package components.musicplaylist;

/**
 * musicplaylist kernel enhanced with secondary methods
 *
 * @author Ayush Saggar
 *
 * @mathmodel type MusicPlaylist is modeled by string of Song
 */
public interface MusicPlaylist extends MusicPlaylistKernel {

    /**
     * moves song from one position to another
     *
     * @param fromIndex
     *            current position
     * @param toIndex
     *            new position
     * @updates this
     * @requires 0 <= fromIndex < |this| and 0 <= toIndex < |this|
     * @ensures <pre>
     * |this| = |#this| and
     * this[toIndex] = #this[fromIndex]
     * </pre>
     */
    void moveSong(int fromIndex, int toIndex);

    /**
     * shuffles songs into random order
     *
     * @updates this
     * @ensures |this| = |#this| and [this is a permutation of #this]
     */
    void shuffle();

    /**
     * returns new playlist with only songs by given artist
     *
     * @param artist
     *            artist to filter by
     * @return new filtered playlist
     * @requires artist /= null
     * @ensures <pre>
     * [filterByArtist contains exactly the songs from this
     *  where song.artist equals artist (case insensitive)]
     * </pre>
     */
    MusicPlaylist filterByArtist(String artist);

    /**
     * returns total duration of all songs in seconds
     *
     * @return total duration
     * @ensures getTotalDuration = [sum of all song durations]
     */
    int getTotalDuration();

    /**
     * reports whether song is in this
     *
     * @param s
     *            song to look for
     * @return true if found
     * @requires s /= null
     * @ensures contains = [s is in this]
     */
    boolean contains(Song s);

    /**
     * returns index of first occurrence of song or -1 if not found
     *
     * @param s
     *            song to look for
     * @return index or -1
     * @requires s /= null
     * @ensures <pre>
     * (indexOf >= 0 implies this[indexOf] = s) and
     * (indexOf = -1 implies [s not in this])
     * </pre>
     */
    int indexOf(Song s);

    /**
     * removes all songs by given artist
     *
     * @param artist
     *            artist to remove
     * @updates this
     * @requires artist /= null
     * @ensures [this has no songs by artist]
     */
    void removeByArtist(String artist);

    /**
     * appends all songs from other to this
     *
     * @param other
     *            playlist to append
     * @updates this
     * @clears other
     * @requires other /= null
     * @ensures this = #this * #other
     */
    void append(MusicPlaylist other);

}
