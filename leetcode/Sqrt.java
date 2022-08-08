class Sqrt {
    public static void main(String[] args) {

        System.out.println(mySqrt(8));
    }

    static public int mySqrt(int x) {
        int start = 1;
        int end = x - 1;
        int mid;

        if (x == 0)
            return 0;

        while (end - start > 1) {
            mid = (start + end) / 2;

            if (mid == x / mid)
                return mid;
            if (x / mid > mid) {
                start = mid;
            }
            if (x / mid < mid) {
                end = mid;
            }
        }

        return start;
    }

}