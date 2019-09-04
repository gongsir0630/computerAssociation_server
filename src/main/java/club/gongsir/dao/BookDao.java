package club.gongsir.dao;

import club.gongsir.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BookDao {
    @Insert("insert into reservation_information_table (user_id, name, mobile_phone, demand, brand, description, signup_time, process_time, process_result, status_color, qq, status_text, sex, grade, model, major) " +
            "values (#{userId},#{name},#{mobilePhone},#{demand},#{brand},#{description},#{signupTime},#{processTime},#{processResult},#{statusColor},#{qq},#{statusText},#{sex},#{grade},#{model},#{major})")
    public int insertBook(Book book);

    @Delete("delete from reservation_information_table where id=#{id}")
    public int deleteBookById(int id);

    @Select("select * from reservation_information_table where id=#{id}")
    public Book selectBookById(int id);

    @Select("select * from reservation_information_table where mobile_phone=#{phone}")
    public List<Book> selectAllByTel(String phone);

    @Select("select * from reservation_information_table limit #{start},#{limit};")
    public List<Book> getAllBook(Map<String,Object> map);

    @Select("select count(*) from reservation_information_table;")
    public Integer getAllCount();

    @Update("update reservation_information_table set process_time=#{processTime},process_result=#{processResult},status_text=#{statusText},status_color=#{statusColor} where id=#{id};")
    public int updateBook(Book book);
}
