package datastructures.Stacks;

public class Main {

    public static boolean isBalancedParentheses(String string) {
        ArrayStack<Character> parenthesesStack = new ArrayStack<>();
        // Iterate through each character in the string
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i); // Get the current character

            // If the character is an open parenthesis, push it onto the stack
            if (c == '(') {
                parenthesesStack.push(c);
            }

            // If the character is a close parenthesis
            if (c == ')') {
                // Check if the stack is empty (meaning there's no matching open parenthesis)
                if (parenthesesStack.isEmpty()) {
                    return false;
                }
                // Pop the top parenthesis from the stack
                parenthesesStack.pop();
            }
        }

        // If there are any remaining open parentheses in the stack, return false
        if (!parenthesesStack.isEmpty()) {
            return false;
        }

        // If we've gone through the entire string and the stack is empty, the
        // parentheses are balanced
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBalancedParentheses("()()")); // True
        System.out.println(isBalancedParentheses("(()")); // False
        System.out.println(isBalancedParentheses(")(")); // False
    }
}
