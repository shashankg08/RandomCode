/*Author: Shashank G
 * 
 * LinkedList implementation.
 * 
 * Methods implemented:
 * 1. Add element
 * 2. Add elements (input array to linkedlist)
 * 3. reverse using recursion/ iteration
 * 4. search (int n)
 * 5. contains (Node n)
 * 6. delete (Node n)
 * 7. getPrevious(Node n)  given node n, returns previous node of n
 * 8. printdata() print contents.
 * 9. getSize() 
 * 
 * */
package DS;

public class Linkedlist{
	
	private static int size;
	private static Node first;
	private static Node last;
		
	public Linkedlist(){			
		first=last;
	}
	
	public Node getFirst(){
		return first;
	}
	
	void addelement(int data){
		
		Node curr_Node = new Node(data);
		if (first == null)							//list is empty
			{
				first = last = curr_Node;
				last.next = null ;  				// singly linked list
				size++;
			}		
		
		else 
			{
				last.next = curr_Node;
				last = curr_Node;
				last.next = null;					// singly linked list
				size++;
			}
		
		}	// end of addelement();
	
	// adds multiple elements.
	public void addelements(int [] data){
		for (int d : data){
			addelement(d);
		}
	}
	
	public void printdata()			// prints any list
	{
		for (Node count = first; count !=null; count = count.next){
			System.out.println(count.getData());
		
		}
	}
	
	// reverse linkedlist using recursion / Inplace;
	public void reverse(Node n){
		
		// Base case:
		if (n.next == null){
			first = n;
			return;
		}
		
		else{
			reverse(n.next);
			n.next.next = n;
			n.next = null;
			last = n;
		}
		
	}
	
	// Reverse using iteration : Inplace;
	public void ireverse(){
		
		if (first == null || last == first){
			return;
		}
		
		Node second = first.next;
		Node third = second.next;
		
		second.next = first;
		first.next = null;
		
		if (third == null){
			return;
		}
		
		Node currentNode = third;
		Node previousNode = second;
		
		while(currentNode != null){
			
			Node nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		
		}
		first = previousNode;
		
		return;
	}
	
	// returns size / length;
	public int getSize(){
		return size;
	}
	
	// search for a node of value n and returns it; returns null otherwise;
	public Node search(int n){	
		for (Node current = first; current!=null; current = current.next){
			if (current.getData() == n)
				return current;
		}
		return null;
	}
	
	
	public boolean contains(Node n){
		Node c = this.search(n.getData());
		if (c == null){
			return false;
		}
		return true;
	}
	
	// given a node, returns it's previous node;
	public Node getPrevious(Node n){
		
		// Use case:
		if (this.getFirst().getData() == n.getData()){
			return null;
		}
		
		Node previous = this.getFirst();
		
		for (Node current = this.getFirst(); current!=null; current = current.next){
		
			if (current.getData() == n.getData()){
				return previous;
			}
			previous = current;
		}
	
		return null;
	}
	
	
	// given a int value, delete it from linkedlist;
	public void delete(Node r){
		
		if (this.getFirst().getData() == r.getData()){
			first = first.next;
		}
		
		Node x = this.search(r.getData());
		
		if (x != null){
			Node prev = this.getPrevious(x);
			prev.next = x.next;
			x.next = null;
			return;
		}
		
		System.out.println("Node not in LinkedList");
	}
	
	
}// end of class Linkedlist
