package inflearnCodingTest.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-09 격자판 최대합 todo 강의
 */
public class Array09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 내가 풀기 ⭕
     * 가로, 세로, 왼쪽 대각선, 오른쪽 대각선 각각의 규칙을 찾았음
     * 아예 입력받을 때 규칙에 맞게 합을 구했음 -> 반복문 1번만 사용함
     * 모두 입력받고난 후 max값을 찾았음.
     */
    static void personal(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] square = new int[n][n];

        int tempSum = 0;

        int leftX = 0;
        int rightX = 0;
        int[] jSums = new int[n];
        int iMax = 0;
        int jMax = 0;

        // i=행, j=열
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int in = scanner.nextInt();
                square[i][j] = in;
                tempSum += in;

                jSums[j] += in;
                if (i == j) {
                    leftX += in;
                }
                if ((n - (i+j)) == 1) {
                    rightX += in;
                }
            }

            if (tempSum > iMax) {
                iMax = tempSum;
            }
            tempSum = 0;
        }

        Arrays.sort(jSums);
        jMax = jSums[n-1];

        int maxIJ = Integer.max(iMax, jMax);
        int maxX = Integer.max(leftX, rightX);
        System.out.println(Integer.max(maxIJ, maxX));
    }
}
