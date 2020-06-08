/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SubTreeOfAnotherTree {
    public String preorder(TreeNode n,String s){
        if(n == null) return "";
        String str = String.valueOf(n.val);
         s = s + "#" + str;
        if(n.left == null){
            s = s + "lnull";
        }
        if(n.right == null){
            s = s + "rnull";
        }
        if(n.left != null)
            s = preorder(n.left,s);
        if(n.right != null)
            s = preorder(n.right,s);

        return s;
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String str = "";
       String strS = preorder(s,str);
        String strT = preorder(t,str);

        if(strS.contains(strT)) return true;
        return false;
    }
}
