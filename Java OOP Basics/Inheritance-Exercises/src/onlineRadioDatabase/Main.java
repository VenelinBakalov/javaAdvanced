package onlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int songCount = Integer.parseInt(reader.readLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < songCount; i++) {
            String[] songArgs = reader.readLine().split(";");
            String artistName = songArgs[0];
            String songName = songArgs[1];
            String duration = songArgs[2];

            try {
                Song song = new Song(artistName, songName, duration);
                songs.add(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Songs added: " + songs.size());
        System.out.println(getTotalDuration(songs));
    }

    private static String getTotalDuration(List<Song> songs) {
        int duration = 0;
        for (Song song : songs) {
            duration += song.getDuration();
        }

        int hours = duration / 3600;
        duration %= 3600;
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("Playlist length: %sh %sm %ss", hours, minutes, seconds);
    }
}
