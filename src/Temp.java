import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Temp {
    public static ArrayList<Integer> commonElements(ArrayList<ArrayList<Integer>> arr) {
        Set<Integer> result = new HashSet<>(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            result.retainAll(arr.get(i));
            System.out.println("result = " + result);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<Integer>() {{ add(1); add(2); add(3); add(4); }});
        arr.add(new ArrayList<Integer>() {{ add(3); add(4); add(5); add(6); }});
        arr.add(new ArrayList<Integer>() {{ add(7); add(8); add(3); add(4); }});
        arr.add(new ArrayList<Integer>() {{ add(4); add(9); add(8); add(3); }});
        arr.add(new ArrayList<Integer>() {{ add(4); add(3); add(10); add(12); }});


        ArrayList<Integer> res = commonElements(arr);
        if (!res.isEmpty()) {
            System.out.println("The common elements present within the array are: " + res);
        } else {
            System.out.println("There are no common elements present within the array !!");
        }
    }
}

