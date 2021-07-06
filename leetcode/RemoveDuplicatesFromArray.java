// remove duplicates from sorted array
// 26th easy problem leetcode
class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] numbers = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(numbers));
        print(numbers);

    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }
        return index + 1;
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
    }
}

// i solved this one all by myself, and it was fater than 100% of java
// submissions running on 0ms
// i can do this!!