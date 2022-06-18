package SRC.PRIORITYQUEUE_HEAP;

import java.util.Arrays;

public class MinHeap_UsingArray {

     /*
      MINHEAP
      4    --> value of node is smaller than  all its children; hence tree has min value at top
     / \       Tree must be complete
    5    6
   / \   / \
   7  8  9  10


     */


     //CONSTRUCTOR
    private int[] array;
    private int ptr;
    public MinHeap_UsingArray(int size){
        /*
        [0,0,0,0]
         |
         ptr
         */
        array = new int[size];
        ptr =0;
    }

    //LOOKUP
    public int peek(){
        /*
         4       [4,5,6,7]-
         / \               |
         5  6              ptr  -- return a[0] 
        / \  / \                    //EDGE CASE: If arr is empty return ISE
        7  8 9  10

        TIME :O(1)
       SPACE :O(n)
        */

        if (isEmpty())
            throw new IllegalStateException();

        return array[0];




    }
    public boolean contains(int item){
        /*
         4       [4,5,6,7]-
         / \               |
         5  6              ptr  -- iterste from 0 to ptr exclusive if array contains item return true
        / \  / \                    //EDGE CASE: If arr is empty return ISE
        7  8 9  10

        TIME :O(1)
       SPACE :O(n)
        */

        //EDGE CASE
        if (isEmpty())
            throw new IllegalStateException();

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
             4       [4,5,6,7,8,9,10]-
             / \        |   | |         |
             5  6       pi   ci          ptr --parentindex = (childindex - 1)/2
            / \  / \
            7  8 9  10

             */


            return (childIndex - 1) / 2;
        }
        private int leftChildIndex(int parentIndex) {
            /*
             4       [4,5,6,7,8,9,10]-
             / \        |   |          |
             5  6       pi  li          ptr --leftChildIndex = parentdindex*2 + 1
            / \  / \
            7  8 9  10

             */
            return parentIndex * 2 + 1;
        }
        private int rightChildIndex(int parentIndex) {
            /*
             4       [4,5,6,7,8,9,10]
             / \        |     |       |
             5  6       pi    ri     ptr --rightChildIndex = parentdindex*2 + 2
            / \  / \
            7  8 9  10

             */
            return parentIndex * 2 + 2;
        }
        private int smallerChildIndex(int parentIndex) {
             /*
             4       [4,5,6,7,8,9,10]
             / \          |     |  |   |
             5  6         pi    li ri   ptr --if parent does not have leftchild
            / \  / \                               return parentIndex
            7  8 9  10                         if parent does not have rightChild
                                                     return leftchildIndex
                                                 else
                                                     return leftchildIndex, rightchildIndex depending upon which  element of both index is snaller

             */

            if (!parent_has_leftchild(parentIndex))
                return parentIndex;

            if (!parent_has_rightchild(parentIndex))
                return leftChildIndex(parentIndex);

            return array[leftChildIndex(parentIndex)]< array[rightChildIndex(parentIndex)]
                    ? leftChildIndex(parentIndex)
                    :rightChildIndex(parentIndex);



        }
        //TREE WRT ARRAY CONDITIONS
        private boolean parent_has_leftchild(int parentIndex) {
          /*
             4       [4,5,6,7,8,9,10]
             / \          |      |       |
             5  6         pi     li     ptr --lefttchildIndex(parentIndex) <= ptr
            / \  / \
            7  8 9  10

             */
            return leftChildIndex(parentIndex) <= ptr;
        }
        private boolean parent_has_rightchild(int parentIndex) {
           /*
             4       [4,5,6,7,8,9,10]
             / \        |     |       |
             5  6       pi    ri     ptr --rightchildIndex(parentIndex) <= ptr
            / \  / \
            7  8 9  10

             */
            return rightChildIndex(parentIndex) <= ptr;
        }
        private boolean isValidParent(int parentIndex) {
            /*
             4       [4,5,6,7,8,9,10]
             / \          |     |  |   |
             5  6         pi    li ri  ptr -- if parent does not have leftchildr
            / \  / \                                no need to move so  return true
            7  8 9  10                           if parent does not have rightchild
                                                   move depending on whether element  at parentindex <= element at leftchildindex
                                                 else
                                                  we have to move depending upon element at parentindex <= element at leftchildIndex and element at rightChildIndex
             */
            if (!parent_has_leftchild(parentIndex))
                return true;

            if(!(parent_has_rightchild(parentIndex)))
                return array[parentIndex] <= array[leftChildIndex(parentIndex)];


            return array[parentIndex] <= array[leftChildIndex(parentIndex)] && array[parentIndex] <= array[rightChildIndex(parentIndex)];
        }

        private void bubbleUp() {

            /*
           |--- 4     [4,5,6,2] --> while ptr2 > 0 and ptr2 < parent of ptr2
           |    / \          |  |        swap ptr2 and parent of ptr2
           |-- 5  6          ptr2 ptr      move pr2 to parent of ptr2
           |    /
           |-- 2

           */


            var ptr2 = ptr - 1;
            while (ptr2 > 0 && array[ptr2] < array[parentindex(ptr2)]) {
                swap(ptr2, parentindex(ptr2));
                ptr2 = parentindex(ptr2);
            }
        }
        private void bubbleDown() {
            /*
             |---3     [3,4,5,6,7,8,9] --> while ptr2 <= ptr and ptr2 is not a valid parent
             |   /  \   |             |         swap ptr2 and smallerChild of ptr2
             -- 4    5  ptr2          ptr       move ptr2 to smallerChild of ptr2
             |  / \  / \
             --6   7 8  9
               /
               1

           */
            var ptr2 = 0;
            while (ptr2 <= ptr && !isValidParent(ptr2)) {
                var smallerChildIndex = smallerChildIndex(ptr2);
                swap(ptr2, smallerChildIndex);
                ptr2 = smallerChildIndex;
            }
        }

    }
    public void add(int value) {
        /*
        INSERT IN BINARY MINHEAP
         4     --> To mantain node greater than all subnodes add and bubbUp
         / \       EG:Lok in VISUALIZATION --BNARY HEAP TREE
         5  6
        / \  / \
        7  8 9  10

         */

        /*
         4       [0,0,0,0]--> put value  at ptr and increment ptr and bubbleup
         / \      |           //EDGE CASE : array is full throw ISE
         5  6     ptr
        / \  / \
        7  8 9  10

        TIME :O(log n) because while doing bubble up you throw half of ip
        SPACE :O(n)
        */

        //EDGE CASE
        if (isFull())
            throw new IllegalStateException();


        array[ptr] = value;
        ptr++;
        Helper h = new Helper();
        h.bubbleUp();
    }
    public int remove() {
        /*
        REMOVE IN BINARY MINHEAP
         4     --> To mantain node less than all childnodes
         / \       remove topnode put leafnode there then bubbledown the topnode
         5  6
        / \  / \
        7  8 9  10

         */

        /*
         4       [4,5,6,7]-
         / \               |
         5  6              ptr  -- return a[0] ; decrement ptr ant put a[0] = a[ptr] and bubbledown
        / \  / \                    //EDGE CASE: If arr is empty return ISE
        7  8 9  10

        TIME :O(log n) because while doing bubble down you throw half of ip
        SPACE :O(n)
         */

        if (isEmpty())
            throw new IllegalStateException();

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
         4     --> [4,5,6,7,8,9,10]
         / \                       |
         5  6                      ptr --ptr at arr.length
        / \  / \                       //EDGE CASE : array is full not req here
        7  8 9  10

        TIME :O(1)
        SPACE :O(n)
        */

        return ptr == array.length;
    }
    public int size() {
        /*
        4     --> [4,5,6,7,8,9,10]
        / \                       |
        5  6                      ptr --return ptr
       / \  / \                       //EDGE CASE : array is empty not req here
       7  8 9  10

       TIME :O(1)
       SPACE :O(n)
       */

       return ptr ;
   }


    //MIN
    public int min() {
        /*
         4     --> [4,5,6,7,8,9,10]
         / \                       |
         5  6                      ptr --a[0] returns top element which is always min
        / \  / \                       //EDGE CASE : array is empty  throw ISE
        7  8 9  10
    
       TIME :O(1)
       SPACE :O(n)
        */
        //EDGE CASE
        if (ptr == 0)
            throw new IllegalStateException();

        return array[0];
    }







}
