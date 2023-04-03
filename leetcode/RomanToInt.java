public class RomanToInt {

    RomanToInt(int a, int b) {
        System.out.println(a + " " + b);
    }

    RomanToInt() {
        this(1, 2);
    }

    public static void main(String[] args) {

    }

    public static int romanToInt(String s) {
        int n = s.length();
        int[] values = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    values[i] = 1;
                    break;
                case 'V':
                    values[i] = 5;
                    break;
                case 'X':
                    values[i] = 10;
                    break;
                case 'L':
                    values[i] = 50;
                    break;
                case 'C':
                    values[i] = 100;
                    break;
                case 'D':
                    values[i] = 500;
                    break;
                case 'M':
                    values[i] = 1000;
                    break;
            }
        }

        for (int i = values.length - 1; i >= 0; i--) {
            if (i == values.length - 1) {
                total += values[i];
            } else {
                if (values[i] < values[i + 1]) {
                    total -= values[i];
                }
                if (values[i] >= values[i + 1]) {
                    total += values[i];
                }
            }
        }

        return total;

    }
}