import Model.*;
import UI.*;

public class Application {
    private IView v;
    private IModel m;

    public Application(IView v, IModel m) {
        this.v = v;
        this.m = m;
    }

    public void createTreeButton() {
        m.createTree();
    }

    public void viewTreeButton() {
        v.allBranch(m.getTree());
    }

    public void dataExportButtin() {
        m.dataExport(m.getTree().getName(), v.allBranch(m.getTree()));
    }
}
