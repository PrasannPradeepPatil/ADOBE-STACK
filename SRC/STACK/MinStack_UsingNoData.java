package SRC.STACK;

import java.util.Stack;

public class MinStack_UsingNoData{
        /*
        2 -support all stack operation and also provide min() in O(1)
        -- 
        3
        --
        4
     */

     //CONSTRUCTOR
     Integer min;         //Declare this inger to avoid all edge cases as stack.peek() stack.pop() will return Integers and we are comparing these vlalues with our min
     Stack<Integer> stack;
     public MinStack_UsingNoData(){
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
     }
     
     
     //LOOKUP
     public int peek(){
        /*
                         
                          8   min = 3   if top >= min then return top
         3  -- min =3     3           
         7                7        
         8                8       
 
                          1  min =2     if top < min then return min element  -->top< min indicates that it is a flag and min element is the element to be returnesd
                          3                                    
                          7
                          8
                                        //EDGE CASE : If stack is empty then ret -1
          TIME  : O(1)
          SPACE : O(1)  
         */
         //EDGE CASE
         if(stack.isEmpty()){
             return -1;
         }
 
         if((int)stack.peek() >= min){
             return stack.peek();
         }
         else {
             return min;
         }
 
 
 
 
 
      }



     //INSERT
     public void push(int item){
        /*
                        
                         8   min = 3   if item >= min 
        3  -- min =3     3   item =8   push normally to stack       
        7                7            
        8                8             

                         1  min = 2    if item < min 
                         3  item =2    push 2*item - min to stack  
                         7             reassign min to item --2*item - min  acts as a flag while popping
                         8
                                       //EDGE CASE : If stack is empty then just push and set min to that item and "return" and move out 


         TIME  : O(1)
         SPACE : O(1)                               
        */
        //EDGE CASE
        if(stack.isEmpty()){
            stack.push(item);
            min = item;
            return;
        }

        if(item >= min){
            stack.push(item);
        }
        else if(item < min){
            stack.push(2*item -min);
            min = item;
        }



     }
     public int pop(){
      /*
                        
                         8   min = 3   if top >= min then pop normally to stack
        3  -- min =3     3           
        7                7        
        8                8       

                         1  min =2     if top < min then pop top element return min element and reassing min = 2*min -top  -->top< min indicates that it is a flag and min element is the element to be returnesd
                         3                                    
                         7
                         8
                                       //EDGE CASE : If stack is empty then ret -1

         TIME  : O(1)
         SPACE : O(1)  
        */
        //EDGE CASE
        if(stack.isEmpty()){
            return -1;
        }

        
        if((int)stack.peek() >= min){
            return stack.pop();
        }
        else {
            int topElement = stack.pop();
            int elementToBeReturned = min;
            min = min*2 - topElement;
            return elementToBeReturned;


        }





     }
     

     //SIZE
     public boolean isEmpty(){
       /*
       3
       2                                         
       4                                         
      stack                                     
       |
      return is stack is Empty
      //EDGE CASE:Check if stack is empty not req
      
      TIME  : O(1)
      SPACE : O(1)  
         */
         return stack.isEmpty();
     }
     public boolean isFull(){
        /*
        No method in stack to check isFull

        TIME  : O(1)
        SPACE : O(1)  
         */

        return false;
    }
     public int size(){
     /*
       3
       2                                         
       4                                         
      stack                                   
       |
      return is stack of stack
      //EDGE CASE:Check if stack is empty ret 0

      TIME  : O(1)
      SPACE : O(1)  
         */

     if(isEmpty())
         return 0;

        return stack.size();
    }

    //MIN
    public int min() {
        /*
          3
          2                                         
          4                                         
         stack                                    
          |
          return min element 
           //EDGE CASE:Check for Integer.MAX_VALUE
        
        TIME  : O(1)
        SPACE : O(1)  
        */
   
           if (stack.isEmpty())
               return -1;
   
            return min == Integer.MAX_VALUE? -1:min;
       }
   

    }