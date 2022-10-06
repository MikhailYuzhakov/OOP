package Tree;

//когда пишем методы - нужно писать методы для проверки методов (unit tests)
public class myTree1 {

    public static void main(String[] args) throws Exception {
        //здесь две-три инструкции, дерево создает отдельный метод класса (не класса Human)
        GenerationTree myTree = new GenerationTree("myTree"); //экземпляр класса генеологическое древо

        View v = new View(myTree);
        System.out.println(v.allBranch());

        Export export = new Export(myTree, "myData");
        export.toFile();
        // export.toFile(myTree);


    }
}