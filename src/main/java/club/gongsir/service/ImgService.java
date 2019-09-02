package club.gongsir.service;

import club.gongsir.pojo.Image;

import java.util.List;

/**
 * @author gongsir
 * 计协，永不止步
 */

public interface ImgService {
    /**
     * 上传img
     * @param img img信息
     * @return
     */
    public int insertImg(Image img);

    /**
     * 根据id删除img
     * @param id id唯一
     * @return
     */
    public int deleteImg(int id);

    /**
     * 根据id查询img
     * @param imgId 唯一
     * @return
     */
    public Image selectByImgId(String imgId);

    /**
     * img分类查询
     * @param imgClass 类别
     * @return
     */
    public List<Image> selectAllByImgClass(String imgClass);

    /**
     * 查询某一分类要显示的图片
     * @param imgClass
     * @return
     */
    public List<Image> selectShowImg(String imgClass, int imgShow);

    /**
     * 更新img信息
     * @param img img对象
     * @return
     */
    public int updateImg(Image img);

    /**
     * 更新img的显示状态
     * @param id img的id唯一
     * @param imgShow 显示状态：1/2 显示/不显示
     * @return
     */
    public int updateImgShowById(int id, int imgShow);

    /**
     * 分页查询img信息
     * @return
     */
    public List<Image> getAllImgs(int start, int limit);

    /**
     * 查询总数
     * @return
     */
    public Integer getAllCount();
}
