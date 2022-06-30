import java.util.Stack;
public class balancedParenthesis {

    public static void main(String[] args) {
        String expr = "{{{{";
        System.out.println(isBalanced(expr));
    }

    public static boolean isBalanced(String expr){
        if(expr.isEmpty()){
            return true;
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < expr.length();i++){
            char current = expr.charAt(i);
            if(current == '{' || current == '(' || current == '['){
                st.push(current);
            }
            if(current == '}' || current == ')' || current == ']') {
                if(st.isEmpty()){
                    return false;
                }
                char last = st.peek();
                if(current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[' ){
                    st.pop();
                }else{
                    return false;
                }
                }
            }
        return st.isEmpty()?true:false;
    }
}
