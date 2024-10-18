import java.util.List;

public class Main {
    private final static String OUT_FILE_PATH = "out.txt";
    private final static String IN_FILE_PATH = "in.txt";

    public static void main(String[] args) {
        List<String> lines = FileHandler.readFile(OUT_FILE_PATH);
        List<String> sortedLines = SortUtils.sort(lines);
        FileHandler.write(sortedLines, IN_FILE_PATH);
    }
}