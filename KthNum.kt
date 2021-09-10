fun main() {
    //test
    val intArray = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val commands = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    val a = solution(intArray, commands)
    for (i in 0 until commands.size) {
        println("" + a[i])
    }

}

fun solution(array: IntArray, commands: Array<IntArray>): Array<Int?> {
    //원래 return 값(==answer)은 IntArray임.
    //1. 문제에서는 answer = intArray() <<이렇게 초기화 되어 있었다.
    // 마지막에 answer에 값을 넣으려니까
    //list가 아니라 .add는 사용 불가했고
    //answer[index]에 값을 넣어줘야했는데, 처음에 사이즈가 0으로 초기화되어 있어서 에러가 났다.

    //2. answer(==IntArray)을 commands.size 크기로 초기화 하고 싶은데,
    //Array(size){0} << 이런 초기화 방법은 IntArray에서는 불가하고
    //그냥 Array<T>에서만 가능했다.

    //3. Array<T?> 를 arrayOfNulls<T>(size) 로 초기화 하는 방법을 찾아서
    //그냥 문제의 return값을 임의로 바꿔서 문제를 풀었다.
    var answer = arrayOfNulls<Int>(commands.size)

    for (i in commands.indices) {
        val intRange = commands[i][0] - 1 until commands[i][1]
        val pick = commands[i][2] - 1

        answer[i] = array.slice(intRange).sorted()[pick]

    }

    return answer
}

fun solution2(array: IntArray, commands: Array<IntArray>): IntArray {
    //array.map(array->) 은 array를 이용해서 {}안에 있는 메소드?를 실행해서 새로운 array를 반환하는 함수이다.
    //이렇게 하면 알아서 command의 size만큼(3만큼) 실행되서 for문을 쓰지 않아도 되고
    //map이 반환한 array를 toIntArray로 바꾸면 문제의 return값을 바꾸지 않고 문제를 해결 할 수 있다.
    return commands.map { command ->
        array.slice(IntRange(command[0] - 1, command[1] - 1)).sorted()[command[2] - 1]
    }
        .toIntArray()
}
