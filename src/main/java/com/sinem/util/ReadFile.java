package com.sinem.util;

import com.sinem.repository.entity.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sinem.repository.entity.Manager;
import com.sinem.repository.entity.Officer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadFile {

    public static List<Employee> readJsonFile(String fileName) {
        List<Employee> employeeList = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray jsonObjects = (JSONArray) obj;
            Scanner scanner = new Scanner(System.in);

            for(Object o : jsonObjects) {
                JSONObject jsonObject = (JSONObject) o;

                String name = (String) jsonObject.get("name");
                String surname = (String) jsonObject.get("surname");
                String role = (String) jsonObject.get("role");

                if(role.equals("Manager")) {
                    Employee currentManager = new Manager();
                    currentManager.setName(name);
                    currentManager.setSurname(surname);
                    employeeList.add(currentManager);

                    System.out.println("Please enter hourly rate of manager: ");
                    short managerHourlyRate = Short.valueOf(scanner.nextLine());
                    System.out.println("Please enter working hour of manager: ");
                    short managerWorkingHour = Short.valueOf(scanner.nextLine());
                }
                if(role.equals("Officer")) {
                    Employee currentOfficer = new Officer();
                    currentOfficer.setName(name);
                    currentOfficer.setSurname(surname);
                    employeeList.add(currentOfficer);

                    System.out.println("Please enter hourly rate of officer: ");
                    short officerHourlyRate = Short.valueOf(scanner.nextLine());
                    System.out.println("Please enter working hour of officer: ");
                    short officerWorkingHour = Short.valueOf(scanner.nextLine());
                }
            }
            System.out.println("employee list is: " + employeeList);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return employeeList;
    }
}
