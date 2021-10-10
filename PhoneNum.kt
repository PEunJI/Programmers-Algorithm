fun main() {
    println(solution6("0101234"))
}

fun solution5(phone_number: String): String {
    var sharp = ""
    var rear4 = phone_number.replaceRange(IntRange(0, phone_number.length - 5), "") //뒷자리4자리
    repeat(phone_number.length - 4) {
        sharp += "*" //앞자리 수만큼 반복..
    }
    return sharp + rear4
}

fun solution6(phone_number: String): String {
    return "".padStart(phone_number.length - 4, '*') + phone_number.takeLast(4)
}
//padstart >> 앞에 padchar을 포함해서 length만큼 글자수를 만들어줌
// + 뒷자리 4자리 더하기