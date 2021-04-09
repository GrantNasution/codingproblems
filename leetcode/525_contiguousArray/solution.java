/**
 * Author: Grant Nasution
 * Leetcode #525 Given a binary array, find the maximum length of a contiguous subarray with equal numbers of 0's and 1's
 */

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0] == 0 ? -1 : 1;
        for(int i = 1; i < nums.length; ++i) {
            sums[i] = nums[i] == 0 ? sums[i-1] - 1 : sums[i-1] + 1;
        }
        //sumIndex maps the sums to the first index encountered
        //(|nums| * 2) + 1, possible sums
        int[] sumIndex = new int[(nums.length*2) + 1];
        //Init as -1
        for(int i = 0; i < sumIndex.length; ++i) {
            sumIndex[i] = -1;
        }
        int max = 0;
        for(int i = 0; i < sums.length; ++i) {
            int mapIndex = sums[i] >= 0 ? sums[i] : (sums[i] * -1) + nums.length;
            //Save index of the 1st instance of a recorded sum
            if(sumIndex[mapIndex] == -1) {
                sumIndex[mapIndex] = i;
            //Sum occured previously check if distance between 1st recorded sum is gt max
            } else {
                max = max > (i - sumIndex[mapIndex]) ? max : (i - sumIndex[mapIndex]);
            }
            //sum of 0 therefore max subarray is between 0 and this index
            if(mapIndex == 0) {
                max = i + 1;
            }
        }
        return max;
    }
}