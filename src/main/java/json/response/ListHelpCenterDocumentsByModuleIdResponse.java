package json.response;

import json.dto.HelpCenterDocumentDTO;

import java.util.List;

/**
 * <ul>
 *     <li>dtos:帮助中心文档</li>
 *     <li>totalNum:文档总量</li>
 *     <li>pageNum：下一页页码</li>
 * </ul>
 * @author moubin.mo
 * @date: 2020/4/1 11:34
 */

public class ListHelpCenterDocumentsByModuleIdResponse {
	private List<HelpCenterDocumentDTO> dtos;
	private Long totalNum;
	private Long pageNum;

	public List<HelpCenterDocumentDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<HelpCenterDocumentDTO> dtos) {
		this.dtos = dtos;
	}

	public Long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	public Long getPageNum() {
		return pageNum;
	}

	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "ListHelpCenterDocumentsByModuleIdResponse{" +
				"dtos=" + dtos +
				", totalNum=" + totalNum +
				", pageNum=" + pageNum +
				'}';
	}
}
