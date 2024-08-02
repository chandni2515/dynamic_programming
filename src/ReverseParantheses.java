import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class ReverseParantheses {
    public String reverseParentheses(String s) {
        String result="";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            StringBuilder temp = new StringBuilder();
            if (c == '(') {
                while (c != ')') {
                    temp.append(c);
                }
            }
            reverse(temp);
        }
        return result;
    }
}