package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Core.Company;
import Core.Employee;


public class Storage {
    String name = "";
    private File file;
    
    public Storage(String companyName) throws IOException {
        this.name = companyName + ".csv";
        file = new File(this.name);
        file.createNewFile();
    }

    public void myExport(Company company) throws IOException {
        FileWriter fw = new FileWriter(this.name);
        fw.write(serialize(company.listOfEmployees));
        fw.close();
    }

    public ArrayList<Integer> myImport(String fileName, Company company) throws IOException, ParseException {
        File fileImport = new File(fileName);  
        ArrayList<Integer> ids = new ArrayList<>();
        if (fileImport.exists()) {
            String content = "";
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                content += scan.nextLine();
            }
            scan.close();
            company.listOfEmployees = deserialize(content);
        } else {
            System.out.println(String.format("myImportException: указанного файла %s не существует", fileName));
        }
        for (Employee employee : company.listOfEmployees) {
            ids.add(employee.getId());
        }
        return ids;
    }

    private String serialize(ArrayList<Employee> employees) {
        StringBuilder myCsv = new StringBuilder();
        myCsv.append("id").append("\t").append("name\t").append("surName\t")
                .append("phonenumber\t").append("salary").append(";");

        for (Employee employee : employees) {
            myCsv.append(employee.getId()).append("\t").append(employee.name).append("\t")
                    .append(employee.surName).append("\t").append(employee.phonenumber).append("\t")
                    .append(employee.salary).append(";");
        }
        return myCsv.toString();
    }

    private ArrayList<Employee> deserialize(String content) throws ParseException {
        ArrayList<Employee> employees = new ArrayList<>();
        String[] row = content.split(";");
        for (int i = 1; i < row.length; i++) {
            String[] data = row[i].split("\t");
            Integer id = Integer.parseInt(data[0]);
            String name = data[1];
            String surName = data[2];
            String phonenumber = data[3];
            if (data[4].matches("[0-9]+")) {
                Integer salary = Integer.parseInt(data[4]);
                Employee employee = new Employee(id, name, surName, phonenumber, salary);
                employees.add(employee);
            } else {
                System.out.println("deserializeException: некорректное значение salary");
                return null;
            }
        }
        return employees;
    }
}
