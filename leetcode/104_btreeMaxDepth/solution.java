/**
 * Author: Grant Nasution
 * leetcode #104 Find max depth of the btree
 */
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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return lDepth < rDepth ? rDepth + 1 : lDepth + 1;
    }

    //Less memory usage due to less recursive calls
    public int memMaxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lDepth, rDepth;
        lDepth = rDepth = 0;
        if(root.left != null)
            lDepth = memMaxDepth(root.left);
        if(root.right != null)
            rDepth = memMaxDepth(root.right);
        return lDepth < rDepth ? rDepth + 1 : lDepth + 1;
    }
}