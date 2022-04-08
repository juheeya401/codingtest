package Sum;

import java.util.Scanner;

/**
 * todo 강의
 * 03-03. 최대 매출
 * 2022-04-07: ❌ => 계속 타임아웃 남
 * 2022-04-08: ❌ => 계속 타임아웃 남
 */
public class Sum03 {
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
    private static void personal(Scanner scanner) {
        int days = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        int rP = 0, lP = arr.length-1;
        while(rP < lP) {
            int r = 0, l = 0;
            for (int i=0; i<k; i++) {
                r += arr[rP + i];
                l += arr[lP - i];
            }

            max = Math.max(max, Math.max(r, l));
            rP++;
            lP--;
        }

        System.out.println(max);
    }
}
