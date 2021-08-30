class `august 4th` {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {

        val scoreArray = arrayListOf<Int>(0, 0, 0, 0, 0)

        val sameArray = mutableListOf<Int>()
        for (i in 0 until table.size) {

            var split_table = table[i].split(" ")
            var job_sum = 0

            for (j in 0 until languages.size) {
                var job_lanj_score = split_table.indexOf(languages[j])
                job_lanj_score = when (split_table.indexOf(languages[j])) {
                    -1 -> 0
                    else -> table.size - split_table.indexOf(languages[j]) + 1
                }

                job_sum += job_lanj_score * preference[j]
            }
            scoreArray[i] = job_sum
        }

        var max_index = 0
        var max_int = scoreArray[max_index]

        for (i in 0 until scoreArray.size) {
            if (scoreArray[i] > max_int) {
                max_index = i
                max_int = scoreArray[max_index]
            }
        }

        for (i in 0 until scoreArray.size) {
            if (scoreArray[i] == scoreArray[max_index]) {
                sameArray.add(i)
            }
        }

        var sameWords = mutableListOf<String>()
        for (i in 0 until sameArray.size) {
            var temp_return = table[sameArray[i]].split(" ")
            sameWords.add(temp_return[0].substring(0))
        }

        sameWords.sort()
        return sameWords[0]
    }
}
