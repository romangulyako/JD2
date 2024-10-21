package java_core.lesson_1.comparators;

import java.util.Comparator;

public class FirstWordsThenNumbersComparator implements Comparator<String> {
    private final static String NUMBER_REGEX = "-?\\d+.?\\d*";
    private final static String MINUS_SYMBOL = "-";

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
            boolean o1StartWithMinus = o1.startsWith(MINUS_SYMBOL);
            boolean o2StartWithMinus = o2.startsWith(MINUS_SYMBOL);

            if (o1StartWithMinus && !o2StartWithMinus) {
                return 1;
            } else if (!o1StartWithMinus && o2StartWithMinus) {
                return -1;
            }
            return o1.compareTo(o2);
        }
    }
}
