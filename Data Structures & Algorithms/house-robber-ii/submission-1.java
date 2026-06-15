class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // Case 1: include nums[0], exclude nums[n-1]
        int max1 = robLinear(nums, 0, n - 2);
        // Case 2: exclude nums[0], include nums[n-1]
        int max2 = robLinear(nums, 1, n - 1);
        return Math.max(max1, max2);
    }

    // Solve the linear house robber on nums[start..end]
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]
        for (int i = start; i <= end; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}