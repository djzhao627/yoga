package com.fc.crm.bases.dao;

import javax.xml.crypto.Data;

/**
 * 基本的dao字段
 * 创建人
 * 创建时间
 * 最后修改人
 * 最后修改时间
 */
public class BaseDao {

    private String createTime;
    private String createAuthor;
    private String lastModifyTime;
    private String lastModifyAuthor;

    public BaseDao() {
    }

    public BaseDao(String createTime, String createAuthor, String lastModifyTime, String lastModifyAuthor) {
        this.createTime = createTime;
        this.createAuthor = createAuthor;
        this.lastModifyTime = lastModifyTime;
        this.lastModifyAuthor = lastModifyAuthor;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateAuthor() {
        return createAuthor;
    }

    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyAuthor() {
        return lastModifyAuthor;
    }

    public void setLastModifyAuthor(String lastModifyAuthor) {
        this.lastModifyAuthor = lastModifyAuthor;
    }
}
