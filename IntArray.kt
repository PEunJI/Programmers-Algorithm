class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = arrayListOf<Int>()
        for (i in arr) {
            if (i % divisor == 0) answer.add(i)
        }
        answer.sort()
        if (answer.size == 0) answer.add(-1)
        return answer.toIntArray()
    }
}

class Solution2 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        arr.forEach {
            if (it % divisor == 0) answer += it
            //크기가 정해지지 않은 intArray에 add를 못해서 Solution처럼 answer을 arraylist로 만든 후에 intarray로 변환햇는데
            //intarry에 + 하면 인자가 더해진다니 ..
        }
        answer.sort()
        if (answer.size == 0) answer += -1
        return answer
    }
}