/**
 * Author: Grant Nasution  
 * Leetcode #103 Binary Tree ZigZag Level Order Traversal
 * Given the root of a binary tree, return the Zig Zag(reft to right, then right to left) level order traversal of its nodes' values.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> inOrder = new ArrayList<>();
        List<TreeNode> currLvl = new ArrayList<>();     
        List<TreeNode> children = new ArrayList<>();
        boolean LtoR = true;
        
        currLvl.add(root);
        while(!currLvl.isEmpty()) {
            List<Integer> lvlVals = new ArrayList<>();
            
            for(int i = 0, j = currLvl.size() - 1; i < currLvl.size(); i++, j--) {
                TreeNode node;
                if(LtoR) {
                    //Add values left to right
                    node = currLvl.get(i);
                    lvlVals.add(node.val);
                }
                else {
                    //Add values right to left
                    node = currLvl.get(j);
                    lvlVals.add(node.val);
                }
                
                node = currLvl.get(i);
                if(node.left != null) {
                    children.add(node.left);
                }
                if(node.right != null) {
                    children.add(node.right);
                }
            }
            
            LtoR = !LtoR;
            inOrder.add(lvlVals);
            currLvl = new LinkedList<>(children);
            children = new LinkedList<>();
        }
        return inOrder;
    }
}