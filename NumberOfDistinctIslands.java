class NumberOfDistinctIslands {
    public String helper(int[][] grid,int i,int j,String str){
        String top = ""; String bottom = ""; String left = ""; String right = "";
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length|| grid[i][j]<=0) return "";
        grid[i][j] = -1;
        //top
           top =  "top" + helper(grid,i-1,j,"");
        //bottom
        bottom = "bottom" + helper(grid,i+1,j,"");
        //left
          left = "left" + helper(grid,i,j-1,"");
        //right
           right = "right" + helper(grid,i,j+1,"");
       String result = str + top + bottom + left + right;
        return result;
    }
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<String>();
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ;j++){
                if(grid[i][j]>0){
                  String s =  helper(grid,i,j,"current");
                    set.add(s);
                }
            }
        }
        return set.size();
    }
}
