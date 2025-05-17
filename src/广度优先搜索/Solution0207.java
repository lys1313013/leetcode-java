package 广度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * #拓扑排序
 */
class Solution0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个课程的入度（需要前置课程的数量）
        int[] inDegree = new int[numCourses];
        // 记录哪些课程依赖这个课程
        List<Integer>[] postCourses = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            postCourses[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            // 入度+1 说明这个课程是需要前置课程
            inDegree[course]++;
            // 记录依赖该前置课程的课，后续前置课程完成后，就可以去看后续的课程是否可以学习
            postCourses[preCourse].add(course);
        }

        // 已完成课程的数量
        int sum = 0;
        Queue<Integer> finishQueue = new LinkedList<>();
        // 获取入度为0的课程（没有前置课程，可以直接学习的）
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                sum++;
                finishQueue.offer(i);
            }
        }

        while (finishQueue.size() > 0) {
            int preCourse = finishQueue.poll();
            List<Integer> postCourseList = postCourses[preCourse];
            for (Integer postCourse : postCourseList) {
                inDegree[postCourse]--;
                if (inDegree[postCourse] == 0) {
                    sum++;
                    finishQueue.offer(postCourse);
                }
            }
        }

        return numCourses == sum;
    }
    public static void main(String[] args) {
        Solution0207 solution = new Solution0207();
        int numCourses = 4;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}};
        boolean result = solution.canFinish(numCourses, prerequisites);
    }
}