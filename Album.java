/**
 * SENG1110/SENG6110 Object Oriented Programming 
 * Assessment 2
 * @ C3238805
 * @ NI ZENG
 * Due 12 Jun 2020
 */
public class Album
{
    // instance variables 
    private Song[] s;
    final private int MAX = 5;
    private int total;
    private int totalTime;
    private final int MAX_TIME = 720; //12 minutes
    private String albumname;
    
    public Album()
    {
        s = new Song[MAX];            
        total = 0;
    }
//-----------------------------------------------------------------------------------------------
    public boolean addData(String name,String artist,int duration,String genre)
    {
        if(total<5){
            
        s[total]= new Song();
        setData1(s[total],name,artist,duration,genre);
        total++;
        return true;
        }
        else
            return false;
    }
//------------------------------------------------------------------------------------------------
    private void setData1(Song s,String name, String artist, int duration, String genre )
    {
        s.setName(name);
        s.setArtist(artist);
        s.setDuration(duration);
        s.setGenre(genre);
    }
//------------------------------------------------------------------------------------ 

      
    public int sumDuration()
    {
        int totalTime = 0;
        for(int i=0;i<total;i++){
            totalTime +=(s[i].getDuration());                    
        }  
        return totalTime;
    }
//--------------------------------------------------------------------------------    
    public String displayallsong(){  
        String allname="";
        for(int i=0;i<total;i++){           
            allname+= "       (Song name): "+s[i].getName()+" (artist): "+s[i].getArtist()+" (duration): "+s[i].getDuration()+" (genre): "+s[i].getGenre()+"\n";
        }
           return allname;                       
    }
    
//---------------------------------------------------------------------------------

    public String songName(){
        String name ="";
        int count = 0;
        for(int i=0;i<total;i++){
            name = s[i].getName(); 
            
        }       
        return (name);
    }
//---------------------------------------------------------------------------------    
    public void addAlbumname (String aName)
    {
        albumname = aName;
    }
    public String getAlbumname ()
    {
        return albumname ; 
    }
//---------------------------------------------------------------------------------
    public String songinfo(int songindex){
        String info="";
        
        for(int i=0;i<total;i++){
            info = s[songindex].getName()+s[songindex].getArtist()+s[songindex].getDuration()+s[songindex].getGenre();
        }        
        return info;
    }
//---------------------------------------------------------------------------------
    public int songindex(){
 
        return total;
    }
//--------------------------------------------------------------------------------    
    public String displayalbumsong(){       
        for(int i=0;i<total;i++){
            System.out.println("("+i+")"+"       (Song name): "+s[i].getName()+" (artist): "+s[i].getArtist()+" (duration): "+s[i].getDuration()+" (genre): "+s[i].getGenre());
            
        }
        System.out.println("("+total+")"    +"Exit");
           return("*************************************************************");                       
    }
//--------------------------------------------------------------------------------
    public int deleteSong(){
        return total--;
    }
//---------------------------------------------------------------------------------   
      public boolean issongnull(int i){
        return s[i] ==null;
    }  
//--------------------------------------------------------------------------    
    
    public String getnameofsong(int i){
        return s[i].getName();
    }

    public String getartistofsong(int i){
        return s[i].getArtist();
    }
    
    public int getdurationofsong(int i){
        return s[i].getDuration();
    }
    
    public String getgenreofsong(int i){
        return s[i].getGenre();
    }
    public void deletesong(int picksong){
        
        if(picksong==0){
                total--;
                for(int i=0;i<total;i++){
                    s[i]=s[i+1];
                }
            }
            else{
                total--;
                for (int i=picksong;i<total;i++){
                    s[i] = s[i+1];
                } 
                s[picksong]=null;
            }             
    }
}

