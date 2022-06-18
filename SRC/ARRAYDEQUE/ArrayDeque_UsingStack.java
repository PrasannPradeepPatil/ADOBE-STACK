package SRC.ARRAYDEQUE;
import java.util.Arrays;
import java.util.Stack;

public class ArrayDeque_UsingStack {
    /*
    QUEUE(FIFO)
    QUEUE(FIFO)
    [1,2,3,4,5,6,7,8]
     |               |
    elements removed elements added
    from rear        in front

     */

     //CONSTRUCTOR
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;
    public ArrayDeque_UsingStack(){
        /*
        []         []
        stack1     stack2


         */
         stack1 = new Stack<>();
         stack2 = new Stack<>();
    }



    //LOOKUP
    public int peek(){
        /*
       [1,2,3,4]      []
          stack1      stack2
          |
        return fron
        //EDGE CASE: check is stack1 is emty then throw ISE()

        
        TIME:O(1)
        SPACE:O(n) 

        */
        if(isEmpty()){
            return -1;
        }
        
        return front;
   }
    public boolean contains(int item){
        /*
        []         []
        stack1     stack2
           |
          check if stack1 contains item
            //EDGE CASE:Check if stack is empty not req
        
        TIME:O(1)
        SPACE:O(n)
        */

        return stack1.contains(item);

   }


    //INSERT
    public void add(int item){
        /*
        [1,2,3,4]  []
        stack1     stack2
        |
        push item(before pushing if stack is empty means 1st push then initialise front to item for peek) to stack1
        
        //EDGE CASE:No method to check if Stack isFull

        TIME:O(1)
        SPACE:O(n)

         */

        if(stack1.isEmpty()){front = item;}

        stack1.push(item);
    }
    public int remove(){
        /*
        [1,2,3,4]      []
           stack1      stack2
           |
         while stack1is not empty
         push elements to stack2
         //EDGE CASE: check is stack is emty then throw ISE()

         []     [4,3,2,1]
         stack1   stack2
                   |
                 pop and return element ;store stack top element in front for peek() method //null check:is !stack2.isEmpty()
                 while stack2 is not empty
                 push elements to stack1
                 //EDGE CASE : Check if stack2 is not empty then throw ISE() 
                 


        TIME:O(2n) = O(n)
        SPACE:O(n)    
        
        TIME AMORTISED :0(1) --> EXPLANATION:https://leetcode.com/problems/implement-queue-using-stacks/solution/
                                (approach 2 check pop method ka  "amortised time complexity analysis")

         
        */


        if(stack1.isEmpty()){throw  new IllegalStateException();}
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }


        if(stack2.isEmpty()){throw new IllegalStateException();}
        if(!stack2.isEmpty()){front = stack2.peek();}
        var storer = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return storer;
    }
    
    
    //SIZE
    public boolean isEmpty(){
        /*
        []         []
        stack1     stack2
           |
          check if stack1 isEmpty
            //EDGE CASE:Check if stack is empty not req
        
        TIME:O(1)
        SPACE:O(n)
        */

        return stack1.isEmpty();
    }
    public boolean isFull(){
        /*
        No method to chck if stack isFull
        
        TIME:O(1)
        SPACE:O(n)
         */

        return false;
    }
    public int size(){
      /*
        [1,2,3,4]      []
         stack1      stack2
           |
        return size of stack1
        //EDGE CASE:Check if stack is empty ret0

        TIME:O(1)
        SPACE:O(n)
        */

      if (isEmpty())
          return 0;


      return stack1.size();
    }




 

}
