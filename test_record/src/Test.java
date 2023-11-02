import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);
        IntStream.iterate(0, i -> i < 15, i -> i + 3)
                .forEach(System.out::println);
    }

}
