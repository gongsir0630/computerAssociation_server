package club.gongsir.service.impl;

import club.gongsir.dao.ContentDao;
import club.gongsir.pojo.Content;
import club.gongsir.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> getAllCon(int page, int limit) {
        page = page<0?1:page;
        int start = (page-1)*limit;
        return contentDao.getAllCon(start,limit);
    }

    @Override
    public Integer getAllCount() {
        return contentDao.getAllCount();
    }

    @Override
    public int insertContent(Content content) {
        return contentDao.insertContent(content);
    }

    @Override
    public int deleteConById(int id) {
        return contentDao.deleteConById(id);
    }

    @Override
    public int updateConById(Content content) {
        return contentDao.updateConById(content);
    }

    @Override
    public Content selectById(int id) {
        return contentDao.selectById(id);
    }
}
