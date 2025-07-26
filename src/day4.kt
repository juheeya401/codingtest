fun removeAndSort(nums: List<Int>, target: Int): List<Int> {
    val removedNums = nums.filter { it != target } // O(n)
    val sortedNums = removedNums
        .distinct()
        .sorted() // O(n)
    return sortedNums
}

fun main() {
    val result = removeAndSort2(listOf(3,4,1,1,2,3,4,5), 1)
    println(result)
}

/**
 * 편의함수 사용하지 않기
 */
// 시간복잡도: O(n²)
// - 타겟 제거는 O(n) → 전체 순회
// - 버블 정렬은 O(n²) → n(n-1)/2번 비교 (최악의 경우)
//   → 이중 for문 안에서 요소들을 계속 비교하고 교환하기 때문
//
// 공간복잡도: O(n)
// - temp 리스트에 최대 n개의 숫자를 저장
fun removeAndSort2(nums: List<Int>, target: Int): List<Int> {
    val temp = mutableListOf<Int>()
    for (i in nums) { // 반복문 낯섦
        if (i != target) {
            temp.add(i)
        }
    }

    for (i in 0 until temp.size - 1) {
        for (j in 0 until temp.size - i - 1) {
            if (temp[j] > temp[j + 1]) {
                val t = temp[j]
                temp[j] = temp[j + 1]
                temp[j + 1] = t
            }
        }
    }

    return temp
}

// 👇 문제 풀이 중 헷갈렸던/질문했던 포인트 요약

// 1. Kotlin 반복문 문법 익숙치 않음 (until)
// 2. mutableListOf() 기본 컬렉션 함수 헷갈림
// 3. 정렬 복잡도 O(n log n), 버블정렬 O(n^2) 감각 약함