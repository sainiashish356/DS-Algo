import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStack {

    Queue<Integer> main;
    Queue<Integer> helper;

    public QueueToStack(){
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    int size(){
        return main.size();
    }

    void push(int val){
        while(main.size() > 0){
            helper.add(main.remove());
        }
        main.add(val);

        while(helper.size() > 0){
            main.add(helper.remove());
        }
    }

    int pop(){
        if(size() == 0){
            System.out.println("Stack EMpty");
            return -1;
        }
        return main.remove();
    }

    int top(){
        if(size() == 0){
            System.out.println("Stack EMpty");
            return -1;
        }
        return main.peek();
    }

}
