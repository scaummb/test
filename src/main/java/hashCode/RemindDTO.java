package hashCode;

/**
 * @author moubin.mo
 * @date: 2020/3/9 14:11
 */

public class RemindDTO implements Comparable {
	private Long startTime;
	private Long endTime;

	public RemindDTO(Long startTime, Long endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "RemindDTO{" +
				"startTime=" + startTime +
				", endTime=" + endTime +
				'}';
	}

	@Override
	public int compareTo(Object o) {
		RemindDTO obj = (RemindDTO) o;
		if (Long.compare(this.startTime, obj.getStartTime()) == 0) {
			return Long.compare(this.getEndTime(), obj.getEndTime());
		}
		return Long.compare(this.startTime, obj.getStartTime());
	}
}
