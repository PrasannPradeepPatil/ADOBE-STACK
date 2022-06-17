package BINARYTREE;
import java.util.*;
import java.util.Stack;






//BINARY TREE DEFINATIONS(FIND THEM BEFORE DIFFERENT TRAERSALS)
/*
1.
HeightOfNode      = longest path from NodeToLeaf              = max no of nodes/edges NodeToLeaf        
DepthOfNode       = path    from nodeToRoot                   = no of nodes/edges  rootToNode
HeightOfBinTree   =longest  path from rootToLeaf              = max no of nodes/edges rootToLeaf     HeightOfBinTree =  MaxDepthOfBinTree
MaxDepthOfBinTree =longest  path from leafToRoot =rootToLeaf  = max no of nodes/edges rootToLeaf
MinDepthOfTree    =shortest path from leafToRoot =rootToLeaf  = max no of nodes/edges rootToLeaf
DiameterOfBinTree =longest  path from leafToLeaf              = max no of nodes/edges rLeafToLeaf 
SizeOfBinTree                                                  = no of nodes/edges in a tree
     |                                                                        |
     |                                                                        |
   height/maxdepth/mindepth balanced binary Tree                    = O(log n)  nodes or edges depends on defn of Path whether it is noOfnodes or noOfegdes  
   height/maxdepth/mindepth unbalance left/right skewed binary Tree = O(n)       noOfEdges = NoOfNodes-1  
   size of a balanced binary tree                                   = O(n)
   size of a unbalance left/right skewed binary Tree                = O(n)

2.
Balanced Binary Tree          = All nodes have equal heights on left and right                                           (|heightOfLeftSubtree-heightOfRightSUbtree|<=1 ) 
    |- Full Binary Tree       = All nodes have 0 OR 2  nodes                                                             (!((root.left == null && root.right == null) || (root.left!=null && root.right != null)))
    |- Complete Binary Trees  = All all levels are completely filled except last which has all nodes as left as possible (index <= noOfnodes index is index of node level wise)     
    |- Perfect Binary Tree    = All nodes have 2 children and all leaves are at same level.                              (sizeof tree == 2^(height  of tree +1) – 1 )
Unbalanced Binary Tree        = All nodes have unequal heights on left and right                                         (--) 
    |- Left skewed            = Most of nodes have left child  ie it is fully on left side
    |- Right  skewed          = Most nodes have right child  ie it is fully on right  side
    Eg https://cs.stackexchange.com/questions/32397/is-there-a-difference-between-perfect-full-and-complete-tree#:~:text=4%20Answers&text=Yes%2C%20there%20is%20a%20difference,has%200%20or%202%20children.&text=Perfect%20Binary%20Tree%3A%20A%20Binary,leaves%20are%20at%20same%20level.    
Binary Tree        =each node has max 2 children             
Binary Search Tree =each node has max 2 children;lefnode <(! <=)rootnode <(! <=) rightnode                                 (properties in BST)
Binary AVL Tree    =each node has max 2 children;lefnode <(! <=)rootnode <(! <=) rightnode;balanced                        (properties in BAT)



3.TEST CASES
[4,10,NULL,5,5,NULL,6,7,NULL,8,8,NULL,8,1] -->nodes are level wise 

             4
            /\
          10  N  
          /\
         5   5
        /\   /\
       N 6   7 N
         /\  /\
        8 8  N 8
        /
        1



*/

//BINARY TREE CODING 
/* #region Main */

//NOTE: In examples fnNameI and fnNameII means in the fn you will see 2 methods I is with no ret type and II is with ret type

/*
//RECURSIVE PATH        
      n1           --> Recursive path left-right  :n1 d,n2 d,n4 d,n4 u,n5 d,n5 u,n2,n3 d,n6 d,n6 u,n7 d,n7 u,n3 u, n1 u
     /    \                            top-bottom :n1,n2,n4,n5,n3,n6,n7
    /      \                           bottom-top :n4,n5,n2,n6,n7,n3,n1
   n2       n3                         bottom-top(top in middle):n4,n2,n5,n1,n6,n3,n7 
   / \      / \        Recursive path right-left  :n1 d,n3 d,n7 d,n7 u,n6 d,n6 u,n3 u,n2 d,n5 d,n5 u,n4 d ,n4 u,n2 u , n1 u
  /   \     /   \                      top-bottom : n1,n3,n7,n6,n2,n5,n4 
 n4     n5  n6    n7                   bottom-top :n7,n6,n3,n5,n4,n4,n1
                                       bottom-top(top in middle):n7,n3,n6,n1,n5,n2,n4
                                
                                      *d = wile coming down
                                       u = while going up


//VOID RECURSIVE                                           
public void sumOfNodes(Node root){
                                     while going top-bottom                                                                      
if(root == null){return;}            return start moving up                                          
pathSize = pathSize +root.val;       Do something with nodes                                               //NULL CHECK                                                         
                                                                                                          //CHANGES TO ARG(IMMUTABLE,MUTABLE(res,arg))   (LEVEL,PREVIOUSNODE)
sumOfNodes(root.left,level+1);      while going left-right/right-left(while going down itself)             |
sumOfNodes(root.right,level+1);                                                                            |                                 
                                    while going bottom-up                                                LOOK AT BOTTOM
pathSize = pathSize +root.val       Do something with nodes                                                     
 
                                  
                                            
//RETURN RECURSIVE(YOU WANT TO STORE WALUE WHILE GOING TOP-DOWN OR BOTTOM-TOP)
(
    CONSIDER NO OF NODES                                         PRIME  EXAMPLES
                     7 l=3;r=3                                   DFSPrePostInOrderLowestCommonAncestorII       (RETURN BOOLEAN ,HOLD INTEGER)
         3      /          \  3                                  DFSPrePostInOrderLowestCommonAncestorII(BST)  (FN IS BROKEN , LINE AFTER Fn IS WHILE COMING BOTTOM-TOP) 
               /            \                                    DFSPrePostInOrderINsertII(BST)                (FN IS BROKEN , LINE AFTER Fn IS WHILE COMING BOTTOM-TOP) 
    l=1;r=1  4                1   l=1,r=1                        DFSPrePostInOrderMergeII 
             /  \          /    \  
         1  /    \ 1    1 /      \  1    --return left + right+1
           /      \      /        \
 l=0;r=0  8  l,r=0 7     2l,r=0  1 l=0;r=0
         /\       /\      /\      /\
       0/  \ 0  0/  \0  0/  \0  0/  \0   -- return 0
        n  n    n    n   n  n    n  n

)
public int  sumOfNodes(Node root){      
                                        while going top-down                           
if(root == null){return 0; }            return(start moving up) and pass value to node above  
pathSize = pathSize +root.val;           Do something with nodes
                                                               
                                     
                                       while going left-right/right-left(while going down itself)   
int left = sumOfNodes(root.left)       left,right holds val coming from leftSubtree, rightSubtree  based on what we return while going top-bottom,bottom-top                                                       
int right = sumOfNodes(root.right);                                                                                     
          |
         Fn is broken then
         Line after the fn call is 
         while coming bottom-top
         EG: DFSPrePostInOrderLowestCommonAncestorII(BST)
             DFSPrePostInOrderInsertII(BST)

                
                                      
                                        while going bottom-up 
 pathSize = pathSize +root.val;         Do something with nodes(L,R VALUES ARE AVAILAVLE) 
 return left + right + root.val;        return(store in temp and later return temp EG AnyToAny LeafToLeaf) and  pass value to node above(L,R VALUES ARE AVAILAVLE) 
  
           |
        Arithmetic exp cannot be broken                     
        Boolean exp can be broken                             
        l||r||node seperate node by returning true     
        l && r && node seperate node by returning false 
        EG:DFSPrePostInOrder ke II   examples  
                                      
                    

*/                                       
//                                                            |                         
//                                                            | 
//                                                            |                                       

                                                        //CHANGES TO ARG
                                                        /*
                                                        //IMMUTABLE                                        
                                                        int pathSum  = 0;                                                       -->Immutable arg that are result  are declared globally and recursive fn works on them;                            
                                                        public void main(){      
                                                            int level = 0;                         
                                                            recursiveFn1(root,level);  

                                                        public void recursiveFn1(Node root, int level){             
                                                            pathSum = pathSUm + root.val;

                                                            recursiveFn1(root.left,level+1)                                       -->Immutable arg that change while going left-right/right-  left are given to recursive fn       
                                                            recursiveFn1(root.right,level+1)     

                                                        //MUTABLE
                                                        public void main(){                     
                                                        List<List<Ineger>> nodes = new ArrayList<>();                            -->Mutale arg that are result  are declared and given to recursive fn arg and recursive fn works on them                             
                                                        List<Ineger> path = new ArrayList<>();
                                                        recursiveFn1(root,nodes,path);  


                                                        public void RecursiveFn (Node root, List<List<Integer>> nodes ,List<Integer> path , int val){
                                                            if(root == null)
                                                            return;

                                                            path.add(root.val);                     
                                                                                                    
                                                            if(root.val == val){                          
                                                            nodes.add(path);                                                       
                                                            return;}                                                                                          
                                                                        

                                                            RecursiveFn(root.left ,nodes,new ArrayList<Integer>(path),val);        -->Mmutable arg that change while going left-right/right-left are given to recursive fns(nodes) 
                                                            RecursiveFn(root.right,nodes,new ArrayList<Integer>(path),val);         AND MAKE "NEW OBJ" AND "RETURN WHEN YOU ADD PATH TO NODES" TO PREVENT CHANGING MADE TO OBJ  OBJ WHILE COMING UP 
                                                                }                                             
                                                                                                                                        3           Consider ypu want to find ancestor of 5 to upar ke code ke hisab se(new ArratList<> X)
                                                                                                                                        / \         niche ate vakt [3]
                                                                                                                                        5  1        niche ate vakt [3,5]     [[3,5]]
                                                                                                                                        /\  /\      niche ate vakt [3,5,6]           --> agar new na hota to yaha node ban jata [[3,5,6]
                                                                                                                                        6 2 0 8     upar ate vakt  [3,5]             -->agar 5 pe return karke kalti na marte to node ban jata [[3,5]] 
                                                                                                                                                    niche ate vakt [3,5,2]           -->agar new na hota to node ban jata [[3,5,2]]
                                                                                                                                                        upar ate vakt  []
                                                        
                                                        //LEVEL          
                                                        public void methodName(Node root , int level){
                                                        methodName(root.left ,level + 1);               -- while going left-right(top-bottom)                                      EWUIVALENT TO   
                                                        methodName(root.left , level+1);                   while going top bottom you increase level from previous node           -------------> while coming top-bottom level + 1
                                                                                                        while going bottom-top you already have have the level for that node                   while coming  bottom-top level-1
                                                        
                                                                                                            7   0
                                                                                                            /  \
                                                                                                            /    \  
                                                                                                        1 8      9  1
                                                                                                        / \    / \
                                                                                                        /   \  /   \
                                                                                                    10   11  12   13
                                                                                                    2     2  2     2
                                                                                                    EG:
                                                                                                    DFSLevelOrder, BFSLevelOrder and its examples
                                                                                                    DFSPPrePostOrderIsCompleteI, DFSPPrePostOrderIsCompleteII -->use long as node vals may be max and min of integers
                                                                                                    DFSPrePostOrderWords(Trie)  --> BOTH EQUIVALENT PARTS DOE IN HYPOTHESISI , HYPOTHESISII

                                                        //PREVIOUS NODE 
                                                        PREVIOUS NODE FOR PREORDER                 
                                                        public void methodName(Node root , Node/int previousNode){

                                                            if(previousNode!=null){//use prevNode here}
                                                            if(previous=null){//check if this case is req as previous case might omt certain cases }  
                                                            
                                                            methodName(root.left , root/root.val);        -- While going left - right(ie going top-down)
                                                            methodName(root.rigt, root/root.val)            store previousNode(we store Node itself so BT can have duplicates)/previosNode value(we store Node value itself so BT must have unique values)              
                                                                                                            EG
                                                                                                                7   0
                                                                                                                /  \
                                                                                                                /    \  
                                                                                                            7 8      9  7  
                                                                                                            / \    / \
                                                                                                            /   \  /   \
                                                                                                        10   11  12   13
                                                                                                        8     8   9    9
                                                                                                        EG: 
                                                                                                        DFSPrPosteOrderOrderAreSiblingsI,DFSPrPosteOrderOrderAreSiblingsII -- using root.left , root.right dont use previous node for parenr
                                                                                                        DFSLevelOrderAreCousins
                                                                                                        DFSAnyToAnyPathsUnivalKaMaxNoOfNodes
                                                        PREVIOUS NODE FOR POSTORDER                                              
                                                        private Node/int previousNode;
                                                        public void methodName(Node root){

                                                            methodName(root.left , root/root.val);      
                                                            methodName(root.rigt, root/root.val)               

                                                            if(previousNode!=null){//use prevNode here}
                                                            if(previous=null){//check if this case is req as previous case might omt certain cases }      --While going  bottom-top
                                                            previousNode =root/root.val                                                                   store previousNode(we store Node itself so BT can have duplicates)/previosNode value(we store Node value itself so BT must have unique values)
                                                                                                                                    EG
                                                                                                                                    7  9
                                                                                                                                    /  \
                                                                                                                                    /    \  
                                                                                                                                11 8      9  13
                                                                                                                                / \    / \
                                                                                                                                /   \  /   \
                                                                                                                            10     11  12   13
                                                                                                                            null    10   8   12
                                                                                                                            EG: 
                                                                                                                            DFSPrePostInOrderFalattenToLLI(prev node not held); DFSPrePostInOrderFalattenToLLIM

                                                                            
                                                        PREVIOUS NODE FOR INORDER
                                                        private Node/int previousNode
                                                        public void methodName(Node root){
                                                            methodName(root.left , root/root.val);     
                                                            
                                                            if(previousNode!=null){//use prevNode here}
                                                            if(previous=null){//check if this case is req as previous case might omt certain cases }                                       
                                                            previousNode =root/root.val                                      --While going  bottom-top(top middle wala ie inorder)
                                                                                                                                store previousNode(we store Node itself so BT can have duplicates)/previosNode value(we store Node value itself so BT must have unique values)
                                                                                                                                    EG
                                                                                                                                    8  9
                                                                                                                                    / \
                                                                                                                                    /   \  
                                                                                                                                10 8      9  12
                                                                                                                                / \    / \
                                                                                                                                /   \  /   \
                                                                                                                            10     11  12   13
                                                                                                                            null    8 null  9
                                                                                                                            EG: 
                                                                                                                            DFSPrePosttInOrderISBSTI,DFSPrePosttInOrderISBSTI
                                                                                                                            DFSPrePosttInOrderModesI(BST),DFSPrePosttInOrderModesII(BST)

                                                            

                                                                methodName(root.rigt, root/root.val)           
                                                            

                                                                            
                                                        */                                               

                                                        //NULL CHECK
                                                        /* 
                                                        root ==null                                         --root.left , root.right cant eb null inside recursive call ;root, root.val cant be null anywhere in fn 

                                                        if(root.left != null && root.right != null){}       --root.left , root.right  cant be null inside fn 
                                                                                                            EG 
                                                                                                            DFSPrePostInOrderSiblingsI,DFSPrePostInOrderSiblingsII
                                                                                                            DFSPrePostInOrderInvertI,DFSPrePostInOrderInvertII              (DONT DO NULL CHECK BECAUSE YOU NEED ROOT.LEFT AND ROOT.RIGHT  NULL VALUES FOR SWAPPING  EG:CONSIDER [1,2,null])
                                                                                                            DFSPrePostInOrderDoubleI,DFSPrePostInOrderDobleII               (DONT DO NULL CHECK BECAUSE YOU NEED ROOT.LEFT AND ROOT.RIGHT  NULL VALUES FOR ASSIGNING EG:CONSIDER [1,2,null])
                                                                                                            DFSPrePostInOrderFalattenToLLI,DFSPrePostInOrderFalattenToLLII  (DONT DO NULL CHECK BECAUSE ROOT.LEFT AND ROOT.RIGHT ARE REQUIRED AS WE  ASSIGNING THEM VAUES EVEN IF THEY ARE NULL EG: CONSIDER[1,2,null,5,6] )
                                                                                                            DFSPrePostInOrderConectI,DFSPrePostInOrderConectII              (HANDLE EACH CASE SEPERATELY  DUE TO CONSTRAINTS OF QUESTION )

                                                        if(root.left == null || root.right == null){}      --root.left , root.right  being   null yeild different results 
                                                        OR                                                     EG DFSLeafToLeaf,DFSLeafToLeafkaSabSums
                                                        if(root.left == null){}
                                                        if(root.righ == null)                                                       

                                                        if(n1 == null && n2 == null){}                     -- When you are checking 2 node simultaneously(NULL WHILE COMING DOWN ONLY NOT WHILE GOING UP AS YOU USE N1,N2 IN RECURSIVE CALL)
                                                        if(n1 == null || n2 == null){}                        n1,n2 both being null yeild a different result ; either being null yeild a different result 
                                                        OR                                                     EG :DFSPrePostInOrderSymmetricI,DFSPrePostInOrderSymmetricII 
                                                        if(root.left == null){}                                    DFSPrePostInOrderAreEqualTreesI,DFSTPrePostOrderAreEqualTreesII
                                                        if(root.right == null)                                     DFSPrePostInOrderMergeTreesI,DFSPrePostInOrderMergeTreesII





                                                                                                        

                                                        */




 /* #endregion */



public class BinaryTree {

    /*

    BINARY SEARCH TREE

              7       -->each node has max 2 children
             /  \        
            4    9
           / \    / \
           1  6   8  10
         /  \ /\  /\  / \
        n  n  n n n n  n n
      */




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
        private Node(){//this.val=0;this.left=null;this.right=null(constructor gives default values)
        }
        private Node(int val) { this.val = val;//this.left=null;this.right=null(constructor gives default values) 
        }
        private Node(int val, Node left, Node right) {this.val = val;this.left = left;this.right = right;}




    }
    //CONSTRUCTOR                //INITIALISING ROOT
    private Node root;           //BinTree Construction:-->Compiler will call className obj = new ClassName() ; obj.methodName() so you must initialise root with default values in constructor of class 
    public BinaryTree(){        // BinTree Methods     -->Compiler will call className obj = new ClassName() ; obj.methodName(new Node()) so root initialised by compiler
        root = null;
    }                           //RETURNING NODES
                                
                                 //RETURN NODES
                                 //return new Node()               -- returns Node with value=0 ,left =null,right=null
                                 //return new Node(val)            -- returns Node with value=value ,left =null,right=null
                                 //return new Node(val,left,right) -- returns Node with value=value ,left =left,right=right
                                 //return root                     -- -- return root along with its subtree vals
                                 //EG -- DFSPrePostInOrderContainsI,DFSPrePostInOrderContainsII
                          
   


    //TRAVERSAL
    public void DFSPreOrder       (Node root , List<Integer> nodes){
         /*
      PREORDER INORDER POSTORDER TRAVERSAL
           7        -->PREORDER:  
          /  \         Left-right,Top-bottom(ROOT,LEFT,RIGHT)-->[7,4,1,6,9,8,10]        
         4    9        Right-left,Top-Bottom(ROOT,RIGHT,LEFT)-->[7,9,10,8,4,6,1]
        / \    / \             
        1  6   8  10   POSTORDER
      /  \ /\  /\ / \  Left-Righ;Bottom-topt(LEFT,RIGHT,ROOT) -->[1,6,4,8,10,9,7] 
      n  n  n n n n  n Right-Left;Bottom-top (RIGHT,LEFT,ROOT)-->[10,8,9,6,1,4,7]

                        INORDER :
                        Left-Righ;Bottom-top(top middle me)(LEFT,ROOT,RIGHT) -->[1,4,6,7,8,9,10]
                        Right-Left;Bottom-top(top middle me);(RIGHT,ROOT,LEFT) -->[10,9,8,7,6,4,1]
        */

          //RECURSIVE IP OP TREE
          /*  
            
          public void DFSPreOrder       (Node root , List<Integer> nodes)
                //LEFT-RIGHT;TOP-BOTTOM        
                                                --while going top-bottom  
                if (root == null){return;}      return at null and  start moving up                  
                nodes.add(root.val)              add nodes to list   
                                                            
                DFSPreOrder(root.left)          --while going left-right
                DFSPreOrder(root.right)


                // RIGHT-LEFT;TOP BOTTOM 
                                                --while going top-bottom  
                if (root == null){return;}      return at null and  start moving up                  
                nodes.add(root.val)             add nodes to list   
                                                            
                DFSPreOrder(root.right)          --while going right-left
                DFSPreOrder(root.left)
            }

           //OVERRIDE
            public List<Integer> DFSPreOrder(Node root){
              List<Integer> list = new ArrayList<Integer> ;
              DFSInOrder(Node root ,List<Integer> nodes)
               return list;
            }

          Time :O(n) if it is balanced tree  as we traverse all nodes in tree
               :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
          Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
           */

           //ITERATIVE
            /*        
            PREORDER                    //STACK                                           
            root--   7                              
                    /  \                           1                
                    4    9                    4    6     6                8                                       -->while stack is not empty  
                / \    / \             7    9    9     9       9        10          10                             stack ka top nikal  
                1  6   8  10           []   [7]  [7,4] [7,4,1] [7,4,1,6][7,1,4,6,9] [7,4,1,6,8] [7,4,1,6,8,10]      val nodes me; r stack me ;l stack me  //NULL CHECK: root cant be null     
                                                                                                                    Stack<Node> stack = new Stack<>();                                                                          
                                                                                                                    stack.push(root); 
                                                                                                                    while(!stack.empty()){
                                                                                                                        root = stack.pop();
                                                                                                                        if(root != null){
                                                                                                                            nodes.add(root.val);    
                                                                                                                            stack.push(root.right); 
                                                                                                                            stack.push(root.left);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return nodes;
                                                                                                                    //EDGE CASE:root is null return nodes
                                    OR
                                        //QUEUE(queue using LL cause queue using AD doesnt take null)
                                                                                                                -->while queue is not empty
                                                                                                                    queue ka bottom nikal 
                                                                                                                    val nodes me; l queue me ;r queue me  //NULL CHECK: root cant be null 
                                                                                                                    
                                                                                                                    DOESNT WORK
                                                                                                                    EG:TRY [1,4,3,2]
                

            public List<Integer>       DFSPreOrder_iterative(Node root,List<Integer> nodes){
                //EDGE CASE
                if(root == null) 
                    return nodes;

                Stack<Node> stack = new Stack<>();
                stack.push(root); 
                while(!stack.empty()){
                    root = stack.pop();
                    if(root != null){
                        nodes.add(root.val);
                        stack.push(root.right);
                        stack.push(root.left);
                    }
                
                }
                return nodes;


            }

            
            TIME :O(n) as we traverse all nodes of tree
            SPACE:O(n) as we use STACK


        

            */



  

  
  
        

    }
    public void DFSPostOrder      (Node root , List<Integer> nodes){
        /*
      PREORDER INORDER POSTORDER TRAVERSAL
           7        -->PREORDER:  
          /  \         Left-right,Top-bottom(ROOT,LEFT,RIGHT)-->[7,4,1,6,9,8,10]        
         4    9        Right-left,Top-Bottom(ROOT,RIGHT,LEFT)-->[7,9,10,8,4,6,1]
        / \    / \             
        1  6   8  10   POSTORDER
      /  \ /\  /\ / \  Left-Righ;Bottom-topt(LEFT,RIGHT,ROOT) -->[1,6,4,8,10,9,7] 
      n  n  n n n n  n Right-Left;Bottom-top (RIGHT,LEFT,ROOT)-->[10,8,9,6,1,4,7]

                        INORDER :
                        Left-Righ;Bottom-top(top middle me)(LEFT,ROOT,RIGHT) -->[1,4,6,7,8,9,10]
                        Right-Left;Bottom-top(top middle me);(RIGHT,ROOT,LEFT) -->[10,9,8,7,6,4,1]
        */
  

        //RECURSIVE IP OP TREE
        /*  

   
        public void DFSPostOrder      (Node root , List<Integer> nodes)    
             //LEFT-RIGHT;BOTTOM-TOP            
                                            --while going top-bottom  
            if (root == null){return;}       return at null and  start moving up                  
                                                            
            DFSPostOrder(root.left)         --while going left-right
            DFSPostOrder(root.right)

                                        --while going bottom-top
            nodes.add(root.val)              add root value to nodes                               

            //RIGHT-LEFT;BOTTOM-TOP 
                                        --while going top-bottom  
            if (root == null){return;}      return at null and  start moving up                  
                                                        
            DFSPostOrder(root.right)      --while going right-left
            DFSPostOrder(root.left)

                                        --while going bottom-top
            nodes.add(root.val)              add root value to nodes   
        }

        //OVERRIDE
        public List<Integer> DFSPostOrder(Node root){
            List<Integer> list = new ArrayList<Integer> ;
            DFSPostOrder(Node root ,List<Integer> nodes)
            return list;
        }

    
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space


        */


        //ITERATIVE
        /*     
                              //STACK                                           

        root--   7                              
                /  \                      10                
                4    9                9    8      8                 6                                                                                                                                    
              / \    / \         7    4    4      4       4         1             1                        --> while stack is not empty                        
              1  6   8  10  ]   [7]  [9,7]  [10,9,7] [8,10,9,7][4,8,10,9,7] [6,4,8,10,9,7] [1,6,4,8,10,9,7]    stack ka top nikal 
                                                                                                               val nodes ke 0 me , l stack me , r stack me  //NULL CHECK: root cant be null   
                                                                                                                Stack<Node> stack = new Stack<>();   
                                                                                                                stack.push(root); 
                                                                                                                while(!stack.empty()){
                                                                                                                    root= stack.pop();
                                                                                                                    if(root != null){
                                                                                                                        nodes.add(0,root.val);  
                                                                                                                        stack.push(root.left);   
                                                                                                                        stack.push(root.right);

                                                                                                                    }
                                                                                                        
                                                                                                                }
                                                                                                                return nodes;
                                                                                                                //EDGE CASE:root is null return nodes
                                OR
                                //QUEUE(queue using LL cause queue using AD doesnt take null)
                                                                                                             -->while queue is not empty
                                                                                                                queue ka bottom nikal 
                                                                                                                val nodeske 0  me; r queue me ;l queue me //NULL CHECK: root cant be null  
                                                                                                                  
                                                                                                                DOESNT WORK
                                                                                                                EG:TRY [1,4,3,2]
                                                                                                                       
        public List<Integer>       DFSPostOrder_iterative(Node root, List<Integer> nodes){
            //EDGE CASE
            if(root == null) 
                return nodes;

            Stack<Node> stack = new Stack<>();   
            stack.push(root); 
            while(!stack.empty()){
                root = stack.pop();
                if(root != null){
                    nodes.add(0,root.val);  
                    stack.push(root.left);
                    stack.push(root.right);

                }
    
            }
            return nodes;
        }
   
        TIME :O(n) as we traverse all nodes of tree
        SPACE:O(n) as we use STACK
        
        


        
        */


        







    }
    public void DFSInOrder        (Node root , List<Integer> nodes){
        /*
      PREORDER INORDER POSTORDER TRAVERSAL
           7        -->PREORDER:  
          /  \         Left-right,Top-bottom(ROOT,LEFT,RIGHT)-->[7,4,1,6,9,8,10]        
         4    9        Right-left,Top-Bottom(ROOT,RIGHT,LEFT)-->[7,9,10,8,4,6,1]
        / \    / \             
        1  6   8  10   POSTORDER
      /  \ /\  /\ / \  Left-Righ;Bottom-topt(LEFT,RIGHT,ROOT) -->[1,6,4,8,10,9,7] 
      n  n  n n n n  n Right-Left;Bottom-top (RIGHT,LEFT,ROOT)-->[10,8,9,6,1,4,7]

                        INORDER :
                        Left-Righ;Bottom-top(top middle me)(LEFT,ROOT,RIGHT) -->[1,4,6,7,8,9,10]
                        Right-Left;Bottom-top(top middle me);(RIGHT,ROOT,LEFT) -->[10,9,8,7,6,4,1]
        */
  

        //RECURSIVE IP OP TREE
        /*  
        
        public void DFSInOrder        (Node root , List<Integer> nodes)
            // LEFT-RIGHT ;BOTTOM-TOP(top middle wala)           
                                            --while going top-bottom  
            if (root == null){return;}       return at null and  start moving up                  
                                                            
            DFSInOrder(root.left)         --while going left-right

                                        --while going bottom-top(top middle wala )
            nodes.add(root.val)              add root value to nodes

            DFSInOrder(root.right)



            //RIGHT-LEFT ;BOTTOM-TOP(top middle wala)            
                                            --while going top-bottom  
            if (root == null){return;}       return at null and  start moving up                  
                                                            
            DFSInOrder(root.right)         --while going right-left

                                        --while going bottom-top(top middle wala )
            nodes.add(root.val)              add root value to nodes

            DFSInOrder(root.left)
            }

        //OVERRIDE
        public List<Integer> DFSInOrder(Node root){
            List<Integer> list = new ArrayList<Integer> ;
            DFSInOrder(Node root ,List<Integer> nodes)
            return list;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
                    





        */

        //ITERATIVE
        /* 
                                  //STACK                                           

        root--   7                              
                /  \           1                        
                4    9         4   4    6            8                                                                                                                                             
              / \    / \       7   7    7    7       9         9         10                                  -->while stack is not empty  stack ka top nikal                        
              1  6   8  10    []  [1] [1,4] [1,4,6] [1,4,6,7][1,4,6,7,8] [1,4,6,7,8,9] [1,4,6,7,8,9,10]         go left till end and add vals in stack // root cant be null FOR ALL OPERATIONS SO ADD IN MAIN WHILE LOOP
                                                                                                                stack ka top val nikal 
                                                                                                                val nodes me , go right 
                                                                                                                Stack<Node> stack = new Stack<>();
                                                                                                                stack.push(root); 
                                                                                                                while(!stack.empty()|| root != null){  
                                                                                                                    while(root != null){  
                                                                                                                        stack.push(root);
                                                                                                                        root = root.left;
                                                                                                                    }
                                                                                                                    root = stack.pop();
                                                                                                                    nodes.add(root.val);   
                                                                                                                    root = root.right;
                                                                                                                }
                                                                                                                return nodes;
                                                                                                                //EDGE CASE:root is null return nodes


    public List<Integer>  DFSInOrder_iterative(Node root,List<Integer> nodes){
        //PREORDER
        //EDGE CASE
        if(root == null) 
            return nodes;

        Stack<Node> stack = new Stack<>();
        stack.push(root); 
        while(root != null || !stack.empty()){  
            while(root != null){  
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            nodes.add(root.val);    
            root = root.right;


        }
        return nodes;
    }
                                                            
                                                        
    */



        

    }
    public void DFSLevelOrder     (Node root,int level,List<List<Integer>> nodes){
        /*
                 7        Traverse top to bottom , left to right   (DFS)
                /\         and return path of nodes  at each level (LevelOrder)
               / \         LEFT-RIGHT
              /   \        left-right;top-bottom -->[ [7] , [4,9], [1,6,8,10] ]
             4    9        left-right;bottom-top   -->[[1,6,8,10],[4,9],[7]] 
             / \    / \    RIGHT-LEFT
            1  6   8  10   right-left;top-bottom -->[ [7] , [9,4], [10,8,6,1] ] 
                           right-left;bottom-top -->[[[10,8,6,1],[9,4],[7] ]
                           LEFT-RIGHT ALTERNATE
                           left-ight  alternate(zigzag);top-bottom -->[[7] , [9,4], [1,6,8,10] 
                           left-right alternate(zigzag);bottom-top -->[[1,6,8,10],[9,4],[7]]
                           LEFT VIEW
                           left-view;top-bottom    (nodes you will see considering you are standing on left of tree )    -->[7,4,1]
                           left-view;bottom-top    (nodes you will see considering you are standing on left of tree )    -->[1,4,7]
                           RIGHT-VIEW
                           right-view ;top-bottom  (nodes you will see considering you are standing on right of tree )  -->[7,9,10]
                           right-viewbottom-top   (nodes you will see considering you are standing on right of tree )  -->[10,9,7]
                           LEFT-BOUNDARY
                           leftboundary;top-bottom  (nodes you will see while going from root to leftmost leaf node preferring travelling  the left subtree over the right subtree; if root doesnt have left subtree then root is itself left boundary) -- [7,4,1]
                           leftboundary;bottom-top (nodes you will see while going from root to leftmost leaf node preferring travelling  the left subtree over the right subtree; if root doesnt have left subtree then root is itself left boundary) -- [1,4,7]
                           RIGHT-BOUNDARY
                           rightboundary;top-bottom(nodes you will see while going from root to rightmost leaf node preferring travelling  the right subtree over the right subtree; if root doesnt have left subtree then root is itself left boundary) -- [7,9,10]
                           rightboundary;top-bottom (nodes you will see while going from root to rightmost leaf node preferring travelling  the right subtree over the right subtree; if root doesnt have left subtree then root is itself left boundary) -- [10,9,7]
                           LEAF NODE
                           leafnode;top to bottom      (nodes at leaf) -[1,6,8,10]
                           ANTICLOCKWISE
                           anticlockwise;top to bottom(nodes you see while travellting leftboundary,leafNodes ,rightboundary  ) -[7,4,1,6,8,10,9,7]
                           CLOCKWISE
                           clockwise;top to bottom (nodes you see while travellting leftboundary,leafNodes ,rightboundary  ) -[7,9,10,8,6,1,4,7]
 
         */


      
        //RECURSIVE IP OP TREE
        /*
        public void DFSLevelOrder     (Node root,int level,List<List<Integer>> nodes)                                                 
            //LEFT-RIGHT;TOP-BOTTOM                           -- while going top-bottom    
            if (root == null){return;}                          return at null and  start moving up                                                                                                                     
            if(nodes.size()==level)                             [[l-r] , [l-r]] -- when we reach a level create a arraylist at last index(top-bottom) 
                nodes.add(new ArrayList<Integer>());             lo       l1       get the arrayList at that level and add nodes at lastindex(left right)
            nodes.get(level).add(root.val);                                         CREATE NEW OBJECT DONE WHEN WE REACH LEVEL NOT WHILE GOING LEFT RIGHT

            DFSLevelOrder(root.left,level+1,nodes);            --while going  left-right                                             equivalent to                                     
            DFSLevelOrder(root.right ,level+1,nodes);           while going top bottom you increase level from previous node      -------------> while coming top-bottom level + 1
                                                                while going bottom-top you already have have the level for that node                   while coming  bottom-top level-1                              
                                                        
                                                                    7   0
                                                                    /  \
                                                                    /    \  
                                                                1 8      9  1
                                        

                                                                
            //LEFT-RIGHT ;BOTTOM-TOP                           -- while going top-bottom   
            if (root == null){return;}                         return at null and  start moving up                                   
            if(nodes.size()==level)                             [[l-r] , [l-r]] -- when we reach a level create a arraylist at first index(bottom-top)
                nodes.add(0,new ArrayList<Integer>());            l1     lo        get the arrayList at that level and add nodes at lastindex(left-right)
            nodes.get(nodes.size() -1 - level).add(root.val);
            DFSLevelOrder(root.left,level+1,nodes);            --while going  left-right 
            DFSLevelOrder(root.right ,level+1,nodes);            ''' same as above

                                                                    
            //RIGHT-LEFT;TOP-BOTTOM                            -- while going top-bottom  
            if (root == null){return;}                          return at null and  start moving up   
            if(nodes.size()==level)                             [[r-l] , [r-l]] -- when we reach a level create a arraylist at last index(top-bottom) 
                nodes.add(new ArrayList<Integer>());             l0       l1       get the arrayList at that level and add nodes at firstindex(right-left)
            nodes.get(level).add(root.val);
            DFSLevelOrder(root.right,level+1,nodes);            --while going  right-left 
            DFSLevelOrder(root.left ,level+1,nodes);              ''' same as above1 

                                                                    
            //RIGHT-LEFT;BOTTOM-TOP                             --while going top-bottom 
            if (root == null){return;}                          return at null and  start moving up                             
            if(nodes.size()==level)                             [[r-l] , [r-l]] -- when we reach a level create a arraylist at first index(bottom-top) 
                nodes.add(0,new ArrayList<Integer>());            l1      l0          get the arrayList at that level and add nodes at lastindex(right-left)
            nodes.get(nodes.size() -1- level).add(root.val);
            DFSLevelOrder(root.right,level+1,nodes);            --while going  right-left 
            DFSLevelOrder(root.left ,level+1,nodes);               ''' same as above

            (ZIG - ZAG)                                                         
            //LEFT-RIGHT ALTERNATE  ;TOP-BOTTOM ;                --while going top-bottom 
            if (root == null){return;}                          return at null and  start moving up                         
            if(nodes.size()==level)                             [[l-r] , [r-l]] -- when we reach a level create a arraylist at last index(top-bottom) 
                nodes.add(new ArrayList<Integer>());             l0        l1      get the arrayList at that level and if even level add nodes at lastindex(left-right) and if odd level add nodes atr firstindex(right-left)
            if(level%2 == 0)
                nodes.get(level).add(root.val);
            else
                nodes.get(level).add(0,root.val);
            DFSLevelOrder(root.left,level+1,nodes);            --while going  left-right 
            DFSLevelOrder(root.right ,level+1,nodes);              ''' same as above

            (ZIG - ZAG)                                               
            //LEFT-RIGHT ALTERNATE;BOTTOM-TOP                  --while going top-bottom 
            if (root == null){return;}                            return at null and  start moving up                                
            if(nodes.size()==level)                               [[l-r] , [r-l]] -- when we reach a level create a arraylist at first index(bottom-top) 
                nodes.add(0,new ArrayList<Integer>());              l1      l0      get the arrayList at that level and if even level add nodes at lastindex(left-right) and if odd level add nodes atr firstindex(right-left)
            if(level%2 == 0)                                     
                nodes.get(nodes.size() -1- level).add(root.val);
            else
                nodes.get(nodes.size() -1- level).add(0,root.val);
            DFSLevelOrder(root.left,level+1,nodes);             --while going  left-right 
            DFSLevelOrder(root.right ,level+1,nodes);             ''' same as above
        
                                                                    
            //LEFT VIEW;TOP-BOTTOM(ZIG-ZAG)                       --while going top-bottom 
            if (root == null){return;}                             return at null and  start moving up 
            if(nodes.size()==level)                                 [7   4  1] -- when we reach a level add  root.val to nodes last index(top-bottom)
                nodes.add(root.val); //list<Integer>                l0 l1 l2                    
            DFSLevelOrder(root.left,level+1,nodes);               --while going  left-right 
            DFSLevelOrder(root.right ,level+1,nodes);                 ''' same as above


                                                                    
            //LEFT VIEW ;BOTTOM-TOP                                --while going top-bottom 
            if (root == null){return;}                            return at null and  start moving up
            if(nodes.size()==level)                                [1   4  7] -- when we reach a level add  root.val to nodes first index(bottom-top)
                nodes.add(0,root.val); //list<Integer>              l0 l1 l2
            DFSLevelOrder(root.left,level+1,nodes);             --while going  left-right 
            DFSLevelOrder(root.right ,level+1,nodes);               ''' same as above


                                                                        
            //RIGHT VIEW ;TOP-BOTTOM                              --while going top-bottom  
            if (root == null){return;}                            return at null and  start moving up
            if(nodes.size()==level)                                [7   9  10] -- when we reach a level add  root.val to nodes last index(top-bottom)
                nodes.add(root.val;  //list<Integer>                l0 l1 l2                          
            DFSLevelOrder(root.right,level+1,nodes);            --while going  right-left 
            DFSLevelOrder(root.left ,level+1,nodes);            ''' same as above
                                                                        
            //RIGHT VIEW;BOTTOM-TOP                              -- while going top-bottom 
            if (root == null){return;}                            return at null and  start moving up           
            if(nodes.size()==level)                               [10,,9,7] -- when we reach a level add  root.val to nodes first index(bottom-top)
                nodes.add(0,root.val);  //list<Integer>            l0 l1 l2                            
            DFSLevelOrder(root.right,level+1,nodes);            --while going  right-left 
            DFSLevelOrder(root.left ,level+1,nodes);              ''' same as above


            //LEFT BOUNDARY;TOP-BOTTOM                            --while going top-bottom 
            if (root == null){return;}                            return at null and  start moving up
            nodes.add(root.val);                                  add root.val to  to nodes last index(top-bottom)
            
            if (root.left != null)                              --while going  left-right   
                DFSLevelOrder(root.left, nodes);                    go to left subtree if not null or right if it is null as left subtree is preferable
            else
                DFSLevelOrder(root.right, nodes);

            //LEFT BOUNDARY;BOTTOM-TOP                             --while going top-bottom (choose any 1 bw top-bottom;bottom-top)
            if (root == null){return;}                             return at null and  start moving up                                                                  
            nodes.add(0,root.val);                                 add root.val to  to nodes first index(bottom-top)
                  |__CHOOSE ANY 1
 
            if (root.left != null)                               --while going  left-right    
                DFSLevelOrder(root.left, nodes);                     go to left subtree if not null or right if it is null as left subtree is preferable   
            else
                DFSLevelOrder(root.right, nodes);
                                                                    --while going bottom-top(choose any 1 bw top-bottom;bottom-top)
            nodes.add(root.val);                                    add root.val to  to nodes last index(bottom-top)
                  |__CHOOSE ANY 1

            //RIGHT BOUNDARY ;TOP-BOTTOM                           -- while going top-bottom 
            if (root == null){return;}                             return at null and  start moving up  
            nodes.add(root.val);                                    add root.val to  to nodes last index(top-bottom)
            
            if (root.right != null)                               --while going  left-right     
                DFSLevelOrder(root.right, nodes);                      go to right subtree if not null or left if  is null as right subtree is preferable
            else
                DFSLevelOrder(root.left, nodes);

            //RIGHT BOUNDARY;BOTTOM-TOP                             --while going top-bottom (choose any 1 bw top-bottom;bottom-top)
            if (root == null){return;}                               return at null and  start moving up  
            nodes.add(0,root.val);                                   add root.val to  to nodes first index(bottom-top) 
                   |__CHOOSE ANY 1

            if (root.right != null)                               --while going  right-left      
                DFSLevelOrder(root.right, nodes);                     go to right subtree if not null or left if it is null as right subtree is preferable
            else
                DFSLevelOrder(root.left, nodes);
                                                                    -- while going bottom-top (choose any 1 bw top-bottom;bottom-top) 
            nodes.add(root.val);                                      add root.val to  to nodes last index(bottom-top)-->-->GOING UP (choose any one) 
                  |__CHOOSE ANY 1

            //LEAF;TOP-BOTTOM                                        -- while going top-bottom
            if (root == null){return;}                                return at null and  start moving up  
            if(root.left==null && root.right == null)                 [10,,9,7] -- when we reach a leaves add  root.val to nodes last index(top-bottom)
                nodes.add(root.val);              

            DFSLevelOrder(root.left,nodes);                        --while going  right-left
            DFSLevelOrder(root.right ,nodes);                          


            //ANTI-CLOCKWISE;TOP-BOTTOM(SOLN --https://massivealgorithms.blogspot.com/2014/07/print-edge-nodes-boundary-of-binary.html)
            public List<Integer> DFSLevelOrder(Node root,List<>Integer> nodes ){
                    if (root.left != null || root.right != null)
                        nodes.add(root.val);
                                                        
                List<>Integer> nodes = new ArrayList<>(); //Root , leftmost leafnode , rightmost leaf node is repeated in nodes List to avoid that do the following steps
                LeftBoundaryTopBottom(root.left,nodes)  -->do not add leftmost leafNode; for that  add the following cond in method if((root.left == null && root.right == null) return ;  do not  add rootnode to nodes for that  starting from left
                LeafNodesTopBottom(root,nodes);            
                RightBoundaryBottomTop(root,nodes);    -->do not add righmost leafNode; fpr that  add the following cond in method if((root.left == null && root.right == null) return;
                                                            add whild going up nodes.add(root.val) do not add while down up nodes.add(0,root.val) 
                                                            because for a individual method it is fine but these methods are adding one after other to list so (0,root.val) will start adding the val a start 
                                                            
            }


            //CLOCKWISE;TOP-BOTTOM
            public List<Integer> DFSLevelOrder(Node root,List<>Integer> nodes ){
                if (root.left != null || root.right != null)
                    nodes.add(root.val);
                                                        
                List<>Integer> nodes = new ArrayList<>(); //Root , leftmost leafnode , rightmost leaf node is repeated in nodes List to avoid that do the following steps
                RightBoundaryTopBottom(root.right,nodes)  -->do not add rightmost leafNode to nodes; for that  add the following cond in method if((root.left == null && root.right == null) return ;  
                                                            do not  add rootnode to nodes for that  starting from right
                leafNodesTopBottom(root,nodes);          

                LefttBoundaryBottomTop(root,nodes);     -->do not add leftmost leafNode to nodes; for that  add the following cond in method if((root.left == null && root.right == null) return;
                                                            add whild going up nodes.add(root.val) do not add while down up nodes.add(0,root.val) 
                                                            because for a individual method it is fine but these methods are adding one after other to list so (0,root.val) will start adding the val a start 
            }




        NOTE REGARDING BOTTOM-TOP(We require to add while going top-bottom):
        if(nodes.size()==level) -- If this condition is present  
                                    We add at 0th index while going down 
                                    We cannot  add while going up as we are dependant on level so bottommost node must be consodered level 0 but while coming down we increent level
                                    
        if(nodes.size()==level) -- If this condition is absetnt   
                                    We can add at 0th index while going down 
                                    We can add while going up
                                        |
                                    choose any one    
        Eg1
        if(nodes.size()==level)                             -- while going top-down(can do)
            nodes.add(0,new ArrayList<Integer>());                                
        nodes.get(nodes.size() -1 - level).add(root.val);

        DFSLevelOrder(root.left,level+1,nodes);
        DFSLevelOrder(root.right ,level+1,nodes);

        if(nodes.size()==level)                           -- while going ottom-topb(cant do this as you have not populated nodes but level has reached  so nodes.size()==0 and level = 3 ) 
            nodes.add(new ArrayList<Integer>());                                
        nodes.get(level).add(root.val);


        EG2
        nodes.add(0,root.val);                            -- while going top-down(make a choice) 
        
        if (root.left != null)                                                
            DFSLevelOrder(root.left, nodes);  
        else
            DFSLevelOrder(root.right, nodes);

        nodes.add(root.val);                              -- while going dobototm-top(make a choice) 


        //OVERRIDE
        public List<List<Integer>>  DFSPostOrder(Node root){
          List<List<Integer>>  nodes = new ArrayList<>() ;
          DFSLevelOrderReverse(Node root ,nodes,0)
          return nodes;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
              :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
                                                                         
      */




    








    


   

  }
    public void BFSLevelOrder     (Node root ,int level, List<Integer> nodes) {
        /*
            7        Traverse at each level                  (BFS)        
            /\       and return path of nodes  at each level (LevelOrder)
            / \      [ [7] , [4,9], [1,6,8,10] ]
            /   \       
            4    9        
            / \    / \    
        1  6   8  10   
        */


        //RECURSIVE IP OP TREE
        /*
        public int BFSLevelOrder     (Node root ,int level, List<Integer> nodes)                                                   -- while going top-down
            if (root == null){return nodes;}                    return nodes at null and  start moving up         
            if (level == 0) {                                    when you reach level add to nodes
                nodes.add(root.val);
                return nodes;}

            return BFSLevelOrder(distance - 1,root.left, list)   -- while going left-right 
            return BFSLevelOrder(distance - 1, root.right, list)    ''' same as level order but reduce kevel
        }

        //OVERRIDE
        public List<List<Integer>> BFSLevelOrder(Node root , List<List<Integer>> nodes){
            List<List<Integer>> nodes = new ArrayListyt<>();
            var height = height(root)
            for (var level = 0; level < height; level++) {
                nodes.add(BFSLevelOrder(root,level,new ArrayList<Integer>))

            return nodes;
        }
        return nodes

        Time :O(n*n) if it is balanced tree  as we traverse all nodes in tree                                ; then iterate from 0 to level(IN OVERRIDE )
            :O(n*n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree;then iterate from 0 to level(OVERRIDE)
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space


        */

         
        //ITERATIVE
        /*                 //QUEUE(queue using LL cause queue using AD doesnt take null)   
          7                          10    
         /  \                        8                
         4    9                 9    6                                                                                                                                                                   
        / \    / \         7    4    1                     --> while queue is not empty 
        1  6   8  10           [7]  [7,4,9] [7,4,8,,6,8,10] queue ka sab elements bottom  se nikal                         
                                                            val list  me , left queue me , right queue me //NULL CHECK: root cant be null  
                                                            while (! queue.isEmpty() ) {
                                                                List<Integer> list = new ArrayList<>();
                                                                int currNumNodes = queue.size();            // queue size keeps on changing in for loop so calculate here 
                                                                for (int i = 0; i < currNumNodes; i++) {
                                                                    root = queue.remove();    
                                                                    if(root != null){
                                                                        list.add(root.val);      "NODES ENCOUNTERED AT EACH LEVEL"
                                                                        queue.add(root.left);
                                                                        queue.add(root.right);
                                                                    }                                                                                                                
                                                                }                                                                                                            
                                                                nodes.add(list);
                                                            }
                                                            return nodes;
                                                            //EDGE CASE:root is null return nodes
                            OR
                            //STACK
                                                            ->while stack is not empty
                                                                stack ka sab elements top  se nikal         
                                                                val nodeske 0  me; l stack me ;r stack me //NULL CHECK: root cant be null  
                                                                        
                                                            DOESNT WORK
                                                            EG:TRY [1,2,3,4,5]





        public List<List<Integer>> BFSLevelOrder_iterative(Node root,List<List<Integer>> nodes){
            if (root == null)
            return nodes;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (! queue.isEmpty() ) {
                List<Integer> list = new ArrayList<>();
                int currNumNodes = queue.size();            // queue size keeps on changing in for loop so calculate here 
                for (int i = 0; i < currNumNodes; i++) {
                    root= queue.remove();    
                    if(root != null){
                        list.add(root.val);
                        queue.add(root.left);
                        queue.add(root.right);
                    }
                    
                } 
                
                nodes.add(list);
            }

            return nodes;    
            
        }                                                                                          
            
        TIME :O(n) as we traverse all nodes of tree
        SPACE:O(n) as we use queue
 
         */





    }  
    public void DFSRootToLeaf     (Node root, List<List<Integer>> nodes ,List<Integer> path){
        /*
         root-- 7      -->Traverse left- right  top -bottom (DFS)
               /  \       return path of nodes  from root to leaf (RootToLeaf)
              4    9      [[7,4,1],[7,4,6],[7,9,8],[7,9,10]]  
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          

        //RECURSIVE IP OP TREE
        /*
        public void DFSRootToLeaf     (Node root, List<List<Integer>> nodes ,List<Integer> path)
                                                                    -- while going top-down 
            if (root == null){return;}                                      return at null and  start moving up 
            path.add(root.val);                                             [7,4,1]   --add node to last index of path         
            if(root.left == null && root.right == null){                    [[7,4,1]] --if we are at leaf node add path to node
                nodes.add(path);                                                        RETURN AND START MOVING UP AGAIN (AVOID SAME OBJECT WHILE COMING BOTTOM-UP)    
                return;} 
                        
        
            DFSRootToLeaf(root.left , nodes,new ArrayList<Integer>(path));   --while going left-right
            DFSRootToLeaf(root.right , nodes,new ArrayList<Integer>(path));    CREATE NEW OBJECT (AVOID SAME OBJECT WHILE COMING BOTTOM-UP)     
        
            path.remove(path.size()-1);                                      --while going bottom-up
                                                                            [7,4] --remove node from last index of path 
                                                                                    so that while coming down when you add 6 it becomes  
                                                                                    [7,4,6] which is another root to leaf path
        }

        //OVERRIDE
        public List<List<Integer>> DFSRootToLeaf(Node root){
            List<ArrayList<Integer>> nodes = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            DFSRootToLeaf(root,nodes,path);
            return nodes;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
        
        if(root == null){return;}
        path.add(root.val);                                  
        if(root.left == null && root.right == null){
            nodes.add(path);
            return;} 
                     
        
       
        DFSRootToLeaf(root.left,nodes,new ArrayList<Integer>(path));
        DFSRootToLeaf(root.right , nodes,new ArrayList<Integer>(path));
    
        path.remove(path.size()-1);     
        
    
     }
    public void DFSRootToAny      (Node root, List<List<Integer>> nodes ,List<Integer> path , int val){
        /*
         root-- 7      -->Traverse  left-right,top-bottom (DFS)
               /  \       return path of nodes  from root to any node with given val (RootToANy)
              4    9      val = 9 [[7,9]]]  
             / \    / \   val = 10 [[7,9,10]]
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          
  
        //RECURSIVE IP OP TREE
        /*
        public void DFSRootToAny      (Node root, List<List<Integer>> nodes ,List<Integer> path , int val)
                                                                        -- while going top-bottom 
            if (root == null){return;}                                      return at null and  start moving up 
            path.add(root.val);                                            [7,4,1]   --add node to last index of path         
            if(root.val == val){                                          [[7,4,1]] --if we are encounter  node add path to node
                nodes.add(path);                                                        RETURN AND START MOVING UP AGAIN (AVOID UPDATING OBJECT WHILE COMING UP)
            return;} 
        
        
            DFSRootToLeaf(root.left , nodes,new ArrayList<Integer>(path));   --while going left-right
            DFSRootToLeaf(root.right , nodes,new ArrayList<Integer>(path));   CREATE NEW OBJECT (AVOID SAME OBJECT WHILE COMING DOWN) ;
        
            path.remove(path.size()-1);                                      --while going bottom-up
                                                                            [7,4] --remove node from last index of path 
                                                                                    so that while coming down when you add 6 it becomes  
        }                                                                          [7,4,6] which is another root to any node  path

        //OVERRIDE
        public List<Integer> DFSRootToAny(Node root){
            List<List<Integer>> nodes = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            DFSRootToAny(root,nodes,path,val);
            return nodes.get(0);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */  
        if(root == null){return;}
        path.add(root.val);                                  
        if(root.val == val){
            nodes.add(path);
            return;} 
                     
        
       
        DFSRootToAny(root.left,nodes,new ArrayList<Integer>(path),val);
        DFSRootToAny(root.right , nodes,new ArrayList<Integer>(path),val);
    
        path.remove(path.size()-1);     

     }
    public int  DFSAnyToAny       (Node root){
        
        /*
         root-- 7      -->-->Traverse  left-right,top-bottom (DFS)
               /  \      return path of any node to any node  (AnyToAny)    -- returning any to any path is tedious so I have done any to any path max sum of nodes
              4    9      ** ANY TO ANY not ncessarily pass throught root
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          

        //RECURSIVE IP OP TREE
        /*
                     7 l=15;r=8                                  
            15  /          \  8                                                  
               /            \ 
    l=8;r=7  4                1   l=0,r=7
             /  \               \  
         8  /    \ 7             \  1               --return  max(max(l,r) + root.val ,root.val) 
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=6
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \1              
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0

        public int  DFSAnyToAny       (Node root)                               

                                                        --while going top-bottom
            if (root == null){return 0;}                  return 0  at null and  start moving up 
                                                        
                                                        --while going lefty,right
            int left = DFSAnyToAny(root.left);             left,right holds the sum of nodes of left and right subtree
            int right = DFSAnyToAny(root.right);


                                                        --while coming bottom-up
            temp1 = max(max(l,r) + root.val ,root.val)    required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                                        max(l,r)+root.val                 -- max sumOfNode from left and right  + node 4 ka val
                                                        (max(l,r) + root.val ,root.val) -- node4 alone can be greater that path with max sum till node4 as there may be -ve vals along the path so compare root also
                                                                                                    and pass it  to next node
            temp2 = l+r+root.val                          required path  passes through our node 4(find the calculation for path through node4 which is our main calcuation)
                                                        l+r+root.val                      -- sumofNodes rom left and right  + node 4 ka val

            ans = max(temp,l+r+1)                          max of not passing through node4 and passing through node 4 is answer   
            res = max(res,ans)                             find maximum path of all answers                                              //res is global var                      
    
            return temp1 ;                                  we dont return res but temp1 which is the val we need to pass ahead when node4 is not answer
        }

        //OVERRIDE
        public int  DFSAnyToAny(Node root){
            return DFSAnyToAny(root);
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
        */

        return 0;


 

    }
    public int  DFSLeafToLeaf     (Node root){
        /*
         root-- 7      ---->Traverse  left-right,top-bottom (DFS)
               /  \       return path of leaf node to leaf node  (LeafToLeaf)     -- returning leaf to leaf path is tedious so I have done leaf to leaf  path max no of nodes
              4    9      ** LEAF TO LEAF not ncessarily pass throught root
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          
        //RECURSIVE IP OP TREE
        /*
                    7 l=12;r=8                                  
            12  /          \  8                                                  
               /            \ 
    l=8;r=7  4                1   l=0,r=7
             /  \               \  
         8  /    \ 7             \  1               --return  max(l,r) + root.val   
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=6
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \1              
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0


        public int  DFSLeafToLeaf     (Node root
                                                    --while going top-bottom
            if (root == null){return 0 ;}              return 0  at null and  start moving up 

            int left = DFSLeafToLeaf(root.left);      --while going left-right 
            int right = DFSLeafToLeaf(root.right);      left , right holds the sum of nodes of left and right subtree

                                                    -- while coming bottom-top

                                                        NEED FOR NULL CHECK:root.left , root.right  being   null yeild different results 
                                                        if left is null then left returns 0 , right returns sumofNodes(+ve/-ve) ;for +ve max(l,r) takes sumOfNodes of right where leaf present no issue ; for -ve max(l,r) takes sumOfNodes of left but leaf present on right                                                                                                                             
            if(root.left == null){                       if left is null find sumOfNodes on right subtree + root val 
            return right+root.val }                    if right is null find sum of nodes on left subtree + root val
        if(root.right == null){                       and return else wont encounter base
            return left + root.val}                        
            OR                                      
            if(root.left==null||root.right==null)       if left or right is null find max of sumOfNodes on left and right subtree + root val  
                return Math.max(left,right)+root.val}   This is "INVALID" as sumofNodes can be -ve unlike noOfNodes so taking max here we may end up on the null node where leaf is not present                              
            
                
            temp1 =max(l,r) + root.val                   required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                                        max(l,r)+root.val                   --  max   sumofNodes  from left and right + node 4 ka  val 
                                                        (max(l,r) + root.val ,root.val)X  -- root alone can be greater that the sum of l,r,root as there may be -ve vals so compare root also
                                                                                                    BUT  root is not a leaf node so we shouldnt compare with root.val
            temp2 = l+r+root.val                         required path  pass through our node 4(node 4 bolega mai hi answer nahi hu )
                                                        l+r+root.val                       --  sumofNodes  from left and right  + node 4 ka  val 
            
            ans = temp2                                   max of not passing through node4 and passing through node 4 is answer  BUT temp may have a path sum from leaf to any node so if temp becomes greater ans might store leaf to any node which is not as require                                                                                         
            res = max(res,ans)                            max path of all answers                                              
    

            return temp1 ;                                 we dont return res but temp which is the val we need to pass ahead
        }

        //OVERRIDE
        public int  DFSLeafToLeaf(Node root){
            return DFSLeafToLeaf(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */

        

        return 0;


    }
    public int  DFSTopToBottom(Node root, int currentsum, int targetSum, Map<Integer, Integer> map) {
        /*
         root-- 10      -->-->Traverse  left-right,top-bottom (DFS) 
               /  \       return path of  top to bottom node(top to bottom means any to any just your traversal  must be top to bottom) -- returning top to bottom path is tedious 
              5    3                                                                                                                            so I have done top to bottom   paths that have targetSum
             / \     \  ** TOP TO BOTTOM not ncessarily pass throught root                                                                      EG 5,3 ; 5,2,1 ; 3-11,16 for target  = 8
            3  2     -11 



        */
        


    
        //RECURSIVE IP OP TREE   
        /*
        Consider  for target  = 8  paths will be  5,3 ; 3,-11
               10  l= 1,r=1,rs=0  
              /  \
          1  /    \  1
            /      \  
  l=1,r=0  5       3     l=0,r=1                                                                                                               
  rs=0     / \       \   rs=0                      --return temp(temp =  left + right +  noOfPathsWithRequiredSum   )
         1/   \0      \1
         /     \       \                                                     
l=0;r=0 3      2 l,r=0 -11 l=0;r=0
rs=1              rs=0     rs=1 
                                                  --return 0

                                       



        public int  DFSTopToBottom(Node root, int currentsum, int targetSum, Map<Integer, Integer> map)                                                               
                                                                            -- while going down     
            if (root == null){return 0 ;}                                        return 0 at null and  start moving up     
            currentsum               = currentsum + root.val;                   find no of paths with target sum
            int requiredSum          = currentsum - targetSum;                  suppose node3 is the curent node(look in question)                                                                                                   
            int noOfPathsWithCurrentSum  = map.getOrDefault(currentsum, 0) + 1; sum of node 10-3(curretsum)  - sum of node 10(requiredSum) = sum of node 5-3(targetSum)     
            int noOfPathsWithRequiredSum = map.getOrDefault(requiredSum, 0);    sum of node 10(requiredSum) =  sum of node 10-3(curretsum) -sum of node 5-3(targetSum)       
            map.put(currentsum,noOfPathsWithCurrentSum);                        now count no of paths with required sum which will be equal to no of paths with target sum                                            
            |
            |
            Default SUM = 0 KA COUNT=1 MAIN METHOD ME SET KARNA PADEGA


                                                                                                                
            int left = DFSTopToBottom(root.left,currentsum,targetSum,map);  --while going left-right 
            int right = DFSTopToBottom(root.right,currentsum,targetSum,map)    left right holds the no  of paths with requires sum fro  of left and right subtree
        
        
                                                                                while going bottom-up
            temp =  left + right +  noOfPathsWithRequiredSum                     noOfPathsWithSUm till node                                                
            map.put(currentsum, map.get(currentsum) - 1);                          update map  
                                                                                            
                                                                            
            return temp;
        }

        //OVERRIDE
        public int DFSTopToBottom(Node root, int targetSum) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0, 1);                                   //Default sum = 0 has one count
            int currentsum = 0;
            return DFSTopToBottom(root,currentsum,targetSum,map);
        }


                        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space

        */

        return 0;


    }

    

 
    //DFSPREPOSTINORDER
    /*
    HeightOfBinTree   -->DFSPrePostInOrderMaxNoOfNode    HeightOfBinTree =  MaxDepthOfBinTree
    MaxDepthOfBinTree -->DFSPrePostInOrderMaxNoOfNode 
    MinDepthOfBinTree -->DFSPrePostInOrderMinNoOfNode
    SizeOfBinTree     -->DFSPrePostInOrderNoOfNodes

    Balanced Binary Tree -->DFSPrePostInOrderIsBalanced
    Full Binary Tree     -->DFSPrePostInOrderisFull                                 
    Complete Binary Tree -->DFSPrePostInOrderisComplete
    Perfect Binary tree  -->DFSPrePostInOrderisPerfect  
    
    BinarySearchTree   -->DFSPrePostInOrderIsBSTI,DFSPrePostInOrderIsBST
    BinaryAVLTree      -->DFSPrePostInOrderIsBATI,DFSPrePostInOrderIsBAT

    */
    public void DFSPrePostInOrderNoOfNodes  (Node root){
        /*
          root-- 7        -->travel left-right;top-bottom      (DFS)
                /  \         and return no of nodes 
               4    9        7 
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


        //RECURSIVE IP OP TREE
        /* 
        public void DFSPrePostInOrderNoOfNodes  (Node root)

                                                                --while going top-bottom  
            if (root == null){return;}                            return at null and  start moving up          
            pathCount = pathCount + 1;//pathcount is global var   add 1 to pathcount 
            
            DFSPrePostInOrderNoOfNodes(root.left);                 --while going left-right
            DFSPrePostInOrderNoOfNodes(root.right);
        }

        //OVERRODE
        int pathCount = 0;  
        public void DFSPrePostInOrderNoOfNodes(Node root){
            DFSPrePostInOrderNoOfNodes(root);
            return pathCount;

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
              :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
               +
               O(n) we are  using list that takes extra space

        */


        //RECURSIVE IP-OP TREE
        /*


         //RECURSION - BINARY RECURSIVE TREE(Binary tree is  recursive DS)
        /* 
                  7 l=3;r=3                                   
         3      /          \  3                                                  
               /            \ 
    l=1;r=1  4                1   l=1,r=1
             /  \          /    \  
         1  /    \ 1    1 /      \  1    --return left + right+1
           /      \      /        \
 l=0;r=0  8  l,r=0 7     2l,r=0    1 l=0;r=0
         /\       /\      /\      /\
       0/  \ 0  0/  \0  0/  \0  0/  \0   -- return 0
        n  n    n    n   n  n    n  n

        public int   DFSPrePostInOrderNoOfNodes(Node root
                                                                --while going top-bottom
            if(root==null) {return 0;}                            return 0 at null and move up 
                                                                pass to next node

            int left = DFSPrePostInOrderNoOfNodes(root.left);   -- while going left-right 
            int right  = DFSPrePostInOrderNoOfNodes(root.right); left,right holds the no of nodes of left and right subtree

                                                                --while going bottom-top
            return left + right + 1;                               no of nodes of left + right subtree + node ka 1 
                                                                    pass to next node
        }

        //OVERRIDE
        public void DFSPrePostInOrderNoOfNodes(Node root){
            return DFSPrePostInOrderNoOfNodes(root);

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */

                  
        
        

    }
    public void DFSPrePostInOrderMaxNode    (Node root){
        /*
          root-- 7        -->travel left-right;top-bottom        (DFS)
                /  \         and return nmax 
               4    9        10
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


        //RECURSION IP OP TREE
        /*  
        public void DFSPrePostInOrderMaxNode(Node root){
                                                                --while going top-bottom  
            if (root == null){return;}                                return at null and  start moving up   
            pathMax = max(pathMax,root.val)//pathMax is global var    replace pathMax by max node val
            
            DFSPrePostInOrderMaxNode(root.left);                 --while going left-right
            DFSPrePostInOrderMaxNode(root.right);
        }

        //OVERRIDE
        int pathMax = Integer.MIN_VALUE;  
        public void DFSPrePostInOrderMaxNode(Node root){
            DFSPrePostInOrderMaxNode(root);
            return pathMax;

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
               :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
        
        //RECURSION IP OP TREE
        /*
                   7 l=8;r=2                                  
                8  /          \  2                                                 
                  /            \ 
        l=8;r=7  4                1   l=2,r=1
                /  \          /    \  
            8  /    \ 7    2 /      \  1    --return max(left,right,root.val)
              /      \      /        \
   l=m;r=n  8  l,r=m 7     2 l,r=m   1 l=m;r=m
            /\       /\      /\      /\
          m/  \m   m/  \m  m/  \m  m/  \m    -- return Integer.MIN_VALUE
            n  n    n    n   n  n    n  n

            
        public int DFSPrePostInOrderMaxNode(Node root){ 

                                                                --while going top-bottom
            if(root==null) {return Integer.MIN_VALUE;}            return Min value at null and move up
                                                                pass to next node

            int left = DFSPrePostInOrderMaxNode(root.left);      --while going left-right
            int right = DFSPrePostInOrderMaxNode(root.right);      left,right  holds max from left and right subtree
            
                                                                --while going bottom-up
            return Math.max(Math.max(left,right),root.data);     max of left,right and root ka val
                                                                pass to next node
        }


        //OVERRIDE
        public int DFSPrePostInOrderMaxNode(Node root)  {
            return DFSPrePostInOrderMaxNode(root);
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */
            
        

    }
    public void DFSPrePostInOrderMinNode    (Node root){
        /*
          root-- 7        -->travel left-right;top-bottom        (DFS)
                /  \         and return min  of nodes 
               4    9        1
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


        //RECURSION IP - OP TREE
        /* 
        public void DFSPrePostInOrderMinNode    (Node root){
                                                                    --while going top-bottom  
            if (root == null){return;}                               return at null and  start moving up      
            pathMin = max(pathMin,root.val)//pathMin is global var   replace pathMin by min node val
            
            DFSPrePostInOrderMinNode(root.left);                   --while gong left-right
            DFSPrePostInOrderMinNode(root.right);
        }

        //OVERRIDE
        int pathMax = Integer.MAX_VALUE;  
        public void DFSPrePostInOrderMinNode(Node root){
            DFSPrePostInOrderMinNode(root);
            return pathMin;

        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */


        
        //RECURSION IP - OP TREE
        /*
                    7 l=4;r=1                                  
             4 /          \  1                                                 
               /            \ 
    l=8;r=7  4                1   l=2,r=1
             /  \          /    \  
         8  /    \ 7    2 /      \  1    --return min(left,right,root.val)
           /      \      /        \
 l=M;r=M  8  l,r=M 7     2l,r=M    1 l=M;r=M
         /\       /\      /\      /\
       M/  \M   M/  \M  M/  \M  M/  \M    -- return Integer.MAX_VALUE
        n  n    n    n   n  n    n  n

         public int DFSPrePostInOrderMinNode    (Node root){
                                                            --while going top-bottom
            if(root==null) {return Integer.MAX_VALUE;}           return max value at null and move up 
                                                                and pass to next node

            int left = DFSPrePostInOrderMinNode(root.left);    --while going left-right 
            int right = DFSPrePostInOrderMinNode(root.right);    left,right holds MIN from left and right subtree
            
                                                                --while going bottom-top
            return Math.max(Math.max(left,right),root.data);     MIN of left,right and root ka val
        }                                                        pass to next node

        //OVERRIDE
        public int DFSPrePostInOrderMinNode(Node root)  {
            return DFSPrePostInOrderMinNode(root);
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */

    }
    public void DFSPrePostInOrderMaxNoOfNode(Node root){
        /*
          root-- 7        -->travel travel left-right;top-bottom            (DFS)
                /  \         and return max no of nodes on path from root to leaf(root to leaf)
               4    9        3
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

        //RECURSIVE IP OP TREE
        /*
        return DFSRootToLeafPathsKaMaxNoOfNodes(root,0);
        */

        //RECURSIVE IP OP TREE
        /*          
                  7 l=2r=1                                   
             2   /          \  1                                                  
                /            \ 
        l=1;r=1  4                1   l=0,r=0
                /  \                
            1  /    \ 1     --return max(left,right)+1
              /      \              
        l=0;r=0  8        7 l=0;r=0   
            /\       /\      
          0/  \ 0  0/  \0    -- return 0
        n  n    n    n   

        public int     DFSPrePostInOrderMaxNoOfNode(Node root)

                                                                --while going top-bottom
            if(root==null) {return 0;}                            return 0 at null andmove up 
                                                                pass to next node

            int left = DFSPrePostInOrderMaxNoOfNode(root.left);   --while going left-right  
            int right =DFSPrePostInOrderMaxNoOfNode(root.right);    left,right n holds the max no of nodes of left and right subtree

                                                                --while going bottom-top
            return Math.max(left,right) + 1;                        max no of nodes  on left ,right subtree + node ka 1 
                                                                    pass to next node
        }

        //OVERRIDE
        public int DFSPrePostInOrderMaxNoOfNode(Node root){
            return DFSPrePostInOrderMaxNoOfNode(root);

        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */



     

    }
    public void DFSPrePostInOrderMinNoOfNode(Node root){
        /*
          root-- 7        -->travel travel left-right;top-bottom                 (DFS)
                /  \         and return min no of nodes on path from root to leaf(root to leaf)
               4    9        3
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

        //RECURSIVE IP OP TREE
        /*
        SAME AS DFSRootToLeafPathsKaMinNoOfNodes()  
        */

        //RECURSIVE IP-OP TREE
        /* 
                   7  l=2r=1                                   
            2   /          \  1                                                  
               /            \ 
    l=1;r=1  4                1   l=0,r=0
             /  \                
         1  /    \ 1     --return min(left,right)+1
           /      \              
 l=0;r=0  8        7 l=0;r=0   
         /\       /\      
       0/  \ 0  0/  \0    -- return 0
        n  n    n    n   


        public int     DFSPrePostInOrderMinNoOfNode (Node root)

                                                                --while going top-bottom
            if(root==null) {return 0;}                            return 0 at null andmove up
                                                                pass to next node

            int left = DFSPrePostInOrderMinNoOfNode(root.left);   --while going left-right   
            int right  =DFSPrePostInOrderMinNoOfNode(root.right);    left,right   holds the min no of nodes of left and right subtree

                                                                --while going bottom-top
            return min(left,right) + 1;                             min no of nodes  on left ,right subtree + node ka 1 
                                                                    pass to next node
        }

        //OVERRIDE
        public int  DFSPrePostInOrderMinNoOfNode(Node root){
            return DFSPrePostInOrderMinNoOfNode(root);

        }
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */
     
        
         
     

    }
    public void DFSPrePostInOrderSumOfNodes (Node root){
        /*
          root-- 7        --travel left-right;top-bottom      (DFS)
                /  \         and return sum  of nodes 
               4    9        45
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */
        
        //RECURSIVE IP OP TREE
        /* 
        DFSPrePostInOrderSumOfNodes(Node root){
                                                                --while going top-bottom  
            if (root == null){return;}                               return at null and  start moving up     
            pathSum = pathSum + root.val;//pathcount is global var  add root val to pathSum 
            
            DFSPrePostInOrderSumOfNodesI(root.left);                --while going left-right
            DFSPrePostInOrderSumOfNodesI(root.right);
        }

        //OVERRIDE
        int pathSum = 0;  
        public void DFSPrePostInOrderSumOfNodes(Node root){
            DFSPrePostInOrderSumOfNodes(root);
            return pathSum;

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
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
         8  /    \ 7    2 /      \  1    --return left + right+root.va;
           /      \      /        \
 l=0;r=0  8  l,r=0 7     2l,r=0    1 l=0;r=0
         /\       /\      /\      /\
       0/  \ 0  0/  \0  0/  \0  0/  \0    -- return 0
        n  n    n    n   n  n    n  n

        public int DFSPrePostInOrderSumOfNodes(Node root){
                                                                --while going top-bottom
            if(root==null) {return 0;}                            return 0 at null andmove up
                                                                pass to next node

            int left = DFSPrePostInOrderSumOfNodesII(root.left);   --while going left-right   
            int right  = DFSPrePostInOrderSumOfNodesII(root.right);  left,right holds the sum of nodes of left and right subtree

                                                                --while coming bottom-up
            return left + right + root.val;                       sum of nodes of left + right subtree + node ka val
                                                                pass to next node
        }

        public int DFSPrePostInOrderSumOfNodes(Node root){
           return  DFSPrePostInOrderSumOfNodes(root);

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */

    }
    public void DFSPrePostInOrderSumOfNodesInRange(Node root, int low , int high){
       /*
          root-- 7        --travel left-right;top-bottom      (DFS)
                /  \         and return sum  of nodes which lie the range [low,high] inclusive
               4    9        45
              / \    / \    
             1  6   8  10    
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
            
            DFSPrePostInOrderSumOfNodesInRange(root.left,low,high);   --while going left-right
            DFSPrePostInOrderSumOfNodesInRange(root.right,low,high);

        }

        //OVERRIDE
        int pathSum = 0;  
        public void DFSPrePostInOrderSumOfNodesInRange(Node root, int low, int high){
            DFSPrePostInOrderSumOfNodes(root,low,high);
            return pathSum;

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
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

        public int DFSPrePostInOrderSumOfNodesInRange(Node root, int low, int high){
                                                                --while going top-bottom
            if(root==null) {return 0;}                            return 0 at null andmove up
                                                                pass to next node

            int left = DFSPrePostInOrderSumOfNodesInRange(root.left);   --while going left-right   
            int right  = DFSPrePostInOrderSumOfNodesInRange(root.right);  left,right holds the sum of nodes of left and right subtree
                                                                    
                                                                        --while coming bottom-up
            if(root.val >= low && root.val <= high){                      if node ka value lies in range
                return left + right + root.val;                              sum of nodes of left + right subtree + node ka val pass to next node
            else                                                          else 
                return left + right + 0;                                   sum of nodes of left + right subtree + 0 l pass to next node
        }

        public int DFSPrePostInOrderSumOfNodesInRange(Node root, int low, int high){
           return  DFSPrePostInOrderSDFSPrePostInOrderSumOfNodesInRangeumOfNodes(root,low,high);

         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */


    }
    public void DFSPrePostInOrderContains   (Node root, int val){
        /*
           root-- 7        -->travel left-right;top-bottom       (DFS)
                 /  \         and  if contains return true false 
                4    9        and if contains return node or null Eg 4
               / \    / \      and if contains eturn node and its subtrenodes or null  Eg [4,1,6]
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 


         
        //RECURSION IP -OP TREE
        /*

        public void  DFSPrePostInOrderContains   (Node root, int val) 
                                                                                                        -- while going top-bottom   
            if (root == null){return;}                                                                       return at null and  start moving up 
            if(root.val == val ){                                                                             if root ka val matches val
                pathBoolean      = true;         //pathBoolean,pathNode,pathNodeSbbtree are  global        make pathBoolean as true , pathNode as sinle node , pathNodeSbbtree as node and all its subnodes
                pathNode        = new Node(val);
                pathNodeSubtree = root     
            }
    
            DFSPrePostInOrderContains(root.left);                                                       --while going left-right
            DFSPrePostInOrderContains(root.right);
        }

        //OVERLOAD
        boolean pathBoolean = false;
         Node pathNode = null;
         Node pathNodeSubtree  = null;
         public Node DFSPrePostInOrderContains(Node root,int val){
             DFSPrePostInOrderContains(root,val);
             return pathBoolean;
             return pathNode
             return pathNodeSubtree;
         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
         */    
        
        //RECURSION IP -OP TREE
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

        public boolean DFSPrePostInOrderContains(Node root,int val)
                                                                     --while going top-bottom
            if(root==null) {return false;}                            return false at null and move up 
                                                                    pass to next node

            boolean left  =DFSPrePostInOrderContains(root.left);         --while going left-right  
            boolean right =DFSPrePostInOrderContains(root.right);          left,right hold whether  left and right subtree contains mode

                                                                        --while going bottom-top
            boolean nodeContains =  (root.val == val) ;                   left has val || right has val ; node has val   pass to next node 
            return left || right || nodeContains;                        pass to next node
            OR                                                          
            if (root.val == val)                                         left has val || right has val ; node has val   pass to next node 
                    pathNode=new Node(val);//pathNode,pathNodeSbbtre global pass to next node                          
                    pathNodeSubtree = root                                                                           
                    return true;
            return left || right;
        }

        boolean pathBoolean = false;
        Node pathNode = null;
        Node pathNodeSubtree  = null;
        public Node DFSPrePostInOrderContains(Node root,int val)  {
           DFSPrePostInOrderisFullII(root,val);
           return pathBoolean/pathNode/pathNodeSubtree;
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes 
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space


      */
      
         
     }
    public void DFSPrePostInOrderIsBalanced (Node root){
        /*
          root-- 7        -->travel left-right;top-bottom   (DFS)
                /  \         and return whether  tree is balanced
               4    9        
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


        //RECURSIVE IP OP TREE
        /* 
        public void   DFSPrePostInOrderIsBalanced  (Node root){
                                                                    --while going top-bottom
            if (root == null){return;}                                 return at null and  start moving up    
            int leftHeight = DFSPrePostInOrderNoOfNodes(root.left);    if  |heightOfLeftSubtree-heightOfrightSubtree| ! <= 1 make pathBoolean = false // pathBoolean is a global variable  
            int rightHeight = DFSPrePostInOrderNoOfNodes(root.right);  
            if(Math.abs(leftHeight-rightHeight) > 1){
                pathBoolean = false;     
            }
            
            DFSPrePostInOrderMinNode(root.left);                   --while ging left-right
            DFSPrePostInOrderMinNode(root.right);
        }

        //OVERLOAD
        boolean pathBoolean = true;
        public boolean DFSPrePostInOrderIsBalanced(Node root){
            DFSPrePostInOrderIsBalanced(root);
            return pathBoolean;
        }



        Time :O(n^2) if it is balanced tree  as we traverse all nodes in tree and at each node we find height of node 
            :O(n^2)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree and at each node we find height of node 
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */
 
        

        //RECURSIVE IP OP TREE
        /*
                        4 l=t;r=t                                 
            t      /          \  t                                                  
                /            \ 
        l=t;r=t   2              6   l=t,r=t
                /  \          /    \                     -- var nodeIsBalanced = Math.abs(height(root.left) - height(root.right)) <=1 OR  if(!(Math.abs(height(root.left) - height(root.right)) <=1)){return true;}    
            t  /    \ t    t /      \  t                    return left && right && nodeIsBalanced                                         return left && right; 
            /      \      /        \
    l=t;r=t  1  l,r=t 3     5l,r=t    7 l=t;r=t
            /\       /\      /\      /\
        t/  \ t  t/  \t  t/  \t  t/  \t                -- return true
        n  n    n    n   n  n      n  n

        public int   DFSPrePostInOrderIsBalanced  (Node root){
                                                              
                                                                                        --while going top-bottom
            if(root==null) {return true;}                                                   return true at null and move up 
                                                                                            pass to next node

            boolean left  =DFSPrePostInOrderIsBalanced(root.left);                        --while going left-right
            boolean right =DFSPrePostInOrderIsBalanced(root.right);                          left,right hold whether  left and right subtree are balanced
                                            
            
            
                                            
                                                                                            --while coming bottom-top 
            int leftHeight = DFSPrePostInOrderMaxNoOfNode(root.left);
            int rightHeight =  DFSPrePostInOrderMaxNoOfNode(root.right);
            var nodeIsBalanced = Math.abs(leftHeight- rightHeight) <=1 ;                  left is balance  && right is balance && node is balance pass to next node 
            return left && right && nodeIsBalanced                                          pass to next node 
            OR
            if(!(Math.abs(leftHeight - rightHeight) <=1)){return true;}                    left is balance  && right is balance ; node is balance pass to next node 
            return left && right                                                            pass to next node 
    
        }

        //OVERRIDE
        public int DFSPrePostInOrderIsBalanced(Node root)  {
          return DFSPrePostInOrderIsBalanced(root);
        }

        Time :O(n^2) if it is balanced tree  as we traverse all nodes in tree and  find height and each node
                :O(n^2)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes and find height and each node
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space

      */

        //RECURSIVE IP OP TREE MODIFIES

        /* 
                4 l=3;r=1                                 
          2      /          \  1                                             
                /            \ 
        l=1;r=1   2              6   l=0,r=0
            /  \                               -- return max(l,r) + 1  
        1  /    \ 1                                  
            /      \      
        l=0;r=0  1        3 l=0,r=0     
        /\       /\      
        0/  \ 0  0/  \0  0/  \0  0/  \0                -- return 0
        n  n    n    n   n  n      n  n
        public int     DFSPrePostInOrderIsBalanced(Node root){
                                                                    --while going top-bottom
            if(root==null) {return 0;}                                return true at null and move up 
                                                                        pass to next node

            int left  =DFSPrePostInOrderIsBalanced(root.left);      --while going left-right  
            int right =DFSPrePostInOrderIsBalanced(root.right);      left,right hold the height of left and right subtree

                                                                    -- while going bottom-top                     
            if (Math.abs(left - right) > 1){                          if height of left - height of right >1 then reassign //pathResult = false;//result is a global var
                pathResult = false;//result is a global var           pass to next node
            }                                                         max of left,right + node ka 1 pass to next node
            return Math.max(left,right) + 1;                          pass to next node
        }

        //OVERRIDE
        boolean pathResult = true;
        public int DFSPrePostInOrderIsBalanced(Node root)  {
            DFSPrePostInOrderIsBalanced(root);
            return pathResult;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree and simultaneously find height  -->O(N) NOT O(N^2)
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes and simultaneously find height 
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */
        
        
        
    }
    public void DFSPrePostInOrderisFull     (Node root){
       /*
          root-- 7        -->travel left-right;top-bottom         (DFS)
                /  \         and return whether  tree is full
               4    9        
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


        //RECURSION IP - OP TREE
        /* 
         public void    DFSPrePostInOrderisFull     (Node root) {                                                                                        -- while going top-bottom   
            if (root == null){return;}                                                                   return at null and  start moving up 
            if(!((root.left == null && root.right == null) || (root.left!=null && root.right != null))){  if node does not have  0 or 2 children  
                pathBoolean = false;//pathBoolean is global                                                 make pathBoolean as false//pathBoolean is global       
            }

            DFSPrePostInOrderisFull(root.left);                                                             --while going left--right
            DFSPrePostInOrderisFull(root.right); 
        }

        //OVERRIDE
        boolean pathBoolean = true;
        public boolean DFSPrePostInOrderisFull(Node root){
            DFSPrePostInOrderisFull(root);
            return pathBoolean;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */    

        //RECURSION IP - OP TREE
        /*
                   4 l=t;r=t                                 
         t      /          \  t                                                  
               /            \ 
    l=t;r=t   2              6   l=t,r=t
             /  \          /    \                     --  var nodeIsFull = (root.left == null && root.right == null) || (root.left!=null && root.right != null)    OR if(!((root.left == null && root.right == null)||(root.left!=null && root.right != null))){return false} 
         t  /    \ t    t /      \  t                     return left && right && isFull                                                                           return left && right; 
           /      \      /        \
 l=t;r=t  1  l,r=t 3     5l,r=t    7 l=t;r=t
         /\       /\      /\      /\
       t/  \ t  t/  \t  t/  \t  t/  \t                -- return true
      n  n    n    n   n  n      n  n


        public boolean DFSPrePostInOrderisFull(Node root){
                                                                                                                    --while going top-bottom
            if(root==null) {return true;}                                                                          return true at null and move up 
                                                                                                                    pass to next node


            boolean left  =DFSPrePostInOrderisFull(root.left);                                                      --while going left-right 
            boolean right =DFSPrePostInOrderisFull(root.right);                                                       left,right  hold whether  left and right subtree are full

                                                                                                                    while going bottom-top
            var isFull = (root.left == null && root.right == null) || (root.left!=null && root.right != null)     left is full && right is full && isFull pass to next node 
            return left && right && isFull                                                                         pass to next node
            OR                                                                                                            
            if(!((root.left == null && root.right == null)||(root.left!=null && root.right != null))){return false}  left is full && right is full ; isFull pass to next node   
            return left && right                                                                                     pass to next node
        }

        public boolean DFSPrePostInOrderisFull(Node root)  {
          return DFSPrePostInOrderisFull(root);
        }


    Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes 
    Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

      */
      
      
        
 
        
    }
    public void DFSPrePostInOrderIsComplete (Node root ,int index , int noOfnodes){
        /*
           root-- 7        -->travel left-right;top-bottom        (DFS)
                 /  \         and return whether  tree is complete
                4    9        
               / \    / \    
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 

        //RECURSION  IP - OP TREE
        /* 
        public void DFSPrePostInOrderIsComplete (Node root ,int index , int noOfnodes)
                                                                                -- while going top-bottom   
            if (root == null){return;}                                              return at null and  start moving up  
            if (index >= noOfnodes)                                                  if the calculated index >= no of nodes
                //pathBoolean = false;//pathBoolean is global var                     make pathBoolean false
        
    
            DFSPrePostInOrderIsComplete(root.left ,index*2 + 1, noOfnodes);          -- while going left-right
            DFSPrePostInOrderIsComplete(root.right,index*2 + 2, noOfnodes);            '' same as level order but calculate the index of node
                                                                                              7   0
                                                                                              /  \
                                                                                             /    \  
                                                                                          1 8      9  2
                                                                                             / \
                                                                                            /   \
                                                                                            12   13
                                                                                            5     6
                                                                                        (5>=5) (6>=6) 
        }

        boolean pathBoolean = true;
         public boolean DFSPrePostInOrderIsComplete(Node root){
             DFSPrePostInOrderIsComplete(root,0,DFSPrePostInOrderNoOfNodesI(root));
             return pathBoolean;
         }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
         */    
    
        //RECURSION  IP - OP TREE
         /* 
                   4 l=t;r=t                                 
         t      /          \  t                                                  
               /            \ 
    l=t;r=t   2              6   l=t,r=t
             /  \          /    \                     -- boolean isComplete = (index >= noOfnodes)   OR if(index >= noOfnodes){return false;} 
         t  /    \ t    t /      \  t                    return left && right &&isComplete;             return left && right; 
           /      \      /        \
 l=t;r=t  1  l,r=t 3     5l,r=t    7 l=t;r=t
         /\       /\      /\      /\
       t/  \ t  t/  \t  t/  \t  t/  \t                -- return true
      n  n    n    n   n  n      n  n

        public boolean DFSPrePostInOrderIsComplete (Node root ,int index , int noOfnodes)

                                                                    --while going top-bottom
            if(root==null) {return true;}                            return false at null and move up 
                                                                    pass to next node

        
    
            left = DFSPrePostInOrderIsComplete(root.left ,index*2 + 1, noOfnodes);     --while going left-right    
            right = DFSPrePostInOrderIsComplete(root.right,index*2 + 2, noOfnodes);      '' same as level order but calculate the index of node
                                                                                        left right holde whether left right subtree are complete
                                                                                                7   0
                                                                                                /  \
                                                                                                /    \  
                                                                                            1 8      9  2
                                                                                                    / \
                                                                                                    /   \
                                                                                                    12   13
                                                                                                    5     6
                                                                                                    (5>=5) (6>=6)
                                                                                        while going bottom-top
            boolean isComplete = (index >= noOfnodes);                                  left is complete && right is complete &&  node is complete pass to next node    
            return left && right &&isComplete;                                          pass to next node
            OR
            if(index >= noOfnodes){return false;}                                       
            return left && right                                                        left is complete && right is complete &&  node is complete pass to next node    
                                                                                    pass to next node
        }

        //OVERRIDE
        public boolean DFSPrePostInOrderIsComplete(Node root){
            return DFSPrePostInOrderIsComplete(root,0,DFSPrePostInOrderNoOfNodesI(root));
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space                                                                         
         */    
        
         
     }
    public void DFSPrePostInOrderisPerfect  (Node root){
        /*
          root-- 7        -->travel left-right;top-bottom     (DFS)
                /  \         and return whether  tree is perfect
               4    9        
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


        //RECURSION IP - OP TREE
        /*
        public void DFSPrePostInOrderisPerfect(Node root){
            int size = DFSPrePostInOrderNoOfNodesI(root);
            int height = DFSPrePostInOrderMaxNoOfNodeI(root);
            if(size == (Math.pow(2, height(root) + 1) - 1)){
                isPerfect =  true; //isPerfect is global
            }
        }

        //OVERRIDE
        boolean isPerfect = false;
        public void DFSPrePostInOrderisPerfect(Node root){
            DFSPrePostInOrderisPerfect(root);
            return isPerfecr

        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
               :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
             +
            O(n) we are  using list that takes extra space
        */
         
        //RECURSION IP - OP TREE
        /*
        public boolean DFSPrePostInOrderisPerfect(Node root){
            int size = DFSPrePostInOrderNoOfNodesI(root);
            int height = DFSPrePostInOrderMaxNoOfNodeI(root);
            return size == (Math.pow(2, height(root) + 1) - 1)
            }
        }

        //OVERRIDE
        public boolean DFSPrePostInOrderisPerfect(Node root){
            return DFSPrePostInOrderisPerfect(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
               :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
             +
            O(n) we are  using list that takes extra space
        */
         

    }
    public void DFSPrePostInOrderIsBST      (Node root){
        /*
           root-- 7        -->travel left-right;top-bottom        (DFS)
                 /  \         and return if it is a BST 
                4    9        
               / \    / \      
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 
        //RECURSIVE IP -OP TREE
        /* 
        public void DFSPrePostInOrderIsBST (Node root){
                                                            --while going top-bottom    
            if (root == null){return;}                        return at null and  start moving up   

            DFSPrePostInOrderIsBST(root.left);             -- while going left-right 


                    
            if(previousNode!=null){                      --while going bottom-top(top middle wala)
            if(root.val <= previousNode.val){           root val <= previousnode val then make pathBoolean false                    
                pathBoolean=false;                         store previousNode(allows duplicate node in BT)/previosNode value(allows only unique BT values) then previousNode will be available with us                                 
            }                                            (left <(!<=)root<(!<=) right so left-right;bottom-top(top middle me ie inorder) will give nodes in purely ascending order ;
                                                            hence  root.val <= previous val for false  )
            
            previousNode = root;   //previousNode is global varuable                                                       
                                                                       
            DFSPrePostInOrderIsBST(root.right);
        }

        //OVERRIDE
        boolean pathBoolean = true;
        public boolean DFSPrePostInOrderIsBST(Node root){
            DFSPrePostInOrderIsBST(root);
            return pathBoolean;
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
        */
       
        //RECURSIVE IP -OP TREE
        /*
                    /* 
                        3 l=t;r=t                                  
                t /          \  t                                                 
                /            \ 
        l=t;r=t   2              5   l=t,r=t
                /  \          /    \  
            t  /    \ t    t /      \  t            --if(root.val <= previousNode.val){return t} ; return left && right
            /      \      /        \
        l=t;r=t  1  l,r=t 7     4 l,r=t    6 l=t;r=t
                                                    -- return false
    
        public boolean DFSPrePostInOrderIsBST (Node root){
    
                                                                --while going top-bottom    
            if (root == null){return false;}                     return false at null and  start moving up   
    
            boolean left = DFSPrePostInOrderIsBST(root.left);  -- while going left-right 
                                                                left,right hold whether left,right subtree are BST
    
                    
            if(previousNode!=null){                             --while going bottom-top(top middle wala)
            if(root.val <= previousNode.val){                  root val <= previousnode val return false                  
                return false;                                     store previousNode(allows duplicate node in BT)/previosNode value(allows only unique BT values) then previousNode will be available with us                                 
            }                                                   [LEFT <(!<=) ROOT<(!<=) RIGHT -->LEFT-RIGH, BOTTOM-TOP(TOP MIDDLE WALA IE INORDER TRAVERSAL) MUST BE PURELY ASCENDING
            previousNode = root;   //previousNode is global                                        SO ROOT VAL > PREVIOUS NODE VAL SO IF ROOT VAL <= PREVIOUS VAL MAKE PATHBOOLEAN FASE ]
            
                                                                
                                                                        
            boolean right = DFSPrePostInOrderIsBST(root.right);   
            
            return left && right;                              -- while going bottom up
                                                                return left is BST && RIGHT IS is BST
        }

        //OVERRIDE
        public boolean DFSPrePostInOrderIsBST(Node root){
            return DFSPrePostInOrderIsBS(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space           
            */
    }
    public void DFSPrePostInOrderIsBAT      (Node root){
        /*
           root-- 7        -->travel left-right;top-bottom        (DFS)
                 /  \         and return if it is a BAT(bin avl tree)
                4    9        
               / \    / \      
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 
        //RECURSION - IP -OP TREE
        /*
        public void DFSPrePostInOrderIsBAT(Node root){
            if(DFSPrePostInOrderIsBST(root); && DFSPrePostInOrderIsBalanced(root) == true){
                isBAT = tru //isBAT is a global var
            }
        }

        //OVERRIDE
        boolean isBAT = false;
        public void DFSPrePostInOrderIsBAT(Node root)
            DFSPrePostInOrderIsBAT(root);
            return isBAT;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
    

        */

            
        //RECURSION - IP -OP TREE
        /*
        public boolean DFSPrePostInOrderIsBAT(Node root){
            return DFSPrePostInOrderIsBST(root); && DFSPrePostInOrderIsBalanced(root);
        }

        //OVERRIDE
        public boolean DFSPrePostInOrderIsBAT(Node root)
            return DFSPrePostInOrderIsBAT(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
    

        */


    }
    public void DFSPrePostInOrderSiblings   (Node root ,int n1 , int n2){
        /*
           root-- 7        -->travel left-right;top-bottom         (DFS)
                 /  \         and  return whether  nodes are siblings ie belong to same parent
                4    9        4,9 are siblings
               / \    / \     
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 
  
        //RECURSION IP-OP TREE
        /* 
        public void DFSPrePostInOrderSiblings(Node root ,int n1 , int n2){                                                                                                 
                                                                       -- while going top-bottom   
            if (root == null){return;}                                  return at null and  start moving up 
            if(root.left != null && root.right != null){                 NEED FOR NULL CHECK-root.left , root.right  cant be null inside fn 
                if(root.left.val == n1 && root.right.val == n2         
                || root.left.val== n2 && root.right.val == n1){         if left child ,atches n1 and right matches n2 or viceversa then make
                pathBoolean = true;  //pathBoolean is global var    pathBoolean true
                                                                                
                }                                                                  
            }
    
            DFSPrePostInOrderSiblings(root.left,n1,n2);              --while going left-right
            DFSPrePostInOrderSiblings(root.right,n1,n2);
        }

        //OVERRIDE
        public boolean pathBoolean = false;
        public void DFSPrePostInOrderSiblings(Node root ,int n1 , int n2){
            DFSPrePostInOrderSiblings(root,n1,n2);
            return pathBoolean;

        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
         */ 
        
        //RECURSION IP-OP TREE
        /*
        Consider checking whether 5,7 are siblings
             4 l=f;r=t                                 
      f      /          \  t                                                  
            /            \ 
    l=f;r=f   2              6   l=f,r=f
           /  \          /    \                     -- boolean areSibling =  ..                 OR if (..){if( ... ) {} return true;} 
       f  /    \ f    f /      \  f                    return left || right || nodeContains;    return left || right || areSibling; 
         /      \      /        \
    l=f;r=f  1  l,r=f 3     5 l,r=f    7 l=f;r=f
        /\       /\      /\      /\
     f/  \ f  f/  \f  f/  \f  f/  \f                -- return false
     n  n    n    n   n  n      n  n


        public boolean DFSPrePostInOrderSiblings(Node root , int n1, int n2)
                                                                            --while going top-bottom
            if(root==null) {return false;}                                     return false at null and move up 
                                                                                pass to next node

            boolean left = DFSPrePostInOrderSiblings(root.left, n1, m2);   --while going left-right 
            boolean right = DFSPrePostInOrderSiblings(root.right ,n1, n2);  left,right  hold whether  left and right subtree are siblings

                                                                            -- while coming  bottom-top 
            if (root.left != null && root.right != null) {                    NEED FOR NULL CHECK-root.left , root.right  cant be null inside fn       
            areSibling = (root.left.val == n1 && root.right.val == n2)         left is sibling || right is sibling || node is sibling    pass to next node 
                        || (root.right.val == n1 && root.left.val == n2);       pass to next node 
            return left || right || areSibling;
            OR            
            if (root.left != null && root.right != null) {                    NEED FOR NULL CHECK-root.left , root.right  cant be null inside fn                                                                            
            if(root.left.val == n1 && root.right.val == n2)                   left is sibling || right is sibling ; node is sibling    pass to next node 
                || (root.right.val == n1 && root.left.val == n2);{          
                }                                                                          
                return true;
            }
            return left || right || areSibling;
        }

        //OVERRIDE
        public boolean DFSPrePostInOrderSiblings(Node root , int n1, int n2){
            return DFSPrePostInOrderSiblings(root, n1, n2)
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
        :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 


        */
    

       
   }
    public void DFSPrePostInOrderLCA        (Node n1, Node n2){
        /*
           root-- 7        -->travel left-right;top-bottom         (DFS)
                 /  \         and  return lowest common ancestor of n1,n2
                4    9        where we allow a node to be a descendant of itself 8,10 
               / \    / \      4,9 lowest common ancestor is 7 ; 4 1 lowest common ancestor is 4
              1  6   8  10    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */

        //RECURSION IP-OP TREE
        /*
        WHILE COMING BOTTOM-UP YOU NEED RETURN VALUE(RET TYPE ) -->RETURN VALUE WILL CARRY THE INFO THAT YOU HAVE ENCOUNTERED THE NODED
        */

        //RECURSION IP-OP TREE
        /*
         Consider returning lowest common ancestor of 2,7
                    4  l=1;r=1;ni=0 (gotcha)                              
              t  /         \  t                                                  
               /            \ 
    l=0;r=1   2              6   l=0,r=1
    ni=0     /  \          /    \ ni=0                     
         f  /    \ t    f /      \  t                 --return  left+right+nodeItself >0;
           /      \      /        \
          1        3     5         7 
    l=0;r=0     l=0,r=0  l=0,r=0    l=0,r=0          
   ni =0        ni=1     ni=0       ni=1                            -- return false
 

            Consider returning lowest common ancestor of 2,3
                    4  l=1;r=1;ni=0   -->l+r+ni=2                                
              t /         \  t                                                  
               /            \ 
   l=0;r=1    2              6   l=0,r=1
   ni=1      /  \          /    \ ni=0                     
  (gotcha) f/    \ t    f /      \  t            --return  left+right+nodeItself >0;
           /      \      /        \
          1        3     5         7 
    l=0;r=0     l=0,r=0  l=0,r=0    l=0,r=0          
    ni =0        ni=1     ni=0       ni=1       
                                                 --return false

        public boolean DFSPrePostInOrderLCA(Node root , Node n1,Node n2)

                                                                            --while going top-bottom
            if(root==null) {return false;}                                     return false at null and move up 
                                                                                pass to next node
    
        int left = DFSPrePostInOrderLowestCommonAncestorII(root.left,n1,n2)?1:0;;   --while going left-right 
        int right = DFSPrePostInOrderLowestCommonAncestorII(root.right,n1,n2)?1:0;    left,right  hold whether  left and right subtree have node
                                                                                        (return boolean but hold l,r as integer because we have to do l+r+ni and nit l&&r&&ni)

                                                                            -- while coming  bottom-top 
            int nodeItself = (root.val == n1.val || root.val == n2.val)?1:0;      nodeItself = 1/0 if it itself is a node or not \
            if(lef+right+nodeitself=2){ancestor=root.val//global var}             if l+r+ni=2 we have our ancestor
            return  left+right+nodeItself >0;                                     return left+right+nodeItself to next node
            
                                                                                    
                                                                                ( Return boolean but hold int in l,r because int covers many ases
                                                                                l+r+ni=2 --> Any two must be 1
                                                                                            ie left has node && right has node
                                                                                                ||left has node && node itself is  node
                                                                                                ||right has node && node itself is  node
                                                                                l+r+ni>0  -->Any one must be 1
                                                                                                left has node
                                                                                                ||right has node 
                                                                                                ||node itself is  node 
        }
        int ancestor = 0;
        public boolean DFSPrePostInOrderLowestCommonAncestor(Node root , Node n1,Node n2){
            DFSPrePostInOrderLowestCommonAncestor(root,n1,n2);
            return new Node(ancestor)
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
           :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
  


        */


                             
 

    }
    public void DFSPrePostInOrderIOSucessor (Node root, Node node){
        /*
        5   -- Traverse the tree in in order fashion and return the inorder sucessor(ie node we will enc after given node while travelling inOrder) 
        /\      Eg: 6 -->5
       3  6
       /\
      2  4
      /
      1
        
        */
        
        //RECURSION IP-OP TREE + ITERATIVE
        /*
        public void DFSPrePostInOrderIOSucessor (Node root, Node node){
            if(node.right != null){                              --if node ka right is not null 
                Node rightNode = node.right;                           find the leftMost node of the right child
                DFSNodeKaLeftMost(root,rightNode); 
            }
            else if(node.right == null){                          --if node ka right is null
                DFSNodeKaPrevious(root,node);                       find the previous node of given node by traversin traverse recursively 
           }                                                           
        }


        //DFSNodeKaPrevious()  
        TreeNode prevNode = null;
        public void DFSNodeKaPrevious(Node root ,Node node){
                                                                                --while travelling top-bottom
            if(root == null){return;}                                             if root is null return and move to next nose
        
            DFSNodeKaPrevious(root.left,node);                                  --while travelling top bottom 
            
            if(prevNode != null){                                                  if pevNode is not null
                if(prevNode == node && sucessor == null ){                            if prevNode matches node and sucessor is not null then assign sucessor to root and return 
                    sucessor = root;return;}//sucessor is global var                  assign prevNode  to root
            }                                                                                               
            prevNode = root;
            
            DFSNodeKaPrevious(root.right,node);                                  --while travelling top botoom
    
        }
    
        //DFSNodeKaLeftMost
        public void DFSNodeKaLeftMost(Node root, Node node){
            Node ptr = node;                                                --initialise ptr to node
            while(ptr.left!= null){                                               while ptr.left is not null
                ptr = ptr.left;                                                      move ptr to left
            }
            sucessor=  ptr; //sucessor is global var                              assign sucessor to ptr 
        } 


        //OVERRIDE
        Node sucessor = null;
        public void DFSPrePostInOrderIOSucessor (Node root, Node node){
            DFSPrePostInOrderIOSucessor(root,node);
            return sucessor;
        }

    
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space


        
        */
        
        
        
       
    }
    public void DFSPrePostInOrderIsSymmetric(Node n1, Node n2){
        /*
           root-- 7                   -->travel left-right;top-bottom       (DFS)
                 /  \                    and  return whether two trees are symmetric    
                4     4               
               / \    / \      
              1  6   6  1    
              /  \ /\  /\  / \
             n  n  n n n n  n n
         */
 
        //RECURSION IP-OP TREE
        /*  
        public void DFSPrePostInOrderIsSymmetric(Node n1, Node n2)                                                    
                                                                --while going top-bottom    
            if(n1 == null && n2 == null){                           NEED FOR NULL CHECK:WHILe CHECKING 2 NODES SIMULTANEOUSLY(NULL WHILE COMING DOWN ONLY NOT WHILE GOING UP AS YOU USE N1,N2 IN RECURSIVE CALL)
                                                                                    n1,n2 both being null yeild a different result ; either being null yeild a different result 
                return;  }                                          n1 n2 both being null is not an issue just return  
            if(n1 ==null ||n2 == null){                             n1 n2 either being null is an issue  make pathBoolean false and return 
                pathBoolean = false;  //pathBoolean is global var } 
            if(n1.val != n2.val){                                    if vals dont match make pathBoolean as false
                pathBoolean = false;  //pathBoolean is global var 
                
            }
        }
        
        
        DFSPrePostInOrderIsSymmetric(n1.left,n2.right);      --while going left- right
        DFSPrePostInOrderIsSymmetric(n1.right,n2.left);        If you start with n1=root,n2=root then we'll end up validating that the left subtree is a mirror of the right subtree but also that the right subtree is a mirror of the left subtree.
                                                              If you start with n1= root.left , n2 = root.right  we'll end up validating that the left subtree is a mirror of the right subtree
                                                              (LOOK IN OVERLOADING )

        //OVERRIDE
        public boolean pathBoolean = true;
        public void DFSPrePostInOrderIsSymmetric(Node root){
            DFSPrePostInOrderIsSymmetric(root,root);          //If you start with n1=root,n2=root then we'll end up validating that the left subtree is a mirror of the right subtree but also that the right subtree is a mirror of the left subtree.
            DFSPrePostInOrderIsSymmetric(root.left,root.right)//If you start with n1= root.left , n2 = root.right  we'll end up validating that the left subtree is a mirror of the right subtree

            return pathBoolean;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
         */ 

        //RECURSION IP-OP TREE
        /*
                    4 l=t;r=f                                 
          t      /         \  f                                                  
               /            \ 
    l=t;r=t   1              2   l=t,r=t
             /  \          /    \                     --  boolean areEqual =(n1.val == n2.val)  OR     if(n1.val != n2.val){return false;}  
         t  /    \ t    t /      \  t                     return left&& right&&areEqual;              return left&& right    
           /      \      /        \
 l=t;r=t  1  l,r=t 3     3l,r=t    1 l=t;r=t
         /\       /\      /\      /\
       t/  \t  t/   \t  t/  \t  t/  \t                --  return true/false depending on nullnes of n1,n2
      n  n    n    n   n  n      n  n  

        public boolean DFSPrePostInOrderIsSymmetric  (Node n1 , Node n2)
                                                                        --while coming bottom-top
                                                                            NEED FOR NULL CHECK:  When you are checking 2 node simultaneously(NULL WHILE COMING DOWN ONLY NOT WHILE GOING UP AS YOU USE N1,N2 IN RECURSIVE CALL) 
            if(n1 == null && n2 == null){                                                            n1,n2 both being null yeild a different result ; either being null yeild a different result 
                return true;  }                                               n1 n2 both being null is not an issue just return true 
            if(n1 ==null ||n2 == null){                                       n1 n2 either being null is an issue  return false
                return false;  } 


            boolean left  = DFSPrePostInOrderIsSymmetric(n1.left, n2.right);  -- while going left-right  
            boolean right = DFSPrePostInOrderIsSymmetric(n1.right, n2.left);     left,right hold whether  left and right parts  are equal

                                                                            -- while coming bottom-top
            boolean areEqual =(n1.val == n2.val);                               left is equal || right is equal; node has val       
            return left&& right&&areEqual;                                      pass to next node 
            OR
            if(n1.val != n2.val){return false;}                            
            return left&& right                                                 left is equal || right is equal; node has val   
                                                                                pass to next node   
        }

        //OVERRIDE
         int pathBoolean = true;
         public boolean DFSPrePostInOrderSymmetricII(Node root){
              DFSPrePostInOrderSymmetricII(root,root);
              return pathBoolean;
         }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
           :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
  

        */
        
        //ITERATIVE
        /*        
                                    //STACK                                           
            root--   7                              
        /  \                6                                while stack is not empty 
        4    4               1                                stack ka top ke 2 vals nikal
        / \   / \        4    6                                val compare kar , n1 ka l r stack me , n2 ka r l stack me //NULL CHECK : If both are null continue ; if one of them is null return false    
        1  6   6  1       4    1                                                                            
                                                                Stack<Node> stack = new Stack<>();
                                                                stack.push(root.left);
                                                                stack.push(root.right);
                                                                while (!stack.empty()) {
                                                                    Node n1 = stack.pop(); 
                                                                    Node n2 = stack.pop();
                                                                    
                                                                    if (n1 == null && n2 == null) continue;
                                                                    if (n1 == null || n2 == null ) return false;
                                                                    
                                                                    if(n1.val != n2.val) return false;
                                                                    stack.push(n1.left);
                                                                    stack.push(n2.right);
                                                                    stack.push(n1.right);
                                                                    stack.push(n2.left);
                                                                }
                                                                return true;
                                                                //EDGE CASE:root is null return true

                
        public boolean DFSPrePostInOrderSymmetricI_iterative(Node root) {
            if (root == null) {
                    return true;}
                
                Stack<Node> stack = new Stack<>();
                stack.push(root.left);
                stack.push(root.right);
                while (!stack.empty()) {
                Node n1 = stack.pop(); 
                Node n2 = stack.pop();
                
                if (n1 == null && n2 == null) continue;
                if (n1 == null || n2 == null ) return false;
                
                if(n1.val != n2.val) return false;
                stack.push(n1.left);
                stack.push(n2.right);
                stack.push(n1.right);
                stack.push(n2.left);
            }
            return true;
        }
    
            TIME :O(n) as we traverse all nodes of tree
            SPACE:O(n) as we use STACK


        

            */

  
  
    }
    public void DFSPrePostInOrderInvert     (Node root){
        /*
           7            7      -->travel left-right;top-bottom       (DFS)
         /  \           /\         and invert binary tree about y axis 
        4    9         6  4       
        / \  / \      /\  /\
       1  6  3  2    2  3 1 6

         */
 



        //RECURSION IP-OP TREE
        /*   
        public void DFSPrePostInOrderInvertI(Node root){

                                        -- while going top-bottom   
            if (root == null){return;}      return at null and  start moving up 
            
                X                              NEED FOR NULL CHECK:root.left , root.right  cant be null inside fn  BUT  DONT DO NULL CHECK BECAUSE YOU NEED ROOT.LEFT AND ROOT.RIGHT  NULL VALUES FOR SWAPPING EG:CONSIDER [1,2,null]
            Node temp = root.left;             left subtree keep in temp
            root.left = root.right;            right subtree attach to left
            root.right = temp;                 left subtree attach to right
            
            
            DFSPrePostInOrderInvert(root.left);  --while going left-right
            DFSPrePostInOrderInvert(root.right);
        }
        
        //OVERRIDE
        public void DFSPrePostInOrderInvertI(Node root){
            DFSPrePostInOrderInvertI(root);
            return root;

        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(1) 
 
         */ 

        //RECURSION IP-OP TREE
        /*   
                    7 l=N4;r=N1                                  
             N4 /          \  N1                                                  
               /            \ 
    l=N8;r=N7  4              1   l=N2,r=N1
             /  \          /    \  
         N8 /    \ N7  N2 /      \  N1                  --return root;
           /      \      /        \
 l=n;r=n  8  l,r=n 7     2 l,r=n    1 l=n;r=n
         /\       /\      /\      /\
       n  \ n   n/  \n  n/  \n  n/  \n                 -- return null
        n  n    n    n   n  n    n  n

        public Node    DFSPrePostInOrderInvert (Node root){
                                                                    --while going top-bottom
            if(root==null) {return null;}                            return  null and move up 
                                                                    pass to next node

            Node left = DFSPrePostInOrderInvert(root.left);         --while going lef-right 
            Node right = DFSPrePostInOrderInvert(root.right);          left holds left subtree; right holds right subtree
                                                                
                                                                    --while coming bottom-top
            X                                                       NEED FOR NULL CHECK:NEED FOR NULL CHECK:root.left , root.right  cant be null inside fn  BUT  DONT DO NULL CHECK BECAUSE YOU NEED ROOT.LEFT AND ROOT.RIGHT  NULL VALUES FOR SWAPPING EG:CONSIDER [1,2,null]                                       
            root.left = right;                                        rightchild assign to left                     
            root.right = left;                                        leftchild assigned to right 
            return root;                                              return root  and pass to next node
        }

        //OVERRIDE
        public void DFSPrePostInOrderInvert(Node root){
            return DFSPrePostInOrderInvert(root);

        }
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
       */ 
       
        //ITERATIVE
        /*
            root--   7                              
            /  \                           1                
            4    9                    4    6     6                8                                       -->while stack is not empty  
        / \    / \             7    9    9     9       9        10          10                             stack ka top nikal  
        1  6   8  10           []   [7]  [7,4] [7,4,1] [7,4,1,6][7,1,4,6,9] [7,4,1,6,8] [7,4,1,6,8,10]      val nodes me; r stack me ;l stack me  //NULL CHECK: root cant be null     
                                                                                                            Stack<Node> stack = new Stack<>();                                                                          
                                                                                                            stack.push(root); 
                                                                                                            while(!stack.empty()){
                                                                                                                root = stack.pop();
                                                                                                                if(root != null){                                                                                                                       
                                                                                                                    var temp = root.left;
                                                                                                                    root.left  = root.right;
                                                                                                                    root.right = temp; ; --> "WHILE COMING DOWN SWAP NODES"
                                                                                                                    stack.push(root.right);
                                                                                                                    stack.push(root.left);
                                                                                                                }
                                                                                                            }
                                                                                                            return nodes;
                                                                                                            //EDGE CASE:root is null return nodes
            
        public Node  DFSPrePostInOrderInvertI_iterative(Node root){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
                
            while(!stack.isEmpty()){
                root = stack.pop();
                if(root != null){
                    var temp = root.left;
                    root.left  = root.right;
                    root.right = temp; 
                    
                    stack.push(root.right);
                    stack.push(root.left);       
                }
            }    
            return root;    
        }
        
        */ 
            
            
            
        
    }
    public void DFSPrePostInOrderDouble     (Node root){
        /*
           7            7      -->travel left-right;top-bottom       (DFS)
         /  \           /\         and  souble tree by inserting a duplicate node on left  
        4    9         7  4
                      /   /
                     6   4
                     /
                    6 



         */

        //RECURSION IP - OP TREE
        /*   
        public void  DFSPrePostInOrderDouble(Node root){

                                        -- while going top-bottom   
            if (root == null){return;}      return at null and  start moving up 
            
                X                              NEED FOR NULL CHECK:root.left , root.right  cant be null inside fn  BUT  DONT DO NULL CHECK BECAUSE YOU NEED ROOT.LEFT AND ROOT.RIGHT  NULL VALUES FOR ASSIGNING EG:CONSIDER [1,2,null]
            var temp = root.left;              left subtree keep in temp
            root.left = new Node(root.val);    new node attach to left
            root.left.left = temp;             left subtree attach to left ka left 
            
            
            DFSPrePostInOrderDouble(root.left);  --while going left-right
            DFSPrePostInOrderDouble(root.right);
        }

        //OVERLOAD
        public void DFSPrePostInOrderDouble(Node root){
            DFSPrePostInOrderDouble(root);
            return root;

        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(1) 

        

         */ 

        //RECURSION IP - OP TREE
        /*   
                    7 l=N4;r=N1                                  
                N4 /          \  N1                                                  
                /              \ 
    l=N8;r=N7  4              1   l=N2,r=N1
              /  \          /    \  
          N8 /    \ N7  N2 /      \  N11                  --return root;
            /      \      /        \
    l=n;r=n  8  l,r=n 7   2 l,r=n    1 l=n;r=n
            /\       /\      /\      /\
        n  \ n   n/  \n  n/  \n  n/  \n                 -- return null
        n  n    n    n   n  n    n  n

        public Node    DFSPrePostInOrderDouble(Node root)
                                                                    --while going top-bottom
            if(root==null) {return null;}                            return  null and move up 
                                                                    pass to next node

            Node left = DFSPrePostInOrderInvert(root.left);         --while going lef-right 
            Node right = DFSPrePostInOrderInvert(root.right);          left holds left subtree; right holds right subtree
                                                                    
                                                                    --while coming bottom-top
                X                                                      NEED FOR NULL CHECK:NEED FOR NULL CHECK:root.left , root.right  cant be null inside fn  BUT  DONT DO NULL CHECK BECAUSE YOU NEED ROOT.LEFT AND ROOT.RIGHT  NULL VALUES FOR ASSIGNING EG:CONSIDER [1,2,null]                                       
            root.left = new Node(root.val);                            new NOde assign to left                   
            root.left.left = left;                                     leftchild assign to left ka left
            return root;                                               return root  and pass to next node
        }
        
        //OVERRIDE
        public void DFSPrePostInOrderDouble(Node root){
            return DFSPrePostInOrderDouble(root);

        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space

        */ 
        

   
        
        
        
    }
    public void DFSPrePostInOrderFlattenToLL(Node root , List<Integer> path){
        /*
           7            7      -->travel left-right;top-bottom      (DFS)
         /  \            \         Flatten binary tree to EQUIVALENT LL 
        4    9            4        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
        / \  / \           \       The "linked list" should be in the same order as a pre-order traversal of the binary tree.
       1  6  3  2           1
                             \
                              6
                               \
                                9
                                 \
                                  3
                                   \
                                    2

         */
 

  
            
        //RECURSION IP - OP TREE
        /*   
        public void DFSPrePostInOrderFlattenToLL(Node root , List<Integer> path)
                                                -- while going top-bottom   
            if (root == null){return;}               return at null and  start moving up 
            X                                       NEED FOR NULL CHECK: root.left , root.right  cant be null inside fn  BUT DONT DO NULL CHECK BECAUSE ROOT.LEFT AND ROOT.RIGHT ARE REQUIRED AS WE  ASSIGNING THEM VAUES EVEN IF THEY ARE NULL  EG: CONSIDER[1,2,null,5,6]                               
            path.add(root.val);                      add to path then later while overloading  (actually root.left , root,right is done in   overload  to ye udhar ke liye hai )
                                                    iterate this path from index 1 
                                                    root.left = null  root.right node = new Node(value of list)


            DFSPrePostInOrderFlattenToLL(root.left,path); -- while coming left-right
            DFSPrePostInOrderFlattenToLL(root.right,path);
        }

        //OVERLOAD
        public void DFSPrePostInOrderFlattenToLL(TreeNode root) {  
            List<Integer> path  = new ArrayList<>();
            DFSPrePostInOrderFlattenToLL(root,path);
            
            if(path.size() == 0 || path.size() == 1){
                return;
            }
            
            for(int i = 1 ; i < path.size();i++){    
                root.left = null;
                root.right = new TreeNode(path.get(i));
                
                root = root.right;
                
            }
        }

    
        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) as we use list  
        */ 
 
        
        //RECURSION IP OP TREE
        /*
        /WHILE COMING BOTTOM-UP YOU CANT RETURN VALUE(VOID TYPE) -->IF L,R WILL KEEP LEFT RIGHT SUBTREE ;SO WHILE COMING BOTTOM-TOP WHAT TO RETURN ? L?R?
        */

        //RECURSION IP - OP TREE MODIFIED
        /*    
        public void DFSPrePostInOrderFlattenToLL(Node root){
                                                    -- while going top-bottom   
            if (root == null){return;}                return at null and  start moving up 
    

                                                    --while going right-left
            DFSPrePostInOrderFlattenToLL(root.right);  first go to right then to left
            DFSPrePostInOrderFlattenToLL(root.left);   because this will give exact order of LL

                                                    --while going bottom-top
                                                    NEED FOR NULL CHECK: root.left , root.right  cant be null inside fn  BUT DONT DO NULL CHECK BECAUSE ROOT.LEFT AND ROOT.RIGHT ARE REQUIRED AS WE  ASSIGNING THEM VAUES EVEN IF THEY ARE NULL  EG: CONSIDER[1,2,null,5,6]                               
            root.left = null;                        root.left = null ; root.right = previousNode                                    
            if(pn!=null)root.right = previousNode;   store previousNode(allows duplicate node in BT)/previosNode value(allows only unique BT values) then previousNode will be available with us                                                            EG
            previousNode =root             
                                                     4   7             7
                                                    /    \           \
                                                 1 4      9 3         4
                                                   /\     / \          \
                                                  /  \   /   \          1
                                                 1    6  3   2           \
                                                6      9 2    null        6
                                                                           \
                                                                            9
                                                                             \
                                                                              3
                                                                               \
                                                                                2
                                                                                 \
                                                                                 null
        }

        //OVERLODAD
        Node previousNode = null;
        public void DFSPrePostInOrderFlattenToLL(TreeNode root) {  
            DFSPrePostInOrderFlattenToLL(root);
         
        }


       Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
               +
             O(1) as we use dont use list

        
        

            */ 



   
    }
    public void DFSPrePostInOrderCompare2TreeForEqual     (Node n1, Node n2){
        /*
         root-- 7               7      -->travel left-right;top-bottom      (DFS)
               /  \            /\         and  return whether two trees are same    ()
              4    9          4  9         both trees are equal
             / \    / \      /\  /\
                                                                                 
       */





        //RECURSION IP-OP TREE
        /* 
        public void DFSPrePostInOrderCompare2TreeForEqual(Node n1, Node n2){                                              
                                                                    --while going top-bottom    
            if(n1 == null && n2 == null){                           NEED FOR NULL CHECK:WHILe CHECKING 2 NODES SIMULTANEOUSLY(NULL WHILE COMING DOWN ONLY NOT WHILE GOING UP AS YOU USE N1,N2 IN RECURSIVE CALL)
                                                                                        n1,n2 both being null yeild a different result ; either being null yeild a different result 
                return;  }                                          n1 n2 both being null is not an issue just return  
            if(n1 ==null ||n2 == null){                             n1 n2 either being null is an issue  make pathBoolean false and return 
                pathBoolean = false;  //pathBoolean is global var } 
            if(n1.val != n2.val){                                          if vals dont match make pathBoolean as false
                pathBoolean = false;  //pathBoolean is global var 

            DFSPrePostInOrderCompare2TreeForEqual(n1.left,n2.left);           --while going left-riht
            DFSPrePostInOrderCompare2TreeForEqual(n1.right,n2.right);
        }

        //OVERRIDE
        public boolean pathBoolean = true;
        public void DFSPrePostInOrderEqualTree(Node t1, Node t2){
            DFSPrePostInOrderEqualTree(t1,t2);
            return pathBoolean;

        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
        */
        
        //RECURSION - BINARY RECURSIVE TREE(Binary tree is  recursive DS)
        /*
                    4 l=t;r=t                              4                                             
                t  /         \  f                          /       \                                        
                /            \                          /         \           --   boolean areEqual =(n1.val == n2.val); ; OR   if(n1.val != n2.val){return false;} 
    l=t;r=t   1              2   l=t,r=t              1           7              return left&& right&&areEqual;                return left&& right
                /  \          /    \                    /  \       /    \                                 
            t  /    \ t    t /      \  t               /    \     /      \                                            
            /      \      /        \                /      \   /        \
    l=t;r=t  1  l,r=t 3     3l,r=t    1 l=t;r=t     1        3   3          1 
            /\       /\      /\      /\
        t/  \t  t/   \t  t/  \t  t/  \t                -                         --  return true/false depending on nullnes of n1,n2
        n  n    n    n   n  n      n  n                                             
        public boolean DFSPrePostInOrderCompare2TreeForEqual(Node n1 , Node n2){


                                                                                --while coming bottom-top
                                                                                NEED FOR NULL CHECK:When you are checking 2 node simultaneously(NULL WHILE COMING DOWN ONLY NOT WHILE GOING UP AS YOU USE N1,N2 IN RECURSIVE CALL)  
            if(n1 == null && n2 == null){                                                          n1,n2 both being null yeild a different result ; either being null yeild a different result  
                return true;  }                                               n1 n2 both being null is not an issue just return true 
            if(n1 ==null ||n2 == null){                                       n1 n2 either being null is an issue  return false
                return false;} 


            boolean left = DFSPrePostInOrderCompare2TreeForEqual(n1.left, n2.left);      -- while going left-right 
            boolean right =  DFSPrePostInOrderCompare2TreeForEqual(n1.right, n2.right);     hold whether  left and right subtree are equa


                                                                                -- while coming up
            boolean areEqual =(n1.val == n2.val);                                 left is equal || right is equal; node has val      
            return left&& right&&areEqual;                                        pass to next node  
            OR
            if(n1.val != n2.val){return false;}                                   left is equal || right is equal; node has val         
            return left&& right                                                   pass to next node
        }

        //OVERRIDE
        public boolean DFSPrePostInOrderEqualTree(Node n1 , Node n2){
            return DFSPrePostInOrderEqualTree(n1,n2)
        }

        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 

        */

 
  
  
}
    public void DFSPrePostInOrderCompare2TreesForMerging  (Node n1, Node n2){
        /*
               1            1    =>   2      -->travel left-right;top-bottom        (DFS)
             /  \           /\        /\        merge the binary tree such that 
            2    3         3  6      5  9       if two nodes overlap, then sum node values up as the new value of the merged node.
            / \           /   /\    /\   /\     otherwise, the NOT null node will be used as the node of the new tree
           4  5          2    1 4  6  5  1 4
    
       */
    
        //RECURSION IP-OP TREE
        /*
         WHILE COMING BOTTOM-UP YOU NEED RETURN VALUE(RET TYPE) -->RETURN VALUE WILL  CARRY LEFT SUBTREE IN LEFT AND RIGHT SUBTREE IN RIGHT     
        */

        //RECURSION IP-OP TREE
        /*   
                    1 l=N4;r=N1                             2        
                /      \                               /   \                        
                /        \                            /     \
    l=5N;r=4N  3          2   l=N2,r=N1               1      3
                /                                         \      \
    5N      /    4N                                     \      \
            /                                             \      \
    l=n;r=n  5                                               4        7
            /\       
        n/  \ n                                                            --  return null/fn1/n2 depending on nullnes of n1,n2      
        n  n   

        public Node    DFSPrePostInOrderCompare2TreesForMerging(Node n1, Node n2){     
                                                                        --while going top-bottom
                                                                            NEED FOR NULL CHECK:WHILE CHECKING 2 NODES SIMULTANEOUSLY(NULL WHILE COMING DOWN ONLY NOT WHILE GOING UP AS YOU USE N1,N2 IN RECURSIVE CALL)
            if(n1 == null && n2 == null){                                                     n1,n2 both being null yeild a different result ; either being null yeild a different result 
                return null;}                                                   n1 ,n2 both beig null return null move up and pass to next node (stored in l,r)
            if(n1 == null){                                                     n1 being null return n2 move up and pass to next node(stored in left,right and connected to n1 while coming up)
                return n2;}                                                     n2 being null return n1 move up (stored in left,right and connected to n1 while coming up)
            if(n2 == null){
                return n1;}
            n1.val = n1.val + n2.val;                                           add values of n1,n2 to n1 value
            
            Node left = DFSPrePostInOrderCompare2TreesForMerging(n1.left,n2.left);          --while goig left-right
            Node right = DFSPrePostInOrderCompare2TreesForMerging(n1.right,n2.right);         left riht holds left and right subtree 
                
                                                                                --while going bottom-top
            n1.left = left;                                                     connect left tree to n1 ka left
            n1.right = right;                                                   connect right tree to n1 ka right
                                                                                return n1 and pass to next node
            return n1;
        }

        //OVERRIDE
        public Node DFSPrePostInOrderCompare2TreesForMerging(Node n1, Node n2){
            return DFSPrePostInOrderCompare2TreesForMerging(n1, n2)
        }

         Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
              :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space :O(h) = O(log n) if it is balanced tree  as we traverse entire height 
               :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
               +
              O(n) we are  using list that takes extra space

        */
          
        
    
    }
    public void DFSPrePostInOrderCompare2TreeForSubtree   (Node n1, Node n2){
            /*
         root-- 7                     -->travel left-right;top-bottom      (DFS)
               /  \                     and  return tree2 is a subtree of tree1
              4    9          4           
             / \    / \      /\  
            1  2   3   4    1 2                                                               
       */

        
        //RECURSION IP-OP TREE
        /*
       We need values while coming up
       */

        
        //RECURSION IP-OP TREE
        /*
       root-- 7                     
             /  \                   
             4    9          4           
            / \    / \      /\  
            1  2   3   4    1 2 

        public boolean DFSPrePostInOrderCompare2TreeForSubtree(Node n1, Node n2){
                                                                                --while going top bottom 
            if(n1 == null){return false;}                                            if n1 reaches null means they dint match so return false
            if(DFSPrePostInOrderCompare2TreeForEqualII(n2,n2)){return true;}         if equal tree at n1,n2 return true
                                
                                                                                    --while going left-right on t1 , dont go left right on tr
            boolean left = DFSPrePostInOrderContainsAnotherTree(n1.left,n2);         left, right holds whether tree2 is a subtree of tree1
            boolean right = DFSPrePostInOrderContainsAnotherTree(n1.right,n2);       
            
                                                                                    --while going bottom-up
            return left || right;                                                     return left|| right   
        }
        
        
        //OVERRIDWE
        public boolean DFSPrePostInOrderCompare2TreeForSubtree(Node n1, Node n2){
            DFSPrePostInOrderCompare2TreeForSubtree(n1,n2);
        }
        

        Time :O(n1*n2) if it is balanced tree  as we traverse all nodes on tree1 and for each node on tree1 we check is tree1 and tree2 are equal
            :O(n1*n2)  if it is unbalanced completely left/right skewed tree  as on tree1 and for each node on tree1 we check is tree1 and tree2 are equal
        Space :O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
    
    */



    }
    public void DFSPrePostInOrderCompare2TreesForConnect(Node root) {
        /*
            1----null         --Travel left-right;top-bottom  (DFS)
            /   \                class Node{l,r,next}
          2-----3---null         Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NUL
        /  \    \               Initially, all next pointers are set to NULL.
        4--- 5--- 6--null
        /          \
        7---------  8--null
            */
    

                
        //RECURSION IP -OP TREE
        /*   
        public void   DFSPrePostInOrderCompare2TreesForConnect(Node root){                                                       
                                                                    --while going top-down
            if (root == null){return;}                                 return at null and  start moving up 
                                                                    NEED FOR NULL CHECK:root.left and root.rightneither can be null ;HANDLE EACH CASE SEPERATELY  DUE TO CONSTRAINTS OF QUESTIO
            if (root.left!= null) {                                    if left is not null
                if (root.right != null)                                   if right is not null : connect left to right
                    root.left.next = root.right;                       if right is  null    :connect left to next available right node
            if (root.right == null) 
                    root.left.next = nextAvailableNodeOnRight(root);   if right is not null
            }                                                                   connect right to next available right node
                                                                                
            if (root.right != null) { 
                root.right.next = nextAvailableNodeONRight(root);
            }
            
            DFSPrePostInOrderCompare2TreesForConnect(root.right);       while going right-left
            DFSPrePostInOrderCompare2TreesForConnecI(root.left);        first connect the right nodes and then the left nodes 
                                                                        becaue you do nextAvailableNodeONRight and for that all the nodes
                                                                        on right must be connected
        }

        //NEXT AVAILABLE NODE ON RIGHT 
        private Node nextAvailableNodeOnRight(Node root) { 

              1----null         
             /   \                 
            2-----3---null         Consider connecting 7 to nearestRight
            /  \    \              root = 4  root = 5           root = 6           -->while root is not null
           4--- 5--- 6--null                 left is null  left is null        move root to right
          /          \                       right is null  right is 8         if left is not null left is nearest node
          7          8--null                                                             if right is not null right is nearest node
                                                                                       null is the nearest node 

        while (root.next != null) {                          
            root = root.next;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
          }
         return null;
       }

        //OVERRIDE
        public void   DFSPrePostInOrderCompare2TreesForConnect(Node root){  
            DFSPrePostInOrderCompare2TreesForConnect(root);
            return root;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree 
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
                O(n) we are  using list that takes extra space
 
         */        
    
        //RECURSION IP -OP TREE
        /*
        //WHILE COMING BOTTOM-UP YOU CANT RETURN VALUE(VOID TYPE) -->IF L,R WILL KEEP LEFT RIGHT SUBTREE;SO WHILE COMING BOTTOM-TOP WHAT TO RETURN ? L?R?
        */






 




    }
 

    //DFSLEVELORDER 
    public void DFSLevelOrderPathsKaNoOfNodesList (Node root,int level,List<Integer> pathCountList){
        /*
          root-- 7        -->travel left-right ,top-bottom            (DFS)
                /  \         and return no of Nodes at each level  [1,2,4] (level order)
               4    9        
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

        //RECURSION IP -OP TREE
        /* 
        public void DFSLevelOrderPathsKaNoOfNodesList (Node root,int level,List<Integer> pathCountList)
                                                                                --while going  top-bottom  
            if(root==null) {return;}                                              return at null and start moving up                                                                           
            if(pathCountList.size()==level)                                        [0  0 ]; --when we reach a level  add 0 to count at lastindex
            pathCountList.add(0);                                                lo l1     get the count at that level and add 1  and set count at that level
            pathCountList.set(level,pathCountList.get(level)+1);                               CREATE NEW OBJECT DONE WHEN WE REACH LEVEL NOT WHILE GOING LEFT RIGHT

            DFSLevelOrderPathsKaNoOfNodesList(root.left,level+1,pathCountList);    -- while going left-right
            DFSLevelOrderPathsKaNoOfNodesList(root.right ,level+1,pathCountList);    ''' same as level order
        }

        //OERRIDE
        public List<Double>  DFSLevelOrderPathsKaNoOfNodesList(Node root){
            List<Integer> pathCountList = new ArrayList<>();
            DFSLevelOrderPathsKaNoOfNodesList(root,0,pathCountList);
            return pathCountList;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */



  

    }
    public void DFSLevelOrderPathsKaMaxNoOfNodes  (Node root,int level,List<Integer> pathCountList){
        /*
          root-- 7        -->travel left-right ,top-bottom      (DFS)
                /  \         and return max no of Nodes of all level   (level order)
               4    9        4 
              / \    / \    
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

        //RECURSION IP -OP TREE
        /* 
        public void DFSLevelOrderPathsKaMaxNoOfNodes  (Node root,int level,List<Integer> pathCountList)
                                                                    --while going top-bottom 
            if(root==null) {return;}                                    return at null and start moving up    
            if(pathCountList.size()==level)                             [0  0 ]; --when we reach a level  add 0 to count at lastindex
            pathCountList.add(0);                                     l0 l1     get the count at that level and add 1  and set count at that level
            pathCountList.set(level,pathCountList.get(level)+1);                   (cannot calculate max/min here because we are going DFS and not BFS level by level )
                                                                                    so we do not  have no of nodes till we reach extreme right side of tree)

            DFSLevelOrderPathsKaMaxNoOfNodes(root.left,level+1,pathCountList);  -- while going left , right
            DFSLevelOrderPathsKaMaxNoOfNodes(root.right ,level+1,pathCountList);   ''' same as level order
        }

        //OVERRIDE
        public List<Double>  DFSLevelOrderPathsKaMaxNoOfNodes(Node root){
            List<Integer> pathCountList = new ArrayList<>();
            DFSLevelOrderPathsKaMaxNoOfNodes(root,0,pathCountList)

            int max = Integer.MIN_val;
            int maxLevel = Integer.MIN_val;
            for(int i = 0 ; i < pathCountList.size() ; i++){
                max = Math.max(pathCountList.get(i),max);

                if(pathCountList.get(i) > max){      // > because if there are duplicate in sum then we will get max/min sum and first occurence of max/min sum
                        maxLevel = i;
                }
            return max;
            return maxLevel+1;    //maxLevel+1 because we consider levels from 0 but question has levels from 1     
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */

  

  

    }
    public void DFSLevelOrderPathsKaMinNoOfNodes  (Node root,int level,List<Integer> pathCountList){
        /*
          root-- 7        -->travel left-right ,top-bottom             (DFS)
                /  \        and return max no of Nodes of all level] (level order)
               4    9        1
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */



        //RECURSION IP -OP TREE
        /* 
        public void DFSLevelOrderPathsKaMinNoOfNodes  (Node root,int level,List<Integer> pathCountList)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                    return at null and start moving up      
            if(pathCountList.size()==level)                             [0  0 ]; --when we reach a level  add 0 to count at lastindex
            pathCountList.add(0);                                     l0  l1     get the count at that level and add 1  and set count at that level
            pathCountList.set(level,pathCountList.get(level)+1);                    (cannot calculate max/min here because we are going DFS and not BFS level by level )
                                                                                    so we do not  have no of nodes till we reach extreme right side of tree)

            DFSLevelOrderPathsKaMinNoOfNodes(root.left,level+1,pathCountList); --while going left-right
            DFSLevelOrderPathsKaMinNoOfNodes(root.right ,level+1,pathCountList); ''' same as level order
        }


        //OVERLOAD
        public List<Double>  DFSLevelOrderPathsKaMinNoOfNodes(Node root){
        List<Integer> pathCountList = new ArrayList<>();
        DFSLevelOrderPathsKaMinNoOfNodes(root,0,pathCountList)

        int min = Integer.MAX_val;
        int minLevel = Integer.MAX_val;
        for(int i = 0 ; i < pathCountList.size() ; i++){
            min = Math.min(pathCountList.get(i),min);

            if(pathCountList.get(i) < min){      // > because if there are duplicate in sum then we will get max/min sum and first occurence of max/min sum
                    minLevel = i;
            }
        }
        return min;
        return minLevel+1;    //minLevel+1 because we consider levels from 0 but question has levels from 1     
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
               :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */

  
  

    }
    public void DFSLevelOrderPathsKaSumOfNodesList(Node root,int level,List<Integer> pathSumList){
        /*
          root-- 7        -->travel left-right ,top-bottom  
                /  \         and return sum of Nodes at each level
               4    9        [7,13,25]
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


    
        //RECURSION IP -OP TREE
        /* 
        public void DFSLevelOrderPathsKaSumOfNodesList(Node root,int level,List<Integer> pathSumList)
                                                            --while going top-bottom  
            if(root==null) {return;}                             return at null and start moving up   
            if(pathSumList.size()==level)                        [0  0] --when we reach a level  add 0 to sum at lastindex
            pathSumList.add(0);                                l0 l1    get the sum at that level and add root.val  and set sum at that level
            pathSumList.set(level,pathSumList.get(level)+(double)root.val);

            DFSLevelOrderPathsKaSumOfNodesList(root.left,level+1,pathSumList);   -- while going left,roght
            DFSLevelOrderPathsKaSumOfNodesList(root.right ,level+1,pathSumList);    ''' same as level order
        }

        //OVERLOAD
        public List<Double>  DFSLevelOrderPathsKaSumOfNodesList(Node root){
            List<Integer> pathSumList = new ArrayList<>();
            DFSLevelOrderPathsKaSumOfNodesList(root,pathSumList);
            return pathSumList;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */

   

  

    }
    public void DFSLevelOrderPathsKaMaxSumOfNodes (Node root,int level,List<Integer> pathSumList){
        /*
          root-- 7        -->travel left-right ,top-bottom 
                /  \         and return max od sum of Nodes of  level
               4    9        25
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


        //RECURSION IP -OP TREE
        /* 
        public void DFSLevelOrderPathsKaMaxSumOfNodes (Node root,int level,List<Integer> pathSumList)                                                        --while going top-bottom  
            if(root==null) {return;}                                   return at null and start moving up   
            if(pathSumList.size()==level)                              [0  0] --when we reach a level  add 0 to sum at lastindex
            pathSumList.add(0);                                      l0  l1   get the sum at that level and add root.val  and set sum at that level
            pathSumList.set(level,pathSumList.get(level)+(double)root.val);   (cannot calculate max/min here because we are going DFS and not BFS level by level )
                                                                                so we do not  have sum of nodes till we reach extreme right side of tree)

            DFSLevelOrderPathsKaMaxSumOfNodes(root.left,level+1,pathSumList);   -- while going left-right
            DFSLevelOrderPathsKaMaxSumOfNodes(root.right ,level+1,pathSumList);    ''' same as level order
        }

        //OVERLOAD
        public List<Double>  DFSLevelOrderPathsKaMaxSumOfNodes(Node root){
            List<Integer> pathSumList = new ArrayList<>();
            DFSLevelOrderPathsKaMaxSumOfNodes(root,0,pathSumList);
            
            int max = Integer.MIN_val;
            int maxLevel = Integer.MIN_val;
            for(int i = 0 ; i < pathSumList.size() ; i++){
                max = Math.max(pathCountList.get(i),max);

                if(pathSumList.get(i) > max){      // > because if there are duplicate in sum then we will get max/min sum and first occurence of max/min sum
                    maxLevel = i;
            }
            return max;
            return maxLevel+1;    //maxLevel+1 because we consider levels from 0 but question has levels from 1     
    
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */

    }
    public void DFSLevelOrderPathsKaMinSumOfNodes (Node root,int level,List<Integer> pathSumList){
        /*
          root-- 7        -->travel left-right ,top-bottom 
                /  \         and return max od sum of Nodes of  level
               4    9        7
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


        //RECURSION IP -OP TREE
        /* 
        public void DFSLevelOrderPathsKaMinSumOfNodes (Node root,int level,List<Integer> pathSumList)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up   
            if(pathSumList.size()==level)                                [0  0] --when we reach a level  add 0 to sum at lastindex
            pathSumList.add(0);                                        lo l1   get the sum at that level and add root.val  and set sum at that level
            pathSumList.set(level,pathSumList.get(level)+(double)root.val);    (cannot calculate max/min here because we are going DFS and not BFS level by level 
                                                                                so we do not  have sum of nodes till we reach extreme right side of tree)

            DFSLevelOrderPathsKaMinSumOfNodes(root.left,level+1,pathSumList);  -- while going left-right
            DFSLevelOrderPathsKaMinSumOfNodes(root.right ,level+1,pathSumList);   ''' same as level order
        }

        //OVERLOAD
        public List<Double>  DFSLevelOrderPathsKaMinSumOfNodes(Node root){
            List<Integer> pathSumList = new ArrayList<>();
            DFSLevelOrderPathsKaMinSumOfNodes(root,0,pathSumList);
            
            int min = Integer.MAX_val;
            int minLevel = Integer.MAX_val;
            for(min i = 0 ; i < pathSumList.size() ; i++){
                max = Math.min(pathCountList.get(i),min);

                if(pathSumList.get(i) > min){      // > because if there are duplicate in sum then we will get max/min sum and first occurence of max/min sum
                    maxLminLevelevel = i;
            }
            return min;
            return minLevel+1;    //maxLevel+1 because we consider levels from 0 but question has levels from 1     
    
           }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        */

        if(root==null) {return;}  
        if(pathSumList.size()==level){
            pathSumList.add(0);
        }
        pathSumList.set(level,pathSumList.get(level)+root.val);
        
        DFSLevelOrderPathsKaMinSumOfNodes(root.left,level+1,pathSumList);
        DFSLevelOrderPathsKaMinSumOfNodes(root.right,level+1,pathSumList);

          //OVERLOAD
          /*
          public List<Double>  DFSLevelOrderPathsKaMinSumOfNodes(Node root){
                List<Integer> pathSumList = new ArrayList<>();
                DFSLevelOrderPathsKaMinSumOfNodes(root,0,pathSumList);
                
                int min = Integer.MAX_val;
                int minLevel = Integer.MAX_val;
                for(min i = 0 ; i < pathSumList.size() ; i++){
                    max = Math.min(pathCountList.get(i),min);

                    if(pathSumList.get(i) > min){      // > because if there are duplicate in sum then we will get max/min sum and first occurence of max/min sum
                        maxLminLevelevel = i;
                }
                return min;
                return minLevel+1;    //maxLevel+1 because we consider levels from 0 but question has levels from 1     
        
           }
          */

  

    }
    public void DFSLevelOrderPathsKaAvgOfNodes    (Node root,int level,List<Double> pathCountList,List<Double> pathSumList){
           /*
           DFS LEVEL ORDER
          root-- 7        -->travel left-right ,top-bottom (DFS) 
                /  \         and return  average at each level(level order)
               4    9        [7.0,6.5,6,25]
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


    
        //RECURSION IP -OP TREE
        /*
        public void DFSLevelOrderPathsKaAvgOfNodes    (Node root,int level,List<Double> pathCountList,List<Double> pathSumList){
                                                            --while going top-bottom  
            if(root==null) {return;}                            return at null and start moving up 
            if(sum.size()==level)                               [0.0  0.0 ];[0.0,0.0] --when we reach a level  add 0.0 to sum/count at lastindex (top-bottom)
                pathCountList.add(0.0);                           l0   l1    l0   l1    get the sum/cont at that level and add root val/1  and set sum/count at that level
                pathSumList.add(0.0);                                                   (cannot calculate avg here because we are going DFS and not BFS level by level                                                                              
            pathCountList.set(level,pathSumList.get(level)+(double)1);                   so we do not  have count and sum of nodes till we reach extreme right side of tree)
            pathSumList.set(level,pathSumList.get(level)+(double)root.val);  
                                                                            
        

            DFSLevelOrderPathsKaAvgOfNodes(root.left,level+1,pathCountList,pathSumList);     -- while going left-right
            DFSLevelOrderPathsKaAvgOfNodes(root.right ,level+1,pathCountList,pathSumList);      ''' same as level order
        }

        
        //OVERLOAD
        public List<Double>  DFSLevelOrderPathsKaAvgOfNodes(Node root){
            List<Double> sum = new ArrayList<>();
            List<Double> count = new ArrayList<>();
            List<Double> average = new ArrayList<>();

            DFSLevelOrderPathsKaAvgOfNodes(root,0,sum,count);
            for(int i = 0 ; i < sum.size() ; i++){
                average.add(sum.get(i)/count.get(i));}
            return average;
        }



        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space

        DFSLevelOrder : DFSPreOrderTraversal  because you see root;then go to left subtree;then go to right subtree
                                                        BFSLevelOrder because you re getting results level y level
                                                        so it is BFSLevelOrder using DFSPreOrderTraversal 
        */



  

    }
    public void DFSLevelOrderPathsKaMaxMinOfNodes (Node root,int level,List<Integer> pathMaxList ,List<Integer> pathMinList){
        /*
        DFS LEVEL ORDER
       root-- 7        -->travel left-right ,top-bottom     (DFS ) 
             /  \        and  return max/min of nodes at each level (level Order)
            4    9       [7,9,10]/[7,4,1]
           / \    / \     
          1  6   8  10    
          /  \ /\  /\  / \
         n  n  n n n n  n n
        */


        //RECURSION IP -OP TREE
        /*

        public void DFSLevelOrderPathsKaMaxMinOfNodes (Node root,int level,List<Integer> pathMaxList ,List<Integer> pathMinList)
                                                            --while going top-bottom  
            if(root==null) {return;}                           return at null and start moving up 
            if(pathMaxList.size()==level)                      [7 ,4 ];[7,4] --when we reach a level  add root.val/root.val to max/min at lastindex (top-bottom)
                pathMaxList.add(root.val);                      l0 l1   l0 l1    get the max/min at that level and compare with root val/root.val  and set max/min at that level
                                                                            (we can find max/min here as we do not need to reach extreme right )

            if(root.val >= pathMaxList.get(level)){
                pathMaxList.set(level,root.val)
            } 
        


            DFSLevelOrderPathsKaMaxMinOfNodes(root.left,level+1,pathMaxList,pathMinList);        -- while going left-right
            DFSLevelOrderPathsKaMaxMinOfNodes(root.right ,level+1,pathMaxList,pathMinList);         ''' same as level order
        }

        //OVERLOAD
        public List<Double>  DFSLevelOrderPathsKaMaxMinOfNodes(Node root){
            List<Integer> max = new ArrayList<>();
            List<Integer> min = new ArrayList<>();
            DFSLevelOrderPathsKaMaxMinOfNodes(root,0,pathMaxList,pathMinList);

            return max;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        */

 



 }
    public void DFSLevelOrderAreCousins           (Node root,Node previousNode,int level, int n1 ,int n2 ){
    /*
    DFS LEVEL ORDER
   root-- 7        -->travel left-right ,top-bottom       (DFS ) 
         /  \        and  return whether node1 and node2 are cousins ie same level different parents (level Order)
        4    9       1,10 are cousins , 4,9 are not
       / \    / \     
      1  6   8  10    
      /  \ /\  /\  / \
     n  n  n n n n  n n
    */


    //RECURSION IP -OP TREE
    /*
    public void DFSLevelOrderAreCousins           (Node root,Node previousNode,int level, int n1 ,int n2 )

                                                                            --while going top-bottom  
        if(root==null) {return;}                                               return at null and start moving up 
        if(root.val == n1){                                               
            levelOfNode1 = level;   //levelOfNode1 is global variable          when we reach a level update the level and  parent of node( when yu go l,r retain root.val)  
            if(previousNode!=null) parentOfNode1 = previousNode;  //parentOfNode1 is global variable   
        }                                                                   
  

        if(root.val == n2){
            levelOfNode2 = level;        //levelOfNode2 is global variable
            if(previousNode!=null) parentOfNode2 = previousNode;  //parentOfNode2 is global variable
        }

        //OVERLOAD
        public boolean DFSLevelOrderAreCousins(TreeNode root, int n1 int n2) {
            int levelOfNode1 = 0;
            int levelOfNode2 = 0;
            Node parentOfNode1 = 0;
            Node parentOfNode2 = 0;
            DFSLevelOrderAreCousins(root,root,0,n1,n2);
            return depthOfNode1 == depthOfNode2 && parentOfNode1 != parentOfNode2;
            
        }

        DFSLevelOrderAreCousins(root.left,root,level+1,n1,n2);       -- while going left-right(ie goint top-bottom) 
        DFSLevelOrderAreCousins(root.right,root,level+1,n1,n2);         ''' same as level order
                                                                    store previousNode(allows duplicate node in BT)/previosNode value(allows only unique BT values) then previousNode will be available with us               
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height
    */




}



    //DFSROOTOLEAF(HEIGHT,MAXDEPTH,MINDEPTH OF BINARY TREE)
    /*
    HeightOfBinTree     --> DFSRootToLeafPathsKaMaxNoOfNodes    HeightOfBinTree =  MaxDepthOfBinTree
    MaxDepthOfBinTree  -->DFSRootToLeafPathsKaMaxNoOfNodes
    MinDepthOfBinTree  -->DFSRootToLeafPathsKaMinNoOfNodes

    */
    public void DFSRootToLeafPathsKaNoOfNodesList (Node root ,List<Integer> pathCountList , int pathCount){
          /*
          root-- 7        -->travel left-right ,top-bottom            (DFS)
                /  \         and return no of nodes on path from root to leaf(root to leaf)
               4    9        [4,4,4,4]
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsKaNoOfNodesList (Node root ,List<Integer> pathCountList , int pathCount)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up 
            pathCount = pathCount + 1;                                   1+1+1 --add 1 to pathCount        
            if(root.left == null && root.right == null){                 [3]   --if we are at leaf node add path to node
                pathCountList.add(pathCount);                       
            }

            DFSRootToLeafPathsKaNoOfNodesList(root.left ,pathCountList,pathCount);
            DFSRootToLeafPathsKaNoOfNodesList(root.right ,pathCountList,pathCount);
            pathCount = pathCount -1;                                      --while going bottom-up
                                                                            1+1+1-1--remove 1 from pathCount   
                                                                                    so that while coming down when you add 6 it becomes  
                                                                                    7+4+6 which is another root to leaf path
        }

        //OVERRIDE
        public List<Integer>  DFSRootToLeafPathsKaNoOfNodesList(Node root){
            List<Integer> pathCountList = new ArrayList<>();
            int pathCount = 0;
            DFSLevelOrderPathsKaMaxMinOfNodes(root,pathCountList,pathCount);
            return pathCountList;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */


   }
    public void DFSRootToLeafPathsKaMaxNoOfNodes  (Node root ,int pathCount){
          /*
          root-- 7        -->travel left-right ,top-bottom             (DFS)
                /  \         and return max no of nodes on path from root to leaf(root to leaf)
               4    9        3
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */
      
        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsKaMaxNoOfNodes  (Node root ,int pathCount)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up 
            pathCount = pathCount + 1;                                   1+1+1 --add 1 to pathCount        
            if(root.left == null && root.right == null){       3          if we are at leaf node find the max of all pathCount
                max = Math.max(pathCount,max);  //max is global va              
            } 
            
    
            DFSRootToLeafPathsKaMaxNoOfNodes(root.left ,pathCount);      -- while going left,right
            DFSRootToLeafPathsKaMaxNoOfNodes(root.right ,pathCount);
        
            pathCount = pathCount - 1;                                     --while going bottom-top
                                                                            1+1+1-1 --remove 1 from pathCount   
                                                                                    so that while coming down when you add 1 it becomes  
                                                                                    1+1+1 which is another root to leaf path
        }

        //OVERLOAD
        int max = Integer.MIN_val;
        public int DFSRootToLeafPathsKaMaxNoOfNodes(Node root){
            int pathCount = 0;
            DFSRootToLeafPathsKaMaxNoOfNodes(root,pathCount);
            return max;
        }
        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
                             
  


   }
    public void DFSRootToLeafPathsKaMinNoOfNodes  (Node root ,int pathCount){
          /*
          root-- 7        -->travel left-right ,top-bottom             (DFS)
                /  \         and return min no of nodes on path from root to leaf(root to leaf)
               4    9        3
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */



        //RECURSION IP-OP TREE
        /*

        public void DFSRootToLeafPathsKaMinNoOfNodes  (Node root ,int pathCount
                                                                   --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up 
            pathCount = pathCount + 1;                                   1+1+1 --add 1 to pathCount        
            if(root.left == null && root.right == null){       3         if we are at leaf node find the min of all pathCount
                min = Math.min(pathCount,min);   //min is global var            
            } 
            
    
            DFSRootToLeafPathsKaMinNoOfNodes(root.left ,pathCount);    --while going left,right
            DFSRootToLeafPathsKaMinNoOfNodes(root.right ,pathCount);
        
            pathCount = pathCount - 1;                                  --while going bottom-up
                                                                        1+1+1-1--remove 1 from pathCount   
                                                                                so that while coming down when you add 1 it becomes  
                                                                                1+1+1 which is another root to leaf path
        }

        int min = Integer.MAX_val;
       public int DFSRootToLeafPathsKaMinNoOfNodes(Node root){
             int pathCount = 0;
             DFSRootToLeafPathsKaMinNoOfNodes(root,pathCount);
             return min;}

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
                             


   }
    public void DFSRootToLeafPathsKaSumOfNodesList(Node root ,List<Integer> pathSumList , int pathSum){
          /*
          root-- 7        -->travel left-right ,top-bottom          (DFS)
                /  \         and return sum of nodes on path from root to leaf(root to leaf)
               4    9        [12,17,24,26]
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsKaSumOfNodesList(Node root ,List<Integer> pathSumList , int pathSum)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                  return at null and start moving up 
            pathSum = pathSum + root.val;                             7+4+1 --add root val to pathSum        
            if(root.left == null && root.right == null){             [12]  --if we are at leaf node add path to node
                pathSumList.add(pathCount);                                  
            }  
            
        
            DFSRootToLeafPathsKaSumOfNodesList(root.left , pathSumList,pathSum);  -- while going left-right
            DFSRootToLeafPathsKaSumOfNodesList(root.right , pathSumList,pathSum)
        
            pathSum = pathSum - root.val;                                --while going bottom-top
                                                                            7+4+1 -1 -- remove root val  from pathSum   
                                                                                        so that while coming down when you add 6 it becomes  
        }                                                                               7+4+6 which is another root to leaf path

        public List<Integer>  DFSRootToLeafPathsKaSumOfNodesList(Node root){
            List<Integer> pathSumList = new ArrayList<>();
            int pathSum = 0;
            DFSRootToLeafPathsKaSumOfNodesList(root , pathSumList , pathSum)
            return pathSumList;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
                             
       

    
   }
    public void DFSRootToLeafPathsKaMaxSumOfNodes (Node root ,int pathSum){
          /*
          root-- 7        -->travel left-right ,top-bottom            (DFS)
                /  \         and return max sum of nodes on path from root to leaf(root to leaf)
               4    9        26
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


         
        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsKaMaxSumOfNodes (Node root ,int pathSum)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up 
            pathSum = pathSum + root.val;                               7+4+1 --add root val to pathSum        
            if(root.left == null && root.right == null){      26        if we are at leaf node find the max of all pathSUm
                max = Math.max(max,pathSum)//max is global var                  
            }  
            
        
            DFSRootToLeafPathsKaSumOfNodesList(root.left ,pathSum);   --while going left,right
            DFSRootToLeafPathsKaSumOfNodesList(root.right ,pathSum)
        
            pathSum = pathSum - root.val;                                --while going up
                                                                            7+4+1 -1  remove root val  from pathSum   
                                                                                    so that while coming down when you add 6 it becomes  
                                                                                   7+4+6 which is another root to leaf path

        }

        //OVERLOAD
        int max = Integer.MIN_val;
        public List<Integer>  DFSRootToLeafPathsKaMaxSumOfNodes(Node root){ 
             List<Integer> pathSumList = new ArrayList<>();
             int pathSum = 0;
             DFSRootToLeafPathsKaMaxSumOfNodes(root , pathSum);
             return max;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
                             


   }
    public void DFSRootToLeafPathsKaMinSumOfNodes (Node root ,int pathSum){
          /*
          root-- 7        -->travel left-right ,top-bottom     (DFS)
                /  \         and return min sum of nodes on path from root to leaf(root to leaf)
               4    9        17
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

         
        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsKaMinSumOfNodes (Node root ,int pathSum){                                                       --while going top-bottom  
            
                                                                    --while going top-bottom  
            if(root==null) {return;}                                    return at null and start moving up 
            pathSum = pathSum + root.val;                               7+4+1 --add root val to pathSum        
            if(root.left == null && root.right == null){      17        if we are at leaf node find the min of all pathSUm
                min = Math.min(min,pathSum)//min is global var            
            }  
            
        
            DFSRootToLeafPathsKaMinSumOfNodes(root.left ,pathSum);      --while going left-right
            DFSRootToLeafPathsKaMinSumOfNodes(root.right ,pathSum);
        
            pathSum = pathSum - root.val;                                --while going bottom-up
                                                                        7+4+1 -1  remove root val  from pathSum   
                                                                                    so that while coming down when you add 6 it becomes  
                                                                                    7+4+6 which is another root to leaf path
        }


        //OVERLOAD
        int min = Integer.MAX_val;
       public List<Integer>  DFSRootToLeafPathsKaMinSumOfNodes(Node root){ 
             List<Integer> pathSumList = new ArrayList<>();
             int pathSum = 0;
             DFSRootToLeafPathsKaMinSumOfNodes(root , pathSum);
             return min;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */
                             

   }
    public void DFSRootToLeafPathsKaMaxString    (Node root, String pathSum){  

        /*
          root-- 7        -->travel left-right ,top-bottom                             (DFS)
                /  \         and return  "lexicographically max string"  from "leaf to root" (root to leaf)
               4    9        ie 1-4-7 = "beh" ;   6-4-7 = "geh"  .. ;10-9-8 = "kji" 
              / \    / \         "kji" is lexicographically max string
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */
         
        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsKaMaxString    (Node root, String pathSum)
                                                                    --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up 
            pathSum = pathSum + (char)(root.val + 97);                  'h'+'e'+'b' --add root's equivalent character  val to pathSum  
            if(root.left == null && root.right == null){  'beh'          if we ar at leaf node reverse string and find the max of all pathsum
                String reversePathSum = reverseString(pathSum);;                    
                if(max.compareTo(reversePathSum) < 0 ){//max is a global variable
                    max = reversePathSum;
                }

            }
            
            
            DFSRootToLeafPathsKaMaxString(root.left ,pathSum);         --while going left,right
            DFSRootToLeafPathsKaMaxString(root.right ,pathSum);
            
                                                            
            pathSum = pathSum.substring(0,pathSum.length()-1);          --while going bottom-up
                                                                        'heb'-'b' -- remove root val  from pathSum   
                                                                                    so that while coming down when you add g it becomes  
                                                                                    'heg' which is another root to leaf path
        }

        //OVERLOAD
        String max = "";//StringBuffer path = new StringBuffer("");  -- String max = "" ; String min = "~" explained in conversion 
        public String DFSRootToLeafPathsKaMaxString(Node root) {      
            int pathSum = "";
            DFSRootToLeafPathsKaMaxString(root,pathSum);
            return max;  //return max.toString(); 
        }

        public String reverseString(String s){         //  public StringBuffer reverseStringBuffer(StringBuffer sb)
            String reverseString = "";                 //  StringBuffer reverseStringBuffer = new StringBuffer("");
            for(int i = s.length()-1 ; i >=0;i--){
                reverseString = reverseString + s.charAt(i);  //reverseStringBuffer.append(sb.charAt(i)); 
            }
            return reverseString;
        }

        Time :O(n^2) if it is balanced tree  as we traverse all nodes in tree
                      and we reverse at each traversal
             :O(n^2)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
                      and we reverse at each traversal
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space

        */







    }
    public void DFSRootToLeafPathsKaMinString    (Node root, String pathSum){  

        /*
          root-- 7        -->travel left-right ,top-bottom                           (DFS)
                /  \         and return  "lexicographically min string"  from "leaf to root" (root to leaf)
               4    9        ie 1-4-7 = "beh" ;   6-4-7 = "geh"  .. ;10-9-8 = "kji" 
              / \    / \         "beh" is lexicographically max string
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
        */


         
         //RECURSION IP-OP TREES)
        /*
        public void DFSRootToLeafPathsKaMinString    (Node root, String pathSum){
                                                                    --while going top-bottom  
            if(root==null) {return;}                                     return at null and start moving up 
            pathSum = pathSum + (char)(root.val + 97);                   'h'+'e'+'b' --add root's equivalent character  val to pathSum  
            if(root.left == null && root.right == null){  'beh'          if we ar at leaf node reverse string and find the in of all pathsum
                String reversePathSum = reverseString(pathSum);;                    
                if(min.compareTo(reversePathSum) > 0 ){//min is a global variable
                    min = reversePathSum;
                }

            }
            
            
            DFSRootToLeafPathsKaMaxString(root.left ,pathSum);         --while going left-right
            DFSRootToLeafPathsKaMaxString(root.right ,pathSum);
            
                                                            
            pathSum = pathSum.substring(0,pathSum.length()-1);          --while going up
                                                                        'heb'-'b' -- remove root val  from pathSum   
                                                                                    so that while coming down when you add g it becomes  
                                                                                    'heg' which is another root to leaf path
        }

        //OVERLOAD
        String min = "~";//StringBuffer path = new StringBuffer("");  -- String max = "" ; String min = "~" explained in conversion 
        public String DFSRootToLeafPathsKaMinString(Node root) {      
            int pathSum = "";
            DFSRootToLeafPathsKaMaxString(root,pathSum);
            return min;  //return min.toString(); 
        }

        public String reverseString(String s){         //  public StringBuffer reverseStringBuffer(StringBuffer sb)
            String reverseString = "";                 //  StringBuffer reverseStringBuffer = new StringBuffer("");
            for(int i = s.length()-1 ; i >=0;i--){
                reverseString = reverseString + s.charAt(i);  //reverseStringBuffer.append(sb.charAt(i)); 
            }
            return reverseString;
        }

        Time :O(n^2) if it is balanced tree  as we traverse all nodes in tree
                      and we reverse at each traversal
             :O(n^2)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
                      and we reverse at each traversal
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space

        */







    }
    public void DFSRootToLeafPathsAsString       (Node root,List<String> pathStringList , String  pathString){ 
         /*
          root-- 7        -->travel left-right ,top-bottom           (DFS)
                /  \         and return path from root to leaf as string(root to leaf)
               4    9        ["7->4->1","7->4->6","7->9->8","7->9->10"]
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */



        //RECURSION IP -OP TREE 
        /*
        public void DFSRootToLeafPathsAsString       (Node root,List<String> pathStringList , String  pathString)
                                                                                                                    --while going top-bottom  
            if(root==null) {return;}                                                                                    return at null and start moving up 
            if(root.left == null && root.right == null){                                                               "7->4->1" -- if we are at leaf node add root val + ->  to pathString else add root val to pathString
                pathString =pathString + Integer.toString(root.val) //pathsb.append(Integer.toString(root.val)).append("->")   ["7->4->1"]-- if we are at leaf node add pathString to pathStringList
                pathStringList.add(pathString);                      // pathStringList.add(pathsb.toSTring());                   RETURN AND START MOVING UP AGAIN (AVOID UPDATING OBJECT WHILE COMING UP)     
                                                                    //return;}                                                   (String immutable so no new return , sb is mutable so return )  
            else{                                                                                                                 
                pathString =pathString + Integer.toString(root.val) + "->";  } //pathsb.append(root.val).append("->")
    
            FN(root.left,pathStringList,pathString);               //(new StringBuffer(pathsb))                            --while going left-right
            FN(root.right,pathStringList,pathString);             //(new StringBuffer(pathsb))                               CREATE NEW OBJECT (AVOID SAME OBJECT WHILE COMING BOTTOM-UP)
                                                                                                                            (String immutable so no new obj , sb is mutable so new obj)
            
            pathString = pathString.substring(0,pathString.length()-3); // paths.delete(paths.length()-3,paths.length())       -- while going bottom-up
                                                                    |                                                             "7->4->1" -  ->1" -- remove "->1" from pathString
                                                            'number' ka 1 +  '->' ka 2                                                              so that while coming down you add "->6"
                                                                                                                                                 and it becomes "7->4->6" which is another root to leaf path
        }
        
        //OVERRIDE
        public List<String> DFSRootToLeafPathsAsString(Node root) {  
            List<String> pathStringList = new ArrayList<>();
            String pathString = "";                                           //String pathSb = new STringBuffer("");
            DFSRootToLeafPathsAsString(root,pathStringList , pathString);     //DFSRootToLeafPathsAsString(root,pathStringList , pathsb);
            return pathStringList;
        }
              
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space

        */

    




    }                                                                                                             
    public void DFSRootToLeafPathsAsStringKaSum  (Node root,String  pathString ){
        /*
          root-- 7        -->travel left-right ,top-bottom            (DFS)
                /  \         and return path from root to leaf as string and add them(root to leaf)
               4    9        "741"+"746"+"798"+"7910"
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


    
        //RECURSION IP-OP TREE  
        /*  
        public void DFSRootToLeafPathsAsStringKaSum  (Node root,String  pathString ){
                                                                                                                 
                                                                                                                   --while going top-bottom  
        if(root==null) {return;}                                                                                     return at null and start moving up 
        pathString =   pathString + root.val;               //pathsb.append(Integer.toString(root.val)).             "741"     -- add root val to pathstring
        if(root.left == null && root.right == null){                                                                 741 + 749 -- if we reach leaf convert string to integer and add all pathstring
            sum = sum + Integer.parseInt(pathString);        //sum = sum + Integer.parseInt(pathString.toSTrin() );  RETURN AND START MOVING UP AGAIN (AVOID UPDATING OBJECT WHILE COMING UP) 
                                                            //return;}                                              (String immutable so no new return , sb is mutable so return 
      
        FN(root.left,,pathString);                    //(new StringBuffer(pathsb))                                 --while going left,right
        FN(root.right,pathString);                    //(new StringBuffer(pathsb))                                   CREATE NEW OBJECT (AVOID SAME OBJECT WHILE COMING BOTTOM-UP)
                                                                                                                     (String immutable so no new obj , sb is mutable so new obj)

    
        pathString =pathString.ss(0,pathString.length()-1); // pathsb.delete(paths.length()-1,paths.length())         -- while going bottom-up
                                                                                                                       "741" - "1"  --> remove "1" from pathString
                                                                                                                                       so that while coming down you add "6"
                                                                                                                                       and it becomes "746" which is another root to leaf path
        }
        
        //OVERRIDE
        int sum =0;
        public List<String> DFSRootToLeafPathsAsStringKaSum(Node root) {
            String pathString = "";                                  //String pathSb = new STringBuffer("");
            DFSpathRootToLeafAllPaths(root,pathString);             //DFSpathRootToLeafAllPaths(root,pathsb);
            return sum;
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */

    }
    public void DFSRootToLeafPathsWithTargetSum ( Node root, List<List<Integer>> nodes ,List<Integer> pathSumList, int pathSum,int targetSum){
        /*
          root-- 7        -->travel left-right ,top-bottom           (DFS)
                /  \         and return path from root to leaf which add to target sum(root to leaf)
               4    9        ie [[7,4,6],[7,9,1]] for targetSum = 17
              / \    / \     
             1  6   1  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */


        //RECURSION IP-OP TREE
        /*
        public void DFSRootToLeafPathsWithTargetSum ( Node root, List<List<Integer>> nodes ,List<Integer> pathSumList, int pathSum,int targetSum){
            
                                                                        --while going top-bottom  
            if(root==null) {return;}                                       return at null and start moving up 
            pathSum = pathSum + root.val;                                  7+4+1,[7,4,1]     -- add root val to pathSum and   pathSumList      
            pathSumList.add(root.val);                                     12==12,[[7,4,1]]   -- if we reach leaf then  if pathsum = targetsum add pathSumList to nodes
            if(root.left == null && root.right == null){                   RETURN AND START MOVING UP AGAIN (AVOID UPDATING OBJECT WHILE COMING BOTTOM-UP)
                if(pathSum == targetSum){nodes.add(pathSumList);};
                return;} 
        
            DFSRootToLeafPathsWithTargetSum(root.left , nodes,new ArrayList<Integer>(pathSumList),pathSum,targetSum);   -- while going left-right
            DFSRootToLeafPathsWithTargetSum(root.right , nodes,new ArrayList<Integer>(pathSumList),pathSum,targetSum);    CREATE NEW OBJECT (AVOID SAME OBJECT WHILE COMING BOTTOM-UP)
        
            pathSum = pathSum - root.val;                           -- while going up
            pathSumList.remove(pathSumList.size()-1);                    7+4+1-1,[7,4,1] - [1]  --remove 1 from pathSum and pathSumList
                                                                                                    so that while coming down you add 6
                                                                                                    and it becomes 7+4+6;[7,4,6]  which is another root to leaf path
        }

        //OVERRIDE
        public List<List<Integer>> DFSRootToLeafPathsWithTargetSum(Node root, int targetSum) {
            List<List<Integer>>nodes = new ArrayList<>();
            List<Integer> pathSumList = new ArrayList<>();
            int pathSum =0;
            DFSRootToLeafPathsWithTargetSum(root,nodes,pathSumList,pathSum,targetSum)
            return nodes;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space      
       
         */
        
 
        }
    public void DFSRootToLeafPathsWithTargetSumExists(Node root, int pathSum,  int targetSum){
       /*
          root-- 7        -->travel left-right ,top-bottom                                      (DFS)
                /  \         and return if path exists path from root to leaf which add to target sum(root to leaf)
               4    9        ie 7,4,6] for targetSum = 17 so return true
              / \    / \     
             1  6   1  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

 
        //RECURSION IP-OP TREE
        /* 
        public void DFSRootToLeafPathsWithTargetSumExists(Node root, int pathSum,  int targetSum){           
                                                                    --while going top-bottom  
            if(root==null) {return;}                                    return at null and start moving up 
            pathSum = pathSum + root.val;                         
            if(root.left == null && root.right == null){                 7+4+1   -- add root val to pathSu
                if(pathSum == targetSum)                                 12==12   --if we reach leaf then  if pathsum = targetsum return true else false
                    pathBoolean = true;  //pathBoolean is global var                
            
        
        
            DFSRootToLeafPathsWithTargetSumExists(root.left,pathSum,targetSum) ; -- while going left-right
            DFSRootToLeafPathsWithTargetSumExists(root.right,pathSum,targetSum)

        
            pathSum = pathSum - root.val;                                 -- while going bottom-top 
                                                                            7+4+1-1 --remove 1 from pathSum 
                                                                            so that while coming down you add 6
                                                                            and it becomes 7+4+6 which is another root to leaf path
        }

        //OVERRIDE
        public pathBoolean = false;
        public boolean DFSRootToLeafPathsWithTargetSumExists(Node root, int targetSum) {
            int pathSum = 0;
            DFSRootToLeafPathsWithTargetSumExists(root,pathSum,targetSum);
            return pathBoolean;
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
       */
        
         




        }





    //DFSROOTTOANY
    public void DFSRootToAnyPathsKaAncestors (Node root, List<List<Integer>> nodes ,List<Integer> path , int val){
        /*
         root-- 7      -->Traverse left-right ,top-bottom  (DFS)
               /  \       return ancestors  of nodes excluding the node   (RootToANy)
              4    9      val = 9 so return [7] 
             / \    / \   val = 6 so return [7,4]
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          

        //RECURSION IP -OP TREE
        /*
        public void DFSRootToAnyPathsKaAncestors (Node root, List<List<Integer>> nodes ,List<Integer> path , int val){
                                                                    --while going top-bottom  
            if(root==null) {return;}                                  return at null and start moving up 
            path.add(root.val);                                       [7,4,1]   --add node to last index of path         
            if(root.val == val){                                      [[7,4]] --if we are encounter  node 
                path.remove(path.size()-1)                                     remove the last node as ancestor should not have the node and add path to node
                nodes.add(path);                                                RETURN AND START MOVING UP AGAIN (AVOID UPDATING OBJECT WHILE COMING BOTTOM-UP)
            return;} 

        
            DFSRootToLeaf(root.left , nodes,new ArrayList<Integer>(path),val);   while going left-right
            DFSRootToLeaf(root.right , nodes,new ArrayList<Integer>(path),val);  CREATE NEW OBJECT (AVOID UPDATING OBJECT WHILE COMING BOTTOM-UP)
        
            path.remove(path.size()-1);                                   --while going bottom-up
                                                                            [7,4] --remove node from last index of path 
                                                                                so that while coming down when you add 6 it becomes  
                                                                                [7,4,6] which is another root to any node  path
            Time :O(n) if it is balanced tree  as we traverse all nodes in tree
                :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
            Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
                +
              O(n) we are  using list that takes extra space
        }

        //OVERRIDE
        public List<Integer> DFSRootToAny(Node root,int val){
            List<List<Integer>> nodes = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            DFSRootToAny(root,nodes,path,val);
            return nodes.get(0);
        }

        */
        
 
     }
    


    //DFSANYTOANY(DIAMETER OF BIN TREE)
    /* 
    DiameterOfBinTree  --> DFSAnyToAnyPathsKaMaxNoOfNodes
 
                                                                          
    */
    public void DFSAnyToAnyPathsKaMaxNoOfNodes(Node root){
        /*
         root-- 7      -->Traverse left-right ,top-bottom  (DFS)
               /  \        return any to any path max no of nodes  (AnyToAny)    
              4    9      
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          
        //RECURSION IP -OP TREE
        /*
                    7 l=2;r=4                                  
              2 /          \  4                                                  
               /            \ 
    l=1;r=1  4                1   l=0,r=3
             /  \               \  
         1  /    \ 1             \  2               --return temp1(max(l,r) + 1)
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=1
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \1              
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0
        public int DFSAnyToAnyPathsKaMaxNoOfNodes(Node root){
                                        --while going top-bottom  
            if(root==null) {return 0 ;}   return 0  at null and start moving up 

            int left = DFSAnyToAnyPathsKaMaxNoOfNodes(root.left);   --while going left  , right 
            int right = DFSAnyToAnyPathsKaMaxNoOfNodes(root.right);   left  , right holds the no of nodes of left and right subtre

                                --while coming bottom-up
            temp1 = max(l,r) + 1     required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                    max(l,r) + 1    -- max of no of nodes from left right  + node 4 ka 1
                                                        and pass it to next node above 
            temp2 = l+r+1           required path  passes through our node 4(find the calculation for path through node4 which is our main calcuation)
                                    l+r+1            - no of nodes drom  left + right + node 4 ka 1 

            ans = max(temp,temp2)    max of not passing through node4 and passing through node 4 is answer   
            res = max(res,ans)       max  of all answers                                                     //res is global var                                            
            return temp1 ;           we dont return res but temp1 which is the val we need to pass ahead when node4 is not answer
        }

        public int  DFSAnyToAnyPathsKaMaxNoOfNodes(Node root){
            return DFSAnyToAnyPathsKaMaxNoOfNodes(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */




        //OVERRIDE
        /*
 
        */


    }
    public void DFSAnyToAnyPathsKaMinNoOfNodes(Node root){
        /*
         root-- 7      -->Traverse left-right ,top-bottom  (DFS)
               /  \       return any to any path min no of nodes  (AnyToAny)   
              4    9      
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          

        //RECURSION IP -OP TREE
        /*
                   7 l=2;r=1                                  
              2 /          \  1                                                  
               /            \ 
    l=1;r=1  4                1   l=0,r=1
             /  \               \  
         1  /    \ 1             \  1               --return temp1(min(l,r) + 1)
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=1
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \1              
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0

        public int DFSAnyToAnyPathsKaMinNoOfNodes(Node root)

                                        --while going top-bottom  
            if(root==null) {return 0 ;}   return 0  at null and start moving up 

            int left = DFSAnyToAnyPathsKaMinNoOfNodes(root.left);  --while going left , right  
            int right = DFSAnyToAnyPathsKaMinNoOfNodes(root.right);   left , right  holds no of nodes from left and right subtree

                                --while going bottom-top 
            temp1 = min(l,r) + 1    required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                    min(l,r) + 1    -- min of no of nodes from left right + node 4 ka 1
                                                        and pass ahead to next node 
            temp2 = l+r+1           required path  passes through our node 4(find the calculation for path through node4 which is our main calcuation)
                                    l+r+1            --no of nodes  from left + right + node 4 ka 1 

            ans = min(temp,temp2)   min of not passing through node4 and passing through node 4 is answer   
            res = min(res,ans)      min  of all answers                                                     //res is global var                                            
            return temp1 ;          we dont return res but temp1 which is the val we need to pass ahead when node4 is not answer
        }

        //OVERLOAD
        public int  DFSAnyToAnyPathsKaMinNoOfNodes(Node root){
            return DFSAnyToAnyPathsKaMinNoOfNodes(root);
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */






    }
    public void DFSAnyToAnyPathsKaMaxSumOfNodes(Node root){

        /*
         root-- 7      -->Traverse left-right ,top-bottom t (DFS)
               /  \      return any to any path max sum of nodes
              4    9      
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          



        //RECURSION IP -OP TREE
        /*     
                     7 l=15;r=8                                  
            15  /          \  8                                                  
               /            \ 
    l=8;r=7  4                1   l=0,r=7
             /  \               \  
         8  /    \ 7             \  1               --return  max(max(l,r) + root.val ,root.val) 
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=6
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \1              
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0
        public int DFSAnyToAnyPathsKaMaxSumOfNodes(Node root)
                                        
                                        --while going top-bottom  
            if(root==null) {return 0 ;}   return 0  at null and start moving up 

            int left = DFSAnyToAnyPathsKaMaxSumOfNodes(root.left);    --while going left right  
            int right = DFSAnyToAnyPathsKaMaxSumOfNodes(root.right);    left right  holds sum of node from left and right 

                                                    --while goig bottom-top
            temp1 = max(max(l,r) + root.val ,root.val)  required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                                        max(l,r)+root.val              -- max sumOfNode from left right  + node 4 ka val
                                                        (max(l,r) + root.val ,root.val) -- node4 alone can be greater that path with max sum till node4 as there may be -ve vals along the path so compare root also
                                                                                        and pass ahead to next node 
            temp2 = l+r+root.val                        required path  passes through our node 4(find the calculation for path through node4 which is our main calcuation)
                                                        l+r+root.val                      -- max sumofNodes from left +right + node4 + node 4 ka val

            ans = max(temp,l+r+1)                        max of not passing through node4 and passing through node 4 is answer   
            res = max(res,ans)                           find maximum path of all answers                                              //res is global var                      
    
            return temp1 ;                               we dont return res but temp1 which is the val we need to pass ahead when node4 is not answer
        }

        //OVERLOAD
        public int  DFSAnyToAnyPathsKaMaxSumOfNodes(Node root){
            return DFSAnyToAnyPathsKaMaxSumOfNodes(root);
        }



        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */




    }
    public void DFSAnyToAnyPathsKaMinSumOfNodes(Node root){
        /*
         root-- 7      -->Traverse left-right ,top-bottom  (DFS)
               /  \      return any to any path min sum of nodes
              4    9      
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          


        //RECURSION IP -OP TREE
        /*
                   7 l=4;r=1                                  
             4  /          \  1                                                  
               /            \ 
    l=8;r=7  4                1   l=0,r=1
             /  \               \  
         8  /    \ 7             \  1               --return  min(min(l,r) + root.val ,root.val) 
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=6
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \ 6           
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0

                                    

        public int DFSAnyToAnyPathsKaMinSumOfNodes(Node root)
                                    --while going top-bottom  
            if(root==null) {return 0 ;}   return 0  at null and start moving up 

            int left = DFSAnyToAnyPathsKaMinSumOfNodes(root.left);  --while going left right  
            int right = DFSAnyToAnyPathsKaMinSumOfNodes(root.right);   left right  holds sum of nodes from left , right 

                                                    --while going top-bottom
            temp1 = min(min(l,r) + root.val ,root.val) required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                                    min(l,r)+root.val                 -- min sumOfNode from left  right  + node 4 ka val
                                                    (min(l,r) + root.val ,root.val) -- node4 alone can be greater that path with min sum till node4 as there may be -ve vals along the path so compare root also
                                                                                                    and  pass the val to next node
            temp2 = l+r+root.val                      required path  passes through our node 4(find the calculation for path through node4 which is our main calcuation)
                                                    l+r+root.val                      -- sumofNodes from left + eight  + node 4 ka val

            ans = min(temp,l+r+1)                      min of not passing through node4 and passing through node 4 is answer   
            res = min(res,ans)                         find maximum path of all answers                                              //res is global var                      
    
            return temp1 ;                              we dont return res but temp1 which is the val we need to pass ahead when node4 is not answer
        }

        public int  DFSAnyToAnyPathsKaMinSumOfNodes(Node root){
            return DFSAnyToAnyPathsKaMinSumOfNodes(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */



    }
    public void DFSAnyToAnyPathsUnivalKaMaxNoOfNodes(Node root , Node previousNode){
       
        /*
         root-- 5      -->Traverse left-right ,top-bottom                                        (DFS)
               /  \        return any to any unival path(all nodes along path are same) max no of nodes  (AnyToAny)    
              5    5      
             / \    / \  
             1  6   5  4 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */


        //RECURSION IP -OP TREE
        /* 
             
                   5 l=1;r=2                                   
        1(max+1) /          \  2(max+1)                                                  
               /            \ 
    l=0;r=0  5                5   l=1,r=0
             /  \            /  \  
         0  /    \ 0     1  /    \  0               --  return temp( temp = 0  if(root.val == previousNode.val) { temp =  max(l,r) +1} 
           /      \  (max) /      \                     (previous me niche ate vakt ka node stored rahega hoga)
 l=0;r=0  1  l,r=0 6      5 l,r=0  4 l=0;r=0
                                                      --return 0       


    

        public int DFSAnyToAnyPathsUnivalKaMaxNoOfNodes(Node root , Node previousNode){  
            
                                            --while going top-bottom  
            if(root==null) {return 0 ;}     return 0  at null and start moving up 

            int left = DFSAnyToAnyPathsUnivalKaMaxNoOfNodes(root.left, root);  --while going left right 
            int right = DFSAnyToAnyPathsUnivalKaMaxNoOfNodes(root.right,root);   store previousNode(allows duplicate node in BT)/previosNode value(allows only unique BT values) then previousNode will be available with us               
                                                                                left right holds no of nodes from left,right
                                        --while going bottom-top
            int temp1 = 0;
            int temp2 = 0;
            if(previousNode!=null){
            if(root.val == previousNode.val){  
                temp1 = max(l,r) + 1    required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                        max(l,r) + 1    -- max of no of nodes from left,right  + node 4 ka 1
                temp2 = l+r+1           required path  passes through our node 4(find the calculation for path through node4 which is our main calcuation)
                                        l+r+1           --max no of nodes from left +  right   + node 4 ka 1 

            ans = max(temp,temp2)       max of not passing through node4 and passing through node 4 is answer   
            res = max(res,ans)          max  of all answers                                                     //res is global var                                            
            return temp1 ;              we dont return res but temp1 which is the val we need to pass ahead when node4 is not answer
        }

        //OVERRIDE
        int res = Integer.MIN_val;
        public int DFSAnyToAnyPathsUnivalKaMaxNoOfNodes(Node root) {
            DFSAnyToAnyPathsUnivalKaMaxNoOfNodes(root,root);
            return res;
        }


        */



    }
    

             
    //DFSLEAFTOLEAF
    public void  DFSLeafToLeafPathsKaMaxSumOfNodes(Node root){
        /*
         root-- 7      -->Traverse left-right ,top-bottom  (DFS)
               /  \       return leaf to leaf  path max no of nodes  (LeafToLeaf)    
              4    9      
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          

        //RECURSION IP -OP TREE
        /*
                  7 l=12;r=8                                  
            12  /          \  8                                                  
               /            \ 
    l=8;r=7  4                1   l=0,r=7
             /  \               \  
         8  /    \ 7             \  1               --return  max(l,r) + root.val   
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=6
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \1              
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0
    public int  DFSLeafToLeafPathsKaMaxSumOfNodes(Node root)


                                        --while going top-bottom  
        if(root==null) {return 0 ;}     return 0  at null and start moving up 

    

        int left = DFSLeafToLeafPathsKaMaxSumOfNodes(root.left);   --while going left-right  
        int right = DFSLeafToLeafPathsKaMaxSumOfNodes(root.right);   left-right  holds sum of nodes from left and right 

                                                --while coming up 
                                                  NEED FOR NULL CHECK:root.left , root.right  being   null yeild different results 
                                                  if left is null then left returns 0 , right returns sumofNodes(+ve/-ve) ;for +ve max(l,r) takes sumOfNodes of right where leaf present no issue ; for -ve max(l,r) takes sumOfNodes of left but leaf present on right                                                                                                                             
        if(root.left == null){                    if left is null find sumOfNodes on right subtree + root val 
          return right+root.val }                 if right is null find sum of nodes on left subtree + root val
       if(root.right == null){                    and return else wont encounter base
          return left + root.val}                        
         OR                                      
        if(root.left==null||root.right==null)      if left or right is null find max of sumOfNodes on left and right subtree + root val  
            return Math.max(left,right)+root.val}  This is "INVALID" as sumofNodes can be -ve unlike noOfNodes so taking max here we may end up on the null node where leaf is not present                              
                                           

        temp1 =max(l,r) + root.val                 required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                                   max(l,r)+root.val                   --  max   sumofNodes  from left,right + node 4 ka  val 
                                                  (max(l,r) + root.val ,root.val)X  -- root alone can be greater that the sum of l,r,root as there may be -ve vals so compare root also 
                                                                                                 BUT  root is not a leaf node so we shouldnt compare with root.val
                                                                                                 and pass the val to next node 
        temp2 = l+r+root.val                       required path  pass through our node 4(node 4 bolega mai hi answer nahi hu )
                                                   l+r+root.val                       --  max   sumofNodes from left + right + node 4 ka  val 
        
        ans = temp2                                 max of not passing through node4 and passing through node 4 is answer  BUT temp may have a path sum from leaf to any node so if temp becomes greater ans might store leaf to any node which is not as require                                                                                         
        res = max(res,ans)                          max path of all answers                                              
 

        return temp1 ;                              we dont return res but temp which is the val we need to pass ahead
       }

       //OVERRIDE
        public int  DFSLeafToLeafPathsKaMaxSumOfNodes(Node root){
            return DFSLeafToLeafPathsKaMaxSumOfNodes(root);
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */






    }
    public void  DFSLeafToLeafPathsKaMinSumOfNodes(Node root){
        /*
         root-- 7      -->Traverse left-right ,top-bottom  (DFS)
               /  \       return leaf to leaf  path min no of nodes  (LeafToLeaf)    
              4    9      
             / \    / \  
             1  6   8  10 
           /  \ /\  /\  / \
          n  n  n n n n  n n

        */
          

        //RECURSION IP -OP TREE
        /*
                   7 l=11;r=1                                  
             11  /          \  1                                                  
               /             \ 
    l=8;r=7  4                1   l=0,r=1
             /  \               \  
         8  /    \ 7             \  1               --return min(l,r) + root.val 
           /      \               \
 l=0;r=0  8  l,   7 l=0,r=0        1 l=0;r=6
         /\       /\              /\
       0/  \ 0  0/  \0          0/  \ 6           
        n  n    n    n           n   6 l=0,r=0
                                  0  /\ 0
                                    /  \
                                    n   n             -- return 0
    public int  DFSLeafToLeafPathsKaMinSumOfNodes(Node root)
                                    
                                        --while going top-bottom  
        if(root==null) {return 0 ;}       return 0  at null and start moving up 


        int left = DFSLeafToLeafPathsKaMaxSumOfNodes(root.left);  -- while going left-right
        int right = DFSLeafToLeafPathsKaMaxSumOfNodes(root.right);   left-right holds sum from left and right subtree


                                         --while going bottom-top
                                           NEED FOR NULL CHECK:Root.left,root.right(outside recursive call)  either being null yeild different result in code ;so  add null check where either one of them is null 
                                           if left is null then left returns 0 , right returns sumofNodes(+ve/-ve) ;for +ve min(l,r) takes sumOfNodes of left where leaf not present so issue ; for -ve min(l,r) takes sumOfNodes of right  leaf present on right so no issue                                                                                                                            
        if(root.left == null){             if left is null find sumOfNodes on right subtree + root val 
          return right+root.val }          if right is null find sum of nodes on left subtree + root val
       if(root.right == null){             and return else wont encounter base
          return left + root.val}                        
         OR                                      
        if(root.left==null||root.right==null)       if left or right is null find min of sumOfNodes on left and right subtree + root val  
            return Math.min(left,right)+root.val}   This is "INVALID" as sumofNodes can be -ve unlike noOfNodes so taking min here we may end up on the null node where leaf is not present                              
                                                


        temp1 =min(l,r) + root.val          required path does not pass through our node4(find the calculation for path till node4 which we will pass ahead)
                                             min(l,r)+root.val                 --  min  sumofNodes  from left,right  + node 4 ka  val 
                                            (min(l,r) + root.val ,root.val)X  -- root alone can be greater that the sum of l,r,root as there may be -ve vals so compare root also
                                                                                 BUT  root is not a leaf node so we shouldnt compare with root.val
                                                                                 and pass the val ahead to next node
        temp2 = l+r+root.val                required path  pass through our node 4(node 4 bolega mai hi answer nahi hu )
                                             l+r+root.val                       --   sumofNodes from left + right + node 4 ka  val 
        
        ans = temp2                         min of not passing through node4 and passing through node 4 is answer  BUT temp may have a path sum from leaf to any node so if temp becomes greater ans might store leaf to any node which is not as require                                                                                         
        res = min(res,ans)                  max path of all answers                                              
 


        return temp1 ;                       we dont return res but temp which is the val we need to pass ahead
       }

        public int  DFSLeafToLeafPathsKaMinSumOfNodes(Node root){
            return DFSLeafToLeafPathsKaMinSumOfNodes(root);
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
              +
              O(n) we are  using list that takes extra space
        */





    }


    

    //CONSTRUCT
    public void binaryTreeConstructionFromPreInOrder(int[] preorder ,int[] inorder , int inorderLeft, int inorderRight) {
        /*
        Question
        3   PREORDER:[3,9,20,15,7] -- Given preorder and inorder arrays with "UNIQUE valS"
        /\  INORDER :[9,3,15,20,7]    return a binary tree
        9 20
           /\
          15 7
        */
        
        //RECURSION IP -OP TREE
        /*
        PREORDER:[3,9,20,15,7] -->PREORDER ARRAY WILL FORM NODES; INORDER ARRAY WILL BE USED TO DETERMINE LEFT AND EIGHT SUBTREE 
        INORDER :[9,3,15,20,7]    Form preorder form node  3
                                  from inorder  left of 3 ie 9 is left subtree ; right of 3 ie 15,20,7 is right subtree
                      
                                  Form preorder form node  9
                                  From inorder  left of 9 ie - is left subtree ; right of 9 ie 3,15,20,7 is right subtree

                                  Form preorder form node  20
                                  From inorder  left of 20 ie3,9,15 is left subtree ; right of 20 ie 7 is right subtree

                                  Form preorder form node  15
                                  From inorder  left of 15 ie 9,3, is left subtree ; right of 15 ie 20,7 is right subtree


                                  Form preorder form node  7
                                  From inorder  left of 7 ie 9,3,15,20, is left subtree ; right of 7 ie - is right subtree


        public Node binaryTreeConstructionFromPreInOrder(int[] preorder ,int[] inorder , int inorderLeft, int inorderRight) {
                                                                                                         -->PREORDER ARRAY WILL FORM NODES
            int rootval = preorder[preorderIndex++];                                             every val in preorder array  will form a root node //preorderIndex is a global variable
            Node root = new Node(rootval);                                                       

                                                                                                -->INORDER ARRAY WILL BE USED TO DETERMINE LEFT AND EIGHT SUBTREE  
            int inorderRoot = inorderMap.get(rootval);                                             find the rootval in inorder array
            root.left = binaryTreeConstruction(preorder,inorder, inorderLeft, inorderRoot - 1);    left side of rootval will be leftsubtree;
            root.right = binaryTreeConstruction(preorder,inorder, inorderRoot + 1, inorderRight);  right side of rootval will be rightsubtree
            return root;
        }

        //OVERRIDE
        int preorderIndex;
        Map<Integer, Integer> inorderMap;
    
        public Node binaryTreeConstruction(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            inorderMap= new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);}

            return arrayToTree(preorder,inorder 0, inorder.length - 1);
           


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree(all vals in array)
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree(all vals in array)
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        DFSPreOrder:  because you see root;then go to left subtree;then go to right subtree
        */
        


 
    }
    public void binaryTreeConstructionFromPostInOrder(int[] postorder ,int[] inorder , int inorderLeft, int inorderRight) {
        /*
        Question
        3   POSTORDER:[9,15,20,7,3] -- Given postorder and inorder arrays with "UNIQUE valS"
        /\  INORDER :[9,3,15,20,7]    return a binary tree
        9 20
           /\
          15 7
        */
        
        //RECURSION IP -OP TREE
        /*
        POSTORDER:[9,15,20,7,3] -->POSTORDER ARRAY WILL FORM NODES; INORDER ARRAY WILL BE USED TO DETERMINE LEFT AND EIGHT SUBTREE 
        INORDER :[9,3,15,20,7]    Form postorder form node  3
                                  from inorder  right of 3 ie 15,20,7 is right subtree; left of 3 ie 9 is left subtree 
                      
                                  Form postorder from node  7
                                  from inorder  right of 7 ie - is right subtree; left of 7 ie 9,3,15,20 is left subtree 

                                  so on
                      

        public Node binaryTreeConstructionFromPostInOrder(int[] postorder ,int[] inorder , int inorderLeft, int inorderRight)
                                                                                                -->PREORDER ARRAY WILL FORM NODES
            int rootval = preorder[postorder--];                                             every val in preorder array  will form a root node
            Node root = new Node(rootval);                                       

                                                                                                -->INORDER ARRAY WILL BE USED TO DETERMINE LEFT AND RIGHT SUBTREE  
            int inorderRoot = inorderMap.get(rootval);                                           find the rootval in inorder array
            root.right = binaryTreeConstruction(postorder,inorder, inorderRoot + 1, inorderRight);  right side of rootval will be rightsubtree
            root.left = binaryTreeConstruction(postorder,inorder, inorderLeft, inorderRoot - 1);    left side of rootval will be leftsubtree;
            return root;
        }

        //OVERRODE
        int preorderIndex;
        Map<Integer, Integer> inorderMap;
    
        public Node binaryTreeConstruction(int[] postorder, int[] inorder) {
            postorder = postorder.length;
            inorderMap= new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);}

            return arrayToTree(postorder,inorder 0, inorder.length - 1);
            
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree(all vals in array)
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree(all vals in array)
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
                :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        DFSPreOrder:  because you see root;then go to left subtree;then go to right subtree


        */
     
  
 

 
    }
    public void binaryTreeConstructionFromPreOrderWithNull(String[] preOrder){
         /*
        Question
        3   PREORDER:["3,"9","null","null","20","15","null","null","7","7"] -- Given preorder array with null 
        /\                                                                    return a binary tree
        9 20
           /\
          15 7
        */
        
        //RECURSION IP -OP TREE
        /*
        int preOrderIndex =0;
        public TreeNode binaryTreeConstructionFromPreOrderWithNull(String[] preOrder){
                                                                              --while going top-dowm
            if(preOrder[preOrderIndex].equals("null")){                         if value is null 
                preOrderIndex++;                                                  increment index 
                return null;                                                      return null and mpve tp node above 
            }
            int rootVal = Integer.valueOf(preOrder[preOrderIndex++]);           create a root node from preOrderIndex  
            TreeNode root = new TreeNode(rootVal);

                                                                                 --while going top-down
            root.left = binaryTreeConstructionFromPreOrderWithNull(preOrder);      connect value returned by left and right
            root.right = binaryTreeConstructionFromPreOrderWithNull(preOrder);     return root
 
                                                                                 --while going bottom-top                                                               
            return root;                                                           return root
        }

        Time :O(n) if it is balanced tree  as we traverse all nodes in tree(all vals in array)
             :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree(all vals in array)
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
             :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
        DFSPreOrder:  because you see root;then go to left subtree;then go to right subtree
        
        */


        
        

        

        
    }
    public void binaryTreeSerializeDeserialize(){
        /*
        Question
        3          Serialize and deserialize a BT with smallest encoded string
        /\         Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file 
        9 20       Deserialization is converting back that data structire
           /\
          15 7    
        */

        /*
        Binary tree cab be serialized using  DFSpreInOrdeOrder ;  DFSPostInOrder  ; DFSPreOrderWithNull 
        but DFSPreOrderWithNulll will give us the smallest encoded string hence use  DFSPreOrderWithNull

        class binaryTreeSerializeDeserialize{
            public String serialize(Node root) {
                List<String> res = new ArrayList<>();          --Convert BT to list using DFS PreOrder 
                DFSPreOrder(root,res);                           and then convert list of integer to unique string(Look in Java/Object/Unique )

                StringBuilder sb= new StringBuilder(""); a   
                for(String s: res){                                 
                    sb.append(s);
                    sb.append("#");
                }
                
                return sb.toString(); 
            }


            public TreeNode deserialize(String s) {
                String[] preOrder = s.split("#");                                    --Convert unique string to arr and construct BT from arr
                return binaryTreeConstructionFromPreOrderWithNull(preOrder);
            }

            Time :O(n) for both serialise deserialise as we travel all nodes in tree
            Space:O(n) for both serialise deserialise as we store  all nodes of tree in String
        }
        
        
        */
    }







    
}


