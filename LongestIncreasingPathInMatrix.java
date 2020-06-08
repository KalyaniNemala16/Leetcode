class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] cache = new int[matrix.length][];

        // Fill Cache with default value of -1
        for (int rpos =0; rpos < matrix.length; rpos++) {
          cache[rpos] = new int[matrix[rpos].length];
          Arrays.fill(cache[rpos], -1);
        }
        for(int i = 0; i<=matrix.length-1 ; i++){
          for(int j = 0; j<=matrix[i].length-1 ; j++){
          int x = getLongestPath(matrix, i, j,cache);
          if(x > max) max = x;
          }
        }
        return max;
    }
  public int getLongestPath(int[][] matrix, int i, int j, int[][] cache){
    int length = 1;
    int top = 0;
    int bottom = 0;
    int right = 0;
    int left = 0;

    if(cache[i][j] != -1) return cache[i][j];
    //top
    if(j>=0 && i > 0 && i< matrix.length && j<matrix[i].length && matrix[i-1][j] > matrix[i][j]){
       top = length + getLongestPath(matrix,i-1,j,cache);
    }
    //left
    if(j>0 && i >= 0 && i< matrix.length && j<matrix[i].length && matrix[i][j-1] > matrix[i][j]){
     left = length + getLongestPath(matrix,i,j-1,cache);
   }
   if(j>=0 && i >=0 && i<matrix.length-1 && j<matrix[i].length && matrix[i+1][j] > matrix[i][j]){
     bottom = length + getLongestPath(matrix,i+1,j,cache);
   }
   if(j>=0 && i >=0 && i< matrix.length && j<matrix[i].length - 1 && matrix[i][j+1] > matrix[i][j]){
     right = length + getLongestPath(matrix,i,j+1,cache);
   }
   int max1 = Math.max(top,bottom);
   int max2 = Math.max(left,right);
    int max3 = Math.max(Math.max(max1,max2),length);
    cache[i][j] = max3;
    return max3;

  }
}
