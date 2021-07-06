public class searchInsertPosition {
    public static void main(String[] args) {
        int[] numbers = { 1, 3 };
        System.out.println(searchInsert(numbers, 3));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target)
            return 0;
        if (nums[nums.length - 1] < target)
            return nums.length;
        if (nums[nums.length - 1] == target)
            return nums.length - 1;

        return util(nums, target, 0, nums.length - 1);
    }

    public static int util(int[] nums, int target, int s, int e) {
        int mid = (int) (s + e) / 2;

        if (nums[mid] == target)
            return mid;
        if (nums[mid] < target && nums[mid + 1] > target)
            return mid + 1;

        if (nums[mid] > target)
            return util(nums, target, s, mid - 1);
        if (nums[mid] < target)
            return util(nums, target, mid + 1, e);

        else
            return 0;
    }
}
