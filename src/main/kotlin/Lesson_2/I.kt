package Lesson_2

import kotlin.math.abs

fun main() {

    var n = readln().toInt()
    if (n==0){ println(0); return}
    var counter = 0
    var stroArray = Array<Int>(n){0}
    var stolArray = Array<Int>(n){0}

    repeat(n){
        var (a, b) = readln().split(" ").map { it.toInt() }
        stroArray[it] = b-1
        stolArray[it] = a-1

    }
    stroArray.sort()
    stolArray.sort()

    var mid = 0
    if (n%2==1) mid = stroArray[n/2+1-1]
    else mid = stroArray[n/2-1]

    for (i in stroArray){
        counter+=abs(i-mid)
    }

    for (i in 0..n-1){
        counter+=abs(stolArray[i]-i)
    }

    println(counter)

}