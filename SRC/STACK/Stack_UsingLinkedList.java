package SRC.STACK;

import java.util.Arrays;
import java.util.LinkedList;

public class Stack_UsingLinkedList {
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
    LinkedList<Integer> list;
    public Stack_UsingLinkedList(){
        /*
        |||
         */

        list = new LinkedList<>();

    }



    //LOOKUP
    public int peek(){
        /*
        |v|n| -->|v|n|
                   |
                  get Last from LL
                  //EDGE CASE: check If LL is empty then return -1

        TIME  : O(1)
        SPACE : O(n)   
         */
        //EDGE CASE
        if(list.isEmpty())
            return -1;

        return list.getLast();
    }
    public boolean contains(int item){
         /*
        |v|n| -->|v|n|
                   |
                  check if linked list  contains item
                  //EDGE CASE: check If LL is empty then return -1

        TIME  : O(n)
        SPACE : O(n)   
         */

        if(list.isEmpty())
        return false;

        return list.contains(item);
        

        
    }


    //INSERT
    public void push(int item){
        /*

        |v|n| -->|v|n|
                   |
                   addLast to LinkedList
                   //EDGE CASE:No method to check if LinkedList isFull
        TIME  : O(1)
        SPACE : O(n)    
         */

        list.addLast(item);
    }
    public void pop(){
       /*
        |v|n| -->|v|n|
                  |
                  remove Last from lnkedList
                  //EDGE CASE: check if LL is empty then throw ISE

        TIME  : O(1)
        SPACE : O(n)   
         */

        //EDGE CASE
        if(isEmpty()){
            throw new IllegalStateException();}

        list.removeLast();
    }



    //SIZE
    public boolean isEmpty() {
        /*
        |||
        |
        check if LL is empty
        //EDGE CASE: Check if LL is Empty not req here

        TIME  : O(1)
        SPACE : O(n)   
         */
        return list.isEmpty();
    }
    public boolean isFull(){
         /*
        No method in LL for isFull()

        TIME  : O(1)
        SPACE : O(n)   
         */

         return false;
    }
    public int size(){
        /*
        |v|n| -->|v|n|
          |
        return size of LinkedList
        //EDGE CASEl If LL is empty return 0

        TIME  : O(1)
        SPACE : O(n)   
         */
        if (isEmpty())
            return 0;

        return list.size();
    }



 




}
