package json.dto;


import java.sql.Timestamp;

/**
 * <ul>
 *     <li>id:id</li>
 *     <li>categoryName:分类名称</li>
 *     <li>fixedFlag:分类固定标识，若是固定标识则禁用重命名和删除操作{@link com.everhomes.rest.common.TrueOrFalseFlag}</li>
 *     <li>namespaceId:namespaceId</li>
 *     <li>status:状态{@link com.everhomes.rest.helpcenter.constants.FileStatus}</li>
 *     <li>createTime:createTime</li>
 *     <li>creatorUid:creatorUid</li>
 *     <li>updateTime:updateTime</li>
 *     <li>updatorUid:updatorUid</li>
 * </ul>
 *
 * @author moubin.mo
 * @date: 2020/3/31 10:30
 */

public class HelpCenterCategoryDTO {
	private Long id;
	private String categoryName;
	private Byte fixedFlag;
	private Integer namespaceId;
	private Byte status;
	private Timestamp createTime;
	private Long creatorUid;
	private Timestamp updateTime;
	private Long updatorUid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Byte getFixedFlag() {
		return fixedFlag;
	}

	public void setFixedFlag(Byte fixedFlag) {
		this.fixedFlag = fixedFlag;
	}

	public Integer getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(Integer namespaceId) {
		this.namespaceId = namespaceId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getCreatorUid() {
		return creatorUid;
	}

	public void setCreatorUid(Long creatorUid) {
		this.creatorUid = creatorUid;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdatorUid() {
		return updatorUid;
	}

	public void setUpdatorUid(Long updatorUid) {
		this.updatorUid = updatorUid;
	}

}
