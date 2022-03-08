import java.util.*;

/**
 * 01-08
 * 채점은 통과. but 강의에서는 다른 방법으로 알려줌
 */
public class String08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();        
        String answer = personal(text);
        System.out.println(answer);
    }
    
    public static String personal(String text) {
        String answer = "YES";
        
        char[] texts = text.toLowerCase().toCharArray();
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (texts[left] != texts[right]) return "NO";
            else {
                left++;
                right--;
            }
        }
        
        return answer;
    }
    
    // 강의 해설 - 방법1 : for 문을 1/2만 돌리기
    public static void solution(String text) {
        
        for (int i=0; i<text.length()/2)
    }
}