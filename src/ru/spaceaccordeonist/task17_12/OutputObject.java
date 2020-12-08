package ru.spaceaccordeonist.task17_12;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputObject {
    private HashMap<String ,ArrayList<String>> stations = new HashMap<>();
    private ArrayList<Line> lines = new ArrayList<>();

    public void addLines(ArrayList<Line> lines){
        this.lines.addAll(lines);
    }
    public void addStations(String line,ArrayList<String> stations){
        this.stations.put(line, stations);
    }

    public HashMap<String, ArrayList<String>> getStations() {
        return stations;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}
