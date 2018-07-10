public class ReverseInteger {
    /**Given a 32-bit signed integer, reverse digits of an integer.

     Example 1:

     Input: 123
     Output: 321
     Example 2:

     Input: -123
     Output: -321
     Example 3:

     Input: 120
     Output: 21
     Note:
     Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     **/
    /**
     * 不需要考虑正负号，如果溢出，则除以10的结果就和之前不同
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int i = x%10;
            int t = res*10 + i;
            if (t/10 != res) return 0;
            res = t;
            x = x/10;
        }
        return res;
    }
}
