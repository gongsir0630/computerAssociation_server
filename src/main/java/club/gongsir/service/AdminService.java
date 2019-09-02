package club.gongsir.service;

import club.gongsir.pojo.Admin;

import java.util.List;

/**
 * @author gongsir
 */

public interface AdminService {
    /**
     * 根据账号查找管理员信息
     * @param count 管理员账号
     * @return 返回Admin对象
     */
    public Admin selectByCount(String count);

    /**
     * 修改密码
     * @param admin
     * @return
     */
    public int updateAdminPassword(Admin admin);

    /**
     * 增加管理员
     * @param admin
     * @return
     */
    public int insertAdmin(Admin admin);

    /**
     * 获取管理员信息列表
     * @return
     */
    public List<Admin> getAllAdmin(int page, int limit);
    public Integer getAllCount();

    /**
     * 搜索
     * @param count
     * @param page
     * @param limit
     * @return
     */
    public List<Admin> getSearchAdmin(String count,int page, int limit);
    public Integer getSearchCount(String count);

    /**
     * 删除管理员
     * @param id
     * @return
     */
    public int deleteAdminById(Integer id);
}
