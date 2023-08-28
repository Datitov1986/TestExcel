package org.example.classes;

public class Counter {
    private String name;
    private double data;

    public Counter() {
    }

    public Counter(String name) {
        this.name = name;
    }

    public Counter(String name, double data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Counter " +
                "name = " + name + '\'' +
                ", data = " + data;
    }
}
