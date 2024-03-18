package Lesson_2

fun main() {
    var n = readln().toInt()
    var input: MutableList<Int> = mutableListOf()
    readln().split(" ").forEach(){
        input.add(it.toInt())
    }

    var sum = 0
    var max = -1
    for (i in input) { sum+=i; max = maxOf(max, i) }

    if (sum-max < max) println(2*max-sum)
    else println(sum)

}