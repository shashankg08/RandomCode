/* Author: Shashank G
 * 
 * Implemented a binary tree and tree traversal: Preorder, Inorder and Postorder.
 * Also implemented a method to construct b tree from inpur array.
 * 
 * */
public class binarytree {
	
	Node root;
	
	public class Node {	
		
		Object data;
		Node left = null;
		Node right = null;
		
		public Node(){
			this.data = 00000;
		}
		public Node(int data){
			this.data = data;
		}
		
	}	// end of Node class
	
	static short lastInserted = 0;					// if 0 --> insert at left
									// if 1 --> insert at right
	public void insert(Node start, int x){
		// Rule: Insert left first, then right.
		// Using lastInserted still give unbalanced tree.
		// However it is better than before.
		// Avoid a tree being left heavy. little balanced;
		
		binarytree mytree = new binarytree();			// need this instance to reach Node class.
		Node node = mytree.new Node(x);
		Node parent = mytree.new Node();			// keeps track of intermediate parent.
		
		if (root == null){
			start = root = node;
			parent = root;
			System.out.println("Inserted Node at root:  "+ node.data);
			return;
		}
		
		// if leaf node, go left. --> BUILDS LEFT HEAVY TREE
		if (start.left != null && start.right != null){
			parent = start;					// parent pointer
			
			if (lastInserted == 0){
				insert(start.left, x);		
				lastInserted = 1;			// make changes here for building better tree;
			}
			else if (lastInserted == 1){
				insert(start.right, x);
				lastInserted = 0;
			}
		}
		
		if (start.left == null){
			parent = start;
			start.left = node;
			System.out.println("Inserted Node at left of "+parent.data+" : "+ node.data);
			return;
		}
		if(start.right == null){
			parent = start;
			start.right = node;
			System.out.println("Inserted Node at right of "+parent.data+" : "+ node.data);
			return;
		}
		
	}	// end of insert
	
	public Node multiple_insert(int[] input_array){
		// populates tree from an input array;
		for (int a: input_array){
			insert(root,a);
		}
		return root;
	}
	
	public void preorder_traversal(Node start){
		
		// Preorder traversal.
		System.out.println(start.data);
		
		if (start.left != null)
			preorder_traversal(start.left);
		
		if (start.right != null)
			preorder_traversal(start.right);
		
		return;
	}// end of traverse
	
	public void inorder_traversal(Node start){
		
		// Inorder traversal
		if (start.left != null)
			inorder_traversal(start.left);
		
		System.out.println(start.data);
		
		if(start.right != null)
			inorder_traversal(start.right);
		
	}
	
	public void postorder_traversal(Node start){
		
		// Post order traversal
		if (start.left != null)
			postorder_traversal(start.left);
		
		if (start.right != null)
			postorder_traversal(start.right);
		
		System.out.println(start.data);
		
	}
	
	// Performs search in binary tree using pre-order traversal.
	// Can use post-order or in-order as well.
	
	static boolean found = false;
	static int checks = 0;
	
	public boolean find(binarytree.Node x, int value){
		
		// base case
		if ( (int) x.data == value){
			System.out.println("Found element in tree: " + x.data);
			found = true;
			return true;
		}
		
		// goes left subtree without checking right subtree. --> Left Heavy.
		if (x.left != null){
			checks+=1;
			find(x.left, value);
		}
		
		// has right child and element has not yet been found in all left nodes.
		if(x.right!=null && (!found)){
			checks+=1;
			find(x.right,value);
		}
		
		//System.out.println("Total Nodes hopped in tree: "+checks);
		return found;
		
	}	// end of find
}
