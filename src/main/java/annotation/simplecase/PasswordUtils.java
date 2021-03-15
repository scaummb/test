package annotation.simplecase;

import java.util.List;

/**
 * 注解使用例子
 *
 * @author: mmb
 * @date: 19-8-10
 */
public class PasswordUtils {

	@UserCase(id = 47, description = "Passward must contain at least one numeric.")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}

	@UserCase(id = 48)
	public String encryptPassward(String passward) {
		return new StringBuilder(passward).reverse().toString();
	}

	@UserCase(id = 49, description = "New password can not equal previously used ones.")
	public boolean checkForNewPassword(List<String> prePasswords, String password) {
		return !prePasswords.contains(password);
	}

}
