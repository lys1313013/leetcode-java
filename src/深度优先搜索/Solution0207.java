package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 */
class Solution0207 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        // 0 未搜索  1 搜索中 2 已搜索
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 搜索到处理“搜索中”状态的数据，存在环
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    public static void main(String[] args) {
        Solution0207 solution = new Solution0207();
        int numCourses = 4;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}};
        boolean result = solution.canFinish(numCourses, prerequisites);
    }
}