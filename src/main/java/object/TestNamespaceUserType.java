package object;

/**
 * @author moubin.mo
 * @date: 2019/11/27 15:31
 */

public class TestNamespaceUserType {
	public static void main(String[] args) {
		UserOrganizations userOrganizations = new UserOrganizations();
		userOrganizations.setNamespaceUserType("wx");
		if (NamespaceUserType.fromCode(userOrganizations.getNamespaceUserType()) == NamespaceUserType.WX) {
			System.out.print("ok");
		}
	}
}
