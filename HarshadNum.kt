fun main() {
    println(harshadNum(10))
}

fun harshadNum(num: Int): Boolean {
    var a = 0
    num.toString().toCharArray().map {
        a += it.toString().toInt()
    }
    return num % a == 0
}