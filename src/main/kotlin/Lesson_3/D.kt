package Lesson_3

fun main() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }

    var input = readLine()!!.split(" ").map { try {

        it.toInt()
    } catch (e: Exception){
        null
    }
    }

    var map = mutableMapOf<Int, Int>()
    if (input[n-1] == null) {
        n-=1
    }
    for (i in 0..n-1){

//        println("1) ${input[i]} ${map[input[i]]} ${i-k-1}")
//        if (i-k-1>0) println(map.getOrDefault(input[i-k-1], 0))
        if (i-k-1>=0 && map.getOrDefault(input[i-k-1], 0) > 0) map[input[i-k-1]!!] = map[input[i-k-1]]!! - 1

        map[input[i]!!] = map.getOrDefault(input[i], 0) + 1
        if (map[input[i]]!! > 1) {
//            println("$i ${map[input[i]]} ${i-k-1}")
            println("YES")
            return
        }
//        println("2) ${input[i]} ${map[input[i]]}")

    }
    println("NO")
}