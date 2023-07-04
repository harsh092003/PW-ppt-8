public class str2 {
    public static boolean checkStr(String s) {
        int bracCount = 0;
        int astrCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                bracCount++;
            } else if (c == ')') {
                if (bracCount > 0) {
                    bracCount--;
                } else if (astrCount > 0) {
                    astrCount--;
                } else {
                    return false;
                }
            } else if (c == '*') {
                astrCount++;
            }
        }

        if (bracCount > astrCount) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "(*()";
        boolean isValid = checkStr(s);
        System.out.println("Is the string valid? " + isValid);
    }
}


