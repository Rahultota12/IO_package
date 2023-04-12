import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
class Movie {
    private String actor;
    private String director;
    private int rilesDate;
    private double rating;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public int getRilesDate() {
        return rilesDate;
    }

    public void setRilesDate(int rilesDate) {
        this.rilesDate = rilesDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

public class MovieDetails {
    public static void main(String[] args) {
        Map<String, Movie> movieMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String movieName;
        boolean continueFlag = true;

        while (continueFlag) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Add Movie Details");
            System.out.println("2. Retrieve Movie Details");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
               
 //======================================= Add Movie Details==============================================================================
                    case 1:
                    Movie movie = new Movie();
                    System.out.println("Enter Movie Name:");
                    movieName = sc.next();
                    System.out.println("Enter Actor:");
                    movie.setActor(sc.next());
                    System.out.println("Enter Director:");
                    movie.setDirector(sc.next());
                    System.out.println("Enter Riles Date:");
                    movie.setRilesDate(sc.nextInt());
                    System.out.println("Enter Rating:");
                    movie.setRating(sc.nextDouble());
                    movieMap.put(movieName, movie);
                    System.out.println("Movie details added successfully!");
                    break;
                
/*========================================Movies Detials show========================================================================= */  
                case 2:
                    System.out.println("Enter Movie Name:");
                    movieName = sc.next();
                    if (movieMap.containsKey(movieName)) {
                        Movie retrievedMovie = movieMap.get(movieName);
                        System.out.println("Movie Name: " + movieName);
                        System.out.println("Actor: " + retrievedMovie.getActor());
                        System.out.println("Director: " + retrievedMovie.getDirector());
                        System.out.println("Riles Sun: " + retrievedMovie.getRilesDate());
                        System.out.println("Rating: " + retrievedMovie.getRating());
                    } 
                    else {
                        System.out.println("Movie not found.");
                    }
                    break;
               
//================================================= Exit=====================================================================================
                    case 3:
                    continueFlag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

