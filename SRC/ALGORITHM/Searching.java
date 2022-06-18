package SRC.ALGORITHM;
import java.util.Arrays;

public class Searching {
    //LINRAR SEARCH 
    public  int arrayLinearSearchIterative(int item, int[] array){
        /*
        [1,2,3,4,5,6,7,8,9]
         |
         ptr  --> move the ptr over array and search element


         TIME : O(n)  -- iterate till end
         SPACE: O(1)  -- no extra memory required wrt to ip
         */

        if(array == null){throw  new IllegalArgumentException();}//Edge case(array is null)


        for (var i = 0; i < array.length ; i++){
            if(array[i] == item)
                return i;
        }

        return -1;



    }
    public  int arraylinearSearchRecursive(int item ,int[] array , int ptr){
        /*
        LOOK IN RECURSION
         */
        return 0;
    }


    //LINRAR SEARCH
    public  int arraytwoPointerSearchIterative(int item,int[] array){
        /*
        [1,2,3,4,5,6,7,8,9]
         |                |
         left            right   --> while  left < right
                                         move left right simultaneouisly

         TIME : O(n)  -- iterate till end
         SPACE: O(1)  -- no extra memory required wrt to ip

         */
        int left  = 0;
        int right = array.length-1;

        while(left < right){
            if(array[left] == item ){
                return left;
            }
            if (array[right] == item){
                return right;
            }

            left++;
            right--;
        }

        return -1;
    }
    public  int arraytwoPointerSearchRecursive(int item , int[] array , int left , int right){
        /*
        LOOK IN RECURSION
        */
        return 0;

        }
   

    //BINARY SEARCH( ARRAY MUST BE SORTED) --> DIVIDE AND CONQUER
    public  int arrayBinarySearchIterative(int[] array , int item){
     /*
       [1,2,3,4,5,6,7,8,9]
        |        |      |
        left    middle  right   --> while left <= right   
                = (l+r)/2          
                                    if item == middle
                                        ret middle
                                    else if item < middle
                                       check on left by reassign right = middle-1 , middle = l+r/1
                                   else if item > middle
                                       check on right by reassign left = middle+1 , middle = l+r/1
                                   |
                                   else if because l,r is used in if cond and updates inside if
                                    //OPTIMIZATION TO PREVENT OVERFLOW:
                                   mid = (l + r)/2  = l + (r-l)/2  
                                   Eg consider int size to be 5 not 10^9
                                   (l+r)/2  = (3+5)/2  8/2    8 >5 so overfof
                                   l + (r-l)/2  = 3 + (2)/2   no overflow here
                          
                                    //ALWAYS DO CALCULATIONS  EXPLICITLY TO BE SAFE MIDDLE YPU CAN TAKE FOR GRANTED
                                    int a = (int)7/3  ; float a = (int)7/3   ; double a = 7/3  ;;int a = Math.ceil((double)7/3)                                                               
                                    int mid = l + (r-l)/2   will return value before decimal                                

             
          
         TIME : O(log2 n)  -- iterate till end and throw half data at each iteratiojn
         SPACE: O(1)       -- no extra memory required wrt to ip
    


     */

        Arrays.sort(array);
        int left = 0;
        int right = array.length-1;



        while (left< right){
            int middle = left + (right-right)/2;  //OPTIMIZATION TO PREVENT OVERFLOW AND SHIFT MIDDLE CALCULATION ON TOP
            if(array[middle] == item)
                return middle;

            if(item > array[middle] ){
                left = middle+1;
            }

            else if(item < array[middle] ){
                right = middle-1;
            }
        }
        return -1;

    }
    public  int arrayBinarySearchRecursive(int[]array , int item, int left , int right){
        /*
        Look in recursion
        */
        return 0;

    }
  

    //TERNARY SEARCH( ARRAY MUST BE SORTED) --> DIVIDE AND CONQUER
    public int arrayTernarySearchIterative(int[] array , int item){
        /*
        [1, 2, 3,  4, 5, 6, 7, 8, 9, 10]
         |     |          |           |
         left  middle1  middl2      right-----.> while(left < right)
         partition= (r-l)/3                        if(item == middle1)
         m1 = l + partition                            ret middle1
         m2 = r - partition                     if(item == middle2 )
                                                       ret middle2
                                                else if (item < middle)
                                                      check on left by reassign left = left right = middle1-1 , p = , m1 = m2 =
                                                else if (middle1<item < middle2)
                                                        check  by reassign left = middle+1 ,right = middle2-1 ;p = , m1 = m2 =
                                                else if(item > middle2)
                                                 |  check on right by reassigning left = middle2 + 1 ,right = right p = , m1 = m2 =
                                                 |
                                                 else if because ptrs are usd in if cond and changing in ifcond
        
          
         TIME : O(log3 n)  -- iterate till end and throw one-third data at each iteration
         SPACE: O(1)       -- no extra memory required wrt to ip
          
         */

        int left  = 0;
        int right = array.length-1;
        int partiion = (right-left)/3;
        int middle1 = left+partiion;
        int middle2 = right - partiion;



        while (left < right){
            if (array[middle1] == item)
                return middle1;

            if (array[middle2] == item)
                return middle2;



            if(item < array[middle1]){
                right = middle1-1;
                partiion = (right-left)/3;
                middle1 = left+partiion;
                middle2 = right - partiion;
            }

            else if(array[middle1] <item && item < array[middle2]){
                left = middle1+1;
                right = middle2-1;
                partiion = (right-left)/3;
                middle1 = left+partiion;
                middle2 = right - partiion;
            }

            else {
                left = middle2+1;
                partiion = (right-left)/3;
                middle1 = left+partiion;
                middle2 = right - partiion;
            }
        }

        return -1;

    }
    public int arrayTernarySearchRecursion(int[] array , int item , int left , int right){
        /*
        Look in recursion
        */
        return 0;

    }
    

    //JUMP SEARCH(ARRAY MUST BE SORTED) -->  DIVIDE AND CONQUER
    public  int arrayJumpSearchIterative(int[] array , int item){
        /*
        [ 1,2,3,4,5,6,7,8,9,10]
          |           |
          start       end     -------->1.INITIALISE start and end
          start =0                       while end < arr.length && arr[end-1] < item
          end = Math.sqrt(item)  +1         look after after box by reassign start = next , next = start+Math.sqrt(item)
                                             if(end >arr.lemgth) end = arr. length-1
                                        2.PERFORM SEARCH OPERATION IN START TO end-1
                                          From start to next-1 perform any search operaion
         
         TIME : O(sqrt(n))  -- jump  using sqrt 
         SPACE: O(1)       -- no extra memory required wrt to ip
         */
        Arrays.sort(array);


        int boxSize = (int) Math.sqrt(item);
        int start = 0;
        int end = start + boxSize;

        while (end <= array.length-1 && array[end-1] < item){
            start = end;
            end = end + boxSize;
            if(end >=array.length)
            end = array.length-1;
        }


        for(var i = start;i<=end-1;i++){
            if(array[i] == item){
                return i;
            }
        }

        return -1;
    }

    //EXPONENTIAL SEARCH(ARRAY MUST BE SORTED)--> DIVIDE AND CONQUER
    public int arrayExponentialSearchIterative(int[] array , int item){
        /*
        [ 1,2,3,4,5,6, 7,8,9,10]
          | |
          start  end   ----> 1.INITIALISE START,END
                             while(end < arr.length && end < item)
                              reassign end by end = end*2
                               if(end >  arr.length-1)end = arr.length - 1
                           2.PERFORM SEARCH OPERATION IN start = end/2 TO end = end
                            from end/2  to end perform any search operaion

          
         
         TIME : O(log2 i)  -- jump till index i exponentially 
         SPACE: O(1)       -- no extra memory required wrt to ip

         */
        Arrays.sort(array);

        int start = 0;
        int end  =1;
        while(end <= array.length-1 && array[end] < item){
            end = end*2;
        }

        if(end >= array.length)
        end = array.length-1;

        start = end/2;
        end = end;

        return arrayBinarySearchRecursive(array,item,start,end);


    }

}



