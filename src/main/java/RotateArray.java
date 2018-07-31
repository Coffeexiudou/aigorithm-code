public class RotateArray {

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.

     Example 1:

     Input: [1,2,3,4,5,6,7] and k = 3
     Output: [5,6,7,1,2,3,4]
     Explanation:
     rotate 1 steps to the right: [7,1,2,3,4,5,6]
     rotate 2 steps to the right: [6,7,1,2,3,4,5]
     rotate 3 steps to the right: [5,6,7,1,2,3,4]
     Example 2:

     Input: [-1,-100,3,99] and k = 2
     Output: [3,99,-1,-100]
     Explanation:
     rotate 1 steps to the right: [99,-1,-100,3]
     rotate 2 steps to the right: [3,99,-1,-100]
     Note:

     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     Could you do it in-place with O(1) extra space?

     三次数组就地逆转

     * @param nums
     * @param k
     */

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public void reverse(int [] array, int start, int end){
        int i = start;
        int j = end;
        while (i < j){
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            ++i;
            --j;
        }
    }

}