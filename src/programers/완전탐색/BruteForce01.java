package programers.완전탐색;

import java.util.ArrayList;
import java.util.List;

/**
 * 완전탐색 > 모의고사 (Lv.1)
 *
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class BruteForce01 {

    public static void main(String[] args) {

        System.out.println(Math.max(2, 2));
        BruteForce01 main = new BruteForce01();

        //int[] sample1 = new int[]{1,2,3,4,5};
        //main.solution(sample1);

    }

    /**
     * 2022-04: 가뿐히 통과 호호 ✅
     * 컨셉: 각 학생들의 패턴과 문제 답안을 비교해서 각 학생들의 점수를 채점하는 동시에 가장 maxSum 값을 구한다 -> 채점 종료 후 maxSum과 동일한 학생들만 모아서 출력한다.
     * 예상복잡도: O(N)
     */
    public int[] solution(int[] answers) {
        // 각 학생들의 패턴을 저장했다. i=학생번호, j=패턴
        int[][] pattern = {
                {},
                {1, 2, 3, 4, 5, 1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] sumArr = new int[4]; // 각 학생들의 채점 점수결과를 저장할 배열(학생수+1)
        int maxSum = 0;// 채점결과 가장 높은 점수
        List<Integer> answer = new ArrayList<>();

        // 학생번호 1~3까지 채점한다
        for (int i=1; i<4; i++) {
            int sum = getSum(answers, pattern[i]);
            sumArr[i] = sum;

            // 그리고 채점과 동시에 최고값도 저장한다.
            if (sum > maxSum) maxSum = sum;
        }

        // 학생들의 채점결과를 돌아보면서 maxSum과 동일한 점수의 학생을 저장한다.
        for (int i=1; i<4; i++) {
            if (sumArr[i] == maxSum) answer.add(i);
        }

        return answer.stream().mapToInt(e -> e).toArray();
    }

    private int getSum(int[] answers, int[] pattern) {
        int sum =0;
        int pointer = 0;
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == pattern[pointer]) sum++;
            if (++pointer == pattern.length) pointer = 0;
        }
        return sum;
    }
}
