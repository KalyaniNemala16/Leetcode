class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while(left<right){
            if(height[right] < height[left]){
                if(area < (right - left) * Math.min(height[right], height[left])){
                    area = (right - left) * Math.min(height[right], height[left]);
                }
                right--;
            }
            else{
                if(area < (right - left) * Math.min(height[right], height[left]))
                    area = (right - left) * Math.min(height[right], height[left]);
                left++;
            }
        }
        return area;

    }
}
