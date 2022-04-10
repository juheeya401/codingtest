package utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java 정렬 방법들
 *
 * Comparable : 기본 정렬 기준을 구현하는 데 사용(like 오름차순)
 *  - compareTo(O)
 * Comparator : 내림차순, 다른 기준으로 정렬하고자 할 때 사용
 *  - compare(O1, O2)
 */
public class practiceCompare {
    public static void main(String[] args) {
        String[] str = {"cat", "Dog", "lion", "tiger", "Zebra"};

        // String 클래스의 기본정렬(Comparable구현)
        // - 오름차순 기준 : 공백, 숫자, 대문자, 소문자 순 (유니코드 순)
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));   // [Dog, Zebra, cat, lion, tiger] -> 대문자가 먼저 나옴.

        // - 대소문자 무시 옵션 : String.CASE_INSENSITIVE_ORDER
        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(str));   // [cat, Dog, lion, tiger, Zebra]

        // 역순 정렬 (인터페이스 직접 구현)
        Arrays.sort(str, new practiceCompare.Descending()); // 역순 정렬
        System.out.println(Arrays.toString(str));   // [tiger, lion, cat, Dog]

        // 역순 정렬 (람다) ⭐️
        Arrays.stream(str)
                .sorted((a, b) -> b.compareTo(a)); // 반대로 비교하면 역순정렬된다.
        System.out.println(Arrays.toString(str));   // [tiger, lion, cat, Dog]

        // 역순 정렬 (람다 옵션) ⭐️
        Arrays.stream(str)
                .sorted(Comparator.reverseOrder()); // 반대로 비교하면 역순정렬된다.
    }

    // 다른 정렬기준 구현을 위해 Comparator 을 구현하는 클래스 생성.
    static class Descending implements Comparator {

        // 역순 정렬
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Comparable && o2 instanceof Comparable) {
                // 주의 : Object타입은 compareTo() 메서드를 쓸 수 없으니까 Comparable로 형변환 후 비교~
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1;       // 결과에 -1을 곱하거나
                // return c2.compareTo(c1);         // 비교 순서를 바꾸면 됨.(같은 결과)
            }
            return -1;
        }

        // 역순정렬 + 대소문자 무시도 만들고 싶을 때는?
    }
}