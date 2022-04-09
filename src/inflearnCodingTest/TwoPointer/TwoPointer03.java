package inflearnCodingTest.TwoPointer;

import java.util.Scanner;

/**
 * todo 강의
 * 03-03. 최대 매출
 * #슬라이딩윈도우!! 구현방법! 숙지하기
 * 2022-04-07: ❌ => 계속 타임아웃 남
 * 2022-04-08: ❌ => 계속 타임아웃 남
 */

/**
 * 03-03. 최대 매출
 * 설명
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 * <p>
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * <p>
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 * <p>
 * 예시 입력 1
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 * <p>
 * 예시 출력 1
 * 56
 */
public class TwoPointer03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 전) 혼자하기: ❌
     * 결과: Time Limit Exceeded
     */
    private static void personal01(Scanner scanner) {
        int days = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 0; i < days - k; i++) {
            int temp = 0;
            for (int j = 0; j < k; j++) {
                temp += arr[i + j];
            }

            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }

    /**
     * 전) 혼자하기2: ❌
     * 컨셉: 혼자하기1의 for 문을 1/2만 실행-> 배열의 앞/뒤 같이 계산
     * 결과: Time Limit Exceeded
     */
    private static void personal02(Scanner scanner) {
        int days = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 0; i < days / 2 + 1; i++) {
            int temp1 = 0;
            int temp2 = 0;
            for (int j = 0; j < k; j++) {
                temp1 += arr[i + j];
                temp2 += arr[days - j - 1];
            }

            max = Math.max(Math.max(temp1, temp2), max);
        }

        System.out.println(max);
    }

    /**
     * 전) 혼자하기3: ❌
     * 컨셉: 배열의 좌/우에 포인터를 각각 둬서 반복문을 전체의 반 만 돌 수 있도록 => 근데 타임아웃이네? ㅎㅎ
     * 결과: Time Limit Exceeded
     */
    private static void personal03(Scanner scanner) {
        int days = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        int rP = 0, lP = arr.length - 1;
        while (rP < lP) {
            int r = 0, l = 0;
            for (int i = 0; i < k; i++) {
                r += arr[rP + i];
                l += arr[lP - i];
            }

            max = Math.max(max, Math.max(r, l));
            rP++;
            lP--;
        }

        System.out.println(max);
    }

    /**
     * 후) 내가 풀기: ⭕️
     * 강의풀이 - 생각도 못했던 방법!
     * 슬라이딩윈도우 : 6분부터 설명듣기!
     * 나는 2중 for 문을 이용했다. -> N의2승 -> 타임아웃
     * 방법: for 문 1번만 쓴다.!!!! -> 복잡도=O(N) !!
     * 윈도우를 이동하면서 sum을 계산한다. i가 증가할 때 sum에 증가한 값을 더해주고, 이전 윈도우에서 잘리는 부분은 빼주는 컨셉.
     */
    private static void personal(Scanner scanner) {
        int days = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = scanner.nextInt();
        }

        // sum 초기화 : 첫번째 윈도우를 계산하고 시작한다.
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += arr[i];
        }
        int max = sum;

        // 윈도우를 옮기면서 max를 갱신해나간다.
        for (int i=k; i<days; i++) {
            sum = sum + arr[i] - arr[i - k];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
