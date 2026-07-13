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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
        // Output: [1,2,3,null,null,null,4]
        if(preorder.length < 1 || inorder.length < 1){
            return null;
        }
        int mid = -1;
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=0; i<inorder.length; i++){
            if(preorder[0] == inorder[i]){
                mid = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, preorder.length);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}
