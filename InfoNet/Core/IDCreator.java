package Core;

import java.util.ArrayList;

public class IDCreator {
    private Integer id = 1;
    private ArrayList<Integer> ids = new ArrayList<>();

    public IDCreator(){
        super();
    }

    public Integer getId() {
        ids.add(id);
        return id++;
    }

    public void insertIds(ArrayList<Integer> ids2) {
        for (Integer item : ids2) {
            if (!ids.contains(item)) {
                ids.add(item);   
            }
        }
    }

    public void deleteID(ArrayList<Integer> ids2) {
        for (Integer id2 : ids2) {
            if (ids.contains(id2)) {
                ids.remove(id2);
            }
        }
    }

    public String getIDList() {
        StringBuilder sb = new StringBuilder();
        for (Integer item : ids) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }
}
