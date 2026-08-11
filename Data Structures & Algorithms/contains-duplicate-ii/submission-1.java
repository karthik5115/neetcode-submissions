class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var set = new HashSet<Integer>();
        var start = 0;
        set.add(nums[start]);
        for (var end = 1; end < nums.length; end++) {
            if (end - start > k) {
                set.remove(nums[start]);
                start++;
            }
            if (!set.add(nums[end])) return true; 
        }
        return false;
    }
}