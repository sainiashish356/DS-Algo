import java.util.Arrays;
import java.util.Stack;

public class MaxAreaHistogram {

    public static void main(String[] args) {
//        int[] arr = {4,10,5,8,20,15,3,12};
            int[] arr = {4,2,1,5,6,3,2,4,2};
        int ans = maxArea(arr);
        System.out.print(ans);
    }

        public static int maxArea(int[] arr){
         int MaxAns = 0;
         int ps[] = prevSmaller(arr);
         int ns[] = nextSmaller(arr);

         for(int i = 0; i < arr.length; i++){
             int curr = (ns[i] - ps[i] - 1)*arr[i];
             MaxAns = Math.max(MaxAns , curr);
         }
         return MaxAns;
        }

    public static int[] nextSmaller(int[] arr){
        int[] ns = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ns[i] = -1;
            }else{
                ns[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return ns;

    }

    public static int[] prevSmaller(int[] arr){
        int[] ps = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i < arr.length; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ps[i] = -1;
            }else{
                ps[i] = arr[stack.peek()];
            }
            stack.push(i);

        }
        return ps;
    }

}
