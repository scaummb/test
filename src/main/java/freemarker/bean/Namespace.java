package freemarker.bean;

/**
 * • PC管理后台域名 #值变更内容#
 * • PC门户域名 #值变更内容#
 * • 文件中转站域名 #值变更内容#
 * • OP运营后台域名 #值变更内容#
 * • 短信签名抬头 #值变更内容#
 *
 * @author moubin.mo
 * @date: 2020/5/28 17:15
 */

public class Namespace {
	private Long id;
	private String name;
	private String homeUrl;
	private String pcHomeUrl;
	private String contentServerUrl;
	private String opServerUrl;
	private String smsHeader;

	public Namespace(Long id, String name, String homeUrl, String pcHomeUrl, String contentServerUrl, String opServerUrl, String smsHeader) {
		this.id = id;
		this.name = name;
		this.homeUrl = homeUrl;
		this.pcHomeUrl = pcHomeUrl;
		this.contentServerUrl = contentServerUrl;
		this.opServerUrl = opServerUrl;
		this.smsHeader = smsHeader;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public String getPcHomeUrl() {
		return pcHomeUrl;
	}

	public void setPcHomeUrl(String pcHomeUrl) {
		this.pcHomeUrl = pcHomeUrl;
	}

	public String getContentServerUrl() {
		return contentServerUrl;
	}

	public void setContentServerUrl(String contentServerUrl) {
		this.contentServerUrl = contentServerUrl;
	}

	public String getOpServerUrl() {
		return opServerUrl;
	}

	public void setOpServerUrl(String opServerUrl) {
		this.opServerUrl = opServerUrl;
	}

	public String getSmsHeader() {
		return smsHeader;
	}

	public void setSmsHeader(String smsHeader) {
		this.smsHeader = smsHeader;
	}
}
