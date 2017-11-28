package skeleton.P02_FileStream;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public abstract class BaseStream implements Streamable {

    private int length;
    private int byteSent;

    protected BaseStream(int length, int byteSent) {
        this.length = length;
        this.byteSent = byteSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.byteSent;
    }
}
