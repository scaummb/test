package integer;

import integer.business.EnterpriseApprovalGroupColors;

/**
 * @author moubin.mo
 * @date: 2020/7/9 16:09
 */

public class TestCircle {
	public static void main(String[] args) {
		for (int i=0; i<10; i++){
			System.out.println(i + " - " + EnterpriseApprovalGroupColors.fromCode(i%3).getColor());
		}

	}
}