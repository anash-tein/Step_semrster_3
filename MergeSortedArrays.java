import java.util.Arrays;

public class MergeSortedArrays {
   
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
 
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        // copy any leftovers from whichever array wasn't fully consumed
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
 
        return result;
    }
 
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6})) + "  (expected [1, 2, 3, 4, 5, 6])");
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{}, new int[]{1, 2, 3})) + "  (expected [1, 2, 3])");
    } 
}
