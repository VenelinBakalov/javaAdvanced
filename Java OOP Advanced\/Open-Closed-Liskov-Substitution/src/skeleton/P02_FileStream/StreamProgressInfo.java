package skeleton.P02_FileStream;

public class StreamProgressInfo {
    private Streamable file;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Streamable file) {
        this.file = file;
    }

    public int calculateCurrentPercent() {
        return (this.file.getBytesSent() * 100) / this.file.getLength();
    }
}
