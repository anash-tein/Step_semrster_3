public class findMin {
     public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
 
        while (left < right) {
            int mid = left + (right - left) / 2;
 
            if (nums[mid] > nums[right]) {
                // Minimum must be to the right of mid (rotation point is there)
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right]: mid could BE the minimum,
                // so keep it in the search range
                right = mid;
            }
        }
 
        return nums[left];
    }
 
}
