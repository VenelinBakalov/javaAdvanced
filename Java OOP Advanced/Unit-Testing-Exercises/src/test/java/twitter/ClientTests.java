package twitter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Venelin on 3.4.2017 г..
 */
public class ClientTests {

    private static final int MESSAGE_LENGTH_EMPTY_SIZE = 0;
    private static final String TEST_MESSAGE = "this is a test";
    private Tweet tweet;

    @Before
    public void init() {
        this.tweet = Mockito.mock(Tweet.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void microwaveShouldImplementClientInterface(){
        Class<? extends Client> microwave = MicrowaveOven.class;
        Class<?>[] interfaces = microwave.getInterfaces();
        Class<Client> clientClass = null;
        for (Class currentInterface : interfaces) {
            if (currentInterface.getSimpleName().equals("Client")) {
                clientClass = currentInterface;
                break;
            }
        }
        Assert.assertSame(Client.class, clientClass);
    }

    @Test
    public void retrieveMessagesShouldPrintMessage() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Tweet tweet = new Message();
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(tweet);
        int size = stream.size();
        Assert.assertNotEquals(MESSAGE_LENGTH_EMPTY_SIZE, size);
    }

    @Test
    public void retrieveMessagesShouldPrintExactMessage() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(TEST_MESSAGE);
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(this.tweet);
        Assert.assertEquals(TEST_MESSAGE, stream.toString().trim());
    }

    @Test
    public void testStoreMessageOnTheServer() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(TEST_MESSAGE);
        Server server = new ServerImpl();
        Client client = new MicrowaveOven(server);
        client.receive(this.tweet);
        Field messageField = server.getClass().getDeclaredField("messages");
        messageField.setAccessible(true);
        List<String> values = List.class.cast(messageField.get(server));
        Assert.assertEquals(TEST_MESSAGE, values.get(0));
    }
}
