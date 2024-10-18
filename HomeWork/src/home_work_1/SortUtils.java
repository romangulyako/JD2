import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortUtils {
    private final static String NUMBER_REGEX = "-?[0-9]+";
    private final static String SPACE_SPLITERATOR = "\\s+";
    private final static String SPACE_SYMBOL = " ";

    public static List<String> sort(List<String> lines) {
        List<String> sortedList = new ArrayList<>();

        for (String line : lines) {
            String[] words = line.split(SPACE_SPLITERATOR);
            Arrays.sort(words, (o1, o2) -> {
                boolean isNumber1 = o1.matches(NUMBER_REGEX);
                boolean isNumber2 = o2.matches(NUMBER_REGEX);

                if (isNumber1 && !isNumber2) {
                    return 1;
                } else if (!isNumber1 && isNumber2) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            });

            sortedList.add(arrayToString(words));
        }

        return sortedList;
    }

    private static String arrayToString(String[] array) {
        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < array.length; j++) {
            builder.append(array[j]);
            if (j != array.length - 1) {
                builder.append(SPACE_SYMBOL);
            }
        }

        return builder.toString();
    }
}
