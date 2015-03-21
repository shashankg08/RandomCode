/* Author: Shashank G
 * 
 * Implement BFS for a given graph or tree
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

class DFS {
	
	public static void main(String args[]){
		
		int [] x = new int []{30,190,90,22,13,4,5,345,21,4,324,99,198};
		
		binarytree mytree = new binarytree();
		
		binarytree.Node root = mytree.multiple_insert(x);
		
		System.out.println("\n*** DFS ***\n");
		
		// Do BFS
		DFS_traversal(root);

		
	}// end of main
	
	private static void DFS_traversal(binarytree.Node root){
		
		Stack<binarytree.Node> mystack = new Stack<binarytree.Node>();				// LIFO for DFS
		
		HashSet<binarytree.Node> visited = new HashSet<binarytree.Node>();			// visited nodes
		
		mystack.push(root);
		
		while (!mystack.empty()){
			
			binarytree.Node u = mystack.pop();										// DFS --> LIFO;
			
			if (!visited.contains(u)){												// not visited
				
				// process children / other nodes here
				for(binarytree.Node n : get_adjacentNodes(u)){						// get adjacent nodes;
					
					if (!visited.contains(n)){										// add neighbor nodes
						mystack.push(n);			
					}					
				}
				
				// process this node here;
				System.out.println("Visiting node: "+ u.data);						// visiting
				visited.add(u);														// add to visited;
			}
			
		}// end of while
		
		System.out.println("\n*** End of DFS ***\n");
	}	// end of BFS
	
	
	private static ArrayList<binarytree.Node> get_adjacentNodes(binarytree.Node n){
		
		ArrayList<binarytree.Node> nlist = new ArrayList<binarytree.Node>();
		
		if(n.left!= null){
			nlist.add(n.left);
		}
		
		if (n.right!=null){
			nlist.add(n.right);
		}
		return nlist;	
	}
	
}	// end of class BFS
