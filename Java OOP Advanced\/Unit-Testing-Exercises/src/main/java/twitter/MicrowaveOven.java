package twitter;

/**
 * Created by Dani on 3.4.2017 г..
 */
public class MicrowaveOven implements Client {

    private Server server;

    public MicrowaveOven(Server server) {
        this.server = server;
    }

    @Override
    public void receive(Tweet tweet) {
        String message = tweet.retrieveMessage();
        System.out.println(message);
        this.server.storeMessages(message);
    }
}
