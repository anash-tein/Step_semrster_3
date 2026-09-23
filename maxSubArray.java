public class maxSubArray {
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
 
        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous run, or abandon it and start fresh here
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
 
        return maxSum;
    
}
}
