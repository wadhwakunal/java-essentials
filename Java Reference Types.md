# Reference Data Types in Java

Java provides two types of data types primitive and reference data type. The primitive data types are
predefined in Java that serves as a fundamental building block while the reference data type refers to 
where data is stored.

In Java, non-primitive data types are known as reference types. 
In other words, a variable of class type is called reference data type.
It contains the address (or reference) of dynamically created objects. 
For example, if Demo is a class, and we have created its object d, then the variable d is known as a reference type.

It refers to objects. It is not pre-defined. It is created by the programmer if required. 
The reference types hold the references of objects. All reference types are a subclass of type java.lang.Object.
It provides access to the objects stored in the memory.

The examples of reference data types are class, interface, String, Arrays, etc.

## Java Reference Types

There are the following five types of reference types in Java:

* Class-> It is a set of instructions. It describes the content of the object.
* Array->	It provides the fixed-size data structure that stores the elements of the same type.
* Annotations-> It provides a way to associate metadata with program elements.
* Interface-> It is implemented by Java classes.
* Enumeration-> It is a special kind of class that is type-safe. Each element inside the enum is an instance of that enum.

## Class in Java

A class is a group of objects which have common properties. 
It is a template or blueprint from which objects are created. It is a logical entity. It can't be physical.

A class in Java can contain:
Fields
Methods
Constructors
Blocks
Nested class and interface

### Syntax to declare a class:
````
class <class_name>{  
field;  
method;  
}  
````

#### Class Example
````
//Java Program to illustrate how to define a class and fields  
//Defining a Student class.  
class Student{  
    //defining fields  
    int id;//field or data member or instance variable  
    String name;  
    //creating main method inside the Student class  
    public static void main(String args[]){  
        //Creating an object or instance  
        Student s1=new Student();//creating an object of Student  
        //Printing values of the object  
        System.out.println(s1.id);//accessing member through reference variable  
        System.out.println(s1.name);  
    }  
}  
````
## Arrays in Java

Normally, an array is a collection of similar type of elements which has contiguous memory location.

Java array is an object which contains elements of a similar data type. Additionally, The elements of an array are stored in a contiguous memory location. It is a data structure where we store similar elements. We can store only a fixed set of elements in a Java array.

Array in Java is index-based, the first element of the array is stored at the 0th index, 2nd element is stored on 1st index and so on.

#### Advantages
* Code Optimization: It makes the code optimized, we can retrieve or sort the data efficiently.
* Random access: We can get any data located at an index position.

#### Disadvantages
* Size Limit: We can store only the fixed size of elements in the array. It doesn't grow its size at runtime. To solve this problem, collection framework is used in Java which grows automatically.

### Types of Array in java
There are two types of array.

* Single Dimensional Array
* Multidimensional Array

#### Single Dimensional Array in Java
````
//Java Program to illustrate how to declare, instantiate, initialize  
//and traverse the Java array.  
class Testarray{  
    public static void main(String args[]){  
        int a[]=new int[5];//declaration and instantiation  
        a[0]=10;//initialization  
        a[1]=20;  
        a[2]=70;  
        a[3]=40;  
        a[4]=50;  
        //traversing array  
        for(int i=0;i<a.length;i++)//length is the property of array  
            System.out.println(a[i]);  
    }
}  
````
#### Multidimensional Array in Java
In such case, data is stored in row and column based index (also known as matrix form).
````
//Java Program to illustrate the use of multidimensional array  
class Testarray3{  
    public static void main(String args[]){  
        //declaring and initializing 2D array  
        int arr[][]={{1,2,3},{2,4,5},{4,4,5}};  
        //printing 2D array  
        for(int i=0;i<3;i++){  
            for(int j=0;j<3;j++){  
                System.out.print(arr[i][j]+" ");  
            }  
            System.out.println();  
        }  
    }   
}  
````
## Interface in Java
An interface in Java is a blueprint of a class. It has static constants and abstract methods.
The interface in Java is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body. It is used to achieve abstraction and multiple inheritance in Java.
In other words, you can say that interfaces can have abstract methods and variables. It cannot have a method body.
#### Why use Java interface?
There are mainly three reasons to use interface. They are given below.
* It is used to achieve abstraction.
* By interface, we can support the functionality of multiple inheritance.
* It can be used to achieve loose coupling.

### Java Interface Example
In this example, the Printable interface has only one method, and its implementation is provided in the A6 class.
````
interface printable{  
    void print();  
}  
class A6 implements printable{  
    public void print(){System.out.println("Hello");}  
  
    public static void main(String args[]){  
        A6 obj = new A6();  
        obj.print();  
    }  
}  
````
## Annotations in Java

Java Annotation is a tag that represents the metadata i.e. attached with class, interface, methods or fields to indicate some additional information which can be used by java compiler and JVM.

Annotations in Java are used to provide additional information, so it is an alternative option for XML and Java marker interfaces.

* Built-In Java Annotations used in Java code->
@Override @SuppressWarnings
@Deprecated
* Built-In Java Annotations used in other annotations->
@Target
@Retention
@Inherited
@Documented

### Understanding Built-In Annotations
* #### @Override 

@Override annotation assures that the subclass method is overriding the parent class method. If it is not so, compile time error occurs.
Sometimes, we do the silly mistake such as spelling mistakes etc. So, it is better to mark @Override annotation that provides assurity that method is overridden.
````
class Animal{  
    void eatSomething(){System.out.println("eating something");}  
}  
  
class Dog extends Animal{  
    @Override  
    void eatsomething(){System.out.println("eating foods");}//should be eatSomething  
}  
  
class TestAnnotation1{  
    public static void main(String args[]){  
        Animal a=new Dog();  
        a.eatSomething();  
    }
}  
````
* #### @SuppressWarnings

@SuppressWarnings annotation: is used to suppress warnings issued by the compiler.
````
import java.util.*;  
class TestAnnotation2{  
    @SuppressWarnings("unchecked")  
    public static void main(String args[]){  
        ArrayList list=new ArrayList();  
        list.add("sonoo");  
        list.add("vimal");  
        list.add("ratan");  
  
        for(Object obj:list)  
            System.out.println(obj);  
    }
}  
````
* #### @Deprecated

@Deprecated annotation marks that this method is deprecated so compiler prints warning. It informs user that it may be removed in the future versions. So, it is better not to use such methods.
````
class A{  
    void m(){System.out.println("hello m");}  
  
    @Deprecated  
    void n(){System.out.println("hello n");}  
}  
  
class TestAnnotation3{  
    public static void main(String args[]){  
  
        A a=new A();  
        a.n();  
    }
}  
````

### Types of Annotation

There are three types of annotations.

* Marker Annotation

An annotation that has no method, is called marker annotation

* Single-Value Annotation

An annotation that has one method, is called single-value annotation.
* Multi-Value Annotation

An annotation that has more than one method, is called Multi-Value annotation

## Enums in Java

The Enum in Java is a data type which contains a fixed set of constants.

It can be used for days of the week (SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY) , directions (NORTH, SOUTH, EAST, and WEST), season (SPRING, SUMMER, WINTER, and AUTUMN or FALL), colors (RED, YELLOW, BLUE, GREEN, WHITE, and BLACK) etc. According to the Java naming conventions, we should have all constants in capital letters. So, we have enum constants in capital letters.

Java Enums can be thought of as classes which have a fixed set of constants (a variable that does not change). The Java enum constants are static and final implicitly. It is available since JDK 1.5.

Enums are used to create our own data type like classes. The enum data type (also known as Enumerated Data Type) is used to define an enum in Java. Unlike C/C++, enum in Java is more powerful.

Java Enum internally inherits the Enum class, so it cannot inherit any other class, but it can implement many interfaces. We can have fields, constructors, methods, and main methods in Java enum.

#### Points to remember for Java Enum
* Enum improves type safety
* Enum can be easily used in switch
* Enum can be traversed
* Enum can have fields, constructors and methods
* Enum may implement many interfaces but cannot extend any class because it internally extends Enum class

#### Simple Example of Java Enum
````
class EnumExample1{  
    //defining the enum inside the class  
    public enum Season { WINTER, SPRING, SUMMER, FALL }  
    //main method  
    public static void main(String[] args) {  
        //traversing the enum  
        for (Season s : Season.values())  
            System.out.println(s);  
        }
    }
}      
````
#### Output:
````
WINTER
SPRING
SUMMER
FALL
````
## Comparing Reference Type

We can also compare the reference types in Java. Java provides two ways to compare reference types:

### By using the equal (==) operator
It compares the memory locations of the objects. If the memory address (reference) of both objects is the same, the objects are equal. Note that it does not compare the contents of the object. For example:
````
Demo d1 = new Demo("Atlanta"); //creating a reference of Demo class  
Demo d2 = d1; //assigning the reference d1 into d2  
if(d1=d2) //comparing reference   
````

### By using the String.equals() Method
The method belongs to the String class. It overrides the equals() method of the Object class. It also uses the equal operator (==) for comparing the reference type. For example, consider the following code snippet:

````
String str1="JAVA";    
String str2="JAVA";    
String str3="java";    
System.out.println(str1.equals(str2));     //returns true because content and case is same    
System.out.println(str1.equals(str3));   //returns false because case is not same 
````

## Copying Reference Type

There are two possibilities when we copy reference types, either a copy of the reference to an object is made or an actual copy (creating a new copy) of the object is made.

In the following example, we have assigned a reference to the object. If we made any changes in the object, it will also reflect the reference and vice-versa.
````
Sum s1 = new Sum();  
Sum s2= s1;  
````
[Link] https://www.javatpoint.com/reference-data-types-in-java