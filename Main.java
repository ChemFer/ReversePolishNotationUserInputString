import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int result = polishReverseNotation(getValuesFromUser());
        System.out.println(result);
    }

    public static String getValuesFromUser(){
        System.out.println("Give reverse polish notation: ");
        Scanner scan = new Scanner(System.in);
        String rpn = scan.nextLine();
        return rpn;
    }

    public static int polishReverseNotation(String tokens){
        Stack<String> stack = new Stack<String>();
        String action = "";
        int x, y;
        String result = "";
        int value;
        String operators = "+-*/";

        for(String a : tokens.split("[^0-9*/+-]")){ 
            if(!a.equals("+") && !a.equals("-") && !a.equals("*") && !a.equals("/")){ //if numbers add to stack
                stack.push(a);
            }
            else { // operators
                action = a;

                switch (action){
                    case "+":
                        x = Integer.parseInt(stack.pop());
                        y = Integer.parseInt(stack.pop());
                        value = x + y;
                        result = "" + value;
                        stack.push(result);
                        break;
                    case "-":
                        x = Integer.parseInt(stack.pop());
                        y = Integer.parseInt(stack.pop());
                        value = x - y;
                        result = "" + value;
                        stack.push(result);
                        break;
                    case "*":
                        x = Integer.parseInt(stack.pop());
                        y = Integer.parseInt(stack.pop());
                        value = x * y;
                        result = "" + value;
                        stack.push(result);
                        break;
                    case "/":
                        x = Integer.parseInt(stack.pop());
                        y = Integer.parseInt(stack.pop());
                        value = y / x;
                        result = "" + value;
                        stack.push(result);
                        break;
                    default:
                        continue;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
