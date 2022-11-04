package Model;

import Core.*;

public class Model implements IModel {
    private GenerationTree famTree;

    public Model() {
        super();
        famTree = new GenerationTree("Южаков");
    }

    @Override
    public void createTree() {
        //1 поколение
        famTree.addNode("Валерий", "Южаков", "Аркадьевич", "m");
        famTree.addNode("Валентина", "Булатова", "Владимировна", "f");
        famTree.addNode("Юрий", "Русских", "Алексеевич", "m");
        famTree.addNode("Нина", "Русских", "Кузьминична", "f");

        //2 поколение
        famTree.addNode("Сергей", "Южаков", "Валерьевич", "m", 
                        famTree.getNodeByFullName("Валерий", "Южаков"), 
                        famTree.getNodeByFullName("Валентина", "Булатова"));
        
        famTree.addNode("Евгений", "Южаков", "Валерьевич", "m", 
                        famTree.getNodeByFullName("Валерий", "Южаков"), 
                        famTree.getNodeByFullName("Валентина", "Булатова"));
    
        famTree.addNode("Светлана", "Южаковa", "Андреевна", "f");

        famTree.addNode("Наталья", "Русских", "Юрьевна", "f", 
                        famTree.getNodeByFullName("Юрий", "Русских"), 
                        famTree.getNodeByFullName("Нина", "Русских"));
        
        famTree.addNode("Татьяна", "Русских", "Юрьевна", "f", 
                        famTree.getNodeByFullName("Юрий", "Русских"), 
                        famTree.getNodeByFullName("Нина", "Русских"));
        
        famTree.addNode("Евгений", "Романенко", "Александрович", "f");
        
        //3 поколение
        famTree.addNode("Михаил", "Южаков", "Сергеевич", "m", 
                        famTree.getNodeByFullName("Сергей", "Южаков"), 
                        famTree.getNodeByFullName("Наталья", "Русских"));
        
        famTree.addNode("Артём", "Южаков", "Евгеньевич", "m", 
                        famTree.getNodeByFullName("Евгений", "Южаков"), 
                        famTree.getNodeByFullName("Светлана", "Южаковa"));
        
        famTree.addNode("Иван", "Романенко", "Евгеньевич", "m", 
                        famTree.getNodeByFullName("Евгений", "Романенко"), 
                        famTree.getNodeByFullName("Татьяна", "Русских"));
        
        famTree.addNode("Матвей", "Романенко", "Евгеньевич", "m", 
                        famTree.getNodeByFullName("Евгений", "Романенко"), 
                        famTree.getNodeByFullName("Татьяна", "Русских"));


    }

    @Override
    public GenerationTree getTree() {
        return famTree;
    }

    @Override
    public void dataExport(String filename, String data) {
        Export e = new Export(filename, data);
        e.toFile();
    }
}
