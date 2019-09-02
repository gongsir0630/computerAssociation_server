package club.gongsir.service.impl;

import club.gongsir.dao.BookDao;
import club.gongsir.pojo.Book;
import club.gongsir.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public int insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book selectBookById(int id) {
        return bookDao.selectBookById(id);
    }

    @Override
    public List<Book> selectAllByTel(String phone) {
        return bookDao.selectAllByTel(phone);
    }

    @Override
    public List<Book> getAllBook(Map<String, Object> map) {
        return bookDao.getAllBook(map);
    }

    @Override
    public Integer getAllCount() {
        return bookDao.getAllCount();
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
