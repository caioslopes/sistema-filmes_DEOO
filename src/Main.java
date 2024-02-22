import Dao.*;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Dao
        MovieDao movieDao = MovieDaoImpl.getInstance();
        DirectorDao directorDao = DirectorDaoImpl.getInstance();
        ActorDao actorDao = ActorDaoImpl.getInstance();

        //New Movie
        Movie movie;
        String title;
        Director director;
        int releaseYear;
        int ranking;
        List<Actor> cast;

        //New Director or Actor;
        Actor actor;
        String name;
        int yearOfBirth;

        //Menu option
        int option;

        int index;

        do {
            System.out.println("*** Filmes ***");
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Listar filmes");
            System.out.println("3 - Listar diretores");
            System.out.println("4 - Listar atores");
            System.out.println("5 - Listar filmes de um diretor");
            System.out.println("6 - Listar filmes de um ator");
            System.out.println("7 - Listar filmes por nota");
            System.out.println("0 - Encerrar programa");
            System.out.println("Selecione uma opção");
            option = scanner.nextInt();
            scanner.nextLine(); //Buffer

            switch (option){
                case 1:
                    System.out.println("Cadastrar Filme");
                    System.out.println("Insira o titulo do filmes:");
                    title = scanner.nextLine();
                    System.out.println("Insira o nome do diretor filme:");
                    director = new Director(scanner.nextLine());
                    System.out.println("Insira o ano de lançamento do filme:");
                    releaseYear = scanner.nextInt();
                    System.out.println("Insira a nota (de 1 a 5) do filme:");
                    ranking = scanner.nextInt();
                    cast = new ArrayList<>();
                    do {
                        scanner.nextLine(); //Buffer
                        System.out.println("Insira o nome do ator:");
                        name = scanner.nextLine();
                        System.out.println("Insira o ano de nascimento do ator <" + name + ">:");
                        yearOfBirth = scanner.nextInt();
                        actor = new Actor(name, yearOfBirth);
                        actorDao.insertActor(actor);
                        cast.add(actor);
                        System.out.println("Digite 0 para finalizar ou 1 para continuar");
                    }while(scanner.nextInt() != 0);
                    movie = new Movie(title, director, cast, releaseYear, ranking);
                    movieDao.insertMovie(movie);
                    directorDao.insertDirector(director);
                    break;
                case 2:
                    System.out.println("Filmes cadastrados no sistema");
                    for(Movie m : movieDao.getAllMovies()){
                        System.out.println(m.getTitle());
                        System.out.println(m.getDirector().getName());
                        System.out.println(m.getReleaseYear());
                        System.out.println(m.getRanking());
                        for(Actor a : m.getCast()){
                            System.out.println(a.getName());
                            System.out.println(a.getYearOfBirth());
                        }
                    }
                    break;
                case 3:
                    index = 1;
                    System.out.println("Diretores");
                    for(Director d : directorDao.getAllDirectors()){
                        System.out.println(index + " - " + d.getName());
                        index+=1;
                    }
                    break;
                case 4:
                    index = 1;
                    System.out.println("Atores");
                    for(Actor a : actorDao.getAllActors()){
                        System.out.println(index + " - " + a.getName());
                        index+=1;
                    }
                    break;
                case 5:
                    System.out.println("Digite o nome do diretor:");
                    name = scanner.nextLine();
                    for(Movie m : movieDao.getAllMovies()){
                        if(m.getDirector().getName().equals(name)){
                            System.out.println("Filme: " + m.getTitle());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do ator:");
                    name = scanner.nextLine();
                    for(Movie m : movieDao.getAllMovies()){
                        for(Actor a : m.getCast()){
                            if(a.getName().equals(name)){
                                System.out.println("Filme: " + m.getTitle());
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Digite a nota:");
                    ranking = scanner.nextInt();
                    for(Movie m : movieDao.getAllMovies()){
                        if(m.getRanking() >= ranking){
                            System.out.println("Filme: " + m.getTitle() + " Nota: " + m.getRanking());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
            }

        }while(option != 0);

    }

}
