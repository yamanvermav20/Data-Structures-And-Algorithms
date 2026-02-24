// package Stack.Conversions_Infix_postfix_prefix;
import java.util.Stack;

public class InfixToPostfix {
    String infix;
    String postfix; 
    public InfixToPostfix(String infix) {
        this.infix = infix;
        this.postfix = "";
    }
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public String convert() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop(); // Pop the '('
            } else { // Operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;

    }
    public static void main(String[] args) {
        String infixExpression = "A+B*C-D";
        InfixToPostfix converter = new InfixToPostfix(infixExpression);
        System.out.println("Infix: " + infixExpression);
        System.out.println("Postfix: " + converter.convert());
    }
}
