import java.util.*;

public class RelativeArray {
//    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
//        HashMap<Integer,Integer> count=new HashMap<>();
//        int n=arr1.length;
//        List<Integer> output=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            count.put(arr1[i],count.getOrDefault(arr1[i],0)+1);
//        }
//        for(int j=0;j<arr2.length;j++){
//            if(count.containsKey(arr2[j])){
//                int val=count.get(arr2[j]);
//                if(val>1){
//                    while(val>0){
//                        output.add(arr2[j]);
//                        val--;
//                    }
//                }else{
//                    output.add(arr2[j]);
//                }
//            }
//            count.remove(arr2[j]);
//        }
//        List<Integer> remaining = new ArrayList<>();
//        for(int val: count.keySet()){
//            int ct = count.get(val);
//            while (ct>0){
//                remaining.add(val);
//                ct--;
//            }
//        }
//        Collections.sort(remaining);
//        output.addAll(remaining);
//
//        return output.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
//    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = 0;
        for(int i=0;i<arr1.length;i++){
            length = Math.max(length,arr1[i]);
        }
        int[] count = new int[length+1];
        for(int i=0;i<arr1.length;i++){
            count[arr1[i]]++;
        }
        int[] ans = new int[arr1.length];
        int index=0;
        for(int i=0;i<arr2.length;i++){
            while(count[arr2[i]]>0){
                ans[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                ans[index] = i;
                index++;
                count[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr1=new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2=new int[]{2,1,4,3,9,6};
        int[] result = relativeSortArray(arr1, arr2);
        System.out.println("result = " + Arrays.toString(result));
    }
}
