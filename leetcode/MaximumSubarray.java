class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubarray(nums));
    }

    static public int maxSubarray(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] > 0 ? nums[i] + nums[i - 1] : nums[i];
        }

        int total = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > total) {
                total = i;
            }
        }

        return total;
    }
}