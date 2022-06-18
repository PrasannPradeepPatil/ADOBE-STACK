package SRC.STACK;


public class MiddleStack_UsingDoubleLinkedList {
    /*
        2 -support all stack operation and also provide getMiddle() in O(1)
        --
        3
        --
        4


     */

    //NODE CLASS
    public class Node {
        /*
           |prev|value| next|
         */

         private int val;
         private Node next;
         private Node prev;
         public Node() {}//this.value = 0 ; this.next = null(constructor initialises default values)
         public Node(int val) { this.val = val;} // this.next = null(constructor initialises default values)
         public Node(int val, Node next) { this.val = val; this.next = next; }
     }

    //CONSTRUCTOR              
    private Node head;       
    private Node tail;
    private Node mid;     
    private int count;
    public MiddleStack_UsingDoubleLinkedList(){       
        head = null;  
        tail = null;
        mid = null;
        count =0;}        

    

    //INSERT
    public void push( int val){
        /*
        |p|val|n|
        /         \
       /           \
      null       |p|1|n|  --|p|1|n|
                   |
                  head                  --initialise newNode
                                          connect newNode ka next to head 
                                          connect newNpode ka  prev to null
                                          connect head ka prev to newNode if head is not null

                                          increment count
                                          reassign mid to to new node if count =1 
                                          reassign mid to mid   if count is even 
                                          reassign  mid to prev if count is odd 

                                          reassign head to new node


                                               


        TIME  : O(1)
        SPACE : O(n)  
        
        */
 

        Node newNode = new Node(val);
        newNode.prev = null;
        newNode.next = head;
        if(head != null){head.prev = newNode;}
   
 
        count ++;
        if (count == 1) {
            mid = newNode;
        }
        else if (count % 2== 0){
            mid = mid;
        }
        else if(count %2 != 0){
            mid = mid.prev;
        }
           
               
        

        head = newNode;
    }
    public int pop(){
        /* 
        |p|1|n|  --|p|1|n|
         |
          head      store head value       
                    move head ahead
                    connect head.prev to null if head is not null

                    decrement count
                    reassign mid to next if count is even 
                    reassign mid to mid if count is odd

                    return stored value

                    //EDGE CASE: if isEmpty(){return -1}

        TIME  : O(1)
        SPACE : O(n) 

          */
        if (isEmpty()) {
            return -1;
        }
 
     
        int item = head.val;
        head = head.next;
        if (head != null){ head.prev = null;}
          
 
        count =count-1;
        if (count % 2 == 0)
            mid = mid.next;
        else if(count %2 != 0){
            mid = mid;
        }
 
        return item;
    }
 

    //SIZE
    public boolean isEmpty(){

        /*
        |||
        |
        head --return count == 0
        */
        return count ==0;
    }

    //GETMIDDLE
    public int getMiddle(){
        /*
        |p|3|n|  --|p|2|n| -- |p|1|n|
                        |        |
                        mid      head --return mid value
                                    //EDGE CASE: if isEmpty(){return -1}

        TIME  : O(1)
        SPACE : O(n)  
        
        */
        if (isEmpty()) {
            return -1;
        }

        return mid.val;
    }


}

 
