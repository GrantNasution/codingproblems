/**
 * Author: Grant Nasution
 * leetcode #128 In an unsorted array find the longest consecutive sequence
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> arr = new HashSet<Integer>();
        for(int i = 0; i < nums.length; ++i) {
            arr.add(nums[i]);
        }
        
        int max = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(!arr.contains(nums[i] - 1)) {
                //follow
                int count = 1;
                for(int j = 1; arr.contains(nums[i] + j); ++j) {
                    count++;
                }
                if(count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
}
