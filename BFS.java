/* Author: Shashank G
 * 
 * Implement BFS for a given tree
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

class BFS {
	
	public static void main(String args[]){
		
		int [] x = new int []{30,190,90,22,13,4,5,345,21,4,324,99,198};
		
		binarytree mytree = new binarytree();
		
		binarytree.Node root = mytree.multiple_insert(x);
		
		System.out.println("\n*** BFS ***\n");
		
		// Do BFS
		BFS_traversal(root);

		
	}// end of main
	
	private static void BFS_traversal(binarytree.Node root){
		
		LinkedList<binarytree.Node> mylist = new LinkedList<binarytree.Node>();		// FIFO queue 
		
		HashSet<binarytree.Node> visited = new HashSet<binarytree.Node>();			// visited nodes
		
		mylist.add(root);
		
		while (mylist.size() > 0){
			
			binarytree.Node u = mylist.removeFirst();								// removing firstNode;
			
			if (!visited.contains(u)){												// not visited
				
				// process children / other nodes here
				for(binarytree.Node n : get_adjacentNodes(u)){
					
					if (!visited.contains(n)){										// add neighbor nodes
						mylist.add(n);			
					}					
				}
				
				// process this node here;
				System.out.println("Visiting node: "+ u.data);						// visiting
				visited.add(u);														// add to visited;
			}
			
		}// end of while
		
		System.out.println("\n*** End of BFS ***\n");
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
