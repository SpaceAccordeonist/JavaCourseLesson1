package ru.spaceaccordeonist.task17_12;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsoupParser {
    public static final String SRC_URL = "https://www.moscowmap.ru/metro.html#lines";
    public static final String OUTPUT_DIR = "out_json";
    public static final String OUTPUT_FILE = "out.json";
    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(SRC_URL).maxBodySize(0).get();
            doc.select("span.t-metrostation-list-header").forEach(element -> {
                Line tempLine = new Line(element.text(),
                        element.attr("data-line"));
                lines.add(tempLine);

                doc.select("div.t-metrostation-list-table[data-line=\""
                        + element.attr("data-line") + "\"] > p > a > span.name").forEach(
                                station -> tempLine.addStation(new Station(station.text(), tempLine.getNumber())));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputObject outputObject = new OutputObject();
        outputObject.addLines(lines);
        lines.forEach(line -> {
            ArrayList<String> names = new ArrayList<>();
            line.getStations().forEach(station -> names.add(station.getName()));
            outputObject.addStations(line.getNumber(), names);
        });
        String output =  new GsonBuilder()
                .setPrettyPrinting()
                .create().toJson(outputObject);

        if(Files.exists(Paths.get(OUTPUT_DIR))) {
            try (FileWriter os =
                         new FileWriter(Path.of(OUTPUT_DIR + "/" + OUTPUT_FILE).toFile(), false)) {
                os.append(output);
            } catch (IOException | InvalidPathException e) {
                System.out.println("Saving error!");
            }
            OutputObject gettedFromFile = new OutputObject();
            try (FileReader is =
                         new FileReader(Path.of(OUTPUT_DIR + "/" + OUTPUT_FILE).toFile())) {
                gettedFromFile = new Gson().fromJson(is, OutputObject.class);
            } catch (IOException | InvalidPathException e) {
                System.out.println("Extracting error!");
            }
            for (Line line: gettedFromFile.getLines()){
                System.out.printf("%s %s - количество станицй: %d\n",
                        line.getNumber(),
                        line.getName(),
                        gettedFromFile.getStations().get(line.getNumber()).size());
            }
        }
    }
}
