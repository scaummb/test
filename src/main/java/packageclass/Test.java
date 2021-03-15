package packageclass;

/**
 * == 和 equals 差异比较demo
 *
 * @author moubin.mo
 * @date: 2020/1/1 11:27
 */

public class Test {
	public static void main(String[] args) {
		Long communityId1 = 10L;
		FamilyDTO family = new FamilyDTO();
		family.setCommunityId(10L);
		if (family.getCommunityId() == communityId1) {
			System.out.println("1 family1.getCommunityId() == communityId1 : true");
		} else {
			System.out.println("1 family1.getCommunityId() == communityId1 : false");
		}
		if (family.getCommunityId().equals(communityId1)) {
			System.out.println("1 family1.getCommunityId().equals(communityId1) : true");
		} else {
			System.out.println("1 family1.getCommunityId().equals(communityId1) : false");
		}

		Long communityId2 = 10000L;
		FamilyDTO family2 = new FamilyDTO();
		family2.setCommunityId(10000L);
		if (family2.getCommunityId() == communityId2) {
			System.out.println("2 family2.getCommunityId() == communityId1 : true");
		} else {
			System.out.println("2 family2.getCommunityId() == communityId1 : false");
		}

		if (family2.getCommunityId().equals(communityId2)) {
			System.out.println("2 family2.getCommunityId().equals(communityId1) : true");
		} else {
			System.out.println("2 family2.getCommunityId().equals(communityId1) : false");
		}


	}
}
