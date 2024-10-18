package comparators;

import java.util.Comparator;

public class FirstWordsThenNumbersComparator implements Comparator<String> {
    private final static String NUMBER_REGEX = "-?\\d+.?\\d*";

    @Override
    public int compare(String o1, String o2) {
        boolean isNumber1 = o1.matches(NUMBER_REGEX);
        boolean isNumber2 = o2.matches(NUMBER_REGEX);

        if (isNumber1 && !isNumber2) {
            return 1;
        } else if (!isNumber1 && isNumber2) {
            return -1;
        } else if (isNumber1) {
            Double num1 = Double.parseDouble(o1);
            Double num2 = Double.parseDouble(o2);

            return num1.compareTo(num2);
        } else {
            return o1.compareTo(o2);
        }
    }
}
