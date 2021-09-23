package Task4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Prime {
    public static void main (String[] args){

        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(2, 4, 6, 8));

        List<Integer> all = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());



        System.out.println(all.stream()
                .filter(e -> isPrime(e))
                .collect(Collectors.toList()));
    }

    public static Boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if ((num % i) == 0) {
                count += 1;
            }
        }
        if (count == 2) {
            return true;
        }else{
            return false;
        }
    };
}