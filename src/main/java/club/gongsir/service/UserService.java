package club.gongsir.service;

import club.gongsir.pojo.User;

import java.util.List;

public interface UserService {
    public int insertUser(User user);
    public int deleteUser(int id);
    public User selectUser(String stunum);
    public List<User> getAllUser();
    public int getAllCount();
    public int updateAllUserInfo(User user);
    int modifyUserInfo(User user);
    int updatePasswordByStuNum(String stuNum, String password);
    int updateLoginCount(String stuNum);
}
