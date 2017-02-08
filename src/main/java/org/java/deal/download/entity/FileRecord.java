package org.java.deal.download.entity;

import java.util.Date;

public class FileRecord {
    private Integer id;

    private String fileName;

    private Date createDate;

    private Date updateDate;

    private Integer createUserId;

    private Integer updateUserId;

    private String fileAllUrl;

    private String fileDir;

    private Integer deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getFileAllUrl() {
        return fileAllUrl;
    }

    public void setFileAllUrl(String fileAllUrl) {
        this.fileAllUrl = fileAllUrl == null ? null : fileAllUrl.trim();
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir == null ? null : fileDir.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "FileRecord{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createUserId=" + createUserId +
                ", updateUserId=" + updateUserId +
                ", fileAllUrl='" + fileAllUrl + '\'' +
                ", fileDir='" + fileDir + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}