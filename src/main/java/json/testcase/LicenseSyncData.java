package json.testcase;


import java.sql.Timestamp;

/**
 * <ul>
 * <li>id: id</li>
 * <li>namespaceId: 域空间ID</li>
 * <li>customerId: 企业客户ID</li>
 * <li>targetId: 许可范围ID</li>
 * <li>targetType: 许可范围类型，1: 域空间, 2: 项目, 3:应用 </li>
 * <li>status: 状态：0: 失效,  1: 试用，2: 生效, 3:过期 </li>
 * <li>licenseNo: 许可编号</li>
 * <li>licenseStartDate: 许可证开始时间</li>
 * <li>licenseEndDate: 许可证结束时间</li>
 * <li>creatorUid: creatorUid</li>
 * <li>createTime: createTime</li>
 * <li>operatorUid: operatorUid</li>
 * <li>updateTime: updateTime</li>
 * </ul>
 */
public class LicenseSyncData {
	private Long id;
	private Integer namespaceId;
	private Long customerId;
	private Long targetId;
	private Byte targetType;
	private Byte status;
	private String licenseNo;
	private Timestamp licenseStartDate;
	private Timestamp licenseEndDate;
	private Long creatorUid;
	private Timestamp createTime;
	private Long operatorUid;
	private Timestamp updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(Integer namespaceId) {
		this.namespaceId = namespaceId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Byte getTargetType() {
		return targetType;
	}

	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Timestamp getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Timestamp licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public Timestamp getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Timestamp licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public Long getCreatorUid() {
		return creatorUid;
	}

	public void setCreatorUid(Long creatorUid) {
		this.creatorUid = creatorUid;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getOperatorUid() {
		return operatorUid;
	}

	public void setOperatorUid(Long operatorUid) {
		this.operatorUid = operatorUid;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
