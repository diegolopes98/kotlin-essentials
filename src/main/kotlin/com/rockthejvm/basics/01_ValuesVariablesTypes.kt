package com.rockthejvm.basics

// constant and for the whole file scope
const val appWideMoL: Int = 42 // computed first // static ???

fun main() {
    // val not re-assignable - value
    val meaningOfLife: Int = 42

    // var re-assignable - variable
    var objectiveInLife: Int = 32
    objectiveInLife = 10

    // type inference
    val meaningOfLife_v2 = 42
    val meaningOfLife_v3 = 40 + 2

    // common types: int, boolean, char, string, short, long, float, double
    val aBoolean: Boolean = true // false
    val aChar: Char = 'K'
    val aByte: Byte = 127 // 1 byte representation
    val aShort: Short = 1234 // 2 bytes
    val anInt: Int = 78 // 4 bytes
    val aLong: Long = 56785678235678L // 8 bytes
    val aFloat: Float = 2.4f // 4 bytes
    val aDouble: Double = 3.14 // 8 bytes

    // String
    val aString: String = "I love Kotlin"
}