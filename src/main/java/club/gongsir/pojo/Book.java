package club.gongsir.pojo;

import java.io.Serializable;

/**
 * @author 龚涛
 * 义诊预约信息
 */
public class Book implements Serializable {
    //主键id
    private Integer id;
    //等同于phone
    private String userId;
    //姓名
    private String name;
    //预约手机号
    private String mobilePhone;
    //义诊需求
    private String demand;
    //电脑品牌
    private String brand;
    //申请时间
    private String signupTime;
    //处理时间
    private String processTime;
    //处理结果
    private String processResult;
    //处理状态颜色：yello/green
    private String statusColor;
    //qq
    private String qq;
    //处理状态
    private String statusText;
    //性别
    private String sex;
    //年级
    private String grade;
    //电脑型号
    private String model;
    //专业
    private String major;
    //故障描述
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(String signupTime) {
        this.signupTime = signupTime;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", demand='" + demand + '\'' +
                ", brand='" + brand + '\'' +
                ", signupTime='" + signupTime + '\'' +
                ", processTime='" + processTime + '\'' +
                ", processResult='" + processResult + '\'' +
                ", statusColor='" + statusColor + '\'' +
                ", qq='" + qq + '\'' +
                ", statusText='" + statusText + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", model='" + model + '\'' +
                ", major='" + major + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}