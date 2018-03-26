package ex_05;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStream_Sum {

    public static void main(String[] args) {
        List random = Collections.unmodifiableList(
                new Random()
                        .ints(0, 2000)
                        .limit(250000)
                        .boxed()
                        .collect(Collectors.toList())
        );

        random.stream().forEach(System.out::println);
        Object collect = random.parallelStream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(collect);

    }
}
