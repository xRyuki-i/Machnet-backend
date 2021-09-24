package Task1;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

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
        List<Integer> numbers = Stream.iterate(1, i -> i +1)
                .limit(50)
                .collect(Collectors.toList());

        Consumer <List<Integer>> printOdd = list -> System.out.println(
                "Odd : " + list.stream()
                        .filter(e -> (e%2)!=0)
                        .collect(Collectors.toList())
        );

        Consumer <List<Integer>> printEven = list -> System.out.println(
                "Even : " + list.stream()
                        .filter(e -> (e%2)==0)
                        .collect(Collectors.toList())
        );

        Consumer <List<Integer>> printPrime = list -> System.out.println(
                "Prime : " + list.stream()
                        .filter(e -> isPrime(e))
                        .collect(Collectors.toList())
        );

        printOdd.accept(numbers);
        printEven.accept(numbers);
        printPrime.accept(numbers);
    }
}
