import java.util.Stack;

public class InfixEval {

    public static void main(String[] args) {

        String exp = "2+(5-3*6/2)";
        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for(int i = 0; i < exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '('){
                optors.push(ch);
            } else if (Character.isDigit(ch)) {
                opnds.push(ch - '0'); //char to integer
            } else if (ch == ')') {
                if(optors.peek() != '('){
                    char optor = optors.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();

                    int operationVal = operation(v1 , v2 , optor);
                    opnds.push(operationVal);
                }
                //this is to remove the opening bracket
                optors.pop();
            } else if (ch == '+' ||ch == '-' || ch == '*' || ch == '/') {

                while(!optors.isEmpty() && optors.peek() != '(' && precedance(ch) <= precedance(optors.peek())){
                    char optor = optors.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();

                    int operationVal = operation(v1 , v2 , optor);
                    opnds.push(operationVal);
                }
                //ch is pushing itself
                optors.push(ch);
            }
        }
        while(!optors.isEmpty()){
            char optor = optors.pop();
            int v2 = opnds.pop();
            int v1 = opnds.pop();

            int operationVal = operation(v1 , v2 , optor);
            opnds.push(operationVal);
        }
        System.out.println(opnds.peek());
    }

    public static int precedance(char optor){
        if(optor == '+'){
            return 1;
        } else if (optor == '-') {
            return 1;
        } else if (optor == '*') {
            return 2;
        }else{
            return 2;
        }
    }

    public static int operation(int v1 , int v2 , char optor){
        if(optor == '+'){
            return v1+v2;
        } else if (optor == '-') {
            return v1-v2;
        } else if (optor == '*') {
            return v1*v2;
        }else{
            return v1/v2;
        }
    }


}
