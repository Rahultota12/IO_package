import java.io.*;
import java.util.Scanner;
public class Movie_Program{
    public static void main(String[] args) throws MovieNotFoundException , IOException{
        Movie_Program mp = new Movie_Program();
        detail();
    }
        public static void detail() throws Movie_Program.MovieNotFoundException{    
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            System.out.println(" add Movies number of add :1 to 10:");
            int inter = sc1.nextInt();
            if (inter >=1 && inter <=10) {
      
        try {
        FileWriter fw = new FileWriter("save.txt");
       
    
     
    for (int i = 1; i <= inter; i++) {
        System.out.println("Enter Details for movie " + i + ":");
        System.out.print("Movie Name: ");
        String movieName = sc.nextLine();
        System.out.print("Actor Name: ");
        String actorName = sc.nextLine();
        System.out.print("Director Name: ");
        String directorName = sc.nextLine();
        System.out.print("Released Year: ");
        int releasedYear = sc.nextInt();
        sc.nextLine();
        System.out.print("Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();
        
       fw.write(" Movie Name : " + movieName +"\n Director Name : "+ directorName + "\n Actor Name : " + actorName + "\n Released Year : " + releasedYear + "\n Ratings : " + rating + "\n");
    }
       fw.close();
            System.out.println("Movie details have been saved to file.");
        
                System.out.print("Do you want to continue? (Y/N): ");
                String input = sc.nextLine();
                if(input.equals("y")){
                    main(null);
                }
                
                System.out.print(" search for movie: ");
                String searchMovie = sc.nextLine();
                File f = new File("save.txt");
                BufferedReader br = new BufferedReader(new FileReader(f));
                String row;
               boolean found = false;
    
                while ((row = br.readLine()) != null) {
                    String[] details = row.split("");
                    String MovieName = details[0];
                    if (MovieName.equals(searchMovie)) {
                        found = true;
                        String ActorName = details[1];
                        String DirectorName = details[2];
                        int ReleasedYear = Integer.parseInt(details[3]);
                        double Rating = Double.parseDouble(details[4]);
    
                        System.out.println("Movie Name: " + MovieName);
                        System.out.println("Actor Name: " + ActorName);
                        System.out.println("Director Name: " + DirectorName);
                        System.out.println("Released Year: " + ReleasedYear);
                        System.out.println("Rating: " + Rating);
                        break;
                    }
                }
        } catch(Exception e){
            System.out.println(e);
        }
    }
   
       throw new MovieNotFoundException(" Movie Not Found");
    
    }
    static class MovieNotFoundException extends Exception {
        public MovieNotFoundException(String message) {
            super(message);
        }
    }
}

