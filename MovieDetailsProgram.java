import java.util.HashMap;
import java.util.Map;

// Custom exception for movie not found
class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message) {
        super(message);
    }
}

// Movie class to store movie details
class Movie {
    private String actor;
    private String director;
    private double rating;
    private String releaseDate;

    public Movie(String actor, String director, double rating, String releaseDate) {
        this.actor = actor;
        this.director = director;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    // Getters and setters
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // toString method to display movie details
    @Override
    public String toString() {
        return "Movie Details: " +
                "\nActor: " + actor +
                "\nDirector: " + director +
                "\nRating: " + rating +
                "\nRelease Date: " + releaseDate;
    }
}

// MovieStore class to store movie details and perform operations
class MovieStore {
    private Map<String, Movie> movieMap;

    public MovieStore() {
        movieMap = new HashMap<>();
    }

    // Add movie details to the movie store
    public void addMovie(String movieName, Movie movie) {
        movieMap.put(movieName, movie);
    }

    // Retrieve movie details by movie name
    public Movie getMovie(String movieName) throws MovieNotFoundException {
        if (movieMap.containsKey(movieName)) {
            return movieMap.get(movieName);
        } else {
            throw new MovieNotFoundException("Movie not found in the store!");
        }
    }
}

// Main class to run the program
public class MovieDetailsProgram {
    public static void main(String[] args) {
        // Create movie store
        MovieStore movieStore = new MovieStore();

        // Add movies to the movie store
        movieStore.addMovie("Movie1", new Movie("Actor1", "Director1", 7.5, "01/01/2020"));
        movieStore.addMovie("Movie2", new Movie("Actor2", "Director2", 8.2, "02/02/2021"));
        movieStore.addMovie("Movie3", new Movie("Actor3", "Director3", 6.9, "03/03/2019"));

        try {
            // Retrieve movie details by movie name
            Movie movie1 = movieStore.getMovie("Movie1");
            System.out.println(movie1);

            Movie movie4 = movieStore.getMovie("Movie4"); // Throw custom exception for movie not found
        } catch (MovieNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
