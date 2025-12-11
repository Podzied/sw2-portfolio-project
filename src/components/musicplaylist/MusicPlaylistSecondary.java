package components.musicplaylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * layered implementations of secondary methods for musicplaylist
 *
 * @author Ayush Saggar
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    // common methods

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MusicPlaylist)) {
            return false;
        }
        MusicPlaylist other = (MusicPlaylist) obj;
        if (this.length() != other.length()) {
            return false;
        }
        Iterator<Song> it1 = this.iterator();
        Iterator<Song> it2 = other.iterator();
        while (it1.hasNext()) {
            if (!it1.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (Song s : this) {
            result = 31 * result + s.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        boolean first = true;
        for (Song s : this) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(s.toString());
            first = false;
        }
        sb.append(">");
        return sb.toString();
    }

    // secondary methods

    @Override
    public void moveSong(int fromIndex, int toIndex) {
        assert 0 <= fromIndex : "Violation of: 0 <= fromIndex";
        assert fromIndex < this.length() : "Violation of: fromIndex < |this|";
        assert 0 <= toIndex : "Violation of: 0 <= toIndex";
        assert toIndex < this.length() : "Violation of: toIndex < |this|";

        Song s = this.removeSong(fromIndex);
        // after removal indexes shift
        int insertAt = toIndex;
        if (toIndex > fromIndex) {
            insertAt = toIndex;
        }

        // remove songs from insertAt to end and save them
        List<Song> temp = new ArrayList<>();
        while (this.length() > insertAt) {
            temp.add(0, this.removeSong(this.length() - 1));
        }

        // add the moved song
        this.addSong(s);

        // add back the saved songs
        for (Song song : temp) {
            this.addSong(song);
        }
    }

    @Override
    public void shuffle() {
        List<Song> temp = new ArrayList<>();
        while (this.length() > 0) {
            temp.add(this.removeSong(0));
        }
        Collections.shuffle(temp);
        for (Song s : temp) {
            this.addSong(s);
        }
    }

    @Override
    public MusicPlaylist filterByArtist(String artist) {
        assert artist != null : "Violation of: artist is not null";

        MusicPlaylist filtered = this.newInstance();
        for (int i = 0; i < this.length(); i++) {
            Song s = this.getSongAt(i);
            if (s.artist().equalsIgnoreCase(artist)) {
                filtered.addSong(new Song(s.title(), s.artist(), s.duration()));
            }
        }
        return filtered;
    }

    @Override
    public int getTotalDuration() {
        int total = 0;
        for (int i = 0; i < this.length(); i++) {
            total += this.getSongAt(i).duration();
        }
        return total;
    }

    @Override
    public boolean contains(Song s) {
        assert s != null : "Violation of: s is not null";

        for (int i = 0; i < this.length(); i++) {
            if (this.getSongAt(i).equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Song s) {
        assert s != null : "Violation of: s is not null";

        for (int i = 0; i < this.length(); i++) {
            if (this.getSongAt(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeByArtist(String artist) {
        assert artist != null : "Violation of: artist is not null";

        int i = 0;
        while (i < this.length()) {
            if (this.getSongAt(i).artist().equalsIgnoreCase(artist)) {
                this.removeSong(i);
                // dont increment i since list shifted
            } else {
                i++;
            }
        }
    }

    @Override
    public void append(MusicPlaylist other) {
        assert other != null : "Violation of: other is not null";
        assert other != this : "Violation of: other is not this";

        while (other.length() > 0) {
            this.addSong(other.removeSong(0));
        }
    }

}
