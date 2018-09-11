package ru.ivan.calc;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppOptimizied {
    public static void main(String[] args) throws NullPointerException, IllegalAccessError {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        new AppOptimizied().toString();
        char[] character = in.toCharArray();
        StringBuilder out = new StringBuilder();
        StringBuilder tempNumb = new StringBuilder();
        StackOnList<String> stack = new StackOnList<>();
        for (int i = 0; i < in.length(); i++) {
            if (character[i] != ' ') {
                if (Character.isDigit(character[i]) || character[i] == '.') {
                    tempNumb.append(character[i]);
                    continue;
                } else {
                    if (tempNumb.length() > 0) {
                        out.append(tempNumb).append(" ");
                        tempNumb.setLength(0);
                    }
                }
                if (character[i] == '(') {
                    stack.push(String.valueOf(character[i]));
                } else if (character[i] == ')') {

                    if (stack.len() > 0) {
                        String func = stack.pop();

                        while (!func.equals("(")) {
                            out.append(func).append(" ");
                            func = stack.pop();
                        }
                    }
                } else if (character[i] == '!') {
                    out.append(character[i]).append(" ");
                } else if (Character.isLetter(character[i])) {
                    StringBuilder maybePrefix = new StringBuilder();
                    for (; i < in.length(); i++) {
                        if (Character.isLetter(character[i])) {
                            maybePrefix.append(character[i]);
                        }else {
                            break;
                        }
                    }
                    i--;
                    if (isPrefix(maybePrefix.toString())) {
                        stack.push(maybePrefix.toString());
                    }
                } else {
                    while (stack.len() > 0 && (priority(stack.peek()) >= priority(String.valueOf(character[i])) || isPrefix(stack.peek()))) {
                        out.append(stack.pop()).append(" ");
                    }
                    stack.push(String.valueOf(character[i]));
                }
            }
        }

        if (tempNumb.length() > 0) {
            out.append(tempNumb).append(" ");
            tempNumb.setLength(0);
        }

        while (stack.len() > 0) {
            out.append(stack.pop()).append(" ");
        }
        System.out.println(out.toString());
        String[] output = out.toString().split(" ");

        for (int j = 0; j < output.length; j++) {

            if (isDouble(output[j])) {
                stack.push(output[j]);
            } else {
                double a = Double.parseDouble(stack.pop());
                double b;
                double temp = 0;
                switch (output[j]) {
                    case "+":
                        b = Double.parseDouble(stack.pop());
                        temp = a + b;
                        break;
                    case "-":
                        b = Double.parseDouble(stack.pop());
                        temp = b - a;
                        break;
                    case "*":
                        b = Double.parseDouble(stack.pop());
                        temp = a * b;
                        break;
                    case "/":
                        b = Double.parseDouble(stack.pop());
                        temp = b / a;
                        break;
                    case "sin":
                        temp = Math.sin(a);
                        break;
                    case "cos":
                        temp = Math.cos(a);
                        break;
                    case "tg":
                        temp = Math.tan(a);
                        break;
                    case "ctg":
                        temp = 1 / Math.tan(a);
                        break;
                    case "!":
                        temp = factorial(a);
                        break;
                }
                stack.push(String.valueOf(temp));
            }
        }
        double dotIndex = Double.parseDouble(stack.peek());
        System.out.printf(in + " = ");

        System.out.printf("%.4f", dotIndex);
    }

    private static double factorial(double a) {
        if (a == 1) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    private static boolean isPrefix(String s) {
        return s.equals("sin") || s.equals("cos") || s.equals("tg") || s.equals("ctg");
    }

    private static boolean isDouble(String maybeDouble) {
        try {
            Double.parseDouble(maybeDouble);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int priority(String c) {
        switch (c) {
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 2;
            default:
                return 0;
        }
    }

    static class StackOnList<T> {
        private List<T> stack = new LinkedList<>();

        void push(T item) {
            stack.add(item);
        }

        T pop() {
            return stack.remove(stack.size() - 1);
        }

        T peek() {
            return stack.get(stack.size() - 1);
        }

        int len() {
            return stack.size();
        }
    }
}

class Stack {
    private int[] stack = new int[1];
    private int number = 0;

    void push(int item) {
        if (number + 1 >= stack.length) {
            int[] biggerStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, biggerStack, 0, stack.length);
            stack = biggerStack;
        }
        stack[number++] = item;
    }

    int pop() {
        return stack[number--];
    }

    int peek() {
        return stack[number];
    }
}