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
        //RECURSIVE IP-OP TREE(Decision:No decision take smaller list)
        /*
            |      [1,5,6,7]  
            [7,6,5,1] 
            |      [5,6,7]
            [7,6,5]
            |      [6,7]        --insert(list,temp)
            [7,6] 
            |      [7]           --return
            [7]
    
        public void    listInsertionSortRecursive(List<Integer> list) {
                                                                --while going top-bottom
        if(list.size() == 1)                                    if list size == 1
            return;                                                 return and start moving up
        var temp = list.remove(list.size()-1);                 temp = remove last element of list
    
                                                                --whle going top down
        listInsertionSortRecursive(list);                      listInsertionSortRecursive(list); 
                                                    
                                                                --while going bottom-top
        insert(list, temp);                                    insert temp in list
        }
    
        //INSRERT  --we can insert iteratovely but ques is asking recursively so we do insert also recursively
        item = 3
                |       [1,2,3,4,5]
            [1,2,4,5]   
            |         [1,2,3,4]
            [1,2,4]
            |          [1,2,3]  
            [1,2]
            |      
            [1,2,3]
            private void  insert(List<Integer> l, int item) {   
                                                                    --while going top-bottom
            if(l.size() == 0 || item >= l.get(l.size()-1)){           if list size == 0 || item > list ka last element  
                l.add(item);                                            add item in list
                return;                                                 return and start moving up
            }
            int temp = l.remove(l.size()-1);;                           int temp = l.remove(l.size()-1);
    
                                                                        --while going top-bottom
            insert(l, item);                                            insert(l,item)
    
                                                                        --while going bottom-top
            l.add(temp)                                                  insert temp in list
            }
    
    
            //OVERRIDE
            public void listInsertionSortRecursive(List<Integer> list) {
            return listInsertionSortRecursive(list);
            }
    
        TIME :O(2^n) as each fn calls itself twice and n(size of  array) reduces by 1 
        SPACE:O(n) as we have n(size of  array)ips       
        */
        
        }
    public void stackInsertionSortRecursive(Stack<Integer> stack) {
        //RECURSIVE IP-OP TREE(Decision:No decision take smaller stack)
        /*
            |      [1,5,6,7]  
            [7,6,5,1] 
            |      [5,6,7]
            [7,6,5]
            |      [6,7]        --insert(stack,temp)
            [7,6]
            |      [7]          --rturn
            [7]
    
        public void    stackInsertionSortRecursive(Stack<Integer> stack) {
                                                                --while going top-bottom
            if(stack.size() == 1)                                    if stack size == 1
            return;                                                 return and start moving up
    
                                                                --whle going top down  
            var temp = stack.pop();                                 var temp = stack.pop();
            stackInsertionSortRecursive(stack);                     stackInsertionSortRecursive(stack);
                                                    
                                                                --while going bottom-top
            insert(stack, temp);                                    insert temp in stack
        }
    
    
    
        //INSRERT  --we can insert iteratovely but ques is asking recursively so we do insert also recursively
        item = 3
                |       [1,2,3,4,5]
            [1,2,4,5]   
            |         [1,2,3,4]
            [1,2,4]
            |          [1,2,3]  
            [1,2]
            |      
            [1,2,3] 
    
            private void  insert(Stack<Integer> stack , int item) {
                                                                    --while going top-bottom
            if(stack.size() == 0 || item >= stack.peek()){            if(stack.size() == 0 || item >= stack.peek())
                stack.push(item);                                       push item in stack
                return; }                                               return and start moving up
    
            int temp = stack.pop();                                   int temp = stack.pop(); 
    
                                                                        --while going top-bottom
            insert(stack, item);                                        insert(stack,item)
    
                                                                        --while going bottom-top
            stack.push(temp);                                             push temp in stack
            }
    
            //OVERRIDE
            public void  stackInsertionSortRecursive(Stack<Integer> stack) {
            stackInsertionSortRecursive(stack);
            }
            
    
        TIME :O(2^n) as each fn calls itself twice and n(size of  array) reduces by 1 
        SPACE:O(n) as we have n(size of  array)ips       
        */
        
        
    
        
        
        }
        
    //QUICKSORT
    public void arrayQuicksortRecursive(int[] array, int left, int right) {
        //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
         /*
                 
        [5, 1, 3 ,2]     
       b l        r                
          /         \
         /           \
      [1, 5, 3, 2]     [1, 5, 3, 2]
    r l,b               b  l     r
  
      public void    arrayQuicksortRecursive(int[] array, int left, int right) {
  
                                                              --while going top-bottom
          if (left >= right)                                    if left >= right
              return;                                           return and start moving up
          int boundary = left - 1;                       
          for (var ptr = left; ptr <= right; ptr++)             move ptr from left to right   
              if (array[ptr] <= array[right]){                    if ptr <= right
                  boundary++;                                     move boundary ahead
                  swap(array, ptr, boundary);                     swap ptr and boundary
          }
  
                                                                  --while going top-down
          arrayQuicksortRecursive(array, left, boundary - 1);       arrayQuicksortRecursive(array, left, boundary - 1);
          arrayQuicksortRecursive(array, boundary + 1, right);      arrayQuicksortRecursive(array, boundary + 1, right);
   
        }
  
  
        public static void arrayQuicksortRecursive(int[] array) {
          arrayQuicksortRecursive(array, 0, array.length - 1); 
        }
                               
        TIME : O(n^2)       - iterate till the end ; pivot ends just 1 before end so n divisions
               O(n log2 n)  - iterate till the end;pivot ends in middle exactly so  divisions in half 
        SPACE: O(n)        - pivot falls just 1 before end so we get arrays of same length wrt ip array
               O(log n)    -pivot falls in middle so we get arrays of half length each timewrt ip array
  
         */
    }
      
    //MERGESORT
    public void arrayMergesortRecursive(int[] arr) {
        //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
        /*
                                  |            [1,2,3,4,5,6,7]
                                  |
                             [7,6,5,1,3,2]   
                  [5,6,7]  /                \    [1,2,3]     
                          /                  \      
                       [7,6,5]              [1,3,2]      
                  [7]   / \  [5,6]      [1,3] /        \   [2,3]             -return compare2ArraysForMergingI(left,right)
                       /   \                /           \        
                     [7]   [6,5]            [1]           [3,2]    
                        [6] /   \  [5]  [1]  |       [3]  / \  [2]            --return arr
                           /     \           |           /   \ 
                         [6]   [5]        [1]        [3]    [2] 
                            
        public int[]   arrayMergesortRecursive(int[] arr) {   
                                                                                  --while   going top-bottom           
          if (array.length == 1)                                                    if arr.length== 1
            return arr;                                                             return arr and start moving up
                                                                          
                                                                                  --while going top-bottom
          int mid = array.length/2 ;                                                left holds left sorted arr  
          int[] left = arrayMergesortRecursive(Arrays.copyOfRange(array,0,mid));    right holds right sorted array
          int[] right = arrayMergesortRecursive(Arrays.copyOfRange(array,0,mid));
                                                                                    --while going bottom-top
          return arrayCompare2ArrayForMergingI(left,right);                            merge left and right
                                                                                      return merged sorted array to next node
        }
  
        //OVERRIDE
        public void  arrayMergesortRecursive(int[] arr){
          int[] arr = arrayMergesortRecursive(arr);
          return arr;
        }
        
        
        TIME : O(nlog2n)   - Divide in half;merge till end iterativelys
               O(nlog2n)   - Divide in half;merge till end iterativelys 
        SPACE: O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 
               O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 
  
  
        */
  
    }
    public void linkedListMergeSortRecursive(Node head){
        //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
        /*
                                  | [1,2,3,4,5,6,7]
                                  |
                             [7,6,5,1,3,2]   
                  [5,6,7]  /                \    [1,2,3]     
                          /                  \      
                       [7,6,5]              [1,3,2]      
                  [7]   / \  [5,6]      [1,3] /        \   [2,3]             -return compare2ArraysForMergingI(left,right)
                       /   \                /           \        
                     [7]   [6,5]            [1]           [3,2]    
                        [6] /   \  [5]  [1]  |       [3]  / \  [2]            --return arr
                           /     \           |           /   \ 
                         [6]   [5]        [1]        [3]    [2]    
                  
                            [1,2,3,5,6,7]         
    
        public Node linkedListMergeSortRecursive(Node head){           
                 
                                                                                  --while   going top-bottom           
          if (head == null || head.next == null))                                   if head == null || head.next == null)
            return head;                                                            return head and start moving up
                                                                          
                                                                                  --while going top-bottom
          int mid = array.length/2 ;                                                 left holds left sorted LL  
          Nodr left = linkedListMergeSortRecursive(head);                            right holds right sorted LL
          Node right = linkedListMergeSortRecursive(mid);
                                                                                    --while going bottom-top
          return compare2LLSortedForMerging(left,right);                    merge left and right
                                                                                      return sorted LL to next node
        }
        
  
        //OVERRIDE
        public Node linkedListMergeSortRecursive(Node head){  
          return linkedListMergeSortRecursive(node);
        }
        
        TIME : O(nlog2n)   - Divide in half;merge till end iterativelys
               O(nlog2n)   - Divide in half;merge till end iterativelys 
        SPACE: O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 
               O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 
  
  
         */
  
       
  
         
  
       
  
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













