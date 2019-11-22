package object;

import org.apache.commons.lang.StringUtils;

/**
 * @author moubin.mo
 * @date: 2019/11/20 19:31
 */

public class TestUser {
	public static void main(String[] args) {
		User user = new User();
		user.setNamespaceUserToken("aaa");
		user.setNamespaceUserType(NamespaceUserType.WX.getCode());
		if(StringUtils.isNotBlank(user.getNamespaceUserToken()) && NamespaceUserType.WX.getCode().equals(user.getNamespaceUserType())){
			System.out.print("ok");
		}
	}
}
