class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        if(s.length() == 1) return s;
        String result = "";
        boolean[][] matrix = new boolean[s.length()][s.length()];
       /* for(boolean row : matrix)
        Arrays.fill(row,false);*/

        for(int j = 0; j < s.length() ; j++){
            int i = 0;
            while(i<=j){
                if(s.charAt(i) == s.charAt(j)){
                    if(i == j || Math.abs(j-i) == 1){
                        matrix[i][j] = true;
                    }
                    else{
                        matrix[i][j] = matrix[i+1][j-1];
                    }
                }
                else
                    matrix[i][j] = false;
                i++;
            }
        }



        int[] coord = new int[]{0,0};

         int max = 0;
        for(int i = 0 ; i<s.length() ; i++){
            int count = 0;
            int r = 0; int c = 0;
            for(int j = i ; j < s.length() ; j++){
              if(matrix[i][j] ){
                  r = i;
                  c = j;
              }
            }
            if(c-r > max){
                max = c-r;
                coord[0] = r;
                coord[1] = c;
            }
        }

        result = s.substring(coord[0],coord[1]+1);

       return result;
    }
}
