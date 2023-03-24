## Multi Threading

### Process 
A process is a self contained execution environment and it can be seen as a program or application.

### Thread
Thread can be called lightweight process. Thread requires less resources to create and exists in the process, thread shares the process resources.

Every java application has at least one thread - <b>main thread</b>. Although there are so many other java threads running in background like memory management, system management, signal processing etc. But from application point of view - main is the first java thread and we can create multiple threads from it

#### Java Thread Benefits
+ Java Threads are lightweight compared to processes, it takes less time and resource to create a thread.
+ Threads share their parent process data and code
+ Context switching between threads is usually less expensive than between processes.
+ Thread intercommunication is relatively easy than process communication.

### Thread Lifecycle 
![img_4.png](.\images\img_4.png)

```dtd
class Thread1 implements Runnable{
	@Override
	public void run() {
		System.out.println("We are inside the run function."
				+ "The thread is in the \"" + Thread.currentThread().getState() + "\" state.");
	}
}

public class BasicThreadLifeCycleDemo{
	public static void printThreadState(Thread threadToCheck) {
		System.out.println("The thread is in the \"" + threadToCheck.getState() + "\" state.");
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		printThreadState(t1);
		t1.start();
		printThreadState(t1);
		for(int i=0; i<=10000; i++) {
			for(int j=0; j<=10000; j++) {
				
			}
		}
		printThreadState(t1);
	}
}

```

### How to Create a Java Thread?
Java lets you create a thread in following two ways:-

+ By implementing the Runnable interface.
+ By extending the Thread

```dtd
public class MyClass implements Runnable {
public void run(){
System.out.println("MyClass running");
   } 
}

Thread t1 = new Thread(new MyClass ());
t1.start();


public class MyClass extends Thread {
    public void run(){
        System.out.println("MyClass running");
    }
}

MyClass t1 = new MyClass ();
t1.start();
```
