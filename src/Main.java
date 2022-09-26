import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Main {
    private static void countWords(final Path file) throws IOException {
        Arrays.stream(new String(Files.readAllBytes(file), StandardCharsets.UTF_8).split("\\W+"))
                .collect(Collectors.groupingBy(Function.<String>identity(), TreeMap::new, counting())).entrySet()
                .forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/EdgarPoem.txt");
       countWords(path);
    }

}
