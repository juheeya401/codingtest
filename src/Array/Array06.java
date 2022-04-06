package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.ArrayUtils.*;

/**
 * 02-06 뒤집은 소수 (어렵)
 * 2022-04-05: ⭕ (알고리즘이 다름. 반성할 점도 있으니 읽어보기)
 */
public class Array06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //personal(scanner);
        solution(scanner);
    }

    /**
     * 혼자풀기(전) ⭕
     * 뒤짚고
     * 정렬한 다음에
     * 최대값까지 소수 배열을 만들어 놓고
     * 소수인지 여부 체크해서 리턴
     *
     * 강의풀의 후 반성
     * 1.기능별로 함수를 만들지 않았다. (입력, 변환, 출력 별도의 기능별로 함수 만들어서 호출하자)
     * 2.숫자로 받지 않고 String으로 받았다 -> 숫자를 입력하니까 숫자로 받는게 개발 할 때 더 의미있다.
     * 비교적 잘한 점
     * 1.소수여부 체크 할 때 강의에서는 모든 숫자를 2부터 나누기를 반복했다.
     * 반면에 나는 소수여부 기준 배열을 만들어 놓고 비교했다. -> 내가 더 효율적일 것 같다.
     **/
    public static void personal(Scanner scanner) {
        int count = scanner.nextInt();

        // 뒤짚어서 입력받았다.
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            String temp = scanner.next();
            int parseInt = Integer.parseInt(new StringBuilder(temp).reverse().toString());
            array[i] = parseInt;
        }

        // 배열 복사해서 정렬했다.
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        // 입력받은 숫자 중 가장 큰 값을 뽑았다.
        int maxNum = sortedArray[count - 1];

        // 소수 배열을 만들어놨다.
        int[] sosuArray = createSosuArray(maxNum);

        // 입력원본 배열을 하나씩 열어보면서 소수값만 출력했다.
        for (int num : array) {
            if (sosuArray[num] == 0) {
                System.out.print(num + " ");
            }
        }
    }

    /**
     * 강의 풀이 : 나랑 많이 다르고, 개념부터 다름.
     * 나 반성할 점 있다.
     */
    private static void solution(Scanner scanner) {
        List<Integer> answer = new ArrayList<>();

        // 입력받는다
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        // 숫자를 한 개씩 뒤짚는다
        for (int i = 0; i < count; i++) {
            int temp = revertInt(arr[i]);

            // 소수여부를 확인한다.
            if (isPrime(temp)) {
                // 출력한다.
                answer.add(temp);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
