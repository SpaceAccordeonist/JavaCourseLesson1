package ru.spaceaccordeonist.task1;

import java.util.Random;

public class Calculator {
    public static int sumArrayFor(int[] array){
        int result = 0;
        for(int num: array){
            result += num;
        }
        return result;
    }
    public static int sumArrayWhile(int[] array){
        int result = 0;
        int i = 0;
        while(i < array.length){
            result += array[i];
            i++;
        }
        return result;
    }
    public static int sumArrayDo(int[] array){
        int result = 0;
        int i = -1;
        do{
            result += array[++i];
        }while (i < array.length - 1);
        return result;
    }

    public static double[] getHarmonicSeries(int count){
        double[] result = new double[count];
        for(int i = 0; i < count; i++){
            result[i] = 1f/(i+1f);
        }
        return result;
    }

    enum RandomType{
        MATH, RANDOM
    }
    public static double[] getRandomArray(int count, RandomType type){
        double[] result = new double[count];
        switch (type) {
            case RANDOM:
                for (int i = 0; i < count; i++) {
                    result[i] = new Random().nextDouble();
                }
                break;
            case MATH:
                for (int i = 0; i < count; i++) {
                    result[i] = Math.random();
                }
                break;
        }
        return result;
    }

    public static int getFactorial(int number){
        int result = 1;
        for(int i = 2; i <= number; i++){
            result *= i;
        }
        return result;
    }
}
