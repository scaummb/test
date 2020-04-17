package json.response;


/**
 * @author moubin.mo
 * @date: 2020/4/17 15:37
 */

public class HelpCenterRestResponse {
	private String version;
	private Integer errorCode;
	private String errorDescription;
	private String errorScope;
	private String errorDetails;
	private String response;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorScope() {
		return errorScope;
	}

	public void setErrorScope(String errorScope) {
		this.errorScope = errorScope;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
