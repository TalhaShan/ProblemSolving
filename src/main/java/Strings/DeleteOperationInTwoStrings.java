package Strings;

public class DeleteOperationInTwoStrings {
    public static int minDistance(String word1, String word2) {
        int lenWord1 = word1.length();
        int lenWord2 = word2.length();

        // 'dp' table where 'dp[i][j]' will be the edit distance of first 'i' characters of 'word1' and first 'j' characters of 'word2'
        int[][] dp = new int[lenWord1 + 1][lenWord2 + 1];

        // Initialize the first column, which represents the edits required to convert 'word1' substrings into an empty 'word2'
        for (int i = 1; i <= lenWord1; ++i) {
            dp[i][0] = i;
        }

        // Initialize the first row, which represents the edits required to convert an empty 'word1' into substrings of 'word2'
        for (int j = 1; j <= lenWord2; ++j) {
            dp[0][j] = j;
        }

        // Fill in the rest of the DP table
        for (int i = 1; i <= lenWord1; ++i) {
            for (int j = 1; j <= lenWord2; ++j) {
                // If the current characters of 'word1' and 'word2' match, no additional edit is required, take the diagonal value
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, consider the minimum of the cell to the left or above plus one for the edit
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],     // Deletion
                            dp[i][j - 1]);    // Insertion
                }
            }
        }

        // The edit distance between 'word1' and 'word2' is in the bottom-right corner of the DP table
        return dp[lenWord1][lenWord2];
    }

    public static void main(String[] args) {

    }
}
//    The solution adopts a dynamic programming approach to efficiently compute the number of necessary deletion steps. Dynamic programming is a method for solving complex problems by breaking them down into simpler subproblems and storing the results of those subproblems to avoid redundant computations.
//
//        Here is the breakdown of the implementation:
//
//        Initialize the 2D array dp with dimensions (m+1) x (n+1), where m is the length of word1 and n is the length of word2. This array will hold the lengths of LCS for different substrings of word1 and word2. We add 1 to include the empty string cases as well.
//
//        Fill the first row and first column of dp with increasing indices. This takes into account that converting any string to an empty string requires a number of deletions equal to the length of the string.
//
//        Loop through the matrix starting at dp[1][1] and decide for each pair (i, j):
//
//        If word1[i - 1] is equal to word2[j - 1], then dp[i][j] is set to dp[i - 1][j - 1] as the characters match and do not need to be deleted (we extend the LCS).
//        If the characters do not match, we look at two scenarios: deleting the last character from word1 or word2. The value of dp[i][j] is set to the minimum of the two possibilities plus one (for the deletion step): dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1]).
//        After completely filling in the dp table, the value at dp[m][n] is the minimum number of deletion steps necessary for the two words to become the same. This is because dp[m][n] represents the size of the LCS, and by subtracting this from the total length of the two strings, we get the number of characters not part of the LCS, which is exactly the number of deletions needed.
//
//        Return dp[m][n] as the solution.
//
//        The algorithm uses a 2D array for dynamic programming, which is a common data structure for storing intermediary results in dynamic programming tasks. The pattern used is to build up the solution from the smallest subproblems (empty strings) to the full problem by adding one character at a time and determining what the best decision is at each step.
//
//        Example Walkthrough
//        Let's walk through the solution approach with a small example where word1 = "sea" and word2 = "eat". The goal is to find the minimum number of deletions to make word1 equal to word2.
//
//        Initialize the 2D array dp. Given that m = 3 (the length of "sea") and n = 3 (the length of "eat"), the dp array will have dimensions (4 x 4) to include the empty string cases.
//
//        Fill the first row and column with increasing indices, reflecting the deletion count to match an empty string.
//
//        dp = [
//        [0, 1, 2, 3],  // "" -> ""
//        [1, 0, 0, 0],  // "s" -> ""
//        [2, 0, 0, 0],  // "se" -> ""
//        [3, 0, 0, 0]   // "sea" -> ""
//        ]
//        Loop through the dp array and fill it following the rules:
//
//        If word1[i - 1] equals word2[j - 1], set dp[i][j] to dp[i - 1][j - 1].
//        If they do not match, set dp[i][j] to the minimum of dp[i - 1][j] and dp[i][j - 1] plus one.
//        Following this logic, the array is updated as shown below (explanations in comments):
//        dp = [
//        [0, 1, 2, 3],                // Starting row and column
//        [1, 1, 2, 2],                // "s" -> "e" or "" -> "e", "s" -> "ea"
//        [2, 2, 1, 2],                // "se" -> "e", "se" -> "ea" or "s" -> "ea"
//        [3, 2, 2, (1 for 'ea')]     // "sea" -> "e" or "s" -> "e", "sea" -> "ea"  : 'a' matches
//        ]
//        The last cell is '1' since 'a' at the end of both words matches, so we carry over the length of LCS without 'a', which was 0 (since "se" -> "e" required no LCS extensions), and add 1 for the common 'a'.
//
//        After filling in the dp table, the last cell dp[3][3] now contains the length of the LCS. This represents that the strings can become the same with a minimum of 2 deletion steps (m + n - 2 * dp[3][3] = 3 + 3 - 2 * 1 = 4).
//
//        The answer is 4, which means that 4 deletions are necessary for word1 and word2 to become the same.
//
//        In conclusion, using dynamic programming, the algorithm iteratively finds the longest common subsequence and uses its length to calculate the minimal number of deletions required to equalize the provided strings.