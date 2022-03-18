package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 입력값 정렬하고
     * max 길이만큼 배열 만들어서
     * 점수=index, 값=등수로 저장한다
     * 등수는 가장 꼴등부터 매기고, 만약 다음 값이랑 이전값이랑 같으면 등수를 올린다
     * 출력할 때는 원래 받은 값들을 갖고 인덱스 찾아서 등수를 입력한다
     */
    static void personal(Scanner scanner) {
        int count = scanner.nextInt();
        int[] inputs = new int[count];
        for (int i=0; i<count;i++) {
            inputs[i] = scanner.nextInt();
        }
        int[] sortedArray = Arrays.copyOf(inputs, count);
        Arrays.sort(sortedArray);

        int maxScore = sortedArray[count-1];
        int[] dngsu = new int[maxScore+1];
        for (int i=count; i>=0; i--) {

        }
    }
}
