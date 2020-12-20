package shizhanthread.chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *     不变性条件：NumberRange保管了两个状态变量，lower 和 upper，设置值必须保存在[lower,upper]
 *     由于状态变量彼此不独立，因此不能委托！
 *     同时复合操作也会让委托失败，所以要额外加锁才能确保线程安全。
 * </p>
 */

public class NumberRange {
	private final AtomicInteger lower = new AtomicInteger(0);
	private final AtomicInteger upper = new AtomicInteger(0);

	public void setLower(int i){
		//注意--不安全的“先检查后执行”
		if (i > upper.get()){
			throw new IllegalArgumentException("can't set lower to " + i + " > upper.");
		}
		lower.set(i);
	}

	public void setUpper(int i){
		//注意--不安全的“先检查后执行”
		if (i < lower.get()){
			throw new IllegalArgumentException("can't set uppper to " + i + " < lower.");
		}
		upper.set(i);
	}

	public boolean isInRange(int i){
		return (i >= lower.get() && i <= upper.get());
	}
}
