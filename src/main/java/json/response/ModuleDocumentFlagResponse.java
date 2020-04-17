package json.response;


/**
 * <ul>
 *     <li>flag:标识模块是否有设置帮助文档 {@link com.everhomes.rest.common.TrueOrFalseFlag}</li>
 * </ul>
 * @author moubin.mo
 * @date: 2020/4/1 11:41
 */

public class ModuleDocumentFlagResponse {
	private Byte flag;

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

}
