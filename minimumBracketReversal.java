import java.util.Stack;

public class minimumBracketReversal {

    public static void main(String[] args) {
        String input = "{{{";
        int ans = countBracketReversals(input);
        System.out.println(ans);

    }


    public static int countBracketReversals(String input) {
        if (input.length() == 0) {
            return 0;
        }
        if (input.length() % 2 != 0) {
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currCh = input.charAt(i);
            if (currCh == '{') {
                stack.push(currCh);
            } else {
                //when we encounter closing bracket
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(currCh);
                }

            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            char c1 = stack.pop();
            char c2 = stack.pop();

            if (c1 != c2) {
                count += 2;
            } else {
                count += 1;
            }
        }
        return count;

    }
}
