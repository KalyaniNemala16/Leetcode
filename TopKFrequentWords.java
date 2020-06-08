class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        //frequency map
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }
            else{
                map.put(word,1);
            }
        }

        //define priority queue with descending order(max heap)
       PriorityQueue<String> minheap = new PriorityQueue<String>(
       new Comparator<String>(){
           public int compare(String a,String b){
               return (map.get(a) == map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b);
           }
       }
       );

        for(String word : map.keySet()){
            minheap.add(word);
            if(minheap.size() > k) minheap.poll();
        }

        List<String> result = new ArrayList<String>();
        for(int i = 0 ; i < k ; i++){
            result.add(minheap.poll());
        }
        Collections.reverse(result);
        return result;


    }
}
