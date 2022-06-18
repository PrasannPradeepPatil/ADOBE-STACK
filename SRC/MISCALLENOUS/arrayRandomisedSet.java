package SRC.MISCALLENOUS;
import java.util.*;

class arrayRandomisedSet {
    /*
    [1,2,3] 
    |
    arrayRandomisedSet(): Initializes the arrayRandomisedSet object.
    add(int val)   :add value to randomised set and return true if not exists  ; return false if exists
    remove(int val):remove item from set and return true if exists; return false if not exists
    getRandom()    :returns a random element from the current set of elements (random meand Each element must have the same probability of being returned and it's guaranteed that at least one element exists when this method is called)
    
    All fns must be implemented in "average" of O(1) complexity
    
    */

    Map<Integer,Integer> map;
    List<Integer> list;
    
    //CONSTRUCTOR
    public arrayRandomisedSet() {
        /*
        {}  --initialise map which will hold vakue as key and its index in our list as value
        []    initialise list which will hold the inserted value
        */
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    //INSERT
    public boolean add(int val) {
        /*
        {1:0,2:1,3:2}     --if map contains value
        [1,2,3]                return false
                            else 
                                add value to last index of list
                                add value and its corresponding index in list ie lastIndex to map
        
        
        Time :O(n)-->adding to list is O(n) worst case; but adding at last index is average O(1)
        Space:O(n) -->For map and list
        */
        if(map.containsKey(val)){
            return false;
        }
        else{
            int lastIndex = list.size();
            list.add(lastIndex,val);
            map.put(val, lastIndex);
            
            return true;
        }
    }
    
    //REMOVE
    public boolean remove(int val) {
        /*
        {1:0,2:1,3:2}     --if map doesnt contains value
        [1,2,3]                return false
                            else 
                                //find the index and last index
                                 find last index of the element to remove from map
                                 find the last index
                                
                                //swap elements at index and lastIndex              -->instead of removing element at index directly
                                 swap elements at index and lastIndex in list         swap element at index and lastIndex and remove element at last index
                                 swap indexes of indexElement and lastIndexElement in map
                                 swap indexElement and lastIndexElement
                                 
                               //remove element at last index
                               remove element at last index in list
                               remove lastIndexElement from map
                                
                                return true
                            }
        
        Time :O(n)-->removing from list is O(n) worst case; but removing at last index is average O(1)
        Space:O(n) -->For map and list
        */
        if(!map.containsKey(val)){
            return false;
        }
        else{
            //find index and lastIndex
            int index  = map.get(val)    ; int indexElement = list.get(index);
            int lastIndex = list.size()-1; int lastIndexElement = list.get(lastIndex);
            
            //swap elements at index and lastIndex
            int temp = indexElement;
            list.set(index,lastIndexElement);
            list.set(lastIndex, temp);
            
            map.put(indexElement,lastIndex);
            map.put(lastIndexElement,index);
            
            indexElement = list.get(index);
            lastIndexElement = list.get(lastIndex);
            
            //remove element at lastIndex 
            list.remove(lastIndex);
            map.remove(lastIndexElement);
            
            return true;

            
        }
        
    }
    
    
    //GETRANDOM
    public int getRandom() {
        /*
        int randomIndex = random.nextInt(0,list.size()); -- this will generate a random number between startIndex and endIndex exclusive
        return list.get(randomIndex);                     --return element at random index in list
        
        Time:O(1)
        Space:O(1)
        */
        Random random = new Random();
        int randomIndex = random.nextInt(0,list.size());
        return list.get(randomIndex);
    }
}