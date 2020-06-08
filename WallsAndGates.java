class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return ;
        int rows = rooms.length;
       int cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0 ; i<rows ;i++){
            for(int j = 0; j<cols ; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int max = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            //top
            if(i-1 >= 0 && rooms[i-1][j] == max){
               rooms[i-1][j] = rooms[i][j] + 1;
                queue.add(new int[]{i-1,j});
            }
            //bottom
            if(i+1<rows && rooms[i+1][j] == max){
                rooms[i+1][j] = rooms[i][j] + 1;
                queue.add(new int[]{i+1,j});
            }
            //left
            if(j-1 >= 0 && rooms[i][j-1] == max){
                rooms[i][j-1] = rooms[i][j] + 1;
                queue.add(new int[]{i,j-1});
            }
            //right
            if(j+1 < cols && rooms[i][j+1] == max){
                rooms[i][j+1] = rooms[i][j] + 1;
                queue.add(new int[]{i,j+1});
            }
        }
    }
}
