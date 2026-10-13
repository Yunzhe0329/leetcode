package lc160_Intersection_of_Two_Linked_Lists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr_a = headA;
        ListNode curr_b = headB;
        // 兩指標各走 A + B 一次，總步數相同，所以會在交點（或同時在 null）相遇
        while (curr_a != curr_b) {
            curr_a = curr_a == null ? headB : curr_a.next;
            curr_b = curr_b == null ? headA : curr_b.next;
        }
        return curr_a;
    }

    public ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public String toStr(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 如果不用 common 建立交集的部分，會有問題(因為比較是比較 reference)，兩者即便有
        // 交集，也會被判斷是不同物件
        ListNode common = sol.build(new int[] { 8, 4, 5 });
        ListNode a1 = sol.build(new int[] { 4, 1 });
        a1.next.next = common;
        ListNode b1 = sol.build(new int[] { 5, 6, 1 });
        b1.next.next.next = common;
        ListNode result = sol.getIntersectionNode(a1, b1);
        IO.println(result == null ? "null" : result.val); // 8
        IO.println(sol.toStr(result)); // [8,4,5]

        // 不相交的情況
        ListNode a2 = sol.build(new int[] { 2, 6, 4 });
        ListNode b2 = sol.build(new int[] { 1, 5 });
        IO.println(sol.getIntersectionNode(a2, b2)); // null
    }
}