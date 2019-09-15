package array;

/**
 * @author moubin.mo
 * @date: 2019/9/15 15:49
 */

public class BankAccount {
	private String name;
	private Double wallet;

	public BankAccount(String name, Double wallet) {
		this.name = name;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}
}
