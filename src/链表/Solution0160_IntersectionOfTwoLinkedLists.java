package 链表;


/**
 * 160. 相交链表
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 *
 */
public class Solution0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有公共节点，设公共节点到尾部的长度为c, headA公共节点前的长度为a, headB公共节点前的长度为b
        // A的长度为 a+c， B的长度为 b+c
        // 如果有公共节点，则 A走完 a+c+b B走完 b+c+a时会相遇
        // 如果没有公共节点，则A 走完a+0+b, B走完 b+0+a时，都会遇到null

        ListNode pA = headA, pB = headB;
        // 若两链表 有 公共尾部 (即 c>0 ) ：指针 A , B 同时指向「第一个公共节点」node 。
        // 若两链表 无 公共尾部 (即 c=0 ) ：指针 A , B 同时指向 null 。
        while (pA != pB) {
            if (pA == null) {
                // pA走到尽头 就走p的路
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                // pB走到尽头，就走A的路
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}