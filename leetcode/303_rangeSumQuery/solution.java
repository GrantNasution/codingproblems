/**
 * Author: Grant Nasution
 * Leetcode #303 Construct a NumArray class with a member function that would return the sum of the array between a given range(inclusive)
 */
class NumArray {
    int[] nums;
    int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        //Cache Approach
        sums = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        sums[0] = sum;
        for(int i = 1; i < nums.length; ++i) {
            sums[i] = sums[i-1] - nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        /** Brute Force Approach
            int sum = 0;
            for(; left <= right; ++left) {
                sum += nums[left];
            }
            return sum;
        */
        //Cache Approach
        return sums[left] - sums[right] + nums[right];
    }
}
