package Lesson_2

import java.lang.Math.max

fun main() {
    var n = readln().toInt()
    var sect = readln().split(" ").map { it.toInt() }
    var (min, max, k) = readln().split(" ").map { it.toInt() }

    var minS:Int = if (min%k!=0) min/k else min/k-1

    var maxS:Int = if (max%k!=0) max/k else max/k-1
    var res = -1

    if (maxS-minS>=n){
        println(sect.maxByOrNull{it })
        return
    }

    for (i in minS..maxS) {
        res = max(res, sect[i%n])
        res = max(res, sect[(n-(i%n))%n])
    }
//    println(minS%n)
//    println(maxS%n)
    println(res)

}