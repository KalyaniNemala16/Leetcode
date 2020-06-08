class TwoSum {
    public int[] twoSum(int[] nums, int target) {

    //Brute Force O(n^2) time complexity
        /*int index[] = new int[2];
       if(nums.length == 1){
           if(nums[0] == target)
               index[0] = 0;
               return index ;
       }
        else{
        for(int i=0 ; i<nums.length-1 ; i++){
            for(int j=i+1 ; j<nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }

        }
    }
        return index;*/

      //  Optimized solution with O(n) time complexity
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i],i);
        }
        int comp;
        for(int i = 0 ; i<nums.length ; i++){
            comp = target - nums[i];
            if(map.containsKey(comp) && map.get(comp)!=i){
                return new int[]{i,map.get(comp)};
            }
        }
        return new int[2];
}
}
