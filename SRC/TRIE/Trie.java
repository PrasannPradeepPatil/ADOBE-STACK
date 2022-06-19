package SRC.TRIE;
import java.util.*;
import java.util.HashMap;
import java.util.List;





//TRIE/PREFIX TREE  DEFINATIONS(DUE TO DEFN TRIE  HAS SOME METHODS DIFFERENT FROM NARY TREE )
/*
1.EACH NODE HAS 26 CHILDREN:ROOT IS  NULL
ALL SUM SAME AS NARYTREE (there it was ArrayList here it is array with index as [ch-'a'] )
+
isEndOfWord  mantained in Node class ; which gives us words in tries EG DFSPrePostOrderNoOfWordsI,II, DFSPrePostOrderListOfWordsI,II,


2.TEST CASE
--

*/


public class Trie {





    //NODE CLASS
    public class Node{
        /*
         val,isEnOfWord,countOfWords,precountOfWOrds
         ---------
          [N1,N2,N3,....]

        */
        private char val;
        private boolean isEndOfWord;
        private int countOfWords;
        private int precountOfWOrds;
        private Node[] children;
        public Node(){//this.val ='some char default';this.isEndOfWord = false;this.countOfWords = 0; this.precountOfWOrds = 0;(compiler initiates default value ) 
            this.children = new Node[26];//(done exclusively)  
        }
        public Node(char val){//this.isEndOfWord = false;this.countOfWords = 0; this.precountOfWOrds = 0;(compiler initiates default value ) 
            this.val = val;
            this.children = new Node[26];//(done exclusively)  
        }


    }
    //CONSTRUCTOR                    //INITIALISING ROOT
    public Node root;               //Trie Construction:-->Compiler will call className obj = new ClassName() ; obj.methodName() so you must initialise root with default value in constructor of class(arr done exclusively not left to default)       
    public Trie(){                  // Trie Methods     -->Compiler will call className obj = new ClassName() ; obj.methodName(new Node()) so compiler initialises root 
        root = new Node();
    }
    
                                  //RETURN NODES
                                 //return new Node()-- returns Node with val='defaultOfChat,isEnOfWord=false,countOfWords=0,precountOfWOrds=0,children =[null,null...26 length](arr done exclusively not left to default)
                                //return new Node()-- returns Node with val=val,isEnOfWord=false,countOfWords=0,precountOfWOrds=0,children =[null,null...26 length](arr done exclusively not left to default))



    //TRAVERSAL
    public void DFSPreOrder   (Node root , List<Character> nodes){
        /*
            null              -->PREORDER:  
        /   |   \   \            Left-right,Top-bottom(ROOT,LEFT,RIGHT)-->[null,a,j,b,i,e,a,c,j,a,x,k,l,t]   
        a    b    j    k          Right-Left,Top-bottom(ROOT,LEFT,RIGHT)-->[null,k,t,l,j,a,x,b,a,c,i,e,a,j]
        |    /\    |    /\
        j   i  a   a    l t       POSTORDER
            |  |   |              Left-Righ;Bottom-topt(LEFT,RIGHT,ROOT) -->[j,a,e,i,c,a,b,x,a,j,l,t,k,null]
            e  c   x              Right-Left;Bottom-top (RIGHT,LEFT,ROOT)-->[t,l,k,x,a,j,c,a,e,i,b,j,a,null]
            
                
                
            
        */
    
        //RECURSIVE IP-OP TREE 
        /*  
        public void DFSPreOrder   (Node root , List<Character> nodes){
            //LEFT-RIGHT;TOP-BOTTOM           
                                                        --while going top-bottom  
            if (root == null){return;}                    return at null and  start moving up                  
            nodes.add(root.val)                            add nodes to list   
            
            for(int i =0 ; i < root.children.length;i++) --while going left-right through children
                DFSPreOrder(root.children[i],nodes)             
    
    
            //RIGHT-LEFT;TOP BOTTOM 
                                            --while going top-bottom  
            if (root == null){return;}      return at null and  start moving up                  
            nodes.add(root.val)             add nodes to list   
                                                        
            for(int i =root.children.length-1 ; i >=0 ;i--) --while going right-left through children
                DFSPreOrder(root.children[i],nodes)
            }
        }

        //OVERLOAD
        public List<Character> DFSPreOrder(Node root){
                List<Character> nodes = new ArrayList<Integer> ;
                DFSInOrder(root ,nodes)
                return nodes;
        }

        

        Time :O(n) as we traverse all nodes in tree
        Space:O(h) = O(logk n)  we traverse entire height and k is approx no of children 
                +
                O(n) we are  using list that takes extra space

            */


        

    }
    public void DFSPostOrder   (Node root , List<Character> nodes){
        /*
        null              -->PREORDER:  
    /   |   \   \            Left-right,Top-bottom(ROOT,LEFT,RIGHT)-->[null,a,j,b,i,e,a,c,j,a,x,k,l,t]   
    a    b    j    k          Right-Left,Top-bottom(ROOT,LEFT,RIGHT)-->[null,k,t,l,j,a,x,b,a,c,i,e,a,j]
    |    /\    |    /\
    j   i  a   a    l t       POSTORDER
        |  |   |              Left-Righ;Bottom-topt(LEFT,RIGHT,ROOT) -->[j,a,e,i,c,a,b,x,a,j,l,t,k,null]
        e  c   x              Right-Left;Bottom-top (RIGHT,LEFT,ROOT)-->[t,l,k,x,a,j,c,a,e,i,b,j,a,null]
        
            
            
        
    */
        
        //RECURSIVE IP-OP TREE 
        /* 
        public void DFSPostOrder   (Node root , List<Character> nodes){ 
            //LEFT-RIGHT;BOTTOM-TOP           
                                                        --while going top-bottom  
            if (root == null){return;}                    return at null and  start moving up                  
            
            for(int i =0 ; i < root.children.length;i++) --while going left-right through children
                DFSPostOrder(root.children[i],nodes) 
                                                        --while going bottom-top  
            nodes.add(root.val)                            add nodes to list               


            //RIGHT-LEFT;BOTTOM-TOP
                                                            --while going top-bottom  
            if (root == null){return;}                     return at null and  start moving up                  
                                                        
            for(int i =root.children.length-1 ; i >=0 ;i--) --while going right-left through children
                    DFSPostOrder(root.children[i],nodes)  
            
                                                            --while going bottom-top  
            nodes.add(root.val)                               add nodes to list  
        }

        //OVERRIDE
        public List<Character> DFSPreOrder(Node root){
            List<Character> nodes = new ArrayList<Integer> ;
            DFSInOrder(root ,nodes)
            return nodes;
        }
            
        Time :O(n) as we traverse all nodes in tree
        Space:O(h) = O(logk n)  we traverse entire height and k is approx no of children 
                +
                O(n) we are  using list that takes extra space

        */





    

}
    public void DFSLevelOrder (Node root,int level,List<List<Character>> nodes){
        /*
            null              -->Traverse top to bottom , left to right   (DFS)
        /   |   \   \            and return path of nodes  at each level (LevelOrder)   
        a    b    j    k         left-right;top-bottom -->[ [null] , [a,b,j,x], [j,i,a,a,l,t],[e,c,x] ]
        |    /\    |    /\        REST SAME AS BT 
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
            
                
                
            
        */


    
        //RECURSIVE IP-OP TREE
        /*
        public void DFSLevelOrder (Node root,int level,List<List<Character>> nodes){                                                    
            //LEFT-RIGHT;TOP-BOTTOM                           -- while going top-bottom    
            if (root == null){return;}                          return at null and  start moving up                                                                                                                     
            if(nodes.size()==level)                             [[l-r] , [l-r]] -- when we reach a level create a arraylist at last index(top-bottom) 
                nodes.add(new ArrayList<Integer>());             lo       l1       get the arrayList at that level and add nodes at lastindex(left right)
            nodes.get(level).add(root.val);                                         CREATE NEW OBJECT DONE WHEN WE REACH LEVEL NOT WHILE GOING LEFT RIGHT

            for(int i =0 ; i < root.children.size();i++){         --while going  left-right through childreb 
            DFSLevelOrder(root.children.[i],level+1,nodes);   increment level by 1 
                                                                    7   0
                                                                    /  \
                                                                    /    \  
                                                                1 8      9  1
                                    
            //REST SAME AS BT
        }

        //OVERLOAD
        public List<List<Character>>  DFSLevelOrder(Node root){
            List<List<Character>>  nodes = new ArrayList<>() ;
            DFSLevelOrder(root ,0,nodes);
            return nodes;
        }

        Time :O(n) as we traverse all nodes in tree
        Space:O(h) = O(logk n)  we traverse entire height and k is approx no of children 
                +
            O(n) we are  using list that takes extra space
                                                                
        */


}
    public void BFSLevelOrder (Node root ,int level, List<Character> nodes) {

        /*
                null              -->Traverse at each level                  
            /   |   \   \            and return path of nodes  at each level   
        a    b    j    k          [ [null] , [a,b,j,x], [j,i,a,a,l,t],[e,c,x] ]
        |    /\    |    /\        
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
    
        */



        //RECURSION IP-OP TREE
        /*
                                                        -- while going top-down
        if (root == null){return nodes;}                    return nodes at null and  start moving up         
        if (level == 0) {                                    when you reach level add to nodes
            nodes.add(root.val);
            return nodes;}

        for(int i =0 ; i < root.children.length;i++){           -- while going left-right along children
            BFSLevelOrder(root.children[i],level-1,nodes);   reduce level 
            
        }


        return nodes

        //OVERRIDE(THE FOR LOOP MAKES IT BFS AS WE GO AT EACH LEVEL)
        public List<List<Character>> BFSLevelOrder(Node root , List<List<Character>> nodes){
            List<List<Character>> nodes = new ArrayListyt<>();
            var height = height(root)
            for (var level = 0; level < height; level++) {
                nodes.add(BFSLevelOrder(root,level,new ArrayList<Integer>))

            return nodes;
        }



        Time :O(n*n) e  as we traverse all nodes in tree                                ; then iterate from 0 to level(IN OVERRIDE )
        Space:O(h) = O(logk n) as we traverse entire height and k is approx no of children 
                +
                O(n) we are  using list that takes extra space

        */

        
        

}  
    public void DFSWordOrder(Node root, String word ){
            /*
                null              -->Traverse the tree  along the word         
            /   |   \   \                                  
        a    b    j    k             EG word = "bie" then travel  b--i--e
        |    /\    |    /\        
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
    
        */

        //ITERATIVE 
        /*
        public void DFSWordOrder(Node root, String word ){
            Node ptr = root;                                           --initialise ptr to root so that root is intcat while traversing                        
            for(int i =0 ; i < word.length(); i++){                    --while moving  across the word and  across the trie equivalent to word
                ptr = ptr.children[word.charAt(i) - 'a'];               
            }
        }
        Time :O(n) as we traverse all nodes in tree                         
        Space:O(1) as we dont require extra space
            */

        //RECURSIVE IP-OP TREE
        /*
        public void DFSWordOrder(Node ptr, int index , String word 
                                                            -->while coming bottom top 

        DFSWordOrder(ptr.children[index], index+1, word)  -->while move across the trie wrt word ka char;move across word by incrementing index

                                                            -->while coming bottom-top 
                                                            EGDFSWordOrderrRemoveWord

        OR

        DFSWordOrder(ptr.children[index], index+1, word,k)  --> move across the trie wrt word ka char;move across word by incrementing index;k remains same
        for (int i=0 ; i < ptr.children.length;i++){if(ptr.children[i]!=null){
                DFSWordOrderr(ptr.children[i], index + 1, ptr.children[i].val != word.charAt(index) ? k - 1 : k,word)) {
            }}                                                 --> move across the trie  allchildren(non null) for every character of word ; move across word by incrementing index;k depending on trie and word ka character match 
                                                                EGDFSWordOrderrContainsWordKDifferent
        
        Time :O(n) as we traverse all nodes in tree                         
        Space:O(1) as we dont require extra space
        
        
        */


    }
    




    //DFS PRE,POST ORDER
    public void DFSPrePostOrderWords   (Node root , List<String> nodes, String pathString){
        /*
            null              -->Traverse the tree
        /   |   \   \            and return the list of words in trie  
        a    b    j    k         
        |    /\    |    /\
        j   i  a   a    l t       
            |  |   |              
            e  c   x              
            
                
                
            
        */
    



        //RECURSION IP-IP TREE(CONSIDERING OUR NODE CLASS HAS ROOT.VAL )
        /*  
    public void DFSPrePostOrderWords   (Node root , List<String> nodes, String pathString){
                                                                                    --while going top-bottom  
        if (root == null){return;}                                                      return at null and  start moving up 
        pathString = pathString + root.val;                                             add root value to pathString  
        if(root.val.isEndOfWord){                                                       if it isend of word
            nodes.add(pathString);                                                      add pathstring to node
            return;                                                                     RETURN AND START MOVING UP AGAIN (AVOID UPDATING OBJECT WHILE COMING UP)
        }
        
        for(int i =0 ; i < root.children.length;i++)                                  --while going left-right through children
            DFSPrePostOrderWords(root.children[i],nodes, new String(pathString)) ; }      CREATE NEW OBJECT (AVOID SAME OBJECT WHILE COMING DOWN) ;    
    }

    //OVERLOAD
        public List<Character> DFSPrePostOrderWords(Node root){
            List<String> nodes = new ArrayList<> ;
            DFSPrePostOrderWords(root ,nodes)
            return nodes;
    }
        Time :O(n) as we traverse all nodes in tree
        Space:O(h) = O(logk n)  we traverse entire height and k is approx no of children 
            +
            O(n) we are  using list that takes extra space
    */

        //RECURSION IP-IP TREE(CONSIDERING OUR NODE CLASS DOESNT HAVE  ROOT.VAL )
        /*  
        public void DFSPrePostOrderWords   (Node root , List<String> nodes, String pathString){
                                                                                            --while going top-bottom  
            if (root == null){return;}                                                          return at null and  start moving up 
            if(root.isEndOfWord){
                nodes.add(pathString);
            }

            for(int i =0 ; i < root.children.length;i++)                                        --while going left-right through children
                DFSPrePostOrderWords(root.children[i],nodes, pathString +root.children[i]; }       while going top bottom you add character from previous node           -------------> while coming top-bottom pathsTring + currentchar
                                                                                                    while going bottom-top you already have have the character for that node            while coming  bottom-top pathsTring-lastchar
                                                                                                    null           
                                                                                                    /   |   \   \            
                                                                                                a    b    j    k         
                                                                                                |    /\    |    /\
                                                                                            'a'  j'b' i  a   a    l t       
                                                                                                        |  |   |              
                                                                                                    'i' e  c   x              
        } 
        
        //OVERLOAD
            public List<Character> DFSPrePostOrderWords(Node root){
                List<String> nodes = new ArrayList<> ;
                DFSPrePostOrderWords(root ,nodes)
                return nodes;
        }
            Time :O(n) as we traverse all nodes in tree
            Space:O(h) = O(logk n)  we traverse entire height and k is approx no of children 
                +
                O(n) we are  using list that takes extra space
            */

        

    }
  

   //DFS WORD ORDER
    public void DFSWordOrderInsertWord(Node root, String word ){
        /*
                null              -->Traverse tree  
            /   |   \   \            and insert the word by attaching                          
        a    b    j    k             EG "jaxie" so it will attach as  j-a-x-i-e
        |    /\    |    /\           
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
    
        */


        //ITERATIVE
        /*
        public void    DFSWordOrderInsertWord(Node root, String word ){
            Node ptr = root;                                                       ---initialise ptr to root so that root is intcat while traversing                            
            for(int i =0 ; i < word.length(); i++){                                --while moving  across the word and  across the trie equivalent to word
                if(ptr.children[word.charAt(i) - 'a'] == null ){                     if child is null put new Node at child                  
                        ptr.children[word.charAt(i) -'a'] = new Node(word.charAt(i));}  increment precountOfWOrds after moving to next node

                ptr = ptr.children[word.charAt(i) -'a']; 
                ptr.precountOfWOrds = ptr.precountOfWOrds + 1;
            }
    
            ptr.countOfWords = ptr.countOfWords + 1;                              --increment countOfWords
            ptr.isEndOfWord = true;                                                 set isEndOfWord
        }

        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(l) as we insert l nodes in tree(l=length of word)  )


        */




    }
    public void DFSWordOrderRemoveWord (Node root, String word ){
        /*
                null              --> Traverse the tree
            /   |   \   \             and remove the word by just removing count and endOfWOrd
        a    b    j    k               EG remove "jax" j-a-x
        |    /\    |    /\          
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
    
        */
        //ITERATIVE
        /*
        public void    DFSWordOrderRemoveWord (Node root, String word ){
            Node ptr = root;                                                       ---initialise ptr to root so that root is intcat while traversing                            
            for(int i =0 ; i < word.length(); i++){                                --while moving  across the word and  across the trie equivalent to word
                ptr = ptr.children[word.charAt(i) -'a']; 
                ptr.precountOfWOrds = ptr.precountOfWOrds - 1;
            }

            ptr.countOfWords = ptr.countOfWords - 1;                              --decrement countOfWords
            ptr.isEndOfWord = true;                                                 set isEndOfWord to false
            
        }

        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(1) as we dont take extra space


        */


        


    }
    public void DFSWordOrderRemoveWord(Node ptr, int index,String word){
        /*
                null              -->Traverse tree and and remove the word 
            /   |   \   \            1.Make isEndoOfWord false    
        a    b    j    k             2. if word's characters do not have children (ie word is not a prefix )  remove the characters    
        |    /\    |    /\           3. if words characters are not end of any other words(ie word is not a suffix)  remove the characters    
        j   i  a   a    l t         
            |  |   |                
            e  c   x              

        */

        //RECURSIVE IP -OP TREE
        /*                                                                          --WHILE COMING BOTTOM-TOP
        if (ptr == null)                                                              if char is null return null
            return null;

        if (index == word.length()) {                                                if we have reached end of word                                                       
            if (ptr.isEndOfWord){ptr.isEndOfWord = false;}                           make isEndOfWord false 
            if (isEmpty(ptr)) { ptr = null; }                                        if word's characters do not have children (ie word is not a prefix );remove character by making it null                                                
            return ptr;                                                              return character 
        }


        ptr.children[word.charAt(index) - 'a'] =DFSWordOrderrRemoveWord(ptr.children[word.charAt(index) - 'a'],index + 1,word);   -->while move across the trie wrt word ka char;move across word by incrementing index
                                                                                                                                        return the result un pointer ka children ka char corresponding to woed
                                                                                --WHILE COMING BOTTOM-TOP
        if (isEmpty(ptr) && ptr.isEndOfWord == false){ptr = null; }               if word's characters do not have children (ie word is not a prefix ) and words characters are not end of any other words(ie word is not a suffix)  ; remove character by making it null          
            return ptr;                                                              retturn character   

            //ISEMPTY
        private boolean isEmpty(Node root, char[] arr){
            for (int i = 0; i < arr.length; i++)
                if (arr[i] != null)
                    return false;
            return true;
        }

        //OVERIDE
        public Node DFSWordOrderrRemoveWord(String word){
            return DFSWordOrderrRemoveWord(root,0,String word);
        }
            
        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(h) = O(log26 n) 
        */

    }
    public void DFSWordOrderWordMatchingIsPossible(Node root, String word ){
        /*
            null              -->Traverse the tree
            /   |   \   \        and if trie has a word matching word given in arg return  
        a    b    j    k         then return  last node of word of trie/true else return null/false  
        |    /\    |    /\       EG word of trie = "jax"  ; word of arg = "jax" so return "x"/true  else null/false
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
    
        */

        

        //ITERATIVE
        /*
        public Node    DFSWordOrderWordMatchingIsPossible(Node root, String word ){
            Node ptr = root;                                                       ---initialise ptr to root so that root is intcat while traversing                            
            for(int i =0 ; i < word.length(); i++){                                --while moving  across the word and  across the trie equivalent to word
                if(ptr.children[word.charAt(i) - 'a'] == null ){                      if child is null return null/false              
                    return null/false;}

                ptr = ptr.children[word.charAt(i) -'a']; 
            }

            return ptr;                                                            --return ptr /ptr.isEndOfWord
            return ptr.isEndOfWord;
        }

        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(1) as we dont take extra space


        */






}
    public void DFSWordOrderWordMatchingKaCount(Node root, String word ){
        /*
                null              -->Traverse the tree
            /   |   \   \            and if trie has a word matching word given in arg return
        a    b    j    k             return number of matching words of trie 
        |    /\    |    /\           EG word of trie = "jax"  ; word of arg = "jax" so return 1
        j   i  a   a    l t           
            |  |   |           
            e  c   x              

        */

        //ITERATIVE
        /*    
        public int   DFSWordOrderWordMatchingKaCount(Node root, String word )
            return (DFSWordOrderWordMatchingIsPossible(root,word))? node.countOfWords:0; //QUESTION MUST INSERT/REMOVE FOR THE COUNTOFWORDS TO SET 
        }
        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(1) as we dont take extra space

        */




    }
    public void DFSWordOrderWordMatchingWithKDifferenceIsPossible(Node ptr, int index, int k,String word) {
        /*
            null              -->Traverse tree
            /   |   \   \        and if trie has a word matching word given in arg with k characters changed 
        a    b    j    k         then return true false
        |    /\    |    /\       EG word of trie = "jax"  ; word of arg = "jbb" k=2 so return true 
        j   i  a   a    l t       
            |  |   |           
            e  c   x   
        TrieMagicDict-- k = 1
        TrieWordDict-- k = number of '.'           
    
        */

    
        //RECURSION IP-OP TREE + ITERATION --More like a ratta algo 0% intution based
        /* 
        public boolean DFSWordOrderrContainsWordKDifferent(Node ptr, int index, int k,String word) {
            if (index == word.length()) {                                                                          BASE CASE   
                return k == 0 && ptr.isEndOfWord;                                                               -->return k == 0 && ptr.isEndOfWord                                                        
            }

            if (k == 0) {                                                                                           K=0                                      
                if(! containsCharI/II(ptr.children ,word.charAt(index)) ){return false;}                          -->if ptr ka  childrens does not contain word ka character return false
                return DFSWordOrderWordMatchingWithKDifferenceIsPossible(ptr.children[word.charAt(index)-'a'],index+1,k,word);  -->move across the trie wrt word ka char;move across word by incrementing index;k remains same
            }                                                                                                       and return its result 
                            
            else if (k > 0) {                                                                                       k>0
                for (int i=0 ; i < ptr.children.length;i++){                                                      -->move across the trie  allchildren(non null)  for every character of word ; move across word by incrementing index;k depending on trie and word ka character match 
                    if(ptr.children[i]!=null){                                                                      and if it is true return true;
                        k =  ptr.children[i].val != word.charAt(index) ? k - 1 : k
                        if (DFSWordOrderWordMatchingWithKDifferenceIsPossible(ptr.children[i], index + 1,k,word)) {
                            return true;                                                                             
                        }                                                                                             
                }}
            }                                      
            return false;                                                                                      -->return false;                                                                    

        }

        //CONTAINSCHARI
        private boolean containsCharI(Node[] arr , char c){   -->If word has characters 'a' - 'z' 
            return arr[c -'a'] !=null)                           then just check the array at  index c-'a'  for non null value 
        }                                                        O(1)

        
        //CONTAINSCHARII
        private boolean containsCharII(Node[] arr , char c){    -->If word has characters other that 'a' - 'z' 
            for(int i=0 ; i < arr.length;i++){                    then check the array at each index (index c-'a'  may be out of bonds hence each index)
                if(arr[i] != null){                               if non null value check if it matches character 
                    if(arr[i].val == c)                           TIME :O(26)
                        return true;
                }
            }
            return false;
        }


    
            //OVERRIDE
            public boolean DFSWordOrderrContainsWordKDifferent(String word,int k ){
                DFSWordOrderrContainsWordKDifferent(root,0,k,String word)
            }
    

        TIME: O(l*26 + l)  as for every character of word you move across all children of trie  
        Space:O(1)         as we dont take extra sp


        */



    
    }
    public void DFSWordOrderWordPrefixIsPossible(Node root, String word ){
        /*
            null              -->Traverse the tree
            /   |   \   \        and if trie has a word which is a prefix of word given in arg
        a    b    j    k         return the word of trie/true else return word of arg/false  
        |    /\    |    /\        EG word = "jaxie" so "jax" word in trie is a prefix of word given in arg so return "jax" 
        j   i  a   a    l t      
            |  |   |           
            e  c   x              

        */


        //ITERATIVE
        /*
        public String  DFSWordOrderWordSuffixIsPossible(Node root, String word )
            Node ptr = root;                                                       ---initialise ptr to root so that root is intcat while traversing                            
            for(int i =0 ; i < word.length(); i++){                                --while moving  across the word and  across the trie equivalent to word
                if(ptr.children[word.charAt(i) - 'a'] == null ){                     if child is null return word/false              
                    return word;                                                     if child is end of word  null return word  substring 0 to i+1/true
                    return false;}                                                   
                if(ptr.children[word.charAt(i) - 'a'].isEndOfWord ){
                    return word.substring(i,i+1)
                    return true;}   
                
                ptr.precountOfWOrds = ptr.precountOfWOrds + 1;
            }

            return word;                                                                   --return word /true
            return true;

        }
        Time :O(l) as we traverse atleast l nodes in tree(l=length of word)                         
        Space:O(1) as we dont take extra space

        */



    }
    public void DFSWordOrderPrefixKaLongestPossibleString(Node root, String word){
        /*
            null             -->Traverse left-right , top-bottom across trie (DFS)  
            /   |   \   \       along the word                              (WordOrder)   
        a    b    j    k        and if trie has a word which is a prefix of word given in arg
        |    /\   |    /\       return the longest possible prefix
        j   i  a  a    l t      Longest prefix ka endNode must not have any child; because if it has a child it will become prefix of another word 
            |  |  | \           Longest prefix ka endNode must not be end of word or else it will nit be a prefix and become a worsd 
            e  c  x  n         EG word = "jaxie" so longest possible prefix = "j"  

        */


        /*
        private String DFSWordOrderSuffixKaLongestString(Node root, String word) {
            Node ptr = root;                                                       ---initialise ptr to root so that root is intcat while traversing                            

            StringBuilder res = new StringBuilder();
            for (int i = 0; i <= word.length()-1; i++) {                          --while moving  across the word and  across the trie equivalent to word
                if(ptr.children[word.charAt(i) - 'a'] != null                        if ptr's children contains character 
                  && ptr.linksCount == 1                                             and ptr has no children(In Trie class declare int linksCount; and while inserying word or removing word do linksCount++ ; linksCount--)
                  && !ptr.isEnOfWord ){                                              and ptr is not end of node
                    res.append(word.charAt(i));                                          means longest prefix is valid till ptr so append ptr to res
                     ptr = ptr.children[word.charAt(i) -'a'];                            move ptr ahead
                }
                else{                                                                else
                    return prefix.toString();                                             meand longest prefix has become invalid by nit satisfying any one of the cond  sp return res 
                }

            }
            return prefix.toString();
        }

        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(1) as we dont take extra space

        
        */

    }
    public void DFSWordOrderWordSuffixIsPossible(Node root, String word ){
        /*
            null              -->Traverse the tree
            /   |   \   \        and if trie has a word which is suffix of the word given in arg    
        a    b    j    k         then return  last node of word of trie/true else return null/false  
        |    /\    |    /\       EG word of trie = "jax"  ; word of arg = "ja" so return "a"/true else null/false
        j   i  a   a    l t      
            |  |   |           
            e  c   x              
    
        */


        

        //ITERATIVE
        /*
        public Node    DFSWordOrderWordSuffixIsPossible(Node root, String word )
            Node ptr = root;                                                       ---initialise ptr to root so that root is intcat while traversing                            
            for(int i =0 ; i < word.length(); i++){                                --while moving  across the word and  across the trie equivalent to word
                if(ptr.children[word.charAt(i) - 'a'] == null ){                      if child is null return null /false             
                        return null;
                        return false;}
                
                ptr.precountOfWOrds = ptr.precountOfWOrds + 1;
            }

            return ptr;                                                                --return ptr /true
            return true;
        }

        Time :O(l) as we traverse atleast l nodes in tree(l=length of word)                        
        Space:O(1) as we dont take extra space

        */

    }
    public void DFSWordOrderWordSuffixKaCount(Node root, String word ){
        /*
                null              -->Traverse the tree
            /   |   \   \            and if trie has a word which is suffix of the word given in arg  
        a    b    j    k             return no of suffix words of trie     
        |    /\    |    /\          EG word of trie = "jax"  ; word of arg = "k" so return 2 for kl and kt 
        j   i  a   a    l t           
            |  |   |           
            e  c   x              

        */




        //ITERATIVE
        /*
        public int     DFSWordOrderWordSuffixKaCount(Node root, String word ){
            return (DFSWordOrderWordMatchingIsPossible(root,word))? node.precountOfWOrds:0; //QUESTION MUST INSERT/REMOVE FOR THE PRECOUNTOFWORDS TO SET  
        }

        Time :O(l) as we traverse atleast l nodes in tree(l=length of word)                         
        Space:O(1) as we dont take extra space
        


        */


    

    }
    public void DFSWordOrdertOrderWordSuffixKaList(Node root , String word){
        /*
            null              -->Traverse the tree
        /   |   \   \            and find words that are suffix to goven word and returnlist of suffixes 
    a    b    j    k             Eg: If word is given as "b" then return ["bia","bac"]
    |    /\    |    /\          
    j   i  a   a    l t           
        |  |   |           
        e  c   x              

    */


        /*
        public List<Character> DFSWordOrdertOrderWordSuffixKaList(Node root,String word){
            List<String> res = new ArrayList<>();     
            Node ptr = roott;                             
            for (var key : word.toCharArray()) {      --while moving  across the word and  across the trie equivalent to word
                ptr = ptr.getChildNode(key);                
                if(ptr == null){return list;}
            }
            Node lastNodeOfWord  = ptr;              --lastNode is the node in trie whic is last character of word 

            DFSPrePostOrder(lastNodeOfString,string, res);  -- perform DFS and collect in a list all the words starting from last character of word 

            return list;
        }

        public void DFSPrePostOrder(Node root ,String word, List<Character> res){      
                                                        --while going top-bottom  
            if (root == null){return;}                    return at null and  start moving up     
            
            if(root.isEndOfWord)                         if node is end of word
                res.add(word)                                  add word to res    
            
            for(var childNode : roott.getChildNodeList()            --while going left-right through children
                DFSPreOrder(childNode,word + childNode.value,,res)      add childNode to word           
        }


        Time :O(l + m) as we traverse l nodes in treea and after that we traverse m nodes(l=length of word,m = total nodes in siffix)                         
        Space:O(1) as we dont take extra space

        */
    }

    
    

// #########################NOT DONE###################################################

    public class Nodee {
        /*

        value | isEnOfWord           addChildNode(char key)      -->add      childNode            
        ----------------             removeChildNode(Char key)   -->remove   childNode          
        {char:Nodee,char:Nodee,... }   getChildNode(char key)      -->get      childNode           
                                     getChildNodeList()          -->get      childNode array 
                                     containsChildNode(char key) -->contains childNode  
                                     hasChild()                  -->has      childNode 
 
         */

        private char value;
        private boolean isEndOfWord;
        private HashMap<Character, Nodee> childMap;
        private Nodee(){}
        private Nodee(char value) {this.value = value;childMap = new HashMap<>();}

        public void    addChildNode(char key) {
            childMap.put(key, new Nodee(key));
        }
        public void    removeChildNode(char key) {
            childMap.remove(key);
        }
        public Nodee    getChildNode(char key) {
            return childMap.get(key);
        }
        public Nodee[]  getChildNodeList() { 
            return childMap.values().toArray(new Nodee[0]); }
        public boolean containsChildNode(char key) {
            return childMap.containsKey(key);
        }
        public boolean hasChild() {
            return !childMap.isEmpty();
        }
    
    }
    private Nodee roott = new Nodee(' ');

    public static String longestCommonPrefix(String[] array) {
        // We add these words to a trie and walk down
        // the trie. If a node has more than one child,
        // that's where these words deviate. Try this
        // with "can", "canada", "care" and "cab". You'll
        // see that these words deviate after "ca".
        //
        // So, we keep walking down the tree as long as
        // the current node has only one child.
        //
        // One edge cases we need to count is when two
        // words are in the same branch and don't deviate.
        // For example "can" and "canada". In this case,
        // we keep walking down to the end because every
        // node (except the last node) has only one child.
        // But the longest common prefix here should be
        // "can", not "canada". So, we should find the
        // shortest word in the list first. The maximum
        // number of characters we can include in the
        // prefix should be equal to the length of the
        // shortest word.
        if (array == null)
            return "";

        //add in a tree
        var trie = new Trie();
        for (var string : array){
            //trie.insert_iterative(string);
        }


        //
        StringBuffer stringBuffer = new StringBuffer();
        var current = trie.roott;
        while (stringBuffer.length() < ShortestStringOfArray(array).length()) {
            var children_array = current.getChildNodeList();
            if (children_array.length != 1)
                break;
            current = children_array[0];
            stringBuffer.append(current.value);
        }

        return stringBuffer.toString();
    }
    private static String ShortestStringOfArray(String[] array) {
        if (array == null || array.length == 0)
            return "";

        var shortest = array[0];
        for (var i = 1; i < array.length; i++) {
            if (array[i].length() < shortest.length())
                shortest = array[i];
        }

        return shortest;
    }
 









}

