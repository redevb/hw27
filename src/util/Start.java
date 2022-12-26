/*
import movie.Cast;
import movie.Movie;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Movie movie = FileService.readFile();
        List<Movie> movieList = new ArrayList<>(movie.movies);
        while (true) {
            chooseAction(movieList);
        }
    }

    public static void printMovies(List<Movie> movieList) {
        for (Movie m : movieList)
            printMovie(m);
    }

    public static void sortMoviesByName(List<Movie> movieList) {
        Collections.sort(movieList);
    }

    public static void sortMoviesByNameReverse(List<Movie> movieList) {
        Collections.sort(movieList, Comparator.reverseOrder());
    }

    public static void sortMoviesByYear(List<Movie> movieList) {
        Comparator<Movie> cmp = Comparator.comparingInt(Movie::getYear);
        movieList.sort(cmp);
    }

    public static void sortMoviesByYearReverse(List<Movie> movieList) {
        Comparator<Movie> cmp = Comparator.comparingInt(Movie::getYear);
        movieList.sort(cmp.reversed());
    }

    public static void sortMoviesByDirector(List<Movie> movieList) {
        Comparator<Movie> cmp = Comparator.comparing(Movie::getDirectorFullName);
        movieList.sort(cmp);
    }

    public static void sortMoviesByDirectorReverse(List<Movie> movieList) {
        Comparator<Movie> cmp = Comparator.comparing(Movie::getDirectorFullName);
        movieList.sort(cmp.reversed());
    }

    public static void printMovie(Movie m) {
        String fmt = String.format("Name: %s%n" +
                        "Year: %s%n" +
                        "Description: %s%n" +
                        "Director: %s%n" +
                        "Cast: %s%n",
                m.getName(),
                m.getYear(),
                m.getDescription(),
                m.getDirectorFullName(),
                Arrays.toString(m.getCast()).replace("[", "").replace("]", ""));
        System.out.println(fmt);
    }

    public static void searchByName(List<Movie> movieList) {
        System.out.print("Enter movie name: ");
        String input = new Scanner(System.in).nextLine();
        for (Movie m : movieList) {
            if (m.getName().toLowerCase().contains(input.toLowerCase())) {
                printMovie(m);
            }
        }
    }

    public static void printAction() {
        System.out.println("\nActions: \n" +
                "1 - Print all movies\n" +
                "2 - Search movie by name by full\n" +
                "3 - Sort movies by year\n" +
                "4 - Sort movies by year(reverse)\n" +
                "5 - Sort movies by name\n" +
                "6 - Sort movies by name(reverse)\n" +
                "7 - Sort movies by director\n" +
                "8 - Sort movies by director(reverse)\n" +
                "9 - Search movies by actor\n" +
                "10 - Search movies by year\n" +
                "11 - Search movies by director\n" +
                "12 - Search movies and role by actor\n" +
                "13 - List of actors, all films and roles\n");
    }

    public static void chooseAction(List<Movie> movieList) {
        String input;
        while (true) {
            printAction();
            System.out.print("Enter number: ");
            input = new Scanner(System.in).nextLine();
            try {
                checkAction(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        switch (Integer.parseInt(input)) {
            case 1:
                printMovies(movieList);
                break;
            case 2:
                searchByName(movieList);
                break;
            case 3:
                sortMoviesByYear(movieList);
                break;
            case 4:
                sortMoviesByYearReverse(movieList);
                break;
            case 5:
                sortMoviesByName(movieList);
                break;
            case 6:
                sortMoviesByNameReverse(movieList);
                break;
            case 7:
                sortMoviesByDirector(movieList);
                break;
            case 8:
                sortMoviesByDirectorReverse(movieList);
                break;
            case 9:
                searchMovieByActor(movieList);
                break;
            case 10:
                searchByYear(movieList);
                break;
            case 11:
                searchMovieByDirector(movieList);
                break;
            case 12:
                searchMovieAndRoleByActor(movieList);
                break;
            case 13:
                getActorAndRole(movieList);
                break;
        }
    }

    public static void checkAction(String input) throws Exception {
        if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 13) {
            throw new Exception("No such action");
        }
    }

    public static void searchMovieByActor(List<Movie> movieList) {
        HashMap<String, ArrayList<Movie>> actorMap = new HashMap<>();

        Set<String> actor = new HashSet<>();
        for (Movie m : movieList) {
            for (Cast c : m.getCast()) {
                actor.add(c.getFullName());
            }
        }

        for (String a : actor) {
            ArrayList<Movie> movieL = new ArrayList<Movie>();
            for (Movie m : movieList) {
                for (Cast c : m.getCast()) {
                    if (c.getFullName().toLowerCase().contains(a.toLowerCase())) {
                        movieL.add(m);
                    }
                }
            }
            actorMap.put(a, movieL);
        }

        System.out.print("Enter actor name: ");
        String input = new Scanner(System.in).nextLine();
        actorMap.get(input);
        printMovies(actorMap.get(input));
    }

    public static void searchMovieByDirector(List<Movie> movieList) {
        HashMap<String, ArrayList<Movie>> directorMap = new HashMap<>();

        Set<String> director = new HashSet<>();
        for (Movie m : movieList) {
            director.add(m.getDirectorFullName());
        }

        for (String d : director) {
            ArrayList<Movie> movieL = new ArrayList<Movie>();
            for (Movie m : movieList) {
                if (m.getDirectorFullName().toLowerCase().contains(d.toLowerCase())) {
                    movieL.add(m);
                }
            }
            directorMap.put(d, movieL);
        }

        System.out.print("Enter director name: ");
        String input = new Scanner(System.in).nextLine();
        directorMap.get(input);
        printMovies(directorMap.get(input));

    }

    public static void searchByYear(List<Movie> movieList) {
        HashMap<Integer, ArrayList<Movie>> yearMap = new HashMap<>();

        Set<Integer> years = new HashSet<>();
        for (Movie m : movieList) {
            years.add(m.getYear());
        }

        for (int y : years) {
            ArrayList<Movie> movieL = new ArrayList<Movie>();
            for (Movie m : movieList) {
                if (m.getYear() == y) {
                    movieL.add(m);
                }
            }
            yearMap.put(y, movieL);
        }

        System.out.print("Enter year: ");
        String input = new Scanner(System.in).nextLine();
        yearMap.get(Integer.parseInt(input));
        printMovies(yearMap.get(Integer.parseInt(input)));
    }

    public static void searchMovieAndRoleByActor(List<Movie> movieList) {
        System.out.print("Enter actor name: ");
        String input = new Scanner(System.in).nextLine();
        for (Movie m : movieList) {
            for (Cast c : m.getCast()) {
                if (c.getFullName().toLowerCase().contains(input.toLowerCase())) {
                    System.out.printf("Movie: %s, Role: %s%n", m.getName(), c.getRole());
                }
            }
        }
    }

    public static void getActorAndRole(List<Movie> movieList) {
        Set<Cast> actor = new HashSet<>();
        for (Movie m : movieList) {
            for (Cast c : m.getCast()) {
                actor.add(c);
            }
        }
        Comparator<Cast> cmp = Comparator.comparing(Cast::getFullName);
        List<Cast> casts = new ArrayList<>();

        for (Cast c : actor){
            casts.add(c);
        }

        casts.sort(cmp);
        for (Cast a : casts) {
            System.out.printf("Actor: %s, Role: %s%n", a.getFullName(), a.getRole());
        }
    }

}*/
