package inflearnCodingTest.DfsDfs;

/**
 * 07-06. 부분집합 구하기(DFS)
 * #DFS #부분집합
 * ⭐️ 전위순회의 기본!
 * <p>
 * 선생님 말: 스택과 상태트리 그리는거 중요하다. 초보자들은 꼭 그리면서 이해하길 바란다.
 */

import java.util.HashSet;

/**
 * 문제: 자연수 N이 주어지면 1부터 N 까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요
 * 입력설명
 * 첫 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * 출력설명
 * 첫 줄부터 각 줄에 하나씩 부분집합을 아래 출력예제와 같은 순서로 출력한다.
 * 단, 공집합은 출력하지 않는다.
 * 입력예제
 * 3
 * 출력예제
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 *
 * 공집합? = 원소가 하나도 없는 집합
 */
public class Dfs06Copy {

    static int N;
    static int[] ch;

    public static void main(String[] args) {
        String numbers = "123";
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        set.stream().forEach(System.out::println);
    }


    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if (!prefix.equals("") && prefix.length() == 4) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }
}
