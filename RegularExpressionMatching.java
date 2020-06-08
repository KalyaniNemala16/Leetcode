class RegularExpressionMatching {
    public boolean isMatch(String s, String p, Map<String, Boolean> map){
         if(p.isEmpty()) return s.isEmpty();
        if(map.containsKey(s)){
            return map.get(s);
        }
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            boolean result =  (isMatch(s,p.substring(2))) || (first_match && isMatch(s.substring(1), p));
            if(!map.containsKey(s)){
                map.put(s,result);
            }
        else
            map.replace(s,result);
            return result;
        }
        else{
             boolean result =  first_match && isMatch(s.substring(1),p.substring(1));
            if(!map.containsKey(s)){
                map.put(s,result);
            }
        else
            map.replace(s,result);
            return result;
        }
    }
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return isMatch(s,p,map);

    }



}
