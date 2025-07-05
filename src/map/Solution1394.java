package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1394. 找出数组中的幸运数
 */
class Solution1394 {
    public int findLucky(int[] arr) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (key == value) {
                ans = Math.max(ans, key);
            } 
        }

        return ans;
    }
}