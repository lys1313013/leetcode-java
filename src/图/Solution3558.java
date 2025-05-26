package 图;

import java.util.*;

/**
 * 3558. 给边赋权值的方案数 I
 */
class Solution3558 {
    public static final int MOD = 1_0000_0000_7;

    public int assignEdgeWeights(int[][] edges) {
        int[] inDegress = new int[edges.length + 2];
        List<Integer>[] affterList = new ArrayList[edges.length + 2];
        for (int i = 0; i < affterList.length; i++) {
            affterList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int start = edge[0];
            int end = edge[1];
            inDegress[end]++;
            affterList[start].add(end);
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> deque = new LinkedList<>();
        for (int i = 0; i < inDegress.length; i++) {
            if (inDegress[i] == 0) {
                deque.offer(i);
                map.put(i, 0);
            }
        }
        int max = 0;
        while (!deque.isEmpty()) {
            int index = deque.poll();
            for (int j = 0; j < affterList[index].size(); j++) {
                int end = affterList[index].get(j);
                inDegress[end]--;
                if (inDegress[end] == 0) {
                    deque.offer(end);
                }
                int depth = map.get(index) + 1;
                map.put(end, depth);
                max = Math.max(depth, max);
            }

        }

        return (int) pow(2, max - 1);
    }

    private long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }

}