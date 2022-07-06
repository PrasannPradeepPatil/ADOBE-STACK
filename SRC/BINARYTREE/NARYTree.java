package SRC.BINARYTREE;
import java.util.*;

//NARY TREE DEFINATIONS
/*
1.NARY TREE
EACH NODE HAS N CHILDREN;  


2.NARY  TEST CASES
[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14] --> nodes are level wise ; each group of children sepereate by null

            1   
        /   |   \   \
       2    3    4    5
       |    /\    |    /\
       n   6  7   8    9 10
           | |   |    |   |
           n 11  12   13  null
             |
             14
*/

//NARY CODING
/*
SAME AS BT 
+
for(var Node : root.children){  OR for(int i=0 ; i < root.children.size();i++){ -->while going left-right
    fn(Node)                           fn(root.children.get(i));                   while going left-right  through children
}                                                                                  [For every iteration entire recursive tree is called]
return max(c1,c2,c3...cn) +1   -->max(l,r) + 1 ke badle  
                                 int max = 0                 -->INITIALISE MAX , MIN TO 0 NOT Integer.MAX_VALUE/Integer.MIN_VALUE bBECAUSE IN END YOU ARE USINFG THIS MAX VALUE FOR MAX + 1
                                 for(){max(c1,c2...cn)}         EG:DFSPrePostOrderMaxNoOfNodeII
                                 return max+1      

*/

            




public class NARYTree {


    //NODE CLASS
    class Node {
        /*
           val, ht
         ---------
          [N1,N2,N3,....]

        */
        private int val;
        private List<Node> children;
        private Node() {//this.val = 0;this.children = null;(compiler initialises default value )
        }
        private Node(int val) {this.val = val;//this.children = null;(compiler initialises default value )
        }
        public  Node(int val, List<Node> children) {this.val = val;this.children = children;}
    }
    //CONSTRUCTOR                 //INITIALISING ROOT
    private Node root;           //NARYTree Construction:-->Compiler will call className obj = new ClassName() ; obj.methodName() so you must initialise root with default value  in constructor of class 
    public NARYTree(){          // NARYTree Methods     -->Compiler will call className obj = new ClassName() ; obj.methodName(new Node()) so compiler initialises root 
        root = null;
    }                       
                                
                                 //RETURN NODES
                                 //return new Node()               -- returns Node with value=0 ,children =null
                                 //return new Node(val)            -- returns Node with value=value,children =null
                                 //return new Node(val,new AL<>()) -- returns Node with value=value,children =AL
                                 //return root                     -- -- return root along with its subtree vals
    
                          


    //TRAVERSAL
    public void DFSPreOrder   (Node root , List<Integer> nodes){
        /*
            1                  -->PREORDER:  
        /   |   \   \            Top-bottom,Left-Right(ROOT,LEFT,RIGHT)-->[1,2,3,6,7,11,14,4,8,12,5,9,13,10]   
       2    3    4    5          Top-bottom,Right-Left(ROOT,RIGHT,LEFT)-->[1,5,10,9,13,4,8,12,3,7,11,14,6,2] 
       |    /\    |    /\
       n   6  7   8    9 10      POSTORDER
           | |   |    |   |      Bottom-top,Left-Righ;(LEFT,RIGHT,ROOT) -->[2,6,14,11,7,3,12,4,8,13,9,10,5,1] 
           n 11  12   13  null   Bottom-top ;Right-Left(RIGHT,LEFT,ROOT)-->[10,13,9,5,12,8,4,14,11,7,6,3,2,1]
             |
             14
            
       */
 
        //RECURSION IP-OP TREE
        /*  
        public void DFSPreOrder   (Node root , List<Integer> nodes){
            //LEFT-RIGHT;TOP-BOTTOM           
                                                        --while going top-bottom  
            if (root == null){return;}                    return at null and  start moving up                  
            nodes.add(root.val)                            add nodes to list   
            
            for(int i =0 ; i < root.children.size();i++) --while going left-right through children
                DFSPreOrder(root.children.get(i),nodes)             


            // RIGHT-LEFT;TOP BOTTOM 
                                            --while going top-bottom  
            if (root == null){return;}      return at null and  start moving up                  
            nodes.add(root.val)             add nodes to list   
                                                        
            for(int i =root.children.size()-1 ; i >=0 ;i--) --while going right-left through children
                DFSPreOrder(root.children.get(i),nodes)   
        }
        
        //OVERRIDE
        public List<Integer> DFSPreOrder(Node root){
            List<Integer> list = new ArrayList<Integer> ;
            DFSInOrder(Node root ,list)
            return list;
        }
            
         Time :O(n) if it is balanced tree  as we traverse all nodes in tree
              :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
         Space:O(h) = O(logk n) if it is balanced tree  as we traverse entire height and k is approx no of children 
               :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
               +
               O(n) we are  using list that takes extra space

          */
     
        //ITERATIVE
        /*        
                                      //STACK                                           
        root--   7                              
                /  \                         1                
                4    9                  4    6     6                8                                       -->while stack is not empty  
            / \    / \             7    9    9     9       9        10          10                             stack ka top nikal  
            1  6   8  10           []   [7]  [7,4] [7,4,1] [7,4,1,6][7,1,4,6,9] [7,4,1,6,8] [7,4,1,6,8,10]      val nodes me; r stack me ;l stack me  //NULL CHECK: root cant be null     
                                                                                                                Stack<Node> stack = new Stack<>();                                                                          
                                                                                                                stack.push(root); 
                                                                                                                while(!stack.empty()){
                                                                                                                    root = stack.pop();
                                                                                                                    if(root != null){
                                                                                                                        nodes.add(root.val);                                 
                                                                                                                        for (int i = root.children.size() - 1; i >= 0; i--){ 
                                                                                                                            stack.push(root.children.get(i));}
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
            
        public List<Integer>       DFSPreOrder_iterative(Node root,List<Integer> nodes) {
            //EDGE CASE
            if(root == null) 
                return nodes;

            Stack<Node> stack = new Stack<>();
            stack.push(root); 
            while(!stack.empty()){
                root = stack.pop();
                if(root != null){
                    nodes.add(root.val);
                    for (int i = root.children.size() - 1; i >= 0; i--){ 
                        stack.push(root.children.get(i));
                    }
                }
            
            }
            return nodes;
 


        }

        TIME :O(n) as we traverse all nodes of tree
        SPACE:O(n) as we use STACK


    

        */


       

   }
    public void DFSPostOrder  (Node root , List<Integer> nodes){
        /*
            1                  -->PREORDER:  
        /   |   \   \            Top-bottom,Left-Right(ROOT,LEFT,RIGHT)-->[1,2,3,6,7,11,14,4,8,12,5,9,13,10]   
       2    3    4    5          Top-bottom,Right-Left(ROOT,RIGHT,LEFT)-->[1,5,10,9,13,4,8,12,3,7,11,14,6,2] 
       |    /\    |    /\
       n   6  7   8    9 10      POSTORDER
           | |   |    |   |      Bottom-top,Left-Righ;(LEFT,RIGHT,ROOT) -->[2,6,14,11,7,3,12,4,8,13,9,10,5,1] 
           n 11  12   13  null   Bottom-top ;Right-Left(RIGHT,LEFT,ROOT)-->[10,13,9,5,12,8,4,14,11,7,6,3,2,1]
             |
             14
            
       */

        //RECURSION IP-OP TREE
        /*  
        public void DFSPostOrder  (Node root , List<Integer> nodes)
            //LEFT-RIGHT;BOTTOM-TOP           
                                                        --while going top-bottom  
            if (root == null){return;}                      return at null and  start moving up                  
            
            for(int i =0 ; i < root.children.size();i++)   --while going left-right through children
                DFSPostOrder(root.children.get(i),nodes)  
                                                        --while going bottom-top 
            nodes.add(root.val)                             add nodes to list              


            // RIGHT-LEFT;BOTTOM-TOP 
                                                        --while going top-bottom  
            if (root == null){return;}                      return at null and  start moving up                  

                                                        
            for(int i =root.children.size()-1 ; i >=0 ;i--) --while going right-left through children
                DFSPostOrder(root.children.get(i),nodes)  
                                                            --while going bottom-top 
            nodes.add(root.val)                               add nodes to list     
        }
        
        //OVERLOAD
        public List<Integer> DFSPostOrder(Node root){
            List<Integer> list = new ArrayList<Integer> ;
            DFSPostOrder(Node root ,list)
            return list;
        }

        
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(logk n) if it is balanced tree  as we traverse entire height and k is approx no of children 
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
                                                                                                                        for(it i =0 ; i < root.children.size();i++){
                                                                                                                            stack.push(root.children.get(i));
                                                                                                                        }

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
       public List<Integer>  DFSPostOrder_iterative(Node root, List<Integer> nodes){       
            //EDGE CASE
            if(root == null) 
                return nodes;

            Stack<Node> stack = new Stack<>();   
            stack.push(root); 
            while(!stack.empty()){
                root = stack.pop();
                if(root != null){
                    nodes.add(0,root.val);  
                    for(int i =0 ; i < root.children.size();i++){
                        stack.push(root.children.get(i));
                    }

                }
    
            }
            return nodes;
        }                                                                                                             

   
        TIME :O(n) as we traverse all nodes of tree
        SPACE:O(n) as we use STACK
        
        


        
        */

    
    }
    public void DFSLevelOrder (Node root,int level,List<List<Integer>> nodes){
        /*
                7         Traverse top to bottom , eft to right   (DFS)
                /\        and return path of nodes  at each level (LevelOrder)
                / \       top-bottom ;left-right-->[ [7] , [4,9], [1,6,8,10] ]
                /   \     REST SAME AS BT 
                4    9        
                / \    / \    
                1  6   8  10   

        //RECURSION -IBH(smaller ip can be identified) -- Recursion because trees
        /*
        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(logk n) if it is balanced tree  as we traverse entire height and k is approx no of children 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */

        
        //RECURSION - BINARY RECURSIVE TREE(Binary tree is  recursive DS)
        /*
        public void DFSLevelOrder (Node root,int level,List<List<Integer>> nodes){                                                  
            //TOP-BOTTOM ;LEFT-RIGHT                          -- while going top-bottom    
            if (root == null){return;}                          return at null and  start moving up                                                                                                                     
            if(nodes.size()==level)                             [[l-r] , [l-r]] -- when we reach a level create a arraylist at last index(top-bottom) 
                nodes.add(new ArrayList<Integer>());             lo       l1       get the arrayList at that level and add nodes at lastindex(left right)
            nodes.get(level).add(root.val);                                         CREATE NEW OBJECT DONE WHEN WE REACH LEVEL NOT WHILE GOING LEFT RIGHT

            for(int i =0 ; i < root.children.size();i++){         --while going  left-right through childreb 
            DFSLevelOrder(root.children.get(i),level+1,nodes);   increment level by 1 
                                                                    7   0
                                                                    /  \
                                                                    /    \  
                                                                1 8      9  1
                                        
            REST DAE AS BT
        }

        //OVERLOAD
        public List<List<Integer>>  DFSLevelOrder(Node root){
            List<List<Integer>>  nodes = new ArrayList<>() ;
            DFSLevelOrder(Node root ,0,nodes)
            return nodes;
        }

        */

        //ITERATIVE
        /*                 
                                  //QUEUE(queue using LL cause queue using AD doesnt take null)   
        7                           10    
        /  \                         8                
        4    9                  9    6                                                                                                                                                                   
        / \    / \         7    4    1                     --> while queue is not empty 
        1  6   8  10     [7]  [7,4,9] [7,4,8,,6,8,10] queue ka sab elements bottom  se nikal                         
                                                            val list  me , left queue me , right queue me //NULL CHECK: root cant be null  
                                                            while (! queue.isEmpty() ) {
                                                                List<Integer> list = new ArrayList<>();
                                                                int currNumNodes = queue.size();            // queue size keeps on changing in for loop so calculate here 
                                                                for (int i = 0; i < currNumNodes; i++) {
                                                                    root = queue.remove();    
                                                                    if(root != null){
                                                                        list.add(root.val);     
                                                                        for(int j=0;j< root.children.size();j++){
                                                                            queue.add(root.children.get(j));
                                                                        }
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
            //EDGE CASE
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
                        for(int j=0;j< root.children.size();j++){
                            queue.add(root.children.get(j));
                        }
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
    public void BFSLevelOrder (Node root ,int level, List<Integer> nodes) {
        /*
            7        Traverse at each level                  (BFS)        
            /\       and return path of nodes  at each level (LevelOrder)
            / \      [ [7] , [4,9], [1,6,8,10] ]
            /   \       
            4    9        
            / \    / \    
        1  6   8  10   
        */



        //RECURSION - BINARY RECURSIVE TREE(Binary tree is  recursive DS)
        /*
        public void BFSLevelOrder (Node root ,int level, List<Integer> nodes) 
                                                            -- while going top-down
            if (root == null){return nodes;}                    return nodes at null and  start moving up         
            if (level == 0) {                                    when you reach level add to nodes
                nodes.add(root.val);
                return nodes;}

            for(int i =0 ; i < root.children.size();i++){           -- while going left-right along children
                BFSLevelOrder(root.children.get(i),level-1,nodes);   reduce level 
                
            }
            return nodes
        }

        //OVERLOAD
        public List<List<Integer>> BFSLevelOrder(Node root , List<List<Integer>> nodes){
            List<List<Integer>> nodes = new ArrayListyt<>();
            var height = height(root)
            for (var level = 0; level < height; level++) {
                nodes.add(BFSLevelOrder(root,level,new ArrayList<Integer>))

            return nodes;
        }


        Time :O(n*n) if it is balanced tree  as we traverse all nodes in tree                                ; then iterate from 0 to level(IN OVERRIDE )
            :O(n*n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree;then iterate from 0 to level(OVERRIDE)
        Space:O(h) = O(logk n) if it is balanced tree  as we traverse entire height and k is approx no of children 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */
   

    }  
    

    //DFSROOTTOLEAF
    /*
    HeightOfNaryTree   -->DFSPrePostInOrderMaxNoOfNode    HeightOfBinTree =  MaxDepthOfBinTree
    MaxDepthOfNaryTree -->DFSPrePostInOrderMaxNoOfNode 
     */
    public void DFSRootToLeafMaxNoOfNode(Node root){
        /*
          root-- 7        -->travel travel top-bottom  ;left-right          (DFS)
                /  \         and return max no of nodes on path from root to leaf(root to leaf)
               4    9        3
              / \    / \     
             1  6   8  10    
             /  \ /\  /\  / \
            n  n  n n n n  n n
           */

         //RECURSIVE IP-OP TREE
         /*
         SAME AS DFSRootToLeafPathsKaMaxNoOfNodes() but there is no way to identofy root leaf Node
         */

        //RECURSION IP-OP TREE
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

        public int     DFSPrePostOrderMaxNoOfNode(Node root)

                                                                --while going top-bottom
            if(root==null) {return 0;}                            return 0 at null andmove up 
                                                                pass to next node
            int childMax = 0;
            int child = 0;
            for(var nodes: root.children){                             --while going left-right through children
                child = DFSRootToLeafPathsKaMaxNoOfNodes(nodes);        child holds children subtree
                childMax = Math.max(child,childMax);                      childMax holds max of all children(childMax = 0 not Integer.MIN_VALUE)
                
                
            }  



                                                                    --while going bottom-top
            return childMax  + 1;(return Math.max(c1,c2....)+1) )        max no of nodes  on all children + node ka 1 
                                                |                          pass to next node
                                            done in for loop 
        }

        //OVERLOAD
        public void DFSPrePostOrderMaxNoOfNode(Node root){
            return DFSPrePostOrderMaxNoOfNode(root);
        }


        Time :O(n) if it is balanced tree  as we traverse all nodes in tree
            :O(n)  if it is unbalanced completely left/right skewed tree  as we traverse all nodes in tree
        Space:O(h) = O(logk n) if it is balanced tree  as we traverse entire height and k is approx no of children 
            :O(h) = O(n) if it is unbalanced completely left/right skewed tree   as we traverse entire height 
            +
            O(n) we are  using list that takes extra space
        */

     

    }
    


   }



















