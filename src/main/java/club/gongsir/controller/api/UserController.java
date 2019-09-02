package club.gongsir.controller.api;

import club.gongsir.pojo.User;
import club.gongsir.service.UserService;
import club.gongsir.utils.MD5Utils;
import club.gongsir.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gongsir
 * computerAssociation
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 登录请求api
     * @param username 用户名
     * @param password  密码
     * @return 返回json数据
     */
    @PostMapping(path = "/login")
    public ResponseData login(@RequestParam("username") String username, @RequestParam("password") String password){
        ResponseData responseData = ResponseData.ok();
        User user = userService.selectUser(username);
        if (user != null){
            responseData.setCount(1);
            if (MD5Utils.md5(password).equals(user.getStupwd())){
                responseData.putDataValue("isAccess",true).putDataValue("msg","登陆成功").putDataValue("user",user);
                if (user.getLoginCount() == 0){
                    responseData.putDataValue("firstLogin",true);
                    responseData.putDataValue("warning","您是第一次登录，请修改您的登录密码，并补充完善您的个人信息");
                    userService.updateLoginCount(username);
                }else {
                    responseData.putDataValue("firstLogin",false);
                }
            }else {
                responseData.putDataValue("isAccess",false).putDataValue("msg","密码错误");
            }
        }else {
            responseData.putDataValue("isAccess",false).putDataValue("msg","用户名不存在");
        }
        return responseData;
    }

    /**
     * 会员注册api
     * @param user 会员信息
     * @return 注册返回信息
     */
    @PostMapping(path = "/reg")
    public ResponseData register(User user){
        LOGGER.info("user注册信息：{}",user);
        //获取学号
        String stuNum = user.getStunum();
        if (userService.selectUser(stuNum)!=null)
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","学号已存在，请勿重复注册");
        //将学号后六位设置为密码并加密
        user.setStupwd(MD5Utils.md5(stuNum.substring(stuNum.length()-6)));
        //默认会员证编号
        user.setMemid("X08-2019");
        //默认活动等级：校级
        user.setActivityLevel("校级");
        //学期会员考评等级：默认待考评，后台管理员修改数据
        user.setAssessmentGrade("待考评");
        //用于判断是否是第一次登录
        user.setLoginCount(0);
        int rs = userService.insertUser(user);
        if (rs>0){
            return ResponseData.ok().putDataValue("status",true).putDataValue("msg","注册成功");
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","注册失败");
        }
    }

    @PostMapping(path = "/updatePassword")
    public ResponseData updatePassword(@RequestParam("username")String username, @RequestParam("password")String password){
        password = MD5Utils.md5(password);
        int rs = userService.updatePasswordByStuNum(username, password);
        if (rs>0){
            return ResponseData.ok().putDataValue("status",true).putDataValue("msg","密码修改成功,请重新登录");
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","错误");
        }
    }

    @PostMapping(path = "/update")
    public ResponseData updateUser(User user){
        System.out.println("前端传来的user信息："+user);
        int rs = userService.modifyUserInfo(user);
        if (rs>0){
            user = userService.selectUser(user.getStunum());
            return ResponseData.ok().putDataValue("status",true).putDataValue("msg","信息修改成功").putDataValue("user",user);
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","信息修改失败");
        }
    }
}
