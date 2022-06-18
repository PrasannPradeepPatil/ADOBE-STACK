package SRC.TRIE;


public class TrieMagicDict {
    /*
    TrieMagicDict()                :Initializes the object.
    buildDict(String[] words) :Sets the data structure with an array of distinct strings words.
    bool search(String word)       :Returns true if you can change exactly one character in searchWord to match any string in the data structure,
                                    otherwise returns false.
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
    public TrieMagicDict() {   
        /* 
        Initialise Trie class and root 
        */                    
        trie = new Trie();
        root  = trie.new Node();
    }

    //INSERT
    public void buildDict(String[] words) {
        /*
        for(int i=0 ; i <= words.length-1;i++){          --iterate through words and insert words in trie
            trie.DFSWordOrderInsertWord(root,dictionary[i]);
        }        
        Time :O(n*l) as we iterate through n words in dict traverse l nodes in tree(l=length of word)                        
        Space:O(l) as we insert l nodes in tree(l=length of word)  )

        */
        for(int i=0 ; i <= words.length-1;i++){
            trie.DFSWordOrderInsertWord(root,words[i]);
        }

     }

     //SEARCH
     public boolean search(String word) {  
        /*
        return trie.DFSWordOrderWordMatchingIsPossible(root,0,1word); -- search word in trie with k different changes allowed 
                                                                       with index = 0; k = 1
        
        TIME: O(l*26 + l)  as for every character of word you move across all children of trie                       
        Space:O(l) as we insert l nodes in tree(l=length of word)  )

        */
  
        return trie.DFSWordOrderWordMatchingWithKDifferenceIsPossible(root,0,1,word);
     }



    
}
