fun main() {
    println(solution("try hello world"))
}

fun solution(s: String): String {
    var a = ""
    //s를 띄어쓰기 기준으로 자른다
    s.split(" ").map {
//        for (i in it.indices) {
//            a += if (i % 2 == 0) it[i].uppercaseChar() else it[i].lowercaseChar()
//        }

        it.mapIndexed { index, c ->
            a += if (index % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
        } //각 단어 내의 짝홀수 따져서 대소문자로 변환
        a += " " // 단어마다 띄어쓰기를 해준다
    }
    return a.substring(0, a.lastIndex) //마지막 띄어쓰기는 임의로 해준거기 때문에 출력되지 않게 해줌
}