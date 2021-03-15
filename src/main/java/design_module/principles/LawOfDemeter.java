package design_module.principles;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2021/1/3 22:33
 */

public class LawOfDemeter {
}

//总公司员工
class Employee {
	private String id;
}

//分公司员工
class SubEmployee {
	private String id;
}

//分公司经理
class SubCompanyManager {
	List<SubEmployee> subEmployees = new ArrayList<SubEmployee>();
}

//总公司经理
class CompanyManager {
	//总公司员工
	List<Employee> employeeList = new ArrayList<Employee>();
	//分公司员工
	List<SubEmployee> subEmployees = new ArrayList<SubEmployee>();
}