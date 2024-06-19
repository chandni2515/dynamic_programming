
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChemicalExplosion {
    public static int countExplosivePairs(int N, String[] chemicals) {
        int count = 0;
        Map<String,Integer> doubledMap=new HashMap<>();

        for(String chemical:chemicals){
            String doubledString=chemical+chemical;
            doubledMap.put(doubledString,doubledString.length());
        }

        for(Map.Entry<String,Integer> pair:doubledMap.entrySet()){
            for (int i = 0; i < N; i++) {
                if(areExplosive(pair.getKey(),chemicals[i])){
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean areExplosive(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
            return sortString(s1).equals(sortString(s2));
//        return calculateFrequency(s1).equals(calculateFrequency(s2));
    }

    /*
      Use this approach if the input size is large or the chemical strings are long
      Time complexity= O(N^2*M log M), Space complexity= O(N*M)
     */
    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /*
       Use  this approach If the input size is relatively small and the chemical strings are short,
       Time complexity = O(N^2*M), Space complexity= O(N*M)


    private static Map<Character, Integer> calculateFrequency(String doubledChemical) {
        Map<Character,Integer> charFreq=new HashMap<>();
        char[] charArray = doubledChemical.toCharArray();
        for(char c: charArray){
            charFreq.put(c,charFreq.getOrDefault(c,0)+1);
        }
        System.out.println("charArray = " + charArray);
        return charFreq;
    }

    */

    public static void main(String[] args) {
        // Example 1, Output=2
        int N1 = 5;
        String[] chemicals1 = {"hacker", "int", "niitnt", "hackhackerer", "long"};
        int result1 = countExplosivePairs(N1, chemicals1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2, Output=1
        int N2 = 3;
        String[] chemicals2 = {"medium", "easy", "yeasseya"};
        int result2 = countExplosivePairs(N2, chemicals2);
        System.out.println("Example 2 Output: " + result2);

        // Example 3, Output=3
        int N3 = 5;
        String[] chemicals3 = {"ellhooelhl", "bye", "hello","ybebye","hlelohello"};
        int result3 = countExplosivePairs(N3, chemicals3);
        System.out.println("Example 3 Output: " + result3);
    }
}
