package club.gongsir.controller;

import club.gongsir.pojo.Book;
import club.gongsir.service.BookService;
import club.gongsir.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/book")
public class AdminBookController {


    private static Logger logger = LoggerFactory.getLogger(AdminBookController.class);

    @Autowired
    private BookService bookService;


    @GetMapping(path = "/edit")
    public ModelAndView getEditPage(int id){
        Book book = bookService.selectBookById(id);
        ModelAndView mv = new ModelAndView("book/edit_book");
        mv.addObject("book", book);
        return mv;
    }

    @PostMapping(path = "/edit")
    public ModelAndView edit(Book book, HttpServletRequest request){
        logger.info("book信息:{}",book);
        if (book.getStatusText().equals("已处理"))
            book.setStatusColor("green");
        int rs = bookService.updateBook(book);
        if (rs>0){
            request.getSession().setAttribute("msg","数据处理成功");
            return new ModelAndView("redirect:book");
        }else {
            request.getSession().setAttribute("msg","数据处理失败");
            return new ModelAndView("redirect:book");
        }
    }

    @ResponseBody
    @PostMapping(path = "/del")
    public ResponseData del(int id){
        int rs = bookService.deleteBookById(id);
        if (rs>0){
            return ResponseData.ok().putDataValue("status",true).putDataValue("msg","数据删除成功");
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","数据删除失败");
        }
    }


    @ResponseBody
    @GetMapping(path = "/all")
    public ResponseData getAll(int page, int limit){
        Map<String, Object> map = new HashMap<>();
        page = page<0?1:page;
        map.put("start",(page-1)*limit);
        map.put("limit",limit);
        List<Book> all = bookService.getAllBook(map);
        if (!all.isEmpty()){
            ResponseData responseData = ResponseData.ok().putDataValue("status", true).putDataValue("data", all);
            responseData.setCount(bookService.getAllCount());
            return responseData;
        }else {
            return ResponseData.error().putDataValue("status",false);
        }
    }
}
