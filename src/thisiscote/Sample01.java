package thisiscote;

import utils.ElapsedTimeUtils;

import java.time.Duration;
import java.time.Instant;

/**
 * 피보나치 수열 - 보텀업 다이나믹 프로그래밍 소스코드
 *
 */
public class Sample01 {
    public static  long[] d = new long[100];

    public static void main(String[] args) {
        ElapsedTimeUtils.start();

        fibonacci();

        ElapsedTimeUtils.finish();
    }

    private static void fibonacci() {
        // 첫번째 피보나치 수와 두번째 피보나치수는 1
        d[1] = 1;
        d[2] = 1;
        int n= 50;// 50번째 피보나치 수를 계산

        // 피보나치 함수(Filbonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
        for (int i=3; i<=n; i++) {
            d[i] = d[i-2] + d[i-1];
        }
        System.out.println(d[n]);
    }
}
