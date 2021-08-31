fun main() {
    val score = arrayOf(
        intArrayOf(50, 90),
        intArrayOf(50, 87),

        )


    println(solution(score))
}

fun solution(scores: Array<IntArray>): String {
    val temp = IntArray(scores.size)
    val nScores: Array<IntArray> = Array(scores.size) { temp }

    val avgArray = mutableListOf<Int>()
    var answer: String = ""
    //행열바꾸기
    for (i in 0 until scores.size) {
        for (j in 0 until scores.size) {
            nScores[i][j] = scores[j][i]
        }
        //내 점수가 최고점이거나 최저점이면 내점수가 유일한지 체크
        var count = 0
        if ((nScores[i].maxOrNull() == nScores[i][i]) || (nScores[i].minOrNull() == nScores[i][i])) {
            count = nScores[i].count {
                it == nScores[i][i]
            }
        }
        //내 점수가 유일하다면, 내점수에 0점 넣기
        if (count == 1) {
            nScores[i][i] = 0
            avgArray.add((nScores[i].sum()) / (scores.size - 1))
        } else {
            avgArray.add(nScores[i].sum() / scores.size)
        }

    }

    avgArray.forEach {
        answer = when (it) {
            in 90 until 100 ->
                answer.plus("A")
            in 80 until 90 ->
                answer.plus("B")
            in 70 until 80 ->
                answer.plus("C")
            in 50 until 70 ->
                answer.plus("D")
            else ->
                answer.plus("F")
        }
    }


    return answer
}




