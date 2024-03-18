package Lesson_2

import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()

    var input = readln().split(" ")

    var maxX = input[0].toInt()
    var maxY = input[1].toInt()
    var minX = maxX
    var minY = maxY

    for (i in 2..n){
        input = readln().split(" ")

        maxX = max(maxX, input[0].toInt())
        maxY = max(maxY, input[1].toInt())
        minX = min(minX, input[0].toInt())
        minY = min(minY, input[1].toInt())
    }

    println("$minX $minY $maxX $maxY")
}