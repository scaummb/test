package multiThread.utils;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *     CountDownLatch 内部维护了一个偏向锁 Sync
 *     初始化时， this.sync = new Sync(count); 设置 state。
 *		CountDownLatch是让某一线程等待多个线程的状态，然后该线程被唤醒。
 *
 *     countdown：本质是  sync.releaseShared(1);
 *     	tryReleaseShared()：检查是否扣一，自旋锁（乐观锁）CAS
 *     		protected boolean tryReleaseShared(int releases) {
 *             // Decrement count; signal when transition to zero
 *             for (;;) {
 *                 int c = getState();//获取内部锁的状态
 *                 if (c == 0) //为0说明已经倒计时完成了。
 *                     return false;
 *                 int nextc = c-1;//不为0，则扣一
 *                 if (compareAndSetState(c, nextc)) //(ABA问题没解决哦)
 *                     return nextc == 0; //返回是否等于0，为0就要外层逻辑执行了。
 *             }
 *         }
 *
 *	   protected final boolean compareAndSetState(int expect, int update) {
 *         // See below for intrinsics setup to support this
 *         return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
 *     }
 *
 *		doReleaseShared()：释放锁资源。
 *		主要逻辑：
 *      for (;;) {
 *             Node h = head;
 *             if (h != null && h != tail) {
 *                 int ws = h.waitStatus;
 *                 if (ws == Node.SIGNAL) {
 *                     if (!compareAndSetWaitStatus(h, Node.SIGNAL, 0))
 *                         continue;            // loop to recheck cases
 *                     unparkSuccessor(h);
 *                 }
 *                 else if (ws == 0 &&
 *                          !compareAndSetWaitStatus(h, 0, Node.PROPAGATE))
 *                     continue;                // loop on failed CAS
 *             }
 *             if (h == head)                   // loop if head changed
 *                 break;
 *         }
 *     }
 *
 *
 * 	【2，await】
 * 	 public void await() throws InterruptedException {
 *         sync.acquireSharedInterruptibly(1);
 *     }
 *
 *   public final void acquireSharedInterruptibly(int arg)
 *             throws InterruptedException {
 *         if (Thread.interrupted())
 *             throw new InterruptedException();
 *         if (tryAcquireShared(arg) < 0) //比较state是否 == 0了，是的话
 *             doAcquireSharedInterruptibly(arg); //添加当前线程到等待队列
 *     }
 *     //倒计时未结束，返回-1
 *      protected int tryAcquireShared(int acquires) {
 *             return (getState() == 0) ? 1 : -1;
 *         }
 *
 *    private Node addWaiter(Node mode) {
 *         Node node = new Node(Thread.currentThread(), mode);
 *         // Try the fast path of enq; backup to full enq on failure
 *         Node pred = tail;
 *         if (pred != null) {
 *             node.prev = pred;
 *             if (compareAndSetTail(pred, node)) {
 *                 pred.next = node;
 *                 return node;
 *             }
 *         }
 *         enq(node);
 *         return node;
 *     }
 * </p>
 * @author moubin.mo
 * @date: 2021/3/1 11:22
 */

public class CountDownLatchUtil {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(4);
		new Thread(new Runnable() {
			@Override
			public void run() {
				countDownLatch.countDown();
				System.out.println("11111");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				countDownLatch.countDown();
				System.out.println("222222");
			}
		}).start();
		countDownLatch.countDown();
		countDownLatch.await();
		System.out.println("3333");
	}
}
