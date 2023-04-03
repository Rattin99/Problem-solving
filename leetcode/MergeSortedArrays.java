public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 3, 4, 5, 6, 7 };

        print(merge(nums1, nums1.length, nums2, nums2.length));

    }

    static public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int pointer1 = 0;
        int pointer2 = 0;
        int[] res = new int[m + n];

        for (int i = 0; i < m + n; i++) {
            if (pointer1 < m) {
                if (nums1[pointer1] <= nums2[pointer2]) {
                    res[i] = nums1[pointer1];
                    pointer1++;

                }
            }
            if (pointer2 < n) {
                if (nums2[pointer2] <= nums1[pointer1]) {
                    res[i] = nums2[pointer2];
                    pointer2++;
                }
            }
        }

        return res;
    }

    static public void print(int[] nums) {
        for (int i : nums)
            System.out.println(i);
    }
}
