package Model;

public class Author {
    Long id;
    String name;

    public Author(Integer id, String name) {
        this.id = Long.valueOf(id);
        this.name = name;
    }
}
