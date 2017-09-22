package twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 3.4.2017 г..
 */
public class ServerImpl implements Server {

    private List<String> messages;

    public ServerImpl() {
        this.messages = new ArrayList<>();
    }

    @Override
    public void storeMessages(String message) {
        this.messages.add(message);
    }
}
