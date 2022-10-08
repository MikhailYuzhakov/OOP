public class Message {
    // Calendar date = new GregorianCalendar();
    private Integer hours;
    private Integer min;
    private User sender;
    private String content;
    private Boolean isRead;

    public Message(Integer hours, Integer min, User sender, String content) {
        this.content = content;
        this.hours = hours;
        this.min = min;
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        
        return String.format("%s (%d:%d) %s", sender, hours, min, content);
    }
}
