package Lesson_3

fun main() {
    var n = readLine()!!.toInt()
    var input = readLine()!!.split(" ").map { it.toInt() }

    var map = mutableMapOf<Int, Int>()
    for (i in input){
        if (map.getOrDefault(i, 0)>=1) continue
        map[i] = map.getOrDefault(i, 0) + 1
    }

    n = readLine()!!.toInt()
    input = readLine()!!.split(" ").map { it.toInt() }

    for (i in input){
        if (map.getOrDefault(i, 0)>=10) continue
        map[i] = map.getOrDefault(i, 0) + 10
    }

    n = readLine()!!.toInt()
    input = readLine()!!.split(" ").map { it.toInt() }

    for (i in input){
        if (map.getOrDefault(i, 0)>=100) continue
        map[i] = map.getOrDefault(i, 0) + 100
    }

    var set = mutableSetOf<Int>()

    for ((key, value) in map){
//        println(value)
        if (value == 11 || value == 101 || value == 110 || value == 111){
            set.add(key)
        }
    }

    if (set.size == 0){
        return
    }
    println(set.toList().sorted().joinToString(" "))

}