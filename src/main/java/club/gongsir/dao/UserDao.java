package club.gongsir.dao;

import club.gongsir.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 龚涛
 * 计协，永不止步
 */

public interface UserDao {
    @Insert("insert into user_table (name, major, grade, qq, dormitory, phone, college, political, post, memid, stunum, activity_level, assessment_grade, stupwd, login_count) " +
            "values (#{name},#{major},#{grade},#{qq},#{dormitory},#{phone},#{college},#{political},#{post},#{memid},#{stunum},#{activityLevel},#{assessmentGrade},#{stupwd},#{loginCount});")
    int insertUser(User user);

    @Delete("delete from user_table where id=#{id}")
    int deleteUser(Integer id);

    @Select("select * from user_table where stunum=#{stunum};")
    User selectUser(String stunum);

    @Select("select * from user_table;")
    List<User> getAllUser();

    @Select("select count(*) from user_table;")
    int getAllCount();

    @Update("update user_table set " +
            "name=#{name },major=#{major },grade=#{grade },qq=#{qq },dormitory=#{dormitory },phone=#{phone },college=#{college },political=#{political },post=#{post },memid=#{memid },stunum=#{stunum},activity_level=#{activityLevel},assessment_grade=#{assessmentGrade},stupwd=#{stupwd } " +
            "where stunum=#{stunum}")
    int updateAllUserInfo(User user);

    @Update("update user_table set " +
            "name=#{name },major=#{major },grade=#{grade },qq=#{qq },dormitory=#{dormitory },phone=#{phone },college=#{college },political=#{political } " +
            "where stunum=#{stunum}")
    int modifyUserInfo(User user);

    @Update("update user_table set stupwd = #{password} where stunum=#{stuNum};")
    int updatePasswordByStuNum(@Param("stuNum") String stuNum, @Param("password") String password);

    @Update("update user_table set login_count = 1 where stunum=#{stuNum};")
    int updateLoginCount(String stuNum);
}
