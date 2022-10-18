package Model;

public class Contact {
    protected Integer id;
    protected String name;
    protected String phoneNumber;

    enum group {
        FRIENDS,
        COLLEGUES,
        RELATIVES
    }

    protected Contact(Integer id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    protected void editContact() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("; ").append(phoneNumber);
        return sb.toString();
    }

    protected Boolean doQualityCheck() {
        if (this.phoneNumber != null) return true;
        else return false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}