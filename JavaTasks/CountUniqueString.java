package JavaTasks;

import java.util.Arrays;
import java.util.List;

public class CountUniqueString {
    public static void main(String[] args){
          List<String> strings = Arrays.asList("Apple", "Ant", "Ball", "Cat", "Ankit", "apple", "Axis", "Amit");

        //  Count unique strings that start with 'A' (case-insensitive)
        long countStartWithA = strings.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .distinct()
                .count();
        System.out.println("Unique strings starting with 'A': " + countStartWithA);
    }
    
}
