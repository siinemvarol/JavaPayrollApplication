package com.sinem;

import com.sinem.repository.entity.Payroll;
import com.sinem.util.ReadFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PayrollApplication {
    public static void main(String[] args) {
        ReadFile.readJsonFile("employee.json");

        System.out.println("Employees who worked less than 150 hours: ");
        if(ReadFile.lessThan150WorkingHourList.size() > 0) {
            System.out.println(ReadFile.lessThan150WorkingHourList.toString());
        } else {
            System.out.println("All employees have worked more than 150 hours this month!");
        }

        try (FileWriter file = new FileWriter("all_payrolls.json")) {
            file.write(Payroll.payrollList.toString());
            file.flush();

        } catch (IOException e) {
         e.printStackTrace();
        }

    }
}