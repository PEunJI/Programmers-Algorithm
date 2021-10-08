fun main() {

}

class solution1 {
    fun solution(a: Int, b: Int): String {
        var sum = 0
        //전달 까지의 일 수를 다 더한다음 b를 더한다.(1월은 for문을 돌지 않으니 b만 더해짐)
        for (i in 1 until a) {
            sum += coressponding(i)
        }
        sum += b

        //일수 % 7로 요일을 알아낸다.
        return returnDate(sum % 7)
    }

    fun coressponding(month: Int): Int {
        return when (month) {
            2 -> 29
            4, 6, 9, 11 -> 30
            else -> 31
        }
    }

    fun returnDate(sum: Int): String {
        return when (sum) {
            0 -> "THU"
            1 -> "FRI"
            2 -> "SAT"
            3 -> "SUN"
            4 -> "MON"
            5 -> "TUE"
            else -> "WED"
        }
    }
}

class solution2{
    fun solution(a: Int, b: Int): String {
        val days = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED") //나머지가 0 일때 목요일임
        val lastDays = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        //sumOf -> 모든 요소를 더해서 반환
        val result = (0 until a - 1).sumOf {
            lastDays[it]
        } + b

        return days[result % 7]
    }
}