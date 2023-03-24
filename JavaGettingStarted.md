### JDK Components
 We did JDK installation our last session, today we'll see why we need JDK.

![jdk. png](./images/jdk.png)
   
### My First Java Program

```
class Simple{  
public static void main(String[] args){  
System.out.println("Hello Java");
   }  
}
```

### Common Signature
Every program needs a place to start its execution; talking about Java programs, that's the main method.The most common main method template is:

```
   public static void main(String[] args) { }
```
   
That's the way we've learned it, that's the way the IDE autocompletes the code for us. But that's not the only form this method can assume, there are some valid variants we can use and not every developer pays attention to this fact.

Before we dive into those method signatures, let's review the meaning of each keyword of the common signature:

**public** – access modifier, meaning global visibility
**static** – the method can be accessed straight from the class, we don’t have to instantiate an object to have a reference and use it
**void** – means that this method doesn't return a value
**main** – the name of the method, that’s the identifier JVM looks for when executing a Java program
As for the args parameter, it represents the values received by the method. This is how we pass arguments to the program when we first start it.


In the next example, we're checking args to decide whether to load test or production parameters:

```
public static void main(String[] args) {
if (args.length > 0) {
if (args[0].equals("test")) {
// load test parameters
} else if (args[0].equals("production")) {
// load production parameters
}
}
}
```

It's always good to remember that IDEs can also pass arguments to the program.

### Different Ways to Write a main() Method

Let's check some different ways to write the main method. Although they're not very common, they're valid signatures.

Note that none of these are specific to the main method, they can be used with any Java method but they are also a valid part of the main method.

The square brackets can be placed near String, as in the common template, or near args on either side:

```
public static void main(String []args) { }
```
```
public static void main(String args[]) { }
```
Arguments can be represented as varargs:

```
public static void main(String...args) { }
```

### Having More Than One main() Methods
We can also define more than one main method inside our application.

In fact, some people use it as a primitive test technique to validate individual classes (although test frameworks like JUnit are way more indicated for this activity).

To specify which main method the JVM should execute as the entry point of our application, we use the MANIFEST.MF file. Inside the manifest, we can indicate the main class:

```
Main-Class: mypackage.ClassWithMainMethod
```

This is mostly used when creating an executable .jar file. We indicate which class has the main method to start the execution, through the manifest file located at META-INF/MANIFEST.MF (encoded in UTF-8).


Now, we’ll look at two basic building blocks of the Java programming language – classes and objects. They're basic concepts of Object Oriented Programming (OOP), which we use to model real-life entities.

In OOP, classes are blueprints or templates for objects. We use them to describe types of entities.

On the other hand, objects are living entities, created from classes. They contain certain states within their fields and present certain behaviors with their methods.

### Classes
Simply put, a class represent a definition or a type of object. In Java, classes can contain fields, constructors, and methods.

Let's see an example using a simple Java class representing a Car:

```
class Car {

    // fields
    String type;
    String model;
    String color;
    int speed;

    // constructor
    Car(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }
    
    // methods
    int increaseSpeed(int increment) {
        this.speed = this.speed + increment;
        return this.speed;
    }
    
    // ...
}
```

This Java class represents a car in general. We can create any type of car from this class. We use fields to hold the state and a constructor to create objects from this class.

Every Java class has an empty constructor by default. We use it if we don't provide a specific implementation as we did above. Here's how the default constructor would look for our Car class:

```
Car(){}
```

This constructor simply initializes all fields of the object with their default values. Strings are initialized to null and integers to zero.

Now, our class has a specific constructor because we want our objects to have their fields defined when we create them:

```
Car(String type, String model) {
// ...
}
```
To sum up, we wrote a class that defines a car. Its properties are described by fields, which contain the state of objects of the class, and its behavior is described using methods.

### Objects
While classes are translated during compile time, objects are created from classes at runtime.

Objects of a class are called instances, and we create and initialize them with constructors:

```
Car focus = new Car("Ford", "Focus", "red");
Car auris = new Car("Toyota", "Auris", "blue");
Car golf = new Car("Volkswagen", "Golf", "green");
```
Now, we've created different Car objects, all from a single class. This is the point of it all, to define the blueprint in one place, and then, to reuse it many times in many places.

So far, we have three Car objects, and they're all parked since their speed is zero. We can change this by invoking our increaseSpeed method:

```
focus.increaseSpeed(10);
auris.increaseSpeed(20);
golf.increaseSpeed(30);
```
Now, we've changed the state of our cars – they're all moving at different speeds.

Furthermore, we can and should define access control to our class, its constructors, fields, and methods. We can do so by using access modifiers, as we'll see in the next section.

### Access Modifiers
In the previous examples, we omitted access modifiers to simplify the code. By doing so, we actually used a default package-private modifier. That modifier allows access to the class from any other class in the same package.

Usually, we'd use a public modifier for constructors to allow access from all other objects:

```
public Car(String type, String model, String color) {
// ...
}
```

Every field and method in our class should've also defined access control by a specific modifier. Classes usually have public modifiers, but we tend to keep our fields private.

Fields hold the state of our object, therefore we want to control access to that state. We can keep some of them private, and others public. We achieve this with specific methods called getters and setters.

Let's have a look at our class with fully-specified access control:

```
public class Car {
private String type;
// ...

    public Car(String type, String model, String color) {
       // ...
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    // ...
}
```

### Declaration vs. Initialization

Let's start by making sure that we're on the same page.

Declaration is the process of defining the variable, along with its type and name.

Here we're declaring the id variable:

```
int id;
```

Initialization, on the other hand, is all about assigning a value:

```
id = 1;
```
To demonstrate, we'll create a User class with a name and id properties:

```
public class User {
private String name;
private int id;

    // standard constructor, getters, setters,
}
```


Next, we'll see that initialization works differently depending on the type of field we're initializing.

### Objects vs. Primitives
Java provides two types of data representation: primitive types and reference types. In this section, we'll discuss the differences between the two with regards to initialization.

Java has eight built-in data types, referred to as Java primitive types; variables of this type hold their values directly.


Reference types hold references to objects (instances of classes). Unlike primitive types that hold their values in the memory where the variable is allocated, references don't hold the value of the object they refer to.

Instead, a reference points to an object by storing the memory address where the object is located.

Note that Java doesn't allow us to discover what the physical memory address is. Rather, we can only use the reference to refer to the object.

Let's look at an example that declares and initializes a reference type out of our User class:

```
@Test
public void whenIntializedWithNew_thenInstanceIsNotNull() {
User user = new User();

    assertThat(user).isNotNull();
}
```

As we can see, a reference can be assigned to a new object by using the keyword new, which is responsible for creating the new User object.

### Variable Scope
   In the following sections, we'll look at the different types of scopes that a variable in Java can exist within, and how this affects the initialization process.

 **Instance and Class Variables**
Instance and class variables don't require us to initialize them. As soon as we declare these variables, they're given a default value:

Now let's try to define some instance and class-related variables, and test whether they have a default value or not:

```
public void whenValuesAreNotInitialized_thenUserNameAndIdReturnDefault() {
User user = new User();

    assertThat(user.getName()).isNull();
    assertThat(user.getId() == 0);
}
```

**Local Variables**
Local variables must be initialized before use, as they don't have a default value and the compiler won't let us use an uninitialized value.

For example, the following code generates a compiler error:

```
public void print(){
int i;
System.out.println(i);
}
```

References:
https://docs.oracle.com/javase/tutorial/
https://www.baeldung.com/get-started-with-java-series