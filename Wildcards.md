# Wildcards in Java

The question mark (?) is known as the wildcard in generic programming. It represents an unknown type. The wildcard can be used in a variety of situations such as the type of a parameter, field, or local variable; sometimes as a return type. Unlike arrays, different instantiations of a generic type are not compatible with each other, not even explicitly. This incompatibility may be softened by the wildcard if ? is used as an actual type parameter.

### Types of wildcards in Java

1. **Upper Bounded Wildcards:**
   These wildcards can be used when you want to relax the restrictions on a variable. For example, say you want to write a method that works on List < Integer >, List < Double >, and List < Number >, you can do this using an upper bounded wildcard.

To declare an upper-bounded wildcard, use the wildcard character (‘?’), followed by the extends keyword, followed by its upper bound.

public static void add(List<? extends Number> list)


```
// Java program to demonstrate Upper Bounded Wildcards

import java.util.Arrays;
import java.util.List;

class WildcardDemo {
   public static void main(String[] args)
   {

        // Upper Bounded Integer List
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
 
        // printing the sum of elements in list
        System.out.println("Total sum is:" + sum(list1));
 
        // Double list
        List<Double> list2 = Arrays.asList(4.1, 5.1, 6.1);
 
        // printing the sum of elements in list
        System.out.print("Total sum is:" + sum(list2));
    }
 
    private static double sum(List<? extends Number> list)
    {
        double sum = 0.0;
        for (Number i : list) {
            sum += i.doubleValue();
        }
 
        return sum;
    }
}
```

In the above program, list1 and list2 are objects of the List class. list1 is a collection of Integer and list2 is a collection of Double. Both of them are being passed to method sum which has a wildcard that extends Number. This means that list being passed can be of any field or subclass of that field. Here, Integer and Double are subclasses of class Number.

2. **Lower Bounded Wildcards:**
   It is expressed using the wildcard character (‘?’), followed by the super keyword, followed by its lower bound: <? super A>.

Syntax: Collectiontype <? super A>

```
// Java program to demonstrate Lower Bounded Wildcards

import java.util.Arrays;
import java.util.List;

class WildcardDemo {
   public static void main(String[] args)
   {
      // Lower Bounded Integer List
      List<Integer> list1 = Arrays.asList(4, 5, 6, 7);

      // Integer list object is being passed
      printOnlyIntegerClassorSuperClass(list1);
 
      // Number list
      List<Number> list2 = Arrays.asList(4, 5, 6, 7);
 
      // Integer list object is being passed
      printOnlyIntegerClassorSuperClass(list2);
   }
 
    public static void printOnlyIntegerClassorSuperClass(
        List<? super Integer> list)
    {
        System.out.println(list);
    }
}
```

Here arguments can be Integer or superclass of Integer(which is Number). The method printOnlyIntegerClassorSuperClass will only take Integer or its superclass objects. However, if we pass a list of types Double then we will get a compilation error. It is because only the Integer field or its superclass can be passed. Double is not the superclass of Integer.

Note: Use extend wildcard when you want to get values out of a structure and super wildcard when you put values in a structure. Don’t use wildcard when you get and put values in a structure. You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both.

3. **Unbounded Wildcard:**

This wildcard type is specified using the wildcard character (?), for example, List. This is called a list of unknown types. These are useful in the following cases –

When writing a method that can be employed using functionality provided in Object class.
When the code is using methods in the generic class that doesn’t depend on the type parameter

```
// Java program to demonstrate Unbounded wildcard

import java.util.Arrays;
import java.util.List;

class unboundedwildcardemo {
public static void main(String[] args)
{

        // Integer List
        List<Integer> list1 = Arrays.asList(1, 2, 3);
 
        // Double list
        List<Double> list2 = Arrays.asList(1.1, 2.2, 3.3);
 
        printlist(list1);
 
        printlist(list2);
    }
 
    private static void printlist(List<?> list)
    {
 
        System.out.println(list);
    }
}
```


_References:_
https://docs.oracle.com/javase/tutorial/

Geeks for Geeks