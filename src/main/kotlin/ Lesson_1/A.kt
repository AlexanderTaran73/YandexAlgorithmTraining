package ` Lesson_1`

import kotlin.math.abs
import kotlin.math.max

fun main() {
    var a: MutableList<Int> = mutableListOf()
    readln().split(" ").forEach(){a.add(it.toInt())}
    var b: MutableList<Int> = mutableListOf()
    readln().split(" ").forEach(){b.add(it.toInt())}

    if (a[1]==0 && b[1]==0) {
        println(0)
        return
    }
    if (a[0]==b[0]) {
        println(max(a[1], b[1])*2+1)
    }
    else if(abs(a[0]-b[0])-1 < a[1]+b[1]) {
        var ans = 0
        ans = max(a[1]+b[1]+abs(a[0]-b[0])-1+2, 2*a[1]+1)
        ans = max(ans, 2*b[1]+1)
        println(ans)
    }
    else {
        if (a[1]==0 || b[1]==0) println( 2*(a[1]+b[1]) + 1)
        else println( 2*(a[1]+b[1]) + 2)
    }


}