import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final static String NEW_LINE_SPLITERATOR = "\n+";
    private final static String NEW_LINE_SYMBOL = "\n";
    public static List<String> readFile(String path) {
        StringBuilder builder = new StringBuilder();

        try (Reader reader = new FileReader(path)) {
            int symbol;

            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>(List.of(builder.toString().split(NEW_LINE_SPLITERATOR)));
    }

    public static void write(List<String> data, String path) {
        try (Writer writer = new FileWriter(path)) {

            for (int i = 0; i < data.size(); i++) {
                writer.write(data.get(i));
                if (i != data.size() - 1) {
                    writer.write(NEW_LINE_SYMBOL);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
