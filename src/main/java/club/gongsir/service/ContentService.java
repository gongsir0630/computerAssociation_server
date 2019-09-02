package club.gongsir.service;

import club.gongsir.pojo.Content;

import java.util.List;

public interface ContentService {
    public List<Content> getAllCon(int page, int limit);

    public Integer getAllCount();

    public int insertContent(Content content);

    public int deleteConById(int id);

    public int updateConById(Content content);

    public Content selectById(int id);

}
