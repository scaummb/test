package shizhanthread.chapter4;

import shizhanthread.annotations.ThreadSafe;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>
 * 组合：为现有类添加一个原子操作时,组合是一个更好的选择。它不关心底层的List是否线程安全。
 * 劣势：虽然额外的同步层导致轻微性能损失
 * 好处：使用java监视器模式来封装现有的List，并且只要在类中应有指向底层List的唯一外部引用，就能够确保线程安全
 *
 * </p>
 */
@ThreadSafe
public class ImproveList<T> implements List<T> {
	//状态变量的作用域封装在类里面
	private final List<T> list;

	public ImproveList(List<T> list) {
		this.list = list;
	}

	// 通过内置锁增加一层额外的加锁
	public synchronized boolean putIfAbsent(T x) {
		boolean absent = list.contains(x);
		if (absent) {
			list.add(x);
		}
		return absent;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return null;
	}

	@Override
	public boolean add(T t) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	//委托给底层的list
	public synchronized void clear() {
		list.clear();
	}

	@Override
	public T get(int index) {
		return null;
	}

	@Override
	public T set(int index, T element) {
		return null;
	}

	@Override
	public void add(int index, T element) {

	}

	@Override
	public T remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return null;
	}
}
