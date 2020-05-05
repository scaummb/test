package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *     数组的流式处理：Arrays.stream
 * </p>
 * @author momoubin
 * @date 2020/5/5
 */
public class TestArrayStream {
    public static void main(String[] args) {
        String[] moduleIdList = {"111","222","333"};
        List<Long> moduleIds = Arrays.stream(moduleIdList)
                .map(moduleId -> Long.parseLong(moduleId.trim()))
                .collect(Collectors.toList());

        Arrays.stream(moduleIdList);
    }
}
