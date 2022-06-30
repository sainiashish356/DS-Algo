import java.util.Stack;

public class SortAstack {

    public static void main(String[] args) {
        int[] arr = {11,2,32,3,41};
        Stack<Integer> stack = new Stack<>();
         for(int elem : arr){
             stack.push(elem);
         }
         sort(stack);

         while(!stack.isEmpty()){
             System.out.println(stack.pop() + " ");
         }
    }

    public static void sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        sort(stack);
        arrange(stack,top);
    }

    private static void arrange(Stack<Integer> stack, int top) {

        if(stack.isEmpty() || stack.peek() < top){
            stack.push(top);
            return;
        }
            int temp = stack.pop();
            arrange(stack, top);
            stack.push(temp);

            }

}
