public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] >= third){
                if (nums[i] > max){
                    third = second;
                    second = max;
                    max = nums[i];
                    num ++;
                }
                else if (nums[i] == max) max = nums[i];
                else if (nums[i] > second){
                    third = second;
                    second = nums[i];
                    num ++;
                }
                else if (nums[i] == second) second = nums[i];
                else {
                        third = nums[i];
                        num ++;
                    }


            }
        }
        if (num >= 3) return (int)third;
        else return (int)max;
    }

    public static void main(String [] args){
        int [] nums = new int[] {1,-2147483648,2};
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(nums));
    }
}
