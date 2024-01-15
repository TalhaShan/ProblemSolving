package Array;

import java.util.Arrays;
import java.util.Collections;

//455. Assign Cookies
//        Easy
//        Topics
//        Companies
//        Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
//
//        Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
//
//
//
//        Example 1:
//
//        Input: g = [1,2,3], s = [1,1]
//        Output: 1
//        Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//        And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//        You need to output 1.
//        Example 2:
//
//        Input: g = [1,2], s = [1,2,3]
//        Output: 2
//        Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
//        You have 3 cookies and their sizes are big enough to gratify all of the children,
//        You need to output 2.
class CookiesContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(s);
        g = Arrays.stream(g).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int qty = 0;
        if (s.length == 0 || g.length == 0) return 0;
        for (int i = 0; i < g.length; i++) {
            while (qty < s.length) {
                if (s[qty] >= g[i]) {
                    s[qty] = s[qty] - g[i];
                    count++;
                    qty = 0;
                    break;
                }
                qty++;
            }
            qty = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2,3}, new int[]{1, 1}));
    }
}