class NumberOfIslands {
     public int numIslands(char[][] grid) {
      if(grid == null || grid.length == 0) return 0;
        int num = 0;
        for(int i = 0 ; i<grid.length ; i++){
          for(int j = 0 ; j<grid[i].length ; j++){
              if(grid[i][j] == '1'){
                  num++;
                  numIslands(grid,i,j);
              }
        }
       }
  return num;
  }

  public void numIslands(char[][] grid, int i, int j)
  {
      int rows = grid.length;
      int cols = grid[i].length;
      if(i<0 || i>= rows || j<0 || j>=cols || grid[i][j] == '0' || grid[i][j] == '#')
    {
      return;
    }
      grid[i][j] = '#';

      //down
      if(i+1<rows && grid[i+1][j] == '1'){
       numIslands(grid, i+1, j);
      }
      //up
      if(i-1>=0 && grid[i-1][j] == '1'){
      numIslands(grid, i-1, j);
      }
      //right
      if(j+1 < cols && grid[i][j+1] == '1'){
       numIslands(grid, i ,j+1);
      }
      //left
      if(j-1 >= 0 && grid[i][j-1] == '1'){
      numIslands(grid, i, j-1);
      }
    return;
  }
    }
