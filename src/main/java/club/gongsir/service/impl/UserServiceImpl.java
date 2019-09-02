package club.gongsir.service.impl;

import club.gongsir.dao.UserDao;
import club.gongsir.pojo.User;
import club.gongsir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gongsir
 * computerAssociation
 */
@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User selectUser(String stunum) {
        return userDao.selectUser(stunum);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public int getAllCount() {
        return userDao.getAllCount();
    }

    @Override
    public int updateAllUserInfo(User user) {
        return userDao.updateAllUserInfo(user);
    }

    @Override
    public int modifyUserInfo(User user) {
        return userDao.modifyUserInfo(user);
    }

    @Override
    public int updatePasswordByStuNum(String stuNum, String password) {
        return userDao.updatePasswordByStuNum(stuNum, password);
    }

    @Override
    public int updateLoginCount(String stuNum) {
        return userDao.updateLoginCount(stuNum);
    }
}
