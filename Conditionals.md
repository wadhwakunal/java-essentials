# Java Conditions Statements
In Java  user can check a
condition and execute certain parts of code depending on whether the condition is true or false. Java has many conditions statement using that various actions can be performed.

### if - Statement
First, the condition is evaluated. If the result of the evaluation is the value true, the then-statement is
executed, and the execution continues with the statement immediately following the if statement
### if else - Statement 
To choose between two alternatives
### else if - Statement
Use the else if statement to specify a previous condition if the first condition is false.

```
public class ConditionalStmtTest {
    public static void main(String[] args) {
        int time = 22;
        if (time < 10) {
            System.out.println("Publicis.");
        } else if (time < 18) {
            System.out.println("Sapient.");
        }  else {
            System.out.println("Publicis Sapient.");
        }
    }
}
```
### Ternary operator
If you want to replace multiple line of if else in single line then ternary operator can be used. 
```
variable = (condition) ? expressionTrue :  expressionFalse;

int time = 20;
String result = (time < 17) ? "PS." : "Publicis Sapient.";
System.out.println(result);
```

### Switch Case Statement
If you have many if else then it can be replaced with switch case statement. 

```
switch(expression) {
    case A:
    // code
    break;
    case B:
    // code
    break;
    default:
    // code
}


class Username {
    public static void main(String[] args) {
        
        String username = "John";
        
        switch (username) {
          case "Doe":
            System.out.println("Username is Doe");
            break;
          case "John":
            System.out.println("Username is John");
            break;
          case "Jane":
            System.out.println("Username is Jane");
            break;
            // Username is John
          default : 
            System.out.println("Username is PS");
        }
    }
}
```
**break**:  it breaks out of the switch block

**default**: If no condition is matched then default will be executed.

#### Limitation of switch case
+ float constant cannot be used in the switch as well as in the case.
+ You can not use the variable expression in case.
+ You cannot use the same constant in two different cases.
+ You cannot use the relational expression in case.