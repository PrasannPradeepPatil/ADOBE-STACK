package SRC.TRIE;


public class Triee {
    /*
    Implement Trie class in which 
    Triee() Initializes the trie object.
    void insert(String word)           :Inserts the string word into the trie.
    boolean search(String word)       :Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String word) :Returns true if there is a previously inserted string word that has the prefix word, and false otherwise.
    
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
        public boolean DFSWordOrderWordMatchingIsPossible(Node root,String word){return true;}
        public boolean DFSWordOrderWordSuffixIsPossible(Node root,String word){return true;}
    }


    //CONSTRUCTOR
    public Trie trie;
    public Trie.Node root;
    public Triee() {   
        /* I
        Initialise Trie class and roor 
        */                    
        trie = new Trie();
        root  = trie.new Node();
    }

    //INSERT
    public void insert(String word) {
        /*
        trie.DFSWordOrderInsertWord(root,word) -- insert the word in trie
        
        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(l) as we insert l nodes in tree(l=length of word)  )

        */
        trie.DFSWordOrderInsertWord(root,word);
     }

     //SEARCH
     public boolean search(String word) {  
        /*
        return trie.DFSWordOrderWordMatchingIsPossible(root,word); -- search the word in trie
        
        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(l) as we insert l nodes in tree(l=length of word)  )

        */
  
        return trie.DFSWordOrderWordMatchingIsPossible(root,word);
     }

     //STARTSWITH
     public boolean startsWith(String word) {
        /*
        return trie.DFSWordOrderWordMatchingIsPossible(root,word); -- search the word in trie contains word ka suffix
        
        Time :O(l) as we traverse l nodes in tree(l=length of word)                        
        Space:O(l) as we insert l nodes in tree(l=length of word)  )
        */
         return trie.DFSWordOrderWordSuffixIsPossible(root,word);
     }

    
}
