public class LCM {
    public static void main(String[] args) {

        String[] words = { "flower", "flow", "flight" };

        System.out.println(longestCommonPrefix(words));

    }

    public static String longestCommonPrefix(String[] strs) {
        String control = strs[0];
        int n = strs.length;
        boolean isPrefix = false;
        String res = "";

        for (int i = 0; i < control.length(); i++) {
            char c = control.charAt(i);
            for (int j = 0; j < n; j++) {
                String s = strs[j];
                if (i + 1 > s.length()) {
                    isPrefix = true;
                    break;
                }
                char t = s.charAt(i);
                if (t != c) {
                    isPrefix = true;
                    break;
                }
            }
            if (isPrefix)
                break;

            res += c;
        }

        return res;
    }

}
