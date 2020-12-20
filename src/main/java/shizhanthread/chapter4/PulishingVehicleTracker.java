package shizhanthread.chapter4;

import java.util.Collections;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/12/19 23:34
 */

public class PulishingVehicleTracker {
	private final Map<String, SafePoint> locations;
	private final Map<String, SafePoint> unmodifiableMap;

	public PulishingVehicleTracker(Map<String, SafePoint> locations) {
		this.locations = locations;
		this.unmodifiableMap = Collections.unmodifiableMap(locations);
	}

	public Map<String, SafePoint> getLocations() {
		return unmodifiableMap;
	}

	public SafePoint getLocation(String id){
		return locations.get(id);
	}

	public void setLocation (String id, int x, int y){
		if (!locations.containsKey(id)){
			throw new IllegalArgumentException("invalid vehicle name:"+id);
		}
		locations.get(id).set(x,y);
	}

}
//线程安全且可变的SafePoint
class SafePoint{
	private int x, y;

	public SafePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public SafePoint(int[] a) {
		this(a[0],a[1]);
	}

	public synchronized int[] get(){
		return new int[]{x,y};
	}

	public synchronized void set(int x, int y){
		this.x=x;
		this.y=y;
	}
}