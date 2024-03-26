//package Lesson_2
//
//import java.lang.Math.max
//
//class Data{
//    var max: Int = 0
//    var elems: MutableList<Elem> = mutableListOf()
//
//
//}
//
//
//
//
//class Elem{
//    var stolb = Stolb_or_Strok()
//    var stroka = Stolb_or_Strok()
//}
//
//class Stolb_or_Strok{
//    var id: Int = 0
//    var maxAmount : Int = 0
//
//    var anothMax : Int = -1
//    var anozMaxAm : Int = 0
//}
//
//fun fillElem(i: Int, j: Int, max: Int, array: Array<Array<Int>>, m: Int, n: Int): Elem {
//
//    var stolb = Stolb_or_Strok()
//    stolb.id = j
//    stolb.maxAmount = 0
//    for (k in 0..m-1) {
//        if (array[k][j] == max) {
//            stolb.maxAmount += 1
//        }
//        else{
//            if (array[k][j] > stolb.anothMax) {
//                stolb.anothMax = array[k][j]
//                stolb.anozMaxAm = 1
//            }
//            else if (array[k][j] == stolb.anothMax){
//                stolb.anozMaxAm += 1
//            }
//        }
//    }
//
//
//    var stroka = Stolb_or_Strok()
//    stroka.id = i
//    stroka.maxAmount = 0
//    for (k in 0..n-1) {
//        if (array[i][k] == max) {
//            stroka.maxAmount += 1
//        }
//        else{
//            if (array[i][k] > stroka.anothMax) {
//                stroka.anothMax = array[i][k]
//                stroka.anozMaxAm = 1
//            }
//            else if (array[i][k] == stroka.anothMax){
//                stroka.anozMaxAm += 1
//            }
//        }
//    }
//
//
//    var elem = Elem()
//    elem.stolb = stolb
//    elem.stroka = stroka
//    return elem
//}
//
//fun main() {
//
//    var ansStolb = -1
//    var ansStroka = -1
//
//
//    var (m, n) = readLine()!!.split(" ").map { it.toInt() }
//    var array: Array<Array<Int>> = Array(m, { Array(n, {0}) })
//
//    for (i in 0..m-1) {
//        array[i] = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
//    }
//
//
//    var data = Data()
//
//    var max = array[0][0]
//
//
//    for (i in 0..m-1) {
//        for (j in 0..n-1) {
//            if (array[i][j] > max) {
//                max = array[i][j]
//            }
//        }
//    }
//    data.max = max
//    for (i in 0..m-1) {
//        for (j in 0..n-1) {
//            if (array[i][j] == max) {
//                data.elems.add(fillElem(i, j, max, array, m, n))
//            }
//        }
//    }
//
//    var bestElem = data.elems[0]
//    var bestElem_maxAm = -1
//    var bestElem_anothMax = -1
//    var bestElem_anozMaxAm = -1
//
//    for (i in data.elems){
//
//        if (bestElem_maxAm < max(i.stolb.maxAmount, i.stroka.maxAmount)){
//            bestElem = i
//
//            if (i.stolb.maxAmount > i.stroka.maxAmount){
//                bestElem_maxAm = i.stolb.maxAmount
//                bestElem_anothMax = i.stolb.anothMax
//                bestElem_anozMaxAm = i.stolb.anozMaxAm
//            }
//            else if (i.stroka.maxAmount > i.stolb.maxAmount){
//                bestElem_maxAm = i.stroka.maxAmount
//                bestElem_anothMax = i.stroka.anothMax
//                bestElem_anozMaxAm = i.stroka.anozMaxAm
//            }
//            else{
//                bestElem_maxAm = i.stolb.maxAmount
//
//                if (i.stolb.anothMax > i.stroka.anothMax){
//                    bestElem_anothMax = i.stolb.anothMax
//                    bestElem_anozMaxAm = i.stolb.anozMaxAm
//                }
//                else if (i.stroka.anothMax > i.stolb.anothMax){
//                    bestElem_anothMax = i.stroka.anothMax
//                    bestElem_anozMaxAm = i.stroka.anozMaxAm
//                }
//                else{
//                    bestElem_anothMax = i.stroka.anothMax
//
//                    if (i.stolb.anozMaxAm > i.stroka.anozMaxAm){
//                        bestElem_anozMaxAm = i.stolb.anozMaxAm
//                    }
//                    else{
//                        bestElem_anozMaxAm = i.stroka.anozMaxAm
//                    }
//                }
//            }
//
//
//        }
//        else if (bestElem_maxAm == max(i.stolb.maxAmount, i.stroka.maxAmount)){
//            if (bestElem_anothMax < max(i.stolb.anothMax, i.stroka.anothMax)){
//                bestElem = i
//
//                if (i.stolb.maxAmount > i.stroka.maxAmount){
//                    bestElem_maxAm = i.stolb.maxAmount
//                    bestElem_anothMax = i.stolb.anothMax
//                    bestElem_anozMaxAm = i.stolb.anozMaxAm
//                }
//                else if (i.stroka.maxAmount > i.stolb.maxAmount){
//                    bestElem_maxAm = i.stroka.maxAmount
//                    bestElem_anothMax = i.stroka.anothMax
//                    bestElem_anozMaxAm = i.stroka.anozMaxAm
//                }
//                else{
//                    bestElem_maxAm = i.stolb.maxAmount
//
//                    if (i.stolb.anothMax > i.stroka.anothMax){
//                        bestElem_anothMax = i.stolb.anothMax
//                        bestElem_anozMaxAm = i.stolb.anozMaxAm
//                    }
//                    else if (i.stroka.anothMax > i.stolb.anothMax){
//                        bestElem_anothMax = i.stroka.anothMax
//                        bestElem_anozMaxAm = i.stroka.anozMaxAm
//                    }
//                    else{
//                        bestElem_anothMax = i.stroka.anothMax
//
//                        if (i.stolb.anozMaxAm > i.stroka.anozMaxAm){
//                            bestElem_anozMaxAm = i.stolb.anozMaxAm
//                        }
//                        else{
//                            bestElem_anozMaxAm = i.stroka.anozMaxAm
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//
//
////    test
//    println(data.max)
//    data.elems.forEach{
//        println(" Strok ${it.stroka.id} ${it.stroka.maxAmount} ${it.stroka.anothMax} ${it.stroka.anozMaxAm} ")
//        println(" Stolb ${it.stolb.id} ${it.stolb.maxAmount} ${it.stolb.anothMax} ${it.stolb.anozMaxAm} ")
//        println()
//    }
//    println("BEST")
//
//    bestElem.also {
//        println(" Strok ${it.stroka.id} ${it.stroka.maxAmount} ${it.stroka.anothMax} ${it.stroka.anozMaxAm} ")
//        println(" Stolb ${it.stolb.id} ${it.stolb.maxAmount} ${it.stolb.anothMax} ${it.stolb.anozMaxAm} ")
//        println() }
//}