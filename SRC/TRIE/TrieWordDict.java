package TRIE;


public class TrieWordDict {
    /*
    TrieWordDict()             :Initializes the object.
    addWord(String word)     :Adds word to the data structure, it can be matched later.
    bool search(String word)   :Returns true if there is any string in the data structure that matches word or false otherwise
                                word may contain dots '.' where dots can be matched with any letter.
    */

    //TRIE CLASS
    public class Trie{ 
        /*
        IMPLEMENMT TRIE CLASS (I HAVE ONLY WRITTEN FN NAMES HERE BUT IMPLMENET WHOLE CLASS HERE)
        */
        public class Node{};
        public Node root;
        public Trie(){root = new Node();}
        
        public void DFSWordOrderInsertWord(Node root,String word){}
        public boolean DFSWordOrderWordMatchingWithKDifferenceIsPossible(Node root,int index, int k,String word){return true;}
    }


    //CONSTRUCTOR
    public Trie trie;
    public Trie.Node root;
    public TrieWordDict() {   
        /* 
        Initialise Trie class and root 
        */                    
        trie = new Trie();
        root  = trie.new Node();
    }

    //INSERT
    public void addWord(String word) {
        /*
        trie.DFSWordOrderInsertWord(root,word);  --insert word in trie

        Time :O(l) as wetraverse l nodes in tree(l=length of word)                        
        Space:O(l) as we insert l nodes in tree(l=length of word)  )

        */

        trie.DFSWordOrderInsertWord(root,word);
        

     }

     //SEARCH
     public boolean search(String word) {  
        /*
        int k=0;                               --iterate through word and find no of '.'
        for(int i=0; i<word.length();i++){
            if(word.charAt(i) == '.'){
                k++;
            }
        }
        return trie.DFSWordOrderWordMatchingIsPossible(root,0,k,word); -- search word in trie with k different changes allowed 
                                                                       with index = 0; k = no of '.'
        
        TIME: O(l)  as for every character of word you move across all children of trie                       
        Space:O(l) as we insert l nodes in tree(l=length of word)  )

        */
  
        int k=0;
        for(int i=0; i<word.length();i++){
            if(word.charAt(i) == '.'){
                k++;
            }
        }
        return trie.DFSWordOrderWordMatchingWithKDifferenceIsPossible(root,0,k,word);
     }



    
}
