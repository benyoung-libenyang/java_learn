import java.util.stream.IntStream;

public class Test_iteam {
    
    public static void main(String[] args) {
        IntStream.iterate(0, i -> i + 3)
                .takeWhile(i -> i <= 20)
                .forEach(System.out::println);

    }
}
