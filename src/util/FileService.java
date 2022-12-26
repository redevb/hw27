package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import movie.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("data/movies.json");

    public static Map<String, List<Movie>> getMovies() {
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            System.out.println("\nFile not found " + e.getMessage());
        }
        return GSON.fromJson(json, new TypeToken<Map<String, List<Movie>>>() {
        }.getType());
    }

    public static void writeFile(Movie movie) {
        String json = GSON.toJson(movie);
        try {
            byte[] arr = json.getBytes();
            Files.write(PATH, arr);
        } catch (IOException e) {
            System.out.println("\nFile not found " + e.getMessage());
        }
    }
}

