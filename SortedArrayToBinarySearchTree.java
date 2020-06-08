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
class SortedArrayToBinarySearchTree {
    public TreeNode helper(int n[],int s,int e){
      if(e<s) return null;
        int mid = (s+e)/2;
        TreeNode node = new TreeNode(n[mid]);
        node.left = helper(n,s,mid-1);
        node.right = helper(n,mid+1,e);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
      return helper(nums,0,nums.length-1);
    }
}
