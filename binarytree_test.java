/* Author: Shashank G
 * 
 * 
 * */
class binarytree_test{
	
	public static void main(String args[]){
	
		int [] x = new int [] {30,190,90,22,13,4,5,345,21,4,324,99,198};
		
		binarytree mytree = new binarytree();
		
		mytree.multiple_insert(x);
		
		System.out.println("\nPre-Order Traversal:");
		mytree.preorder_traversal(mytree.root);
		
		System.out.println("\nIn-Order Traversal:");
		mytree.inorder_traversal(mytree.root);
		
		System.out.println("\nPost-Order Traversal:");
		mytree.postorder_traversal(mytree.root);
		
		mytree.find(mytree.root, 12);
		
		//mytree.find(mytree.root, 132);	
	}
}