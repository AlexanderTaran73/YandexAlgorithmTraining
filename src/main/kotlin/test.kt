fun main() {
    val n = readLine()!!.toInt()

    val berries = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        berries.add(Triple(a, b, it + 1))
    }

    val good = mutableListOf<Triple<Int, Int, Int>>()
    val bad = mutableListOf<Triple<Int, Int, Int>>()

    for (i in berries) {
        val up = i.first - i.second
        if (up > 0) {
            good.add(i)
        } else {
            bad.add(i)
        }
    }

    var goodUp = Triple(-1, -1, -1)
    if (good.isNotEmpty()) {
        goodUp = good[0]
        for (i in good) {
            if (i.second > goodUp.second || (i.second == goodUp.second && i.first > goodUp.first)) {
                goodUp = i
            }
        }
        good.remove(goodUp)
    }

    var first = Triple(-1, -1, -1)
    if (bad.isNotEmpty()) {
        first = bad.maxByOrNull { it.first } ?: Triple(-1, -1, -1)
        bad.remove(first)
    }

    var coord = 0L
    for (i in good) {
        coord += i.first
        coord -= i.second
    }

    val coord1: Long = coord + goodUp.first
    val coord2: Long = coord1 - goodUp.second + first.first

    val ans = mutableListOf<String>()

    if (coord1 > coord2) {
        println(coord1)
    } else {
        println(coord2)
    }

    good.forEach { ans.add(it.third.toString()) }
    if (goodUp.first != -1) {
        ans.add(goodUp.third.toString())
    }
    if (first.first != -1) {
        ans.add(first.third.toString())
        bad.forEach { ans.add(it.third.toString()) }
    }

    println(ans.joinToString(" "))
}
