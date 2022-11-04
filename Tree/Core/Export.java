package Core;
import java.io.FileWriter;
import java.io.IOException;

public class Export {
    private String filename;
    private String data;

    public Export(String filename, String data) {
        this.filename = filename;
        this.data = data;
    }

    public void toFile() {
        try (FileWriter file = new FileWriter(this.filename, false)) {
            file.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
