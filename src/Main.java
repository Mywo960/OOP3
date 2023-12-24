import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение : ");
        String problem = scanner.nextLine();


        double result = solver(problem);
        System.out.println("Результат: " + result);

        scanner.close();
    }

    public static double solver(String problem) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = problem.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = stepProblem(token, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double stepProblem(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                }
                else {
                    System.out.print("Делить на ноль нельзя");
                }
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }
}
