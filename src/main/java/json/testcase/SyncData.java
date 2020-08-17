package json.testcase;

import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/8/13 10:26
 */

public class SyncData {
	private List data;
	private String operationType;

	public SyncData() {
	}

	public SyncData(List data, String operationType) {
		this.data = data;
		this.operationType = operationType;
	}

	public List getData() {
		return this.data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
}
