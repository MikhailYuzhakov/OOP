import Model.*;
import UI.IView;
import UI.View;

public class Presenter {
    IModel m;
    IView v;

    Presenter(IModel m, IView v) {
        this.m = m;
        this.v = v;
    }

    public void clickBtn1() {
       m.setStaffCompany(v.getEmployeeData());
    }

    public void clickBtn2() {

        System.out.println(v.viewAllEmployees(m.getEmployeeList()));

    }
}
