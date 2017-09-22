package interfaces;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public interface OutputWriter {

    void writeLine(String output);

    void writeLine(String format, Object... params);

}
