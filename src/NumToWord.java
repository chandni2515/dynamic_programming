import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class NumToWord {

    private static final Map<Integer, String> below_ten = new HashMap<Integer, String>() {{
        put(0, "");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
    }};
    private static final Map<Integer, String> below_twenty = new HashMap<Integer, String>() {{
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
    }};
    private static Map<Integer, String> below_hundred = new HashMap<Integer, String>() {{
        put(1, "Ten");
        put(2, "Twenty");
        put(3, "Thirty");
        put(4, "Fourty");
        put(5, "Fifty");
        put(6, "Sixty");
        put(7, "Seventy");
        put(8, "Eighty");
        put(9, "Ninety");
    }};

    private static String solve(int num) {
        if (num < 10) {
            return below_ten.get(num);
        }
        if (num < 20) {
            return below_twenty.get(num);
        }
        if (num < 100) {
            return below_hundred.get(num / 10) + ((num % 10 != 0) ? " " + below_ten.get(num % 10) : "");
        }
        if (num < 1000) {
            return solve(num / 100) + " Hundred" + ((num % 100 != 0) ? " " + solve(num % 100) : "");
        }
        if (num < 1000000) {
            return solve(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " " + solve(num % 1000) : "");
        }
        if (num < 1000000000) {
            return solve(num / 1000000) + " Million" + ((num % 1000000 != 0) ? " " + solve(num % 1000000) : "");
        }
        return solve(num / 1000000000) + " Billion" + ((num % 1000000000 != 0) ? " " + solve(num % 1000000000) : "");
    }

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return solve(num);
    }

    public static void main(String[] args) {
//        System.out.println("result: "+numberToWords(123));
//        System.out.println("result: "+numberToWords(12345));
//        System.out.println("result: "+numberToWords(1234567));
        System.out.println("result: "+numberToWords(1000010));
//        System.out.println("result: "+numberToWords(0));
    }
}
