import kotlin.collections.ArrayList

fun solution2(answers: IntArray): IntArray {
    val person1 = intArrayOf(1, 2, 3, 4, 5)
    val person2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val person3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    val list = arrayListOf<Int>(0, 0, 0)

    //사람별로 답을 맞췄다면 list의 자리 자리에 +1
    for (i in answers.indices) {
        if (answers[i] == person1[i % person1.size]) list[0]++
        if (answers[i] == person2[i % person2.size]) list[1]++
        if (answers[i] == person3[i % person3.size]) list[2]++
    }

    //최댓값 찾기
    val maxNum = list.maxOrNull()
    val temp_answer = arrayListOf<Int>()
    //정답을 맞춘 갯수가 최댓값이랑 같으면 temp_answer 에 자기순서(1,2,3)넣기
    if (maxNum == list[0])
        temp_answer.add(1)
    if (maxNum == list[1])
        temp_answer.add(2)
    if (maxNum == list[2])
        temp_answer.add(3)

    //정렬하고 intarray로 바꿔서 return
    val answer = temp_answer.toIntArray()
    answer.sort()

    return answer
}


fun solution(answers: IntArray): IntArray {
    val person1 = intArrayOf(1, 2, 3, 4, 5)
    val person2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val person3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    val persons = arrayListOf<IntArray>(person1, person2, person3)
    val temp_answer = intArrayOf(0, 0, 0)
    //사람별로 답을 맞췄다면 temp_answer의 자리 자리에 +1
    for (j in persons.indices) {
        for (i in answers.indices) {
            if (answers[i] == persons[j][i]) {
                temp_answer[j]++
            }
        }
    }
    val maxNum = temp_answer.maxOrNull()
    val real_answer: ArrayList<Int> = arrayListOf<Int>()
    //정답맞춘 개수가 maxNum인 사람(1,2,3)을 담는 arraylist
    for (i in 0 until temp_answer.size) {
        if (temp_answer[i] == maxNum) {
            real_answer.add(i + 1)
        }
    }
    val reall = real_answer.toIntArray()
    //정렬
    reall.sort()

    return reall
}