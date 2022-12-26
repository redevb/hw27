import java.util.Arrays;

public class Movie implements Comparable<Movie> {
    String name;
    int year;
    String description;
    Director director;
    Cast[] cast;

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public String getDirectorName() {
        return director.getFullName();
    }

    public Cast[] getCast() {
        return cast;
    }

    @Override
    public int compareTo(Movie nameDirector) {
        return this.getDirector().getFullName().compareTo(nameDirector.getDirector().getFullName());
    }

    @Override
    public String toString() {
        String str = String.format("Name: %s%n" +
                        "Year: %s%n" +
                        "Description: %s%n" +
                        "Director: %s%n" +
                        "Cast of the '%s':%n %s%n",
                name,
                year,
                description,
                director,
                name,
                Arrays.toString(cast).replace("[", "").replace("]", ""));
        return str;
    }
}