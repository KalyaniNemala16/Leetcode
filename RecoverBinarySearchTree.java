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
class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pred != null && pred.val > root.val){
                y = root;
                if(x == null) x = pred;
                else break;
            }
            pred = root;
            root = root.right;
        }

        if(x!=null && y!=null)
        {int temp = x.val;
        x.val = y.val;
        y.val = temp;}

    }
}
