package ` Lesson_1`

import java.lang.Math.*


fun main() {
    var l:Int
    var x1:Int
    var v1:Int
    var x2:Int
    var v2:Int

    var a = readln().split(" ")
    l = a[0].toInt()
    x1 = a[1].toInt()
    v1 = a[2].toInt()
    x2 = a[3].toInt()
    v2 = a[4].toInt()

    var x1_now: Double = x1.toDouble()
    var x2_now: Double = x2.toDouble()

    var v_test = (v1+v2).toDouble()

    var t_max: Double = l/v_test

    var dT = t_max / 100000000
    var t:Double

    var r = min(v1, v2)*dT
    for (i in 0..100000000){
        t = dT*i

        x1_now = x1_now+v1*dT
        x2_now = x2_now+v2*dT

        if (x1_now>l) x1_now %= l
        else if(x1_now<0) x1_now = l - x1_now


        if (x2_now>l) x2_now %= l
        else if(x2_now<0) x2_now = l - x2_now


        if (abs(x1_now-x2_now) < r ){
//            println("$x1_now $x2_now $t $r")
            println(t)
            return
        }
        else if(abs(x1_now+x2_now-l) < r) {
//            println("$x1_now $x2_now $t $r ${x1_now+x2_now-l})")
            println(t)
            return
        }
    }

    println("NO")
}