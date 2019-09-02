package club.gongsir.pojo;

import java.io.Serializable;

/**
 * @author 龚涛
 * 会员信息
 */
public class User implements Serializable {
    //主键id
    private Integer id;
    //姓名
    private String name;
    //专业
    private String major;
    //年级
    private String grade;
    //QQ号码
    private String qq;
    //宿舍
    private String dormitory;
    //电话
    private String phone;
    //学院
    private String college;
    //政治面貌
    private String political;
    //职务
    private String post;
    //会员证编号
    private String memid;
    //学号
    private String stunum;
    //活动等级
    private String activityLevel;
    //考核等级
    private String assessmentGrade;
    //登录密码
    private String stupwd;
    //登录次数
    private Integer loginCount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMemid() {
        return memid;
    }

    public void setMemid(String memid) {
        this.memid = memid;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getAssessmentGrade() {
        return assessmentGrade;
    }

    public void setAssessmentGrade(String assessmentGrade) {
        this.assessmentGrade = assessmentGrade;
    }

    public String getStupwd() {
        return stupwd;
    }

    public void setStupwd(String stupwd) {
        this.stupwd = stupwd;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", qq='" + qq + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", phone='" + phone + '\'' +
                ", college='" + college + '\'' +
                ", political='" + political + '\'' +
                ", post='" + post + '\'' +
                ", memid='" + memid + '\'' +
                ", stunum='" + stunum + '\'' +
                ", activityLevel='" + activityLevel + '\'' +
                ", assessmentGrade='" + assessmentGrade + '\'' +
                ", stupwd='" + stupwd + '\'' +
                ", loginCount=" + loginCount +
                '}';
    }
}