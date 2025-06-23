package JavaTasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumber {
   
    public static void main(String[] args) {
        // Sample input data
        List<Integer> numbers = Arrays.asList(12, 55, 67, 24, 89, 50, 10, 3);
        

        // Q1. Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
    }
    
}
