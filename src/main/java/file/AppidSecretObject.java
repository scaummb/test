package file;

/**
 * @author moubin.mo
 * @date: 2019/10/25 17:32
 */

public class AppidSecretObject {
	private String namespaceId;
	private String appid;
	private String secret;

	public AppidSecretObject(String namespaceId, String appid, String secret) {
		this.namespaceId = namespaceId;
		this.appid = appid;
		this.secret = secret;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(String namespaceId) {
		this.namespaceId = namespaceId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "AppidSecretObject{" +
				"namespaceId='" + namespaceId + '\'' +
				", appid='" + appid + '\'' +
				", secret='" + secret + '\'' +
				'}';
	}
}
