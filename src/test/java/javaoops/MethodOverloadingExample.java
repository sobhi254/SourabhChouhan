package javaoops;

public class MethodOverloadingExample {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(10, 20));
        System.out.println(calculator.add(10, 20, 30));
    }
}

class Calculator {
    int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    int add(int firstNumber, int secondNumber, int thirdNumber) {
        return firstNumber + secondNumber + thirdNumber;
    }
}
