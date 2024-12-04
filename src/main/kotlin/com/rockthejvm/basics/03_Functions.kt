package com.rockthejvm.basics

// Unit == "void" in other languages
fun simpleFunction(arg: String): Unit {
    println("Just passed an argument: $arg") // string "template" or "interpolation"
    // 1000 lines of code
}

fun printHello() {
    println("I'm a simple no-arg function")
}

// concatenates aString count times
// concatenateString("Kotlin", 3) = "KotlinKotlinKotlin"
fun concatenateString(aString: String, count: Int): String {
    var result = ""
    for (i in 1..count)
        result += aString
    return result
}

// special syntax for single-expr functions
fun combineStrings(strA: String, strB: String): String =
    "$strA---$strB"

// recursion (functional programming)
/*
    csr("Kotlin", 3) =
    "Kotlin" + csr("Kotlin", 2) = "Kotlin" + "KotlinKotlin" = "KotlinKotlinKotlin"

    csr("Kotlin", 2) =
    "Kotlin" + csr("Kotlin", 1) = "Kotlin" + "Kotlin" = "KotlinKotlin"

    csr("Kotlin", 1) =
    "Kotlin" + csr("Kotlin", 0) = "Kotlin" + "" = "Kotlin"

    csr("Kotlin", 0) =
    ""
 */
fun concatenateStringRec(aString: String, count: Int): String =
    if (count <= 0) ""
    else aString + concatenateStringRec(aString, count - 1)

// default args
fun demoDefaultArg(regularArg: String = "Kotlin", intArg: Int = 0) =
    "$regularArg------$intArg"

// nested function calls
fun complexFunction(someArg: String) {
    // very complex code
    fun innerFunction(innerArg: Int) {
        println("Outer arg: $someArg, inner arg: $innerArg")
    }
    // can use nested functions just inside here
    innerFunction(45)
}

fun greet(name: String, age: Int) =
    "Hi, my name is $name and I am $age years old"

fun factorial(n: Int): Long {
    fun tailrec(n: Int, acc: Long = 1L): Long =
        when {
            n <= 0 -> acc
            else -> tailrec(n - 1, acc * n.toLong())
        }

    return tailrec(n)
}


fun fibonacci(n: Int): Long {
    fun tailrec(n: Int, a: Long = 0, b: Long = 1): Long =
        when (n){
            0 -> a
            1 -> b
            else -> tailrec(n=(n - 1), a=b, b=(a + b))
        }

    return tailrec(n, 0, 1)
}

fun isPrime(n: Int): Boolean {
    fun tailrec(n: Int, current: Int): Boolean =
        when {
            current == 1 -> true
            n < 2 -> false
            n % current == 0 -> false
            else -> tailrec(n, current -1)
        }

    return tailrec(n, n - 1)
}



fun main() {
    simpleFunction("Kotlin")
    simpleFunction("Scala")
    println(concatenateString("Kotlin", 3))
    println(concatenateString("Kotlin", 10))
    println(concatenateStringRec("Kotlin", 3))
    println(concatenateStringRec("Kotlin", 10))
    // default args demo
    val normalCall = demoDefaultArg("Kotlin", 32)
    val defaultCall = demoDefaultArg("Kotlin") // number 0 is passed automatically
    val multipleDefaultCall = demoDefaultArg() // both args are default
    val secondNormalCall = demoDefaultArg(intArg = 99) // name an argument
    val kotlinx3 = concatenateString(aString = "Kotlin", count = 3)

    complexFunction(someArg = kotlinx3)

    println("greet")
    println(greet("Severino", 1))

    println("factorial")
    println(factorial(0))
    println(factorial(10))
    println(factorial(-1))

    println("fibonacci")
    println(fibonacci(0))
    println(fibonacci(1))
    println(fibonacci(2))
    println(fibonacci(5))
    println(fibonacci(9))

    println("isPrime")
    println(isPrime(-1)) // false
    println(isPrime(0))  // false
    println(isPrime(1))  // false
    println(isPrime(2))  // true
    println(isPrime(3))  // true
    println(isPrime(4))  // false
    println(isPrime(5))  // true
    println(isPrime(97))   // true
    println(isPrime(99))   // false
    println(isPrime(2003))   // true
}
