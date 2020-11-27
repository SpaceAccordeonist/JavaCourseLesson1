package ru.spaceaccordeonist.task_17_12;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Line {
    private String number;
    private String name;

    transient private ArrayList<Station> stations = new ArrayList<>();

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStation(Station station){
        stations.add(station);
    }
}
