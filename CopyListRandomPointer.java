import java.util.*;

public class CopyListRandomPointer{
static Node head;
static class Node{
int val;
Node next,random;
Node(int val){
  this.val = val;
  next = null;
  random = null;
}
Node(){
  next = null;
  random = null;
}
}

/*public void createLinkedList(int i){
  Node n = new Node(i);
  if(head == null){
    head = n;
  }
  else{
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = node;
  }
}*/
public Node deepCopy(Node head){
Map<Node,Node> map = new HashMap<Node,Node>();
Node copyHead = new Node();
Node orgList = head;
Node node = new Node(orgList.val);
copyHead = node;
map.put(orgList,copyHead);
orgList = orgList.next;

//Creates a deep copied linked list with original linked list's values
while(orgList != null){
  Node copyNode = new Node(orgList.val);
  if(copyHead == null){
    copyHead = copyNode;
  }
  else{
    Node temp = copyHead;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = copyNode;
  }
  map.put(orgList,copyNode);
  orgList = orgList.next;
}

//Assigning random nodes to the copied list
for(Node n : map.keySet()){
  Node copy = map.get(n);
  copy.random = map.get(n.random);
}

return copyHead;
}

public ArrayList<ArrayList<Integer> show(Node copyList){
ArrayList<ArrayList<Integer>  al = new ArrayList<ArrayList<Integer>();
  Node temp = copyList;
  while(temp != null){
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(temp.val);
    list.add(temp.random.val);
    al.add(list);
    temp = temp.next;
  }
  return al;
}
  public static void main(String args[]){
   CopyListRandomPointer c = new CopyListRandomPointer();
   head = new Node(7);
   head.next = new Node(13);
   head.next.next = new Node(11);
   head.next.next.next = new Node(10);
   head.random = head.next.next;
   head.next.random = head.next.next.next;
   head.next.next.random = head;
   Node copyList = c.deepCopy(head);
   System.out.pritnln(c.show(copyList));
  }
}
