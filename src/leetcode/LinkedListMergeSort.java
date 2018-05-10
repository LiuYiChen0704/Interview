package leetcode;

//Java program to illustrate merge sorted
//of linkedList



public class LinkedListMergeSort {
	ListNode head = null;
	
	public ListNode getMiddle(ListNode h){
		ListNode middle=null;
		if(h==null || h.next==null)middle=h;
		else{
			int listlen=0;
			ListNode s=h;
			while(s!=null){
				listlen++;
				s=s.next;
			}
			middle=h;
			int minx=listlen/2;
			while(minx-->1){
				middle=middle.next;
			}
		}
		return middle;
	}
	public ListNode getMiddle_Advanced(ListNode h){
		ListNode middle=null;
		if(h==null || h.next==null)middle=h;
		else{
			ListNode fastptr=h.next;
			ListNode slowptr=h;
			while(fastptr!=null){
				fastptr=fastptr.next;
				if(fastptr!=null){
					fastptr=fastptr.next;
					slowptr=slowptr.next;
				}
			}
			middle=slowptr;
		}
		return middle;
	}
	public ListNode mergeSort(ListNode h){
		if(h==null ||h.next==null ) return h;
		ListNode middle=getMiddle_Advanced(h);
		ListNode righth=middle.next;
		ListNode lefth=h;
		middle.next=null;
		ListNode a=mergeSort(lefth);
		ListNode b=mergeSort(righth);
		ListNode sortedlist=SortedMerge(a,b);
		return sortedlist;
	}
	
	public ListNode SortedMerge(ListNode a,ListNode b){
		ListNode h=null;
		if(a==null&&b!=null) h=b;
		else if(a!=null&&b==null) h=a;
		else if(a==null&&b==null) h=null;
		else{//a!=null&&b!=null
			if(a.val<b.val){
				h=a;
				h.next=SortedMerge(a.next, b);
			}
			else{
				h=b;
				h.next=SortedMerge(a, b.next);
			}
		}
		return h;
	}
	
	public ListNode sortList(ListNode head) {
		ListNode res=null;
		res=mergeSort(head);
		return res;
	}
	public ListNode push(int newdata,ListNode h){
		ListNode newnode=new ListNode(newdata);
		newnode.next=h;
		return newnode;
	}
	public void printList(ListNode h){
		while(h!=null){
			System.out.print(h.val+" ");
			h=h.next;
		}
	}
	public static void main(String[] args) {
		LinkedListMergeSort llm=new LinkedListMergeSort();
		
		ListNode h=new ListNode(15);
		h.next=null;
		h=llm.push(10, h);
		h=llm.push(5, h);
		h=llm.push(20, h);
		h=llm.push(3, h);
		h=llm.push(2, h);
		
		ListNode newh=llm.mergeSort(h);
		llm.printList(h);
		
	}

}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	
}