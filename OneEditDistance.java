class OneEditDistance {

    public static boolean replace(String str1, String str2){
        int count = 0;
        for(int i = 0 ; i<str1.length() ; i++){
            if(str1.charAt(i) != str2.charAt(i))
            count++;
        }
        if(count>1)
        {return false;}
        return true;
    }

   public static boolean insert(String bs, String ss){
        int i = 0; int j = 0; boolean flag = true; int count =0;
        while(i<ss.length() && j<bs.length()){
            if(ss.charAt(i)!=bs.charAt(j)){
                if(!flag || count>=1) return false;
               flag = false;
                j++; count++;
            }
            else{
                i++;j++;
                flag = true;
            }
        }
        return true;
    }
    public boolean isOneEditDistance(String s, String t) {
        if((s.isEmpty() && t.isEmpty()) || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;

        boolean res;

        if(s.length() == t.length()) {
        res = replace(s,t);
            return res;
        }

       else if(s.length() > t.length()){
         res = insert(s,t);
           return res;
        }

        else if(s.length() < t.length()){
        res = insert(t,s);
            return res;
        }

        return true;
    }
}
