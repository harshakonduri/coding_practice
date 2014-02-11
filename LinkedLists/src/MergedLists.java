
public class MergedLists {
	public static class Node {
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
	     
    /*
      return : The Head of newly merged LinkedList
        
      Assumption : I will be sorting the List in non-decreasing order.

      Approach :  
           I will use the 2 pointers to each of the LinkedLists 
and identify the smaller of the 2 pointers and detach the original list and move its
corresponding pointer forward. 
Then attach the second list to the smaller Node. 
At the end of each iteration we will still have 2 lists with sorted Nodes.

Invariance : At any point in the execution, always the nodes before the current position
   of the mergedList will be merged in sorted increasing order.
    Example :
    List 1 head1 : 1-2-3-4
    List 2 head2 : 1-3-5-7
    
    Iteration 1 : head1.value <= head2.value 
    head1 : 1-1-3-5-7
    head2 : 2-3-4
    
    Iteration 2 : head1.value < head2.value
    head1 : 1-1-2-3-4
    head2 : 3-4
    
    Iteration 3: head1.value < head2.value
    head1 : 1-1-2-3-4
    head2 : 3-4;
    
    Iteration 4: head1.value <= head2.value
    head1 : 1-1-2-3-3-4;
    head2 : 4
    
    Iteration 5: head1.value < head2.value
    head1 : 1-1-2-3-3-4;
    head2 : 4;
    
    Iteration 4: head1.value <= head2.value
    head1 : 1-1-2-3-3-4-4;
    head2 : null

Termination : since head2 is null end the loop and return the mergedHead

    */
    public static Node mergeLists(Node head1, Node head2) {
        if((null == head1) || (null == head2)) {
            // check if either of the 2 nodes are null, if they are return the non-null
            // Node as the new Head.
            return (null == head1)?head2:head1;
        }
        // return this new Node as the merged Head of the two lists.
        
	    Node mergedHead = null;
        
        if(head1.value <= head2.value) {
            mergedHead = head1;
        }
        else {
            mergedHead = head2;
        }
        // use a temporary Node to store the next value for the head pointers
        // in case of changing next pointers during merge.
        Node temp = null;
        
        //loop invariance checks that neither of the two pointers are null
        //in which case we terminate the loop.
        while((null != head1) && (null != head2)) {
            if(head1.value <= head2.value) {
                //check that head2's value lies between head1 and head1.next;
                if(null!=head1.next && head1.next.value > head2.value){
	        	    temp = head1.next;// store the next value of head1
    	        	head1.next = head2; // link list2 to head1
        	    	head1 = head1.next; // move head1 its next value
		            head2 = temp; // move head 2 to the unlinked value of head1
		        }//end inner if
                else {
                    // if we reach here, either the next pointer of head1 is null
                    // we check and just link the rest of head2 to next pointer and
                    // terminate the loop.
                    // or just move head1 forward.
        			if(head1.next == null){
		    		head1.next = head2;
			    	break;
        			}else {	
		    		head1 = head1.next;
			        }
                }
            }//end if
            else if(head2.value < head1.value) {
            // we perform just the reverse of what is done above.
        		if((null!=head2.next && head2.next.value > head1.value)) {
		            temp = head2.next;
            		head2.next = head1;
    		        head1 = temp;
        		    head2 = head2.next; 		
		        }//end inner if
        		else {
		        	if(head2.next == null){
				        head2.next = head1;
        				break;
		        	}
        			else { 
		        		head2 = head2.next;
        			}
		        }//end if
            }//end outer if
        }//end while
        return mergedHead;
    }
}