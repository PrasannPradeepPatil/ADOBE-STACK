package PRIORITYQUEUE_HEAP;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_UsingHeap{
     //DIFFERENCE
     //Priority queue using Arrays : Insertion :O(n) ;Deletion :O(1)           -->Slower Insertion , Faster deletion
    //Priority queue using Heap    : Insertion :O(log n) ;Deletion :O(log n)  

  /*

    PRIORITYQUEUE(PRIORITY)
    [4,5,6,7,10,15,20]
     |              |
  element req      element added acc to priority
  is removed       asc priority: element added in front mantaining asc order
                   desc priority: element added  in fronrt mantainingg desc order

     */


  //CONSTRUCTOR
  private MinHeap_UsingArray minHeap;
  private MaxHeap_UsingArray maxHeap;
  public PriorityQueue_UsingHeap(int size){
    minHeap = new MinHeap_UsingArray(size); 
    maxHeap = new MaxHeap_UsingArray(size);

  }

 
  //LOOKUP
  public int peek(){
      /*
      TIME :    O(1)
      SPACE:    O(n)
      */
      return minHeap.peek();
      //return maxHeap.peek();
  }
  public boolean contains(int item){
    /*
      TIME :    O(n)
      SPACE:    O(n)
      */
      return minHeap.contains(item);
      //return maxHeap.peek();
  }



  //INSERT
  public void add(int item){
    /*
    TIME:O(log n)
    SPACE:O(n)

     */

    minHeap.add(item);
    //maxHeap.add(item);
}
  public int remove(){
    /*
    TIME:O(log n)
    SPACE:O(n)

     */

    return minHeap.remove();
    //return maxHeap.remove();
}


//SIZE
  public boolean isEmpty(){
    /*
    TIME:O(1)
    SPACE:O(n)

     */

    return minHeap.isEmpty();
    //return maxHeap.isEmpty();
}
  public boolean isFull(){
    /*
    TIME:O(1)
    SPACE:O(n)

     */
    return false;

   }
  public int size(){
    /*
    TIME:O(1)
    SPACE:O(n)

     */

  return minHeap.size();
  //return maxHeap.size();
}


}