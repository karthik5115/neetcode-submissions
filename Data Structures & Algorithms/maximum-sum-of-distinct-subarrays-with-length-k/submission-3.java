class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        Boolean ty = true;
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            if (set.containsKey(nums[i])) {
                ty = false;
            }
            set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
            windowSum += nums[i];
        }
        long maxSum = ty ? windowSum : 0;
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[index];

            if (set.get(nums[index]) == 1) {
                set.remove(nums[index++]);
            } else {
                set.put(nums[index], set.get(nums[index]) - 1);
                index++;
            }

            set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
            if (set.size() == k) {
                maxSum = Math.max(windowSum, maxSum);
            }
        }
        return maxSum;
    }
}
