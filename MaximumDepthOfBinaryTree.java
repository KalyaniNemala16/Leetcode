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
class MaximumDepthOfBinaryTree {
    public int helper(TreeNode root, int count, int max){
        count++;
        if(root.left == null && root.right == null){
            return Math.max(count,max);
        }
        else{
            if(root.left != null)
            max = Math.max(max, helper(root.left,count,max));
            if(root.right != null)
                max = Math.max(max,helper(root.right,count,max));
        }
        return max;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root,0,Integer.MIN_VALUE);
    }
}
