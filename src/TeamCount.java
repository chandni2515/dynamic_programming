

import java.util.*;

public class TeamCount {
    public static int numTeams(int[] rating) {
        List<Integer> team=new ArrayList<>(3);
        List<Integer> small=new ArrayList<>();
        List<Integer> big=new ArrayList<>();

        int count=0;
        int n=rating.length;
        for (int k : rating) {
            Map<Integer, Integer> small_map = new TreeMap<>();
            Map<Integer, Integer> large_map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                if (k < rating[j]) {
                    large_map.put(j, rating[j]);
                } else if (k >= rating[j]) {
                    small_map.put(j, rating[j]);
                }
            }
            System.out.println("large_map = " + large_map + " for rating " + k);
            System.out.println("small_map = " + small_map + " for rating " + k);
        }


        return count;
    }

    public static void main(String[] args){
        int[] rating=new int[]{2,5,3,4,1};
        System.out.println("teams: "+numTeams(rating));
    }
}
