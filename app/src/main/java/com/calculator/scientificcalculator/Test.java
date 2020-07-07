package com.calculator.scientificcalculator;


import java.util.Stack;

public class Test {

 public    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


  public   String infixToPostfix(String exp) {

        String result = new String("");


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);


            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    if (stack.peek() == '(') {
                        return "Invalid Expression";
                    }
                    result += stack.pop();
                }
                stack.push(c);
            }

        }


        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }
        return result;
    }

   public  int evaluatePostfix(String exp) {

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);


            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}