import java.util.Stack;

public class InfixConversion {

    public static void main(String[] args) {
        String exp = "a*(b-c)/d+e";
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i = 0 ; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                operator.push(ch);
            } else if ((ch >= '0' && ch <= '9') ||
                    (ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + "");
                post.push(ch + "");

            } else if (ch == ')') {
                while(operator.peek() != '('){
                        process(pre,post,operator);
                }
                operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while(!operator.isEmpty() && operator.peek() != '(' && precedance(ch) <= precedance(operator.peek())){
                    process(pre,post,operator);
                }
                    operator.push(ch);
            }

        }
        while(!operator.isEmpty()){
            process(pre,post,operator);
        }
        System.out.println(pre.pop());
        System.out.println(post.pop());


    }

    public static int precedance(char optor){
        if(optor == '+' || optor == '-'){
            return 1;
        } else if (optor == '*' || optor == '/') {
              return 2;
        }else{
            return 0;
        }
    }

    public static void process(Stack<String> pre, Stack<String> post , Stack<Character> operator){
        char op = operator.pop();
        String pv2 = pre.pop();
        String pv1 = pre.pop();

        String preVal = op + pv1 + pv2;
        pre.push(preVal);

        String postv2 = post.pop();
        String postv1 = post.pop();

        String postVal =  postv1 + postv2 + op;
        post.push(postVal);
    }
}
