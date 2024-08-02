import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] result=new int[nums.length];
        List<List<Integer>> mapped_list=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            String num_st=String.valueOf(nums[j]);
            StringBuilder mapped = getMappedNum(mapping, num_st);
            int new_num=Integer.parseInt(mapped.toString());
            mapped_list.add(Arrays.asList(new_num,j));
            // System.out.println("mapped_list: "+mapped_list);
        }
        Collections.sort(mapped_list,(a,b)-> a.get(0)- b.get(0));
//        mapped_list.sort((a, b) -> a.get(0) - b.get(0));
        for(int i=0;i<result.length;i++){
            int index=mapped_list.get(i).get(1);
            result[i]=nums[index];
        }
        return result;
    }

    private static StringBuilder getMappedNum(int[] mapping, String num_st) {
        StringBuilder mapped=new StringBuilder();
        for(int i = 0; i< num_st.length(); i++){
            char ch= num_st.charAt(i);
            int ch_int=ch-'0';
            mapped.append(mapping[ch_int]);
            // System.out.println("mapped num: "+mapped);
        }
        return mapped;
    }
}
