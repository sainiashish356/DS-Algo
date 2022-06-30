import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int[] stock= {100,80,60,70,60,75,85};
        int[] output = stockSpan(stock);
        System.out.println(Arrays.toString(output));
    }

    public static int[] stockSpan(int[] stock){

        int[] span = new int[stock.length];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for(int i = 1 ; i < stock.length; i++){

            while(!stack.isEmpty() && stock[i] > stock[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i] = i + 1;
            }else{
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }

    public static int[] span(int[] stock){
        int[] span = new int[stock.length];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for(int i = 1; i < stock.length;i++){
            while(!stack.isEmpty() && stock[i] > stock[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i] = 1 + i;
            }else{
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }

}
