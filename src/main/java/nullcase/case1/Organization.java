// @formatter:off
package nullcase.case1;


import java.sql.Timestamp;
import java.util.List;

/**
 * <ul>
 *  *     <li>memberCount: 人员规模</li>
 *         <li>memberStatus: 人员的状态，通过姓名精确或者模糊查询时，需要把离职的员工信息也查出来</li>
 *         <li>operatorFlag: 运营商标签</li>
 *  * </ul>
 */
public class Organization {
	private static final long serialVersionUID = 8428338216022084922L;
    private Long id;
    private Long parentId;
    private String organizationType;
    private String name;
    private Long addressId;
    private String description;
    private String path;
    private Integer level;
    private Byte status;
    private String departmentType;
    private String groupType;
    private String orgNo;
    private Long superiorDetailId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Long directlyEnterpriseId;
    private Integer namespaceId;
    private Long groupId;
    private Long integralTag1;
    private Long integralTag2;
    private Long integralTag3;
    private Long integralTag4;
    private Long integralTag5;
    private String stringTag1;
    private String stringTag2;
    private String stringTag3;
    private String stringTag4;
    private String stringTag5;
    private Byte showFlag;
    private String namespaceOrganizationToken;
    private String namespaceOrganizationType;
    private Integer size;
    private Long creatorUid;
    private Long operatorUid;
    private Byte setAdminFlag;
    private String emailContent;
    private String website;
    private String unifiedSocialCreditCode;
    private Integer order;
    private Long adminTargetId;
    private String adminContactToken;
    private Byte workPlatformFlag;
    private Byte pmFlag;
    private Byte serviceSupportFlag;
    private Byte platformFlag;
    private Long opcOrganizationCustomerId;
    private String opcOrganizationCustomerName;
    private Timestamp expireStartDate;
    private Timestamp expireEndDate;
    private Byte appSelfConfigFlag;
    private Byte pcWorkPlatformFlag;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public Long getSuperiorDetailId() {
        return superiorDetailId;
    }

    public void setSuperiorDetailId(Long superiorDetailId) {
        this.superiorDetailId = superiorDetailId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getDirectlyEnterpriseId() {
        return directlyEnterpriseId;
    }

    public void setDirectlyEnterpriseId(Long directlyEnterpriseId) {
        this.directlyEnterpriseId = directlyEnterpriseId;
    }

    public Integer getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(Integer namespaceId) {
        this.namespaceId = namespaceId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getIntegralTag1() {
        return integralTag1;
    }

    public void setIntegralTag1(Long integralTag1) {
        this.integralTag1 = integralTag1;
    }

    public Long getIntegralTag2() {
        return integralTag2;
    }

    public void setIntegralTag2(Long integralTag2) {
        this.integralTag2 = integralTag2;
    }

    public Long getIntegralTag3() {
        return integralTag3;
    }

    public void setIntegralTag3(Long integralTag3) {
        this.integralTag3 = integralTag3;
    }

    public Long getIntegralTag4() {
        return integralTag4;
    }

    public void setIntegralTag4(Long integralTag4) {
        this.integralTag4 = integralTag4;
    }

    public Long getIntegralTag5() {
        return integralTag5;
    }

    public void setIntegralTag5(Long integralTag5) {
        this.integralTag5 = integralTag5;
    }

    public String getStringTag1() {
        return stringTag1;
    }

    public void setStringTag1(String stringTag1) {
        this.stringTag1 = stringTag1;
    }

    public String getStringTag2() {
        return stringTag2;
    }

    public void setStringTag2(String stringTag2) {
        this.stringTag2 = stringTag2;
    }

    public String getStringTag3() {
        return stringTag3;
    }

    public void setStringTag3(String stringTag3) {
        this.stringTag3 = stringTag3;
    }

    public String getStringTag4() {
        return stringTag4;
    }

    public void setStringTag4(String stringTag4) {
        this.stringTag4 = stringTag4;
    }

    public String getStringTag5() {
        return stringTag5;
    }

    public void setStringTag5(String stringTag5) {
        this.stringTag5 = stringTag5;
    }

    public Byte getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(Byte showFlag) {
        this.showFlag = showFlag;
    }

    public String getNamespaceOrganizationToken() {
        return namespaceOrganizationToken;
    }

    public void setNamespaceOrganizationToken(String namespaceOrganizationToken) {
        this.namespaceOrganizationToken = namespaceOrganizationToken;
    }

    public String getNamespaceOrganizationType() {
        return namespaceOrganizationType;
    }

    public void setNamespaceOrganizationType(String namespaceOrganizationType) {
        this.namespaceOrganizationType = namespaceOrganizationType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getCreatorUid() {
        return creatorUid;
    }

    public void setCreatorUid(Long creatorUid) {
        this.creatorUid = creatorUid;
    }

    public Long getOperatorUid() {
        return operatorUid;
    }

    public void setOperatorUid(Long operatorUid) {
        this.operatorUid = operatorUid;
    }

    public Byte getSetAdminFlag() {
        return setAdminFlag;
    }

    public void setSetAdminFlag(Byte setAdminFlag) {
        this.setAdminFlag = setAdminFlag;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getAdminTargetId() {
        return adminTargetId;
    }

    public void setAdminTargetId(Long adminTargetId) {
        this.adminTargetId = adminTargetId;
    }

    public String getAdminContactToken() {
        return adminContactToken;
    }

    public void setAdminContactToken(String adminContactToken) {
        this.adminContactToken = adminContactToken;
    }

    public Byte getWorkPlatformFlag() {
        return workPlatformFlag;
    }

    public void setWorkPlatformFlag(Byte workPlatformFlag) {
        this.workPlatformFlag = workPlatformFlag;
    }

    public Byte getPmFlag() {
        return pmFlag;
    }

    public void setPmFlag(Byte pmFlag) {
        this.pmFlag = pmFlag;
    }

    public Byte getServiceSupportFlag() {
        return serviceSupportFlag;
    }

    public void setServiceSupportFlag(Byte serviceSupportFlag) {
        this.serviceSupportFlag = serviceSupportFlag;
    }

    public Byte getPlatformFlag() {
        return platformFlag;
    }

    public void setPlatformFlag(Byte platformFlag) {
        this.platformFlag = platformFlag;
    }

    public Long getOpcOrganizationCustomerId() {
        return opcOrganizationCustomerId;
    }

    public void setOpcOrganizationCustomerId(Long opcOrganizationCustomerId) {
        this.opcOrganizationCustomerId = opcOrganizationCustomerId;
    }

    public String getOpcOrganizationCustomerName() {
        return opcOrganizationCustomerName;
    }

    public void setOpcOrganizationCustomerName(String opcOrganizationCustomerName) {
        this.opcOrganizationCustomerName = opcOrganizationCustomerName;
    }

    public Timestamp getExpireStartDate() {
        return expireStartDate;
    }

    public void setExpireStartDate(Timestamp expireStartDate) {
        this.expireStartDate = expireStartDate;
    }

    public Timestamp getExpireEndDate() {
        return expireEndDate;
    }

    public void setExpireEndDate(Timestamp expireEndDate) {
        this.expireEndDate = expireEndDate;
    }

    public Byte getAppSelfConfigFlag() {
        return appSelfConfigFlag;
    }

    public void setAppSelfConfigFlag(Byte appSelfConfigFlag) {
        this.appSelfConfigFlag = appSelfConfigFlag;
    }

    public Byte getPcWorkPlatformFlag() {
        return pcWorkPlatformFlag;
    }

    public void setPcWorkPlatformFlag(Byte pcWorkPlatformFlag) {
        this.pcWorkPlatformFlag = pcWorkPlatformFlag;
    }

    //人员规模
    private String memberRange;

    private String avatarUri;

    private Integer projectsCount;

    private List<Byte> memberStatus;

    private Byte operatorFlag;

    public Byte getOperatorFlag() {
        return operatorFlag;
    }

    public void setOperatorFlag(Byte operatorFlag) {
        this.operatorFlag = operatorFlag;
    }

    public List<Byte> getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(List<Byte> memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getMemberRange() {
        return memberRange;
    }

    public void setMemberRange(String memberRange) {
        this.memberRange = memberRange;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public Integer getProjectsCount() {
        return projectsCount;
    }

    public void setProjectsCount(Integer projectsCount) {
        this.projectsCount = projectsCount;
    }
}
