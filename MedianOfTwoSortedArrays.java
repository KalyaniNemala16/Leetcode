class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //to make sure nums1 length is always less than nums2 length
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        //perform binary search on nums1
        int lenX = nums1.length;
        int lenY = nums2.length;

        int start = 0;
        int end = lenX ;
        while(start <= end){
            int partitonX = (start + end) / 2;
            int partitionY = ((lenX + lenY + 1)/2) - partitonX;
            int maxLeftX = (partitonX == 0) ? Integer.MIN_VALUE : nums1[partitonX - 1];
            int minRightX = (partitonX == lenX) ? Integer.MAX_VALUE : nums1[partitonX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == lenY) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((lenX + lenY)%2 == 0)
                {
                    int max = Math.max(maxLeftX,maxLeftY);
                    int min = Math.min(minRightX,minRightY);
                    return (double) (max+min)/2;
                }

                else
                    return Double.valueOf(Math.max(maxLeftX,maxLeftY));
            }
            //go the left because we are too far on the right
            else if(maxLeftX > minRightY){
                end = partitonX -1;
            }
            //go right to the bigger values.
            else
            start = partitonX + 1;

        }
    throw new IllegalArgumentException();
    }
}
