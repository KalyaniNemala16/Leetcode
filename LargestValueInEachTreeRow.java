/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LargestValueInEachTreeRow {
    public List<List<Integer>> helper(int level, TreeNode n, List<List<Integer>> al){
        if(n == null) return al;
        List<Integer> pq = null;
        if(level < al.size()){

        }

    }
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> list = new ArrayList<PriorityQueue<Integer>>();
        list = helper(o,root,list);
        List<Integer> result = new LinkedList<Integer>();

        int i = 0;
        for(List<Integer> a : al.values()){
            int x = a.get(a.size()-1);
            result.add(i,x);
            i++;
        }
        return result;
    }
}
