package UI;

import Core.GenerationTree;
import Core.Human;

public interface IView {
    public void print(Human h, StringBuilder sb, String str, boolean direction, Integer currentGen, Integer targetGen);
    public String allBranch(GenerationTree tree);
    public String getFather(Human h);
    public String getGrandson(Human h);
}
