package integer.overlimit;

import convert.ConvertHelper;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moubin.mo
 * @date: 2020/11/6 09:27
 */

public class TestOverlimit {
	public static void main(String[] args) {
		EhConfigurations ehConfigurations = new EhConfigurations();
		ehConfigurations.setId(500000154L);
		ehConfigurations.setDescription("1231");
		ehConfigurations.setDisplayName("1231");
		ehConfigurations.setIsReadonly(1);
		ehConfigurations.setValue("1231");
		List<EhConfigurations> boList = new ArrayList();
		boList.add(ehConfigurations);
		List<ConfigurationsIdAdminDTO> list2 = boList.stream().map(r -> {
			//copy 相同属性下的值
			ConfigurationsIdAdminDTO dto = ConvertHelper.convert(r, ConfigurationsIdAdminDTO.class);
			return dto;
		}).collect(Collectors.toList());
		System.out.println(Integer.MAX_VALUE);
	}

	public static <T> T convert(Object src, Class<T> clzDst) {
		if (src == null) {
			return null;
		} else {
			try {
				T dst = clzDst.newInstance();
				BeanUtils.copyProperties(src, dst);
				return dst;
			} catch (IllegalAccessException | InstantiationException var3) {
				throw new RuntimeException(var3);
			}
		}
	}
}

