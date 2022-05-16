package com.letscode.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Oscar {
    public static void main(String args[]) {

        Path pathFemale = Paths.get("list_female.txt");
        Path pathMale = Paths.get("list_male.txt");
        List<Listagem> listFemale = ReadFiles(pathFemale);
        List<Listagem> listMale = ReadFiles(pathMale);
        System.out.println("Atriz que foi mais vezes premiada: " + AtrizMaisPremiada(listFemale));
        System.out.println("Ator mais jovem a ganhar um Oscar: " + AtorMaisJovemGanharOscar(listMale));
        System.out.println("Qual atriz entre 20 e 30 anos que mais vezes foi vencedora? " + AtrizEntreVinteTrinta(listFemale));

    }

    private static List<Listagem> ReadFiles(Path atores) {
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(atores)))) {
            List<Listagem> list = new ArrayList<Listagem>();
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vect = line.split(";");
                int id = Integer.parseInt(vect[0].trim());
                int year = Integer.parseInt(vect[1].trim());
                int age = Integer.parseInt(vect[2].trim());
                String name = vect[3].trim();
                String movie = vect[4].trim();
                Listagem lista = new Listagem(id, year, age, name, movie);
                list.add(lista);


                line = br.readLine();
            }
            return list;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static String AtrizMaisPremiada(List<Listagem> atriz) {
        return atriz.stream()
                .collect(groupingBy(Listagem::getName, counting()))
                .entrySet()
                .stream().max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                .get()
                .getKey();
    }

    public static String AtorMaisJovemGanharOscar(List<Listagem> ator) {
        return ator.stream()
                .min(Comparator.comparingInt(Listagem::getAge))
                .get().getName();
    }

    public static String AtrizEntreVinteTrinta(List<Listagem> jovem) {
        return
                jovem.stream()
                        .filter(listFemale -> listFemale.getAge() > 20 && listFemale.getAge() < 30)
                        .collect(groupingBy(Listagem::getName, counting()))
                        .entrySet()
                        .stream().max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                        .get()
                        .getKey();
    }

}










