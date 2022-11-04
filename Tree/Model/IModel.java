package Model;

import Core.GenerationTree;

public interface IModel {
    public void createTree();
    public GenerationTree getTree();
    public void dataExport(String filename, String data);
}
