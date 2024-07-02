import java.util.*;

public class ArrayIntersection {
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     int n1=nums1.length;
    //     int n2=nums2.length;
    //     int count=0;
    //     int i=0,j=0,k=0;
    //     List<Integer> result=new ArrayList<>();
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     while(i<n1 && j<n2){
    //         if(nums1[i]<nums2[j]){
    //             i++;
    //         }
    //         else if(nums1[i]>nums2[j]){
    //             j++;
    //         }
    //         else{
    //             result.add(nums1[i]);
    //             i++;
    //             j++;
    //         }

    //     }
    //     return result.stream().mapToInt(Integer::intValue).toArray();
    // }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        List<Integer> result=new ArrayList<>();

        for (int k : nums1) {
            countMap.put(k, countMap.getOrDefault(k, 0) + 1);
        }

        for (int i : nums2) {
            if (countMap.containsKey(i) && countMap.get(i) != 0) {
                int count = countMap.get(i);
                countMap.put(i, count - 1);
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{4,9,5};
        int[] arr2 = new int[]{9,4,9,8,4};
        System.out.println("result = " + Arrays.toString(intersect(arr1, arr2)));
    }
}
