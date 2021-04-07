/**
 * Grant Nasution
 * Leet Code Question #101
 * Given the root of a binary tree, determine whether it is symmetric.
 * Notes: This solution is admittedly quite clunky. I desperately need more practice with trees.
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
    public boolean isSymmetric(TreeNode root) {
        if(root.left != null && root.right != null)
            return traverseSubtrees(root.left, root.right);
        else if((root.left != null) != (root.right != null))
            return false;
        else
            return true;
    }
    
    public boolean traverseSubtrees(TreeNode leftTree, TreeNode rightTree) {
        boolean outerSym, innerSym;
        
        //check if values are the same
        if(leftTree.val == rightTree.val) {
            //traverse if both halves contain outer subtrees
            if(leftTree.left != null && rightTree.right != null) {
                outerSym = traverseSubtrees(leftTree.left, rightTree.right);
            }
            //check for asymmetry in outer subtrees
            else if((leftTree.left != null) != (rightTree.right != null)) {
                return false;
            }
            //both halves do not contain outer subtrees
            else {
                outerSym = true;
            }
            //traverse if both halves contain inner subtrees
            if(leftTree.right != null && rightTree.left != null) {
                innerSym = traverseSubtrees(leftTree.right, rightTree.left);
            }
            //check for asymettry in inner subtrees
            else if((leftTree.right != null) != (rightTree.left != null)) {
                return false;
            }
            //both halves do not contain inner subtrees
            else {
                innerSym = true;
            }
            //if outer and inner subtrees are symmetrical 
            if(innerSym && outerSym) {
                return true;
            }
            //inner and/or outer subtrees are aymmetric
            else {
                return false;
            }
        }
        //values not the same
        else {
            return false;
        }
    }
}

/**
 * Better solution taken from leetcode
 */

// public boolean isMirror(TreeNode t1, TreeNode t2) {
//     if (t1 == null && t2 == null) return true;
//     if (t1 == null || t2 == null) return false;
//     return (t1.val == t2.val)
//         && isMirror(t1.right, t2.left)
//         && isMirror(t1.left, t2.right);
// }