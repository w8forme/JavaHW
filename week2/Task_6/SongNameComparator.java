package week2.Task_6;

import java.util.Comparator;

/**
 * Created by Pavel
 */
public class SongNameComparator implements Comparator<Song>
{
    @Override
    public int compare(Song o1, Song o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
