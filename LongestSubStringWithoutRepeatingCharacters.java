class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Set<Character> set = new HashSet<Character>();
        int len = 0;
        int i = 0;
        int j;
        while(i<s.length()-1){
            j = i+1;
            set.add(s.charAt(i));
            if(j < s.length() && !set.contains(s.charAt(j))){
               while(j<s.length() && !set.contains(s.charAt(j))){
                   set.add(s.charAt(j));

                   if(j+1 < s.length() && set.contains(j+1)){
                       i = j;
                       if(set.size() > len)
                           len = set.size();
                       if(set.size() != 0)
                           set.clear();
                       break;
                   }

                   j++;
               }
            }
            else{
                i++;
                if(set.size() > len)
                    len = set.size();
                if(set.size() != 0)
                    set.clear();
            }
        }
        return len;
    }
}
