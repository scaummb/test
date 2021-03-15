package exception;

/**
 * Date: 2019/6/19 16 :06
 *
 * @author moubin.mo
 */

public class ParentException extends Exception {
	private String message;
	private int statusCode;

	public ParentException(String message, int statusCode) {
		super(message);
		this.message = message;
		this.statusCode = statusCode;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public int getStatusCode() {
		return statusCode;
	}

}
