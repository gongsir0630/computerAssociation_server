package club.gongsir.controller.api;
import club.gongsir.pojo.Book;
import club.gongsir.service.BookService;
import club.gongsir.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author gongsir
 * 义诊预约相关api
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/book")
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * 添加预约信息
     * @param book 预约信息对象，前端获取
     * @return 返回json数据
     */
    @PostMapping(path = "/add")
    public ResponseData add(Book book){
        //将userId设置为等于phone的数据
        book.setUserId(book.getMobilePhone());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        book.setSignupTime(simpleDateFormat.format(date));
        book.setProcessResult("未处理");
        book.setStatusColor("yellow");
        book.setStatusText("未处理");
        LOGGER.info("book信息：{}",book);
        int rs = bookService.insertBook(book);
        if (rs>0){
            ResponseData responseData = ResponseData.ok().putDataValue("book",book);
            responseData.putDataValue("status",true).putDataValue("msg","预约信息提交成功");
            responseData.setCount(1);
            return responseData;
        }else {
            return ResponseData.ok().putDataValue("msg","预约信息添加失败").putDataValue("status",false);
        }
    }

    /**
     * 根据id删除预约信息
     * @param id 预约信息的id，唯一
     * @return 返回操作结果的json数据
     */
    @DeleteMapping(path = "/del")
    public ResponseData delete(@RequestParam("id")int id){
        int rs = bookService.deleteBookById(id);
        if (rs>0){
            return ResponseData.ok().putDataValue("msg","数据删除成功").putDataValue("status",true);
        }
        return ResponseData.ok().putDataValue("msg","操作失败").putDataValue("status",false);
    }

    /**
     * 根据手机号查询所有的预约信息
     * @param phone 用户手机号
     * @return  返回list集合数据
     */
    @GetMapping(path = "/list")
    public ResponseData list(@RequestParam("phone")String phone){
        List<Book> list;
        list = bookService.selectAllByTel(phone);
        if (!list.isEmpty()){
            ResponseData responseData =  ResponseData.ok().putDataValue("list",list);
            responseData.putDataValue("status",true);
            responseData.setCount(list.size());
            return responseData;
        }
        return ResponseData.error().putDataValue("msg","未查到相关数据").putDataValue("status",false);
    }

    /**
     * 根据id查询单次预约信息
     * @param id 预约id
     * @return 返回book对象
     */
    @GetMapping(path = "/query")
    public ResponseData query(@RequestParam("id")int id){
        Book book = bookService.selectBookById(id);
        if (book!=null){
            return ResponseData.ok().putDataValue("book",book).putDataValue("status",true);
        }else {
            return ResponseData.error().putDataValue("msg","未查到数据").putDataValue("status",false);
        }
    }
}
