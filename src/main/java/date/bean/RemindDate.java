package date.bean;

import java.sql.Timestamp;

/**
 * @author moubin.mo
 * @date: 2020/3/13 10:44
 */

public class RemindDate {
	private Timestamp startTime;
	private Timestamp endTime;

	public RemindDate(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
