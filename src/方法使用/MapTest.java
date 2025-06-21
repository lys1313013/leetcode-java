package 方法使用;

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

        for (int value : map.values()) {
            System.out.println(value);
        }
    }
}
