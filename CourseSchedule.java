class CourseSchedule {
    public boolean cycle(int num, int[][] edges){
    HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    for(int i = 0 ; i < edges.length ; i++){
      if(graph.containsKey(edges[i][0])){
        List<Integer> l = graph.get(edges[i][0]);
        l.add(edges[i][1]);
        graph.put(edges[i][0],l);
      }
      else{
        List<Integer> l = new ArrayList<Integer>();
        l.add(edges[i][1]);
        graph.put(edges[i][0],l);
      }
    }

    boolean[] visited = new boolean[num];
    boolean[] path = new boolean[num];

    for(int i = 0 ; i<num ; i++){
      if(cycle(i, graph, visited, path))
      return false;
    }

    return true;

  }

  public boolean cycle(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited, boolean[] path){
    if(path[node]){
      return true;
    }
    if(visited[node]){
      return false;
    }
    if(!graph.containsKey(node))
    {
      return false;
    }
    path[node] = true;

    //boolean result;
    List<Integer> adj = graph.get(node);
    for(int j : adj){
      if(cycle(j, graph, visited, path))
      return true;
    }
    path[node] = false;
    visited[node] = true;
    return false;
  }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return cycle(numCourses, prerequisites);
    }
}
