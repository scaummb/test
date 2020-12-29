package stream.test_stream_convert;

import convert.ConvertHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moubin.mo
 * @date: 2020/12/29 15:56
 */

public class TestStreamConvert {
	public static void main(String[] args) {
		EnterpriseApprovalGroup group1 = new EnterpriseApprovalGroup();
		EnterpriseApprovalGroup group2 = new EnterpriseApprovalGroup();
		EnterpriseApprovalGroup group3 = new EnterpriseApprovalGroup();
		EnterpriseApprovalGroup group4 = new EnterpriseApprovalGroup();
		group1.setName("1");
		group2.setName("2");
		group3.setName("3");
		group4.setName("4");
		ArrayList<EnterpriseApprovalGroup> list = new ArrayList<>();
		list.addAll(Arrays.asList(group1,group2,group3,group4));
		List<EhEnterpriseApprovalGroups> result = list.stream().map(
				group -> {
					group1.setId(1L);
					return ConvertHelper.convert(group, EhEnterpriseApprovalGroups.class);
				}
		).collect(Collectors.toList());

		System.out.println(list.toString());
		System.out.println(result.toString());
	}
}
