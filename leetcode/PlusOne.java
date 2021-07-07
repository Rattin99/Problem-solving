import java.util.ArrayList;

class PlusOne {
    public static void main(String[] args) {
        int[] numbers = { 8, 9, 9, 9 };
        int a = 10000;
        print(plusOne(numbers));
    }

    static public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n - 1] < 9) {
            digits[n - 1] += 1;
            return digits;
        }
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] + carry > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] += carry;
                carry = 0;
            }
        }
        if (digits[0] == 0) {
            int[] temp = new int[n + 1];
            System.arraycopy(digits, 0, temp, 1, n);
            temp[0] = 1;
            return temp;
        }

        return digits;
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
