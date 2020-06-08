/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null|| head.next == null) return head;
      ListNode head1 = null;
        ListNode head2 = null;
        ListNode temp = head;
        ListNode curr1 = null;
        ListNode curr2 = null;

        while(temp!=null){
            if(temp.val<x){
             curr1 = new ListNode(temp.val);
              if(head1 == null) {
                head1 = curr1;
              }
                else{
                    ListNode flag1 = head1;
                    while(flag1.next!=null){
                        flag1 = flag1.next;
                    }
                    flag1.next = curr1;
                }
            }
            else{
                curr2 = new ListNode(temp.val);
              if(head2 == null) {
                head2 = curr2;
              }
                else{
                    ListNode flag2 = head2;
                    while(flag2.next!=null){
                        flag2 = flag2.next;
                    }
                    flag2.next = curr2;
                }
            }
            temp = temp.next;
        }
       if(head2 == null) return head1;
        else if(head1 == null) return head2;
        else curr1.next = head2;
        return head1;
    }
}
