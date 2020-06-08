/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if(root == null) return "null#";
        return Integer.toString(root.val) + "#" + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserializer(Queue<String> queue){
        if(queue.isEmpty()) return null;
            String str = queue.poll();
            if(str.equals("null"))
                return null;
            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = deserializer(queue);
            root.right = deserializer(queue);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String node[] = data.split("#");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(node));
        return deserializer(queue);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
