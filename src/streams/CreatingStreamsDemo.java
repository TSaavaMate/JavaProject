package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
  public static void show() {
    // From a collection
    List<Integer> list = new ArrayList<>();
    list.stream()
        .forEach(System.out::println);

    // From an array
    int[] array = { 1, 2, 3 };
    Arrays.stream(array)
          .forEach(System.out::println);

    // From an arbitrary number of objects
    Stream.of(1, 2, 3)
          .forEach(System.out::println);

    // Generate from scratch
    Stream.generate(Math::random)
          .limit(3)
          .forEach(System.out::println);

    // Generate from scratch
    Stream.iterate(1, n -> n + 1)
          .limit(10)
          .forEach(System.out::println);
  }
}
