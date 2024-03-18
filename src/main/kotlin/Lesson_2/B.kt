package Lesson_2

fun main() {
    var input = readln().split(" ")
    var n = input[0].toInt()
    var k = input[1].toInt()

    var days: MutableList<Int> = mutableListOf()
    readln().split(" ").forEach(){
        days.add(it.toInt())
    }

    var maxP = 0;

    for (i in 0..n-1){
        var c = 0
        while (c<=k && i+c < n){
            maxP = maxOf(maxP, days[i+c]-days[i])
            c++
        }
    }

    println(maxP)
}