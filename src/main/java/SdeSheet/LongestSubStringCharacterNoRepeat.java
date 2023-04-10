package SdeSheet;

import java.util.HashSet;
import java.util.Set;

//A very important correction. Not in the code, but in the explanation:
// We use Set NOT because it stores unique characters,
// but because (in HashSet) the operation 'contains()' runs in O(1).
// We really don't need a data structure that maintains unique elements
// because we are doing that part explicitly using the 'contains()' operation.
// So the code would run fine even with a regular List. But 'contains()'
// in List is typically O(n). Hence the choice of (Hash)Set
public class LongestSubStringCharacterNoRepeat {
    //    "abcabcbb" //APPROACH WE WILL HAVE TWO pointers
    // i and j //j will increment until end
    //i will be there to move window until repeat occur
    //we will keep adding until unique occur and count the size
    //when character repeat we have to remove previous trail and start the new trail
    //keep removing unitl hashset becomes empty as prviious window become useless
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        Set<Character> unique = new HashSet<>();
        while (i < s.length()) {
            if (!unique.contains(s.charAt(i))) {
                unique.add(s.charAt(i));
                max = Math.max(max, unique.size());
                i++;
            } else {
                unique.remove(s.charAt(j));
                j++;
            }
        }
        return max;

    }


}