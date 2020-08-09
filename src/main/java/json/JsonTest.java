package json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import convert.ConvertHelper;
import json.dto.BuildingDTO;
import json.dto.BuildingDTOS;
import org.mortbay.util.ajax.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/8/6 20:55
 */

public class JsonTest {
	public static void main(String[] args) {
		String text = "{\"selected\":[{\"id\":\"239825274387485349\",\"apartmentName\":\"101\",\"livingStatus\":3,\"areaSize\":400,\"orientation\":\"南\",\"communityName\":\"演示小区Bc\",\"communityId\":\"240111044332061461\",\"buildingName\":\"1栋\",\"investmentType\":1}]}";

		HashMap map = (HashMap) JSON.parse(text);
		System.out.println(map);

		System.out.println(JSON.toString(map.get("selected")));
		BuildingDTOS selected = ConvertHelper.convert(map.get("selected"), BuildingDTOS.class);
		System.out.println(selected);

		String string = JSON.toString(map.get("selected"));
		JSONArray.parse(string);

		JSONObject jsonObject = JSONObject.parseObject(text);
		JSONArray jsonArray = (JSONArray)jsonObject.get("selected");
		List<BuildingDTO> dtos = (List<BuildingDTO>)JSONArray.parseArray(jsonArray.toString(), BuildingDTO.class);
		System.out.println(dtos);
		HashSet set = new HashSet();
		dtos.stream().forEach(dto -> set.add(dto.getId()));
		System.out.println(set);

	}
}
