package shizhanthread.chapter3;

import shizhanthread.annotations.NotThreadSafe;
import sun.nio.ch.Secrets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author moubin.mo
 * @date: 2020/12/13 21:15
 */
@NotThreadSafe
public class PublishObject {
	public static Set<Secrets> knownSecrets;

	//提供方法，对外发布 knownSecrets
	public void initialize() {
		knownSecrets = new HashSet<Secrets>();
	}

}
