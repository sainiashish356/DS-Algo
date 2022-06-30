import java.util.Stack;
public class PostFixEval_Pre_Inf_Conversion {

    public static void main(String[] args) {
        String exp = "264*8/+3-";
        Stack<Integer> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> infix = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v2 = post.pop();
                int v1 = post.pop();
                int val = operation(v1 , v2 , ch);
                post.push(val);

                String infixv2 = infix.pop();
                String infixv1 = infix.pop();
                String infixVal = "(" + ch + infixv1 + infixv2 + ")";
                infix.push(infixVal);

                String prefixv2 = pre.pop();
                String prefixv1 = pre.pop();
                String prefixVal =  ch + prefixv1 + prefixv2 ;
                pre.push(prefixVal);
            }else{
                post.push(ch - '0');
                pre.push(ch + "");
                infix.push(ch + "");
            }
        }
        System.out.println(post.pop());
        System.out.println(pre.pop());
        System.out.println(infix.pop());

    }

    public static int precedance(char op){
        if(op == '+' || op == '-'){
            return 1;
        }else if (op == '*' || op == '/'){
            return 2;
        }else{
    return 0;
        }
    }

    public static int operation (int v1 , int v2 , char op){
        if(op == '+'){
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1*v2;
        }else if(op == '/'){
            return v1/v2;
        }else{
            return 0;
        }
    }


}
