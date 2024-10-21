package java_core.lesson_1.api;

public interface IFileHandler {
    String read(String path);
    void write(String path, String text);
}
