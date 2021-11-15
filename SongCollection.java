/**
 * SENG1110/SENG6110 Object Oriented Programming 
 * Assessment 2
 * @ C3238805
 * @ NI ZENG
 * Due 12 Jun 2020
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SongCollection
{
    private Scanner console = new Scanner (System.in);
    private Album [] a = new Album[4];
    private int total;
    private int totalTime;
    private final int MAX_TIME=720 ;
    Scanner inputStream ;
    public SongCollection(){
        

    }   
    public  void run()
    {
        int position;
        for(int i=0;i<4;i++){
            a[i] = new Album();
        }
            
        System.out.println("Do you want to input songs from an external file?");
        System.out.println("(1) yes!\n(2) NO!"); position = console.nextInt();
        switch(position){
            case 1:
                    inputFile();
                    break;
            case 2:
                    break;
            default: System.out.println("Invalid Selection.");                    
        }
        
        int choice;
        printMenu();
        choice = console.nextInt();
        while(choice != 0)  {
            switch(choice) {
                
                case 1: 
                        addAlbum();                       
                        break;
                case 2: 
                        addsongsoption();
                        break;
                case 3:
                        findSongs();
                        break;
                case 4:
                        findAlbum();
                        break;
                case 5:
                        displaySong();
                        break; 
                case 6:
                        findDuration();
                        break;
                case 7:
                        findGenre();
                        break;
                case 8:
                        deleteAlbum();
                        break;
                case 9 :
                        deleteSong();
                        break;
                case 0: break;
                default: System.out.println("Invalid Selection.");
            }//end switch 
            printMenu();
            choice = console.nextInt();        
        }

    }
    public void printMenu(){
        System.out.println("-----Select and enter-----");    
        System.out.println(" (1) Create a new Album.");
	System.out.println(" (2) Add Songs.");        
	System.out.println(" (3) Search Songs.");
        System.out.println(" (4) Search Album.");
	System.out.println(" (5) List of all Songs.");
	System.out.println(" (6) Songs under time duration.");
	System.out.println(" (7) Enter genre find songs.");
	System.out.println(" (8) Delete a Album.");
        System.out.println(" (9) Delete a Song from an Album.");
	System.out.println(" (0) Exit the program.");
        System.out.println("-----End of Selection-----");

    }
    public void addAlbum(){                
        if(total<4){
            String albumName ;
            System.out.print("New Album's Name: ");
            albumName = console.next();
            
            boolean matchFound = false;
            for(int i=0;i<total;i++){
                if (a[i].getAlbumname().equals(albumName)){
                    matchFound = true;
                }
            }       
            if (matchFound){
                System.out.println("Album already exists!!");
                return;
            }
            a[total]= new Album();        
            setAlbum(a[total],albumName);
            System.out.println("Store as: "+a[total].getAlbumname());
            total++; 
             
        } 
        else
            System.out.println("ONLY allow to create 4 album !");            
    }       
    private void setAlbum(Album a ,String name){
        a.addAlbumname(name);
    }
    public static void main(String[] args) 
    {
	SongCollection sg = new SongCollection();
        sg.run();        

    }
//------------------------------------------------------------------------------   
    public void addsongsoption(){
        String name,artist,genre = null;
        int duration,genrepick;
        int option=1;
        String album;
        System.out.println("which album? (Enter album name:)"); album = console.next();
        boolean matchFound = false;
        int albumindex=0;

        for(int i=0;i<total;i++){
            if (a[i].getAlbumname().equals(album)){
                matchFound = true;
                albumindex = i;
            }
        }       
        if (!matchFound){
            System.out.println("No such album !!");
            return;
        }         
//------------------------------------------------------------------------------        
        System.out.println("Song's Name: "); name = console.next();        
        boolean songFound = false;               
        for(int i=0;i<total;i++){             
            for(int x=0;x<5;x++){                                   
                if(a[i].issongnull(x)){
                    break;

                }
//--------------------------------------------------------------------------------------------            
                else if (a[i].getnameofsong(x).equals(name)){
                    songFound = true;    
                    System.out.println("Album name: "+a[i].getAlbumname()+" Song's name: "+a[i].getnameofsong(x)+"-"+a[i].getartistofsong(x)+"-"+a[i].getdurationofsong(x)+"-"+a[i].getgenreofsong(x)+"-"+" existed,do you wanna continue? ");
                }
            }
        }
        if(songFound){
            System.out.println("(1) YES !    (2) NO ! ");
            option = console.nextInt();
        }
        switch(option){
            case 1: System.out.println("Song's Artist: "); artist = console.next();
                    System.out.println("Song's Duration: "); duration = console.nextInt(); 
                    if(duration>MAX_TIME){
                        System.out.println("Reach Album's Max_Time "+MAX_TIME+",song can't be added!  ");
                        return;
                    }
                    for( int c=0;c<total;c++){
                        if((duration+a[c].sumDuration())>MAX_TIME){
                            System.out.println("Reach Album's Max_Time "+MAX_TIME+",song can't be added!  ");
                            return;
                        }
                    }    
                    System.out.println("Song's Genre: \n(1)Rock\n(2)Pop\n(3)Hip-pop\n(4)Bossa nova"); genrepick = console.nextInt();
                    switch(genrepick){
                        case 1: genre = "Rock";
                                break;
                        case 2: genre = "Pop" ;
                                break;
                        case 3: genre = "Hip-pop";
                                break;
                        case 4: genre = "Bossa nova";
                                break;
                        default: System.out.println("Invalid Selection.");
                                break;                   
                    }   
                    for(int i=0;i<total;i++){             
                        for(int x=0;x<5;x++){  
                            if(!a[i].issongnull(x)){
                                if(((a[i].getnameofsong(x).equals(name))&&(a[i].getartistofsong(x).equals(artist))&&(a[i].getgenreofsong(x).equals(genre)))&&(a[i].getdurationofsong(x)==duration)){
                                    System.out.println("Same Song exist: "+a[i].getAlbumname()+" Song's name: "+a[i].getnameofsong(x)+"-"+a[i].getartistofsong(x)+"-"+a[i].getdurationofsong(x)+"-"+a[i].getgenreofsong(x));
                                    System.out.println("Same song can't be added!! (2 songs are identical if name, artist, and duration are the same)");
                                    return;
                                    }
                                }
                            }
                    }  
                    if (!a[albumindex].addData(name,artist,duration,genre)){
                        System.out.println("Only allow to store 5 songs!");
                    }
                     

                    return;

            case 2:
                    break;
        }               
                           
                       
          
//------------------------------------------------------------------------------        
        if (!songFound){            
        System.out.println("Song's Artist: "); artist = console.next();
        System.out.println("Song's Duration: "); duration = console.nextInt(); 
        if(duration>MAX_TIME){
            System.out.println("Reach Album's Max_Time "+MAX_TIME+",song can't be added!  ");
            return;
        }
        for( int i=0;i<total;i++){
            if((duration+a[i].sumDuration())>MAX_TIME){
                System.out.println("Reach Album's Max_Time "+MAX_TIME+",song can't be added!  ");
                return;
            } 
        }
                System.out.println("Song's Genre: \n(1)Rock\n(2)Pop\n(3)Hip-pop\n(4)Bossa nova"); genrepick = console.nextInt();
                switch(genrepick){
                    case 1: genre = "Rock";
                            break;
                    case 2: genre = "Pop" ;
                            break;
                    case 3: genre = "Hip-pop";
                            break;
                    case 4: genre = "Bossa nova";
                            break;
                    default: System.out.println("Invalid Selection.");
                            break;                   
                } 
                         
        a[albumindex].addData(name,artist,duration,genre);  
          
        }
        
    }
//------------------------------------------------------------------------------
    public void findSongs(){
        String songname;
        System.out.println("Enter song name to search: "); songname=console.next(); 
        boolean songnameFound = false; 
        
        for(int i=0;i<total;i++){ 
            for(int x=0;x<5;x++){ 
                if(a[i].issongnull(x)){
                    return;
                }
                else if (a[i].getnameofsong(x).equals(songname)){
                songnameFound = true;    
                System.out.println("Album:"+a[i].getAlbumname()+" Song's name: "+a[i].getnameofsong(x)+"-"+a[i].getartistofsong(x)+"-"+a[i].getdurationofsong(x)+"-"+a[i].getgenreofsong(x));;
                }                
                
            }        
        } 
        if(!songnameFound){
            System.out.println("No Song Found!!!");
        }      
    }
//------------------------------------------------------------------------------    
    public void findAlbum(){
        String albumsearch;
        
        System.out.print("Enter Album's Name to search: ");
        albumsearch = console.next();
            boolean albumFound = false;
            for(int i=0;i<total;i++){
                if (a[i].getAlbumname().equals(albumsearch)){
                    albumFound = true;
                    System.out.println("****************************************************");
                    System.out.println(a[i].displayallsong());
                }
            }       
            if (!albumFound){
                System.out.println("No such album!!!");
            }        
    }
//------------------------------------------------------------------------------
    public void displaySong(){
        
        System.out.println("****************************************************");
        for(int i=0;i<total;i++){
            System.out.println("[Album]: "+a[i].getAlbumname());
            System.out.println(a[i].displayallsong());           
        }
        
    } 
//------------------------------------------------------------------------------
    public void findDuration(){
        int songduration=0;
        
        System.out.println("Enter Duration to search songs(in minutes): "); songduration=console.nextInt();
        songduration= songduration*60; // convert minutes to second.
        boolean durationFound = false;
        for(int i=0;i<total;i++){
            for(int x=0;x<5;x++){
                if(a[i].issongnull(x)){
                    break;
                }                
                if(a[i].getdurationofsong(x)<songduration){
                    durationFound = true;
                    System.out.println(a[i].getAlbumname()+": "+a[i].getnameofsong(x)+" Duration: "+a[i].getdurationofsong(x)+"(second)");
                }
            }
        }
        if(!durationFound){
            System.out.println("No song that is under: "+songduration+"second");
        }                
    } 
//------------------------------------------------------------------------------
    public void findGenre(){
        int genreoption=0;
        if (total<=0){
            System.out.println("No Album created!!");
            return;
        }
        else
            for(int i=0;i<total;i++){
                if(a[i].songindex()<=0){
                    System.out.println("No Song is stored!!");
                    return;
                }
            }
       
        System.out.println("Select Genre type to search:");
       
        System.out.println("\n(1)Rock\n(2)Pop\n(3)Hip-pop\n(4)Bossa nova "); genreoption=console.nextInt();
        
        boolean genreFound = false;
        switch(genreoption){
            case 1: 
                    for(int i=0;i<total;i++){
                        for(int x=0;x<5;x++){
                            if(a[i].issongnull(x)){
                                break;
                            }                
                            if(a[i].getgenreofsong(x).equals("Rock")){
                                genreFound = true;
                                System.out.println("[Album]:"+a[i].getAlbumname()+" [Song name]: "+a[i].getnameofsong(x)+" [artist]: "+a[i].getartistofsong(x)+" [duration]: "+a[i].getdurationofsong(x)+" [genre]: "+a[i].getgenreofsong(x));
                            }
                        }
                    }
                    if(!genreFound){
                        System.out.println("No song's type store as Rock");
                    }                
                    break;
            case 2: 
                    for(int i=0;i<total;i++){
                        for(int x=0;x<5;x++){
                            if(a[i].issongnull(x)){
                                break;
                            }                
                            if(a[i].getgenreofsong(x).equals("Pop")){
                                genreFound = true;
                                System.out.println("[Album]:"+a[i].getAlbumname()+" [Song name]: "+a[i].getnameofsong(x)+" [artist]: "+a[i].getartistofsong(x)+" [duration]: "+a[i].getdurationofsong(x)+" [genre]: "+a[i].getgenreofsong(x));
                            }
                        }
                    }
                    if(!genreFound){
                        System.out.println("No Pop type is stored.");
                    }
                    break;
            case 3: 
                    for(int i=0;i<total;i++){
                        for(int x=0;x<5;x++){
                            if(a[i].issongnull(x)){
                                break;
                            }                
                            if(a[i].getgenreofsong(x).equals("Hip-pop")){
                                genreFound = true;
                                System.out.println("[Album]:"+a[i].getAlbumname()+" [Song name]: "+a[i].getnameofsong(x)+" [artist]: "+a[i].getartistofsong(x)+" [duration]: "+a[i].getdurationofsong(x)+" [genre]: "+a[i].getgenreofsong(x));
                            }
                        }
                    }
                    if(!genreFound){
                        System.out.println("No Hip-pop type is stored.");
                    } 
                    break;
            case 4: 
                    for(int i=0;i<total;i++){
                        for(int x=0;x<5;x++){
                            if(a[i].issongnull(x)){
                                break;
                            }                
                            if(a[i].getgenreofsong(x).equals("Bossa nova")){
                                genreFound = true;
                                System.out.println("[Album]:"+a[i].getAlbumname()+" [Song name]: "+a[i].getnameofsong(x)+" [artist]: "+a[i].getartistofsong(x)+" [duration]: "+a[i].getdurationofsong(x)+" [genre]: "+a[i].getgenreofsong(x));
                            }
                        }
                    }
                    if(!genreFound){
                        System.out.println("No Bossa nova type is stored.");
                    } 
                    break;
            default: System.out.println("Invalid Selection.");
                    break;       
        }
        
        
    }
//------------------------------------------------------------------------------ 
    public void deleteAlbum(){
        int choice ;

        System.out.println("Which Album do you want to delete?");
        for(int i=0;i<total;i++){    
            System.out.println("("+i+") [Album]: "+a[i].getAlbumname());
        }
        System.out.println("["+total+"] exit");
        System.out.println("Please enter: ");
        choice = console.nextInt();
        if (choice==total){
            return;
        }          
        if(((choice<0)&&(choice>total-1))){
            System.out.println("Invalid input!\nAlbum does not exist!\n");       
        }        
        else{
            total--;
            for (int i=choice;i<total;i++){
                a[i] = a[i+1];
            } 
            a[total]=null;
        }           
    }
//------------------------------------------------------------------------------
    public void deleteSong(){
        int songdelete; 
        int picksong;
        System.out.println("****************************************************");
        for(int i=0;i<total;i++){
            System.out.println("("+i+")    "+"[Album]: "+a[i].getAlbumname());
            System.out.println(a[i].displayallsong());           
        } 
        System.out.println("["+total+"] exit");
        System.out.println("Enter the Album name to delete songs:"); songdelete = console.nextInt();
        if(songdelete==total){
            return;
        }
        else if(((songdelete<0)&&(songdelete>total-1))){
            System.out.println("Invalid input!\nAlbum does not exist!\n");       
        } 
//----------------------------------------------------------------------------------        
        else{
            System.out.println(""+a[songdelete].displayalbumsong()); 
            System.out.println("enter which song you want to delete: "); picksong = console.nextInt();
            if(picksong==a[songdelete].songindex()){
                return;
            }
            else if(((picksong<0)&&(picksong>a[songdelete].songindex()-1))){
                System.out.println("Invalid input!\nSong does not exist!\n");       
            }        
            else
                a[songdelete].deletesong(picksong);
        }
    }
//-----------------------------------------------------------------------------------        
    public void inputFile(){

        String fileName = "ReginaCollection.txt ";
        
        System.out.println("The file "+ fileName+"\ncontains following line\n");
        try{
            inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e){
        System.out.println("Error opening the file "+fileName);
        System.exit(0);
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine(); //read in line.
            if(line.contains("Album ")){
                String albumname =line.substring(6);
                a[total].addAlbumname(albumname);//add album's name.
                System.out.println("Found album: "+a[total].getAlbumname());
                total++;
            }
            else if(line.contains("Name ")){
                System.out.println("Found song : ");
                String songname = line.substring(5);
                System.out.println("name = " + songname);
                line = inputStream.nextLine();
                String songartist = line.substring(7);
                System.out.println("artist = " +songartist);
                line = inputStream.nextLine();
                int songduration = Integer.parseInt(line.substring(9));
                System.out.println("duration = " + songduration);
                line = inputStream.nextLine();
                String songgenre = line.substring(6);
                System.out.println("song genre = " + songgenre);
                System.out.println("************************************************************"); 
                 
                a[total-1].addData(songname,songartist,songduration,songgenre); //add all the song info.

            }
            
        }
        inputStream.close();        
    }
}

