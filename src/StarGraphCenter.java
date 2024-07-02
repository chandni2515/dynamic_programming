import java.util.HashMap;
import java.util.Map;

public class StarGraphCenter {
    public static int findCenter(int[][] edges) {
        Map<Integer,Integer> result=new HashMap<>();
        int j=0;
        for(int i=0;i<edges.length-1;i++){
            for(int val:edges[i+1]){
                if(val==edges[i][j] && j<edges[i].length){
                    result.put(edges[i][j],result.getOrDefault(edges[i][j],0)+1);
                }
                j++;
            }
        }
        System.out.println("map: "+result);
        return 0;
    }

    public static void main(String[] args){
        int[][] edges={{1,2},{2,3},{4,2}};
        int result=findCenter(edges);
        System.out.println("result = " + result);
    }
}
