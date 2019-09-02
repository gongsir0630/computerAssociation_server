package club.gongsir.dao;

import club.gongsir.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminDao {
    @Select("select * from admin_table where count=#{count}")
    public Admin selectByCount(String count);

    @Select("<script>select * from admin_table " +
            "<where><if test='count != null'>and count like concat('%',#{count},'%')" +
            "</if></where>limit #{start},#{limit}</script>")
    public List<Admin> getSearchAdmin(@Param("count") String count,@Param("start") int start, @Param("limit") int limit);

    @Select("<script>select count(*) from admin_table " +
            "<where><if test='count != null'>and count like concat('%',#{count},'%')" +
            "</if></where></script>")
    public Integer getSearchCount(@Param("count") String count);

    @Select("select * from admin_table limit #{start},#{limit}")
    public List<Admin> getAllAdmin(@Param("start") int start, @Param("limit") int limit);

    @Select("select count(*) from admin_table")
    public Integer getAllCount();

    @Delete("delete from admin_table where id=#{id};")
    public int deleteAdminById(Integer id);

    @Update("update admin_table set password=#{password} where count=#{count}")
    public int updateAdminPassword(Admin admin);

    @Insert("insert into admin_table (count,password) values (#{count},#{password})")
    public int insertAdmin(Admin admin);
}
