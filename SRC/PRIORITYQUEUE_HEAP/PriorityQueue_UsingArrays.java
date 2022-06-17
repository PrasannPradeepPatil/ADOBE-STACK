package PRIORITYQUEUE_HEAP;
import java.util.Arrays;

public class PriorityQueue_UsingArrays {
     //DIFFERENCE
     //Priority queue using Arrays : Insertion :O(n) ;Deletion :O(1)           -->Slower Insertion , Faster deletion
    //Priority queue using Heap    : Insertion :O(log n) ;Deletion :O(log n)  



    /*

    PRIORITYQUEUE(PRIORITY)
    [4,5,6,7,10,15,20]
     |              |
  element req      element added acc to priority
  is removed       asc priority: element added in front mantaining asc order
                   desc priority: element added  in fronrt mantainingg desc order

     */


    //CONSTRUCTOR
    private int[] arr;
    private int[] opArray;
    private  int itemsptr;
    private int frontptr;
    public PriorityQueue_UsingArrays(int size){
        /*
        [0,0,0,0]
        |   |
        fp itemsptr
         */
        arr = new int[size];
        itemsptr =0;
    }


    //LOOKUP
    public int peek(){
        /*
         [1,2,3,4]
          |        |
          fp       ip  -- return element at  fp
                          //EDGE CASE:check if arr is empty throw ISE()
        TIME:O(1)
        SPACE:O(n)
        */
 
        if(isEmpty())
            throw new IllegalStateException();
 
         return arr[frontptr];
     }
    public boolean contains(int item){
         /*
         [1,2,3,4]
          |        |
          fp       ip  -- iterate from o to ip exclusive if sound return true
                          //EDGE CASE:check if arr is empty return false
        TIME:O(n)
        SPACE:O(n)
        */
        //EDGE CASE
        if(isEmpty())
            return false;

        for(int i=0 ; i < itemsptr ; i++){
            if(arr[i] == item)
                return true;
        }
        return false;
    } 



    //INSERT
    private int RightShiftAndReturnIndex(int item) {
        /*
        [1,3,4,0,0]
               |
               ip - iterate from ip-1 to 0
                    if item is less then right shift
                    if item is more means you found index break and return index
         */
        int i;
        for (i = itemsptr - 1; i >= 0; i--) {
            if (item < arr[i] )
                arr[i + 1] = arr[i];
            else if(item > arr[i])
                break;
        }
        return i + 1;
    }
    public void add(int item) {
        /*

        [0  0  0  0]
        | |
        fp ip  -- add item at index acc to priority and increment ip ; copy from 0 to ip exclusive
                 //EDGE CASE: Check if arr is full throw ISE()

        TIME : O(n) -- considering we dont do Array.copyOfRange() 
        SPACE :O(n)

         */
        //EDGE CASE
        if (isFull()){ throw new IllegalStateException();}

        var indexAccToPriority = RightShiftAndReturnIndex(item);
        arr[indexAccToPriority] = item;
        itemsptr++;

        opArray = Arrays.copyOfRange(arr,0, itemsptr);
    }
    public int remove() {
        /*
        [1,2,3,4]
         |        |
         fp       ip  -- return fp make it 0 and increment fp decrement ip ; copy array from fp to arr.length exclusive
                         //EDGE CASE:check if arr is empty throw ISE()
        
        TIME : O(1) -- considering we dont do Array.copyOfRange() 
        SPACE :O(n)
         
        */
        //EDGE CASE
        if (isEmpty()){throw new IllegalStateException();}

        var storer = frontptr;
        arr[frontptr] = 0;

        frontptr++;
        itemsptr--;

        opArray = Arrays.copyOfRange(arr,frontptr,arr.length);

        return storer;
    }
    
    //SIZE
    public boolean isEmpty() {
        /*
        [0,0,0,0]
         ||
        fp ip  -- check if ip at 0

        TIME : O(1) -- considering we dont do Array.copyOfRange() 
        SPACE :O(n)

         */


        return itemsptr == 0;
    }
    public boolean isFull() {
       /*
        [1,2,3,4]
         |        |
         fp       ip  -- check if ip at  arr.length

        TIME : O(1) -- considering we dont do Array.copyOfRange() 
        SPACE :O(n)
         */

        return itemsptr == arr.length;
    }
    public int size(){
        /*
        [1  2  0  0]
        |     |
        fp    ip  -- return itemsptr
   

        TIME : O(1) -- considering we dont do Array.copyOfRange() 
        SPACE :O(n)

         */

         return itemsptr;
    }


}
