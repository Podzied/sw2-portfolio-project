package components.musicplaylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * MusicPlaylist represented as a java.util.List
 *
 * @convention
 *   $this.rep is not null and
 *   all entries in $this.rep are not null
 *
 * @correspondence
 *   this = [entries of $this.rep from index 0 to size-1]
 *
 * @author Ayush Saggar
 */
public class MusicPlaylist1L extends MusicPlaylistSecondary {

    // representation
    private List<Song> rep;

    // helper to create fresh rep
    private void createNewRep() {
        this.rep = new ArrayList<>();
    }

    // constructors

    /**
     * no arg constructor
     */
    public MusicPlaylist1L() {
        this.createNewRep();
    }

    // standard methods

    @SuppressWarnings("unchecked")
    @Override
    public MusicPlaylist newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(MusicPlaylist source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof MusicPlaylist1L : "Violation of: source is of dynamic type MusicPlaylist1L";

        MusicPlaylist1L localSource = (MusicPlaylist1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    // kernel methods

    @Override
    public void addSong(Song s) {
        assert s != null : "Violation of: s is not null";

        this.rep.add(s);
    }

    @Override
    public Song removeSong(int index) {
        assert 0 <= index : "Violation of: 0 <= index";
        assert index < this.rep.size() : "Violation of: index < |this|";

        return this.rep.remove(index);
    }

    @Override
    public int length() {
        return this.rep.size();
    }

    @Override
    public Song getSongAt(int index) {
        assert 0 <= index : "Violation of: 0 <= index";
        assert index < this.rep.size() : "Violation of: index < |this|";

        return this.rep.get(index);
    }

    // iterator

    @Override
    public Iterator<Song> iterator() {
        return this.rep.iterator();
    }

}
