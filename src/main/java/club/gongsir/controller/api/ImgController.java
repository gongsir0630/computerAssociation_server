package club.gongsir.controller.api;

import club.gongsir.pojo.Image;
import club.gongsir.service.ImgService;
import club.gongsir.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gongsir
 * 计协，永不止步
 */

@CrossOrigin //允许跨域请求
@RestController
@RequestMapping(value = "/api/img")
public class ImgController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImgController.class);

    @Autowired
    private ImgService imgService;

    @PostMapping(path = "/show")
    public ResponseData showImg(@RequestParam("imgClass")String imgClass){
        List<Image> show = imgService.selectShowImg(imgClass,1);
        ResponseData responseData = ResponseData.ok();
        responseData.setCount(show.size());
        if (!show.isEmpty()){
            responseData.putDataValue("data",show).putDataValue("status",true).putDataValue("msg","数据加载成功");
        }else {
            responseData.putDataValue("status",false).putDataValue("msg","未查到数据");
        }
        return responseData;
    }

    @PostMapping(path = "/get")
    public ResponseData getImg(@RequestParam("imgId")String imgId){
        Image image = imgService.selectByImgId(imgId);
        ResponseData responseData = ResponseData.ok();
        if (image != null){
            responseData.putDataValue("img",image).putDataValue("status",true).putDataValue("msg","数据加载成功");
            responseData.setCount(1);
        }else {
            responseData.putDataValue("msg","未查到数据").putDataValue("status",false);
        }
        return responseData;
    }
}
