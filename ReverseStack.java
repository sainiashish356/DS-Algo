import java.util.Stack;
import java.util.*;
public class ReverseStack {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Stack<Integer> input = new Stack<>();
        Stack<Integer> extra = new Stack<>();

        for(int elem : arr){
            input.push(elem);
        }
        reverse(input);

        while(!input.isEmpty()){
            System.out.println(input.pop());
        }

    }


    //Reverse a Stack without using extra space

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();

        reverse(stack);
        InsertAtBottom(stack , top);
    }

    public static void InsertAtBottom(Stack<Integer> stack , int elem){
        if(stack.isEmpty()){
            stack.push(elem);
            return;
        }
        int top = stack.pop();
        InsertAtBottom(stack , elem);
        stack.push(top);
    }

    public static void reverseStk(Stack<Integer> input , Stack<Integer> extra){

        if(input.size() <= 1){
            return;
        }

        int temp = input.pop();

        reverseStk(input,extra);

        while(!input.isEmpty()){
            int top = input.pop();
            extra.push(top);
        }

        input.push(temp);

        while(!extra.isEmpty()){
            int top = extra.pop();
            input.push(top);
        }
    }
}
