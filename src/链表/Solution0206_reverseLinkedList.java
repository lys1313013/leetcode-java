package 链表;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/description
 */
class Solution0206_reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 记录下一个节点位置
            ListNode next = cur.next;
            // 反转
            cur.next = pre;
            // 往下一步移动
            pre = cur;
            cur = next;
        }

        return pre;
    }
}