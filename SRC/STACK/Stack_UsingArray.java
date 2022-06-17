package STACK;

import java.util.Arrays;
import java.util.Stack;

public class Stack_UsingArray {
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
    private int[] arr;
    private int ptr;
    int[] opArray;
    public Stack_UsingArray(int size){
        /*
        [0,0,0,0]
         |
         ptr

         */
        arr = new int[size];
        ptr = 0;
    }


    //LOOKUP   
    public int peek(){
        /*
       [1,2,3,4]
                |
               ptr  --return element at ptr-1
                //EDGE CASE: Check if stack is empty  throw IllegalStateException()


        TIME  : O(1)  considering we dont do Array.copyOfRange
        SPACE : O(n)    
        */
        //EDGE CASE
       if(isEmpty()){
           throw new IllegalStateException();}

       return arr[ptr -1];
   }
    public boolean contains(int item){
       /*
       [1,2,3,4]
                |
               ptr  --iterate 0 to ptr-1
                //EDGE CASE: Check if stack is empty  throw IllegalStateException()


        TIME  : O(n)  considering we dont do Array.copyOfRange
        SPACE : O(n)    
        */
        //EDGE CASE
        if(isEmpty()){
            throw new IllegalStateException();}
 
        for(int i = 0 ;i <=ptr-1 ; i++){

            if(arr[i] == item){
                return true;
            }
        }
        return false;
   }


    //INSERT
    public void push(int item){
        /*
        [0,0,0,0]
         |
         ptr  -- put element at ptr and increment ptr ; copy arr from 0 to ptr inclusive
                 //EDGE CASE: Check if stack is Full   throw StackOverFlowError()

        TIME  : O(1)  considering we dont do Array.copyOfRange(
        SPACE : O(n)  
         */
        //EDGE CASE
        if(isFull()){throw new StackOverflowError();}

        arr[ptr] = item;
        ptr++;
        opArray = Arrays.copyOfRange(arr,0, ptr);//[1,0,0,0,0,0]   ->The extra 0's are removes in toString as we form array2 of range(0,counter)
    }
    public int pop(){
      /*
        [1,2,3,4]
                 |
                ptr  --return element at ptr-1 and make it 0 and decrement ptr ; copy arr from 0 to ptr exclusive
                 //EDGE CASE: Check if stack is Empty throw IllegalStateException()
         

        TIME  : O(1)  considering we dont do Array.copyOfRange(
        SPACE : O(n)   
     */

      //EDGE CASE
        if(isEmpty()){throw new IllegalStateException();}

        var element = arr[ptr-1];
        arr[ptr-1] = 0;
        ptr--;
        opArray = Arrays.copyOfRange(arr,0, ptr);
        return element;

    }
    

    //SIZE
    public boolean isEmpty(){
        /*
        [0,0,0,0]
         |
        ptr  --if ptr is at 0 then stack is empty else not
                 //EDGE CASE: Check if stack is Empty not req here


        TIME  : O(1)  considering we dont do Array.copyOfRange(
        SPACE : O(n)    
         */
        return ptr ==0;
    }
    public boolean isFull(){
       /*
        [0,0,0,0]
                 |
                  ptr  --if ptr is at arr.length then it is full else not
                          //EDGE CASE: Check if stack is full not req here

        TIME  : O(1)  considering we dont do Array.copyOfRange(
        SPACE : O(n)  
         */

       return ptr == arr.length;

    }
    public int size(){
         /*
        [1,2,3,4]
                 |
                ptr  --return ptr asit shows size of stack
                        //EDGE CASE: Check if stack is Empty ret 0

        TIME  : O(1)  considering we dont do Array.copyOfRange(
        SPACE : O(n)  
         */

         if (isEmpty())
             return 0;

         return ptr;




    }


  

}
