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
//The below line will result in a compilation error
println(instance1.myMethod(10.0)) 
```