package Practise.DP_ques;

import java.util.Stack;

public class demo1 {

    public static boolean matchPair(String s){
        Stack<Character> data=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{' || c=='[' || c=='('){
                data.push(c);
            }else if(c=='}' || c==']' || c==')'){
                if(data.isEmpty())
                    return false;
                char top=data.pop();
                if(!isMatching(top,c))
                    return false;
            }
        }
        return data.isEmpty();
    }

    private static boolean isMatching(char top, char c) {
        return (top=='{' && c=='}' ||
                top=='[' && c==']' ||
                top=='(' && c==')');
    }

    public static void main(String[] args) {
        String s="{[()]}";
        String s1="{[(])}";
        System.out.println("result: "+matchPair(s));
        System.out.println("result1 : "+matchPair(s1));
    }

}
