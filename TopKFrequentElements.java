class TopKFrequentElements {

  public void quickSelect(int[] keySet, int low, int high, int k, Map<Integer,Integer> frequencyMap) {
    int N = keySet.length;
    int pivot_pos = partition(keySet, low, high,frequencyMap);

    if (pivot_pos == N - k) {
      return;
    } else if (pivot_pos < N - k)
       quickSelect(keySet, pivot_pos + 1, high, k, frequencyMap);
    else
       quickSelect(keySet, low, pivot_pos - 1, k, frequencyMap);
  }

  public void swap(int[] keySet, int i, int j) {
    int temp = keySet[i];
    keySet[i] = keySet[j];
    keySet[j] = temp;
  }

  public int partition(int[] keySet, int low, int high, Map<Integer,Integer> frequencyMap){
    int rand = (int) (Math.random() * (high - low )) + low;
    swap(keySet, rand, high);

    int part = low; int pivot = keySet[high];
    for(int i = low ; i<=high ; i++){
      if(frequencyMap.get(keySet[i]) < frequencyMap.get(pivot)){
        swap(keySet, i ,part);
        part++;
      }
    }
    swap(keySet, part, high);
    return part;
  }

public int[] topKFrequent(int[] nums, int k) {
    if (nums.length == k)
      return nums;

    // create frequency map
    // takes O(n) time
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int n : nums) {
      frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }
    // create a new array that has all the keys. takes O(n) memory in worst case.
    int[] keySet = new int[frequencyMap.size()];
    int j = 0;
    for (int i : frequencyMap.keySet()) {
      keySet[j] = i;
      j++;
    }

    // do quick select on the new array with the frequencyMap keys. the qucik select
    // has to work on the frequencyMap values. Takes O(n) average time.

    quickSelect(keySet, 0, keySet.length - 1, k, frequencyMap);

    return Arrays.copyOfRange(keySet,keySet.length - k , keySet.length);
  }
}
