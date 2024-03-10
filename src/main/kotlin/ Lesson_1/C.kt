package ` Lesson_1`

fun main() {
    val n = readln().toInt()
    var counter: Long = 0
    repeat(n){
        var k = readln().toInt()
        counter+=k/4
        if (k%4==2 || k%4==3)counter+=2
        if (k%4==1) counter+=1
    }
    println(counter)
}