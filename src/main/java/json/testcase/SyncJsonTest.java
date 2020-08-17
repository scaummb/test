package json.testcase;

import com.alibaba.fastjson.JSON;

/**
 * @author moubin.mo
 * @date: 2020/8/13 10:19
 */

public class SyncJsonTest {
	public static void main(String[] args) {
		String jsonString = "{\"data\":[{\"contactName\":\" 联系人1号\",\"contactToken\":\" 18819467607\",\"id\":1048486,\"licenseEndDate\":1596643199000,\"licenseStartDate\":1597285261206,\"licenses\":[{\"createTime\":1597285261342,\"creatorUid\":1,\"customerId\":1048486,\"id\":1198,\"licenseEndDate\":1596643199000,\"licenseNo\":\"LICN20200813GLWT\",\"licenseStartDate\":1597285261206,\"namespaceId\":111111,\"operatorUid\":1,\"targetId\":999897,\"targetType\":1,\"updateTime\":1597285261342}],\"name\":\"深圳kyle物业公司2333333123122\",\"namespaceId\":111111,\"status\":1}],\"operationType\":\"create\"}";
		SyncData syncData = JSON.parseObject(jsonString, SyncData.class);
		syncData.getData().stream().forEach(
				r -> {
					OrganizationCustomerSyncData customerSyncData = JSON.toJavaObject((JSON)r, OrganizationCustomerSyncData.class);
					System.out.println(customerSyncData);
				}
		);

	}
}
