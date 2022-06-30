import java.util.Stack;

public class StackToQueue_ADD_Eff {

    Stack<Integer> main;
    Stack<Integer> helper;

    public StackToQueue_ADD_Eff() {
        main = new Stack<>();
        helper = new Stack<>();
    }

    int size() {
        return main.size();
    }

    void add(int val) {
       main.add(val);
    }

    int remove() {
        if(size() == 0){
            return -1;
        }
        while(main.size() > 1) {
            helper.push(main.pop());
        }
        int val = main.pop();
        while(!helper.isEmpty()){
            main.push(helper.pop());
        }
        return val;
    }

    int top() {
        if(size() == 0){
            return -1;
        }
         while(main.size() > 1) {
            helper.push(main.pop());
        }
        int val = main.pop();
        helper.push(val);
            while(!helper.isEmpty()){
                main.push(helper.pop());
            }
            return val;
    }
}