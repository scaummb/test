package json.dto;

/**
 * <ul>
 *     <li>categoryName：文档分类名</li>
 *     <li>categoryId：文档分类id</li>
 *     <li>identify：发布标识</li>
 * </ul>
 * @author moubin.mo
 * @date: 2020/4/9 19:58
 */

public class DocumentSettingInfo {
	private String categoryName;
	private Long categoryId;
	private String identify;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

}
