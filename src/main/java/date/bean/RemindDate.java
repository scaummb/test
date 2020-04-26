package date.bean;

import java.sql.Timestamp;

/**
 * <ul>
 * <li>startTime: startTime</li>
 * <li>endTime: endTime</li>
 * </ul>
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
