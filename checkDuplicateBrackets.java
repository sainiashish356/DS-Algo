import java.util.Stack;

public class checkDuplicateBrackets {

    public static void main(String[] args) {

    }



    public static boolean checkDuplicacy(String expr){
        if(expr.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expr.length() ; i++){
            char currChar = expr.charAt(i);
            if(currChar == ')'){
                if(stack.peek() == '('){
                    return true;
                }else{
                    while(stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }else{
                stack.push(currChar);
            }
        }
        return false;
    }

    public static boolean checkRedundant(String exp) {
        if (exp.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ')') {
                if (stack.peek() == '(') {
                    return true;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }

        }
        return false;
    }
}



