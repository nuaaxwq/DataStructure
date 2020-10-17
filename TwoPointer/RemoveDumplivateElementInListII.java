package Oct_17_2020;
/*82. 删除排序链表中的重复元素 II leetcode
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3*/

//linkedList
// two pointer
// take left to save nondumplicate element(dummy)
// take right to traverse linkedlist(compare left.next.val ?= right.val)
// time complex O(n) space complex O(1)
public class RemoveDumplivateElementInListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftNode = dummy;
        ListNode rightNode = head.next;

        while(null != rightNode) {
            if (leftNode.next.val != rightNode.val) {
                leftNode = leftNode.next;
                rightNode = rightNode.next;
            } else {
                while (rightNode != null && rightNode.val == leftNode.next.val) {
                    rightNode = rightNode.next;
                }

                leftNode.next = rightNode;
                rightNode = (rightNode == null) ? null : rightNode.next;
            }
        }
        return dummy.next;
    }
}
