import java.util.*;
import java.util.stream.Collectors;

public class Practise {

    public static int findComplement(int num) {
//        StringBuilder sb=new StringBuilder();
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(num));
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1')
                bin.setCharAt(i,'0');
            else
                bin.setCharAt(i,'1');
        }
        return Integer.parseInt(bin.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println("result: "+findComplement(5));
    }
}