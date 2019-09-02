package club.gongsir.pojo;

import java.io.Serializable;

/**
 * @author 龚涛
 */
public class Content implements Serializable {
    /**
     * 模块id
     */
    private Integer id;

    /**
     * 模块类别，分indx，active，server
     */
    private String conClass;

    /**
     * 对应的图片id
     */
    private String imgId;

    /**
     *  对应的图片信息
     */
    private Image image;

    /**
     * html中lable标签的内容
     */
    private String conLabe;

    /**
     * html中p标签的内容
     */
    private String conP;

    /**
     * 详情链接
     */
    private String detailAddr;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConClass() {
        return conClass;
    }

    public void setConClass(String conClass) {
        this.conClass = conClass;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getConLabe() {
        return conLabe;
    }

    public void setConLabe(String conLabe) {
        this.conLabe = conLabe;
    }

    public String getConP() {
        return conP;
    }

    public void setConP(String conP) {
        this.conP = conP;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
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
        Content other = (Content) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getConClass() == null ? other.getConClass() == null : this.getConClass().equals(other.getConClass()))
            && (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
            && (this.getConLabe() == null ? other.getConLabe() == null : this.getConLabe().equals(other.getConLabe()))
            && (this.getConP() == null ? other.getConP() == null : this.getConP().equals(other.getConP()))
            && (this.getDetailAddr() == null ? other.getDetailAddr() == null : this.getDetailAddr().equals(other.getDetailAddr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getConClass() == null) ? 0 : getConClass().hashCode());
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getConLabe() == null) ? 0 : getConLabe().hashCode());
        result = prime * result + ((getConP() == null) ? 0 : getConP().hashCode());
        result = prime * result + ((getDetailAddr() == null) ? 0 : getDetailAddr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", conId=").append(id);
        sb.append(", conClass=").append(conClass);
        sb.append(", imgId=").append(imgId);
        sb.append(", conLabe=").append(conLabe);
        sb.append(", conP=").append(conP);
        sb.append(", detailAddr=").append(detailAddr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}