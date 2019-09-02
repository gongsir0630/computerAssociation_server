package club.gongsir.dao;

import club.gongsir.pojo.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContentDao {
    @Select("select * from pc_content limit #{start},#{limit};")
    public List<Content> getAllCon(@Param("start") int start, @Param("limit") int limit);

    @Select("select count(*) from pc_content;")
    public Integer getAllCount();

    @Insert("insert into pc_content (con_class, img_id, con_labe, con_p, detail_addr) values (#{conClass},#{imgId},#{conLabe},#{conP},#{detailAddr});")
    public int insertContent(Content content);

    @Delete("delete from pc_content where id=#{id};")
    public int deleteConById(int id);

    @Update("update pc_content set con_class=#{conClass},img_id=#{imgId},con_labe=#{conLabe},con_p=#{conP},detail_addr=#{detailAddr} where id=#{id};")
    public int updateConById(Content content);

    @Select("select * from pc_content where id=#{id};")
    public Content selectById(int id);
}
