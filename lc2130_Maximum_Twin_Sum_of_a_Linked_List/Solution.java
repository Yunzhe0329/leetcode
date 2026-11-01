package lc2130_Maximum_Twin_Sum_of_a_Linked_List;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int result = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);

        ListNode first = head;
        ListNode second = slow;
        int pair_sum = 0;
        while (second != null) {
            pair_sum = first.val + second.val;
            result = Math.max(result, pair_sum);
            first = first.next;
            second = second.next;
        }

        return result;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
}