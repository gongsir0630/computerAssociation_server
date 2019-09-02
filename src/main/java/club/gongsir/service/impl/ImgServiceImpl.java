package club.gongsir.service.impl;

import club.gongsir.dao.ImageDao;
import club.gongsir.pojo.Image;
import club.gongsir.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public int insertImg(Image img) {
        return imageDao.insertImg(img);
    }

    @Override
    public int deleteImg(int id) {
        return imageDao.deleteImg(id);
    }

    @Override
    public Image selectByImgId(String imgId) {
        return imageDao.selectByImgId(imgId);
    }

    @Override
    public List<Image> selectAllByImgClass(String imgClass) {
        return imageDao.selectAllByImgClass(imgClass);
    }

    /**
     *
     * @param imgClass
     * @param imgShow
     * @return
     */
    @Override
    public List<Image> selectShowImg(String imgClass, int imgShow) {
        return imageDao.selectShowImg(imgClass,imgShow);
    }

    @Override
    public int updateImg(Image img) {
        return imageDao.updateImg(img);
    }

    @Override
    public int updateImgShowById(int id, int imgShow) {
        return imageDao.updateImgShowById(id,imgShow);
    }

    @Override
    public List<Image> getAllImgs(int page, int limit) {
        int start = (page-1)*limit;
        return imageDao.getAllImgs(start,limit);
    }

    @Override
    public Integer getAllCount() {
        return imageDao.getAllCouunt();
    }
}
