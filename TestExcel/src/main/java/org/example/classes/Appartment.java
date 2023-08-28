package org.example.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Appartment {
    private String name;
    private double square;
    private ArrayList<Counter> counters;

    public Appartment(String name, double square) {
        this.name = name;
        this.square = square;
        this.counters = new ArrayList<>();
    }

    public Appartment(String name) {
        this.name = name;
    }

    public void addCounter(Counter counter) {
        counters.add(counter);
    }

    public Appartment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public ArrayList<Counter> getCounter() {
        return counters;
    }

    public void setCounter(ArrayList<Counter> counters) {
        this.counters = counters;
    }

    @Override
    public String toString() {
        return "Appartment " +
                "name = " + name + '\'' +
                ", square = " + square +
                ", counter = " + counters;
    }

    public ArrayList<String> getCounterNames() {
        ArrayList<String> counterNames = new ArrayList<>();
        for (Counter counter : counters) {
            counterNames.add(counter.getName());
        }
        return counterNames;
    }

    public static ArrayList<Counter> createCounters() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Counter> counters = new ArrayList<>();
        while (true) {
            System.out.println("Введите название счетчика. " + "Для завершения ввода введите выход: ");
            String name = sc.nextLine();
            Counter counter = new Counter();
            counter.setName(name);
            counters.add(counter);
            System.out.println("Вы добавили счетчик: " + counter.toString());
            if (name.equals("выход")) {
                counters.remove(counters.size() - 1);
                System.out.println(counters.toString());
                break;
            }
        }
        return counters;
    }

    public static Appartment crAppartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название квартиры: ");
        String name1 = sc.nextLine();
        System.out.println("Введите площадь квартиры: ");
        double square = sc.nextDouble();
        return new Appartment(name1, square);
    }

    public static Appartment createAppartment() {
        System.out.println("Введите название квартиры: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Введите площадь квартиры: ");
        double square = sc.nextDouble();
        new Appartment(name,square);
        ArrayList<Counter> counters = new ArrayList<>();
        while (true) {
            System.out.println("Введите название счетчика. " + "Для завершения ввода введите выход: ");
            Counter counter = new Counter(name);
            //appartment.addCounter(counter);
            System.out.println("Вы добавили счетчик: " + counter.toString());
            if (name.equals("выход")) {
                counters.remove(counters.size() - 1);
                System.out.println(counters.toString());
                break;
            }
        }
        System.out.println();
        return Appartment.createAppartment();
    }
}
