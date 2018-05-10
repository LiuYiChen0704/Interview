package common;
//BST
public class BinarySearchTree {
	class Node{
		int key;
		Node left,right;
		
		public Node(int item){
			key=item;
			left=right=null;
		}
	}
	
	Node root;
	public BinarySearchTree() {
		root=null;
	}
	void insert(int key){
		root=insertRec(root,key);
	}
	Node insertRec(Node root,int key){
		if(root==null){
			root=new Node(key);
			return root;
		}
		if(key<root.key)
				root.left=insertRec(root.left,key);
		else if(key>root.key)
				root.right=insertRec(root.right,key);
		
		return root;
	}
	void inorder(){
		inorderRec(root);
	}
	void inorderRec(Node root){
		if(root!=null){
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	void deleteKey(int key){
		root=deleteRec(root,key);
	}
	Node deleteRec(Node root,int key){
		/* Base Case: If the tree is empty */
		if(root==null){
			return root;
		}else{
			if(key<root.key)root.left=deleteRec(root.left, key);
			else if(key>root.key)root.right=deleteRec(root.right, key);
			else{
				//// node with only one child or no child
				if(root.left==null)
					return root.right;
				else if(root.right==null)
					return root.left;
				// node with two children: Get the inorder successor (smallest
	            // in the right subtree)
					root.key=minValue(root.right);
				// Delete the inorder successor
					root.right=deleteRec(root.right,root.key);
				
			}
		}
		return root;
	}
	int minValue(Node root){
		int minv=root.key;
		while(root.left!=null){
			root=root.left;
			minv=root.key;
		}
		return minv;
	}
	void secondLargest(Node root){
		secondLargestUtil(root);
	}
	static int cnt=0;
	void secondLargestUtil(Node root){
		if(root==null||cnt>2){
			return ;
		}
		else{
			secondLargestUtil(root.right);
			
			cnt++;
			
			if(cnt==2){
				System.out.print("2nd largest element is "+root.key);
				return;
			}
			secondLargestUtil(root.left);
		}
	}
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
        tree.secondLargest(tree.root);
 
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        cnt=0;
        tree.secondLargest(tree.root);
	}

}
