import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If the number is already in the set, a duplicate exists
            if (!seen.add(num)) {
                return true;
            }
        }
        
        // All elements are distinct
        return false;
    }
}
