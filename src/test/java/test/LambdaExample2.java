package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        System.out.println(
        list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
        );
    }
}

