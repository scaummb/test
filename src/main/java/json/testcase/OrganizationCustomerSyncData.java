package json.testcase;

import java.util.List;

/**
 * <ul>
 * <li>id: id</li>
 * <li>namespaceId: 域空间id</li>
 * <li>name: 企业名称</li>
 * <li>contactName: 企业管理员名称</li>
 * <li>contactToken: 企业管理员手机号</li>
 * <li>licenseStartDate: 有效期开始时间</li>
 * <li>licenseEndDate: 有效期结束时间</li>
 * <li>status: 企业客户状态</li>
 * <li>licenses: 许可证列表</li>
 * </ul>
 */
public class OrganizationCustomerSyncData {
	private Long id;
	private Integer namespaceId;
	private String name;
	private String contactName;
	private String contactToken;
	private Long licenseStartDate;
	private Long licenseEndDate;
	private Byte status;
	private List<LicenseSyncData> licenses;

	public OrganizationCustomerSyncData() {
	}

	public OrganizationCustomerSyncData(Long id, Integer namespaceId, Byte status) {
		this.id = id;
		this.namespaceId = namespaceId;
		this.status = status;
	}

	public List<LicenseSyncData> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<LicenseSyncData> licenses) {
		this.licenses = licenses;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactToken() {
		return contactToken;
	}

	public void setContactToken(String contactToken) {
		this.contactToken = contactToken;
	}

	public Long getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Long licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public Long getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Long licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
}
