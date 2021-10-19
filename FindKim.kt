fun main(){
println(findKim( arrayOf("Jane", "Kim")))
}

fun findKim(array : Array<String>):String{

    array.indexOf("Kim")
    return "김서방은 ${array.indexOf("Kim")+1}에 있다"
}