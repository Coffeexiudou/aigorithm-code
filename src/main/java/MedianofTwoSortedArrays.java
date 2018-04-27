public class MedianofTwoSortedArrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.

     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

     Example 1:
     nums1 = [1, 3]
     nums2 = [2]

     The median is 2.0
     Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5
     */


    /**
     * 我的暴力解法 需要额外空间O(m+n)，时间复杂度O(m+n) 时间复杂度不满足要求
     * 依次比较两个数组的值，填充到新数组中，剩余的话则全部填充到后边，计算新数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        int [] result = new int[n1+n2];
        int k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                ++i;
                ++k;
            } else {
                result[k] = nums2[j];
                ++j;
                ++k;
            }
        }
        if (i < n1 ){
            for (int p = k ; p < n1 + n2 ; ++p){
                result[p] = nums1[i++];
            }
        }
        if (j < n2 ){
            for (int p = k ; p < n1 + n2 ; ++p){
                result[p] = nums2[j++];
            }
        }

        double res ;
        if ((n1 + n2 )%2 == 0){
            double d1 = result[(n1+n2)/2 -1 ];
            double d2 = result[(n1+n2)/2];
            res = (d1+d2)/2;
        }
        else res = result[(n1+n2)/2];
        return res;
    }


    /**
     * 题目要求O(log(m+n)) 就会想到二分
     * 关键是这道题求中位数，实际上转换为求第k大数问题
     * @param args
     */

    public static void main(String [] args){
        int [] a = new int[]{1,2};
        int [] b = new int []{3,4};
        MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
        medianofTwoSortedArrays.findMedianSortedArrays(a,b);
    }
}
