package ALGORITHM;
import java.util.*;



public class Recursion{


    public class Node {
      /*
        |value| next|
      */

      private int val;
      private Node next;
      public Node() {//this.value = 0 ; this.next = null(constructor initialises default values)
      }
      public Node(int val) { this.val = val; // this.next = null(constructor initialises default values)
      }
      public Node(int val, Node next) { this.val = val; this.next = next; }
  }
  
   

    //RECURSION 
    /* #region Main */
    //1.RECURSIVE IP-OP TREE(Decsion)
    /*
    //RECURSIVE PATH
                    IP , OP                                                -->same as Binary tree
           /                   \                                              (condition may be there may not be there,op maybe thre may not be there)
          /                     \       
    condition1                 condition2              
  d1   /      \ d2               d1   / \ d2
      /        \                     /   \
IPsmall, OP1  IPsmall, OP2   Ipsmall OP1  Ipsmall , OP2   
        
    //VOID RECURSIVE
    Same as Binary Tree

    //RETURN RECURSIVE
    Same as Binary Tree

    


    */

    //2.DP TOP-DOWN MEMOIZATION(1.Overlapping subproblem ,2.Optmization req)
    /*
                              1.Overlapping subproblem : Fn with same arguements is called more than once in recursive tree 
                                                          function makes one recursive call and is circular     --> fn with same arguements  called
                                                                                            and is not circular --> fn with same args are not called
                                                          function makes two recursive call and on same args    --> fn with same args are  called
                                                                                            on split arrays     -->fn with same args are not called
                              2.Optimization req       : Finding max ,min largest , smallest etc ) 
                              */
    /*
    //MATRIX
    public int fn(changingarg1,changingarg2 , int[][] dp)                          --> INITIALISE  MATRIX AND FILL -1 IN MAIN FN 
                                                                                                                                                                       
    if(dp[changingarg1][changingarg2] != -1){                                      --> CHECK IN MATRIX               
      return dp[changingarg1][changingarg2];}

    dp[changingarg1][changingarg2] =  fn(ca1,ca2);                                 --> STORE RETURN VALUE IN MATRIX
    return dp[changingarg1][changingarg2]  

    OR

    //HASHMAP(CHARG ARE -VE INTEGERS, CHARG ARE NON INTEEGERS) 
    public int fn(changingarg1,changingarg2 , Map<String,Boolean> dp)               --> INITIALISE MAP IN MAIN FN
                                                                                       (KEY: use" " in map as it makes key unique EG charg1 = "a" charg2 = "bc" ; charg1 = "ab" charg2 = "c" then charg1 + charg2 wull be same for both but adding " " will make them unique ) 
                                                                                        GET: use getOrDefault(key,0) in map because there is a possibility that key mught not be present)

    if(map.containsKey(String.valueOf(ca1) + " " +String.valueOf(ca2) ))            --> CHECK IN MAP
       return map.get(key)

    
    map.put(String.valueOf(ca1) + " " +String.valueOf(ca2) , value)                 --> STORE RETURN VALUE IN MAP
    return map.get(key);

    Eg: arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount___ArraySignPermutation()
        stringscrambledPossible()

    //OPTIMIZE STORING RETURN VALUE IN MATRIX  
    CALLING BOTH THE FNS AND THEN STORING THEIR RETURN VALUES IN MATRIX
    int tempAns = fn(arr,i,k) + fn(arr,k+1,j)        
      
    CALLING EACH FN AND  STORING THEIR RETURN  VALUE SIMULTANEOUSLY             
    if(dp[i][k] != -1){                                                     
        int left =  t[i][k]; }
      else{
        int left =  fn(arr,i,k);
        t[i][k] = left; }

      if(dp[k+1][j] =! -1){               
        int right =  dp[k+1][j];}
      else{
        int right =  fn(arr,k+1,j);
        t[k+1][j] = right;}

      int tempAns = left+ right; 

      EG: MCM ALL PROBLEMS

     Time Complexity: reduced from O(2^n) to O(changingarg1*changingarg2))                                       
     Space complexity: O(changingarg1*changingarg2) and also recursion takes stack space and we may get stack overflow)
      */                    
    
   
    //3.DP BOTTOM-UP TABULATION(Same as above)
    /*  
    //MATRIX

                                        int[][] dp = new int[changingArg1+1][changingArg2 + 1];              --> INITIALISE MATRIX
                                                         
    if(charg1 == 0 || charg2 == 0){     for(i = 0 ; i <=charg1 ; i++){                                       -->STORE RETURN VALUE IN MATRIX  BY CONVERTING CHARG1 TO i CHARG2 j
      return 0;}                             for(j =0; j < =charg2  ; j++){}                                  when you use dp[i-1]: i,j=1 to n in rec cond  and i=0 is taken care in base case ka if cond   Eg:allresursionMethods()
                                                if(i==0 || j==0){                                             when you use dp[i-2]: i,j=2 to n in  rec cond and i=0,1 is taken care in base case ka if cond Eg:numberFibonacci() and all its examples
                                                  dp[i][j] = 0}                                                

    
    return max(fn(charg1',charg2') +      for(i = 1/2 ; i <=charg1 ; i++){                                     -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
               fn(charg1'',charg'')        for(j =1/2; j <=charg2  ; j++){                                        when you use dp[i-1]: i,j=1 to n in rec cond  and i=0 is taken care in base case ka if cond   Eg:allresursionMethods()
                                             dp[charg1][charg2] = max(dp[charg1'][charg2']                        when you use dp[i-2]: i,j=2 to n in  rec cond and i=0,1 is taken care in base case ka if cond Eg:numberFibonacci() and all its examples
                                                                     dp[charg1''][charg2'']
                                             )
                                              
                                          return dp[charg1][charg2]                                            -->LAST ELEMENT IN MATRIX IS ANSWER   
    
    OR

    //HASHMAP +LOOOP CHANGE(CHARG IS -VE INTEGERS , CHARG IS NON INTRGRRS )

                                       int min_limit = fn(charg2)                                               -->INITIALISE MIN AND MAX LIMIT OF THE CHARG WHICH IS -VE
                                       int max_limit = fn(charg2)
                                       if(char2 < min_limit && charg2 >max_limit){ret 0;}


                                        Map<String,Integer> map = new HashMap<>();                              --> INITIALISE MAP IN MAIN FN
                                                                                                                    (KEY: use " " while forming key because it makes key unique;  EG charg1 = "a" charg2 = "bc"  GET: use getOrDefault(key,0) in map because there is a possibility that key mught not be present ) 
                                                                                                                   

                                                         
    if(charg1 == 0 || charg2 == 0){     for(i = 0 ; i <=charg1 ; i++){                                             -->STORE RETURN VALUE IN MAP  BY CONVERTING CHARG1 TO i CHARG2 j
      return 0;}                             for(j =min_limit; j < =max_limit  ; j++){}                               (if Charg2 is -ve :j = -minLimit to maxLimit in base cond aand rec cond well  Eg:arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount___ArraySignPermutation()) 
                                                if(i==0 || j==0){                                                      
                                                  map.put(String.valueOf(i) + " " + String.valueOf(j) , 0)                                                

    
    return fn(charg1-1,charg2) +        for(i = 1 ; i <=charg1 ; i++){                                             -->STORE RETURN VALUE IN   MAP BY CONVERTING CHARG1 TO i CHARG2 j
           fn(charg1,charg2-1)            for(j =1/min_limit; j <=max_limit; j++){                                    (same as above)
                                            left = map.getOrDefault(String.valueOf(i-1)  + " " +String.valueOf(j),0)  
                                            right = map.getOrDefault(String.valueOf(i)  + " " +String.valueOf(j-1),0)
                                            map.put(String.valueOf(i)  + " " +String.valueOf(j),left+right)
          
                                              
                                          return map.get(String.valueOf(charg1) + " " + String.valueOf(chatg2))     -->LAST ELEMENT IN MAP IS ANSWER  


    Eg:numberStairCasePermutation() 
      arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount___ArraySignPermutation(),



    Time Complexity: reduced from O(2^n) to O(changingarg1*changingarg2))                                       
    Space complexity:  O(changingarg1*changingarg2) and also no rec so no stackoverflow err          

    */


    /* #endregion */

    //RECURSION
    public void numerIsHappy(int n){
      /*
      Question
      n = 19 -- break the digits of number and add the square of the digits
                do this endlessly and if a loop ends in 1 it is a happy no and if 
                we go in endless loop then nuhappy number
                Eg:
                19
                1^2 + 9^2 = 82
                8^2 + 2^2 = 68
                6^2 + 8^2 = 100
                1^2 + 0^2 + 0^2 = 1

                Eg:
                2
                2^2 = 4
                4^2 = 16
                1^2 + 6^2 = 37
                3^2 + 7^2 = 58
                5^2 + 8^2 = 90
                9^2 + 0^2 = 81
                8^2 + 1^2 = 65
                6^2 + 0^5 = 61
                6^2 + 0^1 = 37 0-- endless loop




                      
      */

      //RECURSIVE IP-OP TREE(Decision:No decision)
      /*
      19
      |
      82
      |
      68
      |           --return numerIsHappy(sum)
      100
      |           --if(n==1) return false
      1             if(visited.cntains)
                      
      public boolean numerIsHappy(int n){
                                        --while going top down
        if(n == 1){                       if n reaches 1 return true and start moving up
            return true;}                 if n is present in visited return true and start moving up
        if(visited.contains(n)){  //visited is a global hashSet 
            return false;}
                                      --while going top-down
        visited.add(n);                  add n to visided(visited is a global hashSet)
        int sum = 0;                     find sum of sqaure of digits
        while(n > 0){
            int digit = n%10;
            n = n/10;
            sum = sum + digit*digit;
        }
                                        --while going bottom-up
        return numerIsHappy(sum);         return numberisHappy(sum)
      }

      //OVERRIDE
      Set<Integer> set = new HashSet<>();
      public boolean numerIsHappy(int n){
        return numerIsHappy(n);
      }

      
      Time:https://leetcode.com/problems/happy-number/solution/ approach1
      Space:https://leetcode.com/problems/happy-number/solution/ approach1

       */

      
      
      
  }
    public void numberCountAndSay(int n, String s , int N){

      /*
      Question
      n = 5
      countAndSay(1) = "1"
      countAndSay(2) = say "1" = one 1 = "11"
      countAndSay(3) = say "11" = two 1's = "21"
      countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
      countAndSay(5) = say "1211" = one 2 + one 2 + two 1 = "12" + "21" "21" = "122121"
      
      */
      
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller ip)
      /*
      
      1
      |
      2
      |
      3
      |   --return numberCountAndSay(n+1, res, N)
      4
      |   -- return s
      5    
      public String  numberCountAndSay(int n, String s , int N){
                                                     --while going top-down
        if(n == N ){                                      if n reaches N return s  which holds res and start moving up
              return s;}                                   
          
                                                        --while going top down 
          String res = "";                                 convert s to equivalenrt countAndSay and store in res and give this res back to s
          int ptr1 = 0;
          while(ptr1 <= s.length()-1){
              int ptr2 = ptr1;
              while(ptr2 <= s.length() -1 && s.charAt(ptr1) == s.charAt(ptr2)){
                  ptr2++;
              } 
              String length = "" + (ptr2 - ptr1);
              String digit = ""  + s.charAt(ptr1);
              res = res + length + digit;
              ptr1 = ptr2;
          }
      
      
                                                           --while going bottom up
        return numberCountAndSay(n+1, res, N);                 return numberCountAndSay(n+1, res, N);
      }

      public String  numberCountAndSay(int n, String s , int N){
        return numberCountAndSay(1,"1",N);
      }
      
      
      
      */

      
  }
    public void arraylinearSearchRecursive(int[] arr ,int item, int ptr){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller ip)
      
      /*
      [1,2,3,4,5]
       ptr
         |
      [1,2,3,4,5]
         ptr
         |
      [1,2,3,4,5]
               ptr

      public void arraylinearSearchRecursive(int[] arr ,int item, int ptr){
                                                      --while going top-bottom
        if(ptr == arr,length){                          if ptr at arr.length
          index = -1;                                   return and start moving up  
          return;}

        if(arr[ptr] == item){                            if ptr == item
          index = ptr;   //index is a global variable       assign index to ptr
          return;                                           return and start moving up
        }
                                                        --while going top -bottom
        arraylinearSearchRecursive(arr,item,ptr+1);            arraylinearSearchRecursive(arr,item,ptr+1);       
      }

      //OVERRIDE
      int index =0;
      public  int    arraylinearSearchRecursive(int[] arr ,int item){
        arraylinearSearchRecursive(arr ,item, 0);
        return index;


      }
 
      TIME : O(n)  -- each fn calls itself once and n reduces by 1
      SPACE: O(n)  -- we have n ips

      */


    }
    public void arrayTwoPointerSearchRecursive(int[] arr , int item ,int ptr1 , int ptr2){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller ptr1,ptr2) 
      /*              
      [1,2,3,4,5]
     ptr1      ptr2
         |
      [1,2,3,4,5]
       ptr1  ptr2
         |
      [1,2,3,4,5]
       ptr2   ptr1

      public void arrayTwoPointerSearchRecursive(int[] arr , int item ,int ptr1 , int ptr2){
    
                                              --while going top-bottom
        if(ptr1 > ptr2){                           if ptr1 > ptr2
          //index = -1; //index is a global var       index = -1
          return;                                      return and start moving up
        }                                       
        if(arr[ptr1] == item) {                    if arr[ptr1] == item
            index = ptr1;                               index = ptr1
            return;                                     return and start moving up
        }
        if(arr[ptr2] == item) {                   if arr[ptr2] == item 
            index = ptr2;                                index = ptr2;
            return;                                      return and start moving up  
        }
                                                            --while going top-bottom
        arrayTwoPointerSearchRecursive(arr,item,ptr1+1,ptr2-1);     arrayTwoPointerSearchRecursive(arr,item,ptr1+1,ptr2-1);
      }

      int index =0;
      public  int arrayTwoPointerSearchRecursive(int[] array,int item){
        arrayTwoPointerSearchRecursive(array , item,0 , array.length-1);
        return index;}

      TIME : O(n)  -- each fn calls itself once and n reduces by 1
      SPACE: O(n)  -- we have n ips

        */
      

      }
    public void arrayBinarySearchRecursive(int[]arr , int item, int left , int right){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
       /*

      [1,2,3,4,5] 
       l   m   r
         |/mid < item  \ mid > item
         /              \
      [1,2,3,4,5]       [1,2,3,4,5]
       l r                     l r
       /\                   /\


      public void    arrayBinarySearchRecursive(int[]arr , int item, int left , int right){

                                                      --while going top-down
        if(left > right){                                if left > right
            index = -1;                                    index =-1
            return;                                        return and start moving up
        } 
        int middle = left+right/2;                  
        if(arr[middle] == item){                         if middle == item
            index = middle;  //index is global               index = middle
            return;                                          return and start moving up 
        }                                               
                                                        --while going top-borttom
                                                          if middle < item
        if(arr[middle] < item){                               arrayBinarySearchRecursive(arr,item,left,middle-1)
          arrayBinarySearchRecursive(arr,item,left,middle-1);   else if middle > item
        }                                                      arrayBinarySearchRecursive(arr,item,middle + ,rght)
        else if(arr[middle] > item){                           |
            arrayBinarySearchRecursive(arr, item, middle+1, right); |
        }                                                      |
                                                              else if because ptr change in if and used in cond as well
      }

      int index =0;
      public  int arrayBinarySearchRecursive(int[]array , int item){
        arrayBinarySearchRecursive(array,item,0,array.length-1);
        return index;
      } 

      TIME : O(log2 n)  -- each fn calls itself once and n reduces by half
      SPACE: O(n)     -- we have n ips

       */






   }
    public void arrayTernarySearchRecursive(int[] array , int item , int left , int right){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
      /*
            [1,2,3,4,5] item = 0         
         |/item < mid1  \ mid1<item<mid2 \ mid2 < item
         /               \                \
       /\                   /\            /\

      public void arrayTernarySearchRecursive(int[] array , int item , int left , int right){
                                                            --while going top-down
        if(left > right){                                       if left > right
            index = -1;                                         index =-1
            return;                                             return and start moving up
        } 
        if(arr[middle1] == item){                               if middle1 == item
            index = middle;  //index is global                     index = middle1
            return;                                                return and start moving up 
        }                                                
        else if(arr[middle2] == item){                           else if middle2 == item
            index = middle;  //index is global                      index = middle2
            return;                                                 return and start moving up 
        }                                       
                                                                --while going top-bottom
        if(item < array[middle1]){                                if item < middle1       
          arrayTernarySearchRecursive(array,item,left,middle1-1);          arrayTernarySearchRecursive(array,item,left,middle1-1);
        }
        else if(array[middle1] < item && item< array[middle2]){   else if   middle1  < item < middle2
            arrayTernarySearchRecursive(array,item,middle1+1,middle2-1);      arrayTernarySearchRecursive(array,item,middle1+1,middle2-1);   
        } 
        else if (arr[middle2] < item){                            else if middle2 < item 
            arrayTernarySearchRecursive(array,item,middle2+1,right);            arrayTernarySearchRecursive(array,item,middle2+1,right);
        }                                                         |
                                                                else if because ptr modifies inside if and is used as condition inside if
      }

        public static int arrayTernarySearchRecursive(int[] array , int item ){
          Arrays.sort(array); 
          return arrayTernarySearchRecursive(array,item,0,array.length-1);
        } 


      TIME : O(log3 n)  -- each fn calls itself once and n reduces by one-third
      SPACE: O(n)     -- we have n ips
      */


  
    }
    public void arrayQuicksortRecursive(int[] array, int left, int right) {
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
       /*
               
      [5, 1, 3 ,2]     
     b l        r                
        /         \
       /           \
    [1, 5, 3, 2]     [1, 5, 3, 2]
  r l,b               b  l     r

    public void    arrayQuicksortRecursive(int[] array, int left, int right) {

                                                            --while going top-bottom
        if (left >= right)                                    if left >= right
            return;                                           return and start moving up
        int boundary = left - 1;                       
        for (var ptr = left; ptr <= right; ptr++)             move ptr from left to right   
            if (array[ptr] <= array[right]){                    if ptr <= right
                boundary++;                                     move boundary ahead
                swap(array, ptr, boundary);                     swap ptr and boundary
        }

                                                                --while going top-down
        arrayQuicksortRecursive(array, left, boundary - 1);       arrayQuicksortRecursive(array, left, boundary - 1);
        arrayQuicksortRecursive(array, boundary + 1, right);      arrayQuicksortRecursive(array, boundary + 1, right);
 
      }


      public static void arrayQuicksortRecursive(int[] array) {
        arrayQuicksortRecursive(array, 0, array.length - 1); 
      }
                             
      TIME : O(n^2)       - iterate till the end ; pivot ends just 1 before end so n divisions
             O(n log2 n)  - iterate till the end;pivot ends in middle exactly so  divisions in half 
      SPACE: O(n)        - pivot falls just 1 before end so we get arrays of same length wrt ip array
             O(log n)    -pivot falls in middle so we get arrays of half length each timewrt ip array

       */
  }
    public void arrayMergesortRecursive(int[] arr) {
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
      /*
                                |            [1,2,3,4,5,6,7]
                                |
                           [7,6,5,1,3,2]   
                [5,6,7]  /                \    [1,2,3]     
                        /                  \      
                     [7,6,5]              [1,3,2]      
                [7]   / \  [5,6]      [1,3] /        \   [2,3]             -return compare2ArraysForMergingI(left,right)
                     /   \                /           \        
                   [7]   [6,5]            [1]           [3,2]    
                      [6] /   \  [5]  [1]  |       [3]  / \  [2]            --return arr
                         /     \           |           /   \ 
                       [6]   [5]        [1]        [3]    [2] 
                          
      public int[]   arrayMergesortRecursive(int[] arr) {   
                                                                                --while   going top-bottom           
        if (array.length == 1)                                                    if arr.length== 1
          return arr;                                                             return arr and start moving up
                                                                        
                                                                                --while going top-bottom
        int mid = array.length/2 ;                                                left holds left sorted arr  
        int[] left = arrayMergesortRecursive(Arrays.copyOfRange(array,0,mid));    right holds right sorted array
        int[] right = arrayMergesortRecursive(Arrays.copyOfRange(array,0,mid));
                                                                                  --while going bottom-top
        return arrayCompare2ArrayForMergingI(left,right);                            merge left and right
                                                                                    return merged sorted array to next node
      }

      //OVERRIDE
      public void  arrayMergesortRecursive(int[] arr){
        int[] arr = arrayMergesortRecursive(arr);
        return arr;
      }
      
      
      TIME : O(nlog2n)   - Divide in half;merge till end iterativelys
             O(nlog2n)   - Divide in half;merge till end iterativelys 
      SPACE: O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 
             O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 


      */

  }
    public void linkedListMergeSortRecursive(Node head){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller arr)
      /*
                                | [1,2,3,4,5,6,7]
                                |
                           [7,6,5,1,3,2]   
                [5,6,7]  /                \    [1,2,3]     
                        /                  \      
                     [7,6,5]              [1,3,2]      
                [7]   / \  [5,6]      [1,3] /        \   [2,3]             -return compare2ArraysForMergingI(left,right)
                     /   \                /           \        
                   [7]   [6,5]            [1]           [3,2]    
                      [6] /   \  [5]  [1]  |       [3]  / \  [2]            --return arr
                         /     \           |           /   \ 
                       [6]   [5]        [1]        [3]    [2]    
                
                          [1,2,3,5,6,7]         
  
      public Node linkedListMergeSortRecursive(Node head){           
               
                                                                                --while   going top-bottom           
        if (head == null || head.next == null))                                   if head == null || head.next == null)
          return head;                                                            return head and start moving up
                                                                        
                                                                                --while going top-bottom
        int mid = array.length/2 ;                                                 left holds left sorted LL  
        Nodr left = linkedListMergeSortRecursive(head);                            right holds right sorted LL
        Node right = linkedListMergeSortRecursive(mid);
                                                                                  --while going bottom-top
        return compare2LLSortedForMerging(left,right);                    merge left and right
                                                                                    return sorted LL to next node
      }
      

      //OVERRIDE
      public Node linkedListMergeSortRecursive(Node head){  
        return linkedListMergeSortRecursive(node);
      }
      
      TIME : O(nlog2n)   - Divide in half;merge till end iterativelys
             O(nlog2n)   - Divide in half;merge till end iterativelys 
      SPACE: O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 
             O(n)        -2 new arrays are formed every time and all arrays  combined take same space as ip array 


       */

     

       

     

}
    public void listInsertionSortRecursive(List<Integer> list) {
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller list)
      /*
          |      [1,5,6,7]  
        [7,6,5,1] 
          |      [5,6,7]
        [7,6,5]
          |      [6,7]        --insert(list,temp)
        [7,6] 
          |      [7]           --return
        [7]

      public void    listInsertionSortRecursive(List<Integer> list) {
                                                            --while going top-bottom
      if(list.size() == 1)                                    if list size == 1
        return;                                                 return and start moving up
      var temp = list.remove(list.size()-1);                 temp = remove last element of list

                                                            --whle going top down
      listInsertionSortRecursive(list);                      listInsertionSortRecursive(list); 
                                               
                                                           --while going bottom-top
      insert(list, temp);                                    insert temp in list
      }

      //INSRERT  --we can insert iteratovely but ques is asking recursively so we do insert also recursively
      item = 3
           |       [1,2,3,4,5]
       [1,2,4,5]   
          |         [1,2,3,4]
        [1,2,4]
          |          [1,2,3]  
        [1,2]
          |      
        [1,2,3]
        private void  insert(List<Integer> l, int item) {   
                                                                  --while going top-bottom
          if(l.size() == 0 || item >= l.get(l.size()-1)){           if list size == 0 || item > list ka last element  
            l.add(item);                                            add item in list
            return;                                                 return and start moving up
          }
          int temp = l.remove(l.size()-1);;                           int temp = l.remove(l.size()-1);

                                                                    --while going top-bottom
          insert(l, item);                                            insert(l,item)

                                                                    --while going bottom-top
          l.add(temp)                                                  insert temp in list
        }


        //OVERRIDE
        public void listInsertionSortRecursive(List<Integer> list) {
          return listInsertionSortRecursive(list);
        }

      TIME :O(2^n) as each fn calls itself twice and n(size of  array) reduces by 1 
      SPACE:O(n) as we have n(size of  array)ips       
      */
      
    }
    public void stackInsertionSortRecursive(Stack<Integer> stack) {
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller stack)
      /*
          |      [1,5,6,7]  
        [7,6,5,1] 
          |      [5,6,7]
        [7,6,5]
          |      [6,7]        --insert(stack,temp)
        [7,6]
          |      [7]          --rturn
        [7]

      public void    stackInsertionSortRecursive(Stack<Integer> stack) {
                                                              --while going top-bottom
        if(stack.size() == 1)                                    if stack size == 1
          return;                                                 return and start moving up

                                                              --whle going top down  
        var temp = stack.pop();                                 var temp = stack.pop();
        stackInsertionSortRecursive(stack);                     stackInsertionSortRecursive(stack);
                                                
                                                            --while going bottom-top
        insert(stack, temp);                                    insert temp in stack
      }



      //INSRERT  --we can insert iteratovely but ques is asking recursively so we do insert also recursively
      item = 3
           |       [1,2,3,4,5]
       [1,2,4,5]   
          |         [1,2,3,4]
        [1,2,4]
          |          [1,2,3]  
        [1,2]
          |      
        [1,2,3] 

        private void  insert(Stack<Integer> stack , int item) {
                                                                  --while going top-bottom
          if(stack.size() == 0 || item >= stack.peek()){            if(stack.size() == 0 || item >= stack.peek())
            stack.push(item);                                       push item in stack
            return; }                                               return and start moving up

          int temp = stack.pop();                                   int temp = stack.pop(); 

                                                                    --while going top-bottom
          insert(stack, item);                                        insert(stack,item)

                                                                    --while going bottom-top
          stack.push(temp);                                             push temp in stack
        }

        //OVERRIDE
        public void  stackInsertionSortRecursive(Stack<Integer> stack) {
          stackInsertionSortRecursive(stack);
        }
        

      TIME :O(2^n) as each fn calls itself twice and n(size of  array) reduces by 1 
      SPACE:O(n) as we have n(size of  array)ips       
      */
      
      

    
    
    }
    public void stringRevereseRecursive(String s){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller str)
      /* 
      helo
       | 
       |
       hel
       |
       |
       he
       |            --return s.charAt(s.length()-1) + ipSmaller 
       |
       h
       |            --return ""
       |
       ""           
     
      public void  stringRevereseRecursive(String s){

                                                                                          --while going top-bottom 
        if(s.length() == 0){                                                                if s.length = 0
          return "";}                                                                        return "" and move up
        
                                                                                          --while going bottom-top
        String ipSmaller = stringRevereseRecursive(s.substring(0,s.length()-1));;   
        return s.charAt(s.length()-1) + ipSmaller
      }


      //
      public String stringRevereseRecursive(String s){
        return stringRevereseRecursive(s);}

      Time:O(n) as  each fn calls itself once and n(length of string) reduces by 1
      Space:O(n) as we have n(length of string) ips
    */



  }    
    public void stackReverseRecursive(Stack<Integer> stack){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller stack)
      /*
          |      [1,5,6,7]  
        [7,6,5,1] 
          |      [5,6,7]
        [7,6,5]
          |      [6,7]      --insert(stack,temp)
        [7,6]
          |      [7]         --return
        [7]

      public void stackReverseRecursive(Stack<Integer> stack){
                                                              --while going top-bottom
        if(stack.size() == 1)                                   if stack size == 1
          return;                                               return and start moving up


                                                              --whle going top down
        var temp = stack.pop();                                 var temp = stack.pop();  
        stackReverseRecursive(stack);                           stackInsertionSortRecursive(stack);
                                                
                                                            --while going bottom-top
        insert(stack, temp);                                    insert temp in stack
      }



      //INSRERT  --we can insert iteratovely but ques is asking recursively so we do insert also recursively
      item = 3
           |       [3,1,2,3,4,5]
       [1,2,4,5]   
          |         [3,1,2,3,4]
        [1,2,4]
          |          [3,1,2]  
        [1,2]
         |           [3,1]       
        [1]
         |                      
        [] 
        private void insert(Stack<Integer> stack, int element){        
        
                                                                 --while going top-bottom
        if(stack.size() == 0)){                                    if(stack.size() == 0 )
          stack.push(item);                                        push item in stacl
          return;}                                                 return and start moving up
     
        
                                                                  --while going top-bottom
        int temp = stack.pop();                                    int temp = stack.pop();
        insert(stack, item);                                       insert(stack,item)

                                                                  --while going bottom-top
        stack.push(temp);                                           push temp in stack

        }

        //OVERRIDE
        public void stackReverseRecursive(Stack<Integer> stack){
            stackReverseRecursive(stack);
        }

        

      TIME :O(n) as each fn calls itself once and n(size of  array) reduces by 1 
      SPACE:O(n) as we have n(size of  array)ips       
      */
      
    }
    public void queueReverseRecursive(Queue<Integer> queue){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller queue)
      /*
          |      [1,5,6,7]  
        [7,6,5,1] 
          |      [1,5,6]
        [6,5,1]
          |      [1,5]      --queue.add(temp)
        [5,1]
          |      [1]         --return
        [1]
      public void queueReverseRecursive(Queue<Integer> queue){
                                                              --while going top-bottom
        if(queue.size() == 1)                                   if queue size == 1
          return;                                               return and start moving up


                                                              --whle going top down
        var temp = queue.remove();                              var temp = queue.pop();  
        queueReverseRecursive(queue);                           queueReverseRecursive(queue);
                                                
                                                            --while going bottom-top
        queue.add(temp);                                      insert temp in queue

      }

      //OVERRIDE
      public void queueReverseRecursive(Queue<Integer> queue){
        queueReverseRecursive(queue)
      }



      TIME :O(n) as each fn calls itself once and n(size of  array) reduces by 1 
      SPACE:O(n) as we have n(size of  array)ips       
      */
  
  
    }
    public void linkedListReverseRecursive(Node head, Node ptr,Node prevptr, Node nextptr){
      /*
        Question
        1--2--3--4--5--null  --remve  full LL
         
 
        5--4--3--2--1
        
        */
 

      //RECURSIVE IP-OP TREE(Decision:No decision take smaller queue)
      /*
      dn --1--2--3--4--5--6
      |      |
      prev   ptr      --initialise  ptr to head ; prevptr to dummyNode;nextptrTemp to dummyNode -- DO IN OVERRIDE FN
                        move ptr till null(ptr to null ;cb enc till lastnode ;ca enc till null) and move prevptr to ptr before moving ptr =>NULL SO THAT PTR MOVES TO NULL AND YOU CAN REVERSE TILL LAST NODE(CODE BEFORE)
                              nextptr = ptr ka next                                              --DO THIS RECURSIVELY IN A RECURSIVE FN
                              ptr ka next  to prevptr                                              AND RETURN PREV NODE AND STORE IN PREV NODE
                              reassingn prevptr to ptr
                              reassign ptr to nextptr
                          
                          reassign head ka next to null                                          --DO IN OVERRIDE FN 
                          reassign head to prevptr a
                          return head                                                                         

                      //NULL CHECK FOR HEAD if(head == null){return null;} 


      public Node linkedListReverseRecursive(Node head, Node ptr , Node prevptr,Node nextptr){
        if(ptr == null)	
            return prevptr;
      
        nextptr = ptr.next;
        ptr.next = prevptr;
        prevptr = ptr;
        ptr = nextptr;
            
        return linkedListReverseRecursive(head,ptr,prevptr,nextptr);
      }

        

      public ListNode reverseList(Node head) {
        if(head == null) return head;

        Node dummyNode = new ListNode(-1);
        dummyNode.next = head;
        
        Node ptr = head;
        Node prevptr = dummyNode;
        Node nextptr = dummyNode;
        
        prevptr =  LinkedListReverseRecursive(head,ptr,prevptr,nextptr);          
        head.next = null;
        head = prevptr;
            
        return head;
      }
    

      TIME :O(n)  
      SPACE: O(1) 
      */
     }
    public void stackDeleteKthElementRecursive(Stack<Integer> stack , int k){
      //RECURSIVE IP-OP TREE(Decision:No decision take smaller stack)
      /*
          k = 3

          |        [7,6,1,2]
        [7,6,5,1,2] 
          |        [7,6,1]             --stack.push(temp)
        [7,6,5,1]
          |        [7,6]               --stack.pop(),return
        [7,6,5]
         

      public void stackDeleteKthElementRecursive(Stack<Integer> stack , int k){ 
                                                              --while going top-bottom
        if(k == 1)                                              if k== 1
          stack.pop();                                          pop element from stack
          return                                                return and start moving up 


                                                              --whle going top down
        var temp = stack.pop();                                 var temp = stack.pop();  
        stackReverseRecursive(stack);                           stackInsertionSortRecursive(stack);
                                                
                                                            --while going bottom-top
        stack.push(temp);                                     push temp in stack

      }

      //OVERRIDE
      public void stackDeleteKthElementRecursive(Stack<Integer> stack , int k){
        stackDeleteKthElementRecursive(stack,k);
      }


      TIME :O(n) as each fn calls itself once and n(size of  array) reduces by 1 
      SPACE:O(n) as we have n(size of  array)ips       
      */
    }
  

    //SUBARRAY/SUBSTRING,SUBSEQUENCE,SUBSET,COMBINATION,PERMUTATION,
    /*
    1.subset = subsequence + [] 
      combination with unique pairs =  subsequence with unique pairs

     


    

    */
    public void    arraySubArrayKaArrays(int[] arr){

      /*
      [1,2,3,4] --find all subarrays of array

      */

     //USING MULTIPOINTERS (ARRAY REQUIRES MULTIPLE PTR) 
     /*
     [1,2,3,4]
      |
      ptr1 -- initialise pt1 to 0
              while(ptr1 <= arr.length-1){                      --move ptr till arr.length(..)
                  int ptr2 = ptr1;                                   initialise ptr2 to ptr1
                  while(ptr2 <= arr.length-1){                       move ptr2 till arr.length(....)
                      int[] subarray = Arrays.COR(arr,ptr1,ptr2+1);    arr from ptr1 tp ptr2 inclusive is subarray
                      result.add(subarray);                            move ptr2 ahead
                      ptr2++;}                                         
                  ptr1++;                                         move ptr1 ahead
                  }
              }

              //return result;
     Time:O(n^2)
     Space:O(1)
     */
      List<int[]> result = new ArrayList<>(); 
      int ptr1 = 0;
      while(ptr1 <= arr.length-1){
        int ptr2 = ptr1;
        while(ptr2 <= arr.length-1){
          int[] subarray = Arrays.copyOfRange(arr,ptr1,ptr2+1);
          result.add(subarray);
          ptr2++;
        }
        ptr1++;
      }

      //return result;


  }
    public void    arraySubsequenceKaArrays(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
      /*
      [1,2,3,4] --find all subset and subsequences of array

      */
    
      //RECURSIVE IP-OP TREE
      /*
              [1,2] []
        1 X  /            \   1_/ 
            /              \
        [2] []            [2] [1]
      2X /    \ 2_/     2X  /    \ 2 _/
        /      \           /      \
      [] []  [] [2]     [][1]     [] [1,2]

      //PAIRS
      public arraySubsequenceKaArrays(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
                                                                    --while coming top-down
        if(ip.size() == 0){                                             if ip.size == 0     
          resultList.add(op);                                           add op to resltList
          return;                                                       return and start moving up 
        }                                           
                                                                    --while coming top-down
        var ipSmaller = ip.subList(1,ip.size());                       ipSmaller = ip.subList(1,ip.size());         
        var op1 = op.subList(0,op.size());                             op1 = op.subList(0,op.size()); 
        var op2 =  new ArrayList<Integer>(op); op2.add(ip.get(0));     op2 =  new ArrayList<Integer>(op) ;op2.add(ip.get(0)); (SUBLIST RETURNS VIEW AND IT CANT BE MODIFIED AND WILL GIVE CONCURRENTMODIFICATIONEXECEPTION)
        arraySubsequenceKaArrays(ipSmaller,op1 , resultList);          arraySubsequenceKaArrays(ipSmaller,op1 , resultList);
        arraySubsequenceKaArrays(ipSmaller,op2 , resultList);          arraySubsequenceKaArrays(ipSmaller,op2 , resultList); 

        return resultList
      }

      //UNIQUE PAIRS
      public arraySubsequenceKaArrays(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList,  Set<Strng> visited){
                                                                    --while coming top-down
        if(ip.size() == 0){                                             if ip.size == 0     
          String uniqueKey = generateUniqueKey(op);                     ele1#ele2#ele3#(sort) --Look in JAVA/OBJECTS/UNIQUE
          if(!visited.contains(uniqueKeyForPairs)){                     if uniqueKeyForPairs not in visited
            resultList.add(op);                                           add op to resltList
            visited.add(uniqueKeyForPairs);                               add uniqueKeyForPairs in visited
          }
          return;                                                       return and start moving up 
        }                                           
                                                                    --while coming top-down
        var ipSmaller = ip.subList(1,ip.size());                       ipSmaller = ip.subList(1,ip.size());         
        var op1 = op.subList(0,op.size());                             op1 = op.subList(0,op.size()); 
        var op2 =  new ArrayList<Integer>(op); op2.add(ip.get(0));     op2 =  new ArrayList<Integer>(op) ;op2.add(ip.get(0)); (SUBLIST RETURNS VIEW AND IT CANT BE MODIFIED AND WILL GIVE CONCURRENTMODIFICATIONEXECEPTION)
        arraySubsequenceKaArrays(ipSmaller,op1 , resultList);          arraySubsequenceKaArrays(ipSmaller,op1 , resultList);
        arraySubsequenceKaArrays(ipSmaller,op2 , resultList);          arraySubsequenceKaArrays(ipSmaller,op2 , resultList); 


        resultList.remove(0);                                         --remove 0th element which is []
        return resultList
      }

      public String generateUniqueKeyForPairs(List<Integer> arr){
         Collections.sort(arr);
         StringBuffer sb = new StringBuffer("");
         for(int i: arr){
             sb.append(i);
             sb.append("#");
         }
         return sb.toString();  
      }

   




      //OVERRIDE
      public void arraySubsequenceKaArrays(int[] ip){                
        List<Integer> ipList = new ArrayList<>();for(var i : arr){ipList.add(i);}
        List<Integer> opList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        arraySubsequenceKaArrays(ipList ,opList,resultList);
        
        resultList.remove(0); 
        return resultList
      }

      TIME :O(2^n) as each fn calls itself twice and n(size of ip) reduces by 1
      SPACE:O(n) as we have n(size of ip) ips

      */
    
      //RECURSIVE IP-OP TREE + FOR
      /*
                
           /     \       \          --recursive tree for "i" inside for loop
           0       1      2           **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion  
          /\      /|\     / | \
         /  \    / | \   /  |  \
         1  2   0 1  2  0  1  2

      //PAIRS
      public void arraySubsequenceKaArrays(int [] arr, int ptr,List<Integer> tempList, List<List<Integer>> resultList){                            
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        resultList.add(new ArrayList<>(tempList));              add tempList to resultList                      Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
                                                        
        for(int i = ptr; i <= arr.length-1; i++){                **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
                                                                --while coming top-down inside for
            tempList.add(arr[i]);                                 add arr[i] to tempList    
          
                                                                          --while goin top-bottom
            arraySubsequenceKaArrays(arr, i + 1, tempList, result);    increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
        }

    

      //UNIQUE PAIRS
      public void arraySubsequenceKaArrays(int [] arr, int ptr,List<Integer> tempList, List<List<Integer>> resultList){                            
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        resultList.add(new ArrayList<>(tempList));              add tempList to resultList                      Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
                                                        
        for(int i = ptr; i <= arr.length-1; i++){                **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
                                                                --while coming top-down inside for
            if(i > ptr && arr[i] == arr[i-1]) continue;           skip duplicate of arr(sort arr in overload method) to get unique subset subsequences ie [1,2,2]  1,2(1st2),2(2nd2) and 1,2(2nd 2),2(1st 2) 
            
            tempList.add(arr[i]);                                 add arr[i] to tempList    
          
                                                                          --while goin top-bottom
            arraySubsequenceKaArrays(arr, i + 1, tempList, result);    increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
        }

    
      //OVERRIDE
      public void arraySubsequenceKaArrays(int[] arr){    
        List<Integer> tempList = new ArrayList<>();            
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
        arraySubsequenceKaArrays(arr,0,tempList,result);
          
        resultList.remove(0); 
        return resultList 
      }



      TIME :O(n!)--> Level1 has n nodes ; Each node on level 1 has n-1 nodes on level 2 ; Each node on level 2 has n-2 node pn level 3
      Space:O(n)     so total nodes would be n*(n-1*(n-2)...))) = n!

      */

    }
    public void    arraySubsetKaArrays(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
      /*
      [1,2,3,4] --find all subset and subsequences of array

      */
    
      //RECURSIVE IP-OP TREE(SAME AS SUBSEQUENCE BUT RESULT.REMOVE(0) NAHI KARNA HAI )
      /*
              [1,2] []
        1 X  /            \   1_/ 
            /              \
        [2] []            [2] [1]
      2X /    \ 2_/     2X  /    \ 2 _/
        /      \           /      \
      [] []  [] [2]     [][1]     [] [1,2]

      //PAIRS
      public arraySubsetKaArrays(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
                                                                    --while coming top-down
        if(ip.size() == 0){                                             if ip.size == 0     
          resultList.add(op);                                           add op to resltList
          return;                                                       return and start moving up 
        }                                           
                                                                    --while coming top-down
        var ipSmaller = ip.subList(1,ip.size());                       ipSmaller = ip.subList(1,ip.size());         
        var op1 = op.subList(0,op.size());                             op1 = op.subList(0,op.size()); 
        var op2 =  new ArrayList<Integer>(op); op2.add(ip.get(0));     op2 =  new ArrayList<Integer>(op) ;op2.add(ip.get(0)); (SUBLIST RETURNS VIEW AND IT CANT BE MODIFIED AND WILL GIVE CONCURRENTMODIFICATIONEXECEPTION)
        arraySubsetKaArrays(ipSmaller,op1 , resultList);               arraySubsetKaArrays(ipSmaller,op1 , resultList);
        arraySubsetKaArrays(ipSmaller,op2 , resultList);               arraySubsetKaArrays(ipSmaller,op2 , resultList); 

      }

      //UNIQUE PAIRS
      public arraySubsetKaArrays(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList,  Set<Strng> visited){
                                                                    --while coming top-down
        if(ip.size() == 0){                                             if ip.size == 0     
          String uniqueKey = generateUniqueKey(op);                     ele1#ele2#ele3#(sort) --Look in JAVA/OBJECTS/UNIQUE
          if(!visited.contains(uniqueKeyForPairs)){                     if uniqueKeyForPairs not in visited
            resultList.add(op);                                           add op to resltList
            visited.add(uniqueKeyForPairs);                               add uniqueKeyForPairs in visited
          }
          return;                                                       return and start moving up 
        }                                           
                                                                    --while coming top-down
        var ipSmaller = ip.subList(1,ip.size());                       ipSmaller = ip.subList(1,ip.size());         
        var op1 = op.subList(0,op.size());                             op1 = op.subList(0,op.size()); 
        var op2 =  new ArrayList<Integer>(op); op2.add(ip.get(0));     op2 =  new ArrayList<Integer>(op) ;op2.add(ip.get(0)); (SUBLIST RETURNS VIEW AND IT CANT BE MODIFIED AND WILL GIVE CONCURRENTMODIFICATIONEXECEPTION)
        arraySubsetKaArrays(ipSmaller,op1 , resultList);               arraySubsetKaArrays(ipSmaller,op1 , resultList);
        arraySubsetKaArrays(ipSmaller,op2 , resultList);               arraySubsetKaArrays(ipSmaller,op2 , resultList); 

        NOTE:Elements are in order so 
            remove [] from resultList to  get subsequence 
            return resultList to  get subset
      }

      public String generateUniqueKeyForPairs(List<Integer> arr){
         Collections.sort(arr);
         StringBuffer sb = new StringBuffer("");
         for(int i: arr){
             sb.append(i);
             sb.append("#");
         }
         return sb.toString();  
      }

   




      //OVERRIDE
      public void arraySubsetKaArrays(int[] ip){                
        List<Integer> ipList = new ArrayList<>();for(var i : arr){ipList.add(i);}
        List<Integer> opList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        arraySubsetKaArrays(ipList ,opList,resultList);
        
        rturn resultList 
      }

      TIME :O(2^n) as each fn calls itself twice and n(size of ip) reduces by 1
      SPACE:O(n) as we have n(size of ip) ips

      */
    
      //RECURSIVE IP-OP TREE + FOR(SAME AS SUBSEQUENCE BUT RESULT.REMOVE(0) NAHI KARNA HAI )
      /*
                
           /     \       \          --recursive tree for "i" inside for loop
           0       1      2           **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
          /\      /|\     / | \
         /  \    / | \   /  |  \
         1  2   0 1  2  0  1  2

      //PAIRS
      public void arraySubsetKaArrays(int [] arr, int ptr,List<Integer> tempList, List<List<Integer>> resultList){                            
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        resultList.add(new ArrayList<>(tempList));              add tempList to resultList                      Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
                                                        
        for(int i = ptr; i <= arr.length-1; i++){                **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
                                                                --while coming top-down inside for
            tempList.add(arr[i]);                                 add arr[i] to tempList    
          
                                                                --while goin top-bottom
            arraySubsetKaArrays(arr, i + 1, tempList, result);    increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
        }

    

      //UNIQUE PAIRS
      public void arraySubsetKaArrays(int [] arr, int ptr,List<Integer> tempList, List<List<Integer>> resultList){                            
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        resultList.add(new ArrayList<>(tempList));              add tempList to resultList                      Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
                                                        
        for(int i = ptr; i <= arr.length-1; i++){               
                                                                --while coming top-down inside for
            if(i > ptr && arr[i] == arr[i-1]) continue;           skip duplicate of arr(sort arr in overload method) to get unique subset subsequences ie [1,2,2]  1,2(1st2),2(2nd2) and 1,2(2nd 2),2(1st 2) 
            
            tempList.add(arr[i]);                                 add arr[i] to tempList    
          
                                                                 --while goin top-bottom
            arraySubsetKaArrays(arr, i + 1, tempList, result);     increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
        }

    

      //OVERRIDE
      public void arraySubsetKaArrays(int[] arr){    
        List<Integer> tempList = new ArrayList<>();            
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
        arraySubsetKaArrays(arr,0,tempList,result);
        
        return resultList 
      }



      TIME :O(n!)--> Level1 has n nodes ; Each node on level 1 has n-1 nodes on level 2 ; Each node on level 2 has n-2 node pn level 3
      Space:O(n)     so total nodes would be n*(n-1*(n-2)...))) = n!

      */















    }
    public void    arrayCombinationKaArray(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
      /*
      [1,2,3,4] --find all combination of array

      */
    
      //RECURSIVE IP-OP TREE + FOR(SAME AS SUBSEQUENCE BUT for(i = ptr;) ke badle for(i=0;))
      /*
                
           /     \       \          --recursive tree for "i" inside for loop
           0       1      2           **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
          /\ \     /|\     / | \
         /  \ \   / | \   /  |  \
         0  1  2  0 1  2  0  1  2
      //PAIR
      public void    arrayCombinationKaArray(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList)                          
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        resultList.add(new ArrayList<>(tempList));              add tempList to resultList                      Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
                                                        
        for(int i = 0; i <= arr.length-1; i++){                 **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
                                                                --while coming top-down inside for
            tempList.add(arr[i]);                                 add arr[i] to tempList   
           
                                                              --while goin top-bottom
            arraySubset(arr, i + 1, tempList, result);           increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
        }

      }

      //UNIQUE PAIR
      public void    arrayCombinationKaArray(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList)                          
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        resultList.add(new ArrayList<>(tempList));              add tempList to resultList                      Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
                                                         
        for(int i = 0; i <= arr.length-1; i++){                 **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
                                                                --while coming top-down inside for
            if(visited.contains(i)) continue;                     skip duplicate in recursive call to get unique permutation ie.Look in above recursuve tree : 0 index ke niche vapis 0 ondex hai to 0 ke baad 0 add nahi karna , same for index 1 same for index 2  
            if(i > ptr && arr[i] == arr[i-1]                      skip duplicate of arr(sort arr in overload method) if the previos element has been visited for prrmutation to get unique subset permutation ie [1,2,2]  1,2(1st2),2(2nd2) and 1,2(2nd 2),2(1st 2) 
              && visited.contains(i-1)) continue;               
            tempList.add(arr[i]);                                 add arr[i] to tempList   
            visited.add(i)                                        add i to visited
           
                                                              --while goin top-bottom
            arraySubset(arr, i + 1, tempList, result);           increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
            visited.remove(i)                                     remove i from visited
        }

      }


      
      //OVERRIDE
      public void arrayCombinationKaArray(int[] arr){    
        List<List<Integer>> resultList = new LinkedList();
        List<Integer> tempList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Arrays.sort(arr);
        arrayCombinationKaArray(arr,0,tempList,resultList,visited);
        return res;
      }

 

      TIME :O(n^n)--> Level1 has n nodes ; Each node on level 1 has n nodes on level 2 ; Each node on level 2 has n node pn level 3
      Space:O(n)     so total nodes would be n*n...n = n^n
      */

    }
    public void    arrayPermutaionKaArray(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){

      /*
      /*
      [1,2,3,4] --find all permutation of array

      */
    
                                                 
                                


      //RECURSIVE IP-OP TREE + FOR(SAME AS SUBSEQUENCE BUT for(i = ptr;) ke badle for(i=0;) and if(templist.size == arr.size) then only add in resultList)
      /*
                
           /     \       \          --recursive tree for "i" inside for loop
           0       1      2            **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
          /\ \     /|\     / | \
         /  \ \   / | \   /  |  \
         0  1  2  0 1  2  0  1  2

      //PAIR
      public void arrayPermutaionKaArray(int [] arr, int ptr,List<Integer> tempList, List<List<Integer>> result, Set<Integer> visited){ 
                                
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        if(tempList.size() == arr.length){                      if templist size reaches arr length              Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
          result.add(new ArrayList<>(tempList));}               add tempList to resultList                     
                                                        
        for(int i = 0; i <= arr.length-1; i++){                  **start from i = ptr in subseq,subset,  i = 0 in combination,permutatuion
                                                                --while coming top-down inside for
            tempList.add(arr[i]);                                 add arr[i] to tempList   
           
                                                              --while goin top-bottom
            arrayPermutaionKaArray(arr, i + 1, tempList, result);     increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
        }

        //UNIQUE PAIR
        public void arrayPermutaionKaArray(int [] arr, int ptr,List<Integer> tempList, List<List<Integer>> result, Set<Integer> visited){ 
                                
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        if(tempList.size() == arr.length){                      if templist size reaches arr length              Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
          result.add(new ArrayList<>(tempList));}               add tempList to resultList                     
                                                        
        for(int i = 0; i <= arr.length-1; i++){
                                                                --while coming top-down inside for
            if(visited.contains(i)) continue;                     skip duplicate in recursive call to get unique permutation ie.Look in above recursuve tree : 0 index ke niche vapis 0 ondex hai to 0 ke baad 0 add nahi karna , same for index 1 same for index 2  
            if(i > ptr && arr[i] == arr[i-1]                      skip duplicate of arr(sort arr in overload method) if the previos element has been visited for prrmutation to get unique subset permutation ie [1,2,2]  1,2(1st2),2(2nd2) and 1,2(2nd 2),2(1st 2) 
              && visited.contains(i-1)) continue;               
            tempList.add(arr[i]);                                 add arr[i] to tempList   
            visited.add(i)                                        add i to visited
           
                                                              --while goin top-bottom
            arrayPermutaionKaArray(arr, i + 1, tempList, result);     increment i and give to ptr


                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last ele,ment from tempList  
            visited.remove(i)                                     remove i from visited
        }
      //OVERRIDE
      public void arrayPermutaionKaArray(int[] arr){    
        List<List<Integer>> resultList = new LinkedList();
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Arrays.sort(arr);
        arrayPermutaionKaArray(arr,0,tempList,resultList,visited);
        return resultList;
      }

  
 

      TIME :O(n^n)--> Level1 has n nodes ; Each node on level 1 has n nodes on level 2 ; Each node on level 2 has n node pn level 3
      Space:O(n)     so total nodes would be n*n...n = n^n

    */
    
     















    }
    public void    arraySubArraySubsequenceSubsetCombinationPermOutationfSizeK(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
      /*
      [1,2,3,4] --find all subarray , subsequence , subset , combination permutation of size k
                  Eg: combination of size 3 with unique pairs 
                  = [2,4],[3,4],[2,3],[1,2],[1,3],[1,4],
      */


      //PAIRS
      /*
      In methods arraySubsequenceKaArrays(); arraySubsetKaArrays();arrayCombinationKaArray(); arrayPermutaionKaArray(); 
      resultList.add(new ArrayList<>(tempList)); 
      KE BADLE
      if(tempList == k){resultList.add(new ArrayList<>(tempList));} 
      */
    
      //UNIQUE PAIRS
      /*
      In methods arraySubsequenceKaArrays(); arraySubsetKaArrays();arrayCombinationKaArray(); arrayPermutaionKaArray(); 
      resultList.add(new ArrayList<>(tempList)); 
      KE BADLE
      if(tempList == k){resultList.add(new ArrayList<>(tempList));} 
      */
                                                 
                                



    }


    //ARRAY -- MULTIPOINTERS
    public int     arraySubArrayKaCharactersKaContinuousKaLongestLength(int[] arr){
        /*
        [1,0,0,1,1,0,1]   -- find all the subarray of  array
                            and find  subarray with continuous 1 and return longest,shortest length
                              Eg:    [1,0,0,1,1,0,1] -- [1] , [1,1] [1] -- return longest subarray ka length = 2
      
        
        */

      //USING MULTIPOINTERS (ARRAY REQUIRES MULTIPLE PTR) 
      /*
      [1,0,0,1,1,0,1]
        |
        ptr   --initialise ptr to 0
                while(ptr <= arr.length-1){              --move ptr till arr.length-1(ptr at arr.length,cb ptr enc till arr.length-1.ca ptr enc till arr.length)
                    if(arr[ptr] == ch){                       if arr[ptr] == ch
                        chCount++;}                             increment chCount
                    else{                                    else
                        chCount=0;}                              reassign chCount to 0
                    maxLength = Math.max(chCount,maxLength);  find the max,min of of chCount
                    minLength = Math.min(chCount,maxLength)
                    ptr++;                                     move ptr ahead
                }
                      
              return maxLength == Integer.MIN_VALUE?0:maxLength;   //null check : check for max , min
              return minLength == Integer.MAX_VALUE?0:minLength;
      
      */

        int ch = 1;
        int chCount =0;
        int maxLength =Integer.MIN_VALUE;
        int minLength =Integer.MAX_VALUE;
        int ptr = 0;
        while(ptr <= arr.length-1){
            if(arr[ptr] == ch){
                chCount++;
            }
            else{
                chCount=0;
            }
            
            maxLength = Math.max(chCount,maxLength);
            
            ptr++;
            
        }
        
        return maxLength == Integer.MIN_VALUE?0:maxLength;
        //return minLength == Integer.MAX_VALUE?0:minLength;
    }
    public int     arraySubArrayKaCharactersEqualOnSplitKaCount(char[] arr){
        /*
        [1,0,1,1,1,0,0,1,0,0]   -- arr is "split" into subarray (arr is split so the subarrau must must add upto array(a = a1 + a2 + a3 )
                                    return no of subarrays with equal characyers of 1,0
                                    EG:[1,0,1,1,1,0,0,1,0,0]  -->[1,0] ,[1,1,1,0,0,1,0.0] \/ --subarrau must add upto array
                                        "[0,1]" , [1,0,0,1] X 
                                              so return 2
        
        */
        
        /*
      [1,0,1,1,1,0,0,1,0,0] 
        |                --initialise ptr to 0
      ptr                 while(ptr <= arr.length-1) -- move ptr to arr.length(ptr at arr.length , cb ptr at arr.length-1,ca ptr at arr.length)
                            if ch is "1"
                                increment ch1Count
                            if ch is "0"
                                increment ch2Count
                            if ch1Count == ch2Count
                                increment noOfSubstrings 
                                reset ch1Count
                                reset ch2Count 
                            move ptr ahead
                        return noOfSubstrings

        Time:O(m)
        
        */
        
        char ch1 = '1';
        char ch2 = '0';
        int ch1Count = 0;
        int ch2Count = 0;
        int noOfSubStrings = 0;
        
        int ptr = 0;
        while(ptr <= arr.length-1){
            if(arr[ptr] == ch1 ){
                ch1Count++;
            }
            else if(arr[ptr] == ch2 ){
                ch2Count++;
            }
            
            if(ch1Count ==ch2Count ){
                noOfSubStrings++;
                ch1Count = 0;
                ch2Count = 0;
                
            }
            
            ptr++;
        }
        
        return noOfSubStrings;
        
    }
    public int     arraySubArrayKaCharactersIncreasingKaLongestLength(int[] arr){
        /*
        s = [1,2,3,4,3,3,6,7]   -- find all the subarray of  array
                                  and find  increasing OR  strictly increasing/non decreasing subarray  ka longest length
                                  Eg:[1,2,3] ,[3,3,6,7]
                                    (non decreasing/increasing subarray)    
                                    [1,2,3]       --largest  increasing  subsequence is  "abc" whose length 3; so return 3
                                    (strictly increasing  subarray)  

        
        */

        /*
        [1,2,3,4,3,3,6,7] 
        | |  
      ptr1 ptr2   --initialise ptr1 ptr2 to 0 and 1
                    if(arr.length == 1){return 1;}      //null check:ptr1 initialised to 1
                    
                    while(ptr1 <= arr.length-1){                                   --move ptr1 till arr.length(cb ptr1 till arr.length-1,ptr1 at arr.length,ca ptr1 enc till arr.lengtg)                
                        while(ptr2 <= arr.length-1 && arr[ptr2] >=/> arr[ptr2-1] ){        move ptr2 till 1 after ptr2 >= ptr2-1(increasing) OR ptr2 >ptr2-1(increasing)(cb ptr2 enc till ptr2 >ptr2-1,ptr2 at 1 after ptr2 >ptr2-1,ca ptr2 enc till 1 after ptr2 >ptr2-1,)                
                            ptr2 ++;}                                                      move ptr2 ahead
                        int length = (ptr2-1) - ptr1 + 1;                                length =(ptr2-1) - ptr1 + 1  as subarray is from ptr2-1 to ptr1
                        maxLength = Math.max(lengtg,maxLength);                          find max and min length
                        minLength = Math.min(lengtg,maxLength); 
                        ptr1 = ptr2;                                                     reassign ptr1 to ptr2
                        ptr2++;                                                          move ptr2 head 
                    }
                    return result;                                                       return result

        
        */

      
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int ptr1 = 0;
        int ptr2 = 1;
        if(arr.length == 1){return 1;}
        
        while(ptr1 <= arr.length-1){
            
            while(ptr2 <= arr.length-1 && arr[ptr2] > arr[ptr2-1] ){
                ptr2 ++;
            }

        
            int length = (ptr2-1) - ptr1 + 1;
            maxLength = Math.max(length,maxLength);
            minLength = Math.min(length,minLength);
            ptr1 = ptr2;
            ptr2++;
        }
        
        return maxLength;
        
        
        
    }
    public int     arraySubarraykaSumKthLargestKaSum(int arr[], int k){ 
        /*
        Question
        [20, -5, -1]   -- find all the subarray of  array
        k=3               find the kth largest sum of all subarrays
                          Eg:[20, -5, -1] 
                            sum of all subarrays is  20, 15, 14, -5, -6, -1
                            and 3rd largest is 14

                          

        */

      //USING MULTIPOINTERS (ARRAY REQUIRES MULTIPLE PTR) 
      /*
      [20, -5, -1]
        |
        ptr1 -- initialise pt1 to 0
                while(ptr1 <= arr.length-1){                      --move ptr till arr.length(..)
                    int ptr2 = ptr1;                                   initialise ptr2 to ptr1
                    while(ptr2 <= arr.length-1){                       move ptr2 till arr.length(....)
                        int sumOfSubarray =0;                                 subarray is from ptr1 to ptr2
                        if(ptr1==0){sumOfSubarray = sumArr[ptr2] - 0;}        sumOfSubarray = sum of subarray upto ptr2 - sum of subarray 1 before ptr1(create a sumArray that stores sum upto given ptr)
                        else{sumOfSubarray = sumArr[ptr2] - sumArr[ptr1-1];}  find  the kth largest subarray from ptr1 to ptr2 using minheap
                        minHeap.add(sumOfSubarray);
                        if(minHeap.size() > k){
                            minHeap.remove();
                        }
                        ptr2++;}                                          move ptr2 ahead            
                    ptr1++;                                               move ptr1 ahead
                    }
                }

        //sumArray()
        [20, -5, -1]
        []
          |
          p1,p2   --initiaise ptr1 ptr2 to 1
                    sumArr[0] = arr[0];                                       --initialise sumArray  ka 0th element to arr ka 0th element                  
                    while(ptr1 <= arr.length-1 && ptr2 <= sumArr.length-1){   --move ptr till arr.length(ptr at arr.length,cb ptr at arr.length-1,ca ptr at arr.length)
                        sumArr[ptr2] = sumArr[ptr2-1] + arr[ptr1];                    sumArray ka ptr1 = sumArray ka 1 before ptr1 + arr ka ptr2
                        ptr1++;                                                       move ptr1 ahead
                        ptr2++;                                                       move ptr2 ahead
                    }

        */
      int[] sumArr = new int[arr.length];
      // int[] sumArr = sumArray(arr);
        
      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> ();   
      int ptr1 =0;
      while(ptr1 <= arr.length-1){
          int ptr2=ptr1;
          while(ptr2 <= arr.length-1){
              int sumOfSubarray =0;
              if(ptr1==0){sumOfSubarray = sumArr[ptr2] - 0;}
              else{sumOfSubarray = sumArr[ptr2] - sumArr[ptr1-1];}
              
              minHeap.add(sumOfSubarray);
              if(minHeap.size() > k){
                  minHeap.remove();
              }
              ptr2++;
              
          }
          ptr1++;
      }
      

      return minHeap.peek();

      /*
      public int[ ]  sumArray(int[] arr){
            int[] sumArr = new int[arr.length];
            int ptr1 = 1;
            int ptr2 = 1;
            sumArr[0] = arr[0];
            while(ptr1 <= arr.length-1 && ptr2 <= sumArr.length-1){
                sumArr[ptr2] = sumArr[ptr2-1] + arr[ptr1];
                ptr1++;
                ptr2++;
            }
            return sumArray;
      }
    
        */
  }

 
    //ARRAY -- MULTIPOINTERS SORT+SEARH
    public int     arraySubsequenceKaCharactersConsecutiveAnyOrderKaLongestLength(int[] arr){
      /*
      [100,4,200,1,3,2,4] -- find all the subsequence of arr 
                            find the longest subsequence with consecutove numbers in any order
                            Eg :[100,4,4,200,1,3,2]  -- 4,1,2,3 so return 4
      
      */

      //USING -MULTIPOINTERS SORT SEARCH(ARRAY REQUIRES SORTING)-->Time: O(nlogn + n); Space:O(1)
      /*
      //SORT
      [100,4,4,200,1,3,2] -- [1,2,3,4,4,100]

      //SEARCH
      [1,2,3,4,4,100]
         |
         ptr --   initialise ptr to 1, length to1
                  while(ptr <= arr.length-1){                                       --move ptr to arr.length(..)
                      if(arr[ptr] == arr[ptr-1]){                                         if(arr[ptr] == arr[ptr-1]) 
                          while(ptr <= arr.length-1 && arr[ptr] == arr[ptr-1]){               move ptr ahead till  arr[ptr] == arr[ptr-1] 
                              ptr++;                                                          because we dont want to include duplicates in length
                          }
                      }                                                                   else
                      else{                                                                    if arr[ptr] - arr[ptr-1] == 1
                          if(arr[ptr] - arr[ptr-1] == 1){                                          increment length
                              length++;                                                         else
                          }                                                                         find the max of all length           
                          else{                                                                     reset length to 1
                              maxLength = Math.max(length,maxLength);                     move ptr ahead
                              length = 1;
                          }
                          ptr++;
                      }  
                  }  
                  
                  return Math.max(length,maxLength);                                  --again calculate max of length and maxLength 
                                                                                         because maxLength is calculated in else part 
                                                                                         which may nevr be encountered
                                                                                         Eg:[0,1,2,3,4,5]





      Time:Time: O(nlogn + n)
      SpaceLO(1)
      
      */
      /*
      Arrays.sort(arr);

      int ptr = 1;
      int length =1;
      int maxLength= Integer.MIN_VALUE;
      while(ptr <= arr.length-1){
          if(arr[ptr] == arr[ptr-1]){
              while(ptr <= arr.length-1 && arr[ptr] == arr[ptr-1]){
                  ptr++;
              }
          }
          else{
              if(arr[ptr] - arr[ptr-1] == 1){
                  length++;
              }
              else{
                   maxLength = Math.max(length,maxLength);
                  length = 1;

              }
               ptr++;
              
          }  
      }  
      
      return Math.max(length,maxLength);
      */

      //USING HASHMAP(ARRAY REQUIRES STORING) -->-->Time: O( n); Space:O(n)
      /*
      [100,4,200,1,3,2,4] --{1:1        --iterate array and populate hashmap with element as key and count as value
                              2:1          iterate hashmap
                              3:1              x = i.getKey()
                              4:1              if map does not contain x-1 means x may be start of the consecutive sequence
                              100:1               y = x+1
                            }                    while map contains y
                                                      increment y
                                                  length = y-x
                                                  find max of all lengths

      Time:O(n)
      Space:O(n)
      */                                            
      /*
      Map<Integer,Integer> map = new HashMap<>();
      for(int i = 0 ; i <= arr.length-1;i++){
          map.put(arr[i],map.getOrDefault(arr[i],0)+1);
      }
      
      int maxLength = Integer.MIN_VALUE;
      for(var i:map.entrySet()){
          int x = i.getKey();
          if(!map.containsKey(x-1)){
              int y  = x+1;
              while(map.containsKey(y)){
                  y++;
              }
              int length = y-x;
              maxLength = Math.max(length,maxLength);
              
          }
      }
      
      return maxLength;
      */

      return 0;

    }
  


    //ARRAY -- MULTIPOINTERS SLIDING WINDOW
    /*
    IDENTIFY
    ARRAY KA SUBARRAY/SUBSTRING OF SIZE K   -- FIXED SIZE SLIDING WINDOW
    ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY -- VARIABLE SIZE SLIDING WINDOW
                                               REASON
                                                Convert t O(n^2) to O(n) by  avoiding repetition in calculations
                                                Eg: array subset of size 3 largest sum
                                                [1,2,3,4]  -- for(i = o ; i < arr.length ; i++){  -- 1 + 2 + 3   -- 2 + 3 is being repeated 
                                                    ||               for(j = i ; j < 3 ; j++){          2 + 3 + 4  
                                                    ij                  sum = sum + arr[j]            






    FIXED SIZE SLIDING WINOW
    [1,2,3,4]       -- while(ptr2 <= arr.length-1)         -->move ptr2 till arr.length(ptr2 at arr.length ; cb enc till arr.length-1; ca enc till arr.length)
    ||                      
ptr1,ptr2               if(ptr2 -ptr1 <= k-2)               if(ptr2 -ptr1 <= k-2)  (ptr2 at k-1,cb ptr2 enc till k-2,ca ptr2 enc till k-2 ie  this loop encounters till 1 less than window size)
                            calulation for ptr2
                             move ptr2 ahead 
                        else                               else(ptr2 at k-1 ie at window size )
                            calculation for ptr2
                            calculation for window as you have got your window from ptr1 to ptr2 
                            calculations for ptr1 remove
                            ptr1++;                              
                            ptr2+=



    VAIABLE SIZE SLIDING WINDOW
    [1,2,3,4]       -- while(ptr2 < arr.length)-1                         -->move ptr2 till arr.lenhth (ptr2 at arr.length  ; code before ptr2 till arr.length-1 ; code after ptr2  till arr.length) 
    ||                  calculation for ptr2                                 calculation outside condition because so that ptr2 can be before k,at k , after k
    i j                 if(condition <  k)                                   if(condition < k)       (ptr2 is at condition < k)
                                move ptr2 ahead                                       
                        else if(conditions == k)                             else if(condition == k) (ptr2 is at  condition = k)
                            calculation for window as you have got your window from ptr1 to ptr2 
                            move ptr2 ahead
                        else if(conditions > k)                               else if(condition >k)   (ptr2 is at condition > k)
                                while(ptr1 <= ptr2 -1 && condition > k)            move ptr1 till condition >k (ptr1 till condition >k)
                                    calc for ptr1 remove 
                                    move ptr1 ahead 
                                if(condition == k)                                 if(condition == k)  (ptr2 at condition = k)
                                        calculation for window as you have got your window from ptr1 to ptr2     
                                move ptr2 ahead                         


    
    */
    public int   arraySubarrayKaSizeKMaxMinSumKaSum(int[] arr ,int k){
      /*
      Question
      [1,2,3,4,5]  -- find  all subarrays of size k  
                      return the maximum/minimum sum of the subararys
                      Eg 
                      [1,2,3] - 6   ;[2,3,4] - 9;[3,4,5] - 12  -- return max = 12 ; min = 6
      */

      //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
      /*
      [1,2,3,4,5,6]                 
      ||
  ptr1 ptr2   --  initialise ptr1,ptr2 to 0
                  while(ptr2 <= arr.length-1){   -->move ptr2 till arr.length(ptr2 at arr.length,cb ptr till arr.length-1,ca ptr till arr.length)    
                      
                      if(ptr2-ptr1  <= k-2){           if ptr2-ptr1 <=k-2 (ptr2 reaches k-1 , cb ptr2 enc till k-2 ie 1 before window size)
                          sum = sum + arr[ptr2];          add ptr2 to sum
                          ptr2++                          move ptr2 ahead
                      }
              
                      else{                            else(ptr2 reached  k-1 ie at window size )
                          sum = sum + arr[ptr2];             add ptr2 to sum 
                          max = Math.max(max,sum);           find max of all sum 
                          sum = sum - arr[ptr1];             remove ptr1 from sum
                          ptr1++;                            move i ahead    
                          ptr2++;                            move j ahead
                      }
              }
              
              return max/min;

      Time : O(n )   as we reduce n(length of arr) by 1 
      Space: O(1) 
      */

      int ptr1 = 0;
      int ptr2 = 0;

      int sum = 0;
      int maxSum = Integer.MIN_VALUE;
      int minSUm = Integer.MAX_VALUE;
      while(ptr2 <= arr.length-1){
          
          if(ptr2-ptr1 <= k-2){
              sum = sum + arr[ptr2];
              ptr2++;
          }
          else{
              sum = sum + arr[ptr2];
              maxSum = Math.max(sum, maxSum);
              minSUm = Math.min(sum, minSUm);

              sum = sum - arr[ptr1];
              ptr1++;
              ptr2++;
          }
      }


      return maxSum;
  }
    public int[] arraySubArrayKaSizeKFirstNegativeNumbersKaNumbers(int[] arr , int k){
        /*
        Question
        [1,-7,6,2,3]  --find all  subarrays of size k  
                        return 1st negative numbers in all subarrays if -ve number doesnt exist rturn 0;
                        Eg 
                        [1,-7,6] - -7  ;[-7,6,2]  - -7 ;[6,2,3]   - 0  ---- return [-7,-7,0]
        */


        //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
        /*
        [1,-7,-6,2,3,4]                 
        ||
        ptr1,ptr2  --initialise ptr1,ptr2 to 0
                  while(ptr2 <= arr.length-1){        -->move ptr2 till arr.length(ptr2 at arr.length ; cb enc till arr.length-1; ca enc till arr.length)
                    if(ptr2-ptr1 <= k-2){               if ptr2-ptr1 <= k-2 (ptr2 at k-1,cb ptr2 enc till k-2,ca ptr2 cnc till k-2 ie 1 before window siez)
                        
                        if(arr[ptr2] < 0){                     add ptr2 to negativeList if arr[ptr2] <0
                            negativeList.add(arr[ptr2]);       because you want  1st -ve integer followed by next -ve integer
                        }
                        ptr2++;                                 move ptr2 head
                    }
                    else{                                  else (ptr2 reaches k-1 ie at window size)
                        if(arr[ptr2] < 0){                         add ptr2 to negativeList if arr[ptr2] <0
                            negativeList.add(arr[ptr2]);           because you want  1st -ve integer followed by next -ve integer
                        }
                        
                        if(negativeList.size() == 0){             add 1st element of negatove list to result          //null check if negativeList is empty
                            result.add(0);                         because it is the 1st negative number if subarray 
                        }
                        else{
                            result.add(negativeList.get(0)){
                        }
                        
                        if(negativeList.size() != 0){              remove ptr1 from negativeList if arr[ptr1] == negativeList.get(0) //null check if negativeList is empty
                            if(arr[ptr1] == negativeList.get(0)){  because if ptr1 is itself 1st negative ypu dont want it in next subarray 
                                negativeList.remove(0);
                            }    
                        }
  
                        ptr1++;                                    move ptr1 ,ptr2 ahead
                        ptr2++;
                    }
            
            

        Time : O(n )   as we reduce n(length of arr) by 1 
        Space: O(1) 
        */


        int ptr1 = 0;
        int ptr2 =0;
        List<Integer> negativeList  = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while(ptr2 <= arr.length-1){
            if(ptr2-ptr1 <= k-2){
                if(arr[ptr2] < 0){
                    negativeList.add(arr[ptr2]);
                }
                ptr2++;
            }
            else{
                if(arr[ptr2] < 0){
                    negativeList.add(arr[ptr2]);
                }
                
                if(negativeList.size() == 0){
                    result.add(0);
                }
                else{
                    result.add(negativeList.get(0));
                    
                }
                
                if(negativeList.size() != 0){
                    if(arr[ptr1] == negativeList.get(0)){
                        negativeList.remove(0);
                    }    
                }
                
                
                
                ptr1++;
                ptr2++;
            }
            
            
        }
        
        //return result;
        return null;


    }
    public int[] arraySubArrayKaSizeKMaxNumbersKaNumbers(int[] arr, int k) {

        /*
        Question
        [1,2,3,4,5]  -- find  all subarrays of size k  
                        return the max and min in all  the subararys
                        Eg 
                        [1,2,3 ] - 3  ;[ 2,3,4 ]  -4 ;[3,4,53] -53  --return [3,4,53]
                                  
        */

        //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
        /*
        [7,3,6,5,4,2]
        ||
        ptr1 ptr2 - initialise ptr1 , ptr2 to 0
                    while(ptr2 <= arr.length-1){                                  -->move ptr2 till arr.length(ptr2 at arr.length,cb ptr till arr.length-1,ca ptr till arr.length)    
                        
                        if(ptr2 - ptr1 <= k-2){
                            
                            int ptrr = maxList.size()-1;                            if ptr2-ptr1 <=k-2 (ptr2 reaches k-1 , cb ptr2 enc till k-2 ie 1 before window size)
                            while(ptrr >= 0 && maxList.get(ptrr) < arr[ptr2]){          add ptr2 to maxList before that remove all elements strictly smaller that ptr2 (< not <= ) ; 
                                    maxList.remove(ptrr);                                because you want max element at beginning followed by next max element
                                    ptrr--;                                          
                            }
                            maxList.add(arr[ptr2]);                                     
                            ptr2++;                                                       move ptr2 ahead
                            
                        }
                        else{                                                        else (ptr2 reaches k-1 ie at window size)
                            int ptrr = maxList.size()-1;                                   add ptr2 to maxList before that remove all elements strictly smaller that ptr2 (< not <= ) ;  
                            while(ptrr >= 0 && maxList.get(ptrr) < arr[ptr2]){             because we want max element at beginning followed by next max element
                                    maxList.remove(ptrr);
                                    ptrr--;}
                            maxList.add(arr[ptr2]);                                 
                            result.add(maxList.get(0));                                     add 1st element of maxList to result 
                                                                                            because  it is largest element of the subarray

                            if(arr[ptr1] == maxList.get(0)){                                remove ptr1 from maxList if ptr1 == maxlist(0)  
                                                                                            because if the ptr1 element is itself max element then we need to remove it so that it doesnt come in next subarray else if 1st element is not a max element we need not emove it 
                                maxList.remove(0);}
                            ptr1++;                                                         move ptr1 ahead
                            ptr2++;                                                         move ptr2 ahead
                        }
                    }
                    
                    
                    return result;



            Time : O(n )   as we reduce n(length of arr) by 1 
            Space: O(1) 
        */

        
            
            

        int ptr1 =0;
        int ptr2 =0;
        List<Integer> maxList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        while(ptr2 <= arr.length-1){
            
            if(ptr2 - ptr1 <= k-2){
                
                int ptrr = maxList.size()-1;
                while(ptrr >= 0 && maxList.get(ptrr) < arr[ptr2]){
                        maxList.remove(ptrr);
                        ptrr--;
                }
                maxList.add(arr[ptr2]);

                
                ptr2++;
                
            }
            
            else{
                int ptrr = maxList.size()-1;
                while(ptrr >= 0 && maxList.get(ptrr) < arr[ptr2]){
                        maxList.remove(ptrr);
                        ptrr--;
                }
                maxList.add(arr[ptr2]);
                
                result.add(maxList.get(0));
                
                if(maxList.get(0) == arr[ptr1]){
                    maxList.remove(0);
                }
                
                
                ptr1++;
                ptr2++;
            }
        }
        
        
        //return result;
        return null;
    }
    public int   arraySubarrayKaSizekOddElementsMinCountKaCount(int[] arr,int k){
        /*
        Question
        [1,4,3,2,5] k=3 -- find  all subarrays of size k  
                          in each  subarray  count no of odd
                          return min count
                            Eg 
                            [1,4,3] -2 ;[4,3,2]-1 ;[3,2,5] -2  --return 1

        */

        //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
        /*
        [1,4,3,2,5] 
        ||
        ptr1 ptr2 - initialise ptr1 , ptr2 to 0
                    while(ptr2 <= arr.length-1){                                  -->move ptr2 till arr.length(ptr2 at arr.length,cb ptr till arr.length-1,ca ptr till arr.length)    
                        if(ptr2 - ptr1 <= k-2){                                         if ptr2-ptr1 <=k-2 (ptr2 reaches k-1 , cb ptr2 enc till k-2 ie 1 before window size)
                            if(arr[ptr2] %2!=0 ){count++;}                                add ptr2 to count if arr[ptr2] is odd
                            ptr2++;                                                      move ptr2 ahead                            
                        }
                        else{                                                        else (ptr2 reaches k-1 ie at window size)
                          if(arr[ptr2] %2!=0){count++;}                                   add ptr2 to count if arr[ptr2] is odd
                            minCount = Math.min(count,minCount);                          find the min of all counts
                            if(arr[ptr1] %2!=0){count--;}                                   remove ptr1 from count if arr[ptr1] is odd
                            ptr1++;                                                        move ptr1 pt2r ahead
                            ptr2++;
                        }
                    }
                    
                    
                    return result;



            Time : O(n )   as we reduce n(length of arr) by 1 
            Space: O(1) 
        */

        
            
        
        int ptr1 = 0;
        int ptr2 = 0;
        int count =0;
        int minCount = Integer.MAX_VALUE;
        while(ptr2 <=arr.length-1 ){
            if(ptr2-ptr1<= k-2){
                if(arr[ptr2] %2 !=0 ){count++;}
                ptr2++;
            }
            else{
                if(arr[ptr2] %2 != 0){count++;}
                minCount = Math.min(count,minCount);
                if(arr[ptr1] %2 != 0){count--;}
                ptr1++;
                ptr2++;
                
                
            }
            
        }
        return minCount;
        
    }
    public int   arraySubarrayKaSumDivisionMinimiseMaximumKaSum(int[] arr){
        /*
        Question
        arr = [10,20,30,40] ; noOfdivion= n(consider 2)
        Divide arr into given 2 subarrays 
        and "mimimize" the "maximum sum" among subarrays 
        Eg: scheme1 : [10]      ;[20,30,40] - max(10,90) = 90
            scheme2 : [10,20]   ;[30,40]    - max(50,70) = 70  ---- min = 60 
            scheme3 : [10,20,30];[40]       - max(60,40) = 60                         
            
        
        */

        //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
        //                                      Array division:No of divisions = 2
        //                                      
        /*
        [10,20,30,40]    
        |   |
        ptr1 ptr2       --initialisse ptr1 to 0 and ptr2 to 1
                            int sum1 = arr[ptr1];                     --sum1 = ptr1
                            int sum2 = 0;                               sum2 = ptr2 tll end of arr                            
                            while(ptr2 <= arr.length-1 ){               max = max(sum1,sum2)
                                sum2 = sum2 + arr[ptr2];ptr2++;}        result = min(result,max)
                            
                            max = Math.max(sum1,sum2);
                            result = Math.min(result,max);
                            
                            ptr1++;                                     --move ptr1 ahead
                            while(ptr1 <= arr.length-2){                --move ptr1 till arr.length-1(ptr1 at arr.length-1, cb ptr1 enc till arr.length-2)
                                sum1 = sum1 + arr[ptr1];                     add ptr1 to sum1
                                sum2 = sum2 - arr[ptr1];                     remove ptr1 from sum2
                                max = Math.max(sum1,sum2);                   max = max(sum1,sum2)   
                                result = Math.min(result,max);               result = min(result,max)
                                
                                ptr1++;                                       move ptr1 ahead
                            }
                            
                            
                            return result;                               return result
        
        
        */
        int max = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
            
        int ptr1 = 0;
        int ptr2 = 1;
        int sum1 = arr[ptr1];
        int sum2 = 0;
        while(ptr2 <= arr.length-1 ){sum2 = sum2 + arr[ptr2];ptr2++;}
        
        max = Math.max(sum1,sum2);
        result = Math.min(result,max);
        
        ptr1++;
        while(ptr1 <= arr.length-2){
            sum1 = sum1 + arr[ptr1];
            sum2 = sum2 - arr[ptr1];     
            
            max = Math.max(sum1,sum2);
            result = Math.min(result,max);
            
            ptr1++;
        }
        
        
        return result;

        //USING MULTIPOINTERS BINARY SEARCH  -
        //                                      Array division:No of divisions = any
        /*
        Look in MULTIPOINTERS BINARY SEARCH
        */
        


    }
    public int   arraySubarrayKaSumDivisionMaximiseMinimumKaSum(int[] arr){
        /*
        Question
        arr = [10,20,30,40] ; noOfdivion= 2
        Divide arr into given 2 continuous subarrays 
        and "maximise" the "minimum sum" among subarrays 
        Eg: scheme1 : [10]      ;[20,30,40] - min(10,90) = 10
            scheme2 : [10,20]   ;[30,40]    - min(30,70) = 30  ---- max = 40 
            scheme3 : [10,20,30];[40]       - min(60,40) = 40      
        */

        //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
        //                                      Array division:No of divisions = 2
        //                                      
        /*
        [10,20,30,40]    
        |   |
        ptr1 ptr2       --initialisse ptr1 to 0 and ptr2 to 1
                            int sum1 = arr[ptr1];                     --sum1 = ptr1
                            int sum2 = 0;                               sum2 = ptr2 tll end of arr                            
                            while(ptr2 <= arr.length-1 ){               max = max(sum1,sum2)
                                sum2 = sum2 + arr[ptr2];ptr2++;}        result = min(result,max)
                            
                            max = Math.max(sum1,sum2);
                            result = Math.min(result,max);
                            
                            ptr1++;                                     --move ptr1 ahead
                            while(ptr1 <= arr.length-2){                --move ptr1 till arr.length-1(ptr1 at arr.length-1, cb ptr1 enc till arr.length-2)
                                sum1 = sum1 + arr[ptr1];                     add ptr1 to sum1
                                sum2 = sum2 - arr[ptr1];                     remove ptr1 from sum2
                                max = Math.max(sum1,sum2);                   max = max(sum1,sum2)   
                                result = Math.min(result,max);               result = min(result,max)
                                
                                ptr1++;                                       move ptr1 ahead
                            }
                            
                            
                            return result;                               return result
        
        
        */
        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        
        
        int ptr1 = 0;
        int ptr2 = 1;
        int sum1 = arr[ptr1];
        int sum2 = 0;
        while(ptr2 <= arr.length-1 ){sum2 = sum2 + arr[ptr2];ptr2++;}
        
        min = Math.min(sum1,sum2);
        result = Math.max(result,min);
        
        ptr1++;
        while(ptr1 <= arr.length-2){
            sum1 = sum1 + arr[ptr1];
            sum2 = sum2 - arr[ptr1];     
            
            min = Math.min(sum1,sum2);
            result = Math.max(result,min);
            
            ptr1++;
        }
        
        
        return result;
        
        //USING MULTIPOINTERS BINARY SEARCH  -
        //                                      Array division:No of divisions = any
        /*
        Look in MULTIPOINTERS BINARY SEARCH
        */
        

    }
    public int   arraySubArrayKaSumEqualsKKaLongestShortestKaLengthAndStringAndCount(int[] arr , int k){

        /*
            Question
            [4,2,1,1,2,3,5]  -- find  all subarrays of sum k  
                                return the longest/shortest subararys size OR print  longest/shortest subararys OR number of such subarrays 
                              Eg k = 5
                              [4,1];[2,3];[1,1,1,2]; [5]    -- return longest subarray [1,1,1,2] size = 4 ;shortwst subarray size [5] size = 1; no of subarray = 4
      
            */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY )
        //                                                 Arr must have positive integers(>0 not >=0) because moving ptr1 ahead in while cond doesnt guarantee a smaller woindow which satisfies the condition
        //                     
        /*
        [4,2,1,1,2,3,5]                  
        ||                          int ptr1=0                                 -->initialise ptr1,ptr2, long sum(as addns may lead to overflow),
      ptr1 ptr2                     int ptr2 = 0    
                                    long sum = 0    
                                    while(ptr2 <= arr.length-1){                     -->move ptr2 till arr.length (ptr2 at arr.length ; cb ptr2 till arr.length-1; ca enc till arr.length)
                                        sum = sum + ptr2                                add ptr2 to sum
                                        if(sum < k)                                     if(sum <k)          (ptr2 at  sum < k)
                                            ptr2++                                            move ptr2 ahead
                                        else if(sum == k)                                 else if(sum == k) (ptr2 at sum = k)
                                            maxLength = Math.max(ptr2-ptr1+1, maxLength);     window is from ptr1 to ptr2 
                                            minLength = Math.min(ptr2-ptr1+1, minLength);     find max ,min of window lengths , startIndex for max min window lengths , increment numberOfSubArray 
                                            if(ptr2-ptr1+1 >= maxLength){                   
                                                maxLength = ptr2-ptr1+1;                       move ptr2 ahead
                                                startIndex = ptr1;}
                                            if(ptr2-ptr1+1 <= minLength){
                                                minLength = ptr2-ptr1+1;
                                                startIndex = ptr1;}
                                            numberOfSubArray++;
                                            ptr2++                                            
                                        else if(sum > k)                                  else if(sum >k) (ptr2 at sum > k)
                                                while(ptr1 <= arr.length-1 && sum > k)       move ptr1 till sum > k (ptr1 till sum > k)
                                                    sum = sum - arr[ptr1]                        remove ptr1 from sum
                                                    ptr1++;                                      move ptr1 ahead
                                                if(sum == k)                                if(sum == k) (ptr1 at sum = k)
                                                  maxLength = same as above                     window is from ptr1 to ptr2 
                                                  minLength = same as above                     find max ,min of window lengths , startIndex for max min window lengths , increment numberOfSubArray 
                                                  startIndex = sameAsAbove
                                                  numberOfSubArray++;
                                            ptr2++                                          move ptr2 ahead      

                                if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
                                return maxLength/minLength                                 
                                return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
                                return return numberOfSubstring;


        Time : O(n )   as we reduce n(length of arr) by 1 
        Space: O(1) 
        */
    
        /*
        int ptr1 = 0;
        int ptr2 = 0;
        long sum = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int numberOfSubArray = 0;
        int startIndex = 0;

        while(ptr2 <= arr.length-1){
            sum = sum + arr[ptr2];

            if(sum <k){
                ptr2++;
            }

            else if(sum == k){
                maxLength = Math.max(ptr2-ptr1+1, maxLength);
                minLength = Math.min(ptr2-ptr1+1, minLength);
                if(ptr2-ptr1+1 >= maxLength){
                    maxLength = ptr2-ptr1+1;
                    startIndex = ptr1;
                }
                if(ptr2-ptr1+1 <= minLength){
                    minLength = ptr2-ptr1+1;
                    startIndex = ptr1;
                }
                numberOfSubArray++;

                ptr2++;
            }

            else if(sum > k){
                while(ptr1 <= arr.length-1 && sum > k){
                    sum = sum - arr[ptr1];
                    ptr1++;
                    if(sum == k) {
                        //maxLength = same as above
                        //minLength = same as above
                        //startIndex =same as above
                        numberOfSubArray++;
                    }
                }
                ptr2++;
            }


            }

            
        if(maxLength= Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring;}
        if(minLength= Integer.MAX_VALUE){retur 0 ; return new int[0], return numberOfSubstring;}
        return maxLength/minLength;
        return Arrays.copyOfRange(startIndex,startIndex+maxLength/minLength +1)
        return numberOfSubstring;
        */
        
        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE WITH PRESUM(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY )
        //                                                              Arr can  have positive,negative and 0
    
        /*
        [10,5,2,7,1,9] k = 15
        |
        ptr  --int ptr1 = 0;                           -->initialise ptr1,ptr2, long sum(as addns may lead to overflow),
               int ptr2 = 0;
               long sum =0;
                while(ptr <= arr.length-1){                  --move ptr till arr.length(ptr at arr.length , cb ptr enc till arr.length-1 , ca ptr enc till arr.length)
                    sum = sum + arr[ptr];                            add ptr to sum
                    
                    if(sum == k){                                      if sum == k  then         
                        int length = ptr-0+1                              window  from 0 to ptr is valid window 
                        maxLength = Math.max(length,maxLength);           find  longest ,shortest length and string and count  
                        minLength = Math.min(length,minLength);
                        if(length>=maxLength){startIndex=0;}  
                        if(length<=minLength){startIndex=0;}            
                        noOfSubArray++;   }

                    if(mapp.containsKey(sum - k)){                         if(mapp.containsKey(sum - k))                                                 
                        int length = ptr - (mapp.get(sum-k) +1)+1;           window  from map.get(sum-k) +1,ptr is valid 
                        maxLength = Math.max(length,maxLength);              find  longest ,shortest length and string and count  
                        minLength = Math.min(length,minLength);               Eg:[10,5,2,7,1,9] ; k = 15
                        if(length>=maxLength){startIndex=mapp.get(sum-k) +1}     Consider ptr at 4 -->sum = 25,k = 15; mapp =  {10:0,15:1,17:2,24:3,25:4}   
                        if(length<=minLength){startIndex=mapp.get(sum-k) +1}     25-15 = 10 means there was a subarray with sum 10      
                        noOfSubArray= noOfSubArray+map.get(sum-k);               remove subarray with sum 10(sum-k) from subarray with sum 25(sum)      
                                                                                 you get subarray with sum 15(k)     
                                                                                 so subarray is from [mapp.get(sum-k) +1 ,ptr]                                                                                                                                 
      
                    map.put(sum,map.getOrDefault(sum,0)+1);           add sum as key and freq of sum as value
                    if(!mapp.containsKey(sum)){mapp.put(sum , ptr); } add sum as key and index of sum as value
                    
                    ptr++;                                             move ptr ahead

                }               
                if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
                return maxLength/minLength                                 
                return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
                return return numberOfSubstring;

        Time:O(n)
        Space:O(n)
        */
        /*
        int ptr = 0;
        long sum = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int noOfSubArray = 0;
        

        Map<Integer,Integer> mapp = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        while(ptr <= arr.length-1){
            sum = sum + arr[ptr];
            
            if(sum == k){
                int length = ptr-0+1;  
                maxLength = Math.max(length,maxLength);
                minLength = Math.min(length,minLength);
                if(length>=maxLength){startIndex=0;}    
                if(length<=minLength){startIndex=0;}    
                noOfSubArray++;

            }
            if(mapp.containsKey(sum - k)){
                int length = ptr - (mapp.get(sum-k) +1)+1; 
                maxLength = Math.max(length,maxLength);
                minLength = Math.min(length,minLength);
                if(length>=maxLength){startIndex=mapp.get(sum-k) +1;}    
                if(length<=minLength){startIndex=mapp.get(sum-k) +1} 
                noOfSubArray= noOfSubArray+map.get(sum-k);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
            if(!mapp.containsKey(sum)){
                mapp.put(sum , ptr);    
            }
            ptr++;

          }               
          if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
          return maxLength/minLength                                 
          return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
          return return numberOfSubstring;
  
        
        */
    
        return 0;
    
    }
    public int   arraySubArraySumAtMostKKaLongestShortestKaLengthAndStringAndCount(int[] arr, int k){
       /*
        Question
        [2,3,1,2,4,3]  -- find  all subarrays of sum at most  k 
                            return the longest/shortest subararys size OR print  longest/shortest subararys OR number of such subarrays 
                            
    
        */

    
        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE WITH PRESUM(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY )
        //                                                              Array must have positive,negative and 0  because moving ptr1 ahead in while cond doesnt guarantee a smaller woindow which satisfies the condition
        /*
        [1,2,3]
         ||
     ptr1 ptr2 
          --int ptr1 = 0;                                                     -->initialise ptr1,ptr2, long sum(as addns may lead to overflow),
            int ptr2 = 0;
            long sum = 0;
            int noOfSubstrings = 0;
            int maxLength = Integer.MIN_VALUE;
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;
            int sum = 0;
            while( ptr2 <= arr.length-1 ){                                      --move ptr2 till arr.length-1
                sum = sum + arr[ptr2];                                                 add ptr2 to sum
                
                if(map.size() > k){                                                 if noOfDisdinctCharacters > k
                    while(ptr1 <= ptr2 && map.size() > k){                             while(ptr1 <= ptr2 && noOfDisdinctCharacters > k){                         
                        sum = sum - arr[ptr1]                                             remove ptr1 from sum                                     
                        ptr1++;                                                            move ptr1 ahead
                    }
                }                                                                        
                maxLength = Math.max(maxLength,ptr2-ptr1+1);                       window from ptr1 to ptr2 is window with at most k distinct elements  
                minLength = Math.min(minLength,ptr1-ptr1+1);                       so all windows from ptr1 to ptr2 ie [ptr1,ptr1],[ptr1,ptr1+1]..[ptr1,ptr2] are window with at most k distinct elements
                if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}                   calculate maxLength,minLength,startIndex,noOfSubstring     
                if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;}
                noOfSubstrings+=ptr2-ptr1+1;                
                
                ptr2++;                                                           move ptr2 ahead
            } 
            if(maxLength = Integer.MIN_VALUE){return 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
            return maxLength/minLength;                                
            return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
            return  numberOfSubstring;

        Time:O(n)   as we reduce n(length of arr) by 1 
        Space: O(1) 
        
        */
 
        /*
        int ptr1 = 0;
        int ptr2 = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int noOfSubstrings = 0;
        long sum = 0;
        while( ptr2 <= arr.length-1 ){
            sum = sum + arr[ptr2];
            
            if(map.size() > k){
                while(ptr1 <= ptr2 && map.size() > k){ 
                    sum = sum - arr[ptr1];
                    ptr1++;
                }
            }
        
                  
            maxLength = Math.max(maxLength,ptr2-ptr1+1);
            minLength = Math.min(minLength,ptr1-ptr1+1);
            if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}
            if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;}
            noOfSubstrings+=ptr2-ptr1+1;        
            ptr2++;
        } 
        
        // if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
        // return maxLength/minLength                                 
        // return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
        return  noOfSubstrings;
    
        */



        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY )
        //                                                 Arr must have positive integers(>0 not >=0)
        /*
        Difficult to do for at  most  
        */
        /*
        Difficult to do for at  most  
        
        
        */
    
        return 0;

    }
    public int   arraySubArrayKaSumAtleastKKaLongestShortestKaLengthAndStringAndCount(int[] arr , int k){
      /*
        Question
        [2,3,1,2,4,3]  -- find  all subarrays of sum atleast k 
                            return the longest/shortest subararys size OR print  longest/shortest subararys OR number of such subarrays 
                            
    
        */

      //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY )
      //                                                 Arr must have positive integers(>0 not >=0)  because moving ptr1 ahead in while cond doesnt guarantee a smaller woindow which satisfies the condition
      /*
        [4,2,1,1,2,3,5]                  
         ||
     ptr1 ptr2 
          --int ptr1 = 0;                                                      -->initialise ptr1,ptr2, long sum(as addns may lead to overflow),
            int ptr2 = 0;
            long sum =0;
            int noOfSubstrings = 0;
            int maxLength = Integer.MIN_VALUE;
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;

            Map<Integer,Integer> map  = new HashMap<>();
            while( ptr2 <= arr.length -1 ){                                        --move ptr2 till arr.length-1
                sum = sum + arr[ptr2];;                                               add ptr2 to sum
                
                if(sum >= k){                                                        if sum >= k
                    while(ptr1 <= ptr2 && sum >= k){                                   while(ptr1 <= ptr2 && sum >= k){   
                                                                                                           
                        maxLength = Math.max(maxLength,arr.length-1-ptr2+1);               window from ptr1 to ptr2 is window with at least k distinct elements  
                        minLength = Math.min(minLength,ptr2-ptr1+1);                       so all windows from ptr2 to s.length-1 ie [ptr2,ptr2],[ptr2,ptr2+1]..[ptr2,s.length-1] are window with at least k distinct elements
                        if(arr.length()-1-ptr2+1 >= maxLength){startIndex = ptr1;}         calculate maxLength,minLength,startIndex,noOfSubstring     
                        if(ptr2-ptr1+1<= minLength){startIndex = ptr1;}
                        noOfSubstrings+=arr.length-1 - ptr2 + 1;           

                        sum = sum - arr[ptr1];                                             remove ptr1 from sum
                        ptr1++;                                                            move ptr1 ahead
                    }
                }

                ptr2++;                                                           move ptr2 ahead
            } 
            if(maxLength = Integer.MIN_VALUE){return 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
            return maxLength/minLength;                                
            return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
            return  numberOfSubstring;

        Time:O(n)   as we reduce n(length of arr) by 1 
        Space: O(1)   
        */ 
      /*
        int ptr1 = 0;
        int ptr2 = 0;
        long sum = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int noOfSubstrings = 0;
        while( ptr2 <= arr.length-1 ){
             sum = sum + arr[ptr2];
            
            if(sum >= k){
                while(ptr1 <= ptr2 && sum >= k){ 
                    noOfSubstrings += arr.length-1 -ptr2+1;                
                    maxLength = Math.max(maxLength,arr.length-1 -ptr2 + 1);
                    minLength = Math.min(minLength,ptr2-ptr1+1);  
                    if(arr.length-1-ptr2+1 >= maxLength){startIndex = ptr1;}     
                    if(ptr2-ptr2+1<= minLength){startIndex = ptr1;}
                    noOfSubstrings+=arr.length-1 - ptr2 + 1;  

                    sum = sum - arr[ptr1];
                    ptr1++;
                }
            }

            ptr2++;
        } 
        
        // if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
        // return maxLength/minLength                                 
        // return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
        return  noOfSubstrings;

       */

      //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE WITH PRESUM(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY )
      //                                                              Arrcan can have positive,negative and 0  
      /*
       []
        ||
      ptr1,ptr2 --                                         //INITIALISE
          int ptr1 = 0;                                   initialise ptr1,ptr2, long sum(as addns may lead to overflow),
          int ptr2 = 0;
          int maxLength = Integer.MIN_VALUE;
          int minLength = Integer.MAX_VALUE;
          int startIndex = 0;
          int noOfSubstring = 0;
          long sum  = 0;
                                                            //PREFIX  SUM
          long[] prefixSum = new long[arr.length+1];       prefix will hold sum between subarrays 
          for (int i = 0; i <= arr.length-1; i++) {        ie prefixSum[j] -prefixSum[i] will give sum of
              sum += arr[i];                               subarray betweenw i and j excluding j
              prefixSum[i+1] = sum;
          }

                                                          //QUEUE
          Deque<Integer> queue = new ArrayDeque<>(     -->queue will hold possible indexes for ptr1 where sum increases
                                                          in sliding window you blindly increase ptr1 when we meet conditions to shrink window size 
                                                          but here we move  ptr1 only when sum is increasing 
        
                                                                                              //MOVE PTR2 AND SHRINK PTR1 ONLY ON INCREASING SUM
          while(ptr2 <= arr.length){                                                        -->move ptr2 till arr.length not arr.length -1 
            if(!queue.isEmpty() && prefixSum[ptr2] -prefixSum[queue.peekFirst()] >0 ){            if sum of subarray bw possible ptr1 and ptr2 >=0 means sum is increasing 
                while (!queue.isEmpty() && prefixSum[ptr2] - prefixSum[queue.peekFirst()] >= k) {   while sum of subarray bw possible ptr1 and ptr2 >=k 
                    ptr1 = queue.removeFirst();                                                        window is from ptr1 to ptr2-1 as prefixsum holds sum i to j exclusive
                                                                                                      calculatelongest/shortest length and string and count
                    maxLength = Math.max(maxLength,ptr2-1 - ptr1 + 1);
                    minLength = Math.min(minLength, ptr2-1 - ptr1 + 1);
                    if(ptr2-1 - ptr1 + 1 <= minLength ){startIndex =ptr1; }
                    if(minLength >= ptr2-1 - ptr1 + 1  ){startIndex = ptr1;}
                    noOfSubstring++;
                }         
            }
            if(!queue.isEmpty() &&  prefixSum[ptr2] - prefixSum[queue.peekLast()]<=0 ){            if sum of subarray bw possible ptr1 just before ptr2  and ptr2<= 0 means sum is decreasing
                while (!queue.isEmpty() &&  prefixSum[ptr2] <= prefixSum[queue.peekLast()] ) {        while sum of subarray bw ptr2 and possible ptr1 just before ptr2 >=k 
                    queue.removeLast();                                                                   remove ptr1 closest to ptr2 from queue to keep only ptr1 positions with increasing sum in queue
                }            
            }

              
            queue.addLast(ptr2);                                                                 add ptr2 to queue
            ptr2++;                                                                              move ptr2 ahead
          }                                                                                            |
                                                                                                       |
          if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring}     |
          return maxLength/minLength;                                                                  |
          return Arrays.copyOfRange(startIndex,si+maxLength/minLength)                                 |
          return noOfSubstring;                                                                        |
                                                                                                       |
          EXPLANATIONS<---------------------------------------------------------------------------------|
          arr = [2,7,3,-8,4,10] ; k = 12
          prefixSum = [0,2,9,12,4,8,18]

          PTR2  = 0
          [2,7,3,-8,4,10]    []   --ps[ptr2] = 0
          ||                       sum of subarr >0 but sum of subarray !>= k  
        p1 p2                      so add ptr2 to queue and move ptr2 ahead

        [2,7,3,-8,4,10]    [0]   
          |  |                      
        p1  p2 


          PTR2 = 1
          [2,7,3,-8,4,10]    [0]   --ps[ptr2] = 2 ; ps[queue.peekFirst()] = 0 ; ps[queue.peekLast()] = 0; 
          |  |                       sum of subarr >0 but sum of subarray !>= k 
        p1  p2                       add ptr2 to queue and move ptr2 ahead
          [2,7,3,-8,4,10]    [0,1]     
          |    |                       
        p1     p2 

        
          PTR2  = 2
          [2,7,3,-8,4,10]    [0,1]  --ps[ptr2] = 9 ; ps[queue.peekFirst()] = 0 ; ps[queue.peekLast()] = 2; 
          |    |                      sum of subarr >0 and  sum of subarray >= k 
        p1    p2                      so shrink windw my moving ptr1 ahead untill  sum of subarray >= k 
                                      add ptr2 to queue and move ptr2 ahead
                                      
        [2,7,3,-8,4,10]    [2]       
            |    |                       
          p1    p2                            

        
          PTR2 = 3
          [2,7,3,-8,4,10]    [2]    --ps[ptr2] = 12 ; ps[queue.peekFirst()] = 9 ; ps[queue.peekLast()] = 9; 
            |    |                    sum of subarr >0 and  sum of subarray >= k 
            p1   p2                   so shrink windw my moving ptr1 ahead untill  sum of subarray >= k 
                                      add ptr2 to queue and move ptr2 ahead
                                        
                                  
          [2,7,3,-8,4,10]    [3]     
               |    |                       
               p1   p2                            

          ......

          As you can see we move ptr2 ahead and move ptr1 ahead to shrink window 
          only when increasing sum subarray is found


      Time:O(n)   as we reduce n(length of arr) by 1 
      Space: O(n) as we use queue  
       
      */ 
      /*
      int ptr1 = 0;
      int ptr2 = 0;
      int maxLength = Integer.MIN_VALUE;
      int minLength = Integer.MAX_VALUE;
      int startIndex = 0;
      int noOfSubstring = 0;
      long sum  = 0;
      
      long[] prefixSum = new long[arr.length+1];
      for (int i = 0; i <= arr.length-1; i++) {
          sum += arr[i];
          prefixSum[i+1] = sum;
      }

      
      Deque<Integer> queue = new ArrayDeque<>();
      while(ptr2 <= arr.length){
        
        if(!queue.isEmpty() && prefixSum[ptr2] -prefixSum[queue.peekFirst()] >0 ){
            while (!queue.isEmpty() && prefixSum[ptr2] - prefixSum[queue.peekFirst()] >= k) {
                ptr1 = queue.removeFirst();

                maxLength = Math.max(maxLength,ptr2-1 - ptr1 + 1);
                minLength = Math.min(minLength, ptr2-1 - ptr1 + 1);
                if(ptr2-1 - ptr1 + 1 <= minLength ){startIndex =ptr1; }
                if(minLength >= ptr2-1 - ptr1 + 1  ){startIndex = ptr1;}
                noOfSubstring++;
            }         
        }
            
        if(!queue.isEmpty() &&  prefixSum[ptr2] - prefixSum[queue.peekLast()]<=0 ){
            while (!queue.isEmpty() &&  prefixSum[ptr2] <= prefixSum[queue.peekLast()] ) {
                queue.removeLast();
            }            
        }

        queue.addLast(ptr2); 
        ptr2++;
      }
        
      if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring}
      return maxLength/minLength;
      return Arrays.copyOfRange(startIndex,si+maxLength/minLength)  
      return noOfSubstring;
      */
      
    
      return 0;
    
    }
    public int   stringSubstringKaCharactersEqualsKDistinctKaLongesKaLengthAndString_PickFruits(String s , int k){
        /*
        Question
        "aabacbebebe" -- find  all substring  with k distinct character   
                        return the longest subararys size OR print  longest subararys

                        Eg k = 2
                        "aab","aaba" ,"bebebe" -- return longest substring "bebebe" size = 6  ; number of substring = 3
                        
                        

        **PICK FRUITS***
        fruits = [1,2,3] --fruits[i] represents type of fruit ith tree produces
                           you have 2 baskets and must pick maximum fruits from the tree with certain rules
                           1.You only have two baskets, and each basket can only hold a single type of fruit.         --->Exactly k distinct
                           Each basket must be filled
                           2.Starting from any tree of your choice, you must pick exactly one fruit from every tree  ------>substring
                           (including the start tree) while moving to the right.                                          /
                           The picked fruits must fit in one of your baskets.                                            /
                           3.Once you reach a tree with fruit that cannot fit in your baskets, you must stop.      -----/
                           
                           Find the max fruits you can pick                                                    -->max length

                        
                           = stringSubstringCharactersAtMostKDistinctKaLongestShortestLengthStringNumber__PickFruits(k,2);


                           = stringSubstringKaCharactersEqualsKDistinctKaLongesLengthAndString_Or_PickToys(arr,2);

                            
        */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY)-
        /*
        "aabacbebebe"                 
        ||  
      ptr1 ptr2                while(ptr2 <=s.length()-1){                                     -->move ptr2 till s.length (ptr2 at s.length ; cb ptr2 till s.length-1; ca enc till s.length)
                                    map.put(s.charAt(ptr2),map.getOrDefault(s.charAt(ptr2),0) + 1) add ptr2 and its count to to map
                                    
                                    if(map.size() < k){                                             if(noOfDistinctCharacters <k)
                                        ptr2++;}                                                         move ptr2 ahead

                                    else if(map.size() == k){                                       else if(noOfDistinctCharacters==k) 
                                        maxLength = Math.max(ptr2-ptr1+1, maxLength);                 window is from ptr1 to ptr2 
                                        if(ptr2-ptr1+1 >= maxLength){                                 some  substrings within this window are  valid;some substrings are not valid  
                                            maxLength = ptr2-ptr1+1;                                  hence we can calculate longest substring usinhg window but cant calculate noOfSubstrings
                                            startIndex = ptr1;                                        
                                        }
                                        ptr2++;                                                      move ptr2 ahead
                                    }
                                    else if(map.size() > k){                                    else if(noOfDistinctCharacters>k) (ptr2 at noOfDistinctCharacters>k)
                                        while(ptr1 <= ptr2-1 && map.size() > k){                    move ptr1 till noOfDistinctCharacters>k (ptr1 till noOfDistinctCharacters>k)
                                            map.put( s.charAt(ptr1), map.get( s.charAt(ptr1))-1);     remove ptr1 from map by decrementing count ; if count = 0 remove ptr1 
                                            if(map.get( s.charAt(ptr1)) == 0){                         move ptr1 ahead
                                                map.remove( s.charAt(ptr1));
                                            }
                                            ptr1++;
                                        } 
                                        if(map.size() == k){                                       if noOfDistinctCharacters==k (ptr1 at noOfDistinctCharacters==k)
                                             maxLength = ptr2-ptr1+1;                                  same as abpve
                                             if(ptr2-ptr1+1 >= maxLength){                                    
                                                maxLength = ptr2-ptr1+1;                                     
                                                startIndex = ptr1;
                                            }
                                        }


                                    ptr2++;                                                       move ptr2 ahead
                                }

                            
                              if(maxLength = Integer.MIN_VALUE){retur 0 ;} //null check:if max  value never get replaced                        
                              return maxLength                                 
                              return Arrays.copyOfRange(startIndex,startIndex+maxLength-1)


        Time : O(n )   as we reduce n(length of arr) by 1 
        Space: O(n) as you use map 
        */
    
        int ptr1 = 0;
        int ptr2 = 0;
        int maxLength = Integer.MIN_VALUE;
        int startIndex = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(ptr2 <=s.length()-1){
            if(map.containsKey(s.charAt(ptr2))){
                map.put(s.charAt(ptr2),map.get(s.charAt(ptr2))+1);}
            else{
                map.put(s.charAt(ptr2),1);}
        


            if(map.size() < k){
                ptr2++;}

            else if(map.size() == k){
                maxLength = Math.max(ptr2-ptr1+1, maxLength);
                if(ptr2-ptr1+1 >= maxLength){
                    maxLength = ptr2-ptr1+1;
                    startIndex = ptr1;
  
                }
                ptr2++;
            }

            else if(map.size() > k){

                while(ptr1 <= ptr2 && map.size() > k){
                    
                    map.put( s.charAt(ptr1), map.get( s.charAt(ptr1))-1);
                    if(map.get( s.charAt(ptr1)) == 0){
                        map.remove( s.charAt(ptr1));
                    }

                    ptr1++;
                }

                if(map.size() == k){  
                    maxLength = Math.max(ptr2-ptr1+1, maxLength);
                    if(ptr2-ptr1+1 >= maxLength){
                        maxLength = ptr2-ptr1+1;
                            startIndex = ptr1;
                    }
                }


            ptr2++;
        }

        }
        
        
        return 0;
        //if(maxLength= Integer.MIN_VALUE){retur 0 }
        //return maxLength;
        //return Arrays.copyOfRange(startIndex,startIndex+maxLength-1);
        
        
    }
    public int   stringSubstringKaCharactersEqualsKDistinctKaCount(String s , int k){
        /*
        Question
        "aabc" -- find  all substring  with k distinct character   
                        return the number of such subararys

                        Eg k = 2
                        "aab","bc" ,--number of substring = 3
                        
                    

       
                            
        */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY)-
        /*
        "aabacbebebe"                 
        ||  
      ptr1 ptr2    
      
            --int n1 = stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits(s,k); 
              int n2 = stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits(s,k-1);
              int noOfSubstring = n1-n2;     -- Exactly k characters = At most k characters - At most k-1 characters
                                                (we cant use the same logic for "longest length/string"  and "number of substrings" 
                                                 window is from ptr1 to ptr2 
                                                 some  substrings within this window are  valid;some are not valid  
                                                 hence we can calculate longest substring usinhg window but cant calculate noOfSubstrings

              return noOfSubstring;

        Time : O(n )   as we reduce n(length of arr) by 1 
        Space: O(n) as you use map 
        */

        int n1 = stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits(s,k);
        int n2 = stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits(s,k-1);
        int noOfSubstring = n1-n2;

        return noOfSubstring;
    
        
        
    }
    public int   stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits(String s , int k){
        /*
        "abc" -- find  all substring  with at most k distinct character   
                 return the longest/shortest subararys size OR print  longest/shortest subararys OR number of such subarrays 
                Eg k = 2
                "a","b",c","ab" ,"ac" "bc" -- return longest substring "bc" size = 2 ; shortest substring "a" size = 1 ; number of substring = 6
                
        **PICK FRUITS***
        fruits = [1,2,3] --fruits[i] represents type of fruit ith tree produces
                           you have 2 baskets and must pick maximum fruits from the tree with certain rules
                           1.You only have two baskets, and each basket can only hold a single type of fruit.         --->Art most k distinct
                           There is no limit on the amount of fruit each basket can hold.
                           2.Starting from any tree of your choice, you must pick exactly one fruit from every tree  ------>substring
                           (including the start tree) while moving to the right.                                          /
                           The picked fruits must fit in one of your baskets.                                            /
                           3.Once you reach a tree with fruit that cannot fit in your baskets, you must stop.      -----/
                           
                           Find the max fruits you can pick                                                    -->max length

                        
                           = stringSubstringCharactersAtMostKDistinctKaLongestShortestLengthStringNumber__PickFruits(k,2);


        
        */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY)
        /*
        "abc"
         ||
     ptr1 ptr2 
          --int ptr1 = 0;                                                      --initialise ptr1 ptr2 to 0
            int ptr2 = 0;
            int noOfSubstrings = 0;
            int maxLength = Integer.MIN_VALUE;
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;

            Map<Character,Integer> map  = new HashMap<>();
            while( ptr2 <= s.length()-1 ){                                      --move ptr2 till s.length-1
                map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);      add ptr2 to map
                
                if(map.size() > k){                                                 if noOfDisdinctCharacters > k
                    while(ptr1 <= ptr2 && map.size() > k){                             while(ptr1 <= ptr2 && noOfDisdinctCharacters > k){                         
                        map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);               remove ptr1 from map
                        if(map.get(s.charAt(ptr1)) == 0)                                   move ptr1 ahead
                            map.remove(s.charAt(ptr1));
                        ptr1++;
                    }
                }                                                                        
                maxLength = Math.max(maxLength,ptr2-ptr1+1);                       window from ptr1 to ptr2 is window with at most k distinct elements  
                minLength = Math.min(minLength,ptr1-ptr1+1);                       so all windows from ptr1 to ptr2 ie [ptr1,ptr1],[ptr1,ptr1+1]..[ptr1,ptr2] are window with at most k distinct elements
                if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}                   calculate maxLength,minLength,startIndex,noOfSubstring     
                if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;}
                noOfSubstrings+=ptr2-ptr1+1;                
                
                ptr2++;                                                           move ptr2 ahead
            } 
            if(maxLength = Integer.MIN_VALUE){return 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
            return maxLength/minLength;                                
            return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
            return  numberOfSubstring;

        Time:O(n)   as we reduce n(length of arr) by 1 
        Space: O(n) as you use map 
        
        */
        int ptr1 = 0;
        int ptr2 = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int noOfSubstrings = 0;
        Map<Character,Integer> map  = new HashMap<>();
        while( ptr2 <= s.length()-1 ){
            map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);
            
            if(map.size() > k){
                while(ptr1 <= ptr2 && map.size() > k){ 
                    map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);
                    if(map.get(s.charAt(ptr1)) == 0)
                        map.remove(s.charAt(ptr1));
                    ptr1++;
                }
            }
        
                  
            maxLength = Math.max(maxLength,ptr2-ptr1+1);
            minLength = Math.min(minLength,ptr1-ptr1+1);
            if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}
            if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;}
            noOfSubstrings+=ptr2-ptr1+1;        
            ptr2++;
        } 
        
        // if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
        // return maxLength/minLength                                 
        // return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
        return  noOfSubstrings;

    }
    public int   stringSubstringKaCharactersAtLeastKDistinctKaLongestShortestKaLengthAndStringAndCount(String s , int k){
        /*
        "abc" -- find  all substring  with at least k distinct character   
                 return the longest/shortest subararys size OR print  longest/shortest subararys OR number of such subarrays 

        Eg k = 2
        "ab" ,"ac" "bc""abc" -- return longest substring "abc" size = 3 ; shortest substring "ab" size = 2 ; number of substring = 4
        
        
        */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY)
        /*
        "abc"
         ||
     ptr1 ptr2 
          --int ptr1 = 0;                                                      --initialise ptr1 ptr2 to 0
            int ptr2 = 0;
            int noOfSubstrings = 0;
            int maxLength = Integer.MIN_VALUE;
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;

            Map<Character,Integer> map  = new HashMap<>();
            while( ptr2 <= s.length()-1 ){                                      --move ptr2 till s.length-1
                map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);       add ptr2 to map
                
                if(map.size() >= k){                                                  if noOfDisdinctCharacters >= k
                    while(ptr1 <= ptr2 && map.size() >= k){                             while(ptr1 <= ptr2 && noOfDisdinctCharacters >= k){   
                                                                                                           
                        maxLength = Math.max(maxLength,s.length-1-ptr2+1);                 window from ptr1 to ptr2 is window with at least k distinct elements  
                        minLength = Math.min(minLength,ptr2-ptr1+1);                       so all windows from ptr2 to s.length-1 ie [ptr2,ptr2],[ptr2,ptr2+1]..[ptr2,s.length-1] are window with at least k distinct elements
                        if(s.length()-1-ptr2+1 >= maxLength){startIndex = ptr1;}           calculate maxLength,minLength,startIndex,noOfSubstring     
                        if(ptr2-ptr1+1<= minLength){startIndex = ptr1;}
                        noOfSubstrings+=s.length()-1 - ptr2 + 1;           

                        map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);                 remove ptr1 from map
                        if(map.get(s.charAt(ptr1)) == 0)                                    move ptr1 ahead
                            map.remove(s.charAt(ptr1));
                        ptr1++;
                    }
                }

                ptr2++;                                                           move ptr2 ahead
            } 
            if(maxLength = Integer.MIN_VALUE){return 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
            return maxLength/minLength;                                
            return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
            return  numberOfSubstring;

        Time:O(n)   as we reduce n(length of arr) by 1 
        Space: O(n) as you use map 
        
        */
        int ptr1 = 0;
        int ptr2 = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int noOfSubstrings = 0;
        Map<Character,Integer> map  = new HashMap<>();
        while( ptr2 <= s.length()-1 ){
            map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);
            
            if(map.size() >= k){
                while(ptr1 <= ptr2 && map.size() >= k){ 
                    noOfSubstrings += s.length()-1 -ptr2+1;                
                    maxLength = Math.max(maxLength,s.length()-1 -ptr2 + 1);
                    minLength = Math.min(minLength,ptr2-ptr1+1);  
                    if(s.length()-1-ptr2+1 >= maxLength){startIndex = ptr1;}     
                    if(ptr2-ptr1+1<= minLength){startIndex = ptr1;}
                    noOfSubstrings+=s.length()-1 - ptr2 + 1;  

                    map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);
                    if(map.get(s.charAt(ptr1)) == 0)
                        map.remove(s.charAt(ptr1));
                    ptr1++;
                }
            }

            ptr2++;
        } 
        
        // if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
        // return maxLength/minLength                                 
        // return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
        return  noOfSubstrings;

    }
    public int   stringSubstringKaCharactersAllDistinctKaLongestShortestKaLengthAndStringAndCount(String s , int k){
        /*
        "abc" -- find  all substring  with at all distinct character   
                 return the longest/shortest subararys size OR print  longest/shortest subararys OR number of such subarrays 
        */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY)
        /*
        "abc"
         ||
     ptr1 ptr2 
          --int ptr1 = 0;                                                      --initialise ptr1 ptr2 to 0
            int ptr2 = 0;
            int noOfSubstrings = 0;
            int maxLength = Integer.MIN_VALUE;
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;

            Map<Character,Integer> map  = new HashMap<>();
            while( ptr2 <= s.length()-1 ){                                      --move ptr2 till s.length-1
                map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);      add ptr2 to map
                
                if(map.size() < ptr2-ptr1+1){                                    if noOfDisdinctCharacters < currentWindowLength
                    while(ptr1 <= ptr2 && map.size()< ptr2-ptr1+1){                  while(ptr1 <= ptr2 && noOfDisdinctCharacters < currentWindowLength){                         
                        map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);               remove ptr1 from map
                        if(map.get(s.charAt(ptr1)) == 0)                                   move ptr1 ahead
                            map.remove(s.charAt(ptr1));
                        ptr1++;
                    }
                }                                                                        
                maxLength = Math.max(maxLength,ptr2-ptr1+1);                       window from ptr1 to ptr2 is window with at all distinct
                minLength = Math.min(minLength,ptr1-ptr1+1);                       so all windows from ptr1 to ptr2 ie [ptr1,ptr1],[ptr1,ptr1+1]..[ptr1,ptr2] are window with at most all distinct elements
                if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}                   calculate maxLength,minLength,startIndex,noOfSubstring     
                if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;}
                noOfSubstrings+=ptr2-ptr1+1;                
                
                ptr2++;                                                           move ptr2 ahead
            } 
            if(maxLength = Integer.MIN_VALUE){return 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
            return maxLength/minLength;                                
            return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
            return  numberOfSubstring;

        Time:O(n)   as we reduce n(length of arr) by 1 
        Space: O(n) as you use map 
        
        */
        int ptr1 = 0;
        int ptr2 = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int noOfSubstrings = 0;
        Map<Character,Integer> map  = new HashMap<>();
        while( ptr2 <= s.length()-1 ){
            map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);
            
            if(map.size() < ptr2-ptr1+1){
                while(ptr1 <= ptr2 && map.size()  < ptr2-ptr1+1){ 
                    map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);
                    if(map.get(s.charAt(ptr1)) == 0)
                        map.remove(s.charAt(ptr1));
                    ptr1++;
                }
            }
                      
            maxLength = Math.max(maxLength,ptr2-ptr1+1);
            minLength = Math.min(minLength,ptr1-ptr1+1);
            if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}
            if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;} 
            noOfSubstrings+=ptr2-ptr1+1;  
            ptr2++;
        } 
        // if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
        // return maxLength/minLength                                 
        // return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
        return  noOfSubstrings;

    }
    public int   stringSubstringKaCharacterAllRepeatingOnKReplacementKaLongestShortestLengthAndStringAndCount(String s , int k){
      /*
      Question
      "abab" k=2-- find  all substring with all repeating characters where we can replace at the most k characters to any characters
                    return the longest/shortest substring size OR print  longest/shortest substring OR number of such substring 
                    Eg :  "abab" -- replace 2 b with a or vice versa -- "aaaa" -- return longest substring "aaa" size = 3 
                      
      */

      /*
      "abab"
       ||
       ptr1 ptr2  
              --initialise ptr1 ptr2 to 0
              while(ptr2 <= s.length()-1){                                            --> move ptr2 till s.length(..)                                              
                  map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);            add ptr2 to map
                  maxOccuringCharacterCount = Math.max(maxOccuringCharacterCount,           max occuring character = max of all characters added to map             
                                                map.get(s.charAt(ptr2)));                   min no of replacement req = window size -  max occuring character 
                  minNoOfReplacementsRequired = (ptr2-ptr1+1) - maxOccuringCharacterCount;   
                  
                  if(minNoOfReplacementsRequired < k){                                      if minNoOfReplacementsRequired < k 
                      if(ptr2-ptr1+1>=maxLength ){                                              window is from ptr1 to ptr2
                          maxLength = ptr2-ptr1+1;                                              find max ,min of window lengths , left right for max min window lengths , increment numberOfSubArray 
                          left = ptr1;                                                          move ptr2 ahead
                          right = ptr2;
                      }                                                                  
                      if(ptr2-ptr1+1 <= minLength ){                                            
                          minLength = ptr2-ptr1+1;                                              
                          left = ptr1;                                                       
                          right = ptr2;
                      }                                                                   
                      noOfSubstrings++;                                                        
                                                                                               
                      ptr2++;                                                                   
                  }                                                                            
                                                                                              
                  else if(minNoOfReplacementsRequired == k){                              else if minNoOfReplacementsRequired == k                              
                      if(ptr2-ptr1+1>=maxLength ){                                           window is from ptr1 to ptr2  
                          maxLength = ptr2-ptr1+1;                                           find max ,min of window lengths , left right for max min window lengths , increment numberOfSubArray 
                            left = ptr1;                                                      move ptr2 ahead
                          right = ptr2;
                      }
                      if(ptr2-ptr1+1 <= minLength ){
                          minLength = ptr2-ptr1+1;
                          left = ptr1;
                          right = ptr2;
                      }    
                      noOfSubstrings++;
                      
                      ptr2++;
                  }  


                  else if(minNoOfReplacementsRequired > k){                                    else if minNoOfReplacementsRequired > k
                      map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);                         remove ptr1 from map by reducing count
                      ptr1++;                                                                     move ptr1 ahead
                                                                                                  recalculate minNoOfReplacementsRequired 
                      maxOccuringCharacterCount = Math.max(moc,map.get(s.charAt(ptr2)));          if(minNoOfReplacementsRequired == k))   
                      minNoOfReplacementsRequired = (ptr2-ptr1+1- maxOccuringCharacterCount;          window is from ptr1 to ptr2         
                      if(minNoOfReplacementsRequired == k){                                           find max ,min of window lengths , left right for max min window lengths , increment numberOfSubArray 
                          if(ptr2-ptr1+1>=maxLength ){                                             move ptr2 ahead    
                              maxLength = ptr2-ptr1+1;                                            
                              left = ptr1;
                              right = ptr2;
                          }
                          if(ptr2-ptr1+1 <= minLength ){
                              minLength = ptr2-ptr1+1;
                              left = ptr1;
                              right = ptr2;
                          }
                          noOfSubstrings++;
                      }                           
                      ptr2++;                            
                  }

              }
                                                

              if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced             
              return maxLength/minLength;                                 
              return Arrays.copyOfRange(startIndex,right+1)
              return return numberOfSubstring;
              return 0;



      Time:O(n)
      Space:O(1)

      
      */

      int ptr1 = 0;
      int ptr2 = 0;
      int maxLength = Integer.MIN_VALUE;
      int minLength = Integer.MAX_VALUE;
      int left = 0;
      int right = 0;
      int noOfSubstrings = 0;
      int maxOccuringCharacterCount = 0; 
      int minNoOfReplacementsRequired  = 0; 
      Map<Character, Integer> map = new HashMap<>();
      while(ptr2 <= s.length()-1){
          map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);
          maxOccuringCharacterCount = Math.max(maxOccuringCharacterCount, map.get(s.charAt(ptr2)));                         
          minNoOfReplacementsRequired = (ptr2-ptr1+1) - maxOccuringCharacterCount;
          
          
          if(minNoOfReplacementsRequired < k){
              if(ptr2-ptr1+1>=maxLength ){
                  maxLength = ptr2-ptr1+1;
                  left = ptr1;
                  right = ptr2;
              }
              if(ptr2-ptr1+1 <= minLength ){
                  minLength = ptr2-ptr1+1;
                  left = ptr1;
                  right = ptr2;
              }
              noOfSubstrings++;
                                    
              ptr2++;
          }   
          else if(minNoOfReplacementsRequired == k){
              if(ptr2-ptr1+1>=maxLength ){
                  maxLength = ptr2-ptr1+1;
                    left = ptr1;
                  right = ptr2;
              }
              if(ptr2-ptr1+1 <= minLength ){
                  minLength = ptr2-ptr1+1;
                  left = ptr1;
                  right = ptr2;
              }    
              noOfSubstrings++;
              
              ptr2++;
          }  
          else if(minNoOfReplacementsRequired > k){
              
              map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);
              ptr1++;
              
              maxOccuringCharacterCount = Math.max(maxOccuringCharacterCount, map.get(s.charAt(ptr2)));
              minNoOfReplacementsRequired = (ptr2-ptr1+1) - maxOccuringCharacterCount;
              if(minNoOfReplacementsRequired == k){
                  if(ptr2-ptr1+1>=maxLength ){
                      maxLength = ptr2-ptr1+1;
                      left = ptr1;
                      right = ptr2;
                  }
                  if(ptr2-ptr1+1 <= minLength ){
                      minLength = ptr2-ptr1+1;
                      left = ptr1;
                      right = ptr2;
                  }
                  noOfSubstrings++;
              }                           
              ptr2++; 
          }  
      }
                                        

      // if(maxLength = Integer.MIN_VALUE){retur 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced             
      // return maxLength/minLength;                                 
      // return Arrays.copyOfRange(startIndex,right+1)
      // return return numberOfSubstring;
      return 0;
      
      
      
  }
    public int   stringSubstringKaCharacterAtleastKRepeatedKaLongestLength(String s , int k){

      /*
      Question
      "aaabb" k=3-- find  all substring where each character is repeated atleast k times 
                    return the longest substring ka length 
                    Eg :  "aaa" -- return length of subs= 3
                      

      
      */
      /*
      
      public int stringSubstringKaCharacterAtleastKRepeatedKaLongestLength(String s , int k){
        int maxLength = Integer.MIN_VALUE;

        Map<Character,Integer> map = new HashMap<>();            --find total number of distinct characters in string
        int totalDistinctCharacters = 0;
        for (int i = 0; i <= s.length()-1; i++) {
            if (!map.containsKey(s.charAt(i))) {
                totalDistinctCharacters++;
                map.put(s.charAt(i), 1);
            }
        }
        for (int d = 1; d <= totalDistinctCharacters; d++) { --Iterate d = 1 to totalDistinctCharacters
            int length = fnWrittenBelow(s,d,k);                 find subs with at most d distinct char and each char repeated atleast k times ka max length
            maxLength = Math.max(maxLength,length);             find max of all such subs 
        }                                                           
        if(maxLength == Integer.MIN_VALUE){return 0;}        --return maxLenggth
        return maxLength;                                      
      }
                                               

    
    public int stringSubstringKaCharacterAtMostdDistinctAnd AtLeastkRepeated(String s ,int d,int k){
      SAME AS stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits()
      But also keep track of number of characters with freq atleast k and at end if number of characters with frequency atleast k
      matches no of distonct characters then only update maxLength


      Map<Character,Integer> map  = new HashMap<>();
      while( ptr2 <= s.length()-1 ){                                      --move ptr2 till s.length-1
          map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0)+1);      add ptr2 to map
          
          if(map.size() > k){                                                 if noOfDisdinctCharacters > k
              while(ptr1 <= ptr2 && map.size() > k){                             while(ptr1 <= ptr2 && noOfDisdinctCharacters > k){                         
                  map.put(s.charAt(ptr1), map.get(s.charAt(ptr1))-1);               remove ptr1 from map
                  if(map.get(s.charAt(ptr1)) == 0)                                   move ptr1 ahead
                      map.remove(s.charAt(ptr1));
                  ptr1++;
              }
          }                                                                        
          maxLength = Math.max(maxLength,ptr2-ptr1+1);                       window from ptr1 to ptr2 is window with at most k distinct elements  
          minLength = Math.min(minLength,ptr1-ptr1+1);                       so all windows from ptr1 to ptr2 ie [ptr1,ptr1],[ptr1,ptr1+1]..[ptr1,ptr2] are window with at most k distinct elements
          if(ptr2-ptr1+1 >= maxLength){startIndex = ptr1;}                   calculate maxLength,minLength,startIndex,noOfSubstring     
          if(ptr1-ptr1+1 <= minLength){startIndex = ptr1;}
          noOfSubstrings+=ptr2-ptr1+1;                
          
          ptr2++;                                                           move ptr2 ahead
      } 
      if(maxLength = Integer.MIN_VALUE){return 0 ; return new int[0], return numberOfSubstring} //null check:if max min value never get replaced                        
      return maxLength/minLength;                                
      return Arrays.copyOfRange(startIndex,si+maxLength/minLength)
      return  numberOfSubstring;    

      int ptr1 = 0;                                                              --initialise ptr1 ptr2 to 0
      int ptr2 = 0;
      int numberOfCharWithFreqEqualsk = 0;
      int maxLength = Integer.MIN_VALUE;
      Map<Character,Integer> map = new HashMap<>();
      
      while (ptr2 <= s.length()-1) {                                              --move ptr2 till s.length-1
          map.put(s.charAt(ptr2), map.getOrDefault(s.charAt(ptr2),0) + 1);            add ptr2 to map
          if(map.get(s.charAt(ptr2)) == k){numberOfCharWithFreqEqualsk++;}            calculate no of char with freq = k

          
          if (map.size() > d) {                                                       if noOfDisdinctCharacters > k
              while(ptr1 <= ptr2 && map.size() > d){                                     while(ptr1 <= ptr2 && noOfDisdinctCharacters > d){                         
                  map.put(s.charAt(ptr1), map.getOrDefault(s.charAt(ptr1),0) - 1);          remove ptr1 from map
                  if(map.get(s.charAt(ptr1)) == k-1){numberOfCharWithFreqEqualsk--;}        calculate no of char with freq = k 
                  if(map.get(s.charAt(ptr1)) == 0){map.remove(s.charAt(ptr1));}              mpve ptr1 ahead
              
                  ptr1++;  
              }
          }
          
          if (numberOfCharWithFreqEqualsk == map.size())                             if no of char with freq = k  == no of distinct char
              maxLength = Math.max(ptr2 - ptr1+1, maxLength);                        window from ptr1 to ptr2 is window with at most d distinct elements and freq f  
                                                                                     calculate maxLength,minLength,startIndex,noOfSubstring 
        
      ptr2++;                                                                         move ptr2 ahead                                  
      }                                                                              /
      return maxLength;                                                             / 
    }                                                                              /
                                                      EXPLANATION-----------------/
                                                      s = "abababbdabcabc" k = 2

                                                      d = 1
                                                      "ababa|bb|dabcabc" 
                                                      string with d(1) distinct char and each char repeting atleast k(2) times 
                                                      ka longest = ""bb" ;maxLength = 2

                                                      d = 2
                                                     "|abababb|dabcabc" 
                                                      string with d(2) distinct char and each char repeting atleast k(2) times 
                                                      ka longest = ""abababb" ;maxLength = 7

                                                      d = 3
                                                     "abababbd|abcabc|" 
                                                      string with d(3) distinct char and each char repeting atleast k(2) times 
                                                      ka longest = ""abcabc" ;maxLength = 6
                                                      
                                                      So max o all lengths is 7



    Time:O(26*n) --Total distinct char can at max be 26 and for each distinct char we calculate at most d distinct and atleast k repeating
    Space:O(n)-- map of size n 
      
      */
      return 0;
  }
    public int   stringSubstringKaCharactersOddNumberEverythingKaLongestShortestKaLengthAndStringAndCount(int[ ] arr,int k){
    /*
    Question
    [1,1,2,1,1] - find  all substring  with k distinct; at most k distinct ;at least  k distinct; all Distinct,  
     k = 3        return the longest/shortest subarray ka length, string and count                              
    */

    //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTY)
    /*
    K DISTINCT 
    stringSubstringKaCharactersEqualsKDistinctKaLongesKaLengthAndString_PickFruits()
    stringSubstringKaCharactersEqualsKDistinctKaCount()

    AT MOST K DISTINCT 
    stringSubstringKaCharactersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCount__PickFruits()

    AT LEAST K DISTINCT 
    stringSubstringKaCharactersAtLeastKDistinctKaLongestShortestKaLengthAndStringAndCount()

    ALL DISINCT
    stringSubstringKaCharactersAllDistinctKaLongestShortestKaLengthAndStringAndCount()
    |
    |
    Same as these methods   
    But instead of map use distinctOddCount 
    add,remove only when odd number at ptr
    and increment decfrement only when element at ptr is odd

    EG:( https://leetcode.com/problems/count-number-of-nice-subarrays/)
    In an array find number of subarray with k odd numbers
    
    public int arraySubarrayKaCharactersOddNumbersEqualsKDistinctKaLongesKaLengthAndString(int[] arr, int k) {
      return arraySubArrayKaCharactersOddNumbersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCout(arr,k) 
      - arraySubArrayKaCharactersOddNumbersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCout(arr,k-1);
    }
    public int arraySubArrayKaCharactersOddNumbersAtMostKDistinctKaLongestShortestKaLengthAndStringAndCout(int[] arr, int k){
        
      int ptr1 = 0;
      int ptr2 = 0;
      int noOfSubstrings = 0;
      int maxLength = Integer.MIN_VALUE;
      int  minLength = Integer.MAX_VALUE;
      int distinctOddNumbers  = 0;
      while( ptr2 <= arr.length-1 ){
          if(arr[ptr2] %2 != 0){distinctOddNumbers++;}

          if(distinctOddNumbers > k){
              while(ptr1 <= ptr2 && distinctOddNumbers > k){ 
                  if(arr[ptr1] %2 != 0){distinctOddNumbers--;}
                  ptr1++;
              }
          }                
          maxLength = Math.max(maxLength,ptr2-ptr1+1);
          minLength = Math.min(minLength,ptr1-ptr1 + 1);
          if(ptr2-ptr1+1 >= maxLength){maxLength =ptr2-ptr1+1; }
          if(ptr1-ptr1 + 1<= minLength){minLength = ptr1-ptr1+1;}
          noOfSubstrings+=ptr2-ptr1+1;  
          
          ptr2++;
          } 
          return noOfSubstrings; 
      }





    
    
    
    */

  return 0;
}
    public int[] stringSubStringKaCharacterContainingAnagramOfOtherStringKaStringAndCount(String s1 , String s2){
      /*
          Question
          s1 = "aabaabaaa"   -- find all substrings of s1 
          s2 = "aaba"           and count no of substrings which are anagrams of s2 and return  so return count of substrings or print the substring

      */                    


      //USING MULTIPOINTERS SLIDING WINDOW -- FIXED SIZE(Array ka Subarray of size k)
      /*
      "aabaabaaa"        "aaba"               
      ||                 {a:3,b:1}                 
  ptr1 ptr2                                                           
                  populate hashmap with s2 ka characters as key and their frequency as value 
                  initialise ptr1 ptr2 to 0 
                  initialise distinctCharacters to map size
                  while(ptr2 <= s1.length()-1){                                          -->move ptr2 till s1.length(ptr2 at s1.length,cb ptr till s1.length-1,ca s1 till arr.length)    

                      if(ptr2 - ptr1 <= s2.length()-2){                                    if ptr2-ptr1 <=s2.length()-2 (ptr2 reaches s2.length()-1 , cb ptr2 enc till s2.length()-2 ie 1 before window size)
                          if(map.containsKey(s1.charAt(ptr2))){                                  remove ptr2 from map and if count = 0 reduce distinctCharacters
                              map.put(s1.charAt(ptr2), map.get(s1.charAt(ptr2))-1);               because map contains characters of s2 which we are comparing to s1
                              if(map.get(s1.charAt(ptr2)) == 0){
                                  distinctCharacters--;
                              }
                          }
                          ptr2++;                                                                 move ptr2 ahead 
                          
                          
                          
                      }
                      else{                                                               else(ptr2 reaches s2.length()-1 ie 1 before window size) 
                          if(map.containsKey(s1.charAt(ptr2))){                                remove ptr2 from map and if count = 0 reduce distinctCharacters
                              map.put(s1.charAt(ptr2), map.get(s1.charAt(ptr2))-1);              because map contains characters of s2 which we are comparing to s1
                              if(map.get(s1.charAt(ptr2)) == 0){
                                  distinctCharacters--;
                              }
                          }
                          if(distinctCharacters == 0){                                        add string from i to j to restltList if distinctCharacters == 0
                              result.add(s1.substring(ptr1,ptr2+1));                          because it means s1 has all characters of s2 
                              noOfSubstring++;
                          }
                          
                          if(map.containsKey(s1.charAt(ptr1))){                                add ptr1 to map and if count = 1 increase distinctCharacters
                              map.put(s1.charAt(ptr1), map.get(s1.charAt(ptr1))+1);            because map contains characters of s2 which we are comparing to s1
                              if(map.get(s1.charAt(ptr1)) == 1){
                                  distinctCharacters++;
                              }
                          }
                          ptr1++;                                                               move ptr1, ptr2 ahead
                          ptr2++;
                      }
                      
                  }
                  
                  return result;


      Time : O(n )   as we reduce n(length of arr) by 1 
      Space: O(1) 

      */

      int noOfSubString = 0;
      Map<Character,Integer> map = new HashMap<>();
      for(int i=0 ; i <= s2.length()-1;i++){
          if(!map.containsKey(s2.charAt(i))){
              map.put(s2.charAt(i),1);
          }
          else{
              map.put(s2.charAt(i),map.get(s2.charAt(i) ) + 1);
          }
      }
      
      int ptr1 = 0;
      int ptr2 =0;
      int distinctCharacters = map.size();
      List<String> result = new ArrayList<>();
      
      while(ptr2 <= s1.length()-1){
          
          
          if(ptr2 - ptr1 <= s2.length()-2){
              if(map.containsKey(s1.charAt(ptr2))){
                  map.put(s1.charAt(ptr2), map.get(s1.charAt(ptr2))-1);
                  if(map.get(s1.charAt(ptr2)) == 0){
                      distinctCharacters--;
                  }
              }
              
              ptr2++;
              
              
              
          }
          else{
              if(map.containsKey(s1.charAt(ptr2))){
                  map.put(s1.charAt(ptr2), map.get(s1.charAt(ptr2))-1);
                  if(map.get(s1.charAt(ptr2)) == 0){
                      distinctCharacters--;
                  }
              }
              
              
              if(distinctCharacters == 0){
                  result.add(s1.substring(ptr1,ptr2+1));
                  noOfSubString++;
              }
              
              if(map.containsKey(s1.charAt(ptr1))){
                  map.put(s1.charAt(ptr1), map.get(s1.charAt(ptr1))+1);
                  if(map.get(s1.charAt(ptr1)) == 1){
                      distinctCharacters++;
                  }
              }
              
              
              ptr1++;
              ptr2++;
          }
          
      }
      
      //return result;
      //return noOfSubstrings;
      return null;
  }
    public int   stringSubstringKaCharacterContainingCharactersOfOtherStringKaLongestShortestLengthAndStringAndCount(String s1 , String s2){
      /*
      Question
      "totctcctctocc" -- find  all substring of s1 which has all the characters of s2 
      "toc"               return the shortest substring size OR OR print shortest substring OR number of such substrings 
                          Eg 
                          "totc"  , "toc" ,"totc", "totctcc" -- return shortest substring "toc" size = 3 
                      
      */

      //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTYg) 
      /*
      "totmtaptat"  "tta" 
      ||              
      ptr1 ptr2        
                      for(int i=0 ; i <= s2.length()-1 ; i++){                -- add s2 as key and count as value to map 
                          if(!map.containsKey(s2.charAt(i))){                    distinctCharacters = s2.length()
                              map.put(s2.charAt(i),1);
                          }
                          else{
                              map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
                          }
                          
                      }
                      int distinctCharacters = s2.length(); 
                      
                      while(ptr2 <= s1.length()-1){                                       --move ptr2 till s1.length(ptr2 at s1.length,cb ptr1 till s1.length()-1 , ca ptr2 enc till s1.length )

                          if(map.containsKey(s1.charAt(ptr2))){                            remove ptr2 from map by decrementing count ; if count = 0 decrement distinctCharacters  
                              map.put(s1.charAt(ptr2), map.get(s1.charAt(ptr2)) - 1);
                              if(map.get(s1.charAt(ptr2)) >= 0) {distinctCharacters--;} 
                          }
                          
                          
                          if(distinctCharacters != 0){                                      if(distinctCharacters != 0) (ptr2 at distinctCharacters != 0)                 
                              ptr2++;                                                            move ptr2 ahead  
                          } 
              
                          if(distinctCharacters == 0){                                      if(distinctCharacters == 0) (ptr2 at distinctCharacters == 0)
                              while(ptr1 <= ptr2 && distinctCharacters == 0 ){                   move ptr1 till distinctCharacter =0 (ptr1 at distinctCharacter=0)                  
                                  minLength = Math.min(ptr2-ptr1+1,minLength);                        window is from ptr1 to ptr2 
                                  maxLength = Math.max(ptr2-ptr1+1,maxLength);                        find maxLength minLength;left right for maxLength minLength,noOfSubstring
                                  if(ptr2 -ptr1+ 1 <= minLength){          
                                      minLength = ptr2 -ptr1+ 1;                                       put ptr1 in map by incrementing count;if count >=1 increment distinctCharacters
                                      left = ptr1;                                                     move ptr1 ahead
                                      right = ptr2;                                               move ptr2 ahead
                                  
                                  } 
                                  if(ptr2 -ptr1+ 1 >= maxLength){
                                      maxLength = ptr2 -ptr1+ 1;
                                      left = ptr1;
                                      right = ptr2;
                                  }
                                  noOfSubstring++;
              
                                  if(map.containsKey(s1.charAt(ptr1))){                              
                                      map.put(s1.charAt(ptr1), map.get(s1.charAt(ptr1)) + 1);
                                      if(map.get(s1.charAt(ptr1)) >= 1) {distinctCharacters++;}
                                  }
                                  ptr1++;
                              } 
                              
                              ptr2++;
                          }
                          
              
                      }
                          

                      return 0;
                      //if(minLength == Integer.MAX_VALUE){return 0;"";0 }   //null check:if max min value never get replaced                        
                      //return minLength/maxLength;
                      //return s1.substring(left, right + 1);
                      //return noOfSubstring;
                                          
      

          Time : O(n )   as we reduce n(length of arr) by 1 
          Space: O(1) 
              
      */


      int minLength = Integer.MAX_VALUE;
      int maxLength = Integer.MIN_VALUE;
      int left = 0;
      int right = 0;
      int noOfSubstring =0;

      
      Map<Character, Integer> map = new HashMap<>();
      for(int i=0 ; i <= s2.length()-1 ; i++){
          if(!map.containsKey(s2.charAt(i))){
              map.put(s2.charAt(i),1);
          }
          else{
              map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
          }
          
      }
      int distinctCharacters = s2.length(); 
        
      
      int ptr1 = 0;
      int ptr2 = 0;
      while(ptr2 <= s1.length()-1){
          if(map.containsKey(s1.charAt(ptr2))){
              map.put(s1.charAt(ptr2), map.get(s1.charAt(ptr2)) - 1);
              if(map.get(s1.charAt(ptr2)) >= 0) {distinctCharacters--;} 
          }
          
          
          if(distinctCharacters != 0){
              ptr2++;
          }

          if(distinctCharacters == 0){
              while(ptr1 <= ptr2 && distinctCharacters == 0 ){
                  minLength = Math.min(ptr2-ptr1+1,minLength);
                  maxLength = Math.max(ptr2-ptr1+1,maxLength);
                  if(ptr2 -ptr1+ 1 <= minLength){
                      minLength = ptr2 -ptr1+ 1;
                      left = ptr1;
                      right = ptr2;
                    
                  }
                  if(ptr2 -ptr1+ 1 >= maxLength){
                      maxLength = ptr2 -ptr1+ 1;
                      left = ptr1;
                      right = ptr2;
                  }
                  noOfSubstring++;

                  if(map.containsKey(s1.charAt(ptr1))){
                      map.put(s1.charAt(ptr1), map.get(s1.charAt(ptr1)) + 1);
                      if(map.get(s1.charAt(ptr1)) >= 1) {distinctCharacters++;}
                  }
                  ptr1++;
              } 
              
              ptr2++;
          }
          

      }
      

      return 0;
      //if(minLength == Integer.MAX_VALUE){return 0;"";0 }
      //return minLength/maxLength;
      //return s1.substring(left, right + 1);
      //return noOfSubstring;
                      
      

  



        }
    public int   stringSubstringKaCharacterContainingCharactersOfItselfKaLongestShortestLengthAndStringAndCount(String s1){
        /*
        Question
        "AABBBCBBAC" -- find  all substring of s1 which has all the characters of s1
                        return the shortest substring size OR OR print shortest substring OR number of such substrings 
                        Eg 
                        "AABBB"  , "BBCBBAC" ,"BAC",  -- return shortest substring "BAC" size = 3 
                        
        */

        //USING MULTIPOINTERS SLIDING WINDOW--VARIABLE SIZE(ARRAY KA SUBARRAY/SUBSTRING OF PROPERTYg) 
        /*
        s1 = "AABBBCBBAC"    -- populate hashmap with characters of s1
        s2 = "ABC"              iterate hashmap and add characters of s2 to s2 so s2 will have all characters of s1
                              
                                return stringSubstringKaCharacterContainingCharactersOfOtherStringKaLongestShortestLengthAndStringAndCount(s1,s2)

        Time : O(n)
        Space: O(1) 
                
        */

        s1 = s1;
        String s2 = "";

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0 ; i <= s1.length()-1;i++){
            if(!map.containsKey(s1.charAt(i))){map.put(s1.charAt(i),1);}
            else{map.put(s1.charAt(i),map.get(s1.charAt(i))+1);}}
        for(var i:map.entrySet()){
            s2 = s2 + i.getKey(); }
        
        return  stringSubstringKaCharacterContainingCharactersOfOtherStringKaLongestShortestLengthAndStringAndCount(s1,s2);
        





        



        }


    //ARRAY-- MULTIPOINTER KADANES ALGO
    /*
    IDENTIFY
    ARRAY KA SUBARRAY/SUBSTRING     
    */
    public int[] arraySubArrayKaSumMaxMinKaArray(int[] arr){
        /*
        [1,2,3,-2,5] -- find all subarray
                          return subarray of max sum
                          Eg:[1,2,3,-2,5] -- return [1,2,3,-2,5] with maxsum = 9
        */

        //USING MULTIPONTER KADANES ALGO(Array ka subarray)
        /* 
        [1,2,3,-2,5] 
        |
        ptr    --initialise ptr to 0
                while(ptr <= arr.length-1){                     --move ptr till arr.length-1(ptr at arr.lengt, cb ptr enc till arr.length-1, ca pyr n till arr.lengt)
                    sum = sum + arr[ptr];                              add ptr to sum                         
                    if(sum >= maxSum){                                 if(sum >= maxSum)
                        maxSum = sum;                                    find maxsum 
                        startIndex = startIndxOnReset;                   startIndex =startIndxOnReset because startINdex is from where array is reset 
                        endIndex = ptr;                                  endIndex = ptr because  endIndexs is where maxSUm is found  
                    }
                                                                      //For 0 number
                                                                      no need to check

                                                                      //For -ve number
                    if(sum < 0){                                       if sum <0 due to -ve number then reset subarray by                       
                        sum = 0;                                         reset sum =0
                        startIndxOnReset = ptr+1;                        reset startIndexReset = ptr+1;
                    }
                    ptr++;                                             move ptr ahead
              }

        return Arrays.copyOfRange(arr,startIndex,endIndex+1); 
          
        Time:O(n)
        Space:O(1)
                          
        */
        int ptr = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int startIndxOnReset = 0;
        
        while(ptr <= arr.length-1){
            sum = sum + arr[ptr];

            if(sum >= maxSum){
                maxSum = sum;
                startIndex = startIndxOnReset;
                endIndex = ptr;
            }
            if(sum < 0){  
                sum = 0;
                startIndxOnReset = ptr+1;
            }

            
            ptr++;
        }

        return Arrays.copyOfRange(arr,startIndex,endIndex+1);
        

        
    }
    public int[] arraySubArrayKaProductMaxMinKaArray(int[] arr){

        /*
        [1,2,3,-2,5] -- find all subarray
                        return subarray of max prduct
                        Eg:[2,3,-2,4] -- return [2,3] with maxProduct = 6
        */

        
        //USING MULTIPONTER KADANES ALGO(Array ka subarray)
        /*
        [1,2,3,-2,5]
        |
        ptr       --initalise ptr t0 0
                    while(ptr <= arr.length-1){                 --move ptr till arr.length
                        product *= arr[ptr];                          find product of ptr
                        if(product >= maxProduct){                    if product >= maxProduct
                            maxProduct = product;                        find maxProduct
                            startIndex = startIndexOnReset;              startIndex = startIndexOnReset because startINde is from where subarray is reset  
                            endIndex = ptr;                              endIndex = ptr because endindex is where maxProduct is found
                        }
                                                                    //For 0 numbers
                        if(product == 0){                             if(product == 0) due to  0 , then reset subarray                  
                            product = 1;                                   reset product to 1
                            startIndexOnReset = ptr+1;                     reset startIndexOnReset to ptr+1
                        } 
                        ptr++;                                       move ptr ahead
                    }
                                                                    //For -ve numbers
                                                                    Do the same as above in reverse format
                                                                    [3,-1,4] -- from frontside you will get maxProdut = 3 si=1 ei = 1
                                                                              --from backside you will get maxProduct = 4 si = 2,ei=2
                    product = 1;                 
                    ptr = arr.length-1;
                    while(ptr>=0){
                        product *= arr[ptr];
                        if(product >= maxProduct){
                            maxProduct = product;
                            startIndex  = ptr;
                            endIndex = endIndexOnReset;
                            
                        }
                        if(product ==0) {
                            product = 1;
                            endIndexOnReset = ptr-1;
                        }
                        
                        ptr--;
                    }

                    return Arrays.copyOfRange(arr,startIndex,endIndex+1);
        */
        
        int product=1;
        int maxProduct = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int startIndexOnReset = 0;
        int endIndexOnReset = arr.length-1;
        
        int ptr = 0;
        while(ptr <= arr.length-1){
            product *= arr[ptr];
            
            if(product >= maxProduct){
                maxProduct = product;
                startIndex = startIndexOnReset;
                endIndex = ptr;
                
            }
            if(product == 0){
                product = 1;
                startIndexOnReset = ptr+1;
            } 
            ptr++;
        }

        product = 1;
        ptr = arr.length-1;
        while(ptr>=0){
            product *= arr[ptr];
            if(product >= maxProduct){
                maxProduct = product;
                startIndex  = ptr;
                endIndex = endIndexOnReset;
                
            }
            if(product ==0) {
                product = 1;
                endIndexOnReset = ptr-1;
            }
            
            ptr--;
        }

        return Arrays.copyOfRange(arr,startIndex,endIndex+1);
        
    }
    


    //KNAPSACK
    public int     arrayknapSack01(int[] weight , int[] value , int sizeofWtArray ,int W){
      /*
      weight[1  2 3 4  5 6] ---> W = 6  -- put the weights in a bag(each wt can only be taken 0 or 1 times) with weight capacity 6  
      value [4 5 3 4 2 1 8]                return the combination with max profit ka value           
                                             Eg {2,4},   = 5+2  =7                                                                           
                                                {1,2,3}  = 4+5+3 12-- this combo returns  max profit so return 12  
      */ 

      //RECURSION - IP OP TREE (Decision: wt1 lu ya na ; wt2 lu ya na lu )
      /*
                [w1,w2],[v1,v2]          IP     **sizeOfWtArr for smallerIp instead of reducing arr
                W                        OP       (do not use ptr because base case for ptr will be if(ptr == -1) which will cause issue in bottom-up tabulaion)
              /                      \
            /                        \
        w2<= W                       w2 > W
    w2\/  /      \ w2 x                | w2 x
          /        \                    |
        /          \                   |
        [w1]      [w1]                [w1] 
        W-w2      W                    W
          /      \          
          /        \                                 --if(arr[sizeofWtArray-1] <= W) return max(l,r)  
        w1<=W       w1>W                              else return l
          /  \         |
    w1\/ /    \w1 X 0  | w1 X                         --if(sizeofWtArray == 0 || W == 0) return 0
        /      \       |
    []      []      []
    W-w2-w1  W-w2   W-w2  
                                                                                        --while going top-bottom
        if(sizeOfWtArray ==  0 || W == 0 ){                                               if sizeOfWtArray==0 || W == 0
            return 0;                                                                     return 0 and start mocing up
        }
        
                                                                                          --while going top-bottom
        if(weight[sizeOfWtArray-1] <= W){                                                  if(weight[sizeOfWtArray-1] <= W){    (sizeOfWtArray starts from arr.len hence sizeOfarr-1)
            int left = value[sizeOfWtArray-1] +                                              left stores value if wt taken
                        arrayknapSack01(weight,value,sizeOfWtArray-1,W-weight[sizeOfWtArray-1]);   right stores value if wt not taken
            int right = arrayknapSack01(weight,value,sizeOfWtArray-1,W);                          return max(l,r) to next node
            return Math.max(left,right);
        }
        else{                                                                              else
            int left = arrayknapSack01(weight,value,sizeOfWtArray-1,W);                              left stores value if wt not taken
            return left;                                                                        return left to next node
            
        }



      TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
      SPACE:O(n) as we have n(size of wt array)ips       


      




      */


      
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public static int arrayknapSack01(int[] weight , int[] value,int sizeOfWtArray , int W, int[][] dp){ -- INITIALISE MATRIX dp[sizeofWtArray+1][Weight+1] , FILL MATRIX WITH -1 
          if(sizeOfWtArray ==  0 || W == 0 ){
              return 0;
          }
          
          if(dp[sizeOfWtArray][W] != -1){                                                              -- CHECK IN MATRIX
              return dp[sizeOfWtArray][W];
          }
          
          if(weight[sizeOfWtArray-1] <= W){
              int left = value[sizeOfWtArray-1] +
              knapSackk01(weight,value,sizeOfWtArray-1,W-weight[sizeOfWtArray-1],dp);
              int right = knapSackk01(weight,value,sizeOfWtArray-1,W,dp);
              dp[sizeOfWtArray][W] =  Math.max(left,right);                                          --STORE RETURN VALUE IN MATRIX 
              return dp[sizeOfWtArray][W];
              
          }
          else{
              int left = knapSackk01(weight,value,sizeOfWtArray-1,W,dp );
              dp[sizeOfWtArray][W] =  left;
              return dp[sizeOfWtArray][W];
              
          }

          
      }
      
      
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^2
      
      
      */
        

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*                                         
          j  0  1  2  3  4  5                          
      i     -  a  b  c  d  e     -->(i,j) stores for sizeOfArr= i and weight = j 
      0  -  0  0  0  0  0  0        elements of arr add add upto weight unka the number of combination                                   
      1  a  0  1  1  1  1  1                                                        
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4 
    public static int knapSackkk01(int[] weight , int[] value,int sizeOfArr , int W){
      int[][] dp = new int[sizeOfArr+1][W+1];                                          --INITIALISE MATRIX
      
      for(int i =0;i <= sizeOfArr ; i++){                                                 --STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i; CHARG2 to j
          for(int j=0 ; j <= W;j++){ 
              if(i == 0 && j == 0){
                    dp[i][j] = 0;
              }
              
            
          }
      }
      
      for(int i = 1 ; i <= sizeOfArr; i++){                                            -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
          for(int j=1 ; j <= W ;j++){
              if(weight[i-1] <=j){
                  int left = value[i-1] + dp[i-1][j-weight[i-1]];
                  int right = dp[i-1][j];
                  dp[i][j] = Math.max(left,right);
              }
              else{
                  int left = dp[i-1][j];
                  dp[i][j] = left;
              }
          }
      }
      
      
      return dp[sizeOfArr][W];                                                  -->LAST ELEMENT IN MATRIX IS ANSWER   
        
    }
    
    
    TIME :O(n^2) = O(sizeOfWtArray*W) as we elminiate recursion and use matrix of size n^2
    SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^2
   
    
    
    */

      return 0;
    }
    public int     arrayknapSackUnbound_RodCuttingMaxCost(int[] weight , int[] value , int sizeofWtArray ,int W){
      /*
      weight[1  2 3 4  5 6] ---> W = 6  -- put the weights in a bag(each wt can only be taken many times) with weight capacity 6  
      value [4 5 3 4 2 1 8]                return the combination with max profit ka value           
                                           Eg {2,4},   = 5+2   =7         
                                              {2,2,2}  = 5+5+5 =15                                                                    
                                              {1,2,3}  = 4+5+3 =12-- 15  combo returns  max profit so return 15 
      OR
      length: [1,2,3,4] -- cut the rod of given length  using lengths goven in array and cutting the rod of given length costs corresponding valie
      price  :[5,6,8,8]   return max cost    
      length : 4          eg {1 ,1,2} = 5 + 5 + 6 = 16 
                              {2 ,2} = 6 + 6 = 12
                              {1,1 ,1 ,1} = 5 + 5 + 5 + 5 = 20 --this combo   returns max profit  so return 20  
      */ 

      //RECURSION - IP OP TREE (Decision: wt1 lu ya na ; wt2 lu ya na lu )
      /*
                  [w1,w2],[v1,v2]          IP     **sizeOfWtArr for smallerIp instead of reducing arr
                  W                        OP       (do not use ptr because base case for ptr will be if(ptr == -1) which will cause issue in bottom-up tabulaion)
              /                      \
              /                        \
          w2<= W                       w2 > W
      w2\/  /      \ w2 x                | w2 x
          /        \                    |
          /          \                   |
        [w1]      [w1]                [w1] 
        W-w2      W                    W
            /      \          
          /        \                                 --if(arr[sizeofWtArray-1] <= W) return max(l,r) 
          w1<=W       w1>W                             else return l
            /  \         |
      w1\/ /    \w1 X 0  | w1 X                         --if(sizeofWtArray == 0 || W == 0) return 0
          /      \       |
      []      []      []
      W-w2-w1  W-w2   W-w2  
                                                                                          --while going top-bottom
          if(sizeOfWtArray ==  0 || W == 0 ){                                               if sizeOfWtArray==0 || W == 0
              return 0;                                                                     return 0 and start mocing up
          }
          
                                                                                            --while going top-bottom
          if(weight[sizeOfWtArray-1] <= W){                                                  if(weight[sizeOfWtArray-1] <= W){    (sizeOfWtArray starts from arr.len hence sizeOfarr-1)
              int left = value[sizeOfWtArray-1] +                                              left stores value if wt taken
                        arrayknapSackUnbound(weight,value,sizeOfWtArray,W-weight[sizeOfWtArray-1]); right stores value if wt not taken
              int right = arrayknapSackUnbound(weight,value,sizeOfWtArray-1,W);                     return max(l,r) to next node
              return Math.max(left,right);
          }
          else{                                                                              else
              int left = arrayknapSackUnbound(weight,value,sizeOfWtArray-1,W);                    left stores value if wt not taken
              return left;                                                                        return left to next node
              
          }
          *if you take wt do not reduce size of wt arr as you can take wt again
            if you dont take wt you can reduce sizeOfWtArr because if you dont want that wt means you can reduce the ip


        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips       


      




      */
      

      
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public static int arrayknapSackUnbound(int[] weight , int[] value,int sizeOfWtArray , int W, int[][] dp){ -- INITIALISE MATRIX dp[sizeofWtArray+1][W+1] , FILL MATRIX WITH -1 
          if(sizeOfWtArray ==  0 || W == 0 ){
              return 0;
          }
          
          if(dp[sizeOfWtArray][W] != -1){                                                              -- CHECK IN MATRIX
              return dp[sizeOfWtArray][W];
          }
          
          if(weight[sizeOfWtArray-1] <= W){
              int left = value[sizeOfWtArray-1] +
                       knapSackk01(weight,value,sizeOfWtArray,W-weight[sizeOfWtArray-1],dp);
              int right = knapSackk01(weight,value,sizeOfWtArray-1,W,dp);
              dp[sizeOfWtArray][W] =  Math.max(left,right);                                          --STORE RETURN VALUE IN MATRIX 
              return dp[sizeOfWtArray][W];
              
          }
          else{
              int left = knapSackk01(weight,value,sizeOfWtArray-1,W,dp );
              dp[sizeOfWtArray][W] =  left;
              return dp[sizeOfWtArray][W];
              
          }

          
      }
      
    TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size 
    SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space 
      
      */
        

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
          j  0  1  2  3  4  5                          
      i     -  a  b  c  d  e     -->(i,j) stores for sizeOfArr= i and weight = j 
      0  -  0  0  0  0  0  0        elements of arr add add upto weight unka the number of combination                                   
      1  a  0  1  1  1  1  1                                                        
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4 

      public static int arrayknapSackUnbound(int[] weight , int[] value,int sizeOfWtArray , int W){
          int[][] dp = new int[sizeOfWtArray+1][W+1];                                              --INITIALISE MATRIX
          
          for(int i =0;i <= sizeOfWtArray ; i++){                                                 --STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i; CHARG2 to j
              for(int j=0 ; j <= W;j++){ 
                  if(i == 0 && j == 0){
                        dp[i][j] = 0;
                  }
                  
                
              }
          }
          
          for(int i = 1 ; i <= sizeOfWtArray; i++){                                            -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
              for(int j=1 ; j <= W ;j++){
                  if(weight[i-1] <=j){
                      int left = value[i-1] + dp[i][j-weight[i-1]];
                      int right = dp[i-1][j];
                      dp[i][j] = Math.max(left,right);
                  }
                  else{
                      int left = dp[i-1][j];
                      dp[i][j] = left;
                  }
              }
          }
          
          
          return dp[sizeOfWtArray][W];                                                  -->LAST ELEMENT IN MATRIX IS ANSWER   
          
      }
      
      
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2)  as we matrix takes extra space n^2
    
      
      
      */

        return 0;
    }
    public boolean arraySubsequenceKaSumEqualsTargetKaPossible(int[] arr , int sizeOfarr , int sum){
      /*
      Question
      [2,3,5,6,8,10] --find all the subsets of array
      sum = 10        and find subset  whose sum is equal to given sum and return if they exist  or not
                      Eg [2,8];[2,3,5];[10]     -- subset  whose sum is 10 exists ;so retrurn true
                          
                         
      */
      
      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )
      /*
                  [a1,a2]                 IP     **sizeOfWtArr for smallerIp instead of reducing arr
                  sum                  OP       (do not use ptr because base case for ptr will be if(ptr == -1) which will cause issue in bottom-up tabulaion)
              /                      \
              /                        \
          a[2]<= sum                    a[2] > sum
    a[2]\/ /      \ a[2] x                | a[2] x
          /        \                      |
          /          \                   |
        [a1]      [a1]                 a[1] 
        sum-a[2]  sum                  sum
            /      \          
          /        \                                       --if(a[sizeOfarr-1] <= sum) return l||r    
          a[1]<=sum  a[1]>sum                                 else return l
            /  \           |
    a[1]\/ /    \a[1] X 0  | a[1] X                         --if(sum == 0 && sizeOfarr = anything ) return true 
          /      \         |                                 if(sizeOfArr == 0 && sum != 0) return true
      []         []          []
  sum-a[2]-a[1]  sum-a[2]      sum-a[2]  
                                                                                                      --while going top-bottom
          if(sum ==  0 ){                                                                                if sum==0 && sizeOfarr = anything
              return true;}                                                                              return tru2 and start moving up
          if(sizeOfArr == 0 && sum != 0)){                                                               if sizeOfarr == 0 && sum != 0 
            return true;}                                                                                return false and start moving up
              
          
                                                                                                        --while going top-bottom
          if(arr[sizeOfarr-1] <= sum){                                                                    if(arr[sizeOfarr-1] <= sum){    (sizeOfWtArray starts from arr.len hence sizeOfarr-1)
              boolean left = arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfarr-1,sum-arr[sizeOfarr-1]);   left stores value if element taken
              boolean right = arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfarr-1,sum);                   right stores value if element not taken
              return left||right;                                                                             return left||right to next nod
          }
          else{                                                                                            else
              int left = arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfarr-1,sum);                       left stores value if element not taken
              return left;                                                                                   return left to next node
              
          }



        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips       


      




      */
      

      
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public static int arraySubsequenceKaSumEqualsTargetKaPossible(int[] arr,int sizeOfArr , int sum, int[][] dp){ -- INITIALISE MATRIX dp[sizeOfarr+1][sum+1] , FILL MATRIX WITH -1 
          if(sum ==0){                                                                                  
            return true;} 
          if(sizeOfarr ==  0 && sum != 0){                                                                       
              return false;}                                                                                
                                                                                      
              
          if(dp[sizeOfarr][sum] != -1){                                                              -- CHECK IN MATRIX
              return dp[sizeOfWtArray][sum];
          } 
                                                                                                        
          if(arr[sizeOfarr-1] <= sum){                                                          --STORE RETURN VALUE IN MATRIX(1,0 USED AS T,F SO DO ACCORDINGLY)                          
              int left = arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfarr-1,sum-arr[sizeOfarr-1],dp);   
              int left = arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfarr-1,sum,dp);               
              dp[sizeOfArr][sum] =  ((left + right) != 2)?(left+right):1;  
              return    dp[sizeOfArr][sum];                                                                       
          } 
          else{                                                                                            
              int left = arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfarr-1,sum,dp);                  
              dp[sizeOfArr][sum] =  left;         
              return dp[sizeOfArr][sum];                                                                          
              
          }
      }
      
      
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^2
      
      */
        

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
          j  0  1  2  3  4  5                          
      i     -  a  b  c  d  e     -->(i,j) stores for sizeOfArr= i and sum = j 
      0  -  0  0  0  0  0  0        elements of arr add add upto sum ka  possibility                              
      1  a  0  1  1  1  1  1                                                        
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4  

      public  int arraySubsequenceKaSumEqualsTargetKaPossible(int[] arr ,int sizeOfArr , int sum){
          boolean[][] dp = new int[ptr+1][sum+1];                                              --INITIALISE MATRIX
          
          for(int i =0;i <= sizeOfArr ; i++){                                                 --STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i; CHARG2 to j
              for(int j=0 ; j <= sum;j++){ 
                  if(j == 0){
                    dp[i][j] = true;
                  }
                  if(j != 0 && i == 0 ){
                    dp[i][j] = false;
                  }
                  
                
              }
          }
          
          for(int i = 1 ; i <= sizeOfArr; i++){                                            -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
              for(int j=1 ; j <= sum ;j++){
                  if(arr[i-1] <=j){
                      int left =  dp[i-1][j-arr[i-1]];
                      int right = dp[i-1][j];
                      dp[i][j] = left||right;
                  }
                  else{
                      int left = dp[i-1][j];
                      dp[i][j] = left;
                  }
              }
          }
          
          
          return dp[sizeOfArr][W];                                                  -->LAST ELEMENT IN MATRIX IS ANSWER   
          
      }
      
      
      TIME :O(n^2) = O(sizeOfWtArray*W) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^2
      
      
      */

      return false;
    }
    public int     arraySubsequenceKaSumEqualsTargetKaCountI(int[] arr , int sizeOfarr , int sum){
       /*
      Question
      [2,3,5,6,8,10] --find all the subsets of array
      sum = 10        and find subset  whose sum is equal to given sum and return no of subsets
                      Eg [2,8];[2,3,5];[10]     -- subset  whose sum is 10 are 3; so reurn 3
   
      */
      

      
      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )
      /*
                  [a1,a2]               IP      **sizeOfWtArr for smallerIp instead of reducing arr
                  sum                  OP       (do not use ptr because base case for ptr will be if(ptr == -1) which will cause issue in bottom-up tabulaion)
              /                      \
              /                        \
          a[2]<= sum                    a[2] > sum
    a[2]\/ /      \ a[2] x                | a[2] x
          /        \                      |
          /          \                     |
        [a1]      [a1]                   a[1] 
        sum-a[2]  sum                    sum
            /      \          
          /        \                                       --if(a[sizeOfarr-1] <= sum) return l+r    
          a[1]<=sum  a[1]>sum                                 else return l
            /  \           |
    a[1]\/ /    \a[1] X 0  | a[1] X                         --if(sum == 0 && sizeOfarr == anything) return 1
          /      \         |                                 if(sum != 0 && sizeOfarr == 0) return 0
      []         []          []
  sum-a[2]-a[1]  sum-a[2]      sum-a[2]  

                                                                                                      --while going top-bottom
          if(sum ==  0 ){                                                                                if sum==0 && sizeOfarr = anything
              return 1;}                                                                                 return 1 and start moving up
          if(sum != 0 && sizeOfArr == 0 )){                                                               if sum != 0  && sizeOfarr == 0 
            return 0   ;}                                                                                return 0 and start moving up
              
          
          
                                                                                                        --while going top-bottom
          if(arr[sizeOfarr-1] <= sum){                                                                    if(arr[sizeOfarr-1] <= sum){    (sizeOfWtArray starts from arr.len hence sizeOfarr-1)
              int left = arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfarr-1,sum-arr[sizeOfarr-1]);       left stores value if element taken
              int left = arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfarr-1,sum);                        right stores value if element not taken
              return left+right;                                                                           return left+right to next nod
          }
          else{                                                                                            else
              int left = arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfarr-1,sum);                        left stores value if element not taken
              return left;                                                                                 return left to next node
              
          }



        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips       


      




      */
      

      
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public static int arraySubsequenceKaSumEqualsTargetKaCountI(int[] arr,int sizeOfArr , int sum, int[][] dp){ -- INITIALISE MATRIX dp[sizeOfarr+1][sum+1] , FILL MATRIX WITH -1 
          if(sum ==0  ){                                                                       
              return 1;}                                                                                
          if(sum !=0 && sizeOfarr == 0 ){                                                                                  
            return 0;}                                                                              
              
          if(dp[sizeOfarr][sum] != -1){                                                              -- CHECK IN MATRIX
              return dp[sizeOfWtArray][sum];
          } 
                                                                                                        
          if(arr[sizeOfarr-1] <= sum){                                                            --STORE RETURN VALUE IN MATRIX
              int left = arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfarr-1,sum-arr[sizeOfarr-1]);   
              int right = arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfarr-1,sum);               
              dp[sizeOfArr][sum] =  left + right;  
              return    dp[sizeOfArr][sum];                                                                       
          } 
          else{                                                                                            
              int left = arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfarr-1,sum);                  
              dp[sizeOfArr][sum] =  left;         
              return dp[sizeOfArr][sum];                                                                          
              
          }
      }
      
      
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^2
      
      */
        

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
          j  0  1  2  3  4  5                          
      i     -  a  b  c  d  e     -->(i,j) stores for sizeOfArr= i and sum = j 
      0  -  0  0  0  0  0  0        elements of arr add add upto sum ;unk arrays ka  count                              
      1  a  0  1  1  1  1  1                                                        
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4  
    
      public  int arraySubsequenceKaSumEqualsTargetKaCountI(int[] arr ,int sizeOfArr , int sum){
          int[][] dp = new int[sizeOfArr+1][sum+1];                                              --INITIALISE MATRIX
          
          for(int i =0;i <= sizeOfArr ; i++){                                                 -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i; CHARG2 to j
              for(int j=0 ; j <= sum;j++){ 
                  if(j == 0){
                    dp[i][j] = 1;
                  }
                  if(j!=0 && i == 0){
                    dp[i][j] = 0;
                  }
                  
                
              }
          }
          
          for(int i = 1 ; i <= sizeOfArr; i++){                                               -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
              for(int j=1 ; j <= sum ;j++){
                  if(arr[i-1] <=j){
                      int left =  dp[i-1][j-arr[i-1]];
                      int right = dp[i-1][j];
                      dp[i][j] =left+ right;
                  }
                  else{
                      int left = dp[i-1][j];
                      dp[i][j] = left;
                  }
              }
          }
          
          
          return dp[sizeOfArr][sum];                                                              -->LAST ELEMENT IN MATRIX IS ANSWER   
          
      }
      
      
      TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
      
      
      */

      return 0;
    
    }
    public int     arraySubsequenceKaSumEqualsTargetKaCountII_CoinChangeCombinationCount(int[] coins ,int sizeOfarr, int sum){
      /*
      QUESTION
        [2,3,5,6,8,10] --find all the subsets of array where each element can be taken any no of times
        sum = 10        and find subset  whose sum is equal to given sum and return no of subsets
                        Eg [2,8];[2,3,5];[10]     -- subset  whose sum is 10 are 3; so reurn 3
         OR
        coins: [1,2,3] -- given an infinite supply of coins
         sum = 5          return how many ways can we make change
                          eg {2,3} -- 5 such combo exists so return 5
                           {1,2,2} 
                           {1 ,1 ,1 ,2}
                           {1,1,3}
                           {1,1,1,1,1}
      */
  

  
        //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
        /*
        return arraySubsequenceKaSumEqualsTargetKaCountI(coins,sizeOfarr,sum);-->fn is bounded knapsack ; make fn unbounded knapsack--> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                             int left = arraySubsequenceSumEqualsTargetCount(arr,sizeOfarr-1,sum-arr[sizeOfarr-1]); 
                                                                             TO
                                                                              int left = arraySubsequenceSumEqualsTargetCount(arr,sizeOfarr,sum-arr[sizeOfarr-1]); 
  
  
        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips     
  
                                                              
  
  
        */
  
  
        //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
        /*
        return arraySubsequenceKaSumEqualsTargetKaCountI(coins,sizeOfarr,sum);-->fn is bounded knapsack ; make fn unbounded knapsack --> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                             boolean left = arraySubsequenceSumEqualsTargetCount(arr,sizeOfarr-1,sum-arr[sizeOfarr-1]); 
                                                                             TO
                                                                              boolean left = arraySubsequenceSumEqualsTargetCount(arr,sizeOfarr,sum-arr[sizeOfarr-1]); 
  
  
  
          
        TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
        SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
        */
      
      
        //DP BOTTOM-UP TABULATION(Overlapping subproblem )
        /*
        return arraySubsequenceKaSumEqualsTargetKaCountI(coins,sizeOfarr,sum);-->fn is bounded knapsack ; make fn unbounded knapsack --> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                            int left = dp[i-1][j-weight[i-1]];
                                                                            TO
                                                                            int left = dp[i][j-weight[i-1]];
  
  
  
        TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
        SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
        */
  
        return 0;
  
  
     }
    public int     arraySubSequenceKaSumEqualsTargetKaMinLengthI(int[] arr, int sizeOfArr,int sum){
      /*
      Question
      [2,3,5,6,8,10] --find all the subsets of array
      sum = 10        and find subset  whose sum is equal to given sum and return min length of the subset
                      Eg [2,8];[2,3,5];[10]     -- subset  whose sum is 10 are these min length is 1
   
      */
      

      
      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )
      /*
                  [a1,a2]                 IP     **sizeOfWtArr for smallerIp instead of reducing arr
                  sum                  OP       (do not use ptr because base case for ptr will be if(ptr == -1) which will cause issue in bottom-up tabulaion)
              /                      \
              /                        \
          a[2]<= sum                    a[2] > sum
    a[2]\/ /      \ a[2] x                | a[2] x
          /        \                    |
          /          \                   |
        [a1]      [a1]                 a[1] 
        sum-a[2]  sum                  sum
            /      \          
          /        \                                       --if(a[sizeOfarr-1] <= sum) return l+r    
          a[1]<=sum  a[1]>sum                                 else return l
            /  \           |
    a[1]\/ /    \a[1] X    | a[1] X                         --if(sum == 0 && sizeOfarr==anything) return 0;
          /      \         |                                  if(sum != 0 && sizeOfArr == 0)     return Integer. MAX_VALUE-1
      []         []          []
  sum-a[2]-a[1]  sum-a[2]      sum-a[2]  
                                                                                                      --while going top-bottom
          if(sum ==0 ){                                                                                 if sum == 0 && sizeOfarr==anything
            return  0;}                                                                                 return 0 and start moving up
          if(sum != 0 && sizeOfArr == 0){                                                               if sum != 0 && sizeOfArr == 0
            return  Integer. MAX_VALUE-1;;}                                                             return Integer. MAX_VALUE-1(-1 because later on we will add +1 while coming up) and start moving up
              
          
                                                                                                        --while going top-bottom
          if(arr[sizeOfarr-1] <= sum){                                                                    if(arr[sizeOfarr-1] <= sum){    (sizeOfWtArray starts from arr.len hence sizeOfarr-1)
              boolean left = 1 + arraySubSequenceKaSumEqualsTargetKaMinLengthI(arr,sizeOfArr-1,sum-arr[sizeOfArr-1]);   left stores sizeof arr if element taken
              boolean right =  arraySubSequenceKaSumEqualsTargetKaMinLengthI(arr,sizeOfArr-1,sum);                     right stores sizeof arr if element not taken
              return  return Math.min(left,right);                                                                 return min(l,r)  to next nod
          }
          else{                                                                                            else
              int left =  0 + arraySubSequenceKaSumEqualsTargetKaMinLengthI(arr,sizeOfArr-1,sum);                     left stores size of arr if element not taken
              return left;                                                                                       return left to next node
              
          }



        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips       


      




      */
      
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      public int arraySubSequenceKaSumEqualsTargetKaMinLengthI(int[] arr, int sizeOfArr,int sum ,int[][] dp){ -->INITIALISE MATRIX dp[sizeOfarr+1][sum+1] , FILL MATRIX WITH -1 
        
        
        if(sum == 0){
            dp[sizeOfArr][sum ] =  0;
            return dp[sizeOfArr][sum ];
        }
        if(sum != 0 && sizeOfArr ==0){
            dp[sizeOfArr][sum ] =  Integer.MAX_VALUE -1;
            return dp[sizeOfArr][sum ];
        }  
        
        
        if(dp[sizeOfArr][sum ] != -1){                                                               -->CHECK MATRIX
            return dp[sizeOfArr][sum ];
        }
      
        
        if(arr[sizeOfArr-1] <= sum){
            int left = 1 + arraySubSequenceKaSumEqualsTargetKaMinLengthI(arr,sizeOfArr-1,sum-arr[sizeOfArr-1]);
            int right = 0 + arraySubSequenceKaSumEqualsTargetKaMinLengthI(arr,sizeOfArr-1,sum);
            
            dp[sizeOfArr][sum ] =  Math.min(left,right);                                             -->STORE RETURN VALUE IN MATRIX
            return dp[sizeOfArr][sum ];
            
        }
        else{
            int left =  0 + arraySubSequenceKaSumEqualsTargetKaMinLengthI(arr,sizeOfArr-1,sum);
            dp[sizeOfArr][sum ] =  left;
            return dp[sizeOfArr][sum ];
        }
        
        
        
    }

    
      */

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*

          j  0  1  2  3  4  5                          
      i     -  a  b  c  d  e     -->(i,j) stores for sizeOfArr= i and sum = j 
      0  -  0  0  0  0  0  0        elements of arr add add upto sum; un arrays ka min length                            
      1  a  0  1  1  1  1  1                                                        
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4  


      public int arraySubSequenceKaSumEqualsTargetKaMinLengthI(int[] arr, int sizeOfArr,int sum){
        
        int[][] dp = new int[sizeOfArr+1][sum+1];                     -->INITIALISE MATRIX

        for(int i = 0;i<= sizeOfArr;i++){                             -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
            for(int j=0 ; j<=sum;j++){
                if(j==0){
                    dp[i][j] = 0;
                }
                if(j!=0 && i == 0){
                    dp[i][j] = Integer.MAX_VALUE -1;
                }
              
            }
        }

    
        
        for(int i = 1;i<= sizeOfArr;i++){                         -->STORE RETURN VALUE IN MATRIX BY CONVERTING CHARG1 TO i CHARG2 j
            for(int j=1 ; j<=sum;j++){
                if(arr[i-1] <= j){
                    int left = 1+ dp[i-1][j-arr[i-1]];
                  int right = 0 + dp[i-1][j];
                  dp[i][j] = Math.min(left,right);
                }
              else{
                  int  left = 0 + dp[i-1][j];
                  dp[i][j] = left;
              }
            }
        }
      
      
        return dp[sizeOfArr][sum];                              -->LAST ELEMENT IN MATRIX IS AMSWER
        }
      */


        

     return 0;
	    
	    
	    
	}
    public int     arraySubSequenceKaSumEqualsTargetKaMinLengthII_CoinChangeCombinationMinCount_PerfectSquareMinCount(int[] coins ,int sizeOfarr, int sum){
      /*
      QUESTION
      [2,3,5,6,8,10] --find all the subsets of array where each element can be taken any no of times
      sum = 10         and find subset  whose sum is equal to given sum and return subset with  min length
                        Eg [2,8];[2,3,5];[10]     -- subset  whose sum is 10 are these and min length is 1 
      OR
      coins: [1,2,3] -- given an infinite supply of coins
      sum = 5            return min  number  of coins required  to make sum
                        Eg {2,3} --  min 2 coins are required  so return 2
                          {1,2,2} 
                          {1 ,1 ,1 ,2}
                          {1,1,3}
                          {1,1,1,1,1}
      OR
      n = 12 --given a number return the least number of perfect squares that add upto number
              Eg:12 -- 1+1+1+1..+1            --min no of perfect squares that add upto 12 is 3 
                       1 + 1+ 1 + 1 + 4 + 4
                       4 + 4 + 4


      */


        //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
        /*
        return arraySubSequenceKaSumEqualsTargetKaMinLengthI(coins,sizeOfarr,sum);-->fn is bounded knapsack ; make fn unbounded knapsack --> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                          int left = left = 1 + arraySubSequenceSumEqualsTargetMinLength(arr,sizeOfArr-1,sum-arr[sizeOfArr-1]);
                                                                          TO
                                                                          int left = left = 1 + arraySubSequenceSumEqualsTargetMinLength(arr,sizeOfArr,sum-arr[sizeOfArr-1]);


        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips     

                                                              


        */


        //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
        /*
        return arraySubSequenceKaSumEqualsTargetKaMinLengthI(coins,sizeOfarr,sum);-->fn is bounded knapsack ; make fn unbounded knapsack --> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                          int left = left = 1 + arraySubSequenceSumEqualsTargetMinLength(arr,sizeOfArr-1,sum-arr[sizeOfArr-1]);
                                                                          TO
                                                                          int left = left = 1 + arraySubSequenceSumEqualsTargetMinLength(arr,sizeOfArr,sum-arr[sizeOfArr-1]);


          
        TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
        SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
        */
      
      
        //DP BOTTOM-UP TABULATION(Overlapping subproblem )
        /*
        return arraySubSequenceKaSumEqualsTargetKaMinLengthI(coins,sizeOfarr,sum);-->fn is bounded knapsack ; make fn unbounded knapsack --> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                          int left = 1+ dp[i-1][j-arr[i-1]];
                                                                          TO
                                                                          int left = 1+ dp[i][j-arr[i-1]];



        TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
        SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
        */

        //arrayPerfectSquareMinCount()
        /*
        public int[] arrayPerfectSquareMinCount(int n){ 
          int[] res = new int[n];int index =0;              --arr: arr of perfect squares upto numbr
          int no = 1;                                         sum: n
          while(no*no <= n){
              res[index++] = no*no;
              no++;
          }
          
          int[] arr =  Arrays.copyOfRange(res,0,index);
          int sum = n;
          return  arraySubSequenceKaSumEqualsTargetKaMinLengthII(arr,arr.length,sum)''

          
      }
         */
        return 0;



    }
    public void    arraySubsequenceKaSumEqualsTargetKaArraysI(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
      /*
    [2,3,5,6,8,10] --find all the subsequence of array
    sum = 10        and find subsequence  whose sum is equal to given sum and return the subsets
                    Eg [2,8];[2,3,5];[10]     -- subsequence  whose sum is 10 are 3; so reurn those subsequence                                     
                              
    */

      //RECURSIVE IP-OP TREE + FOR
      /*
                
              /  \  \          --recursive tree for "i" inside for loop
            /    \  \
            0     1   2
            /\    /
          /  \  /
          1  2  2
      public void arraySubsequenceKaSumEqualsTargetKaArraysI(int [] arr, int ptr,int sum,List<Integer> tempList, List<List<Integer>> resultList){
                                
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        if(sum <0 ){return;}                                    if sum <0 return and start moving up             Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
        if(sum == 0){result.add(new ArrayList<>(tempList));}    if sum == 0 add tempList to resultist
        
        for(int i = ptr; i <= arr.length-1; i++){
                                                                --while coming top-down inside for
            if(i > ptr && arr[i] == arr[i-1]) continue;           skip duplicate of arr(sort arr in overload method) to get unique subset subsequences ie [1,2,2]  1,2(1st2),2(2nd2) and 1,2(2nd 2),2(1st 2) 
            tempList.add(arr[i]);                                 add arr[i] to tempList    
          
            arraySubsequenceKaSumEqualsTargetKaArraysI(arr, i + 1,       --while going top-down insode for
                          sum-arr[i] tempList, result);                  increment i and give to ptr
                                                                          decrement sum
  
                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last element from tempList  
        }

      //OVERRIDE
      public void arraySubsequenceKaSumEqualsTargetKaArraysI(int [] arr, int sum){   
        List<Integer> tempList = new ArrayList<>();            
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
        arraySubsequenceKaSumEqualsTargetKaArraysI(arr,0,sum,tempList,resultList);
          
        resultList.remove(0); return resultList // subsequence
        return resultList //subset
      }

      
      TIME :O(n!)--> Level1 has n nodes ; Each node on level 1 has n-1 nodes on level 2 ; Each node on level 2 has n-2 node pn level 3
      Space:O(n)     so total nodes would be n*(n-1*(n-2)...))) = n!

      */



  }
    public void    arraySubsequenceKaSumEqualsTargetKaArraysII_CoinChangeCombinationArray(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){

      /*
      QUESTION
        [2,3,5,6,8,10] --find all the subsequence of array where each element can be taken any no of times
        sum = 10        and find subsequence  whose sum is equal to given sum and return those subsequence
                        Eg [2,8];[2,3,5];[10]     -- subsequence  whose sum is 10 are 3; so reurn 3
        OR
        coins: [1,2,3] -- given an infinite supply of coins
        sum = 5          return the  ways can we make change
                          eg {2,3} -- 5 such combo exists so return 5
                          {1,2,2} 
                          {1 ,1 ,1 ,2}
                          {1,1,3}
                          {1,1,1,1,1}                                    
                                
      */

      //RECURSIVE IP-OP TREE + FOR
      /*
        return arraySubsequenceKaSumEqualsTargetKaArraysII(coins,sizeOfarr,sum);-->similar to knapsack you can take elements multiple times by making  the chang--> Jaha pe leta hai vaha ip ka size kam mat karna
                                                                              arraySubsequenceKaSumEqualsTargetKaArraysI(arr, i + 1,sum-arr[i] tempList, result)
                                                                              TO
                                                                              arraySubsequenceKaSumEqualsTargetKaArraysII(arr, i,sum-arr[i] tempList, result)


      TIME :O(n!)--> Level1 has n nodes ; Each node on level 1 has n-1 nodes on level 2 ; Each node on level 2 has n-2 node pn level 3
      Space:O(n)     so total nodes would be n*(n-1*(n-2)...))) = n!

                                                            
      */


    }
    public void    arraySubsequenceOfSizeKKaSumEqualsTargetKaArraysI(List<Integer>ip ,List<Integer> op , List<List<Integer>> resultList){
      /*
    [2,3,5,6,8,10] --find all the subsequence of size k 
    sum = 10 ,k=3       and find subsequence  whose sum is equal to given sum and return the subsets
                       Eg[2,3,5]   -- subsequence  whose sum is 10 and size is 3 is 2,3,5; so reurn those subsequence                                     
                              
    */

      //RECURSIVE IP-OP TREE + FOR
      /*
                
              /  \  \          --recursive tree for "i" inside for loop
            /    \  \
            0     1   2
            /\    /
          /  \  /
          1  2  2
      public void arraySubsequenceOfSizeKKaSumEqualsTargetKaArraysI(int [] arr, int ptr,int sum,List<Integer> tempList, List<List<Integer>> resultList, int k){
                                
                                                              --while coming top-down outside for
        if(ptr > arr.length){return;}                           if(ptr > arr.length) return and start moving up (> not = because you add tempList to result 1st then add element to tempList so you dont want to lose last element
        if(sum <0 ){return;}                                    if sum <0 return and start moving up             Eg [0,1,2] when i=2 then tempList = [0,1,2] then you  call fn recursively and now if ptr == arr.length you would return without adding this tempList to res 
        if(sum == 0 && tempList.size() == k){result.add(new ArrayList<>(tempList));}    if sum == 0 add tempList ka size equals k then add to  resultist
        
        for(int i = ptr; i <= arr.length-1; i++){
                                                                --while coming top-down inside for
            if(i > ptr && arr[i] == arr[i-1]) continue;           skip duplicate of arr(sort arr in overload method) to get unique subset subsequences ie [1,2,2]  1,2(1st2),2(2nd2) and 1,2(2nd 2),2(1st 2) 
            tempList.add(arr[i]);                                 add arr[i] to tempList    
          
            arraySubsequenceKaSumEqualsTargetKaArraysI(arr, i + 1,       --while going top-down insode for
                          sum-arr[i] tempList, result,k);                  increment i and give to ptr
                                                                          decrement sum
  
                                                                --while coming bottom -top inside for
            tempList.remove(tempList.size() - 1);                 remove last element from tempList  
        }

      //OVERRIDE
      public void arraySubsequenceOfSizeKKaSumEqualsTargetKaArraysI(int [] arr, int sum, int k){   
        List<Integer> tempList = new ArrayList<>();            
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
        arraySubsequenceOfSizeKKaSumEqualsTargetKaArraysI(arr,0,sum,tempList,resultList, k);
          
        return resultList 
      }

      
      TIME :O(n!)--> Level1 has n nodes ; Each node on level 1 has n-1 nodes on level 2 ; Each node on level 2 has n-2 node pn level 3
      Space:O(n)     so total nodes would be n*(n-1*(n-2)...))) = n!

      */



  }
    public boolean arraySubsequenceKaSumOfPairsDifferenceEqualsZeroKaPossible(int[] arr, int sizeOfarr){
      /*
        Question
        [1,5,11,5]    --find all the subsets of array
        sum = 10        and find pair of subset  whose sum ka difference equal 0  and return if pair  exist  or not
                        Eg [1,5,5] - [11] = 0--> pair of subset  whose sum is equal exists ;so return true  
    


        */

      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
      /*
        int sumOfArr = sumOfArr(arr)
        if(sumOfArr % 2 == 0){                                                     --even numbers can be divied in equal partitions
          int sum = sumOfArr/2;                                                     sum(subset1) = sum(subset2) 
          int sizeOfArr = arr.length                                                sum(subset1) - sum(subset2) =0  
          return arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfArr,sum);        sum(subset1) - (sum(arr)- sum(subset1)) = 0 ;  
        }                                                                           sum(subset1) = sum(arr)/2  -->subsequence shose sum equals sumOfArr/2

        else{ 
          return false;                                                               -- odd numbers cant be divided in equal partitions
        }


        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips     

                                                              


        */

      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      if(sumOfArr % 2 == 0){                                                     --even numbers can be divied in equal partitions
        int sum = sumOfArr/2;                                                     sum(subset1) = sum(subset2) 
        int sizeOfArr = arr.length                                                sum(subset1) - sum(subset2) =0  
        int[][] dp = new int[sizeOfArr+1][sum+1]                                  sum(subset1) - (sum(arr)- sum(subset1)) = 0 ;  
        for(int i=0 ; i<= dp.length-1;i++){                                        sum(subset1) = sum(arr)/2  -->subsequence shose sum equals sumOfArr/2
          for(int j=0 ; j<= dp[i].length-1;j++){dp[i][j] = -1;}}
        return arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfArr,sum,dp);                                                                        
      }
      else{ 
        return false;                                                               -- odd numbers cant be divided in equal partitions
      }


        
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
      */
      
      
      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      if(sumOfArr % 2 == 0){                                                     --even numbers can be divied in equal partitions
        int sum = sumOfArr/2;                                                     sum(subset1) = sum(subset2) 
        int sizeOfArr = arr.length                                                sum(subset1) - sum(subset2) =0  
        return arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfArr,sum);        sum(subset1) - (sum(arr)- sum(subset1)) = 0 ;  
      }                                                                           sum(subset1) = sum(arr)/2  -->subsequence shose sum equals sumOfArr/2

      else{ 
        return false;                                                               -- odd numbers cant be divided in equal partitions
      }




      TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
      */

      return false;

    }
    public int     arraySubsequenceKaSumOfPairsDifferenceEqualsZeroKaCount(int[] arr , int sizeOfarr){
      /*
      Question
      [1,5,11,5]    --find all the subsets of array
      sum = 10        and find pair of subset  whose sum ka difference equal 0  and return  pair count
                      Eg [1,5,5] -[11] = 0 --> pair of subset  whose sum is equal is 1 ; so return 1
      */

      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
      /*
      int sumOfArr = sumOfArr(arr)
      if(sumOfArr % 2 == 0){                                                     --even numbers can be divied in equal partitions
        int sum = sumOfArr/2;                                                     sum(subset1) = sum(subset2) 
        int sizeOfArr = arr.length                                                sum(subset1) - sum(subset2) =0  
        return arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfArr,sum);      sum(subset1) - (sum(arr)- sum(subset1)) = 0 ;  
      }                                                                           sum(subset1) = sum(arr)/2  -->subsequence shose sum equals sumOfArr/2

      else{ 
        return 0;                                                               -- odd numbers cant be divided in equal partitions
      }


      TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
      SPACE:O(n) as we have n(size of wt array)ips     

                                                              


        */

      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      if(sumOfArr % 2 == 0){                                                     --even numbers can be divied in equal partitions
        int sum = sumOfArr/2;                                                     sum(subset1) = sum(subset2) 
        int sizeOfArr = arr.length                                                sum(subset1) - sum(subset2) =0  
        int[][] dp = new int[sizeOfArr+1][sum+1]                                  sum(subset1) - (sum(arr)- sum(subset1)) = 0 ;  
        for(int i=0 ; i<= dp.length-1;i++){                                       sum(subset1) = sum(arr)/2  -->subsequence shose sum equals sumOfArr/2
          for(int j=0 ; j<= dp[i].length-1;j++){dp[i][j] = -1;}}
        return arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfArr,sum,dp);                                                                        
      }
      else{ 
        return 0;                                                               -- odd numbers cant be divided in equal partitions
      }


        
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
      */
      
      
      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      if(sumOfArr % 2 == 0){                                                     --even numbers can be divied in equal partitions
        int sum = sumOfArr/2;                                                     sum(subset1) = sum(subset2) 
        int sizeOfArr = arr.length                                                sum(subset1) - sum(subset2) =0  
        return arraySubsequenceSumEqualsTargetCount(arr,sizeOfArr,sum);           sum(subset1) - (sum(arr)- sum(subset1)) = 0 ;  
      }                                                                           sum(subset1) = sum(arr)/2  -->subsequence shose sum equals sumOfArr/2

      else{ 
        return 0;                                                               -- odd numbers cant be divided in equal partitions
      }




      TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
      */

      return 0;

    }
    public boolean arraySubsequenceKaSumOfPairsDifferenceEqualsTargetKaPossible(int[] arr, int sizeOfarr , int difference){
       /*
      Question
      [1,1,2,3]     --find all the subsets of array
      diff = 1        and find pair of subset  whose sum ka difference is given diff and return if they exist  or not
                      Eg [1,3] - [1,2] = 1;[1(another1),3] - [1(another1),3] = 1--> pair of subset  whose sum ka diff is given diff exists ; so return true  

      */
      
      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
      /*
        int sumOfArr = sumOfArr(arr)
        int sizeOfArr = arr.length                                              sum(subset1) - sum(subset2) = diff
        int sum = (sumOfArr + diff)/2                                           sum(subset1) - (sum(arr)- sum(subset1)) = diff;
        return arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfArr,sum);      sum(subset1) = (diff + sum(arr))/2 ;  -->subsequence shose sum equals (diff + sum(arr))/2 
       


        TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
        SPACE:O(n) as we have n(size of wt array)ips     

                                                              


      */


      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      int sizeOfArr = arr.length                                              sum(subset1) - sum(subset2) = diff
      int sum = (sumOfArr + diff)/2                                           sum(subset1) - (sum(arr)- sum(subset1)) = diff;
      int[][] dp = new int[sizeOfArr+1][sum+1]                                sum(subset1) = (diff + sum(arr))/2 ;  -->subsequence shose sum equals (diff + sum(arr))/2 
      for(int i=0 ; i<= dp.length-1;i++){ 
        for(int j=0 ; j<= dp[i].length-1;j++){dp[i][j] = -1;}}
      return arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfArr,sum,dp); 


        
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
      */
    
    
      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      int sizeOfArr = arr.length                                              sum(subset1) - sum(subset2) = diff
      int sum = (sumOfArr + diff)/2                                           sum(subset1) - (sum(arr)- sum(subset1)) = diff;
      return arraySubsequenceKaSumEqualsTargetKaPossible(arr,sizeOfArr,sum);      sum(subset1) = (diff + sum(arr))/2 ;  -->subsequence shose sum equals (diff + sum(arr))/2 
      






      TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
      */

      return false;


    }
    public int     arraySubsequenceKaSumOfPairsDifferenceEqualsTargetKaCount(int[] arr, int sizeOfarr , int difference){
      /*
      Question
      [1,1,2,3]     --find all the subsequence of array
      diff = 1        and find pair of subsequence  whose sum ka difference is given diff and return pair count
                      Eg [1,3] - [1,2] = 1;[1(another1),3] - [1(another1),3] = 1--> pair of subset  whose sum ka diff is given diff are 2 pairs ; so return 2  





     */
     
      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
      /*
      int sumOfArr = sumOfArr(arr)
      int sizeOfArr = arr.length                                              sum(subset1) - sum(subset2) = diff
      int sum = (sumOfArr + diff)/2                                           sum(subset1) - (sum(arr)- sum(subset1)) = diff;
      return arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfArr,sum);    sum(subset1) = (diff + sum(arr))/2 ;  -->subsequence shose sum equals (diff + sum(arr))/2 
      


      TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
      SPACE:O(n) as we have n(size of wt array)ips     

                                                            


      */


      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      int sizeOfArr = arr.length                                              sum(subset1) - sum(subset2) = diff
      int sum = (sumOfArr + diff)/2                                           sum(subset1) - (sum(arr)- sum(subset1)) = diff;
      int[][] dp = new int[sizeOfArr+1][sum+1]                                sum(subset1) = (diff + sum(arr))/2 ;  -->subsequence shose sum equals (diff + sum(arr))/2 
      for(int i=0 ; i<= dp.length-1;i++){ 
        for(int j=0 ; j<= dp[i].length-1;j++){dp[i][j] = -1;}}
      return arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfArr,sum,dp); 


        
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
      */
    
    
      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      int sumOfArr = sumOfArr(arr)
      int sizeOfArr = arr.length                                              sum(subset1) - sum(subset2) = diff
      int sum = (sumOfArr + diff)/2                                           sum(subset1) - (sum(arr)- sum(subset1)) = diff;
      return arraySubsequenceKaSumEqualsTargetKaCountI(arr,sizeOfArr,sum);    sum(subset1) = (diff + sum(arr))/2 ;  -->subsequence shose sum equals (diff + sum(arr))/2 
      






      TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
      */

      return 0;

   }
    public int     arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount___ArraySignPermutation(int[] arr, int sizeOfarr , int difference){
      /*
      Question
      [1,1,1,1,1]     --divide arr into 2 subsequence pair whose sum ka difference is given diff and return pair count 
      diff = 1         Eg [1,1,1,1] - [1] = 1;[ 1(another 1),1,1,1] - [1(another1)] = 1 
                      
      OR
      [1,1,1,1,1,1]   -- find the number of ways we can assign + - sign to elements such that
      sum = 3            we can attain the target sum, 
                        -1 + 1 + 1 + 1 + 1 = 3 -- so 5 ways so return 5
                        +1 - 1 + 1 + 1 + 1 = 3
                        +1 + 1 - 1 + 1 + 1 = 3
                        +1 + 1 + 1 - 1 + 1 = 3
                        +1 + 1 + 1 + 1 - 1 = 3

                        = [1,1,1,1] - [1] 
                          [1,1,1,1] - [1]...
                                    
    Note :sum can be -ve
         Eg: [1000,2] -->-1000 + 2
             sum = -998 


    */
    
      //RECURSION - IP OP TREE (Decision: element1 lu ya na ; element2 lu ya na lu )   
      /*
              [a1,a2]                 IP     
                 sum                  OP 
                 COND -->a[2]<= sum ;a[2] > sum(we avoid checking these cond because you  do not have the choice of not taking an element as we have to divide arr into 2 subsequence so all elements of arr must be taken )
          +a[2]\/ /\-a[2]                 
                 /  \                            
                /    \                              --return l+r
            [a1]      [a1]
            sum-a2    sum - (-a2)
      +a[1] / \ -a[1] +a[1] /    \  -a[1]            -- if(sum == 0 && sizeOfArr == 0  ){return 1;}
           /   \           /      \                     if(sum != 0 && sizeOfArr == 0 ){return 0;}
         []    []         []       []
    sum-a2-a2  sum-a2+a1  sum+a2-a2 sum +a2-a1



    public int arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount___ArraySignPermutation(int[] arr, int sizeOfArr,int sum){ 

                                                                                     --while going top-bottom
        if(sum == 0 && sizeOfArr == 0  ){                                             if(sum == 0 && sizeOfArr == 0  )
           return 1;}                                                                       return 1 because this subarray gives tatget sum and also we have used up all elements in array(in other examples we dont care if we have used up all elements or not but here we have to divide in 2 pairs so pairs ust have all elemengts)
        if(sum != 0 && sizeOfArr == 0 ){                                               if(sum != 0 && sizeOfArr == 0  )
           return 0;}                                                                        return 0 because this subarray doesnt gives tatget sum and also we have used up all elements in array
    
       
                                                                                       --while going top-bottom
         int left = arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount_(arr,sizeOfArr-1, sum - arr[sizeOfArr-1]);       left stores count of subsequence if we take +element
         int right = arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount_(arr,sizeOfArr-1, sum  + arr[sizeOfArr-1]);     right stores count of subsequence if we take +element

                                                                                       --while going bottom top
         return left+ right;                                                             return lrft + right




      TIME :O(2^n) as each fn calls itself twice and n(size of wt array) reduces by 1 
      SPACE:O(n) as we have n(size of wt array)ips     

                                                            


      */


      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      public int arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount___ArraySignPermutation(int[] arr, int sizeOfArr,int sum ,Map<String,Integer> dp){ 
       if(sum == 0 && sizeOfArr == 0  ){return 1;}                                                             -->INITIALISE HASHMAP IN MAIN FN(Map<String,Integer> map = new HashMap<>())
       if(sum != 0 && sizeOfArr == 0 ){return 0;}                                                                (KEY: Use " " GET: use getOrDefault(key,00))
                                                                    
       if(map.containsKey(String.valueOf(sizeOfArr) +" " +  String.valueOf(sum))){                              -->CHECK MAP  
           return map.get(String.valueOf(sizeOfArr) +" " +  String.valueOf(sum));
       }


        int left = arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount_(arr,sizeOfArr-1, sum - arr[sizeOfArr-1],map);                         -->STORE RETURN VALUE IN MAP
        int right = arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount_(arr,sizeOfArr-1, sum  + arr[sizeOfArr-1],map); 
        map.put(key,left+ right);
        return map.get(key);
      
        
      TIME :O(n^2) = O(sizeOfWtArray*W) as we reduce  recursion overlapping subproblems and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*W)as we matrix takes extra space n^
      */
    
    
      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
           j  0  1  2  3  4  5                          
      i     -  a  b  c  d  e     -->(i,j) stores for sizeOfArr= i and sum = j 
      0  -  0  0  0  0  0  0        sum of 2 pairs ke difference equals target ka  count                            
      1  a  0  1  1  1  1  1                                                        
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4  


      public int arraySubsequenceKaSumOf2PairsDifferenceEqualsTargetKaCount_(int[] arr ,int sizeOfArr , int sum){
        int max_limit = arraySum(arr);                                                                       -->INITIALISE MIN AND MAX LIMIT OF THE SUM WHICH IS -VE
        int min_limit = -arraySum(arr);
        if (sum < min_limit || sum > max_limit) return 0;
        
        Map<String,Integer> map = new HashMap<>();                                                          -->INITIALISE MAP
                                                                                                             (KEY: Use " " ; GET: use getOrDefault(key,00))
          
        for(int i = 0 ; i <= sizeOfArr; i++){                                                              -->STORE RET VALUE IN MAP BY CHANNGING CHAR1 to i and CHARG2 to j
            for(int j= min_limit ; j <= max_limit;j++){                                                       (j ie sum is itesle -ve so j =min_limit to max_limit in base cond as well as recursion cond  )
               if(j == 0 && i == 0  ){
                   map.put((String.valueOf(i) + " " + String.valueOf(j))   ,1 );}
                if(j != 0 && i == 0 ){
                   map.put((String.valueOf(i) + " " + String.valueOf(j))   ,0);}
            }
        }      
        for (int i=1; i <=sizeOfArr; i++) {                                                                  -->STORE RET VALUE IN MAP BY CHANNGING CHAR1 to i and CHARG2 to j
            for (int j=min_limit; j <= max_limit; j++) {                                                       (j ie sum is itesle -ve so j =min_limit to max_limit in base cond as well as recursion cond  )
                int left = map.getOrDefault(String.valueOf(i-1) + " " + String.valueOf(j - arr[i-1]), 0);
                int right =map.getOrDefault(String.valueOf(i-1) + " " + String.valueOf(j + arr[i-1]), 0); 
                map.put((String.valueOf(i) + " " +String.valueOf(j) ) , left + right);  
                
                
            }
        } 
        
        return map.get(String.valueOf(sizeOfArr) + " " + String.valueOf(sum));                                 -->RETURN LAST VALUE IN MAP
           
         
    }
  




      TIME :O(n^2) = O(sizeOfWtArray*sum) as we elminiate recursion and use matrix of size n^2
      SPACE:O(n^2) == O(sizeOfWtArray*sum)as we matrix takes extra space n^2
      */

      return 0;

  }
    public int     arraySubsequenceKaSumOfPairsDifferenceEqualsMinKaSum(int[] arr , int sizeOfarr ){
      /*

      Question
      [1,5,6,11]     --find all the subsets of array
      diff = 1        and find pair of subset  whose sum ka difference is min diff and return the min diff
                      Eg [5,11] - [1,6] = 9 ; [6,11] - [1,5] = 11 ;[1,11] - [5,6] = 1  --> pair of subset  whose sum ka difference is min is 3rd wala ; so return its diff 1


      https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
      */

       //DP BOTTOM-UP TABULATION  WRT arrayknapSack01([1 , 2,   3,   4]    --  {   }  {   }                    )
      //                                          /\  / \  / \  / \        sum1  sum2  sum1 - sum2 = min
      //                                         \/ X  \/ X \/ X \/ X       
      /*



      arrayknapSack01                                                                     subsetSum
      weight = [1,2,3,4] value = [1,2,3,4]                                           arr = [1,2,3,4] 
      Weight = 5                                                                     sum = sum(subset2) - sum(subset1)= min

                                                                                     arraySubsequenceKaSumEqualsTargetKaPossible(arr,arr.length,sum(arr))                                                                            -- because sum of subset can be from 0 {} to sum(arr) {all elements}
                                                                                     listofpossiblesum           = dp[dp.length-1]                                 = [0,1,5,6,7,11,12,16,17,18,22,23]  --because last line of dp[][] decide wheteher sum0 is possible ; sum1 is possible,.....
                                                                                     listofpossiblesumforsubset1 =listofpossiblesum[0 :listofpossiblesum.length/2] = [0,1,5,6,7,11]                    -- because  subset1 < subset2  the possible values for sub1 are till half of listofpossiblesum
                                                                                     listOfpossibledifference    = sum(arr) - 2*listOfpossibledifference[i]        = [23,21,13,11,9,1]                 -- because  sum(sub2) - sum(sub1) = min  ; sum(arr) - sum(sub1) - sum(sub2) = min; sum(arr) - 2sum(sub1) = min
                                                                                     min  = min(listOfpossibledifference)

      public int     arraySubsequenceKaSumOfPairsDifferenceEqualsMinKaSum(int[] arr , int sizeOfarr ) {
        int sum = sum(arr);
        boolean[][] dp = new boolean[sizeOfarr+1][sum+1];       

        for(int i= 0 ; i <= sizeOfarr; i++){
          for(int j =0 ; j <= sum; j++){
            if(j==0){
              dp[i][j] = true;
            }
            if(j != 0 && i==0){
              dp[i][j] = false;
            }
          
          }
        }

        for(int i= 1 ; i <= sizeOfarr; i++){
          for(int j =1 ; j <= sum; j++){
            if(arr[i-1] <=j)
              dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
            else{
              dp[i][j] = dp[i-1][j];
            }
          }
        }




        List<Integer>  listofpossiblesums = new ArrayList<>();
        for(int i = 0 ; i < dp[dp.length-1].length ; i++){
          if(dp[dp.length-1][i]){
            listofpossiblesums.add(i);
          }
        }

        List<Integer> listofpossiblesumsforsubset1 = new ArrayList<>();
        for(int i = 0 ; i < listofpossiblesums.size()/2 ; i++){
          listofpossiblesumsforsubset1.add(i);
        }

        List<Integer> listOfpossibledifference = new ArrayList<>();
        for(int i = 0 ; i < listofpossiblesumsforsubset1.size() ; i++){
          listOfpossibledifference.add(sum -  2*listofpossiblesumsforsubset1.get(i));
        }

      
        int min = Integer.MAX_VALUE;
        for(var i : listOfpossibledifference){
          if(i <= min){
            min = i;
          }
        }

        System.out.println(listOfpossibledifference);
        return min;
      
      }     
      
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=sizeofarr*sum)
      SPACE:O(n^2)  as we matrix takes extra space n^2(n^2=sizeofarr*sum)
    
    */

      return 0;









  }



    //LCS
    public int     stringSubsequenceKaCommonKaLongestLength(String s1 , String s2 , int s1Length , int s2Length){
      /*
      Question
      s1 = "abcd"   -- find all the subsequence of both strings
      s2 =  "abhd"     and find the longest common subsequence  and return its length
                        Eg:"ab",abd"  -- longest commen subsequence is "abd" whose length 3; so return 3
      */              

     //RECURSION - IP OP TREE (Decision: char1 lu ya na ; char1 lu ya na lu )
      /*

      
                      "s1s2", "S1S2"          **s1Length , s2Length for smallerIp instead of reducing str
                  /                    \
                 /                      \
              s2== S2                    s2 != S2
          s2\/  |                     s2\/  /       \   s2 X   
          S2\/  |                    S2X   /         \  S2 \/     
              "s1",                       "s1"          "s1s2"  
              "S1"                        "S1S2"        "S1"
               /   \                        /    \                        --if s1==S1 return 1 + left  ; else return max(left,right)
              /     \                      /      \
          s1==S1    s1 !=S1              s1=S2    s1 !=S2  
        s1\/  |   s1 \/  /\   s1 x      s1\/ |   s1\/  / \ s1 x
        S1 \/ |   S1 x  /  \  S1 \/     S2\/ |   S2X  /   \ S2 \/           --return 0
              ""      ""     "s1"            ""     ""     "s1"
              ""     "S1"      ""            "S1"   "S2"     "S1"
             
        
  

      //BASE CASE                                                                            --while going top-down
      if(s1Length == 0 || s2Length == 0 ){                                                   if s1 length == 0 || s2 length == 0
          return 0;                                                                          return 0 and start moving up
      }
      
                                                                                                --while going top-own
      if(s1.charAt(s1Length-1) == s2.charAt(s2Length-1)){                                         if (s1.charAt(s1Length-1) == s2.charAt(s2Length-1)) 
          int left =1+ stringSubsequenceKaCommonKaLongestLength(s1,s2,s1Length-1,s2Length-1);          left stores length of subsequence if s1 s2 taken
          return left; }                                                                              return left to next node and start moving up
        else{                                                                                     else 
            int left = stringSubsequenceKaCommonKaLongestLength(s1,s2,s1Length-1,s2Length);            left stores length of subsequence if s1 taken and s2 not taken
            int right = stringSubsequenceKaCommonKaLongestLength(s1,s2,s1Length,s2Length-1);           right stores length of subsequence if s1 not taken and s2  taken
            return Math.max(left,right);                                                             return max(l,r) because because subseq allows discountinuous char
        }                                                                                                             so if a char is mismatched there might be some match before 
                                                                                                                       and we must find the max of the previous lengths
        
      TIME :O(2^n) as each fn calls itself twice and n(size of s1 or s2 ) reduces by 1 
      SPACE:O(n) as we have n(size of s1 or s2 )ps 

    
      */

      //DP TOP-DOWN MEMOIZATION(Overlapping subproblem)
      /*
      public int stringSubsequenceKaCommonKaLongestLength(String s1 , String s2 , int s1Length , int s2Length, int[][] dp){ --  INITIALISE MATRIX dp[s1Length+1][s2Length+1] , FILL MATRIX WITH -1 

        if(s1Length == 0 || s2Length == 0){
        return 0 ;}

        if(dp[s1Length][s2Length] !=-1){                              -- CHECK IN MATRIX
          return dp[s1Length][s2Length]}


        if(s1.charAt(s1Length-1) == s2.charAt(s2Length-1)){        ---STORE RETURN VALUE IN MATRIX  
          int left =  1 + stringSubsequenceKaCommonKaLongestLength(s1,s2,s1Length-1,s2Length-1,dp);
          dp[s1Length][s2Length] =  1 + left 
          return  dp[s1Length][s2Length] ;  
        }
        else{
          int left = stringSubsequenceKaCommonKaLongestLength(s1,s2,s1Length-1,s2Length,dp);
          int right =  stringSubsequenceKaCommonKaLongestLength(s1,s2,s1Length,s2Length-1,dp)
          dp[s1Length][s2Length]  =  Math.max(left, right)); 
          return dp[s1Length][s2Length] ;                                     
        }
      }

      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
    



      */
    


      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /* 
        s1 ="abfce"                                              
        s2 = "abcde"                                            
           j  0  1  2  3  4  5                          
        i     -  a  b  c  d  e     -->(i,j)  s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        common subsequence ke longest length  
        1  a  0  1  1  1  1  1        EG (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                         
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
              
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

        return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
                                                               
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */
    
     return 0;
    
    }
    public String  stringSubsequenceKaCommonKaLongestString(String s1 , String s2 , int s1Length , int s2Length){
        
      /*

      Question
      s1 = "abcd"   -- find the subsequence if string common subsequence
      s2 =  "abhd"     and find the longest common subsequence  and return the subsequence
                        Eg:"abd"  -- longest commen subsequence is "abd"; so return "abd"
      */


      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /*               
                                         
           j  0  1  2  3  4  5                          
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        common subsequence ke longest length    
        1  a  0  1  1  1  1  1       EG (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                        
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      s1 ="abfce"                                              
      s2 = "abcde"     
      
      int[][] dp = new int[s1Length][s2Length];
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

    
      int i = s1Length;                                -- initialise i to s1Length , j to s2length
      int j = s2Length;
      String result = "";
      while(i >=1 && j >= 1){                           --move i till 1 and j till 1
                                                          (i at 0 , cb i till 1 , ca i till 0 ; j at 0 , cb j till 1 , ca j till 0)  
        if(s1.charAt(i-1) == s2.charAt(j-1)){             if characters at i-1  match chracter at j-1
          result = result + s1.charAt(i-1);                   add characters at i-1
          i--;                                                move i behind    
          j--}                                                move j behind 
        else{                                             else if characters dont match 
            if(dp[i-1][j] > dp[i][j-1])                      if move i back and find longest common subs > move j back and find longest common subs
                  i--;                                         move i back                                                
            else                                             else 
                  j--;                                         move j back                                                            
          }  
      }
      if(i >= 1)                                         //null check if (i>=1) for smaller s2 not req
      if(j >=1)                                          //null check if (i>=1) for smaller s2 not req

      resut = reverse(result)                              -- reverse string as we iterate from last character
    

                                                               
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */

      return "";
    

    }
    public int     stringSubsequencekaCharactersIncreasingKaLongestlength(String s1, int s1Length){
      
      /*
      Question
      s = "abbcdb"   -- find all the subsequence of  strings
                        and find the longest  increasing/non decreasing OR longest strictly increasing subsequence  and return its length
                        Eg:"a" , "ab" "abb" "abbc"
                          (non decreasing/increasing subsequence)    
                          "a" , "ab" "abc"           --largest  increasing  subsequence is  "abc" whose length 3; so return 3
                          (strictly increasing  subsequence)  
      */


      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /*
           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j)  for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length
        1  a  0  1  1  1  1  1         EG (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
        s1 ="abbcdb"                                              
        s2 = sort(s1)                        -->"abbcdb"   ----> "abbcd"
                                                "abbbcd"   LCS 
                                                when we sort a string then 
                                                longest common subsequence will be increasing/non decreasing
          =removeDuplicates(s1),sort(s1)      -->"abbcdb"   ----> "abcd"
                                                 "abcd"     LCS
                                                 when we remove duplicate and  sort a string then 
                                                 longest common subsequence will be strictly increasing
      
      int [][] dp = new int[s1Length+1][s2Length+1];  
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

        return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
                                                               
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */
    

      return 0;



    }
    public int     stringSubsequenceKaCharacterIncreasingTripletKaPossibleAndString(String s1, int s1Length){
      /*
      s = "abbcdb"   -- find all the subsequence of  strings
                      and find the  trictly increasing  triplet subsequence 
                      and return if such triplet is possible ; return  the triplet 
                        Eg:'abb" 
                           (non decreasing/increasing subsequence)    
                           "abc"           
                          (strictly increasing  subsequence)  

      */
      //USING MULTIPTR GREEDY
      /*
      Look in array multiptr greedy(udar arr ke liye kiya hai arraySubarrayKaCharacterIncreasingTripletKaPossibleAndArray)
       */

      return 0;
    }
    public int     stringSubsequenceKaCharacterPallindromeKaLongestLength(String s1 ,int s1Length){
      
      /*
      s = "agbcba" -- find all the subsequence of  strings
                      and find the longest  pallindromic subsequence  and return its length
                      Eg:"a" , "bcb" , "abcba" -- longest pallindromic subsequence is "abcbd" whose length is 5 ; so return 5

      */

      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /*


           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
        1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
      s1 ="abbcdb"                                              
      s2 = reverse(s1)                     -->"agbcba"   ----> "abbcd"
                                              "abcbga"   LCS 
                                              when we reverse a string then 
                                              longest common subsequence will be a pallindrome

      
      int [][] dp = new int[s1Length+1][s2Length+1];  
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

      for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
        for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
          if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
              dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
          else {
              dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                    dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
          }                                             find the max of both 
      }

      return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
                                                               
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */
    

      return 0;




    }
    public int     stringSubsequenceKaCharacterRepeatingKaLongestLength(String s1,int s1Length){
      /*
      Question
      s = "aabebcdd" --find all the subsequence of  strings
                      and find the longest  repeating subsequence  and return its length
                      Eg:"abd" "abd" (both use different a , b and c)-- longest repeating subsequence is "abd" whose length is 3 ; so return 3
      */

      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /*

          j  0  1  2  3  4  5                             
      i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
      0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
      1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4 
  
            
      s1 ="aabebcdd"  
      String s2 = s1.substring(0,s1.length());   --> "aabebcdd"   -------> "abd" "abd"           
                                                      "aabebcdd"    LCS 
                                                                    +
                                                                    if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j) added cond i!= j

                                                      when we use same string then 
                                                      longest common subsequence along with condition i!= j will be longest repeating subsequence
                                                      (i!= j beause when character matches at a particular index make sure the indexes are different
                                                      as  same character cannot be included in both subsequence)   

      
      
      int [][] dp = new int[s1Length+1][s2Length+1];  
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

        return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full                                                                                                                             a
                                                                                                                                    i = 0,1  --> a matches at 0,0 so we cant take "a" because same "a" cannot be uses in both subsequence
                                                                                                                                    j = 0,1      but a matches at 0,1 so we can  take a because different "a" can be uses in both subsequence
                                                                                                                                    b
                                                                                                                                    similar to d
                                                                                                                                    d
                                                                                                                                    similar to a
                                                                                                                                    e
        TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
        SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
                                                                                                                            i = 3   --> e matches at 3,3  we cant take "e" because same "e" cannot be uses in both subsequence
                                                                                                                                    j ->5  e matches at 5,5 so dont take c                                                   
                                                                                                                                  
      */   

      return 0;

   

    }
    public boolean stringSubsequenceKaCharacterContainingOtherStringIsPossible(String s1 , String s2 ,String s1Length , String s2Length){
      /*
      Question
      s1 = "abcde" -- find all the subsequence of  s1
      s2 = "abde"     and find if s2 is a subsequence of s1 and return if a subsequence or not 
                      Eg:"abd" "abde" -->"abde" is a subsequence ; so return T
      */

      
      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) -->Time: O(n^2); Space:O(n^2)
      /*
      s1 ="geek"  
       s2 = "eke" 

          j  0  1  2  3  4  5                             
      i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
      0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
      1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4 
  
              
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

      return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
      
      int lcs = dp[s1Length][s2Length]  
      if(lcs == min(s1.length,s2.length) OR s2.length()) -->  length of LCS == length of smaller string if asked if either string is a pattern/length of s2 if asked if s2 is a pattern subsequence of s1
          return true                                         Now considering s2 as smaller string                                                                                                                                                                                                                 
      else                                                    tu bolega ki LCS aur s2 same hone chahiye na ki LCS aur s2 ki lengths   
        return false                                          par sirf length se kaam chalega kyuki agar s2 ko subsequence hona hai to use LCS hi hona padegaa
                                                              s1 ="geek"     --------"gee"
                                                              s2 = "gee"     LCS

      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */
      
      //USING MULTIPOINTERS (ARRAY REQUIRES MULTIPLE PTR)-->Time: O(n); Space:O(1)
      /*
      "abcde"     "abde"  
      |           |
      ptr1         ptr2           --   s1 = larger string ; s2 = smaller string --if asked either string is a pattern  of other
                                      s1 = s2 ; s2 = s2                         --if asked s2 is a pattern  of s1
                                      while(ptr1 <= s1.length()-1 &&  ptr2 <= s2.length()-1){  -->move ptr1 ptr2 till  s1.length , s2.length which is null
                                          if(s1.charAt(ptr1) == s2.charAt(ptr2)){                (ptr1,ptr2 reach at s1.length,equivalent char and exit; code before moving ptr encounter till s1.length-1,equivalent char ; code after moving ptr encounter s1.length,eq char [s1 small; vice versa arr2 is small] )
                                              ptr1++;
                                              ptr2++;}                               
                                          else{
                                          |   ptr1++;}}
                                          |
                                      else if because left,right modifies inside if else
                                      and left,right  used as conditiom

                                      return (ptr2 <= s2.length()-1) ? false:true;      //null check for smaller s2
      
      Time : O(n) as we reduce n(length of str ) by 1
      Space: O(1)
          
      */
      
      /*
      String s1 = "";
      String s2 = "";
      if(str1.length() >= str1.length()){
          s1 = str1;
          s2 = str2;
      }
      else{
          s1 = str2;
          s2 = str1;
      }
      
      
      
      int ptr1 = 0;
      int ptr2 = 0;
      
      
      while(ptr1 <= s1.length()-1 &&  ptr2 <= s2.length()-1){
          
          
          if(s1.charAt(ptr1) == s2.charAt(ptr2)){
              ptr1++;
              ptr2++;
          }
          
          else{
              ptr1++;
          }
      
      }
      
      return (ptr2 < s2.length()) ? false:true;
      */
      
      return false;




  }
    public int     stringSubstringKaCommonKaLongestLength(String s1 , String s2 ,int s1Length , int s2Length){
      /*
      Question
      s1 = "abcde"   -- find all the substrings of both strings
      s2 =  "abfce"     and find the longest common substring  and return its length
                        Eg:"a" , "ab" , "c" ,"e "   -- longest commen substring is "ab" whose length 2; so return 2
      */

      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /*
        s1 ="abcde"                                              
        s2 = "abfce"   
        j  0  1  2  3  4  5                             
      i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters (becuse substring must be continuous so we reset lengths to 0 in between so matrix is not continuous)                       
      0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
      1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
      2  b  0  1  2  2  2  2                                                     
      3  f  0  1  2  2  2  2                                                     
      4  c  0  1  2  3  3  3                                                 
      5  e  0  1  2  3  3  4 
          
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common substring =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common substring + 1                                      
            else {
                dp[i][j] =  0                             if character doesnt match
            }                                             reset length to 0
        }

        int max = Integer.MIN_VALUE;
        for(int i=0 ; i <= dp.length-1;i++){            -->last character in matrix is not the  answer
            for(int j=0 ; j <= dp[i].length-1;j++){        max of all lengths is amswer
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return (max == Integer.MIN_VALUE)?0:max;        //null check if max is never replaced

                                                              
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */
      

      return 0;

                                    
    }
    public String  stringSubstringKaCharacterPallindromeKaLongestLengthAndLongestString(String s1, int s1Length){
      /*
      "cbbd"  -- find all the substrings 
                 find the longest pallindromic substring ka length and string 
                Eg:bb
      */


      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) -->Time: O(n^2); Space:O(n^2)
      /*
                                                                                            
          j  0  1  2  3  4  5                            
        i     a  b  c  c  b  m                            
        0  a  T  F  F  F  F  F         (i,j) string between startIndex i and endIndex j 
        1  b     T  F  F  T  F         stores whether  that string is a pallindrome                                 
        2  c        T  T  F  F         Eg (2,3) means "cc" is a pallindrome                                      
        3  c           T  F  F                                            
        4  b              T  F                                  
        5  m                 F
        

      


      s1 = "abccbm"                                          --XXXXXXX
      s1 = reverse(s1)                                         lcs of s1 and reverse s1 wont work 
                                                              Eg s1 = "abacdfgdcaba" s2 = "abacdgfdcaba"  lcs is "abacd" which is not a pallindrome 



      boolean[][] dp = new boolean[s1Length][s1Length];
      for (int i = 0; i <= s1Length-1; i++) {                 --move startIndex till s1Length-1
        for (int j = 0; j <= s1Length-1; j++) {                   move endIndex till s2Length -1
            if(i == j){                                             if startIndex == endIndex
                dp[i][j] = true;                                      means single character which is a  pallindrome 
            }                                                        
    
          }
        }
        
      String maxString = "" + s1.charAt(s1.length()-1);    --initialise maxLength and maxString to lastIndex of stringmaxString
      int maxLength = Integer.MIN_VALUE;
      for (int i = s1Length - 1; i >= 0; i--) {            --move startIndex from end of string to beinning of string
        for (int j = i+1; j <= s1Length-1; j++) {              move endIndex from startIndex+1 to end of string
          if(s1.charAt(i) == s1.charAt(j) && j-i == 1 ){         if startIndex == endIndex and there are only 2 characters
                dp[i][j] = true;                                    means the string bw i,j is a pallindrome
                if(maxLength <= j-i+1){                            find the maxLength and maxString
                    maxLength = j-i+1;
                    maxString = s1.substring(i,j+1);
                }
            }   
            else if(s1.charAt(i) == s1.charAt(j) && j-i >1){     else if startIndex == endIndex and there are more than 2 characters
                if(dp[i+1][j-1] == true){                           if string bw startIndex+i,endIndex-1 is a pallindrome  
                        dp[i][j] = true;                               means the string bw i,j is a pallindrome 
                        if(maxLength <= j-i+1){                         find the maxLength and maxString
                        maxLength = j-i+1;
                        maxString = s1.substring(i,j+1);
                    }
                    
            }
          }
        }

        return maxLength;
        return maxString;



      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)

      
      
      */

      //USING MULTIPOINTERS     -->Time: O(n^2); Space:O(1)
      /*
      "cbbd"
        |
        centre    --move centre from 0 to s.length-1
                      len1 = initialise ptr1 = centre , ptr2 = centre and find the length of pallindrome around centre    Eg:civic --assume centre at 2 then ptr1 and ptr2 must be at 2 
                      len2 = initialise ptr1 = centre , ptr2 = centre +1 and find the length of pallindrome around centre Eg:cbbd -- assume centre is at 1 then ptr1 must be at 1 ,ptr2 at 2
                      len = max(len1,len2)

                      if(len >= maxLength){
                          maxLength = len;
                          maxStart = centre - (len-1)/2;
                          maxEnd = centre + len/2;
                          
                      }

                  return maxLength;
                  return s1.substring(maxStart,maxEnd+1)
          

      Time:O(n^2)
      Space:o(1)
          

      */

      /*
 
      
      int maxLength = Integer.MIN_VALUE;
      int maxStart = 0;
      int maxEnd = 0;
      
      for(int centre = 0; centre <= s1Length;centre++){
          
        int len1 = stringPallindromeAroundCentreLength(s1,centre,centre);   
        int len2 = stringPallindromeAroundCentreLength(s1,centre,centre+1); 
        int len = Math.max(len1,len2); 
          
          if(len >= maxLength){
              maxLength = len;
              maxStart = centre - (len-1)/2;
              maxEnd = centre + len/2;
              
          }        
      }  
      return maxLength;
      return s1.substring(maxStart,maxEnd+1);
      
      
  
      public int stringPallindromeAroundCentreLength(String s1, int ptr1,int ptr2){
          while(ptr1 >= 0 && ptr2 <= s1.length()-1 && s1.charAt(ptr1) == s1.charAt(ptr2)){
              ptr1--;
              ptr2++;
          }
          return ptr2-ptr1-1;     
      }
    */
    
      return "";
  

        
    }
    public String  stringSubstringKaCharacterAllPallindromeKaCoundAndString(String s1, int s1Length){
      /*
    "cbbd"  -- find all the substrings 
               find the pallindromic substring ka string
              Eg:["c","b","b","d","bb"]
    */


    //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) -->Time: O(n^2); Space:O(n^2)
    /*
                                                                                          
        j  0  1  2  3  4  5                            
      i     a  b  c  c  b  m                            
      0  a  T  F  F  F  F  F         (i,j) string between startIndex i and endIndex j 
      1  b     T  F  F  T  F         stores whether  that string is a pallindrome                                 
      2  c        T  T  F  F         Eg (2,3) means "cc" is a pallindrome                                      
      3  c           T  F  F                                            
      4  b              T  F                                  
      5  m                 F
      


    


    s1 = "abccbm"                                          --XXXXXXX
    s1 = reverse(s1)                                         lcs of s1 and reverse s1 wont work 
                                                            Eg s1 = "abacdfgdcaba" s2 = "abacdgfdcaba"  lcs is "abacd" which is not a pallindrome 



    boolean[][] dp = new boolean[s1Length][s1Length];
    for (int i = 0; i <= s1Length-1; i++) {                 --move startIndex till s1Length-1
      for (int j = 0; j <= s1Length-1; j++) {                   move endIndex till s2Length -1
          if(i == j){                                             if startIndex == endIndex
              dp[i][j] = true;                                      means single character which is a  pallindrome 
              res.add(s1.substring(i,j+1))                          add substring bw i,j inclusive t0 res
              count++                                               increment count
          }                                                        
  
        }
      }  
    List<String> res = new ArrayList<>();
    int count = 0;
    for (int i = s1Length - 1; i >= 0; i--) {            --move startIndex from end of string to beinning of string
      for (int j = i+1; j <= s1Length-1; j++) {              move endIndex from startIndex+1 to end of string
        if(s1.charAt(i) == s1.charAt(j) && j-i == 1 ){         if startIndex == endIndex and there are only 2 characters
              dp[i][j] = true;                                    means the string bw i,j is a pallindrome
              res.add(s1.substring(i,j+1))                        add substring bw i,j inclusive to res
              count++                                             increment count

          }   
          else if(s1.charAt(i) == s1.charAt(j) && j-i >1){     else if startIndex == endIndex and there are more than 2 characters
              if(dp[i+1][j-1] == true){                           if string bw startIndex+i,endIndex-1 is a pallindrome  
                      dp[i][j] = true;                               means the string bw i,j is a pallindrome 
                      res.add(s1.substring(i,j+1))                        add substring bw i,j inclusive to res
                      count++                                             increment count
                  
          }
        }
      }

      return res;
      return count;
  



    TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
    SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)

    
    
    */

    //USING MULTIPOINTERS     -->Time: O(n^2); Space:O(1)
    /*
    "cbbd"
      |
      centre    --move centre from 0 to s.length-1
                    res1/count1 = initialise ptr1 = centre , ptr2 = centre and find all of pallindrome around centre    Eg:civic --assume centre at 2 then ptr1 and ptr2 must be at 2 
                    res2/count2 = initialise ptr1 = centre , ptr2 = centre +1 and find all pallindrome around centre    Eg:cbbd -- assume centre is at 1 then ptr1 must be at 1 ,ptr2 at 2
                   
                    res = iterate through res1 and res2 and add their elements
                    count = count1 + count2;



                return res;
                return count;

    Time:O(n^2)
    Space:o(1)
        

    */

    /*
    public String stringSubstringKaCharacterAllPallindromeKaCoundAndString(String s1){
    
      List<String> res  = new ArrayList<>();
      int count = 0;
      for(int centre = 0; centre <= s1.length()-1;centre++){
        int res1/count1 = stringPallindromeAroundCentre(s1,centre,centre);   
        int res2/count2 = stringPallindromeAroundCentre(s1,centre,centre+1); 

        for(int i=0; i <= res1.size()-1;i++){res.add(res1.get(i));}
        for(int i=0; i <= res2.size()-1;i++){res.add(res2.get(i));}
        count = count1+count2;
        
          
               
      }  
      return res;
      return count;
      
    }

    public List<String> stringPallindromeAroundCentre(String s1, int ptr1,int ptr2){
       List<String> res = new ArrayList<>(); 
       int count =0; 
        while(ptr1 >= 0 && ptr2 <= s1.length()-1 && s1.charAt(ptr1) == s1.charAt(ptr2)){
            res.add(s1.substring(ptr1,ptr2+1));
            count++; 
            ptr1--;
            ptr2++; 

         }
      
        return res; 
        return count;
         
    }
  */
  
    return "";


      
  }
    public int[]   stringSubstringKaCharacterContainingOtherStringKaIndex(String s1 , String s2){
      /*
          Question
          "onionionspl"--> find all substrings of s1
          "onions"        and check of s2 is a substring of s1 and return the index's of where s2 is a substring of s1
                          Eg:"onionionsplonions", "onions"  -- [3,11]

      */

      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) -->Time: O(n^2); Space:O(n^2)
      /*
      No soln for DP
      */

      //USING MULTIPOINTERS (ARRAY REQUIRES MULTIPLE PTR)  --Time:O(n1*n2) , Space:O(1)
      /*
      "onionionsplonions" "onions" 
      |                   |
      ptr1               ptr1
                      -- initialise ptr1 , ptr2 to 0
                          while(ptr1 <= s1.length()-1){             --move ptr1 till s1.length(ptr1 at s1.length , cb ptr1 till s1.length-1; ca ptr1 till s1.length)
                              
                              if(s1.charAt(ptr1) == s2.charAt(ptr2)){ --If there is a match 
                                  ptr1++;                               "onionionsplonions" "onions"                     
                                  ptr2++;}                               |                   | 
                                                                      ptr1                ptr2        --inc ptr1 
                                                                                                          inc ptr2
                              else{                                  --If there is a mismatch
                                  ptr1 = ptr1-ptr2+1;                  "onionionsplonions" "onions"        
                                  ptr2=0;                                    |                    |
                              }                                              ptr1                 ptr2    --reassign ptr1= ptr1-ptr2,
                                                                                                          reassign ptr2=0     
                              


                              if(ptr2 == s2.length()){                --If ptr2 has reached end of s2
                                  occurenceList[index++] = p1-p2          "onionionsplonions" "onions"     
                                  ptr1 = ptr1-ptr2+1 ;                            |                 |
                                  ptr2 =0;                                        ptr1              ptr2   --add ptr1 - ptr2 in list
                              }                                                                              reassign ptr1 = ptr1-ptr2+1 for next index
                                                                                                          reassign ptr2 =0  for next index
                              
                              
                          }
                          
                          return Arrays.copyOfRange(occurenceList, 0, index);
                          // return occurenceList.size() == 0 ? -1: occurenceList[[0];  if 1st index is asked   if 1st index is asked  
      Time:O(n1*n2) where n n2 are lengths of s1,s2
      Space:O(1)
      */
      /*
      int[] occurenceList = new int[s1.length() + s2.length()];int index = 0;

      int ptr1 = 0;
      int ptr2 = 0;        
      while(ptr1 <= s1.length()-1){
          
          if(s1.charAt(ptr1) == s2.charAt(ptr2)){
              ptr1++;
              ptr2++;
          }
          else{
              if(ptr2 == 0){
                  ptr1++;
              }
              else{
                  ptr1 = ptr1-ptr2+1;
                  ptr2 = 0;  
                  
              }
              
          }
          if(ptr2 == s2.length()){
              occurenceList[index++] = ptr1-ptr2;
              ptr1 = ptr1-ptr2+1 ;
              ptr2 =0;
          }
          
          
      }
      
      return Arrays.copyOfRange(occurenceList, 0, index);
      // return occurenceList.size() == 0 ? -1: occurenceList[[0];  if 1st index is asked  
      
      */
      

      //USING MULTIPOINTERS KMP (ARRAY REQUIRES MULTIPLE PTR + OPTIMIZATION)  --Time:O(n1*n2) , Space:O(1)
      /*
      https://www.youtube.com/watch?v=4jY57Ehc14Y
      "onionionsplonions" "onions" 
        |                   |
        ptr1               ptr1
                        -- initialise ptr1 , ptr2 to 0
                          while(ptr1 <= s1.length()-1){             --move ptr1 till s1.length(ptr1 at s1.length , cb ptr1 till s1.length-1; ca ptr1 till s1.length)
                              
                              if(s1.charAt(ptr1) == s2.charAt(ptr2)){ --If there is a match 
                                  ptr1++;                               "onionionsplonions" "onions"                     
                                  ptr2++;}                               |                   | 
                                                                          ptr1                ptr2        --inc ptr1 
                                                                                                            inc ptr2 
                              else{                                  --If there is a mismatch
                                  if(ptr2 ==0 ){                       "onionionsplonions" "pnions"
                                      ptr1++                            |                   |
                                  }                                    ptr1                 ptr2   -- increment ptr1
                                  else{
                                      ptr1 = ptr1;                    "onionionsplonions" "onions"        
                                      ptr2=lps[ptr2-1];                     |                  |
                                  }                                         ptr1              ptr2    --reassign ptr1= ptr1           ie instead of moving ptr1 back keep it there
                              }                                                                         reassign ptr2= lps[ptr2-1] = 2 ie instead of moving ptr2 to 0 move it acc to lps(longest prefix which is also a suffix)     
                                                                                                          


                              if(ptr2 == s2.length()){                --If ptr2 has reached end of s2
                                  occurenceList[index++]=ptr1-ptr2;      "onionionsplonions" "onions"     
                                  ptr1 = ptr1 ;                                   |                |
                                  ptr2 =lps[ptr2-1];                             ptr1              ptr2   --add ptr1 - ptr2 in list
                              }                                                                             reassign ptr1= ptr1           ie instead of moving ptr1 back keep it there
                                                                                                            reassign ptr2= lps[ptr2-1] = 2 ie instead of moving ptr2 to 0 move it acc to lps(longest prefix which is also a suffix)     
                              
                          }
                          
                          return Arrays.copyOfRange(occurenceList,0,index+1);
                          
      //CALCULATE LPS(Longest proper prefix which is also a  suffix ka length)
      "o n i o n s"
        0 0 0 1 2 0  -->o    :prefix = "" , suffix = ""                                  common = nothing
                        on   :prefix = "o" ; suffix = "n"                                common = nothing
                        oni  :prefix = "o","on" ; suffix = "i" "ni"                      common = nothing
                        onio :prefix = "o","on","oni" ; suffix = "o" "io" "nio"          common = "o" = 1
                        onion :prefix = "o","on","oni" ,"onio" ; suffix = "n" "on" "ion" common = "on" = 2
                      
      "o n i o n s" [0 0 0 1 2 0] 
        | |
    ptr1 ptr2 --initialise ptr1 to 0 ptr2 to 0 ; lps[0] to 0
              while(ptr2 <= s.length()-1){                       -- move ptr2 till s.length(ptr2 at s.length, cb till s.length-1 , ca till s.lentgth)

                  if(s.charAt(ptr1) == s.charAt(ptr2)){          -- if match
                      lps[ptr2] = ptr1+ 1;                          o n i o n s
                      ptr1++;                                       |     |
                      ptr2++;                                      ptr1   ptr2    --lps[ptr2] =  ptr1 + 1  because ptr1 + 1 characters have matched from front and back
                                                                                    increment ptr1
                                                                                    increment ptr2
                  }
                  else{                                        -- if mismatch
                      if(ptr1 == 0){                              o  n  i  o  n  s
                          lps[ptr2] = 0;                          |   |
                          ptr2++;                               ptr1  ptr2        --lps[ptr2] = 0 because no characters match from front back
                      }                                                             increment ptr2

                      else{                                      o  n  i  o  n  s 
                          ptr1 = lps[ptr1-1];                           |       |
                                                                        ptr1     ptr2  --ressing ptr1 to lps[ptr1-1] because instead of reassigning ptr1 to 0 reassign it to lps[ptr1-1] because we have already compared the characters till lps[ptr1-1] 
                                                  
                      }
                  }
                  
                  
                  
                  
              }
              
              return lps;
          
              return lps[lps.length-1] --  if question is to find  length of longest prefix which is also a suffix
      



      Time:O(n1 + n2) where n n2 are lengths of s1,s2
      Space:O(1)
      */
      /*
      public int[]    stringSubstringKaCharacterContainingOtherStringKaIndex(String s1 , String s2)
          int[] occurenceList = new int[500];int index =0;

          int ptr1 = 0;
          int ptr2 = 0;        
          while(ptr1 <= s1.length()-1){
              
              if(s1.charAt(ptr1) == s2.charAt(ptr2)){
                  ptr1++;
                  ptr2++;
              }
              else{
                  if(ptr2 == 0){
                      ptr1++;
                  }
                  else{
                      if(ptr2 == 0){
                          ptr1++;
                      }
                      else{
                      ptr1 = ptr1-ptr2+1;
                      ptr2 = 0; 
                      } 
                      
                  }
                  
              }
              if(ptr2 == s2.length()){
                  occurenceList[index++] = ptr1-ptr2;
                  ptr1 = ptr1-ptr2+1 ;
                  ptr2 =0;
              }
              
              
          }
          
          return Arrays.copyOfRange(occurenceList, 0, index);
          //return occurenceList.size() == 0 ? -1: occurenceList.get(0);  if 1st index is asked  
      }

      public int[] calculateLPS(String s){
      
          int[] lps = new int[s.length()];
          
          int ptr1 = 0;
          int ptr2 = 1;
          lps[0] = 0;
          while(ptr2 <= s.length()-1){
              if(s.charAt(ptr1) == s.charAt(ptr2)){
                  lps[ptr2] = ptr1+ 1; 
                  ptr1++; 
                  ptr2++;
              }
              else{
                  if(ptr1 == 0){
                      lps[ptr2] = 0;
                      ptr2++;
                  }
                  else{
                      ptr1 = lps[ptr1-1];                                  
                  }
              }
          }
          
          return lps;
      }
          
          
      
      
      
      */

      return null;
  }
    public int     stringSupersequenceKaCommonKaShortestLength(String s1 , String s2 ,int s1Length , int s2Length){
      /*
      Question
      s1 = "geek"   -- find all the supersequence of both strings
      s2 = "eke"       and find the shortest common supersequence  and return its length
                        Eg:"geekeke","geeke"  -- shortest common supersequence is "geeke" whose length 5; so return 5
      */

      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /* 
           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
        1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
      
      s1 ="geek"                                              
      s2 ="eke"                          -->"geek"  +  "eke" -------> "geekeke" ---------->"geeke" 
                                                               s1 + s2             -lcs
      int[][] dp = new int[s1Length][s2Length];
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

    
      int lcs = dp[s1Length][s2Length]        
      int scs = s1Length + s2Length - lcs            
                                                                

      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */
    
      return 0;
    }
    public String  stringSupersequenceKaCommonKaShortestString(String s1 , String s2 ,int s1Length , int s2Length){
      /*
      Question
      s1 = "geek"   -- find all the supersequence of both strings
      s2 = "eke"       and find the shortest common supersequence  and return the supersequence
                      Eg:"geekeke","geeke"  -- shortest common supersequence is "geeke"; so return "geeke"

      */
      
      //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem)
      /* 
        s1 ="abfce"                                              
        s2 = "abcde"                                            
           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
        1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
         
      int[][] dp = new int[s1Length][s2Length];
      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

    
      int i = s1Length;                                -- initialise i to s1Length , j to s2length
      int j = s2Length;
      String result = "";
      while(i >=1 && j >= 1){                           --move i till 1 and j till 1
                                                          (i at 0 , cb i till 1 , ca i till 0 ; j at 0 , cb j till 1 , ca j till 0)  
        if(s1.charAt(i-1) == s2.charAt(j-1)){             if characters at i-1  match chracter at j-1
          result = result + s1.charAt(i-1);                   add characters at i-1
          i--;                                                move i behind    
          j--}                                                move j behind 
        else{                                             else if characters dont match 
            if(dp[i-1][j] > dp[i][j-1])                      if move i back and find longest common subs > move j back and find longest common subs
                result = result + s1.charAt(i-1);              add char at i-1to result because we also want non common characters 
                i--;                                           move i back                                                
            else                                             else 
                result = result + s2.charAt(j-1);              add char at j-1 to result because we also want non common characters 
                j--;                                           move j back                                                            
          }  
      }

      if(i>=1 ){                                           //null check if (i>=1) for smaller s2
        while(i >=1){                                       move i till 1
                                                            (i at 0 , cb i till 1 , ca i till 0)
            result = result + s1.charAt(i-1);                   add char at i-1 to result because we want remaining characters
            i--;                                                move i bbehind
        }
      }
      if(j>=1 ){                                           //null check if (j>=1) for smaller s1
        while(j >=1){                                       move i till 1
                                                            (j at 0 , cb j till 1 , ca j till 0)
            result = result + s2.charAt(j-1);                   add char at j-1 to result because we want remaining characters
            j--;                                                move j behind
        }
      }


      resut = reverse(result)                              -- reverse string as we iterate from last character
    

                                                               
      TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
      SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
      */

      return "";



  
    

  }
    public int     stringConvertToPallindromeWIthMinInsertionDeletion(String s1 , int s1Lenght){
        /*
        Question
        s1 = "agbcba"   -- convert string  to pallindrome using minimum insertion OR deletions 
                          and return no of insertion OR deletions
                          EG:delete  a  delege g delete a "bcb"  ; delete a delete g delete b delete b delete a "c" ; delete g "abcba"
                            so return minimum deletion = 1 
        */
        
        //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) 
      
        /*

           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
        1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
        s1 ="abbcdb"                                              
        s2 = reverse(s1)                     -->"agbcba"   ----> "abcbga"   ------------->"g"  so remove "g" to convert to pallindrome
                                                "abcbga"   LPS               s1.length-lps     so add "g" to convert to pallindrome
                                                when we reverse a string then 
                                                longest common subsequence will be a pallindrome
        int[][] dp = new int[s1Length][s2Length];
        for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
          for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
            if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
                dp[i][j] = 0;                                longest common subsequence =  0  
          }
        }

          for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
            for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
              if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                  dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
              else {
                  dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                        dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
              }                                             find the max of both 
          }

          return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
                                                                
          lps = dp[s1Length][s2Length]
          deletion  =s1Length -lps  
          insertion = deletion                    
                                          
                                                                                                                              
          TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
          SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)
                                                                                                                                      
      
      */   
      return 0;



  }
    public int     stringConvertToAnotherStringWithMinimumInsertionDeletion(String s1 , String s2 ,int s1Length , int s2Length){
        /*
        Question
        s1 = "heap"   -- convert string1 to string2 using minimum insertion and deletion in s1
        s2 =  "pea"      and return the no of oprations = insertion + deletion
                         In s1 delete h , In s1 delete p , In s1 insert p at beginning


                          
        */

        
        //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) 
        /*                                           
           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
        1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
      
      s1 ="heap"                                    "heap"   ----> "ea"   --------------> "hp" so delete h and p from s1 to make s1 = "ea"                                  
      s2 = "pea"                                    "pea"    LCS         s1.length- LCS   
                                                                         ---------------> "p" so insert p in s1 to make s1 = "pea"        
                                                                         s2.length - LCS 

      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

        return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
                                                      

        int lcs = dp[s1Length][s2Length] ;      
        int deletion = s1.length() - lcs;                
        int insertion = s2.length - lsc;                             
        int noOfOperation = deletion + insertion                                           
        TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
        SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)                        

      
        */   

        return 0;



      }
    public int     stringConvertToEqualStringsWithMinimumDeletion(String s1 , String s2 ,int s1Length , int s2Length){
        /*
        Question
        s1 = "sea"   -- convert string1 and string2 to  equal string using minimum deletions in s1 and deletion in s2
        s2 =  "eat"      and return the no of  operation = deletions in s1 + deletion in s2
                         In s1 delete s, In s2  delete t


                          
        */

        
        //DP BOTTOM-UP TABULATION DIRECTLY(Overlapping subproblem) 
        /*                                            
           j  0  1  2  3  4  5                             
        i     -  a  b  c  d  e     -->(i,j) for s1 ke i characters ; s2 ke j characters                        
        0  -  0  0  0  0  0  0        stores common subsequence ka longest length 
        1  a  0  1  1  1  1  1        Eg  (3,4) stores longest common subsequence for "abf" ;  "abcd"                                                       
        2  b  0  1  2  2  2  2                                                     
        3  f  0  1  2  2  2  2                                                     
        4  c  0  1  2  3  3  3                                                 
        5  e  0  1  2  3  3  4 
      
      
      s1 ="sea"                                      -->"sea"   ----> "ea"   --------------> "s"  so delete s in s1 to make s1 = "ea"                                     
      s2 = "eat"                                        "eat"    LCS         s1.length- LCS
                                                                              ---------------> "t" so delete "t" in s2 to make s2 = "ea"
                                                                             s2.length-LCS 

      for(int i=0 ; i <=s1Length ; i++){                -->move i 0 to s1 length                             
        for(int j=0 ; j<=s2Length ; j++){                  move j 0 to s2 length  
          if(i == 0 ||j == 0 )                             if i == 0 (s1 = "" s2 = anything) || j = 0(s1 = "anything" s2 = "")
              dp[i][j] = 0;                                longest common subsequence =  0  
        }
      }

        for(int i=1 ; i <= s1Length ; i++){             -->move i 1 to s1 length          
          for(int j=1 ; j<= s2Length ; j++){               move j 1 to s2 length  
            if(s1.charAt(i-1) == s2.charAt(j-1)){          if character matches              
                dp[i][j] =   1 + dp[i-1][j-1]; }           move i behind, move j behind and find the longest common subs + 1                                      
            else {
                dp[i][j] =  Math.max( dp[i-1][j],         if character doesnt match
                                      dp[i][j-1] );       move i behind find longest common subs , move j behind find longest common subs
            }                                             find the max of both 
        }

        return dp[s1Length][s2Length]                  -->last character in matrix stores longest common subsequence for s1 full and s2 full 
                                                      

        int lcs = dp[s1Length][s2Length] ;     
        int deletion1 = s1.length() - lcs;       
        int deletion2 = s2.length - lsc;                            
        int noOfOperation = deletion1 + deletion2                                           
        
        
        TIME :O(n^2)  as we elminiate recursion and use matrix of size n^2(n^2=ssizeOfS1*sizeOfS2)
        SPACE:O(n^2)  as we matrix takes extra space n^2(ssizeOfS1*sizeOfS2)                        

      
        */   

        return 0;


      }
    

    //FIBONACCI
    public int     numberFibbonaci(int n){
  
      //RECURSION IP-OP TREE
      /*
               3
         -1  /  \ -2
            /    \              --  return left + right;
            2      1
        -1  / \ -2             
           /   \ 
          1    0                -- if(n == 0){return 0;} 
                                    if(n == 1){return 1;}
    
      public int  numberFibbonaci(int n){
                                                        --while going top-down
        if(n == 0){return 0;}                             if n== 0 return 0 and start moving up
        if(n == 1){return 1;}                             if n==1 retu1n 1 and start moving up
                                                         
                                                          
                                                        --while going top-down
        int left = numberfibonacci(n-1);                  left hilds fibonacci sum for n-1 
        int right = numberfibonacci(n-2);                 right hilds fibonacci sum for n-2
        
                                                        --while going bottom up
        return left + right;                               return left + right to node above
      }



      Time:O(2^n)
      Space:O(n)
      */
        
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public int     numberFibbonaci(int n , int[]  dp)         --INITIALISE MATRIX IN MAIN FN(int[] dp = new int[n+1];for(int i=0 ; i <= dp.length-1;i++){dp[i] = -1;})
        if(n == 0){return 0;}  
        if(n == 1){return 1;}
        

        if(dp[n] != -1){                                        --CHECK MATRIX
            return dp[n];   
        }
        int left = numberfibonacci(n-1);                       --STORE RET VALUE IN MATRIX
        int right = numberfibonacci(n-2);
        dp[n] =  left + right;
        
        return dp[n];
        }

      Time:O(n^2)
      Space:O(n)
      
      */

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      [0,1,1,2,3,4,5]      --i is the ith fibonacci number

      public int     numberFibbonaci(int n)
        int[] dp = new int[n+1];          --initialise dp of n+1
        
        if(n==0){return 0;}               -- 0th fibonacci = 0   // Edge case: check for n=0, n=1, n= 2
        if(n==1){return 1;}                  1st fibonacci = 1
        if(n==2){return 1;}                  2nd fibonacci = 1 
        dp[0] = 0;                           
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3 ; i <= n;i++){        --3rd fibonacci = 1st fibonaci + 2nd fibonacci
            dp[i] = dp[i-2] + dp[i-1];       
        }
        
        return dp[n];                      ----return  nth fibonaccu
      
      Time:O(n)
      Space:O(n)
      
      */
     
      //DP BOTTOM-UP TABULATION IN VARIABLE(Overlapping subproblem )
      /*
      [0,1,1,2,3,4,5] 
       | |
      prev1 prev2     ----insetead of dp use prev1 for dp[i-2] and prev2 for dp[i-1] and curr for dp[i]

      public int     numberFibbonaci(int n)
          if(n==0){return 0;}             
          if(n==1){return 1;}             
          if(n==2){return 1;}                                         
          int prev1 = 1;                  
          int prev2 = 1;
          int current = 0;
          for(int i=3 ; i <= n;i++){      
              current = prev1 + prev2; 
              prev1 = prev2;
              prev2 = current;      
          }
          
          return current;                     
        }
      Time:O(n)
      Space:O(1)
      
      */

    

      return 0;


  }
    public int     numberPermutationKaStepsKaCount(int n){
      /*
      n = 5 -- given n stairs where you can take 1 step or 2 steps
                return no of ways to reach n steps
                Eg: n = 3
                1 step + 1 step + 1 step
                1 step + 2 steps
                2 steps + 1 step
      
      */
      //RECURSION IP-OP TREE
      /*
              n=3
          1   /  \  2
             /    \              --  return left + right;
            2      1
        1  / \ 2             
          /   \ 
          1     0                -- if(n == 0){return 1;} 
                                    if(n == 1){return 1;}

      public int  numberPermutationKaStepsKaCount(int n){}
                                                        --while going top-down
        if(n == 0){return 0;}                             if n== 0 return 0 and start moving up
        if(n == 1){return 1;}                             if n==1 retu1n 1 and start moving up
      
                                                        --while going top-down
        int left = numberPermutationKaStepsKaCount(n-1);    left holds no of combination  for n-1 
        int right = numberPermutationKaStepsKaCount(n-2);   right holds no of combination  for n-2
        
                                                        --while going bottom up
        return left + right;                               return left + right to node above
      }



      Time:O(2^n)
      Space:O(n)
      */
        
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public int  numberPermutationKaStepsKaCount(int n , int[]  dp)         --INITIALISE MATRIX IN MAIN FN(int[] dp = new int[n+1];for(int i=0 ; i <= dp.length-1;i++){dp[i] = -1;})
        if(n == 0){return 1;}  
        if(n == 1){return 1;}
        

        if(dp[n] != -1){                                            --CHECK MATRIX
            return dp[n];   
        }
        int left = numberPermutationKaStepsKaCount(n-1);            --STORE RET VALUE IN MATRIX
        int right = numberPermutationKaStepsKaCount(n-2);
        dp[n] =  left + right;
        
        return dp[n];                                              --RETURN LAST VALUE OF MATRIX
        }

      Time:O(n)
      Space:O(n)
      
      */

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      [0,1,2,3,5,8,14]    -i is the number of ways of climbing i stairs

      public int  numberPermutationKaStepsKaCount(int n)  
        int[] dp = new int[n+1];          --initialise dp of n+1
        
        if(n==0){return 0;}               -- number of ways of climbing 0 stairs =0  // Edge case: check for n=0, n=1, n= 2
        if(n==1){return 1;}                  number of ways of climbing 1 stairs = 1
        if(n==2){return 2;}                  number of ways of climbing 2 stairs = 2
        dp[0] = 0;                           
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3 ; i <= n;i++){        -- number of ways of climbing 3 stairs=  number of ways of climbing 1 stairs +  number of ways of climbing 2 stairs
            dp[i] = dp[i-2] + dp[i-1];       
        }
        
        return dp[n];                      --return  number of ways of climbing n stairs
      }
      Time:O(n)
      Space:O(1)

      
      */

      //DP BOTTOM-UP TABULATION + VARIABLE(Overlapping subproblem )
      /*
        [0,1,2,3,5,8,14]     
        | |
      prev1 prev2  -- insetead of dp use prev1 for dp[i-2] and prev2 for dp[i-1] and curr for dp[i]

      public int  numberPermutationKaStepsKaCount(int n)   
        if(n == 0){return 0;}
        if(n == 1){return 1;}
        if(n == 2){return 2;}
        int prev1 = 1;
        int prev2  = 2;
        int current =0;
        for(int i=3 ; i <= n; i++){
            current = prev1+prev2;
            prev1 = prev2;
            prev2 = current;
        }
        
        return current;
      }                     
      
      Time:O(n)
      Space:O(1)

      
      */




      return 0;
    }
    public int     numberPermutationKaIntegerToEnglishStringKaCount(String s){
      /*
      "226" -->given a string number it can be decoded into alphabets 
               return the number of ways we can decode number
              Eg: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
              Eg: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
               
      */


      //RECURSION IP-OP TREE
      /*
         "226"
     "2" /      \ "22" --if condition of taking 2 or 22 satisfies
        /        \
       "26"       "6"
    "2"/\"26"   "6" /
      /  \         /
    "6"    ""     ""        --if ptr == s.length return 1
  "6"/
    /
   ""
       
      public int numberPermutationKaIntegerToEnglishStringKaCount(String s,int ptr ){
                                                                         --while going top-down
        if(ptr == s.length()){                                             if ptr reaches s.length
            return 1; }                                                    return 1 as that is 1 way to decode 
  
        int left = 0;                                                      
        int right = 0;                                                  --while going top-down
        if(s.charAt(ptr) != '0'){                                        --if condition for taking 1 character satsfies
            left = numberPermutationKaIntegerToEnglishStringKaCount(s,ptr+1);             left holds number of permutation of taking 1 character
        }                                                                 if condition for taking 2 characters satisfy
        if(ptr+1 <=s.length()-1 && (s.charAt(ptr) == '1'|| s.charAt(ptr) == '2'  && s.charAt(ptr+1) <='6')){
              right = numberPermutationKaIntegerToEnglishStringKaCount(s,ptr+2);           right  holds number of permutation of taking 1 character
        }
                                                                           --while going bottom-top
        return left + right;                                                 return left + right to node above
      } 

      //OVERRIDE
      public int numberPermutationKaIntegerToEnglishStringKaCount(String s,int ptr ){
        return numberPermutationKaIntegerToEnglishStringKaCount(s,0);
      }

      Time:O(2^n)
      Space:O(n)
    }
      
      */

      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*
      public int numberPermutationToDecode(String s,int ptr, int[] dp ){  --INITIALISE MATRIX IN MAIN FN(int[] dp = new int[n+1];for(int i=0 ; i <= dp.length-1;i++){dp[i] = -1;})
        if(ptr == s.length()){
            return 1;
        }
  
        
        if(dp[ptr] !=-1){                                      --CHECK MATRIX
            return dp[ptr];
        }
        int left = 0;
        int right = 0;

        if(s.charAt(ptr) != '0'){
            left = numberPermutationToDecode(s,ptr+1,dp);    
        }
        if(ptr+1 <=s.length()-1 && (s.charAt(ptr) == '1'|| s.charAt(ptr) == '2'  && s.charAt(ptr+1) <='6')){
              right = numberPermutationToDecode(s,ptr+2,dp);     
        }
        
        dp[ptr]= left + right;                                --STORE RET VALUE IN MATRIX

        return dp[ptr];                                      --RETURN LAST VALUE OF MATRIX
      }
    
      Time:O(2^n)
      Space:O(n)

      //OVERRIDE
      public int numberPermutationKaIntegerToEnglishStringKaCount(String s){
        return numberPermutationKaIntegerToEnglishStringKaCount(s,0);
      }
      
      */

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      public int numberPermutationKaDecodeWaysKaCounttt(String s , int ptr ){
          int[] dp  = new int[s.length()+1];                              --initialise dp of sizeOfArr+1
                                                                            dp stores no of permutation of decoding string of size i
          
          if(s.length() == 0){return 1;}                                  --no of ways of decodingfor string size 0  = 1
          if(s.length() == 1){return s.charAt(0) !='0' ?1:0;}               no of ways of decodingfor string size 0  = 1 or 0 based on character
          dp[0] = 1;
          dp[1] = s.charAt(0) != '0' ?1:0;

          for(int i=2 ;i <= s.length();i++){                              -- if single digit is valid carry forward no of ways of decoding 1 character less   
              int singleDigit = s.charAt(i-1);                               if two digits are valid add carried forward value(dp[i]) annd no of ways of decofing 2 characters less
              if(s.charAt(i-1) != '0')                                       Consider "216"
                  dp[i] = dp[i-1];                                                             
              else                                                           Initially(No of ways of decoding "2") 
                dp[i] = 0;                                                   dp = [1,1,0,0] 
                                                                 
              int twoDigit = Integer.valueOf(s.substring(i - 2, i));                          
              if (twoDigit >= 10 && twoDigit <= 26) {                        i = 2(No of ways of decoding "21")    
                  dp[i] =dp[i] +  dp[i - 2];                                 "1" is valid carry forward no of ways of decoding "2" dp[1,1,1,0]   
                }                                                            "21" is valid so add carried forward value(dp[i]) and no of ways of decoding "" dp [1,1,2,0] 
          }                                                                     
          return dp[s.length()]; --return last element in dp which is answer                                                                    i = 3(Considering "216")
        }                                                                     "1" is valid carry forward no of ways of decoding "21" dp[1,1,2,2,0]   
                                                                              "16" is valid so add carried forward value(dp[i]) and no of ways of decoding "2" dp [1,1,2,3]
                                                                              
                                                                              Consider "206"
                                                                              Initially(No of ways of decoding "2") 
                                                                              dp = [1,1,0,0]
                                                                              
                                                                              i = 2(No of ways of decoding "20")
                                                                              "0" is not valid dont carry forward no of ways of decoding "3" dp[1,1,0,0]   
                                                                              "20" is valid so add carried forward value(dp[i]) and no of ways of decoding "" dp [1,1,1,0]
                                                                              
                                                                               so on
      //OVERRIDE
      public int numberPermutationKaIntegerToEnglishStringKaCount(String s){
        return numberPermutationKaIntegerToEnglishStringKaCount(s,0);
      }                                                                  
          
        
      
      Time:O(n)
      Space:O(n)
      */

      //DP BOTTOM-UP TABULATION + VARIABLE(Overlapping subproblem )
      /* 
        [0,1,2,3,5,8,14]     
        | |
      prev1 prev2  -- insetead of dp use prev1 for dp[i-2] and prev2 for dp[i-1] and curr for dp[i]

      public int numberPermutationKaIntegerToEnglishStringKaCount(String s , int ptr ){        
        if(s.length() == 0){return 0;}
        if(s.length() == 1){return s.charAt(0) != '0' ?1:0;}
        int prev1 = 1;
        int prev2 = s.charAt(0) != '0' ?1:0;
        int current = 0;
        
        for(int i=2 ;i <= s.length();i++){
            int singleDigit = s.charAt(i-1);
            if(singleDigit != '0'){
                current = prev2;
            }
            else{
                current =0;
            }
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current = current +  prev1;
            }
         
            prev1 = prev2;
            prev2 = current;
            
        }
        return current;
      }

      //OVERRIDE
      public int numberPermutationKaIntegerToEnglishStringKaCount(String s){
        return numberPermutationKaIntegerToEnglishStringKaCount(s,0);
      }

      Time:O(n)
      Space:O(1)

      */    
      return 0;
    }
    public int     arrayPermutationMaxRobberSumKaSumI(int[] arr, int sizeOfArr){
      /*
      [1,2,3,1]- given amount of money in each house a robber cannot steal from adjacent house
                give max amount robber can steal
                Eg: [1,2,3,1]
                1 + 3   = 4 -- max he can steal is 4 
                2  + 1 = 3
                2 steps + 1 step
      
      */


      //RECURSION IP-OP TREE
      /*
            [1,2,3]
        3 X  /    \  3 \/
            /      \              --  return (left, right + arr[i-1]);;
        [1,2]      [1](3 ko steal kiya to 2 bhi ip se hatega)
        2x  / \ 2\/             
          /   \ 
          [1]  []               -- if(sizeOfArr == 0){return 0} 
                                  if(sizeOfArr == 1){return arr[sizeOfArr-1];}
  
    
      public int  arrayPermutationMaxRobberSumKaSumI(int n, int sizeOfArr)
                                                        --while going top-down
        if(sizeOfArr == 0){return 0;}                     if sizeOfArr== 0 return 0 and start moving up
        if(sizeOfArr == 1){return 1;}                     if sizeOfArr==1 return 1 and start moving up
     
                                                                       --while going top-down
        int left = arrayPermutationMaxRobberSumKaSumI(sizeOfArr,-1);        left holds amount of money if we steal house
        int right = arrayPermutationMaxRobberSumKaSumI(arr,sizeOfArr-2);    right holds amount of money if we dont steal house
        
                                                        --while going bottom up
        return Math.max(left, right + arr[i-1]);         return left + right to node above
      }


      Time:O(2^n)
      Space:O(n)
      */
        
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      public int arrayPermutationMaxRobberSumKaSumI(int[] arr , int sizeOfArr, int[] dp){    --INITIALISE MATRIX IN MAIN FN(int[] dp = new int[n+1];for(int i=0 ; i <= dp.length-1;i++){dp[i] = -1;})
        if(sizeOfArr == 0 ){
            return 0;}
        if(sizeOfArr == 1){
            return arr[sizeOfArr-1];}
        
        if(dp[sizeOfArr] !=-1){                                                  --CHECK MATRIX
            return dp[sizeOfArr];
        }
        
        
        int left = arrayHouseRobCombb(arr,sizeOfArr-1, dp); 
        int right =arrayHouseRobCombb(arr,sizeOfArr-2, dp);
        dp[sizeOfArr] =  Math.max(left , right +  arr[sizeOfArr-1]);           --STORE RET VALUE IN MATRIX
          
        return dp[sizeOfArr];                                                  --RETURN LAST VALUE OF MATRIX
        
        
    }
    
    

      
      Time:O(n^2)
      Space:O(n)
      
      */

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      [0,1,2,3] -- i stores the cost of robbing the house of sizeOfArr = i

      public int arrayPermutationMaxRobberSumKaSumI(int[] arr , int sizeOfArr){
        int[] dp = new int[sizeOfArr+1];      --initialise dp of sizeOfArr+1
          
        if(sizeOfArr == 0){return 0;}            --cost of robbing house for sizeOfArr 0 = 0                  // Edge case: check for n=0, n=1, n = 2
        if(sizeOfArr == 1){return arr[0];}         cost of robbing house for sizeOfArr 1 = 0th element of arr
        if(sizeOfArr == 1){return max(a[0],a[1])}   cost of robbing house for sizeOfArr 2 = max(arr[0],arr[1])
        dp[0] = 0;                                
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0],arr[1])
        for(int i = 3 ; i <= sizeOfArr;i++){             --cost of robbing house for sizeOfArr 3 =  cost of robbing house for sizeOfArr 1 + arr[2], cost of robbing house for sizeOfArr 2
            dp[i] = Math.max(dp[i-2] + arr[i-1],dp[i-1] );                                         
        }
          
    
        return dp[sizeOfArr];                      --return cost of robbing sizeOfArr = sizeOfArr
  
        }


      Time:O(n)
      Space:O(n)
      
      */

      //DP BOTTOM-UP TABULATION IN VARIABLE(Overlapping subproblem )
      /*
        [0,1,2,3] 
        | |
        prev1 prev2  -- insetead of dp use prev1 for dp[i-2] and prev2 for dp[i-1] and curr for dp[i]
        
      public int arrayPermutationMaxRobberSumKaSumI(int[] arr , int sizeOfArr){
        if(sizeOfArr == 0){return 0;}
        if(sizeOfArr == 1){return arr[0];}
        if(sizeOfArr == 2){return  Math.max(arr[0],arr[1]);}
        int prev1  = arr[0];
        int prev2  = Math.max(arr[0],arr[1]);
        int current =0;
        for(int i = 3 ; i <= sizeOfArr;i++){
            current = Math.max(prev1+arr[i-1],prev2);
            prev1 = prev2;
            prev2 = current;
        }

        return current 

      Time:O(n)
      Space:O(1)
      
      */



      return 0;
    }
    public int     arrayPermutationMaxRobberSumKaSumII(int[] arr){
      /*
      [1,2,3,1]- given amount of money in each house a robber cannot steal from adjacent house and the last house is connected to 1st
        |____|   give max amount robber can steal
                Eg: [1,2,3,1]
                1 + 3   = 4 -- max he can steal is 4 
                2  + 1 = 3
          
      
      */


      //RECURSION IP-OP TREE
      /*
                                    
      if(arr.length == 0){return 0;}                            //null check : since we are breaking arr in 2 parts ;     null check for length 0 and 1 
      if(arr.length == 1){return arr[0];}                       
                                                            

      int[] arr1 = Arrays.copyOfRange(arr,0,arr.length-1);       --arr1 is 0 to arr.length-2(considering 0th not considering last )  
      int[] arr2 = Arrays.copyOfRange(arr,1,arr.length);           arr1 is 1 to arr.length-1(not considering 0th and considering last )  
      int res1 = arrayPermutationMaxRobberSumKaSumI(arr1,arr1.length);         res1 =  arrayPermutationMaxRobberSumKaSumI using recursion for arr1
      int res2 =arrayPermutationMaxRobberSumKaSumI(arr2,arr2.length);          res2 =  arrayPermutationMaxRobberSumKaSumI using recursion for arr1
      int res = Math.max(res1,res2);                               res = max(res1,res2)
        
      return res;                                                 return res
  
      Time:O(2^n)
      Space:O(n)
      */
        
      //DP TOP-DOWN MEMOIZATION( Overlapping subproblem )
      /*   
      if(arr.length == 0){return 0;}                            //null check : since we are breaking arr in 2 parts ;     null check for length 0 and 1 
      if(arr.length == 1){return arr[0];}                       
                                                            

      int[] arr1 = Arrays.copyOfRange(arr,0,arr.length-1);       --arr1 is 0 to arr.length-2(considering 0th not considering last )  
      int[] arr2 = Arrays.copyOfRange(arr,1,arr.length);           arr1 is 1 to arr.length-1(not considering 0th and considering last )  
      int res1 = arrayPermutationMaxRobberSumKaSumI(arr1,arr1.length);         res1 =  arrayPermutationMaxRobberSumKaSumI using dp top-down for arr1
      int res2 =arrayPermutationMaxRobberSumKaSumI(arr2,arr2.length);          res2 =  arrayPermutationMaxRobberSumKaSumI using dp top-down  for arr1
      int res = Math.max(res1,res2);                               res = max(res1,res2)
        
      return res;                                                 return res
      Time:O(n^2)
      Space:O(n)
      
      */

      //DP BOTTOM-UP TABULATION(Overlapping subproblem )
      /*
      if(arr.length == 0){return 0;}                            //null check : since we are breaking arr in 2 parts ;     null check for length 0 and 1 
      if(arr.length == 1){return arr[0];}                       
                                                            

      int[] arr1 = Arrays.copyOfRange(arr,0,arr.length-1);       --arr1 is 0 to arr.length-2(considering 0th not considering last )  
      int[] arr2 = Arrays.copyOfRange(arr,1,arr.length);           arr1 is 1 to arr.length-1(not considering 0th and considering last )  
      int res1 = arrayPermutationMaxRobberSumKaSumI(arr1,arr1.length);         res1 =  arrayPermutationMaxRobberSumKaSumI using dp bottom-top  for arr1
      int res2 =arrayPermutationMaxRobberSumKaSumI(arr2,arr2.length);          res2 =  arrayPermutationMaxRobberSumKaSumI using dp bottom-top  for arr1
      int res = Math.max(res1,res2);                               res = max(res1,res2)
        
      return res;                                                 return res

      Time:O(n)
      Space:O(n)
      
      */

     //DP BOTTOM-UP TABULATION IN VARIABLE(Overlapping subproblem )
      /*
      if(arr.length == 0){return 0;}                            //null check : since we are breaking arr in 2 parts ;     null check for length 0 and 1 
      if(arr.length == 1){return arr[0];}                       
                                                            

      int[] arr1 = Arrays.copyOfRange(arr,0,arr.length-1);       --arr1 is 0 to arr.length-2(considering 0th not considering last )  
      int[] arr2 = Arrays.copyOfRange(arr,1,arr.length);           arr1 is 1 to arr.length-1(not considering 0th and considering last )  
      int res1 = arrayPermutationMaxRobberSumKaSumI(arr1,arr1.length);         res1 =  arrayPermutationMaxRobberSumKaSumI using dp bottom-top  for arr1
      int res2 =arrayPermutationMaxRobberSumKaSumI(arr2,arr2.length);          res2 =  arrayPermutationMaxRobberSumKaSumI using dp bottom-top  for arr1
      int res = Math.max(res1,res2);                               res = max(res1,res2)
        
      return res;                                                 return res

      Time:O(n)
      Space:O(n)
      
      */




      return 0;
    }
    
    
    //COMBINTAION, PERMUTATION
    public void    stringPermutationKaSpaceKaString(String ip , String op , List<String> resultList) {
      /*
      "abc" -- given string print all string with spaces permutations
              ie abc, "ab_c", "a_bc", "a_b_c"
      */

      //  RECURSIVE IP-OP TREE(Decision:"abc" me  a ko lu ya _a ko lu, b ko lu ya _b ko lu , c ko lu ya _c ko lu
      /*
               "abc"  ""
          a /       \   _a  
            /        \ 
          "bc" "a"    X        
       b /            \ _b        
        /              \
    "c" "ab"           "c" "a_b"
   c  /  \ _c           c /    \  _c
     /    \              /       \
   "" "abc" "" "ab_c"  "" "a_bc"  ""  "a_b_c" 

    public void    stringPermutationKaSpaceKaString(String ip , String op , List<String> resultList)
                                                     --while going top-bottom
      if(ip.length() == 0){                            if ip.length==0
        resultList.add(op);                            add op to resultList   
        return;                                        return and start moving up  
      }
           
                                                        --while going top-bottom                                         
      var ipSmaller = ip.substring(1, ip.length());       ipsmaller = ip from 1 to end (charAt(0) returns character and substring(0,1) returns string ;and we require string here)
      var op1 = op +ip.charAt(0) ;                        op1 = op + ip(0)             (charAt(0) returns character and substring(0,1) returns string ;both can be concatenated to string so use any one) 
      var op2 = op + "_" + ip.charAt(0);                  op2 = op + "_" + ip(0)       (charAt(0) returns character and substring(0,1) returns string ;both can be concatenated to string so use any one)
      stringPermutationKaSpaceKaString(ipSmaller,op1,resultList);   stringPermutationKaSpaceKaString(ipSmaller,op1,resultList);
      stringPermutationKaSpaceKaString(ipSmaller,op2,resultList)    stringPermutationKaSpaceKaString(ipSmaller,op2,resultList)
    }

    //OVERRIDE
    public List<String> stringPermutationKaSpaceKaString(String ip){
      String ipp = ip.substring(1,ip.length());
      String op = ip.substring(0, 1);
      List<String> resultList = new ArrayList<>();
      stringPermutationKaSpaceKaString(ipp,op,resultList);
      return resultList;
    }


      TIME :O(2^n) as each fn calls itself twice and n(size of ip) reduces by 1
      SPACE:O(n) as we have n(size of ip) ips
    
      */






    }
    public void    stringPermutationKaLetterCaseKaString(String ip , String op , List<String> resultList){ 
      /*
      Question
      "ab"  - given an string in lower case  or uppercase or mix
             return all the permutation in upper and lower case
             ie "ab", "aB", "Ab", "AB"
      */

      //  RECURSIVE IP-OP TREE(Decision:"abc" me  a ko lu ya A ko lu, b ko lu ya B ko lu , c ko lu ya C ko lu)
      /*
              "ab"   ""
        a  /        \       A
          /          \
       "b" "a"       "b" "A"
      b /  \ B      b   /   \  B 
       /    \          /     \
    "" "ab" "" "aB"  "" "Ab" "" "AB" 

    public void    stringPermutationKaLetterCaseKaString(String ip , String op , List<String> resultList)
                                             --while going top bottom
      if(ip.length() == 0){                      if ip length = 0   
        resultList.add(op);                        add op to result list 
        return;                                    return and start moving up
      }



                                                                --while going top-bottom
      var ipSmaller = ip.substring(1, ip.length());              ipSmaller = ip from 1 to end   (charAt(0) returns character and substring(0,1) returns string ;but we require string here)
      var op1 = op + ip.substring(0, 1).toLowerCase();           op1 = op + ip(0).toLowerCase   (charAt(0) returns character and substring(0,1) returns string ;both can be concatenated but toLowerCase not available for char)
      var op2 = op + ip.substring(0, 1).toUpperCase();           op2 = op + ip(0).toUpperCase   (charAt(0) returns character and substring(0,1) returns string ;both can be concatenated but toLowerCase not available for char)
      stringPermutationKaLetterCaseKaString(ipSmaller ,op1 , resultList);  stringPermutationKaLetterCaseKaString(ipSmaller ,op1 , resultList);
      stringPermutationKaLetterCaseKaString(ipSmaller ,op2 , resultList);  stringPermutationKaLetterCaseKaString(ipSmaller ,op2 , resultList);

    }

      //OVERRIDE
      public List<String> stringPermutationKaLetterCaseKaString(String ip){
          List<String> resultList = new ArrayList<>();
          stringPermutationKaLetterCaseKaString(ip,"",resultList);
          return resultList;
      }

      TIME :O(2^n) as each fn calls itself twice and n(size of ip) reduces by 1
      SPACE:O(n) as we have n(size of ip) ips
      
      */





  
    }
    public void    stringPermutationKaNumberLetterCaseKaString(String ip , String op , List<String> resultList){
      /*
      Question
      "a1b2"  - given an string in lower case  or uppercase or mix and digotd
                return all the permutation in upper and lower case
                ie "a1b2", "a1B2", "A1b2", "A1B2"
      */

      //RECURSIVE IP-OP TREE(Decision: "a1b2" a ko lu a ko nai lu , 1 ko lu , b ko lu b ko nai lu)
      /*
                  "a1b2" ""                                  ==   "a1b2"  ""
           a /                \ A                                   /       \
            /                  \                                   /         \
      "1b2""a"                   "1b2" "A"                       isLetter    isnotLetter
        | 1                          | 1                    a    /     \ A             |
        |                            |                          /       \              |
       "b2" "a1"                 "b2"  "A1"            ipsmaller op1  ipsmaller op2     ipsmaller  op1
     b  /      \ B             b /      \  B     
       /        \               /        \
    "2" "a1b"   "2" "a1B"     "2" "A1b"    "2"  "A1B"
       2|          2|          2|          2|                            
        |           |           |           |
    "" "a1b2"   "" "a1B2"     "" "A1b2"    ""  "A1B2"

    public void    stringPermutationKaNumberLetterCaseKaString(String ip , String op , List<String> resultList)         
                                                               --while going top bottom
      if(ip.length() == 0){                                        if ip length = 0   
        resultList.add(op);                                        add op to result list 
        return;                                                    return and start moving up
      }



                                                                  --while going top-bottom
      if(Character.isLetter(ip.charAt(0))){                         if ip(0) is letter
        var ipSmaller = ip.substring(1, ip.length());                  ipSmaller = ip from 1 to end    (charAt(0) returns character and substring(0,1) returns string ;but we require string here)
        var op1 = op + ip.substring(0, 1).toLowerCase();               op1 = op + ip(0).toLowerCase    (charAt(0) returns character and substring(0,1) returns string ;both can be concatenated but toLowerCase not available for char)
        var op2 = op + ip.substring(0, 1).toUpperCase();               op2 = op + ip(0).toUpperCase     (charAt(0) returns character and substring(0,1) returns string ;both can be concatenated but toLowerCase not available for char)
        stringPermutationKaNumberLetterCaseKaString(ipSmaller,op1,resultList);   stringPermutationKaNumberLetterCaseKaString(ipSmaller,op1,resultList);
        stringPermutationKaNumberLetterCaseKaString(ipSmaller,op2,resultList);   stringPermutationKaNumberLetterCaseKaString(ipSmaller,op2,resultList);
      }
      else{                                                         else 
        var ipSmaller = ip.substring(1, ip.length());                 smaller ip = ip from 1 to end
        var op1 = op + ip.charAt(0);                                  op1 = op + ip(0)
        stringPermutationKaNumberLetterCaseKaString(ipSmaller,op1,resultList);  stringPermutationKaNumberLetterCaseKaString(ipSmaller,op1,resultList);
      }

      //OVERRIDE
      public List<Integer> stringPermutationKaNumberLetterCaseKaString(String ip){
        List<String> resultList = new  ArrayList<>();
        stringPermutationKaNumberLetterCaseKaString(S, "" , resultList);
        return resultList;}
      }
 
      TIME :O(2^n) as each fn calls itself twice and n(size of ip) reduces by 1
      SPACE:O(n) as we have n(size of ip) ips     
      */








    }
    public void    stringPermutationKabalanceParanthesisKaString(int ipOpening , int ipClosing, String op , List<String> resultList){
      /*
      QUESTION
      n = 3 - for given n generate valid parenthesis
              ie  "((()))"  "(()())"  "(())()"  "()(())"  "()()()"
      */



     // RECURSIVE IP-OP TREE(Decision : for n = 3  "(" lu ya ")" lu ; "(" lu ya ")" ; "(" lu ya ")"   )
      /*
                    ipopening =3 ipclosing=3    ""         ==                           ipopening =3   ipclosing=3    "" 
                             | (                                             /                        |                              \
                             |                                              /                         |                               \
                             23 "("                      ipOpening != 0 && ipOpening >= ipClosing  ipClosing != 0 && ipOpening == 0     ipOpening != 0 && ipClosing != 0 && ipOpening < ipClosing
                     (  /              \  )                            ( |                           ) |                                (   /   \  )                            
                       /                \                                |                             |                                   /     \
              13 "(("                    22   "()"     ipopeningSmaller,ipclosingSmaller,op1     ipopeningSmaller,ipclosingSmaller,op1   '',op1   '',op2         
              ( /    \  )                  (  |     
               /      \                       |       
          03 "((("       12 "(()"            12  "()("  
             | )       ( /       \ )            ( /   \ )
             |          /         \              /     \
          02 "((()"    02 "(()("   11 "(())"    02 "()(("  11"()()"
           | )           | )        ( |          | )         | ()
           |             |            |          |           |
          01  "((())"  01 "(()()"   01 "(())("  01 "()(()"  01 "()()("
           | )           | )            | )       | )        | )
           |             |              |         |          |
          00 "((()))"    00  "(()())"  00 (())()" 00 "()(())" 00 "()()()"

      public void    stringPermutationKabalanceParanthesisKaString(int ipOpening , int ipClosing, String op , List<String> resultList){
                                                                                     --while coming top-bottom
        if(ipOpening == 0 && ipClosing == 0){                                          if ipOpening==0 a&& ipclosing ==0
          resultList.add(op);                                                          add op to resultList
          return;                                                                      return and start moving up
        }
                                                                                      --while coming top down
        if(ipOpening != 0 && ipOpening >= ipClosing ){                                  if(ipOpening != 0 && ipOpening >= ipClosing )
          int ipOpeningSmaller = ipOpening -1;                                              int ipOpeningSmaller = ipOpening -1;        
          int ipClosingSmaller = ipClosing;                                                 int ipClosingSmaller = ipClosing;   
          String op1 = op + "(";                                                            String op1 = op + "(";  
          stringPermutationKabalanceParanthesisKaString(ipOpeningSmaller,ipClosingSmaller,op1,resultList);   
        }
        if(ipClosing != 0 && ipOpening == 0 ){                                          if(ipClosing != 0 && ipOpening == 0 ){
            int ipOpeningSmaller = ipOpening;                                                int ipOpeningSmaller = ipOpening;
            int ipClosingSmaller = ipClosing-1;                                              int ipClosingSmaller = ipClosing-1;   
            String op1 = op + ")";                                                           String op1 = op + ")";    
            stringPermutationKabalanceParanthesisKaString(ipOpeningSmaller,ipClosingSmaller,op1,resultList)
        }
        if(ipOpening != 0 && ipClosing != 0 && ipOpening < ipClosing ){                if(ipOpening != 0 && ipClosing != 0 && ipOpening < ipClosing ){           
            int ipOpeningSmaller1 = ipOpening-1;                                              int ipOpeningSmaller1 = ipOpening-1;
            int ipClosingSmaller1 = ipClosing;                                                int ipClosingSmaller1 = ipClosing;
            int ipOpeningSmallerr2 = ipOpening;                                               int ipOpeningSmallerr2 = ipOpening;                                        
            int ipClosingSmallerr2= ipClosing-1;                                              int ipClosingSmallerr2 = ipClosing-1;    
            String op1 = op + "(";                                                            String op1 = op + "(";   
            String op2 = op + ")";                                                            String op2 = op + ")";
          stringPermutationKabalanceParanthesisKaString(ipOpeningSmaller,ipClosingSmaller,op1,resultList);  
          stringPermutationKabalanceParanthesisKaString(ipOpeningSmallerr,ipClosingSmallerr,op2,resultList);
      }

      //OVERRIDE
      public void stringPermutationKabalanceParanthesisKaString(int ip){
        List<String> resultList = new ArrayList<>();
        stringPermutationKabalanceParanthesisKaString(ip,ip, "" ,resultList);
      }

      TIME :O(2^n) as each fn calls itself twice(both if conditions can pass) and n(size of brackets) reduces by 1 
      SPACE:O(n) as we have n(size of brackets) ips                                   
      */


  
  







    }
    public void    stringPermutationKaBinaryPrefixKaString(int ip , int ipOnes , int ipZeros , String op , List<String> resultList){

      /*
      QUESTION
      n = 3 - for given n generate binary number whose prefix has no of 1's >= no of 0's
              ie  "111"  -- prefixes 111 , 11 , 1
                   "110" -- prefixes 110 , 11 , 1
                   "101" -- -- prefixes 101 , 10 , 1
      */

      // RECURSIVE IP-OP TREE(Decision :for n=3  1 lu ya 0 lu ; 1 lu ya 0 lu ; 1 lu ya 0 lu)
      /*
          ipOnes = 0 ipZeros = 0 ip = 3  ""
                | 1         
                |
              1 0 2  "1"
            0  /    \1
              /      \
        1 1 1 "10"     2 0 1 "11"
            | 1       0 /       \ 1
            |          /         \
        2 2 0 "101"  2 1 0 "110"    2 0 0 "111"

      public void    stringPermutationKaBinaryPrefixKaString(int ip , int ipOnes , int ipZeros , String op , List<String> resultList)
                                                      --while ging top-down
        if(ip == 0 ){                                    if ip == 0
          resultList.add(op);                            add op to result list
          return;                                        return and start moving up   
        }
                                                      --while going top down
        if(ipOnes <= ipZeros){                          if(ipOnes <= ipZeros)
          int ipOnesSmaller = ipOnes + 1;                   add 1
          int ipZerosSmaller = ipZeros;
          int ipSmaller = ip -1;
          String op1 = op + "1";
          stringPermutationKaBinaryPrefixKaString(ipSmaller, ipOnesSmaller, ipZerosSmaller , op1 , resultList );
        }
        if(ipOnes > ipZeros){                        if(ipOnes > ipZeros)  
          int ipSmaller = ip-1;                         add1   
          int ipOnesSmaller1 = ip+1;                    add 0 
          int ipZerosSmaller1 = ip;
          int ipOnesSmaller2 = ip;
          int ipZerosSmaller2 = ip+1;
          String op1 = op + "1";
          String op2 = op + "0";
          stringPermutationKaBinaryPrefixKaString(ipSmaller, ipOnesSmaller1, ipZerosSmaller1 , op1 , resultList );
          stringPermutationKaBinaryPrefixKaString(ipSmaller, ipOnesSmaller2, ipZerosSmaller2 , op2 , resultList );
        }
      }

      //OVERRIDE
      public void stringPermutationKaBinaryPrefixKaString(int ip){
        List<String> resultList = new ArrayList<>();
        stringPermutationKaBinaryPrefixKaString(ip ,0 ,0 ,"",resultList);
      }

      TIME :O(2^n) as each fn calls itself twice(both if conditions can pass) and n(size of ipzeros and ipones) reduces by 1 
      SPACE:O(n) as we have n(size of ipzeros and ipones)ips       

      */







    }
  



    //COMBINTAION, PERMUTATION -- DFS, BFS
    public void    stringPermutationKaPartitionInOtherListKaPossible(String s, List<String> wordDict){
      /*
      s = "leet"                              --given string partition it into space seperated sequence
      wordDict = ["l","e","ee","le","lee","t"]  such that those sequence are present in word dict 
                                                return true if string can be partitiones
                                               Eg: word can be broken as [["l","e","e","t"] ;["le","e","t"]; ["lee","t"]]
                                                   so return true
      */


      //DFS RECURSIVE
      /*
                                 leet
                        /             |      \         \
                      l/         le   |   lee \    leet \    --chose str from 0 to i inclusive        
                      /               |        \         \
                     eet               et       t          ""  --recursovely call fn on i to end of string
                  /    |   \         /\          
                e/  ee | eet\      e/  \et    
                /      |     \     /    \
               et      t     ""    t   ""
              /  \      |           |
            e/    \et  t|          t|                              
            /      \    |           |
           t      ""    ""          ""                           

      public boolean stringPermutationKaPartitionInOtherListKaPossible(String s,Set<String> set){
                                                          --while moving through string
          if(s.length() == 0) {                            if string length == 0
              return true;                                    return true and start moving up
          }
            
          for(int i=0;i<=s.length()-1;i++) {             --while movingh throught string
              if(set.contains(s.substring(0,i+1))) {         if string from 0 to i inclusive is in set
                  if(fn(s.substring(i+1,s.length()),set)){      recursively call fn on string from i+1 to end of string
                      return true;                                 return true
                  }
                
              }
          }
                                                          --while returning through string 
          return false;                                     return false if we dontr return true above
      }

      //OVERRIDE
      public boolean stringPermutationKaPartitionInOtherListKaPossible(String s,List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict)                    -- populate set with wordDict
        return stringPermutationKaPartitionInOtherListKaPossible(s,set);
      }
   
      Time  :O(n*2^n) -->O(2^n)
                      Each fn calls itself n times 
                      But the number of calls decrease at each level 
                      Thus resulting in total calls of 2^n

                      O(n)
                      At each recursion we call the substring fn which O(n)
      Space :O(n+n)  -->recursion stack of depth n(n) +  Set to storew word dict(n) 
      */

      //DFS RECURSIVE KA TOP-DOWN MEMOIZATION(Overlapping subproblem)
      /*
      public boolean stringPermutationKaPartitionInOtherListKaPossible(String s,Set<String> set, Map<String,Boolean> map)){
                                                       --INITIALISE MAP IN MAIN FN
          if(s.length() == 0) {                            
              return true;                      
          }
          
          if(map.containsKey(s)){                       --CHECK MAP FOR S
            return map.get(s);                            (ie Fn on string s is already called earlier)
          }
          for(int i=0;i<=s.length()-1;i++) {           
              if(set.contains(s.substring(0,i+1))) {        
                  if(fn(s.substring(i+1,s.length()),set)){  
                      map.put(s,true);                  --STORE RET VALUE IN MAP
                     return true;                              
                  }
                
              }
          }
                                                        --STORE RET VALUE IN MAP
          map.put(s,false);
          return false;
      }

      //OVERRIDE
      public boolean stringPermutationKaPartitionInOtherListKaPossible(String s,List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict)                    -- populate set with wordDict
        Map<String,Boolean> map = new HashMap<>();
        return stringPermutationKaPartitionInOtherListKaPossible(s,set,map);
      }

      Time:O(n^3) --o(n^2)
                    Recursion fn calls itself n^2 times

                    O(n)
                    At each recursion we call the substring fn which O(n)

      Space :O(n+n)  -->recursion stack of depth n(n) +  Set to storew word dict(n) 
   
      */

      //DFS RECURSIV KA BOTTOM-UP TABULATION(Overlapping subproblem)
      /* 
      
      public boolean stringPermutationKaPartitionInOtherListKaPossible(String s,int ptr, Set<String> set){
        [t,t,f,f,f] -- dp[i] stores whether string from 0 to i exclusive is present in set
        

        boolean[] dp = new boolean[s.length() + 1]; --initialise dp of s.length+1

        dp[0] = true;                              --string from 0 to 0 exclusive ie""  is by defaulr present in set
        


        for (int i = 1; i <= s.length(); i++) {                ----iterate i from 1 to s.length
          for (int j = 0; j <= i; j++) {                              iterate j 0 to i
              if (dp[j] && set.contains(s.substring(j, i))) {           if substring from 0 to j is present in set  and subs from j to i exclusive is presentt in set
                  dp[i] = true;                                           then subs from 0 to i exclusive is can be formed from the set
                  break;                                                  break
              }                                                    Eg
          }                                                        s = "leet"  set = ["le","et"]                                                              
        }                                                          initially
                                                                   [T,F,F,F,F]

                                                                   i = 1
                                                                   j = 0,1 -- doesnt pass cond
                                                                   j = 1 -- doesnt pass cond

                                                                   i = 2
                                                                   j = 0-- -- dp[0] = T and set contains "le"
                                                                              dp[2] = T  -->[T,F,T,F,F]

                                                                   i = 4
                                                                   j = 2 -- dp[2] = T and set contains "et"
                                                                            dp[4] = T
                                                                            (You can see "le" dp[2] is present in set and "et" is present in set
                                                                             Hence "leet" dp[4] can be formed from set)




        return dp[s.length()];                              --last element is answwr
      }

      //OVERRIDE
      public boolean stringPermutationKaPartitionInOtherListKaPossible(String s,List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict)                    -- populate set with wordDict
        return stringPermutationKaPartitionInOtherListKaPossible(s,set);
      }

      Time:O(n^3) --o(n^2)
                    Outer loops

                    O(n)
                    At each recursion we call the substring fn which O(n)

      Space :O(n)  -->Set to storew word dict(n) 
      */

     
    }
    public void    stringPermutationKaPartitionInOtherListKaStrings(String s, List<String> wordDict){
     /*
      s = "catsanddog"                             --given string partition it into space seperated sequence
      wordDict = ["cat","cats","and","sand","dog"]  such that those sequence are present in word dict 
                                                    return all such possible partitions AND join them by space
                                                    Eg: word can be broken [["cats","and","dog"],["cat","sand","dog"]
                                                       so return ["cats and dog","cat sand dog"]
      */

      //DFS RECURSIVE
      /*
                                 leet
                        /             |      \         \
                      l/         le   |   lee \    leet \    --chose str from 0 to i inclusive        
                      /               |        \         \
                     eet               et       t          ""  --recursovely call fn on i to end of string
                  /    |   \         /\          
                e/  ee | eet\      e/  \et    
                /      |     \     /    \
               et      t     ""    t   ""
              /  \      |           |
            e/    \et  t|          t|                              
            /      \    |           |
           t      ""    ""          ""                           


      private void stringPermutationKaPartitionInOtherListKaStrings(String s,Set<String> set, List<String> currentList,List<List<String>> res){
          
          if(s.length() == 0) {                                        --while moving through string
              res.add(new ArrayList<String>(currentList));               add current list to res and start moving up 
          }
          
          for(int i=0;i<=s.length()-1;i++) {                          --while movingh throught string
              if(set.contains(s.substring(0,i+1))) {                      if string from 0 to i inclusive is in set         
                  currentList.add(s.substring(0,i+1));                      add string from 0 to i inclusive to currentList
                  fn(s.substring(i+1,s.length()),set, currentList,res);     recursively call fn on string from i+1 to end of string
                  currentList.remove(currentList.size() - 1);               remove last string while coming bacl
                
              }
          }
      }
    
      //OVERRIDE
      public List<String> stringPermutationKaPartitionInOtherListKaStrings(String s, List<String> wordDict) {
        List<List<String >> res = new ArrayList<>();       
        List<String> currentList = new ArrayList<>();
        stringPermutationKaPartitionInOtherListKaStrings(s,new HashSet(wordDict),currentList,res);
       

        List<String> result = new ArrayList<>();           --convert res(List<List<Str>>) to desired result(List<Str>) 
        for(List<String> resElement:res){
            StringBuilder sb = new StringBuilder();
            for(String resString: resElement){
                sb.append(resString).append(" ");    
            }
            result.add(sb.toString().trim());
            
        }  
        return result;
      }
   
      Time  :O(n*(2^n)) -->O(2^n)
                      Each fn calls itself n times 
                      But the number of calls decrease at each level 
                      Thus resulting in total calls of 2^n

                      O(n)
                      At each recursion we call the substring fn  which are both O(n)
                
      Space :O(n+n)  -->recursion stack of depth n(n) +  Set to storew word dict(n
      */


    }
    public void    stringPermutationKaPartitionIsPallindromeKaPossible(String s){
      /*
      s = "aab"                              --given string partition it into space seperated sequence
                                                such that those sequence are pallindrome 
                                                return true if string can be partitioned
                                               Eg: s can be broken as [["a","a","b"],["aa","b"]]
                                                   so return true
      */

      //DFS RECURSIVE
      /*
      Same as stringPermutationKaPartitionInOtherListKaPossible()
      if(set.contains(s.substring(0,i+1))) KE BADLE if(isPallindrome(s.substring(0,i+1)))

      AND
      set , wordDict not req
      
      */

      
      //DFS RECURSIVE KA TOP-DOWN MEMOIZATION(Overlapping subproblem)
      /*
      Same as stringPermutationKaPartitionInOtherListKaPossible()
      if(set.contains(s.substring(0,i+1)))  KE BADLE if(isPallindrome(s.substring(0,i+1)))

      AND
      set , wordDict not req
       */

      //DFS RECURSIV KA BOTTOM-UP TABULATION(Overlapping subproblem)
      /*
      Same as stringPermutationKaPartitionInOtherListKaPossible()
      if(set.contains(s.substring(0,i+1))) KE BADLE if(isPallindrome(s.substring(0,i+1)))

      AND
      set , wordDict not req
       */
    }
    public void    stringPermutationKaPartitionIsPallindromeKaStrings(String s){
      /*
      s = "aab"                              --given string partition it into space seperated sequence
                                                such that those sequence are pallindrome 
                                                return true if string can be partitioned
                                               Eg: s can be broken as [["a","a","b"],["aa","b"]]
                                                   so return [["a","a","b"],["aa","b"]]
      */

      //DFS RECURSIVE
      /*
      Same as stringPermutationKaPartitionInOtherListKaPossible()
      if(set.contains(s.substring(0,i+1))) KE BADLE if(isPallindrome(s.substring(0,i+1)))

      AND
      set , wordDict not req

      AND
      In Overrode Fn convert res to desired result is also not requires 

      */

      
    }
    public void    stringPermutationKaIntegerToMobileString(String s){
      /* 
      "226" -->given a string convert it to mobile equivalent string(Image:https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
                return the mobile equivalent string
              Eg: "23" could be decoded as ["ad","ae","af","bd","be","bf","cd","ce","cf"]
      */


      //DFS RECURCIVE
      /*
                      23
                     "def ghi"
                /          |         \
              d/           |e         \
              /            |           \
            "d"            "e"          "f"
            / | \          / | \          /  |  \ 
         g / h| i\       g/ h| i\       g/  h|   \
          /   |   \      /   |   \      /    |    \
      "dg"  "dh"   "di" "eg" "eh" "ei"  "fg" "fh"  "fi"

      public void stringPermutationKaIntegerToMobileString(String s, int index, StringBuilder path,List<String> res,Map<Character, String> map ) {
                                                               --while moving through string
        if (path.length() == s.length()) {                      if path.length = s.length
            res.add(path.toString());                               add path to result
            return;                                                 return and start moving up
        }
        

        String possibleLetters = map.get(s.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {   --while moving through string
            path.append(letter);                                   append letter to parth
            fn(s,index + 1, path,res,map);                         recursively call fn on next index ie next digit
            path.deleteCharAt(path.length() - 1);                  while moving back remove last letter from path
        }
      }

      //OVERRIDE
      public List<String> stringPermutationKaIntegerToMobileString(String s) {
            
        if (s.length() == 0) {                             //null check for 0 length
            return new ArrayList<>();
        }
        
        Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        StringBuilder path = new StringBuilder("");
        List<String> res = new ArrayList<>();
        stringPermutationKaMobileNumberToStr(s,0,path ,res,map);
        return res;
      }
      

      Time:o(n*(4^n))-->4^n
                       Each fn calls itself 4 times ,ax(digit 7 , 8 have 4 letters)

                       O(n)
                       For each call you build sb and then convert it to string in O(n)

      Space:O(n) -->recursion depth of n(n) + map(1) as map is not dependant on ip
      
      */
    }


    //MATRIX-- DFS, BFS
    public int  maxtrixTraversal(int[][] arr,int m , int n){

      
      /*
        1--2--3   
        |  |  |     
        4--5--6
        |  |  |
        7--8--9 
        */

      //DFS RECURSIVE
      /*
      Start with a starting pos m,n 
      Move in top,bottom,left,right,diagonal dir using recursion and base case

      Eg:matrixConnectedComponentFill_FloodFill()
      
      */

      //DFS ITERATIVE
      /*
      Start with a starting nodes m,n 
      Push the starting nodes in stack
      while !stack.isEmpty()
        pop the nodes from stack
        move in top,bottom,left,right,diagonal  by pushing to stack in REVERSE order  
      
      Eg:matrixConnectedComponentFill_FloodFill()
      */

      //BFS ITERATIVE
      /*
      Start with a starting pos m,n 
      Push starting nodes in queue
      while !queue.isEmpty()
          pop the nodes from queue
          push the top,bottom,left,right,diagonal  nodes in queue

      Eg:matrixConnectedComponentFill_FloodFill()
      */
    


      return 0;





    }
    public int  matrixUniquePathKaCountI(int[][] arr, int m, int n){

      /*
      1 1 1  --given matrix move from top left to bottom right and
      1 1 1    return the number of unique paths reach bottom right
      1 1 1
      
      */

      //DFS RECURSIVE
      /*
      public int matrixUniquePathKaCountI(int[][] arr){
          DFSRecursive(arr,0,0);                                              --perform DFS on start Node only 
      }

      public int DFSRecursive(int[][] arr, int m, int n){
                                                                                 --while going bottom and right 
          if(m >=arr.length || n >=arr[0].length)                                     if m or n move beyound boundary
            return 0;                                                                    return 0  and move back to original node
          if(m ==arr.length || n ==arr[0].length)                                     if m and n reach bottom right
              return 1;                                                                   return 1 and move back to original node
              
                                                      
                                                                                  --while going bottom and right 
          int top = DFSRecursive(arr,m+1,n);                                         top,left  stores path count from above and left  
          int left = DFSRecursive(arr,m,n+1);
                                                                                  --while going  up and left
          return top+ left;                                                            return top + left 
      }


      TIME :O(2^m+n) as each fn calls itself twice
      SPACE:O(m+n)   for recursion depth m+n
      
      */
   

      //DFS RECURSIVE KA TOP-DOWN MEMOIZATION(Overlapping subproblem)
      /*
        public int matrixUniquePathKaCountI(int[][] arr){
          int[][] dp = new int[arr.length+1][arr[0].length+1];
          for(int i=0; i <=dp.length-1;i++){for(int j=0; j <= dp[0].length-1;j++){dp[i][j] = -1;}}
          DFSRecursive(arr,0,0,dp);                                     --perform DFS  on start Node only 
      }

      public int DFSRecursive(int[][] arr, int m, int n, int[][] dp){ ----  INITIALISE MATRIX [arr.length+1][arr[0].length+1] , FILL MATRIX WITH -1 
          if(m >=arr.length || n >=arr[0].length) 
          return 0;
  
          if(m ==arr.length || n ==arr[0].length)
          return 1;
          

          if(dp[m][n] != -1){                            -- CHECK IN MATRIX
              return dp[m][n];
          }
     
            
      
        
        int top = DFSRecursive(arr,m+1,n);               --STORE RETURN VALUE IN MATRIX
        int left = DFSRecursive(arr,m,n+1);
        dp[m][n] = top + left;
        reyurn dp[m][n];

      }



      TIME :O(m^m)  as we elminiate recursion and use matrix of size m^n
      SPACE:O(m^n)  as we matrix takes extra space m^n        
      */

      //DFS RECURSIV KA BOTTOM-UP TABULATION(Overlapping subproblem)
      /*
      1 1 1  --(m,n) for column m and row n 
      1 2 3    stores  the no of paths untill that node 
      1 1 1    Eg (1,1) represents 2 paths to reach ie 1 from above + 1 from left   
                   (1,2) represents 3 paths to reach there ie 2 froim left and 1 from above

      public int matrixUniquePathKaCountI(int[][] arr, int m, int n){
        return DFSRecursive(arr,arr.length-1,arr[0].length-1);          --perform DFS  on start Node only 
      }

      public int DFSRecursive(int[][] arr,int m, int n){
        int[][] dp = new int[arr.length+1][arr[0].length+1];                    --> INITIALISE MATRIX

        for(int i=0 ; i<= m;i++){                                               -->move i 0 till m
            for(int j=0 ; j <= n;j++){                                              move j 0 till n
                if(i == 0 || j == 0){                                                 initialise all i=0,j=t to 1 because there is only 1 way to reach thetre
                    dp[i][j] = 1;
                }
            
            }
        }
            
        for(int i=1 ; i<= m;i++){                                              -->move i 1 to m
            for(int j=1 ; j <= n;j++){                                              move j 1 to n
                int left = dp[i-1][j];                                                 add paths coming from left and right
                int right = dp[i][j-1];
                dp[i][j] = left + right;
            }
        }
            
        return dp[m][n];                                                       -->last element in matrix is answer
      
      }
  
      
      TIME :O(m^n)  as we elminiate recursion and use matrix of size m^n
      SPACE:O(m^n) as we use dp   
      
      */

      return 0;
    }
    public int  matrixUniquePathKaCountII(int[][] arr, int m, int n){
      /*
      0 0 0  --given matrix move from top left to bottom right and
      1 1 0    return the number of unique paths reach bottom right
      0 1 0    and if there is an  obstacles denoted by 1  then you cant move on that pathh    
      */

      //DFS RECURSIVE
      /*
      public int matrixUniquePathKaCountII(int[][] arr){
          DFSRecursive(arr,0,0);                                    --perform DFS  on start node only 
      }
      public int DFSRecursive(int[][] arr, int m, int n){
                                                                                 --while going bottom and right
          if(m >=arr.length || n >=arr[0].length)                                  if m or n move beyound boundary 
            return 0;                                                                   return 0  and move back to original node
          if(m ==arr.length-1|| n ==arr[0].length-1 &&arr[m][n] !=1)               if m and n reach bottom right and there is no obstacle on top ledt
              return 1;                                                                return 1 and move back to original node
          if(arr[m][n] == 1){                                                      if there is an obstacle           
              return 0;                                                                 return 0 and move back to original noide
          }

              
                                                      
                                                                                  --while going bottom and right
          int top = DFSRecursive(arr,m+1,n);                                        top,left  stores path count  from up and left
          int left = DFSRecursive(arr,m,n+1);
                                                                                  --while going up and left
          return top+ left;                                                        return top + lefyt
      }



      TIME :O(2^m+m) as each fn calls itself twice
      SPACE:O(m+n)   for recursion depth m+n
      
      */
   

      //DFS RECURSIVE KA TOP-DOWN MEMOIZATION(Overlapping subproblem)
      /*
      public int matrixUniquePathKaCountII(int[][] arr){
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        for(int i=0; i <=dp.length-1;i++){for(int j=0; j <= dp[0].length-1;j++){dp[i][j] = -1;}}
        DFSRecursive(arr,0,0,dp);        --perform DFS on start node only
      }


      public int DFSRecursive(int[][] arr, int m, int n, int[][] dp){ ----  INITIALISE MATRIX [arr.length+1][arr[0].length+1] , FILL MATRIX WITH -1 
          if(m >=arr.length || n >=arr[0].length)  {
            return 0;
          if(m ==arr.length-1|| n ==arr[0].length-1 &&arr[m][n] !=1) {
            return 1;
          

          if(dp[m][n] != -1){                                    -- CHECK IN MATRIX
              return dp[m][n];
          }
     
            
      
        
        int top = DFSRecursive(arr,m+1,n);                      --STORE RETURN VALUE IN MATRIX
        int left = DFSRecursive(arr,m,n+1);
        dp[m][n] = top + left;
        reyurn dp[m][n];

      }

      TIME :O(m^m)  as we elminiate recursion and use matrix of size m^n
      SPACE:O(m^n)  as we matrix takes extra space m^n        
      */

       //DFS RECURSIVE KA BOTTOM-UP TABULATION(Overlapping subproblem)
      /*
      1 1 1  --(m,n) for column m and row n 
      1 2 3    stores  the no of paths untill that node 
      1 1 1    Eg (1,1) represents 2 paths to reach ie 1 from above + 1 from left   
                   (1,2) represents 3 paths to reach there ie 2 froim left and 1 from above

      public int matrixUniquePathKaCountI(int[][] arr, int m, int n){
        return DFSRecursive(arr,arr.length-1,arr[0].length-1);      --perform DFS on start node only
      }

      public int DFSRecursive(int[][] arr,int m, int n){
        int[][] dp = new int[arr.length+1][arr[0].length+1];     --> INITIALISE MATRIX

        for(int i=0 ; i <= m ; i++){                             -->move i 0 till m
            if(arr[i][0] == 1){                                        if there is an obstacle 
                dp[i][0] = 0;                                          initialise dp[i][0] to 0 and all elements after that must be 0 so break
                break;}                                                initialise dp[i][0] to 1 as there is only 1 way to reach there 
            dp[i][0] = 1;
            
        }

        for(int j=0 ; j <= m ; j++){                             -->move j 0 till n
          if(arr[0][j] == 1){                                        if there is an obstacle 
              dp[0][j] = 0;                                          initialise dp[0][j] to 0 and all elements after that must be 0 so break
              break;}                                                initialise dp[0][j] to 1 as there is only 1 way to reach there 
          dp[0][j] = 1;
        }

   
       for(int i=1; i <= m ; i++){                              -->move i 1 till m
           for(int j=1 ; j <= n;j++){                                move j 0 till n
               if(arr[i][j] == 1){                                       if there is an obstacle
                   dp[i][j] = 0;                                            initialise dp[i][j] to 0 and continue as you dont want to continue on that path
                   continue;}                                            add no of pathhs from left and above
               int left =dp[i-1][j] ;  
               int right = dp[i][j-1]  
               dp[i][j] = left + right;
               
              }
       }
        
        
        return dp[m][n];
        return dp[m][n];                              -->last element in matrix is answer
      
      }

  
      
      TIME :O(m^n)  as we elminiate recursion and use matrix of size m^n
      SPACE:O(m^n) as we use dp   
      
      */

      return 0;
    }
    public int  matrixAllPathsKaMinSum(int[][] arr, int m, int n){
      /*
      1 2 3  --given matrix move from top left to bottom right and
      4 5 6    count sum of all paths and return the min sum of all paths
      7 8 9    
      */

      //DFS RECURSIVE
      /*
       public int matrixAllPathsKaMinSum(int[][] arr){
          DFSRecursive(arr,0,0);                            --perform DFS on start node only
      }
      public int DFSRecursive(int[][] arr, int m, int n){
                                                                                 --while going bottom and right
          if(m >=arr.length || n >=arr[0].length)                                  if m or n move beyound boundary 
            return Integer.MAX_VALUE;                                                return Integer.MAX_VALUE and move back to original node
          if(m ==arr.length-1|| n ==arr[0].length-1)                               if m and n reach bottom right 
              return arr[m][n];                                                        return arr[m][n] and move back to original node
          }

              
                                                      
                                                                                  --while going bottom and right
          int up = DFSRecursive(arr,m+1,n);                                          up,left stores sum from up and left   
          int left = DFSRecursive(arr,m,n+1);
                                                                                   --while going up and left
          return arr[m][n] + Math.min(up,left);                                          return arr[m][n] +  min sum from  up and left
      }

      TIME :O(2^m+m) as each fn calls itself twice
      SPACE:O(m+n)   for recursion depth m+n
      
      */
   

      //DFS RECURSIVE KA  TOP-DOWN MEMOIZATION(Overlapping subproblem)
      /*
      public int matrixAllPathsKaMinSum(int[][] arr){
          int[][] dp = new int[arr.length+1][arr[0].length+1];
          for(int i=0; i <=dp.length-1;i++){for(int j=0; j <= dp[0].length-1;j++){dp[i][j] = -1;}}
          DFSRecursive(arr,0,0,dp);                            --perform DFS on start node only
      }


      public int DFSRecursive(int[][] arr, int m, int n, int[][] dp){           ----  INITIALISE MATRIX [arr.length+1][arr[0].length+1] , FILL MATRIX WITH -1 
          if(m >=arr.length || n >=arr[0].length)  {
            return Integer.MAX_VALUE;
          if(m ==arr.length-1|| n ==arr[0].length-1) {
            return arr[m][n];
          

          if(dp[m][n] != -1){                                                              -- CHECK IN MATRIX
              return dp[m][n];
          }
     
            
      
        
        int up = DFSRecursive(arr,m+1,n);               --STORE RETURN VALUE IN MATRIX
        int left = DFSRecursive(arr,m,n+1);
        dp[m][n] = arr[m][n] + Math.min(up , left);
        reyurn dp[m][n];

      }



      TIME :O(m^m)  as we elminiate recursion and use matrix of size m^n
      SPACE:O(m^n)  as we matrix takes extra space m^n        
      */

      //DFS RECURSIVE  BOTTOM-UP TABULATION(Overlapping subproblem)
      /*
      1 1 1  --(m,n) for column m and row n 
      1 2 3    stores min sum of paths untill that node
      1 1 1    Eg (1,1) represents min sum at that pos ie arr[1][1] + min(sum from above + sum from left)

      public int matrixUniquePathKaCountI(int[][] arr, int m, int n){
        return DFSRecursive(arr,0,0); -- perform DFS On start node only
      }
  

      public int DFSRecursive(int[][] arr,int m, int n){
        int[][] dp = new int[arr.length+1][arr[0].length+1];     --> INITIALISE MATRIX

         for(int i=0 ; i <= m;i++){                              --move i 0 to m
            for(int j=0 ; j <= n;j++){                               move j 0 to m
                if(i == 0 && j == 0)                                   if(i == 0 && j == 0){ 
                    dp[i][j] = arr[i][j];                                   initialise 1st block to arr[i][j] 
                if(i != 0 && j == 0 ){                                 if(i != 0 && j == 0 ){
                    dp[i][j] = arr[i][j] + dp[i-1][j];                     initialise columns except 1st block to arr[i][j] + sum of prev column
                if(i == 0 && j != 0){                                   if(i != 0 && j == 0 ){
                    dp[i][j] = arr[i][j] + dp[i][j-1];                      initialise row except 1st block to arr[i][j] + sum of prev row
                }
            }
         }

   
       for(int i=1; i <= m ; i++){                              -->move i 1 till m
           for(int j=1 ; j <= n;j++){                                move j 1 till n
               int left = dp[i-1][j];                                   add arr[i][j] + min sum from left and right
               int right = dp[i][j-1];
               dp[i][j] = arr[i][j] + Math.min(left,right);
               
              }
       }
        
        
        return dp[m][n];
        return dp[m][n];                                                       -->last element in matrix is answer
      
      }

      
      TIME :O(m^n)  as we elminiate recursion and use matrix of size m^n
      SPACE:O(m^n) as we use dp   
      
      */

      return 0;
    }
    public void matrixConnectedComponentFill_FloodFill(int[][] arr,int m,int n ,int originalNode,int newNode){
      /*
      1 1 1   -->2 2 2    --> starting from pos m,n 
      1 1 0      2 2 0        find all the connected nodes (neighbouring nodes to node at m,n with same value as originalNode)
      1 0 1      2 0 1        replace connecting nodes with newNode
      nc = 2                  OR
      m,n = 1,1               starting from m,n flood fill all neighbours staring from m,n

      
      
      */
      
      //DFS RECURSIVE
      /*
      public int[][] matrixConnectedComponentFill_FloodFill(int[][] arr, int m, int n, int newColour) {

        if(arr[m][n] == newColour){return arr;}                  --if starting pt is itself newColour then return the arr because if we call recursion;  then we will be moving down,up,left,right forever 
        DFSRecursive(arr,m,n,arr[m][n],newColour);               --perform DFS On start node only
        return arr;  
      }

      public void DFSRecursive(int[][] arr,int m,int n ,int originalNode,int newNode){
                                                                                         --while going down,up,left,right,
        if(m <=-1 || n <=-1 || m >= arr.length || n>= arr[0].length){                      if we move out of boundary
            return;                                                                           return
        if(arr[m][n] != originalColour)                                                   if we reach node where colout doesnt matches originalColour which we want to replace
            return;                                                                           return
        
                                                                                          reassign arr[m][n] to new colour
        arr[m][n] = newColour;    
                                                                                         --while going down,up,left,right,
        DFSRecursive(arr,m-1,n,oldColour,newColour);
        DFSRecursive(arr,m+1,n,oldColour,newColour);
        DFSRecursive(arr,m,n-1,oldColour,newColour);
        DFSRecursive(arr,m,n+1,oldColour,newColour); 
 
      }

    
      Time:O(m*n) : you travel all nodes in matrix only once 
                    as arr[m][n] = newColour marks m,n as new colour and when you visit m,n again in future
                    the condition if(arr[m][n] != originalColour) will return and  will not let you  visit m,n again
  
                        
      Space:O(m*n) which is the depth of recursion stack
    
      */
      

      //DFS ITERATIVE
      /*
      public int[][] matrixConnectedComponentFill_FloodFill(int[][] arr, int m, int n, int newColour) {

        if(arr[m][n] == newColour){return arr;}                  --if starting pt is itself newColour then return the arr because if we call recursion;  then we will be moving down,up,left,right forever 
        DFSIterative(arr,m,n,arr[m][n],newColour);               --perform DFS On start node only
        return arr;  
      }


      public void DFSIterative(int[][] arr,int m,int n ,int originalColour,int newColour){
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{m,n});                  --push starting nodes in stack
          
        while(!stack.isEmpty()){                      --while stack.isEmpty()
            int[] node = stack.pop();                       pop node from stack 
            m = node[0];n= node[1];                         

            if(arr[m][n] !=originalColour){continue}      if we reach node where colour doesnt matches originalColour which we want to replace;skip the node
            arr[m][n] = newColour;                          reassign arr[m][n] to new colour
            
            if(m-1 >= 0){                                   push top,bottom,left,right nodes to stack
                stack.push(new int[]{m-1,n});
            }
            if(m+1 <= arr.length-1){
                stack.push(new int[]{m+1,n});
            }
            if(n-1 >=0){
                stack.push(new int[]{m,n-1});
            }
            if(n+1 <= arr[0].length-1){
                stack.push(new int[]{m,n+1});
            }    
        }          
      }
    

      Time:O(m*n) :same as above
      Space:O(m*n) which is space required by stack
      
      */
      

      //BFS ITERATIVE
      /*
      public int[][] matrixConnectedComponentFill_FloodFill(int[][] arr, int m, int n, int newColour) {

        if(arr[m][n] == newColour){return arr;}                  --if starting pt is itself newColour then return the arr because if we call recursion;  then we will be moving down,up,left,right forever 
        BFSIterative(arr,m,n,arr[m][n],newColour);               --perform BFS On start node only
        return arr;  
      }

      public void BFSIterative(int[][] arr,int m,int n ,int originalColour,int newColour){
        Queue<int[]> queue = new ArrayDeque<>(); 
        queue.add(new int[]{m,n});                                    --push starting nodes in stack
          
        while(!queue.isEmpty()){                                     --while stack.isEmpty()
            int[] node = queue.remove();                                remove node from queue 
            m = node[0];n= node[1];

            if(arr[m][n] !=originalColour){continue}                   if we reach node where colour doesnt matches originalColour which we want to replace;skip the node
            arr[m][n] = newColour;                                      reassign arr[m][n] to new colour
            
            if(m-1 >= 0){                                               add top,bottom,left,right nodes to queue
                queue.add(new int[]{m-1,n});
            }
            if(m+1 <= arr.length-1){
                queue.add(new int[]{m+1,n});
            }
            if(n-1 >=0){
                queue.add(new int[]{m,n-1});
            }
            if(n+1 <= arr[0].length-1){
                queue.add(new int[]{m,n+1});
            }  
        }   
    }

    
      Time:O(m*n) same as above
      Space:O(m*n) which is space required by queue
      
      
      */
      
      
  }
    public void matrixConnectedComponentArea_FloodFillArea(int[][] arr,int m,int n ,int originalColour,int newColour){
      /*
      1 1 1   -->2 2 2    --> matrix starting pos m,n 
      1 1 0      2 2 0        find all the connected nodes (neighbouring nodes to node at m,n with same value as originalNode)
      1 0 1      2 0 1        replace connecting nodes with newNode
      nc = 2                  and return the area(number of cells filled) 
      m,n = 1,1               OR
                              starting from m,n flood fill all neighbours andf find the flood fill area(mo of cells filled)


      
      
      */
      
      //DFS RECURSIVE
      /*
      public int[][] matrixConnectedComponentArea_FloodFillArea(int[][] arr, int m, int n, int newColour) {

        if(arr[m][n] == newColour){return arr;}               --if starting pt is itself newColour then return the arr because if we call recursion; then we will be moving down,up,left,right forever 
        DFSRecursive(arr,m,n,arr[m][n],newColour);                   --perform DFS On start node only       
        return arr;  
      }

      public int  DFSRecursive(int[][] arr,int m,int n ,int originalColour,int newColour){
                                                                                        --while going down,up,left,right,
        if(m <=-1 || n <=-1 || m >= arr.length || n>= arr[0].length){                      if we move out of boundary
            return 0;                                                                          return 0 
        if(arr[m][n] != originalColour)                                                   if we reach node where colout doesnt matches originalColour which we want to replace
            return 0;                                                                           return 0
        
                                                                                          reassign arr[m][n] to new colour
        arr[m][n] = newColour;    
                                                                                        --while going bottom,top,left,right,
        int bottom = DFSRecursive(arr,m-1,n,oldColour,newColour);                         top,down,left,right store the number of nodes filles
        int top    = DFSRecursive(arr,m+1,n,oldColour,newColour);
        int left   = DFSRecursive(arr,m,n-1,oldColour,newColour);
        int right  = DFSRecursive(arr,m,n+1,oldColour,newColour); 
                                                                                         --while returning bottom,top,left,right,
        return 1+  bottom+top+left+right                                                  return  1+  bottom+top+left+right   

      }
                           
    
      Time:O(m*n) :  you travel all nodes in matrix only once 
                    as arr[m][n] = newColour marks m,n as new colour and when you visit m,n again in future
                    the condition if(arr[m][n] != originalColour) will return and  will not let you  visit m,n again
                          
      Space:O(m*n) which is the depth of recursion stack
    
      */
      

    
      
  }
    public void matrixConnectedNodeComponent_NoOfIslands(char[][] arr){
      /*
      [
        ["1","1","1","1","0"],    - find all the connected nodes (neighbouring nodes to node at m,n with same value as originalNode="1")
        ["1","1","0","1","0"],      find number if such connected nodes 
        ["1","1","0","0","0"],       
        ["0","0","0","1","0"]        OR 
                                    In a matrix land is "1" and water is "0" 
                                    island is formed by connect by joining land horizontally and vertically and is surrounded by water
                                    count the number of islands
                                    Eg:In this case 2 island 1 on top left , 1 in last row
      ]
      
      */

      //DFS RECURSIVE
      /*
      public int matrixConnectedNodeComponent_NoOfIslands(char[][] arr) {
        int count =0;
        for(int i=0; i <= arr.length-1;i++){                               --iterate matrix
            for(int j=0 ; j <= arr[0].length-1;j++){                            if arr[i][j] == '1'
                if(arr[i][j] == '1'){                                              increment count as this is an island
                    count++;                                                       flood fill all neighbouring '1' with '0' 
                    matrixConnectedComponentFill_FloodFill(arr,i,j,arr[i][j],'0');                        so that all the connected lands are considered in this island
                }                                                                  (matrixFloodDFSRecursive(int[][] arr,int m,int n ,int oldColour,cinthar newColour)  KE BADLE
            }                                                                       matrixFloodDFSRecursive(char[][] arr,int m,int n ,char oldColour,char newColour))
        }
        return count;                                                        --return count 
      }


      Time:O(m*n) because you traverse all nodes in matrix 
                  the time complexity of matrixConnectedComponentFill_FloodFill wont be multiplied
                  because if you flood fill the neighbours of a node and then visit the neighbouring node in next iteration
                  you will not be required to flood fill on that node 
             
      Space:O(m*n) which is the depth of recursion stack for the flood fill 
      */
    
      //DFS ITERATIVE
      /*
      public int matrixConnectedNodeComponent_NoOfIslands(char[][] arr) {
        int count =0;
        for(int i=0; i <= arr.length-1;i++){                               --iterate matrix
            for(int j=0 ; j <= arr[0].length-1;j++){                            if arr[i][j] == '1'
                if(arr[i][j] == '1'){                                              increment count as this is an island
                    count++;                                                       flood fill all neighbouring '1' with '0' 
                    matrixConnectedComponentFill_FloodFill(arr,i,j,arr[i][j],'0');                        so that all the connected lands are considered in this island
                }                                                                  (matrixFloodDFSRecursive(int[][] arr,int m,int n ,int oldColour,cinthar newColour)  KE BADLE
            }                                                                       matrixFloodDFSRecursive(char[][] arr,int m,int n ,char oldColour,char newColour))
        }
        return count;                                                        --return count 
      }
      Time:O(m*n) same as abpve
      Space:O(m*n) which is space required by stack
      */

          
      //BFS  ITERATIVE
      /*
      public int matrixConnectedNodeComponent_NoOfIslands(char[][] arr) {
        int count =0;
        for(int i=0; i <= arr.length-1;i++){                               --iterate matrix
            for(int j=0 ; j <= arr[0].length-1;j++){                            if arr[i][j] == '1'
                if(arr[i][j] == '1'){                                              increment count as this is an island
                    count++;                                                       flood fill all neighbouring '1' with '0' 
                    matrixConnectedComponentFill_FloodFill(arr,i,j,arr[i][j],'0');                        so that all the connected lands are considered in this island
                }                                                                  (matrixFloodDFSRecursive(int[][] arr,int m,int n ,int oldColour,cinthar newColour)  KE BADLE
            }                                                                       matrixFloodDFSRecursive(char[][] arr,int m,int n ,char oldColour,char newColour))
        }
        return count;                                                        --return count 
      }
      Time:O(m*n) same as abpve
      Space:O(m*n) which is space required by stack
      */
    
    
    
    
    
    }
    public void matrixConnectedComponentMaxArea_MaxAreaOfIslands(char[][] arr){
      /*
        [
        ["1","1","1","1","0"],    - find all the connected nodes (neighbouring nodes to node at m,n with same value as originalNode="1")
        ["1","1","0","1","0"],      find max area(no of nodes in connected nodes) of all such  connected nodes 
        ["1","1","0","0","0"],       
        ["0","0","0","1","0"]        OR 
                                    In a matrix land is "1" and water is "0" 
                                    island is formed by connect by joining land horizontally and vertically and is surrounded by water
                                    return the max area  the number of islands

      ]
      
      */

      //DFS RECURSIVE
      /*
      public int matrixConnectedComponentMaxArea_MaxAreaOfIslands(char[][] arr) {
        int maxArea =Integer.MIN_VALUE;
        for(int i=0; i <= arr.length-1;i++){                               --iterate matrix
            for(int j=0 ; j <= arr[0].length-1;j++){                            if arr[i][j] == 1
                if(arr[i][j] ==  1){                                              increment count as this is an island
                  int area = matrixConnectedCompArea_FFA(arr,i,j,arr[i][j],0);    flood fill all neighbouring 1 with 0 so that all the connected lands are considered in this island and return the coumt of cells filles 
                  maxArea = Math.max(maxArea,area);                               find the max area of all the islands                              
                }                                                                  
            }                                                                       
        }
        return maxArea != Integer.MIN_VALUE?maxArea:0;;                        --return maxArea 
      }


      Time:O(m*n) because you traverse all nodes in matrix 
                  the time complexity of matrixConnectedComponentFill_FloodFill wont be multiplied
                  because if you flood fill the neighbours of a node and then visit the neighbouring node in next iteration
                  you will not be required to flood fill on that node 
      Space:O(m*n) which is the depth of recursion stack for the flood fill 
      */
    
  
    
    
    
    }
    public void matrixWordSearch(char[][] arr,String word){
      /*
      -----
      A B C | E      --given a matrix you can travel in all 4 directions
      S F C | S        search if a word exists or not
      A D E | E        Eg:In this case word exists
        ----
      Word = "ABCCED"
      
      
      
      */
      
      //DFS RECURSIVE
      /*
        public boolean matrixWordSearch(char[][] arr, String word) {
          for(int i=0 ; i <= arr.length-1;i++){                              --performm DFS  on each element of matrix
              for(int j=0 ; j <= arr[0].length-1;j++){                                                 
                  if(DFSRecursive(arr,i,j,0,word))
                      return true;
              }
          }
          return false;
      }

      public boolean DFSRecursive(char[][] arr, int m,int n, int index, String s){
                                                                                                            --while moving top bottom left right
          if(m >= arr.length || m <= -1 || n >= arr[0].length || n <= -1  || index >= s.length() ){              if we move out of matrix boundary or string boundary
              return false;                                                                                           return false
          
          if(arr[m][n] != s.charAt(index))                                                                        if arr[m][n] != s.charAt(index)
              return false;                                                                                           return false and move to next node                      
          if(arr[m][n] == s.charAt(index) && index == s.length()-1){                                              if arr[m][n] == s.charAt(index) and we are at last index
              return true;                                                                                            return true and mve to next node
          

          arr[m][n] = '#';                                                                                       mark the visited node


          boolean res = DFSRecursive(arr,m-1,n,index+1,s)                                                   --while moving top bottom left right
          ||DFSRecursive(arr,m+1,n,index+1,s)                                                                 res holds if word found from all 4 direction
          ||DFSRecursive(arr,m,n-1,index+1,s)
          ||DFSRecursive(arr,m,n+1,index+1,s);
                                                                                                              --while moving top bottom left right
          arr[m][n] = s.charAt(index);                                                                           inmark the visited node

          return res;
      }   

      Time:O(m*n * 3^L) -- we iterate throigh array(O(n*m))
                           and at each iteration we call each fn 4 times till the length(l) of the string
                           but marking the visited node doesnt allow us to go left 
      Space:O(L) -- recursion calls till length of string
      
          
      
      
  }
  
      
      
      
      */
      
      
  }
    public void matrixWordSearchII(char[][] arr,String[] word){
      /*
        -----
        A B C | E      --given a matrix you can travel in all 4 directions
        S F C | S        return all the words that exists im the  not
        A D E | E        Eg:In this case wordS ["ABCCED","ABFD"] exists
          ----
        words = ["ABCCED","ABFD","ALARM"]
        
      
      
      */
      
      //DFS RECURSIVE
      /*
      public List<String> matrixWordSearchII(char[][] arr, String[] words) {
        //construct trie-
        Trie trie = new Trie();                              --Implement trie with one extra thing of word
        Trie.Node root =trie.new Node();                       In implementation of Trie class add "word" which a stores the word at a point in trie 
                                                                class Trie{
                                                                  public class Node{
                                                                    private boolean isEndOfWord;
                                                                    public String word; -- add this
                                                                  }
                                                                  public void    DFSWordOrderInsertWord(Node root, String word ){
                                                                    for(...){}
                                                                    ptr.isEndOfWord = true;
                                                                    ptr.word = word;          --add this
                                                                  }
                                                                }

        for(String word:words){                                --iterate the words and insert the words in Trie
            trie.DFSWordOrderInsertWord(root,word);              
        }                                                        
         
        
        List<String> res = new ArrayList<>();
        for(int i=0 ; i <= arr.length-1;i++){                   --performm DFS  on each element of matrix                                                   
            for(int j=0 ; j <= arr[0].length-1;j++){ 
                DFSRecursive(arr,i,j,root,res);
            }
        }
      
      return res;
    }

    public void DFSRecursive(char[][] arr, int m,int n,Trie.Node root, List<String> res ){
                                                                                                --while moving top bottom left right
      if(m >= arr.length || m <= -1 || n >= arr[0].length || n <= -1  || index >= s.length() )    if we move out of matrix boundary or string boundary
        return;                                                                                       return 
      char currentChar = arr[m][n];                                                               if current char is visite or current char is not in our Trie
      if (currentChar == '#' || root.children[currentChar - 'a'] == null) {                          return
         return;

      root = root.children[currentChar - 'a'];                                                   move root to current char
      if (root.word != null) {                                                                   if it is a word  
        res.add(root.word);                                                                         add the word to res
        root.word = null;                                                                           reassign word to null
      }

        
       
      arr[m][n] = '#';                                                                          mark the visited node
        
                                                                                             --while moving top bottom left right
      DFSRecursive(arr,m-1,n,root,res);                                                        move top bottom left right
      DFSRecursive(arr,m+1,n,root,res);
      DFSRecursive(arr,m,n-1,root,res);
      DFSRecursive(arr,m,n+1,root,res);
        
                                                                                           --while moving top bottom left right
      arr[m][n] = currentChar;                                                               unmark the visited node with current character
 
    }
    
      Time:O(m*n + m*n*3^L) --insert m*n characters in trie(O(m*n))
                           -- we iterate throgh array(O(n*m))
                              and at each iteration we call each fn 4 times till the length(l) of the string
                              but marking the visited node doesnt allow us to go left 
      Space:O(L) -- recursion calls till length of string
      
      */
    }

  




    //GRAPH-- DFS, BFS
    /*   
    n0----n1---Node/vertice(N/V) 
     |    |---- Edges(E)  
     |    |
     n2---n3
                                  
    REPRESENTATION OF GRAPH    
    ADJACENCY MATRIX   ADJACENCY LIST      OR     ADJACENCY MAP OR   EDGES
        0 1 2 3        [[1,2,3]                    {0:[1,2,3]          [[0,1],            
     0 [0 1 1 0         [0,3]                       1:[0,3]             [1,2],        
     1  0 0 0 0         [0,3]                       2:[n1]              [2,0]], 
     2  1 0 0 1         [1,2]                       3:[n1]        
     3  0 0 0 0 ]        ]                            }                      
     |                    |                             |                   |
     |                    |                             |                   |
n0 is connected to n1,n2  n0 is connected to n1,n2,n3   same            For unidirectional/directed  graph
n2 is connected to n0,n3  n2 is connected to n0,n3                      n0 connected to n1
                          [2,0]],                                       n1 connected to n2
                                                                       n2 connected to n1

                                                                      For bidirectional/directed graph
                                                                      n0 connected to n1 , n1 connected to n0
                                                                      n1 connected to n2,n2 connected to n1
                                                                      n2 connected to n0,n0 connected to n2

                                                                      CONVERT EDGES TO ADJACENCY LIST OR ADJACENCY MAP
                                                                      Map<Integer,List<Integer>> graphMap = new HashMap<>();
                                                                      List<List<Integer>> graphArr = new ArrayList<>();
                                                                      for(int i=0 ; i <= n-1;i++){               //if edges are given then no of nodes will also be given
                                                                          graphArr.add(i,new ArrayList<>());
                                                                          graphMap.put(i,new ArrayList<>());
                                                                      }
                                                                      for(int[] edge:edges){
                                                                          graphArr.get(edge[0]).add(edge[1]);   //if it is a unidirectional graph then you need to connect only 0 to 1
                                                                          graphArr.get(edge[1]).add(edge[0]);    If it is a bidirectional graph you need to connect 0 to 1 and 1 to 0
                            
                                                                          graphMap.get(edge[0]).add(edge[1]);
                                                                          graphMap.get(edge[1]).add(edge[0]);
                                                  }



  TYPES OF GRAPH
  UNIDIRECTIONAL/DIRECTED  :Nodes are connected to other nodes in 1 direction only
  BIDIRECTIONAL/UNDIRECTED :Nodes are connected to other nodes in both direction
  DISJOINT                 :Nodes are not all connected Eg 1---2  3  4
  CYCLIC GRAPH             :Graph has atleast 1 cycle       |__|  |__|
  ACYCLIC GRAP             :Graph Has Cycle

    */
    public void graphConstruct(int[][] edges, int n){
      /*
      //graphConstructI()-->Convert edge: [[0,1], [0,2],[1,2]] to graphArr[[1,2],[2] ]
      public int graphConstructI(int[][] edges , int n){                   0     1     

        Map<Integer,List<Integer>> graphMap = new HashMap<>();  --initialise graphArr, graphMap
        List<List<Integer>> graphArr = new ArrayList<>();          
        for(int i=0 ; i <= n-1;i++){                             
            graphArr.add(i,new ArrayList<>());                     
            graphMap.put(i,new ArrayList<>());                    
        }
        for(int[] edge:edges){
            graphArr.get(edge[0]).add(edge[1]);                 --if it is a unidirectional graph then you need to connect only 0 to 1
            graphArr.get(edge[1]).add(edge[0]);                   if it is a bidirectional graph you need to connect 0 to 1 and 1 to 0
            
            graphMap.get(edge[0]).add(edge[1]);
            graphMap.get(edge[1]).add(edge[0]);
        }
      }                                                       
                                                             
      //graphConstructI()-->construct graph for edge :[[0,1,6],[0,2,9],[1,2,11]] to graphArrr[[<1,6>,<2,9>],[<2,11>] ]
      public class Node{                                                                           0             1
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }
      public int graphConstruct(int[][] edges , int n){   
        Map<Node,List<Node>> graphMap = new HashMap<>();  ---initialise graphArr, graphMap
        List<List<Node>> graphArr = new ArrayList<>(); 
        for(int i=0 ; i <= n-1;i++){                             
            graphArr.add(i,new ArrayList<>());                     
            graphMap.put(i,new ArrayList<>());                    
        }
        for(int[] edge:edges){

            graphArr.get(edge[0]).add(new Node(edge[1],edge[2]));      --if it is a unidirectional graph then you need to connect only 0 to 1
            graphArr.get(edge[1]).add(new Node(edge[0],edge[2]));        if it is a bidirectional graph you need to connect 0 to 1 and 1 to 0
            
            graphMap.get(edge[0]).add(new Node(edge[1],edge[2])); 
            graphMap.get(edge[1]).add(new Node(edge[1],edge[2])); 
        } 

      }

                                                   0     1   2
      //graphDeConstructI() -->Convert graphArr: [[1,2],[0],[0] ] to edge: [[0,1,6],[0,2,9],[1,2,11]]  
      public int[][] graphDeConstructI(ArrayList<ArrayList<Integer>> graphArr, int n){
        boolean[] visited = new boolean[n];
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i=0 ; i <=n-1;i++){
            for(int j : graphArr.get(i)){
                if(!visited[j]){                                    --if it is a undirectional graph  we need to ckeck visited 
                    List<Integer> tempList = new ArrayList<>();        because  graphArr has contains connection for both sides but edge has only 1 connection hence we use visited
                    tempList.add(i); visited[i] = true;                Eg: In above eg in graph arr 0 is connected to 1 and 1 to 0 ; but in edge we need to show  [0,1] and not [1,0]
                    tempList.add(j);                                --if it directional graph then also check viited no harm in it
                    edgeList.add(tempList);
                }
            }
        }
        
        int[][] edges = new int[edgeList.size()][2];
        for(int i=0 ; i <= edgeList.size()-1;i++){
            int[] tempArr = new int[2];
            for(int j=0 ; j<=edgeList.get(i).size()-1;j++){
                tempArr[j] = edgeList.get(i).get(j);
            }
            edges[i] = tempArr;
        }
        return edges;
    }
                                                      0             1     
      //graphDeConstructII() -->Convert graphArr: [[<1,6>,<2,9>],[<2,11>] ] to edge:[[0,1,6],[0,2,9],[1,2,11]]
      public int[][] graphDeConstructI(ArrayList<ArrayList<Integer>> graphArr, int n){
        boolean[] visited = new boolean[n];
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i=0 ; i <=n-1;i++){
            for(Node j : graphArr.get(i)){
                if(!visited[j.getVal()]){                            --if it is a undirectional graph  we need to ckeck visited 
                    List<Integer> tempList = new ArrayList<>();        same as explained above
                    tempList.add(i); visited[i] = true;                --if it directional graph then also check viited no harm in it
                    tempList.add(j.getVal());
                    tempList.add(j.getWeight());                               
                    edgeList.add(tempList);
                }
            }
        }
        
        int[][] edges = new int[edgeList.size()][2];
        for(int i=0 ; i <= edgeList.size()-1;i++){
            int[] tempArr = new int[3];
            for(int j=0 ; j<=edgeList.get(i).size()-1;j++){
                tempArr[j] = edgeList.get(i).get(j);
            }
            edges[i] = tempArr;
        }
        return edges;
    }
      


      
      
      */

    }
    public void graphUndirUnionFind(){

      /*
      //UNION FIND BY RANK AND PATH CPOMPRESSION
      Class UnionFind(){
          
        //MAKESET-->INITIALISE THE RANK AND PARENT ARRAYS
        public void makeSet(int[] parent , int[] rank, int n){       
          for(i =0  ; i <=n-1;i++ ){                                   --initialise every node as its won parent
            parent[i] = i;                                               initialise every node's rank to 0 
            rank[i] = 0;
          }
        }

        //FINDPARENT -->FIND THE TOPMOST PARENT OF NODE AND ALSO PERFORM PATH COMPRESSION Eg: 1-->2-->3 ;find(3) will return 1 and compress gpapg to 1-->3
        public int findParent(int node,int[] parent , int[] rank){                                                                                 |-->2
          if(node == parent[node])                                      --if node and parent of node are same 
            return node;                                                    return parent

          return parent[node] = findParent(parent[node],parent,rank);   --go to parent of the node 
                                                                          and also perform path compression by assigning parent of node to node returned by fn
        }

        //UNION -->IF NODE U AND NODE V ARE IN 2 DIFFERENT COMPONENTS THEN COMBINE THEM BY MAKING ONE PARENT OF OTHER
        public void union(int u , int v,int[] parent , int[] rank,int n){    
          u = findParent(u,parent,rank,);                                 --find parent of u,v
          v = findParent(v,parent,rank,n);

          if(rank[u] < rank[v]){                                         if rank of u < rank if v   
            parent[u] = v;}                                                  make v as parent of u and dont change rank of u or v  as height of graph doesnt change
          else if(rank[v] < rank[u]){                                    if rank of v < rank of u
            parent[v] = u;}                                                   make v as parent of u and dont change rank of u or v as height of graph doesnt change
          else if(rank[u] == rank[v]){                                    if rank of u and v is same         
            parent[v] = u;rank[u]++;                                          make u as parent of v and change rank of u as height of graph  changes
            OR                                                                OR
            parent[u] = v; rank[v]++;                                         make v as parent of u and change rank of v 
          }
        }

        //EXPLANATION
        Initially
        rank   [0,0,0,0,0] -->every node is parent of itself, every node has rank 0
        parent [0,1,2,3,4]   
        0  1   2   3   4    5   6
        |_| |_| |_| |_| |_| |_| |_|

        union(0,1)   
        rank   [0,0,0,0,0,0,0]       -->0 ka parent is 0   
        parent [0,1,2,3,4,5,6]           1 ka parent is 1
        0   1   2   3   4   5   6        rank of 0 and 1 is same  
        |_| |_| |_| |_| |_| |_| |_|         make 0 as parent of 1 and increment rank of 0 as height of graph changes 
                     
        rank   [1,0,0,0,0,0,0]   
        parent [0,0,2,3,4,5,6]      
        0 -->1   2   3   4   5   6       
        |_|  |_| |_| |_| |_| |_| |_|
        
        union(1,2)   
        rank   [1,0,0,0,0,0,0]      -->1 ka parent is 0
        parent [0,0,2,3,4,5,6]         2 ka parent is 2  
        0 -->1  2  3  4  5   6         rank of 2 < rank of 0    
             |_| |_| |_| |_| |_|         make 0 as parent of 2 and dont increment rank as height of graph doesnt change

        rank   [1,0,0,0,0,0,0]   
        parent [0,0,0,3,4,5,6]      
        0 -->1  3   4   5   6     
        |--->2  |_| |_| |_| |_|


        union(3,4)
        rank   [1,0,0,0,0,0,0]  --> parent of 3 is 3  
        parent [0,0,0,3,4,5,6]      parent of 4 is 4
        0 -->1  3   4   5   6      rank of 3 = rank of 4
        |--->2  |_| |_| |_| |_|       make 3 as parent of 4 anc increment rank of 3 as height increases

        rank   [1,0,0,1,0,0,0]   
        parent [0,0,0,3,3,5,6]      
        0 -->1  3 -->4   5   6     
        |--->2       |_| |_| |_|

        union(5,6)
        rank   [1,0,0,1,0,0,0]   -->parent of 5 is 5
        parent [0,0,0,3,3,5,6]      parent of 6 is 6
        0 -->1  3 -->4   5   6      rank of 5 = rank of 6
        |--->2       |_| |_| |_|     make 5 as parent of 6 and increment rank of 5 as height increases

        rank   [1,0,0,1,0,1,0]   
        parent [0,0,0,3,3,5,5]      
        0 -->1  3 -->4   5 -->6     
        |--->2       |_| |_|

        union(4,5)
        rank   [1,0,0,1,0,1,0]  -->parent of 4 is 3 
        parent [0,0,0,3,3,5,5]     parent of 5 is 5
        0 -->1  3 -->4   5 -->6    rank of 3 = rank of 5 
        |--->2       |_| |_|          make 4 as parent of 5 and increment rank of 4 as height increases

       
        rank   [1,0,0,1,0,1,0] 
        parent [0,0,0,3,3,5,5]     
        0 -->1  3 -->4-->5 -->6    
        |--->2                 

        union(2,6)
        rank   [1,0,0,1,0,1,0] -->parent of 6 is 3 -->parent of 6 is 5;  parent of 5 is 4 so compress path by making 4 as parent of 6; paret of 4 is 3 so compress path by making 3 as parent of 4,5,6
        parent [0,0,0,3,3,5,5]    parent of 2 is 0   
        0 -->1  3 -->4-->5 -->6   rank of 3 = rank of 0 
        |--->2                       make 0 as parent of 3 and increment rank of 3 as height increases

        rank   [1,0,0,2,0,1,0] 
        parent [0,0,0,3,3,3,4]     
        0 -->1     
        |--->2   
        |--->3
             |-->4
             |-->5
             |-->6


      }



      Time :O(4*alpha)=O(4) = O(1) -->tieme complexity of union fn is proven to be 4 alpha
      Space:O(N)     -->For rank and parent array 
      
      
      
      */

    }
    public void graphTraversal(int[][] edges){
      //DFS RECURSIVE(Same for both directed and undirected graph)
      /*
      public  void DFSRecursive( Map<Integer,List<Integer>> graphMap,boolean[] visited, int node,ArrayList<Integer> res) {
        
                                                                       --while moving through neighbourNode nodes 
        visited[node]=true;                                              mark the node as visited
        res.add(node);                                                   add node to res

        for (int neighbourNode:graphMap.get(node)){                     --while moving through neighbourNode nodes of current node                              
            if (!visited[neighbourNode]){                                 if neighbourNode is not  visited
                DFSRecursive(graphMap,visited,neighbourNode,res);             call recursive fn on neighbourNode
            }
        }    
      }

      //OVERRIDE
      public List<Integer> DFSRecursive(int[][] edges, int n) {
        List<Integer>res=new ArrayList<>();
 
        List<List<Integer>> graphArr = graphArr;                           --initialise graphArr and graphMap , visited                            
        Map<Integer,ArrayList<Integer>> graphMap = new HashMap<>();          (look in graphConstructI())
        boolean visited[]=new boolean[n];
        DFSRecursive(graphMap,visited,0,res);                              --start with a starting node
        return res;
          
      }

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N + N+E +  N) -- recursion stack depth(N) , graphMap(N+E) , visited arr(N) 



      
      */

      //DFS ITERATIVE(Same for both directed and undirected graph)
      /*
      public  void DFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited,int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);                                                    --push 1st node to stack
 
        while(!stack.isEmpty()){                                               --while(!stack.isEmpty())
          node= stack.pop();                                                     pop node from stack

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                    add popped node to visited
          res.add(node)                                                            add node to res
          
          
          List<Integer> neighbourNodes =  graphMap.get(node);                       move through neighbour nodes in REVERSE order
          for(int i = neighbourNodes.size()-1;i>=0;i--){                             if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                             push neighBourNode to stack
              if(!visited[node]){
                    stack.push(node);
              }  
          }
        }

        //OVERRIDE
        public List<Integer> DFSIteratove(int[][] edges, int n) {
          List<Integer>res=new ArrayList<>();
  
          List<List<Integer>> graphArr = graphArr;                           --initialise graphArr and graphMap , visited                            
          Map<Integer,ArrayList<Integer>> graphMap = new HashMap<>();          (look in graphConstructI())
          boolean visited[]=new boolean[n];
          DFSRecursive(graphMap,visited,0,res);                              --start with a starting node
          return res;
            
        }



     
      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit the same node again
      Space:O(N+E +  N) -- graphMap(N+E) , visited arr and stack(N) 
  

      */

      //BFS ITERATIVE(Same for both directed and undirected graph)
      /*
      public  void BFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited, int node){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);                                                      --push 1st node to queue
 
        while(!queue.isEmpty()){                                               --while(!queue.isEmpty())
          node = queue.remove();                                                remove node from queue

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                   add popped node to visited
          res.add(node)                                                            add node to res
          
          
          List<Integer> neighbourNodes =  graphMap.get(node);                        move through neighbour nodes in STRAIGHT  order
          for(int i = 0;i<=neighbourNodes.size()-1;i++){                             if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                             push neighBourNode to queue
              if(!visited[neighbourNode] ){
                    queue.add(neighbourNode);
              }  
          }
        }

        //OVERRIDE
        public List<Integer> BFSIterative(int[][] edges, int n) {
          List<Integer>res=new ArrayList<>();
  
          List<List<Integer>> graphArr = graphArr;                       --initialise graphArr and graphMap                 
          Map<Integer,ArrayList<Integer>> graphMap = new HashMap<>();       (look in graphConstructI())
          boolean visited[]=new boolean[n];
          BFSIterative(graphMap,visited,0,res);                           --start with a starting node
          return res;
          
        }


     
      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn tallow the recursive fn to be called again on the node
      Space:O(N+E +  N) -- graphMap(N+E) , visited arr and queue(N) 
      */

    }
    public void graphDirUndirPathExists(int[][] edges,int n, int startNode,int endNode){
      /*
      0--1  3       --find if path starting with startNode and ending with endNode directed/undirected  graph
         |    |       Eg:In this caase true
         |    |         
         2    4
      
      edges: [[0,1],[1,2],[3,4]]
      n = 5
      startNode = 0
      endNode = 2

      
      
      */
      //DFS RECURSIVE
      /*
      public  void graphDirUndirPathExists( Map<Integer,List<Integer>> graphMap,boolean[] visited, int startNode,int endNode,) {
        DFSRecursive(graphMap,visited,startNode,endNode); -- perform DFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                             but we must start from given startNode and hence cant perform DFS on every node
      }

      public  void DFSRecursive( Map<Integer,List<Integer>> graphMap,boolean[] visited, int startNode,int endNode) {
                                                                       --while moving through neighbourNode nodes 
        visited[startNode]=true;                                         mark the node as visited


        for (int neighbourNode:graphMap.get(startNode)){                --while moving through neighbourNode nodes of current node  
            if(neighbourNode ==endNode ){pathFound = true;break;}         if neighBoutNode is endNode set pathFound to true and return                             
            if (!visited[neighbourNode]){                                 if neighbourNode is not  visited
                DFSRecursive(graphMap,visited,neighbourNode,endNode);     call recursive fn on neighbourNode
            }
        }    
      }


      //OVERRIDE
      public boolean pathFound = false;
      public List<Integer> graphDirUndirPathExists(int[][] edge ,int n, int startNode,int endNode) {

        if(edges.length == 0 && startNode == 0  && endNode == 0){return true;}-- EDGE CASE:edge:[] ,sn:0,en: 0 means graphArr= {0:[0]}

        Map<Integer,List<Integer>> graphMap = new HashMap<>();  ----initialise graphArr, graphMap ,visisted
        List<List<Integer>> graphArr = new ArrayList<>();           (look in graphConstructI())
        boolean[] visited = new boolean[n];
        graphDirUndirPathExists(graphMap,visited,startNode,endNode);   --start with a starting node 0, 
        return pathFound;
          
      }

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+ N+E +  N) -- recursion stack depth(N) + graphMap(N+E) , visited arr(N) 



      
      */

      //DFS ITERATIVE
      /*
      public  void graphDirUndirPathExists(Map<Integer,List<Integer>> graphMap,boolean[] visited, int startNode,int endNode){
        DFSIterative(graphMap,visited,startNode,endNode); -- perform DFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                             but we must start from given startNode and hence cant perform DFS on every node
      }
      }

      public  void DFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited, int startNode,int endNode){
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);                                                 --push 1st node to stack
 
        while(!stack.isEmpty()){                                               --while(!stack.isEmpty())
          node = stack.pop();                                                    pop node from stack

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                   add popped node to visited
          if(node ==endNode ){pathFound = true;break;}                            if rewmoved node matches ebNode make pathFound true and break

          
          
          List<Integer> neighbourNodes =  graphMap.get(node);                       move through neighbour nodes in REVERSE order
          for(int i = neighbourNodes.size()-1;i>=0;i--){                             if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                             push neighBourNode to stack
              if(visited[neighbourNode] != true){
                    stack.push(neighbourNode);
              }  
          }
        }
     

      //OVERRIDE
      public boolean pathFound = false;
      public List<Integer> graphDirUndirPathExists(int[][] edge ,int n, int startNode,int endNode) {
        if(edges.length == 0 && startNode == 0  && endNode == 0){return true;}-- EDGE CASE:edge:[] ,sn:0,en: 0 means graphArr= {0:[0]}

        Map<Integer,List<Integer>> graphMap = new HashMap<>();             --initialise graphArr, graphMap ,visisted
        List<List<Integer>> graphArr = new ArrayList<>();                     (look in graphConstructI())
        boolean[] visited = new boolean[n];
 
      
        graphDirUndirPathExists(graphMap,visited,startNode,endNode);        --start with a starting node 0, 
        return pathFound;
          
      }

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
     Space:O(N+ N+E +  N) -- recursion stack depth(N) + graphMap(N+E) , visited arr and stack(N) 

  

      */

      //BFS ITERATIVE
      /*
      public  void graphDirUndirPathExists(Map<Integer,List<Integer>> graphMap,boolean[] visited, int startNode,int endNode){
        BFSIterative(graphMap,visited,startNode,endNode); -- perform BFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                             but we must start from given startNode and hence cant perform BFS on every node
      }

      public  void BFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited, int startNode,int endNode){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);                                                 --push 1st node to queue
 
        while(!stack.isEmpty()){                                               --while(!stack.isEmpty())
          node = queue.remove();                                                 remove node from queue

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                   add popped node to visited
          if(node ==endNode ){pathFound = true;break;}                            if rewmoved node matches ebNode make pathFound true and break
          
          
          List<Integer> neighbourNodes =  graphMap.get(node);                        move through neighbour nodes in STRAIGHT order
          for(int i = 0;i<=neighbourNodes.size()-1;i++){                             if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                             push neighBourNode to stack
              if(visited[neighbourNode] != true){
                    queue.add(neighbourNode);
              }  
          }
        }
     
      //OVERRIDE
      public boolean pathFound = false;
      public List<Integer> graphDirUndirPathExists(int[][] edge ,int n, int startNode,int endNode) {
        if(edges.length == 0 && startNode == 0  && endNode == 0){return true;}-- EDGE CASE:edge:[] ,sn:0,en: 0 means graphArr= {0:[0]}

        Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr, graphMap ,visisted
        List<List<Integer>> graphArr = new ArrayList<>();              for bidirectional graph
        boolean[] visited = new boolean[n];                           (look in graphConstructI())
 
      
        graphDirUndirPathExists(graphMap,visited,startNode,endNode);   --start with a starting node 0, 
        return pathFound;
          
      }

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+ N+E +  N) -- recursion stack depth(N) + graphMap(N+E) , visited arr and queue(N) 


      */
    
    }
    public void graphDirUndirConnectedComponentsCount(int[][] edges , int n){
      /*
      0--1  3       --find the connected nodes in directed/undirected graph(ie nodes which are connected with each other) 
         |  |         return the number of such connected nodes
         |  |         Eg:In this case it is 2
         2  4
      
      edges: [[0,1],[1,2],[3,4]]
      n = 5
      
      */
      
      //DFS RECURSIVE
      /*
      public int  graphDirUndirConnectedComponentsCount(Map<Integer,List<Integer>> graphMap, boolean[] visited, int n){
          int count =0;
          for(int i=0 ; i <= n-1;i++){                                 --perform DFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
              if(!visited[i]){                                          and increment count on every visit 
                DFSRecursive(graphMap,visited,i);                         Eg 
                count++;                                                  i = 0            
              }                                                           DFSRecursive will traverse all nodes connected to  0  
          }                                                               and fill visited with all connected nodes [0,1,2]  
          return count                                                                
                                                                          i=1,i=2
                                                                          not enter the loop as they are alrwady in visited
        }
                                                                          i=3
                                                                          DFSRecursive will traverse all nodes connected to  3
                                                                          and fill visited with all connected nodes [3,4]

                                                                          i=4
                                                                          not enter the loop as they are alrwady in visited

                                                                          so the number of times loop runs gives the number of connected components

      }

    public  void DFSRecursive( Map<Integer,List<Integer>> graphMap,boolean[] visited, int node) {
        
                                                                       --while moving through neighbourNode nodes 
        visited[node]=true;                                              mark the node as visited

        for (int neighbourNode:graphMap.get(node)){                     --while moving through neighbourNode nodes of current node                              
            if (!visited[neighbourNode]){                                 if neighbourNode is not  visited
                DFSRecursive(graphMap,visited,neighbourNode,res);             call recursive fn on neighbourNode
            }
        }    
      }



      //OVERRIDE
      public int graphDirUndirConnectedComponentsCount(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n];       
          return graphDirUndirConnectedComponentsCount(graphArr, visited,n );
      
      }      


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                     the time complexity of DFSRecursive doesnt get multiplied because visited inside DFSRecursive
                      but  the visited array doesnt allow to visit same node again
      Space:O(N+ N+E +  N) --recursion depth(N), graphMap(N+E) , visited arr(N) 
          
          

      }
      */

      //DFS ITERATIVE
      /*
      public int  graphDirUndirConnectedComponentsCount(Map<Integer,List<Integer>> graphMap, boolean[] visited int n){
          int count =0;
          for(int i=0 ; i <= n-1;i++){                                 --perform DFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
              if(!visited[i]){                                          and increment count on every visit 
                DFSIterative(graphMap,visited,i);                         Eg 
                count++;                                                  i = 0            
              }                                                           DFSRecursive will traverse all nodes connected to  0  
          }                                                               and fill visited with all connected nodes [0,1,2]  
          return count                                                                
                                                                          i=1,i=2
                                                                          not enter the loop as they are alrwady in visited
        }
                                                                          i=3
                                                                          DFSRecursive will traverse all nodes connected to  3
                                                                          and fill visited with all connected nodes [3,4]

                                                                          i=4
                                                                          not enter the loop as they are alrwady in visited

                                                                          so the number of times loop runs gives the number of connected components

      }

    public  void DFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited,int node){
      Stack<Integer> stack = new Stack<>();
      stack.push(node);                                                    --push 1st node to stack

      while(!stack.isEmpty()){                                               --while(!stack.isEmpty())
        node= stack.pop();                                                     pop node from stack

        if(visited[node]){continue;}                                            if popped node is visited continue          
        visited[node] = true;                                                    add popped node to visited
        res.add(node)                                                            add node to res
        
        
        List<Integer> neighbourNodes =  graphMap.get(node);                       move through neighbour nodes in REVERSE order
        for(int i = neighbourNodes.size()-1;i>=0;i--){                             if neighBourNode is not visited
            int neighbourNode = neighbourNodes.get(i);                             push neighBourNode to stack
            if(!visited[node]){
                  stack.push(node);
            }  
        }


      //OVERRIDE
      public int graphDirUndirConnectedComponentsCount(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n];       
          return graphDirUndirConnectedComponentsCount(graphArr, visited,n );
      
      } 
      
      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                     the time complexity of DFSRecursive doesnt get multiplied because visited inside DFSRecursive
                      but  the visited array doesnt allow to visit same node again
      Space:O(N+E +  N) -- graphMap(N+E) , visited arr and stack(N) 
      */

      //BFS ITERATIVE
      /*
      public int  graphDirUndirConnectedComponentsCount(Map<Integer,List<Integer>> graphMap, boolean[] visited int n){
          int count =0;
          for(int i=0 ; i <= n-1;i++){                                 --perform DFS on every node if not visitesd(Graph may be multiple components and BFS  traverses only one component ;hence we perform BFS on every node)
              if(!visited[i]){                                          and increment count on every visit 
                DFSIterative(graphMap,visited,i);                         Eg 
                count++;                                                  i = 0            
              }                                                           DFSRecursive will traverse all nodes connected to  0  
          }                                                               and fill visited with all connected nodes [0,1,2]  
          return count                                                                
                                                                          i=1,i=2
                                                                          not enter the loop as they are alrwady in visited
        }
                                                                          i=3
                                                                          DFSRecursive will traverse all nodes connected to  3
                                                                          and fill visited with all connected nodes [3,4]

                                                                          i=4
                                                                          not enter the loop as they are alrwady in visited

                                                                          so the number of times loop runs gives the number of connected components

      }

      public  void BFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited, int node){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);                                                      --push 1st node to queue
 
        while(!queue.isEmpty()){                                               --while(!queue.isEmpty())
          node = queue.remove();                                                remove node from queue

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                   add popped node to visited
          res.add(node)                                                            add node to res
          
          
          List<Integer> neighbourNodes =  graphMap.get(node);                        move through neighbour nodes in STRAIGHT  order
          for(int i = 0;i<=neighbourNodes.size()-1;i++){                             if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                             push neighBourNode to queue
              if(!visited[neighbourNode] ){
                    queue.add(neighbourNode);
          }  
        }
      }

      //OVERRIDE
      public int graphDirUndirConnectedComponentsCount(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n];       
          return graphDirUndirConnectedComponentsCount(graphArr, visited,n );
      
      } 
      
      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                     the time complexity of DFSRecursive doesnt get multiplied because visited inside DFSRecursive
                      but  the visited array doesnt allow to visit same node again
      Space:O(N+E +  N) -- graphMap(N+E) , visited arr and queue(N) 
      */

      //UNION-FIND -->Only for Undirected graph as union find works for undirected graph only
      /*
      public int graphDirUndirConnectedComponentsCount(int[][] edges, int n){
                                                    
        UnionFind  uf = new UnionFind();                                    
        int[] parent = new int[n];                                              --> parent array stores node and their parent ;initially all nodes are their own parents
        int[] rank = new rank[n];                                                  rank array stores rank of the node;initialise by 0 
        int[] mst = new int[n];                                           
        uf.makeSet(parent,rank,n);  

        int noOfComponents = n;                                         
        for(int[] edge:edges){                                                  -->iterate through edges     
            int u= edge[0];                                                        if parent of u != parent v 
            int v = edge[1];                                                         find union of u,v as     
                                                                                     decrement noOfComponents count as we join 2 nodes
            if(uf.findParent(u,parent,rank,n) != uf.findParent(v,parent,rank,n)){            
                uf.union(u,v,parent,rank,n);
                noOfComponents--;
            }
        }
        return noOfComponents;                                                        return noOfComponents;
      }

        //OVERRIDE
        public int graphDirUndirConnectedComponentsCount(int[][] edges, int n){
          int[][] edges = graphDeconstructI(graphArr,n)       --initialise edges; our fn requires edges but we may be given graphArr so deconstruuct graphArr to edges
                                                                (look in graphDeconstructI())

          return graphDirUndirConnectedComponentsCount(edges,n);
        
        }   




    Time:O(E*4alpha): Iterate through E edges(E) and perform union find(4alpha)
    Space:O(N)      :For parent , rank , mst arrays  
 
        

        
    }
      */

  }
    public void graphDirAcyclicTopologicalSort(int[][] edges , int n){
      /*
      5            4    --Given a directed acyclic graph 
      |\          / |     topological sort is linear order of graph  such that for node u,v u appears before v and there can be multiple topological sort orders 
      | \-->0 <--/  |     Eg:5,4,2,3,1,0 is valid topological sort
      *             *        4,5,2,3,1,0 is valid topological sort
      2             1
      \             *
      \--->3------/
      * is arrow
      
      */
      
      //DFS RECURSIVE
      /*
      public List<Integer> graphDirAcyclicTopologicalSort(Map<Integer,List<Integer>> graphMap, boolean[] visited,Stack<Integer> topoStack, int n){ 
        for(int i=0 ; i <= n-1;i++){                           --perform DFS on every node if not visited(Graph may be disconnected hence we perform DFS on every node)
            if(!visited[i]){
                DFSRecursive(graphMap,visited,topoStack,i);
            }
        }  

        List<Integer>  topoList = new ArrayList<>();                                  --topoStack contains topologoical sort
        for(int i=0 ; i <= topoStack.size()-1;i++){topoList.add(topoStack.pop())}
        return topoList;
      } 
      public void DFSRecursive(Map<Integer,List<Integer>> graphMap,boolean[] visited,Stack<Integer> topoStack, int node){
                                                                    --while moving through neighbourNode nodes 
        visited[node] = true;                                          mark node as visited
            
        for(int neighbourNode:graphMap.get(node)){                   --while moving through neighbourNode nodes 
          if(!visited[neighbourNode]){                                if neighbourNode is not  visited  
            DFSRecursive(graphMap,visited,topoStack,neighbourNode);        call fn on neighBourNode recursively
          }
        }    
                                                                    --while returning to node
        topoStack.push(node);                                          push the node to stack
                                                                      bcause while performing DFS we encounter connected nodes in order means we encounter node u before node v
                                                                      so while returning we encounter node v then node u which we add to stack 
                                                                      so stack will v,u
                                                                      so at the end stack will have nodes in topological sort order 

                                                                                    
      }


      //OVERRIDE
      public List<Integer>  graphDirAcyclicTopologicalSort(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n] 
          Stack<Integer> topoStack = new Stack<>();      
          return graphDirAcyclicTopologicalSort(graphMap, visited,topoStack,n);
      
      }   
    
      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N + N+E +  N) --recursion stack +  graphMap(N+E) , visited arr and stack(N) 
            
    */


      //DFS ITERATIVE
      /*
        Backtracking makes it difficult to implement DFS iterative 
      
      */

      //BFS ITERATIVE(KAHNS ALGORITHM)
      /*
      Backtracking makes it difficult to implement BFS iterative; but we can do BFS with Kahns algo


      public void graphDirAcyclicTopologicalSort(Map<Integer,List<Integer>> graphMap,boolean[] visited,List<Integer> topoList, int n){
        BFSIterative(graphMap,visited,topoList,0,n);  -->perform DFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node) 
                                                         But we go through every node in BFSIterative so no need to perform BFSIterative in every node
      }

    
      public void BFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited,List<Integer> topoList, int node,int n){
        int indegree[] = new int[n];                               -->Go through every node 
        for(int i = 0;i<=n-1;i++) {                                  calculate indegree(no of incoming edges) of ever node
            for(int neighBourNode: graphArr.get(i)) {                by going to neighbour and increasing their indegree count 
                indegree[neighBourNode]++; 
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();               -->Go to every node  
        for(int i = 0;i<=n-1;i++) {                                 push all nodes with indegree 0 to queue
            if(indegree[i] == 0) {
                queue.add(i); 
            }
        }
        
        while(!queue.isEmpty()) {                              -> while queue is not empty
            node = queue.remove();                                 pop node from queue
            topoList.add(node);                                   add node to topoArr 

            xx                                                     do not check visited node as we go through every node above while loop

            for(int neighBourNode: graphMap.get(node)) {           move through neighbour nodes
                indegree[neighBourNode]--;                            reduce indegree count of neighbour nodes
                if(indegree[neighBourNode] == 0){                     if indegree count is 0 add neighBourNode to queue
                  queue.add(neighBourNode); }                    
            }                                                            
        }                                                                
      }                                                            EXPLANATION OF KAHNS ALGO :
                                                                  1st we add nodes with 0 indegree becsuse node has 0 dependency
                                                                    
                                                                  Then when we go to neighbourNode we reduce indegree of that neighbourNode because we are not considering that parent again as we are doing BFS
                                                                  and while doing so if indegree is 0 add that node to queue because tat node will have 0 dependency 
                                                                  EG:  4-->0<--5  --indegree of 0 is 2
                                                                        0   2   0    when we move from 4 to 0 we reduce indegree 0 
                                                                                      because  we are doing BFS ;so we will now not visit 4 in future so we can remove it
                                                                                      now 0 has only 1 incoming edge from 5
                                                                                      hence we reduce indegree of 0 when we move from 4 




      //OVERRIDE
      public List<Integer> graphDirAcyclicTopologicalSort(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n] 
          List<Integer> topoList = new ArrayList<>();   
          graphDirAcyclicTopologicalSort(graphMap,visited,topoList,n);   
          return topoList;
      
      } 


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E + N) --  graphMap(N+E) , visited arr and stack,queue etc(N) 
      

      
      */
    
    
    }
    public void graphDirCycleDetection(int[][] edges , int n){
      /*
      0--1  3       --give a  directed graph 
      |  |  |         find if cycle exists or not
      |  |  |          Eg:In this case cycle exists so return true
      --2   4
      
      edges: [[0,1],[1,2],[3,4]]
      n = 5

      
      */
      
      //DFS RECURSIVE
      /*
      public boolean graphDirCycleDetection(Map<Integer,List<Integer>> graphMap,boolean[] visited,boolean[] visitedPath, int n){
        for(int i = 0;i<= n-1;i++) {                                  --perform DFS on every node if not visited(Graph may be disconnected hence we perform DFS on every node)
            if(!visited[i]) {                                           if DFS on any node returns true return true
                if(DFSRecursive(graphArr,visited,visitedPath,i))
                  return true; 
            }
        }
        return false;                                                   if DFS on all nodes doesnt return anything then return false
      }

      public boolean DFSRecursive(ArrayList<ArrayList<Integer>> graphArr,boolean[] visited,boolean[] visitedPath , int node) {
          visited[node] = true;                                            --while moving through neighbourNode nodes 
          visitedPath[node] = true                                              mark node as visited
                                                                                add node in visited path 

          for(int neighborNode: graphArr.get(node)) {                       --while moving through neighbourNode nodes 
              if(!visited[neighborNode]) {                                    if neighbourNode is not  visited            
                if(DFSRecursive(graphArr,visited,neighborNode,node) == true)     call fn on neighBourNode recursively and if it returns true
                  return true;                                                    return true  
              }
              else if(visited[neighborNode] && visitedPath[neighborNode]){    else if neighbournode is visited and neighBourNode is in visited path
                return true;                                                       return true 
              }
          }
          visitedPath[node] = false;                                         --while returning to node
                                                                              remove node from visited path 
          return false;                                                       return false
      }

      //OVERRIDE
      public boolean graphDirCycleDetection(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[graphArr.size()];
          boolean[] visitedPath = new boolean[n]  ;     
          return graphDirCycleDetection(graphArr, visited,visitedPath,n);
      
      }   


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N + N+E +  N) --recursion stack +  graphMap(N+E) , visited arr and queue(N) 


      
      */

      //DFS RECURSIVE;DFS ITERATIVE;BFS ITERATIVE(Topological sort)
      /*
      public void graphDirCycleDetection(int[][] edgs , int n){
        List<Integer> topoList = graphDirAcyclicTopologicalSort(edges,n);
        return topoList.size() != n      --> For graph to bedirected  cyclic;topological sort should not be completed(topological sort is possible only for directed acyclic graph
      }
          
      Time:Time req for topological sort 
      Space:Space req for topological sort 
      
      */
    }  
    public void graphUnDirCycleDetection(int[][] edges , int n){
        /*
      0--1  3       --give a undirected graph 
      |  |  |         find if cycle exists or not
      |  |  |          Eg:In this case cycle exists so return true
      --2   4
      edges: [[0,1],[1,2],[3,4]]
      n = 5
      
      */
      
      //DFS RECURSIVE
      /*
      public boolean graphUnDirCycleDetection(Map<Integer,List<Integer>> graphMap,boolean[] visited, int n){
        for(int i = 0;i<= n-1;i++) {                                  --perform DFS on every node if not visited(Graph may be disconnected hence we perform DFS on every node)
            if(!visited[i]) {                                           and if DFS returns true return trie
                if(DFSRecursive(graphArr,visited,i, -1))
                  return true; 
            }
        }
        return false;                                                   return false
      }

      public boolean DFSRecursive(Map<Integer,List<Integer>> graphMap,boolean[] visited,int node, int parentNode) {
          visited[node] = true;                                            --while moving through neighbourNode nodes 
                                                                              mark node as visited

          for(int neighborNode: graphArr.get(node)) {                       --while moving through neighbourNode nodes 
              if(!visited[neighborNode]) {                                    if neighbourNode is not  visited            
                if(DFS(graphArr,visited,neighborNode,node) == true)              call fn on neighBourNode recursively and if it returns true
                  return true;                                                        return true  
              }
              else if(visited[neighborNode] && neighborNode!=parentNode){    else if neighbournode is visited and neighBourNode is not parentode 
                return true;                                                         return true 
              }
          }
                                                                                --while returning to node
          return false;                                                           return false
      }

      //OVERRIDE
      public int graphUnDirCycleDetection(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n];       
          return graphUnDirCycleDetection(graphArr, visited,n);
      
      }   


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N + N+E +  N) --recursion stack +  graphMap(N+E) , visited arr


      
      */

      //DFS ITERATIVE
      /*
      public boolean graphUnDirCycleDetection(Map<Integer,List<Integer>> graphMap,boolean[] visited, int n){
        for(int i = 0;i<= n-1;i++) {                                  --perform DFS on every node if not visited(Graph may be disconnected hence we perform DFS on every node)
            if(!visited[i]) {                                           and if DFS returns true return true
                if(DFSIterative(graphArr,visited,i, -1))
                  return true; 
            }
        }
        return false;                                                   return false
      }

      public boolean DFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited,int node, int parentNode) {
        Stack<int[]> stack =  new Stack<>(); 
        stack.add(new int[]{node, -1});                                       --push 1st node and parentNode to stack
 
        while(!stack.isEmpty()){                                               --while(!stack.isEmpty())
          int[] nodee= stack.pop();                                               pop node from stack
          node = nodee[0];
          parentNode = nodee[1];

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                    add popped node to visited
                    
          List<Integer> neighbourNodes =  graphMap.get(node);                       move through neighbour nodes in REVERSE order
          for(int i = neighbourNodes.size()-1;i>=0;i--){                             if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                                push neighBourNode to stack
              if(!visited[node]){                                                    else if neighbour nodew is visited and neighBourNode is not parentode
                  stack.push(node);                                                     return true
              else if(visited[neighBourNode]&& parentNode != neighBourNode) {
                  return true;
              
          }

          return false                                                            return false
      }

      //OVERRIDE
      public int graphUnDirCycleDetection(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n];       
          return graphUnDirCycleDetection(graphArr, visited,n);
      
      }   

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr and stack(N) 
      
      */

      //BFS ITERATIVE
      /*
      public boolean graphUnDirCycleDetection(Map<Integer,List<Integer>> graphMap,boolean[] visited, int n){
        for(int i = 0;i<= n-1;i++) {                                  --perform BFS on every node if not visited(Graph may be disconnected hence we perform DFS on every node)
            if(!visited[i]) {                                           and if DFS returns true return true
                if(BFSIterative(graphArr,visited,i, -1))
                  return true; 
            }
        }
        return false;                                                   return false
      }

      public boolean BFSIterative(Map<Integer,List<Integer>> graphMap,boolean[] visited,int node, int parentNode) {
        Queue<int[]> stack =  new ArrayDeque<>(); 
        queue.add(new int[]{node, -1});                                       --push 1st node and parentNode to queue
 
        while(!queue.isEmpty()){                                               --while(!queue.isEmpty())
          int[] nodee= queue.remove();                                           pop node from queue
          node = nodee[0];
          parentNode = nodee[1];

          if(visited[node]){continue;}                                            if popped node is visited continue          
          visited[node] = true;                                                   add popped node to visited
                    
          List<Integer> neighbourNodes =  graphMap.get(node);                     move through neighbour nodes 
          for(int i =0;i <= neighbourNodes.size()-1;i++){                           if neighBourNode is not visited
              int neighbourNode = neighbourNodes.get(i);                                 push neighBourNode to queue
              if(!visited[node]){                                                    else if neighbour nodew is visited and neighBourNode is not parentode
                  queue.add(node);                                                     return true
              else if(visited[neighBourNode]&& parentNode != neighBourNode) {
                  return true;
              
          }

          return false                                                            return false
      }

      //OVERRIDE
      public int graphUnDirCycleDetection(int[][] edges , int n){
          Map<Integer,List<Integer>> graphMap = new HashMap<>();      --initialise graphArr,graphMap, visited
          List<List<Integer>> graphArr = new ArrayList<>();             (look in graphConstructI())
          boolean[] visited = new boolean[n];       
          return graphUnDirCycleDetection(graphArr, visited,n);
      
      }   

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr and queue(N) 
      
      */
    
      //UNION FIND -->Only for Undirected graph as union find works for undirected graph only
      /*
      public void graphUnDirCycleDetection(int[][] edges , int n){                                           
        UnionFind  uf = new UnionFind();                                          
        int[] parent = new int[n];                                                --> parent array stores node and their parent ;initially all nodes are their own parents
        int[] rank = new rank[n];                                                   rank array stores rank of the node;initialise by 0                                           
        uf.makeSet(parent,rank,n);  
                                  
        for(int[] edge:edges){                                                    -->iterate through edges     
            int u= edge[0];                                                           if parent of u != parent v 
            int v = edge[1];                                                             find union of u,v     
            if(uf.findParent(u,parent,rank,n) != uf.findParent(v,parent,rank,n))      else if  parent of u != parent v  
                 uf.union(u,v,parent,rank,n);                                             return true as cycle is found
            else  if(uf.findParent(u,parent,rank,n) == uf.findParent(v,parent,rank,n)){
               return true;  
        }
        return false;                                                               return false if we dont return true and break;
      }

      //OVERRIDE
      public void graphUnDirCycleDetection(int[][] edges , int n){
        int[][] edges = graphDeconstructI(graphArr,n)       --initialise edges; our fn requires edges but we may be given graphArr so deconstruuct graphArr to edges
        return graphUnDirCycleDetection(edges,n)             (look in graphDeconstructI())
      }

      Time:O(E*4alpha): Iterate through E edges(E) and perform union find(4alpha)
      Space:O(N)      :For parent,rank etc arrays  
 
      
      */
    
    
    }  
    public void graphCourseSchedule(int[][] edges , int n){
      /*
      0-->1         --prerequisites [ai,bi] show that to take course ai you should complete bi 
      |   |           to take course 1 you should finish course 0 and to take course 2 you shuld finish course 1 
      |   *           find if courses can be taken 
      --->2   
      
      prereq: [[1,0],[2,1],[3,4]]
      numOfCourses = 5
      */
      
      //DFS RECURSIVE;DFS ITERATIVE;BFS ITERATIVE(Topological sort)
      /*
      public boolean graphCourseSchedule(int[][] edgs , int n){
        List<Integer> topoList = graphDirAcyclicTopologicalSort(edges,n);
        return topoList.size() == n      --> For completing courses graph must be directed acyclic 
                                             For graph to be directed acyclic;topological sort should be complete(topological sort is possible only for directed acyclic graph)
                                             NOTE:While constructing graph
                                                  Instead of graphArr.get(edge[0]).add(edge[1]) do graphArr.get(edge[1]).add(edge[0])
                                                  because to take course ai ypu must complete bi so graph will be bi-->ai
      }
          
      Time:Time req for topological sort 
      Space:Space req for topological sort 
      
      */

 
    

    }
    public void graphCourseScheduleII(int[][] edges , int n){
      /*
      0-->1         --prerequisites [ai,bi] show that to take course ai you should complete bi 
      |   |           to take course 1 you should finish course 0 and to take course 2 you shuld finish course 1 
      |   *           find the order in which courses must be taken and if they cant be taken return empty arr
      --->2   
      
      prereq: [[1,0],[2,1],[3,4]]
      numOfCourses = 5
      */
      
      //DFS RECURSIVE;DFS ITERATIVE;BFS ITERATIVE(Topological sort)
      /*
      public List<Integer> graphCourseScheduleII(int[][] edgs , int n){
        List<Integer> topoList = graphDirAcyclicTopologicalSort(edges,n);
        if(topoList.size() == n)       --> For completing courses graph must be directed acyclic 
          return topoList}                 For graph to be directed acyclic;topological sort should be complete(topological sort is possible only for directed acyclic graph)
        else                               NOTE:While constructing graph
            return new ArrayList<>();           Instead of graphArr.get(edge[0]).add(edge[1]) do graphArr.get(edge[1]).add(edge[0])
                                                because to take course ai ypu must complete bi so graph will be bi-->ai
      }
          
      Time:Time req for topological sort 
      Space:Space req for topological sort 
      
      */
    }
    public void graphDirAcyclicShortestLongestPath(int[][] edges ,int startNode,int n){
      /*
       2    3  6
      0-->1-->2-->3    --Given a directed acyclic graph with weight( weight is cost to reach that node from previous Node)and a startNode 
      \      *    *      find the shortest path from given startNode to every other Node in graph
       \    /    / 1
        \->4-->5
          2  4
      [[<1,2>,<4,2>], [<2,3>,<0,0>,<4,2>] , ..]
  
      }
      */

      //BFS ITRRATIVE
      /*

      public void graphDirAcycliShortestLongestPath(List<List<Node>> graphArr,int[] dist,int startNode,int n){
          BFSIterative(graphArr,visited,dist,startNode,n); -- perform BFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                               but we must start from given startNode and hence cant perform BFS on every node
      }
      

      public void BFSIterative(List<List<Node>> graphArr,boolean[] visited,int[] dist, int startNode,int n){

                               
        Stack<Integer> topoStack = new Stack<>();                                
        graphDirAcyclicTopologicalSort(graphArr, visited, topoStack,startNode); -->-Find the topological sort for the graph
                                                                                   (Note: Instead of integer we have Node
                                                                                    DFSRecursiv(),DFSIterative,BFSIterative() fns: instead of   if(!visited[neighbourNode]){ DFSRecursive(..,neighbourNode,...)} use if(!visited[neighbourNode.getVal()]){ DFSRecursive(neighbourNode.getVal(),...)}
                                                                                    graphDirAcyclicTopologicalSort():instead of parameter List<List<Integer>> graphArr use List<List<Node>> graphArr


                                                                                 --> Create a distance arr which stores distance from start node to any node
        for (int i = 0; i <=n-1; i++)                                                fill it with max/min(for shortest/longest distance) value 
            dist[i] = Integer.MAX_VALUE OR Integer.MIN_VALUE;                        initialise distance of startNode with 0 as you start from this node
        dist[startNode] = 0;

        while (!stack.empty()){                                                     -->while stack is not empty
            int node = (int)stack.pop();                                                pop node from stack 

            xx                                                                          do not check visited node as we go through every node above while loop

          
          for(Node neighBourNode: graphArr.get(startNode)) {                      move through neighbour nodes in STRAIGHT  order
            if (dist[node] != Integer.MAX_VALUE OR Integer.MIN_VALUE){                  if dist of node is not max/min (for shortest/longest paths) means we have reached that node 
                    if(dist[node] + neighBourNode.getWeight() < OR >                        if dist of current node(cost req to reach from start to current node) + weight of neighbourNode(cost req to reach from current to neighbour node) 
                       dist[neighBourNode.getVal()]) {                                      is  </>(shortest/longest) dist of neighbournode(cost req to reach from start to current node)
                        dist[neighBourNode.getval()] = dist[node] + neighBourNode.getWeight();   update the distance of neighbour node = current node + weight of neighbour node   
                    }
            }
          }
        }

        for (int i = 0; i <= dist.length()-1; i++){                              -- dist arr ka index i will hold the shortest/longest dist to reach from startNode to node_i     
            if (dist[i] == Integer.MAX_VALUE OR Integer.MIN_VALUE)                  if dist[i] = max/min(for shortest/longest) 
                dist[i] = -1;                                                           means we cant reach from startNode to node_i hence -1
            else                                                                     else
                dist[i] = dist[i];                                                        means we can reach from startNode to node_i 
        }
    }

     //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

     public void graphDirAcyclicShortestLongestPath(int[][] edge ,int startNode,int n){
          Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visited
          List<List<Node>> graphArr = graphMap             (look in graphConstructII() )
          boolean[] visited = new boolean[n];
          int[] dist = new dist[n];  
          graphDirAcyclicShortestLongestPath(graphArr,visited,diststartNode,n);   
          return dist;
      }


      

      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr,stack etc(N)


      */
    
    


    }
    public void graphUnDirShortestLongestPath(int[][] edges , int n){
      /*
       2    3  6
      0--1---2---3    --Given a undirected  graph with weight( weight is cost to reach that node from previous Node)and a startNode 
      \      /   /      find the shortest path from given startNode to every other Node in graph
       \    /   / 1
        \->4-->5
          2  4

       [[<1,2>,<4,2>], [<2,3>,<0,0>,<4,2>] , ..]
      */


      //BFS ITRRATIVE             -->For unweighted graph ie weights = 1
      /*
      public void graphUnDirShortestLongestPath(List<List<Integer>> graphArr,boolean[] visited, int[] dist,int startNode,int n){
          BFSIterative(graphArr,visited,dist,startNode,n); -- perform BFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                               but we must start from given startNode and hence cant perform BFS on every node
      }
      public void BFSIterative(List<List<Integer>> graphArr,boolean[] visited, int[] dist, int startNode,int n){

                                                                                --> dist arr which stores distance from start node to any node
        for (int i = 0; i <=n-1; i++)                                                fill it with max/min(for shortest/longest distance) value 
            dist[i] = Integer.MAX_VALUE OR Integer.MIN_VALUE;                        initialise distance of startNode with 0 as you start from this node
        dist[startNode] = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();                             -->add startNode to queue
        q.add(startNode); 

        while(!queue.isEmpty()) {                                             -->while queue is not empty
          int node = queue.remove();                                             remove node from queue
          
          xx                                                                      do not check visited node as we go through every node above while loop
          
          for(int neighbourNode:graphArr.get(node)){                             move through neighbour nodes in STRAIGHT  order
            if (dist[node] != Integer.MAX_VALUE OR Integer.MIN_VALUE){             if dist of node is not max/min (for shortest/longest paths) to avoid overflow 
              if(dist[node] + 1 < OR > dist[neighbourNode]){                         if dist of current node(cost req to reach from start to current node) + weight of neighbourNode =1(cost req to reach from current to neighbour node)    
                                                                                     is  </>(shortest/longest) dist of neighbournode(cost req to reach from start to neighbour node)          
                  dist[neighbourNode] = dist[node] + 1;                              update the distance of neighbour node = current node + weight of neighbour node =1
                  
                  queue.add(neighbourNode);                                       add neighbour node to queue
              }
            }
          } 
        }
        
        for (int i = 0; i <= dist.length()-1; i++){                              -- dist arr ka index i will hold the shortest/longest dist to reach from startNode to node_i     
            if (dist[i] == Integer.MAX_VALUE OR Integer.MIN_VALUE)                  if dist[i] = max/min(for shortest/longest) 
                dist[i] = -1;                                                           means we cant reach from startNode to node_i hence -1
            else                                                                     else
                dist[i] = dist[i];                                                        means we can reach from startNode to node_i 
        }

      }

      //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }
      public void graphUnDirShortestLongestPath(int[][] edge,int startNode,int n){
          Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visited
          List<List<Node>> graphArr = graphMap             (look in graphConstructII()  for edges with weigtht)
          boolean[] visited = new boolean[n];
          int[] dist = new dist[n];  
          graphUnDirShortestLongestPath(graphArr,visited,dist,startNode,n);   
          return dist;
      }



      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr,stack etc(N)


      */
    
      //BFS ITERATIVE(Dijkshtras)  -->For +ve weighted graph ie weights >=0 
      /*
      public void graphUnDirShortestLongestPath(List<List<Node>> graphArr,boolean[] visited, int[] dist,int startNode,int n){
          BFSIterative(graphArr,visited,dist,startNode,n); -- perform BFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                               but we must start from given startNode and hence cant perform BFS on every node
      }
      public void BFSIterative(List<List<Integer>> graphArr,boolean[] visited, int[] dist, int startNode,int n){

                                                                                --> dist arr stores distance from start node to any node
        for (int i = 0; i <=n-1; i++)                                                fill it with max/min(for shortest/longest distance) value 
            dist[i] = Integer.MAX_VALUE OR Integer.MIN_VALUE;                        initialise distance of startNode with 0 as you start from this node
        dist[startNode] = 0;
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>(                       -->add  the elements to min heap in asc order of weights of node(so that min element at front can be popped) 
            (Node n1,Node n2) -> {return n1.getWeight() - n2.getWeight()}           (for shortest distance)
        ); 
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(                           add  the elements to max heap in desc order of weights of node(so that max element at front can be popped)
            (Node n1,Node n2) -> {return n2.getWeight() - n1.getWeight()}            (For longest distance)
        );                  
                                                                         
        minHeap.add(new Node(startNode,0));                                         -->add startNode with distance 0  to minheap

        while(!minHeap.isEmpty()) {                                                -->while minHeap is not empty
          Node node = minHeap.remove();                                                   remove node from minHeap
          
          xx                                                                              do not check visited node as we go through every node above while loop
          
          for(int neighbourNode:graphArr.get(node.getVal())){                             move through neighbour nodes in STRAIGHT  order
            if (dist[node.getVal()] != Integer.MAX_VALUE OR Integer.MIN_VALUE){            if dist of node is not max/min (for shortest/longest paths) to avoid overflow 
              if(dist[node.getVal()] + neighBourNode.getWeight() < OR >                         if dist of current node(cost req to reach from start to current node) + weight of neighbourNode(cost req to reach from current to neighbour node) 
                dist[neighBourNode.getVal()]) {                                                 is  </>(shortest/longest) dist of neighbournode(cost req to reach from start to current node)
                dist[neighBourNode.getval()] = dist[node.getval()] + neighBourNode.getWeight(); update the distance of neighbour node = current node + weight of neighbour node                                                    
                minHeap.add(new Node(neighbourNode,dist[neighBourNode]));                       add neighbour with distance to minHeap
              }
          } 
        }
        
        for (int i = 0; i <= dist.length()-1; i++){                              -- dist arr ka index i will hold the shortest/longest dist to reach from startNode to node_i     
            if (dist[i] == Integer.MAX_VALUE OR Integer.MIN_VALUE)                  if dist[i] = max/min(for shortest/longest) 
                dist[i] = -1;                                                           means we cant reach from startNode to node_i hence -1
            else                                                                     else
                dist[i] = dist[i];                                                        means we can reach from startNode to node_i 
        }

      }

      //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

     public void graphUnDirShortestLongestPath(int[][] edge,int startNode,int n){
          Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visited
          List<List<Node>> graphArr = graphMap             (look in graphConstructII()  for edges with weigt))
          boolean[] visited = new boolean[n];
          int[] dist = new dist[n];  
          graphUnDirShortestLongestPath(graphArr,visited,diststartNode,n);   
          return dist;
      }



      Time:O((N+E)*log(n)) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                              but  the visited array doesn allow to visit same node again
                              amd you are also inserting each node in Priority queue(log(n))
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr,queue,priority queue etc(N)


      */
    
      //BFS ITERATIVE(Bellman Ford) -->For weighted graph ie weight = anything 
      //                            -->For positive weight cycle graph ie the sum of a cycle in graph must be positive
      /*
      
      public boolean graphUnDirShortestLongestPath(int[][] edges,int[] visited, int[] dist, int startNode, int n){
        BFSIterative(edges,visited,dist,startNode,n); -- perform BFS on every node if not visitesd(Graph may be multiple components and DFS traverses only one component ;hence we perform DFS on every node)
                                                         but we must start from given startNode and hence cant perform BFS on every node
      }
    
      public void BFSIterative(int[][] edges,int[] visited, int[] dist, int startNode, int n){

                                                                               
        for (int i = 0; i <=n-1; i++)                                   --> dist arr  stores distance from start node to any node      
            dist[i] = Integer.MAX_VALUE OR Integer.MIN_VALUE;               fill it with max/min(for shortest/longest distance) value       
        dist[startNode] = 0;                                                initialise distance of startNode with 0 as you start from this node

        for(int i = 1;i<=n-1;i++) {                                    -->Do relaxation of edges n-1 times   
          for(int[] edge: edges) {                                       iterate through edges
            int u = edge[0];int v = edge[1];int weight = edge[2];        u is currentNode, v is neighBourNode , weight is cost to reach v from startNode
            if(dist[u] != Integer.MAX_VALUE OR Integer.MIN_VALUE){       if dist of curren node is not max/min (for shortest/longest paths) to avoid overflow 
              if(dist[u] + weight                                          if dist of current node(cost req to reach from start to current node) + weight of neighbourNode(cost req to reach from current to neighbour node) 
              < OR > dist[v]) {                                            is  </>(shortest/longest) dist of neighbournode(cost req to reach from start to current node)
                dist[v] = dist[u] + weight;                                update the distance of neighbour node = current node + weight of neighbour node                                                    
              }                                                          EXPLANATION:
            }                                                            Consider 5 straignt nodes 
          }                                                              a-->b-->c-->d-->e Edges[[d,e,wt],[c,d,wt],[b,c,wt],[a,b,wt]]
        }                                                                1st relaxation
                                                                         edge d,e-->dist[e] not updated as dist[d] is infinity 
                                                                         edge c,d-->dist[d] not updated as dist[c] is infinity 
    	                                                                   edge b,c-->dist[c] not updated as dist[b] is infinity
                                                                         edge a,b-->dist[b] updated as dist[a] is 0
                                                                         
                                                                         2nd relaxation. 3rd relaxation,4th relaxation
                                                                         dist[c] updated,dist[d],dist[e] updated

                                                                         So in n-1 relaxation will relax n-1 node and 0th node is already relaxed 
                                                                         so all n nodes are relaxed ;
                                                                        
                                                                         We can extend this to any graph not only straight graph
                                                                         because longest path we can take is of n nodes and
                                                                         we have relaxed al nodes along that path
                                                    

                                                                         


        boolean isNegativeWeihtCycle = false;                        -->Find isNegativeWeihtCycle by relaxing egdes 1 more time
        for(int[] edge: edges) {                                       iterate through edges
            int u = edge[0];int v = edge[1];int weight = edge[2];        u is currentNode, v is neighBourNode , weight is cost to reach v from startNode
            if(dist[u] != Integer.MAX_VALUE OR Integer.MIN_VALUE){       if dist of curren node is not max/min (for shortest/longest paths) to avoid overflow 
              if(dist[u] + weight                                          if dist of current node(cost req to reach from start to current node) + weight of neighbourNode(cost req to reach from current to neighbour node) 
              < OR > dist[v]) {                                            is  </>(shortest/longest) dist of neighbournode(cost req to reach from start to current node)
                isNegativeWeihtCycle = true;                                  then it is a negative weight cyccle
                break;                                                  Explanation:
              }                                                         After relaxing edges n-1 times n edges must be relaxed
                                                                        if we relax edge again and the distance is still reducing means there is negatove edge
            } 
    	  }
                                                                     -->Based on isNegativeWeihtCycle fill dist arr
        if(!isNegativeWeihtCycle){                                     if it is not a negative weight cycle means finding distance is possible
          for (int i = 0; i <= dist.length()-1; i++){                     dist arr ka index i will hold the shortest/longest dist to reach from startNode to node_i     
              if (dist[i] == Integer.MAX_VALUE OR Integer.MIN_VALUE)      if dist[i] = max/min(for shortest/longest) 
                  dist[i] = -1;                                               means we cant reach from startNode to node_i hence -1
              else                                                        else
                  dist[i] = dist[i];                                          means we can reach from startNode to node_i 
          }
        }
        else{                                                          else findin distance is not possible
            for(int i=0 ; i <= n-1;i++){                                   so fill dist arr witj -1
                dist[i] = -1;
            }
        }
      }
    
      //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

     public int[] graphUnDirShortestLongestPath(int[][] edge,int startNode,int n){
        int[][] edges = graphDeconstructI(graphArr,n)       --initialise edges; our fn requires edges but we may be given graphArr so deconstruuct graphArr to edges
        boolean[] visited = new boolean[n];                   (look in graphDeconstructII())
        int[] dist = new dist[n];  
        graphUnDirShortestLongestPath(edge,visited,dists,tartNode,n);  --if startNode not given take it as 0   
        return dist;
      }

      Time:O(N*E)         -- for N-1 times you traverse all edges  in matrix E
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr,queue,priority queue etc(N)
    
      
      
      */
    


    }
    public void graphUndirisBipirtite(int[][] edges){

      /*

      0-----1----2----3----4--6--7  --> Given an undirected graph
            \___5__________/            check if it bipirtite or not
                                        Bipirtite graph is a graph in which nodes can be seperated on 2 sets such that
                                        no 2 nodes within the same sets are adjacent
                                        OR 
                                        Bipirate graph is a graph in which we can colour the adjacent nodes with opposite
                                        colour
                                        Eg: graphArr = [[1,2,3],[0,2],[0,1,3],[0,2]] is a bipirtite graph
                                            graphArr = [[1,3],[0,2],[1,3],[0,2]] is not bipirtite graph

      
      */

      //DFS RECURSIVE
      /*
      public boolean graphUndirisBipirtite(List<List<Integer>> graphArr,int[] visitedGroup, int n){
        for(int i = 0;i<=n-1;i++) {
        	if(visitedGroup[i] == -1) {                                   --perform DFS on every node if not visitedGroup(Graph may be disconnected hence we perform DFS on every node)
        		if(!DFSRecursive(graphArr,visitedGroup ,i)) {                 if DFS on any node returns false return false 
        			return false; 
        		}
        	}
        }
        return true;                                                      if DFS on all nodes doesnt return anything then return true
      }
      
      public boolean DFSRecursive(List<List<Integer>> graphArr,int[] visitedGroup, int node) {  
                                                                       --while moving through neighbourNode nodes 
        xxx                                                              dont mark node as visited as you will mark neighBourNode as visited based on node
                                                           
                                                                   
        for(int neighBourNode: graphArr.get(node)) {                   --while moving through neighbourNode nodes 
          if(visitedGroup[neighBourNode] == -1) {                          if neighbourNode is not  visited 
            visitedGroup[neighBourNode] = 1 - visitedGroup[node] ;             add neighBourNode in visited by toggling the value of node
                    
            if(!DFSRecursive(graphArr, visitedGroup, neighBourNode) )          call fn on neighBourNode recursively and if it returns false 
              return false;                                                    return false
          }
          else if(visitedGroup[neighBourNode] != -1 &&                   else if neighbourNode is visited &&  node and neighBourNode have same values
                  visitedGroup[node] == visitedGroup[neighBourNode]) {      return false
            return false; 
          }
        }
        return true;                                                   return true
      }

      //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

      public boolean graphUndirisBipirtite(int[][] edge,int n){
        Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, initialise visited by -1
        List<List<Node>> graphArr = graphMap             (look in graphConstructII())
        boolean[] visitedGroup = new boolean[n];           
        for(int i=0;i <= visitedGroup.length-1;i++){visitedGroup[i] = -1;}
        return graphUndirisBipirtite(graphArr,visitedGroup,n);   
   
      }


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N + N+E +  N) --recursion stack +  graphMap(N+E) , visited arr(N) 
      
      */

      //DFS ITERATIVE
      /*
      public boolean graphUndirisBipirtite(List<List<Integer>> graphArr,int[] visitedGroup, int n){
        for(int i = 0;i<=n-1;i++) {
        	if(visitedGroup[i] == -1) {                                   --perform DFS on every node if not visitedGroup(Graph may be disconnected hence we perform DFS on every node)
        		if(!DFSIterative(graphArr,visitedGroup ,i)) {                 if DFS on any node returns false return false 
        			return false; 
        		}
        	}
        }
        return true;                                                      if DFS on all nodes doesnt return anything then return true
      }
      
      public boolean DFSIterative(List<List<Integer>> graphArr,int[] visitedGroup, int node){
        Stack<Integer> stack = new Stack<>(); 
        stack.push(node);                                               --push 1st node to stack
 
        while(!stack.isEmpty()){                                         --while(!stack.isEmpty())
            node = stack.pop();                                             pop node from stack
              
            XX                                                              dont mark node as visited as you will mark neighBourNode as visited based on node
            
            List<Integer> neighBourNodes  = graphArr.get(node);             move through neighbour nodes in REVERSE order
            for(int i= neighBourNodes.size()-1;i>=0;i--){                      if neighBourNode is not visited visited                
                int neighBourNode = neighBourNodes.get(i);                         if neighBourNode is visited continue
                if(visitedGroup[neighBourNode] == -1){                             add neighBourNode in visited by toggling the value of node
                    if(visitedGroup[neighBourNode] != -1){continue;}               push neighBourNode to stack 
                    visitedGroup[neighBourNode] = 1- visitedGroup[node];      else if neighBourNode is visited && node and neighBourNode have same values
                    stack.push(neighBourNode);                                  return false
                }
                else if(visitedGroup[neighBourNode] != -1 && visitedGroup[node] == visitedGroup[neighBourNode]){
                    return false;
                }
            } 
        }
        return true;                                                        return true                                  
           
     }
    
      //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

      public boolean graphUndirisBipirtite(int[][] edge,int n){
        Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visited
        List<List<Node>> graphArr = graphMap             (look in graphConstructII(), initialise visited by -1)
        boolean[] visitedGroup = new boolean[n];           
        for(int i=0;i <= visitedGroup.length-1;i++){visitedGroup[i] = -1;}
        return graphUndirisBipirtite(graphArr,visitedGroup,n);   
   
      }


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr and stack(N) 
      
      */

      //BFS ITERATIVE
      /*
      public boolean graphUndirisBipirtite(List<List<Integer>> graphArr,int[] visitedGroup, int n){
        for(int i = 0;i<=n-1;i++) {
        	if(visitedGroup[i] == -1) {                                   --perform BFS on every node if not visitedGroup(Graph may be disconnected hence we perform DFS on every node)
        		if(!BFSIterative(graphArr,visitedGroup ,i)) {                 if DFS on any node returns false return false 
        			return false; 
        		}
        	}
        }
        return true;                                                      if DFS on all nodes doesnt return anything then return true
      }
      
      public boolean BFSIterative(List<List<Integer>> graphArr,int[] visitedGroup, int node){
        Queue<Integer> queue = new ArrayDeque<>(); 
        queue.add(node);                                               --push 1st node to queue
 
        while(!queue.isEmpty()){                                         --while(!queue.isEmpty())
            node = queue.pop();                                             pop node from queue
              
            XX                                                              dont mark node as visited as you will mark neighBourNode as visited based on node
            
            List<Integer> neighBourNodes  = graphArr.get(node);             move through neighbour nodes in STRAIGHT  order
            for(int i= 0;i<=neighBourNodes.size()-1;i++){                      if neighBourNode is not visited visited                
                int neighBourNode = neighBourNodes.get(i);                         if neighBourNode is visited continue
                if(visitedGroup[neighBourNode] == -1){                             add neighBourNode in visited by toggling the value of node
                    if(visitedGroup[neighBourNode] != -1){continue;}               push neighBourNode to queue 
                    visitedGroup[neighBourNode] = 1- visitedGroup[node];      else if neighBourNode is visited && node and neighBourNode have same values
                    queue.add(neighBourNode);                                      return false
                }
                else if(visitedGroup[neighBourNode] != -1 && visitedGroup[node] == visitedGroup[neighBourNode]){
                    return false;
                }
            } 
        }
        return true;                                                        return true                                  
           
     }
    
      //OVERRIDE
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

      public boolean graphUndirisBipirtite(int[][] edge,int n){
        Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visited
        List<List<Node>> graphArr = graphMap             (look in graphConstructII(), initialise visited by -1)
        boolean[] visitedGroup = new boolean[n];           
        for(int i=0;i <= visitedGroup.length-1;i++){visitedGroup[i] = -1;}
        return graphUndirisBipirtite(graphArr,visitedGroup,n);   
   
      }


      Time:O(N+E) -- you traverse all nodes in matrix (N) and also return to them through edges(E)
                      but  the visited array doesn allow to visit same node again
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr and queue(N) 
      
      */

    }
    public void graphDirUndirMinimumSpanningTree(int[][] edges, int n){
      /*
          2   3 
        0----1---2      --Given a directed/undirected graph with weights(weight is cost to reach that node from previous Node)
      6 | 8 /|5 /7        Convert graph to  minimum spanning tree
        |  / | /          Spanning tree is a tree with n nodes and n-1 edges and all nodes are reachable from one another  
        3    4            Minimum spanning tree is spanning tree with minimum total edge weight
                          Eg:
                          2     3 
                          0----1---2       total weight = 18
                            8 /|5         
                            / |          
                          3    4 

                            2     3 
                          0----1---2       total weight = 18
                        6 |       /7   
                          |      /          
                          3     4 

                            2     3 
                          0----1---2       total weight = 16 -->Minimum spanning tree
                        6 |    | 5   
                          |    |          
                          3    4           
      */

      //BFS ITERATIVE(Prim's algorithm)
      /*

      public int[] graphDirUndirMinimumSpanningTree(ArrayList<ArrayList<Node>> graphArr,boolean[] mst, int[] weight,int[] parent,int n){
          BFSItrative(graphArr,visitedMST,weight,mst,n); -- perform BFS on every node if not visitesd(Graph may be multiple components and BFS traverses only one component ;hence we perform BFS on every node)
          return mst                                         but we iterate through all nodes in BFSiterative()

      }
      
      public void BFSItrative(ArrayList<ArrayList<Node>> graphArr,boolean[] visitedMST, int[] weight,int[] mst, int n){
        for(int i = 0;i<n-1;i++) {                             -->visitedMST stores the visited nodes that we connect in out MST; fill it with false
        	visitedMST[i] = false;                                  weight stores the minimum weight of all the connecting node i ; fill it with Int.MAX_VALUE and weight of node 0 is 0
          weight[i] = 100000000;                                  mst stores the structure of MST; fill it with -1 Eg: mst = [-1,0,1,0,1]  means node 0 ka parent is node -1; node 1 ka parent node 0 and so on
          parent[i] = -1                   
        }
        weight[0] = 0;


        for(int i = 0;i<n-1;i++) {                             -->iterate through all  nodes
        	int minWeight = Integer.MAX_VALUE;                      
          int minWeightNode = 0; 
        	for(int node = 0;node<=weight.length-1;node++) {               -->iterate through  weights of all nodes
        		if(!visitedMST[node] && weight[node] < minWeight) {              if the node is not a part of our MST && weight of node < minWeight
        			minWeight = weight[node];                                        update minWeight
        			minWeightNode = node;                                            update minWeightNode
        		}
        	}
        	visitedMST[minWeightNode] = true;                               -->mark the  minWeightNode as visited as we connect that node in our MST                       

        	for(Node neighbourNode: graphArr.get(minWeightNode)) {          -->iterate through neighBourNodes of minWeightNode
        		if(!visitedMST[neighbourNode.getVal()                             if neighBourNodenode is not a part of our MST && weight of neighBourNodenode < weight at neighBourNodenode
             && neighbourNode.getWeight() < weight[neighbourNode.getVal()]) {    update neighBourNode ka to minWeightNode
        			mst[neighbourNode.getVal()] = minWeightNode;                       update weight at neighbourNode to neighBourNode ka weight
        			weight[neighbourNode.getVal()] = neighbourNode.getWeight(); 
        		}
        	}
        }     
                    
                                                                                EXPLANATION
                                                                                Consider the example in question
                                                                                1.Find the min weight of all egdes connected to node 0 and and which are not yet  a part of our MST  
                                                                                  2       
                                                                                0----1
                                                                                2.Find the min weight of all egdes connected to node 0,node 1 and which are not yet  a part of our MST    
                                                                                  2     3 
                                                                                0----1---3
                                                                                3.Find the min weight of all egdes connected to node 0,node 1,node 3 and which are not yet  a part of our MST  
                                                                                  2     3 
                                                                                0----1---3
                                                                                      | 5
                                                                                      |
                                                                                      4
                                                                                4.Find the min weight of all egdes connected to node 0,node 1,node 3, node 4 and which are not yet  a part of our MST  
                                                                                  2     3 
                                                                                0----1---3
                                                                              6 |    | 5
                                                                                |    |
                                                                                3    4

                                                            
      }

      //OVERLOAD
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

      public int[] graphDirUndirMinimumSpanningTree(int[][] edges,  int n){
        Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visitedMST,weight,parent
        List<List<Node>> graphArr = graphMap             (look in graphConstructII()  for edges with weigt))
        boolean[] visitedMST = new boolean[n];
        int[] weight = new weight[n];  
        int[] parent = new weight[n];  
        graphDirUndirMinimumSpanningTree(graphArr,visitedMST,weight,parent,n);   
        return mst;
      }

      Time:O(N^2) -- you traverse all nodes in matrix (N) and again traverse all nodes in matrix (N)  
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr and stack(N) 
      
      
      */

      //BFS ITERATIVE(Prim's algorithm optimised)
      /*
      public int[] graphDirUndirMinimumSpanningTree(ArrayList<ArrayList<Node>> graphArr,boolean[] mst, int[] weight,int[] parent,int n){
        return BFSItrative(graphArr,visitedMST,weight,mst,n); -- perform BFS on every node if not visitesd(Graph may be multiple components and BFS traverses only one component ;hence we perform BFS on every node)
                                                                but we iterate through all nodes in BFSiterative()

      }
      
      public void BFSItrative(ArrayList<ArrayList<Node>> graphArr,boolean[] visitedMST, int[] weight,int[] mst, int n){
        for(int i = 0;i<n-1;i++) {                             -->visitedMST stores the visited nodes that we connect in out MST; fill it with false
        	visitedMST[i] = false;                                  weight stores the minimum weight of all the connecting node i ; fill it with Int.MAX_VALUE and weight of node 0 is 0
          weight[i] = 100000000;                                  mst stores the structure of MST; fill it with -1 Eg: mst = [-1,0,1,0,1]  means node 0 ka parent is node -1; node 1 ka parent node 0 and so on
          parent[i] = -1                                           
        }
        weight[0] = 0;
                                                                                 
      
        PriorityQueue<Node> minHeap = new PriorityQueue<>(                        -->add  the elements to min heap in asc order of weights of node   
            (Node n1,Node n2) -> {return n1.getWeight() - n2.getWeight()}            add node 0 and weight[0]  to minHeap   
        ); 
        minHeap.add(new Node(0,weight[0]));  
        
        for(int i = 0;i<n-1;i++) {                                               -->iterate through all  nodes
          int minWeightNode = minHeap.remove().getValue();                          --> find the minWeightNode by poppint the top element of minHeap  	
          visitedMST[minWeightNode] = true;                                        -->mark the  minWeightNode as visited as we connect that node in our MST                       

        	for(Node neighbourNode: graphArr.get(minWeightNode)) {                  -->iterate through neighBourNodes of minWeightNode
        		if(!visitedMST[neighbourNode.getVal()                                     if neighBourNodenode is not a part of our MST && weight of neighBourNodenode < weight at neighBourNodenode
             && neighbourNode.getWeight() < weight[neighbourNode.getVal()]) {         update neighBourNode ka to minWeightNode
        			mst[neighbourNode.getVal()] = minWeightNode;                            update weight at neighbourNode to neighBourNode ka weight
        			weight[neighbourNode.getVal()] = neighbourNode.getWeight();             add neighBourNode and weight at neighBourNode to minHeap
              minHeap.add(new Node(neighbourNode.getVal(),weight[neighbourNode.getVal()]))
        		}                                                                         (mst will hold node and its parent)
        	}
        }  
        
                                                                                      EXPLANATION
                                                                                      Same as above

                                                            
      }

      //OVERLOAD
      public class Node{
        private int val;
        private int weight;
        public Node(int val, int weight){this.val = val;this.weight = weight;}
        public int getVal(){return this.val;}
        public int getWeight(){return this.weight;}
      }

      public int[] graphDirUndirMinimumSpanningTree(int[][] edges,  int n){
        Map<Node,List<Node>> graphMap = graphMap;      --initialise graphArr,graphMap, visitedMST,weight,parent
        List<List<Node>> graphArr = graphMap             (look in graphConstructII())
        boolean[] visitedMST = new boolean[n];
        int[] weight = new weight[n];  
        int[] parent = new weight[n];  
        graphDirUndirMinimumSpanningTree(graphArr,visitedMST,weight,parent,n);   
        return mst;
      }

      Time:O(N*log(N)) -- you traverse all nodes in matrix (N) and again put in Priority Queue(log n) 
      Space:O(N+E +  N) --  graphMap(N+E) , visited arr and stack(N) 
      
      
      */

      //UNION-FIND(Kruskals Algorithm) -->Only for Undirected graph as union find works for undirected graph only
      /*

      public int[] graphDirUndirMinimumSpanningTree(int[][] edges, int n){
                                                                      1.SORT EDGES ARR  BASED ON WEIGHT
                                                                      ( so that you can pick the edges greedily and union them later)              
        List<List<Integer> edgesArr = new ArrayList<>();              -->convert edge arr to edge list 
        for(int i=0; i <= edges.length-1;i++){                           and sort edge list based on weight
            List<Integer> temp  = new ArrayList<>();                    
            for(int j=0 ; j <= edges[i].length-1;j++){temp.add(edges[i][j]);}
            edgeArr.add(temp);
        }
        Collections.sort(edgeArr, (                                       
            (List<Integer> a , List<Integer> b) ->{                          
                return a.get(2) - b.get(2);
            }
        ));
                                                                           2.FIND UNION OF SORTED EDGES ;STORE THOSE UNION IN MST
                                                                            (initially all nodes are their own parent
                                                                            we are iterating through graph and recreating the graph by joining nodes 
                                                                            but as the edges are sorted we are recreating a graph greedily thus forming a MST)

        UnionFind uf = new UnionFind(); (look in graphUndirUnionFind();) 

        int[] parent = new int[n];                                         --> parent array stores node and their parent ;initially all nodes are their own parents
        int[] rank = new rank[n];                                              rank array stores rank of the node;initialise by 0 
        int[] mst = new int[n];                                                 mst stores the structure of MST; fill it with -1 Eg: mst = [-1,0,1,0,1]  means node 0 ka parent is node -1; node 1 ka parent node 0 and so on    
        uf.makeSet(parent,rank,n);  
        for(int i=0 ; i <=n-1;i++){mst[i] = -1}  

        int costMst = 0;                               
        for(List<Integer> edge : edgeArr){                                  -->iterate through edges and find their union
          int u= edge.get(0); int v = edge.get(1);                              if parent of u != parent v
          int weight = edge.get(2);                                               find union of u,v                  
          if(uf.findParent(u,parent,rank,n)!= uf.findParent(v,parent,rank,n)){    make v as parent of u in our mst 
            uf.union(u,v,parent,rank);                                            increment cost of mst by adding weight
            mst[u] = v;
            costMst += weight;                                           
          }                                                              
        }    
        return mst                                                   --return mst                                                               
      }                                                                                                                                        
                                                                      EXPLANATION:
                                                                      Consider the following graph
                                                                            5
                                                                        4------3-----\
                                                                      9/| \     |     \8
                                                                      / |  \    |      \
                                                                     5 1|  3\   | 3     6
                                                                      \ |    \  |      /
                                                                      4\|     \ |     /7
                                                                        1------2-----/
                                                                            2
                                                                      
                                                                      [[1,2,2],[1,4,1] ,[1,5,4] ,[2,3,3], [2,4,3], [2,6,7],[3,4,5], [3,6,8],[4,5,9]]

                                                                      1.Sort the edges by weight
                                                                      [[1,4,1] [1,2,2] , [2,3,3], [2,4,3],[1,5,4],[3,4,5],[2,6,7],[3,6,8],[4,5,9]]

                                                                      2.Find the union of sorted edges and store those edges in mst
                                                                      Initially all nodes are their own parent-
                                                                      union(1,4)
                                                                      1
                                                                   1  |
                                                                      |
                                                                      4

                                                                      union(1,2)
                                                                      4
                                                                   1  |
                                                                      |
                                                                      1-----2
                                                                        2

                                                                      union(2,3)
                                                                      4     3
                                                                   1  |     | 3
                                                                      |     |
                                                                      1-----2
                                                                        2

                                                                      union(2,4)
                                                                      2 and 4 have same parent so we skip this

                                                                      similarly we continue and build our MST

      //OVERRIDE
      public int[] graphDirUndirMinimumSpanningTree(int[][] edges, int n){       
        int[][] edges = graphDeconstructI(graphArr,n)       --initialise edges; our fn requires edges but we may be given graphArr so deconstruuct graphArr to edges
        return graphDirUndirMinimumSpanningTree(edges,n)      (look in graphDeconstructI())
      } 


      Time :O(Elog E + E*4alpha) : Sort E dges(ElogE) and iterte through E edges(E) and find their union(4alpha)
      Space:O(N)                 :For parent , rank , mst arrays
      */




    }
    public void graphUndirIsValidTree(int[][] edges, int n){
      /*
      1---2  --given an undirected graph 
      |---3    check if it is a valid tree 
               1.It is completely connected and has only 1 componenyt
               2.It Has no cycles
      */      
      
      //DFS RECURSIVE;DFS ITERATIVE;BFS ITERATIVE
      /*
      public void graphDirUndirIsValidTree(int[][] edges, int n){
        int noOfComponent = graphUndirConnectedComponentCount(edges,n);   --check graph is a valid tree by checking if there is 1 component and no cycle
        boolean isCycle   = graphUnDirCycleDetection(edges,n);
        
        return noOfComponent==1 && !isCycle;
      }

      Time:Time req for graphUndirConnectedComponentCount +  graphUnDirCycleDetection
      Space:Space req for graphUndirConnectedComponentCount +  graphUnDirCycleDetection
      
      */
      
    }


  
    //MCM 
    /*
    MCM IDENTIFY
    [1  2  3  4  5 6]    --we need to do partion for different combination like (1)(2,3,4,5) ;  (1,2) (3,4,5) ; so on

    
    MCM RECURSION
    public void solve(int[] arr, int i , intj )
      //1.Find i, j   such that they are valid
      public void solve(arr,1 ,arr.length-1)
      

      //2.Find  i,j for different base condition 
      if(i > j)                            
        return 0
      if(i < j)
        return 0
      if(i == j)
        return 0     

      
      //3.Find k such that partitions are valid  partition1(itok) partition2(k+1 to j) 
      for(k = i ; k < j ; k++ ){ }

      //4.Find tempAns considering fn(i to k) fn(k+1 to j)
      tempans = solve(arr,i,k) 
                +/-/..          
                solve(arr,k+1,j)

      //5. find ans based on tempAns         
      ans = fn(tempans)           
      
      return ans 
    }


    
    */
    public int     matrixchainMultiplicationMinimumCost(int[] arr , int i , int j ){
      /*
      Question
      [10,30,5,60,20] -- find the  cost of all possible multiplacation of matrices of given dimention
                        so return the minimum cost 
                      Eg
                      A = 10 X 30 ; B = 30 X 5 ; C = 5 X 60 ;D  = 60 X 20 
                      (AB)(CD) =AB      = (10 X 30)* (30 X 5) -- cost = 10*30*5  
                                CD      = (5 X 60) * (60 X 20)         + 5*60*20
                              (AB)(CD) = (10 X 5) * (5 X 20 )         + 10*5*20
                      (ABC)D  = AB      = (10 X 30)* (30 X 5) -- cost = 10*30*5  
                                ABC     = (10 X 5) * (5 X 60)           + 10*5*60
                                (ABC)D  = (10 X 60)* (60 X 20)         + 10*60*20
                      so return minimum of cost

      */

      //RECURSIVE WRT MCM( [10,30,5,60,20] - (10,30)(5,60,20) ;  (10,30,5) (60,20) ; so on partitions are required)
      /*
        TIME :O(n*2^n)  as each fn calls itself twice and reduces by 1 ; iterate n times (n = arr length)
        SPACE:O(n) as we have n ips(n = arr length)

      (Ai = a[i-1] X a[i])
      //1.Find i, j such that they are valid
      i = 0 
      [10,30,5,60,20]      [10]  we canot form matrix  a[-1] X 10   X 
        i                

      i = 1 
      [10,30,5,60,20]       [30] we can form matrix 10 X 30       \/
          i            
      
      j = arr.length - 1     
      [10,30,5,60,20]       [20] we can  form a matrix  60 X 20    \/
                  j       

      So    
      public int matrixchainMultiplicationMinimumCost(int[] arr , 1 ,arr.length-1 )    
      
      //2.Find  i,j for different base condition 
      i < j
      [10,30,5,60,20]     cost of multiplying == anything
          i      j     
      
      i = j(arr of size1)
      [10]                 cost of multiplying = 0
      ||         
      i j

      i > j(arr of size 0)
      []                  cost of multiplying = 0
                

      So
      if(i > j)                            
        return 0;
      if(i == j)
        return 0;  

      //3.Find k such that partitions are valid  partition1(itok) partition2(k+1 to j) 
      k = i 
      [10,30,5,60]  --p1 [30]   we can form a matrix 10X 30  ;        \/ 
          i    j      p2 [5,60] we can form  matrix 30X 5 ; 5 X 60   \/
          k         
      
      k = j 
      [10,30,5,60]  -- p1 [30,5,60] we can frm a matrix 10X 30, 30 X 5 , 5 X 60 ;\/ 
          i    j       p2 out of bond we can form matrix as k+1 is out of bond  X    
              k     
      
      k = j-1 
      [10,30,5,60]  --p1 [30,5] we can frm a matrix 10X 30,30 X 5     \/
          i    j     p2 [60] we can form matrix 5 X 60                \/
            k      
      
      So
      for(int k = i ; k <= j-1 ; k++){
      }


    

      

      //4.Find tempAns considering fn(i to k) fn(k+1 to j)
      [10,30,5,60,20]  --
          i   k   j    fn(i to k)                -- finds cost of    (10 X 30) * (30 X 5)    ie (AB)    
                        fn(k+1 to j)             -- finds cost of  (5X 60) *  (60 X 20)    ie (CD)
                        arr[i-1]*arr[k]*arr[j]   -- finds cost of (10X5) *(5*20) ie(AB)(CD)
      
        So
        int tempAns = matrixchainMultiplicationMinimumCost(arr,i,k)  -- add all the costs
                    + matrixchainMultiplicationMinimumCost(arr,k+1,j)
                    + arr[i-1]*arr[j]*arr[k];

      //5.Find ans based on tempAns
      ans = max(tempAns for all k)
      
      if(tempAns <= min ){
        min = tempAns;
      }     


      PROGRAM
      public int matrixchainMultiplicationMinimumCost(int[] arr , int i , int j ) {
      if(i >= j)                            
        return 0;


      int min = Integer.MAX_VALUEL
      for(int k = i ; k <= j-1 ; k++){
        int tempAns = matrixchainMultiplicationMinimumCost(arr,i,k)
              + matrixchainMultiplicationMinimumCost(arr,k+1,j)
              + arr[i-1]*arr[j]*arr[k];

        if(tempAns <= min){
          min = tempAns
        }      
      }

      int ans = min;
      return ans;


      } 


      */
      

      //DP TOP-DOWN MEMOIZATION WRT MCM([10,30,5,60,20]    -- k ghumte rahega bracket ke liye  aur before after k ka soln dhundna hai)
      /*
      TIME :O(n^3) =  as  we store overlapping problems in matrix and  do this n time(n = arr length)
      SPACE:O(n^2) =  as we matrix takes extra space (n = arr length)  

      public int matrixchainMultiplicationMinimumCost(int[] arr , int i , int j ,int[][] dp) {  --  INITIALISE MATRIX dp[i+1][j+1] , FILL MATRIX WITH -1
      if(i >= j)                            
        return 0;

      if(dp[i][j] =! -1){                             -- CHECK IN MATRIX
        return t[i][j];
      }   

      int min = Integer.MAX_VALUEL
      for(int k = i ; k <= j-1 ; k++){
        int tempAns = matrixchainMultiplicationMinimumCost(arr,i,k,dp)
              + matrixchainMultiplicationMinimumCost(arr,k+1,j,dp)
              + arr[i-1]*arr[j]*arr[k];

        if(tempAns <= min){
          min = tempAns
        }      
      }

      dp[i][j] = min;                                   ---STORE RETURN VALUE IN MATRIX  
      return dp[i][j];


      } 

      //OPTIMIZE STORING RETURN VALUE IN MATRIX  
      CALLING BOTH THE FNS AND THEN STORING THEIR RETURN VALUES IN MATRIX    
      int tempAns = matrixchainMultiplicationMinimumCost(arr,i,k,dp)
                  + matrixchainMultiplicationMinimumCost(arr,k+1,j,dp)
                  + arr[i-1]*arr[j]*arr[k];        

      CALLING EACH FN AND  STORING THEIR RETURN  VALUE SIMULTANEOUSLY   
      if(dp[i][k] =! -1){                         
        int left =  dp[i][k]; }
      else{
        int left =  matrixchainMultiplicationMinimumCost(arr,i,k,dp);
        dp[i][k] = left;}

      if(t[k+1][j] =! -1){               
        int right =  dp[k+1][j];}
      else{
        int right =  matrixchainMultiplicationMinimumCost(arr,k+1,j,dp);
        dp[k+1][j] = right;}

      
      int tempAns = left + right +  + arr[i-1]*arr[j]*arr[k]; 
      */ 

      return 0;
    }
    public int     stringPallindromePartitionMinimumCount(String s , int i , int j){
      /*
      Question
      "nitin" -- find the  partitions that give pallindrome 
                so return minimum number of partition required
                Eg
                "nitin" -- "n" "i" "t" "i" "n" - 4partition
                            "n" "iti" "n"  - 3 partitiom
                            "nitin" - 0 partitiion
                  so return 0          


      */

      //RECURSIVE WRT MCM("nitin"- ("n")("itin") ;  ("ni") ("tin") ; so on partitions are required)
      /*
      TIME :O(n*2^n)  as each fn calls itself twice and reduces by 1 ; iterate n times (n = str length)
      SPACE:O(n) as we have n ips(n = str length)


      //1.Find i, j   such that they are valid
      i = 0 
      "nitin"  --  "n"  we can form a string
      i                

      j = s.length() - 1     
      "nitin"   --"n"  we can form a string
          j       

      SO      
      public int stringPallindromePartitionMinimumCount(String s ,1 , s.length()-1)   
  
    
      //2.Find  i,j for base condition 
      i < j
      "nitin" --  no of partitions !=0  but if it is a pallindrome then cost = 0 so check ispallindrome also
        i  j     
      
      i = j(string of size1)
      "n"    -- no of partitions ==0 
      ||         
      i j

      i > j(string of size 0)
      ""     --  no of partitions ==0 

      SO
      if(i > j)                            
        return 0;
      if(i == j)
        return 0;  
      if(ispallindrome(s,i,j))
        return 0;  


    //3.Find k such that partitions are valid  partitions p1(i to k) p2(k+1 to j) 
      k = i 
      "nitin"  -- p1 "n"  we can form a string   \/  
      i   j      p2 "itin" we can form string   \/         
      k          
      
      k = j 
      "nitin"   --p1 "nitin" we can frm a string  \/  
      i   j      p2 out of bond we cannot form string    
          k     

      k = j-1 
      "nitin"  --p1 "niti" we can frm a string  ; 
      i   j     p2 "n" we can form string           
          k       
      
      SO
      for(int k = i ; k <= j-1 ; k++){
      }

      

      //4.Find tempAns considering fn(i to k) fm(k+1 to j)
      "nitin" - fn(i to k)       --finds no of partition  of "nit"    
        i k  j   fn(k+1 to j)     --finds no of partition  of "in" 
                1                --1 partition bw "nit" and "in"
      
        SO
        int tempAns = stringPallindromePartitionMinimumCount(arr,i,k)  -- add no of partititons
                    + stringPallindromePartitionMinimumCount(arr,k+1,j)
                    + 1;

      //5.Find ans based on tempAns
      ans = min(tempAns for all k)
      
      if(tempAns <= min ){
        min = tempAns;
      }     


      PROGRAM
      public int stringPallindromePartitionMinimumCount(int[] arr , int i , int j ) {
      if(i >= j)                            
        return 0;


      int min = Integer.MAX_VALUEL
      for(int k = i ; k <= j-1 ; k++){
        int tempAns = stringPallindromePartitionMinimumCount(arr,i,k)
              + stringPallindromePartitionMinimumCount(arr,k+1,j)
              + 1;

        if(tempAns <= min){
          min = tempAns
        }      
      }


      return min;


      } 


      */
      

      //DP TOP-DOWN MEMOIZATION WRT MCM("nitin"   -- k ghumte rahega partition ke liye  aur before after k ka soln dhundna hai)
      /*
      TIME :O(n^3) =  as  we store overlapping problems in matrix and  do this n time(n = str length)
      SPACE:O(n^2) =  as we matrix takes extra space (n = str length)   

      public int stringPallindromePartitionMinimumCount(int[] arr , int i , int j,int[][] dp ) {-- INITIALISE MATRIX dp[i+1][j+1] , FILL MATRIX WITH -1
        if(i >= j)                            
          return 0;

        if(dp[i][j] =! -1){                            --> CHECK MATRIX
          return t[i][j];}     


        int min = Integer.MAX_VALUEL
        for(int k = i ; k <= j-1 ; k++){
          int tempAns = stringPallindromePartitionMinimumCount(arr,i,k , dp)
                + stringPallindromePartitionMinimumCount(arr,k+1,j , dp)
                + 1;

          if(tempAns <= min){
            min = tempAns
          }      
        }

      dp[i][j] = min;                                   --> STORE RETURN VALUE IN MATRIX
        return dp[i][j];


      //OPTIMIZE STORING RETURN VALUE IN MATRIX  
      CALLING BOTH THE FNS AND THEN STORING THEIR RETURN VALUES IN MATRIX    
      int tempAns = stringPallindromePartitionMinimumCount(arr,i,k,dp)  
              + stringPallindromePartitionMinimumCount(arr,k+1,j,dp)          
              + 1;
      CALLING EACH FN AND  STORING THEIR RETURN  VALUE SIMULTANEOUSLY   
      if(dp[i][k] =! -1){                         
        int left =  dp[i][k]; }
      else{
        int left =  stringPallindromePartitionMinimumCount(arr,i,k,dp);
        dp[i][k] = left;}

      if(dp[k+1][j] =! -1){               
        int right =  dp[k+1][j];}
      else{
        int right =  stringPallindromePartitionMinimumCount(arr,k+1,j);
        dp[k+1][j] = right;}

      */


      return 0;
    }
    public int     stringexpressionPartitionCount(String s , int i , int j, int isTrue){
      /*
      Question
      "T/\F&T" -- find all possible ways of evaluating expression to T 
                  so return number of ways
                  Eg
                  (T/\F)&T = T&T = T
                  T/\(F&T)  = T/\F = T
                  so return no of ways = 2
      */

      //RECURSIVE WRT MCM( "T|F&T|F" --(T)|(F&T|F) ; (T|F)&(T|F) so on partitions are required  )
      /*
      TIME :O(n*2^n)  as each fn calls itself twice and reduces by 1 ; iterate n times (n = str length)
      SPACE:O(n) as we have n ips(n = str length)

      //1.Find i, j  to be  passed to fns such that they are valid
      i = 0 
      "T|F&T|F"  --  "T"  we can form a expression
      i                

      j = s.length() - 1     
      "T|F&T|F"   -"F"  we can form a expression
            j       

      SO      
      public int stringexpressionPartitionCount(String s ,1 , s.length()-1, true)   
  
    
      //2.Find  i,j for different base condition 
      i < j
      "T|F&T|F"         --  no of ways = anything
      i    j     
      
      i = j(string of size1)
      "T/F"               -- no of ways = depends on the character at i because i aur j pe T ya F ayega; k pe operator acc to loop  
      ||                     if isTrue = 1 then if s[i] = 'T' return 1 else 0
      i j                    if  isTrue = 0 then if s[i] = 'F' return 1 else 0
                                    |__explained in step 4
      i > j(string of size 0)
      ""            --  no of ways = 0

      SO
      if(i >= j)                            
        return 0;
      if(i == j){
        if(b == true){
            return s.charAt(i) == 'T' ? 1:0;}
        else{
          return s.charAt(i) == 'F' ? 1:0;}
      }  
    
    
                                          k-1 not k because k is operator and we dont want to include it
                                                              |
      //3.Find k such that partitions are valid  partition1(i to k-1) partition2(k+1 to j) 
      k = i
      "T|F&T|F"  -- p1 out of bond   we cant make expression as out of bond X
      i     j      p2 "|F&T|F"     we cannot make expresion  with |        X
      k 

      k = i+1
      "T|F&T|F"  -- p1 "T"      we cant make expression   \/
      i     j      p2 "F&T|F"  we cannot make expresion  \/
        k  

      k = j
      "T|F&T|F"  -- p1 T|F&T|"  we cannot  make expression due to |   X
      i     j      p2 out of bond  we cannot make expresion  as out of bond
            k       
      k = j -1
      "T|F&T|F"   --p1 "T|F&T"  we can  make expression   
      i     j      p1 "F"  we can  make expression    
            k     

      k = k+2
      "T|F&T|F"  -- k partitions on operator and they are alternate so k must jump 2 places
      i     j             
      k      

      SO
      for(int k = i+1 ; k <= j-1 ; k= k+2){
      }

      
                                            
      //4.Find tempAns considering fn(i to k-1) fn(k+1 to j)
      "T|F&T|F"    lefftTrue = fn(i to k-1,1) finds no of ways when left exp must be true     --> consider exp1^exp2 = true  we need exp1 true and exp2 false OR vive versa 
        i  k  j     leftFalse = fn(i to k-1,0) finds no of ways when left exp must be false       so our subproblems  not necessarily have to be true ; but true or false  such that final op evaluates to true 
                    rightTrue = fn(k+1 to j,1) finds no of ways when right exp must be true       so we find no of ways for left to be true,false and right to be true,false by mantaining int "isTrue" as  1 for true - for false 
                    rightFalse = fn(i to k-1,0) finds no of ways when right exp must be false  
        SO
        if(s.charAt(k) == '&'){                                                                -> for each operator check isTrue = 0 and preferred is false  check what is the preferred answer ;for the preferred answer  add all the possibilities 
          if(isTrue == 1)                                                                          when  isTrue = 1 -- find all the possibilities of left and right to be true
            int tempAns = lefftTrue*rightTrue                                                     when  isTrue = 0 -- find all the possibilities of left and right to be false         
          if(isTrue == 0)
              int tempAns = lefftFalse*rightFalse + lefftFalse*rightTrue + lefTrue*rightFalse
        } 
        if(s.charAt(k) == '|'){                                                                     
          if(isTrue == 1)                                                                      
            int tempAns = lefftTrue*rightTrue  + lefftFalse*rightTrue + lefTrue*rightFalse                                                              
          if(isTrue == 0)
              int tempAns = lefftFalse*rightFalse
        }   
        if(s.charAt(k) == '^'){                                                                     
          if(isTrue == 1)                                                                      
            int tempAns = lefftTrue*rightFalse  + lefftFalse*rightTrue                                                             
          if(isTrue == 0)
              int tempAns = leftTrue*rightTrue + lefftFalse*rightFalse
        }             
                            

      //5.Find ans based on tempAns
      ans = sum(tempAns for all k)
      SO
      ans = 0
      ans = ans + temp;  


      PROGRAM
      public int stringexpressionPartitionCount(String s ,int i , int j , int booleanWeWant){
        if(i >= j)                            
          return 0;
        if(i == j){
          if(b == true){
              return s.charAt(i) == 'T' ? 1:0;}
          else{
            return s.charAt(i) == 'F' ? 1:0;}
        } 
        int ans =0 
        for(int k = i+1 ; k <= j-1 ; k= k+2){
          int lefftTrue = stringexpressionPartitionCount(s,i ,k-1, 1)
          int leftFalse = stringexpressionPartitionCount(s,i ,k-1, 0)      
          int rightTrue = stringexpressionPartitionCount(s,k+1 ,j,1)      
          int rightFalse =  stringexpressionPartitionCount(s,k+1 ,j,0) 

          if(s.charAt(k) == '&'){                                                                   
            if(isTrue == 1)                                                                     
              int tempAns = lefftTrue*rightTrue                                                               
            if(isTrue == 0)
                int tempAns = lefftFalse*rightFalse + lefftFalse*rightTrue + lefTrue*rightFalse
          } 
          if(s.charAt(k) == '|'){                                                                     
            if(isTrue == 1)                                                                      
              int tempAns = lefftTrue*rightTrue  + lefftFalse*rightTrue + lefTrue*rightFalse                                                              
            if(isTrue == 0)
                int tempAns = lefftFalse*rightFalse
          }   
          if(s.charAt(k) == '^'){                                                                     
            if(isTrue == 1)                                                                      
              int tempAns = lefftTrue*rightFalse  + lefftFalse*rightTrue                                                             
            if(isTrue == 0)
                int tempAns = leftTrue*rightTrue + lefftFalse*rightFalse
          } 
          
          ans = ans + tempAns;

        }
        return ans;
      }

      */
      
      //DP TOP-DOWN MEMOIZATION WRT MCM( "T|F&T|F" -- k ghumte rahega partition ke liye  aur before after k ka soln dhundna hai )
      /*
      TIME :O(n^3) =  as  we store overlapping problems in matrix and  do this n time(n = str length)
      SPACE:O(n^2) =  as we matrix takes extra space (n = str length)   

      public int stringexpressionPartitionCount(String s ,int i , int j , int isTrue , int[][] dp){ -- INITIALISE MATRIX dp[i+1][j+1] , FILL MATRIX WITH -1
        if(i > j)                            
          return 0;
        if(i == j){
          if(isTrue == 1){
              return s.charAt(i) == 'T' ? 1:0;}
          else{
            return s.charAt(i) == 'F' ? 1:0;}
        }

                    
        if(dp[i][j][isTrue] =! -1){           --> CHECK MATRIX                   
          return t[i][j][isTrue];}     

      int ans =0 
        for(int k = i+1 ; k <= j-1 ; k= k+2){
          int lefftTrue = stringexpressionPartitionCount(s,i ,k-1, 1, dp)
          int leftFalse = stringexpressionPartitionCount(s,i ,k-1, 0 , dp)      
          int rightTrue = stringexpressionPartitionCount(s,k+1 ,j,1 ,dp)      
          int rightFalse =  stringexpressionPartitionCount(s,k+1 ,j,0 , dp) 

          if(s.charAt(k) == '&'){                                                                   
            if(isTrue == 1)                                                                     
              int tempAns = lefftTrue*rightTrue                                                               
            if(isTrue == 0)
                int tempAns = lefftFalse*rightFalse + lefftFalse*rightTrue + lefTrue*rightFalse
          } 
          if(s.charAt(k) == '|'){                                                                     
            if(isTrue == 1)                                                                      
              int tempAns = lefftTrue*rightTrue  + lefftFalse*rightTrue + lefTrue*rightFalse                                                              
            if(isTrue == 0)
                int tempAns = lefftFalse*rightFalse
          }   
          if(s.charAt(k) == '/\'){                                                                     
            if(isTrue == 1)                                                                      
              int tempAns = lefftTrue*rightFalse  + lefftFalse*rightTrue                                                             
            if(isTrue == 0)
                int tempAns = leftTrue*rightTrue + lefftFalse*rightFalse
          } 
          
          ans = ans + tempAns;

        }
                                                                    
        dp[i][j][isTrue] = ans;                                  --> STORE RETURN VALUE IN MATRIX 
        return dp[i][j][isTrue]; 

      }
          

      //OPTIMIZE STORING RETURN VALUE IN MATRIX  
      CALLING BOTH THE FNS AND THEN STORING THEIR RETURN VALUES IN MATRIX    
      int lefftTrue = stringexpressionPartitionCount(s,i ,k-1, 1)
      int leftFalse = stringexpressionPartitionCount(s,i ,k-1, 0)      
      int rightTrue = stringexpressionPartitionCount(s,k+1 ,j,1)      
      int rightFalse =  stringexpressionPartitionCount(s,k+1 ,j,0) 

      CALLING EACH FN AND  STORING THEIR RETURN  VALUE SIMULTANEOUSLY   
      if(dp[i][k-1][1] =! -1){                         
        int lefftTrue =  dp[i][k-1][1]; }
      else{
        int left =  stringexpressionPartitionCount(s,i ,k-1, 1 , dp);
        dp[i][k-1][1] = left;
      }

      if(dp[i][k-1][0] =! -1){                         
        int leftFalse =  dp[i][k-1][0]; }
      else{
        int leftFalse =  stringexpressionPartitionCount(s,i ,k-1, 0 , dp);
        dp[i][k-1][0] = leftFalse;
      }

      if(dp[k+1][j][1] =! -1){                         
        int rightTrue =  dp[k+1][j][1]; }
      else{
        int rightTrue =  stringexpressionPartitionCount(s,k+1 ,j,1 , dp);
        dp[k+1][j][1] = rightTrue;
      }
      
      if(dp[k+1][j][0] =! -1){                         
        int rightFalse =  dp[k+1][j][0]; }
      else{
        int rightFalse =  stringexpressionPartitionCount(s,k+1 ,j,0 , dp) ;
        dp[k+1][j][0] = rightFalse;
      }
      
      */
      return 0;
    }
    public int     eggDropingMinimumCount(int n , int e){
      /*
      Question
      8  o o o  -- n floor and ;e eggs available;threshold floor and floor below it  eggs do break and floors above threshold  eggs break
      7             so return minimum no of attemopts to find threshold floor worst case scenario
      6            EG
      5            n= 4 ; e = 2
      4            4                 CASE 1:Drop at 1st floor
      3            3                 Egg breaks      : no of eggs left = 1  ;floors to check = 0  -> no of attempts =1
      2            2                 Egg doesnt break: no of eggs left = 2 ; floors to check = f2,f3,f4 = 3(worst case threshold on 4th floor so you need 3 more attempts)  -->no of attempts =4 
      1            1  0 0            Worst case = 3                                                        
                                      
                                    CASE 2: Drop at second floor
                                    Egg breaks      : no of eggs left = 1 ; floors to check = f1(worst case threshold on 1st floor so you need  1 more attempts)   -->no of attempts =2 
                                    Egg doesnt break: no of eggs left = 2 ; floor to check = f3 f4(worst case threshold on 4th floor so you need 2 more attempts)  --> no of attempt = 3
                                    Worst case = 3

                                    CASE 3: Drop at third floor
                                    Egg breaks      : no of eggs left = 1 ; floors to check = f2,f1(worst case threshold on 1st floor so you need  2 more attempts)  -->no of attempts =3 
                                    Egg doesnt break: no of eggs left = 2 ; floor to check : f4(worst case threshold on 4th floor so you need  1 more attempts)      --> no of attempt = 2
                                    worst case = 3
                                    
                                    CASE 4: Drop at fourth floor
                                    Egg breaks      : no of eggs left = 1 ; floors to check = f3,f2,f1(worst case threshold on 1st floor so you need  3 more attempts)  -->no of attempts =4 
                                    Egg doesnt break: no of eggs left = 2 ; floor to check : f4(worst case threshold on 4th floor so you need  1 more attempts)         --> no of attempt = 0
                                    worst case = 4

                                    so return the min of them = 3


      */        
      

      //RECURSIVE WRT MCM( [4,3,2,1] --([4])([3,2,1]) ; ([4,3])([2,1]) so on partitions are required )
      /*
      TIME :O(n*2^n)  as each fn calls itself twice and reduces by 1 ; iterate n times (n = no of floor)
      SPACE:O(n) as we have n ips(n = no of floor)

        //1.Find i, j  to be  passed to fns such that they are valid
        i j not req here


        //2.Find  n,e for different base condition 
        e = 1
        4          --worst case threshold will be on 4th floor; start from 1st floor no of attempts = 4
        3
        2
        1 o

        e = 0
        4          --worst case threshold will be on 4th floor; start from 1st floor but no eggs so no of attempts = 0 
        3
        2
        1 


        n = 1
        1          --worst case threshold will be on 1st floorn;start from 1st floor  no of attempts = 1

        n = 0
                  --worst case threshold will be on no floor; no floor to start no of attempts = 0

        So
        if(e == 1){
          return n;
        }  
        if(e == 0){
          return 0;
        }        
        if(n == 1){
          return 0;
        } 
        if(n == 0){
          return f;
        }

        

        //3.Find k such that partitions are valid  p1(1 to k-- 1st floor to kth floor) (k+1 to n -- floor after k to nth floor)
        k = 1
        4         -- p1 1     we can make this partition
        3            p2 3 2 1 we can make this partition
        2
        1 -- k   
  
        k = n
        4 -k      -- p1 1 2 3 4  we can make this partition
        3            p2  --  we can make this partition 
        2
        1    

        SO
        for(k = 1 ; k <= n ; k++){
        }


      //4.Find tempAns considering fn(egg breaks) fn(egg doesnt)
        4           --fn(k-1,e-1)  -- finds  give no of attempts if egg breaks
        3 k           fn(f-k,e)    -- finds no of attempts if egg doesnt breaks
        2             1            --1 attempt for the kth floor itself
        1   

        so
        int tempAns = 1 + Mathmax(eggDropingMinimumCount(k-1,e-1) , eggDropingMinimumCount(f-k,e)) --find max because we need worst no of attempts of breaking or not breaking 
  
        //5.Find ans based on tempAns
        int ans = min(all tempAns) -- min becausse we want to find minimum of all attempts

        PROGRAM                                     
        //DP                                                               //DP + BS ON ANSWER
        public int eggDropingMinimumCount(int n , int e){                  public int eggDropingMinimumCount(int n , int e){        
        if(e == 1){                                                            if(e == 1){   
          return n;}                                                               return n;}
        if(e == 0){                                                             if(e == 0)
          return 0;                                                                return 0;                                                               
        if(n == 1){                                                             if(n == 1){
          return 0;}                                                                return 0;} 
        if(n == 0){                                                              if(n == 0){
          return n;}                                                                return n;}

        int min = Integer.MAX_VALUE                                           int min = Integer.MAX_VALUE;
                                                                              int low = 1;int high = n;
        for(k = 1 ; k <= f ; k++){                                            while(low <= high) {      
          int tempAns = 1 + Mathmax(eggDropingMinimumCount(k-1,e-1) ,               int mid = low+((high - low)/2);
                                      eggDropingMinimumCount(f-k,e))                 int eggbreak = eggDropingMinimumCount(mid-1,e-1 ,dp);
                                                                                    int eggnobreak = eggDropingMinimumCount(n-mid,e,dp);
                                                                                    int tempAns = 1 + Math.max(eggbreak, eggnobreak);
          min = Math.min(tempAns,min)                                                min = Math.min(tempAns,min)

                                                                                    if (eggbreak == eggnobreak) --->means eggnobreak = eggnobreak so brek immediately
                                                                                        break;
                                                                                    else if (eggbreak < eggnobreak) -->means eggnobreak has higher no of attempts so acc to worst case we take eggnobreak 
                                                                                      low = mid + 1;                  so if egg isnt broken you move up ie right n our array
                                                                                      else                           -->means eggbreak has higher no of attempts so acc to worst case we take eggbreak 
                                                                                        high = mid-1;                  so if egg isnt broken you move down ie left in our array
        }                                                                       }
        return min;                                                          return min;
      }                                                                      }
  
                                              

      
      */
        
      //DP TOP-DOWN MEMOIZATION WRT MCM( [4,3,2,1] --([4])([3,2,1]) ; ([4,3])([2,1]) so on partitions are required )
      /*
      TIME :O(n^3) =  as  we store overlapping problems in matrix and  do this n time(n = no of floor)
      SPACE:O(n^2) =  as we matrix takes extra space (n = no of floor) 

        public int eggDropingMinimumCount(int n , int e,int[][] dp){         public int eggDropingMinimumCount(int n , int e,int[][] dp){   --  INITIALISE MATRIX dp[n+1][e+1] , FILL MATRIX WITH -1       
      if(e == 1){                                                            if(e == 1){   
          return n;}                                                               return n;}
        if(e == 0){                                                             if(e == 0)
          return 0;                                                                return 0;                                                               
        if(n == 1){                                                             if(n == 1){
          return 0;}                                                                return 0;} 
        if(n == 0){                                                              if(n == 0){
          return n;}                                                                return n;}

        if(dp[n][e] =! -1){                                                      if(dp[n][e] =! -1){     -->CHECK MATRIX
          return dp[n][e]                                                               return dp[n][e]
        }                                                                         }  
        int min = Integer.MAX_VALUE                                           int min = Integer.MAX_VALUE;
                                                                              int low = 1;int high = n;
        for(k = 1 ; k <= f ; k++){                                            while(low <= high) {      
          int tempAns = 1 + Mathmax(eggDropingMinimumCount(k-1,e-1) ,               int mid = low+((high - low)/2);
                                      eggDropingMinimumCount(f-k,e))                 int eggdrop = eggDropingMinimumCount(mid-1,e-1,dp);
                                                                                    int eggnodrop = eggDropingMinimumCount(n-mid,e,dp);
                                                                                    int tempAns = 1 + Math.max(eggdrop, eggnodrop);
          min = Math.min(tempAns,min)                                                min = Math.min(tempAns,min)

                                                                                    if (eggdrop == eggnodrop) 
                                                                                      break;
                                                                                    else if (eggdrop < eggnodrop) 
                                                                                      low = mid + 1;
                                                                                      else 
                                                                                        high = mid-1;
        }                                                                       }
        dp[n][e] = min                                                           dp[n][e] = min      --> STORE RETURN VALUE IN MATRIX 
        retrn dp[n][e]                                                           retrn dp[n][e]
      }                                                                      }
  


        
      //OPTIMIZE STORING RETURN VALUE IN MATRIX  
      CALLING BOTH THE FNS AND THEN STORING THEIR RETURN VALUES IN MATRIX  
      int tempAns = 1 + Math.max(eggDropingMinimumCount(k-1,e-1) , eggDropingMinimumCount(f-k,e))    int tempAns = 1 + Math.max(eggDropingMinimumCount(mid-1,e-1,dp), eggDropingMinimumCount(n-mid,e,dp));

      
      CALLING EACH FN AND  STORING THEIR RETURN  VALUE SIMULTANEOUSLY   
      if(dp[k-1][e-1] =! -1 ){                                                                       if(dp[mid-1][e-1] =! -1 ){
        int left = dp[k-1][e-1];                                                                        int left = dp[mid-1][e-1];
      }                                                                                              }
      else{                                                                                         else{
        int left = eggDropingMinimumCount(k-1,e-1);                                                     int left = eggDropingMinimumCount(mid-1,e-1);
        dp[k-1][e-1] = left;                                                                            dp[mid-1][e-1] = left;
      }                                                                                             }
        

      if(dp[f-k][e] =! -1 ){                                                                       if(dp[f-k][e] =! -1 ){
        int right = dp[f-k][e];                                                                        int right = dp[f-k][e];
      }                                                                                               } 
      else{                                                                                        else{
        int right = eggDropingMinimumCount(f-k,e);                                                      int right = eggDropingMinimumCount(f-k,e);
        dp[f-k][e] = right;                                                                             dp[f-k][e] = right;
      }                                                                                             }

      int tempAns = 1 + Math.max(left,right)                                                    int tempAns = 1 + Math.max(left,right)
      */ 
      
      
      return 0;
      





    }
    public boolean stringscrambledPossible(String a, String b){
    /*
    Question
    a = "great"  -- check if b is a valid scramble of a (scramble - break a into tree with "non empty node"  them make 0 or more  swaps at any "non-leaf" node) 
    b = "rgeat"     so return  T or F 
                     Eg
                     "great"                            -- "rgeta"
                      /  \                                  /  \
      swap"gr"<-- "gr" "eat"                             "rg"   "eta"  
                     / \     / \                          / \     / \
                    "g" "r" "e" "at"-- swap "at"        "g"  "r" "e" "ta"
                                 /  \                                  / \
                                "a"   "t"                            "a"  "t"

                     "great"                              -- "gerta"
                      /    \                                  /   \
                  "gre"   "at"                            "ger"   "at"  
                    / \      / \                          / \      / \
    swap"re"<--   "g" "re"  "a" "t"                     "g" "er" "a"  "t"
                         /  \                               / \
                       "r"   "e"                          "r"  "e"        
                
               so return true or false if s2 is a valid scramble        
    */

    //RECURSIVE WRT MCM( "great" --("g")("reat") ; ("gr")("eat") so on partitions are required  )
    /*
    TIME :O(n*2^n)  as each fn calls itself twice and reduces by 1 ; iterate n times (n = str length)
    SPACE:O(n) as we have n ips(n = str length)

    //1.Find i, j  to be  passed to fns such that they are valid
     i j not required here 

    SO      
    public int expressionEvaluateCount(s1,s2)   
 
   
    //2.Find  base conditions for a , b
    if(a.equals(b) == true)                    -- if a and b are equal return true
        return true
    if(a.length() == 1 && b.length() == 1)     -- a and b have reached length 1 and they are still not equal(as we have not encountered the above if)
      return true                                 so return false
      
    MAIN FN  
    if(a.length() != b.length())                   --In Main fn itself check the 2 base conditions
        return false                                 if lengths are unequal no swapping can produce scramble so return false
    if(a.length() == 0 && b.length() == 0)           if lengths are 0 then "" is a scramble of " so return true
        return true    
                                 
                                                            
    
    //3.Find k such that tree  partitions are valid(k is length not index so partition will be made before k)  
     k = 0 
    "great"  --  "great"  we cannot form a empty node
     k             / \
                ""  "great"    

    k = 1 
    "great  --  "great"  we can form  node
      k           / \
                "g"  "reat"                

    k = s1.length()     
    "great"  --  "great"  we cannot form  a empty node
         k        / \
                "great"  ""
                
    k = s1.length() -1    
    "great" --  "great"  we can form  node
        k         / \
                "grea"  "t"           
    SO
    for(int k = 1 ; k <= s1.length() -1 ; k++){
    }

    
                                          
    //4.Find tempAns considering fn(0 to k) fn(k to n)
    "great"   "great"  -- fn(a.substring(0, k), b.substring(0, k) == true)  compare  "gr" "gr"  -- when we do not swap 
       k         k         fn(a.substring(k, n), b.substring(k, n) == true) compare "eat" "eat" 

    "great"   "eatgr"  -- fn(a.substring(0, k), b.substring(n-k, n) == true)  compare "gr" "gr"     -- when we swap 
       k         k         fn(a.substring(k, n), b.substring(0, n-k) == true)   compare "eat" "eat"


     SO
    int n = a.length() OR b.length();                    -- if either of swapping or no swapping gives equal string 
    int tempans = false;                                    then make tempans true and  immediately exit
    if (
      (
      stringscrambledPossible(a.substring(0, k), b.substring(0, k) == true) &&
      stringscrambledPossible(a.substring(k, n), b.substring(k, n)  == true) 
      )
      ||
      (
      isScstringscrambledPossibleramble(a.substring(0, n-k), b.substring(k, n)  == true) &&   
      stringscrambledPossible(a.substring(n-k, n), b.substring(0, k)  == true)          
      )
      {
        tempAns = true;
        break;
      }
      
   
     //5.Find ans based on tempAns
     return tempAns   -- tempAnds has the ans


     PROGRAM
     public boolean stringscrambledPossible(String a, String b){
      if(a.equals(b) == true)                 
        return true
      if(a.length() == 1 && b.length() == 1)   
       return true                                
      
      MAIN FN  
      if(a.length() != b.length())           
        return false                                 
      if(a.length() == 0 && b.length() == 0)           
        return true    
                      

      int tempAns = 0;
      int n = a.length();
      for(int k = 1 ; i <= n-1 ; i++){
        if (
          (
          stringscrambledPossible(a.substring(0, k), b.substring(0, k)) &&
          stringscrambledPossible(a.substring(k, n), b.substring(k, n)) 
          )
          ||
          (
          stringscrambledPossible(a.substring(0, n - k), b.substring(k, n)) &&
          stringscrambledPossible(a.substring(n - i, k), b.substring(0, k))
          )
          
          )
          {flag = 1;}
      }
          
    
      return tempAns;





     }


    




    }



    */


     //RECURSIVE TOP-DOWN MEMOIZATION MCM( "great" --("g")("reat") ; ("gr")("eat") so on partitions are required  )
     /*
    TIME :O(n^3) =  as  we store overlapping problems in matrix and  do this n time(n = str length)
    SPACE:O(n^2) =  as we matrix takes extra space (n = str length)   

      public boolean stringscrambledPossible(String a, String b , Map<String,Boolean> dp){
      if(a.equals(b) == true)                 
        return true
      if(a.length() == 1 && b.length() == 1)   
       return true                                
      
      MAIN FN  
      if(a.length() != b.length())           
        return false                                 
      if(a.length() == 0 && b.length() == 0)           
        return true

     
      String key  = Bolean.toString(a) + " " +Boolean.toString(b)              
      if(dp.containsKey(key))           -->CHECK MAP
         return dp.get(key);  

      int tempAns = 0;
      int n = a.length();
      for(int k = 1 ; i <= n-1 ; i++){
        if (
          (
          stringscrambledPossible(a.substring(0, k), b.substring(0, k)) &&
          stringscrambledPossible(a.substring(k, n), b.substring(k, n)) 
          )
          ||
          (
          stringscrambledPossible(a.substring(0, n - k), b.substring(k, n)) &&
          stringscrambledPossible(a.substring(n - i, k), b.substring(0, k))
          )
          
          )
          {flag = 1;}
      }
          
    
      dp.put(key,tempAns)   -->STORE VALUE IN MAP
      return dp.get(key);
     }

     */
    return true;
  }


  
    //GAMES RECURSION
    public int  josephesPosition(int n , int k ,int indexOfPersonKilled ,  List<Integer> peopleArray){
      /*
      QUESTION
          1        -- For given n , k  n people are standing in circle and 1 kills kth person in circle(counting himself)
      10    2         and so on until1 person remains. Find the safest pos
    9        3       Eg n = 10 k = 3  
    8        4       1 kills 3 -- 4 kills 6 -- 7 kils 9 -- 10 kills 2 -- 5 kills 8 -- 10 kills 5 -- 4 kills 10 -- 4 kills 7 
      7      5        4 is safest
          6     
      */


      //RECURSION -IBH(smaller ip can be identified)-- Recursion because  question is defined recursively ie next perso killed depends on previoud
      /*
      TIME :O(n) as each fn calls itself once and n(size of peoplearray) reduces by 1
      SPACE:O(n) as we have n(size of peoplearray) ips
      */

      //BASE CASE
        /*
        peopleArray.size() == 1 --[3] ie if people arr  has 1 element means it is safe pos 
      */
      if(peopleArray.size() == 1){
        return peopleArray.get(0);
      }

      //HYPOTHESIS AND INDUCTION
      /*                  
                            /----- NOTE: This k is goven as k-1 in overriding because the person counts himself also while counting positions
      josephesPosition(n ,k ,indexOfPersonKilled ,peopleArray) --  return safe position for people array  
      josephesPosition(n,k,indexOfPersonKilled,peopleArray); --    return safe position for people array after killing a person  
      
      
      --      -- There is no need for induction as for cases like sorting array we must reinsert the element removed but after the killed
                  person is removed we dont need reinsertion
      */
      indexOfPersonKilled = (indexOfPersonKilled + k)% peopleArray.size();
      peopleArray.remove(indexOfPersonKilled);
      return josephesPosition(n,k,indexOfPersonKilled,peopleArray);


    //OVERRIDE
    // public int josephesPosition(int n, int k){
    //   List<Integer> peopleArray = new ArrayList<>();
    //   for(int i  = 1 ; i <= n ; i++){
    //     peopleArray.add(i);
    //   }
    //   return josephesPosition(n ,k-1 ,0 ,peopleArray);
    // }
      
      




    }
    public int  grammarElement(int n , int k ){
      /*
      QUESTION
          k =1  2 3  4  5 6 7 8       --> On the first row, we write a 0.
      n =1  0                            Now in every subsequent row, we look at the previous row and replace each 
          2  0  1                         occurrence of 0 with 01, and each occurrence of 1 with 10.
          3  0  1  1 0                    Given (N , k) return the element at that index
          4  0  1  1 0  1 0 0 1
      */

      //RECURSION -IBH(smaller ip can be identified)-- Recursion because question is defined recursively ie next row depends on prev
      /*
      TIME :O(n) as each fn calls itself once and n reduces by 1
      SPACE:O(n) as we have n ips
      */


      //BASE CASE
      /*
      n = 1 and k = 1 -- return 0
      */
      if(n == 1 && k == 1){
        return 0;
      }

      //HYPOTHESIS AND INDUCTON
      /*
      grammarElement(n ,k) -- return the element at n and k 
      grammarElement(n-1,k/k-mid)  - return element at n-1 and k /k - mid(reason in induction)



        if(k <= mid){                  - if k <=  mid then elementat n,k is same as element at n-1,  k 
        return grammarElement(n-1,k);   else the element at n,k is opposite to element at n-1 k-mid hence the EXOR
      }
      else{
        return grammarElement(n-1, k - mid)^1;
    
      }

      */
      var length = (int)Math.pow((double)2, (double)n-1);
      var mid = (int)length/2;

      if(k <= mid){
        return grammarElement(n-1,k);
      }
      else{
        return grammarElement(n-1, k - mid)^1;
    
      }







      


    }
    public void towerOfHanoiPermutation(int n ,String s , String d ,String h ){
      /*
      QUESTION

    plate1  --                                -->we have three rods and n disks , move the entire stack from source to dest with help of helper
    plate2 -----                                 1.Only one disk ie uppermost  can be moved at a time.
    plate3 ---------                              2.No disk may be placed on top of a smaller disk.
          _____________   _________  ________
        source           helper     destination

    EG for n = 3
    Move plate 1 from s to d
    Move plate 2 from s to h
    Move plate 1 from d to h
    Move plate 3 from s to d
    Move plate 1 from h to s
    Move plate 2 from h to d
    Move plate 1 from s to d

      */

      //RECURSION -IBH(smaller ip can be identified)-- Recursion because choices available like placing disk at source , destination or helper
      /*
      TIME :O(2^n) as each fn calls itself twice and n reduces by 1
      SPACE:O(n) as we have n ips
      */



      //BASE CASE
      /*
      n == 1  -->
                    --------                                 ie only 1 disk so move s->d and return
                    ___________   ___________  ___________
                  s              h             d 

      */
      if(n == 1){
        System.out.println("Move plate "+ n + " from " + s + " to " + d);
        return;
      }

      //HYPOTHESIS AND INDUCTION
      /*
      towerOfHanoi( n , s ,  d , h) -- can move n disk from s to d using h  
      towerOfHanoi(n-1, s, h, d) -- can move n-1 disk from s to h using d(reason of these 2 fns explained ininduction)
      towerOfHanoi(n-1, h, d, s) -- can move n-1 disk from h to d using s


      towerOfHanoi(n-1, s, h, d) --   --   }----\                            ie move n-1 plate from s to d using h
                                      ----  }     \
                                    --------      \                            
                                    ___________   ___________  ___________
                                    s              h             d 
      sout(Move plate  n s to d);--                                            ie move nth plate from s to d using h
                                                      --
                                    --------         ----                            
                                    ___|________   ___________  ___________
                                    s  |            h             d 
                                        |_____________________________|

      towerOfHanoi(n-1, h, d, s) --                                                ie move n-1 plates from h to d using s
                                                      -- }-------\
                                                      ----}       --------                   
                                    ___________   ___________  ___________
                                    s              h             d 
          
      NOTE: Time complexity = 2^n-1
              SO NO OF STEPS = 2^N - 1                              
      */
      towerOfHanoiPermutation(n-1, s, h, d);
      System.out.println("Move plate "+ n + " from " + s + " to " + d);
      towerOfHanoiPermutation(n -1 , h, d, s);

      



    }
    public void StringPermutation(String s,int leftptr, int rightptr, Set<String> visitedSet){

      /*
                                  abc
                              /    |     \
                            abc    bac    cba
                          /   \    /  \    / \
                        abc   acb  bac bca cab cba                    
                      
      */


      //BASE CASE
      /*
      leftptr == rightptr -- print s add in visitedSet and return
      */

      if(leftptr == rightptr){
        System.out.println(s);
        visitedSet.add(s);
        
        return;
      }


      //SIMPLER CASE AND RELATION
      /*
      StringPermutationRecursive(s, leftptr + 1, rightptr) -- provide permutationfor smaller string

      for(int i = leftptr ; i <=rightptr ; i++){  -- provide permutationfor when a is fixed , b is fixed , c is fixed
          s = swapCharacters(s, leftptr, i);
          if(!(visitedSet.contains(s)))
              StringPermutationRecursive(s, leftptr + 1, rightptr);
          
      }

      */
      for(int i = leftptr ; i <=rightptr ; i++){
          //s = swapCharacters(s, leftptr, i);
          /*
          private String swapCharacters(String s, int index1, int index2){
            char[] arr = s.toCharArray();

            var temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;

            return String.valueOf(arr);
      }
          */
          s = "";
          if(!(visitedSet.contains(s)))
            StringPermutation(s, leftptr + 1, rightptr, visitedSet);

          
      }


      //OVERRIDE
      //public void  StringPermutationRecursive(String s){StringPermutationRecursive(s, 0,s.length()-1 ,new HashSet<>())}
      
      



      }
    public int  coinPermutationRecursive(int[] arr , int leftptr , int rightptr){
          /*
          QUESTION
          [1,5,7,3,2,4] --user and opponent are equally smart and have to get max coins
                        user  choose a coin 1 
                        opponent can choose  bw 5 and 4 lets say 4
                        user can choose bw  5 and 2 lets say 5 
                        opponent cn choose bw  7 and 2 lets say 7
                        user can bw 3 and 2 lets say 3
                        opponent chooses 2
                        user total = 9 opp total = 13 opponent loses
      

          */


          //BASE CASE
          /*

          leftptr +1  == rightptr --> when left ptr is just 1 behind right ptr choose the maximum of them

          */
          if(leftptr +1  == rightptr){
              return Math.max(arr[leftptr], arr[rightptr]);
          }



          //SIMPLE CASE AND RELATION
          /*
          if user choose a[0]  --> opponent chooses  1 we can choose bw 2,5 -- >opp will make us choose bw
                                opponent chooses 5 we can choose bw 1,4    --->min of 2,5  and 1,4        ----\
                                                                                                              -- we can find max of both paths     
          if user choose a[5]  --> opponent chooses bw 0 we can choose bw 1,4 -- >opp will make us choose bw ---/
                                opponent chooses 4 we can choose bw 0,3   --->min of 1,4  and 0,3

          */
          return Math.max(+
              //CASE1
              arr[leftptr] + Math.min( coinPermutationRecursive(arr ,  leftptr + 2 , rightptr),
                                      coinPermutationRecursive(arr , leftptr+1  , rightptr-1)
                                          ),
              //CASE 2    
              arr[rightptr] + Math.min( coinPermutationRecursive(arr ,  leftptr + 1 , rightptr-1),
                                        coinPermutationRecursive(arr , leftptr  , rightptr-2)
                                        )           

                


          );


          //OVERRIDE
          //public int coinPermutation(int[] arr) {return public int coinPermutation(int[] arr , 0 , arr.length -1);}

        





      







      }
 
 
  }