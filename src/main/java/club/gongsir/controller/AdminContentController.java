package club.gongsir.controller;

import club.gongsir.pojo.Content;
import club.gongsir.pojo.Image;
import club.gongsir.service.ContentService;
import club.gongsir.service.ImgService;
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
import java.util.List;

@Controller
@RequestMapping("/admin/content")
public class AdminContentController {
    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ImgService imgService;
    @Autowired
    private ContentService contentService;

    @ResponseBody
    @PostMapping(path = "/del")
    public ResponseData del(int id){
        int rs = contentService.deleteConById(id);
        if (rs>0)
            return ResponseData.ok().putDataValue("status",true).putDataValue("msg","数据删除成功");
        else
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","数据删除失败");
    }

    @GetMapping(path = "/edit")
    public ModelAndView getEditPage(int id){
        ModelAndView mv = new ModelAndView();
        Content content = contentService.selectById(id);
        if (content != null){
            mv.setViewName("content/edit_content");
            mv.addObject("con",content);
        }else {
            mv.setViewName("redirect:content");
        }
        return mv;
    }

    @PostMapping(path = "/edit")
    public ModelAndView editContent(Content content) {
        if (content == null)
            return new ModelAndView("content/content").addObject("msg","前端信息不能为空");
        else {
            System.out.println("前段content信息："+content);
            int rs = contentService.updateConById(content);
            if (rs>0)
                return new ModelAndView("redirect:content").addObject("msg","数据添加成功");
            else
                return new ModelAndView("redirect:content").addObject("msg","数据添加失败");
        }
    }

    @PostMapping(path = "/add")
    public ModelAndView addContent(Content content, HttpServletRequest request){
        if (content == null)
            return new ModelAndView("content/content").addObject("msg","前端信息不能为空");
        else {
            System.out.println("前段content信息："+content);
            Image image = imgService.selectByImgId(content.getImgId());
            if (image == null){
                request.getSession().setAttribute("msg","图片ID不存在");
                return new ModelAndView("redirect:add_content");
            }
            int rs = contentService.insertContent(content);
            if (rs>0){
                return new ModelAndView("redirect:content").addObject("msg","数据添加成功");
            }else
                return new ModelAndView("redirect:content").addObject("msg","数据添加失败");
        }
    }

    @ResponseBody
    @GetMapping(path = "/all")
    public ResponseData getAll(int page, int limit){
        List<Content> all = contentService.getAllCon(page,limit);
        if (!all.isEmpty()){
            for (Content con:all){
                con.setImage(imgService.selectByImgId(con.getImgId()));
            }
            ResponseData responseData = ResponseData.ok().putDataValue("status",true).putDataValue("data",all);
            responseData.setCount(contentService.getAllCount());
            return responseData;
        }else
            return ResponseData.error().putDataValue("status",false).putDataValue("data",null);
    }
}
