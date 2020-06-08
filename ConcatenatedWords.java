class ConcatenatedWords {
    public boolean findAllConcatenatedWordsInADic(Set<String> wordSet, String subWord,Set<String> memo){
        if(memo.contains(subWord)) return true;
        for(int i = 1 ; i < subWord.length() ; i++){
            String prefix = subWord.substring(0,i);
            String suffix = subWord.substring(i);
            if(wordSet.contains(prefix) && (wordSet.contains(suffix) || findAllConcatenatedWordsInADic(wordSet, suffix, memo))){
                memo.add(subWord);
                return true;
            }

        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<String>();
        for(String s : words){
            wordSet.add(s);
        }
        List<String> result = new ArrayList<String>();
        Set<String> memo = new HashSet<String>();
        for(String original : wordSet){
            if(findAllConcatenatedWordsInADic(wordSet, original,memo))
            result.add(original);
        }
         return result;
    }
}
