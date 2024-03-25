package com.sinem.util;

import com.sinem.repository.entity.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            for(Object o : jsonObjects) {
                JSONObject jsonObject = (JSONObject) o;
                String name = (String) jsonObject.get("name");
                System.out.println("name: " + name);

                String surname = (String) jsonObject.get("surname");
                System.out.println("surname: " + surname);

                String role = (String) jsonObject.get("role");
                System.out.println("role is: " + role);
            }


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
