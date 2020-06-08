class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
       if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        if(minHeap.size() < maxHeap.size() && maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }

    }

    public double findMedian() {
         if(maxHeap.size() > minHeap.size()){

             return Double.valueOf(maxHeap.peek());
         }


            return Double.valueOf(Double.valueOf(minHeap.peek() + maxHeap.peek())/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
