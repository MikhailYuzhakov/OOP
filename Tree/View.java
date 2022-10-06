package Tree;

public class View {
    GenerationTree tree;
    String name;

    public View(GenerationTree myTree) {
        this.name = myTree.getName();
        this.tree = myTree;
    }

    /**
     * Печать генеологического древа
     * @param h - точка входа в дерево
     * @param direction - направление обхода, true - от предков к потомкам
     */
    private void print(Human h, StringBuilder sb, String str, boolean direction, Integer currentGen, Integer targetGen)
    {
        if (h != null) {
            sb.append(String.format("%sid:%d fn:%s ln:%s\n", str, h.getHumanId(), h.fn, h.ln));
            if (direction) {
                if (currentGen == targetGen)
                    return;
                else
                    currentGen++;
                if (h.dad != null) 
                    print(h.dad, sb, str + " ", direction, currentGen, targetGen);
                if (h.mom != null) 
                    print(h.mom, sb, str + " ", direction, currentGen, targetGen);
            } else {
                if (!h.childs.isEmpty()) {
                    str += ' ';
                    if (currentGen == targetGen)
                        return;
                    else {
                        currentGen++;
                    }
                    for (Human child : h.childs) {
                        print(child, sb, str, direction, currentGen, targetGen); // прибавить 1 поколение
                    }    
                }
            }
        }
    }

    public String allBranch() {
        StringBuilder sb = new StringBuilder();
        sb.append(tree.getName());
        sb.append("\n");
        this.print(tree.getFirst(), sb, "", false, 0, 5);
        return sb.toString();
    }

    public String getGrandson(Human h) {
        StringBuilder sb = new StringBuilder();
        this.print(h, sb, "", false, 0, 2);
        return sb.toString();
    }

    public String getFather(Human h) {
        StringBuilder sb = new StringBuilder();
        this.print(h, sb, "", false, 0, 1);
        return sb.toString();
    }
}
