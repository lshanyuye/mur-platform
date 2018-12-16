package com.mur.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Domain
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/13 10:56
 **/
public class Domain implements Serializable{
    @TableId
    private String id;

    @TableField("CREATED_BY")
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("MODIFIED_BY")
    private String modifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("MODIFIED_TIME")
    private Date modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @JsonIgnore
    public Boolean isNew(){
        return StringUtils.isBlank(this.id);
    }
}
