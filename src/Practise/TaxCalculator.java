package Practise;

import java.util.Arrays;
import java.util.List;

public class TaxCalculator {


    /**
     tax calculator
    input:
    0-100k--10%
    100-200 20%
    200+- 30%

    salary,tax bracket input, output should be total tax
    */

    static class TaxBracket{
        double lower;
        double upper;
        double tax;
        public TaxBracket(double lower,double upper, double tax){
            this.lower = lower;
            this.upper = upper;
            this.tax = tax;
        }
    }

    private static double calculateTax(List<TaxBracket> taxBracket, double salary){

        /**
        sal=210k-->
         first 100k-->100,000*10/100==10000
        next 100k-->100k*20/100==20000
        remaining 10k-->10000*30/100=3000
        total tax=33000
        */

/**        ****** Simple approach ********* **/
//        double tax = 0;
//        if(salary<=100000){
//            tax=salary*taxBracket.get(0).tax;
//        }else if(salary>100000 && salary<=200000){
//            tax=((salary-100000)*taxBracket.get(1).tax) + (100000*taxBracket.get(0).tax);
//        }else{
//            tax=(100000*taxBracket.get(0).tax) + (100000*taxBracket.get(1).tax) + ((salary-200000)*taxBracket.get(2).tax);
//        }
//        return tax;

        double tax = 0;
        for(TaxBracket tb : taxBracket){
            if(salary>tb.lower){
                double taxableIncome= Math.min(tb.upper,salary)-tb.lower;
                tax+=taxableIncome*tb.tax;
            }else
                break;
        }
        return tax;
    }
    public static void main(String[] args) {

        List<TaxBracket> taxBrackets= Arrays.asList(new TaxBracket(0,100000,0.10),
                                                    new TaxBracket(100000,200000,0.20),
                                                    new TaxBracket(200000,Double.MAX_VALUE,0.30));
        double result = calculateTax(taxBrackets, 210000);
        System.out.println("Total tax: "+result);

    }
}
