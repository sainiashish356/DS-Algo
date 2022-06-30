import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackOPtimized {

    Queue<Integer> main;
    Queue<Integer> helper;

    public QueueToStackOPtimized(){
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    int size(){
        return main.size();
    }

    void push(int val){
        main.add(val);
    }

    int pop(){
        if(size() == 0){
            System.out.println("Stack EMpty");
            return -1;
        }else{
            while(size() > 1){
                helper.add(main.remove());
            }
            int val = main.remove();

            while(helper.size() > 0){
                main.add(helper.remove());
            }
            return val;
        }
    }

    int top(){
        if(size() == 0){
            System.out.println("Stack EMpty");
            return -1;
        }else{
            while(size() > 1){
                helper.add(main.remove());
            }
            int val = main.remove();
            helper.add(val);

            while(helper.size() > 0){
                main.add(helper.remove());
            }
            return val;
        }

    }

}
