public class ListLoopQuestion {
  public static class ListNode {
    public int value;
    public ListNode next;
  }
 
  /**
    
     return : true if the List given has a cycle or 
     return false
     
     I will solve this problem using 2 pointers, slowPointer and fastPointer where the 
    slowPointer will move one step at a time and the fastPointer will move 2 steps at a
    time.
    
    If there is a Loop present in the list then both the slowPointer and fastPointer 
    will meet at some point inside the Loop.

    Big O Analysis : This operation will take O(n) time and O(1) space.
    If there is no loop the fastPointer will reach the end of the list in O(n/2) which
    is O(n) and if a loop exists then the fastPointer will meet the slowPointer 
    before it completes one Loop cycle O(n) where n is the total length including the
    length of the loop.
    
  */
  public static boolean hasLoops( ListNode myList ) {
      if((null == myList) || (null == myList.next)) { // check if List has 0 or 1 nodes.
          return false;
      }
      
      // Declaration of slowPointer and fastPointer, assigned to head of the List.
      
      ListNode slowPointer = myList,fastPointer = myList;
      
      while(null != fastPointer) { // if there is no Loop the fastPointer will end first
                    
          fastPointer = fastPointer.next; // move the fastPointer one step.
          
          if(null == fastPointer) { // check for null after moving one step.
              return false;
          }//end if
          
          // move fastPointer one more step = 2 steps in 1 while loop iteration.
          // move slowPointer one step = 1 step in 1 while loop iteration.
          
          fastPointer = fastPointer.next;
          slowPointer = slowPointer.next;
          
          if(slowPointer == fastPointer) { // if they meet it means we have detected a loop
              return true;
          }//end if
          
      }//end while
      
      //if this code is reached it means we do not have a loop since if a loop was
      //indeed there the slow and fast Pointers would traverse the list in the while loop
      // and meet at some point at line : 42
      
      return false;
  }
}