package object;

/**
 * @author moubin.mo
 * @date: 2019/11/21 15:59
 */

public class TestFlag {
	public static void main(String[] args) {
		Integer wxNamespaceFlag = 1;
		if (wxNamespaceFlag == null || TrueOrFalseCode.TRUE.getCode().equals(wxNamespaceFlag.byteValue())){
			System.out.print("ok");
		}
	}
}
