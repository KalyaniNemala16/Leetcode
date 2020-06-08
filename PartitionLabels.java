class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i = 0 ; i < S.length() ; i++){
            if(map.containsKey(S.charAt(i))){
                map.replace(S.charAt(i), i);
            }
            else{
                map.put(S.charAt(i) , i);
            }
        }

        int labelstart = 0; int j = 0;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i < S.length() ; i++){
            j = Math.max(j, map.get(S.charAt(i)));
            if(i == j){
                result.add(i - labelstart + 1);
                labelstart = i + 1;
            }
        }
        return result;
    }
}
