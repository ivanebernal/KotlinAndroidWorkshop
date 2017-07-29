# Kotlin
Some of you might be familiar with Java. It is the programming langage originally used to develop Android apps. 
Now google officially added Kotlin support to Android Studio, which is very good news! Kotlin is a statically-typed programming
language which runs on the JVM. Both languages are very different from each other and have their own pros and cons. 
I personally preffer Kotlin because it's easier to write and has much less boilerplate code (let's say "noisy" code).

To have more perspective, let's see some of the main and basic differences between the two languages.

## Basic Syntax

### Variable declaration

Java:
```java
//mutable variables
private int number;
private String name;

//final variables
private final int number = 8;
private final String name = "Ivan";
```

Kotlin:
```kotlin
//mutable variables
var number: Int = 0
var name: String = ""

//final variables
val number = 8 //Type Int is inferred
val name = "" //Type String is inferred
```

### Function definition

Java:
```java
public int sum(int a, int b){
  return a+b;
}
```

Kotlin:
```kotlin
fun sum(a: Int, b: Int): Int{
  return a+b
}

//OR

fun sum(a: Int, b: Int) = a+b
```

### Conditionals

Java:
```java
public int maxOf(int a, int b){
  if(a>b) return a;
  else return b;
}
```

Kotlin:
```kotlin
fun maxOf(a: Int, b: Int){
  if(a>b) return a
  else return b
}

//OR

fun maxOf(a: Int, b: Int) = if(a>b) a else b
```

### Null

Java:
```java
private int age = null;
```

Kotlin:
```kotlin
var age: Int = null //NOT VALID
var age: Int? = null //Valid
```

For more Kotlin basic syntax please refer to [Kotlin docs](https://kotlinlang.org/docs/reference/basic-syntax.html)

## Classes

### Class declaration

Java:
```java
public final class Person{
}
```

Kotlin:
```kotlin
class Person{ //final by default, if we want it to be inherited we need the open
}
```

### Constructor

Java:
```java
public final class Person{
  private String name;
  private int age;
  
  public Person(String name, int age){
    this.name = name;
    this.age = age;
  }
}
```

Kotlin:
```kotlin
class Person(val name: String, val age: Int){
}
```

### Instances

Java:
```java
private Person ivan = new Person("Ivan", 24);
```

Kotlin:
```kotlin
private val ivan = Person("Ivan", 24)
```

### Inheritance

(Assume previous classes were not final and open)

Java:
```java
public class Male extends Person{
}
```

Kotlin:
```kotlin
class Male(val name: String, val age: Int): Person(name, age){

}
```

Implementing interfaces

Java:
```java
public class Male extends Person implements Programmer{
  @Override
  void code(){
    //Code
  }
  
  @Override
  void eat(){
    //Eat
  }
}

interface Programmer{
  void code();
  void eat();
}
```

Kotlin:
```kotlin
class Male(val name: String, val age: Int): Person(name, age), Programmer{
  override fun code(){
    //Code
  }
  override fun eat(){
    //Eat
  }
}

interface Programmer{
  fun code()
  fun eat()
}
```

For more about Classes please refer to [Kotlin docs](https://kotlinlang.org/docs/reference/classes.html)

## More

You can find more about Kotlin in the [Reference webpage](https://kotlinlang.org/docs/reference/).
And now, let's continue with our app!
