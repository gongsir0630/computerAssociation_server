package club.gongsir.controller;

import club.gongsir.pojo.Image;
import club.gongsir.service.ImgService;
import club.gongsir.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author gongsir
 * 计协，永不止步
 * 计算机协会官网后台controller，可以管理前端图片
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminImgController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ImgService imgService;

    @ResponseBody
    @GetMapping(path = "/img/all")
    public ResponseData imgAll(int page, int limit){
        List<Image> all = imgService.getAllImgs(page,limit);
        if (!all.isEmpty()){
            ResponseData responseData = ResponseData.ok().putDataValue("status",true).putDataValue("data",all);
            responseData.setCount(imgService.getAllCount());
            return responseData;
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("data",null);
        }
    }

    @ResponseBody
    @PostMapping(path = "/img/add")
    public ResponseData addImg(@RequestParam("file") MultipartFile file,
                               @ModelAttribute Image image,
                               HttpServletRequest request) {
        Assert.notNull(file, "上传文件不能为空");
        //服务器路径
        Image img = imgService.selectByImgId(image.getImgId());
        if (img != null){
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","图片ID已经存在");
        }else {
            String path = request.getServletContext().getRealPath("/static/img");
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            File filepath = new File(path,fileName);
            if (!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdir();
            }
            String src = request.getContextPath()+"/static/img";
            try {
                file.transferTo(new File(path+File.separator+fileName));
            } catch (IOException e) {
                throw new RuntimeException("文件太大");
            }
            image.setImgLink(src+File.separator+fileName);
            image.setImgShow(1);
            image.setImgName(fileName);
            int rs = imgService.insertImg(image);
            if (rs>0){
                return ResponseData.ok().putDataValue("status",true).putDataValue("msg","图片上传成功");
            }else
                return ResponseData.error().putDataValue("status",false).putDataValue("msg","图片上传失败");
        }
    }

    @ResponseBody
    @PostMapping(path = "/img/del")
    public ResponseData delImg(@RequestParam("id") int id,
                               @RequestParam("name") String imgName,
                               HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/static/img/");
        File file = new File(path,imgName);
        if (file.exists()){
            file.delete();
            int rs = imgService.deleteImg(id);
            if (rs>0){
                return ResponseData.ok().putDataValue("status",true).putDataValue("msg","数据删除成功");
            }else {
                return ResponseData.error().putDataValue("status",false).putDataValue("msg","数据删除失败");
            }
        }
        return ResponseData.error().putDataValue("status",false).putDataValue("msg","文件不存在");
    }

    @GetMapping(path = "/img/edit")
    public ModelAndView getEditPage(String imgId){
        ModelAndView mv = new ModelAndView();
        Image image = imgService.selectByImgId(imgId);
        System.out.println(image);
        if (image != null){
            mv.addObject("img",image);
            mv.setViewName("img/edit_img");
        }else {
            mv.setViewName("redirect:img");
        }
        return mv;
    }

    @PostMapping(path = "/img/edit")
    public ModelAndView editImg(Image image){
        System.out.println(image);
        int rs = imgService.updateImg(image);
        return new ModelAndView("redirect:img");
    }
}
