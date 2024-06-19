import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
        // public String replaceWords(List<String> dictionary, String sentence) {
        //     Set<String> st = new HashSet<>();
        //     StringBuilder word = new StringBuilder();
        //     StringBuilder ans = new StringBuilder();
        //     sentence += ' ';


        //     for (String i : dictionary) {
        //         st.add(i);
        //     }

        //     for (char i : sentence.toCharArray()) {
        //         if (i == ' ') {
        //             if (ans.length() > 0) {
        //                 ans.append(' ');
        //             }

        //             StringBuilder temp = new StringBuilder();
        //             for (char j : word.toString().toCharArray()) {
        //                 temp.append(j);
        //                 if (st.contains(temp.toString())) {
        //                     break;
        //                 }
        //             }
        //             ans.append(temp);
        //             word = new StringBuilder();
        //         } else {
        //             word.append(i);
        //         }
        //     }

        //     return ans.toString();
        // }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] words=sentence.split(" ");
        HashSet<String> set = new HashSet<>(dictionary);
        StringBuilder ans = new StringBuilder();

        for(String word:words){
            boolean found=false;
            for(int i=0;i<word.length();i++){
                String partial=word.substring(0,i+1);
                if(set.contains(partial)){
                    ans.append(partial).append(" ");
                    found=true;
                    break;
                }
            }
            if(!found)
                ans.append(word).append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();

    }

    public static void main(String[] args) {

        List<String> dictionary= Arrays.asList("cat","rat","bat");
        String sentence="the cattle was rattled by the battery";
        String answer=replaceWords(dictionary,sentence);
        System.out.println("answer = " + answer);

        List<String> dictionary2= Arrays.asList("a","b","c");
        String sentence2="aadsfasf absbs bbab cadsfafs";
        String answer2=replaceWords(dictionary2,sentence2);
        System.out.println("answer2 = " + answer2);

    }
}
