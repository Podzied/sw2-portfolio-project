/**
 * enhanced interface for playlist component
 *
 * @author ayush saggar
 */
public interface Playlist extends PlaylistKernel {

    /**
     * moves a song from one position to another in the playlist
     *
     * @param from
     *            the current index of the song
     * @param to
     *            the target index for the song
     * @updates this
     * @requires 0 <= from < this.length() and 0 <= to < this.length()
     * @ensures this.getSongAt(to) = #this.getSongAt(from) and all other songs
     *          maintain their relative positions
     */
    void moveSong(int from, int to);

    /**
     * randomly shuffles the order of songs in the playlist
     *
     * @updates this
     * @ensures this.length() = #this.length() and this contains the same songs
     *          as #this but in random order
     */
    void shuffle();

    /**
     * creates a new playlist containing only songs by the specified artist
     *
     * @param artist
     *            the artist to filter by
     * @return a new playlist with songs by the specified artist
     * @requires artist is not null
     * @ensures filterByArtist.length() = number of songs by artist in this and
     *          all songs in filterByArtist have artist equal to the given
     *          artist
     */
    Playlist filterByArtist(String artist);

    /**
     * creates a new playlist containing songs with titles containing the
     * specified text
     *
     * @param title
     *            the text to search for in song titles (case-insensitive)
     * @return a new playlist with songs containing the specified text in their
     *         titles
     * @requires title is not null
     * @ensures findSongsByTitle.length() = number of songs with title
     *          containing the given text and all songs in findSongsByTitle have
     *          titles containing the given text (case-insensitive)
     */
    Playlist findSongsByTitle(String title);

    /**
     * calculates the total duration of all songs in the playlist
     *
     * @return the total duration in seconds
     * @ensures getTotalDuration = sum of durations of all songs in this
     */
    int getTotalDuration();

    /**
     * reverses the order of songs in the playlist
     *
     * @updates this
     * @ensures this.length() = #this.length() and this.getSongAt(i) =
     *          #this.getSongAt(this.length() - 1 - i) for all valid indices i
     */
    void reverse();

    /**
     * gets the name of the playlist
     *
     * @return the playlist name
     * @ensures getName = this.name
     */
    String getName();

    /**
     * sets the name of the playlist
     *
     * @param name
     *            the new name for the playlist
     * @updates this
     * @requires name is not null
     * @ensures this.getName() = name
     */
    void setName(String name);

    /**
     * creates a copy of this playlist
     *
     * @return a new playlist that is a copy of this playlist
     * @ensures copy.length() = this.length() and copy.getSongAt(i) equals
     *          this.getSongAt(i) for all valid indices i and copy.getName() =
     *          this.getName()
     */
    Playlist copy();

    /**
     * reports whether this playlist is empty
     *
     * @return true if the playlist has no songs, false otherwise
     * @ensures isEmpty = (this.length() = 0)
     */
    boolean isEmpty();

    /**
     * gets the index of the first occurrence of the specified song
     *
     * @param song
     *            the song to search for
     * @return the index of the song, or -1 if not found
     * @ensures indexOf = index of first occurrence of song in this, or -1 if
     *          not found
     */
    int indexOf(Song song);

    /**
     * removes the song at the specified index
     *
     * @param index
     *            the index of the song to remove
     * @updates this
     * @requires 0 <= index < this.length()
     * @ensures this.length() = #this.length() - 1 and this.getSongAt(i) =
     *          #this.getSongAt(i) for i < index and this.getSongAt(i) =
     *          #this.getSongAt(i + 1) for i >= index
     * @return the song that was removed
     */
    Song removeSongAt(int index);
}
