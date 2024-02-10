package DSAShardaAman;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> setW = new HashSet<>();
        for (int num : nums) {
            if (setW.contains(num)) return true;
            setW.add(num);
        }
        return false;
    }
}
