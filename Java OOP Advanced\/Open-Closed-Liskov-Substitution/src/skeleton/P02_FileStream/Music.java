package skeleton.P02_FileStream;

public class Music extends BaseStream {

    private String artist;
    private String album;

    public Music(int length, int byteSent, String artist, String album) {
        super(length, byteSent);
        this.artist = artist;
        this.album = album;
    }
}
