class MeetingRooms2 {
    public void sort(int[] a){
    for(int i = (a.length/2)-1 ; i>= 0 ; i--){
      order(a,i,a.length);
    }
    for(int i = a.length - 1 ; i>0 ; i--){
      int temp = a[0];
      a[0] = a[i];
      a[i] = temp;
      order(a,0,i);
    }
  }
  public void order(int[] a, int pos, int length){
    int max = pos;
    int left = pos * 2 + 1;
    int right = pos * 2 + 2;
    if(left < length && a[left] > a[max]){
      max = left;
    }
    if(right < length && a[right] > a[max]){
      max = right;
    }
    if(max != pos){
      int temp = a[max];
      a[max] = a[pos];
      a[pos] = temp;
      order(a,max,length);
    }
  }
    public int minMeetingRooms(int[][] intervals) {
       if(intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0 ; i < intervals.length ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        sort(start);
        sort(end);

        int i = 0; int j = 0;
        int meeting = 0;
        if(start[0] == 0 && end[0] == 0)
        {   i++;
            j++;
            }

        while(i<start.length && j<end.length){
            if(start[i] < end[j]){
                meeting++;
            }
            else
            {
                j++;
            }
            i++;
        }
       return meeting;
    }
}
