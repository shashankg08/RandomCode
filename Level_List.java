/* Author: Shashank G
 * 
 *  Given a graph or a tree, build linkedlist for all nodes that belong to each level;
 * 
 *  For n levels --> there will be n linkedLists;
 *  
 *  Using BFS
 * 
 * */
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

class Level_List {
	
	public static void main(String args[]){
		
		// build random tree
		int [] x = new int []{30,190,90,22,13,99,4,5,345,99,223,21,4,324,99,198,9999};
		binarytree mytree = new binarytree();
		binarytree.Node root = mytree.multiple_insert(x);	
		
		ArrayList<LinkedList<binarytree.Node>> lists = get_level_lists(root);
		
		System.out.println("\nNumber of levels in tree: "+lists.size()+"\n");
		
		int count = 0;
		for (LinkedList<binarytree.Node> l : lists){
			System.out.println("Level:"+count);
			printList(l);
			System.out.println("\n");
			count++;
			
		}
		
		
	}
	
	private static ArrayList<LinkedList<binarytree.Node>> get_level_lists(binarytree.Node root){
		
		// Collection to store all linkedLists; One for each level;
		ArrayList<LinkedList<binarytree.Node>> lists_collection = new ArrayList<LinkedList<binarytree.Node>>();
		
		HashSet<binarytree.Node> visited = new HashSet<binarytree.Node>();
		
		LinkedList<binarytree.Node> level_list = new LinkedList<binarytree.Node>();
		
		level_list.add(root);							// keeps track of all nodes in one level
		
		int level = 0;									// stores level
		
		lists_collection.add(level, level_list);		// key step: Index corresponds to level number;
				
		while (true){
			
			level_list = new LinkedList<binarytree.Node> ();
			for (int i = 0; i < lists_collection.get(level).size(); i++ ){
				
				binarytree.Node node = lists_collection.get(level).get(i);		// internal nodes of each level linked lists;
				
				if (node != null && !visited.contains(node)){
					if (node.left != null) 
						level_list.add(node.left);
					if (node.right != null)
						level_list.add(node.right);
					visited.add(node);	
				}
			} // end of for loop		
		
			if (level_list.size() > 0){
				lists_collection.add(level + 1, level_list);
			}
			else{
				break;															// no more leaf nodes;
			}
			
			level++;
		
		}																		// end of while	
		return lists_collection;
		
	}	// end of get_level_lists
	
	
	// Iterate over a linkedList
	public static void printList(LinkedList<binarytree.Node> a){
		
		Iterator<binarytree.Node> iter = a.iterator();
		
		while(iter.hasNext()){
			System.out.print("Node: "+iter.next().data+"  ");
		}
		
		
	}
	 
}
