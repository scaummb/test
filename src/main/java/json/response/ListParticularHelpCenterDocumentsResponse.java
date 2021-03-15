package json.response;


import json.dto.DocumentSettingInfo;
import json.dto.HelpCenterDocumentTreeDTO;

/**
 * <ul>
 *     <li>dto：文档树</li>
 *     <li>documentSettingInfo：设置信息</li>
 * </ul>
 *
 * @author moubin.mo
 * @date: 2020/4/13 18:15
 */

public class ListParticularHelpCenterDocumentsResponse {
	private HelpCenterDocumentTreeDTO dto;
	private DocumentSettingInfo documentSettingInfo;

	public DocumentSettingInfo getDocumentSettingInfo() {
		return documentSettingInfo;
	}

	public void setDocumentSettingInfo(DocumentSettingInfo documentSettingInfo) {
		this.documentSettingInfo = documentSettingInfo;
	}

	public HelpCenterDocumentTreeDTO getDto() {
		return dto;
	}

	public void setDto(HelpCenterDocumentTreeDTO dto) {
		this.dto = dto;
	}
}
