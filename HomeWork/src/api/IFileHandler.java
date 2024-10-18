package api;

import java.util.List;

public interface IFileHandler {
    String read(String path);
    void write(String path, String text);
}
