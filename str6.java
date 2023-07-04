import java.util.*;
public class str6 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = anagrams(s, p);
        System.out.println("Start Indices of Anagrams: " + result);
    }

    public static List<Integer> anagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int pCount[] = new int[26]; 
        int wCount[] = new int[26];
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        int wSize = p.length();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            wCount[s.charAt(right) - 'a']++;

            if (right - left + 1 > wSize) {
                wCount[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == wSize && matches(pCount, wCount)) {
                result.add(left);
            }

            right++;
        }

        return result;
    }

    private static boolean matches(int[] pCount, int[] wCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != wCount[i]) {
                return false;
            }
        }
        return true;
    }
}

