import java.util.Stack;

public class SmallestNumberPattern  {

    public static void main(String[] args) {
            String str = "ddidddid";
        smallestNumber(str);
    }

    public static void smallestNumber(String str){

            Stack<Integer> stack = new Stack<>();
            int num = 1;

            for(int i = 0; i < str.length();i++){
                char ch = str.charAt(i);

                if(ch == 'd'){
                    stack.push(num);
                    num++;
                }else{
                    stack.push(num);
                    num++;

                    while(!stack.isEmpty()){
                        System.out.print(stack.pop());
                    }
                }
            }
        stack.push(num);
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }

}
