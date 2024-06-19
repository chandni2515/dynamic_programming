public class SumOfSquareNum {
    public static boolean judgeSquareSum(int c) {
        double len=Math.ceil(Math.sqrt(c));
        System.out.println("len = " + len);
        return false;
    }
    
    public static void main(String[] args){
        boolean result = judgeSquareSum(5);
        System.out.println("result = " + result);

        boolean result2 = judgeSquareSum(3);
        System.out.println("result = " + result2);

        boolean result3 = judgeSquareSum(73);
        System.out.println("result = " + result3);
    }
}
