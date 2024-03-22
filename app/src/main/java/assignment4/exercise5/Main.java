package assignment4.exercise5;

import static assignment4.exercise5.MyKotlinFunctionsKt.add;
import static assignment4.exercise5.MyKotlinFunctionsKt.divide;
import static assignment4.exercise5.MyKotlinFunctionsKt.multiply;
import static assignment4.exercise5.MyKotlinFunctionsKt.subtract;

public class Main {
    public static void main(String[] args) {
        long num1 = 10;
        long num2 = 5;
        long sum = add(num1, num2);
        long difference = subtract(num1, num2);
        long product = multiply(num1, num2);
        long quotient = divide(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}