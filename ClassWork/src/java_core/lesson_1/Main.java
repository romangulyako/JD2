package java_core.lesson_1;

import java_core.lesson_1.comparators.FirstWordsThenNumbersComparator;
import java_core.lesson_1.api.IFileHandler;
import java_core.lesson_1.utils.SortUtils;

public class Main {
    private final static String OUT_FILE_PATH = "./ClassWork/src/java_core/lesson_1/resourсes/out.txt";
    private final static String IN_FILE_PATH = "./ClassWork/src/java_core/lesson_1/resourсes/in.txt";

    public static void main(String[] args) {
        IFileHandler fileHandler = new FileHandler();

        String text = fileHandler.read(IN_FILE_PATH);
        String sortedText = SortUtils.sortByWordsAndLines(text,new FirstWordsThenNumbersComparator());
        fileHandler.write(OUT_FILE_PATH,sortedText);
    }
}