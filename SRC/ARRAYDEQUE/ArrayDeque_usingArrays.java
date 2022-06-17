package ARRAYDEQUE;

import java.util.Arrays;


public class ArrayDeque_usingArrays {
    /*
    QUEUE(FIFO)
    [1,2,3,4,5,6,7,8]
    |               |
 elements removed   elements added
 from rear          in front


     */
    
    //CONSTRUCTOR
    int[] arr;
    int[] opArray;
    private int frontcounter ;
    private int backcounter ;
    int itemscounter;
    public ArrayDeque_usingArrays(int queue_size){
        /*
        [  0   0  0  0  ]
        | | |
       fc bc ic
        |  |   \
   move circular move linear


         */
        arr = new int[queue_size];
        frontcounter = 0;
        backcounter = 0;
        itemscounter =0;
    }

    //LOOKUP
    public int peek(){
        /*
         [1  2  3  4 ]
          |           |  |
          fc           ic  bc  -- return element at fc
                                   //EDE CASE: If queue is empty return ISE()
  
        TIME: O(1) considering we dont do Array.copyOfRange() 
        SPACE:O(2n) = O(n)              
         
        */
          //EGDE CASE
          if(isEmpty()){throw new IllegalStateException();}
  
          return arr[frontcounter];
      }
    public boolean contains(int item){
        /*
         [1  2  3  4 ]
          |           |  |
          fc           ic  bc  -- iterate from 0 to ic
                                   //EDE CASE: If queue is empty return ISE()
  
        TIME: O(n) considering we dont do Array.copyOfRange() 
        SPACE:O(2n) = O(n)              
         
        */
          //EGDE CASE
          if(isEmpty()){throw new IllegalStateException();}
  
          for(int i =0 ; i <= itemscounter ; i++){
              if(arr[i] == item){
                  return true;
              }
          }
          return false;  
      }

    //INSERT
    public void add(int item){
        /*
       [ 0,     0,  0 ,0 ]
        | | |
        fc ic  bc  -- put element at backcounter and increment backcounter circular  increment items counter; copy arr from 0 to ic exclusive
                      //EDGE CASE:Check if quqeue is full then throw ISE()

        TIME: O(1) considering we dont do Array.copyOfRange() 
        SPACE:o(2n) = O(n)              
        */

        if(isFull())
            throw new IllegalStateException();


        if (itemscounter == arr.length){throw new IllegalStateException();}//Err case(array is full)

        arr[backcounter] = item;
        backcounter = (backcounter+1)% arr.length;
        itemscounter++;

        opArray = Arrays.copyOfRange(arr,0,itemscounter);
    }
    public int remove(){
        /*
       [1  2  3  4 ]
        |           |  |
        fc           ic  bc  -- return element at fc  make it 0 and  circular increment fc  decrement ic ; copy arr from fc to end
                                //EDGE CASE:Check if quqeue is empty then throw ISE()
        
        TIME: O(1) considering we dont do Array.copyOfRange() 
        SPACE:o(2n) = O(n)             
        */
        //EDGE CASE
        if (isEmpty())
            throw new IllegalStateException();

        var storer = arr[frontcounter];
        arr[frontcounter] = 0;
        frontcounter = (frontcounter+1)% arr.length;
        itemscounter--;

        opArray = Arrays.copyOfRange(arr, frontcounter, arr.length);

        return storer;
    }
    

    //SIZE
    public boolean isEmpty(){
        /*
        [ ]
         | |  |
         fc ic  bc  --if items counter is at 0 then queue is empty
                      //EDGE CASE:Check if quqeue is emoty not req here

        TIME: O(1) considering we dont do Array.copyOfRange() 
        SPACE:o(2n) = O(n)              
         
        */
         return itemscounter ==0;
     }
     public boolean isFull(){
        /*
        [1,2,3,4 ]
         |        |  |
         fc        ic  bc  --if items counter is at arr.length then queue is full
                               //EDGE CASE:Check if quqeue is full not req here
        TIME: O(1) considering we dont do Array.copyOfRange() 
        SPACE:o(2n) = O(n)              
         
        */
         return itemscounter == arr.length;
 
     }
     public int size(){
      /*
        [1  2  3  4 ]
         |           |  |
         fc           ic  bc  -- return ic
                                   //EDGE CASE:Check if quqeue is empty ret -1
 
        TIME: O(1) considering we dont do Array.copyOfRange() 
        SPACE:o(2n) = O(n)              
         
        */
          //EDGE CASE
          if(isEmpty())
              return 0;
 
         return itemscounter;
     }
 






 
}
