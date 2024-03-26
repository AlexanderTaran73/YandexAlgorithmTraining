package Lesson_3

fun main() {
    var str1 = readLine()!!
    var str2 = readLine()!!

    var map1 = mutableMapOf<Char, Int>()

    for (i in str1){
        map1[i] = map1.getOrDefault(i, 0) + 1
    }

    for (i in str2){
        map1[i] = map1.getOrDefault(i, 0) - 1
    }

    var flag = true
    for ((key, value) in map1){
        if (value != 0){
            flag = false
            break
        }
    }
    if (flag) println("YES")
    else println("NO")
}