package Oct_17_2020;
/*24. 两两交换链表中的节点leetcode
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]*/
//linked list -> dummy
// two pointer
// taken node1 and node2 to record targetnodes
// time complex O(n) space complex O(1)

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            ListNode node1 = head.next;
            ListNode node2 = head.next.next;

            head.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            head = node1;
        }

        return dummy.next;
    }
}
