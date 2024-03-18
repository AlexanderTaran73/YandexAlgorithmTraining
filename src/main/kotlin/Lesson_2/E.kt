package Lesson_2

import kotlin.math.max



fun main() {
    var n = readln().toInt()

    var goodPils: MutableList<Int> = mutableListOf()
    var badPils: MutableList<Int> = mutableListOf()

    var pils: MutableList<Pair<Int, Int>> = mutableListOf()

    var coord = 0L


    var down = 0L

    for (i in 1..n){
        var input = readln().split(" ")
        pils.add(Pair(input[0].toInt(), input[1].toInt()))
        if (input[0].toInt()-input[1].toInt()>0){
            goodPils.add(i)
        }
        else{
            badPils.add(i)
        }
    }
    var ansAr: MutableList<Int> = mutableListOf()


    if (goodPils.isNotEmpty()) {
        var maxUpIndex = goodPils[0]
        var maxUp = pils[maxUpIndex-1].first
        var maxUpDown = pils[maxUpIndex-1].second


        for (i in goodPils) {
            if(pils[i - 1].second > maxUpDown || (pils[i - 1].second == maxUpDown && pils[i - 1].first > maxUp)) {
                maxUp = pils[i - 1].first
                maxUpDown = pils[i - 1].second
                maxUpIndex = i
            }
        }

        goodPils.remove(maxUpIndex)

        for (i in goodPils) {
            coord += pils[i - 1].first
            coord -= pils[i - 1].second
            ansAr.add(i)
        }

        coord += maxUp
        down = coord-maxUpDown
        ansAr.add(maxUpIndex)
    }

    if (badPils.isNotEmpty()){

        var bestBad = badPils[0]
        var bestUp = pils[bestBad-1].first

        for (i in badPils){
            if (pils[i-1].first > bestUp){
                bestBad = i
                bestUp = pils[i-1].first
            }
        }

        badPils.remove(bestBad)
//        if (down != -1L){
        coord = max(coord, down+bestUp)
//        }
//        coord+=bestUp
        ansAr.add(bestBad)

        for (i in badPils) ansAr.add(i)

    }





    println(coord)
    print("${ansAr[0]}")

    for (i in 1..ansAr.size-1){
        print(" ${ansAr[i]}")
    }


}