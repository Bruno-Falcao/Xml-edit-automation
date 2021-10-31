package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        //I'm sorry about the variables names
        // reads the directory url
        Path pathDoItalo = Paths.get("directoryUrl");
        List<String> italo = new ArrayList<>();

        try {
            Stream<Path> subPath = Files.walk(pathDoItalo);
            subPath.forEach(c -> {
                italo.add(c.toString());
            });
            //needed to remove first index because it's not a file name
            italo.remove(0);
            italo.forEach(reis -> {
                try {
                    Path path = Paths.get(reis);
                    String data = new String(Files.readAllBytes(path));
                    //replacing the strings
                    data = data.replace("utf-16", "utf-8");
                    data = data.replace("http:www", "http://www");


                    BufferedWriter johnEscrevennon = new BufferedWriter(new FileWriter(reis));
                    johnEscrevennon.write(data);
                    johnEscrevennon.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
