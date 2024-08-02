import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> persons=new HashMap<>();
        int n=names.length;
        String[] result=new String[n];
        for(int i=0;i<n;i++){
            persons.put(heights[i],names[i]);
        }
        // System.out.println("map:"+persons);
        int temp=0;
        Arrays.sort(heights);
        int j=n-1;
        for (int key : heights) {
            result[j--] = persons.get(key);
            // System.out.println("result: "+result[i]);
        }

        return result;
    }

    public static void main(String[] args){
        String[] names=new String[]{"IEO","Sgizfdfrims","QTASHKQ","Vk","RPJOFYZUBFSIYp","EPCFFt","VOYGWWNCf","WSpmqvb"};
        int[] heights=new int[]{17233,32521,14087,42738,46669,65662,43204,8224};
        String[] output = sortPeople(names, heights);
        System.out.println("output = " + Arrays.toString(output));
    }
}