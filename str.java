public class str {
    public static int minDelSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];

        for (int j = l2-1; j >= 0; j--) {
            dp[l2][j] = dp[l2][j+1] + s2.charAt(j);
        }

        for (int i = l1-1; i >= 0; i--) {
            dp[i][l2] = dp[i+1][l2] + s1.charAt(i);
        }

        for (int i = l1-1; i >= 0; i--) {
            for (int j = l2-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j] + s1.charAt(i), dp[i][j+1] + s2.charAt(j));
                }
            }
        }
        return dp[0][0];
    }
    public static  void main(String args[]){
        String s1 = "sea";
        String s2 = "eat";
        int minSum = minDelSum(s1, s2);
        System.out.println("Minimum ASCII sum of deleted characters: " + minSum);
    }
}

    

