package json.dto;


import java.sql.Timestamp;

/**
 * <ul>
 *     <li>id：id</li>
 *     <li>moduleId:模块id</li>
 *     <li>moduleName：模块名</li>
 *     <li>folderStructureId：文件目录结构id</li>
 *     <li>parentId：文件结构id</li>
 *     <li>level：文件所在层级id</li>
 *     <li>path：文件路径</li>
 *     <li>fileName：文件名称</li>
 *     <li>sortNum：排序id</li>
 *     <li>categoryId：文档分类id</li>
 *     <li>publishType：文档发布状态{@link com.everhomes.rest.helpcenter.constants.PublishType}</li>
 *     <li>publishVersionIdentify：文档发布版本标识 </li>
 *     <li>publishVersionNumber：文档发布编号（系统根据发布时间自动生成） </li>
 *     <li>draftFlag：文档草稿标识</li>
 *     <li>content：文档内容</li>
 *     <li>namespaceId：namespaceId</li>
 *     <li>status:状态{@link com.everhomes.rest.helpcenter.constants.FileStatus}</li>
 *     <li>createTime:createTime</li>
 *     <li>creatorUid:creatorUid</li>
 *     <li>creatorNickName:创建者昵称</li>
 *     <li>updateTime:updateTime</li>
 *     <li>updatorUid:updatorUid</li>
 *     <li>updatorNickName:更新者昵称</li>
 * </ul>
 *
 * @author moubin.mo
 * @date: 2020/3/30 18:27
 */

public class HelpCenterDocumentDTO {
	private Long id;
	private Long moduleId;
	private String moduleName;
	private Long folderStructureId;
	private Long parentId;
	private Integer level;
	private String path;
	private String fileName;
	private Integer sortNum;
	private Long categoryId;
	private Byte publishType;
	private String publishVersionIdentify;
	private String publishVersionNumber;
	private Byte draftFlag;
	private String content;
	private Integer namespaceId;
	private Byte status;
	private Timestamp createTime;
	private Long creatorUid;
	private String creatorNickName;
	private Timestamp updateTime;
	private Long updatorUid;
	private String updatorNickName;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreatorNickName() {
		return creatorNickName;
	}

	public void setCreatorNickName(String creatorNickName) {
		this.creatorNickName = creatorNickName;
	}

	public String getUpdatorNickName() {
		return updatorNickName;
	}

	public void setUpdatorNickName(String updatorNickName) {
		this.updatorNickName = updatorNickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getFolderStructureId() {
		return folderStructureId;
	}

	public void setFolderStructureId(Long folderStructureId) {
		this.folderStructureId = folderStructureId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Byte getPublishType() {
		return publishType;
	}

	public void setPublishType(Byte publishType) {
		this.publishType = publishType;
	}

	public String getPublishVersionIdentify() {
		return publishVersionIdentify;
	}

	public void setPublishVersionIdentify(String publishVersionIdentify) {
		this.publishVersionIdentify = publishVersionIdentify;
	}

	public String getPublishVersionNumber() {
		return publishVersionNumber;
	}

	public void setPublishVersionNumber(String publishVersionNumber) {
		this.publishVersionNumber = publishVersionNumber;
	}

	public Byte getDraftFlag() {
		return draftFlag;
	}

	public void setDraftFlag(Byte draftFlag) {
		this.draftFlag = draftFlag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
