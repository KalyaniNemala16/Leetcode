import java.util.*;

public class WordBreak {
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<String>(wordDict);
    Set<String> redundant = new HashSet<String>();
    return wordBreak(s, set, redundant);
  }

  public boolean wordBreak(String sub, Set<String> set, Set<String> redundant){
    if(set.contains(sub)){
      return true;
    }
    if(redundant.contains(sub)) return false;
    for(int i = 0 ; i<sub.length() ; i++){
      String prefix = sub.substring(0,i);
      String suffix = sub.substring(i, sub.length());
      if(set.contains(prefix) && wordBreak(suffix, set, redundant)){
        return true;
      }
    }
    redundant.add(sub);
    return false;
  }
  public static void main(String[] args) {
    WordBreak w = new WordBreak();
    List<String> wordDict = new ArrayList<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
    String s = new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
    System.out.println(w.wordBreak(s,wordDict));
  }
}
