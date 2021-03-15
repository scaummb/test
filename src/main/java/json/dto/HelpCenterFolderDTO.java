package json.dto;


import java.sql.Timestamp;

/**
 * <ul>
 *     <li>id:id</li>
 *     <li>parentId:父节点id</li>
 *     <li>fileName:文件夹名称</li>
 *     <li>level:等级</li>
 *     <li>path:路径</li>
 *     <li>categoryId:分类id</li>
 *     <li>identify：文档标识，非必填</li>
 *     <li>fixedFlag:分类固定标识，若是固定标识则禁用重命名和删除操作{@link com.everhomes.rest.common.TrueOrFalseFlag}</li>
 *     <li>fileType：文件夹类型{@link com.everhomes.rest.helpcenter.constants.FileType}</li>
 *     <li>sortNum:排序id</li>
 *     <li>namespaceId:域空间id</li>
 *     <li>status:状态{@link com.everhomes.rest.helpcenter.constants.FileStatus}</li>
 * </ul>
 *
 * @author moubin.mo
 * @date: 2020/3/30 20:22
 */

public class HelpCenterFolderDTO {
	private Long id;
	private Long parentId;
	private String fileName;
	private Integer level;
	private String path;
	private Byte fixedFlag;
	private Byte fileType;
	private Integer sortNum;
	private String identify;
	private Long categoryId;
	private Integer namespaceId;
	private Byte status;
	private Timestamp createTime;
	private Long creatorUid;
	private Timestamp updateTime;
	private Long updatorUid;

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Byte getFixedFlag() {
		return fixedFlag;
	}

	public void setFixedFlag(Byte fixedFlag) {
		this.fixedFlag = fixedFlag;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Byte getFileType() {
		return fileType;
	}

	public void setFileType(Byte fileType) {
		this.fileType = fileType;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
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
