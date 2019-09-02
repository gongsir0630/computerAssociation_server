package club.gongsir.pojo;

import java.io.Serializable;

/**
 * @author 龚涛
 */
public class Image implements Serializable {
    private Integer id;

    /**
     * 图片id
     */
    private String imgId;

    /**
     * 图片分类
     */
    private String imgClass;

    /**
     * 图片名称
     */
    private String imgName;

    /**
     * 图片标题，或者alt属性的值
     */
    private String imgTitle;

    /**
     * 描述信息
     */
    private String imgDesc;

    /**
     * 地址，href的值
     */
    private String imgLink;

    /**
     * 是否显示，1显示，2不显示
     */
    private Integer imgShow;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgClass() {
        return imgClass;
    }

    public void setImgClass(String imgClass) {
        this.imgClass = imgClass;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Integer getImgShow() {
        return imgShow;
    }

    public void setImgShow(Integer imgShow) {
        this.imgShow = imgShow;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Image other = (Image) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
            && (this.getImgClass() == null ? other.getImgClass() == null : this.getImgClass().equals(other.getImgClass()))
            && (this.getImgName() == null ? other.getImgName() == null : this.getImgName().equals(other.getImgName()))
            && (this.getImgTitle() == null ? other.getImgTitle() == null : this.getImgTitle().equals(other.getImgTitle()))
            && (this.getImgDesc() == null ? other.getImgDesc() == null : this.getImgDesc().equals(other.getImgDesc()))
            && (this.getImgLink() == null ? other.getImgLink() == null : this.getImgLink().equals(other.getImgLink()))
            && (this.getImgShow() == null ? other.getImgShow() == null : this.getImgShow().equals(other.getImgShow()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getImgClass() == null) ? 0 : getImgClass().hashCode());
        result = prime * result + ((getImgName() == null) ? 0 : getImgName().hashCode());
        result = prime * result + ((getImgTitle() == null) ? 0 : getImgTitle().hashCode());
        result = prime * result + ((getImgDesc() == null) ? 0 : getImgDesc().hashCode());
        result = prime * result + ((getImgLink() == null) ? 0 : getImgLink().hashCode());
        result = prime * result + ((getImgShow() == null) ? 0 : getImgShow().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", imgId=").append(imgId);
        sb.append(", imgClass=").append(imgClass);
        sb.append(", imgName=").append(imgName);
        sb.append(", imgTitle=").append(imgTitle);
        sb.append(", imgDesc=").append(imgDesc);
        sb.append(", imgLink=").append(imgLink);
        sb.append(", imgShow=").append(imgShow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}