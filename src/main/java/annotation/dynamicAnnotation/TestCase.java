package annotation.dynamicAnnotation;

import annotation.dynamicAnnotation.business.zone.ZoneOperationLogHandler;
import annotation.dynamicAnnotation.log.handler.OperationLogBaseHandler;

import java.lang.reflect.Method;

/**
 * @author moubin.mo
 * @date: 2020/5/19 12:02
 */

public class TestCase {
	public static void main(String[] args) {
//		new OperationLogContext(new ZoneOperationLogHandler())
//				.submitLog(
//						new ZoneCreateBaseLogger("新增了域空间“{#namspaceName}”", null, new Namespace())
//				);

		OperationLogBaseHandler handler = new ZoneOperationLogHandler();
		Method[] methods = handler.getClass().getDeclaredMethods();
		System.out.println(methods);

	}
}
