package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberGame {

    public static void main(String[] args) {
        int [] B = new int[4];

        List<Integer> collect = Arrays.stream(B)
                .boxed().toList();

    }
}
