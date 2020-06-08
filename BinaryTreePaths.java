/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreePaths {
    public void binaryTree(TreeNode root,String traverse, List<String> list){
        if(!traverse.equals(""))
       traverse = traverse + "->" + Integer.toString(root.val);
        else
            traverse = Integer.toString(root.val);

        if(root.left == null && root.right == null) list.add(traverse);

        if((root.left != null && root.right != null)){
        binaryTree(root.left,traverse,list);
        binaryTree(root.right,traverse,list);
        }
        else{
            if(root.left == null && root.right!=null){
             binaryTree(root.right,traverse,list);
            }
            else if(root.left!=null && root.right == null){
              binaryTree(root.left,traverse,list);

            }
        }

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
        binaryTree(root,"",list);
        return list;
    }
}
