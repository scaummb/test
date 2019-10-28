package version_control;

/**
 * @author moubin.mo
 * @date: 2019/10/19 20:47
 */

public class Test {
	public static void main(String[] args) {
		String appVersion = "6.10.0";
		String organizationFieldType = "SINGLE_LINE_TEXT";
		long encodedValue = UserAuthVersionSeparation.USER_AUTH_FORM_SEPARATION_VERSION_2.getEncodedValue();
		long encodedValue1 = Version.fromVersionString(appVersion).getEncodedValue();
		if (encodedValue1 >= encodedValue && GeneralFormFieldType.SINGLE_LINE_TEXT.getCode().equals(organizationFieldType)) {
			System.out.print("111");
		}

		if (encodedValue1 >= encodedValue && (organizationFieldType == GeneralFormFieldType.SINGLE_LINE_TEXT.getCode())) {
			System.out.print("222");
		}
	}
}
