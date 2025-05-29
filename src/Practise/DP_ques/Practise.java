package Practise.DP_ques;

import java.util.*;
import java.util.stream.Collectors;

public class Practise {

    public static int findComplement(int num) {
//        StringBuilder sb=new StringBuilder();
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(num));
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1')
                bin.setCharAt(i,'0');
            else
                bin.setCharAt(i,'1');
        }
        return Integer.parseInt(bin.toString(), 2);
    }

    public static int minSubarray ( int[] nums, int p){
        int count = 0;
        int sum = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i : nums) {
            sum += i;
        }
        System.out.println("sum: " + sum);
        int mod = sum % p;
        System.out.println("mod: " + mod);
        Set<Integer> factors=new HashSet<>();
        if (mod == 0) return 0;
        for(int num : nums){
            if(p%num==0)
                factors.add(num);
        }
        return nums.length - factors.size();
    }

    public static void main(String[] args) {
//        System.out.println("result: "+findComplement(5));
        int[] nums = {6, 3, 5, 2};
        int p = 9;
        System.out.println("result: " + minSubarray(nums, p));
        int[] nums2 = {3,1,4,2};
        int p2 = 6;
        System.out.println("result2 : " + minSubarray(nums2, p2));
    }
}