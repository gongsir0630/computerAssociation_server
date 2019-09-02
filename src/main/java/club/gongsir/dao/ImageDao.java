package club.gongsir.dao;

import club.gongsir.pojo.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ImageDao {
    @Insert("insert into pc_imgs (img_id, img_class, img_name, img_title, img_desc, img_link, img_show) " +
            "values (#{imgId},#{imgClass},#{imgName},#{imgTitle},#{imgDesc},#{imgLink},#{imgShow});")
    public int insertImg(Image img);

    @Delete("delete from pc_imgs where id=#{id}")
    public int deleteImg(int id);

    @Select("select id,img_id,img_class,img_name,img_title,img_desc,img_link,img_show from pc_imgs where img_id=#{imgId};")
    public Image selectByImgId(String imgId);

    @Select("select id,img_id,img_class,img_name,img_title,img_desc,img_link,img_show from pc_imgs where img_class=#{imgClass};")
    public List<Image> selectAllByImgClass(String imgClass);

    @Select("select id, img_id, img_class, img_name, img_title, img_desc, img_link, img_show from pc_imgs where img_class=#{imgClass} and img_show=#{imgShow}")
    public List<Image> selectShowImg(@Param("imgClass") String imgClass, @Param("imgShow") int imgShow);

    @Update("update pc_imgs set img_class=#{imgClass},img_title=#{imgTitle},img_desc=#{imgDesc},img_link=#{imgLink},img_show=#{imgShow} where id=#{id}")
    public int updateImg(Image img);

    @Update("update pc_imgs set img_show=#{imgShow} where id=#{id}")
    public int updateImgShowById(@Param("id")int id,@Param("imgShow")int imgShow);

    @Select("select * from pc_imgs limit #{start},#{limit}")
    public List<Image> getAllImgs(@Param("start") int start, @Param("limit") int limit);

    @Select("select count(*) from pc_imgs;")
    public Integer getAllCouunt();

}
