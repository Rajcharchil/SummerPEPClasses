package JavaTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GreaterThan50 {
    
    public static void main(String[] args) {
        
         List<Integer> numbers = Arrays.asList(12, 55, 67, 24, 89, 50, 10, 3);

         /// with Stream

        //  List<Integer> greaterThan50 = numbers.stream()
        //         .filter(n -> n > 50)
        //         .collect(Collectors.toList());


        //without stream
        
        List<Integer> greaterThan50 = new ArrayList<>();
        for (int n : numbers) {
            if (n > 50) {
                greaterThan50.add(n);
            }
        }
        System.out.println("Numbers > 50: " + greaterThan50);
    }

    
}
