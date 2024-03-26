package Lesson_3

import java.lang.Math.max

fun main() {
    var n = readLine()!!.toInt()
    var map = mutableMapOf<Int, Int>()
    var input = readLine()!!.split(" ").map { it.toInt() }
    for (i in input){
        map[i] = map.getOrDefault(i, 0) + 1
    }
    var maxS = 0
    for ((key, value) in map){

        maxS = max(maxS, value+map.getOrDefault(key+1, 0))

    }
    println(n-maxS)
}