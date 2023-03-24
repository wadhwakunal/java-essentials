## What is Collection in Java
A Collection represents a single unit of objects, i.e., a group.

## What is a framework in Java

* It provides ready-made architecture.
* It represents a set of classes and interfaces.

## What is Collection framework
The Collection framework represents a unified architecture for storing and manipulating a group of objects. It has:

1. Interfaces and its implementations, i.e., classes
2. Algorithm

## Hierarchy of Collection Framework
The java.util package contains all the classes and interfaces for the Collection framework.

## Iterator interface 
Iterator interface provides the facility of iterating the elements in a forward direction only.

#### Methods of Iterator interface

| NO. | Methods |Description|
|:----|:--------|:----------|
| 1   |public boolean hasNext()|It returns true if the iterator has more elements otherwise it returns false.|
|2|public Object next()|It returns the element and moves the cursor pointer to the next element.|
|3|public void remove()|It removes the last elements returned by the iterator. It is less used.|

## Iterable Interface
The Iterable interface is the root interface for all the collection classes. The Collection interface extends the Iterable interface and therefore all the subclasses of Collection interface also implement the Iterable interface

It contains only one abstract method. i.e.,
````
Iterator<T> iterator()  
````
It returns the iterator over the elements of type T.

## Collection Interface

The Collection interface is the interface which is implemented by all the classes in the collection framework. It declares the methods that every collection will have. In other words, we can say that the Collection interface builds the foundation on which the collection framework depends.

Some of the methods of Collection interface are Boolean add ( Object obj), Boolean addAll ( Collection c), void clear(), etc. which are implemented by all the subclasses of Collection interface.

## List Interface

List interface is the child interface of Collection interface. It inhibits a list type data structure in which we can store the ordered collection of objects. It can have duplicate values.

List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack.

To instantiate the List interface, we must use :
````
List <data-type> list1= new ArrayList();  
List <data-type> list2 = new LinkedList();  
List <data-type> list3 = new Vector();  
List <data-type> list4 = new Stack(); 
````
There are various methods in List interface that can be used to insert, delete, and access the elements from the list.
 
### ArrayList
The ArrayList class implements the List interface. It uses a dynamic array to store the duplicate element of different data types. The ArrayList class maintains the insertion order and is non-synchronized. The elements stored in the ArrayList class can be randomly accessed. 
The important points about the Java ArrayList class are:
* Java ArrayList class can contain duplicate elements.
* Java ArrayList class maintains insertion order.
* Java ArrayList class is non synchronized.
* Java ArrayList allows random access because the array works on an index basis.
* In ArrayList, manipulation is a little slower than the LinkedList in Java because a lot of shifting needs to occur if any element is removed from the array list.
````
import java.util.*;  
class TestCollection{  
    public static void main(String args[]){  
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
        list.add("Ravi");//Adding object in arraylist  
        list.add("Vijay");  
        list.add("Ravi");  
        list.add("Ajay");  
        //Traversing list through Iterator  
        Iterator itr=list.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
}  
````
Output:
````
Ravi
Vijay
Ravi
Ajay
````
### LinkedList
LinkedList implements the Collection interface. It uses a doubly linked list internally to store the elements. It can store the duplicate elements. It maintains the insertion order and is not synchronized. In LinkedList, the manipulation is fast because no shifting is required.
The important points about Java LinkedList are:
* Java LinkedList class can contain duplicate elements.
* Java LinkedList class maintains insertion order.
* Java LinkedList class is non synchronized.
* In Java LinkedList class, manipulation is fast because no shifting needs to occur.
* Java LinkedList class can be used as a list, stack or queue.
Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        LinkedList<String> al=new LinkedList<String>();  
        al.add("Ravi");  
        al.add("Vijay");  
        al.add("Ravi");  
        al.add("Ajay");  
        Iterator<String> itr=al.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
}  
````
Output:
````
Ravi
Vijay
Ravi
Ajay
````

### Vector

Vector uses a dynamic array to store the data elements. It is similar to ArrayList. However, It is synchronized and contains many methods that are not the part of Collection framework.

Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        Vector<String> v=new Vector<String>();  
        v.add("Ayush");  
        v.add("Amit");  
        v.add("Ashish");  
        v.add("Garima");  
        Iterator<String> itr=v.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
}  
````
Output:
````
Ayush
Amit
Ashish
Garima
````

### Stack
The stack is the subclass of Vector. It implements the last-in-first-out data structure, i.e., Stack. The stack contains all of the methods of Vector class and also provides its methods like boolean push(), boolean peek(), boolean push(object o), which defines its properties.

Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        Stack<String> stack = new Stack<String>();  
        stack.push("Ayush");  
        stack.push("Garvit");  
        stack.push("Amit");  
        stack.push("Ashish");  
        stack.push("Garima");  
        stack.pop();  
        Iterator<String> itr=stack.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
} 
````
Output:
````
Ayush
Garvit
Amit
Ashish
````
## Queue Interface
Queue interface maintains the first-in-first-out order. It can be defined as an ordered list that is used to hold the elements which are about to be processed. There are various classes like PriorityQueue, Deque, and ArrayDeque which implements the Queue interface.

Queue interface can be instantiated as:
````
Queue<String> q1 = new PriorityQueue();  
Queue<String> q2 = new ArrayDeque(); 
````
There are various classes that implement the Queue interface, some of them are given below.

### PriorityQueue

The PriorityQueue class implements the Queue interface. It holds the elements or objects which are to be processed by their priorities. PriorityQueue doesn't allow null values to be stored in the queue.

Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        PriorityQueue<String> queue=new PriorityQueue<String>();  
        queue.add("Amit Sharma");  
        queue.add("Vijay Raj");  
        queue.add("JaiShankar");  
        queue.add("Raj");  
        System.out.println("head:"+queue.element());  
        System.out.println("head:"+queue.peek());  
        System.out.println("iterating the queue elements:");  
        Iterator itr=queue.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
        queue.remove();  
        queue.poll();  
        System.out.println("after removing two elements:");  
        Iterator<String> itr2=queue.iterator();  
        while(itr2.hasNext()){  
            System.out.println(itr2.next());  
        }  
    }  
}  
````
Output:
````
head:Amit Sharma
head:Amit Sharma
iterating the queue elements:
Amit Sharma
Raj
JaiShankar
Vijay Raj
after removing two elements:
Raj
Vijay Raj
````
### Deque Interface
Deque interface extends the Queue interface. In Deque, we can remove and add the elements from both the side. Deque stands for a double-ended queue which enables us to perform the operations at both the ends.

Deque can be instantiated as:
````
Deque d = new ArrayDeque();  
````
### ArrayDeque
ArrayDeque class implements the Deque interface. It facilitates us to use the Deque. Unlike queue, we can add or delete the elements from both the ends.

ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.

Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String[] args) {  
        //Creating Deque and adding elements  
        Deque<String> deque = new ArrayDeque<String>();  
        deque.add("Gautam");  
        deque.add("Karan");  
        deque.add("Ajay");  
        //Traversing elements  
        for (String str : deque) {  
            System.out.println(str);  
        }  
    }  
}  
````
Output:
````
Gautam
Karan
Ajay
````
## Set Interface
Set Interface in Java is present in java.util package. It extends the Collection interface. It represents the unordered set of elements which doesn't allow us to store the duplicate items. We can store at most one null value in Set. Set is implemented by HashSet, LinkedHashSet, and TreeSet.

Set can be instantiated as:
````
Set<data-type> s1 = new HashSet<data-type>();  
Set<data-type> s2 = new LinkedHashSet<data-type>();  
Set<data-type> s3 = new TreeSet<data-type>();  
````
### Hash Set
HashSet class implements Set Interface. It represents the collection that uses a hash table for storage. Hashing is used to store the elements in the HashSet. It contains unique items.

Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        //Creating HashSet and adding elements  
        HashSet<String> set=new HashSet<String>();  
        set.add("Ravi");  
        set.add("Vijay");  
        set.add("Ravi");  
        set.add("Ajay");  
        //Traversing elements  
        Iterator<String> itr=set.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
}  
````
Output:
````
Vijay
Ravi
Ajay
````
### LinkedHashSet

LinkedHashSet class represents the LinkedList implementation of Set Interface. It extends the HashSet class and implements Set interface. Like HashSet, It also contains unique elements. It maintains the insertion order and permits null elements.

Consider the following example.
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        LinkedHashSet<String> set=new LinkedHashSet<String>();  
        set.add("Ravi");  
        set.add("Vijay");  
        set.add("Ravi");  
        set.add("Ajay");  
        Iterator<String> itr=set.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
}  
````
Output:
````
Ravi
Vijay
Ajay
````
## SortedSet Interface
SortedSet is the alternate of Set interface that provides a total ordering on its elements. The elements of the SortedSet are arranged in the increasing (ascending) order. The SortedSet provides the additional methods that inhibit the natural ordering of the elements.

The SortedSet can be instantiated as:
````
SortedSet<data-type> set = new TreeSet();  
````
### TreeSet
Java TreeSet class implements the Set interface that uses a tree for storage. Like HashSet, TreeSet also contains unique elements. However, the access and retrieval time of TreeSet is quite fast. The elements in TreeSet stored in ascending order.

Consider the following example:
````
import java.util.*;  
public class TestCollection{  
    public static void main(String args[]){  
        //Creating and adding elements  
        TreeSet<String> set=new TreeSet<String>();      
        set.add("Ravi");  
        set.add("Vijay");  
        set.add("Ravi");  
        set.add("Ajay");  
        //traversing elements  
        Iterator<String> itr=set.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }  
    }  
}  
````
Output:
````
Ajay
Ravi
Vijay
````
## Java Map Interface
A map contains values on the basis of key, i.e. key and value pair. Each key and value pair is known as an entry. A Map contains unique keys.

A Map is useful if you have to search, update or delete elements on the basis of a key.

### Java Map Hierarchy
There are two interfaces for implementing Map in java: Map and SortedMap, and three classes: HashMap, LinkedHashMap, and TreeMap.

A Map doesn't allow duplicate keys, but you can have duplicate values. HashMap and LinkedHashMap allow null keys and values, but TreeMap doesn't allow any null key or value.

A Map can't be traversed, so you need to convert it into Set using keySet() or entrySet() method.

|Class|Description|
|:----|:----------|
|HashMap|HashMap is the implementation of Map, but it doesn't maintain any order.|
|LinkedHashMap|LinkedHashMap is the implementation of Map. It inherits HashMap class. It maintains insertion order.|
|TreeMap|TreeMap is the implementation of Map and SortedMap. It maintains ascending order.|

### Java HashMap
Java HashMap class implements the Map interface which allows us to store key and value pair, where keys should be unique. If you try to insert the duplicate key, it will replace the element of the corresponding key. It is easy to perform operations using the key index like updation, deletion, etc. HashMap class is found in the java.util package.

HashMap in Java is like the legacy Hashtable class, but it is not synchronized. It allows us to store the null elements as well, but there should be only one null key. Since Java 5, it is denoted as HashMap<K,V>, where K stands for key and V for value. It inherits the AbstractMap class and implements the Map interface.

#### Points to remember
* Java HashMap contains values based on the key.
* Java HashMap contains only unique keys.
* Java HashMap may have one null key and multiple null values.
* Java HashMap is non synchronized.
* Java HashMap maintains no order.
* The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.

Let's see a simple example of HashMap to store key and value pair.
````
import java.util.*;  
public class HashMap{  
    public static void main(String args[]){  
        HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
        map.put(1,"Mango");  //Put elements in Map  
        map.put(2,"Apple");    
        map.put(3,"Banana");   
        map.put(4,"Grapes");   
       
        System.out.println("Iterating Hashmap...");  
        for(Map.Entry m : map.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());    
        }  
    }  
}  
````
Output:
````
Iterating Hashmap...
1 Mango
2 Apple
3 Banana
4 Grapes
````
### Java LinkedHashMap class
Java LinkedHashMap class is Hashtable and Linked list implementation of the Map interface, with predictable iteration order. It inherits HashMap class and implements the Map interface.

#### Points to remember
* Java LinkedHashMap contains values based on the key.
* Java LinkedHashMap contains unique elements.
* Java LinkedHashMap may have one null key and multiple null values.
* Java LinkedHashMap is non synchronized.
* Java LinkedHashMap maintains insertion order.
* The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.

Java LinkedHashMap Example
````
import java.util.*;  
class LinkedHashMap{  
    public static void main(String args[]){  
        LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();  
        hm.put(100,"Amit");  
        hm.put(101,"Vijay");  
        hm.put(102,"Rahul");  
  
        for(Map.Entry m:hm.entrySet()){  
            System.out.println(m.getKey()+" "+m.getValue());  
        }  
    }  
}  
````
Output:
````
100 Amit
101 Vijay
102 Rahul
````

### Java TreeMap class
Java TreeMap class is a red-black tree based implementation. It provides an efficient means of storing key-value pairs in sorted order.

The important points about Java TreeMap class are:

* Java TreeMap contains values based on the key. It implements the NavigableMap interface and extends AbstractMap class.
* Java TreeMap contains only unique elements.
* Java TreeMap cannot have a null key but can have multiple null values.
* Java TreeMap is non synchronized.
* Java TreeMap maintains ascending order.

Java TreeMap Example
````
import java.util.*;  
class TreeMap1{  
    public static void main(String args[]){  
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
        map.put(100,"Amit");    
        map.put(102,"Ravi");    
        map.put(101,"Vijay");    
        map.put(103,"Rahul");

        for(Map.Entry m:map.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());    
        }    
    }  
}  
````
Output:
````
100 Amit
101 Vijay
102 Ravi
103 Rahul
````
[Link]https://www.javatpoint.com/collections-in-java

[Link]https://www.javatpoint.com/java-map