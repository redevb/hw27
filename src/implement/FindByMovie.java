/*
package implement;

import interfaces.Findable;
import movie.Cast;
import movie.Movie;
import util.FileService;

import java.util.*;

public class FindByMovie implements Findable {
    private static final Scanner SC = new Scanner(System.in);
    private static final List<Movie> MOVIES = new ArrayList<>();
    @Override
    public List<Movie> getAllMovies(List<Movie> movieList) {
        print("******* All Movies *******");
        Map<String, List<Movie>> movie = FileService.getMovies();
        List<Movie>movies = movie.get("movies");
        return movies;
    }

    @Override
    public void findMovieByFull(List<Movie> movieList) {
        print("Write movie's name ");
        String input = new Scanner(System.in).nextLine();
        for (Movie m : movieList) {
            if (m.getName().toLowerCase().contains(input.toLowerCase())) {
                printMovie(m);
            }
        }
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

    @Override
    public void findMovieByActorName(List<Movie> movieList) {
        HashMap<String, ArrayList<Movie>> actorMap = new HashMap<>();

        Set<String> actor = new HashSet<>();
        for (Movie movie : movieList){
            for (Cast cast : movie.getCast()) {
                actor.add(cast.getFullName());
            }
        }

        for (String s : actor) {
            ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
            for (Movie movie : movieList) {
                for (Cast cast : movie.getCast()) {
                    if (cast.getFullName().toLowerCase().contains(s.toLowerCase())) {
                        movieArrayList.add(movie);
                    }
                }
            }
            actorMap.put(s, movieArrayList);
        }
        print("Enter an actor name: ");
        String input = new Scanner(System.in).nextLine();
        actorMap.get(input);
        getAllMovies(actorMap.get(input));
    }

    */
/*@Override
    public void findMovieByActorName(List<Movie> movies) {
        Map<Cast, Set<Movie>> map =  new HashMap<>();
        Set<Cast> casts = new HashSet<>();
        MOVIES.forEach(e -> casts.addAll(e.getCasts()));
        casts.forEach(e -> map.put(e, new HashSet<>());
        MOVIES.forEach(e -> e.getCasts().forEach(e -> map.get(e).add(e)));
        map.forEach((cast, movies1) -> print(cast.));

        *//*
 */
/*Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int a = 0;
        String name;
        System.out.print("Enter a name of actor: ");
        while (a < 5){
            a++;
            name = scanner.next();
            List<Movie>actor=new ArrayList<>();
            for (Movie movie : movies) {
                for (Cast casts : movie.getCasts()) {
                    if (casts.getActorName().equalsIgnoreCase(name) || casts.getActorSurname().equalsIgnoreCase(name)){
                        System.out.println("\nActor: " + casts.getActorName() + " " + casts.getActorSurname());
                        actor.add(movie);
                        System.out.println(movie);
                        counter++;
                    }
                }actor.forEach(System.out::println);
            }
            if (counter > 0){
                break;
            } else {
                System.out.print("Couldn't find any actor by name: " + name + "Try another name: ");
            }
        }
        if (a == 5){
            System.out.println("Try again later!");
        }*//*
 */
/*
 *//*
 */
/*List<Movie>actor=new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCasts().get(0).getFullName().contains(act)){
                actor.add(movie);}
        }actor.forEach(System.out::println);*//*
 */
/*
    }*//*

    @Override
    public void findMovieByDirector(List<Movie> movieList) {
        HashMap<String, ArrayList<Movie>> directorMap = new HashMap<>();
        Set<String> director = new HashSet<>();
        for (Movie movie : movieList) {
            director.add(movie.getDirectorFullName());
        }
        for (String dir : director){
            ArrayList<Movie> movieArrayList = new ArrayList<>();
            for (Movie movie : movieList) {
                if (movie.getDirectorFullName().toLowerCase().contains(dir.toLowerCase())){
                    movieArrayList.add(movie);
                }
            }
            directorMap.put(dir, movieArrayList);
        }

        print("Write director's name");
        String input = new Scanner(System.in).nextLine();
        directorMap.get(input);
        getAllMovies(directorMap.get(input));

    }
    @Override
    public void findMovieByYear(List<Movie> movieList) {
        HashMap<Integer, ArrayList<Movie>> yearMap = new HashMap<>();
        Set<Integer> years = new HashSet<>();
        for (Movie movie : movieList) {
            years.add(movie.getYear());
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

        print("Write movie's year ");
        String input = new Scanner(System.in).nextLine();
        yearMap.get(Integer.parseInt(input));
        getAllMovies(yearMap.get(Integer.parseInt(input)));
    }

    private void print(String s) {
        System.out.println(s);
    }

    @Override
    public void findMovieAndRoleByActor(List<Movie> movieList) {
        //int i=0;
        print("Write actor's name");
        String input = new Scanner(System.in).nextLine();
        for (Movie m : movieList) {
            for (Cast c : m.getCast()) {
                if (c.getFullName().toLowerCase().contains(input.toLowerCase())) {
                    System.out.printf("Movie: %s, Role: %s%n", m.getName(), c.getRole());
                }
            }
        }
 */
/*System.out.println("***************"+
                " \n         Actor: "+name+
                "\n***************");

        System.out.print("Movie: "+movName.get(i).getName());
        System.out.println(" "+movName.get(i+1).getName());

        System.out.print(role.get(i).getCasts().get(i));
        System.out.println(role.get(i+1).getCasts().get(i));*//*

    }
    @Override
    public void getActorAndRole(List<Movie> movieList) {
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
