/* Author: Shashank G
 * */

package DS;
public class DNode {
		private int data;
		DNode next;
		DNode prev;
	
	public DNode(){					// default constructor
		data=0;
		next= null;
		prev = null;				//doubly LL
	}
	public DNode(int value){		// Creates node with data and next field.
		data = value;
		next = null;
		prev= null;					//doubly LL	
	}
	
	public int getData(){
		return this.data;
	}
	
	public int setData(int value){
		this.data = value;
		return this.data;
	}
	
} 	//end of class DNode 
	
