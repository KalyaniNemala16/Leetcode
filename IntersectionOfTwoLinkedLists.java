/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0; int len2=0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int jump;
        while(temp1!=null){
            len1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            len2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        if(len1>=len2){
        jump = len1-len2;
        for(int i = 0 ; i < jump; i++){
          temp1 = temp1.next;
        }
        }
        else{
            jump = len2-len1;
            for(int i = 0 ; i < jump; i++){
          temp2 = temp2.next;
        }
        }

        while(temp1!=temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1 == temp2) return temp1;
        return null;


    }
}
