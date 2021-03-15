package concurrency.rejection;

/**
 * @author moubin.mo
 * @date: 2021/3/9 16:22
 */

public class Worker implements Runnable {
	// 任务编号
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Worker(String id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		try {
			//休眠1s
			Thread.sleep(1000);
			System.out.println(id + " 正常执行！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
