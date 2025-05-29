package Practise.DP_ques;

import java.util.Scanner;

public class CountingGame {

//    public static boolean isValid(int number) {
//        // Check if the number contains the digit '7' or is divisible by 7
////        return !String.valueOf(number).contains("7") && number % 7 != 0;
//        return (number % 7 != 0) && (String.valueOf(number).indexOf('7') == -1);
//    }

    static boolean containsSeven(int n) {
        if (n == 0) return false;
        int currentN = n;
        while (currentN > 0) {
            if (currentN % 10 == 7) {
                return true;
            }
            currentN /= 10;
        }
        return false;
    }

    static boolean isForbidden(int k) {
        if (k <= 0) {
            return true;
        }
        if (containsSeven(k)) {
            return true;
        }
        for (int d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                if (containsSeven(d)) {
                    return true;
                }
                if (d * d != k) {
                    if (containsSeven(k / d)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//
//        if (!isValid(x)) {
//            System.out.println(-1);
//        } else {
//            // Find the next valid number
//            int nextNumber = x + 1;
//            while (!isValid(nextNumber)) {
//                nextNumber++;
//            }
//            System.out.println(nextNumber);
//        }
//
//        scanner.close();

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        if (isForbidden(x)) {
            System.out.println(-1);
        } else {
            int zackNum = x + 1;
            while (true) {
                if (!isForbidden(zackNum)) {
                    System.out.println(zackNum);
                    break;
                }
                zackNum++;
            }
        }
        scanner.close();
    }
}

