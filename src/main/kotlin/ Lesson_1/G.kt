package ` Lesson_1`

fun main() {
    var my_solder = readln().toInt()
    var base = readln().toInt()
    var spawn = readln().toInt()
    var his_solder = 0

    var counter = 0

    var base_before: Int? = null
    while (true){
        if (base<=0 && his_solder<=0) {
            println(counter)
            return
        }
        if (my_solder<=0){
            println(-1)
            return
        }
        if (base == base_before && base!=0){
            println(-1)
            return
        }



        base_before = base


        counter+=1
//        println("start $counter. my:$my_solder base:$base his:$his_solder")

        var activeSolder = my_solder


        if (base <=0){
            his_solder-=activeSolder
        }
        else {
            if (base <= activeSolder && my_solder-(his_solder-(activeSolder-base)) >= (his_solder-(activeSolder-base))*3/5) {
                activeSolder -= base
                base = 0
                his_solder -= activeSolder
            }
            else{
                if (his_solder>=activeSolder){

                    his_solder-=activeSolder
                    activeSolder=0
                }
                else{
                    activeSolder-=his_solder
                    his_solder=0
                    base-=activeSolder
                    activeSolder=0
                }
            }

        }


        my_solder-=his_solder



        if (base>0) his_solder+=spawn


//        println("end $counter. my:$my_solder base:$base his:$his_solder")
    }
}