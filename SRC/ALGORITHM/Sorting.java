package SRC.ALGORITHM;
import java.util.*;

public class Sorting {
    public class Node{private int val;private Node next; public Node(int val){this.val = val;}};private Node head;

    //BUBBLE SORT
    public void arrayBubblesort(int[] array){
        /*
        [7,6,5,1,3,2]
         |
         ptr --------- for i = 1 to i<=arr.length
                          move ptr till 2nd last element -i
                             if(ptr > ptr+1) swap ptr , ptr+1

                        OPTIMIZATION
                        At each iter initialise isSorted = true  ;if we swap then isSorted = false ;
                        at end issorted = true then immediately return as arr is sorted
        
        TIME : O(n^2)  - iterate till end  n times
               O(n)   - iterate till end only once as array is sorted in 1st go
        SPACE: O(1)    -- no extra memory required wrt to ip
               O(1)    -- no extra memory required wrt to ip
         */


        for(int i = 1; i<=array.length;i++){
            boolean isSorted = true ;   //OPTIMIZATION
            for (int pointer = 0; pointer<= (array.length-2)-i ; pointer++){
                if(array[pointer+1] < array[pointer]){
                   //swap(array,pointer,pointer+1);
                   isSorted = false; }
            }
            if (isSorted){
                return ;
            }
        }

        // private static void swap(int[] array , int index1, int index2){
        //     var temp = array[index1];
        //     array[index1] = array[index2];
        //     array[index2] = temp;
        // }

    }
    
    //SELECTION SORT
    public void arraySelectionSort(int[] array){
       /*
        [7,6,5,1,3,2]
         |
         ptr --------- move ptr till end of arr
                          swap ptr with min value from pointer till end

        TIME : O(n^2)  - iterate till end  and in each iteration find min element
               O(n^2)    - iterate till end and in each iteration find min element 
        SPACE: O(1)    -- no extra memory required wrt to ip
               O(1)    -- no extra memory required wrt to ip


         */

        for (int pointer = 0 ; pointer <= array.length-1 ;pointer++){
            //var minvalueindex= minIndex(array,pointer,array.length-1);
            //swap(array,pointer,minvalueindex);

        }
        //MININDEX
        /*
        private static int minIndex(int[] array, int index1 , int index2){

            int min = array[index1];
            int minindex = 0;
            for (int i = index1 ; i <=index2; i++ ){
                if(array[i] <= min){
                    min = array[i];
                    minindex = i;
                }
            }
    
            return minindex;
        }
        */
    


    }
    

        
    //INSERTSORT
    public void arrayInsertionSort(int[] array) {
        /*
          [7,6,5,1,3,2]
          |
          ptr -----------> move ptr till the end
                                before ptr   for all  element > ptr then rightshift from element to ptr
  
          TIME : O(n^2)  - iterate till end  and in each iteration compare till end
                O(n)    - iterate till end  and in each iteration compare only once as  arr is sorted
          SPACE: O(1)    -- no extra memory required wrt to ip
                O(1)    -- no extra memory required wrt to ip
  
        
        
        
  
  
  
          */
        for (int ptr = 0; ptr < array.length; ptr++) {
            var temp = array[ptr];
            var j = ptr - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
      
      }    
    public Node linkedListInsertionSort(Node head) {
          /*
          LOOK IN LINKEDLIST insertionSort()
          */
          return null;
          
          
        }
    public void listInsertionSortRecursive(List<Integer> list) {
          /*
          Look in Recursion listInsertionSortRecursive()
          */
      
        
        
        }
    public void stackInsertionSortRecursive(Stack<Integer> stack) {
        /*
        Look in Recursion StackInsertionSortRecursive()
        */
      
        
      }
          

    //QUICKSORT
    public void arrayQuicksortRecursive(int[] array, int start, int end) {
      /*
      Look in Recursion arrayQuicksortRecursive()
      */
    }
    
    //MERGESORT
    public void arrayMergesortRecursive(int[] array) {
      /*
      Look in Recursion arrayQuicksortRecursive()
      */

     
    
    
    }
    public Node linkedListMergeSortRecursive(Node head){
      /*
      Look in Recursion linkedListMergeSortRecursive()
      */
      return null;

}



    //COUNT SORT --->Array must have +ve elements , max element in array is given(k)
    public void arrayCountSort(int[] arr,int k){
        /*
        [4,5,1,2]

        [0 1 0 0 1 1]    --populate arr2 with count of element of arr1
        0 1 2 3 4  5

        [0 1 0 0 1 1]    --iterate arr2
        0 1 2 3 4  5         add arr ka index arr2[index] times in array 1 ie add 0 0 times ; add 11 time 




        0,1,2,3,4
      [4,5,1,2]---------------------->   [4,5,1,2]
       |                                 |
       ptr1                              ptr1

       []                                 [0 1 0 1 1]
        |                                 |0 1 3 4 5
        ptr2-->move ptr1 till end and     ptr2  ----move ptr 2 till end and
               put in arr2                           from 0 to val populate arr1
              ind=elem,val=cnt

        TIME : O(n+k)   - Populating we have to traverse over array ; iterate over array 2
               O(n+k)   - Populating we have to traverse over array ; iterate over array 2
        SPACE: O(k)     -1 new arrays formed with k inputs wrt ip array
               O(k)     -1 new arrays formed with k inputs wrt ip array

         */
        int[] arr2 = new int[k + 1];
        for(int i = 0 ; i <= arr.length-1;i++){
            int index = arr[i];
            arr2[index]++;
        }

    

        var index = 0;
        for (int ptr1 = 0; ptr1 <= arr2.length-1; ptr1++)
            for (int ptr2 = 1; ptr2 <= arr2[ptr1]; ptr2++){
                arr[index++] = ptr1;
            }

    }
    
    //HEAP SORT
    public void arrayHeapSort(int[] array){
        /*
        [7,6,1,2,4]------->  1  -- put in minheap and remove from minheap
                             2
                             3
                             4
                             5
                             6
                             7

        TIME : O(n(logn + logn)) = O(nlog2n)   - Iterate array ; Populating heap and  Removing from heap
               O(n(logn + logn)) = O(nlog2n)   - Iterate array ; Populating heap and  Removing from heap
        SPACE: O(n)                             -minheap of size n
               O(n)                             -minheap of size n

   


         */

        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        for (var i:array){
            minHeap.add(i); }
        int index = 0;    
        while(!minHeap.isEmpty()){
            array[index] = minHeap.remove();
        }
    }


    //NOTE: Sorting LL,STACK,QUEUES : can copy them in array ;sort array ; convert array back to data structure







}













