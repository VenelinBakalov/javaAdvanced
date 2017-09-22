package hell.interfaces;

/**
 *  This is the interface for the OutputWriter
 *  @method void writeLine(String output) - a method which is made to write a string line to the corresponding Stream.
 *  @method void writeLine(String format, Object... params) - a method which is made write a string line to the corresponding Stream, formatted in a specific way, with the given parameters.
 */
public interface OutputWriter {
    void writeLine(String output);

    void writeLine(String format, Object... params);
}