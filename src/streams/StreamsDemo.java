package streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
  public static void show() {
    var movies= List.of(
            new Movie("title1",12,Genre.Horror),
            new Movie("title2",22,Genre.COMEDY),
            new Movie("title3",32,Genre.ACTION)
    );
    //simple Filter
    Predicate<Movie> isPopular=movie -> movie.getLikes()>15;

    movies.stream()
            .filter(isPopular)
            .forEach(System.out::println);

    //takeWhile
    movies.stream()
            .skip(1)
            .limit(2)
            .takeWhile(isPopular)
            .forEach(System.out::println);

    //sort
    movies.stream()
            .sorted(Comparator.comparing(Movie::getLikes))
            .forEach(System.out::println);
    //set
    movies.stream()
            .map(Movie::getGenre)
            .distinct()
            .forEach(System.out::println);

    //peek
    movies.stream()
            .filter(it->it.getLikes()>15)
            .peek(it-> System.out.println("it is"+it))
            .map(Movie::getTitle)
            .forEach(System.out::println);

    //reducing
    movies.stream()
            .max(Comparator.comparing(Movie::getLikes))
            .get();
//            .findAny()
//            .findFirst()
//            .allMatch()
//            .anyMatch()
//            .count()

    //sum
    var sum=movies.stream()
            .map(Movie::getLikes)
            .reduce((a,b)->a+b);
    System.out.println(sum.orElse(0));


    movies.stream()
            .map(Movie::getLikes)
//            .reduce(Integer::sum);         optional
            .reduce(0,Integer::sum); //int


    movies.stream().mapToInt(Movie::getLikes).sum();


    movies.stream()
            .collect(Collectors.summingInt(Movie::getLikes));


    //toCollection

    movies.stream()
            .map(Movie::getTitle)
            .collect(Collectors.toList());

    movies.stream()
            .filter(it->it.getLikes()>15)
            .collect(Collectors.summarizingInt(Movie::getLikes));

    //grouping by
    movies.stream()
            .collect(Collectors.groupingBy(
                    Movie::getGenre,
//                    Collectors.counting()
                    Collectors.toSet()
            ));

    movies.stream()
            .collect(Collectors.groupingBy(
                    Movie::getGenre,
                    Collectors.mapping(
                            Movie::getTitle,
                            Collectors.joining(",")
                    )
            ));

    movies.stream()
            .collect(Collectors.partitioningBy(
                    isPopular,
                    Collectors.mapping(
                            Movie::getTitle,
                            Collectors.joining(",")
                    )
            ));

    var ranged=IntStream.range(0,100);
    new ArrayList<Stream<Integer>>((Collection)ranged);


    Stream.generate(()->Math.round(Math.random()*100))
            .forEach(System.out::println);

  }
  public static String reverseWords(final String original) {
    return Arrays.stream(original.split(" "))
            .map(it->new StringBuilder(it).reverse().toString())
            .collect(Collectors.joining(" "));

  }
}
