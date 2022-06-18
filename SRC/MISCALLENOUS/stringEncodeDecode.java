package SRC.MISCALLENOUS;
import java.util.*;

public class stringEncodeDecode {
    /*
    ["abc","de","eff"]
      |
      |
    encoode() :convert list string  into a sequence of bits(smallest encoded string) 
    decode() :converting back to list of string
    
    */

    public String encode(List<String> list) {
        /*
        ["abc","de","eff"] --"3#abc2#de3#eff" -- convert list of string to unique string(Look in Java/Object/Unique )
         
        Time:O(n) --n is number of strings as we iterate over all strings
        Space:O(1)
        */
        StringBuilder sb = new StringBuilder("");
        for(String s:list){
            sb.append(s.length()).append("#").append(s);
        }
        
        return sb.toString();
    }

    public List<String> decode(String s) {
        /*
        3#abc2#de3#eff" -- ["abc","de","eff"] -- convert  string to list of strings
        |
        ptr                                        --initialise ptr to 0
                                                     while(ptr <= s.length()-1){    
                                                          find hash Index
                                                          find size from ptr to hasIndex exclusive
                                                          find string from hashIndex+1 to hashIndex + size+1  exclusive
                                                          add string to list
                                                          
                                                          move ptr to hashIndex + size +1
                                                
        
        Time:O(n) --n is number of strings as we iterate over all strings
        Space:O(1)
        
        */
        List<String> res = new ArrayList<>();
        
        int ptr  = 0;
        while(ptr <= s.length()-1){
            int hashKaIndex = s.indexOf('#',ptr);
            int size    = Integer.valueOf(s.substring(ptr,hashKaIndex));
            String str  = s.substring(hashKaIndex + 1, hashKaIndex + size +1);
            
            res.add(str);
            
            ptr = hashKaIndex + size +1;
        }
        
        return res;
    }




}
