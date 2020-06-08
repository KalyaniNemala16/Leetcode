/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(f!=null && f.next!=null){
            stack.push(s.val);
            s = s.next;
            f = f.next.next;
        }
        if(f!=null){
            s = s.next;
        }

        while(s!=null){
            if(stack.pop()==s.val){
                s=s.next;
            }
            else return false;
        }
        return true;
    }
}
