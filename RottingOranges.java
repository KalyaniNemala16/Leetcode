class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int time = -1;
        int freshOranges = 0;
        Deque<Pair<Integer,Integer>> q = new ArrayDeque<Pair<Integer,Integer>>();

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        if(!q.isEmpty())
        q.add(new Pair(-1,-1));

        if(!q.isEmpty()){
            while(!q.isEmpty()){
                int change = 0;
                Pair<Integer,Integer> p = q.poll();
                int key = p.getKey();
                int val = p.getValue();
                if(key == -1 && val == -1){
                    time++;
                    if(!q.isEmpty())
                    q.add(new Pair(-1,-1));
                }
                else{
                    //check neighbors
                    //top
                    if(key - 1 >=0 ){
                     if(grid[key-1][val] == 1){
                        grid[key-1][val] = 2;
                        q.add(new Pair(key-1,val));
                        freshOranges--;
                     }
                    }
                    //right
                    if(val + 1 < grid[key].length){
                        if(grid[key][val+1] == 1){
                            grid[key][val+1] = 2;
                            q.add(new Pair(key, val+1));
                            freshOranges--;
                        }
                    }
                    //left
                    if(val - 1 >= 0 ){
                        if(grid[key][val-1] == 1){
                            grid[key][val-1] = 2;
                            q.add(new Pair(key,val-1));
                            freshOranges--;
                        }
                    }
                    //bottom
                    if(key + 1 < grid.length){
                        if(grid[key+1][val] == 1){
                            grid[key+1][val] = 2;
                            q.add(new Pair(key+1,val));
                            freshOranges--;
                        }
                    }

                   //Pair<Integer, Integer> temp = q.getLast();
                  // if(temp.getKey() != -1 && time!=-1)
                       // q.add(new Pair(-1,-1));
                }
            }
        }

        if(freshOranges == 0 && time<0) return 0;
        if(freshOranges == 0) return time;
       // if(freshOranges == 1) return -1;

        return -1;
    }
}
