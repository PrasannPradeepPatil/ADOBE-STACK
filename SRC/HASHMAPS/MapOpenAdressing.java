package SRC.HASHMAPS;

public class MapOpenAdressing {
    /*
      MAP
      k,v----> | HashFn |  ---->  k,v    --> k , v pair comes then hashtabe decides index based on key
                                ------    and the key value pair  is stored in hashtable at that index
                                  k,v
                         HashMap, HashTable,HashBucket



    OPEN ADRESSING
    [
    k | v
    K | v   ----> array stores the key value pair
    k | v          hashfn , hashindex ,EntryObject helps decide index , index without collision, arr[hashindex]
                   methods  are calculated based on hashIndex and EntryObject
    ]

     */

     //CONSTRUCTOR AND HELPER FNS
    private int ptr;
    private Entry[] array;
    private class Entry {
        /*
        k |  v  -- entry obj
         */
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public MapOpenAdressing(int size){
        /*
        [ 0        ->ptr
          0
          0
        ]  -- arr that sores Entry Object

         */
         array = new Entry[size];
         ptr = 0;
    }
    private int hashfunction(int key, int i) {
        /*
        RETURNS AN INDEX
        LINEAR PROBING    :return (key % array.length + i) % array.length
        QUADRATIC PROBING :return (key % array.length + i^2) % array.length; 
        DOUBLE HASHING    :return (key%array.length   + i*(prime- key%prime) ) %array.length  )   prime is prime number just less than array length
         */
        return ((key % array.length) + i) % array.length; }
    private int hashIndex(int key) {
        /*
         MAKE SURE INDEX HAS NO COLLISION
         The hash fn produces same index for multiple keys but 1 index can have only 1 EntryObject
         so we need to traverse the array to find empty place


          LINEAR PROBING    :if there is a collision then searches for empty by increasing by i
                             ADV: Small increment in i so we do not fear running out of array length immediately
                             DISADV : Small increment in i causes clustering
          QUADRATIC PROBING :if there is a collision then searches for empty by increasing by i^2
                             ADV: Large  increment in i^2 so no clusterring
                             DISADV :large  increment in i^2  so we do fear running out of array length
          DOUBLE HASHING    :if there is a collision then searches for empty by increasing by prime



         */
        int ptr = 0;
        while (ptr < array.length) {
            int index = hashfunction(key, ptr++);
            var entryObject = array[index];
            if (entryObject == null || entryObject.key == key)
                return index;
        }
        return -1;
    }
    private Entry EntryObject(int key) {
        /*
        ENTRY OBJECT IS ARRAY[HASHINDEX]


        [
         0  -->ptr
         0           calculate the index for the key
         0           if index > 0 return the element at that index else return null
        ]

         */
        var index = hashIndex(key);
        return index >= 0 ? array[index] : null;
    }


   //LOOKUP
    public String get(int key) {
        /*
        [
        |k|v|  --> calculate index and entryObject  for given key
        |k|v|       if entry obj is null return null
        |k|v|       if entry obj not null return entryObject value
                    //EDGE CASE: Check is arr is empty throw ISE()
        ]
           -->ptr
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)

         */

        var index = hashIndex(key);
        var entryObject = EntryObject(key);

        //EDGE CASE
        if(isEmpty())
            throw new IllegalStateException();

        if (entryObject == null)
            return null;
        else {
            return entryObject.value;
        }




    }
    public boolean containsKey(int key){
        /*
       [
       |k|v|  --> calculate index and entryObject  for given key
       |k|v|        if entry obj is null return false
       |k|v|        if entry obj not null preturn true
                    //EDGE CASE: Check is arr is empty throw ISE()
       ]
           --->ptr

        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */
        //EDGE CASE
        if (isEmpty())
            throw new IllegalStateException();
       var index = hashIndex(key);
       var entryObject = EntryObject(key);
        if(entryObject == null){
            return false;
        }
        else {
            return true;
        }


   }
    public boolean containsValue(String value){
       /*
       [
       |k|v|  --> iterate over array
       |k|v|     if entry obj value matches value return true
       |k|v|       //EDGE CASE: Check is arr is empty throw ISE()
       ]
           --->ptr
        Time:O(n)  --considering  search by key calculation is O(1)
        Space:O(n)

           */

       //EDGE CASE
       if(isEmpty())
           throw new IllegalStateException();

       for(var entry : array){
           if(entry.value.equals(value))
               return true;
       }

       return false;



   }
   
    
    //INSERT
    public void put(int key, String value) {
       /*
        [
         0        -->ptr  -> calculate index and entryObject  for given key   ;
         0                   if entryObj is null create new entryObj and put at arr[index] and inc ptr
         0                   if entr obj not null give entryObj value
                             //EDGE CASE: Check is arr is full throw ISE()
        ]

        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)

         */
        //EDGE CASE
        if (isFull()) {throw new IllegalStateException();};

        var index = hashIndex(key);
        var entryObject = EntryObject(key);
        if(entryObject == null){
            array[index] = new Entry(key, value);
            ptr++;}
        else{
            entryObject.value = value;
        }



    }
    public void remove(int key) {
     /*
        [
        |k|v|  --> calculate index and entryObject  for given key
        |k|v|        if entry obj is null return
        |k|v|        if entry obj not null put null at arr[index]
                    //EDGE CASE: Check is arr is empty throw ISE()
        ]
            --->ptr
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

        //EDGE CASE
         if(isEmpty())
             throw new IllegalStateException();

        var index = hashIndex(key);
        var entryObject = EntryObject(key);
        if (entryObject == null) {
            return;
        }
        else {
            array[index] = null;
            ptr--;

        }


    }



    
    //SIZE
    public boolean isEmpty(){
         /*
        [
              -->ptr  ->if ptr is at 0 then e,pty  ;
                        //EDGE CASE: Check is arr is empty not req

        ]

        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)

         */
        return ptr ==0;

    }
    public boolean isFull(){
      /*
        [
        |k|v|
        |k|v|
        ]
            --->ptr -- if ptr at arr.length then it is full
                       //EDGE CASE: If arr is full not req
        Time:O(1)  --considering  search by key calculation is O(1)
        Space:O(n)
        */

        return ptr == array.length;
    }
    public int size(){
       /*
        [
        |k|v|
        |k|v|
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

