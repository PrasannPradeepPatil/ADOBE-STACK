package LINKEDLIST;
import java.util.*;

//LINKED LIST DEFINATIOONS
/*
SINGLY LINKED LIST
v|n --> v|n --->v|n --> each node has a ref to next node
|               |
head            tail

DOUBLY LINKED LIST
v|n,p --> v|n,p ----->v|n,p --> each node has a ref to next node and prev node
|    <--        <--   |
head                tail


CIRCULAR LINKED LIST
v|n,p --> v|n,p ----->v|n,p  -->last node has link to head node 
| |                      |      circular LinkedList can be singly or doubly
| head                  tail 
|_________________________|



    */

//LINKEDLIST CODING CONCEPTS
/* #region Main */

//PTR AND NULL CHECK(ALWAYS REMEMBER RO RETURN IN NULL CHECKS SO THAT CODE AFTER IT IS NOT ENCOUNTERED) 
/*
//NULL CHECK BEFORE WHILE LOOP 
if(head == null){return something }
if(k>=size();k==0){}  -->rotateRightByKNodes();splitInKParts() ;reverseInKGroups()
                        [properties of rotate] [property of split from question] [property of reverse from question]



//INITIALISING
Node dummyNode = new Node(-1);dN.next = head      
Node prevptr = dummyNode      

Node ptr = head;

Node nextptrtemp = null 
                                                                
                                                                                                                                                                                                                                               
//MOVING FWD                                                            
while(ptr!=null ; ptr.next!= null ; ptr!=null && p.next!= null ; ptr != null && count <=(k)-1/(K+1)-1){     
                                CODE BEFORE MOVING PTR
                                ptr encounters till lastNode ;2nd lastNode;2nd lastNode(For even) and 3rd lastNode(For odd);k-1 /k th node;

                                CODE AT PTR
    prevptr  = ptr              ptr  enc till null ; lastNode; null(For even) and lastNode(For odd);  k/k+1 the Node      EG:removeK1IntervalK2Nodes();reverseUptoKthNode(); reverseBetweenK1K2Node() -- k+1
    nextptrTemp = ptr.next       
    ptr = ptr.next/ptr.next.next;
    cnt++                            

                                CODE AFTER MOVING PTR
                                ptr  enc till null ; lastNode;null(For even) and lastNode(For odd);  k/k+1 the Node 

}

//NULL CKECK AFTER WHILE LOOP
while(ptr!=null){ptr = ptr.next}   
if(ptr != null){ptr.next}  --null chek if(ptr == null) as ptr exits at null at end of while loop
 
while(ptr.next!=null){ptr = ptr.next} 
ptr.next                  --null chek  not req  as ptr exits at lastNode at end of while loop

while(ptr!=null && ptr.next!=null)    
if(ptr == null){}         --null check for even nodes because ptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
else if(ptr.next==null)     EG:getMiddle(),loopExists() ,loopStartNode(), 
                               reorderEvenOddNodes(),copyRandomPtrLL() usingNoHashMap[noOfNodes=even]
                                                
head = dummyNode.next;    //null check for modifying 1st/single node 
dummyNode.next = null;    //null check for attachment
return head;


*/

//PTR AND NULL CHECK FOR CIRCULAR LL(ALWAYS REMEMBER RO RETURN IN NULL CHECKS SO THAT CODE AFTER IT IS NOT ENCOUNTERED)  
/*


//NULL CHECK FOR HEAD
same as above
//NULL CHECK FOR K
same as above

//INITIALISING
Same as aboive

//MOVING FWD   
while(ptr.next != head){    
                                    //NULL CHECK IN WHILE LOOP//
                                    SAME AS ABOVE+null check  not req as ptr,prevptr,nextptrTemp can never be null as they are in loop
                                        


                                    CODE BEFORE
                                    ptr encounter till 2nd last node                            
 
    prevptr = ptr;
    nextptrTemp = ptr.next         MOVE FWD(IN ACCORDANCE TO WHILE LOOP CONDITION)
    ptr = ptr.nextk                ptr move and without encountering exit(if no code after)  at last node
                              
                                   CODE AFTER
                                   ptr encounter and  exit  at last node
}

                                   //NULL CHECK AFTER WHILE LOOP//
                                    SAME AS ABOVE+null check  not req as ptr,prevptr,nextptrTemp can never be null as they are in loop
                                    +
                                    null check if(condition for modifying1stNode){} before while loop; because ypu have to rearrange the incoming loop at 1st node also
                                    null check if(condition for modifyingLastNode){} after while loop; because  you dont encounter the last node

                                   
EG : addInCircularLL()





*/

//PTR AND NULL CHECK FOR 2 LL(ALWAYS REMEMBER RO RETURN IN NULL CHECKS SO THAT CODE AFTER IT IS NOT ENCOUNTERED)  
/*

//NULL CHECK FOR HEAD
4 combiations
//NULL CHECK FOR K
same as above

//INITIALISING
Same as aboive

                
//MOVING FWD   
while(ptr1 != null && ptr2 != null){    
                                    //NULL CHECK IN WHILE LOOP//
                                    SAME AS ABOVE 

                                    CODE BEFORE
                                    ptr1 encounter till last node,pt2 encounter till equivalent node  [ LL1 is smaller ,LL2 is smaller vice versa]                              
         


    pt1 = ; ptr2 =  ;ptr3 =         MOVE FWD(IN ACCORDANCE TO WHILE LOOP CONDITION)
                                    ptr1 move till null and exit without encountering null ,ptr2 move till equivalent node and exit without encountering equivalent node [LL1 is smaller,,LL2 is smaller vice versa]] 
                                    
                              
                                    CODE AFTER
                                    ptr1 encounter and exit at null ,ptr2 encounter at exit at equivalent node[LL1 is smaller,LL2 is smaller vice versa]]


                                    //NULL CHECK AFTER WHILE LOOP//
                                    SAME AS ABOVE 
                                    +
                                    null check if(ptr1!=null){}  for smaller LL2
                                    null check if(ptr2 !=null){} for smaller LL1
                                  
            
                                  
EG : compare2LLForAddition() ,compare2LLForAdditionOfPolynomial(), compare2LLSortedForMerging(),compare2LLForIntersectingNode()[ ptr1!=ptr2 ]; linkedListisPallindrome()



*/



/* #endregion */

public class Linkedlist_UsingNode {




    //NODE CLASS
    public class Node {
         /*
            |value| next|
          */

          private int val;
          private Node next;
          public Node() {}//this.value = 0 ; this.next = null(constructor initialises default values)
          public Node(int val) { this.val = val;} // this.next = null(constructor initialises default values)
          public Node(int val, Node next) { this.val = val; this.next = next; }
      }
    
    //CONSTRUCTOR              //INITIALISING HEAD,TAIL
    private Node head;        //LinkedList Construction:-->Compiler will call className obj = new ClassName() ; obj.methodName() so you must initialise head,tail with default values in constructor of class 
    private Node tail;       // LinkedList Methods      -->Compiler will call className obj = new ClassName() ; obj.methodName(new Node()) so compiler initialosed head,tail
    public Linkedlist_UsingNode(){       
        head = null;  
        tail = null;}        //RETURN NODES 
                             //return new Node()               -- returns Node with value=0 ,next =null
                            //return new Node(val)            -- returns Node with value=value,next = null
                            //return new Node(val,new Node()) -- returns Node with value=value,next = Node
                            //return head                     -- return entire LL
                                                                //HEAD IF PASSED AND MODIFIED ; MODIFIED HEAD MUST BE RETURNED 
                                                                //Reason:https://www.reddit.com/r/javahelp/comments/o2ghqd/removefirst_function_not_able_to_remove_the_head/?utm_medium=android_app&utm_source=share
                                                                /*
                                                                public Node mainMethod(Node head){   --> head passed and modified  X
                                                                    helperMethod(head);                
                                                                    return head
                                                                }
                                                                public void helper(Node head){
                                                                    head == null;
                                                                }

                                                                public Node mainMethod(Node head){     -- head passed and modified; modified head is returned \/
                                                                    return helperMethod(head);
                                                                }
                                                                public void helper(Node head){
                                                                    head == null;
                                                                    return head;
                                                                }

                                                                */


    public int size;  // for size() method   


    //LOOKUP
    public Node     getFirst(Node head){
        /*
        Question
        1--2--3--4--5--6--7   --return node at 1st pos
        */

     

       /*
       1--2--3--4--5-->null
        |
       head  --initialise ptr to head
               return ptr 
               //NULL CHECK FOR HEAD:if(head != null){return null }   

        TIME :O(1)  
        SPACE: O(1)
        

         */
        //NULL CHECK FOR HEAD:
        if(head == null) {return null;} 
              
        Node ptr = head;
        return ptr;

    }
    public Node     getLast(Node head){
        /*
        Question
        1--2--3--4--5--6--7   --last
        */


        /*
         1--2--3--4--5--6-nukk
         |                       
       ptr                     --initialise  ptr to head 
                                move ptr till last node(ptr to lastNode;cb enc till 2ndlastnode;ca enc till lastNode) 
                                return ptr
                                //NULL CHECK FOR HEAD:if(head != null){return null }   

        
        TIME  :O(n)/O(1)  -consodering we dont have/have tail 
        SPACE :O(1)                              
        */

        //NULL CHECK FOR HEAD
        if(head == null){return null;}  

        Node ptr = head;          
        while(ptr.next != null){
            ptr = ptr.next;            
        }      

        return ptr;

  



    }
    public Node     get(Node head , int index){
        /*
        Question
        1--2--3--4--5--6--7   --get  node at index
        index = 2 

        3
        
       */

         /*
        1--2--3--4--5--null
        |      
        ptr    -- initialise ptr to head 
                   move ptr till index(ptr to index ;cb enc till index-1;ca enc till index)
                   return ptr    
                   //NULL CHECK FOR HEAD :if(head == null){return null;}                                                                     


        TIME  :O(n)  
        SPACE :O(1)  
        */


   
        //NULL CHECK FOR HEAD
        if(head == null) {return null;}


        Node ptr = head;              
        int cnt = 0;
        while(ptr != null && cnt <=index-1){
            ptr = ptr.next;    
            cnt++;
        }

        return ptr;
        
    }
    public Node     getkthFromStart(Node head ,int k){
        /*
        Question
        1--2--3--4--5--6--7   --get kth node from start
        k = 2 

        2
        
       */

         /*
        1--2--3--4--5--null
        |      
        ptr    -- initialise ptr to head 
                   move ptr till kthNode(ptr to k ;cb enc till k-1;ca enc till k)
                   return ptr    
                   //NULL CHECK FOR HEAD :if(head == null){return null;}                                                                     


        TIME  :O(n)  
        SPACE :O(1)  
        */


   
        //NULL CHECK FOR HEAD
        if(head == null) {return null;}


        Node ptr = head;              
        int cnt = 1;
        while(ptr != null && cnt <=k-1){
            ptr = ptr.next;    
            cnt++;
        }

        return ptr;
        
 
 
 
     }
    public Node     getKthFromEnd (Node head , int k){
        /*
       Question
       1--2--3--4--5--6--7   --get kth node from end
       k = 2 

       6
       
       */

        /*
        1--2--3--4--5--null
         | |
        ptr1,ptr2  -- initialise ptr1,ptr2 to head  
                      move ptr2 till kthNode(ptr2 to k;cb enc till k-1;ca enc till k)                       
                      move ptr2 till null (ptr2 to null;cb enc till lastnode;ca enc till null); move ptr 1 
                      return ptr1
                     //NULL CHECK FOR HEAD if(head == null){return null;}                                                               

        
         
        TIME :O(n)  
        SPACE :O(1)  
        */

        //EGDE CASE
        if(head == null)  {return null;}


        Node ptr1 = head;                  
        Node ptr2 = head;
        int count =1;
        while(ptr2 != null && count <=k-1){       
            ptr2 = ptr2.next;
            count ++;
        }


        while (ptr2.next!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
    public Node     getMiddleNode(Node head){
        /*
        Question
        1--2--3--4--5--null  --return 2 middle nodes for even , 1 middle node for odd 
        3 
        */
 
         /*
         1--2--3--4--5--6--7->null  
          | |                                 
          sp fp    --initialise sp,fp to head  
                    move sp by 1 and fp by 2  untill fp does not reach null  FOR EVEN NODES(fp to null;cb enc till lastnode;ca enc till null) &&  fastptr does not reach last node  FOR ODD NODES(fp to lastNode;;cb enc till 2ndlastnode;ca enc till lastNode)  
                    if(fp == null){slowptr , prevslowptr are middleNode}       //null check for even nodes because ptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
                    else if(fp.next==null){slowptr is middleNode}              //null check for odd  nodes because ptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately  
                                                                                 (else if because if there are even nodes fastptr will be null so you dont want to check 2nd cond)



                 //NULL CHECK FOR HEAD:null check if(head == null){return null}
 
         TIME :O(n)    
         SPACE :O(1)
         */
         
         //NULL CHECK FOR HEAD
         if(head == null) { return null;}
         
         Node slowptr = head; 
         Node fastptr = head;
         Node middleptr = head;
         Node dummyNode = new Node(-1);dummyNode.next = head;
         Node prevslowptr = dummyNode;
 
         while (fastptr != null && fastptr.next != null){
             fastptr = fastptr.next.next;
             prevslowptr = slowptr;
             slowptr = slowptr.next;
         }
  
         if(fastptr == null){                //null check for even nodes because ptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
             middleptr = slowptr;
             //middleptr = prevslowptr
 
         }
         else if(fastptr.next == null) {   //null check for odd nodes because ptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
             middleptr = slowptr;          //(else if because if there are even nodes fastptr will be null so you dont want to check 2nd cond)
         }
         return middleptr;
     }
    public int      indexOf(Node head , int item){
        /*
       Question
       1--2--3--4--5--6--7   --get item ka pos
       item = 2

       2
       
       */

        /*

        1--2--3--4--5-->null
        |
        ptr --initialise ptr to head                              
              move ptr till null(ptr to null;cb enc till lastnode;ca enc till null)   =>  SO THAT PTR IS AT NULL
              if ptrs value matches item return count
              return -1

              //NULL CHECK FOR HEAD: null check if(head == null){return -1}

        
        TIME :O(n)  
        SPACE: O(1) 

         */

        //NULL CHECK FOR HEAD
        if(head == null){return  -1;}  

        Node ptr = head;               
        int cnt = 1;
        while (ptr!=null){
            if(ptr.val == item){return  cnt;}

            ptr = ptr.next;          
            cnt++;
        }
        return -1;
    }
    public int      lastIndexOf(Node head, int item){
       /*
       Question
       1--2--3--4--5--2--7   --get item ka last pos
       item = 2 
       5
       
       */



        /*
          1--2--3--4--5--6--2--7-->null
          |||
        ptr1,2,3-- initialise ptr1 and ptr2,ptr3 to head  
                   move  ptr2 till null (ptr2 to null;cb enc till lastnode;ca enc till null)  =>  SO THAT PTR2 IS AT NULL
                      if ptr2 value == item 
                         ptr1 = ptr2
                         lastcount = count                   
                    return lastcount
                    //NULL CHECK FOR HEAD: null check if(head == null){return -1}

          
 
         TIME :O(n+n)/O(n)  -consodering we dont have/have tail  
         SPACE :O(1) 
         */
         //NULL CHECK FOR HEAD
         if(head == null){ return -1;}

        Node ptr1 = head;           
        Node ptr2 = head;
        int count = 0;
        int lastCount = -1;
        while (ptr2 != null) {
            if (ptr2.val == item){
                ptr1 = ptr2;
                lastCount = count;
            }
                 
            ptr2 = ptr2.next; 
            count++;         
        }
 
 

 
 
         return lastCount;
 
 
     }
    public Node     contains(Node head , int item){
        /*
        Question
        1--2--3--4--5--2--7   --check if linkedList contains item and if present return the node/boolean 
        item = 2 

        2
        
        */

        /*
        1--2--3--4--5--6-null
         |
         ptr  -- -- initialise ptrto head     
                    move ptr till  end and (ptr to null;cb enc till lastnode;ca enc till null)  
                        if ptr ka val matches item
                        return node/true
                    return null/false
                    //NULL CHECK FOR HEAD: null check if(head == null){return -1}


        TIME :O(n) 
        SPACE: O(1)


       */

        //NULL CHECK FOR HEAD
        if(head == null){return null;} 

        Node ptr = head;                
        while (ptr!=null){
            if(ptr.val == item){return  ptr;}
            ptr = ptr.next;  
        }
        return null;
    }

    //INSERT
    public Node     addFirst(Node head,int val){
         /*
        Question
        1--2--3--4--5--6--7   --add node at 1st pos
        item = 77

        77--1--2--4--5--6--7
        
        */

        /*
        1--2--3--4--5--null
        |   
        ptr   -- initialise  ptr to head
                connect new node next to ptr , move ptr to newnode 
                reassign head to ptr;return head
                //NULL CHECK FOR HEAD :if head is null give head and tail same new node
        
        TIME :O(1)  
        SPACE: O(1) 
        */

        Node new_node = new Node(val );
        //  NULL CHECK FOR HEAD
        if(head == null){  
            head = new_node;
            tail = new_node;
            return head; }


        Node ptr = head;   
        
        new_node.next = ptr;
        ptr = new_node;

        head  = ptr;
        return head;

    }
    public Node     addLast(Node head ,int val){
         /*
        Question
        1--2--3--4--5--6--7   --add node at last pos
        item = 77

        1--2--4--5--6--7--77
        
        */

        /*
        1--2--3--4--5--null
        |   
        ptr                      --initialise  ptr to head 
                                   move ptr to last node(ptr to null;cb enc till lastnode;ca enc till null)
                                  connect ptr ka next to newnode ; move  ptr  to newnode  
                                  reassign tail no ptr;return head
                                  //NULL CHECK FOR HEAD :if head is null give head and tail same new node


        TIME :O(n)/O(1)  considering we dont have/have tail  
        SPACE: O(1) 

         */
        Node new_node = new Node(val);
     
         //NULL CHECK FOR HEAD
        if(head == null){    
            head = new_node;
            tail = new_node;
            return head;}


        Node ptr = head;    
        while(ptr.next != null){
            ptr = ptr.next;}

        ptr.next = new_node; 
        ptr = new_node;

        tail = ptr;
        return head;

    }
    public Node     add(Node head, int index, int val){
        /*
        Question
        1--2--3--4--5--6--7   --add node at index 
        index = 2 val = 77

        1---2--77--3----5--6--7
        
        */

        /*
        dummy--1--2--3--4--5--null
        |      |
        prevptr ptr   --initialise ptr to head  and prevptr to dummyNod                                       
                        move ptr till index(ptr to index;cb enc till index-1;ca enc till index ) ; move prevptr to ptr before moving ptr 
                        prevptr ka next to new node;new node  ka next to ptr  
                        return head                                           //null check for modifying 1st/single node  null check for attachment 
                        //NULL CHECK FOR HEAD if(head == null){assign head and tail to new node and return  head;}                                                                     


        TIME  :O(n)  
        SPACE :O(1)   
        */

        Node new_node = new Node(val);

        //NULL CHECK FOR HEAD
        if(head == null){head = new_node;tail = new_node;return head;} 


        Node ptr = head; 
        Node dummyNode = new Node(-1);dummyNode.next = head;    
        Node prevptr = dummyNode;   

       int count =0;
       while(ptr != null && count <=index-1){
           prevptr = ptr;
           ptr = ptr.next;
           count++;
       }

       prevptr.next = new_node;
       new_node.next = ptr;


       
       head = dummyNode.next;    //null check for modifying 1st/single node 
       dummyNode.next = null;    //null check for attachment
       return head;

    }
    public Node     addKthFromStart(Node head,int k , int val){
        /*
        Question
        1--2--3--4--5--6--7   --add node at kth node from start
        k = 2 val = 77

        1--77--2--4--5--6--7
        
        */

        /*
        dummy--1--2--3--4--5--null
        |      |
        prevptr ptr   --initialise ptr to head  and prevptr to dummyNod                                       
                        move ptr till kthNode(ptr to k;cb enc till k-1;ca enc till k ) ; move prevptr to ptr before moving ptr 
                        prevptr ka next to new node;new node  ka next to ptr  
                        return head                                           //null check for modifying 1st/single node  null check for attachment 
                        //NULL CHECK FOR HEAD if(head == null){assign head and tail to new node and return  head;}                                                                     


        TIME  :O(n)  
        SPACE :O(1)   
        */

         Node new_node = new Node(val);

         //NULL CHECK FOR HEAD
         if(head == null){head = new_node;tail = new_node;return head;} 


         Node ptr = head; 
         Node dummyNode = new Node(-1);dummyNode.next = head;    
         Node prevptr = dummyNode;   
 
        int count =1;
        while(ptr != null && count <=k-1){
            prevptr = ptr;
            ptr = ptr.next;
            count++;
        }

        prevptr.next = new_node;
        new_node.next = ptr;


        
        head = dummyNode.next;    //null check for modifying 1st/single node 
        dummyNode.next = null;    //null check for attachment
        return head;
 

     }
    public Node     removeFirst(Node head){
        /*
        Question
        1--2--3--4--5--6--7   --remove node at 1st pos

        2--4--5--6--7        
        */

 

        /*
         1--2--3--4--5-->null
          |  |
         ptr nextptr -initialise ptr at head , nextptrTemp  at next node        
                      connect ptr next to null 
                      reassign head to nextptr   return head

                    //NULL CHECK FOR HEAD if(head == null){return  null;}                                                                     

  
          TIME :O(n)  
          SPACE :O(1)


        */
        //NULL CHECK FOR HEAD
        if(head == null){return null;}

        Node ptr = head;
        Node nextptrTemp = ptr.next;

        ptr.next = null;

        head = nextptrTemp;
        return head;

  
      
  
  
  
      }
    public Node     removeLast(Node head){
        /*
        Question
        1--2--3--4--5--6--7   --remove node at las pos

        1--2--4--5--6        
        */

        /*
            
        dummy-- 1--2--3--4--5--null
         |      |   
        prevptr ptr              --initialise  ptr to head ; prevptr to dummyNode
                                   move ptr to last node(ptr to lastNode;;cb enc till 2ndlastnode;ca enc till lastNode);move prevptr to ptr before moving ptr
                                   connect prevptr ka next to null  
                                   reassign tail no prevptr ;return head   //null check for modifying 1st/single node  ;null check for attachment
                                  //NULL CHECK FOR HEAD :if head is null give head and tail same new node


        TIME :O(n)/O(1)  considering we dont have/have tail  
        SPACE: O(1) 
    
          */

        //NULL CHECK FOR HEAD 
        if(head == null){
            return null;
        }

        Node ptr = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;

        while(ptr.next != null){
            prevptr = ptr;
            ptr = ptr.next;
        }

        prevptr.next = null;

                           
                           
        head = dummyNode.next;  //null check for modifying 1st/single node 
        dummyNode.next = null;  //null check for attachment
        tail = prevptr;
        return head;






  

      }
    public Node     remove(Node head , int index){
        /*
      Question
      1--2--3--4--5--6--7   --remve index node
      index = 2 

      1--2--4--5--6--7
      
      */

        /*
       dummy--1--2--3--4--5--null
       |      |
       prevptr   ptr    -- initialise ptr to head  and prevptr to dummyNode                                    
                           move ptr till kthNode(ptr to index;cb enc till index-1;ca enc till index  ) ; move prevptr to ptr before moving ptr  
                           prevptr ka next to ptr ka next;ptr ka next to null  
                           return head                                          //null check for modifying 1st/single node  ; null check for attachment 
                           //NULL CHECK FOR HEAD if(head == null){return null;}                                                                     


       TIME  :O(n)  
       SPACE :O(1)   
       */
       //NULL CHECK FOR HEAD
       if(head == null){return null;}


       Node ptr = head;                     
       Node dummyNode = new Node(-1);dummyNode.next = head;
       Node prevptr = dummyNode;
       
       int count = 0;
       while(ptr != null && count <=index-1){
           prevptr = ptr;
           ptr = ptr.next;
           count ++;
       }
       prevptr.next = ptr.next;
       ptr.next = null;

       head = dummyNode.next;     //null check for modifyingg 1st node 
       dummyNode.next = null;     //null check for attachment
       return head;

   }
    public Node     removekthFromStart(Node head , int k){
         /*
       Question
       1--2--3--4--5--6--7   --remve kth node from start
       k = 2 

       1--3--4--5--6--7
       
       */

         /*
        dummy--1--2--3--4--5--null
        |      |
        prevptr   ptr    -- initialise ptr to head  and prevptr to dummyNode                                    
                            move ptr till kthNode(ptr to k;cb enc till k-1;ca enc till k  ) ; move prevptr to ptr before moving ptr  
                            prevptr ka next to ptr ka next;ptr ka next to null  
                            return head                                          //null check for modifying 1st/single node  ; null check for attachment 
                            //NULL CHECK FOR HEAD if(head == null){return null;}                                                                     


        TIME  :O(n)  
        SPACE :O(1)   
        */
        //NULL CHECK FOR HEAD
        if(head == null){return null;}


        Node ptr = head;                     
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;
        
        int count = 1;
        while(ptr != null && count <=k-1){
            prevptr = ptr;
            ptr = ptr.next;
            count ++;
        }
        prevptr.next = ptr.next;
        ptr.next = null;

        head = dummyNode.next;     //null check for modifyingg 1st node 
        dummyNode.next = null;     //null check for attachment
        return head;

    }
    public Node     removekthFromEnd(Node head , int k){
        /*
       Question
       1--2--3--4--5--6--7   --remve kth node from end
       k = 2 

       1--2--3--4--5--7
       
       */


        /*
        d--1--2--3--4--5--null
        |  | |
  prevptr  ptr1,ptr2  -- initialise ptr1,ptr2 to head  and prevptr to dummyNode                                                                                  
                         move ptr2 till kthNode(ptr to k;cb enc till k-1;ca enc till k) 
                         move ptr2 till null (ptr to null;cb enc till lastnode;ca enc till null) ; move ptr ; move prevptr to ptr before moving ptr
                         prevptr ka next to ptr ka next;ptr ka next to null 
                         return head                                                 //null check for modifying 1st/single node ; null check for attachment
                         //NULL CHECK FOR HEAD if(head == null){return null;} 
                       

        TIME  :O(n)  
        SPACE :O(1)  

       */         
        //NULL CHECK FOR HEAD 
        if(head == null){return null;}


        Node ptr1 = head;
        Node ptr2 = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;


        int count =1;
        while(ptr2 != null && count <=k-1){
            ptr2 = ptr2.next;
            count ++;
        }

        while(ptr2.next != null){
                prevptr = ptr1;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
        }


        prevptr.next = ptr1.next;
        ptr1.next = null;


        head = dummyNode.next;     //null check for modifyingg 1st node 
        dummyNode.next = null;     //null check for attachment
        return head;

   }
    public Node     removeK1IntervalK2Nodes(Node head , int k1 , int k2){
        /*
       Question
       1--2--3--4--5--6--7--8  --remove after k1 intervals k2 nodes   
       
       k1 = 2 , k2 = 1
       1--2--4--5--7--8
       
       */


        /*
        d--1--2--3--4--5--7--8
        |  | 
  prevptr  ptr1  -- initialise ptr to head  and prevptr to dummyNode  ;nextptrTemp to null                                         
                    move ptr till null(ptr to null;cb enc till lastnode;ca enc till null)
                         move ptr till k1+1th node(ptr to k1+1 ;cb enc till k1;ca enc till k1+1) ; prevptr to ptr before moving ptr =>k1+1 SO THAT  YOU CAN START REMOVING FROM K1+1TH NODE
                         move ptr till k2+1th node(ptr to k2+1 ;cb enc till k2 ;ca enc till k2+1)                                   =>K2+1 SO THAT PTR IS  AT  K2+1TH NODE  AND YOU CAN REMOVE UPTO K2 TH NODE(CODE BEFORE)  
                            prevptr ka next to ptr ka next ;ptr ka next to null
                         return head                                                                                                //null check for modifying 1st/single node null check for attachment
                       //NULL CHECK FOR HEAD if(head == null){return null;} 


        TIME  :O(n)  
        SPACE :O(1)  

       */         
        //NULL CHECK FOR HEAD 
        if(head == null){return null;}


        Node ptr = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;
        Node nextptrTemp = null;

     
       
       while(ptr != null){
             int count =1;
             while(ptr!=null && count <=(k1+1)-1){ 
                 prevptr = ptr;
                 ptr = ptr.next;
                 count++;
             }
             
             int countt =1;
             while(ptr != null && countt<=(k2+1)-1){
                 prevptr.next = ptr.next;
                 nextptrTemp = ptr.next;
                 ptr.next = null;


                 ptr = nextptrTemp;
                 countt++;
                 
             }
           
           
           
           
       }
        

        
       head = dummyNode.next;     //null check for modifyingg 1st node 
       dummyNode.next = null;     //null check for attachment
       return head;

    }
    public Node     removeMatchingValues(Node head, int val) {
        /*
       Question
       1--2--2--2--2--3--4--5  --remve  all nodes with matching value
       m = 2 , n = 2 

       1--2--5--6
       
       */


        /*
        d--1--2--2--2--3--4--2--null
        |  | 
  prevptr  ptr1  -- initialise ptr to head  and prevptr to dummyNode;nextptrTemp to null                                         
                    move ptr till null(ptr to null;cb enc till lastnode;ca enc till null) and prevptr to ptr before moving ptr //null check if (ptr == null){break because ptr has reached null dues to code before moving ptr }
                         if ptr KA val matches val 
                            move ptr till it matches value(ptr at matching value ka next node ie on our case 3 and null )
                            prevptr ka next to ptr  
                    return head                                                                                               //null check for modifying 1st/single node ; null check for attachment
                    //NULL CHECK FOR HEAD if(head == null){return null;} 


        TIME  :O(n)  
        SPACE :O(1)  

       */         
        //NULL CHECK FOR HEAD
        if(head == null){return null;}



        Node ptr = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;

        while(ptr != null){
            if(ptr.val == val){
                while(ptr != null && ptr.val == val){
                    ptr = ptr.next;
                } 
                prevptr.next = ptr;
            }
            

            prevptr = ptr;
            if(ptr == null){break;}
            ptr = ptr.next;             //null check if (ptr == null){break}    because ptr may encounter null in above while loop

        }
        
        head = dummyNode.next;          //null check for single node 
        dummyNode.next = null;          //null check for attachment
        return head;
    }
    public void     removeNodeWithoutHead(Node node){
        /*
        1-2-3-4-5
            |
            node      --delete the node and head is not goven to you
                        node is guaranteed to exist , node is guaranteed to not be tail
        */
        
        /*
        1--2--3--4--5
              |  |   |
           ptr1 ptr2 ptr3 - initialise ptr1 to node , ptr2 to node ka next ,ptr3 to node ka next ka next (node can be max at 2nd last node , so ptr1 at 2nd last ptr2 at last ptr3 at null so ni null value issues)
                            copy ptr2 ka value in ptr1
                            remove ptr2 
        
        
        */
        Node ptr1 = node; 
        Node ptr2 = node.next;    
        Node ptr3 = node.next.next;
        
        ptr1.val = ptr2.val;
        ptr1.next = ptr3;
        


    }
    
    //SIZE
    public boolean  isEmpty(Node head){
        /*
        1---2---3--4--5->null
        |  
       ptr    --initialise ptr to head
                return ptr == null;
        Time:O(1)
        Space:O(1)
         */
        Node ptr = head;
        return ptr == null;
    }
    public boolean  isFull(Node head, Node tail){
        /*
        1---2---3--4--5->null
        |  
       ptr    --return head == tail;
        Time:O(1)
        Space:O(1)
         */
        return head == tail;  
    }
    public int      size(Node head){
        /*
       1---2---3--4--5->null
        |  
       ptr    --initialise ptr to head
                move ptr till last node(ptr at last node , cb enc nodes till second last , ca encounter till last node)
                inc size 
       
                 OR
                 size ++ ; size -- at start of adding removing methods(do this at start of method  because if you return in middle somewhere you may not encounter size++ at bottom)
                 return size
       

        TIME :O(n)/O(1) of you are finding size by method/if you are building LL and do size++,size-- while add remove etc  
        SPACE :O(1)  
        */

      Node ptr = head;
      
      int size = 1;
      while(ptr.next != null){
          size++;
          ptr = ptr.next;

      }
      return size;

      //OR
      //   size ++ ; size -- at start of adding removing methods(do this at start of method  because if you return in middle somewhere you may not encounter size++ at bottom)
      //   return size


    }



    //REVERSE 
    public Node     reverse(Node head) {
       /*
       Question
       1--2--3--4--5--null  --remve  full LL
        

       5--4--3--2--1
       
       */


        /*
        dn --1--2--3--4--5--6
        |      |
        prev   ptr      --initialise  ptr to head ; prevptr to dummyNode;nextptrTemp to dummyNode 
                          move ptr till null(ptr to null ;cb enc till lastnode ;ca enc till null) and move prevptr to ptr before moving ptr =>NULL SO THAT PTR MOVES TO NULL AND YOU CAN REVERSE TILL LAST NODE(CODE BEFORE)
                               nextptr = ptr ka next
                               ptr ka next  to prevptr
                               reassingn prevptr to ptr
                               reassign ptr to nextptr
                            
                           reassign head ka next to null
                           reassign head to prevptr a
                           return head                                                                         

                        //NULL CHECK FOR HEAD if(head == null){return null;} 

        TIME :O(n)  
        SPACE: O(1) 
        */

        //NULL CHECK FOR HEAD
        if(head == null){ return null;}

        Node ptr = head;        
        Node dummyNode = new Node(-1);dummyNode.next = head;  
        Node prevptr = dummyNode;
        Node nextptr = dummyNode;  
        while (ptr != null) {
            nextptr = ptr.next;
            ptr.next = prevptr;

            prevptr = ptr;
            ptr = nextptr;
        }

                                //null check for modifying 1st/single node  not req
        head.next = null;      //null check for attachment
        head = prevptr;
        return head;

}
    public Node     reverseRecursive(Node head){
     /*
       Question
       1--2--3--4--5--null  --remve  full LL
        

       5--4--3--2--1
       
       */


       /*
       Look in Recursion linkedListReverseRecursive
       */
        return null;
    }
    public Node     reverseUptoKthNode(Node head, int k){
       /*
       Question
       1--2--3--4--5--null  --reverse LL upto kth node
       k=2

       2--1--3--4--5
       
       */


        /*
        dn  -- 1--2--3--4--5--6 k =2
        |      |
        prev   ptr              --initialise  ptr to head ; prevptr to dummyNode;nextptrTemp to null 
                                  move ptr till k+1(ptr to k+1 ;cb enc till k ;ca enc till k+1) and move prevptr to ptr before moving ptr =>K+1 SO THAT PTR MOVES TO K+1TH NODE  AND YOU CAN REVERSE TILL KTH NODE(CODE BEFORE);  
                                     ptr ka next  to prevptr
                                 connect head ka next to ptr ;reassign head to prevptr ; return head                                      //null check for modifying 1st/single node not req;null check for attachment
                                //NULL CHECK FOR HEAD if(head == null){return null;}   
                          

                        

        TIME :O(n)  
        SPACE: O(1) 
        */

         //NULL CHECK FOR HEAD
        if(head == null){return null;}


        Node ptr = head;
        Node prevptr = null;
        Node nextptr = null;
        int count =1;
        while(ptr != null && count <=k){
            nextptr = ptr.next;
            ptr.next = prevptr;
            
            prevptr = ptr;
            ptr = nextptr;
            count++;
        }
        
                                //null check for modifying 1st/single node not req
        head.next = null;      //null check for attachment
        head.next = ptr;
        head = prevptr;
        return head;
    }
    public Node     reverseBetweenK1K2Node(Node head, int k1, int k2) {
       /*
       Question
       1--2--3--4--5--null  --reverse LL bw k1 and k2 node
       k1=2 , K2 = 4

       1--4--3--2--5
       
       */


        /*
        dn->1->2->3->4->5->6   k1 =2,k2 = 4


        dn->1->2->3->4->5->6    
        |    |                  
        prev ptr        --initialise ptr to head; prevptr to dumyNode
                          move ptr till k(ptr to k;cb enc till k;ca enc till k+1) and move prevptr to ptr before moving ptr    =>KTH NODE BECAUSE YOU WANT TO START REVERSING FROM KTH NODE ONWARDS
                          store  ptr and prevptr in tempptr , tempprevptr                                                      ==>visualise by reversing for 1st group and 2nd group
                          move ptr  till k2 + 1(ptr to k2+1;cb enc till k2;ca enc till k2+1); prevptr tp ptr before moving ptr ==>k2+1th BECAUSE PTR WILL BE AT K2+1TH AND YOU CA REVERSE UPTO K2TH NODE
                                connect ptr ka next to prevptr
                          connect tempprevptr ka next to prevptr ; connect tempprevptr ka next to ptr
                          return head;                                                                                       //null ckeck for modifying 1st/single node  ; null check for attachment
                         //NULL CHECK FOR HEAD:  if(head == null){return null;}
                          
               

        TIME :O(n)  
        SPACE: O(1) 
        */

         //NULL CHECK FOR HEAD
        if(head == null){return null;}
        
               
        

        //MOVE TILL K1 TH NODE 
        Node ptr  = head;
        Node dummyNode = new Node(-1); dummyNode.next = head;
        Node prevptr = dummyNode;
        Node nextptrTemp = null;
        int count =1;
        while(ptr !=null && count <=k1 -1 ){ 
            prevptr = ptr;
            ptr = ptr.next;
            count++;
        }
        
        //STORE PTRS
        Node tempptr = ptr;
        Node tempprevPtr = prevptr;
        
        //MOVE K2+1 (K1+1 bec K must not be reversed ; k2+1 bec last ke baad next pe jaake ptr beithe)
        while(ptr != null && count <=(k2+1)-1){
            nextptrTemp = ptr.next;
            ptr.next = prevptr;
            
            prevptr = ptr;
            ptr = nextptrTemp;
            count++;
        }
        tempprevPtr.next = prevptr;
        tempptr.next = ptr;
        
        head = dummyNode.next;//null ckeck for modifying 1st/single node ; 
        dummyNode.next = null;//null check for attachment
        return head;
  
        
    }
    public Node     reverseInKGroups(Node head , int k){
        /*
       Question
       1--2--3--4--5  --reverse the LL in k groups 
                        If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it i
      
       k=2 
       2--1--4--3--5
       
       k=3
       3--2--1--4--5
       
       */


        /*
        d--1--2--3--4--5--7--8
        |  | 
  prevptr  ptr1  -- initialise ptr to head  and prevptr to dummyNode  ;nextptrTemp to null                                         
                    move ptr till null(ptr to null;cb enc till lastnode;ca enc till null)
                    store pp and p in tpp and p for 1st time from next time onwards store tp and p in tpp and tp                ==>visualise by reversing for 1st group and 2nd group
                    move ptr till k1+1th node(ptr to k1+1 ;cb enc till k1;ca enc till k1+1) ;prevpptr to ptr before moving ptr  =>K+1 SO THAT PTR IS  AT  K+1TH NODE  AND YOU CAN REVERSE UPTO Kth NODE(CODE BEFORE)  
                           connect prevptr to ptr
                    connect tempprevptr ka next to prevptr ; connect tempprevptr ka next to ptr                                                                                              //null check for modifying 1st/single node ; null check for attachment
                    //NULL CHECK FOR HEAD 
                      if(head == null){return null;} 
                    //NULL CHECK FOR K:
                      k is not a divisor of size then remaining nodes should not be reversed: Before reversing check if(noOfTimesRotated == noOfTimesCanRotate){break} 
                      [PROPERTY OF REVERSE GIVEN IN QUES]                                     because after rotation noOfTimesRotated++ so when you come back in loop  
                                                                                              if you have already rotatd required times then break and dont rotate the remaining nodes



        TIME  :O(n)  
        SPACE :O(1)  

       */  
        //NULL CHECK FOR HEAD 
        if(head == null){return null;}
        
        
        Node ptr = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;


        
        Node tempprevptr = null;
        Node tempptr = null;
        int noOfTimesRotated = 0;
        int noOfTimesCanRotate = size(head) /k;
        
        while(ptr != null){
            
            if(noOfTimesRotated ==0){
                tempprevptr = prevptr;
                tempptr = ptr;
            }
            else{
                tempprevptr = tempptr;
                tempptr = ptr;
                
            }
            
            //NULL CHECK FOR K 
            if(noOfTimesRotated == noOfTimesCanRotate){break;}
            
            Node nexptrptrTemp = null;
            int count = 1;
            while(ptr != null && count <=(k+1)-1){
                nexptrptrTemp = ptr.next;
                ptr.next = prevptr;
                
                prevptr = ptr;
                ptr = nexptrptrTemp;
                count++;
            }
            tempprevptr.next = prevptr;
            tempptr.next = ptr;
            
            
            noOfTimesRotated++;
            
        }
        
        
        head = dummyNode.next;
        dummyNode.next = null;
        return head;
        
          
        
    }
    public boolean  linkedListisPallindrome(Node head){
        /*
       Question
       1--2--3--2--1--null  --check if LL is pallindrome and return T/F
       1--2--2--1--null
       T
       T
       
       */


        
        /*
           1--2--3--2--1  
           |                        SPLIT INTO 2 LL
           head                     mid = getMiddle(head)  -->returns second middlenode for even(1 2 3(m) 4) ; middlenode for odd(1 2 3(m) 4 5)  
                                    leftptr  = head           return middleptr ke badle prevslowptr.next = null; return middleptr
                                    rightptr = mid
                                    rightptr = reverse(mid)

                                    COMPARE 2 LL 
            1->2   3<-2-<1          move lp rp till both not null(lp,rp at null,eq node ; cb enc lastNode,eq node ; ca enc null,eq node [LL1 small; vice versaLL2 small] )               
            |            |              if(ptr1.val!=ptr2.val) return false
            lp           rp             move lp ahead
                                        move rp ahead
                                    return true                        

                                if(p1 != null){                        //null check if(p1!=null){}  for smaller LL2 (LL2 is always greater)
                                   not possible                        
                                }
                                if(p2 != null){                        //null check if(p2!=null){}  for smaller LL1 (LL2 is always greater)
                                    do nothing as only 1 element left to compare
                                }
                                
                                                              
           TIME :O(n) 
           SPACE: O(1) 

         */
        //NULL CHECK FOR HEAD
        Node mid = getMiddleNode(head);   //return middleptr ke badle prevslowptr.next = null; return middleptr

        Node leftptr = head;
        Node rightptr = mid;
        rightptr = reverse(mid);
        
        while(leftptr!=null && rightptr !=null){
            if(leftptr.val != rightptr.val){
                return false;
            }
            
            leftptr = leftptr.next;
            rightptr = rightptr.next;
        }
        
        return true;
    }
    

    //SWAP
    public Node     swapKthFromStartKthFromEndNodesKaValue(Node head , int k){
        /*
        Question
        1--2--3--4--5--null  --swap kth Node from start and kth Node from end ka "VALUES"
        k = 2

        1--4--3--2--5--null
        */

        
        /*
          1--2--3--4--5--6  
          | |                                 
          p1 p2    --initialise ptr1,ptr2 to head  
                     move ptr2 till k(ptr2 to k;cb enc till k-1;ca enc till k) and move prevptr to ptr before moving ptr 
                     tempptr1 = ptr2
                     move ptr2 till null(ptr to null;cb enc till last node , ca enc till null) ; move ptr1
                     tempptr1 = ptr1
                     Swap tempptr1,tempptr1 value
                     return head
                     //NULL CHECK FOR HEAD:if(head == null){return null;}
                                                                                                                                                                              
           TIME : O(n) 
           SPACE: O(1) 

         */

         //NULL CHECK FOR HEAD
        if(head == null){return null;}
        
        
        
        Node ptr1 = head;
        Node ptr2 = head;
        int count =1;
        while(ptr2!= null && count <=k-1){
            ptr2 = ptr2.next;
            count++; 
        }
        
        Node tempptr1 = ptr2;
        
        while(ptr2.next!= null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        Node tempptr2 = ptr1;
        
        
        //SWAP
        int temp = tempptr1.val;
        tempptr1.val = tempptr2.val;
        tempptr2.val = temp;
        
        
        return head;
        
        
    }
    public Node     swapAlternateNodes(Node head){
        /*
        Question
        1--2--3--4--5--null  --swap alternate "NODES NOT THEIR VALUES"

        2--1--4--3--5--null
        */

        
        /*
        dN--1--2--3--4--5--6  
        |   |   |                               
       pp   ptr npT  --initialise ptr to head ; prevptr to dummy ; mextptrTemp to null
                      move ptr till null(ptr2 to k;cb enc till k-1;ca enc till k) and move prevptr to ptr before moving ptr 
                         ptr ka next to nextptrTemp ka next ; nextptrTemp Ka next to ptr ; prevptr ka next to nextptrTemp //null check if(nextptrTemp == null){break} because ptr encounters till last node so nextptrTemp encounters till null 
                     return head                                                                                          //null check for modifying 1st/single node  ; null check for attachments
                     //NULL CHECK FOR HEAD:if(head == null){return null;}
                                                                                                                                                                              
           TIME : O(n) 
           SPACE: O(1) 

         */
        //NULL CHECK FOR HEAD if(head == null){return null;} 
        if(head == null){return null;}
        
        
        Node ptr = head;
        Node dummyNode = new Node(-1); dummyNode.next = head;
        Node prevptr = dummyNode;
        Node nextptrTemp = null;
        
        while(ptr != null){
            nextptrTemp = ptr.next;
      
            if(nextptrTemp == null){break;}    
            ptr.next = nextptrTemp.next;    //null check if(nextptrTemp == null){break} because ptr encounters till last node so nextptrTemp encounters till null 
            nextptrTemp.next = ptr;
            prevptr.next = nextptrTemp;
            
            
            
            prevptr = ptr;
            ptr = ptr.next;
        }
        
        head = dummyNode.next;               //null check for modifying 1st/single node  not req
        dummyNode.next = null;                //null check for attachment
        return head;
        
        
        
        
        
        
    }
 
    //REORDER
    public Node     reorderEvenOddNodes(Node head) {
        /*
        1--2--3--4--5  --reorder the LL into odd and even nodes

        1--3--5--2--4
        
        */
        
        /*
        dN--1--2--3--4--5  
        |   |
        ep  op              --initialise oddptr to head; evenptr to dummyNode ; preOddptr to dummyNode ; preEvenptr to dummyNode ; nextO
                            move op  untill op does not reach null  FOR EVEN NODES(fp to null;cb enc till lastnode;ca enc till null) and op does not reach last node  FOR ODD  NODES(fp to lastNode;;cb enc till 2ndlastnode;ca enc till lastNode)
                                connect ep ka next to ep ka next ka next
                                connect op ka next to op ka next ka next

                            if(oddptr == null){                                     //null check for even nodes because oddptr exits at nullFOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
                                dN--2--4--n    1--3   -->  1--2--3--4--n
                                       |  |       |
                                       ep op      pop
                                connect pop ka next to dN ka next 
                                connect dN ka next to null
                                head is head
                              }   
                              else if(oddptr.next == null){                         //null check for odd nodes because oddptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
                                dN-2-4  1-3-5   4-5 ka connection                     (else if because if there are even nodes oddptr will be null so you dont want to check 2nd cond)
                                     |      |   bachta hai   
                                     ep     op
                                conenct ep ka next to null
                                op ka next to dN ka next
                                dN ka next to null
                                head is head
                              }
              


                            return head;   
                                 
        
        */
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node evenptr = dummyNode;
        Node oddptr = head;
        Node preevenptr = dummyNode;
        Node preoddptr = dummyNode;
        Node nextevenptrTemp  = null;
        Node nextoddptrTemp   = null;
        while(oddptr != null && oddptr.next != null){
            nextevenptrTemp = evenptr.next.next;
            nextoddptrTemp = oddptr.next.next;
            evenptr.next = evenptr.next.next;
            oddptr.next = oddptr.next.next;
            
            
           preevenptr = evenptr; 
           evenptr = nextevenptrTemp;
           preoddptr = oddptr;
           oddptr = nextoddptrTemp;
            
        }
        
        if(oddptr == null){                             //null check for even nodes because oddptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
            preoddptr.next = dummyNode.next;
            dummyNode.next = null;
            head = head;
            
        } 
        else if(oddptr.next == null){                  //null check for odd nodes because oddptr exits at null(FOR EVEN) and lastNode(FOR ODD)so you have to handle two results seperately
            evenptr.next = null;                       // (else if because if there are even nodes oddptr will be null so you dont want to check 2nd cond)
            oddptr.next = dummyNode.next;
            dummyNode.next = null;
            head = head;
            
        }
        

        return head;
        
        
        
            
            
            
    }
    public Node     reorderFirstLastISecondSecondLastNodes(Node head){
        /*
        1--2--3--4--5  --reorder the LL such that L1 connects to Ln L2 connects to Ln-1 and so on 

        1--5--2--4--3
        
        */
        
        /*
        1--2--3--4--5  
        |                       SPLIT INTO 2 LL
        head                    mid = getMiddle(head)  -->returns second middlenode for even(1 2 3(m) 4) ; middlenode for odd(1 2 3(m) 4 5)  
                                leftptr  = head           return middleptr ke badle prevslowptr.next = null; return middleptr
                                rightptr = mid
                                rightptr = reverse(mid)

                                COMPARE 2 LL 
        1->2   5->4->3         move p1 p2 till both not null     (p1,p2 at null,eq node ; cb enc lastNode,eq node ; ca enc null,eq node [LL1 small; vice versaLL2 small] )               
        |       |                  connect p1 ke next to ptr2   
        p1      p2                 connect ptr2 ka next to ptr1 ka next
        
                                   reassign ptr1 to nextptr1
                                   reassign ptr2 to nextptr2

                                if(p1 != null){                        //null check if(p1!=null){}  for smaller LL2 (LL2 is always greater)
                                   not possible                        
                                }
                                if(p2 != null){                        //null check if(p2!=null){}  for smaller LL1 (LL2 is always greater)
                                    reassign prevptr2 ka next to ptr2
                                }

                                return head;
                                

                                                            
        TIME :O(n) 
        SPACE: O(1) 
         
        
    
                                 
        
        */
        Node mid = getMiddleNode(head);  //return middleptr ke badle prevslowptr.next = null; return middleptr
        Node ptr1 = head;
        Node ptr2 = mid;
        ptr2 = reverse(mid);
        
        Node dummyNode = new Node(-1);dummyNode.next = ptr2;
        Node prevptr2 = dummyNode;
        Node nextptr1 = null;
        Node nextptr2 = null;
        
        while(ptr1 != null && ptr2 != null){
            nextptr1 = ptr1.next;
            nextptr2 = ptr2.next;
            
            ptr1.next = ptr2;
            ptr2.next = nextptr1;
            
            prevptr2 = ptr2; 
            ptr1 = nextptr1;
            ptr2 = nextptr2;
        
        }

        
        if(ptr1 != null){   
        }
        if(ptr2 != null){
            prevptr2.next = ptr2;    
        }   
        

        return head;
    }
    
    //ROTATE
    public Node     rotateRightByKNodes(Node head , int k){
        /*
        1--2--3--4--5   -- move array right and move the displaced of last pos at start 
                           if k>=size then you still can rotate k times 
        
        
        k = 1
        5--1--2--3--4

        k = 3
        3--4--5--1--2

        k=7
        4--5--1--2--3
        
        
        */

        
        /*
       dN--1--2--3--4--5->null
       |   |
  prevptr ptr1 ptr2  -- initialise ptr1 , ptr2 to head 
                        move ptr2 till kth node(ptr2 to k;cb enc till k-1;ca enc till k) 
                        move ptr2 to last node(ptr to null;cb enc till lastnode;ca enc till null) ;move ptr ahead(ptr at kth niode from end) ; move prevptr tp ptr before moving ptr
                        connect prevptr  ka next to null; dummyNode ka next to pr1, ptr2 ka next to head   
                        return head                                                             //null check for single node; null check for attachment
                        //NULL CHECK FOR HEAD: 
                         Covered in null check for k
                        //NULL CHECK FOR K
                        if(k>=size(head)){k = k% size(head)} -->rotate k%size times EGsize =5  k=5 -- rotate 5 times = rotate 0 times ; k=rotate 8 times = rotate 3 times
                        [PROPERTY OF ROTATE]
                        if(k==0){return head}                -->return head and rotate 0 times
                        [PROPERTY OF ROTATE]  
                        k=anything,head =null               -->return null and rotate 0 times 
                        [PROPERTY OF ROTATE] 
   
                        

        TIME :O(n)  
        SPACE: O(1) 
         */

        //NULL CHECK FOR K 
        if(head == null){return null;}
        if(k>=size){k = k % size(head);}         
        if(k ==0){return head;}                  
        
        Node ptr1 = head;
        Node ptr2 = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;
        
        int count =1;
        while(ptr2 != null && count <=k-1){
            ptr2 = ptr2.next;
            count++;
        }
        
        while(ptr2.next != null){
            prevptr = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        prevptr.next = null;
        dummyNode.next = ptr1;
        ptr2.next = head;
        
        
        head = dummyNode.next; //null check for single node
        dummyNode.next = null; //null check for attachment
        return head;
         
        
        
        
    }
    
 
    //COPYLL
    public Node     copyRandomPtrLL(Node head){
        /*
        Question
        1--2--3--4--5   --copy the LL with Node having value and a random ptr pointing to random node and if random is null it doesnt point to any node
        |__|___|    |     //class Node {int val;Node next;Node random;public Node(int val) {this.val = val;this.next = null;this.random = null;}}
           |________| 

        1'--2'--3'--4'--5'   
        |__|____|       |
           |____________| 



        */


        //USING HASHMAP
        /*
        1--2--3--4--5   
        |__|___|    |   
        |  |________|
        ptr1                        
        dn           
        |                       COPY LL
        ptr2                    initialise ptr1 to head , ptr2 to dummyNode
                                move ptr1 till null(ptr1 at null, cb enc till lastNode, ca enc till null)
                                    connect ptr2 ka next to newNode ;move ptr2 ahead 
                                    add ptr1 and newNode in map
                                    mve ptr1 ahead
                                CONNECT RANDOM  BASED ON MAP      
                                initialise ptr1 to head
                                initialise ptr2 to dummy ka next
                                move ptr1 till null(ptr1 at null, cb enc till lastNode, ca enc till null)
                                    connect ptr2 ka random to to its equivalent node which we can get from map   //null check if ptr1.randon != null
                                    move ptr1 ahead
                                    move ptr2 ahead                        
                                return head2                                                                     ////null check for modifying 1stnode/singlenode;; null check for attachment
         
                                //NULL CHECK FOR HEAD:if(head == null){return null;}
        */
        //NULL CHECK FOR HEAD
        if(head == null){return null;}
        
        Node ptr1=head;
        Node dummyNode = new Node(-1);;
        Node ptr2=dummyNode;
        Map<Node,Node> map = new HashMap<>();

        //COPY LL
        while(ptr1!=null){
            Node newNode = new Node(ptr1.val);
            ptr2.next=newNode;
            ptr2=ptr2.next;
            map.put(ptr1,newNode);
            
            ptr1=ptr1.next;
        }

        //CONNECT RANDOM BASED ON MAP   
        ptr1=head;
        ptr2=dummyNode.next;
        while(ptr1!=null){
            //if(ptr1.random!=null){//null check if ptr1.randon != null
            //    ptr2.random=map.get(ptr1.random);}
            
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        Node head2 = dummyNode.next;                    //null check for modifying 1st node; 
        dummyNode.next = head;                         //null check for attachment
        //return head2;




        //USING NO HASHMAP(INTERVIEWING NODES)
        /*
        1--2--3--4--5   
        |__|___|    |   
        |  |________|
        ptr                           
                        ADD COPY LL TO REAL LL
                        1-1'-2-2'3-3-4-4'
                        initialis ptr  to head , nextptrTemp to null
                        move ptr till null(ptr at null, cb enc till lastNode, ca enc till null)
                        connect ptr ka next to newNode and nexwNode ka next to ptr ka next 
        
                        CONNECT RANDOM BASED ON REAL LL
                          _________
                          |       |
                        1-1'-2-2'3-3'-4-4'
                        |________|
                        initialis ptr  to head 
                        move ptr  till ptr does not reach null FOR EVEN NODES(fp to null;cb enc till lastnode;ca enc till null) and ptr does not reach lastNode FOR ODD NODES(fp to lastNode;cb enc till 2ndLast;ca enc till lastNode) X ODD NODES NOT REQUIRED AS NODES ARE ALWAYS EVEN
                              connect ptr ka next ka random to ptr ka random ka next //null check if ptr.random != null
                                                                  
                                                                                                    //null check for even not req as nodes will always be even
                                                                                                   //null check for odd  not req as nodes will always be enev
                                                                                                    
                        REMOVE COPY LL FROM REAL LL 
                        dN--1-1'-2-2'3-3'-4-4'
                        initialise ptr1 to dummyNode , ptr2 to head ,nextptr1Temp to null , nextptr2Temp ti null
                        move ptr2 till ptr2 does not reach null FOR EVEN NODES(fp to null;cb enc till lastnode;ca enc till null) and ptr2 does not reach lastNode FOR ODD NODES(fp to lastNode;cb enc till 2ndLast;ca enc till lastNode) X ODD NODES NOT REQUIRED AS NODES ARE ALWAYS EVEN
                          connect ptr1 ka next to ptr1 ka next ka next
                          connect ptr2 ka next to ptr2 ka next ka next  
                                                                                                   //null check for even not req as nodes will always be even
                                                                                                   //null check for odd  not req as nodes will always be enev
                        return head2                                                              //null check for modifying 1stnode/singlenode; null check for attachment
         
                        //NULL CHECK FOR HEAD:if(head == null){return null;}                                                                             
        
        
        
       */

        //ADD COPY LL TO REAL LL 
        Node ptr = head;
        Node nextptrTemp = null;
        while(ptr!=null){
            Node new_node = new Node(ptr.val);
            nextptrTemp = ptr.next;
            ptr.next = new_node;
            new_node.next = nextptrTemp;
            
            ptr = nextptrTemp;
        }
        

        //CONNECT RANDOM BASED ON REAL LL
        ptr = head;
        while(ptr !=null){                   
            //if(ptr.random !=null){//null check if ptr.random != null
                //ptr.next.random = ptr.random.next; }
            
            ptr = ptr.next.next;
        }
        
            
        
                
        //REMOVE COPY LL FROM REAL LL
        Node dumyNode = new Node(-1);dumyNode.next = head;
        Node ptrr1 = dumyNode;
        Node ptrr2 = head;
        Node nextptrr1Temp = null;
        Node nextptrr2Temp  = null;
        while(ptrr2 != null){  
            nextptrr1Temp = ptrr1.next.next;
            nextptrr2Temp = ptrr2.next.next;
            ptrr1.next = ptrr1.next.next;
            ptrr2.next = ptrr2.next.next;
            
            
            ptrr1 = nextptrr1Temp;
            ptrr2 = nextptrr2Temp;
            
            
                
        }
        
        
        Node headd2 = dummyNode.next;                          //null check for modifying 1stnode/singlenode
        dummyNode.next = null;                                 //null check for attachment
        return headd2;

    }
 

    //SPLIT
    public  Node[]  splitInKParts(Node head,int k){
          /*
        1-2-3-4-5-6-7-8-9-10   -- split the LL in k equal parts 
                                  a.The length of each part should be as equal as possible
                                    and the parts occurring earlier should always have a size greater than or equal to parts occurring later.
                                    and no two parts should have a size differing by more than one
                                  b.if k>=size then split each node and remaining splits will be null
        
        
        1-2-3-4-5-6-7-8-9-10
        k = 3
        [[1,2,3,4],[5,6,7],[8,9,10]]

        1--2--3
        k=5
        [[1],[2],[3],[],[]]
        
        */

        
        /*
         1-2-3-4-5-6-7-8-9-10;k=3  
         |       
         ptr      --initialise ptr to head
                    move ptr to kth node(ptr at k; cb enc till k-1;ca enc till k) -->CALCULATE K LIST : quotient = size/k(q=3)  remainder = size%k(r=1)  fill kList with quotient(kList = [3,3,3]) distribite the rem over kLIst(kList =[4,3,3])
                    connect ptr ka next to null
                    add head in listNode
                    reassign head to ptr ka next
                    return listNode
                    //NULL CHECK FOR HEAD
                      Covered in null check for k
                    //NULL CHECK FOR K
                    K>=sise(head)                   -->put all elements of ll in listNode; fill the remaining elements of listNode with null
                    [PROPERTY OF SPLIT GIVEN IN QUES]
                    k==0                            -->k cant be 0 as it will result in invalid split
                    [PROPERTY OF SPLIT GIVEN IN QUES]
                    k=anything,head =null            -->populate listnode with null 
                    [PROPERTY OF SPLIT FIGURED FROM TEST CASE: [] k=3 -->[[][][]]]





  
  
  
  


        TIME :O(n)  
        SPACE: O(1) 
         */



        

        //NULL CHECK FOR K
        if(head == null){                                    
             Node[] listNode = new Node[k];
            
            for(int i =0 ; i < listNode.length;i++){
                listNode[i] = null;
            }
            return listNode;         
        }
        if(k>=size(head)){                                  
            Node[] listNode = new Node[k];
            
            int index =0;
            Node ptr = head;
            Node nextptrTemp  = null;
            while(ptr!=null){
                nextptrTemp =  ptr.next;
                
                ptr.next = null;
                listNode[index] = ptr;index++;
                
                ptr = nextptrTemp;
                
                
            }
            
            for(int i = index+1;i<listNode.length;i++){
                listNode[i] = null;
            }
            
            return listNode;
          
            
            
        }
        if(k==0){                                          
           // k cant be 0 as it  
        }

        
        //CALCULATE K LIST OF SIZE K
        int[] kList = new int[k];
        int quotient = ((int)size(head))/((int)k);
        int remainder = ((int)size(head)) % ((int)k);
        for(int i=0; i < kList.length ; i++){
            kList[i] = quotient;
        }  
        int index =0;   
        for(int i =1 ; i <= remainder;i++){
          kList[index] = kList[index] + 1; 
          index++;
      }

         



        Node[] listNode = new  Node[k] ;
        int indexx =0;
        for(int i=0 ; i< kList.length;i++){
            k = kList[i];
            
            Node ptr = head;
            int count = 1;
            while(ptr != null && count <=k-1){
                ptr = ptr.next;
                count++;
            }
            Node nextptrTemp = ptr.next;
            ptr.next = null;
            listNode[indexx] = head;indexx++;
            head = nextptrTemp;
            
            
        }
        

        return listNode;
        
        
        
        
    }
    

    //LOOP
    public Node     loopCreateAtk(Node head,int k){
       /*
       Question
       1--2--3--4--5--null  --create a loop at kth node
       k=2

       1--2--3--4--5
          |________|
       
       */



        /*
          1--2--3--4--5->null
         | |
        ptr1 ptr2  -- initialise ptr1 , ptr2 to head 
                      move ptr1,ptr2 till kth node(ptr1,ptr2 to k;cb enc till k-1;ca enc till k) 
                      move ptr2 to last node(ptr to null;cb enc till lastnode;ca enc till null)
                      connect ptr2 ka next  to ptr1   
                      return head
                    //NULL CHECK FOR HEAD:null check if(head == null){retuen null}
        TIME :O(n)  
        SPACE: O(1) 
         */

        //NULL CHECK FOR HEAD
        if(head == null ){ return null;}

        Node ptr1 = head; 
        Node ptr2 = head;

        int count = 1;
        while(ptr1!=null && count<=k-1){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            count++;
        }
        while(ptr2.next != null){
            ptr2 = ptr2.next;
        }
        
        ptr2.next = ptr1;
        
        return head;

        
    }
    public boolean  loopExists(Node head) {
       /*
       Question
       1--2--3--4--5       -- check if loop exists and return true/false
          |________|
       
       */


        //USING MULTIPTR +HASHMAP
        /*
        
        1--2--3--4--5--6 
        | |     |      |              
      sp fp     |      |   --initialise ptr to head   
                |______|    move ptr till null 
                                nextNode = ptr.next
                                if nextNode != null && visited.contains(nextNode)
                                  return true

                                add ptr to visited
                                move ptr ahead

                            return false


     
        TIME :O(n)  
        SPACE: O(n)        
        
        */
        /*
        Set<Node> visited = new HashSet<>();
        
        Node ptr = head;
        while(ptr != null){
            Node nextNode = ptr.next;
            if(nextNode != null && visited.contains(nextNode)){
                return true;
            }
            
            visited.add(ptr);
            ptr = ptr.next;
        }
        return false;
        
        
        */

        //USING MULTIPTR 
        /*
        1--2--3--4--5--6 
        | |     |      |              
      sp fp     |      |   --initialise sp,fp to head   
                |______|    move sp by 1 and fp by 2  untill fp does not reach null  FOR EVEN NODES(fp to null;cb enc till lastnode;ca enc till null) &&  fastptr does not reach last node  FOR EVEN NODES(fp to lastNode;;cb enc till 2ndlastnode;ca enc till lastNode ) 
                                if fp==sp        --> Floyd’s Cycle-finding Algorithm (If there is a loop sp , fp meet)   
                                    return true
                            return false;           //null check for even nodes not req because you return at requured point
                                                    //null check for odd nodes  not req because you return at requured point


     
        TIME :O(n)  
        SPACE: O(1)                                                         
       */

       /*
        if(head == null ){return false;} 

        var slowptr = head;  
        var fastptr = head;

        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;

            if (slowptr == fastptr)
                return true;
        }

        return false;
       */

       return false;

    }
    public Node     loopStartNode(Node head) {
        /*
       Question
       1--2--3--4--5       -- return node where loop starts
          |________|
       2
       
       */


        /*
       1--2--3--4--5--6 
        | |     |      |              
      sp fp     |      |     --initialise sp,fp to head   
                |______|      move sp by 1 and fp by 2  untill fp does not reach null  FOR EVEN NODES(fp to null;cb enc till lastnode;ca enc till null &&  fastptr does not reach last node  FOR ODD NODES(fp to lastNode;;cb enc till 2ndlastnode;ca enc till lastNode ) 
                                if fp==sp                                              --> Floyd’s Cycle-finding Algorithm (If there is a loop sp , fp meet)   
                                    initialise startptr to head                        --> Floyd’s Cycle-finding Algorithm II (If there is a loop sp,startptr meet at beginning of loop)   
                                    move slow ptr by 1 and stp by 1 while they dont meet   
                                    return slowptr OR startptr 
                                return false                                           //null check for even nodes not req because you return at reqyured point
                                                                                       //null check for odd nodes  not req because you return at requured point
                                    
                                    
                                    
                                                                                           PROOF OF FLOYDS CYCLE-FINDING ALGORITHM II:
                                                                                            a        b
                                                                                            <------><----->                     a = distance from head node to start of cycle = 2
                                                                                            1   2   3  4  5  6                  b = distance from start of cycle to meeting point of sp,fp = 2
                                                                                                    |_________|                 n = length of cycle = 4
                                                                                                    <--------->
                                                                                                        n                       distance travelled by fp = distance travelled by sp + length of cycle
                                                                                                                                2(a+b) = (a+b) + n
                                                                                                                                n = a + b ----So when you are at b and you travel a distance of a from there on you will complete n and reach loop start


                                                  

    

                                                              
        TIME :O(n)  
        SPACE: O(1)                                                        
       */

        //NULL CHECK FOR HEAD
        if(head == null ){ return null;}  

        Node slowptr = head;  
        Node fastptr = head;

        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;

            if (fastptr == slowptr ){
                Node startptr = head;

                while(startptr != slowptr){
                    startptr = startptr.next;
                    slowptr = slowptr.next;
                }

                return slowptr;


            }
                
        }

        return null;
    }
  

    //CIRCULAR LL
    public  Node     addInCircularSorted(Node head,int val){
         /*
       Question
       1--2--3--4--5       --circular LL is a list in which lastnode points to head node
       |________|             Add the given node in sorted circular LL 

       2
       1-2-2-3-4-5
       |_________|

       6
       1-2-3-4-5-6
       |_________|
       
       */


        /*
        dN-1-2-3-4-5   --initialise ptr to head;prevptr to dummyNode
        | |_______|     move ptr till last node
        pp p                if ptr ka val >= val 
                                prevptr ka next to new node;newNode ka next to ptr ;break because you have done >= so you dont want to encounter next node if it is same as current

                        
                                       
                        if(ptr.val >= val)                                      //null check if(condition for modifying1stNode){} before while loop; because ypu have to rearrange the incoming loop at 1st node also
                           move ptr till last node
                           add node at 1st pos 
                           return head; //null check for 1st node ,attachments             
                            
                        if(nodeAdded >= false)                                //null check if(condition for modifyingLastNode){} after while loop; because  you dont encounter the last node
                           if ptr.val >= val
                              add value before ptr
                           if(ptr.val < val)
                               add value after ptr 

                        return head                                            //null check for modifying 1st/single node ; null check for attachments   
                           
                           
                         
                                                              
        TIME :O(n)  
        SPACE: O(1)                                                        
       */


        Node new_node = new Node(val);
        //NULL CHECK FOR HEAD
        if(head == null){head = new_node ;return head;}
        
        
        Node ptr = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr = dummyNode;
        boolean nodeAdded = false;
        

        
        if(ptr.val >= val){                        //null check if(condition for modifying1stNode){} before while loop; because ypu have to rearrange the incoming loop at 1st node also

            while(ptr.next!=head){
                prevptr = ptr;
                ptr = ptr.next;
            }
            
            
            dummyNode.next =new_node ;
            new_node.next = head;
            ptr.next = new_node;
            
            
            
            
            head = dummyNode.next;//null check for modifyng 1st node
            dummyNode.next = null;//null check for attachments 
            return head;
        
            
        }
        
        while(ptr.next != head){
             if(ptr.val >=val){
                 prevptr.next = new_node;
                 new_node.next = ptr;
                 nodeAdded = true;
                 break;
             }
            prevptr = ptr;
            ptr = ptr.next;
        }
        
   
        if(nodeAdded == false){                   //null check if(condition for modifyingLastNode){} after while loop; because  you dont encounter the last node
            if(ptr.val >= val){
                prevptr.next = new_node;
                new_node.next = ptr;
            }
            if(ptr.val < val){
                Node nextptrTemp = ptr.next;
                ptr.next = new_node;
                new_node.next = nextptrTemp;
                
                
            }
        }
        
        
        
        head = dummyNode.next;   //null check for modifying 1st/single node ; 
        dummyNode.next = null;   //null check for attachments
        return head;
        
    }
  
    
    //2LL
    public Node     compare2LLForAddition(Node head1, Node head2){
        /*
        Question
        9--9---9--9--9       -- add 2 LL into another LL
        9--9
        -------------
        8--9--0--0--0--1

        */

        
        /*
        9--9--9--9--9--n 
        9--9--n
        dN              -initialise ptr1 , ptr2 to head , ptr3 to dummyNode
                         move ptr1 ptr2 till both not null(ptr1,ptr2 at null,eq node ; cb enc lastNode,eq node ; ca enc null,eq node [LL1 small; vice versaLL2 small] )
                                int operand1 = ptr1.val;
                                int operand2 = ptr2.val;
                                int sum = operand1 + operand2 + carry;
                                carry = sum /10;   -->calculate carry before sum  becaused sum is reassigned                        
                                sum = sum %10;

                                connect ptr3 ka next to sum ;move ptr3 ahead
                                move ptr1 ahead
                                move ptr2 ahead

                        if(ptr1!=null){               //null check if(ptr1!=null){}  for smaller LL2
                            move ptr1 till null(ptr1 at null ; cb till last node ; ca till null)
                                int operand1 = ptr1.val;
                                int sum = operand1  + carry;
                                carry = sum /10;                           
                                sum = sum %10;

                                connect ptr3 ka next to sum ;move ptr3 ahead
                                move ptr1 ahead}  
                        if(ptr2!=null){              //null check if(ptr1!=null){}  for smaller LL1
                            move ptr2 till null(ptr2 at null ; cb till last node ; ca till null)
                                int operand1 = ptr2.val;
                                int sum = operand1  + carry;
                                carry = sum /10;                         
                                sum = sum %10;

                                connect ptr3 ka next to sum ;move ptr3 ahead
                                move ptr1 ahead}
                            }    

                        if(carry != 0){                  -->TAKE INTO ACCOUNT THE CARRY LEFT AFTER LAST ADDITIONM
                            connect ptr3 ka next to carry}      

                        return head               //null check for modifying single node/1st node ; null check for attachment
                                                    
                        //NULL CHECK FOR HEAD:4 combinations       

       
                         
        */

        

        //NULL CHECK FOR HEAD
        if(head1 == null && head2 == null){return null;}
        if(head1 != null && head2 == null){return head1;}
        if(head1 == null && head2 != null){return head2;}
        if(head1 != null && head2 != null){}//do nothing

        Node ptr1 = head1;
        Node ptr2 = head2;
        Node dummyNode = new Node(-1);
        Node ptr3 = dummyNode;
     

        int carry= 0; 
        while(ptr1 != null && ptr2 != null){
            int operand1 = ptr1.val;
            int operand2 = ptr2.val;
            int sum = operand1 + operand2 + carry;
            carry = sum /10;
            sum = sum %10;
        
            
            ptr3.next  = new Node(sum);
            ptr3 = ptr3.next;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;     
        }
        
        if(ptr1 != null){      
            
            while(ptr1 != null){  
                int operand1 = ptr1.val;
                int operand2 = ptr2.val;
                int sum = operand1 + operand2 + carry;
                carry = sum /10;
                sum = sum %10;
            
                
                ptr3.next = new Node(sum);
                ptr3 = ptr3.next;
                
                
                ptr1 = ptr1.next;
            }
            
            
            
        }
        if(ptr2 != null){          
            while(ptr2 != null){
                int operand1 = ptr1.val;
                int operand2 = ptr2.val;
                int sum = operand1 + operand2 + carry;
                carry = sum /10;
                sum = sum %10;
            
                
                ptr3.next = new Node(sum);
                ptr3 = ptr3.next;
                
                
                ptr2 = ptr2.next;
            }
        }
        
        if(carry !=0){              
            ptr3.next = new Node(carry);
            ptr3 = ptr3.next;
        }
        
        
        Node head3= dummyNode.next;  //null check for modifying single node/1st node 
        dummyNode.next = null;       //null check for attachment
        return head3;
        
        
        
    }
    public Node     compare2LLForAdditionOfPolynomial(Node head1,Node head2){
        /*
        Question
        1x^3--3x^2---2x^1--1x^0       -- add 2 LL into another LL 
        3x^2--2x^1                       where each LL consists of node which consists of coeff,pow instead of val 
        -------------                     public class Node{int coeff;int pow;Node next;public Node(int coeff,int pow){this.coeff = coeff;this.pow =pow;}}
        1x^3--6x^2---4x^1--1x^0 

        */

        
        /*
        1x^3--3x^2---2x^1--1x^0      
        3x^2--2x^1   
        dN              -initialise ptr1 , ptr2 to head1,head2 , ptr3 to dummyNode
                         move ptr1 ptr2 till both not null(ptr1,ptr2 at null,eq node ; cb enc lastNode,eq node ; ca enc null,eq node [LL1 small; vice versaLL2 small] )
                            if ptr1.pow > ptr2.pow
                               connect ptr3 ka next to new node(ptr1.coeff,ptr1.pow) ; move ptr3 ahead
                               move ptr1 ahead
                            else if ptr2.pow > ptr1.pow
                               connect ptr3 ka next to new node(ptr2.coeff,ptr2.pow) ; move ptr3 ahead
                               move ptr2 ahead
                            else if ptr1.pow > ptr2.pow
                            |   connect ptr3 ka next to new node(ptr1.coeff + ptr2.coeff,ptr1.pow) ; move ptr3 ahead
                            |   move ptr1 ahead
                            |   move ptr2 ahead
                            |
                            else if because ptr modifies inside if else
                            and ptr1 ,ptr2 used as conditiom

                        if(ptr1!=null){               //null check if(ptr1!=null){}  for smaller LL2
                            move ptr1 till null(ptr1 at null ; cb till last node ; ca till null)
                                connect ptr3 ka next to new node(ptr1.coeff + ptr2.coeff,ptr1.pow) ; move ptr3 ahead
                                move ptr1 ahead}  
                        if(ptr2!=null){              //null check if(ptr1!=null){}  for smaller LL1
                            move ptr2 till null(ptr2 at null ; cb till last node ; ca till null)
                                connect ptr3 ka next to new node(ptr2.coeff,ptr2.pow) ; move ptr3 ahead
                                move ptr2 ahead}         

                        return head                //null check for modifying single node/1st node ; null check for attachment
                                                    
                        //NULL CHECK FOR HEAD:4 combinations       

       
                         
        */

        

        //NULL CHECK FOR HEAD
        if(head1 == null && head2 == null){return null;}
        if(head1 != null && head2 == null){return head1;}
        if(head1 == null && head2 != null){return head2;}
        if(head1 != null && head2 != null){}//do nothing

        
        Node ptr1 = head1;
        Node ptr2 = head2;
        Node dummyNode = new Node(-1); // Node dummyNode = new Node(-1,-1);
        Node ptr3 = dummyNode;
        while(ptr1!= null && ptr2 != null){
            
            //if(ptr1.pow > ptr2.pow){
               //ptr3.next = new Node(ptr1.coeff,ptr1.pow); 
               ptr3 = ptr3.next;
               
               ptr1 = ptr1.next;
            //}
            //else if(ptr2.pow > ptr1.pow){
                //ptr3.next = new Node(ptr2.coeff,ptr2.pow);
                ptr3 = ptr3.next;
                
                ptr2 = ptr2.next;
            //}
            //else if(ptr1.pow == ptr2.pow){
                //ptr3.next = new Node(ptr1.coeff+ ptr2.coeff,ptr1.pow);
                ptr3 = ptr3.next;
                
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            //}
            
            
        }
        
        
        if(ptr1!=null){                                    //null check if(ptr1!=null){}  for smaller LL2
            while(ptr1 != null){
                //ptr3.next = new Node(ptr1.coeff,ptr1.pow); 
                ptr3 = ptr3.next;
                
                ptr1 = ptr1.next;
            }
            
            
        }
        if(ptr2!=null){                                   //null check if(ptr1!=null){}  for smaller LL1
            while(ptr2 != null){
                //ptr3.next = new Nodee(ptr2.coeff,ptr2.pow); 
                ptr3 = ptr3.next;
                
                ptr2 = ptr2.next;
            }
            
            
        }
        
        
        Node head3 = dummyNode.next;                     //null check for modifying single node/1st node ;
        dummyNode.next = null;                           // null check for attachment
        return head3;
    
    
        
        
        
    }
    public Node     compare2LLSortedForMerging(Node head1,Node head2){
        /*
        Question
        1--2---4       -- merge 2 sorted LLL 
        1--3--4
        -------------
        1--2--3--4--4

        */


        /*
        1--2---4
        1--2--4
        dN              -initialise ptr1 , ptr2 to head , ptr3 to dummyNode
                         move ptr1 ptr2 till both not null(ptr1,ptr2 at null,eq node ; cb enc lastNode,eq node ; ca enc null,eq node [LL1 small; vice versaLL2 small] )
                            if(ptr1.val < ptr2.val)
                              connect ptr3 ka next to ptr1 ka val ; move ptr3 ahead
                              move ptr1 ahead
                            else if(ptr2.val < ptr1.val) 
                              connect ptr3 ka next to ptr2 ka val ; move ptr3 ahead
                              move ptr2 ahead
                            else if(ptr2.val < ptr1.val) 
                            |  connect ptr3 ka next to ptr1 ka val ; move ptr3 ahead; connect ptr3 ka next to ptr2 ka val ; move ptr3 ahead
                            |  move ptr1 ahead
                            |  move ptr2 ahead
                            |
                            else if because ptr modifies inside if else
                            and ptr1 ,ptr2 used as conditiom

                            if(ptr1!=null){              //null check if(ptr1!=null){}  for smaller LL2
                                move ptr1 till null(ptr1 at null ; cb till last node ; ca till null)
                                    connect ptr3 ka next to ptr1 ka val ;move ptr3 ahead
                                    move ptr1 ahead}  
                            if(ptr2!=null){              //null check if(ptr1!=null){}  for smaller LL1
                                move ptr2 till null(ptr2 at null ; cb till last node ; ca till null)
                                    connect ptr3 ka next to ptr1 ka val ;move ptr3 ahead
                                    move ptr2 ahead}   

                             return head                //null check for modifying single node/1st node ;null check for attachment     

        
                        //NULL CHECK FOR HEAD:4 combinations       






    

                                                              
        TIME :O(n)  
        SPACE: O(1)                                                        
       */

        //NULL CHECK FOR HEAD
        if(head1 == null && head2 == null){return null;}
        if(head1 != null && head2 == null){return head1;}
        if(head1 == null && head2 != null){return head2;}
        if(head1 != null && head2 != null){}//do nothing
        
        Node ptr1 = head1;
        Node ptr2 = head2;
        Node dummyNode = new Node(-1);
        Node ptr3 = dummyNode;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                ptr3.next = new Node(ptr1.val);
                ptr3 = ptr3.next;
                
                ptr1 = ptr1.next;
                
            } 
            else if(ptr2.val < ptr1.val){          //e;se if because ptr modifies                                
                ptr3.next = new Node(ptr2.val);
                ptr3 = ptr3.next;
                
                ptr2 = ptr2.next;
                
            }
            
            
            
            else if(ptr1.val == ptr2.val){
                ptr3.next = new Node(ptr1.val);
                ptr3 = ptr3.next;
                ptr3.next = new Node(ptr2.val);
                ptr3 = ptr3.next;
                
                
                
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                
            }
            
        }
        
        
        if(ptr1 != null){             //null check if(ptr1!=null){}  for smaller LL2
            while(ptr1 != null){
                ptr3.next = new Node(ptr1.val);
                ptr3 = ptr3.next;
                
                ptr1 = ptr1.next;
            }
        }
        if(ptr2 != null){             //null check if(ptr1!=null){}  for smaller LL1
            while(ptr2 != null){
                ptr3.next = new Node(ptr2.val);
                ptr3 = ptr3.next;
                    
                ptr2 = ptr2.next;
                
                
            }
            
        }
         
        Node head3= dummyNode.next;  //null check for modifying single node/1st node 
        dummyNode.next = null;       //null check for attachment
        return head3;
        
            
        
        
        
    }
    public Node     compare2LLForIntersectingNode(Node head1, Node head2){
        /*
         Question
         1--2---3--4--5       -- return intersecting node of 2 LL 
               /
         1--2--
         
         */
  
  
          /*
         1--2-----3--4--5     --initialise ptr1 to head1,head2 
         |        /              while ptr1 !=ptr2                                                 -->Intersection-finding Algorithm (If LL intersest ptr1, ptr2 meet at intersection node and ptr1=ptr2 ; if they do not intersect ptr1, ptr2 reach null and ptr1==ptr2)   )                                       
       ptr1      /                  if ptr1 is not mull move ptr1 ahead else move ptr1 to head2      VISUALISATION:https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len! -- BryanBo-Cao ka comment                         
         1--2---/                   if ptr2 is not mull move ptr2 ahead else move ptr2 to head1                                                  
         |                      return ptr1                                                                        
        ptr2                         
                               //NULL CHECK FOR HEAD:4 combinations     
                                   
                                  
                                                                                    
                                                     
        
                              
  
  
      
  
                                                                
          TIME :O(n)  
          SPACE: O(1)                                                        
         */
  

        //NULL CHECK FOR HEAD
        if(head1 == null && head2 == null){return null;}
        if(head1 == null && head2 != null){return null;}
        if(head1 != null && head2 == null){return null;}
        if(head1 != null && head2 != null){}//do nothing
          
        Node ptr1 = head1;
        Node ptr2 = head2;
        while(ptr1 != ptr2){
                                                            
            ptr1 = (ptr1 != null) ? ptr1.next: head2;      //move ptr1 ptr acc to condition till ptr1!=ptr2      
            ptr2 = (ptr2 != null) ? ptr2.next: head1;
          }   
          
  
        return ptr1;                                    
  
          
          
          
          
          
          
      }
    public Node     matrixLLCompareRowForMerging(Node[] arr){
         /*
        [1,2,4]  -->1-2-3-4-5-6   --find the merge of matrix containing LL(merge is combination with duplicates) in sorted manner
        [3,4,5] 
        [2,3,6]   
     
        */

     
        /*
        Look in basic algorithm/Matrix
        */

    
        return null;
    }  


    //SORT
    public Node     linkedListInsertionSort(Node head) {
        /*
        pp2 p2
        |   |
        dN--4--2--1--3
        |   |
        p1  p2                 --initialise ptr2 to head , prevptr2 to dummyNode , nextptr2Temp to null
                                 move ptr2 till null(ptr till null , cb enc lastNode, ca enc null) , prevptr to ptr2 before moving ptr2 -->MOVE BASED ON PTR2 IS REMOVED OR NOT
                                      initialise ptr1 to dummyNode ka next, prevptr to dummyNode
                                      move ptr1 till ptr2(ptr1 till ptr2 , cb enc 1 node before ptr2,cf enc till ptr2),prevptr1 to ptr1 
                                          if(ptr1.val>ptr2)
                                            remove ptr2 (ptr2isRemioved = true)
                                            add ptr2 before ptr1
                                            break because you have removed ptr2 and moved it before so ptr1!=ptr2 becomes invalid
                                          else   
                                             do nothing(ptr2isRemioved = false)
                                return head           //null check for modifying 1stnode/singlenode , null check for attachment

                                //NULL CHECK FOR HEAD:if( head == null ){return null;}
        
        
        */
        //NULL CHECK FOR HEAD
		if( head == null ){return null;}
		
		Node ptr2 = head;
        Node dummyNode = new Node(-1);dummyNode.next = head;
        Node prevptr2 = dummyNode;
        Node nextptr2Temp = null;
        boolean ptr2IsRemoved = false; 
        
        while(ptr2!=null){
            
            
            Node ptr1 = dummyNode.next;   
            Node prevptr1 = dummyNode;
            while(ptr1!=null && ptr1 != ptr2){
                if(ptr1.val > ptr2.val){
                    //REMOVE PTR2
                    nextptr2Temp = ptr2.next;
                    prevptr2.next = ptr2.next;
                    ptr2IsRemoved = true;
                    
                    
                    //ADD PTR2 BEFORE PTR1
                    prevptr1.next = ptr2;
                    ptr2.next = ptr1;
                    
                    break;
                }
                else{
                    ptr2IsRemoved = false;
                }
                prevptr1 = ptr1;
                ptr1 = ptr1.next;
            }
    



            prevptr2 = (ptr2IsRemoved == false) ?ptr2:prevptr2;
            ptr2     = (ptr2IsRemoved == false) ?ptr2.next:nextptr2Temp ;          
            
        }
        
        
        head = dummyNode.next; //null check for modifying 1stnode/singlenode 
        dummyNode.next = null; //null check for attachment
        return head;
        
        
	}
    public Node     linkedListmergeSortRecursive(Node head){
        /*
        LOOK IN recursion linkedListmergeSortRecursive()
        */
        return null;
    }

 


    

}



