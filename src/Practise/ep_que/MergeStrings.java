package Practise.ep_que;

public class MergeStrings {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println("result: "+mergeAlternately(word1,word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (char c : s1) {
            for (char value : s2) {
                sb.append(c);
                sb.append(value);
            }
        }
        return sb.toString();
    }
}
