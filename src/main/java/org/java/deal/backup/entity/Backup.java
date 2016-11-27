package org.java.deal.backup.entity;

import java.util.Date;

import org.java.base.common.entity.BaseEntity;

public class Backup extends BaseEntity{
    private Integer id;

    private String backupName;

    private String backupType;

    private String backupPath;

    private Date createDate;

    private Integer deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackupName() {
        return backupName;
    }

    public void setBackupName(String backupName) {
        this.backupName = backupName == null ? null : backupName.trim();
    }

    public String getBackupType() {
        return backupType;
    }

    public void setBackupType(String backupType) {
        this.backupType = backupType == null ? null : backupType.trim();
    }

    public String getBackupPath() {
        return backupPath;
    }

    public void setBackupPath(String backupPath) {
        this.backupPath = backupPath == null ? null : backupPath.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	@Override
	public String toString() {
		return "Backup [id=" + id + ", backupName=" + backupName
				+ ", backupType=" + backupType + ", backupPath=" + backupPath
				+ ", createDate=" + createDate + ", deleteFlag=" + deleteFlag
				+ "]";
	}
}