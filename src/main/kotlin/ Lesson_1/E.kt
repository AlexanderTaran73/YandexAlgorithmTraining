package ` Lesson_1`



fun main() {
    var input: MutableList<Int> = mutableListOf()
    readLine()!!.split(" ").forEach { input.add(it.toInt()) }
    var n: Long = input[0].toLong()

        repeat(input[2]) {
            for (i in 0..9) {
                if ((n * 10L + i) % input[1].toLong() == 0L) {
                    if (i==0) {
                        print(n)
                        for (k in 0..(input[2]-it)-1) print(0)
                        return
                    }
                    n = n * 10L + i
                    break
                }
                if (i == 9) {
                    println(-1)
                    return
                }
            }
        }

        println(n)

}

