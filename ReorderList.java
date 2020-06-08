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
class ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode curr = head;
        int len = 0;
        while(curr!=null){
            len++;
            s.push(curr);
            curr = curr.next;
        }
         curr = head;
        for(int i = 0 ; i<len && head!=null ; i++){
            if(i%2 == 0){
                ListNode node = s.pop();
                node.next = curr.next;
                curr.next = node;
                curr = curr.next;
            }
            else{
                curr = curr.next;
            }
        }
        if(curr!=null)
            curr.next = null;
    }
}
