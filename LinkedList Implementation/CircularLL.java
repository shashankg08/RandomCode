/* Author: Shashank G
 * */

package DS;
public class CircularLL{
	
	private static int size;
	private Node first;
	private Node last;
		
	public CircularLL(){			
		first=last= null;
	}
	
	public int getSize(){
		return size;
	}
	
	public void addelement(int data){
		
		Node curr_Node = new Node(data);
		if (first == null)					//list is empty
			{
				first = last = curr_Node;
				last.next = first ;  		// circular linked list
				size++;
			}		
		
		else 
			{
				last.next = curr_Node;
				last = curr_Node;
				last.next = first;			// circular linked list
				size++;
			}
		
		}	// end of addelement();
	
	public void addelements(int [] input){
		for (int d : input){
			addelement(d);
		}
	}
	
	public void printdata()			// prints any list!
	{
		Node count = first;
		for (int i=0;i<size;i++){
			
			System.out.println(i + "  Node address:" +count);
			System.out.println(count.getData());
			System.out.println(count.next);
			System.out.println(count.next.getData());
			System.out.println();
			count = first.next;
			first = first.next;
			
		}
		
	}
	
}// end of class listy
	


