package SRC.ARRAYDEQUE;
import java.util.Arrays;
import java.util.LinkedList;

public class ArrayDequeue_UsingLinkedList {
    /*
    QUEUE(FIFO)
    [1,2,3,4,5,6,7,8]
     |               |
    elements removed elements added
    from rear        in front

     */

     //CONSTRUCTOR
    LinkedList<Integer> list ;
    public ArrayDequeue_UsingLinkedList(){
        /*
        |||
         */

        list = new LinkedList<>();

    }


    //LOOKUP
    public int peek(){
        /*
        |v|n| -->|v|n|
            |
            getFirst from LL
            //EDGE CASE: check If LL is empty then return -1

        TIME :O(1)
        SPACE:O(n)    
            */

        if(list.isEmpty())
            return -1;

        return list.getFirst();
        }
    public boolean contains(int item){
        /*
        |v|n| -->|v|n|
            |
            check if LL contains item
            //EDGE CASE: check If LL is empty then return -1

        TIME :O(1)
        SPACE:O(n)    
            */

        if(list.isEmpty())
            return false;

        return list.contains(item);
    }
        
    //INSERT
    public void add(int item){
        /*

        |v|n| -->|v|n|
                   |
                   addLast to LinkedList
                   //EDGE CASE:No method to check if LinkedList isFull
        TIME :O(1)
        SPACE:O(n)
         */

        list.addLast(item);
    }
    public void remove(){
       /*
        |v|n| -->|v|n|
          |
         remove first from lnkedList
         //EDGE CASE: check if LL is empty then throw ISE8(
        
        TIME :O(1)
        SPACE:O(n) 
        */

       //EDGE CASE
        if(isEmpty()){throw new IllegalStateException();}

        list.removeFirst();
    }
    

    //SIZE
    public boolean isEmpty() {
        /*
        |||
        |
        check if LL is empty
        //EDGE CASE:Check if quqeue is emoty not req here
        
        TIME :O(1)
        SPACE:O(n)
        
        */
        return list.isEmpty();
    }
    public boolean isFull(){
        /*
        No method to check isFull() in LL
        
        TIME :O(1)
        SPACE:O(n)
        */
        return false;
    }
    public int size(){
        /*
        |v|n| -->|v|n|
          |
        return size of LinkedList
        
        TIME :O(1)
        SPACE:O(n)
         */

        return list.size();
    }


}
