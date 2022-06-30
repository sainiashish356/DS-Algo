import java.util.*;

public class prefixEvalAndConversion {

    public static int operation(int v1, int v2 , char op){
        if(op == '+'){
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else if (op == '/') {
            return v1 / v2;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {

        String exp = "-+2/*6483";

        Stack<String> postfix = new Stack<>();
        Stack<String> Infix = new Stack<>();
        Stack<Integer> value = new Stack<>();

        for(int i = exp.length() - 1; i >= 0; i-- ){
            char ch = exp.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v1 = value.pop();
                int v2 = value.pop();
                int Outputval = operation(v1,v2,ch);
                value.push(Outputval);

                String Postv1 = postfix.pop();
                String Postv2 = postfix.pop();
                String PostVal = Postv1 + Postv2 + ch;
                postfix.push(PostVal);

                String Inv1 = Infix.pop();
                String Inv2 = Infix.pop();
                String InVal = "(" + Inv1 + ch + Inv2 + ")";
                Infix.push(InVal);

            }else{
                postfix.push(ch + "");
                Infix.push(ch + "");
                value.push(ch - '0');
            }
        }

        System.out.println(postfix.pop());
        System.out.println(value.pop());
        System.out.println(Infix.pop());

    }

}
