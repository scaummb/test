package shizhanthread.chapter4;

import jdk.nashorn.internal.ir.annotations.Immutable;
import shizhanthread.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>
 * 线程安全的委托：使用线程安全组件，将维护线程安全的任务交给安全容器.
 * 下面实例：将线程安全的坐标map数据，委托给了一个线程安全的状态变量 locations，它是一个实现了 ConcurrentMap 接口的 ConcurrentHashMap 实例。
 * </p>
 */
@ThreadSafe
public class DelegatingVehicleTracker {

	private final ConcurrentMap<String, Point> locations;

	private final Map<String, Point> unmodifiableMap;

	public DelegatingVehicleTracker(Map<String, Point> points) {
		locations = new ConcurrentHashMap<String, Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(points);
	}

	public Point getLocations(String id) {
		return locations.get(id);
	}
	// 设置数据

	public synchronized void setLocation(String id, int x, int y) {
		if (locations.replace(id, new Point(x, y)) == null) {
			throw new IllegalArgumentException("invalid vehicle name: " + id);
		}
	}

	// 获取全部数据
	public Map<String, Point> getLocations() {
		return unmodifiableMap;
	}
	// 获取全部数据,优化获取静态数据拷贝
//	public Map<String, Point> getLocations(){
//		return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
//	}

}

@Immutable
class Point {
	public final int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}