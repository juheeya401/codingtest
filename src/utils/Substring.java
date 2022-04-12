package utils;

public class Substring {
    public static void main(String[] args) {
        String text = "1234567";
        System.out.println(text.substring(1));

        String newText = "1234";
        System.out.println(text.substring(newText.length()));

        System.out.println(newText.substring(0, 4));
    }
}
