package shizhanthread.chapter4;

import shizhanthread.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 基于java监视器模式的车辆追踪，使用对象内置锁
 * </p>
 */
@ThreadSafe
public class MonitorVehicleTracker {
	//实例封闭
	private final Map<String, MutablePoint> locations;

	// 构造器
	public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
		this.locations = deepCopy(locations);
	}

	// 获取数据
	public synchronized Map<String, MutablePoint> getLocations() {
		return deepCopy(locations);
	}

	// 设置数据
	public synchronized void setLocation(String id, int x, int y) {
		MutablePoint loc = locations.get(id);
		if (loc == null)
			throw new IllegalArgumentException("No such ID: " + id);
		loc.x = x;
		loc.y = y;
	}

	// 获取数据
	public synchronized MutablePoint getLocation(String id) {
		MutablePoint mutablePoint = locations.get(id);
		return mutablePoint == null ? null : new MutablePoint(mutablePoint);
	}

	// 深拷贝
	private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
		Map result = new HashMap<String, MutablePoint>();
		for (String id : m.keySet()) {
			result.put(id, new MutablePoint(m.get(id)));
		}
		return Collections.unmodifiableMap(result);
	}
}

/**
 * <p>
 * 虽然 MutablePoint 非线程安全，但是 MonitorVehicleTracker 是线程安全的。
 * 某种程度上，线程安全是通过：在返回客户代码之前，复制可变的数据来维护。
 * 劣势：在数据量大的情况下，极大的降低性能。
 * </p>
 */
class MutablePoint {
	public int x, y;

	public MutablePoint() {
		x = 0;
		y = 0;
	}

	public MutablePoint(MutablePoint p) {
		this.x = p.x;
		this.y = p.y;
	}

}