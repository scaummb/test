package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2019/10/25 17:25
 */

public class TestFileImport {

	private final static String PATH = "I:\\code\\test\\src\\main\\java\\file\\namespaceppaisecret.txt";
	private final static String PREFIX = "INSERT INTO eh_app_bind_wx_appid_secret_mapping (id, app_id, secret, namespace_id, status, create_time) VALUES ('";
	private final static String SUFFIX = "'1', '2019-10-24 16:53:26');";
	private static int index = 1;

	public static void main(String[] args) {
		File file = new File(PATH);
		ArrayList<AppidSecretObject> list = new ArrayList<>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine())!=null){
				String[] appidSecretObjectAttributes = line.split(",");
				AppidSecretObject appidSecretObject = new AppidSecretObject(appidSecretObjectAttributes[0],appidSecretObjectAttributes[1],appidSecretObjectAttributes[2]);
				list.add(appidSecretObject);
//				System.out.println(appidSecretObject.toString());
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			outOutAsSql(list);
		}
	}

	private static void outOutAsSql(ArrayList<AppidSecretObject> list) {
		list.stream().forEach(
				(appidSecretObject) -> {
					index++;
					buildSql(appidSecretObject, index);
				}
		);

	}

	private static void buildSql(AppidSecretObject appidSecretObject, int id) {
		StringBuffer sql = new StringBuffer();
		sql.append(PREFIX).append(id).append("',")
				.append("'").append(appidSecretObject.getAppid()).append("',")
				.append("'").append(appidSecretObject.getSecret()).append("',")
				.append("'").append(appidSecretObject.getNamespaceId()).append("',")
				.append(SUFFIX);
		System.out.println(sql);
	}
}
