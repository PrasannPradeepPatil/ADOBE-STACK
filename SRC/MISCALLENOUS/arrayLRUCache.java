package SRC.MISCALLENOUS;

import java.util.*;


public class arrayLRUCache {
    /*

    [[1,1], [2,2]]  maxSize = 2
    |
    |
    LRUCache_UsingDoubleLinkedListHashMap(size):initialises LRU CACHE object by capacity
    add(value,key) :add key value pair to LRUCache if not exists; override if exists;when you add element it becomes most recent 
    get(key)       :return value of key is key exists ;return  -1 if not exists ; if you get element it becomes most recent 
                   if the size goes beyond maxSize remove the least recently used key value pair

                    EG:Cache Size = 2
                    add(1 2) -->{1: 2}    (the most recently added  is kept at the rightmost position)
                    add(2,3) -->{1:2,2:3} (the most recently added one is kept at the rightmost position)
                    add(1,5) -->{2:3,1:5} (the most recently added one is kept at the rightmost position and size > maxSize so remove least recently used)
                    add(4,5) -->{1:5,4:5} (the most recently added one is kept at the rightmost position and size > maxSize so remove least recently used)
                    add(6,7) -->{1:5,4:5} (the most recently added one is kept at the rightmost position and size > maxSize so remove least recently used)
                    get(1)   -->{4:5,1:5} (the most recently get is kepot at right) return 5
                    add(3,2)  -->{1:2,3:2}(the most recently added one is kept at the rightmost position and size > maxSize so remove least recently used)
                    get(7)   -->rturn -1    
                  
    */

    //CLASS NODE
    class Node {
        /*
        |prev|value| next|
        */
      int key;
      int value;
      Node prev;
      Node next;
    }


    //CONSTRUCTOR
    private HashMap<Integer, Node> map;
    private int size;
    private int maxSize;
    private Node head, tail;
    public arrayLRUCache(int capacity) {
    /*
    |p|v|n| --|p|v|n|
     |         |
     head     tail   --create dummy node head and tail
                       connect head ka next to tail
                       connect head ka prev to null
                       connect tail ka prev to head
                       connect tail ka next to null

                       initialise size to 0
                       initialise maxSize to given capacity
                       initialise map

    */
    size = 0;
    maxSize = capacity;
    map = new HashMap<Integer, Node>();

    head = new Node();
    tail = new Node();

    head.prev = null;
    head.next = tail;

    tail.prev = head;
    tail.next = null;
    
    }


    //DOUBLY LINKED LIST METHOD
    private void DoubleLinkedListAddFirst(Node node) {
        /*
              |p|v|n|  
             /     \
        |p|v|n| -X-|p|v|n|--|p|v|n|
        |                     |           
        head                 tail      --head and tail are dummy nodes 
                                        connect node ka prv to head
                                        connect node ka next to head ka next
                                        connect head ka next ka prev to node
                                        connect head ka next to node
        
        
        */

      node.prev = head;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
    }
    private Node DoubleLinkedListRemoveMiddle(Node node){
        /*
    
        |p|v|n| --|p|v|n|--|p|v|n|
        |          |             |           
        head      node        tail     --head and tail are dummy nodes 
                                        prevNode = node.prev
                                        nextNode node.next
                                        connect prevNode ka next to nextNode
                                        connect nextNode ka prev to prevNode
                                        return node
                    
        
        */
        
      Node prevNode = node.prev;
      Node nextNode = node.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;

      return node;
    }
    private Node DoubleLinkedListRemoveLast(){
        /*
    
        |p|v|n| --|p|v|n|--|p|v|n|
        |           |            |           
        head       node       tail     --head and tail are dummy nodes 
                                        node = tail.orev
                                        prevNode = node.prev
                                        nextNode node.next
                                        connect prevNode ka next to nextNode
                                        connect nextNode ka prev to prevNodee
                                        return node
                             
                    
        
        */
        Node node = tail.prev;
        
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next= nextNode;
        nextNode.prev = prevNode;
        
        return node;
    }

    
  
    //LOOKUP
    public int get(int key) {
        /*
        { 1:|1,1| ,2:|2,32|       h--|1,1|--|2,2|--t     -- !if map.containsKey(key)
                                                               return -1
                                                            else
                                                                get node from map and return its value
                                                                remove node from middle of doubly linkedList and  add node at beginning of doubly linkedList  so that least recent can be at right to be removrd
                                                                
                                                            

        }
        
        Time:O(1)
        Space:O(n)
        
        */

      if(!map.containsKey(key)){
          return -1;
      }
      else{
          Node node = map.get(key);
          DoubleLinkedListRemoveMiddle(node);
          DoubleLinkedListAddFirst(node);
          return node.value;
          
      }

    }
    
    //INSERT
    public void add(int key, int value) {
        /*
        { 1:|1,1| ,2:|2,32|       h--|1,1|--|2,2|--t        -- !if map.containsKey(key)
                                                                   create a newNode with key and value
                                                                   add key as key and newNnode as value to map
                                                                   add newNode at beginning of doubly linkedList so that least recent can be at right to be removed
                                                                
                                                                   increment size
                                                                   if(size>maxSize)
                                                                      remove the lastNode of doubly linkedList because it is the least recent
                                                                      remove the  lastNode from map
                                                                      decrement size 
                                                                
                                                                else
                                                                   add key as key and node with replaced value as value to map
                                                                   remove node from middle of doubly linkedList and  add node at beginning of doubly linkedList  so that least recent  can be at right to be removrd
                                                                 
                                                                

        Time:O(1)
        Space:O(n)
        */
        
      if(!map.containsKey(key)){
        Node newNode = new Node();newNode.key = key;newNode.value = value;
        map.put(key, newNode);
        DoubleLinkedListAddFirst(newNode);
          
        size++;
        if(size > maxSize){
          Node node = DoubleLinkedListRemoveLast();
          map.remove(node.key);
          size--;
        }
      }
      else{
            Node node = map.get(key);node.value = value;
            map.put(key,node);
            DoubleLinkedListRemoveMiddle(node);
            DoubleLinkedListAddFirst(node);
        }

    }

}

