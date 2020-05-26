package freemarker.bean;

import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/5/27 00:34
 */

public class OrganizationCustomer {
	//数值
	private Long id;
	private String name;
	private String description;
	// 类型
	private ContactUser user;
	// 容器+普通数值
	private List<String> address;
	// 容器+类型
	private List<ContactUser> members;
	// 容器+嵌套
	private List<OrganizationCustomer> customers;

	public OrganizationCustomer() {
	}

	public OrganizationCustomer(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public List<OrganizationCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<OrganizationCustomer> customers) {
		this.customers = customers;
	}

	public List<ContactUser> getMembers() {
		return members;
	}

	public void setMembers(List<ContactUser> members) {
		this.members = members;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public ContactUser getUser() {
		return user;
	}

	public void setUser(ContactUser user) {
		this.user = user;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
