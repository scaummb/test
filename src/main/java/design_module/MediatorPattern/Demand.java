package design_module.MediatorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 14:58
 */

public class Demand {
	private String description;

	public Demand(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
