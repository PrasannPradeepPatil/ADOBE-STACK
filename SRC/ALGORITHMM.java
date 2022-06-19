package SRC;

import java.util.*;



public class ALGORITHMM{

    //TIME SPACE COMPLEXITY
    /* #region Main */

    /*
    TIME COMPLEXITY     : no of  iteration wrt  no of inputs (Drop irrelevant terms ie O(n^2 +n) = O(n))
    SPACETIME COMPLEXITY: space wrt ip

    GRAPH -- https://dev.to/victoria/a-coffee-break-introduction-to-time-complexity-of-algorithms-160m

    */
    //O(1)
    /*
    int[]  a = {1,2,3,4,5}
    Sout(a[0])      -->Time: O(1)
                   
    */
    //O(n)
    /*
    for(int i = 0 ; i < = n ; i++)                -->Time : O(n) 
        {sout(a[i])}                                 Space:O(1)
 
    */
    //O(n^2) ; O(n^3)
    /*
    for(int i = 0 ; i < = n ; i++)                   -->Time:O(n*n) = O(n^2)  
        for(int j = 0 ; i < = n ; i++)                  Space:O(1) 
        {sout(a[i])}                                                                                                        
               
    */                                                               
    //O(log2 n) ; O(log3 n)
    /*
    while (left< right)
            int middle = left + (right-right)/2;      -->Time:O(log2 n) as we throw ½ ip at each iteration
            if(array[middle] == item)                     Space:O(1)       
                return middle;

            if(item > array[middle] ){
                left = middle+1;}

            else if(item < array[middle] ){
                right = middle-1;
            }
            


    while (left < right){
            if (array[middle1] == item)         -->Time:O(log3 n) as we throw 1/3  ip at each iteration
                return middle1;                    Space:O(n)       


            if(item < array[middle1]){
                right = middle1-1;
                partiion = (right-left)/3;
                middle1 = left+partiion;
                middle2 = right - partiion;
            }

    */
    //O(n log2 n)
    /*
    for(i = 0 ; I < = n ; i++)
        while (left< right)
                int middle = left + (right-right)/2;         -->Time: O(n log n) as we throw ½ ip at each iteration and we run this n times
                    if(array[middle] == item)                   Space:O(1)       
                        return middle;

                    if(item > array[middle] ){
                        left = middle+1;}

                    else if(item < array[middle] ){
                        right = middle-1;
                    }
        */
    //NOTE
    /*
    SOME   ALGO LOOK  O(N^2) but are O(N) AS THEY RETURN WITHOUT GOING BACK TO OUTER LOOP
    Eg:stringPallindromeWith1deletion()
    */


    /* #endregion */


    //TIME,SPACE COMPLEXITY FOR RECURSION
    /* #region Main */

    /*
    TIME      = no of fn calls*time complexity of each fn because we call fns no of times  and each fn takes certain
    SPACE  = max depth*time complexity of each fn         because fns get accumulated till leaf node and start returning from leaf node
    SPACE  = extra space wrt ip  
    |
    1st is space taken by stack and second is space wrt ip choose  Which space to consider Eg Letcode takes SPACE
    */
    //SINGLE RECURSIVE CALL(ASSUMIG EACH FN TAKES O(1) TIME AND O(1) space)     
    /* 
    sum = sum + sum(n-1)                     --> T =O(n) each fn calls itself once and n reduces by 1
                                                 S =O(n) + O(1) as we have n inputs so n method calls for recursion + no extra space
                                                

    */
    //TWO/THREE  RECURSIVE(ASSUMIG EACH FN TAKES O(1) TIME AND O(1) space)
    /*
    fn(n-1)                                   -->  T = O(2^n)/O(3^n)  each fn calls itself twice/thrice and n reduces by 1
    fn(n-1)                                          S =O(n) + O(1) as we have n inputs so n method calls for recursion + no extra space
                                        
                                            

    public void fnName(int left,int right){
        while (left< right)
        int middle = left + (right-right)/2;      -->T = O(log2 n)/O(log3 n) each fn calls itself once and n reduces by half/one-third
        if(array[middle] == item)                      S =O(n) + O(1) as we have n inputs so n method calls for recursion + no extra space
            return middle;                                  

        if(item > array[middle] ){
            fnName(middle+1,right);}

        else if(item < array[middle] ){
            fnName(left,middle-1);
        }
    */
    //LOOP + SINGLE/TWO/THREE RECURSIVE(ASSUMIG EACH FN TAKES O(1) TIME AND O(1) space)
    /*
    for(i=0 to n)                              -->  T = O(n !)           
        fn(n-1)                                -->  S = O(n)
                                                   Eg:arraySubsetKaArrays

                                     
    */                                     
    //BINARY TREES
    /*
    fn(root.leftchild)           -->T  = O(n) if tree is balanced as we traverse all nodes in tree
    fn(root.rightchilc)                = O(n) if tree is unbalanced completely left/right skewed   as we traverse all nodes in tree
                                    S  = O(h) = O(log2 n)  if tree is balanced    as we traverse entire height 
                                       = O(h) = O(n) if tree is  unbalanced completely left/right skewed   as we traverse all nodes in tree


                                            
    if(){                          -->T = O(log2 n) if tree is balanced   as we traverse throw half nodes in tree 
        fn(root.leftchild)              = O(n)      if tree is  unbalanced completely left/right skewed   as we traverse all nodes in tree
    }                                 S = O(h) = O(logn) if tree is balanced    as we traverse entire height 
    else{                               = O(h) = O(logn) if tree is  unbalanced completely left/right skewed   as we traverse all nodes in tree
        fn(root.rightchilc)  
    }
    */

    /* #endregion */


    //TIME,SPACCE COMPLEXETIES RELATED
    /*                                
    https://gist.github.com/psayre23/c30a821239f4818b0709     
                                AL    LL   STACK  ADQ   PQ   HM     HS                             
    LOOKUP BY INDEX(ACSESS)                                                                                                     
    1.start index               O(1)  O(1)  ---   O(1)  O(1)  ---   ---                               
    2.end   index               O(1)  O(1)  O(1)  O(n)  ---   ---   ---                                       
    3.middle index              O(1)  O(n)  ----  ---   ---   O(1)  ---
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    LOOKUP BY VALUE(SEARCH)
    1.first occurence           O(n)   O(1)  ---   ---   ---   ---   ---
    2.last occurence            O(n)   O(1)  ---   ---   ---   ---   ---
    3.presence                  O(n)   O(n)  O(n)  O(n)  O(n)  O(1)  O(1)

    ADD(INSERTION)
    1.start index               O(n)   O(1)  ---   O(n)  ---    ---  ---
    2.end   index               O(n)   O(1)  O(1)  O(1)  O(logn)---  ---  
    3.middle index              O(n)   O(n)  ---   ---   ---   O(1)  O(1)          

    REMOVE(DELETION)    
    1.start index                O(n)   O(1)  ---   ---   O(logn)---  ---   
    2.end   index                O(n)   O(1)  O(1)  O(1)  ---    ---  ---    
    3.middle index               O(n)   O(n)  ---   ---   ---   O(1)  O(1)          
                                  |                                    |
                                  |                                    |
                         add operations of AL                          |
                         Worts case: O(n),Amortised:O(1)               |
                         as as we do not double and copy arr for       |
                          each operation but only when array is filled |                                                 
                                                                       |
                                                                       |
                                                                    Contains operation of set
                                                                    WorstCase:O(1) ,Average: O(1)
                                                                    as set operation internally use
                                                                    TreeMap and collision may cause logn
    BINARY TREE:
    LOOKUP  :O(n)
    INSERT: :O(n)
    DELETE  :O(n) 


    BINARY SEARCH TREE:
    LOOKUP:O(logn) for balanced BST /O(n) for inbalance completely letf/right skewed
    ADD   :O(logn) for balanced BST /O(n) for inbalance completely letf/right skewed
    DELETE:O(logn) for balanced BST /O(n) for inbalance completely letf/right skewed


    BINARY AVL TREE:
    LOOKUP:O(logn) for balanced BST /O(n) for inbalance completely letf/right skewed but AVL are not unbalanced so logn is worst case complexity
    ADD   :O(logn) for balanced BST /O(n) for inbalance completely letf/right skewed but AVL are not unbalanced so logn is worst case complexity
    DELETE:O(logn) for balanced BST /O(n) for inbalance completely letf/right skewed but AVL are not unbalanced so logn is worst case complexity



    TRIES
    LOOKUP :O(L) -->L is the length of the word
    ADD    :O(L)
    DELETE :O(L)


    GRAPHS
                     ADJACENT MATRIX    ADJACENT LIST/ADJACENCY MAP
    LOOKUP EDGE         
    LOOKUP NODE        
    ADD NODE        O(n)                  O(n)
    ADD EDGE        O(1)                  O(n)
    DELETE NODE     O(n)                  O(n^2)
    DELETE EDGE     O(1)                  O(n)
    SPACE:          O(N^2)               O(N + E)---> Worst case: If graph is dense ie every node connected to every E = V^2 so space: O(v^2)


    SEARCHING ALGORITHMS      
                    TIME         SPACE                                   
    Linear           O(n)          O(1)    -->Array can be unsorted                    
    LinearRecursive  O(n)          O(n)    -->Array can be unsorted   
    Binary           O(log2 n)     O(1)    -->Array must be sorted; Binary > Ternary due to less comparisions    
    BinaryRecursive  O(log2 n)     O(n)    -->Array must be sorted 
    Ternary          O(log3 n)     O(1)    -->Array must be sorted 
    TernaryRecursive O(log2 n)     O(n)    -->Array must be sorted 
    Jump search      O(sqrt(n))    O(1)    -->Array can be unsorted                    
    Exponential      O(log i)      O(1)    -->Array can be unsorted  ;i is the index of element    
                     


    SORTING ALGORITHMS 
                        TIME                        Space
    Bubblesort         O(n^2)    O(n)             O(1)   O(1)     -->Good for completely unsorted array   
    SelectionSort      O(n^2)    O(n^2)           O(1)   O(1)     -->Good for completely unsorted array   
    InsertSort         O(n^2)    O(n)             O(1)   O(1)     -->Good for nearly sorted array
    QuickSortRecursive O(n^2)    O(nlog2n)        O(n)   O(log2n) -->Fastest in best case and less memory in best case 
    MergesortRecursive O(nlog2n) O(nlog2n)        O(n)   O(n)     -->Fastest but requires  memory 
    Count sort         O(n+k)    O(n+k)           O(k)   O(k)     -->Good if array  +ve array elements and max range k is given(both must be given)
    Heap sort          O(nlog2n) O(nlog2n)        O(n)   O(n)     -->Fastest but requires memory 

    */


    //CONSTRAINTS
    /*



    | ----1 <= arr.length <= 10^8---------------
    |    --- 1 <=     a[i]        <= 10^9 -----    |
    |    |                                   |     |
    |    |                                   |     |
    ARRAY| EDGE CASE                         |    DATATYPE(int range = 2*10^9)
    0 ele|ment , 1 element etc               |    constraint    datatype
         |                                   |    0-10^9         int[] arr
         |                                   |    >10^9          long[] arr
    ARRAY ELEMENTS EDGE CASE                 | 
    -ve numbers etc                 TIME COMPLEXITY(time <= 1sec = 10^8) 
                                    constraints    Time complexity(O(log2 n),O(n),O(n^2),O(2^n),O(n!))
                                    10^18          O(lg2n) because  log2(10^8) <= 10^8      
                                    10^8           O(n)    because 10^8 <= 10^8               
                                    10^7           O(n)    because 10^7 <= 10^
                                    10^4           O(n^2)  because (10^4)^2 <=10^8                               
                                    20             O(2^n)  becaue 2^20 <=  10^8             
                                    11             O(n!)   becaue 11! <=  10^8  
    */




    //ALGORITHMS
    public void    iterate(String s,StringBuffer sb, int [] arr , ArrayList<Integer> arrayList ,LinkedList<Integer> linkedList , Stack<Integer> stack,Queue<Integer> queue,PriorityQueue<Integer> priorityQueue,Map<Integer,Integer> map, Set<Integer> set){
        //byte/short,int,long,float,double -->InIterable
        

        //Byte,Short,Integer,Long,Float,Double -->Initerab;e

        //Char -->Initerable

        //Character -->Initerable

        //String -->Initerable
        for(int i = 0 ; i <= s.length()-1;i++){
            System.out.println(s.charAt(i));
        }


        //StringBuffer -->Initerable
        for(int i =0; i <= sb.toString().length()-1;i++ ){
            System.out.println(sb.charAt(i));
        }

        //array -->Iterable
        for(int i =0 ; i <= arr.length-1;i++){
            System.out.println(arr[i]);}
        for (var i: arr){
            System.out.println(i);}

        //arrayList -->Iterable
        for(int i = 0 ; i <= arrayList.size()-1 ; i++){
            System.out.println(arrayList.get(i));
        }
        for(Integer i : arrayList){
            System.out.println(arrayList.get(i));    
        }
    
    
        //linkedList -->Iterable
        for (int i =0 ; i <= linkedList.size()-1 ; i++){
            System.out.println(linkedList.get(i)); }
        for(Integer i: linkedList){
            System.out.println(i);}

        //stack -->Initerable
        while (!stack.isEmpty()) {
            int element = stack.pop();
        }
        while (stack.size() > 0) {
            var element = stack.pop();
        }


        //queue -->Initerab;e
        while (!queue.isEmpty()) {
            int element = queue.remove();
        }
        while (queue.size() > 0) {
            int element = queue.remove();
        }


        //priorityQueue -->Initerab;e
        while (!priorityQueue.isEmpty()) {
            int element = priorityQueue.remove();
        }
        while (priorityQueue.size() > 0) {
            int element = priorityQueue.remove();
        }

        //hashmap -->Initerable
        Set<Integer> keys= map.keySet();
        for(Integer key : keys){
            Integer keyy = key;
        }
        Collection<Integer> values=  map.values();
        for(Integer value:values){
            Integer valuee = value;
        }
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer,Integer> entry : entrySet) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
        }


        //ITERATE HASHSET
        for (Integer key : set) {
            System.out.println(key);
        }
        

    
    }
    public void    frequency(int[] arr){
        //ADDING FREQUENCY
        /* 
        Map<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i <= arr.length-1; i++) {
            if (!map.containsKey(arr[i])) 
                map.put(arr[i], 1);
            else 
                map.put(arr[i], map.get(arr[i]) + 1);
           
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        */


        //ADDING FREQ BEFORE ITERATING ARRAY
        /*
        Adding key value to map and then iterating array causes
        encountering value in both front and back ways
        Eg: 
        count pairs with 2 targer sum
        [1,1,5],target = 6  
        
        populate hashmap  key = ele and value = frq --ptr at 0 -->(1,5) will be counted 
        iterate arr                                   ptr at 1 -->(1,5) will be counted
            diff = target - arr[i]                    ptr at 2 -->(5,1) (5,1) will be counted which are same pairs enc at ptr1 , ptr2
            if(map.containsKey(diff))
                cnt = cnt + map.get(diff)
        */
        
        
        //ADDING FREQ WHILE ITERATING ARRAY
        /*                                    
        Adding key value later on while iterating array causes
        encountering value  only backwards
        Eg: 
        count pairs with 2 targer sum
        [1,1,5],target = 6                                
        iterate arr                                   ptr at 0 -->5 yet not added to map so no pair
            diff = target - arr[i]                    ptr at 1 -->5 yet not added to map so no pair
            if(map.containsKey(diff))                 ptr at 2 -->(5,1) (5,1) will be counted 
                cnt = cnt + map.get(diff)
            populate hashmap  key = ele and value = frq                            

        
        */
        

        
    }
    public void    maxMin(int[] arr){
        int  maxint = Integer.MIN_VALUE;      //If you use max,min values value you have to chech edge case if(max = Int.MAX_VALUE ){} ; if ypu use some value like max = arr[0] etc then you dont neeed to check edge cases 
        int  minint = Integer.MAX_VALUE;      
        char maxchar = Character.MIN_VALUE;           
        char minChar = Character.MAX_VALUE;
        int  maxIndex =0;
        int  minIndex = 0;
       
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= maxint){             // >=  --> if there are duplicated we will get maxvalue and maxIndex will be the last occurence of maxValue EG[3,2,1,2,1,3] MaxValue = 3 ; maxIndex = 5
                maxint = arr[i];             // >  -->if there are duplicated we will get maxvalue and maxIndex will be the first occurence of maxValue EG[3,2,1,2,1,3] MaxValue = 3 ; maxIndex = 0
                maxIndex = i;
            }
            minint = Math.max(arr[i],minint);
            if(arr[i] <= minint){
                minint = arr[i];
                minIndex = i;
            }
            minint = Math.min(arr[i],minint); 
        }




    }
}



 









