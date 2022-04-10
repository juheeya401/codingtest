package programers.정렬;

import java.util.Arrays;

/**
 * H-Index (개어렵)
 * 문제 이해도 어렵고, 구현도 어려웠다.
 *
 * 문제 설명
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 어떤 과학자가 발표한 논문 n편 중,
 * h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
 * h의 최댓값이 이 과학자의 H-Index입니다.
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 * 제한사항
 * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 * 입출력 예
 * citations	     return
 * [3, 0, 6, 1, 5]   3
 * 입출력 예 설명
 * 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
 */
public class Array03 {
    public static void main(String[] args) {
        Array03 main = new Array03();

        int[] sample = new int[]{3, 0, 6, 1, 5};
        int solution = main.solution01(sample);
        System.out.println("solution = " + solution);

        int[] sample2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println("solution2 = " + main.solution01(sample2));

        System.out.println("solutionSample: " + main.solutionSample(sample));
        System.out.println("solutionSample2: " + main.solutionSample(sample2));


        // ⭐️ 이런 케이스가 내01번 솔루션이 틀리는 이유다.
        int[] sample3 = new int[]{0, 1, 200, 203, 310, 400}; // 정답=4
        System.out.println("solution01-3 = " + main.solution01(sample3)); // 5 - 오답
        System.out.println("solution02-3 = " + main.solution02(sample3)); // 1 - 오답
        System.out.println("solutionSample3: " + main.solutionSample(sample3)); //4 - 정답
        System.out.println("solution03-3 = " + main.solution03(sample3)); // 4 - 정답
    }

    // 성공사례 찾아본거
    public int solutionSample(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 논문 개수
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    /**
     * 2022-04 시도3) 성공⭐️
     * 원인2 제거
     *  실패: 나는 정렬된 배열에서 max값부터 체크해 나갔다. 그런데 그러면 h의 최대값이 아니라 '최소값'을 구하게 되어버린다.
     *  case3의 경우를 시뮬레이션 해보면 알 수 있다.
     */
    public int solution03(int[] citations) {
        int answer = 0;
        // 1.인용횟수 순서대로 정렬
        Arrays.sort(citations);

        // 2.배열 최소값부터 체크해나간다. (조건검사를 제대로 구현해야한다)
        //for (int i = citations.length - 1; i >= 0; i--) { // 원인2
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 논문 개수
            //if (h >= citations[i]) {  // 원인1
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    /**
     * 2022-04 시도2) 실패
     * 원인1 제거 (문제를 잘 읽어보고 문제의 기준대로하자)
     */
    public int solution02(int[] citations) {
        int answer = 0;
        // 1.인용횟수 순서대로 정렬
        Arrays.sort(citations);

        // 2.인용횟수 Max 값부터 조건 검사
        for (int i = citations.length - 1; i >= 0; i--) { // 원인2 => 왜??? 왜 뒤에서부터 계산하는게 아닌데?? // 왜 작은 인용수부터 체크해야하지??
            int h = citations.length - i; // 논문 개수
            //if (h >= citations[i]) {  // 원인1. 내 조건은 반대로 했음. 문제를 잘 읽어보고 문제의 기준대로하자
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    /**
     * 2022-04 시도1) 실패
     */
    public int solution01(int[] citations) {
        int answer = 0;
        // 1.인용횟수 순서대로 정렬
        Arrays.sort(citations);

        // 2.인용횟수 Max 값부터 조건 검사
        for (int i = citations.length - 1; i >= 0; i--) { // 원인2 => 왜??? 왜 뒤에서부터 계산하는게 아닌데?? // 왜 작은 인용수부터 체크해야하지??
            int h = citations.length - i; // 논문 개수
            if (h >= citations[i]) {  // 원인1.
                answer = h;
                break;
            }
        }
        return answer;
    }
}
