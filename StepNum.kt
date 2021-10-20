import java.lang.Thread.yield
import kotlin.time.seconds

fun main() {

}

fun solution(x: Int, n: Int): LongArray {
    //n개 크기 만큼의 LongArray 만든다
    //i 는 인덱스임
    return LongArray(n) { i ->
        (i + 1) * x.toLong()
    }
}
