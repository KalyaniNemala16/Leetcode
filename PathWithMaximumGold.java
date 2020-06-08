class PathWithMaximumGold {
    public int max(int[][] grid, int i, int j){
        int grid_val = grid[i][j];
        //visited
        grid[i][j] = 0;
        int top = 0; int bottom = 0 ; int left = 0; int right = 0;
        //top
        if(canStep(grid, i-1, j,grid_val)){
            top =  max(grid, i-1 ,j);
        }
        //bootom
        if(canStep(grid,i+1,j,grid_val)){
           bottom =  max(grid,i+1,j);
        }
        //left
        if(canStep(grid,i,j-1,grid_val)){
            left =  max(grid,i, j-1);
        }
        //right
        if(canStep(grid,i,j+1,grid_val)){
            right = max(grid,i,j+1);
        }
        //replacing the visited flag with original value for next iteration
        grid[i][j] = grid_val;
        //find maximum from all the the paths from all directions
        int max1 = Math.max(top,bottom);
        int max2 = Math.max(left,right);
        int max = Math.max(max1,max2);
        int sum = grid[i][j] + max;
        return sum;
    }
    public boolean canStep(int[][] grid, int i, int j, int grid_val){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j] == 0)
            return false;
        return true;
    }
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] != 0){
                int sum = max(grid,i,j);
                  if(sum > max){
                      max = sum;
                  }
            }
        }

    }
        return max;
}
}
