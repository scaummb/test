package shizhanthread.chapter4;

import shizhanthread.annotations.ThreadSafe;
import stream.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     实例封闭之一
 *     通过封闭机制-》线程安全。
 *     状态对象不逸出，将对象封闭在类里面。
 *     使用对象内置锁
 * </p>
 */
@ThreadSafe
public class PersonSet {
	private final Set<Person> mySet = new HashSet<Person>();

	public synchronized void addPerson(Person person){
		mySet.add(person);
	}

	public synchronized boolean containPerson(Person person){
		return mySet.contains(person);
	}
}
