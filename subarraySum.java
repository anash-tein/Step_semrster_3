import java.util.HashMap;
import java.util.Map;

public class subarraySum {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix, needed for subarrays starting at index 0
 
        int currentSum = 0;
        int count = 0;
 
        for (int num : nums) {
            currentSum += num;
            // If (currentSum - k) has been seen before, those prefixes mark
            // the start of a subarray ending here that sums to k
            count += prefixCount.getOrDefault(currentSum - k, 0);
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
 
        return count;
    }
}
