package demo;

import demo.inteface.HelloService;
import demo.inteface.MathOperation;

public class LambdaTest {

    public static void main(String[] args) {

        LambdaTest test = new LambdaTest();

        MathOperation addtion = (int a, int b) -> a + b;

        int result = test.operate(3, 4, addtion);

        System.out.println("addtion: " + result);

        result = test.operate(7, 5, (a, b) -> a - b);

        System.out.println("subtraction: " + result);

        result = test.operate(3, 2, (int a, int b) -> {return a * b;});

        System.out.println("multiply: " + result);

        HelloService helloService = msg -> System.out.println("Hello, " + msg);

        helloService.sayHello("How are you?");

        // Lambda 表达式让匿名类不再需要，这为 Java 增添了简洁但实用的函数式编程能力。




    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.calculate(a, b);
    }


}


