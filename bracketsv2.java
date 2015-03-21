/* Author: Shashank G
 * 
 * Validate brackets
 * Input is only brackets.
 * 
 * Test cases: ({[{}[]()]}) ; {{ ; }};
 * 				
 * */
import java.util.Stack;
import java.util.Hashtable;
import java.util.Scanner;

class bracketsv2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter brackets");
		
		String input = sc.nextLine();
		
		System.out.println(validate(input));
		
		sc.close();
		
	} // end of main
	
	private static boolean validate(String abc){
		
		// opening brace --> push in stack
		// closing brace --> pop from stack, check if it is as expected from table.
		
		// test case - 1 : Starts with a closing bracket [0]
		if (isClosingBrace(abc.toCharArray()[0])){
			System.out.println("Invalid brakets.");
			return false;
		}
		
		
		Stack<String> mystack = new Stack<String>();
		
		// mytable stores the accurate opening and closing bracke pairs.
		// on getting closing brace, we check if top bracket on stack is equal
		// to this accurate brace in table. If not, it is invalid.
		
		Hashtable<String,String> mytable= new Hashtable<String,String>();
		mytable.put("}", "{");
		mytable.put("]","[");
		mytable.put(")", "(");
		
		for (char a: abc.toCharArray()){
			
			if(isOpeningBrace(a)){
				mystack.push(Character.toString(a));
			}
			
			else if (isClosingBrace(a)){
				
				if (!mystack.empty()){
					String expected = mystack.pop();
				
				if (!expected.equals(mytable.get(Character.toString(a)))){	
						System.out.println("Invalid brakets.");
						return false;
					}
				}
				else{
					System.out.println("Invalid brakets.");
					return false;
				}
			}
				
		}// end of for loop
		
		if (mystack.isEmpty()){
			System.out.println("Brackets are valid! ");
			return true;
		}
		
		System.out.println("Invalid brakets.");
		return false;
		
	} 
	private static boolean isOpeningBrace(char x){
		return x == '{' || x =='[' || x == '('	;
	}
	
	private static boolean isClosingBrace(char y){
		return y == '}' || y ==']' || y == ')'	;
	}

}
