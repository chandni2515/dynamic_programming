package Practise.DP_ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sequence {

    public static String[] solution(int n) {
        List<String> res = new ArrayList<>();
        List<List<Integer>> seqs = new ArrayList<>();

        int sqrtN = (int) Math.sqrt(n);
        if (sqrtN * sqrtN == n)
            seqs.add(Collections.singletonList(sqrtN));

        for (int len = 2; (long) len * (len + 1) * (2L * len + 1) / 6 <= n; len++) {
//            int a = len;
//            int b = len * (len - 1);
//            int c = (int) (((long)(len - 1) * len * (2L * len - 1)) / 6 - n);
//
//            long d = (long) b * b - 4L * a * c;

            int a = len;
            int b = len * (len - 1);
            long c = (long)(len - 1) * len * (2L * len - 1) / 6;
            long d = (long) b * b - 4L * a * (c - n);  // <- FIXED HERE

            int sqrtD = (int) Math.sqrt(d);
            if (d < 0 || (long) sqrtD * sqrtD != d) continue;

            for (int sign : new int[]{1, -1}) {
                long num = -b + sign * sqrtD;
                long den = 2L * a;
                if (num % den != 0) continue;

                int p = (int) (num / den);
                if (p <= 0) continue;

                List<Integer> seq = new ArrayList<>();
                int sum = 0;
                for (int i = 0; i < len; i++) {
                    int val = p + i;
                    sum += val * val;
                    seq.add(val);
                }

                if (sum == n) seqs.add(seq);
            }
        }

        seqs.sort((a1, a2) -> a2.size() - a1.size());
        res.add(String.valueOf(seqs.size()));
        for (List<Integer> seq : seqs) {
            StringBuilder sb = new StringBuilder();
            sb.append(seq.size());
            for (int x : seq) sb.append(" ").append(x);
            res.add(sb.toString());
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] result = solution(2030);
        Arrays.stream(result).forEach(System.out::println);
    }
}
