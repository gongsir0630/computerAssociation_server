package club.gongsir.service;

import club.gongsir.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    /**
     * 添加预约信息
     * @param book 预约实体
     * @return 返回值为int
     */
    public int insertBook(Book book);

    /**
     * 根据id删除单次预约信息
     * @param id 主键id，唯一
     * @return 返回int值
     */
    public int deleteBookById(int id);

    /**
     * 根据id查询单次预约信息
     * @param id 主键id，唯一
     * @return 返回Book对象
     */
    public Book selectBookById(int id);

    /**
     * 根据手机号查询个人所有预约记录
     * @param phone 手机号
     * @return 返回该手机号的所有预约记录
     */
    public List<Book> selectAllByTel(String phone);

    /**
     * 查询所有预约信息
     * @param map
     * @return
     */
    public List<Book> getAllBook(Map<String,Object> map);

    /**
     * 数量
     * @return
     */
    public Integer getAllCount();

    /**
     * 处理预约
     * @param book
     * @return
     */
    public int updateBook(Book book);
}
