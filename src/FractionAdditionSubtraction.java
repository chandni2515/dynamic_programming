public class FractionAdditionSubtraction {

    public static int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static String fractionAddition(String exp) {
        int nume=0;
        int deno=1;
        int n=exp.length();
        int i=0;

        while(i<n){
            int currNume=0;
            int currDeno=0;
            char c=exp.charAt(i);
            boolean isNeg=(c=='-');

            if(c=='+' || c=='-')
                i++;
            while(i<n && Character.isDigit(exp.charAt(i))){
                int val=exp.charAt(i)-'0';
                currNume=(currNume*10)+val;
                i++;
            }
            i++;
            if(isNeg==true)
                currNume*=-1;

            while(i<n && Character.isDigit(exp.charAt(i))){
                int val=exp.charAt(i)-'0';
                currDeno=(currDeno*10)+val;
                i++;
            }

            nume= nume*currDeno + currNume*deno;
            deno= deno*currDeno;

        }

        int GCD=gcd(Math.abs(nume),deno);
        nume/=GCD;
        deno/=GCD;
        return nume +"/"+ deno;

    }

    public static void main(String[] args) {
        String exp="-1/2+1/2";
        System.out.println("result: "+fractionAddition(exp));
    }
}
