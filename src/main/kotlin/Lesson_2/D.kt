package Lesson_2

fun main() {

    var n = readln().toInt()
    var desk = arrayOf(
        arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 2),
        arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2)
    )

    for (i in 0..n-1){
        var input = readln().split(" ")
        desk[input[0].toInt()][input[1].toInt()] = 1
    }
    var sdvigI = arrayOf(-1, 0, 1, 0)
    var sdvigJ =  arrayOf(0, 1, 0, -1)

    var counter = 0
    for (i in 1..8){
        for (j in 1..8){
            if (desk[i][j]==1){

                for (k in 0..3) {
                    var ni = i + sdvigI[k]
                    var nj = j + sdvigJ[k]
                    if (desk[ni][nj] == 0 || desk[ni][nj] == 2) {
                        counter++
                    }
                }

            }
        }
    }
    println(counter)
}