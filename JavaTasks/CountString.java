package JavaTasks;

import java.util.Arrays;
import java.util.List;

public class CountString {
    public static void main(String[] args){
          List<String> strings = Arrays.asList("Apple", "Ant", "Ball", "Cat", "Ankit", "apple", "Axis", "Amit");

        //  Count unique strings that start with 'A' (case-insensitive)
          long countLengthMoreThan3 = strings.stream()
                .filter(s -> s.length() > 3)
                .count();
        System.out.println("Strings with length > 3: " + countLengthMoreThan3);
    }
    
}
