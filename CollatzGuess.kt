fun main() {
    println(solution8(626331))
}

fun solution8(number: Int): Int {
    var count = 0
    var num: Long = number.toLong()
    while (count < 500) {
        if (num == 1L) {
            return count
        } else if (num % 2 == 0L) {
            num /= 2
            count++
        } else {
            num = num * 3 + 1
            count++
        }
    }
    return -1
}


//꼬리재귀함수 (자기자신만 재귀호출하는 함수) -> 재쉬함수를 루프로 바꾸어 컴파일하기 때문에 자원소비가 적다.
tailrec fun collatzAlgorithm(n: Long, c: Int): Int =
    when {
        c > 500 -> -1
        n == 1L -> c
        else -> collatzAlgorithm(if (n % 2 == 0L) n / 2 else (n * 3) + 1, c + 1)
    }
