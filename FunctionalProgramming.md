# Functional Programming with Java
It is a declarative style of programming rather than imperative. The basic objective of this style of programming is to make code more concise, less complex, more predictable, and easier to test compared to the legacy style of coding. Functional programming deals with certain key concepts such as pure function, immutable state, assignment-less programming etc. 
### lambda expressions
Provide the ability to pass behaviors to methods. Prior to Java 8, if you want to pass behavior to a method, then your only option was the Anonymous class, which will take 6 lines of code, and the most important line, which defines the behavior is lost in between. Lambda expression replaces anonymous.

```dtd
//Before Java 8:
        new Thread(new Runnable() { 
                @Override public void run() { 
                    System.out.println("Before Java8, too much code for too little to do"); 
                }
            }
        ).start();

 //Java 8 way: 
 new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();

```
<b>Iterating over List using Lambda expressions</b>
```dtd
List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//Prior Java 8 :
for (String feature : features) { 
        System.out.println(feature); 
} 

//In Java 8:  
features.forEach(n -> System.out.println(n)); 

// Even better use Method reference feature of Java 8 
// method reference is denoted by :: (double colon) operator 
// looks similar to score resolution operator of C++ 
features.forEach(System.out::println);
```
### Streams 
Java provides a new additional package in Java 8 called java.util.stream. This package consists of classes, interfaces and enum to allows functional-style operations on the elements
+ Stream is functional in nature. Operations performed on a stream does not modify it's source.
+ Stream is lazy and evaluates code only when required.
+ The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.

![img.png](.\images\img.png)


![img_1.png](.\images\img_1.png)

```dtd
List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    System.out.println("original list: " + numbers);
    List<Integer> even = numbers.stream()
                                .map(s -> Integer.valueOf(s))
                                .filter(number -> number % 2 == 0)
                                .collect(Collectors.toList());
  
    System.out.println("processed list, only even numbers: " + even);

```
### Functions
A function is a block of statements that performs a specific task. Functions accept data, process it, and return a result. Functions are written primarily to support the concept of re usability. Once a function is written, it can be called easily, without having to write the same code again and again.

Functional Programming revolves around first class functions, pure functions and high order functions.

* A First Class Function is the one that uses first class entities like String, numbers which can be passed as arguments, can be returned or assigned to a variable.

* A High Order Function is the one which can take a function as an argument and/or can return a function.

* A Pure Function is the one which has no side effect while its execution.

### First Class Function
A first class function can be treated as a variable. That means it can be passed as a parameter to a function, it can be returned by a function or can be assigned to a variable as well. Java supports first class function using lambda expression. A lambda expression is analogous to an anonymous function. See the example below −
````
public class Tester {
   public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5};
      SquareMaker squareMaker = item -> item * item;
      for(int i = 0; i < array.length; i++){
         System.out.println(squareMaker.square(array[i]));
      }
   }
}
interface SquareMaker {
   int square(int item);
}
````
Output
````
1
4
9
16
25
````
Here we have created the implementation of square function using a lambda expression and assigned it to variable squareMaker.

### High Order Function
A high order function either takes a function as a parameter or returns a function. In Java, we can pass or return a lambda expression to achieve such functionality.
````
import java.util.function.Function;

public class Tester {
   public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5};

      Function<Integer, Integer> square = t -> t * t;        
      Function<Integer, Integer> cube = t -> t * t * t;

      for(int i = 0; i < array.length; i++){
         print(square, array[i]);
      }        
      for(int i = 0; i < array.length; i++){
         print(cube, array[i]);
      }
   }

   private static <T, R> void print(Function<T, R> function, T t ) {
      System.out.println(function.apply(t));
   }
}
````
Output
````
1
4
9
16
25
1
8
27
64
125
````
### Pure Function
A pure function does not modify any global variable or modify any reference passed as a parameter to it. So it has no side-effect. It always returns the same value when invoked with same parameters. Such functions are very useful and are thread safe. In example below, sum is a pure function.
The return value of the function depends only on the input parameters passed to the function.
````
//Pure Function 
public class Tester {
   public static void main(String[] args) {
      int a, b;
      a = 1;
      b = 2;
      System.out.println(sum(a, b));
   }

   private static int sum(int a, int b){
      return a + b;
   }
}

//Non pure function 
public class ObjectWithNonPureFunction{
    private int value = 0;

    public int add(int nextValue) {
        this.value += nextValue;
        return this.value;
    }
}

````
Output
````
3
````
##  Composition
Functional composition refers to a technique where multiple functions are combined to a single function. We can combine lambda expression together. Java provides inbuilt support using Predicate and Function classes. Following example shows how to combine two functions using predicate approach.
````
import java.util.function.Predicate;
public class Tester {
   public static void main(String[] args) {
      Predicate<String> hasName = text -> text.contains("name");
      Predicate<String> hasPassword = text -> text.contains("password");
      Predicate<String> hasBothNameAndPassword = hasName.and(hasPassword);
      String queryString = "name=test;password=test";
      System.out.println(hasBothNameAndPassword.test(queryString));
   }
}
````
Output
````
true
````
Predicate provides and() and or() method to combine functions. Whereas Function provides compose and andThen methods to combine functions. Following example shows how to combine two functions using Function approach.
````
import java.util.function.Function;
public class Tester {
   public static void main(String[] args) {
      Function<Integer, Integer> multiply = t -> t *3;
      Function<Integer, Integer> add = t -> t  + 3;
      Function<Integer, Integer> FirstMultiplyThenAdd = multiply.compose(add);
      Function<Integer, Integer> FirstAddThenMultiply = multiply.andThen(add);
      System.out.println(FirstMultiplyThenAdd.apply(3));
      System.out.println(FirstAddThenMultiply.apply(3));
   }
}
````
Output
````
18
12
````
## Optional class 

Java 8 introduced a new public final class Optional in java.util package. It is used to deal with NullPointerException in java application. It provides the methods to easily check whether a variable has null value or not

Commonly used methods.
+ Optional.ofNullable(): It returns a Non-empty Optional if the given object has a value, otherwise it returns an empty Optional.
+ isPresent(): It is used check whether the particular Optional object is empty or no-empty.
+ ifPresent(): It only executes if the given Optional object is non-empty.

```dtd
//Without optional
     String[] str = new String[10];
     String lowerCaseString = str[4].toLowerCase();
     System.out.print(lowerCaseString);  

//With optional

     String[] str = new String[10];
     Optional<String> checkNull = Optional.ofNullable(str[4]);
    //Check for value is present or not
    if(checkNull.isPresent()){
    String lowerCaseString = str[4].toLowerCase();
    System.out.print(lowerCaseString);
    }else  {
    System.out.println("String value is not present");
    }  
```

```dtd
String[] str = new String[10];
// Setting value for 4th index
str[4] = "Optional class example at PS";
// It returns an empty instance of Optional class
Optional<String> empty = Optional.empty();
System.out.println(empty);
// It returns a non-empty Optional
Optional<String> value = Optional.of(str[4]);
// If value is present, it returns an Optional otherwise returns an empty Optional
System.out.println("Filtered value: "+value.filter((s)->s.equals("Abc")));
System.out.println("Filtered value: "+value.filter((s)->s.equals("Optional class example at PS")));
// It returns value of an Optional. if value is not present, it throws an NoSuchElementException
System.out.println("Getting value: "+value.get());
// It returns hashCode of the value
System.out.println("Getting hashCode: "+value.hashCode());
// It returns true if value is present, otherwise false
System.out.println("Is value present: "+value.isPresent());
// It returns non-empty Optional if value is present, otherwise returns an empty Optional
System.out.println("Nullable Optional: "+Optional.ofNullable(str[5]));
// It returns value if available, otherwise returns specified value,
System.out.println("orElse: "+value.orElse("Value is not present"));
System.out.println("orElse: "+empty.orElse("Value is not present"));
//printing value by using method reference
value.ifPresent(System.out::println);
```

## Closure
A closure is a function which is a combination of function along with its surrounding state. A closure function generally have access to outer function's scope. In the example given below, we have created a function getWeekDay(String[] days) which returns a function which can return the text equivalent of a weekday. Here getWeekDay() is a closure which is returning a function surrounding the calling function's scope.

Following example shows how Closure works.
````
import java.util.function.Function;

public class Tester {
   public static void main(String[] args) {
      String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday",
         "Friday", "Saturday", "Sunday" };
      Function<Integer, String> getIndianWeekDay = getWeekDay(weekDays);
      System.out.println(getIndianWeekDay.apply(6));      
   }

   public static Function<Integer, String> getWeekDay(String[] weekDays){
      return index -> index >= 0 ? weekDays[index % 7] : null;
   }
}
````
Output
````
Sunday
````
## Currying
Function Currying is a concept of breaking a function with many arguments into many functions with single argument in such a way, that the output is same. In other words, its a technique of simplifying a multi-valued argument function into single-valued argument multi-functions.

![img_2.png](.\images\img_2.png)

See the below equation.
````
(1 + 2 + 3) = 1 + (2 + 3) = 1 + 5 = 6

 // Using Java 8 Functions
// to create lambda expressions for functions
// and with this, applying Function Currying

// Curried Function for Adding u, v & w
Function<Integer,
         Function<Integer,
                  Function<Integer, Integer> > >
    triadder = u -> w -> v -> u + w + v;

// Calling the curried functions

// Calling Curried Function for Adding u, v & w
System.out.println("Add 2, 3, 4 :"
                   + triadder
                         .apply(2)
                         .apply(3)
                         .apply(4));
````

## Reducing
In functional programming, reducing is a technique to reduce a stream of values to a single result by apply a function on all the values. Java provides reduce() function in a Stream class from Java 8 onwards. A stream has inbuilt reducing methods like sum(), average(), count() as well which works on all elements of the stream and returns the single result.

Following example shows how Reducing works.
````
import java.util.stream.IntStream;

public class FunctionTester {
   public static void main(String[] args) {

      //1 * 2 * 3 * 4 = 24
      int product = IntStream.range(1, 5) 
         .reduce((num1, num2) -> num1 * num2)
         .orElse(-1); 

      //1 + 2 + 3 + 4 = 10
      int sum =  IntStream.range(1, 5).sum();

      System.out.println(product);
      System.out.println(sum);
   } 
}
````
Output
````
24
10
````
[Link]https://www.tutorialspoint.com/functional_programming_with_java/index.htm