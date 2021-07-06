//Remove ELement
// problem no: 27, easy, leetcode

public class RemoveElement {
    public static void main(String[] args) {
        int[] number = { 0, 1, 2, 2, 3, 0, 4, 2 };
        System.out.println(removeElement(number, 2));
        print(number);

    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }

        }

        return index;
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
