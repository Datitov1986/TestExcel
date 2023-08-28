package org.example;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.classes.Appartment;
import org.example.classes.Counter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        String str = null;

        // Вводим список
        List<Appartment> list = new ArrayList<>();
        System.out.print("\nВведите объекты для списка (\"end\" - конец ввода)\nИмя: ");
        while (!"end".equalsIgnoreCase(str = inp.nextLine())) {
            System.out.print("Площадь: ");
            if (inp.hasNextInt()) {
                // Создаем объект и добавляем его в список:
                list.add(new Appartment(str, inp.nextDouble()));
                inp.nextLine();
                System.out.print("Имя: ");
            } else {
                System.out.println("Это не число. Закончим на этом");
                inp.nextLine();
                break;
            }
        }
        // Выводим список
        System.out.println("\nСодержимое списка:");
        list.forEach((d) -> {
            // Здесь в d получаем объект с именем и данными
            System.out.printf("Имя: %s, площадь: %s\n", d.getName(), d.getSquare());});

        list.get(0).addCounter(new Counter(inp.nextLine(), inp.nextDouble()));
        list.get(1).setCounter(new ArrayList<>());
        System.out.println(list.get(0));
    }




}
