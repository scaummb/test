package Utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class PrintUtils {
    public static void printObjects (Object... objects){
        StringBuffer stringBuffer = new StringBuffer();
        if (!CollectionUtils.isEmpty(Arrays.asList(objects))){{
            List<Object> objectList = Arrays.asList(objects);
            objectList.stream().forEach(
                    object -> {
                        stringBuffer.append(JSON.toJSONString(object)).append(",");
                    }
            );
        }}
        System.out.println(stringBuffer.toString());
    }

}
