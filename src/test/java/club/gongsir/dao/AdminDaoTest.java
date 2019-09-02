package club.gongsir.dao;

import club.gongsir.pojo.Admin;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("ALL")
public class AdminDaoTest extends DaoTest {

    //声明日志管理，日志记录
    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(AdminDaoTest.class);

    //注入
    @Autowired
    private AdminDao adminDao;

    @Test
    public void getSearchAdminTest(){
        String count = "admin";
        int start = 0;
        int limit = 10;
        List<Admin> list = adminDao.getSearchAdmin(count,start,limit);
        for (Admin admin:list){
            System.out.println(admin);
        }
    }

    @Test
    public void getSearchCountTest(){
        System.out.println(adminDao.getSearchCount("admin"));
    }
}