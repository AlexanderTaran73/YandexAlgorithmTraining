package Lesson_3

fun main() {
    var n = readLine()!!.toInt()
    var map = mutableMapOf<String, Int>()
    repeat(n){
        var k = readLine()!!.toInt()
        var music = readLine()!!.split(" ").map { it }
        for (i in music){

            map[i] = map.getOrDefault(i, 0) + 1
        }
    }
    var ans = mutableListOf<String>()
    for((key, value) in map){
        if (value == n) ans.add(key)
    }
    ans.sort()
    println(ans.size)
    println(ans.joinToString(" "))
}