package SRC.ARRAYLIST;
import java.util.Arrays;


public class ArrayList_UsingArray {
      /*
      ARRAYLIST
      [1,2,3,4] --> elements get added and  size changes dynamically y doubling each time for ArrayList and increasing 50% for vectorList
       |
       ptr
      */




    //CONSTRUCTOR
    int[] arr ;
    int[] opArr;
    int ptr;
    public ArrayList_UsingArray(int length){
        /*
        [0,0,0,0,0]
         |
         ptr
         */
        arr = new int[length];
        ptr = 0;
    }


    // LOOKUP
    public int get(int index){
        /*
         [1,2,3,4,5,0,0,0,0,0]
              |     |
             index  ptr  -- return element at index
                             //EDGE CASE:Check if array is Empty return -1
        TIME :O(1) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
         */
 
        if(isEmpty())
            return -1;
 
         return arr[index];
 
     }   
    public int indexOf(int item){
        /*
        [1,2,3,4,5,0,0,0,0,0]
                  |
                   ptr  -- search from 0 to pttr exclusive 
                            //EDGE CASE:Check if array is Empty return -1

        TIME :O(n) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
         */
        //EDGE CASE
        if(isEmpty())
            return -1;

        for(int i=0 ; i< ptr ; i++){
            if(arr[i] == item)
                return i;
        }

        return -1;


    }
    public int lastIndexOf(int item){
        /*
        [1,2,3,4,5,0,0,0,0,0]
                    |
                   ptr  -- search from ptr exclusive to 0 
                            //EDGE CASE:Check if array is Empty return -1
        
        TIME :O(n) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
        */

        //EDGE CASE
        if (isEmpty())
            return -1;

        for (int i = ptr-1 ; i >= 0 ; i--){

            if(arr[i] == item)
                return i;
        }

        return -1;





    }
    public boolean contains(int item){
        /*
        [1,2,3,4,5,0,0,0,0,0]
                  |
                   ptr  -- search from 0 to ptr exclusive
                          //EDGE CASE:Check if array is Empty return false
        TIME :O(n) considering we dont require Arrays.copyOfRange()
        SPACE:O(n) 
        */

        if(isEmpty())
            return false;

        for(int i =0 ; i < ptr ; i ++){
            if(arr[i] == item)
                return true;
        }

        return false;

    }
    
    //INSERT 
    public void add(int item){
        /*
         [0,0,0,0,0]
          |
          ptr  -- add element at ptr and increment ptr and take arr from 0 to ptr exclusive
                   //EDGE CASE: check if arr is full load arr to extendedArray ressign array
         
        TIME :O(1) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
         */

        //EDGE CASE
        if(isFull()){
            int[] extendedArray = new int[arr.length *2];
            for(int i=0 ; i < arr.length; i++){
                arr[i] = extendedArray[i];
            }
            arr = extendedArray;

        }


        arr[ptr] = item;
        ptr++;
        opArr = Arrays.copyOfRange(arr, 0 , ptr);

    }
    public void add(int item, int index){
         /*
        [1,2,3,4,5,0,0,0,0,0]
             |      |
            index   ptr  -- right shift from index to ptr exclusive ; increment counter ; set index to item; copy arr 0 to ptr exclusive
                             //EDGE CASE:check if arr is full ;  load arr to extendedArray ressign array --> CHECK IN BEGINNING
         
        TIME :O(n) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
         
         */

         //EDGE CASE
        if(ptr == arr.length){
            int[] extendedArray = new int[arr.length *2];
            for(int i=0 ; i < arr.length; i++){
                arr[i] = extendedArray[i];
            }
            arr = extendedArray;

        }

        for(int i = index ; i <= ptr ; i++){
            arr[i+1] = arr[i];
        }
        ptr ++;

        arr[index] = item;

        opArr = Arrays.copyOfRange(arr,0,ptr);




    }
    public void remove(int index){
        /*

        [1,2,3,4,5,0,0,0,0,0]
             |     |
           index   ptr  -- left shift from index to ptr exclusive decrement ptr,  take arr from 0 to ptr excluive
                             //EDGE CASE: Check if arr is empty ; throw ISE
         
        
        TIME :O(n) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
        */

        //EDGE CASE
        if(isEmpty())
            throw new IllegalStateException();

        for(int i =index ;i < ptr ; i++ ){
            arr[i] = arr[i+1];
        }
        ptr--;

        opArr = Arrays.copyOfRange(arr,0, ptr);
    }
    public void set(int index, int item){
        /*
        [1,2,3,4,5,0,0,0,0,0]
             |     |
            index  ptr  -- set index to item
                           //EDGE CASE: Check if arr is empty throe ISE
        
        TIME :O(1) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
        */

        //EDGE CASE
        if(isEmpty())
            throw new IllegalStateException();

        arr[index] = item;
     }
    
    
    
    
    //SIZE
    public boolean isEmpty(){
         /*
        [0,0,0,0,0,0,0,0,0,0]
         |
        ptr  -- if ptr is at 0 it is empty
                //EDGE CASE:Check if array is Empty not req here
        TIME :O(1) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
         */
        return ptr == 0;
    }
    public boolean isFull(){
        /*
        [1,2,3,4,5,6,7,8,9,10]
                               |
                              ptr  -- if ptr is at arr.length it is full
                                       //EDGE CASE:Check if array is Full not req here
        TIME :O(1) 
        SPACE:O(n)
        */
         return ptr == arr.length;
    }
    public int size(){
        /*
        [1,2,3,4,5,0,0,0,0,0]
                  |
                  ptr  -- return ptr
                          //EDGE CASE:Check if array is Empty return 0
        TIME :O(1) considering we dont require Arrays.copyOfRange()
        SPACE:O(n)
        */
        if (isEmpty())
            return 0;

        return ptr;

    }



 
}
