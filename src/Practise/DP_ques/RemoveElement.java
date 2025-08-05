package Practise.DP_ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    public static int removeElement(int[] nums, int val){
        int n=nums.length;
        List<Integer> result=new ArrayList<>();

        for(int num:nums){
            if(num!=val){
                result.add(num);
            }
        }
        System.out.println("result: "+result);
        nums=result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("nums: "+ Arrays.toString(nums));
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int result = removeElement(arr, 2);
        System.out.println("result: "+result);
    }
}
