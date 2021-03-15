package string;

import file.AppidSecretObject;

/**
 * @author moubin.mo
 * @date: 2019/10/25 16:54
 */

public class TestStringValueInvoke {

	public static void main(String[] args) {
		String test = "aaaa";
//		StringBuffer testBuffer = new StringBuffer("aaa");
//		addString(test);
//		addString(testBuffer);
//		System.out.println("1 " + test+ " " + test.hashCode());


		AppidSecretObject appidSecretObject = new AppidSecretObject("1", "1", "1");
		changeappidSecretObject(appidSecretObject);
		System.out.println(appidSecretObject);
	}

	private static void changeappidSecretObject(AppidSecretObject appidSecretObject) {
		appidSecretObject.setAppid("2");
		appidSecretObject.setNamespaceId("2");
		appidSecretObject.setSecret("2");
		System.out.println(appidSecretObject);
	}

	private static void addString(String test) {
		String test1 = test + "bbbbb";
		System.out.println("2 " + test.toString() + " " + test.hashCode());


		test = test1;


		System.out.println("3 " + test.toString() + " " + test.hashCode());
		System.out.println("4 " + test1.toString() + " " + test1.hashCode());
	}

	private static void addString(StringBuffer test) {
		test.append("bbbbb");
	}

}



