package freemarker;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author moubin.mo
 * @date: 2020/5/27 00:30
 */

public class FreeMarkerTemplateUtils {
	public FreeMarkerTemplateUtils() {
	}

	public static String processTemplateIntoString(Template template, Object model) throws IOException, TemplateException {
		StringWriter result = new StringWriter();
		template.process(model, result);
		return result.toString();
	}

}
