package design_module.ProxyPattern.dynamicProxy2;

/**
 * 被代理类或者叫代理目标类
 */
public class WomanDao implements IUserDao {
	@Override
	public void find() {
		System.out.println("查找女性用户");
	}
}
