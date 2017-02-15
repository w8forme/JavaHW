package week2.Task_6;

/**
 * Created by Pavel
 */
public class Song
{
    private String name;
    private String artist;
    private Integer rating;

    public Song(String name, String artist, Integer rating)
    {
        this.name = name;
        this.artist = artist;
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return String.format("| %-40s | %-30s | %-7d |", name, artist, rating);
    }

    public String getName()
    {
        return name;
    }

    public String getArtist()
    {
        return artist;
    }

    public Integer getRating()
    {
        return rating;
    }
}
