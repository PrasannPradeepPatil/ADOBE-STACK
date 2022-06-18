package SRC.MISCALLENOUS;

class MatrixIterator {

    /*
    [[1,2],[3,4],[],[],[5,6],[]]
    
    matrixIteratot(int[][] arr) : initializes 2D array.
    next()                      : returns the next element from the 2D array and moves the pointer one step forward. You may assume that all the calls to next are valid.
    hasNext()                   : returns true if there are still some elements in the arr, and false otherwise
                                Eg:
                                int[][] arr = new int[][]{{1,2},{3,4},{},{},{5,6},{}}
                                MatrixIterator matrixIterator = new MatrixIterator(arr);
                                while(imatrixIterator.hasNext()){
                                   res.add(matrixIterator.next())
                                }
                                return res; -->[1,2,3,4,-1,-1,5,6,-1,-1]

    */
    
    int ptrInner;
    int ptrOuter;
    int[][] arr;

    //CONSTRUCTOR
    public MatrixIterator(int[][] arr) {
        /*
        [[1,2],[3,4],[],[],[5,6],[]]
         | |
   ptrOuter ptrInner -- initialise arr , ptrInner, ptrOuter
   
        */
        this.arr = arr;
        this.ptrInner = 0;
        this.ptrOuter = 0;
    }
    
   
    //NEXT
    public int next() {
        /*
       [[1,2],[3,4],[],[],[5,6],[]]
         ||
ptrOuter ptrInner --  if (!hasNext()){                 --if next element               
                         return -1;}                       return -1
                         
                      return arr[ptrOuter][ptrInner++]; --return arr[ptrOuter][ptrInner]
                                                          move ptrInner ahead
                                                          
        Time:O(m/n) -->CALL moveToNextAvailableElement() internally
        Space:O(1)
        */
        if (!hasNext()){return -1;}                   
        
        return arr[ptrOuter][ptrInner++];
    }


    //HASNEXT
    public boolean hasNext() {
        /*
        [[1,2],[3,4],[],[],[5,6],[]]
         ||
ptrOuter ptrInner -- moveToNextAvailableElement()      --move to next available element
                      return ptrOuter <= arr.length-1; --if ptrOuter is in bounds return true

        Time:O(m/n) -->CALL moveToNextAvailableElement() internally
        Space:O(1)         
                                
                                
        
        */
        
       
        moveToNextAvailableElement();
        return ptrOuter <= arr.length-1;
    }
    public void moveToNextAvailableElement(){
        /*
        [[1,2],[3,4],[],[],[5,6],[]]
         ||
ptrOuter ptrInner -- while ( ptrInner == arr[ptrOuter].length) && ptrOuter <=arr.length-1) { --if inner ptr reached end and outer ptr is in bounds 
                        ptrInner = 0;                                                             move ahead by resetting ptrInner and incrementing ptrOuter 
                        ptrOuter++;                                                            (convert if to while will help skip empty arrays)
                     }
                     
        Time :O(m/n) -->m = number of inner arrays ;n = total number of integers  
        Space:O(1)     Eg consider  [[1,2],[3,4],[],[],[],[]] m = 6, n = 4
                            MatrixIterator matrixIterator = new MatrixIterator(arr);
                                while(imatrixIterator.hasNext()){
                                   res.add(matrixIterator.next())
                            }
                             Go to 1 Call moveToNextAvailableElement()
                             Go to 2 call moveToNextAvailableElement()
                             Gp to 3 call moveToNextAvailableElement()
                             Go to 4 call moveToNextAvailableElement()
                             Go to [] call moveToNextAvailableElement() now this fn will iterate till end skipping empty arrays 

                             So in total we iterated  n+m times(n for each elements + m  consider all inner arrays are empty then we need to iterate all inner arrays )
                             But we called the fn moveToNextAvailableElement() only n times
                             Time = n+m/n = m/n

 

                             



                       
    */
        while(ptrOuter <=arr.length-1 && ptrInner == arr[ptrOuter].length) {
            ptrInner = 0;
            ptrOuter++;
        }
    } 
}
