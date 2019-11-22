package object;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author moubin.mo
 * @date: 2019/11/20 19:30
 */

public class User {
	private Long id;
	private String uuid;
	private String accountName;
	private String nickName;
	private String avatar;
	private String statusLine;
	private Byte status;
	private Integer points;
	private Byte level;
	private Byte gender;
	private Date birthday;
	private Long addressId;
	private String address;
	private Long communityId;
	private Long homeTown;
	private String homeTownPath;
	private String occupation;
	private String company;
	private String school;
	private String locale;
	private Byte inviteType;
	private Long invitorUid;
	private Timestamp createTime;
	private Timestamp deleteTime;
	private Timestamp lastLoginTime;
	private String lastLoginIp;
	private String regIp;
	private Long regCityId;
	private Long regChannelId;
	private String originalAvatar;
	private String salt;
	private String passwordHash;
	private Integer namespaceId;
	private String namespaceUserToken;
	private String namespaceUserType;
	private Byte executiveTag;
	private String positionTag;
	private String identityNumberTag;
	private Timestamp updateTime;
	private String thirdData;
	private Byte showCompanyFlag;
	private Long companyId;
	private Integer vipLevel;
	private String vipLevelText;
	private Long updateVersion;

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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getStatusLine() {
		return statusLine;
	}

	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public Long getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(Long homeTown) {
		this.homeTown = homeTown;
	}

	public String getHomeTownPath() {
		return homeTownPath;
	}

	public void setHomeTownPath(String homeTownPath) {
		this.homeTownPath = homeTownPath;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Byte getInviteType() {
		return inviteType;
	}

	public void setInviteType(Byte inviteType) {
		this.inviteType = inviteType;
	}

	public Long getInvitorUid() {
		return invitorUid;
	}

	public void setInvitorUid(Long invitorUid) {
		this.invitorUid = invitorUid;
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

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public Long getRegCityId() {
		return regCityId;
	}

	public void setRegCityId(Long regCityId) {
		this.regCityId = regCityId;
	}

	public Long getRegChannelId() {
		return regChannelId;
	}

	public void setRegChannelId(Long regChannelId) {
		this.regChannelId = regChannelId;
	}

	public String getOriginalAvatar() {
		return originalAvatar;
	}

	public void setOriginalAvatar(String originalAvatar) {
		this.originalAvatar = originalAvatar;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Integer getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(Integer namespaceId) {
		this.namespaceId = namespaceId;
	}

	public String getNamespaceUserToken() {
		return namespaceUserToken;
	}

	public void setNamespaceUserToken(String namespaceUserToken) {
		this.namespaceUserToken = namespaceUserToken;
	}

	public String getNamespaceUserType() {
		return namespaceUserType;
	}

	public void setNamespaceUserType(String namespaceUserType) {
		this.namespaceUserType = namespaceUserType;
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

	public String getIdentityNumberTag() {
		return identityNumberTag;
	}

	public void setIdentityNumberTag(String identityNumberTag) {
		this.identityNumberTag = identityNumberTag;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getThirdData() {
		return thirdData;
	}

	public void setThirdData(String thirdData) {
		this.thirdData = thirdData;
	}

	public Byte getShowCompanyFlag() {
		return showCompanyFlag;
	}

	public void setShowCompanyFlag(Byte showCompanyFlag) {
		this.showCompanyFlag = showCompanyFlag;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Integer getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipLevelText() {
		return vipLevelText;
	}

	public void setVipLevelText(String vipLevelText) {
		this.vipLevelText = vipLevelText;
	}

	public Long getUpdateVersion() {
		return updateVersion;
	}

	public void setUpdateVersion(Long updateVersion) {
		this.updateVersion = updateVersion;
	}
}
