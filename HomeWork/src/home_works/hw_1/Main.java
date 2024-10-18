package home_works.hw_1;

import comparators.FirstWordsThenNumbersComparator;
import api.IFileHandler;
import utils.SortUtils;

public class Main {
    private final static String OUT_FILE_PATH = "./HomeWork/src/home_works/hw_1/resourсes/out.txt";
    private final static String IN_FILE_PATH = "./HomeWork/src/home_works/hw_1/resourсes/in.txt";

    public static void main(String[] args) {
        IFileHandler fileHandler = new FileHandler();

        String text = fileHandler.read(IN_FILE_PATH);
        String sortedText = SortUtils.sortByWordsAndLines(text,new FirstWordsThenNumbersComparator());
        fileHandler.write(OUT_FILE_PATH,sortedText);
    }
}