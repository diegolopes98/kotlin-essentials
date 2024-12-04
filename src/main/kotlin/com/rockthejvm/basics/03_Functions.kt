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
}
