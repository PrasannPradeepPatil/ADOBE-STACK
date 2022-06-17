package TRIE;
import java.util.*;

public class TrieSums {

    public void stringCompareNStringsForReplacement(List<String> words,String sentence){
        /*
        sentence = "the cattle was rattled by the battery    - replace every word in sentece with root and 
        words = ["cat","bat","rat"]                         if word can be replaced by more than one root,
        Output: "the cat was rat by the bat"                    replace with shortest root.
                                                                EG :https://leetcode.com/problems/replace-words/

        */
    
        //USING TRIE
        /*
        public String  DFSWordOrderReplaceSentenceWithRoots(List<String> words,String sentence){
            Trie trie = new Trie();                                                         -->Initialise trie and root
            Trie.Node root = trie.new Node();  

            for(int i =0 ; i <= words.size()-1 ; i++){                                    -->Iterate through words of root  
                trie.DFSWordOrderInsertWord(root,words.get(i));                                    insert the word in trie
            }
            
            String[] wordsReplaced = sentence.split(" ");         
            String res = "";
            for(int i =0 ; i <= wordsReplaced.length-1;i++){                                    -->Iterate through words to be replaced 
                res = res + trie.DFSWordOrderWordPrefixIsPossible(root,wordsReplaced[i]);         find the prefixx of the word tp be replaced in trie
                res = res + " ";
            }
            
            return opsentence.substring(0,s.length()-1);                                          -->return opsentence by removing last space as we dont need last space added 

            
        } 
        Time :O(n+ m) -->n is total characters in wordRoot ; m is total characters in sentence
                          O(n):you insert n characters in trie
                          O(m):you search m characters in trie
        Space:O(n + n) >n is total characters in wordRoot ; m is total characters in sentence
                        O(n):you store n characters in trie
                        O(m):you store m characters in res string

        */

    }
    public void StringCompareNStringForAutoComplete(List<Integer> words, String searchWord){
        /*
        words:["card","carry","carma","cmd"] -->Given words
        searchWord:"car"                        Check the words which are autocomplete of searchWord
        */

        //USING TRIE
        /*
        public List<Integer> StringCompareNStringForAutoComplete(List<Integer> words, String searchWord){
            Trie trie = new Trie();                                                         -->Initialise trie and root
            Trie.Node root = trie.new Node();  

            for(int i =0 ; i <= words.size()-1 ; i++){                                    -->Iterate through words of root  
                trie.DFSWordOrderInsertWord(root,words.get(i));                                    insert the word in trie
            }

            return DFSWordOrdertOrderWordSuffixKaList(root,searchWord)                  -->Search trie for all the suffix of given word
        }

        Time :O(n+ m) -->n is total characters in words ; m is total characters in searchWord
                          O(n):you insert n characters in trie
                          O(m):you search m characters in trie
        Space:O(n)    -->n is total characters in wordRoot ; m is total characters in searchWord
                        O(n):you store n characters in trie
        */
    }
    public void stringCompareNStringsForLongestCommonPrefix(List<Integer> words){
        /*
        words ["flower","flow","flight"] -- given list of words find the longest common prefix
                                            Eg words ["flower","flow","flight"] 
                                               longest common prefix = "fl"
        
        */

        //USING MULTIPTR 
        /*
        Look in array multiptr
        */
    }
    public void stringCompareNStringsForLongestCommonPrefixWithWord(List<Integer> words, int word){
        /*
        words ["flower","flow","flown"] -- given list of words find the longest common prefix of all given word with the given words
        word = "flom"                      Eg: ["flower","flow","flown"] word =  "flom"  
                                               longest common prefix with word= "flo"
        
        */

        //USING TRIE
        /*
        
        public void stringCompareNStringsForLongestCommonPrefixWithWord(List<Integer> words, int word){
            Trie trie = new Trie();                                                         -->Initialise trie and root
            Trie.Node root = trie.new Node();  

            for(int i =0 ; i <= words.size()-1 ; i++){                                    -->Iterate through words of root  
                trie.DFSWordOrderInsertWord(root,words.get(i));                               insert the word in trie
            }

            return trie.DFSWordOrderPrefixKaLongestPossibleString(root,word);            -->Search Trie for longest possible prefix
        }

        
        Time :O(n+ m) -->n is total characters in words ; m is total characters in word
                          O(n):you insert n characters in trie
                          O(m):you search m characters in trie
        Space:O(n)    -->n is total characters in wordRoot ; m is total characters in word
                        O(n):you store n characters in trie
        */

    }
    public void matrixWordSearchII(char[][] arr,String[] word){
        /*
        Lokk in Recursion/MATRIX
        */
    }



    
}
