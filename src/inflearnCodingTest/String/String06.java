package inflearnCodingTest.String;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ️01-06
 * 2022-03-07: ❌
 * 중복되는 문자 중복제거/순서대로 나열하기
 * 내가 푼 것과 강의의 방식이 다르다!
 */
public class String06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        solution(text);
    }

    // 내가풀기1 -> 실패. 순서가 안 맞음
    public static void personal(String text) {
        Set<Character> collect = text.codePoints()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        String answer = collect.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(answer);
    }

    // 내가풀기2 -> 성공. Set 이용 : 순서 보장을 위해서 LinkedHashSet를 사용해야 한다!!
    public static void personal02(String text) {
        //Set<Character> collect = new HashSet<>(); // 순서 보장 안 됨
        Set<Character> collect = new LinkedHashSet<>(); // 순서대로 저장됨
        for (char c : text.toCharArray()) {
            collect.add(c);
        }
        collect.stream().forEach(System.out::print);
    }
    // 내가풀기3 -> StringBuilder 로 풀기
    public static void personal03(String text) {
        StringBuilder answer = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (answer.toString().indexOf(c) < 0) {
                answer.append(c);
            }
        }
        System.out.println(answer);
    }

    // ⭐️강의 해설
    // indexOf로 풀기!!!!!
    public static void solution(String text) {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<text.length(); i++) {
            if (i == text.indexOf(text.charAt(i))) {
                answer.append(text.charAt(i));
            }
        }
        System.out.println(answer);
    }

}
/**
 * ⭐️indexOf()를 위한 문제임!!
 */