package inflearnCodingTest.StackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-01. 올바른 괄호
 * #스택 #stack #스택_대표문제
 * 2022-04-09: ❌
 */

/**
 * 05-01. 올바른 괄호
 * 설명
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 * 입력
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 * 출력
 * 첫 번째 줄에 YES, NO를 출력한다.
 * 예시 입력 1
 * (()(()))(()
 * 예시 출력 1
 * NO
 */
public class StackQueue01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner);
    }

    /**
     * 전) ❌
     * 컨셉: 단순히 열림, 닫힘 갯수만 동일한지 봄
     */
    private static void personal01(Scanner scanner) {
        String input = scanner.nextLine();

        int open = 0;
        int close = 0;
        for (char x : input.toCharArray()) {
            if (x == '(') {
                open++;
            } else {
                close++;
            }
        }

        System.out.println(open == close ? "YES" : "NO");
    }

    /**
     * 후) 직접: ⭕️
     * 컨셉: 열림만 stack에 저장. 닫힘 나오면 pop. 마지막에 stack 이 비어있다면 -> yes
     */
    private static void personal(Scanner scanner) {
        String input = scanner.nextLine();

        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for (char x : input.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                // 여기서 한 번 체크 하는 것 있음 주의
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty() && result) System.out.println("YES");
        else System.out.println("NO");
    }


    /**
     * 강의해설
     * 컨셉: 내 구현과 비슷함.
     */
    private static void solution(Scanner scanner) {
        String input = scanner.nextLine();
        System.out.print(getAnswer(input));
    }

    private static String getAnswer(String input) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : input.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {

                // 여기서 한 번 체크 하는 것 있음 주의
                if (stack.isEmpty()) { // '('이 부족하다! -> NO
                    return "NO";
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return "NO";
        return answer;
    }
}
