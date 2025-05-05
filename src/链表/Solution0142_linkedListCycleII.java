package 链表;

/**
 * 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class Solution0142_linkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // 设 a 为环外距离，b为环内距离 f,s为快慢指针第一次相遇的距离
        // f = 2s， f比s多走n个环的距离 f = s + nb
        // 得 s = nb，f = 2nb
        // 如何才能准确的走到入口呢，公式为 a 或者 a + nb;
        // 我们现在已经得出 s = nb，只需要再走a步，就一定能到环的入口。
        // 如何才能准确的走a步，答案是，重新从起点开始走，走a步的时候，会与slow在起点遇见
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;    
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}