package interfaces;

import movie.Movie;

import java.util.List;

public interface Sortable {
    void sortByNameOfMovie(List<Movie> movies);

    void sortBYYearOfRelease(List<Movie> movies);

    void sortByDirector(List<Movie> movies);
}
