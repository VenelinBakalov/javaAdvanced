package warningLevels;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Message {

    private Importance level;
    private String content;

    public Message(Importance level, String content) {
        this.level = level;
        this.content = content;
    }

    public Importance getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return this.level + ": " + this.content;
    }
}
