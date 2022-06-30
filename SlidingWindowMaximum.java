import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k= 3;
        int[] ans = maxSlidingWindow(nums , k);
        System.out.print(Arrays.toString(ans));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];


        int ng[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length-1);
        ng[nums.length-1] = nums.length;
        for(int i = nums.length-2; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ng[i] = -1;
            }else{
                ng[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i = 0 ; i < nums.length -k ; i++){

            int j = i;

            if(ng[j] < i + k){
                j = ng[j];
            }
            max[i] = nums[j];

        }
        return max;

    }
}
