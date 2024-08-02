import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathOfCities {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int m=edges.length;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int wt = edge[2];
            dist[a][b] = wt;
            dist[b][a] = wt;
        }

        for(int i=0;i<n;i++) dist[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE ||
                            dist[k][j]==Integer.MAX_VALUE)
                        continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        int city_ct=n;
        int city=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold) count++;
            }
            if(count<=city_ct){
                city_ct=count;
                city=i;
            }
        }
        return city;
    }

    public static void main(String[] args){
        int[][] edges=new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold=4;
        int output = findTheCity(4, edges, distanceThreshold);
        System.out.println("output = " + output);
    }
}
