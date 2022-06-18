package SRC.PRIORITYQUEUE_HEAP;
public class Heapify {

    /*
    HEAPIFY
    [3,2,1,4,5,6]  -- change array in place to resembleBinary MaxHeap

     */


    private  void heapifyForElement(int[] array, int parentIndex) {
        /*
        [3,2,1,4,5,6]
             |   |  |
            pi   li ri
            LI          -- if element at LI < element at li and li < arr.length
                                 LI = li
                          if element at RI > element at ri and ri > arr.lemgth
                                  LI = re
                          if  LI = pi then LI has not moved hence element at LI > element at le and element at ri
                                return

                          swap(pi, LI)
                          heapify(arr,LI) -- recursively call by LI as the new pi
            
        TIME: O(log n)  each fn calls itself once and n reduces by half
        SPACE:O(n) as we have n ips
        */


        //
        var largerChildIndex = parentIndex;
        var leftChildIndex = parentIndex * 2 + 1;
        var rightChildIndex = parentIndex * 2 + 2;

        if (array[largerChildIndex] < array[leftChildIndex]  && leftChildIndex < array.length )
            largerChildIndex = leftChildIndex;
        if (array[largerChildIndex] < array[rightChildIndex]  && rightChildIndex < array.length )
            largerChildIndex = rightChildIndex;
        if (largerChildIndex == parentIndex )
            return;


        //swap(array, parentIndex, largerChildIndex);
        heapifyForElement(array, largerChildIndex);





    }
    public void heapify(int[] array) {
        /*
        TIME: O(n log n)  where O(log n) for recursion ;O(n) for loop 
        SPACE:O(n)        where O(n) for recursion
        */

        //Heapify for every element on array
        for (var i = 0;i< array.length; i++)
            heapifyForElement(array, i);
    }




}
