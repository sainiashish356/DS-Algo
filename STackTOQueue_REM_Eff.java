import java.util.Stack;

public class STackTOQueue_REM_Eff {

    Stack<Integer> main;
    Stack<Integer> helper;

    public STackTOQueue_REM_Eff(){
        main = new Stack<>();
        helper= new Stack<>();
    }

    int size(){
        return main.size();
    }

    void add(int val){
        if(main.size() > 0){
            helper.add(main.pop());
        }
        main.add(val);

        while(!helper.isEmpty()){
            main.add(helper.pop());
        }
    }

    int remove(){
        if(size() == 0){
            return -1;
        }else{
            return main.pop();
        }
    }

    int top(){
        if(size() == 0){
            return -1;
        }else{
            return main.peek();
        }
    }



}
