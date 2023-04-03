// problem no: 28, easy

public class ImplementStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));

    }

    public static int strStr(String hayStack, String needle) {

        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < hayStack.length() - needle.length(); i++) {
            if (hayStack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
