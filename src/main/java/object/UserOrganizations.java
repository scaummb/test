package object;

import java.sql.Timestamp;

/**
 * @author moubin.mo
 * @date: 2019/11/27 15:32
 */

public class UserOrganizations {
	private Long id;
	private Long userId;
	private Long organizationId;
	private String groupPath;
	private String groupType;
	private Byte status;
	private Integer namespaceId;
	private Timestamp createTime;
	private Byte visibleFlag;
	private Timestamp updateTime;
	private Byte executiveTag;
	private String positionTag;
	private Long operatorUid;
	private String namespaceUserType;

	public String getNamespaceUserType() {
		return namespaceUserType;
	}

	public void setNamespaceUserType(String namespaceUserType) {
		this.namespaceUserType = namespaceUserType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getGroupPath() {
		return groupPath;
	}

	public void setGroupPath(String groupPath) {
		this.groupPath = groupPath;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(Integer namespaceId) {
		this.namespaceId = namespaceId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Byte getVisibleFlag() {
		return visibleFlag;
	}

	public void setVisibleFlag(Byte visibleFlag) {
		this.visibleFlag = visibleFlag;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getExecutiveTag() {
		return executiveTag;
	}

	public void setExecutiveTag(Byte executiveTag) {
		this.executiveTag = executiveTag;
	}

	public String getPositionTag() {
		return positionTag;
	}

	public void setPositionTag(String positionTag) {
		this.positionTag = positionTag;
	}

	public Long getOperatorUid() {
		return operatorUid;
	}

	public void setOperatorUid(Long operatorUid) {
		this.operatorUid = operatorUid;
	}
}
