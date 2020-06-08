/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode newlist = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1==null){
            dummy.next = l2;
        }
        else{
            dummy.next = l1;
        }

        return newlist.next;
    }
}
