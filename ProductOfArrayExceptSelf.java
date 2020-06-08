class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        result[0] = 1;
            for(int i = 1 ; i < nums.length ; i++){
                result[i] = result[i-1] * nums[i-1];
            }
        int val = nums[nums.length - 1];
        for(int i = nums.length - 2 ; i>=0 ; i--){
            result[i] = result[i] * val;
            val = val * nums[i];
        }
        return result;


    }
}
