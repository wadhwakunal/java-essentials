# Data Types 

Data types specify the different sizes and values that can be stored in the variable.It has no additional methods. There are two types of data types in Java:

## Primitive data types: 
These data types are already hard coded into the compiler to be recognized when the program is executed.
Primitive values do not share state with other primitive values. 
Example : The primitive data types include boolean, char, byte, short, int, long, float and double.
## Non-primitive data types: 
These data types are special types of data which are user defined, i,e, the program contains their definition.
Example : The non-primitive data types include Classes, Interfaces, and Arrays

##### There are 8 types of primitive data types:

boolean data type
byte data type
char data type
short data type
int data type
long data type
float data type
double data type


### boolean
The boolean data type has two possible values, either true or false.
Default value: false.
```
class BooleanTest {
public static void main(String[] args) {
        boolean flag = true;
        System.out.println(flag);
    }
}
```

### byte
The byte data type can have values from -128 to 127 (8-bit signed two's complement integer).
It’s used instead of int or other integer data types to save memory if it's certain that the value of a variable will be within [-128, 127].
Default value: 0
```
class ByteTest {
public static void main(String[] args) {

        byte range;
        range = 124;
        System.out.println(range);
    }
}
```
### short
The short data type can have values from -32768 to 32767 (16-bit signed two's complement integer).
It’s used instead of other integer data types to save memory if it’s certain that the value of the variable will be within [-32768, 32767].
Default value: 0
```
class ShortTest {
public static void main(String[] args) {

        short temperature;
        temperature = -200;
        System.out.println(temperature);
    }
}
```
### int
The int data type can have values from -2<sup>31</sup> to 2<sup>31</sup>-1 (32-bit signed two's complement integer)
```
class IntTest {
public static void main(String[] args) {

        int range = 42500;
        System.out.println(range);
    }
}
```

### long
The long data type can have values from -2<sup>63</sup> to 2<sup>63</sup>-1 (64-bit signed two's complement integer).
```
class LongTest {
public static void main(String[] args) {

        long range = 42332200000L;
        System.out.println(range);
    }
}
```
### double
The double data type is a double-precision 64-bit floating-point.
```
class DoubleTest {
public static void main(String[] args) {

        double number = 42.3;
        System.out.println(number);
    }
}
```
### float
The float data type is a single-precision 32-bit floating-point.
Default value: 0.0 (0.0f)
```
class FloatTest {
public static void main(String[] args) {

        float number = -42.3f;
        System.out.println(number);
    }
}
```

### char
It’s a 16-bit Unicode character.
```
class CharTest {
public static void main(String[] args) {

        char letter = 'SGM';
        System.out.println(letter);
    }
}
```

## Naming conventions
In naming these variables, it is important to both stick to the rules and also convention.

The first rule is that names should start with a letter. While they can start with a - or a $ , it is not recommended to do as this is bad convention. Also, names are case sensitive, so make sure whatever case you use, you use it consistenly.

The second rule is that names should be defined using lowerCamelCase for consistency and ease of reading. This ensures that words are clearly separated and defined. No whitespace can be used in variable names!

The third and final rule is that names should always use full words to describe what it is used for! Try to limit the abbreviations if possible, unless they are consistently used and have been clearly defined, as you never know who is going to read your code!


## Comments

Single Line Comments. 
```
// Single Line Comment example
```
Multi line Comments
```
/*
This is a 
multi line comment example
*/
```

### Wrapper class
Wrapper class is a predefined class in java and wrapper class objects wrap primitive data type. In simple words, wrapper class converts the datatype to objects.

Primitive datatype are variables therefore it does not belong to any class and cannot be instantiated.

+ If we have to serialize a primitive value, it must first be converted into objects using wrapper classes. 
+ Wrapper classes help in working with Collection variables.

```dtd
public class WrapperClass {

public static int processedValue(Integer value) {
value = value + 10;
return value;
}

public static void main(String[] args) {
int i = 10;
Integer value = new Integer(i);
System.out.println(“Wrapper class object= “ + value);

//create a new object and store modified value, it will work
processedValue(value);
System.out.println(“Modified Value= “ + value);

}

}
```

### Autoboxing and Unboxing:
The automatic conversion of primitive data types into its equivalent Wrapper type is known as boxing and opposite operation is known as unboxing.

```
class BoxingExample1{  
  public static void main(String args[]){  
    int a=50;  
        Integer a2=new Integer(a);//Boxing  
  
        Integer a3=5;//Boxing  
          
        System.out.println(a2+" "+a3); 

        int a4 = a3; // Unboxing 
        
        System.out.println(a4); 
 }   
}  
```