import java.util.Arrays;

public class ReverseAndCompareTwoArrays {
    public static boolean canBeEqual(int[] target, int[] arr) {
        if(arr.length==1) return true;
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,3};
        int[] target={1,2,3,4};
        System.out.println(canBeEqual(target, arr));
    }
}
