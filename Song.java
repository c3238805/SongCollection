/**
 * SENG1110/SENG6110 Object Oriented Programming 
 * Assessment 2
 * @ C3238805
 * @ NI ZENG
 * Due 12 Jun 2020
 */
public class Song
{
	private String name;
	private String artist;
	private int duration;
	private String genre;
	
	//add comments
    public Song ()
    {
        name = "";
        artist = "";
        duration = 0;
        genre = "";
    }
    public Song (String inputName, String inputArtist, int songDuration, String pickGenre)
    {
        name = inputName;
        artist = inputArtist;
        duration = songDuration;
        genre = pickGenre;
    }

//--------------------------------------------------------------------------------------    
    public void setName(String inputName)
    {
         name = inputName;
    }
    public String getName()
    {
        return name;
    }
//--------------------------------------------------------------------------------------
    public void setArtist (String inputArtist)
    {
        artist = inputArtist;
    }
    public String getArtist()
    {
        return artist;
    }
//--------------------------------------------------------------------------------------
    public void setDuration(int songDuration)
    {
        duration = songDuration;
    }
    public int getDuration()
    {
        return duration;
    }
//--------------------------------------------------------------------------------------
    public void setGenre(String pickGenre )
    {
        genre= pickGenre;        
    }
    public String getGenre()
    {
         return genre;     
    }
}
	//add other methods

