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
    public boolean isValidBST(TreeNode root) {
        return dst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dst(TreeNode node, int left, int right){
        if(node == null){
            return true;
        }
        if(!(node.val > left && node.val < right)){
            return false;
        }
        return (dst(node.left, left, node.val) && 
                dst(node.right, node.val, right));
    }
}
