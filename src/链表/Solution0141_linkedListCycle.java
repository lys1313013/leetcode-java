package 链表;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/
 */
public class Solution0141_linkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head ==  null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            // 这里是为了在第一次套圈的时候就逮住慢指针
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return false;

    }
}