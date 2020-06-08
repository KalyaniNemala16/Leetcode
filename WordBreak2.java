import java.util.*;
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<String>(wordDict);
    Map<String, List<String>> redundant = new HashMap<String, List<String>>();
    return wordBreak(s, wordSet, redundant);
    }
  public List<String> wordBreak(String s, Set<String> wordSet, Map<String, List<String>> redundant){

    List<String> result = new ArrayList<String>();
     if(redundant.containsKey(s))
         return redundant.get(s);
    if(wordSet.contains(s)){
      result.add(s);
    }

    for(int i = 1 ; i<s.length() ; i++){
      String prefix = s.substring(0,i);
      String suffix = s.substring(i,s.length());
      List<String> newStringList = new ArrayList<String>();

      if(wordSet.contains(prefix)){
        List<String> suffixesUntilNow = wordBreak(suffix, wordSet, redundant);
        for(String word : suffixesUntilNow){
          String str = prefix + " " + word;
          newStringList.add(str);
        }
      }

      if(!newStringList.isEmpty()){
        result.addAll(newStringList);
      }


    }
      redundant.put(s, result);

    return result;
  }

  public static void main(String args[]){
    WordBreak2 w = new WordBreak2();
    List<String> wordDict = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
    System.out.println(w.wordBreak("catsanddog", wordDict));
  }
}
