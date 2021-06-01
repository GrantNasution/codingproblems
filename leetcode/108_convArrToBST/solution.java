/**
 * Author: Grant Nasution
 * leetcode #108 Convert sorted array(increasing order) to a height balanced binary search tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root;
        root = genSubTree(nums, 0, nums.length -1);
        return root;
    }
    
    public int findMid(int left, int right) {
        return (left + right)/2;
    }
    
    public TreeNode genSubTree(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        
        TreeNode root;
        int mid = findMid(left, right);
        root = new TreeNode(nums[mid]);
        root.left = genSubTree(nums, left, mid - 1);
        root.right = genSubTree(nums, mid + 1, right);
        return root;
    }
}
