package home_work_1.task_71;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Class<?> printerClass = printer.getClass();
        try {
            Method printMethod = printerClass.getDeclaredMethod("printHelloWorld");
            System.out.println(printMethod.invoke(printer));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
