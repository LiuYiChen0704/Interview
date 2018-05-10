package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_tree_postorder_traversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		/***
        ArrayList<Integer> res=new ArrayList<Integer>();
        postrecursive(root,res);
        return res;
        ***/
		ArrayList<Integer> res=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.empty();
		return res;
		
		
    }
	
	public List<Integer> postorderTraversal2(TreeNode root) {

        
        //iteratively
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode p=root,r=null;
        while(p!=null || !stack.empty())
        {
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.peek();
            p=p.right;
            if(p!=null && p!=r){
                stack.push(p);
                p=p.left;
            }else{
                p=stack.pop();
                res.add(p.val);
                r=p;
                p=null;
            }
        }        
    	return res;
    }
    
    
    public void postrecursive(TreeNode root,ArrayList<Integer> res){
        if(root==null) return;
        else if(root.left==null&&root.right==null){
            res.add(root.val);
            return;
        }else{
            postrecursive(root.left,res);
        	postrecursive(root.right,res);
            res.add(root.val);
            return;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}