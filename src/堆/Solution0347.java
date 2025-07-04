package 堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 */
class Solution0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(cnt::get));
        for (int key : cnt.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (cnt.get(key) > cnt.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.remove();
        }
        return ans;
    }
}