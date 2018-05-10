package Jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution {
	public String replaceSpace(StringBuffer str) {
		if (str == null)
			return null;
		int len = str.length();
		int spacenum = 0;
		for (int i = 0; i < len; i++)
			if (str.charAt(i) == ' ')
				spacenum++;
		len += 2 * spacenum;
		char[] newstr = new char[len];
		int oldp = str.length() - 1, newp = len - 1;
		while (newp >= 0 && oldp >= 0) {
			char c = str.charAt(oldp);
			if (c != ' ') {
				newstr[newp] = str.charAt(oldp);
				newp--;
			} else {
				newstr[newp] = '0';
				newstr[newp - 1] = '2';
				newstr[newp - 2] = '%';
				newp -= 3;
			}
			oldp--;
		}
		return String.valueOf(newstr);

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ListNode pNode=listNode;
		ArrayList<Integer> res=new ArrayList<Integer>();
		Stack<Integer> s=new Stack<Integer>();
		while(pNode!=null){
			s.push(pNode.val);
			pNode=pNode.next;
		}
		while(!s.isEmpty()){
			res.add(s.pop());
		}

		return res;
	}
	ArrayList<Integer> res=new ArrayList<Integer>();
	public ArrayList<Integer> printListFromTailToHead_recursive(ListNode listNode) {
		ListNode pNode=listNode;
		if(pNode!=null){
			printListFromTailToHead_recursive(pNode.next);
			res.add(pNode.val);
		}
		return res;
	}
	
	
	//两个栈实现队列
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty())
    			stack2.push(stack1.pop());
    	
    	}
    	return stack2.pop();
    	
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return null;
    }
    public int Fibonacci(int n) {
    	int[] arr=new int[n+1];
    	arr[0]=0;
    	arr[1]=1;
    	for(int i=3;i<=n;i++){
    		arr[i]=arr[i-1]+arr[i-2];
    	}
    	return arr[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode h=new ListNode(1);
		h.next=new ListNode(2);
		h.next.next=new ListNode(3);
		List<Integer> res=s.printListFromTailToHead(h);

	}

}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}