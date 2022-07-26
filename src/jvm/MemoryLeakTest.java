package jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 강참조, 약참조 테스트해보기
 * 참조 : https://ktko.tistory.com/entry/%EC%9E%90%EB%B0%94-%EA%B0%95%ED%95%9C%EC%B0%B8%EC%A1%B0Strong-Reference%EC%99%80-%EC%95%BD%ED%95%9C%EC%B0%B8%EC%A1%B0Weak-Reference
 */
public class MemoryLeakTest {
    private List<WeakReference<BigData>> weakReferences = new LinkedList<>();
    private List<SoftReference<BigData>> softReferences = new LinkedList<>();
    private List<BigData> strongReferences = new LinkedList<>();

    // 약참조 - GC 발생하면 무조건 회수된다.즉, GC 실행 주기와 일치하다
    // oom 발생하지 않음
    public void weakReferenceTest() {
        try {
            for (int i = 0; true; i++) {
                weakReferences.add(new WeakReference<BigData>(new BigData()));
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory error!");
        }
    }

    // 소프트 참조 - 무조건 회수되는건 아니지만, OOM 에 가까워지면 수거된다.
    // oom 발생하지 않음
    public void softReferenceTest() {
        try {
            for (int i = 0; true; i++) {
                softReferences.add(new SoftReference<BigData>(new BigData()));
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory error!");
        }
    }

    // 강참조 - 참조된 객체는 GC 대상에서 제외된다. 즉, 정리되지 않는다. 일반적으로 new 로 생성되는 객체는 강참조이다.
    // ⭐️ oom 발생함.
    public void strongReferenceTest() {
        try {
            for (int i = 0; true; i++) {
                strongReferences.add(new BigData());
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory error!");
        }
    }

    public static void main(String[] args) {
        System.out.println("실행");

        MemoryLeakTest test = new MemoryLeakTest();
        //test.weakReferenceTest();
        //test.softReferenceTest();
        test.strongReferenceTest();

        System.out.println("종료");
    }
}

class BigData {
    private int[] array = new int[2500];
}