package Model;

import java.io.IOException;

public interface Model {
    public Phonebook fillPhonebook(String data);
    public String getPhonebook();
    public void myImport();
    public void myExport() throws IOException;
}
