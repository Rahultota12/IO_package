import java.io.*;
import java.util.Scanner;
public class Movie_progra {
    public static void main(String[] args) throws MovieNotFoundException, IOException {
        detail();
    }
    public static void detail() throws MovieNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Add movies (number of movies to add: 1 to 10):");
        int Enter = sc1.nextInt();
        if (Enter >= 1 && Enter <= 10) {

/*=========================File Writer  Part in program ==================================================================*/            
            try {
                FileWriter fw = new FileWriter("save.txt");
                for (int i = 1; i <= Enter; i++) {
                    System.out.println("Enter details for movie " + i + ":"); 
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
            fw.write("Movie Name: " + movieName + "\nActor Name: "+ actorName +
                       "\nDirector Name: " + directorName + "\nReleased Year: " + releasedYear + "\nRating: " + rating + "\n");
                }
                fw.close();
                System.out.println("Movie details have been saved to file.");
                System.out.print("Do you want to continue? (Y/N): ");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    main(null);
                }
                System.out.print("Search for movie: ");
                String searchMovie = sc.nextLine();
                File f = new File("save.txt");
                BufferedReader br = new BufferedReader(new FileReader(f));
                String row;
                boolean found = false;
           
    /*===============================File Reader part in program======================================================== */            
                
                while ((row = br.readLine()) != null) {
                    String[] details = row.split(": ");
                    String movieName = details[1];
                    if (movieName.equalsIgnoreCase(searchMovie)) {
                        found = true;
                        String actorName = br.readLine().split(": ")[1];
                        String directorName = br.readLine().split(": ")[1];
                        int releasedYear = Integer.parseInt(br.readLine().split(": ")[1]);
                        double rating = Double.parseDouble(br.readLine().split(": ")[1]);

           /*================================OutPut part in program===================================================== */

                        System.out.println("Movie Name: " + movieName);
                        System.out.println("Actor Name: " + actorName);
                        System.out.println("Director Name: " + directorName);
                        System.out.println("Released Year: " + releasedYear);
                        System.out.println("Rating: " + rating);
                        break;
                    }
                }
    
     /*=====================================Exception Part in program ====================================*/

                if (!found) {
                    throw new MovieNotFoundException("Movie Not Found");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }
    static class MovieNotFoundException extends Exception {
        public MovieNotFoundException(String message) {
            super(message);
        }
    }
}
