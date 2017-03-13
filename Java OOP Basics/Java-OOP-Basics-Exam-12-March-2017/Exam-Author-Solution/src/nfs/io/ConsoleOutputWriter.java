package nfs.io;

public class ConsoleOutputWriter {
    public void writeLine(String output){
        System.out.println(output);
    }

    public void writeLine(String format, Object... params){
        System.out.println(String.format(format, params));
    }
}
