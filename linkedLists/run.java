/* Author: Shashank G
 * */

package DS;
class run{
	
	public static void main(String[] args) throws Exception{
		
		Linkedlist list = new Linkedlist ();
		
		int [] x = new int []{10,20,55,33,21,45,3};
		list.addelements(x);
		
		list.printdata();
		// recursion
		list.reverse(list.getFirst());
		System.out.println("** Reverse **");
		list.printdata();
		
		// iteration
		System.out.println("** Reverse **");
		list.ireverse();
		list.printdata();
	}
	
	}
	
