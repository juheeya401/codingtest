package utils;

public class ArrayUtils {

    /***
     * 소수 구하기
     * @param maxNum 범위 최대값
     * @return sosuArray index = 숫자, 배열값 = 소수 여부(0=소수, 1=소수아님)
     */
    public static int[] createSosuArray(int maxNum) {
        int[] sosuArray = new int[maxNum+1];
        sosuArray[0] = 1;
        sosuArray[1] = 1;
        for (int i=2; i<=maxNum; i++) {
            if (sosuArray[i] == 0) {
                for (int j=i; j<=maxNum; j=j+i) {
                    if (j > i) {        // i 본인은 소수이므로 0 유지해야 함.
                        sosuArray[j] = 1;
                    }
                }
            }
        }
        return sosuArray;
    }

    /**
     * 숫자 뒤짚기
     * @param number 뒤짚을 숫자
     * @return int 뒤짚어진 숫자
     */
    public static int revertInt(int number) {
        int answer = 0;
        while (number > 0) {
            int t = number % 10;
            answer = answer * 10 + t;
            number = number / 10;
        }
        return answer;
    }

    /**
     * 소수여부 체크
     * @param number
     * @return boolean
     */
    public static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i < number; i++) { // 주의! 2부터 자기자신 전 까지만 나눠지는지 체크해야 한다.!
            if (number % i == 0) return false;
        }
        return true;
    }
}
