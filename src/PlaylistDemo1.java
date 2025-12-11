import components.musicplaylist.MusicPlaylist;
import components.musicplaylist.MusicPlaylist1L;
import components.musicplaylist.Song;

/**
 * demo showing basic playlist usage - creating a party playlist
 *
 * @author Ayush Saggar
 */
public final class PlaylistDemo1 {

    private PlaylistDemo1() {
    }

    public static void main(String[] args) {
        // create a party playlist
        MusicPlaylist party = new MusicPlaylist1L();

        // add some songs
        party.addSong(new Song("Blinding Lights", "The Weeknd", 200));
        party.addSong(new Song("Levitating", "Dua Lipa", 203));
        party.addSong(new Song("Uptown Funk", "Bruno Mars", 270));
        party.addSong(new Song("Shake It Off", "Taylor Swift", 219));
        party.addSong(new Song("Happy", "Pharrell", 233));

        System.out.println("Party Playlist:");
        System.out.println("---------------");
        for (int i = 0; i < party.length(); i++) {
            Song s = party.getSongAt(i);
            System.out.println((i + 1) + ". " + s);
        }

        // show total duration
        int total = party.getTotalDuration();
        System.out.println("\nTotal: " + total / 60 + " min " + total % 60 + " sec");

        // shuffle for the party
        System.out.println("\nShuffling...\n");
        party.shuffle();

        System.out.println("Shuffled Playlist:");
        System.out.println("------------------");
        for (int i = 0; i < party.length(); i++) {
            System.out.println((i + 1) + ". " + party.getSongAt(i));
        }
    }

}
