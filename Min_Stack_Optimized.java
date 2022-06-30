import java.util.Stack;

public class Min_Stack_Optimized  {

    Stack<Integer> data;
    int min;

    public Min_Stack_Optimized(){
        data =  new Stack<>();
        min = 0;
    }

    int size(){
        return data.size();
    }

    void push(int val){
        if(data.size() == 0){
            data.push(val);
            min = val;
        } else if (val >= min) {
            data.push(val);
        }else{
            data.push(val+val-min);
            min = val;
        }
    }

    int pop(){
        if(data.size() == 0){
            System.out.println("Stack Empty");
            return -1;
        }else{
            if(data.peek() >= min){
                return data.pop();
            }else{
                int oldVal = min;
                min = 2 * min - data.pop();
                return oldVal;
            }

        }

    }

    int top(){
        if(data.size() == 0){
            System.out.println("Stack Empty");
            return -1;
        }else{
            if(data.peek() > min){
                return data.peek();
            }else{
                return min;
            }
        }
    }

    int min(){
            if(size() == 0){
                System.out.println("STack EMpty");
                return -1;
            }else{
                return min;
            }
    }

}
