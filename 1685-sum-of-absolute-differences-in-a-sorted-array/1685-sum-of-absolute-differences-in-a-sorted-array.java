class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            int leftDiff = i * nums[i] - leftSum;
            int rightDiff = rightSum - (n - i - 1) * nums[i];
            
            result[i] = leftDiff + rightDiff;
            
            leftSum += nums[i];
        }
        
        return result;
    }
}