package hashCode;

/**
 * @author moubin.mo
 * @date: 2020/4/12 13:00
 */

public class TestHashCodeGenerate {
	public static void main(String[] args) {
		String simpleName = "EhHelpCenterFilesStructures";
		int hash = simpleName.hashCode();
		long bucketHash = (long) hash + 4294967296L;
		System.out.println(bucketHash);
		long bucketId = bucketHash >> 10;
		String redisMapKey = "seq" + ":" + bucketId;
		System.out.println(redisMapKey);
	}
}
