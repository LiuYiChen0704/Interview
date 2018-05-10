package leetcode;

public class Insertion_sort_list {
	public void printList(ListNode h){
		while(h!=null){
			System.out.print(h.val+" ");
			h=h.next;
		}
		System.out.println("");
	}
	public ListNode push(int newdata,ListNode h){
		ListNode newnode=new ListNode(newdata);
		newnode.next=h;
		return newnode;
	}
	public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        else{
            ListNode i=head.next;
            ListNode tmp;
            ListNode j,jprev,iprev=head;
            while(i!=null){
            	printList(head);
                j=head;
                jprev=null;
                while(j!=null && j.val<=i.val&&j!=i){
                    jprev=j;
                    j=j.next;
                }
                if(j==i){
                    iprev=i;
                    i=i.next;
                }
                else{
                    if(jprev==null){
                            tmp=i.next;
                            iprev.next=tmp;
                            i.next=head;
                            head=i;
                            i=tmp;

                    }else{
                        tmp=i.next;
                        i.next=j;
                        jprev.next=i;
                        iprev.next=tmp;
                        i=tmp;
                    }
                }
                
                
            }
        }
        return head;
    }
	public static void main(String[] args) {
		Insertion_sort_list isl=new Insertion_sort_list();
		ListNode h=new ListNode(3);
		h.next=null;
		h=isl.push(1, h);
		h=isl.push(2, h);
		h=isl.push(4, h);
		//head.next=new ListNode(1);
		isl.printList(h);
		h=isl.insertionSortList(h);
		isl.printList(h);

	}

}
