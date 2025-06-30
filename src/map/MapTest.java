package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 12:17
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);

        // 遍历值
        for (int value : map.values()) {
            System.out.println(value);
        }
        // 遍历key
        for (int key : map.keySet()) {
            System.out.println(key);
        }

        int key = 1;
        // 判断是否包含
        if (map.containsKey(key)) {

        }

        map.getOrDefault(key, 0);
    }
}
