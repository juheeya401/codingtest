package utils;

import java.util.HashMap;
import java.util.Map;

public class MapSample {
    public static void main(String[] args) {

        // getOrDefault(키) : 키로 저장된 값이 없다면 기본값을 가져와라.
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', map.getOrDefault('A', 0) + 1); // 새로 알게된 메서드!

    }
}
