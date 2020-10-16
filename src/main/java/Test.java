import java.util.Arrays;

/**
 * @author moubin.mo
 * @date: 2020/6/16 23:57
 */

public class Test {
	public static void main(String[] args) {
		test2();
	}

	/**
	 * <p>
	 *     ASCII字符表的字母，解码后byte数组长度跟字符串长度一致
	 *     如果有中文字符，超出了ASCII字符表的表示范围，则会出现长度溢出
	 * </p>
	 */
	private static void test2() {
		String time = String.valueOf(System.currentTimeMillis());
		StringBuffer stringBuffer = new StringBuffer();
		for (int i=0;i<20;i++){
			stringBuffer.append(time);
		}
		byte[] timeBytes = stringBuffer.toString().getBytes();
		System.out.println("timelength="+stringBuffer.toString().length()+", time = "+stringBuffer.toString());
		System.out.println("length="+timeBytes.length+",bytes = "+ Arrays.toString(timeBytes));

		Long userId = 1000L;
		String date = "2020-1-1-1-1一二";
		String cardCode = userId.toString().concat(date);
		byte[] bytes = cardCode.getBytes();
		System.out.println("datalength="+cardCode.length()+", data = "+cardCode);
		System.out.println("length="+bytes.length+",bytes = "+ Arrays.toString(bytes));
	}

	private static void test1() {
		DTO dto1 = new DTO();
		DTO dto2 = new DTO();
		StringBuilder stringBuilder = new StringBuilder();
		if(dto1.getNamespaceName() == null && dto2.getNamespaceName() == null
				|| (dto1.getNamespaceName() != null && dto2.getNamespaceName() != null
				&& dto1.getNamespaceName().equals(dto2.getNamespaceName()))){
			//两者都为空或两者相等 nothing
		}
		else if(dto1.getNamespaceName() != null && dto2.getNamespaceName() == null){
			stringBuilder.append("域空间名称设置为空");
		}
		else if(dto1.getNamespaceName() == null && dto2.getNamespaceName() != null){
			stringBuilder.append("域空间名称设置为"+dto2.getNamespaceName());
		}
		else if(dto1.getNamespaceName() != null && dto2.getNamespaceName() != null && !dto1.getNamespaceName().equals(dto2.getNamespaceName())){
			stringBuilder.append("域空间名称从"+dto1.getNamespaceName()+"改为"+dto2.getNamespaceName());
		}
	}

}
class DTO{
	private String namespaceName;

	public String getNamespaceName() {
		return namespaceName;
	}

	public void setNamespaceName(String namespaceName) {
		this.namespaceName = namespaceName;
	}
}