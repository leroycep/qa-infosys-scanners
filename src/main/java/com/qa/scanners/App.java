package com.qa.scanners;

import java.util.Scanner;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Hello! Type in a math problem with the following format:" );
        System.out.println( "    <number> <number> <op>" );
        System.out.println( "\nWhere op is one of `+`, `-`, `*`, or `/`" );
        System.out.println( "\nFor example, you can divide 20 by 5 using the following expression:" );
        System.out.println( "    20 5 /" );
        System.out.println( "\nTo exit, simply type `exit`" );

        Stack<Double> stack = new Stack<Double>();
        boolean running = true;
        while (running) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            for (String part: parts) {
                if (!runPart(stack, part)) {
                    running = false;
                    break;
                }
            }
            System.out.println(stack);
        }

        scanner.close();
    }

    public static boolean runPart(Stack<Double> stack, String part)
    {
        Double num2;
        Double num1;
        switch (part) {
            case "":
                break;
            case "+":
                stack.push(stack.pop() + stack.pop());
                break;
            case "-":
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 - num2);
                break;
            case "*":
                stack.push(stack.pop() * stack.pop());
                break;
            case "/":
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 / num2);
                break;
            case "exit":
                return false;
            default:
                stack.push(Double.parseDouble(part));
                break;
        }
        return true;
    }
}
