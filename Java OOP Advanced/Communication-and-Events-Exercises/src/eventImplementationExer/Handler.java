package eventImplementationExer;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(NameChange event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getChangedName()));
    }
}
