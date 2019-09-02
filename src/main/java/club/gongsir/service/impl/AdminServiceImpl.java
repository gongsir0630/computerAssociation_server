package club.gongsir.service.impl;

import club.gongsir.dao.AdminDao;
import club.gongsir.pojo.Admin;
import club.gongsir.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin selectByCount(String count) {
        return adminDao.selectByCount(count);
    }

    @Override
    public int updateAdminPassword(Admin admin) {
        return adminDao.updateAdminPassword(admin);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }

    @Override
    public Integer getSearchCount(String count) {
        return adminDao.getSearchCount(count);
    }

    @Override
    public List<Admin> getAllAdmin(int page, int limit) {
        page = page<1?1:page;
        int start = (page-1)*limit;
        return adminDao.getAllAdmin(start,limit);
    }

    @Override
    public Integer getAllCount() {
        return adminDao.getAllCount();
    }

    @Override
    public List<Admin> getSearchAdmin(String count, int page, int limit) {
        page = page<1?1:page;
        int start = (page-1)*limit;
        return adminDao.getSearchAdmin(count,start,limit);
    }

    @Override
    public int deleteAdminById(Integer id) {
        return adminDao.deleteAdminById(id);
    }
}
