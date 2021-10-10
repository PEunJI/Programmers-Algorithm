fun main() {
    println(solution8("zZA"))
}

fun solution8(s: String): String {
    var answer =""
    s.toCharArray().sortedDescending().map {
        answer+=it
    }
    return answer
}