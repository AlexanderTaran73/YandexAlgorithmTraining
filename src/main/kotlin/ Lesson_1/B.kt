package ` Lesson_1`

import kotlin.math.abs

fun main(){

    val a: MutableList<Int> = mutableListOf()
    readln().split(":").forEach(){a.add(it.toInt())}
    val b: MutableList<Int> = mutableListOf()
    readln().split(":").forEach(){b.add(it.toInt())}
    var c = readln().toInt()

    if (a[0]+b[0]-a[1]-b[1]>0) println(0)
    else if(a[0]+b[0]-a[1]-b[1]==0){
        if ((c==1 && (a[1]<b[0])) || (c==2 && (a[0]>b[1]))) println(0)
        else println(1)
    }
    else{

        if(c==1 && abs(a[0]+b[0]-a[1]-b[1]) > a[1]-b[0]) println(abs(a[0]+b[0]-a[1]-b[1]))
        else if(c==2 && (a[0]>b[1]))println(abs(a[0]+b[0]-a[1]-b[1]))
        else println(abs(a[0]+b[0]-a[1]-b[1])+1)
    }
}