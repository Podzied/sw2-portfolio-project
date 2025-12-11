package components.musicplaylist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * junit tests for MusicPlaylist1L kernel methods
 *
 * @author Ayush Saggar
 */
public class MusicPlaylist1LTest {

    // test addSong and length

    @Test
    public void testAddSongEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s = new Song("Test", "Artist", 180);
        p.addSong(s);
        assertEquals(1, p.length());
        assertEquals(s, p.getSongAt(0));
    }

    @Test
    public void testAddSongMultiple() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s1 = new Song("Song1", "Artist1", 100);
        Song s2 = new Song("Song2", "Artist2", 200);
        Song s3 = new Song("Song3", "Artist3", 300);
        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        assertEquals(3, p.length());
        assertEquals(s3, p.getSongAt(2));
    }

    // test removeSong

    @Test
    public void testRemoveSongFirst() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s1 = new Song("Song1", "Artist1", 100);
        Song s2 = new Song("Song2", "Artist2", 200);
        p.addSong(s1);
        p.addSong(s2);
        Song removed = p.removeSong(0);
        assertEquals(s1, removed);
        assertEquals(1, p.length());
        assertEquals(s2, p.getSongAt(0));
    }

    @Test
    public void testRemoveSongLast() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s1 = new Song("Song1", "Artist1", 100);
        Song s2 = new Song("Song2", "Artist2", 200);
        p.addSong(s1);
        p.addSong(s2);
        Song removed = p.removeSong(1);
        assertEquals(s2, removed);
        assertEquals(1, p.length());
    }

    @Test
    public void testRemoveSongOnly() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s = new Song("Only", "Artist", 150);
        p.addSong(s);
        Song removed = p.removeSong(0);
        assertEquals(s, removed);
        assertEquals(0, p.length());
    }

    // test length

    @Test
    public void testLengthEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        assertEquals(0, p.length());
    }

    @Test
    public void testLengthAfterOperations() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "B", 100));
        p.addSong(new Song("C", "D", 100));
        p.removeSong(0);
        assertEquals(1, p.length());
    }

    // test getSongAt

    @Test
    public void testGetSongAtFirst() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s1 = new Song("First", "Artist", 100);
        Song s2 = new Song("Second", "Artist", 200);
        p.addSong(s1);
        p.addSong(s2);
        assertEquals(s1, p.getSongAt(0));
        // make sure it didnt change
        assertEquals(2, p.length());
    }

    @Test
    public void testGetSongAtMiddle() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "X", 100));
        p.addSong(new Song("B", "Y", 200));
        p.addSong(new Song("C", "Z", 300));
        Song middle = p.getSongAt(1);
        assertEquals("B", middle.title());
    }

    // test clear

    @Test
    public void testClearEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.clear();
        assertEquals(0, p.length());
    }

    @Test
    public void testClearNonEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "B", 100));
        p.addSong(new Song("C", "D", 200));
        p.clear();
        assertEquals(0, p.length());
    }

    // test newInstance

    @Test
    public void testNewInstance() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "B", 100));
        MusicPlaylist p2 = p.newInstance();
        assertEquals(0, p2.length());
        // original unchanged
        assertEquals(1, p.length());
    }

    // test transferFrom

    @Test
    public void testTransferFrom() {
        MusicPlaylist p1 = new MusicPlaylist1L();
        MusicPlaylist p2 = new MusicPlaylist1L();
        Song s = new Song("Test", "Artist", 100);
        p2.addSong(s);
        p1.transferFrom(p2);
        assertEquals(1, p1.length());
        assertEquals(s, p1.getSongAt(0));
        assertEquals(0, p2.length());
    }

}
