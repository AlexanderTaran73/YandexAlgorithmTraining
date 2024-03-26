package Lesson_3

fun main() {
//    val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
    var slov = readLine()!!.split(" ").map { it}.toSet()
    var test = readLine()!!.split(" ").map { it}.toMutableList()

//    for (i in slov){
//        if (i==null) continue
//        for (j in 0..slov.size-1){
////            println(slov)
//
//            if (slov[j]==null) continue
//            if (slov[j]!!.startsWith(i) && slov[j]!!.length>i.length) slov[j] = null
//
//        }
//    }
//
////    println(slov)
//    var slov2 = slov.toMutableSet()
//    slov2.remove(null)

    for (j in 0..test.size-1){
        for (i in 1..test[j].length){
            if (test[j].substring(0, i) in slov){
                test[j] = test[j].substring(0, i)
                break
            }
        }
    }
    println(test.joinToString(" "))

}