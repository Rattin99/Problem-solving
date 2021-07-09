// problem no:67, easy, name: add Binary
public class AddBinary {
    public static void main(String[] args) {
        String a = "111";
        String b = "101";
        System.out.println(addBinary(a, b));
    }

    static public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int lenA = ac.length;
        int lenB = bc.length;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        if (lenA >= lenB) {

            int diff = lenA - lenB;
            for (int i = lenA - 1; i >= 0; i--) {
                if (i - diff < 0) {
                    if (ac[i] == '1' && carry == 0) {
                        sb.append('1');
                        carry = 0;
                    } else if (ac[i] == '0' && carry == 1) {
                        carry = 0;
                        sb.append('1');
                    } else if (ac[i] == '1' && carry == 1)
                        sb.append('0');
                    else if (ac[i] == '0' && carry == 0)
                        sb.append(0);
                } else {
                    int j = i - diff;
                    if (ac[i] == '1' && bc[j] == '1' && carry == 1)
                        sb.append('1');
                    else if (ac[i] == '1' && bc[j] == '0' && carry == 0)
                        sb.append('1');
                    else if (ac[i] == '1' && bc[j] == '0' && carry == 1)
                        sb.append('0');
                    else if (ac[i] == '0' && bc[j] == '1' && carry == 0)
                        sb.append('1');
                    else if (ac[i] == '0' && bc[j] == '0' && carry == 0)
                        sb.append('0');
                    else if (ac[i] == '0' && bc[j] == '0' && carry == 1) {
                        sb.append('1');
                        carry = 0;
                    } else if (ac[i] == '0' && bc[j] == '1' && carry == 1) {
                        sb.append('0');
                    } else if (ac[i] == '1' && bc[j] == '1' && carry == 0) {
                        sb.append('0');
                        carry = 1;
                    }
                    ;

                }

            }

            if (carry != 0)
                sb.append('1');

        } else {

            return addBinary(b, a);
        }

        return sb.reverse().toString();
    }

}
