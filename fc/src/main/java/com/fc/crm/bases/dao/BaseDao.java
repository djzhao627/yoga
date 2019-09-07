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
    private Long createAuthor;
    private String lastModifyTime;
    private Long lastModifyAuthor;

    public BaseDao() {
    }

    public BaseDao(String createTime, Long createAuthor, String lastModifyTime, Long lastModifyAuthor) {
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

    public Long getCreateAuthor() {
        return createAuthor;
    }

    public void setCreateAuthor(Long createAuthor) {
        this.createAuthor = createAuthor;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getLastModifyAuthor() {
        return lastModifyAuthor;
    }

    public void setLastModifyAuthor(Long lastModifyAuthor) {
        this.lastModifyAuthor = lastModifyAuthor;
    }
}
