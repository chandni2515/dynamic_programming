import java.util.*;
import java.util.stream.Collectors;

public class Temp {
    public static List<String> commonChars(String[] words) {
        Map<Character, Integer> common = new HashMap<>();
        calculateFrequency(words, 0, common);

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> curr = new HashMap<>();
            calculateFrequency(words, i, curr);
            for (char c : common.keySet()) {
                if (curr.containsKey(c)) {
                    common.put(c, Math.min(common.get(c), curr.get(c)));
                } else {
                    common.put(c, 0);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : common.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                res.add(entry.getKey().toString());
                count--;
            }
        }
        return res;
    }

    private static void calculateFrequency(String[] words, int index, Map<Character, Integer> common) {
        for (char c : words[index].toCharArray()) {
            common.put(c, common.getOrDefault(c, 0) + 1);
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"bella", "label", "roller"};
        System.out.println("words = " + commonChars(words));

    }
}

