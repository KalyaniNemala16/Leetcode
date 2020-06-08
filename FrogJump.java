class FrogJump {
    public boolean canCross(int[] stones, int pos, int k, int[][] cache){
        if(pos == stones.length-1) return true;
        if(cache[pos][k] != -1) {
            if(cache[pos][k] == 0) return false;
            else
                return true;
        }

        boolean res = false;

        for(int j = pos+1 ; j<stones.length ; j++){
            if(stones[j] == stones[pos]+k || stones[j] == stones[pos]+k-1 || stones[j] == stones[pos]+k+1){
                int temp = stones[j] - stones[pos];
              res = canCross(stones,j,temp,cache);

                if(res) {
                     break;
                }
            }
        }
        if(res) cache[pos][k] = 1;
        else cache[pos][k] = 0;
        return res;
    }
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return false;
        int[][] memo = new int[stones.length][stones.length];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return canCross(stones,0,0,memo);
    }
}
