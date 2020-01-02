package convert;

import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/1/2 18:15
 */

public class AObject {
	private Long id;
	private String name;
	private List<Long> ids;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
