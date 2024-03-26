package Lesson_2

import java.lang.Math.max

class Data{
    var max: Int = 0
    var elems: MutableList<Elem> = mutableListOf()


}



class Elem(
    var id: Int,
    var i: Int,
    var j: Int
)

fun findMax(array: Array<Array<Int>>, m: Int, n: Int): Int {
    var max = array[0][0]

    for (i in 0..m-1) {
        for (j in 0..n-1) {
            if (array[i][j] > max) {
                max = array[i][j]
            }
        }
    }
    return max
}

fun main() {

    var ansStolb = -1
    var ansStroka = -1


    var (m, n) = readLine()!!.split(" ").map { it.toInt() }
    var array: Array<Array<Int>> = Array(m, { Array(n, {0}) })

    for (i in 0..m-1) {
        array[i] = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    }


    var data = Data()


//    find max
    var max = array[0][0]

    for (i in 0..m-1) {
        for (j in 0..n-1) {
            if (array[i][j] > max) {
                max = array[i][j]
            }
        }
    }
    data.max = max


//    add all max
    var counter = 0
    for (i in 0..m-1) {
        for (j in 0..n-1) {
            if (array[i][j] == max) {
                data.elems.add(Elem(counter, i, j))
                counter += 1
            }
        }
    }

    var ind1 = mutableSetOf<Int>()
    var ind2 = mutableSetOf<Int>()

    for (i in data.elems){
        ind1.add(i.i)
        ind2.add(i.j)
    }

    if (ind1.size>=3 && ind2.size>=3){
        println("1 1")
        return
    }

//    перебор вариантов

    var bestDel = Pair(-1, -1)
    var bestMax = data.max+1
    var bestMaxAmount = n*m+1
    var data2 = Data()

    var coppyArray = Array(m, { Array(n, {0}) })
    for (i in 0..m-1) {
        for (j in 0..n-1) {
            coppyArray[i][j] = array[i][j]
        }
    }

    for (i in data.elems){
        var blockStrok = -1
        var blockStolb = -1

/////////////////////////////////////////////////////////
//        Сперва варианты начинающиеся с удалеения строки
//        block strok
        blockStrok = i.i
        for (j in 0..n-1) {
            coppyArray[blockStrok][j] = -1
        }

//        find new max
        data2.max = findMax(coppyArray, m, n)

//    add all max2
        var counter2 = 0
        for (i2 in 0..m-1) {
            for (j in 0..n-1) {
                if (coppyArray[i2][j] == data2.max) {
                    data2.elems.add(Elem(counter2, i2, j))

//                    println("/$i2 $j/")

                    counter2 += 1
                }
            }
        }

//        новыая копия уже измененного массива
        var coppy2Array = Array(m, { Array(n, {0}) })
        for (k in 0..m-1) {
            for (j in 0..n-1) {
                coppy2Array[k][j] = coppyArray[k][j]
            }
        }
        for (j in data2.elems){
//            block stolb
            blockStolb = j.j
            for (k in 0..m-1) {
                coppy2Array[k][blockStolb] = -1
            }

//            testCopy(coppy2Array)

            var newMax = findMax(coppy2Array, m, n)
            if (newMax > bestMax) {
//                ничего т.к этот вариант хуже или такой же
            }
            else if(newMax < bestMax || (newMax == bestMax && data2.elems.size < bestMaxAmount)){

//
//                testCopy(coppy2Array)
//

//                println(bestMaxAmount)

                bestMax = newMax
                bestDel = Pair(blockStrok, blockStolb)
                bestMaxAmount = data2.elems.size
//                println(bestMaxAmount)

            }


//            сбоасываю копию
            for (i2 in 0..m-1) {
                for (j2 in 0..n-1) {
                    coppy2Array[i2][j2] = coppyArray[i2][j2]
                }
            }
        }

//      reset data
        for (k in 0..m-1) {
            for (j in 0..n-1) {
                coppyArray[k][j] = array[k][j]
            }
        }

        data2 = Data()


        blockStrok = -1
        blockStolb = -1
//////////////////////////////////////////////////////////////
//      Теперь варианты начинающиеся с удаления столбца
//      block stolb

        blockStolb = i.j
        for (k in 0..m-1) {
            coppyArray[k][blockStolb] = -1
        }

//        find new max
        data2.max = findMax(coppyArray, m, n)

    //    add all max2
        counter2 = 0
        for (i2 in 0..m-1) {
            for (j in 0..n-1) {
                if (coppyArray[i2][j] == data2.max) {
                    data2.elems.add(Elem(counter2, i2, j))
                    counter2 += 1
                }
            }
        }

//        новыая копия уже измененного массива
        coppy2Array = Array(m, { Array(n, {0}) })
        for (k in 0..m-1) {
            for (j in 0..n-1) {
                coppy2Array[k][j] = coppyArray[k][j]
            }
        }
        for (j in data2.elems) {
//            block strok
            blockStrok = j.i
            for (k in 0..n - 1) {
                coppy2Array[blockStrok][k] = -1
            }
//            testCopy(coppy2Array)

            var newMax = findMax(coppy2Array, m, n)
            if (newMax > bestMax) {
//                ничего т.к этот вариант хуже или такой же
            }
            else if(newMax < bestMax || (newMax == bestMax && data2.elems.size < bestMaxAmount)){

//
//                testCopy(coppy2Array)
//


                bestMax = newMax
                bestDel = Pair(blockStrok, blockStolb)
                bestMaxAmount = data2.elems.size
            }


//            сбоасываю копию
            for (i2 in 0..m-1) {
                for (j2 in 0..n-1) {
                    coppy2Array[i2][j2] = coppyArray[i2][j2]
                }
            }
        }
        //      reset data
        for (k in 0..m-1) {
            for (j in 0..n-1) {
                coppyArray[k][j] = array[k][j]
            }
        }

        data2 = Data()


    }

    println("${bestDel.first+1} ${bestDel.second+1}")


}

fun testCopy(array: Array<Array<Int>>){
    println("TEST COPY")
    for (i in array){
        for (j in i){
            print("$j ")
        }
        println()
    }
}