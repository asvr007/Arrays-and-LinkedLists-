import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
       if (s == null || s.length() < 1) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0; 
        int maxLength = 1; 

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; 

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }  

  public static void main(String[] args) {
    Solution m = new Solution();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter string: ");
    String s = sc.next();
    System.out.println("Longest palindrome is : "+ m.longestPalindrome(s));
    }
}
