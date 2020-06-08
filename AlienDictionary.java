class AlienDictionary {

    public String alienOrder(String[] words) {
       if(words == null || words.length == 0) return "";

        //create the graph and the map with incoming edges
        HashMap<Character,ArrayList<Character>> graph = new HashMap<Character,ArrayList<Character>>();
        Map<Character,Integer> incoming = new HashMap<Character,Integer>();
        //initialized graph and created structure for graph and incoming edges map
        for(String word : words){
        for(char c : word.toCharArray()){
            if(!graph.containsKey(c)){
                graph.put(c,new ArrayList<Character>());
                incoming.put(c,0);
            }
        }
    }

      //fill the graph with adjacancy lists and incoming map with the no of incoming edges for each node.
        for(int i = 0 ; i+1 < words.length ; i++){
            String a = words[i];
            String b = words[i+1];

            if(a.length() > b.length() && a.startsWith(b)){
                //no order
                return "";
            }

            //see if there are unique characters. if yes order can be built. add it to the adjancency list and increment its value in incoming map.
            for(int j = 0 ; j < Math.min(a.length(),b.length()) ; j++){
                if(a.charAt(j) != b.charAt(j)){
                   ArrayList adj = graph.get(a.charAt(j));
                    adj.add(b.charAt(j));
                    incoming.put(b.charAt(j),incoming.get(b.charAt(j)) + 1);
                    //stop the loop running because we already found distinct characters.
                    break;
                }
            }
        }

            //Start topological sort by adding incoming keys with 0 incoming edges in the incoming map into the queue.
            Queue<Character> queue = new LinkedList<Character>();
            for(char c : incoming.keySet()){
                if(incoming.get(c) == 0){
                    queue.add(c);
                }
            }

           //Run the loop until queue is not empty. For every pop check if the character has values in the adjacency list. If yes, decrement the incoming values of the values in the adjacnecncy list and add them to the queue if and only if their value in the incoming map is zero. If a cycle exists then no values will be added to the queue.
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()){
                char node = queue.poll();
                sb.append(node);
                Iterator<Character> itr = graph.get(node).iterator();
                while(itr.hasNext()){
                    char c = itr.next();
                    incoming.put(c,incoming.get(c)-1);
                    if(incoming.get(c) == 0)
                        queue.add(c);
                }
            }

            //Check if the length of the string is equal to the size of the graph.
            if(sb.length() == graph.size())
                return sb.toString();
            //if it is not cycle exists or there is no build order. So return empty string.
            return "";


    }
}
