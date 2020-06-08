class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = Integer.MIN_VALUE;
        int right_max = Integer.MIN_VALUE;
        int result = 0;
       while(left < right){
           if(height[left] < height[right]){
               if(height[left] > left_max)
                left_max = height[left];
               else
                result = result + left_max - height[left];
               left++;
           }
           else{
              if(height[right] > right_max)
                  right_max = height[right];
               else
                   result = result + right_max - height[right];
               right--;
           }
       }
        return result;
    }
}
