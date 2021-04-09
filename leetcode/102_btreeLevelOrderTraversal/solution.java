/**
 * Author: Grant Nasution  
 * Leetcode #102 Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' valus.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> inOrder = new ArrayList<>();
        Queue<TreeNode> currLvl = new LinkedList<>();     
        Queue<TreeNode> children = new LinkedList<>();   
        currLvl.add(root);
        while(currLvl.peek() != null) {
            List<Integer> lvlVals = new ArrayList<>();
            for(TreeNode node : currLvl) {
                lvlVals.add(node.val);
                if(node.left != null) {
                    children.add(node.left);
                }
                if(node.right != null) {
                    children.add(node.right);
                }
            }
            inOrder.add(lvlVals);
            currLvl = new LinkedList<>(children);
            children = new LinkedList<>();
        }
        return inOrder;
        
    }
}