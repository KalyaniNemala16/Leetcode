//import java.util.*;

public class WordSearch{
  public boolean exist(char[][] board, String word) {
    if(board.length == 0 || board == null || word == null || word.length() == 0) return false;
    for(int i = 0; i<board.length ; i++){
      for(int j = 0 ; j<board[i].length ; j++){
        if(exist(board, word, 0, i, j))
          return true;
      }
    }
    return false;
  }

  public boolean exist(char[][] clone, String word, int pos, int i, int j){
    if(i<0 || j <0 || i>=clone.length || j>=clone[i].length || pos >=  word.length() || word.charAt(pos)!=clone[i][j]) return false;
    boolean exist = false;
    /*if(pos == word.length()-1){
      if(clone[i][j] == word.charAt(pos))
      return true;
      else
      return false;
    }*/
    if(pos == word.length()-1) return true;
  /*boolean top = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;*/
    char c = clone[i][j];
    clone[i][j] = '#';

    /*//top
    if(canStepInto(clone, word, i-1, j, pos + 1)){
      top = exist(clone, word, pos + 1, i-1, j);
    }
    //right
    if(canStepInto(clone, word, i, j+1, pos + 1) && !top){
      right = exist(clone, word, pos + 1, i, j+1);
    }
    //bottom
    if(canStepInto(clone, word, i+1, j, pos + 1) && !top && !right){
      down = exist(clone, word, pos + 1, i+1, j);
    }
    //left
    if(canStepInto(clone, word, i, j-1, pos + 1) && !top && !right && !down){
      left = exist(clone, word, pos +1, i, j-1);
    }*/
    exist = exist(clone, word, pos + 1, i-1, j) || exist(clone, word, pos + 1, i, j+1) || exist(clone, word, pos + 1, i+1, j) || exist(clone, word, pos +1, i, j-1);
    clone[i][j] = c;
    return exist;
    //return top || down || right || left;
  }

  /*public boolean canStepInto(char[][] clone, String word, int i, int j, int pos){
  if(i<0 || j<0 || i>=clone.length || j>=clone[i].length || pos > word.length() || clone[i][j] != word.charAt(pos))
  {
  return false;
  }
  return true;
}*/


  public static void main(String args[]){
    WordSearch w = new WordSearch();
    char[][] board = new char[][]{
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    };
    String word = new String("ABCCED");
    System.out.println(w.exist(board, word));
  }
}
