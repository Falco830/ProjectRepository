import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CousinTree {
	
	static Node root;
	static LinkedList<Node> queue = new LinkedList<Node>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node nd = new Node(23);	 
	      
		CousinTree bt = new CousinTree();
		
		bt.addNodeToNode(new Node(20));
		bt.addNodeToNode(new Node(23));
		bt.addNodeToNode(new Node(22));
		bt.addNodeToNode(new Node(21));
		bt.addNodeToNode(new Node(19));
		bt.addNodeToNode(new Node(17));
		bt.addNodeToNode(new Node(13));
		bt.addNodeToNode(new Node(18));
		bt.addNodeToNode(new Node(26));
		bt.addNodeToNode(new Node(24));
		bt.addNodeToNode(new Node(27));
		bt.addNodeToNode(new Node(25));
		
		BTreePrinter.printNode(root);
	    //BTreePrinter.printNode(test2());
		 Node Node1, Node2; 
	     Node1 = bt.root.left.left; 
	     Node2 = bt.root.right.right; 
	        if (bt.isCousin(bt.root, Node1, Node2)) {
	            System.out.println("Yes"); 
	        }
	        else {
	            System.out.println("No"); 
	        } 
		
		 System.out.println("Preorder traversal of binary tree is "); 
	        bt.printPreorder(root); 
	  
	        System.out.println("\nInorder traversal of binary tree is "); 
	        bt.printInorder(root); 
	  
	        System.out.println("\nPostorder traversal of binary tree is "); 
	        bt.printPostorder(root); 
			System.out.println();
			//bt.printTreeOrder(root);
		
	}
	 boolean isSibling(Node node, Node a, Node b) 
	    { 
	        // Base case 
	        if (node == null) 
	            return false; 
	  
	        return ((node.left == a && node.right == b) || 
	                (node.left == b && node.right == a) || 
	                isSibling(node.left, a, b) || 
	                isSibling(node.right, a, b)); 
	    } 
	 int level(Node node, Node ptr, int lev) 
	    { 
	        // base cases 
	        if (node == null) 
	            return 0; 
	  
	        if (node == ptr) 
	            return lev; 
	  
	        // Return level if Node is present in left subtree 
	        int l = level(node.left, ptr, lev + 1); 
	        if (l != 0) 
	            return l; 
	  
	        // Else search in right subtree 
	        return level(node.right, ptr, lev + 1); 
	    } 
	  
	    // Returns 1 if a and b are cousins, otherwise 0 
	    boolean isCousin(Node node, Node a, Node b) 
	    { 
	        // 1. The two Nodes should be on the same level 
	        //       in the binary tree. 
	        // 2. The two Nodes should not be siblings (means 
	        //    that they should not have the same parent 
	        //    Node). 
	        return ((level(node, a, 1) == level(node, b, 1)) && 
	                (!isSibling(node, a, b))); 
	    } 
	    
	void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.value + " "); 
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.value + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
 
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.value + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.left); 
  
        /* now recur on right subtree */
        printPreorder(node.right); 
    } 
    
    void printTreeOrder(Node node) 
    { 
        if (node == null) 
            return; 
        Node temp = root;
        Node temp2 = temp;
  
        System.out.println(temp.value);
        while(temp.left!=null) {
	        System.out.println("/" + " " + "\\");
	        System.out.print(temp.left.value);
	        while(temp2.right != null) {
	        	System.out.println(" " + temp.right.value);
	        }
	        temp = temp.left;
        }
        temp = root;
        while(temp.right!=null) {	     
	        System.out.println("/" + " " + "\\");
	        System.out.print(temp.left.value);
	        if(temp.right != null) {
	        	System.out.println(" " + temp.right.value);
	        }
	        temp = temp.left;
        }
        while(temp.right!=null) {	     
	        System.out.println("/" + " " + "\\");
	        System.out.print(temp.left.value + " " + temp.right.value);
	        temp = temp.right;
        }
  
        /* then print the data of node */
      //  System.out.print(node.value + " "); 
        //System.out.println("/");
        /* now recur on right child */
        /* first recur on left child */
     /*
        printTreeOrder(node.left);              
        printTreeOrder(node.right); 
        if(node.left != null) {
            System.out.print("/");
           }
        if(node.right != null) {
        	System.out.print("\\");
        }
      */
    } 
    
	private Node addNodeToNode(Node current) {
		
		Node temp = root;
		if(temp != null) {
			while(temp.value != 0) {
				//System.out.println("temp.value > current.value " + temp.value + " " + current.value );
				if(temp.value > current.value) {
					if(temp.left != null) {
						temp = temp.left;
						continue;
					}
						temp.left = current;
						return temp.left;
					
				}else {
					if(temp.right != null) {
						temp = temp.right;
						continue;
					}
						temp.right = current;
						return temp.right;					
				}
			}
		}else {
			root = current;		//if no root exists create new one
		}

		return current;
	}
	
}
class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}