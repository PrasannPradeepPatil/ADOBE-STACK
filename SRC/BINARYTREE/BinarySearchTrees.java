package SRC.BINARYTREE;
import java.util.*;

//BST DEFN
/*
SAME AS BT



*/


//BST CODING(In examples fnNameI and fnNameII means in the fn you will see 2 methods I is with no ret type and II is with ret type)
/*
SAME AS BT 
+
LEFTNODE < ROOTNODE <  RIGHTNODE
1.
left subtree < right subtree                                                                  EG:DFSPrePosttInOrderContains;DFSPrePosttInOrderInsert
left subtree < right subtree  so ancestor will be at splitting point                          EG:DFSPrePostInOrderLowestComonAncestor
2.
leftmost Node is purely min                                                                   EG: DFSPrePosttInOrderMinNode; DFSPrePosttInOrderMaxNode
rightmost node is purely max     
3.
min difference nodes will be together                                                         EG:DFSAnyToAnyPathDifferenceOfNodesMin
max difference nodes will be extreme left and extreme right
4.
bottom-top,left-right(inorder) will give nodes in strictly ascending order                    EG:DFSPrePosttInOrderkthMinNode; DFSPrePosttInOrderkthMaxNode; DFSPrePosttInOrderIsBST(BT); 
bottom-top;right-left(inorder) will give nodes in strictly descending order                                                                      


LEFTNODE  <=ROOTNODE <= RIGHTNODE -->SPECIFIED IN QUES    
1.
left subtree <= right subtree   
left subtree <= right subtree  so ancestor will be at splitting point  
2.
leftmost Node is  min                                                              
rightmost node is  max
3.
min difference nodes will be together 
max difference nodes will be extreme left and extreme right
+
Duplicate Nodes will be together                                                              EG:DFSPrePosttInOrderModes                                                               
4.
left-right;bottom-top(top middle me ie inorder) will give nodes in  ascending order     
right-left;bottom-top(top middle me ie inorder) will give nodes in  descending order  

*/



public class BinarySearchTrees {

    //NODE CLASS
    private class Node {
        /*
           val
         ---------
          lc |  rc

         */
        private int val;
        private Node left;
        private Node right;
        private Node() {//this.val=0;this.left=null;this.right=null(constructor gives default values)
        }
        private Node(int val) { this.val = val; //this.left=null;this.right=null(constructor gives default values)
        }
        private Node(int val, Node left, Node right) {this.val = val;this.left = left;this.right = right;}




    }
    //CONSTRUCTOR                //INITIALISING ROOT
    private Node root;           //BinSearchTree Construction:-->Compiler will call className obj = new ClassName() ; obj.methodName() so you must initialise root with default values in constructor of class 
    public BinarySearchTrees(){  // BinSearchTree Methods     -->Compiler will call className obj = new ClassName() ; obj.methodName(new Node()) so no root initialised by compiler
        root = null;
    }                           //RETURNING NODES
                                
                                 //RETURN NODES
                                 //return new Node()               -- returns Node with value=0 ,left =null,right=null
                                 //return new Node(val)            -- returns Node with value=value ,left =null,right=null
                                 //return new Node(val,left,right) -- returns Node with value=value ,left =left,right=right
                                 //return root                     -- -- return root along with its subtree vals
    
                          

    


    //DFSPREPOSTORDER
    public void DFSPrePostInOrderMaxNode   (Node root){
        /*
          root-- 4        -->travel top-bottom ;left-right      (DFS)
                /  \         and return max node in BST
               2     6        7
              / \    / \    
             1   3   5  7    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


        //RECURSION IP -OP TREE
        /* 
        public void DFSPrePostInOrderMaxNode(Node root){ 
                                                                --while going top-bottom  
            if (root == null){return;}                                return at null and  start moving up   
            pathMax = max(pathMax,root.val)//pathMax is global var    replace pathMax by max node val
            
            DFSPrePostInOrderMaxNode(root.right);                 --while going left-right 
                                                                  go right only (left <(!<=)root<(!<=) right so rightmost node is purely max : hence we move only right)
        }

        //OVERIDE
        int pathMax = Integer.MIN_VALUE;  
        public void DFSPrePostInOrderMaxNode(Node root){
            DFSPrePostInOrderMaxNode(root);
            return pathMax;

         }

        Time :O(log4 n) if it is balanced tree  as we traverse only right throwing 1/4 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        //BT:You have to travel top-bottom left-right(all nodes) and find max Node           Time:O(n)      
        //BST:You have to travel  top-bottom rightt (only right side) and find max Nodes     Time:O(log4 n)
        */
        
        //RECURSION IP-OP TREE
        /*
                      4   r=7                             
                /          \  7                                                 
               /            \ 
              2              6   r=1
             /  \          /    \  
            /    \        /      \  7      --return max(right,root.val)
           /      \      /        \
          1        3     6        7  r=m
         /\       /\      /\      /\
       m/  \m   m/  \m  m/  \m  m/  \m    -- return Integer.MIN_VALUE
        n  n    n    n   n  n    n  n

        
        public int  DFSPrePostInOrderMaxNode      (Node root){

                                                                --while going top-bottom
            if(root==null) {return Integer.MIN_VALUE;}            return Min value at null and move up
                                                                pass to next node

            int right = DFSPrePostInOrderMaxNodeII(root.right);      --while going left-right 
                                                                    go to only right only (left <(!<=)root<(!<=) right so rightmost node is purely max : hence we move only right)
                                                                    right holds max value from right subtree 
            
                                                                --while going bottom-up
            return Math.max(Math.max(right,right),root.data);      max of right and root ka val
                                                                pass to next node
        }

        //OVERRIDE
        public int DFSPrePostInOrderMaxNode(Node root)  {
            return DFSPrePostInOrderMaxNode(root);
        }


        Time :O(log4 n) if it is balanced tree  as we traverse only right throwing 1/4 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        //BT:You have to travel top-bottom left-right(all nodes) and find max Node        Time:O(n)
        //BST:You have to travel  top-bottom rightt (only right side) and find max Nodes  Time:O(log2 n)
        */

        //ITERATIVE
        /*

           MAX        -->ptr = root -- assign otr to keep root intact so that we can return root(entire tree) if req
       root-- 7         while ptr != null               (left <(!<=)root<(!<=) right so rightmost node is purely max : hence we move only right
        ptr   /  \          ptr on right
            4    9      return ptr val
           / \    / \   //EDGE CASE : if ptr is null return -1
           1  6   8  10
         /  \ /\  /\  / \
        n  n  n n n n  n n
        public int     DFSPrePostInOrderMaxNodeI_Iteration(Node root){
            //EDGE CASE
            var ptr = root;
            if (ptr == null) {
                return -1;}

            
            while (ptr.right != null) {
                ptr = ptr.right;
            }
            return ptr.val;


        }


        Time :O(log2 n) if it is balanced tree  as we throw half nodes
              :O(n) if it is a unbalanced completely right skewed as we have to travel all nodes on righty
               :O(1) if it is a unbalanced completely left  skewed as we have to check only root node
        Space:O(1) as we do not require extra data

        //BT:You have to travel top-bottom left-right(all nodes) and find max Node           Time:O(n)      
        //BST:You have to travel  top-bottom rightt (only right side) and find max Nodes     Time:O(log4 n)
   
       */
 

    }
    public void DFSPrePostInOrderMinNode   (Node root){
        /*
          root-- 4        -->travel top-bottom ;left-right         (DFS)
                /  \         and return min node in BST
               2     6        1
              / \    / \    
             1   3   5  7    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */

        //RECURSION IP -OP TREE
        /*  
        public void DFSPrePostInOrderMinNode  (Node root){}
                                                               --while going top-bottom  
        if (root == null){return;}                                return at null and  start moving up   
        pathMin = min(pathMax,root.val)//pathMax is global var    replace pathMax by max node val
        
        DFSPrePostInOrderMinNode(root.left);                  --while going left-right
                                                              go to only left  (left <(!<=)root<(!<=) right so leftMost node is purely min : hence we move only left)
  
        Time :O(log4 n) if it is balanced tree  as we traverse only right throwing 1/4 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        //OVERRIDE
        int pathMIN = Integer.MAX_VALUE;    
        public void DFSPrePostInOrderMinNode(Node root){
            DFSPrePostInOrderMinNode(root);
            return pathMin;

         }


        //BT:You have to travel top-bottom left-right(all nodes) and find max Node       Time:O(n)
        //BST:You have to travel  top-bottom left (only right side) and find min Nodes   Time:O(log4 n)
          
          */

        //RECURSION - IP-OP TREE
        /*
                4  l =1                             
              1  /         \                                                   
               /            \ 
          l=1  2              6   
             /  \          /    \  
         1  /    \        /      \        --return min(left,root.val)
           /      \      /        \
     l=m  1        3     6        7  
         /\       /\      /\      /\
       M/  \M   m/  \m  m/  \m  m/  \m    -- return Integer.MAX_VALUE
        n  n    n    n   n  n    n  n

        
        public int DFSPrePostInOrderMinNode(Node root)

                                                                --while going top-bottom
            if(root==null) {return Integer.MAX_VALUE;}            return max value at null and move up
                                                                pass to next node

            int left = DFSPrePostInOrderMinNode(root.left);      --while going left-right go to only left only (left <(!<=)root<(!<=) right so leftmost node is purely min : hence we move only left) 
                                                                    left  holds min from right subtree
            
                                                                --while going bottom-up
            return Math.max(left,root.val);                        min of left and root ka val
                                                                pass to next node

        }
        
        //OVERRIDE
        public int DFSPrePostInOrderMinNodeII(Node root)  {
            return DFSPrePostInOrderMinNodeII(root);}


        Time :O(log4 n) if it is balanced tree  as we traverse only right throwing 1/4 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
            O(n) we are  using list that takes extra space

        //BT:You have to travel top-bottom left-right(all nodes) and find max Node      Time:O(n)
        //BST:You have to travel  top-bottom left (only right side) and find min Nodes  Time:O(log2 n)

        */
        
        //ITERATIVE
        /*

                    -->ptr = root -- assign otr to keep root intact so that we can return root(entire tree) if req
       root-- 7         while ptr != null           (left <(!<=)root<(!<=) right so leftmost node is purely max : hence we move only left
        ptr   /  \          move ptr on left
            4    9      return ptr val
           / \    / \   //EDGE CASE : if ptr is null return -1
           1  6   8  10
         /  \ /\  /\  / \
        n  n  n n n n  n n
        public int     DFSPrePostInOrderMinNodeI_Iteration(Node root){
            //EDGE CASE
            if (root == null) {
                return -1;
            }

            var ptr = root;
            while (ptr.left != null) {
                ptr = ptr.left;
            }
            return ptr.val;
        }

        Time :O(log2 n) if it is balanced tree  as we throw half nodes
              :O(n) if it is a unbalanced completely left skewed as we have to travel all nodes on left
               :O(1) if it is a unbalanced completely right  skewed as we have to check only root node
        Space:O(1) as we do not require extra data
        DFSPreOrder:  because you see root;then go to left subtree;then go to right subtree
   
         //BT:You have to travel top-bottom left-right(all nodes) and find max Node       Time:O(n)
        //BST:You have to travel  top-bottom left (only right side) and find min Nodes   Time:O(log4 n)
       */






    }
    public void DFSPrePostInOrderKthMaxNode(Node root){
        /*
           root-- 4        -->travel top-bottom ;left-right         (DFS)
                 /  \         and  return kth max node in  BST 
                2     6        
               / \    / \      
              1  3   5   7    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
  
        //RECURSION IP -OP TREE
        /* 
        public void DFSPrePostInOrderKthMaxNode(Node root)
                                                                                                     -- while going top-bottom   
        if (root == null){return;}                                                                      return at null and  start moving up 

        
        DFSPrePostInOrderKthMaxNode(root.right);                                                    --while going right-left  
                                                                                                       go right then left  (left <(!<=)root<(!<=) right so  right-left;bottom-top(top middle me ie inorder) will give nodes in purely descending order)
                                             
                                                                              
                                                                                                       --while going bottom-top(top middle wala)
         pathIndex++ //  pathIndex  if ==s global                                                       increment pathindex and if it matchhes k 
         if(pathIndex == k){                                                                            then give pathMaxNode root value
             pathMaxNode = root.val //pathMaxNode is global var 
         }
         DFSPrePostInOrderKthMaxNode(root.left); 

         //OVERRIDE
         boolean pathBoolean = false;
         int pathIndex = 0;
         int pathMaxNode  = 0;
         public Node DFSPrePostInOrderKthMaxNode(Node root){
             DFSPrePostInOrderKthMaxNode(root);
             return pathMaxNode;
         }


        Time :O(n) if it is balanced tree  as we traverse all nodes 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space


        //BT:You have to travel top-bottom left-right(all nodes) and store nodes in  array; then fond kth largest in array using maxheap Time:O(n) + O(n logk) ; Space:O(n) recursion + O(n) arrat + O(k) heap 
        //BST:You have to travel  top-bottom right-left (all nodes) and find max Nodes                                                   Time:O(n)             ; Space:O(n) recursion 
  

         */    
         
        //RECURSION IP-OP TREE
        /* Consider 3rd largest node
                    4  l =6,r=0                             
            0  /         \  6                                                  
            /            \ 
    l=0,r=0  2              6  l=0,r=0
            /  \          /    \  
        0  /    \    0   /      \   0     --if(pathIndex == k){return rootval}  ;   return left + right 
        /      \      /        \
l=0,r=0  1 l,r=0 3     6 l,r=0  7  l=0,r=0
        /\       /\      /\      /\
                                                --return 0

    public int DFSPrePostInOrderKthMaxNode(Node root){
                                                                                                    -- while going top-bottom   
        if (root == null){return 0;}                                                                    return 0  at null and  start moving up and pass to next node

        
        int left = DFSPrePostInOrderKthMaxNode(root.right);                                           --while going right-left  
                                                                                                        go right then left  (left <(!<=)root<(!<=) right so  right-left;bottom-top(top middle me ie inorder) will give nodes in purely descending order)
                                                                                                        left,right hold 0 or kth Node value from left and right subtree
                                                                            
                                                                                                    --while going bottom-top(top middle wala)
        pathIndex++ //  pathIndex  if ==s global                                                       increment pathindex and if it matchhes k 
        if(pathIndex == k){                                                                            returnn root value and pass to next node
            return root.val  
        }
        int right = DFSPrePostInOrderKthMaxNode(root.left); 

        return left + right                                                                           --while going bottom-top
                                                                                                        return left+right to next node
    }

    //OVERRIDE
    int pathIndex = 0;
        public Node DFSPrePostInOrderKthMaxNode(Node root){;
            return DFSPrePostInOrderKthMaxNode;
        }


    Time :O(n) if it is balanced tree  as we traverse all nodes 
        :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
    Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space


    //BT:You have to travel top-bottom left-right(all nodes) and store nodes in  array; then fond kth largest in array  Time:O(n) + O(n logk) ; Space:O(n) recursion + O(n) arrat + O(k) heap 
    //BST:You have to travel  top-bottom right-left (all nodes) and find max Nodes                                      Time:O(n)             ; Space:O(n) recursion 

        */    


     }
    public void DFSPrePostInOrderKthMinNode(Node root){
        /*
           root-- 4        -->travel top-bottom ;left-right       (DFS)
                 /  \         and  return kth min node in  BST 
                2     6        
               / \    / \      
              1  3   5   7    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 

        //RECURSION IP -OP TREE
        /* 
        public void DFSPrePostInOrderKthMinNode(Node root){
                                                                                                        -- while going top-bottom   
            if (root == null){return;}                                                                      return at null and  start moving up 

            
            DFSPrePostInOrderKthMinNode(root.left);                                                    --while going left-right  
                                                                                                        go right then left  (left <(!<=)root<(!<=) right so left-right;bottom-top(top middle me ie inorder) will give nodes in purely ascending order)
                                                
                                                                                
                                                                                                        --while going bottom-top(top middle wala)
            pathIndex++ //  pathIndex  is global                                                          increment pathindex and if it matchhes k 
            if(pathIndex == k){                                                                            then give pathMinNode root value
                pathMinNode = root.val //pathMinNode is global var 
            }
            DFSPrePostInOrderKthMinNode(root.right); 
        }

        //OVERRIDE
        int pathIndex = 0;
         int pathMinNode  = 0;
         public Node DFSPrePostInOrderKthMinNode(Node root){
             DFSPrePostInOrderKthMinNode(root);
             return pathMinNode;
         }

        Time :O(n) if it is balanced tree  as we traverse all nodes 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
    

        //BT:You have to travel top-bottom left-right(all nodes) and store nodes in  array; then fond kth smallest in array  Time:O(n) + O(n logk) ; Space:O(n) recursion + O(n) arrat + O(k) heap 
        //BST:You have to travel  top-bottom right-left (all nodes) and find min Nodes                                       Time:O(n)             ; Space:O(n) recursion 


         */    
    
         
         
        //RECURSION IP-OP TREE
        /* Consider 3rd smallest node
                    4  l =2,r=0                             
            2  /         \  0                                                  
            /            \ 
    l=0,r=0  2              6  l=0,r=0
            /  \          /    \  
        0  /    \    0   /      \   0     --if(pathIndex == k){return rootval}  ;   return left + right 
        /      \      /        \
l=0,r=0  1 l,r=0 3     6 l,r=0  7  l=0,r=0
        /\       /\      /\      /\
                                                --return 0


    public int DFSPrePostInOrderKthMinNode(Node root){
                                                                                                    -- while going top-bottom   
    if (root == null){return 0;}                                                                    return 0  at null and  start moving up and pass to next node

        
    int left = DFSPrePostInOrderKthMinNode(root.left);                                              --while going left-rightr  
                                                                                                    go left then right  (left <(!<=)root<(!<=) right so  left-right;bottom-top(top middle me ie inorder) will give nodes in purely ascending order)
                                                                                                    left,right hold 0 or kth Node value from left and right subtree
                                                                            
                                                                                                    --while going bottom-top(top middle wala)
        pathIndex++ //  pathIndex  if ==s global                                                       increment pathindex and if it matchhes k 
        if(pathIndex == k){                                                                            returnn root value and pass to next node
            return root.val  
        }
        int right = DFSPrePostInOrderKthMinNodeII(root.right); 

        return left + right                                                                           --while going bottom-top
                                                                                                        return left+right to next node
    }

    //OVERRIDE
        int pathIndex = 0;
        public Node DFSPrePostInOrderKthMinNode(Node root){;
            return DFSPrePostInOrderKthMinNode(root);
        }

    Time :O(n) if it is balanced tree  as we traverse all nodes 
        :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
    Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space


    //BT:You have to travel top-bottom left-right(all nodes) and store nodes in  array; then fond kth largest in array   Time:O(n) + O(n logk) ; Space:O(n) recursion + O(n) arrat + O(k) heap 
    //BST:You have to travel  top-bottom left-right (all nodes) and find min Nodes                                       Time:O(n)             ; Space:O(n) recursion 


        

        */    

         
     }
    public void DFSPrePostInOrderSumOfNodesInRange(Node root, int low , int high){
        /*
           root-- 4        --travel top-bottom ;left-right      (DFS)
                 /  \         and return sum  of nodes which lie the range [low,high] inclusive
                2    6        
               / \    / \    
              1  3   5    7    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
         //RECURSION IP-OP TREE
         /*
         public void DFSPrePostInOrderSumOfNodesInRange(Node root, int low , int high){
                                                                         --while coming top-down
            if(root == null){return;}                                     if root is null return and move to next node
             
            if(root.val >= low && root.val <= high)                       if root val lies bw range 
                 pathSum = pathSum + root.val; //pathSum is global            add value to pathSum
             
                                                                          --while going left-rigght
            if(root.val >  low)                                              if root.val > low
                DFSPrePostInOrderSumInRange(root.left,low,high);                 valid node will be on left so go to left
            if(root.val < high)                                              if root.val < high
                DFSPrePostInOrderSumInRange(root.right,low,high);               valid node will be on right so go to left
                                                                            
         }
 
         //OVERRIDE
         int pathSum = 0;  
         public void DFSPrePostInOrderSumOfNodesInRange(Node root, int low, int high){
             DFSPrePostInOrderSumOfNodes(root,low,high);
             return pathSum;
 
          }
        Time :O(log n) if it is balanced tree  as we traverse  half nodes 
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                    :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                     +
                    O(n) we are  using list that takes extra space
    

         
         */
 
        //RECURSIVE IP- OP TREE
         /* 
                   7 l=19;r=4                                   
          19     /          \  4                                                 
                /            \ 
     l=7;r=8  4                1   l=2,r=1
              /  \          /    \  
          8  /    \ 7    2 /      \  1    --return left + right+root.val;
            /      \      /        \
  l=0;r=0  8  l,r=0 7     2l,r=0    1 l=0;r=0
          /\       /\      /\      /\
        0/  \ 0  0/  \0  0/  \0  0/  \0    -- return 0
         n  n    n    n   n  n    n  n
 
         public int DFSPrePostInOrderSumOfNodesInRange(Node root, int low , int high){
                                                                         --while coming top-down
            if(root == null){return 0;}                                     if root is null return 0 and move to next node
             
             
                                                                          --while going left-rigght
            int left = 0;
            int right =0;
            if(root.val >  low)                                              if root.val > low
                left = DFSPrePostInOrderSumInRange(root.left,low,high);         valid node will be on left so go to left and left stores sum
            if(root.val < high)                                              if root.val < high
                right DFSPrePostInOrderSumInRange(root.right,low,high);         valid node will be on right so go to left and right stores sum
                                                                            
            }

                                                                               
                                                                        --while coming bottom-up
            if(root.val >= low && root.val <= high){                      if node ka value lies in range
                return left + right + root.val;                              sum of nodes of left + right subtree + node ka val pass to next node
            else                                                          else 
                return left + right + 0;                                   sum of nodes of left + right subtree + 0 l pass to next node

         //OVERRIDE
         public int DFSPrePostInOrderSumOfNodesInRange(Node root, int low, int high){
            return  DFSPrePostInOrderSDFSPrePostInOrderSumOfNodesInRangeumOfNodes(root,low,high);
 
          }
 
        Time :O(log n) if it is balanced tree  as we traverse  half nodes 
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                    :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                     +
                    O(n) we are  using list that takes extra space
         */
 
 
     }
    public void DFSPrePostInOrderContains  (Node root, int val){
        /*
           root-- 4        -->travel top-bottom ;left-right        (DFS)
                 /  \         and  if contains return true false 
                2     6        and if contains return node or null Eg 6
               / \    / \      and if contains eturn node and its subtrenodes or null  Eg [6,5,7]
              1  3   5   7    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
  
        //RECURSION IP -OP TREE
        /* 
        public void DFSPrePostInOrderContains(Node root, int val){
                                                                                                     -- while going top-bottom   
        if (root == null){return;}                                                                      return at null and  start moving up 
        if(root.val == val ){                                                                           if root ka val matches val
              pathBoolean      = true;         //pathBoolean,pathNode,pathNodeSbbtree are  global      make pathBoolean as true , pathNode as sinle node , pathNodeSbbtree as node and all its subnodes
              pathNode        = new Node(val);
              pathNodeSubtree = root     
         }
   
          
        if(root.val > val){
            DFSPrePostInOrderContains(root.left);}                                                       --while going left-right  
        if(root.val < val){                                                                               if root val > val  move left;if root val < val move right   (left <(!<=)root<(!<=) right so move left right accordin)
            DFSPrePostInOrderContains(root.right);}           
        }
        
        //OVERRIDE
        boolean pathBoolean = false;
         Node pathNode = null;
         Node pathNodeSubtree  = null;
         public Node DFSPrePostInOrderContains(Node root,int val){
             DFSPrePostInOrderContains(root,val);
             return pathBoolean;
             return pathNode
             return pathNodeSubtree;
         }
        
        Time :O(log2 n) if it is balanced tree  as we traverse either left or right  and throw half of nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
    

        //BT:You have to travel top-bottom left-right(all nodes) and check if contains                               Time:O(n)
        //BST:You have to travel top-bottom left or  or right(left or roght subtree nodes)and and check if contains  Time:O(log2 n)
 
        */    

        
         //RECURSION IP-OP TREE
        /*
          Consider item to find is 6
                  4 l=f;r=t                                 
         f      /          \  t                                                  
               /            \ 
    l=f;r=f   2              6   l=f,r=f
             /  \          /    \                     -- boolean nodeContains =  (root.val == val) ;   OR if (root.val == val)  { ... ;  return true;} 
         f  /    \ f    f /      \  f                    return left || right || nodeContains;            return left || right;; 
           /      \      /        \
 l=f;r=f  1  l,r=f 3     5 l,r=f    7 l=f;r=f
         /\       /\      /\      /\
       f/  \ f  f/  \f  f/  \f  f/  \f                -- return true
      n  n    n    n   n  n      n  n

        public boolean  DFSPrePostInOrderContains(Node root,int val) {
                                                                    --while going top-bottom
            if(root==null) {return false;}                            return false at null and move up 
                                                                    pass to next node
            boolean left = false;
            boolean right = false;                                                           
            if(root.val > val){
                left  =DFSPrePostInOrderContains(root.left);}         ---while going left-right
            if(root.val < val)boolean                                 if root val > val  move left;if root val < val move right ( (left <(!<=)root<(!<=) right so left subtree < right subtree) 
                right =DFSPrePostInOrderContains(root.right);          left,right hold whether  left and right subtree contains node


                                                                    --while going bottom-top
            boolean nodeContains =  (root.val == val) ;                  left has val || right has val ; node has val   pass to next node 
            return left || right || nodeContains;                        pass to next node
            OR                                                          
            if (root.val == val)                                         left has val || right has val ; node has val   pass to next node 
                pathNode=new Node(val);//pathNode,pathNodeSbbtre global pass to next node                          
                pathNodeSubtree = root                                                                           
                return true;
            return left || right;
        }

        //OVERRIDE
        pathBoolean = false;
        pathNode = false;
        pathNodeSubtree = null;
        public Node DFSPrePostInOrderContains(Node root,int val)  {
                DFSPrePostInOrderContains(root);
            return pathBoolean/pathNode/pathNodeSubtree;
        }

        Time :O(log2 n) if it is balanced tree  as we traverse either left or right  and throw half of nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
    

        //BT:You have to travel top-bottom left-right(all nodes) and check if contains                                 Time:O(n)
        //BST:You have to travel top-bottom left or  or right(left or roght subtree nodes)and and check if contains    Time:O(log2n)

      */

        
        //ITERATIVE
        /*           
                         -->ptr = root                  --> assign otr to keep root intact
      root--  7          while ptr is not null       lefnode <(! <=)rootnode <(! <=) rightnode  left subtreee < right subtree       
      ptr--- /  \           if val < ptr
            4    9              move ptr to left
           / \    / \       else if val > ptr        -->ptr is getting updated inside above if and used as condition in this if  ;hence  use "ELSE IF"
           1  6   8  10         move ptr to right
         /  \ /\  /\  / \    else if val == ptr      -->ptr is getting updated inside above if and used as condition in this if  ;hence  use "ELSE IF"
        n  n  n n n n  n n      return true/new Node(ptr.val)/ptr
                             //EDGE CASE: If root is null return false/null/null

        public boolean DFSPrePostInOrderContainsI_Iteration(Node root ,int val){
            var ptr = root;
            //EDGE CASE
            if(ptr == null)
                return false;

            while (ptr != null) {
                if (val < ptr.val)
                    ptr = ptr.left;
                else if (val > ptr.val)
                    ptr = ptr.right;
                else if(val == ptr.val)
                    return true;
            }
            return false;

        }
        Time :O(log2 n) if it is balanced tree  as we throw half nodes
              :O(n) if it is a unbalanced completely left/right skewed as we have to travel all nodes
        Space:O(1)  as we do not require extra data
        DFSPreOrder:  because you see root;then go to left subtree;then go to right subtree
                        
        
        //BT:You have to travel top-bottom left-right(all nodes) and check if contains                               Time:O(n)
        //BST:You have to travel top-bottom left or  or right(left or roght subtree nodes)and and check if contains  Time:O(log2 n)                
        
       */


     }
    public void DFSPrePostInOrderFrequencyOfNodesMax     (Node root,List<Integer> pathList){
        /*
          root-- 4        -->travel top-bottom ;left-right       (DFS)  
                /  \         For a special BST where left <=root <= right  
               2     6       return list of modes in any order ie nodes with max frequency
              / \    / \     ie [1,5]     
             1  1   5   5    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */



       //RECURSION IP -OP TREE
       /* 
       public void DFSPrePostInOrderFrequencyOfNodesMaxI(Node root,List<Integer> pathList
                                                                           -- while going top-bottom   
           if (root == null){return;}                                          return at null and  start moving up 

           
           DFSPrePostInOrderFrequencyOfNodesMax(root.left);                              --while going left-right  

                                               
                                                                               
                                                                           --while going bottom-top(top middle wala) ( lefnode <(! <=)rootnode <(! <=) rightnode  so duplicate nodes will be together)
                                                                               //COUNT NO OF NODES                
           if(previousNode != null){                                           if prev != null  
               if(root.val == previousNode.val){                                 if root val = prev val add pathCount 
                   pathCount++;                                                  if(root.val != prevval make pathcount to 1
               }                                                               if prev = null                        
               if(root.val != previousNode.val){                                    make path count 1                   
                   pathCount=1;                                                                                     
               }
           }   
           if(previousNode == null){                                           if(prev == null)                      -->You miss doing pathcount = 1 for  node whose prev is null  add max node to list
               pathCount =1;                                                      make pathcount 1                      Eg IP:[1,n,2] ; for node pathCount=1 must me made even if prev =n
           }                                                    



                                                                           //ADD MAX NO OF NODES TO LST     
           if(pathCount > pathMaxCount){                                      if we find better count                           
               pathMaxCount = pathCount;                                       reset pathMaxcount
               pathList.clear();                                                clear prev added val  and add this value
               pathList.add(root.val);                                       else if we find same count                    -->pathMaxCount is updated in above if and used as condition in this if ; hence we must use "else if"                                                               
           }                                                                   then also add value to list as there might   
           else if(pathCount == pathMaxCount){                                 be multiple nodes with                       
               list.add(root.val)                                                                                           
           }  
               
       
           
           previousNode = root;

           DFSPrePostInOrderFrequencyOfNodesMaxI(root.right);
           
       }

       //OVERRIDE
       public void DFSPrePostInOrderFrequencyOfNodesMax(Node root){
           List<Integer> pathList = new ArrayList<>(); 
           DFSPrePostInOrderFrequencyOfNodesMax(Node root,List<Integer> pathList);
           return pathList;
       }
       

       Time :O(n) if it is balanced tree  as we traverse all nodes 
           :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
       Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
               :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
               +
               O(n) we are  using list that takes extra space
   

       //BT:You have to travel top-bottom left-right(all nodes) and store nodes and their freq in  hashMapthen populate list with key of max value
       //BST:You have to travel  top-bottom left-right (all nodes) and find frequency from previous nodes as duplicate nodes will be together 



        */  

       //RECURSION IP -OP TREE
       /*
       WHILE COMING BOTTOM-UP YOU CANT RETURN VALUE(VOID TYPE) -->IF L,R WILL CARY LIST<INTEGER> ;SO WHILE COMING BOTTOM-TOP WHAT TO RETURN ? L?R? L+R?   
       */


       
   }    
    public void DFSPrePostInOrderLCA       (Node root,Node n1, Node n2){
        /*
           root-- 7        -->travel top-bottom ;left-right        (DFS)
                 /  \         and  return lowest common ancestor of n1,n2
                4    9        where we allow a node to be a descendant of itself 8,10 
               / \    / \      4,9 lowest common ancestor is 7 ; 4 1 lowest common ancestor is 4
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */


        //RECURSION IP -OP TREE
        /* 
        public void DFSPrePostInOrderLCA(Node root,Node n1, Node n2){ 
                                                                        --while going top-bottom  
            if (root == null){return;}                                      return at null and  start moving up   

                                                                        --while going left-right ( lefnode <(! <=)rootnode <(! <=) so leftSubtree < rightSubtree)
            if(root.val > n1.val && root.val > n2.val){                     if root.val > n1,n2 then move to left as n1,n2 are on left  
                DFSPrePostInOrderLowestComonAncestor(root.left,n1,n2)}      else if root.val < n1,n2 then move to right as n1,n2 are on right 
            else if(root.val < n1.val && root.val < n2.val){                 else n1 on left n2 on right or vice versa which means we have reached split point
                DFSPrePostInOrderLowestComonAncestor(root.right,n1,n2)}     and split point is  ancestor 
            else{
                ancestor = root.val; //ancestor is global 
            }
        }
        
        //OVERRIDE
        int ancestor = 0;
        public Node  DFSPrePostInOrderLCA(Node root,Node n1, Node n2){
            DFSPrePostInOrderLCA(root,n1,n2);
            return new Node(ancestor);
        }
        
        Time :O(log2 n) if it is balanced tree  as we traverse only right throwing 1/2 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        //BT:You have to travel  left-right,top-bottom(all nodes) and find common ancestor while coming bottom-up  Time:O(n)      
        //BST:You have to travel left or right , top-bottom and find ancestor   at split point                  Time:O(log2 n)
    
                                                               
        */
        
        //RECURSION - BINARY RECURSIVE TREE(Binary tree is  recursive DS)
        /*  
        Consider finding lowest common ancestor of 1,2
                  7 l=2;r=null                                 
              2 /            \                                                    
               /              \ 
      l=2,r=n 4                 9  
             /  \             /    \                     --return left,return right depending on where we travel  , return root
          2 /    \           /      \                    
           /      \         /        \
   l= r=   2        5 l,r= 7        7
          /\
         /  \
   l= r= 1   3   l= r=                                 --return null(never reach here as we return at 2 itself so l,r not populated)


        public Node  DFSPrePostInOrderLowestComonAncestor(Node root,Node n1, Node n2){
                                                                          --while going top-bottom  
            if (root == null){return null;}                                 return at null and  start moving up   
                                                            
                                                                    
            Node left = null;                                                             
            Node right = null;                                                   --while going left-right ( lefnode <(! <=)rootnode <(! <=) so leftSubtree < rightSubtree)
            if(root.val > n1.val && root.val > n2.val){                           if root.val > n1,n2 then move to left as n1,n2 are on left; left hold ancestor;return left and pass to next node  
                left = DFSPrePostInOrderLowestComonAncestorII(root.left,n1,n2)    else if root.val < n1,n2 then move to right as n1,n2 are on right; right hold ancestor;;return lrighteft and pass to next node 
                return left; }     ------------------------------------------- \   else n1 n2 on left right or vice versa means we reahched sp;it point which means it is ancestor; return root and pass to next node     
            else if(root.val < n1.val && root.val < n2.va){                     \   
                right = DFSPrePostInOrderLowestComonAncestorII(root.right,n1,n2);\
                return right;}   ---------------------------------------------------->while coming bottom-top
            else{                                                                 /   return left and pass to next node   (We return  l OR r depending whether we moved l or r  
                return  root;  --------------------------------------------------/    return right and pass to next node   In other words we always get non null value)
            }                                                                         return root and pass to next node    
        }
        
        //OVERRIDE
        public Node  DFSPrePostInOrderLowestComonAncestorII(Node root,Node n1, Node n2){
            return DFSPrePostInOrderLowestComonAncestorII(root,n1,n2);
        }

        Time :O(log2 n) if it is balanced tree  as we traverse only right throwing 1/2 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        //BT:You have to travel  left-right,top-bottom(all nodes) and find common ancestor while coming bottom-up  Time:O(n)      
        //BST:You have to travel left or right , top-bottom and find ancestor   at split point                      Time:O(log2 n)                                                          
        */


            
    }
    public void DFSPrePostInOrderIOSucesor (Node root, Node node){
           /*
            5   -- Traverse the tree in in order fashion and return the inorder sucessor(ie node we will enc after given node while travelling inOrder) 
            /\      Eg: 6 -->5
           3  6
          /\
          2  4
         /
         1
        
        */
        
        //RECURSIVE IP -OP TREE --> THIS WONT WORK FOR DUPLICATES , FOR DUPLICATE NODES USE THE SOLN OF BINARY TREE
        /*
             5  
            /\      
           3  6
          /\
          2  4
         /
         1

        public void DFSPrePostInOrderIOSucessor(Node root, Node node){
                                                                                 --while coming down
            if(root == null){return;}                                              if root is null return and move to next node

            if(root.val <= node.val){                                             if root.val <= node.val
                DFSPrePostInOrderIOSucessorr(root.right,node);}                       means node is on the right so move right
            else if(root.val > node.val){                                         else if root.val > node.val
                sucessor = root; //sucessor is global                                  current root is an candidate for inOrder sucessor
                DFSPrePostInOrderIOSucessorr(root.left,node);                         means node is on the right so move right
            }
        }
        }

        //OVERLOAD
        Node sucessor = null;
        public void DFSPrePostInOrderIOSucessor(Node root, Node node){
            DFSPrePostInOrderIOSucessor(root,node);
            return sucessor
        }

    
        Time :O(log2 n) if it is balanced tree  as we traverse only right throwing 1/2 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        
        
        */

        //ITERATIVE -> THIS WONT WORK FOR DUPLICATES , FOR DUPLICATE NODES USE THE SOLN OF BINARY TREE
        /*
             5  
            /\      
           3  6
          /\
          2  4
         /
         1

        public void DFSPrePostInOrderIOSucessor(Node root, Node node){
            while(root != null)                                                    --while root is not null

                if(root.val <= node.val){                                             if root.val <= node.val
                   root = root.right;}                                                     means node is on the right so move right
                else if(root.val > node.val){                                         else if root.val > node.val
                    sucessor = root;  //sucessor is global                                  current root is an candidate for inOrder sucessor
                    root = root.left;                                                       means node is on the right so move right
                }
            }
        }

        //OVERLOAD
        Node sucessor = null;
        public Node DFSPrePostInOrderIOSucessor(Node root, Node node){
            DFSPrePostInOrderIOSucessor(root,node);
            return sucessor
        }

    
        Time :O(log2 n) if it is balanced tree  as we traverse only right throwing 1/2 nodes
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(1)

        
        
        */


    
    }
    public void DFSPrePostInOrderInsert    (Node root ,int val){
        /*
       root-- 4       -->Travel top-bottom ;left-right  (DFS)
             /  \        and insert node to mantain BST 
            2     5      and retur root [4,2,1,3,5,6,7] 
           / \    / \    NOTE : WE INSERT AT LEAF NODE ONLY SO NO NEED TO WORRY ABOUT MIDDLE INSERTION IN MIDDLE
          1  3   6  7            EG: Look in VISUALISATION-->BINARY SEARCH TREE
         /  \ /\  /\  / \
        n  n  n n n n  n n

         */
    
        //RECURSION IP -OP TREE
        /*
        //WHILE COMING BOTTOM-UP YOU NEED RETURN VALUE(RET TYPE) -->RETURN VALUE WILL  CARRY LEFT SUBTREE IN LEFT AND RIGHT SUBTREE IN RIGHT 
         */
        
        //RECURSION IP -OP TREE
        /*
        Consider Inserting   5
                    4 l=2N;r=7N                                 
                /          \  7N                                                  
               /            \ 
              2              7   l=5N r=8N
             /   \          /    \                     -- return root 
            /     \      6N/      \  8N                    
           /       \      /        \
          1         3     6 l,r=5N  8 l=6N;r=6N
                          /                           -- return new Node(val)
                         /
                         5 INSERT



        public Node  DFSPrePostInOrderInsert(Node root ,int val){
                                                                --while coming bottom-top
            if(root == null){                                       return  new Node(val)  at null and move up
                return new Node(val);}                               pass to next node                 
                
        Node left =  null;
        Node right = null;
        if(root.val > val){                                      --while coming left,right 
            left= DFSPrePostInOrderInsertII(root.left,val);        if root val > val  move left;if root val < val move right ( (left <(!<=)root<(!<=) right so left subtree < right subtree) 
            root.left = left } -   \                                   left,right hold   left and right subtree 
            if(root.val < val){     \--------------------------------\                                
                right = DFSPrePostInOrderInsertII(root.right,val);    \
                root.right = right} -----------------------------------> while coming top bottom 
                                                                     /   root.left = left  
                                                                    /   root.right = right
            return root   -------------------------------------------    return  root and  pass to next node 
        }

        //OVERRODE
        public void DFSPrePostInOrderInsert(Node root, int val){
           return DFSPrePostInOrderInsert(root,val);}
        

        Time :O(log2 n) if it is balanced tree  as we throw half nodes
            :O(n) if it is a unbalanced completely left/right skewed as we have to travel all nodes
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height ht 

        //BT:You have to travel top-bottom left-right(all nodes) and dont have any property to insrt node  Time: X
        //BST:You have to travel  top-bottom left or right  and insert node acc to BST property            Time:O(log2 n)

         */
        
        //ITERATIVE
        /*               
                          ptr = root                                                          --> assign otr to keep root intact
        root--  7         while true                                                             lefnode <(! <=)rootnode <(! <=) rightnode  left subtreee < right subtree       
        ptr--- /  \           if ptr.val > val
              4    9              if left is not null move to left   
             / \    / \           elseif left is null  insert on lefetchild and return      -->ptr is getting updated inside above if and used as condition in this if  ;hence  use "ELSE IF"
             1  6   8  10     else if ptr.val < ptr                                         -->ptr is getting updated inside above if and used as condition in this if  ;hence  use "ELSE IF"
           /  \ /\  /\  / \        if right is not null move right
          n  n  n n n n  n n       else if  right  is null  insert on lefetchild and return -->ptr is getting updated inside above if and used as condition in this if  ;hence  use "ELSE IF"
                              return root
                            //EDGE CASE: If root is null give root new node and return root;


        public Node    DFSPrePostInOrderInsertI_Iteration(Node root ,int val){
            var ptr = root;
            //EDGE CASE
            if (root == null) {
                root = new Node(val);
                return root; }
    
            while (true) {
                if (val < ptr.val) {
                    if (ptr.left != null) {
                        ptr = ptr.left;
                    }
                    else if (ptr.left == null){
                        ptr.left = new Node(val);
                        break;
                    }
                        
                }
                else if(val > ptr.val) {
                    if (ptr.right != null) {
                        ptr = ptr.right;
                    }
                    else if(ptr.right != null){
                        ptr.right = new Node(val);
                        break;

                    }
                        
                }
            }
        
            return root;
        }

        Time :O(log2 n) if it is balanced tree  as we throw half nodes
              :O(n) if it is a unbalanced completely left/right skewed as we have to travel all nodes
        Space:O(1) as we do not require extra data

        //BT:You have to travel top-bottom left-right(all nodes) and dont have any property to insrt node 
        //BST:You have to travel  top-bottom left or right  and insert node acc to BST property  Time:O(log2 n)

                        
  
            */
  
 
    
    }


    //DFSANYTOANY
    public void DFSAnyToAnyPathDifferenceOfNodesMin(Node root){
        /*
         root-- 7      -->Traverse top-bottom ;left-right   (DFS)
               /  \        return any to any path ka min difference between any 2 nodes  (AnyToAny)    
              2     11     EG 2-1 = 1 is the min diff bw any 2 nides   
             / \    / \  
             1  4   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */


        //RECURSION IP -OP TREE
        /*  
        public void DFSAnyToAnyPathDifferenceOfNodesMin(Node root){
                                                                        --while going top-bottom  
            if (root == null){return;}                                        return at null and  start moving up   
            pathMax = max(pathMax,root.val)//pathMax is global var            replace pathMax by max node val
            
            DFSPrePostInOrderMaxNodeI(root.left);                            --while going left-right 
                                                
                                                                            --while going bottom-top(top middle wala ie inorder)  ( ( lefnode <(! <=)rootnode <(! <=) rightnode  so min diff nodes will be together))
            if(previousNode != null){                                           if(orevious != null )
            pathDifference = root.val - previousNode.val;                    find the diff bw current and previous node 
            pathMinDifference  = Math.min(pathDifference,pathMinDifference);  find the min of all diff
            }
            
            previousNode = root;                                             
            
            
            DFSAnyToAnyPathDifferenceOfNodesMin(root.right);
        }

        //OVERRIDE
        int pathMax = 0;
        public int DFSAnyToAnyPathDifferenceOfNodesMin(Node root){
            DFSAnyToAnyPathDifferenceOfNodesMin(root);
            return pathMax
        }
        
        Time :O(n) if it is balanced tree  as we have to traverse al odes
            :O(n) if it is a unbalanced completely left/right skewed as we have to travel all nodes
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height ht 

        //BT:You have to travel left-right,top-bottom any to any nodes  and check for all paths for min node 
        //BST:You have to travel  left-right,top-bottom check for min node as min diff nodes will be together as nodes are in asc order  Time:O(n)

        */

        

        
        
        
        
        
    }
    
    
    

    //CONSTRUCT
    public void binarySearchTreeConstructionFromPreOrder(int[] inOrder,int inOrderLeft,int inOrderRight){
        /*
         8    PRERDER:[8,5,1,7,10] -- Given PreOrder array(Sorted arrayy)
        / \                           Convert to BST of balanced height
       5   10                          
       / \
       1 7
        
        */
        
        //RECURSION IP -OP TREE
        /*
        [8,5,1,10,7]
        public TreeNode binarySearchTreeConstructionFromPreOrder(int[] preOrder, int lowerLimit,int upperLimit){

                                                                                 --while going top-bottom
            if (preOrderIndex == preOrder.length) {                                if we reach end of arr
                return null;}                                                      tree is constructed return null

            int rootVal = preOrder[preOrderIndex];                                 create a root node from preOrderIndex         
            if (rootVal < lowerLimit || rootVal > upperLimit) return null;         and if value is not within bpunds return null
            TreeNode root = new TreeNode(rootVal);
            preOrderIndex++;
         
                                                                                                  --whilegping top-bottom    
            root.left = binarySearchTreeConstructionFromPreOrder(preOrder,lowerLimit, rootVal);   left subtree will be from lowerLimit to upperLimit = root ka val
            root.right = binarySearchTreeConstructionFromPreOrder(preOrder,rootVal, upperLimit);  right subtree will be from lowerLimit = root ka val to upperLimit 

                                                                                                  --while going bottom-top  
            return root;                                                                            return root
        }

           
        //OVERROIDE
        int preOrderIndex =0;
        public TreeNode binarySearchTreeConstructionFromPreOrder(int[] preorder) {
            return binarySearchTreeConstructionFromPreOrder(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
            
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        */

        
        
        
        }
    public void binarySearchTreeConstructionFromPostOrder(int[] inOrder,int inOrderLeft,int inOrderRight){
        /*
        8  POSTORDER:[1,7,5,10,8] -- Given PostOrder array(Sorted arrayy)
        / \                               Convert to BST of balanced height
        5   10                          
        / \
        1 7
        
        */
        
        //RECURSION IP -OP TREE
        /*
        [1,7,5,10,8]
        public TreeNode binarySearchTreeConstructionFromPostOrder(int[] postOrder, int lowerLimit,int upperLimit){

                                                                                    --while going top-bottom
            if (postOrderIndex == -1) {                                             if we reach start of arr
                return null;}                                                        tree is constructed return null

            int rootVal = postOrder[postOrderIndex];                               create a root node from postOrderIndex         
            if (rootVal < lowerLimit || rootVal > upperLimit) return null;         and if value is not within bounds return null
            TreeNode root = new TreeNode(rootVal);
            postOrderIndex--;
            
                                                                                                    --whilegping top-bottom
            root.right = binarySearchTreeConstructionFromPostOrder(postOrder,rootVal, upperLimit);  right subtree will be from lowerLimit = root ka val to upperLimit     
            root.left = binarySearchTreeConstructionFromPostOrder(postOrder,lowerLimit, rootVal);   left subtree will be from lowerLimit to upperLimit = root ka val
           

                                                                                                    --while going bottom-top  
            return root;                                                                            return root
        }

            
        //OVERROIDE
        int postOrderIndex;
        public TreeNode binarySearchTreeConstructionFromPostOrder(int[] postOrder) {
            postOrderIndex = postOrder.length-1;
            return binarySearchTreeConstructionFromPostOrder(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
            
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        */

        
        
        
        }
    public void binarySearchTreeConstructionFromInorder_SortedArrToBST(int[] inOrder,int inOrderLeft,int inOrderRight){
        /*
         0  INORDER:[-10,-3,0,5,9] -- Given Inorder array(Sorted arrayy)
        / \                            Convert to BST of balanced height
      -10   5                          Note:You will not get a unique soln so return any 1 soln
       \     \
       -3     9
        
        */
        
        //RECURSION IP -OP TREE
        /*
        [-10,-3,0,5,9]
        public Node binarySearchTreeConstructionFromInorder_SortedArrToBST(int[] inOrder,int inOrderLeft,int inOrderRight)
                                                                                                           --while going top-down
            if(inOrderLeft > inOrderRight){                                                                  if left > right
                return  null;                                                                                  return  null
            }
            int middle = inOrderLeft + (inOrderRight - inOrderLeft)/2;                                      create a root node with middle
            int rootVal = inOrder[middle]                                                                   
            Node root = new Node(rootVal);                                                        
            
                                                                                                           --while going top-down
            root.left = binaryTreeConstructionFromInorder_SortedArrToBST(inOrder,inOrderLeft,middle-1);      left subtree will be left of middle
            root.right= binaryTreeConstructionFromInorder_SortedArrToBST(inOrder,middle+1,inOrderRight);     left subtree will be right of middle
            
                                                                                                            --while going bottpm-top
            return root;                                                                                     return root
        }

        //OVERROIDE
        public Node binarySearchTreeConstructionFromInorder_SortedArrToBST(int[] inOrder){
            return binarySearchTreeConstructionFromInorder_SortedArrToBST(inOrder,0,inOrder.length-1);
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        */

        
        
        
        }
    public void binarySearchTreeSerializeDeserialize(){
        /*
        Question
        3          
        /\         
        9 20       
            /\
            15 7   
            |
            |
        serialize()   :convert BST  into a sequence of bits(smallest encoded string) 
        deserialize() :converting back to BST
        */

        /*
        Binary Search tree can be serialised using DFSPreOrder,DFSPostOrder,DFSInOrder
        and all will give same length of encoded string but constructing BST from InOrder is not unique ; hence use DFSPreOrder OR DFSPostOrder 


        class binarySearchTreeSerializeDeserialize{
            public String serialize(Node root) {
                List<Integer> res = new ArrayList<>();            ---Convert BST to list 
                DFSPreOrder(root,res);                               and then convert list  to string((Look in Java/Object/Unique )
                StringBuilder sb= new StringBuilder("");           
                for(String s: res){                                
                    sb.append(s);
                    sb.append("#");
                }
                
                return sb.toString(); 
            }

            public TreeNode deserialize(String s) {
                if(s == ""){return null;}                          --Convert string to arr and construct BST from arr
                String[] arr = s.split("#");
                int[] preOrder = new int[arr.length];int index = 0;
                for(int i=0 ; i <= arr.length-1;i++){preOrder[i] = Integer.valueOf(arr[i]);}
                return binarySearchTreeConstructionFromPreOrder(preOrder);
            }
        }

        OR

        class binarySearchTreeSerializeDeserialize{
            public String serialize(Node root) {
                List<Integer> res = new ArrayList<>();            ---Convert BST to list  and then convert list  to string using delimeter "#"
                DFSPostOrder(root,res);                                (delimeter: Look in Java/Object/Unique arrays)
                StringBuilder sb= new StringBuilder("");           
                for(String s: res){                                
                    sb.append(s);
                    sb.append("#");
                } 
                return sb.toString(); 
            }
            public TreeNode deserialize(String s) {
                if(s == ""){return null;}                          --Convert string to arr and construct BST from arr
                String[] arr = s.split("#");
                int[] postOrder = new int[arr.length];int index = 0;
                for(int i=0 ; i <= arr.length-1;i++){postOrder[i] = Integer.valueOf(arr[i]);}
                return binarySearchTreeConstructionFromPostOrder(postOrder);
            }
        }

            Time :O(n) for both serialise deserialise as we travel all nodes in tree
            Space:O(n) for both serialise deserialise as we store  all nodes of tree in String
        
        
        */
    }


    
    
    


   

}
