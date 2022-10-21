import Core.Company;
import Model.Model;
import UI.*;

public class Program {
    public static void main(String[] args) {

        Presenter p = new Presenter(new Model(), new AutoView());
        p.clickBtn1();
        p.clickBtn2();
    }
}
