package net.xiaocun.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiaocunzhang on 16/11/24.
 */
public class Blog implements Serializable{
    private long id;
    private String title;
    private String content;
    private String digest;
    private int globalCategory;
    private int personalCategory;
    private String tags;
    private String relateUrls;
    private String bgPicture;
    private long userId;
    private int status;
    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date    gmtModified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getGlobalCategory() {
        return globalCategory;
    }

    public void setGlobalCategory(int globalCategory) {
        this.globalCategory = globalCategory;
    }

    public int getPersonalCategory() {
        return personalCategory;
    }

    public void setPersonalCategory(int personalCategory) {
        this.personalCategory = personalCategory;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getRelateUrls() {
        return relateUrls;
    }

    public void setRelateUrls(String relateUrls) {
        this.relateUrls = relateUrls;
    }

    public String getBgPicture() {
        return bgPicture;
    }

    public void setBgPicture(String bgPicture) {
        this.bgPicture = bgPicture;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
