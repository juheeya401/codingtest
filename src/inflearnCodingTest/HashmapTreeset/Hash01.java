package inflearnCodingTest.HashmapTreeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 04-01. 학급 회장(해쉬)
 * #해쉬맵
 * 2022-04-08: ⭕️ -> 맞긴한데 찜찜. -> 오 내가 한 방법 맞음!
 */
public class Hash01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner);
    }

    /**
     * 전) 내가하기
     * 컨셉: Map 이용. 키=사람, 값=투표수.
     *      투표수 저장 후 map 의 키만큼 반복해서 max 값의 사람을 구함
     */
    private static void personal(Scanner scanner) {
        // 입력
        int cnt = scanner.nextInt();
        scanner.nextLine();
        char[] users = scanner.nextLine().toCharArray();

        // map 에 사람:투표수 저장
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            Character key = users[i];
            int value = map.get(key) != null ? map.get(key) : 0;
            map.put(key, value + 1);
        }

        int max = 0;
        Character person = null;
        // 키 만큼 반복해서 투표수 확인
        for (Character key : map.keySet()) {
            Integer integer = map.get(key);
            if (integer > max) {
                max = integer;
                person = key;
            }
        }

        System.out.println(person);
    }

    /**
     * 강의풀이
     * 컨셉: 내가 풀기와 동일.
     * 단, Map 의 새로운 메서드를 알게되었다.
     */
    private static void solution(Scanner scanner) {
        // 입력
        int cnt = scanner.nextInt();
        String str = scanner.next();

        Map<Character, Integer> map = new HashMap<>();
        for (char x: str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // 새로 알게된 메서드!
        }

        char answer = ' ';
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            Integer integer = map.get(key);
            if (integer > max) {
                max = integer;
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
