package ` Lesson_1`

import kotlin.math.min

fun main() {
    var my_solder = readln().toInt()
    var base = readln().toInt()
    var spawn = readln().toInt()
    var his_solder = 0

    var counter = 0

    var min_counter = 2000000000

    var base_before: Int? = null
    while (true){
        if (base<=0 && his_solder<=0) {
            println(minOf(min_counter, counter))
            return
        }
        if (my_solder<=0){
            if(min_counter<2000000000) println(min_counter)
            else println(-1)
            return
        }
        if (base == base_before && base!=0){
            if(min_counter<2000000000) println(min_counter)
            else println(-1)
            return
        }



        base_before = base


        counter+=1
//        println("start $counter. my:$my_solder base:$base his:$his_solder")

        var activeSolder = my_solder


        if (base <=0){
            his_solder-=activeSolder
        }
        else {

            if (base<=activeSolder){

                var c = willWeLive(my_solder-(his_solder-(activeSolder-base)), (his_solder-(activeSolder-base)), counter+1)
                if (c!=-1) min_counter = minOf(min_counter, c)

            }


//            if (base <= activeSolder && my_solder-(his_solder-(activeSolder-base))>=(his_solder-(activeSolder-base))*3/5) {
//                activeSolder -= base
//                base = 0
//                his_solder -= activeSolder
//            }
//            else{
            if (his_solder>=activeSolder){

                his_solder-=activeSolder
                activeSolder=0
            }
            else{
                activeSolder-=his_solder
                his_solder=0
                base-=activeSolder
                activeSolder=0
            }
//            }

        }


        my_solder-=his_solder



        if (base>0) his_solder+=spawn


//        println("end $counter. my:$my_solder base:$base his:$his_solder")
    }
}


//        k  n
//        2k-n n-k
//        5k-3n 2n-3k
//        13k-7n 5n-8k
//        34k-19n 12n-21k

fun willWeLive(m: Int, h: Int, c: Int): Int{
    var my = m
    var his = h
    var counter = c
    while (true){
//        println("start! $c. my:$my base:$0 his:$his")

        his-=my

        if (his<=0) return counter

        my-=his

        if (my<=0) return -1

//        println("end! $c. my:$my base:$0 his:$his")

        counter+=1
    }
}