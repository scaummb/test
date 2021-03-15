package Utils.demo.boContribute;

import java.sql.Timestamp;

/**
 * Date: 2019/7/8 16 :07
 *
 * @author moubin.mo
 */

public class Group {
	private static final long serialVersionUID = -472479880L;
	private Long id;
	private String uuid;
	private Integer namespaceId;
	private String name;
	private String displayName;
	private String avatar;
	private String description;
	private Long creatorUid;
	private Byte privateFlag;
	private Integer joinPolicy;
	private String discriminator;
	private Byte visibilityScope;
	private Long visibilityScopeId;
	private Long categoryId;
	private String categoryPath;
	private Byte status;
	private Long memberCount;
	private Long shareCount;
	private Byte postFlag;
	private String tag;
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
	private Timestamp updateTime;
	private Timestamp createTime;
	private Timestamp deleteTime;
	private Byte visibleRegionType;
	private Long visibleRegionId;
	private Byte approvalStatus;
	private Long operatorUid;
	private Byte touristPostPolicy;
	private Byte clubType;
	private String phoneNumber;
	private Byte descriptionType;

	public Group() {

	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreatorUid() {
		return creatorUid;
	}

	public void setCreatorUid(Long creatorUid) {
		this.creatorUid = creatorUid;
	}

	public Byte getPrivateFlag() {
		return privateFlag;
	}

	public void setPrivateFlag(Byte privateFlag) {
		this.privateFlag = privateFlag;
	}

	public Integer getJoinPolicy() {
		return joinPolicy;
	}

	public void setJoinPolicy(Integer joinPolicy) {
		this.joinPolicy = joinPolicy;
	}

	public String getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public Byte getVisibilityScope() {
		return visibilityScope;
	}

	public void setVisibilityScope(Byte visibilityScope) {
		this.visibilityScope = visibilityScope;
	}

	public Long getVisibilityScopeId() {
		return visibilityScopeId;
	}

	public void setVisibilityScopeId(Long visibilityScopeId) {
		this.visibilityScopeId = visibilityScopeId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Long memberCount) {
		this.memberCount = memberCount;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public Byte getPostFlag() {
		return postFlag;
	}

	public void setPostFlag(Byte postFlag) {
		this.postFlag = postFlag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Byte getVisibleRegionType() {
		return visibleRegionType;
	}

	public void setVisibleRegionType(Byte visibleRegionType) {
		this.visibleRegionType = visibleRegionType;
	}

	public Long getVisibleRegionId() {
		return visibleRegionId;
	}

	public void setVisibleRegionId(Long visibleRegionId) {
		this.visibleRegionId = visibleRegionId;
	}

	public Byte getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Byte approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Long getOperatorUid() {
		return operatorUid;
	}

	public void setOperatorUid(Long operatorUid) {
		this.operatorUid = operatorUid;
	}

	public Byte getTouristPostPolicy() {
		return touristPostPolicy;
	}

	public void setTouristPostPolicy(Byte touristPostPolicy) {
		this.touristPostPolicy = touristPostPolicy;
	}

	public Byte getClubType() {
		return clubType;
	}

	public void setClubType(Byte clubType) {
		this.clubType = clubType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Byte getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(Byte descriptionType) {
		this.descriptionType = descriptionType;
	}
}
