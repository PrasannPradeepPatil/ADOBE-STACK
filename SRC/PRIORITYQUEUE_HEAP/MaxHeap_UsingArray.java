package SRC.PRIORITYQUEUE_HEAP;
import java.util.Arrays;

public class MaxHeap_UsingArray {
    /*
     MAXHEAP
     20    --> value of node is greater than  all its children; hence tree has max value at top
     / \       Tree must be complete
    10  15
   / \   / \
   4  5  6  7

     */

     //CONSTRUCTOR
    private int[] array ;
    private int ptr;
    public MaxHeap_UsingArray(int size){
        /*
        [0,0,0,0]
          |
        ptr

         */
        array = new int[size];
        ptr = 0;
    }

    //LOOKUP
    public int peek(){
        /*
        20    --> [20,10,15,4,5,6,7]
        / \                         |
        10  15                      ptr -- return a[0] 
        / \   / \                  //EDGE CASE : array is empty throw ISE
        4  5  6  7

         */

        if (isEmpty()) {
            throw new IllegalStateException();}

       return array[0];





    }
    public boolean contains(int item){
          /*
        20    --> [20,10,15,4,5,6,7]
        / \                         |
        10  15                      ptr -- iterate 0 to ptr exclusive if array contains element return true
        / \   / \                  //EDGE CASE : array is empty throw ISE
        4  5  6  7

         */
        //edge case
        if (isEmpty()) {
            throw new IllegalStateException();}

        for(int i =0 ; i < ptr ; i++){
            if(array[i] == item){}
            return true;
        }

       return false;
    }

    //INSERT
    private class Helper{
        private void swap(int first, int second) {
            var temp = array[first];
            array[first] = array[second];
            array[second] = temp;
        }
        //TREE WRT ARRAY INDEX
        private int parentindex(int childIndex) {
           /*
            20    --> [20,10,15,4,5,6,7]
            / \            |    | |      |
            10  15       pi      ci     ptr      --parentindex = (childindex - 1)/2
            / \   / \
            4  5  6  7
         */

            return (childIndex - 1) / 2; }
        private int leftChildIndex(int parentIndex) {
          /*
            20    --> [20,10,15,4,5,6,7]
            / \            |     |      |
            10  15        pi     li     ptr  leftChildIndex = parentdindex*2 + 1
            / \   / \
            4  5  6  7
         */
            return parentIndex * 2 + 1;
        }
        private int rightChildIndex(int parentIndex) {
         /*
            20    --> [20,10,15,4,5,6,7]
            / \            |      |       |
            10  15         pi    ri      ptr--rightChildIndex = parentdindex*2 + 2
            / \   / \
            4  5  6  7
         */
            return parentIndex * 2 + 2;
        }
        private int largerChildIndex(int parentIndex) {
            /*
            20    --> [20,10,15,4,5,6,7]
            / \              |      | |   |
            10  15           pi     li ri ptr  if parent does not have leftchild
            / \   / \                              return parentIndex
            4  5  6  7  /                       if parent does not have rightChild
                                                   return leftchildIndex
                                                 else
                                                   return leftchildIndex, rightchildIndex depending upon which  element of both index is greater

           */

            if (!(parent_has_leftchild(parentIndex)))
                return parentIndex;
            if (!(parent_has_rightchild(parentIndex)))
                return leftChildIndex(parentIndex);
            return array[leftChildIndex(parentIndex)]> array[rightChildIndex(parentIndex)] ? leftChildIndex(parentIndex): rightChildIndex(parentIndex);


        }
        //TREE WRT ARRAY CONDITIONS
        private boolean parent_has_leftchild(int parentIndex){
            /*
            20    --> [20,10,15,4,5,6,7]
            / \              |      |     |
            10  15           pi     li    ptr  --lefttchildIndex(parentIndex) <= ptr
            / \   / \
            4  5  6  7
           */

            return leftChildIndex(parentIndex) <= ptr;}
        private boolean parent_has_rightchild(int parentIndex){
            /*
            20    --> [20,10,15,4,5,6,7]
            / \              |        |   |
            10  15           pi       ri ptr  --rightchildIndex(parentIndex) <= ptr
            / \   / \
            4  5  6  7
           */
            return rightChildIndex(parentIndex) <= ptr;}
        private boolean isValidParent(int parentIndex) {
           /*
            20    --> [20,10,15,4,5,6,7]
            / \              |      | |   |
            10  15           pi     li ri ptr  if parent does not have leftchild
            / \   / \                              no need to move so  return true
            4  5  6  7  /                       if parent does not have rightchild
                                                    move depending on whether element  at parentindex > element at leftchildindex
                                                 else
                                                  we have to move depending upon element at parentindex > element at leftchildIndex element at rightChildIndex

           */
            if (!(parent_has_leftchild(parentIndex)))
                return true;
            if(!(parent_has_rightchild(parentIndex))){
                return array[parentIndex] >= array[leftChildIndex(parentIndex)];}

            return array[parentIndex] >= array[leftChildIndex(parentIndex)]
                    && array[parentIndex] >= array[rightChildIndex(parentIndex)];


        }

        //BUBBLE UP , BUBBLEDOWN
        private void bubbleUp() {
            /*
       |--- 20     [20,10,15,22] --> while ptr2 > 0 and ptr2 > parent of ptr2
       |    / \               |  |        swap ptr2 and parent of ptr2
       |-- 10  15           ptr2 ptr      move pr2 to parent of ptr2
       |    /
       |-- 22

           */
            var ptr2 = ptr - 1;
            while (ptr2 > 0 && array[ptr2] > array[parentindex(ptr2)]) {
                swap(ptr2, parentindex(ptr2));
                ptr2 = parentindex(ptr2);

            }
        }
        private void bubbleDown() {
            /*
         |---8     [8,15,9,12,10,3,4] --> while ptr2 <= ptr and ptr2 is not a valid parent
         |   /  \   |                 |         swap ptr2 and largerChild of ptr2
         -- 15    9  ptr2             ptr       move ptr2 to largerchild of ptr2
         |  / \   / \
         --12  10 3  4
           /
           1

           */
            var ptr2 = 0;
            while (ptr2 <= ptr && !isValidParent(ptr2)) {
                var largerChildIndex = largerChildIndex(ptr2);
                swap(ptr2, largerChildIndex);
                ptr2 = largerChildIndex;
            }
        }

    }
    public void add(int value) {
      /*
       INSERT IN BINARY MAX HEAP
        20    --> To mantain node greater than all subnodes add and bubbUp
        / \        EG:Lok in VISUALIZATION --BNARY HEAP TREE
        10  15
        / \   / \
        4  5  6  7

      */

        /*
        20    --> [0,0,0,0]
        / \         |
        10  15     ptr -- put value at ptr and increment ptr and bubbleup
        / \   / \         //EDGE CASE : array is full throw ISE
        4  5  6  7

        TIME :O(log n) because while doing bubble up you throw half of ip
        SPACE :O(n)

         */
        //EDGE CASE
        if (isFull()) {
            throw new IllegalStateException();}

        array[ptr] = value;
        ptr++;
        Helper h = new Helper();
        h.bubbleUp();
    }
    public int remove() {
        /*
       REMOVE IN BINARY MAX HEAP
        20    --> To mantain node greater than all childnodes
        / \        remove topnode put leafnode therethen bubbledown the topnode
        10  15     EG:Lok in VISUALIZATION --BNARY HEAP TREE
        / \   / \
        4  5  6  7
       */

       /*
        20    --> [20,10,15,4,5,6,7]
        / \                         |
        10  15                      ptr -- return a[0] ; decrement ptr ant put a[0] = a[ptr] and bubbledown
        / \   / \                  //EDGE CASE : array is empty throw ISE
        4  5  6  7

        TIME :O(log n) because while doing bubble down you throw half of ip
        SPACE :O(n)

        */
        if (isEmpty()) {
            throw new IllegalStateException();}

        var storer = array[0];
        ptr--;
        array[0] = array[ptr];
        Helper h = new Helper();
        h.bubbleDown();
        return storer;
    }
  

    //SIZE
    public boolean isEmpty() {
        /*
        -     [0,0,0,0]
        /\     |
       -  -     ptr -- if ptr at 0 then empty
                         //EDGE CASE : array is empty not req here
        TIME :O(1)
        SPACE :O(n)
        */
        return ptr == 0;
    }
    public boolean isFull() {
        /*
        20    --> [20,10,15,4,5,6,7]
        / \                         |
        10  15                      ptr --ptr at arr.length
        / \   / \                       //EDGE CASE : array is full not req here
        4  5  6  7
     
     TIME :O(1)
     SPACE :O(n)
        
        */


        return ptr == array.length; }
    public int size() {
            /*
            20    --> [20,10,15,4,5,6,7]
            / \                         |
            10  15                      return ptr
            / \   / \                   //EDGE CASE : array is empty not req here
            4  5  6  7
         
         TIME :O(1)
         SPACE :O(n)
            
            */
    
    
            return ptr ; }
    

    //MAX
    public int max() {
      /*
        20    --> [20,10,15,4,5,6,7]
        / \        |
        10  15     ptr -- a[0] returns top element which is max element
        / \   / \         //EDGE CASE : array is empty  throw ISE
        4  5  6  7

        TIME:O(1)
        SPACE:O(n)
         */
      //EDGE CASE
        if (isEmpty())
            throw new IllegalStateException();

        return array[0];
    }


   
}
