class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0) return "";

        paragraph = paragraph.toLowerCase();
        Map<String,Integer> map = new HashMap<String,Integer>();
        Set<String> ban = new HashSet<String>();
        for(String s : banned){
            ban.add(s);
        }
        int max = -1; String res = "";
        StringBuilder b = new StringBuilder();
        paragraph += ".";
        char chars[] = paragraph.toCharArray();
        for(Character c : chars){
            if(Character.isLetter(c)){
                b.append(Character.toString(c));
            }
            else if(b.length() > 0){
                    String str = b.toString();
                    if(!ban.contains(str)){
                map.put(str,map.getOrDefault(str,0)+1);
                if(map.get(str) > max){
                           max = map.get(str);
                            res = str;
                        }
                    }
                b = new StringBuilder();
                }
                }

        return res;
    }
}
