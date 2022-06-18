package SRC.BINARYTREE;



//BAT DEFN(DUE TO DEFN BAT HAS SOME METHODS DIFFERENT FROM BST )
/*

SAME AS BT


*/

//BAT CODING
/*
SAME AS BT
+
LEFTNODE <(! <=)ROOTNODE <(! <=) RIGHTNODE
ALL SUM SAME AS BST 

COMPLETE TREE
MaxNoOfNode  = MaxNoOfNodesOnLeftMostTree                                           EG DFSPrePostInOrderMaxNoOfNodeI,DFSPrePostInOrderMaxNoOfNodeII
NoOfNodes    =  2 ^leftHeight+1(for a node below which we have perfect bin tree)    EG DFSPrePostInOrderNoOfNodeI,DFSPrePostInOrderNoOfNodeII
              = left + right +1 for a node below which we have complete tree) 

NOTE:DIFFERENCES IN TIME,SPACE COMPLEXITRIES CAUSED BY THESE PROPERTIES EXPLAINED IN RECURSION OF EACH METHOD 

*/



public class BinaryAVLTree {
    /*
    BINARY AVL TREE
              7      -->each node has max 2 children
             /  \      lefnode < rootnode < rightnode  ; so entire left subtree < right subtree Tree must be  balanced
            4    9     tree must be balanced
           / \    / \
           1  6   8  10
         /  \ /\  /\  / \
        n  n  n n n n  n n
     */


    
    //NODE CLASS
    private class Node {
        /*
           val, ht
         ---------
          lc |  rc

         */
        private int val;
        private int ht;
        private Node left;
        private Node right;
        private Node() {//this.val=0; this.ht =0 ; this.left=null;this.right=null(constructor gives default values)
        }
        private Node(int val) { this.val = val;// this.ht =0 ; this.left=null;this.right=null(constructor gives default values)
         }
        private Node(int val,int ht) { this.val = val; this.ht =0 ;// this.left=null;this.right=null(constructor gives default values)
        }
        private Node(int val, Node left, Node right) {this.val = val;this.left = left;this.right = right;}




    }
    //CONSTRUCTOR                 //INITIALISING ROOT
    private Node root;           //BinAVLTree Construction:-->Compiler will call className obj = new ClassName() ; obj.methodName() so you must initialise root with default value in constructor of class 
    public BinaryAVLTree(){     // BinAVLTree Methods     -->Compiler will call className obj = new ClassName() ; obj.methodName(new Node()) so compiler initialises root
        root = null;
    }                       
                                
                                 //RETURN NODES
                                 //return new Node()                  -- returns Node with value=0,ht=0 ,left =null,right=null
                                 //return new Node(val)               -- returns Node with value=value,ht=0,left =null,right=null
                                 //return new Node(val,ht)            -- returns Node with value=value,ht=ht,left =null,right=null
                                 //return new Node(val,ht,left,right) -- returns Node with value=value,ht=ht,left =left,right=right
                                 //return root                        -- return root along with its subtree vals
    
                          





    private class Helper {
        //CHECKING TREE CONDITION: BALANCEFACTOR, ISLEFTHEAVY,ISRIGHTHEAVY
        private int     balanceFactor(Node node) {
        /*
                7   -->ht(leftnode) - ht(rightnode)
            /  \
            4    9
            / \
            1  6

            */
            if(node == null){ return 0; }
            return ht(node.left) - ht(node.right);
        }
        private boolean isLeftHeavy(Node node) {
        /*

            7   -->ht(leftnode) - ht(rightnode) > 1
        /  \
        4    9
        / \
        1  6

            */
            return balanceFactor(node) > 1;
        }
        private boolean isRightHeavy(Node node) {
        /*
        RIGHTHEAVY
            7   -->ht(leftnode) - ht(rightnode) < 1
        /  \
        4    9
            / \
            1  6

            */

            return balanceFactor(node) < -1;
        }
        //CHANGING TREE COND : SET ht , ROTATELEFT, ROTATERIGHT,
        private void setHeight(Node node) {
        /*
        val.h -- set the ht of node using 1 + Math.max(ht(node.left), ht(node.right))
        l r
            */

            node.ht = 1 + Math.max(ht(node.left), ht(node.right)); }
        private Node rotateLeft(Node root) {
        /*
        root-- 1
                \
        newroot --2     -->    newroot--  2       -->return newRoot
                    \           set ht    /  \
                    3                   /    \
                                root --1      3
                                set ht
            ie root ko uthake left me daal aur jiske across left me dala use return kar
            */
            var newRoot = root.right;
            root.right = newRoot.left;
            newRoot.left = root;

            setHeight(root);
            setHeight(newRoot);

            return newRoot;
        }
        private Node rotateRight(Node root) {
            /*
            root-- 1
                    /
        newroot --2     -->    newroot--  2    -->return newRoot
                /             set ht    /  \
                3                      /     \
                                    3       1 -- root
                                                    set ht
            ie root ko uthake right  me daal aur jiske across righ  me dala use return kar
            */

            var newRoot = root.left;
            root.left = newRoot.right;
            newRoot.right = root;

            setHeight(root);
            setHeight(newRoot);

            return newRoot;
        }
        //BALANCING TREE BY CHECKING AND CHANGING
        private Node balance(Node root) {
        /*
        LEFTHEAVY
        root- 16
            / bf of 5 < 0
            5  ------------>       5  ---------> 7
            \  r.left =  rl(5)   /    rr(16)    / \
            7                  7                5   16
                                /
                                16--root
        RIGHTHEAVY
        root-5
                \   bf of 16 > 0
                16  -------------------->  root--5 ---------->    7
                /     r.right = rr(16)              \   rl(5)    /  \
            7                                     7         5     1
                                                    \
                                                    1

            */
            if (isLeftHeavy(root)) {
                if (balanceFactor(root.left) < 0)
                    root.left = rotateLeft(root.left);//additional left rotate
                return rotateRight(root);
            }

            else if (isRightHeavy(root)) {
                if (balanceFactor(root.right) > 0)
                    root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
            return root;
        }
        //HEIGHT
        private int ht(Node node) {
            /*
            ht
                    7   -->return ht stored in node
                    /  \     //EDGE CASE : node is null return -1
                4    9
                / \    / \
                1  6   8  10
                /  \ /\  /\  / \
            n  n  n n n n  n n

            */       
                //EDGE CASE
            if (node == null) {
                return -1; }

            return node.ht;

        
        }
        


    }




    //DFSPREPOSTORDER
    /*
    HeightOfBinTree   -->DFSPrePostInOrderMaxNoOfNode
     */
    public void DFSPrePostInOrderNoOfNode(Node root ,int val){
        /*
          root-- 7        -->travel travel left-right;top-bottom(DFS)
                /  \         and return no of nodes(root to leaf)
               4    9        7
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n

         */
        
        //RECURSIVE IP-OP TREE
        /* 
        WHILE COMING BOTTOM-UP YOU NEED RETURN VALUE(RET TYPE) -->RETURN VALUE WILL  CARRY LEFT SUBTREE IN LEFT AND RIGHT SUBTREE IN RIGHT 
        */
    
        //RECURSION IP-OP TREE
        /* 

                      4  l=3,r=2                          
return 2^lh-1 -- 3 /         \  2                                                      
                 /            \ 
                2              6   l=1,r=0                                            nr = we don reach  here upar se hi kalti 
              /  \             /      
             /    \          1/            --return left + right + 1
            /      \         /        
    l,r=nr 2       1 lr=nr  3 l=0,r=0           
                                          -- return 0
                                                   
        public int DFSPrePostInOrderNoOfNode(Node root) {
                                                                --while going top-bottom  
            if (root == null) {return 0;}                           return 0 at null and  start moving up                
            int leftHeight =leftHeight(root);                       if leftheight and rightheight are equal means below this node we have a perfect bin tree 
            int rightHeight = rightHeight(root);                      return  no of nodes= 2^leftHeight-1 and start moving up 
            if (leftHeight == rightHeight) { 
                return (int)Math.pow(2,leftHeight)-(int)1;} 
            
            
            int left = DFSPrePostInOrderNoOfNode(root.left);     --while going left-right
            int right = DFSPrePostInOrderNoOfNode(root.right);      left,right holds no of nodes on left subtree

            return left + right + 1;                               --while going bottom-top
                                                                    no of nodes on letf + right+1
                                                                    pass to next node
        }

        //LEFTHEIGHT
        private int leftHeight(TreeNode root) {    
            if(root == null){
                return 0;
            }
            int left = leftHeight(root.left);
            return left + 1;
         }

        //RIGHTHEIGHT
        private int rightHeight(TreeNode root) {    
            if(root == null){
                return 0;
            }
            int right = rightHeight(root.right);
            return right + 1;
        }
        


        //OVERLOAD
        public int DFSPrePostInOrderNoOfNode(Node root){
           return DFSPrePostInOrderNoOfNode(root);
        }
       

        Time :O(logn*logn)  if it is balanced tree  as worst case we traverse upto leaf node only  unbalanced part and not balanced part = O(logn) 
                            and at each node we find left height or right height = O(logn) 
            :O(logn*logn)  as tree cant be unbalanced
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(log n) as tree cant be unbalanced

        //BST:You have to travel top-bottom left-right(all nodes) and find max Node         Time:O(n)      
        //BAT:You have to travel  top-bottom unbalanced part and find height at each node  Time:O(longn * logn) < O(n)

        */

    }
    public void DFSPrePostInOrderInsert(Node root ,int val){
        /*
        root-- 4       -->Travel left -righ ; top bottom (DFS)
                /  \        and insert node to mantain BST 
                2     5      and retur root [4,2,1,3,5,6,7] 
            / \    / \    NOTE : WE INSERT AT LEAF NODE ONLY SO NO NEED TO WORRY ABOUT MIDDLE INSERTION IN MIDDLE
            1  3   6  7            EG: Look in VISUALISATION-->BINARY SEARCH TREE
            /  \ /\  /\  / \
            n  n  n n n n  n n

            */
        
        //RECURSIVE IP-OP TREE
        /*
        WHILE COMING BOTTOM-UP YOU NEED RETURN VALUE(RET TYPE) -->RETURN VALUE WILL  CARRY LEFT SUBTREE IN LEFT AND RIGHT SUBTREE IN RIGHT 
        */

        //RECURSIVE IP-OP TREE
        /*

        
        Consider Inserting   5
                    4 l=2N;r=7N                                 
                /          \  7N                                                  
               /            \ 
              2              7   l=5N r=8N
             /   \          /    \                     -- return balanced root  
            /     \      6N/      \  8N                    
           /       \      /        \
          1         3     6 l,r=5N  8 l=6N;r=6N
                          /                           -- return new Node(val)
                         /
                         5 INSERT


        public Node DFSPrePostInOrderInsert(Node root,int val) {
                                                               --while coming bottom-top
        if(root == null){                                       return  new Node(val)  at null and move up
            return new Node(val);}                               pass to next node                 
              
       Node left =  null;
       Node right = null;
       if(root.val > val){                                      --while coming left,right 
           left= DFSPrePostInOrderInsert(root.left,val);        if root val > val  move left;if root val < val move right ( (left <(!<=)root<(!<=) right so left subtree < right subtree) 
           root.left = left } -\                                   left,right hold   left and right subtree 
        if(root.val < val){     \--------------------------------\                                
            right = DFSPrePostInOrderInsert(root.right,val);    \
            root.right = right} -----------------------------------> while coming top bottom 
                                                                  /   root.left = left  
                                                                 /   root.right = right
        return helper.balance(root)   ------------------------       return  helper.balance(root) and  pass to next node 
        }

        //OVERRIDE
        public void DFSPrePostInOrderInsert(int val) {
            return  DFSPrePostInOrderInsert(root, val);
        }

        Time :O(log2 n) if it is balanced tree  as we throw half nodes
            :O(log2 n) as it cannot be unbalanced tree 
        Space:O(h)  =O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) =O(log2 n) as it cannot be unbalanced tree 

        //BST:You have to travel  top-bottom left or right  and insert node acc to BST property                  Time:O(log2 n) /O(n)
        //BAT:You have to travel  top-bottom left or right  and insert node acc to BST property and also balance Time:O(log2 n) /O(log2 n)


         */
        
    }

    //DFSROOTTOLEAF
    public void DFSRootToLeafMaxNoOfNodes(Node root){
        /*
          root-- 7        -->travel travel left-right;top-bottom            (DFS)
                /  \         and return max no of nodes on path from root to leaf(root to leaf)
               4    9        3
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */



        //RECURSION  IP-OP TREE
        /* 
        public void DFSPrePostInOrderMaxNoOfNode(Node root){
                                                                --while going top-bottom  
            if (root == null){return;}                            return at null and  start moving up          
            pathCount = pathCount + 1;//pathcount is global var   add 1 to pathcount 
            
            DFSPrePostInOrderNoOfNodes(root.left);                 --while going left-right
                                                                    go left only(complete tree so MaxNoOfNode = MaxNoOfNodesOnLeftMostTree)
        }

        //OVERLOAD
        int pathCount = 0;  
        public void DFSPrePostInOrderNoOfNodes(Node root){
            DFSPrePostInOrderNoOfNodes(root);
            return pathCount;

         }

        Time :O(log4 n) if it is balanced tree  as we traverse only left 
            :O(log4 n) as tree cant be unbalanced
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(log n) as tree cant be unbalanced
    
        //BST:You have to travel top-bottom left-right(all nodes) and find max Node           Time:O(n)      
        //BAT:You have to travel  top-bottom left (only left side) and find max Nodes       Time:O(log4 n)


        
         */


         
        //RECURSION IP-OP TREE
        /* 

        public int DFSPrePostInOrderMaxNoOfNode(Node root){
                                                                --while going top-bottom  
            if (root == null){return 1;}                           return 0 at null and  start moving up          

            int left = DFSPrePostInOrderNoOfNodes(root.left);    --while going left-right
                                                                    go left only(complete tree so MaxNoOfNode = MaxNoOfNodesOnLeftMostTree)
                                                                    left holds no of nodes on left subtree
                                                                
                                                                --while going bottom-top
            return left +1;                                       no of nodes on letf + 1
                                                                pass to next node
        }

        //OVERLOAD
        public void DFSPrePostInOrderNoOfNodes(Node root){
            return DFSPrePostInOrderNoOfNodes(root);
         }


        Time :O(log4 n) if it is balanced tree  as we traverse only left 
            :O(log4 n) as tree cant be unbalanced
        Space:O(h) = O(log n) if it is balanced tree  as we traverse entire height 
            :O(h) = O(log n) as tree cant be unbalanced

        //BST:You have to travel top-bottom left-right(all nodes) and find max Node           Time:O(n)      
        //BAT:You have to travel  top-bottom left (only left side) and find max Nodes       Time:O(log4 n)
 
        */



    }


 






 
 



}
