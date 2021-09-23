package Task1;

import java.util.Arrays;

public class SumDigits {
    public static void main (String[] args){
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};

        int sum = Arrays.stream(numbers)
                    .reduce(0, (acc, e)-> acc + e);

        System.out.println("The sum integer of array containing the numbers from 1 to 50 is "+ sum);
    }
}
