import java.util.*;
public class IntegerToWords {
    Map<Integer, String> numberMap;
    Map<Integer, String> tenMap;
    Map<Integer, String> teenMap;
    Map<Integer, String> bigMap;
    IntegerToWords(){
        numberMap = new HashMap<Integer, String>();
        tenMap = new HashMap<Integer, String>();
        teenMap = new HashMap<Integer, String>();
        bigMap = new HashMap<Integer, String>();

        //numbers

        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");
        numberMap.put(5, "Five");
        numberMap.put(6, "Six");
        numberMap.put(7, "Seven");
        numberMap.put(8, "Eight");
        numberMap.put(9, "Nine");

        //ten to nineteen
        teenMap.put(0, "Ten");
        teenMap.put(1, "Eleven");
        teenMap.put(2, "Twelve");
        teenMap.put(3, "Thirteen");
        teenMap.put(4, "Fourteen");
        teenMap.put(5, "Fifteen");
        teenMap.put(6, "Sixteen");
        teenMap.put(7, "Seventeen");
        teenMap.put(8, "Eighteen");
        teenMap.put(9, "Nineteen");


        //tens

        tenMap.put(2,"Twenty");
        tenMap.put(3,"Thirty");
        tenMap.put(4,"Forty");
        tenMap.put(5,"Fifty");
        tenMap.put(6,"Sixty");
        tenMap.put(7,"Seventy");
        tenMap.put(8,"Eighty");
        tenMap.put(9,"Ninety");

        //Base

        bigMap.put(0, "");
        bigMap.put(1, "Thousand");
        bigMap.put(2, "Million");
        bigMap.put(3, "Billion");

    }
    public String helperHundered(int num){
        int start = 100;
        String s = "";
        while(num > 0){
          int q = num /start;
           int r = num % start;
            if(start == 100 && q!=0){
                s = numberMap.get(q) +" " + "Hundred";
            }
            else if(start == 10 && q!=0){
                if(q == 1){
                    s = s + " " + teenMap.get(r);
                    return s;
                }
                else
                s = s +  " " + tenMap.get(q);
            }
            else if( start == 1 && q!=0){
                s = s + " " + numberMap.get(q) ;
            }
            start = start / 10;
            num = r;
        }

        return s;
    }
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        if(num < 10){
            return numberMap.get(num);
        }
        if(num < 1000){
            return helperHundered(num).trim();
        }

        String str = Integer.toString(num);
        int seg = 0;
        int i = str.length()-1;
        String s = "";
        while(i >= 0){
            int count = 3;
            String hund = "";
            while(count > 0 && i >= 0){
                hund = str.charAt(i) + hund;
                i--;
                count--;
            }

            int hundred = Integer.parseInt(hund);
            String help = helperHundered(hundred).trim();
            if(!help.equals(""))
            s = help + " " + bigMap.get(seg)+ " " + s;
            seg++;
        }

        return s.trim();
    }

    public static void main(String args[]){
    IntegerToWords i = new IntegerToWords();
    System.out.println(i.numberToWords(10100123s));
    }
}
