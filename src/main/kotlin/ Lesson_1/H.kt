package ` Lesson_1`

fun main() {
    var l:Int
    var x1:Int
    var v1:Int
    var x2:Int
    var v2:Int

    var a = readln().split(" ")
    l = a[0].toInt()
    x1 = a[1].toInt()
    v1 = a[3].toInt()
    x2 = a[4].toInt()
    v2 = a[5].toInt()

    var x1_now: Double = x1.toDouble()
    var x2_now: Double = x2.toDouble()

    var tochn = 10_000
    var time = 0

    while(true){

        x1_now = x1_now + v1*time/tochn
        x2_now = x2_now + v2*time/tochn
    }
}