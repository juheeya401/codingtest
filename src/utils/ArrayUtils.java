package utils;

public class ArrayUtils {

    /***
     * 소수 구하기
     * @param maxNum 범위 최대값
     * @return sosuArray index = 숫자, 배열값 = 소수 여부(0=소수, 1=소수아님)
     */
    private static int[] createSosuArray(int maxNum) {
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
}
