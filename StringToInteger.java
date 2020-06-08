public class StringToInteger {
   public int myAtoi(String str) {
        double result = 0;
        int i = 0;
        while(i < str.length() && Character.isWhitespace(str.charAt(i))){
          i++;
        }

        if(i == str.length()){
          return 0;
        }
        String s = "";
        boolean negative = false;
           if(str.charAt(i) == '-'){
              negative = true;
              i++;
            }
          while(i<str.length()){
              if(str.charAt(i) >= '0' && str.charAt(i)<= '9'){
                s = s + str.charAt(i);
                i++;
              }
              else return 0;
          }
           result = Double.parseDouble(s);
           if(result != 0 && negative){
            result = -result;
           }

         if(result > Integer.MAX_VALUE){
           return Integer.MAX_VALUE;
         }
         if(result < Integer.MIN_VALUE)
         return Integer.MIN_VALUE;

        return (int)result;
    }

  public static void main(String[] args) {
    StringToInteger m = new StringToInteger();
   System.out.println(m.myAtoi("word  -42"));
  }
}
