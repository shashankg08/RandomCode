/*Author: Shashank G
 */ 
package DS;

public class Node{
	private int data;
	public Node next;

	public Node(){				// default constructor
		data = 000;
		next = null;
	}

	public Node(int value){		// Creates node with data and next field.
		data = value;
		next = null;
	}
	
	public int getData(){		// getter
		return this.data;
	}
	
	public int setData(int value){
		this.data = value;
		return this.data;
	}

} 	//end of class Node 