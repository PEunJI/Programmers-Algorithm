import kotlin.math.*

fun main() {
    println(divisor(24, 27))
}

fun divisor(left: Int, right: Int): Int {
    val range = left..right
    var answer = 0

    range.map {
        var cnt = 0
        var sqrt = floor(sqrt(it.toDouble())).toInt() //제곱근
        val range2 = 1..sqrt //1~제곱근까지의 약수 갯수 *2 = 총 약수의갯수
        for (i in range2) {
            if (it % i == 0) cnt++
        }
        cnt *= 2
        if (ceil(sqrt(it.toDouble())).toInt() == sqrt) //25
            cnt -= 1
        answer = if (cnt % 2 == 0) answer+it
        else answer-it
        println(answer.toString())
    }
    return answer
}
