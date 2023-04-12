import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message) {
        super(message);
    }
}

public class MoviesDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "movies.txt";
        Map<String, String[]> movieDetails = new HashMap<>();

        // Read existing movie details from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String[] details = {tokens[1], tokens[2], tokens[3], tokens[4]};
                movieDetails.put(tokens[0], details);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Check if movie details have already been entered
        if (movieDetails.size() == 0) {
            System.out.println("No movie details found. Please enter details for 10 movies.");
            for (int i = 1; i <= 10; i++) {
                System.out.println("Enter details for Movie " + i + ":");
                System.out.print("Movie name: ");
                String name = scanner.nextLine();
                System.out.print("Actor name: ");
                String actor = scanner.nextLine();
                System.out.print("Director name: ");
                String director = scanner.nextLine();
                System.out.print("Rating: ");
                String rating = scanner.nextLine();
                System.out.print("Release date: ");
                String releaseDate = scanner.nextLine();
                String[] details = {actor, director, rating, releaseDate};
                movieDetails.put(name, details);
            }

            // Write movie details to file
            try (FileWriter writer = new FileWriter(fileName)) {
                for (Map.Entry<String, String[]> entry : movieDetails.entrySet()) {
                    String nameKey = entry.getKey();
                    String[] detailsValue = entry.getValue();
                    String line = nameKey + "," + String.join(",", detailsValue) + "\n";
                    writer.write(line);
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }

        // Get movie details for user-specified movie name
        System.out.print("Enter movie name to view details: ");
        String searchName = scanner.nextLine();
        try {
            String[] detailsFound = movieDetails.get(searchName);
            if (detailsFound == null) {
                throw new MovieNotFoundException("Movie not found in database.");
            }
            System.out.println("Movie Name: " + searchName);
            System.out.println("Actor: " + detailsFound[0]);
            System.out.println("Director: " + detailsFound[1]);
            System.out.println("Rating: " + detailsFound[2]);
            System.out.println("Release date: " + detailsFound[3]);
        } catch (MovieNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
