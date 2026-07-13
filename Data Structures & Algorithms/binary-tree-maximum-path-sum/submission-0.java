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

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        dfs(root, result);
        return result[0];
    }

    //return node without split
    private int dfs(TreeNode root, int[] result){
        if(root == null){
            return 0;
        }
        int leftNode = Math.max(dfs(root.left, result),0);
        int rightNode = Math.max(dfs(root.right, result),0);
        //get the node with split
        result[0] = Math.max(result[0], root.val + leftNode + rightNode);
        return root.val + Math.max(leftNode, rightNode);
    }
}
