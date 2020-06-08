/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode s = head;
        while(s!=null && s.next!=null){
            if(s.val == s.next.val){

                while(s.val == s.next.val && s.next!=null){
                    s.next = s.next.next;
                    if(s.next == null){
                    ListNode last = head;
                        ListNode prev = head;
                        while(last.val!=s.val){
                            prev = last;
                            last = last.next;
                        }
                        int x = last.val;
                        s.val = prev.val;
                        if(x == s.val)
                        {
                            s = null;
                            return s;
                        }
                        else{
                          s = null;
                            prev.next = null;
                            return head;
                        }
                }
                }

                   s.val = s.next.val;
                s.next = s.next.next;


            }
            else{
                s = s.next;
            }
        }
        return head;

    }
}
