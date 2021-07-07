
class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("Hello World"));
    }

    // 1ms solution, faster than 52%
    static public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals(" "))
            return 0;

        String[] ss = s.split(" ");
        return ss[ss.length - 1].length();
    }

    // 0ms solution, faster than 100%
    static public int lengthOfLastWord2(String s) {
        s = s.trim();

        if (s.isEmpty())
            return 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                return (s.length() - 1) - i;
        }

        return 0;
    }
}