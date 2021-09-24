package Task5;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DescendingOrder {
    public static void main (String[] args) {
        List<Integer> numbers = Stream.iterate(1, i -> i = (int)((Math.random()*99)+1))
                        .limit(100)
                        .collect(Collectors.toList());

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);
    }
}
