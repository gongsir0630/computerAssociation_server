package club.gongsir.controller;

import club.gongsir.pojo.Admin;
import club.gongsir.pojo.User;
import club.gongsir.service.AdminService;
import club.gongsir.service.UserService;
import club.gongsir.utils.MD5Utils;
import club.gongsir.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author gongsir
 * 计协，永不止步
 */

@CrossOrigin    //允许跨域请求
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    /**
     * 自动页面跳转
     */
    @GetMapping(path = "/{dir}/{pageName}")
    public String getPage(@PathVariable("dir") String dir, @PathVariable("pageName")String pageName){
        return dir+"/"+pageName;
    }

    /**
     * admin：后台管理员操作
     * @param admin
     * @param request
     * @param response
     * @return
     */

    /**
     * 管理员登录
     * @param admin
     * @param request
     * @param response
     * @return
     */
    @PostMapping(path = "/login")
    public ModelAndView login(Admin admin, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        logger.info("admin信息：用户名：{}",admin.getCount()+"密码："+admin.getPassword());
        Admin user = adminService.selectByCount(admin.getCount());
        if (user!=null){
            System.out.println(MD5Utils.md5(admin.getPassword().trim()));
            if ((MD5Utils.md5(admin.getPassword())).equals(user.getPassword())){
                session.setAttribute("admin",user);
                mv.setViewName("index");
                mv.addObject("msg","登陆成功");
            }else{
                mv.setViewName("login");
                mv.addObject("msg","密码错误");
            }
        }else{
            mv.setViewName("login");
            mv.addObject("msg","用户名错误");
        }
        return mv;
    }

    /**
     * 管理员退出登录
     * @param request
     * @return
     */
    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "login";
    }


    /**
     * getAll
     */
    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseData adminAll(int page, int limit){
        List<Admin> all = adminService.getAllAdmin(page,limit);
        if (!all.isEmpty()){
            ResponseData responseData = ResponseData.ok().putDataValue("status",true).putDataValue("data",all);
            responseData.setCount(adminService.getAllCount());
            return responseData;
        }else {
            return ResponseData.ok().putDataValue("status",false).putDataValue("data",null);
        }
    }

    /**
     * 查询管理员信息
     * @return
     */
    @GetMapping(path = "/search")
    @ResponseBody
    public ResponseData search(int page, int limit,String count){
        if (count.equals(""))
            count=null;
        System.out.println(count);
        List<Admin> all = adminService.getSearchAdmin(count,page,limit);
        if (!all.isEmpty()){
            ResponseData responseData = ResponseData.ok().putDataValue("status",true).putDataValue("data",all);
            responseData.setCount(adminService.getSearchCount(count));
            return responseData;
        }else {
            return ResponseData.ok().putDataValue("status",false).putDataValue("data",null);
        }
    }

    /**
     * 根据id删除管理员信息
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/delAdmin")
    public ResponseData delAdmin(@RequestParam("id")String id){
        System.out.println(id);
        if (id != null && !id.equals("")){
            int rs = adminService.deleteAdminById(Integer.valueOf(id));
            if (rs>0){
                return ResponseData.ok().putDataValue("status",true).putDataValue("msg","用户删除成功");
            }else {
                return ResponseData.error().putDataValue("status",false).putDataValue("msg","用户删除失败");
            }
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","id为空");
        }
    }

    @PostMapping(path = "/add")
    public ModelAndView addAdmin(String count,String password,String order){
        if (count==null|| password==null || order==null){
            return new ModelAndView("user/admin").addObject("msg","前端信息不能为空");
        }else {
            Admin admin = new Admin();
            admin.setCount(count);
            admin.setPassword(MD5Utils.md5(password));
            int rs = adminService.insertAdmin(admin);
            if (rs>0){
                return new ModelAndView("redirect:user/admin").addObject("msg","数据添加成功");
            }else
                return new ModelAndView("redirect:user/admin").addObject("msg","数据添加失败");
        }
    }

    @GetMapping(path = "/edit")
    public ModelAndView getAdminEditPage(@RequestParam("count") String count){
        ModelAndView mv = new ModelAndView();
        Admin admin = adminService.selectByCount(count);
        System.out.println(admin);
        if (admin!=null){
            mv.clear();
            mv.setViewName("user/edit_admin");
            mv.addObject("adm",admin);
        }else {
            mv.setViewName("redirect:user/admin");
        }
        return mv;
    }

    @PostMapping(path = "/edit")
    public ModelAndView editAdmin(String count,String password){
        Admin admin = new Admin();
        admin.setCount(count);
        admin.setPassword(MD5Utils.md5(password));
        System.out.println("修改之后的admin信息："+admin);
        int rs = adminService.updateAdminPassword(admin);
        if (rs>0){
            return new ModelAndView("redirect:user/admin");
        }
        return new ModelAndView("redirect:user/admin");
    }

    /**
     * user:后台对会员信息的操作
     * @return
     */

    @ResponseBody
    @GetMapping(path = "/user/all")
    public ResponseData userAll(){
        ResponseData responseData = ResponseData.ok();
        List<User> all = userService.getAllUser();
        if (!all.isEmpty()){
            responseData.setCount(all.size());
            responseData.putDataValue("data",all);
        }else {
            responseData.putDataValue("data",null);
        }
        return responseData;
    }

    @ResponseBody
    @PostMapping(path = "/user/delUser")
    public ResponseData delUser(@RequestParam("id")String id){
        System.out.println(id);
        if (id != null && !id.equals("")){
            int rs = userService.deleteUser(Integer.valueOf(id));
            if (rs>0){
                return ResponseData.ok().putDataValue("status",true).putDataValue("msg","用户删除成功");
            }else {
                return ResponseData.error().putDataValue("status",false).putDataValue("msg","用户删除失败");
            }
        }else {
            return ResponseData.error().putDataValue("status",false).putDataValue("msg","id为空");
        }
    }

    @PostMapping(path = "/user/add")
    public ModelAndView addUser(User user, HttpServletRequest request){
        logger.info("预添加user的信息：{}",user);
        ModelAndView mv = new ModelAndView();
        //获取学号
        String stuNum = user.getStunum();
        if (userService.selectUser(stuNum)!=null){
            mv.setViewName("user/add_user");
            request.getSession().setAttribute("msg","学号已经存在");
            return mv;
        }
        //将学号后六位设置为密码并加密
        user.setStupwd(MD5Utils.md5(stuNum.substring(stuNum.length()-6)));
        //用于判断是否是第一次登录
        user.setLoginCount(0);
        int rs = userService.insertUser(user);
        if (rs>0){
            mv.setViewName("redirect:member");
            request.getSession().setAttribute("msg","学生:"+stuNum+"添加成功");
        }else {
            mv.setViewName("user/add_user");
            request.getSession().setAttribute("msg","学生:"+stuNum+"添加失败");
        }
        return mv;
    }

    @GetMapping(path = "/user/edit")
    public ModelAndView getUserEditPage(String stunum){
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUser(stunum);
        if (user!=null){
            mv.setViewName("user/edit_user");
            mv.addObject("user",user);
        }else {
            mv.setViewName("redirect:member");
        }
        return mv;
    }

    @PostMapping(path = "/user/edit")
    public ModelAndView editUser(User user, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        user.setStupwd(MD5Utils.md5(user.getStupwd()));
        System.out.println(user);
        int rs = userService.updateAllUserInfo(user);
        if (rs>0){
            mv.setViewName("redirect:member");
            request.getSession().setAttribute("msg","数据更新成功");
        }else {
            mv.setViewName("user/edit_user");
            request.getSession().setAttribute("msg","数据更新失败");
        }
        return mv;
    }
}
