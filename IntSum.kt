import java.lang.Math.max
import java.lang.Math.min

fun main() {
    println(solution(3, 3)
    )
}

fun solution(a: Int, b: Int): Long {
    val c = max(a, b).toLong()
    val d = min(a, b).toLong()

    return LongRange(d,c).sum()
}