package Tree;

import java.io.FileWriter;

public class Export extends View{
    private String name;
    private String filename;
    /**
     * 
     * @param name - имя файла без расширенияы
     */
    public Export(GenerationTree myTree, String filename) {
        super(myTree);
        this.filename = filename;
    }

    //отдельная сущность, отдельный класс
    private void toFile(Human h, String data, String format) throws Exception {
        FileWriter file = new FileWriter(this.name + format, false);

        switch (format) {
            case ".txt":
                file.write(h.toString() + "\n");
                break;
            case ".csv":
                file.write(h.toString() + ";");
                break;
            case "tree.txt":
                file.write(data);
                break;
        }
        file.close();
    }

    public void toFile() throws Exception {
        String fileData = super.allBranch();
        this.toFile(null, fileData, "tree.txt");
    }

    public void toFile(String format) throws Exception {
        this.toFile(null, "", format);
        System.out.println("Data is empty");
    }

    public void toFileTxt() throws Exception {
        this.toFile(".txt");
    }

    public void toFileCsv() throws Exception {
        this.toFile(".csv");
    }
 
}
