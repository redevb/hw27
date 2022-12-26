import java.util.Arrays;

public class Movies {
    Movie[] movies;

    public Movie[] getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movies=" + Arrays.toString(movies) +
                '}';
    }
}
