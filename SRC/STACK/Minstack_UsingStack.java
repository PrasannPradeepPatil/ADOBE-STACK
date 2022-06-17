package STACK;


import java.util.Arrays;
import java.util.Stack;

public class Minstack_UsingStack {
    /*
        2 -support all stack operation and also provide min() in O(1)
        --
        3
        --
        4


     */

    //CONSTRUCTOR
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Minstack_UsingStack(){
        /*
        _    _
        _    _
        _    _
      stack   minstack
         */
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    
    //LOOKUP
    public int peek(){
        /*
         3
         2                                         2
         4                                         4
        stack                                     minstack
         |
        peek top element at stack
        //EDGE CASE:if stack is empty throw ISE()
  
         TIME  : O(1)
         SPACE : O(n)  
        */
  
        if(stack.isEmpty()){
            throw new IllegalStateException();
        }
  
        return stack.peek();
  
  
      }
    public boolean contains(int item){
        /*
         3
         2                                         2
         4                                         4
        stack                                     minstack
         |
        check if stack contains ele,enyt
        //EDGE CASE:if stack is empty throw ISE()
  
         TIME  : O(n)
         SPACE : O(n)  
        */
  
        if(stack.isEmpty()){
            throw new IllegalStateException();
        }
  
        return stack.contains(item);
  
  
      }
     

    //INSERT
    public void push(int item) {
        /*
           3
           2                                        2
           4                                        4
         stack                                     minstack
         |                                               |
         push to stack                                  push to minstack only if  item <= top element so that in stays at top
        //EDGE CASE:No method to check if stack isFull   //EDGE CASE : if minstack is emoty push element as you need atleast 1 element to compare


        TIME  : O(1)
        SPACE : O(n)  

         */
        stack.push(item);

        //EDGE CASE
        if (minStack.isEmpty()){
            minStack.push(item);
            return;
        }
            
        if (item <= minStack.peek())
            minStack.push(item);
    }
    public int pop() {
       /*
       3
       2                                         2
       4                                         4
      stack                                     minstack                          
       |                                          |                              
      pop form stack and return                   pop  from  minstack only if  item poped from stack =  top element of minstack
      //EDGE CASE:if stack is empty throw ISE()     //EDGE CASE : if minstack is empty throw ISE()
        
       TIME  : O(1)
       SPACE : O(n)  
         */

        //EDGE CASE
        if (stack.isEmpty())
            throw new IllegalStateException();
        int top = stack.pop();

        //EDGE CASE
        if(minStack.isEmpty())
            throw new IllegalStateException();
        if (minStack.peek() == top)
            minStack.pop();

        return (int)top;
    }
  
    //SIZE
    public boolean isEmpty(){
        /*
        3
        2                                         2
        4                                         4
       stack                                     minstack
        |
       return is stack is Empty
       //EDGE CASE:Check if stack is empty not req
       
        TIME  : O(1)
        SPACE : O(n)  
       
       */
 
        return stack.isEmpty();
 
 
     }
    public boolean isFull(){
         /*
         No method in stack to check isFull
 
         TIME  : O(1)
         SPACE : O(n)  
          */
 
         return false;
     }
    public int size(){
      /*
        3
        2                                         2
        4                                         4
       stack                                     minstack
        |
       return is stack of stack
       //EDGE CASE:Check if stack is empty ret 0
 
       TIME  : O(1)
        SPACE : O(n)  
     
        */
 
      if(isEmpty())
          return 0;
 
         return stack.size();
     }
 
    //MIN
    public int min() {
     /*
       3
       2                                         2
       4                                         4
      stack                                     minstack
                                                 |
                                                 return top element at minstack
                                                 //EDGE CASE:Check if minstack is empty ret 01

       TIME  : O(1)
       SPACE : O(n)  
    */

        if (minStack.isEmpty())
            return -1;

        return minStack.peek();
    }



 

}
