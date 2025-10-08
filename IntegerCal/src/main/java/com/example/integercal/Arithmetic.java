/**
 * Tri Tony Tran
 */
package com.example.integercal;

import java.util.*;
import java.io.*;

/**
 * The {@code Arithmetic} class provides functionality to:
 * <ul>
 *     <li>Store arithmetic expressions as tokens (numbers and operators).</li>
 *     <li>Convert expressions from infix to postfix notation.</li>
 *     <li>Evaluate postfix expressions.</li>
 * </ul>
 * <p>
 * Supported operations: addition, subtraction, multiplication, division,
 * clearing, removing last element, and negation of the last number.
 * </p>
 */
public class Arithmetic {
    /** Container that stores the expression as tokens (numbers/operators). */
    private final ArrayList<String> container = new ArrayList<>();

    // - - - Public functions - - -

    /**
     * Adds a token (number or operator) to the arithmetic expression container.
     *
     * @param input the token to add (e.g., "3", "+", "-", "×", "÷").
     */
    public void add(String input) {
        container.add(input);
    }

    /**
     * Removes the last token from the arithmetic expression container.
     * <p>
     * Throws an exception if the container is empty.
     */
    public void remove() {
        container.removeLast();
    }

    /**
     * Clears all tokens from the arithmetic expression container.
     */
    public void clear() {
        container.clear();
    }

    /**
     * Evaluates the current arithmetic expression in the container.
     * <p>
     * Steps:
     * <ol>
     *   <li>Convert the infix expression to postfix notation.</li>
     *   <li>Evaluate the postfix expression.</li>
     *   <li>Clear the container and replace it with the result as individual characters.</li>
     * </ol>
     */
    public void calculate() {
        StringBuilder postFix = infixToPostfix(); // Convert infix -> postfix
        String result = String.valueOf(evaluatePostfix(postFix)); // Evaluate postfix
        container.clear();

        // Store result back into container as single characters
        for (int i = 0; i < result.length(); i++) {
            String ch = result.substring(i, i+1);
            container.add(ch);
        }
    }

    /**
     * Negates the most recent number in the arithmetic expression.
     * <p>
     * Behavior:
     * <ul>
     *   <li>If the number is already negated, the minus sign is removed.</li>
     *   <li>If not, a minus sign is inserted before the number.</li>
     * </ul>
     */
    public void negate() {
        int index = container.size() - 1; // Start from last element
        String ch = container.get(index);

        // Move backward until hitting an operator or beginning of expression
        while (precedence(ch) < 0 && index > 0) {
            index--;
            ch = container.get(index);
        }

        if ((index - 1) >= 0) {
            // If previous token is an operator, remove negation
            String op = container.get(index - 1);
            if (precedence(op) > 0) {
                container.remove(index);
            } else {
                // Otherwise, insert negation before the number
                container.add(index + 1, "-");
            }
        } else {
            // Handle case at the start of the expression
            if (precedence(ch) > 0) {
                container.remove(index);
            } else {
                container.addFirst("-"); // NOTE: ArrayList has no addFirst(), consider LinkedList
            }
        }
    }

    /**
     * Returns the string representation of the current arithmetic expression.
     *
     * @return the concatenated expression from the container.
     */
    @Override
    public String toString() {
        String output = "";

        // Concatenate tokens to form expression string
        for (String i : container) {
            output += i;
        }

        return output;
    }


    // - - - Helper Functions - - -

    /**
     * Evaluates a postfix expression using a stack.
     *
     * @param input the postfix expression as a {@code StringBuilder}.
     * @return the integer result of the postfix evaluation.
     */
    private int evaluatePostfix(StringBuilder input) {
        int output = 0; // Stores the final result
        Stack<Integer> stack = new Stack<>(); // Holds operands during evaluation
        StringBuilder number = new StringBuilder(); // For multi-digit numbers

        for (int i = 0; i < input.length(); i++) {
            String ch = input.substring(i, i+1);

            // If operator detected
            if (precedence(ch) > 0) {
                if (input.charAt(i+1) == ' ') {
                    // Pop last two numbers from stack
                    int num2 = stack.pop();
                    int num1 = stack.pop();

                    // Perform operation
                    if (ch.equals("+")) {
                        output = num1 + num2;
                    } else if (ch.equals("-")) {
                        output = num1 - num2;
                    } else if (ch.equals("×")) {
                        output = num1 * num2;
                    } else if (ch.equals("÷")) {
                        output = num1 / num2;
                    }

                    // Push result back onto stack
                    stack.push(output);
                } else {
                    // Operator was part of a negative number (e.g., "-3")
                    number.append(ch);
                }
            }
            // If delimiter (space) encountered → push accumulated number
            else if (ch.equals(" ")) {
                if (!number.isEmpty()) {
                    stack.push(Integer.parseInt(String.valueOf(number)));
                }
                number.setLength(0); // Reset buffer
            }
            // Otherwise, it's part of a number
            else {
                number.append(ch);
            }
        }
        return output;
    }

    /**
     * Converts the current infix expression (e.g., 3 + 5 × 2) into postfix
     * (e.g., 3 5 2 × +).
     *
     * @return the postfix expression as a {@code StringBuilder}.
     */
    private StringBuilder infixToPostfix() {
        StringBuilder result = new StringBuilder(); // Final postfix string
        Stack<String> stack = new Stack<>();        // Holds operators
        boolean addOP = true; // Helps detect negative numbers

        for (String letter : container) {
            // If it's a number
            if (precedence(letter) < 0) {
                result.append(letter);
                addOP = true;
            } else {
                // Handle negative number (operator at start or after another operator)
                if (stack.isEmpty() && result.isEmpty() || !addOP) {
                    result.append(" ").append(letter);
                } else {
                    // Pop operators with higher/equal precedence
                    result.append(" ");
                    while (!stack.isEmpty() && precedence(letter) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    // Push current operator
                    stack.push(letter);
                    addOP = false;
                }
            }
        }

        // Final flush: pop any remaining operators
        result.append(" ");
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result;
    }

    /**
     * Returns the precedence of an operator.
     *
     * @param input the operator as a string ("+", "-", "×", "÷").
     * @return {@code 2} for multiplication/division,
     *         {@code 1} for addition/subtraction,
     *         {@code -1} if the input is not an operator.
     */
    private int precedence(String input) {
        if (input.equals("+") || input.equals("-")) {
            return 1; // Low precedence
        } else if (input.equals("×") || input.equals("÷")) {
            return 2; // High precedence
        } else {
            return -1; // Not an operator (likely a number)
        }
    }
}
