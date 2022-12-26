package implement;

import interfaces.Sortable;
import movie.Movie;
import util.FileService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CollectionOfMovies implements Sortable {
    private static final Map<String, List<Movie>> MOVIE = FileService.readFile();
    private static final List<Movie> MOVIE_LIST = MOVIE.get("movies");

    @Override
    public void sortByNameOfMovie(List<Movie> movies) {
        Comparator cmp4 = Comparator.comparing(Movie::getName);
        MOVIE_LIST.sort(cmp4);
        print("SORTED COLLECTION BY NAME IN ASCENDING ORDER:");
        System.out.println(MOVIE_LIST);

        Comparator cmp5 = Comparator.comparing(Movie::getName).reversed();
        MOVIE_LIST.sort(cmp5);
        print("SORTED COLLECTION BY NAME IN DESCENDING ORDER:");
        System.out.println(MOVIE_LIST);
    }

    @Override
    public void sortBYYearOfRelease(List<Movie> movies) {
        Comparator cmp = Comparator.comparing(Movie::getYear);
        MOVIE_LIST.sort(cmp);
        print("SORTED COLLECTION BY YEAR IN ASCENDING ORDER:");
        System.out.println(MOVIE_LIST);

        Comparator cmp1 = Comparator.comparing(Movie::getYear).reversed();
        MOVIE_LIST.sort(cmp1);
        print("SORTED COLLECTION BY YEAR IN DESCENDING ORDER:");
        System.out.println(MOVIE_LIST);
    }

    @Override
    public void sortByDirector(List<Movie> movies) {
        Comparator cmp2 = Comparator.comparing(Movie::getDirectorFullName);
        MOVIE_LIST.sort(cmp2);
        print("SORTED COLLECTION BY DIRECTOR IN ASCENDING ORDER:");
        System.out.println(MOVIE_LIST);

        Comparator cmp3 = Comparator.comparing(Movie::getDirectorFullName).reversed();
        MOVIE_LIST.sort(cmp3);
        print("SORTED COLLECTION BY DIRECTOR IN DESCENDING ORDER:");
        System.out.println(MOVIE_LIST);
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
