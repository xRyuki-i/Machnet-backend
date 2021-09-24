package Task4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task4 {
    public static void main (String[] args){
        List<String> names = Arrays.asList("Nischal","Aishwarya","Ajay","Alina","Summit");

        Predicate<String> startsWithA = e -> e.toLowerCase().startsWith("a") && e.length()<=5 ;

        List<String> result = names.stream()
                .filter(e -> startsWithA.test(e))
                .collect(Collectors.toList());

        System.out.println("The list of names that start with A or a and contains length more than 5 is "+result);
    }
}
