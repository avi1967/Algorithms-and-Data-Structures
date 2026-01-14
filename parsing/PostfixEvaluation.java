// Algorithm: Postfix Expression Evaluation using Stack
// Time Complexity: O(n)
// Space Complexity: O(n)
// Key Idea: Use a stack to evaluate operators in postfix order
//
// Correctness:
// - Each operand is pushed onto the stack.
// - Each operator pops exactly two operands and pushes the result.
// - At termination, exactly one value must remain.

package parsing;

public class PostfixEvaluation {

    /**
     * Evaluates a postfix (Reverse Polish Notation) expression.
     *
     * @param expr postfix expression containing integers and operators
     * @return evaluated integer result
     * @throws InvalidPostfixException if the expression is malformed
     */
    public static int evaluate(String expr) throws InvalidPostfixException {
        Stack stack = new Stack(expr.length());
        int i = 0;

        while (i < expr.length()) {
            char ch = expr.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                i++;
                continue;
            }

            // Parse integer (supports multi-digit and negative numbers)
            if (Character.isDigit(ch) || (ch == '-' && i + 1 < expr.length() && Character.isDigit(expr.charAt(i + 1)))) {
                boolean negative = false;
                if (ch == '-') {
                    negative = true;
                    i++;
                }

                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }

                stack.push(negative ? -num : num);
                continue;
            }

            // Operator case
            if (isOperator(ch)) {
                if (stack.isEmpty()) throw new InvalidPostfixException("Too few operands");
                int b = stack.pop();
                if (stack.isEmpty()) throw new InvalidPostfixException("Too few operands");
                int a = stack.pop();

                stack.push(applyOperator(a, b, ch));
            } else {
                throw new InvalidPostfixException("Invalid character: " + ch);
            }

            i++;
        }

        if (stack.isEmpty()) throw new InvalidPostfixException("No result produced");
        int result = stack.pop();
        if (!stack.isEmpty()) throw new InvalidPostfixException("Extra operands remaining");

        return result;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int applyOperator(int a, int b, char op) throws InvalidPostfixException {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new InvalidPostfixException("Division by zero");
                return a / b;
            default:
                throw new InvalidPostfixException("Unknown operator");
        }
    }
}
