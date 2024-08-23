public class GroupOnes {
    public static int minSwaps(int[] nums) {
        int n=nums.length;
        int totalOne=0;
        for (int num : nums) {
            if (num == 1) totalOne++;
        }
        int[] new_nums=new int[n+totalOne];
        for(int i=0;i< new_nums.length;i++){
            if(i<n) new_nums[i]=nums[i];
            else{
                new_nums[i]=nums[i-n];
            }
        }
        int swap=Integer.MAX_VALUE;

        for(int i=0;i<new_nums.length;i++){
            int zeroCount=0,oneCount=0;
            for(int j=0;j<totalOne;j++){
                if(new_nums[j]==1) oneCount++;
                // else oneCount++;
            }
            swap=Math.min(swap,totalOne-oneCount);
        }
        return swap;
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,1,1,0,0};
        System.out.println(minSwaps(nums));
    }
}