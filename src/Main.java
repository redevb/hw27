import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Map<String, List<Movie>> movieList = FileService.readFile();
        List<Movie> movie = movieList.get("movies");
        ArrayList<Movie> movie1 = new ArrayList<>(movie);
        while (true) {
            chooseAction(movie1);
        }
    }

    public static void printMovies(List<Movie> movie1) {
        for (Movie m : movie1)
            printMovie(m);
    }

    public static void sortMoviesByName(List<Movie> movie) {
        Comparator<Movie> cmp = Comparator.comparing(Movie::getName);
        movie.sort(cmp);
        print("SORTED COLLECTION BY NAME IN ASCENDING ORDER:");
        for (Movie m : movie) {
            System.out.println(m);
        }
    }

    public static void sortMoviesByNameReverse(List<Movie> movie) {
        Comparator<Movie> cmp = Comparator.comparing(Movie::getName);
        movie.sort(cmp.reversed());
        print("SORTED COLLECTION BY NAME IN DESCENDING ORDER:");
        for (Movie m : movie) {
            System.out.println(m);
        }
    }

    public static void sortMoviesByYear(List<Movie> movie) {
        Comparator<Movie> cmp = Comparator.comparingInt(Movie::getYear);
        movie.sort(cmp);
        print("SORTED COLLECTION BY YEAR IN ASCENDING ORDER:");
        for (Movie m : movie) {
            System.out.println(m);
        }
    }

    public static void sortMoviesByYearReverse(List<Movie> movie) {
        Comparator<Movie> cmp = Comparator.comparingInt(Movie::getYear);
        movie.sort(cmp.reversed());
        print("SORTED COLLECTION BY YEAR IN DESCENDING ORDER:");
        for (Movie m : movie) {
            System.out.println(m);
        }
    }

    public static void sortMoviesByDirector(List<Movie> movie) {
        movie.sort(Movie::compareTo);
        print("SORTED COLLECTION BY DIRECTOR IN ASCENDING ORDER:");
        for (Movie m : movie) {
            System.out.println(m);
        }
    }

    public static void sortMoviesByDirectorReverse(List<Movie> movie) {
        Comparator<Movie> cmp = Comparator.comparing(Movie::getDirectorName);
        movie.sort(cmp.reversed());
        print("SORTED COLLECTION BY DIRECTOR IN DESCENDING ORDER:");
        for (Movie m : movie) {
            System.out.println(m);
        }
    }

    public static void printMovie(Movie m) {
        String fmt = String.format("Name: %s%n" +
                        "Year: %s%n" +
                        "Description: %s%n" +
                        "Director: %s%n" +
                        "Cast of the '%s':%n %s%n",
                m.getName(),
                m.getYear(),
                m.getDescription(),
                m.getDirectorName(),
                m.getName(),
                Arrays.toString(m.getCast()).replace("[", "").replace("]", ""));
        print(fmt);
    }

    public static void searchByName(List<Movie> movie1) {
        print("Enter a movie name: ");
        String input = new Scanner(System.in).nextLine();
        for (Movie m : movie1) {
            if (m.getName().toLowerCase().contains(input.toLowerCase())) {
                printMovie(m);
            }
        }
    }

    public static void printAction() {
        print("[ 1 ] - Print all movies\n" +
                "[ 2 ] - Search movie by name by full\n" +
                "[ 3 ] - Sort movies by year\n" +
                "[ 4 ] - Sort movies by year in reversed order\n" +
                "[ 5 ] - Sort movies by name\n" +
                "[ 6 ] - Sort movies by name in reversed order\n" +
                "[ 7 ] - Sort movies by director\n" +
                "[ 8 ] - Sort movies by director in reversed order\n" +
                "[ 9 ] - Search movies by actor\n" +
                "[ 10 ] - Search movies by year\n" +
                "[ 11 ] - Search movies by director\n" +
                "[ 12 ] - Search movies and role by actor\n" +
                "[ 13 ] - List of actors, all films and roles\n");
    }

    public static void chooseAction(List<Movie> movie1) {
        String input;
        while (true) {
            printAction();
            print("Choose an action : ");
            input = new Scanner(System.in).nextLine();
            try {
                checkAction(input);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        switch (Integer.parseInt(input)) {
            case 1:
                printMovies(movie1);
                break;
            case 2:
                searchByName(movie1);
                break;
            case 3:
                sortMoviesByYear(movie1);
                break;
            case 4:
                sortMoviesByYearReverse(movie1);
                break;
            case 5:
                sortMoviesByName(movie1);
                break;
            case 6:
                sortMoviesByNameReverse(movie1);
                break;
            case 7:
                sortMoviesByDirector(movie1);
                break;
            case 8:
                sortMoviesByDirectorReverse(movie1);
                break;
            case 9:
                searchMovieByActor(movie1);
                break;
            case 10:
                searchByYear(movie1);
                break;
            case 11:
                searchMovieByDirector(movie1);
                break;
            case 12:
                searchMovieAndRoleByActor(movie1);
                break;
            case 13:
                getActorAndRole(movie1);
                break;
        }
    }

    public static void checkAction(String input) throws Exception {
        if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 13) {
            throw new Exception("No such action. Please Try again");
        }
    }

    public static void searchMovieByActor(List<Movie> movie1) {
        HashMap<String, ArrayList<Movie>> actorMap = new HashMap<>();

        Set<String> actor = new HashSet<>();
        for (Movie m : movie1) {
            for (Cast c : m.getCast()) {
                actor.add(c.getFullName());
            }
        }

        for (String a : actor) {
            ArrayList<Movie> movieL = new ArrayList<Movie>();
            for (Movie m : movie1) {
                for (Cast c : m.getCast()) {
                    if (c.getFullName().toLowerCase().contains(a.toLowerCase())) {
                        movieL.add(m);
                    }
                }
            }
            actorMap.put(a, movieL);
        }
        print("Enter an actor name: ");
        while (true) {
            try {
                String input = new Scanner(System.in).nextLine();
                actorMap.get(input);
                printMovies(actorMap.get(input));
                break;
            } catch (NullPointerException e) {
                print("No Such Actor, Please Enter Full Name In Correct Way");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                print("Don't Write Numbers, Please Enter Full Name In Correct Way");
                e.printStackTrace();
            }
        }
    }

    public static void searchMovieByDirector(List<Movie> movie1) {
        HashMap<String, ArrayList<Movie>> directorMap = new HashMap<>();

        Set<String> director = new HashSet<>();
        for (Movie m : movie1) {
            director.add(m.getDirectorName());
        }

        for (String d : director) {
            ArrayList<Movie> movieL = new ArrayList<Movie>();
            for (Movie m : movie1) {
                if (m.getDirectorName().toLowerCase().contains(d.toLowerCase())) {
                    movieL.add(m);
                }
            }
            directorMap.put(d, movieL);
        }
        print("Enter a director name: ");
        while (true) {
            try {
                String input = new Scanner(System.in).nextLine();
                directorMap.get(input);
                printMovies(directorMap.get(input));
                break;
            } catch (NullPointerException e) {
                print("No Such Movie For This Specified Director, Please Write Director's Name In Correct Way");
                e.printStackTrace();
            }
        }
    }

    public static void searchByYear(List<Movie> movie1) {
        HashMap<Integer, ArrayList<Movie>> yearMap = new HashMap<>();

        Set<Integer> years = new HashSet<>();
        for (Movie m : movie1) {
            years.add(m.getYear());
        }

        for (int y : years) {
            ArrayList<Movie> movieL = new ArrayList<Movie>();
            for (Movie m : movie1) {
                if (m.getYear() == y) {
                    movieL.add(m);
                }
            }
            yearMap.put(y, movieL);
        }
        print("Enter a year of the movie: ");
        while (true) {
            try {
                String input = new Scanner(System.in).nextLine();
                yearMap.get(Integer.parseInt(input));
                printMovies(yearMap.get(Integer.parseInt(input)));
                break;
            } catch (NullPointerException | NumberFormatException e) {
                print("No Such Movie For This Specified Year, Please Enter Year Of The Movie In Correct Way");
                e.printStackTrace();
            }
        }
    }

    public static void searchMovieAndRoleByActor(List<Movie> movie1) {
        System.out.print("Enter actor name: ");
        String input = new Scanner(System.in).nextLine();
        for (Movie m : movie1) {
            for (Cast c : m.getCast()) {
                if (c.getFullName().toLowerCase().contains(input.toLowerCase())) {
                    System.out.printf("Movie: %s, Role: %s%n", m.getName(), c.getRole());
                }
            }
        }
    }

    public static void getActorAndRole(List<Movie> movie1) {
        Set<Cast> actor = new HashSet<>();
        for (Movie m : movie1) {
            for (Cast c : m.getCast()) {
                actor.add(c);
            }
        }
        Comparator<Cast> cmp = Comparator.comparing(Cast::getFullName);
        List<Cast> casts = new ArrayList<>();

        for (Cast c : actor) {
            casts.add(c);
        }
        casts.sort(cmp);
        for (Cast a : casts) {
            System.out.printf("Actor: %s, Role: %s%n", a.getFullName(), a.getRole());
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }
}