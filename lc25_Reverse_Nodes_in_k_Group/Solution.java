package lc25_Reverse_Nodes_in_k_Group;

class Solution{
    public ListNode reverseKGroup(ListNode head, int k) {
        // 在 linkedlist 中，以 k 個 node 為單位做 reverse
        // 如果剩下的 linkedlist長度 < k -> 不需要做 reverse
        // 找到要 reverse 的區間 -> reverse()
        ListNode tail = head;
        for(int i = 0; i < k; i++){
            if(tail.next == null) return head;
            tail = tail.next;
        }
        
        ListNode newList = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newList;
    }
    // reverse function: range of nodes
    private ListNode reverse(ListNode head, ListNode tail){
        ListNode prev = null;
        while(head != tail){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
    private ListNode build(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int val: arr){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    private String toStr(ListNode head){
        StringBuilder sb = new StringBuilder("[");
        while(head != null){
            sb.append(head.val);
            if(head.next != null){
                sb.append(",");
            }
            head = head.next;
        }
        return sb.append("]").toString();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        
        //tc1
        ListNode tc1 = sol.build(new int[]{1, 2, 3, 4,5});
        ListNode tc2 = sol.build(new int[]{1, 2, 3, 4,5});
        // expect: [2,1,4,3,5]
        System.out.println(sol.toStr(sol.reverseKGroup(tc1, 2)));
        // expect : [3,2,1,4,5]
        System.out.println(sol.toStr(sol.reverseKGroup(tc2, 3)));
    }
}