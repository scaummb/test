package json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/8/31 23:26
 */

public class TestGson {

	private static Gson gson = new Gson();

	public static void main(String[] args) {
		EnterpriseApprovalLogDTO newApprovalLogDTO = new EnterpriseApprovalLogDTO();
		newApprovalLogDTO.setName("123123");
		newApprovalLogDTO.setGroupName("123123");
		newApprovalLogDTO.setSortNum(1);
		String s = gson.toJson(newApprovalLogDTO);
		Map map = gson.fromJson(s, Map.class);
		System.out.println(map);

		Gson gson1 = new GsonBuilder().create();
		Gson gson2 = getGson();
		System.out.println("gson1: "+gson1.fromJson(s,new TypeToken<Map<String,Object>>(){}.getType()));
		System.out.println("gson2: "+gson2.fromJson(s,new TypeToken<Map<String,Object>>(){}.getType()));
	}

	public static Gson getGson() {
		Gson gson = new GsonBuilder().create();
		try {
			Field factories = Gson.class.getDeclaredField("factories");
			factories.setAccessible(true);
			Object o = factories.get(gson);
			Class<?>[] declaredClasses = Collections.class.getDeclaredClasses();
			for (Class c : declaredClasses) {
				if ("java.util.Collections$UnmodifiableList".equals(c.getName())) {
					Field listField = c.getDeclaredField("list");
					listField.setAccessible(true);
					List<TypeAdapterFactory> list = (List<TypeAdapterFactory>) listField.get(o);
					int i = list.indexOf(ObjectTypeAdapter.FACTORY);
					list.set(i, MapTypeAdapter.FACTORY);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson;
	}
}

class EnterpriseApprovalLogDTO {
	private String name;
	private String scope;
	private String groupName;
	private Integer sortNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
}
