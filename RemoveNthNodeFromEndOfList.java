/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;
        if(s.next == null){
            head = null;
            return head;
        }
        for(int i = 0 ; i < n ; i++){
           f = f.next;
        }

        while(f!=null && f.next!=null){

            s = s.next;
            f = f.next;
        }
        if(f == null){
            s.val = s.next.val;
            s.next = s.next.next;
        }

        else{
          s.next = s.next.next;
        }

        return head;
    }
}
