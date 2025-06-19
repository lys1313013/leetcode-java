# 动态规划

| 题目                                                         | 备注                   |
| ------------------------------------------------------------ | ---------------------- |
| [70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/)  | 注意前几个数不能进循环 |
| [198. 打家劫舍](https://leetcode.cn/problems/house-robber/)  |                        |
| [279. 完全平方数](https://leetcode.cn/problems/perfect-squares/) |                        |
| [322. 零钱兑换](https://leetcode.cn/problems/coin-change/)   |                        |
| [139. 单词拆分](https://leetcode.cn/problems/word-break/)    |                        |
| [300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/) |                        |
| [152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/) | 负负得正               |
| [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/) |                        |



# 二分

| 题目                                                         | 备注             |
| ------------------------------------------------------------ | ---------------- |
| [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/) | 让left一直保持比 |
|                                                              |                  |
|                                                              |                  |





# 链表

| 题目                                                         | 备注                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) | a+c+b == b+c+a                                               |
| [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) | 两个控制反转，一个临时变量记录下一节点位置                   |
| [234. 回文链表](https://leetcode.cn/problems/palindrome-linked-list/) | 1. 取出来判断<br>2. 快慢指针，翻转后半部分，然后一个从开头遍历，一个从中间遍历，太麻烦了。。。 |
| [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/) | 1. 快慢指针<br>2. 哈希表                                     |
| [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) | 1. 快慢指针+数学公式<br>2. 哈希表                            |
| [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) | 还得练。。。                                                 |
| [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/) | 原地相加                                                     |
| [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) | 要考虑前指针移出去的场景                                     |

# 二叉树



| 题目                                                         |      |
| ------------------------------------------------------------ | ---- |
| [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/) |      |
| [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/) |      |
| [226. 翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) |      |
| [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree/) |      |
| [543. 二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/) |      |
| [108. 将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/) |      |







# 贪心

| 题目                                                         | 备注                      |
| ------------------------------------------------------------ | ------------------------- |
| [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/) | 小于0就丢弃，sum重新置为0 |
| [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) |                           |
| [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/)      |                           |
| [45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) |                           |
| [763. 划分字母区间](https://leetcode.cn/problems/partition-labels/) |                           |



# 回溯

| 题目                                                         | 备注 |
| ------------------------------------------------------------ | ---- |
| [46. 全排列](https://leetcode.cn/problems/permutations/)     |      |
| [78. 子集](https://leetcode.cn/problems/subsets/)            |      |
| [17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) |      |
| [39. 组合总和](https://leetcode.cn/problems/combination-sum/) |      |
| [200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/) |      |
| [22. 括号生成](https://leetcode.cn/problems/generate-parentheses/) |      |

模板

```
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }
    for (选择 : 本层集合中的元素) {
        处理节点;
        backtracking(路径, 选择列表); // 递归
        撤销处理; // 回溯
    }
}
```



# 位运算

| 题目                                                         |      |
| ------------------------------------------------------------ | ---- |
| [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/) |      |
|                                                              |      |
|                                                              |      |

# 二维数组

| 题目                                                         |                          |
| ------------------------------------------------------------ | ------------------------ |
| [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges/) |                          |
| [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/) | 原地算法；O(1)空间复杂度 |
| [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)  |                          |
| [48. 旋转图像](https://leetcode.cn/problems/rotate-image/)   |                          |
| [240. 搜索二维矩阵 II](https://leetcode.cn/problems/search-a-2d-matrix-ii/) |                          |

# 栈

| 题目                                                         | 备注                         |
| ------------------------------------------------------------ | ---------------------------- |
| [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/) | Deque、push()、pop()、peek() |
| [155. 最小栈](https://leetcode.cn/problems/min-stack/)       | 使用辅助栈                   |
| [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/) | 注意pop完数据就被去除        |
| [3561. 移除相邻字符](https://leetcode.cn/problems/resulting-string-after-adjacent-removals/) |                              |

# 图

| 题目                                                         | 备注               |
| ------------------------------------------------------------ | ------------------ |
| [207. 课程表](https://leetcode.cn/problems/course-schedule/) | 入度为零时可以使用 |
| [210. 课程表 II](https://leetcode.cn/problems/course-schedule-ii/) |                    |
| [3558. 给边赋权值的方案数 I](https://leetcode.cn/problems/number-of-ways-to-assign-edge-weights-i/) |                    |
| [1857. 有向图中最大颜色值](https://leetcode.cn/problems/largest-color-value-in-a-directed-graph/) | 还得练             |



# 排序

| 题目                                                         | 备注                       |
| ------------------------------------------------------------ | -------------------------- |
| [56. 合并区间](https://leetcode.cn/problems/merge-intervals/) | 调用排序后，题目就好做多了 |
|                                                              |                            |
|                                                              |                            |



# 数组

| 题目                                                         | 备注            |
| ------------------------------------------------------------ | --------------- |
| [41. 缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/) | O(1) 空间复杂度 |
|                                                              |                 |
|                                                              |                 |

# 字符串

| 题目                                                         | 备注             |
| ------------------------------------------------------------ | ---------------- |
| [3403. 从盒子中找出字典序最大的字符串 I](https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/) | 需要注意边界条件 |
|                                                              |                  |
|                                                              |                  |



# 深度优先搜索

| 题目                                                         |                                            |
| ------------------------------------------------------------ | ------------------------------------------ |
| [1061. 按字典序排列最小的等效字符串](https://leetcode.cn/problems/lexicographically-smallest-equivalent-string/) | 有向图，每次都将最小的指向转换成更小的指向 |
|                                                              |                                            |
|                                                              |                                            |

