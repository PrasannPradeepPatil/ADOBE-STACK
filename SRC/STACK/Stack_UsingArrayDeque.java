package STACK;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Stack_UsingArrayDeque {
    /*
    STACK(LIFO)
    [1,2,3,4,5]
             |
            elements are added in front
            and removed from front

     OR

     3  -- elements are added on top of stack and removed from tp of stack
     --
     2
     --
     1
     --

     */


    //CONSTRUCTOR
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int front;
    public Stack_UsingArrayDeque(){
        /*
        []       []
        queue1    queue2

         */
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    //LOOKUP
    public int peek(){
        /*
        [1,2,3,4]              []
        queue1                queue2

        return front stored suring push pop
        //EDGE CASE: Check if queue is empty ret -1

        TIME  : O(1)
        SPACE : O(2n) = O(n) 
         */

        if (isEmpty())
            return -1;


        return front;
    }
    public boolean contains(int item){
        /*
         []              []
         queue1                queue2
            |
          check if queue contains element
          //EDGE CASE: check if queue is empty not rqe here
 
         TIME  : O(n)
         SPACE : O(2n) = O(n) 
        */
 
          return queue1.contains(item);
    }

    //INSERT
    public void push(int item){
        /*
        [1,2,3,4]                    []
        queue1                    queue2
         |
         add element to queue1
         store item in front for peek
         //EDGE CASE: Method not available to check if queue is full

        TIME  : O(1)
        SPACE : O(2n) = O(n)  
         */
        queue1.add(item);
        front = item;
    }
    public int pop(){
        //USING 2 QUEUE
        /*
        [1,2,3,4]              []
        queue1                queue2
         |
      while size >1
      remove (store in front for peek) and add  to queue2
      //EDGE CASE: Check if queue1 is not empty

       [4]               [1,2,3]
       queue1            queue2
        |
        pop the element in queue1 and return

        []              [1,2,3]
        queue2         queue1
        |
        swap queues

        TIME  : O(n)
        SPACE : O(2n) = O(n)  
         */
  
        //USING 1 QUEUE(You can eliminate need of queue2 completely by using a variable size)
        /*
        

        [1,2,3,4]              
        queue1               
         |
       while size >1
       remove (store in front for peek) and add  to queue1
       decrement size
      //EDGE CASE: Check if queue1 is not empty
       
       [4,1,2,3]
        queue1
        |
        remoove and return 

        
        */

        //USING 2 QUEUE
        if(queue1.isEmpty()){throw new IllegalStateException();}

        while (queue1.size() >1){
            front = queue1.remove();
            queue2.add(front);
        }
        var storer = queue1.remove();

 
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        //return storer;

        //USING 1 QUEUE
        if(queue1.isEmpty()){
            return -1;    
        }
        int size = queue1.size();
        while(size > 1 ){
            front = queue1.remove();
            queue1.add(front);
            size--;
        }
        
        return queue1.remove();

     }
    

    //SIZE
    public boolean isEmpty(){
        /*
         []              []
         queue1                queue2
            |
          check if queue 1 is empty
          //EDGE CASE: check if queue is empty not rqe here
 
         TIME  : O(1)
         SPACE : O(2n) = O(n) 
          */
 
         return queue1.isEmpty();
     }
    public boolean isFull(){
         /*
         No method in queue for isFull
 
         TIME  : O(1)
         SPACE : O(2n) = O(n) 
          */
         return false;
     }
    public int size(){
         /*
         [1,2,3,4]              []
         queue1                queue2
         |
         return size of queue1
         //EDGE CASE: check if queue is empty return 0
 
         TIME  : O(1)
         SPACE : O(2n) = O(n) 
 
          */
 
         if (isEmpty())
             return 0;
 
        return queue1.size();
     }
 



  


}







