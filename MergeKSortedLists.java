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
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode a,ListNode b){
                return a.val-b.val;
            }
        });


        for(ListNode l : lists){
            if(l!=null)
            pq.add(l);
        }
        if(pq.isEmpty()) return null;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
         ListNode next = curr.next;
            if(next!=null){
                pq.add(next);
            }
        }
        return head.next;
    }

}
