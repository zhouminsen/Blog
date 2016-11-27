package org.java.deal.permission.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.java.base.common.entity.BaseEntity;

public class Role extends BaseEntity {
    private Integer roleId;

    private String roleName;

    private String menuIds;

    private String operationIds;

    private String description;

    

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds == null ? null : menuIds.trim();
    }

    public String getOperationIds() {
        return operationIds;
    }

    public void setOperationIds(String operationIds) {
        this.operationIds = operationIds == null ? null : operationIds.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", menuIds=" + menuIds + ", operationIds=" + operationIds
				+ ", description=" + description + ", getCreateDate()="
				+ getCreateDate() + ", getDeleteFlag()=" + getDeleteFlag()
				+ "]";
	}
    

}