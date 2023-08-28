package org.example.classes;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ExcelFile {
    private String fileName;
    private String sheetName;
    private static final Scanner SCANNER = new Scanner(System.in);

    public ExcelFile(String fileName, String sheetName) {
        this.fileName = fileName;
        this.sheetName = sheetName;
    }

    public ExcelFile(String fileName) {
        this.fileName = fileName;
    }

    public ExcelFile() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public static void writeToExcel(Counter counter) {
        Appartment.createAppartment();
        System.out.println("Введите название записи: ");
        String sheetName = SCANNER.nextLine();
        ExcelFile ex = new ExcelFile(Appartment.createAppartment().getName(), sheetName);
        ArrayList<String> counterNames = Appartment.createAppartment().getCounterNames();
        for (String name : counterNames) {
            counterNames.add(name);
        }
        try {
            File file = new File(Appartment.createAppartment().getName() + ".xlsx");
            if (!file.exists()) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet(sheetName);
                XSSFRow headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("df");
            }
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int lastRowIndex = sheet.getLastRowNum();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
