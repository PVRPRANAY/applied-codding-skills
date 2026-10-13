class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int maxKadane = nums[0];
        int currentMax = 0;
        
        int minKadane = nums[0];
        int currentMin = 0;
        
        for (int num : nums) {
            // Standard Kadane's algorithm for maximum subarray sum
            currentMax = Math.max(num, currentMax + num);
            maxKadane = Math.max(maxKadane, currentMax);
            
            // Modified Kadane's algorithm for minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minKadane = Math.min(minKadane, currentMin);
            
            totalSum += num;
        }
        
       
        if (maxKadane < 0) {
            return maxKadane;
        }
        
        return Math.max(maxKadane, totalSum - minKadane);
    }
}