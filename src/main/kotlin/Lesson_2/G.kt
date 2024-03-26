package Lesson_2

fun main() {

    var t = readln().toInt()
    repeat(t) {
//        println(it)
        var n = readln().toInt()
        var array = readln().split(" ").map { it.toInt() }

        var ans: MutableList<Int> = mutableListOf()
        var counter = 0

        var minInt = array[0]

        var lenI = 1


        for (i in 1..n-1){

            if (lenI == minInt) {
                ans.add(lenI)
                counter += 1
                minInt = array[i]
                lenI = 1
            }
            else {
                if (array[i] >= minInt) {
                    lenI += 1
                }
                else {
                    if (array[i] > lenI) {
                        minInt = array[i]
                        lenI += 1
                    }
                    else {
                        ans.add(lenI)
                        counter += 1
                        minInt = array[i]
                        lenI = 1
                    }
                }
            }
        }

        var sum = 0
        ans.forEach(){
            sum+=it
        }
        if (sum!=n){
            counter+=1
            ans.add(n-sum)
        }


        println(counter)
        println(ans.joinToString(" "))

    }
}