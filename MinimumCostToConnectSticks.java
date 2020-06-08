class MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length == 0 || sticks.length == 1) return 0;
       Queue<Integer> pq = new PriorityQueue<Integer>();
        for(int stick : sticks){
            pq.add(stick);
        }
        int result = 0;
        while(pq.size() > 1){
         int a = pq.poll();
            int b = pq.poll();
            result = result + a + b;
            pq.offer(a+b);
        }
        return result;

    }
}
