package common;

import java.util.Stack;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	void printPostorder(Node node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key + " ");
	}
	void printPostorderwithoutRecursion(Node root) {
		if (root == null)
			return;
		Stack<Node> stack=new Stack<Node>();
		Node current,pre=null;
		stack.push(root);
		while(!stack.isEmpty()){
			current=stack.peek();
			if((current.left==null&&current.right==null)||
					(pre!=null&&(pre==current.left||pre==current.right))){
////假设当前结点没有孩子结点或者孩子节点都已被訪问过 
				System.out.print(current.key+" ");
				stack.pop();
				pre=current;
			}else{
				if(current.right!=null)
					stack.push(current.right);
				if(current.left!=null)
					stack.push(current.left);
			}
		}
	}

	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}

	void printInorderwithoutRecursion(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		Node current = root;
		while (current != null || !s.isEmpty()) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}

			if (!s.isEmpty()) {
				Node p = s.pop();
				System.out.print(p.key + " ");
				current = p.right;
			}
		}

	}

	void printPreorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	void printPreorderwithoutRecursion(Node root) {
		if (root == null)
			return;
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				System.out.print(current.key + " ");
				stack.push(current);
				current = current.left;
			} else
				current = stack.pop().right;

		}
	}

	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();
		System.out.println("\nPreorder traversal of binary tree without Recursion is ");
		tree.printPreorderwithoutRecursion(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();
		System.out.println("\nInorder traversal of binary tree without Recursion is ");
		tree.printInorderwithoutRecursion(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
		System.out.println("\nPostorder traversal of binary tree without Recursion is ");
		tree.printPostorderwithoutRecursion(tree.root);
	}

}
