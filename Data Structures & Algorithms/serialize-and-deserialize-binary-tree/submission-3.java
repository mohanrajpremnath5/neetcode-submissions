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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join(",", list);
    }

    private void dfsSerialize(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsSerialize(root.left, list);
        dfsSerialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split(",");
        int[] i = {0};
        return dfsDeserialize(value, i);
    }

    private TreeNode dfsDeserialize(String[] value, int[] i){
        if("N".equals(value[i[0]])){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(value, i);
        node.right = dfsDeserialize(value, i);
        return node;
    }
}
