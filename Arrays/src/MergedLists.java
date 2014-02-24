public class MergedLists
{
static class Node {
	public int value;
	public Node next;
	public Node() {
		value = 0;
		next = null;
	}
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}


	public static Node mergeLists(Node head1, Node head2) 
	{
		
		Node newHead=null;//return this

		if(head1==null && head2==null) //if both the lists are empty
			return null;
		if(head1==null || head2 == null) //if either list is empty return the other list
			return ((head2==null)?head1:head2);
		
		if(head1.value < head2.value) { // obtain the newHead to be returned.
			newHead = head1;
		}
		else {
			newHead = head2;
			head2 = head1;
			head1 = newHead;
		}
		 
		// we make sure head1 is the starting point from the smaller of either lists.
		// and check if head2 fits between head1 and head1.next so the condition is head1.next should
		// not be null and head2 should not be null
		while(head1.next!=null)
		{
			if(head2==null)
			{
				break;
			}
			if(head1.next.value>head2.value) //if the second list contains the smaller element
			{
				Node temp = head2;
				head2 = head1.next;
				head1.next = temp;
			}
			else {
				head1 = head1.next;
			}
		}
		
		// if head1 
		
		if(head1.next==null)  //if the first list runs out and second list has elements left
		{
			head1.next = head2;
		}
		return newHead;  
	}
	public static void main(String []args)
	{
		//Node mObj= new Node();

		Node h3=new Node(17,null);
		Node h2=new Node(15,h3);
		Node head1=new Node(11,h2);
		
		
		Node h4=new Node(5,null);
		Node h5=new Node(4,h4);
		Node head2=new Node(2,h5);
		
		Node temp=	MergedLists.mergeLists(head1, head2);
	

	/*	sll head2=new sll(9);
		head2.next=new sll(12);
		head2.next.next=new sll(15);
		head2.next.next.next=new sll(19);
		head2.next.next.next.next=new sll(20);
		head2.next.next.next.next.next=new sll(21);
		head2.next.next.next.next.next.next=new sll(22);
*/
		while(temp!=null)
		{
			System.out.println(temp.value);
			temp=temp.next;
		}
	}
}

