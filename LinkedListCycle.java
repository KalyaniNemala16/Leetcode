/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode i = head;
        ListNode j = head;
        i = i.next;
        j = j.next.next;
        while(i != j && i!=null && j!=null && i.next != null && j.next != null){
            i = i.next;
            j = j.next.next;
        }
        if(i == j){
            i = head;
            while(i != j){
                i = i.next;
                j = j.next;
            }
            return true;
        }
        return false;
    }
}
