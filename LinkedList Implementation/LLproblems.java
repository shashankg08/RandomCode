/*Author: Shashank G
 * 
 * Problems:
 * 1. Find middle of linkedlist in O(N);
 * 2. Find nth element from last node in O(N);
 */ 

package problems;

import DS.Linkedlist;
import DS.Node;

public class LLproblems {

	// get nth element from last node in O(n);
	private static int get_last_n(Linkedlist list, int n){

		// Use case
		if (n > list.getSize() || n <= 0){
			System.out.println("Invalid Input for n ");
			return -909;
		}

		// set fast pointer/ window
		Node fast_one = list.getFirst();
		for (int i = 1; i<=n; i++){
			fast_one = fast_one.next;
		}

		Node one;
		for (one = list.getFirst(); fast_one!=null; one = one.next){
			fast_one = fast_one.next;
		}	
		return one.getData();
	}

	// find middle of linkedlist in O(n)
	private static Node getMiddle(Linkedlist list){

		Node fast_pointer = list.getFirst();
		Node slow_pointer = fast_pointer;

		while(fast_pointer != null){
			fast_pointer = movePointer(fast_pointer, 2);
			if (fast_pointer != null){
				slow_pointer = movePointer(slow_pointer,1);

			}
		}

		return slow_pointer;
	}

	// Helper method; Moves pointer by n;
	private static Node movePointer(Node pointer, int n){
		for (int i = 1 ; i<=n && pointer != null; i++){
			pointer = pointer.next;
		}
		return pointer;
	}
		
	public static void main(String args[]){
		
		Linkedlist mylist = new Linkedlist();
		int [] a = new int []{10,2,90,1,69,45,99};
		mylist.addelements(a);
		
		System.out.println("*** LinkedList Elements ***");
		mylist.printdata();
		System.out.println();
		
		System.out.println("*** Nth Last Element ***");
		System.out.println(get_last_n(mylist,2));
		System.out.println();
		
		System.out.println("*** Middle Element ***");
		System.out.println(getMiddle(mylist).getData());
		System.out.println();
		
		mylist.delete(new Node(2));
		mylist.printdata();
		
		System.out.println(mylist.contains(new Node(45)));
		
	}
	
}
