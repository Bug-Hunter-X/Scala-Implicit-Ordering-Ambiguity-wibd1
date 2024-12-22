```scala
class MyClass[T](val value: T) {
  def myMethod(anotherValue: T)(implicit ordering: Ordering[T]): Boolean = {
    ordering.compare(value, anotherValue) == 0
  }
}

val instance1 = new MyClass(10)
val instance2 = new MyClass(10.0)
println(instance1.myMethod(10))
println(instance2.myMethod(10.0))

//Solution: Explicitly provide the Ordering
println(instance1.myMethod(10)(implicitly[Ordering[Int]]))
//Or by using a more specific type in MyClass declaration
class MyClass2[T: Ordering](val value: T){
  def myMethod(anotherValue: T): Boolean = implicitly[Ordering[T]].compare(value, anotherValue) == 0
}
val instance3 = new MyClass2(10)
val instance4 = new MyClass2(10.0)
println(instance3.myMethod(10))
println(instance4.myMethod(10.0))
//This will still not compile because of type mismatch
//println(instance3.myMethod(10.0))
```