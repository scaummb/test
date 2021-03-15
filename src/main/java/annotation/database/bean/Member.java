package annotation.database.bean;

import annotation.database.annotation.Constraints;
import annotation.database.annotation.DBTable;
import annotation.database.annotation.SQLInteger;
import annotation.database.annotation.SQLString;

/**
 * <p>
 *
 * @author momoubin
 * @DBTable name ： 表名
 * 类的每个成员被注解修饰
 * @SQLString
 * @SQLInteger 数据库属性注解里面还嵌套了
 * </p>
 * @date 2020/5/16
 */
@DBTable(name = "MEMBER")
public class Member {
	@SQLString(20)
	String firstName;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;
	static int memberCount;

	@Override
	public String toString() {
		return handle;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}
}
