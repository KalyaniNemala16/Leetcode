import java.util.*;



public class LRUCache{

	static class Cache{
	class Node{
	Node prev,next;
	int val,key;
	Node(){
		prev = null;
		next = null;
	}
	Node(int key,int val){
	this.key = key;
	this.val = val;
	prev = null;
	next = null;
	}
	}

	 int capacity;
	 int size;
	 Node head,tail;
	 HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	Cache(int capacity){
	this.capacity = capacity;
	this.size = 0;
	head = new Node();
	tail = new Node();
	head.next = tail;
	tail.prev = head;
	}

	public  void put(int key, int val){
		if(!map.containsKey(key)){
			Node node = new Node(key,val);
			add(node);
			map.put(key,node);
			size++;

			if(size > capacity){
				Node r = removeTail();
				map.remove(r.key);
				size--;
			}
		}
		else{
			Node n = map.get(key);
			n.val = val;
			remove(n);
			add(n);
		}
	}

	public  int get(int key){
		if(!map.containsKey(key)){
			return -1;
		}
		else{
			Node n = map.get(key);
			remove(n);
			add(n);
			return n.val;
		}
	}

	public  void add(Node node){
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	public  void remove(Node node){
		Node node1 = node.prev;
		Node node2 = node.next;

		node1.next = node2;
		node2.prev = node1;

		node.prev = null;
		node.next = null; 

	}

	public  Node removeTail(){
		Node before = tail.prev;
		remove(before);
		return before;
	}

}

	public static void main(String args[]){
		Cache c = new Cache(2);

		c.put(1,1);
		c.put(2,2);
		System.out.println(c.get(1));
		c.put(3,3);
		System.out.println(c.get(2));
		c.put(4,4);
		System.out.println(c.get(1));
		System.out.println(c.get(3));
		System.out.println(c.get(4));
	}
}
