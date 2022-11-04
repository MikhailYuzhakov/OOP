
import Model.Model;
import UI.View;

public class myTree1 {

    public static void main(String[] args) throws Exception {
        Application app = new Application(new View(), new Model());
        
        app.createTreeButton();
        app.viewTreeButton();
        app.dataExportButtin();
    }
}