class SlidingWindowMaximum {
    public void clear_deque(ArrayDeque<Integer> d, int i ,int k, int[] nums){
        if(!d.isEmpty() && d.getFirst() == i - k){
            d.removeFirst();
        }
        while(!d.isEmpty() && nums[d.getLast()] < nums[i]){
            d.removeLast();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};
        if(k == 0 || k == 1 || nums.length == 1 ) return nums;

        ArrayDeque<Integer> d = new ArrayDeque<Integer>();
        int[] maximum  = new int[nums.length - k + 1];

        int max = Integer.MIN_VALUE;

        //Initializing deque
        for(int i = 0 ; i<k ; i++){
            clear_deque(d, i ,k, nums);
            d.addLast(i);
            if(nums[i] > max) max = nums[i];
        }
        maximum[0] = max;
        int j = 1;

        //iterating over the rest of the array
        for(int  i = k ; i < nums.length ; i++){
            clear_deque(d, i, k, nums);
            d.addLast(i);
            maximum[j] = nums[d.getFirst()];
            j++;
        }
        return maximum;
    }
}
