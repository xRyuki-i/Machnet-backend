package Task2;

import java.util.function.Supplier;

public class Task2 {
    public static Boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if ((num % i) == 0) {
                count += 1;
            }
        }
        return count == 2;
    }

    public static void main (String[] args){
        Supplier<Integer> randomPrime = ()->{
            int prime=0;
            do{
                prime = (int)(Math.random()*89+10);
            }
            while (!isPrime(prime));
            return prime;
        };

        System.out.println("The generated two digit prime no is "+randomPrime.get());
    }
}
