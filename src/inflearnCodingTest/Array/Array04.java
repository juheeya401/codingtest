package inflearnCodingTest.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-04 피보나치 수열
 * 2022-03-11:⭕
 */
public class Array04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //personal(count);
        personal02(count);
    }

    // 내가 풀기(전) : 너무 쉽다..⭕
    private static void personal(int count) {
        int[] array = new int[count];
        array[0] = 1;
        array[1] = 1;
        for (int i=2; i<count; i++) {
            array[i] = array[i-2] + array[i-1];
        }
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }

    /**
     * 내가풀기 - 배열 없는 버전 ⭕
     */
    private static void personal02(int count) {
        int prePre = 1;
        int pre = 1;
        System.out.print(prePre + " ");
        System.out.print(pre + " ");
        for (int i=2; i<count; i++) {
            int temp = prePre + pre;
            System.out.print(temp + " ");
            prePre = pre;
            pre = temp;
        }
    }

    /**
     * 강의 해설 1
     * - 배열 버전 (배열을 사용하지 말라는 문제도 있다고 함)
     */
    private static void solution(int count) {
        int[] answer = new int[count];
        answer[0] = 1;
        answer[1] = 1;
        for (int i=2; i<count; i++) {
            answer[i] = answer[i -2] + answer[i-1];
        }
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
