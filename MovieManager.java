import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
class Movie {
    private String name;
    private String description;
    private String actor;
    private String director;
    private double rating;
    private String releaseDate;

    public Movie(String name, String description, String actor, String director, double rating, String releaseDate) {
        this.name = name;
        this.description = description;
        this.actor = actor;
        this.director = director;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Actor: " + actor + "\n" +
                "Director: " + director + "\n" +
                "Rating: " + rating + "\n" +
                "Release Date: " + releaseDate;
    }

    public String getActor() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public String getRating() {
        return null;
    }

    public String getReleaseDate() {
        return null;
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie name: ");
        String name = scanner.nextLine();
        System.out.print("Enter movie description: ");
        String description = scanner.nextLine();
        System.out.print("Enter actor name: ");
        String actor = scanner.nextLine();
        System.out.print("Enter director name: ");
        String director = scanner.nextLine();
        System.out.print("Enter movie rating: ");
        double rating = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter release date: ");
        String releaseDate = scanner.nextLine();

        Movie movie = new Movie(name, description, actor, director, rating, releaseDate);

        try {
            FileWriter writer = new FileWriter("movies.txt", true);
            writer.write(movie.getName() + "," +
                         movie.getDescription() + "," +
                         movie.getActor() + "," +
                         movie.getActor() + "," +
                         movie.getRating() + "," +
                         movie.getReleaseDate() + "\n");
            writer.close();
            System.out.println("Movie details saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving movie details.");
            e.printStackTrace();
        }

        System.out.print("Enter movie name to search: ");
        String searchName = scanner.nextLine();

        try {
            Movie foundMovie = findMovieByName(searchName);
            System.out.println(foundMovie);
        } catch (MovieNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Movie findMovieByName(String name) throws MovieNotFoundException {
        try (Scanner scanner = new Scanner(MovieManager.class.getResourceAsStream("movies.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(name)) {
                    return new Movie(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new MovieNotFoundException("Movie not found: " + name);
    }
}
