import java.util.*;

public class str4 {
    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        List<Integer> inorder = buildTree(s);
        System.out.print("Inorder traversal: ");
        for (int val : inorder) {
            System.out.print(val + " ");
        }
    }

    public static List<Integer> buildTree(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> inorder = new ArrayList<>();
        int n = s.length();
        int i = 0;
        int rootValue = 0;
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            rootValue = rootValue * 10 + (s.charAt(i) - '0');
            i++;
        }

        rootValue *= sign;
        inorder.add(rootValue);

        if (i < n && s.charAt(i) == '(') {
            i++;
            inorder.addAll(buildTree(s.substring(i)));
            i += findClosingParenthesis(s.substring(i)) + 1;
        }

        if (i < n && s.charAt(i) == '(') {
            i++;
            inorder.addAll(buildTree(s.substring(i)));
        }

        return inorder;
    }

    private static int findClosingParenthesis(String s) {
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }

            i++;
        }

        return -1;
    }
}
