public class MaximumGain {

    public static int maximumGain(String s, int x, int y) {
        int result=0;
        String first,second;
        int first_count=0,second_count=0;
        StringBuilder in= new StringBuilder(s);
        if(x>y) {
            first="ab";
            second="ba";
            first_count=x;
            second_count=y;
        }
        else{
            first="ba";
            second="ab";
            first_count=y;
            second_count=x;

        }
        result+=removePairs(in,first)*first_count;
        result+=removePairs(in,second)*second_count;
        return result;
    }

    private static int removePairs(StringBuilder s, String sub) {
        int i=0;
        int count=0;
        while(i<s.length()-1) {
            int j=i+1;
            String sb = String.valueOf(s.charAt(i)) + s.charAt(j);
            if(sb.equals(sub)){
                count++;


                s.deleteCharAt(i);
                s.deleteCharAt(i);
                if(i>0)
                    i--;
            }else{
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="cdbcbbaaabab";
        System.out.println("maxGain = " + maximumGain(s,4,5));

        String s2="aabbaaxybbaabb";
        System.out.println("maxGain = " + maximumGain(s2,5,4));

        String s3="abab";
        System.out.println("maxGain = " + maximumGain(s3,4,5));
    }
}
