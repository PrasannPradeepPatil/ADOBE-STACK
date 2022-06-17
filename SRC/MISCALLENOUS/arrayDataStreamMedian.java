package MISCALLENOUS;
import java.util.*;
public class arrayDataStreamMedian {
    /*
    arrayDataStreamMedian() initializes the  object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far.
                        median is the median of the sorted array
                        median of odd numbers is middle element ; median of even no is avg of 2 middle elements
    */

    //USING INSERTION SORT
    /*
    //CONSTRUCTOR
    List<Integer> list;
    int medianptr ;
    double median;
    public arrayDataStreamMedian() {
        list = new ArrayList<>();      --initialise list , medianptr , median
        medianptr = 0;
        median = (double) 0.0;
    }
    
    public void addNum(int num) {
                                                     //ADD TO LIST IN SORTED MANNER
        int ptr = 0;                               --add elememnt to list at the correct index
        while(ptr <= list.size() -1){                NOTE: We can find index BY BS and improve time from O(n) to O(log n)
           if(num <= list.get(ptr)){                       but we later do insertion which is O(n) 
               list.add(ptr,num);                          So O(n + n) = O(n + logn)
               break;
           }
            ptr++;
        }
        if(ptr == list.size()){
            list.add(num);
        }
                                                          //SEARCH MEDIAN IN LIST
        if(list.size() == 1){                            --if list size is 1 
            median = list.get(0);                             median is o0th element
        }                                                  else if list size is even
         else if(list.size()% 2 == 0){                        median is mean of medianPtr and medianPtr+1
             double num1 = (double)(list.get(medianptr));   else if list size is odd
             double num2 = (double)(list.get(medianptr+1));     median is medianPtr+1 
             median = (double)((num1+ num2)/2);                 also increase median ptr
         }
        else if(list.size()% 2 !=0){
            median = (double)(list.get(medianptr+1));
            medianptr++;
            
        }
    }

    Time:O(n + n) as we iterate through whole array to insert and then insert at the position
    Space:O(n) as we use list
    
    public double findMedian() {
        return median;                                  --return median
    }

    Time:O(1)
    Space:O(n) as we use lst
    */


    //USING HEAPS
    /*
    //CONSTRUCTOR
    List<Integer> list;                                  --initialise list , medianptr , median
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;
    public MedianFinder() {
        list = new ArrayList<>();                       
        minHeap = new PriorityQueue<>((Integer val1,Integer val2) ->{return val1-val2;});
        maxHeap = new PriorityQueue<>((Integer val1,Integer val2) ->{return val2-val1;});
    }


    
    public void addNum(int num) {
        maxHeap.add(num);                              --add num to maxheap                 
                                                         remove from maxHeap and add to minHeap
        minHeap.add(maxHeap.remove());                   balance maxHeap and minHeap because maxHeap must have 1 element extra

        if (maxHeap.size() < minHeap.size()) {          
            maxHeap.add(minHeap.remove());
        }  
        
        Time :O(5logn) -- for each element we can at max have 3 insertion + 2 deletions each having log n
        Space:O(n) as we use 2 minHeaps and list
    
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size() ){        --if maxHeap size > minHeap size
            return (double) maxHeap.peek();                means maxHeap has 1 element extra which is medianm
        else                                           else
            return (double)(((double)minHeap.peek()        means maxHeap minHeap have equal elements and top of both is median
                   + (double)maxHeap.peek())/2);            /
        }                                                  /
        Time :O(1) -- as we peek top elements in heap     /
        Space:O(n) as we use 2 minHeaps and list         /
                                                        /
    }                                                  / 
                                                      /
    EXPLANATION:-------------------------------------/
    maxHeap stores all elements smaller that median;minHeap stores all elements smaller that median;
    
    At evey addition we add element to maxHeap 
    Then remove maxElement from top of maxHeap and add to minHeap because minHeap stores larger number
    Then balance heaps because maxHeap minHeap must have equal size for even elements and maxHeap must have 1 extra for odd eleme ts

    At every addition 
    For even elements: maxHeap and minHeap have equal elements ; top 2 elements are median
    For odd elemenst : maxHeap has 1 element extra ;top element of maxHeap is median

    EG:
    Consider [41,35,62,4,97,108]

    Element:41
    MaxHeap  : [41]  
    MinHeap  : []
    Median is 41

    Element:35
    MaxHeap  : [35]  
    MinHeap  : [41]
    Median is 38

    Element:62
    MaxHeap  : [41,35]  
    MinHeap  : [62]
    Median is 38

    Element:4
    MaxHeap  : [35,4]  
    MinHeap  : [41,62]
    Median is 38

    Element:97
    MaxHeap  : [41, 35, 4]  
    MinHeap  : [62, 97]
    Median is 41

    
    Element:108
    MaxHeap  : [41, 35, 4]  
    MinHeap  : [62, 97, 108]
    Median is 51.5

                                        


    
    */
}

