package ru.spaceaccordeonist.task1;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.printf("program #1\nfor: %d\n", Calculator.sumArrayFor(arr));
        System.out.printf("do-while: %d\n", Calculator.sumArrayDo(arr));
        System.out.printf("while: %d\n", Calculator.sumArrayWhile(arr));
        System.out.println();

        System.out.println("program #2");
        for(String arg: args){
            System.out.println(arg);
        }
        System.out.println();

        System.out.println("program #3");
        double[] series = Calculator.getHarmonicSeries(10);
        for(double num: series){
            System.out.printf("%.2f ", num);
        }
        System.out.println("\n");

        System.out.println("program #4");
        System.out.println("Math.random() :");
        double[] rand = Calculator.getRandomArray(10, Calculator.RandomType.MATH);
        for(double num: rand){
            System.out.printf("%.2f ", num);
        }
        System.out.println("\nnew Random().nextDouble() :");
        rand = Calculator.getRandomArray(10, Calculator.RandomType.RANDOM);
        for(double num: rand){
            System.out.printf("%.2f ", num);
        }
        System.out.println();
        System.out.println();

        System.out.println("program #5");
        System.out.printf("factorial of %d = %d", 4, Calculator.getFactorial(5));
    }
}
