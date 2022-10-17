package Model;

public class ContactBuilder {
    private Integer id;
    private String name;
    private String phoneNumber;

    public ContactBuilder() {
        super();
    }

    public ContactBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContactBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Contact createContact() {
        Contact contact = new Contact(id, name, phoneNumber);
        if (contact.doQualityCheck()) return contact;
        else throw new RuntimeException("PhoneNumber is absent");
    }
}
