package utils;

import java.util.*;

public class ArraySample {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4};

        // 배열 복사
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("arr2 : " + Arrays.toString(arr2));
        // arr2 : [0, 1, 2, 3, 4]

        int[] arr3 = Arrays.copyOf(arr, 3);         // 3개만 복사
        System.out.println("arr3 : " + Arrays.toString(arr3));
        // arr3 : [0, 1, 2]

        int[] arr4 = Arrays.copyOf(arr, 7);         // 복사 대상보다 큰 사이즈면 0으로 채움.
        System.out.println("arr4 : " + Arrays.toString(arr4));
        // arr4 : [0, 1, 2, 3, 4, 0, 0]

        // 범위 복사
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        // 시작 인덱스 <= 범위 < 끝 인덱스 (주의:끝 인덱스는 포함 안 함)
        System.out.println("arr5 : " + Arrays.toString(arr5));
        // arr5 : [2, 3]

        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);  // 복사 대상보다 큰 사이즈면 0으로 채움.
        System.out.println("arr6 : " + Arrays.toString(arr6));
        // arr6 : [0, 1, 2, 3, 4, 0, 0]


        // 배열 채우기 - fill(), setAll()
        int[] arr00 = new int[5];

        Arrays.fill(arr, 9); // 지정 값으로 배열 크기만큼 다 채움
        System.out.println("arr : " + Arrays.toString(arr));
        // arr : [9, 9, 9, 9, 9]

        //Arrays.setAll(arr, () -> (int) (Math.random() * 5) + 1);  // ? 에러나네?


        // 정렬과 검색 - sort(), binarySearch()
        // binarySearch() : 값의 위치 반환. 단, 배열이 정렬되어있어야 함.
        arr = new int[]{3,2,0,1,4};
        int idx = Arrays.binarySearch(arr, 2);
        System.out.println("idx : " + idx);
        // idx : -4 (잘못된 결과! 정렬된 배열이 아니기 때문.)

        // 배열 정렬
        Arrays.sort(arr);
        System.out.println("arr : " + Arrays.toString(arr));
        // arr : [0, 2, 3, 3, 4]

        // 역순 정렬 - Collections.reverseOrder() : 단, 기본형 타입의 배열은 안 됨.
        //Arrays.sort(arr, Collections.reverseOrder());       // int[] 는 에러남
        Integer[] arrInteger = new Integer[]{3,2,0,1,4};

        Arrays.sort(arrInteger);
        System.out.println("Integer[] 순 정렬 : " + Arrays.toString(arrInteger));
        // [0, 1, 2, 3, 4]

        Arrays.sort(arrInteger, Collections.reverseOrder());
        System.out.println("Integer[] 역순 정렬 : " + Arrays.toString(arrInteger));
        // [4, 3, 2, 1, 0]


        // 배열 이진검색 : 빠름. but 정렬된 상태에서만 가능.
        idx = Arrays.binarySearch(arr, 2);  // 2의 인덱스 찾기. 배열 정렬이 됐으므로 정상적으로 찾아짐.
        System.out.println("idx : " + idx); // idx : 1


        // 문자열 비교와 출력 - equals(), toString(), deppEquals(), deepToString()
        int[] arr01 = new int[]{0,1,2,3,4};
        int[][] arr2D = {{11,12},{21,22}};
        int[][][] arr3D = {{{111, 222},{110,220}},{{333, 444},{330,440}}};

        // 출력. toString() : 1차원 / deepToString() : 다차원
        System.out.println("toString(arr01) : " + Arrays.toString(arr01));
        // 1차원 배열만 출력 -> toString(arr) : [0, 1, 2, 3, 4]

        System.out.println("deepToString(arr2D) : " + Arrays.deepToString(arr2D));
        // 다차원 배열 출력 -> deepToString(arr2D) : [[11, 12], [21, 22]]

        System.out.println("deepToString(arr3D) : " + Arrays.deepToString(arr3D));
        // deepToString(arr3D) : [[[111, 222], [110, 220]], [[333, 444], [330, 440]]]


        int[][] arr2D2 = {{11,12},{21,22}};

        // 모든 요소 비교.
        // equals() : 1차원 배열
        // deepEquals() : 다차원 배열 비교
        //  - 다차원 배열은 배열의 배열로서'주소'를 값으로 갖고 있기 때문에
        //    equals()로 비교하면 주소값이 비교되서 항상 false가 나온다
        System.out.println("Arrays.equals(arr01, arr) : " + Arrays.equals(arr01, arr));
        // Arrays.equals(arr01, arr) : true

        System.out.println("Arrays.equals(arr2D, arr2D2) : " + Arrays.equals(arr2D, arr2D2));
        // Arrays.equals(arr2D, arr2D2) : false

        System.out.println("Arrays.deepEquals(arr2D, arr2D2) : " + Arrays.deepEquals(arr2D, arr2D2));
        // Arrays.deepEquals(arr2D, arr2D2) : true


        // 배열 -> List로 변환 - asList(Object... a)
        // 매개변수타입이 가변인수라서 배열 생성없이 요소 나열만 해도 됨.
        List list = Arrays.asList(new Integer[]{1,2,3,4,5});
        System.out.println("list.toString() : " + list.toString());
        // list.toString() : [1, 2, 3, 4, 5] -> List는 배열과 달리 그냥 toString()하면 출력됨.

        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        System.out.println("list2.toString() : " + list2.toString());
        // list2.toString() : [1, 2, 3, 4, 5]

        list.add(6);
        // UnsupportedOperationException 에러 발생
        // -> 주의 : asList()로 생성 시 사이즈 변경, 추가, 삭제 불가.
    }
}