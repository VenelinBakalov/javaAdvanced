package onlineRadioDatabase;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Song {

    private String artistName;
    private String songName;
    private String duration;

    public Song(String artistName, String songName, String duration) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setDuration(duration);
    }

    public int getDuration() {
        int duration = 0;
        String[] durationArgs = this.duration.split(":");
        int minutes = Integer.parseInt(durationArgs[0]);
        int seconds = Integer.parseInt(durationArgs[1]);
        duration += minutes * 60 + seconds;
        return duration;
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || 20 < artistName.length()) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || 30 < songName.length()) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = songName;
    }

    private void setDuration(String duration) {
        String[] durationArgs = duration.split(":");
        int minutes = 0;
        int seconds = 0;
        try {
            minutes = Integer.parseInt(durationArgs[0]);
            seconds = Integer.parseInt(durationArgs[1]);
        } catch (IllegalArgumentException e) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
        if (minutes < 0 || 14 < minutes) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (seconds < 0 || 59 < seconds) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.duration = duration;
    }
}
