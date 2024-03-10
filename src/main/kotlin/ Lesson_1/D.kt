package ` Lesson_1`

import kotlin.math.abs

fun main() {
    var desk = mutableListOf<String>()
//    var desk2 = arrayOf(
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0))

    repeat(8) {
        desk.add(readln())
    }
    var ans = 0

    for (i in 0..7){
        for (j in 0..7){

//            for (i in 2..2){
//                for (j in 1..1){
//            println("$i $j")
            var flag = 1

//            <-
            var k = i
            var l = j
            while (k>=0){
                if (desk[k][j]=='R') {
                    flag = 0
                    break
                }
                if (desk[k][j]=='B') {
                    break
                }
                k--
            }



//            T
            k = i
            l = j
            while (l>=0){
                if (desk[i][l]=='R') {
                    flag = 0
                    break
                }
                if (desk[i][l]=='B') {
                    break
                }
                l--
            }

//            ->


            k = i
            l = j
            while (k<=7){
                if (desk[k][j]=='R') {
                    flag = 0
                    break
                }
                if (desk[k][j]=='B') {
                    break
                }
                k++
            }

//            V

            k = i
            l = j
            while (l<=7){
                if (desk[i][l]=='R') {
                    flag = 0
                    break
                }
                if (desk[i][l]=='B') {
                    break
                }
                l++
            }

//            \T

            k = i
            l = j
            while (k>=0 && l>=0){
                if (desk[k][l]=='B') {
                    flag = 0
                    break
                }
                if (desk[k][l]=='R') {
                    break
                }
                k--
                l--
            }


//            /T

            k = i
            l = j
            while (k<=7 && l>=0){
                if (desk[k][l]=='B') {
                    flag = 0
                    break
                }
                if (desk[k][l]=='R') {
                    break
                }
                k++
                l--
            }


//            \V

            k = i
            l = j
            while (k<=7 && l<=7){
                if (desk[k][l]=='B') {
                    flag = 0
                    break
                }
                if (desk[k][l]=='R') {
                    break
                }
                k++
                l++
            }

//            /V

            k = i
            l = j
            while (k>=0 && l<=7){
                if (desk[k][l]=='B') {
                    flag = 0
                    break
                }
                if (desk[k][l]=='R') {
                    break
                }
                k--
                l++
            }
//            if (flag==0){
//                desk2[i][j] = 1
//            }
            if (flag == 1) ans+=1
        }
    }


//    for (i in 0..7){
//        for(j in 0..7){
//            print("${desk2[i][j]} ")
//        }
//        println()
//    }

    println(ans)
}