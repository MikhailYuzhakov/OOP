package UI;
import Core.GenerationTree;
import Core.Human;

public class View implements IView {

    public View() {
        super();
    }

    /**
     * Печать генеологического древа
     * @param h - точка входа в дерево
     * @param direction - направление обхода, true - от предков к потомкам
     */
    @Override
    public void print(Human h, StringBuilder sb, String str, boolean direction, Integer currentGen, Integer targetGen)
    {
        if (h != null) {
            sb.append(String.format("%sid:%s fn:%s ln:%s\n", str, h.getID(), h.getFirstName(), h.getLastName()));
            if (direction) {
                System.out.println(h.getDad());
                if (currentGen == targetGen)
                    return;
                else
                    currentGen++;
                if (h.getDad() != null) 
                    print(h.getDad(), sb, str + " ", direction, currentGen, targetGen);
                if (h.getMom() != null) 
                    print(h.getMom(), sb, str + " ", direction, currentGen, targetGen);
            } else {
                if (!h.getChilds().isEmpty()) {
                    str += ' ';
                    if (currentGen == targetGen)
                        return;
                    else {
                        currentGen++;
                    }
                    for (Human child : h.getChilds()) {
                        print(child, sb, str, direction, currentGen, targetGen); // прибавить 1 поколение
                    }    
                }
            }
        }
    }
    
    @Override
    public String allBranch(GenerationTree tree) {
        StringBuilder sb = new StringBuilder();
        sb.append(tree.getName());
        sb.append("\n");
        this.print(tree.getNodeByFullName("Валерий", "Южаков"), sb, "", false, 0, 5);
        System.out.println(sb);
        return sb.toString();
    }

    @Override
    public String getGrandson(Human h) {
        StringBuilder sb = new StringBuilder();
        this.print(h, sb, "", false, 0, 2);
        return sb.toString();
    }

    @Override
    public String getFather(Human h) {
        StringBuilder sb = new StringBuilder();
        this.print(h, sb, "", false, 0, 1);
        return sb.toString();
    }
}
