 //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// Knapsack Problem: dynamic programming approach; Time complexity: O(NW)

 import java.util.Collections;
 import java.util.HashMap;
 import java.util.Map;

 public class Main {
    public static void main(String[] args) {
        int[][] input=new int[][]{{2,5},{7,4},{5,3},{2,4},{3,10},{3,5},{4,5},{4,4},{6,5}};
        System.out.println("result: "+areaOfMaxDiagonal(input));
//        int[] weights =new int[]{1,2,3};
//        int[] values =new int[]{6,10,12};
//        int W=5;
//        int N=weights.length;
//        System.out.println("result: "+knapSack(weights,values,W,N));
    }
//     static int knapSack(int[] wt, int[] val, int W, int n)
//    {
//        int i, w;
//        int[][] K = new int[n + 1][W + 1];
//
//        // Build table K[][] in bottom up manner
//        for (i = 0; i <= n; i++) {
//            for (w = 0; w <= W; w++) {
//                if (i == 0 || w == 0)
//                    K[i][w] = 0;
//                else if (wt[i - 1] <= w)
//                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
//                else
//                    K[i][w] = K[i - 1][w];
//            }
//        }
//
//        return K[n][W];
//    }


     public static int areaOfMaxDiagonal(int[][] dimensions) {
         int n=dimensions.length;
         HashMap<Integer,Double> area_maxlength_map= new HashMap<>();
         for(int i=0;i<n;i++){
             double dia_length=Math.sqrt(dimensions[i][0]*dimensions[i][0] + dimensions[i][1]*dimensions[i][1]);
             int area=dimensions[i][0] * dimensions[i][1];
             area_maxlength_map.put(area,dia_length);
         }
         return Collections.max(area_maxlength_map.entrySet(), Map.Entry.comparingByValue()).getKey();
     }
 }