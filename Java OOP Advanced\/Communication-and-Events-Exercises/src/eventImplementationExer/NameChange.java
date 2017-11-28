package eventImplementationExer;

import java.util.EventObject;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class NameChange extends EventObject {

    private String changedName;

    public NameChange(Object source, String changedName) {
        super(source);
        this.changedName = changedName;
    }

    public String getChangedName() {
        return changedName;
    }
}
