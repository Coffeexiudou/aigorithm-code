import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; ++i)
        {
            priorityQueue.add(nums[i]);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        return priorityQueue.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        int temp = nums[0];
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            while (nums[i] < temp){

            }
        }
        return 0;
    }

    public static void main(String [] args){
        int [] nums = new int [] {1,2,3,4,5};
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        System.out.println(k.findKthLargest(nums,3));
    }
}
