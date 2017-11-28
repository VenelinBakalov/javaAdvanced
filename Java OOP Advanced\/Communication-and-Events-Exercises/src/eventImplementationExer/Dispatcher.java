package eventImplementationExer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Dispatcher {

    private String name;
    private List<NameChangeListener> listeners;

    public Dispatcher() {
        this.listeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        this.listeners.remove(listener);
    }

    public void setName(String name) {
        this.name = name;
        NameChange event = new NameChange(this, this.name);
        this.fireNameChangeEvent(event);
    }

    public void fireNameChangeEvent(NameChange event) {
        for (NameChangeListener listener : this.listeners) {
            listener.handleChangedName(event);
        }
    }
}
