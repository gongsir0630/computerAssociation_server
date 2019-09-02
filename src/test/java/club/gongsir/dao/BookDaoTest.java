package club.gongsir.dao;

import club.gongsir.pojo.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class BookDaoTest extends DaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("start",0);
        map.put("limit",10);
        List<Book> all = bookDao.getAllBook(map);
        for (Book book:all){
            System.out.println(book);
        }
    }
}