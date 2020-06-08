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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root == null) return l;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        int i = 0;
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            l.add(new LinkedList<Integer>());
            if(i % 2 == 0){
                while(!q1.isEmpty()){
                    TreeNode n = q1.poll();
                    l.get(i).add(n.val);
                    if(n.left!= null) q2.add(n.left);
                    if(n.right!=null) q2.add(n.right);
                }
                i++;
            }

            else{
                while(!q2.isEmpty()){
                    TreeNode n = q2.poll();
                    l.get(i).add(n.val);
                    if(n.left!= null) q1.add(n.left);
                    if(n.right!=null) q1.add(n.right);
            }
                i++;
        }

    }
        return l;
}
}
