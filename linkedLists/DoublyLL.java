/* Author: Shashank G
 * */

package DS;
public class DoublyLL{
	
	int size;
	private DNode first;
	private DNode last;
	private DNode curr_Node;
		
	public DoublyLL(){			
		first=last= null;
	}
	
	void addelements(int data){
		
		curr_Node = new DNode(data);
		
		if (first == null)				//list is empty
			{
				first = last = curr_Node;
				last.next = null ;  	// doubly linked list
				size++;
			}		
		
		else 
			{
				last.next = curr_Node;
				curr_Node.prev = last;
				last = curr_Node;
				last.next = null;	// //doubly linked list
				size++;
			}
		
		}	// end of addelements();
	
	void printdata()			// prints any list!
	{
		DNode count = first;
		for (int i=0;i<size;i++){
			System.out.println(count.getData());
			System.out.println();
			count = first.next;
			first = first.next;
			
		}
		
	}
}