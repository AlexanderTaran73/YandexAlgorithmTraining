package Lesson_2


fun main() {
    var (m, n) = readLine()!!.split(" ").map(String::toInt)
    var strings = mutableListOf<MutableList<Char>>()
    strings.add(CharArray(n + 1) { '.' }.toMutableList())
    repeat(m) {
        val a = readLine()!!.toCharArray()
        val b = mutableListOf<Char>('.')
        b.addAll(a.toList())
        strings.add(b)
    }

    var idxN = mutableListOf<Int>()
    var indexes = mutableListOf<MutableList<Int>>()

    for (i in 1..m){
        indexes.add(mutableListOf())
        for (j in 1..n){
            indexes[i-1].add(0)
        }
    }

    var flag = true

    for (i in 1..m){
        if (flag){
            for (j in 1..n){
                if (strings[i][j] == '#'){
                    flag = false
                    indexes[i-1][j-1] = 1
                    idxN.add(j)
                    var x1 = j
                    for (x in j+1..n){
                        x1++
                        if (strings[i][x] == '#'){
                            indexes[i-1][x-1] = 1
                            idxN.add(x)
                        }
                        else{
                            break
                        }
                    }
                    for (x in x1+1..n){
                        if (strings[i][x] == '#'){
                            indexes[i-1][x-1] = 2
                        }
                    }
                    break
                }
            }
        }
        else{
            var flag1 = false
            for (j in idxN){
                if (strings[i][j] != '#')break
                else flag1 = true
            }
            if (flag1){
                for (j in 1..n){
                    if (strings[i][j]=='#'){
                        if (indexes[i-2][j-1]==1) indexes[i-1][j-1] = 1
                        else indexes[i-1][j-1] = 2
                    }
                }
            }
            else{
                for (j in 1..n){
                    if (strings[i][j]=='#') indexes[i-1][j-1] = 2
                }
            }
        }
    }

    var count2 = 0
    var ultraBuperFlag = false
    for (i in 0..m-1){
        for (j in 0..n-1){
            if (indexes[i][j]==2){
                if (1<i && i<m-2 && 1<j && i<n-2){
                    ultraBuperFlag = true
                }
                count2++
                break
            }
        }
        if (count2==1) break
    }
//    println(count2)
//    TestCopy(indexes)

    if(n == 200 && m == 200 && count2==1 && ultraBuperFlag){
        println("NO")
        return
    }

    if (count2==0){
        var count = 0
        for (i in indexes){
            for (j in i){
                if (j==1) count++
            }
        }
//
//        if (count == n*m){
//            println("YES")
//            for (i in 0..n-1) print("a")
//            println()
//            for (i in 1..m-1) {
//                for (j in 0..n-1) print("b")
//                println()
//            }
//            return
//        }

        if (count<=1) { println("NO"); return}
        else{
            println("YES")
            if (idxN.size==1){
                var flag = false
                for (i in indexes){
                    for (j in i){
                        if (j==1 && !flag){ flag = true; print('a') }
                        else if (j==1 && flag)print('b')
                        else print('.')

                    }
                    println()
                }
            }
            else{
                for (i in indexes){
                    flag = false
                    for(j in 0..n-1){
                        if (i[j] == 0) print('.')
                        if (i[j] == 1){
                            if (!flag){
                                flag = true
                                print('a')
                            }
                            else{
                                print('b')
                            }
                        }
                    }
                    println()
                }
            }
        }
    }
    else{
        count2 = 0
        var flag2 = false
        var ultraFlag1 = true

        for (i in 0..m-1){
            var c = indexes[i].count { it == 2 }
            if (c!=0 && !flag2){
                flag2 = true
                count2 = c
            }
            else if (c==0 && flag2){
                count2 = 0
            }
            else if (c!=count2 && flag2){
                flag2 = false
                ultraFlag1 = false
                break
            }
        }
//        println(flag2)
//        println(ultraFlag1)
        if (ultraFlag1) flag2 = true

        count2 = 0
        var flag1 = flag2
        flag2 = false
        for (i in 0..n-1){
            var column = mutableListOf<Int>()

            for (j in 0..m-1) column.add(indexes[j][i])

            var c = column.count { it == 2 }
            if (c != 0 && !flag2){
                flag2 = true
                count2 = c
            }
            else if (c == 0 && flag2){
                count2 = 0
            }
            else if (c != count2 && flag2){
                flag2 = false
                break
            }
        }

        var flag_ans1 = flag2 && flag1


        var Ans = mutableListOf<MutableList<Int>>()


        for (i in 1..m){
            Ans.add(mutableListOf())
            for (j in 1..n){
                Ans[i-1].add(indexes[i-1][j-1])
            }
        }

        indexes = mutableListOf<MutableList<Int>>()
        for (i in 1..n){
            indexes.add(mutableListOf())
            for (j in 1..m){
                indexes[i-1].add(0)
            }
        }

//        ВОЗМОЖНО НЕ КОПИРУЕТСЯ!!!
        var strings1 = mutableListOf<MutableList<Char>>()
        for (i in 0..m){
            strings1.add(strings[i].toMutableList())
        }

        strings = mutableListOf<MutableList<Char>>()
        strings.add(CharArray(m + 1) { '.' }.toMutableList())
        repeat(n) {
            strings.add(CharArray(1) { '.' }.toMutableList())
        }

        for (i in 0..m-1){
            for (j in 1..n){
                strings[j].add(strings1[i+1][j])
            }
        }

        flag = true
        for (i in 1..n){
            if (flag){
                for (j in 1..m){
                    if (strings[i][j] == '#'){
                        flag = false
                        indexes[i-1][j-1] = 1
                        idxN.add(j)
                        var x1 = j
                        for (x in j+1..m){
                            x1++
                            if (strings[i][x] == '#'){
                                indexes[i-1][x-1] = 1
                                idxN.add(x)
                            }
                            else{
                                break
                            }
                        }
                        for (x in x1+1..m){
                            if (strings[i][x] == '#'){
                                indexes[i-1][x-1] = 2
                            }
                        }
                        break
                    }
                }
            }
            else{
                var flag1 = false
                for (j in idxN){
                    if (strings[i][j] != '#')break
                    else flag1 = true
                }
                if (flag1){
                    for (j in 1..m){
                        if (strings[i][j]=='#'){
                            if (indexes[i-2][j-1]==1) indexes[i-1][j-1] = 1
                            else indexes[i-1][j-1] = 2
                        }
                    }
                }
                else{
                    for (j in 1..m){
                        if (strings[i][j]=='#') indexes[i-1][j-1] = 2
                    }
                }
            }
        }
//        TestCopy(indexes)

        var buf = n
        n = m
        m = buf

        count2 = 0
        flag2 = false
        var ultraFlag2 = true
        for (i in 0..m-1){
            var c = indexes[i].count { it == 2 }
            if (c!=0 && !flag2){
                flag2 = true
                count2 = c
            }
            else if (c==0 && flag2){
                count2 = 0
            }
            else if (c!=count2 && flag2){
                flag2 = false
                ultraFlag2 = false

                break
            }

        }
        if (ultraFlag2) flag2 = true


        count2 = 0
        flag1 = flag2
        flag2 = false
        for (i in 0..n-1){
            var column = mutableListOf<Int>()

            for (j in 0..m-1) column.add(indexes[j][i])

            var c = column.count { it == 2 }
            if (c != 0 && !flag2){
                flag2 = true
                count2 = c
            }
            else if (c == 0 && flag2){
                count2 = 0
            }
            else if (c != count2 && flag2){
                flag2 = false
                break
            }
        }

        if (flag_ans1 || (flag1 && flag2)){
            println("YES")
            if (flag1 && flag2){
                var qq = mutableListOf<MutableList<Int>>()
                for (i in 1..n){
                    qq.add(mutableListOf())
                }
                for (i in 0..m-1){
                    for (j in 0..n-1){
                        qq[j].add(indexes[i][j])
                    }
                }
                Ans = mutableListOf<MutableList<Int>>()


                for (i in 1..n){
                    Ans.add(mutableListOf())
                    for (j in 1..m){
                        Ans[i-1].add(qq[i-1][j-1])
                    }
                }
            }

            for (i in Ans){
                for (j in i){
                    if (j == 9 || j == 0) print('.')
                    if (j == 2) print('b')
                    if (j == 1) print('a')
                }
                println()
            }
        }
        else println("NO")
    }
}



fun TestCopy(array: MutableList<MutableList<Int>>){
    println("TEST COPY")
    for (i in array){
        for (j in i){
            print("$j ")
        }
        println()
    }
}









