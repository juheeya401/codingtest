package Array;

import java.util.Scanner;

/**
 * 02-11. 임시반장 정하기
 * 2022-04-: ❌
 */
public class Array11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 전) 실패
     */
    private static void personal(Scanner scanner) {
        final int LAST_CLASS = 5;

        int count = scanner.nextInt();
        int[][] arr = new int[count + 1][LAST_CLASS + 1];
        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < LAST_CLASS + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int answerPerson = 0;
        int maxSame = Integer.MIN_VALUE;
        for (int i = 1; i < count + 1; i++) {
            //Set<Integer> sameClass = new HashSet<>();
            int countSame = 0;

            for (int j = 1; j < LAST_CLASS + 1; j++) {
                int target = arr[i][j];
                for (int t = 1; t < count + 1; t++) {
                    if (target == arr[t][j]) {
                        //sameClass.add(t);
                        countSame++;
                        break;
                    }
                }
            }

            if (maxSame < countSame) {
                maxSame = countSame;
                answerPerson = i;
            }
        }

        System.out.println(answerPerson);
    }


    private static void personal02(Scanner scanner) {
        final int LAST_CLASS = 5;

        int count = scanner.nextInt();
        int[][] arr = new int[count + 1][LAST_CLASS + 1];
        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < LAST_CLASS + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int answerPerson = 0;
        int maxSame = Integer.MIN_VALUE;
        for (int i = 1; i < count + 1; i++) {
            int cnt = 0;

            for (int j = 1; j < count + 1; j++) {
                for (int t = 1; t < LAST_CLASS + 1; t++) {
                    if (arr[i][t] == arr[j][t]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (maxSame < cnt) {
                maxSame = cnt;
                answerPerson = i;
            }
        }

        System.out.println(answerPerson);
    }
}
