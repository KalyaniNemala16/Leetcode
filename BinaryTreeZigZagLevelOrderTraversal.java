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
class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
       List<Integer> l = null;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        if(root == null) return al;

        s1.push(root);
        int i = 0;

        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                l = new LinkedList<Integer>();
                al.add(i,l);
                while(!s1.isEmpty()){
                   TreeNode n = s1.pop();
                    l = al.get(i);
                    l.add(n.val);
                    if(n.left != null) s2.push(n.left);
                    if(n.right != null) s2.push(n.right);
                }
            }
            i++;

            if(!s2.isEmpty()){
                l = new LinkedList<Integer>();
                al.add(i,l);
                while(!s2.isEmpty()){
                    TreeNode n = s2.pop();
                    l = al.get(i);
                    l.add(n.val);
                    if(n.right != null) s1.push(n.right);
                    if(n.left != null) s1.push(n.left);
                }
            }
            i++;
        }
        return al;
    }
}
