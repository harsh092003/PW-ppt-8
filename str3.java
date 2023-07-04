public class str3 {
    public static int minDist(String wrd1, String wrd2) {
        int m = wrd1.length();
        int n = wrd2.length();
        int dp[][] = new int[m+1][n+1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (wrd1.charAt(i-1) == wrd2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
                }
            }
        }

        return dp[m][n];
    }
    public static void main(String args[]){
        String wrd1 = "sea";
        String wrd2 = "eat";
        int minSteps = minDist(wrd1, wrd2);

        System.out.println("Minimum number of steps: " + minSteps);
    }
}


    


