package STACK;
import java.util.Arrays;



public class DualStack_UsingArray {
     /*
    DUALSTACK(LIFO)
    [1,2,3,4,  5,6,7,8]
         |     |
     stack1     stack2
     from front  from behind
     It performs  PUSH1() PUSH2() POP1() ,POP2()  AND SO ON

     */


    //CONSTRUCTOR
    private int top1;
    private int top2;
    private int[] arr;
    public DualStack_UsingArray(int size) {
        /*
        [0,0,0,0]
       |         |
       top1     top2
         */
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }



    //LOOKUP
    public int peek1(){
        /*
         [1,2,0,0,0]
            |        |
           top1     top2  -- return  top1
                             //EDGE CASE : Check if stack1 is empty throw ISE
         TIME  : O(1)
         SPACE : O(n)
 
          */
 
        //EDGE CASE
        if(isEmpty1())
            throw new IllegalStateException();
 
        return arr[top1];
     }
    public int peek2(){
       /*
         [0,0,1,2]
        |     |
       top1  top2  -- return  top2
                      //EDGE CASE : Check if stack2 is empty throw ISE
 
        TIME  : O(1)
        SPACE : O(n)
 
       */
 
         if(isEmpty2())
             throw new IllegalStateException();
         return arr[top2];
     }
    public boolean contains1(int item){
        /*
        [1,2,0,0,0]
           |     |
        top1     top2  -- iterate from 0 to top1
                            //EDGE CASE : Check if stack1 is empty throw ISE
        TIME  : O(n)
        SPACE : O(n)

        */

        //EDGE CASE
        if(isEmpty1())
            throw new IllegalStateException();

        for(int i = 0 ; i <= top1; i++){
            if(arr[i] == item){
                return true;
            }
        }
        return false;

    }
    public boolean contains2(int item){
        /*
        [0,0,0,2,1]
       |       |
        top1  top2  -- iterate from arr.length-1  to top2
                      //EDGE CASE : Check if stack1 is empty throw ISE
        TIME  : O(n)
        SPACE : O(n)

        */

        //EDGE CASE
        if(isEmpty2())
            throw new IllegalStateException();

        for(int i = arr.length-1 ; i >= top2; i--){
            if(arr[i] == item){
                return true;
            }
        }
        return false;

    }

    //INSERT
    public void push1(int item) {
        /*
         [0,0,0,0,0,0,0,0,0,0]
        |                      |
        top1                   top2  -- increment top1 and put element
                                         //EDGE CASE : Check if stack 1 is full throw SOE
 
       TIME  : O(1)
       SPACE : O(n)
        */
        //EDGE CASE
         if (isFull1())
             throw new StackOverflowError();
 
         top1++;
         arr[top1] = item;
     }
    public void push2(int item) {
        /*
         [0,0,0,0]
        |          |
        top1      top2  -- decrement top2 and put element
                           //EDGE CASE : Check if stack2 is full throw SOE
 
        TIME  : O(1)
        SPACE : O(n)
          */
        //EDGE CASE
         if (isFull2())
             throw new IllegalStateException();
 
         top2--;
         arr[top2] = item;
     }
    public int pop1() {
        /*
         [1,2,0,0,0]
            |        |
           top1     top2  -- return  top1 and decrement top1
                            //EDGE CASE : Check if stack 1 is empty throw ISE
         TIME  : O(1)
         SPACE : O(n)
 
          */
         //EDGE CASE
         if (isEmpty1())
             throw new IllegalStateException();
 
         var element = arr[top1];
         top1 --;
         return element;
     }
    public int pop2() {
        /*
         [0,0,1,2]
        |     |
       top1  top2  -- return  top2 and decrement top2
                        //EDGE CASE : Check if stack2 is empty throw ISE
         TIME  : O(1)
         SPACE : O(n)
 
          */
        //EDGE CASE
         if (isEmpty2())
             throw new IllegalStateException();
 
         var element = arr[top2];
         top2++;
         return element;
     }
     

    //SIZE
    public boolean isEmpty1() {
        /*
        [0,0,0,0]
       |         |
       top1      top2  -- if top1 is -1 stack1 is never filled
                  //EDGE CASE : Check if stack1 is empty not req

        TIME  : O(1)
        SPACE : O(n)

         */

        return top1 == -1;
    }
    public boolean isEmpty2() {
       /*
        [0,0,0,0]
       |         |
       top1      top2  -- if top2 is at arr.length stack2 is never filled
                         //EDGE CASE : Check if stack2 is empty not req

        TIME  : O(1)
        SPACE : O(n)

         */
        return top2 == arr.length;
    }
    public boolean isFull1() {
       /*
        [1,2,3,4]
                |  |
              top1 top2  -- if top1 +1 is at top2 then stack1 is full
                              //EDGE CASE : Check if stack1 is full not req
        TIME  : O(1)
        SPACE : O(n)      

         */
        return top1 + 1 == top2;
    }
    public boolean isFull2() {
        /*
        [1,2,3,4]
     |   |
    top1 top2  -- if top2 -1 is at top1 then stack2 is full
                    //EDGE CASE : Check if stack2 is full not req
        TIME  : O(1)
        SPACE : O(n)
         */
        return top2 - 1 == top1;
    }
    public int size1(){
     /*
      [1,2,0,0,0]
         |        |
        top1     top2  -- return  top1+1
                           //EDGE CASE : Check if stack1 is empty ret 0
        TIME  : O(1)
        SPACE : O(n)
      */
     //EDGE CASE
     if (isEmpty1())
         return 0;

     return top1+1;

    }
    public int size2(){
      /*
        [0,0,1,2]
       |     |
      top1  top2  -- return  top2-1
                      //EDGE CASE : Check if stack2 is empty not req
        TIME  : O(1)
        SPACE : O(n)
       */

      if (isEmpty2())
          return 0;
      return top2-1;
    }


}
