package STACK;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Stack_UsingPriorityQueue_Heap {

     /*
    /////1.BASED ON ELEMENT/////////
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();--> [4,5,6,7]   -->elements are added mantaining  asc based on "element" 
                                                                OR            and removed from front of queue or top of stack
                                                                [4                     
                                                                5                        
                                                                6
                                                                7                     
                                                                8                           
                                                                9                           
                                                                10
                                                                ]  

    PriorityQueue<Integer> maxheap = new PriorityQueue<>();--> [7,6,5,4]   -->elements are added mantaining  desc based on "element" 
                                                                OR                     and removed from front of queue or top of stack
                                                                [7                 
                                                                6                      
                                                                5
                                                                4                     
                                                                ]  
    peek()
    contains(1)

    add(1)
    remove()

    isEmpty()
    size()




     /////2.BASED ON HASHMAP , NODE KEY VALUE/////////     
    public class Node{ 
        int key;int value;                                         
        public Node(int key,int value){this.key=key;this.key=key;} }
    hashmap = {key1: value1, key2:value2,key3 , value3}  

    PriorityQueue<Node> minHeap = new PriorityQueue<>(                               
           (Node n1 , Node n2) -> { return (n1.key == n2.key) -->[<1,4>,<2,1>,<2,8>,<3,1>]   -->elements are added mantaining  asc based on  "key of node" if key of node is same sort in asc/desc based on "value of node"(here asc)  
                                    ? n1.value - n2.value        OR                            and removed from front of queue or top of stack 
                                    :n1.key - n2.key;}           [<1,4>
     )                                                            <2,1> 
                                                                  <2,8>
                                                                  <3,1>                            
                                                                ]  
    PriorityQueue<Node> maxHeap = new PriorityQueue<>(                               
        (Node n1 , Node n2) -> { return (n1.key == n2.key) -->[<3,1>,<2,1>,<2,8>,<1,4>]    -->elements are added mantaining  desc based on  "key of node" if key of node is same sort in asc/desc based on "value of node"(here asc)  
                                ? n1.value - n2.value        OR                            and removed from front of queue or top of stack 
                                :n2.key - n1.key;}         [<3,1>                     
                                                            <2,1>                     
                                                            <2,8>
                                                            <1,4>  ]     


    peek()
    contains(?)

    add(new Node(key , value)  -- key , value can be direct values 1,2
    remove().value                key value can be from hashmap for(var i : hashMap.entrySet()){  var key = i.getKey();var value = i.getValue();

    isEmpty()
    size()
   


    NOTE: PQ does not guarantee adding in perfect asc or des order
           PQ does guarantee that when you remove you will get the perfect order as if it was added in as or desc 
    NOTE: FOR comparing integers: x - y for 
          FOR string            : x.compareTo(y) 
          FOR  list you cabn do same
            Collections.sort(list)                                 -->sort in ascending order based on "element"
            Collection.sort(list                                   --> sort in descending order based on "element"                    
                    (value1,value2) -> { return value2-value1}    
            );  
            Collection.sort(list                                    --> sort in ascending order based on "value of hashmap"   if value of map is same sort in asc/desc  based on "element" 
                    (value1,value2) -> { return (map.get(value1) == map.get(value2)) ? value1- value2 : map.get(value1) - map.get.getValue(value2);}    
            );  
            Collection.sort(list                                    --> sort in descending order based on "value of hashmap " but if value is same sort in asc/desc  based on "element" 
                    (value1,value2) -> { return (map.get(value1) == map.get(value2)) ? value1- value2 : map.get(value2) - map.get.getValue(value1);}    
            );  
    
    

   */


    
    //CONSTRUCTOR 
    private class Node{
        int key;
        int value;                                                
        public Node(int key,int value){this.key=key;this.key=key;} 
    }
    private PriorityQueue<Node> maxHeap; ////ADD IN DESCENDING  ORDER BASED ON NODE'S KEY = ORDER IN WHICH WE INSERT ELEMENTS
    private int insertionOrder;
    public Stack_UsingPriorityQueue_Heap(){
    maxHeap = new PriorityQueue<>(
      /*
       [<3,1>,<2,1>,<2,8>,<1,4>]    
       OR                           
       [<3,1>                     
        <2,1>                     
        <2,8>
        <1,4>  ]
      */
        (Node n1 , Node n2) -> { return (n1.key == n2.key) ? n1.value - n2.value :n2.key - n1.key;}    
    );
    insertionOrder = 0;

  }

 
  //LOOKUP
  public int peek(){
      /*
                               
      [<3,1>,<2,1>,<2,8>,<1,4>]    --peek value of node at top of maxheap
       OR                            //EDGE CASE: if maxheap is empty ret -1
       [<3,1>                     
        <2,1>                     
        <2,8>
        <1,4>  ]

      TIME :    O(1)
      SPACE:    O(n)
      */

      //EDGE CASE
      if(maxHeap.isEmpty())
        return -1;
      return maxHeap.peek().value;
  }
  public boolean contains(int item){
     /*
                               
      [<3,1>,<2,1>,<2,8>,<1,4>]    --check if maxheap contains item
       OR                            //EDGE CASE: if maxheap is empty ret false
       [<3,1>                     
        <2,1>                     
        <2,8>
        <1,4>  ]

      TIME :    O(n)
      SPACE:    O(n)
      */

      //EDGE CASE
      if(maxHeap.isEmpty())
        return false;
      return maxHeap.contains(item);
  }



  //INSERT
  public void push(int item){
    /*
                              
    [<3,1>,<2,1>,<2,8>,<1,4>]    --add element in maxheap  
      OR                           //EDGE CASE: if maxheap is full return
      [<3,1>                     
      <2,1>                     
      <2,8>
      <1,4>  ]

    TIME :    O(log n)
    SPACE:    O(n)
    */

    Node node = new Node(insertionOrder++,item);
    maxHeap.add(node);
}
  public int pop(){
    /*
                              
    [<3,1>,<2,1>,<2,8>,<1,4>]    --remove element in maxheap  
      OR                           //EDGE CASE: if maxheap is empty return -1
      [<3,1>                     
      <2,1>                     
      <2,8>
      <1,4>  ]

    TIME :    O(log n)
    SPACE:    O(n)
    */

    //EDGE CASE
    if(maxHeap.isEmpty()){return -1;}

    return maxHeap.remove().value;
}


//SIZE
  public boolean isEmpty(){
     /*
                              
    [<3,1>,<2,1>,<2,8>,<1,4>]    --check if maxheap is empty
      OR                           //EDGE CASE: if maxheap is empty return false
      [<3,1>                     
      <2,1>                     
      <2,8>
      <1,4>  ]

    TIME :    O( 1)
    SPACE:    O(n)
    */

    return maxHeap.isEmpty();
}
  public boolean isFull(){
    /*
                              
    [<3,1>,<2,1>,<2,8>,<1,4>]    --check if maxheap is full
      OR                           //EDGE CASE: if maxheap is full return false
      [<3,1>                     
      <2,1>                     
      <2,8>
      <1,4>  ]

    TIME :    O( 1)
    SPACE:    O(n)
    */


    return false;
   }
  public int size(){
    /*
                              
    [<3,1>,<2,1>,<2,8>,<1,4>]    --retur size of maxheap
      OR                           //EDGE CASE: if maxheap is full return false
      [<3,1>                     
      <2,1>                     
      <2,8>
      <1,4>  ]

    TIME :    O( 1)
    SPACE:    O(n)
    */

  return maxHeap.size();
}

    
}
