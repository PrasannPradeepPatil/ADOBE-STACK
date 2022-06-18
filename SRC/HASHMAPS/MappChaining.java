package SRC.HASHMAPS;
import java.util.Arrays;
import java.util.LinkedList;

public class MappChaining {
    /*

      MAP
      K|V ----> | HashFn |  ---->  k,v    --> k , v pair comes then hashtabe decides index based on key
                                   ------    and the key value pair  is stored in hashtable at that index
                                    k,v
                          HashMap, HashTable,HashBucket
        CHAINING
        [
        |k|v|-->|k|v|          -->array stores the Linked List of key value pair
        |k|v|-->|k|v|-->|k|v|      hashfn , hashindex ,LinkedListOfEntrObject helps decide index , index withoutcollision, arr[hashindex];
        |k|v|                      methods are  calculated based on hashIndex and LinkedListOfEntrObject

        ]

     */

   //CONSTRUCTOR AND HELPER FNS
   private LinkedList<Entry> [] arr;
   int ptr;
    private class Entry {
        /*
        k |  v  --> entry obj
       */
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public MappChaining(int size){
        /*
        [ 0  -->  ptr
          0           --> arr that stores LinkedList
          0
        ]

         */
        arr = new LinkedList[size];
        ptr = 0;


    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
    private int hashfunction(int key){
        // RETURNS AN INDEX
        return key% arr.length; }
    private int hashIndex(int key){
        /*
         MAKE SURE INDEX HAS NO COLLISION
         The hash fn produces same index for multiple keys but 1 index can have multiple EntryObject chained in LL
         so we no  traverse the array to find hash index we can directly take hashFn value




         */



        return hashfunction(key);
    }
    private LinkedList<Entry> LinkedListOfEntrObject(int key){
        /*
        LINKEDLISTOFEMTRYOBJECT   IS ARRAY[HASHINDEX]

        [
         0  -->ptr
         0           calculate the index for the key
         0           if index > 0 return the element at that index else return null
        ]

         */
        int index = hashIndex(key);
        return index >= 0  ? arr[index]:null;
    }

  
    //LOOKUP
    public String get(int key){
        /*
        [
        |k|v| --> |k|v|        --> calculate index and LinkedListOfEntrObject  for given key
        |k|v| --> |k|v|-->|k|v|    if  LinkedListOfEntrObject is null return null ;
        |k|v| --> |k|v|            if LinkedListOfEntrObject  not null iterate over  it  and if value matches return value
        ]  --ptr                   //EDGE CASE: If arr is empty throw ISE()

        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

        //EDGE CASE
        if(isEmpty())
            throw new IllegalStateException();


        var index = hashfunction(key);
        var LinkedListOfEntrObject = LinkedListOfEntrObject(key);

        if(LinkedListOfEntrObject != null) {
            for(var i: LinkedListOfEntrObject){
                if(i.key == key ){
                    return i.value;
                }
            }
        }


        return null;




       }
    public boolean containsKey(int key){
        /*
         [
         |k|v| --> |k|v|        --> calculate index and LinkedListOfEntrObject  for given key
         |k|v| --> |k|v|-->|k|v|    if  LinkedListOfEntrObject is null throw ISE () ;
         |k|v| --> |k|v|            if LinkedListOfEntrObject  not null iterate over  it  and if key matches return true ; if n0t found till end throw new ISE()
         ]  --ptr                   //EDGE CASE: If arr is empty ret false;
        
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
          */
        //EDGE CASE
         if (isEmpty())
             return false;
 
 
 
         var index = hashfunction(key);
         var LinkedListOfEntrObject = LinkedListOfEntrObject(key);
         if(LinkedListOfEntrObject == null)
             return false;
 
         for(var i : LinkedListOfEntrObject){
             if(i.key == key)
                 return true;
         }
 
         return false;
 
 
     }
    public boolean containsValue(String value){
         /*
         [
         |k|v| --> |k|v|        --> calculate index and LinkedListOfEntrObject  for given key
         |k|v| --> |k|v|-->|k|v|    iterate over array
         |k|v| --> |k|v|            iterate over LLOEO and if value matches return true
         ]  --ptr                   //EDGE CASE: If arr is empty ret false;
 
         Time:O(n)  --considering  search by key calculation is O(1)
        Space:O(n)
        */
         //EDGE CASE
         if (isEmpty())
             return false;
 
 
 
        for (var LinkedListEntryObject: arr){
            for (var entryObject: LinkedListEntryObject){
                if (entryObject.value.equals(value)){
                    return true;}
            }
 
        }
 
        return false;
 
 
     }
     
 

    //INSERT
    public void put(int key , String value){
        /*
        [ 0  -->  ptr
          0           -->calculate index and LinkedListOfEntrObject  for given key
          0              if LinkedListOfEntrObject  is null give new LLOEO and increment ptr
                         if LinkedListOfEntrObject  is not null iterate over entry obj to find matching key and give value and return if not found key addLast
        ]                //EDGE CASE: Check if arr is full and throw ISE()

        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
         */

        //EDGE CASE
        if(isFull())
            throw new IllegalStateException();


        var index = hashfunction(key);
        var LinkedListOfEntrObject = LinkedListOfEntrObject(key);
        if(LinkedListOfEntrObject == null ){
            arr[index] = new LinkedList<>();
            ptr++;
        }

        for(var i :LinkedListOfEntrObject){
            if(i.key == key){
                i.value = value;
                return;
            }
        }
        LinkedListOfEntrObject.addLast(new Entry(key,value));
    }
    public void remove(int  key){
        /*
        [
        |k|v| --> |k|v|        --> calculate index and LinkedListOfEntrObject  for given key
        |k|v| --> |k|v|-->|k|v|    if  LinkedListOfEntrObject is null throw ISE () ;
        |k|v| --> |k|v|            if LinkedListOfEntrObject  not null iterate over  it  and if key matches remove node decrement cnt and rturn ; if npt found till end throw new ISE()
        ]  --ptr                   //EDGE CASE: If arr is empty throw ISE()

        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

        //EDGE CASE
        if(isEmpty())
            throw new IllegalStateException();

        var index = hashfunction(key);
        var LinkedListOfEntrObject = LinkedListOfEntrObject(key);


        if(LinkedListOfEntrObject == null){
            throw  new IllegalStateException();}
        if(LinkedListOfEntrObject != null){
            for(var i:LinkedListOfEntrObject){
                if(i.key == key){
                    LinkedListOfEntrObject.remove(i);
                    ptr--;
                    return;
                }
            }
        }
        throw new IllegalStateException();//Edge case(notghing found means key entered is wrong):Java throws err so we throw custom err
    }


    //SIZE
    public boolean isEmpty(){
         /*
        [ 0  -->  ptr -->if ptr at 0 arr is empty
          0              //EDGE CASE: arr is empty not req
          0
        ]
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

        return ptr == 0;
    }
    public boolean isFull(){
       /*
        [
        |k|v| --> |k|v|
        |k|v| --> |k|v|-->|k|v|
        |k|v| --> |k|v|
        ]  --ptr  -- if ptr at arr.length then full
                    //EDGE CASE: arr is empty full not  req
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

       return ptr == arr.length;
    }
    public int size(){
       /*
        [
        |k|v|-->|k|v|
        |k|v|-->|k|v|-->|k|v|
        |k|v|
        ]
            --->ptr -- return ptr to know size
                       //EDGE CASE:If arr is empty return 0
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

        if(isEmpty())
            return 0;

        return ptr;

    }



   


}









