// ✅ 문제 설명 (Day 3)
// 1부터 n까지의 수 중에서
// - 3의 배수만 골라
// - 각각의 숫자를 뒤집은 형태로 변환한 뒤
// - List<Int> 형태로 반환하라

// 입력: 정수 n (1 이상 10,000 이하)
// 출력: 뒤집힌 숫자 리스트 (예: n=20 → [3, 6, 9, 21, 51, 81])

fun main() {
    println(reverseMultiplesOf3(20).joinToString(","))
}

fun reverseMultiplesOf3(n: Int): List<Int> {
    var list = mutableListOf<Int>()
    for (i in 1 until n) {
        if ((i % 3) == 0) {
            list.add(i)
        }
    }
    return list.map {
        // it.toString().reversed().toInt()
        it.toString().toCharArray().reversed().joinToString("").toInt()
    }
}

// 문제 제대로 이해하지 못함.
// for문 작성법, reversed() 함수 존재 몰라서 GPT에게 물어봄

// 시간복잡도: O(n)
// - 1부터 n까지 반복 → O(n)
// - 3의 배수만 리스트에 저장 (약 n/3개) → O(n)
// - 각 수 뒤집기 (정수 변환, 자릿수 최대 10) → O(1) × O(n/3) → O(n)

// 공간복잡도: O(n)
// - 최대 n/3개의 Int 저장