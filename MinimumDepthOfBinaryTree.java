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
class MinimumDepthOfBinaryTree {

    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        helper(root,1);
        return minDepth;
    }

    public void helper(TreeNode root, int dist){
        if(root == null) return;
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth,dist);
            return;
        }
        helper(root.left,dist+1);
        helper(root.right,dist+1);
    }
}
